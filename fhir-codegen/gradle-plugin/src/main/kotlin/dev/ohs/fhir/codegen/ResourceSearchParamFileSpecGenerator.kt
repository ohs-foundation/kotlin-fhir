/*
 * Copyright 2026 Open Health Stack Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ohs.fhir.codegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.SearchParameterDefinition
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.searchparam.SearchParamExtractFromFunctionBodyEmitter
import dev.ohs.fhir.codegen.searchparam.SearchParamPattern
import dev.ohs.fhir.codegen.searchparam.SearchParamTypeResolver
import dev.ohs.fhir.codegen.searchparam.parseSearchParamExpression
import dev.ohs.fhir.codegen.searchparam.splitTopLevelUnion

/**
 * Generates per-resource search parameter container objects.
 *
 * For each resource type (e.g. Patient), produces a `{Resource}SearchParams` plain `object`
 * exposing one `val` per search parameter. Each `val` is a [SearchParam]`<Resource, T>`: metadata
 * plus an `extractor` lambda. The container also exposes an `all` list of every search parameter
 * for that resource. This keeps the generated output to one file (and a handful of `val`s) per
 * resource rather than a class file per search parameter.
 *
 * This object orchestrates KotlinPoet type/file building. The actual work of interpreting the
 * search parameter's FHIRPath expression and generating the extraction expression is split across
 * the `dev.ohs.fhir.codegen.searchparam` package:
 * - [dev.ohs.fhir.codegen.searchparam.parseSearchParamExpression] classifies the expression into a
 *   [SearchParamPattern].
 * - [SearchParamTypeResolver] maps a pattern to the type parameter `T`.
 * - [SearchParamExtractFromFunctionBodyEmitter] emits the Kotlin source string for the extraction.
 */
object ResourceSearchParamFileSpecGenerator {

  /**
   * Generates a `{Resource}SearchParams.kt` file for the given resource type.
   *
   * @param packageName The package name for the generated file.
   * @param resourceName The resource type name (e.g., "Patient").
   * @param searchParams The search parameter definitions for this resource.
   * @param elementsByType A map from StructureDefinition name to its snapshot elements, used to
   *   resolve FHIRPath expressions to Kotlin property access code.
   */
  fun generate(
    packageName: String,
    resourceName: String,
    searchParams: List<SearchParameterDefinition>,
    elementsByType: Map<String, List<Element>>,
  ): FileSpec {
    val searchPackageName = "$packageName.search"
    val searchParamClassName = ClassName(searchPackageName, "SearchParam")
    val searchParamTypeClassName = ClassName("$packageName.terminologies", "SearchParamType")
    val resourceClassName = ClassName(packageName, resourceName)
    val containerObjectName = "${resourceName}SearchParams"

    val resolver = FhirPathExpressionResolver(elementsByType)
    val dedupedParams = searchParams.distinctBy { it.code }.sortedBy { it.code }

    // Unsupported params still get their own `val` (calling `extractFrom` on them throws), and
    // are listed explicitly in [unsupported] so the unsupported set is visible at a glance.
    // [all] enumerates only the supported ones, so iterate-all use cases (building a search
    // index, etc.) can rely on every entry being callable.
    val (unsupportedParams, supportedParams) =
      dedupedParams.partition { sp ->
        val expr = sp.extractExpressionForResource(resourceName)
        parseSearchParamExpression(expr, resourceName, resolver) == SearchParamPattern.Unsupported
      }

    val containerObject =
      TypeSpec.objectBuilder(containerObjectName)
        .addModifiers(KModifier.PUBLIC)
        .addKdoc("Search parameters for the [%T] resource type.", resourceClassName)
        .apply {
          for (searchParam in dedupedParams) {
            addProperty(
              buildSearchParamProperty(
                searchParam,
                packageName,
                resourceName,
                resourceClassName,
                searchParamClassName,
                searchParamTypeClassName,
                resolver,
              )
            )
          }

          val listType =
            List::class.asClassName()
              .parameterizedBy(searchParamClassName.parameterizedBy(resourceClassName, STAR))

          // `unsupported` declared first so `all`'s initializer can reference it. Both use %N so
          // KotlinPoet backtick-escapes names that are Kotlin keywords (e.g. `class`, `for`).
          val unsupportedInit =
            CodeBlock.builder()
              .apply {
                add("listOf(")
                unsupportedParams.forEachIndexed { i, sp ->
                  if (i > 0) add(", ")
                  add("%N", sp.code.toPropertyName())
                }
                add(")")
              }
              .build()
          addProperty(
            PropertySpec.builder("unsupported", listType)
              .addModifiers(KModifier.PUBLIC)
              .addKdoc(
                "Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on " +
                  "any of these throws `NotImplementedError`. Listed here so the unsupported " +
                  "set is visible at a glance, and excluded from [all]."
              )
              .initializer(unsupportedInit)
              .build()
          )

          val allInit =
            CodeBlock.builder()
              .apply {
                add("listOf(")
                supportedParams.forEachIndexed { i, sp ->
                  if (i > 0) add(", ")
                  add("%N", sp.code.toPropertyName())
                }
                add(")")
              }
              .build()
          addProperty(
            PropertySpec.builder("all", listType)
              .addModifiers(KModifier.PUBLIC)
              .addKdoc(
                "Supported search parameters for the %L resource type. Iterating `all` and " +
                  "calling `extractFrom` on each entry is safe; see [unsupported] for the " +
                  "parameters excluded from this list.",
                resourceName,
              )
              .initializer(allInit)
              .build()
          )
        }
        .build()

    return FileSpec.builder(searchPackageName, containerObjectName)
      .addSuppressAnnotation()
      .addType(containerObject)
      .build()
  }

  private fun buildSearchParamProperty(
    searchParam: SearchParameterDefinition,
    packageName: String,
    resourceName: String,
    resourceClassName: ClassName,
    searchParamClassName: ClassName,
    searchParamTypeClassName: ClassName,
    resolver: FhirPathExpressionResolver,
  ): PropertySpec {
    val propertyName = searchParam.code.toPropertyName()

    val resourceExpression = searchParam.extractExpressionForResource(resourceName)
    val pattern = parseSearchParamExpression(resourceExpression, resourceName, resolver)
    val valueTypeName = SearchParamTypeResolver.resolve(pattern, packageName, resourceName)
    val extractionCode =
      SearchParamExtractFromFunctionBodyEmitter.emit(
        pattern,
        packageName,
        searchParam.code,
        resourceExpression,
      )
    val usesResource = pattern !is SearchParamPattern.Unsupported

    val parameterizedSearchParam =
      searchParamClassName.parameterizedBy(resourceClassName, valueTypeName)

    val initializer =
      CodeBlock.builder()
        .add("%T(\n", searchParamClassName)
        .indent()
        .add("name = %S,\n", searchParam.code)
        .add("type = %T.%L,\n", searchParamTypeClassName, searchParam.type.capitalized())
        .add("expression = %S,\n", resourceExpression)
        .apply {
          if (searchParam.target.isNotEmpty()) {
            add("target = listOf(")
            searchParam.target.forEachIndexed { index, target ->
              if (index > 0) add(", ")
              add("%T::class", ClassName(packageName, target))
            }
            add("),\n")
          }
        }
        .apply {
          if (usesResource) add("extractor = { resource -> %L },\n", extractionCode)
          else add("extractor = { %L },\n", extractionCode)
        }
        .unindent()
        .add(")")
        .build()

    return PropertySpec.builder(propertyName, parameterizedSearchParam)
      .addModifiers(KModifier.PUBLIC)
      .initializer(initializer)
      .build()
  }
}

/**
 * Extracts the parts of a FHIRPath expression that belong to [resourceName].
 *
 * Many spec expressions cover several resources: for `AllergyIntolerance.code | Condition.code |
 * Patient.name` and resource "Patient", this returns `Patient.name`. When several branches belong
 * to the same resource, all of them are kept: for `Observation.value.ofType(dateTime) |
 * Observation.value.ofType(Period)` and resource "Observation", both branches are returned, so
 * extraction covers the whole union rather than only the first branch.
 *
 * If no branch starts with the resource name, returns the expression unchanged.
 */
private fun SearchParameterDefinition.extractExpressionForResource(resourceName: String): String {
  val expr = expression ?: return ""
  val resourceParts =
    splitTopLevelUnion(expr).filter {
      it.startsWith("$resourceName.") || it.startsWith("($resourceName.")
    }
  return if (resourceParts.isEmpty()) expr else resourceParts.joinToString(" | ")
}

/**
 * Converts a search parameter code (e.g., "general-practitioner") to a lowerCamelCase property name
 * (e.g., "generalPractitioner"), matching the Kotlin style guide for properties.
 */
private fun String.toPropertyName(): String {
  val parts = split("-")
  return parts.first() + parts.drop(1).joinToString("") { it.capitalized() }
}

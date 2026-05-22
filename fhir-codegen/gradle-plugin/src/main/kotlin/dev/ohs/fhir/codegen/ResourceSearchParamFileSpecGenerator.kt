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
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.SearchParameterDefinition
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.searchparam.SearchParamCodeEmitter
import dev.ohs.fhir.codegen.searchparam.SearchParamPattern
import dev.ohs.fhir.codegen.searchparam.SearchParamTypeResolver
import dev.ohs.fhir.codegen.searchparam.parseSearchParamExpression

/**
 * Generates per-resource search parameter container objects.
 *
 * For each resource type (e.g. Patient), produces a `{Resource}SearchParam` plain `object` exposing
 * one `val` per search parameter. Each `val` is a [SearchParam]`<Resource, T>` backed by a
 * `SimpleSearchParam` instance: metadata plus an `extractor` lambda. The container also exposes an
 * `ALL` list of every search parameter for that resource. This keeps the generated output to one
 * file (and a handful of `val`s) per resource rather than a class file per search parameter.
 *
 * This object orchestrates KotlinPoet type/file building. The actual work of interpreting the
 * search parameter's FHIRPath expression and generating the extraction expression is split across
 * the `dev.ohs.fhir.codegen.searchparam` package:
 * - [dev.ohs.fhir.codegen.searchparam.parseSearchParamExpression] classifies the expression into a
 *   [SearchParamPattern].
 * - [SearchParamTypeResolver] maps a pattern to the type parameter `T`.
 * - [SearchParamCodeEmitter] emits the Kotlin source string for the extraction.
 */
object ResourceSearchParamFileSpecGenerator {

  /**
   * Generates a `{Resource}SearchParam.kt` file for the given resource type.
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
    val searchParamInterfaceClassName = ClassName(searchPackageName, "SearchParam")
    val simpleSearchParamClassName = ClassName(searchPackageName, "SimpleSearchParam")
    val searchParamTypeClassName = ClassName("$packageName.terminologies", "SearchParamType")
    val resourceClassName = ClassName(packageName, resourceName)
    val containerObjectName = "${resourceName}SearchParam"

    val resolver = FhirPathExpressionResolver(elementsByType)
    val dedupedParams = searchParams.distinctBy { it.code }.sortedBy { it.code }

    // The generated `val`s share the object's scope, so a target whose simple name matches a `val`
    // name (e.g. a `patient` search param produces a `Patient` val) would shadow the model class in
    // `X::class` expression position. Such targets are fully-qualified instead.
    val valNames = dedupedParams.mapTo(mutableSetOf()) { it.code.toPropertyName() }

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
                searchParamInterfaceClassName,
                simpleSearchParamClassName,
                searchParamTypeClassName,
                valNames,
                resolver,
              )
            )
          }

          val allListType =
            List::class.asClassName()
              .parameterizedBy(
                searchParamInterfaceClassName.parameterizedBy(resourceClassName, STAR)
              )
          addProperty(
            PropertySpec.builder("ALL", allListType)
              .addModifiers(KModifier.PUBLIC)
              .addKdoc("All search parameters for the %L resource type.", resourceName)
              .initializer(
                "listOf(${dedupedParams.joinToString(", ") { it.code.toPropertyName() }})"
              )
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
    searchParamInterfaceClassName: ClassName,
    simpleSearchParamClassName: ClassName,
    searchParamTypeClassName: ClassName,
    valNames: Set<String>,
    resolver: FhirPathExpressionResolver,
  ): PropertySpec {
    val propertyName = searchParam.code.toPropertyName()

    val resourceExpression = searchParam.extractExpressionForResource(resourceName)
    val pattern = parseSearchParamExpression(resourceExpression, resourceName, resolver)
    val (valueTypeName, extractionCode) = render(pattern, packageName, resourceName)

    val declaredType =
      searchParamInterfaceClassName.parameterizedBy(resourceClassName, valueTypeName)
    val concreteType = simpleSearchParamClassName.parameterizedBy(resourceClassName, valueTypeName)

    // The emitter produces a `return <expr>` statement (its historical extract()-body form); the
    // extractor lambda needs the bare expression. Unsupported params emit `emptyList()`, which does
    // not reference `resource`, so use a parameterless lambda to avoid an unused-parameter warning.
    val extractionExpr = extractionCode.removePrefix("return ")
    val extractorLambda =
      if ("resource" in extractionExpr) "{ resource -> $extractionExpr }" else "{ $extractionExpr }"

    val initializer =
      CodeBlock.builder()
        .add("%T(\n", concreteType)
        .indent()
        .add("name = %S,\n", searchParam.code)
        .add("type = %T.fromCode(%S),\n", searchParamTypeClassName, searchParam.type)
        .add("expression = %S,\n", resourceExpression)
        .apply {
          if (searchParam.target.isNotEmpty()) {
            add("target = listOf(")
            searchParam.target.forEachIndexed { index, target ->
              if (index > 0) add(", ")
              if (target in valNames) {
                // Fully-qualify to force the class literal rather than the shadowing `val`.
                add("%L", "$packageName.$target::class")
              } else {
                add("%T::class", ClassName(packageName, target))
              }
            }
            add("),\n")
          }
        }
        .add("extractor = %L,\n", extractorLambda)
        .unindent()
        .add(")")
        .build()

    return PropertySpec.builder(propertyName, declaredType)
      .addModifiers(KModifier.PUBLIC)
      .initializer(initializer)
      .build()
  }

  private data class ExtractionResult(val typeParam: TypeName, val code: String)

  private fun render(
    pattern: SearchParamPattern,
    packageName: String,
    resourceName: String,
  ): ExtractionResult =
    when (pattern) {
      is SearchParamPattern.SimplePath ->
        ExtractionResult(
          SearchParamTypeResolver.forResolvedPath(pattern.resolved, packageName, resourceName),
          SearchParamCodeEmitter.forSegments(pattern.resolved),
        )
      is SearchParamPattern.WhereResolve ->
        ExtractionResult(
          SearchParamTypeResolver.forResolvedPath(pattern.resolved, packageName, resourceName),
          SearchParamCodeEmitter.forWhereResolve(pattern.resolved, pattern.targetType),
        )
      is SearchParamPattern.ElementNoCast ->
        ExtractionResult(
          SearchParamTypeResolver.forElementNoCast(pattern.resolved, packageName),
          SearchParamCodeEmitter.forSegments(pattern.resolved),
        )
      is SearchParamPattern.ElementCast -> {
        val sealedSubclass =
          SearchParamTypeResolver.elementSubclass(pattern.resolved, pattern.targetType, packageName)
        ExtractionResult(
          SearchParamTypeResolver.forElementCastTarget(pattern.targetType, packageName),
          SearchParamCodeEmitter.forElementCast(
            pattern.resolved,
            sealedSubclass.simpleNames.joinToString("."),
          ),
        )
      }
      is SearchParamPattern.WhereFilter -> {
        val elementType = pattern.resolved.segments.last().leafTypeCode!!
        val typeParam =
          if (pattern.postPath != null)
            SearchParamTypeResolver.forResolvedPath(pattern.postPath, packageName, resourceName)
          else ClassName(packageName, elementType.capitalized())
        ExtractionResult(
          typeParam,
          SearchParamCodeEmitter.forWhereFilter(
            pattern.resolved,
            pattern.field,
            pattern.value,
            pattern.postPath,
          ),
        )
      }
      SearchParamPattern.Unsupported ->
        ExtractionResult(ClassName("kotlin", "Any"), "return emptyList()")
    }
}

/**
 * Extracts the FHIRPath expression portion relevant to a specific resource from a potentially
 * multi-resource expression.
 *
 * For example, given the expression: `AllergyIntolerance.code | Condition.code | Patient.name` and
 * resource name "Patient", returns "Patient.name".
 *
 * If the expression is already single-resource, returns it as-is.
 */
private fun SearchParameterDefinition.extractExpressionForResource(resourceName: String): String {
  val expr = expression ?: return ""
  val parts = expr.split("|").map { it.trim() }
  // Find the part that starts with the resource name
  val resourcePart =
    parts.firstOrNull { it.startsWith("$resourceName.") || it.startsWith("($resourceName.") }
  return resourcePart ?: expr
}

/**
 * Converts a search parameter code (e.g., "general-practitioner") to a property name (e.g.,
 * "GeneralPractitioner").
 */
private fun String.toPropertyName(): String = split("-").joinToString("") { it.capitalized() }

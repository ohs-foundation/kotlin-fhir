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
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.WildcardTypeName
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.SearchParameterDefinition
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.searchparam.SearchParamCodeEmitter
import dev.ohs.fhir.codegen.searchparam.SearchParamPattern
import dev.ohs.fhir.codegen.searchparam.SearchParamTypeResolver
import dev.ohs.fhir.codegen.searchparam.parseSearchParamExpression
import kotlin.reflect.KClass

/**
 * Generates per-resource search parameter container objects.
 *
 * For each resource type (e.g. Patient), produces a `{Resource}SearchParam` plain `object`
 * containing one `data object` per search parameter. Each data object directly implements
 * [SearchParam]`<Resource, T>` with the concrete resource type and a value type `T` derived from
 * the search parameter's FHIRPath expression. The container also exposes an `ALL` list of every
 * search parameter for that resource.
 *
 * This object orchestrates KotlinPoet type/file building. The actual work of interpreting the
 * search parameter's FHIRPath expression and generating the `extract` body is split across the
 * `dev.ohs.fhir.codegen.searchparam` package:
 * - [dev.ohs.fhir.codegen.searchparam.parseSearchParamExpression] classifies the expression into a
 *   [SearchParamPattern].
 * - [SearchParamTypeResolver] maps a pattern to the type parameter `T`.
 * - [SearchParamCodeEmitter] emits the Kotlin source string for the `extract` body.
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
    val searchParamTypeClassName = ClassName("$packageName.terminologies", "SearchParamType")
    val resourceClassName = ClassName(packageName, resourceName)
    val containerObjectName = "${resourceName}SearchParam"

    val resolver = FhirPathExpressionResolver(elementsByType)
    val dedupedParams = searchParams.distinctBy { it.code }.sortedBy { it.code }

    val containerObject =
      TypeSpec.objectBuilder(containerObjectName)
        .addModifiers(KModifier.PUBLIC)
        .addKdoc("Search parameters for the [%T] resource type.", resourceClassName)
        .apply {
          for (searchParam in dedupedParams) {
            addType(
              buildSearchParamDataObject(
                searchParam,
                packageName,
                resourceName,
                resourceClassName,
                searchParamInterfaceClassName,
                searchParamTypeClassName,
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
                "listOf(${dedupedParams.joinToString(", ") { it.code.toDataObjectName() }})"
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

  private fun buildSearchParamDataObject(
    searchParam: SearchParameterDefinition,
    packageName: String,
    resourceName: String,
    resourceClassName: ClassName,
    searchParamInterfaceClassName: ClassName,
    searchParamTypeClassName: ClassName,
    resolver: FhirPathExpressionResolver,
  ): TypeSpec {
    val objectName = searchParam.code.toDataObjectName()

    val resourceExpression = searchParam.extractExpressionForResource(resourceName)
    val pattern = parseSearchParamExpression(resourceExpression, resourceName, resolver)
    val (valueTypeName, extractionCode) = render(pattern, packageName, resourceName)

    val parentType = searchParamInterfaceClassName.parameterizedBy(resourceClassName, valueTypeName)
    val returnType = List::class.asClassName().parameterizedBy(valueTypeName)

    return TypeSpec.objectBuilder(objectName)
      .addModifiers(KModifier.PUBLIC, KModifier.DATA)
      .addSuperinterface(parentType)
      .addProperty(
        PropertySpec.builder("name", String::class)
          .addModifiers(KModifier.OVERRIDE, KModifier.PUBLIC)
          .initializer("%S", searchParam.code)
          .build()
      )
      .addProperty(
        PropertySpec.builder("type", searchParamTypeClassName)
          .addModifiers(KModifier.OVERRIDE, KModifier.PUBLIC)
          .initializer("%T.fromCode(%S)", searchParamTypeClassName, searchParam.type)
          .build()
      )
      .addProperty(
        PropertySpec.builder("expression", String::class)
          .addModifiers(KModifier.OVERRIDE, KModifier.PUBLIC)
          .initializer("%S", resourceExpression)
          .build()
      )
      .addProperty(
        PropertySpec.builder(
            "target",
            List::class.asClassName()
              .parameterizedBy(
                KClass::class.asClassName()
                  .parameterizedBy(WildcardTypeName.producerOf(ClassName(packageName, "Resource")))
              ),
          )
          .addModifiers(KModifier.OVERRIDE, KModifier.PUBLIC)
          .apply {
            if (searchParam.target.isEmpty()) {
              initializer("emptyList()")
            } else {
              val targetClassNames = searchParam.target.map { ClassName(packageName, it) }
              val format = "listOf(${targetClassNames.joinToString(", ") { "%T::class" }})"
              initializer(format, *targetClassNames.toTypedArray())
            }
          }
          .build()
      )
      .addFunction(
        FunSpec.builder("extract")
          .addModifiers(KModifier.OVERRIDE, KModifier.PUBLIC)
          .addParameter("resource", resourceClassName)
          .returns(returnType)
          .addCode(extractionCode)
          .build()
      )
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
 * Converts a search parameter code (e.g., "general-practitioner") to a data object name (e.g.,
 * "GeneralPractitioner").
 */
private fun String.toDataObjectName(): String = split("-").joinToString("") { it.capitalized() }

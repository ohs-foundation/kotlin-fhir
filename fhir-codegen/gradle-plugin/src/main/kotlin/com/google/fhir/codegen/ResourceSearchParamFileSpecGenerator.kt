/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.codegen

import com.google.fhir.codegen.schema.SearchParameterDefinition
import com.google.fhir.codegen.schema.capitalized
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName

/**
 * Generates per-resource search parameter sealed classes.
 *
 * For each resource type (e.g., Patient), generates a `{Resource}SearchParam` sealed class where
 * each search parameter is a `data object` carrying both metadata and an `extract` function.
 */
object ResourceSearchParamFileSpecGenerator {

  /**
   * Generates a `{Resource}SearchParam.kt` file for the given resource type.
   *
   * @param packageName The package name for the generated file.
   * @param resourceName The resource type name (e.g., "Patient").
   * @param searchParams The search parameter definitions for this resource.
   */
  fun generate(
    packageName: String,
    resourceName: String,
    searchParams: List<SearchParameterDefinition>,
  ): FileSpec {
    val searchParamInterfaceClassName = ClassName(packageName, "SearchParam")
    val searchParamTypeClassName = ClassName("$packageName.terminologies", "SearchParamType")
    val resourceClassName = ClassName(packageName, resourceName)
    val sealedClassName = "${resourceName}SearchParam"
    val typeVariable = TypeVariableName("T")
    val listOfT = List::class.asClassName().parameterizedBy(typeVariable)

    val dedupedParams = searchParams.distinctBy { it.code }.sortedBy { it.code }

    val sealedClass =
      TypeSpec.classBuilder(sealedClassName)
        .addModifiers(KModifier.PUBLIC, KModifier.SEALED)
        .addTypeVariable(typeVariable)
        .addSuperinterface(searchParamInterfaceClassName)
        .addKdoc("Search parameters for the [%T] resource type.", resourceClassName)
        .addFunction(
          FunSpec.builder("extract")
            .addModifiers(KModifier.PUBLIC, KModifier.ABSTRACT)
            .addParameter("resource", resourceClassName)
            .returns(listOfT)
            .addKdoc("Extracts the values for this search parameter from the given [resource].")
            .build()
        )
        .apply {
          for (searchParam in dedupedParams) {
            addType(
              buildSearchParamDataObject(
                searchParam,
                packageName,
                resourceName,
                resourceClassName,
                searchParamTypeClassName,
              )
            )
          }

          // Add companion with ALL list
          val allListType =
            List::class.asClassName()
              .parameterizedBy(ClassName(packageName, sealedClassName).parameterizedBy(STAR))
          addType(
            TypeSpec.companionObjectBuilder()
              .addProperty(
                PropertySpec.builder("ALL", allListType)
                  .addModifiers(KModifier.PUBLIC)
                  .addKdoc("All search parameters for the %L resource type.", resourceName)
                  .initializer(
                    "listOf(${dedupedParams.joinToString(", ") { it.code.toDataObjectName() }})"
                  )
                  .build()
              )
              .build()
          )
        }
        .build()

    return FileSpec.builder(packageName, sealedClassName)
      .addSuppressAnnotation()
      .addType(sealedClass)
      .build()
  }

  private fun buildSearchParamDataObject(
    searchParam: SearchParameterDefinition,
    packageName: String,
    resourceName: String,
    resourceClassName: ClassName,
    searchParamTypeClassName: ClassName,
  ): TypeSpec {
    val objectName = searchParam.code.toDataObjectName()
    val sealedClassName = ClassName(packageName, "${resourceName}SearchParam")

    // Extract the expression portion relevant to this resource
    val resourceExpression = searchParam.extractExpressionForResource(resourceName)

    // Use Any as the type parameter for now — specific types will be added
    // when we implement extraction logic
    val parentType = sealedClassName.parameterizedBy(ClassName("kotlin", "Any"))

    return TypeSpec.objectBuilder(objectName)
      .addModifiers(KModifier.PUBLIC, KModifier.DATA)
      .superclass(parentType)
      .addProperty(
        PropertySpec.builder("paramName", String::class)
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
            List::class.asClassName().parameterizedBy(String::class.asClassName()),
          )
          .addModifiers(KModifier.OVERRIDE, KModifier.PUBLIC)
          .initializer(
            if (searchParam.target.isEmpty()) {
              "emptyList()"
            } else {
              "listOf(${searchParam.target.joinToString(", ") { "\"$it\"" }})"
            }
          )
          .build()
      )
      .addFunction(
        FunSpec.builder("extract")
          .addModifiers(KModifier.OVERRIDE, KModifier.PUBLIC)
          .addParameter("resource", resourceClassName)
          .returns(List::class.asClassName().parameterizedBy(ClassName("kotlin", "Any")))
          .addCode("return emptyList()")
          .build()
      )
      .build()
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

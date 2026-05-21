/*
 * Copyright 2025-2026 Open Health Stack Foundation
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
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.WildcardTypeName
import com.squareup.kotlinpoet.asClassName
import kotlin.reflect.KClass

/**
 * Generates a `SearchParam.kt` file with the sealed interface for search parameter metadata and
 * extraction.
 *
 * The `SearchParam<R, T>` interface carries the metadata about a FHIR search parameter (name, type,
 * expression, target) and the typed `extract` function that pulls values of type `T` out of a
 * resource of type `R`. Per-resource container objects (e.g., `PatientSearchParam`) hold the `data
 * object` implementations, one per search parameter for that resource.
 */
object SearchParamFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val resourceClassName = ClassName(packageName, "Resource")
    val searchParamTypeClassName = ClassName("$packageName.terminologies", "SearchParamType")

    val typeR = TypeVariableName("R", resourceClassName, variance = KModifier.IN)
    val typeT = TypeVariableName("T", variance = KModifier.OUT)
    val listOfT = List::class.asClassName().parameterizedBy(typeT)
    val listOfTargetClasses =
      List::class.asClassName()
        .parameterizedBy(
          KClass::class.asClassName()
            .parameterizedBy(WildcardTypeName.producerOf(resourceClassName))
        )

    return FileSpec.builder("$packageName.search", "SearchParam")
      .addType(
        TypeSpec.interfaceBuilder("SearchParam")
          .addModifiers(KModifier.PUBLIC, KModifier.SEALED)
          .addTypeVariable(typeR)
          .addTypeVariable(typeT)
          .addKdoc("Base type for typed FHIR search parameters.")
          .addProperty(
            PropertySpec.builder("name", String::class)
              .addModifiers(KModifier.PUBLIC)
              .addKdoc("The name of the search parameter as used in search URLs.")
              .build()
          )
          .addProperty(
            PropertySpec.builder("type", searchParamTypeClassName)
              .addModifiers(KModifier.PUBLIC)
              .addKdoc("The search parameter type (e.g., date, token, reference).")
              .build()
          )
          .addProperty(
            PropertySpec.builder("expression", String::class)
              .addModifiers(KModifier.PUBLIC)
              .addKdoc("The FHIRPath expression that extracts values for this search parameter.")
              .build()
          )
          .addProperty(
            PropertySpec.builder("target", listOfTargetClasses)
              .addModifiers(KModifier.PUBLIC)
              .addKdoc("The target resource types for reference search parameters.")
              .build()
          )
          .addFunction(
            FunSpec.builder("extract")
              .addModifiers(KModifier.PUBLIC, KModifier.ABSTRACT)
              .addParameter("resource", typeR)
              .returns(listOfT)
              .addKdoc("Extracts the values for this search parameter from the given [resource].")
              .build()
          )
          .build()
      )
      .build()
  }
}

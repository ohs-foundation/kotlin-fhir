/*
 * Copyright 2025-2026 Google LLC
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

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName

/**
 * Generates a `SearchParam.kt` file with the sealed interface for search parameter metadata.
 *
 * The `SearchParam` interface provides metadata about FHIR search parameters (name, type,
 * expression, target). Per-resource sealed classes (e.g., `PatientSearchParam`) extend this
 * interface and add typed extraction functions.
 */
object SearchParamFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val searchParamTypeClassName = ClassName("$packageName.terminologies", "SearchParamType")

    return FileSpec.builder(packageName, "SearchParam")
      .addType(
        TypeSpec.interfaceBuilder("SearchParam")
          .addModifiers(KModifier.PUBLIC, KModifier.SEALED)
          .addKdoc("Base type for typed FHIR search parameters.")
          .addProperty(
            PropertySpec.builder("paramName", String::class)
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
            PropertySpec.builder(
                "target",
                List::class.asClassName().parameterizedBy(String::class.asClassName()),
              )
              .addModifiers(KModifier.PUBLIC)
              .addKdoc("The target resource types for reference search parameters.")
              .build()
          )
          .build()
      )
      .build()
  }
}

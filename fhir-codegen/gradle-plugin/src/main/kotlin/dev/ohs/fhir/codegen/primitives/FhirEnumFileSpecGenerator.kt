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

package dev.ohs.fhir.codegen.primitives

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.schema.sanitizeKDoc

/**
 * Generates a [FileSpec] for `FhirEnum.kt` containing the `FhirEnum` interface.
 *
 * All generated FHIR enum classes implement this interface to provide uniform access to terminology
 * metadata (`code`, `system`, `display`).
 */
object FhirEnumFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val fhirEnumClassName = ClassName(packageName, "FhirEnum")
    return FileSpec.builder(fhirEnumClassName)
      .addType(
        TypeSpec.interfaceBuilder(fhirEnumClassName)
          .addModifiers(KModifier.PUBLIC)
          .addProperty(
            PropertySpec.builder("code", String::class)
              .addKdoc("The machine code string defined by the code system.")
              .build()
          )
          .addProperty(
            PropertySpec.builder("system", String::class)
              .addKdoc("The URI of the code system that defines the code.")
              .build()
          )
          .addProperty(
            PropertySpec.builder("display", String::class.asClassName().copy(nullable = true))
              .addKdoc("The human-readable display title of the code, if defined.")
              .build()
          )
          .addKdoc(
            """
            A common interface for all FHIR enumerated terminology concepts.
            """
              .trimIndent()
              .sanitizeKDoc()
          )
          .build()
      )
      .build()
  }
}

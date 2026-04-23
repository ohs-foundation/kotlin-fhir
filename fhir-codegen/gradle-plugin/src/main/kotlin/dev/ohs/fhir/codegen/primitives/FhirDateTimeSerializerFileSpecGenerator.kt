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

package dev.ohs.fhir.codegen.primitives

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

/**
 * Generates `FhirDateTimeSerializer` — a [kotlinx.serialization.KSerializer] for the sealed
 * `FhirDateTime` interface used by FHIR's `dateTime` and `instant` primitives.
 *
 * Round-trips as the canonical FHIR dateTime string via the sealed interface's existing
 * `toString()` / `fromString(...)` contract. Wired from `DateTime.value` via `@Serializable(with =
 * FhirDateTimeSerializer::class)`.
 */
object FhirDateTimeSerializerFileSpecGenerator {
  fun generate(serializersPackageName: String): FileSpec {
    val modelPackageName = serializersPackageName.removeSuffix(".serializers")
    val fhirDateTimeClassName = ClassName(modelPackageName, "FhirDateTime")
    return FileSpec.builder(serializersPackageName, "FhirDateTimeSerializer")
      .addType(
        TypeSpec.objectBuilder("FhirDateTimeSerializer")
          .addModifiers(KModifier.INTERNAL)
          .addKdoc("A Serializer for `FhirDateTime` using the FHIR dateTime string form.")
          .addSuperinterface(
            ClassName("kotlinx.serialization", "KSerializer").parameterizedBy(fhirDateTimeClassName)
          )
          .addProperty(
            PropertySpec.builder(
                "descriptor",
                ClassName("kotlinx.serialization.descriptors", "SerialDescriptor"),
              )
              .addModifiers(KModifier.OVERRIDE)
              .initializer(
                CodeBlock.of(
                  "%T(%S, %T.%L)",
                  ClassName("kotlinx.serialization.descriptors", "PrimitiveSerialDescriptor"),
                  "FhirDateTime",
                  ClassName("kotlinx.serialization.descriptors", "PrimitiveKind"),
                  "STRING",
                )
              )
              .build()
          )
          .addFunction(
            FunSpec.builder("serialize")
              .addModifiers(KModifier.OVERRIDE)
              .addParameter("encoder", ClassName("kotlinx.serialization.encoding", "Encoder"))
              .addParameter("value", fhirDateTimeClassName)
              .addStatement("encoder.encodeString(value.toString())")
              .build()
          )
          .addFunction(
            FunSpec.builder("deserialize")
              .addModifiers(KModifier.OVERRIDE)
              .addParameter("decoder", ClassName("kotlinx.serialization.encoding", "Decoder"))
              .returns(fhirDateTimeClassName)
              .addStatement("return %T.fromString(decoder.decodeString())!!", fhirDateTimeClassName)
              .build()
          )
          .build()
      )
      .build()
  }
}

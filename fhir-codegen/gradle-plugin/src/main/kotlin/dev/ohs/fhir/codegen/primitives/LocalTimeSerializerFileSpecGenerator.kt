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
import com.squareup.kotlinpoet.asClassName
import kotlinx.datetime.LocalTime

/**
 * Generates a [FileSpec] for `LocalTimeSerializer` that always include seconds, even if they are
 * zero. Fractional parts of the second are included if non-zero.
 */
object LocalTimeSerializerFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    return FileSpec.builder(packageName, "LocalTimeSerializer")
      .addType(
        TypeSpec.objectBuilder("LocalTimeSerializer")
          .addModifiers(KModifier.INTERNAL)
          .addKdoc(
            "A Serializer for `LocalTime` that always include seconds, even if they are zero.\n"
          )
          .addKdoc("Fractional parts of the second are included if non-zero.")
          .addSuperinterface(
            ClassName("kotlinx.serialization", "KSerializer")
              .parameterizedBy(LocalTime::class.asClassName())
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
                  "FormattedLocalTime",
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
              .addParameter("value", LocalTime::class.asClassName())
              .addStatement(
                "encoder.encodeString(%T.Formats.ISO.format(value))",
                ClassName("kotlinx.datetime", "LocalTime"),
              )
              .build()
          )
          .addFunction(
            FunSpec.builder("deserialize")
              .addModifiers(KModifier.OVERRIDE)
              .addParameter("decoder", ClassName("kotlinx.serialization.encoding", "Decoder"))
              .addStatement(
                "return %T.parse(decoder.decodeString())",
                ClassName("kotlinx.datetime", "LocalTime"),
              )
              .returns(LocalTime::class.asClassName())
              .build()
          )
          .build()
      )
      .build()
  }
}

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
import kotlinx.serialization.ExperimentalSerializationApi

/**
 * Generalizes a [FileSpec] for `DoubleSerializer` that always serializes Double with at least one
 * digit after the decimal point.
 */
object DoubleSerializerFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    return FileSpec.builder(packageName, "DoubleSerializer")
      .addType(
        TypeSpec.objectBuilder("DoubleSerializer")
          .addSuperinterface(
            ClassName("kotlinx.serialization", "KSerializer")
              .parameterizedBy(Double::class.asClassName())
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
                  "FormattedDouble",
                  ClassName("kotlinx.serialization.descriptors", "PrimitiveKind"),
                  "DOUBLE",
                )
              )
              .build()
          )
          .addFunction(
            FunSpec.builder("serialize")
              .addAnnotation(ExperimentalSerializationApi::class)
              .addModifiers(KModifier.OVERRIDE)
              .addParameter("encoder", ClassName("kotlinx.serialization.encoding", "Encoder"))
              .addParameter("value", Double::class.asClassName())
              .addStatement(
                "encoder.encodeSerializableValue(%T.serializer(), %T(value.toString().let { " +
                  "if (it.contains('" +
                  ".')) { it } else { \"\$it.0\" } }))",
                ClassName("kotlinx.serialization.json", "JsonPrimitive"),
                ClassName("kotlinx.serialization.json", "JsonUnquotedLiteral"),
              )
              .build()
          )
          .addFunction(
            FunSpec.builder("deserialize")
              .addModifiers(KModifier.OVERRIDE)
              .addParameter("decoder", ClassName("kotlinx.serialization.encoding", "Decoder"))
              .returns(Double::class.asClassName())
              .addStatement("return decoder.decodeDouble()")
              .build()
          )
          .build()
      )
      .build()
  }
}

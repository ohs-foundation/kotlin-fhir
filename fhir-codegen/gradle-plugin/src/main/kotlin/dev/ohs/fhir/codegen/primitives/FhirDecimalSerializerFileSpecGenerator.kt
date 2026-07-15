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

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

/** Generates `FhirDecimalSerializer` that serializes `FhirDecimal` to unquoted JSON literals. */
object FhirDecimalSerializerFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val modelPackageName = packageName.removeSuffix(".serializers")
    val fhirDecimal = ClassName(modelPackageName, "FhirDecimal")
    val kSerializer = ClassName("kotlinx.serialization", "KSerializer")
    val serialDescriptor = ClassName("kotlinx.serialization.descriptors", "SerialDescriptor")
    val primitiveDescriptor =
      ClassName("kotlinx.serialization.descriptors", "PrimitiveSerialDescriptor")
    val primitiveKind = ClassName("kotlinx.serialization.descriptors", "PrimitiveKind")
    val encoder = ClassName("kotlinx.serialization.encoding", "Encoder")
    val decoder = ClassName("kotlinx.serialization.encoding", "Decoder")
    val jsonEncoder = ClassName("kotlinx.serialization.json", "JsonEncoder")
    val jsonDecoder = ClassName("kotlinx.serialization.json", "JsonDecoder")
    val jsonPrimitive = ClassName("kotlinx.serialization.json", "JsonPrimitive")
    val jsonUnquotedLiteral = MemberName("kotlinx.serialization.json", "JsonUnquotedLiteral")
    val jsonPrimitiveAccessor = MemberName("kotlinx.serialization.json", "jsonPrimitive")
    val experimentalOptIn = ClassName("kotlinx.serialization", "ExperimentalSerializationApi")

    val serializeFn =
      FunSpec.builder("serialize")
        .addModifiers(KModifier.OVERRIDE)
        .addAnnotation(
          AnnotationSpec.builder(ClassName("kotlin", "OptIn"))
            .addMember("%T::class", experimentalOptIn)
            .build()
        )
        .addParameter("encoder", encoder)
        .addParameter("value", fhirDecimal)
        .beginControlFlow("if (encoder is %T)", jsonEncoder)
        .addStatement(
          "encoder.encodeSerializableValue(%T.serializer(), %M(value.wire))",
          jsonPrimitive,
          jsonUnquotedLiteral,
        )
        .nextControlFlow("else")
        .addStatement("encoder.encodeString(value.wire)")
        .endControlFlow()
        .build()

    val deserializeFn =
      FunSpec.builder("deserialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", decoder)
        .returns(fhirDecimal)
        .beginControlFlow("return if (decoder is %T)", jsonDecoder)
        .addStatement(
          "%T.fromString(decoder.decodeJsonElement().%M.content)",
          fhirDecimal,
          jsonPrimitiveAccessor,
        )
        .nextControlFlow("else")
        .addStatement("%T.fromString(decoder.decodeString())", fhirDecimal)
        .endControlFlow()
        .build()

    return FileSpec.builder(packageName, "FhirDecimalSerializer")
      .addType(
        TypeSpec.objectBuilder("FhirDecimalSerializer")
          .addModifiers(KModifier.INTERNAL)
          .addKdoc("Serializer for `FhirDecimal` which outputs unquoted JSON literals.")
          .addSuperinterface(kSerializer.parameterizedBy(fhirDecimal))
          .addProperty(
            PropertySpec.builder("descriptor", serialDescriptor)
              .addModifiers(KModifier.OVERRIDE)
              .initializer(
                CodeBlock.of(
                  "%T(%S, %T.%L)",
                  primitiveDescriptor,
                  "FhirDecimal",
                  primitiveKind,
                  "STRING",
                )
              )
              .build()
          )
          .addFunction(serializeFn)
          .addFunction(deserializeFn)
          .build()
      )
      .build()
  }
}

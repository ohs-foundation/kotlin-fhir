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
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

/**
 * Generates `BigDecimalSerializer` — a [kotlinx.serialization.KSerializer] for the bignum
 * `BigDecimal` type used by FHIR's `decimal` primitive.
 *
 * FHIR requires decimal precision to be preserved on the wire (`0.010 ≠ 0.01`). On the JSON path
 * the value is emitted as an unquoted number via `JsonUnquotedLiteral(toPlainString())` — keeping
 * trailing zeros and arbitrary precision that `Double` would silently lose. For non-JSON encoders
 * the serializer falls back to `encodeString(toPlainString())` / `decodeString()` so the same
 * precision is preserved through a string encoding.
 */
object BigDecimalSerializerFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val bigDecimalClassName = ClassName("com.ionspin.kotlin.bignum.decimal", "BigDecimal")
    val kSerializerClassName = ClassName("kotlinx.serialization", "KSerializer")
    val serialDescriptorClassName =
      ClassName("kotlinx.serialization.descriptors", "SerialDescriptor")
    val primitiveDescriptorClassName =
      ClassName("kotlinx.serialization.descriptors", "PrimitiveSerialDescriptor")
    val primitiveKindClassName = ClassName("kotlinx.serialization.descriptors", "PrimitiveKind")
    val encoderClassName = ClassName("kotlinx.serialization.encoding", "Encoder")
    val decoderClassName = ClassName("kotlinx.serialization.encoding", "Decoder")
    val jsonEncoderClassName = ClassName("kotlinx.serialization.json", "JsonEncoder")
    val jsonDecoderClassName = ClassName("kotlinx.serialization.json", "JsonDecoder")
    val jsonPrimitiveClassName = ClassName("kotlinx.serialization.json", "JsonPrimitive")
    val jsonUnquotedLiteralMemberName =
      com.squareup.kotlinpoet.MemberName("kotlinx.serialization.json", "JsonUnquotedLiteral")
    val experimentalOptInClassName =
      ClassName("kotlinx.serialization", "ExperimentalSerializationApi")

    val serializeFn =
      FunSpec.builder("serialize")
        .addModifiers(KModifier.OVERRIDE)
        .addAnnotation(
          AnnotationSpec.builder(ClassName("kotlin", "OptIn"))
            .addMember("%T::class", experimentalOptInClassName)
            .build()
        )
        .addParameter("encoder", encoderClassName)
        .addParameter("value", bigDecimalClassName)
        .beginControlFlow("if (encoder is %T)", jsonEncoderClassName)
        .addStatement(
          "encoder.encodeSerializableValue(%T.serializer(), %M(value.toPlainString()))",
          jsonPrimitiveClassName,
          jsonUnquotedLiteralMemberName,
        )
        .nextControlFlow("else")
        .addStatement("encoder.encodeString(value.toPlainString())")
        .endControlFlow()
        .build()

    val deserializeFn =
      FunSpec.builder("deserialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", decoderClassName)
        .returns(bigDecimalClassName)
        .beginControlFlow("return if (decoder is %T)", jsonDecoderClassName)
        .addStatement(
          "%T.parseString(decoder.decodeJsonElement().%M.content)",
          bigDecimalClassName,
          com.squareup.kotlinpoet.MemberName("kotlinx.serialization.json", "jsonPrimitive"),
        )
        .nextControlFlow("else")
        .addStatement("%T.parseString(decoder.decodeString())", bigDecimalClassName)
        .endControlFlow()
        .build()

    return FileSpec.builder(packageName, "BigDecimalSerializer")
      .addType(
        TypeSpec.objectBuilder("BigDecimalSerializer")
          .addModifiers(KModifier.INTERNAL)
          .addKdoc(
            "Serializer for bignum `BigDecimal` — the in-memory type for FHIR's `decimal` " +
              "primitive. On the JSON wire the value is emitted as an unquoted number that " +
              "preserves the original precision (trailing zeros included); on other encoders " +
              "it falls back to a plain decimal string."
          )
          .addSuperinterface(kSerializerClassName.parameterizedBy(bigDecimalClassName))
          .addProperty(
            PropertySpec.builder("descriptor", serialDescriptorClassName)
              .addModifiers(KModifier.OVERRIDE)
              .initializer(
                CodeBlock.of(
                  "%T(%S, %T.%L)",
                  primitiveDescriptorClassName,
                  "FhirBigDecimal",
                  primitiveKindClassName,
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

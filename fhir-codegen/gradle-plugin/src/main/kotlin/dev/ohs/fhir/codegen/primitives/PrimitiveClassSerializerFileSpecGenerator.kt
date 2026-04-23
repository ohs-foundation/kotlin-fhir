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
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec

/**
 * Generates a custom `KSerializer` object for one FHIR primitive wrapper class (e.g. `Boolean`,
 * `Decimal`, `Code`). The serializer hand-builds a class descriptor with three elements — `id`,
 * `extension`, `value` — and implements serialize/deserialize via `encodeStructure` /
 * `decodeStructure`.
 *
 * This bypasses the kotlinx.serialization compiler plugin entirely, so the compile-time duplicate
 * serial name error from `@Serializable` + inheritance + `override val` never arises. The wrapper
 * class itself is annotated `@Serializable(with = XSerializer::class)` so kotlinx.serialization
 * dispatches here whenever a primitive is encoded/decoded — including the JSON path, reached via
 * the enclosing resource/complex serializer's structure-based fallback.
 */
object PrimitiveClassSerializerFileSpecGenerator {
  /**
   * [primitiveClassName] = e.g. `dev.ohs.fhir.model.r4.Boolean`.
   *
   * [valueType] = Kotlin type of the primitive's `value` property, non-nullable (e.g.
   * `kotlin.Boolean`, `kotlin.Int`, `kotlin.String`, `BigDecimal`, `FhirDate`).
   *
   * [valueNullable] = whether the primitive's `value` property is nullable. All FHIR primitives are
   * nullable except `xhtml`.
   */
  fun generate(
    primitiveClassName: ClassName,
    valueType: TypeName,
    valueNullable: Boolean,
  ): FileSpec {
    val serializerClassName =
      ClassName(
        "${primitiveClassName.packageName}.serializers",
        "${primitiveClassName.simpleName}Serializer",
      )
    val extensionClassName = ClassName(primitiveClassName.packageName, "Extension")
    val kSerializer = ClassName("kotlinx.serialization", "KSerializer")
    val serialDescriptor = ClassName("kotlinx.serialization.descriptors", "SerialDescriptor")
    val encoder = ClassName("kotlinx.serialization.encoding", "Encoder")
    val decoder = ClassName("kotlinx.serialization.encoding", "Decoder")
    val compositeDecoder = ClassName("kotlinx.serialization.encoding", "CompositeDecoder")
    val builtinsListSerializer = ClassName("kotlinx.serialization.builtins", "ListSerializer")
    val buildClassSerialDescriptor =
      ClassName("kotlinx.serialization.descriptors", "buildClassSerialDescriptor")
    val experimentalOptIn = ClassName("kotlinx.serialization", "ExperimentalSerializationApi")
    val internalOptIn = ClassName("kotlinx.serialization", "InternalSerializationApi")

    // Resolve the value-serializer expression + descriptor expression from the value TypeName.
    val valueEncoding = valueEncodingFor(valueType, primitiveClassName.packageName)

    val listExtensionSerializerInit =
      CodeBlock.of("%T(%T.serializer())", builtinsListSerializer, extensionClassName)

    val descriptorInit =
      CodeBlock.builder()
        .add(
          "%M(%S) {\n",
          MemberNameRef("kotlinx.serialization.descriptors", "buildClassSerialDescriptor"),
          primitiveClassName.simpleName,
        )
        .indent()
        .add("element(%S, %T.serializer().descriptor)\n", "id", ClassName("kotlin", "String"))
        .add("element(%S, extensionListSerializer.descriptor)\n", "extension")
        .add("element(%S, %L)\n", "value", valueEncoding.descriptorExpr)
        .unindent()
        .add("}\n")
        .build()

    val serializeFn =
      FunSpec.builder("serialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("encoder", encoder)
        .addParameter("value", primitiveClassName)
        .addCode(
          CodeBlock.builder()
            .add("encoder.encodeStructure(descriptor) {\n")
            .indent()
            .add(
              "encodeNullableSerializableElement(descriptor, 0, %T.serializer(), value.id)\n",
              ClassName("kotlin", "String"),
            )
            .add(
              "if (value.extension.isNotEmpty()) " +
                "encodeSerializableElement(descriptor, 1, extensionListSerializer, value.extension)\n"
            )
            .apply {
              if (valueNullable) {
                add(
                  "encodeNullableSerializableElement(descriptor, 2, %L, value.`value`)\n",
                  valueEncoding.serializerExpr,
                )
              } else {
                add(
                  "encodeSerializableElement(descriptor, 2, %L, value.`value`)\n",
                  valueEncoding.serializerExpr,
                )
              }
            }
            .unindent()
            .add("}\n")
            .build()
        )
        .build()

    val deserializeFn =
      FunSpec.builder("deserialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", decoder)
        .returns(primitiveClassName)
        .addCode(
          CodeBlock.builder()
            .add("return decoder.decodeStructure(descriptor) {\n")
            .indent()
            .add("var id: %T? = null\n", ClassName("kotlin", "String"))
            .add(
              "var extension: %T<%T> = emptyList()\n",
              ClassName("kotlin.collections", "List"),
              extensionClassName,
            )
            .apply {
              if (valueNullable) {
                add("var `value`: %T? = null\n", valueType)
              } else {
                // xhtml: value is non-nullable. Default to empty string until we read it.
                add("var `value`: %T = \"\"\n", valueType)
              }
            }
            .add("while (true) {\n")
            .indent()
            .add("when (val index = decodeElementIndex(descriptor)) {\n")
            .indent()
            .add(
              "0 -> id = decodeNullableSerializableElement(descriptor, 0, %T.serializer())\n",
              ClassName("kotlin", "String"),
            )
            .add(
              "1 -> extension = decodeSerializableElement(descriptor, 1, extensionListSerializer)\n"
            )
            .apply {
              if (valueNullable) {
                add(
                  "2 -> `value` = decodeNullableSerializableElement(descriptor, 2, %L)\n",
                  valueEncoding.serializerExpr,
                )
              } else {
                add(
                  "2 -> `value` = decodeSerializableElement(descriptor, 2, %L)\n",
                  valueEncoding.serializerExpr,
                )
              }
            }
            .add("%T.DECODE_DONE -> break\n", compositeDecoder)
            .add(
              "else -> throw %T(%P)\n",
              ClassName("kotlinx.serialization", "SerializationException"),
              "Unexpected index \$index decoding \${descriptor.serialName}",
            )
            .unindent()
            .add("}\n")
            .unindent()
            .add("}\n")
            .add("%T(id = id, extension = extension, `value` = `value`)\n", primitiveClassName)
            .unindent()
            .add("}\n")
            .build()
        )
        .build()

    val typeSpec =
      TypeSpec.objectBuilder(serializerClassName)
        .addModifiers(KModifier.INTERNAL)
        .addAnnotation(
          AnnotationSpec.builder(ClassName("kotlin", "OptIn"))
            .addMember("%T::class", experimentalOptIn)
            .addMember("%T::class", internalOptIn)
            .build()
        )
        .addSuperinterface(kSerializer.parameterizedBy(primitiveClassName))
        .addProperty(
          PropertySpec.builder(
              "extensionListSerializer",
              kSerializer.parameterizedBy(
                ClassName("kotlin.collections", "List").parameterizedBy(extensionClassName)
              ),
            )
            .addModifiers(KModifier.PRIVATE)
            .initializer(listExtensionSerializerInit)
            .build()
        )
        .addProperty(
          PropertySpec.builder("descriptor", serialDescriptor)
            .addModifiers(KModifier.OVERRIDE)
            .initializer(descriptorInit)
            .build()
        )
        .addFunction(serializeFn)
        .addFunction(deserializeFn)
        .build()

    return FileSpec.builder(serializerClassName)
      .addImport("kotlinx.serialization.encoding", "encodeStructure")
      .addImport("kotlinx.serialization.encoding", "decodeStructure")
      .addImport("kotlinx.serialization.builtins", "serializer")
      .addType(typeSpec)
      .build()
  }

  private data class ValueEncoding(val serializerExpr: CodeBlock, val descriptorExpr: CodeBlock)

  private fun valueEncodingFor(valueType: TypeName, modelPackage: String): ValueEncoding {
    val raw = (valueType as? ClassName)?.copy(nullable = false)
    val serializersPackage = "$modelPackage.serializers"
    return when {
      raw == ClassName("kotlin", "Boolean") ||
        raw == ClassName("kotlin", "Int") ||
        raw == ClassName("kotlin", "Long") ||
        raw == ClassName("kotlin", "String") ->
        ValueEncoding(
          serializerExpr = CodeBlock.of("%T.serializer()", raw),
          descriptorExpr = CodeBlock.of("%T.serializer().descriptor", raw),
        )
      raw == ClassName("kotlin", "ByteArray") ->
        ValueEncoding(
          serializerExpr =
            CodeBlock.of("%T", ClassName("kotlinx.serialization.builtins", "ByteArraySerializer")),
          descriptorExpr =
            CodeBlock.of(
              "%T.descriptor",
              ClassName("kotlinx.serialization.builtins", "ByteArraySerializer"),
            ),
        )
      raw == ClassName("com.ionspin.kotlin.bignum.decimal", "BigDecimal") ->
        customSerializerRef(ClassName(serializersPackage, "BigDecimalSerializer"))
      raw == ClassName(modelPackage, "FhirDate") ->
        customSerializerRef(ClassName(serializersPackage, "FhirDateSerializer"))
      raw == ClassName(modelPackage, "FhirDateTime") ->
        customSerializerRef(ClassName(serializersPackage, "FhirDateTimeSerializer"))
      raw == ClassName("kotlinx.datetime", "LocalTime") ->
        customSerializerRef(ClassName(serializersPackage, "LocalTimeSerializer"))
      else ->
        error(
          "PrimitiveClassSerializerFileSpecGenerator: unsupported value type $valueType. " +
            "Add a mapping in valueEncodingFor()."
        )
    }
  }

  private fun customSerializerRef(className: ClassName): ValueEncoding =
    ValueEncoding(
      serializerExpr = CodeBlock.of("%T", className),
      descriptorExpr = CodeBlock.of("%T.descriptor", className),
    )

  /** Tiny helper so we don't have to import [com.squareup.kotlinpoet.MemberName] separately. */
  private fun MemberNameRef(packageName: String, name: String) =
    com.squareup.kotlinpoet.MemberName(packageName, name)
}

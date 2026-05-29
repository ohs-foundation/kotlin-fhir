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

package dev.ohs.fhir.codegen.serializer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.TypeName

internal const val KOTLINX_SERIALIZATION_DESCRIPTORS = "kotlinx.serialization.descriptors"
internal const val KOTLINX_SERIALIZATION_ENCODING = "kotlinx.serialization.encoding"
internal const val KOTLINX_SERIALIZATION_BUILTINS = "kotlinx.serialization.builtins"

internal val decoderClassName = ClassName(KOTLINX_SERIALIZATION_ENCODING, "Decoder")
internal val encoderClassName = ClassName(KOTLINX_SERIALIZATION_ENCODING, "Encoder")
internal val serialDescriptorClassName =
  ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "SerialDescriptor")
internal val compositeDecoderClassName =
  ClassName(KOTLINX_SERIALIZATION_ENCODING, "CompositeDecoder")

internal val buildClassSerialDescriptorMemberName =
  MemberName(KOTLINX_SERIALIZATION_DESCRIPTORS, "buildClassSerialDescriptor")
internal val decodeStructureMemberName =
  MemberName(KOTLINX_SERIALIZATION_ENCODING, "decodeStructure")
internal val encodeStructureMemberName =
  MemberName(KOTLINX_SERIALIZATION_ENCODING, "encodeStructure")
internal val listSerializerMemberName = MemberName(KOTLINX_SERIALIZATION_BUILTINS, "ListSerializer")
internal val nullableMemberName = MemberName(KOTLINX_SERIALIZATION_BUILTINS, "nullable")
internal val listDescMemberName =
  MemberName(KOTLINX_SERIALIZATION_DESCRIPTORS, "listSerialDescriptor")

internal fun lazyDescriptorMemberName(className: ClassName): MemberName =
  MemberName("${className.packageName}.serializers", "lazyDescriptor")

/**
 * Certain stdlib / external types are serialized via a FHIR-specific custom serializer (e.g.
 * `LocalTime` → `LocalTimeSerializer` which always includes seconds; `BigDecimal` →
 * `BigDecimalSerializer`). Returns the custom serializer's [ClassName] for JSON + proto
 * encode/decode, or null for types that use the default kotlinx serializer.
 */
internal fun customSerializerFor(className: ClassName, parentClass: ClassName): ClassName? {
  val pkg = "${parentClass.packageName}.serializers"
  return when {
    className.packageName == "kotlinx.datetime" && className.simpleName == "LocalTime" ->
      ClassName(pkg, "LocalTimeSerializer")
    className.packageName == "com.ionspin.kotlin.bignum.decimal" &&
      className.simpleName == "BigDecimal" -> ClassName(pkg, "BigDecimalSerializer")
    className.packageName == parentClass.packageName && className.simpleName == "FhirDate" ->
      ClassName(pkg, "FhirDateSerializer")
    className.packageName == parentClass.packageName && className.simpleName == "FhirDateTime" ->
      ClassName(pkg, "FhirDateTimeSerializer")
    else -> null
  }
}

private val stdlibSerializableTypes =
  setOf("String", "Int", "Long", "Double", "Boolean", "Char", "Byte", "Short", "Float")

internal fun isStdlibSerializableType(className: ClassName): Boolean =
  className.packageName == "kotlin" && className.simpleName in stdlibSerializableTypes

internal fun serializerForClassName(className: ClassName): CodeBlock =
  if (isStdlibSerializableType(className)) {
    CodeBlock.of("%T.%M()", className, MemberName(KOTLINX_SERIALIZATION_BUILTINS, "serializer"))
  } else {
    CodeBlock.of("%T.serializer()", className)
  }

internal fun serializerForTypeName(typeName: TypeName): CodeBlock {
  return when (val nonNull = typeName.copy(nullable = false)) {
    is ClassName -> serializerForClassName(nonNull)
    is ParameterizedTypeName -> {
      when (nonNull.rawType) {
        ClassName("kotlin.collections", "List"),
        ClassName("kotlin.collections", "MutableList") -> {
          val inner = nonNull.typeArguments.single()
          val innerSer = serializerForTypeName(inner)
          if (inner.isNullable) {
            CodeBlock.of(
              "%M((%L).%M)",
              MemberName(KOTLINX_SERIALIZATION_BUILTINS, "ListSerializer"),
              innerSer,
              MemberName(KOTLINX_SERIALIZATION_BUILTINS, "nullable"),
            )
          } else {
            CodeBlock.of(
              "%M(%L)",
              MemberName(KOTLINX_SERIALIZATION_BUILTINS, "ListSerializer"),
              innerSer,
            )
          }
        }
        else -> serializerForClassName(nonNull.rawType)
      }
    }
    else -> error("Unexpected TypeName: $typeName")
  }
}

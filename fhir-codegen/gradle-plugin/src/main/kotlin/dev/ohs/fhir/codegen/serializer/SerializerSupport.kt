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
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.toSerializerClassName
import kotlinx.serialization.KSerializer

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
 * Builds `internal val listSerializer: KSerializer<List<T>> = ListSerializer(this)` (or
 * `nullableListSerializer: KSerializer<List<T?>> = ListSerializer(this.nullable)` when
 * [nullableElement] is true) on a serializer singleton object.
 */
internal fun buildListSerializerProperty(
  elementType: ClassName,
  nullableElement: Boolean = false,
): PropertySpec {
  val listElementType = elementType.copy(nullable = nullableElement)
  val listType = ClassName("kotlin.collections", "List").parameterizedBy(listElementType)
  val propName = if (nullableElement) "nullableListSerializer" else "listSerializer"
  val initializer =
    if (nullableElement) {
      CodeBlock.of("%M(this.%M)", listSerializerMemberName, nullableMemberName)
    } else {
      CodeBlock.of("%M(this)", listSerializerMemberName)
    }
  return PropertySpec.builder(
      propName,
      KSerializer::class.asClassName().parameterizedBy(listType),
      KModifier.INTERNAL,
    )
    .initializer(initializer)
    .build()
}

/**
 * Certain stdlib / external types are serialized via a FHIR-specific custom serializer (e.g.
 * `LocalTime` → `LocalTimeSerializer` which always includes seconds; `FhirDecimal` →
 * `FhirDecimalSerializer`). Returns the custom serializer's [ClassName] for JSON + proto
 * encode/decode, or null for types that use the default kotlinx serializer.
 */
internal fun customSerializerFor(className: ClassName, parentClass: ClassName): ClassName? {
  val pkg = "${parentClass.packageName}.serializers"
  return when {
    className.packageName == "kotlinx.datetime" && className.simpleName == "LocalTime" ->
      ClassName(pkg, "LocalTimeSerializer")
    className.packageName == parentClass.packageName && className.simpleName == "FhirDecimal" ->
      ClassName(pkg, "FhirDecimalSerializer")
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

/**
 * Returns the generated serializer singleton [ClassName] for [className] (custom primitive
 * serializer, `ResourcePolymorphicSerializer`, or `XSerializer`), or null for stdlib / external
 * types that do not have a generated serializer object in [parentClass]'s package.
 */
private fun serializerObjectForClass(className: ClassName, parentClass: ClassName): ClassName? {
  customSerializerFor(className, parentClass)?.let {
    return it
  }
  if (className.packageName != parentClass.packageName) return null
  return if (className.simpleNames == listOf("Resource")) {
    ClassName(parentClass.packageName, "ResourcePolymorphicSerializer")
  } else {
    className.toSerializerClassName()
  }
}

/**
 * Direct singleton reference to the serializer for [className] at an encode/decode call site (e.g.
 * `ExtensionSerializer`, `LocalTimeSerializer`, `ResourcePolymorphicSerializer`, or
 * `String.serializer()`).
 */
internal fun serializerRefForClass(className: ClassName, parentClass: ClassName): CodeBlock =
  serializerObjectForClass(className, parentClass)?.let { CodeBlock.of("%T", it) }
    ?: serializerForClassName(className)

/**
 * Direct reference to the shared `ListSerializer` singleton for `List<className>` (or
 * `List<className?>` when [nullableElement] is true) owned by the element's serializer object.
 */
internal fun listSerializerRefForClass(
  className: ClassName,
  parentClass: ClassName,
  nullableElement: Boolean,
): CodeBlock {
  if (nullableElement) {
    val serializersPkg = "${parentClass.packageName}.serializers"
    if (className.packageName == "kotlin") {
      when (className.simpleName) {
        "Boolean" ->
          return CodeBlock.of("%M", MemberName(serializersPkg, "booleanNullableListSerializer"))
        "Int" -> return CodeBlock.of("%M", MemberName(serializersPkg, "intNullableListSerializer"))
        "String" ->
          return CodeBlock.of("%M", MemberName(serializersPkg, "stringNullableListSerializer"))
      }
    }
    serializerObjectForClass(className, parentClass)?.let {
      return CodeBlock.of("%T.nullableListSerializer", it)
    }
    return CodeBlock.of(
      "%M((%L).%M)",
      listSerializerMemberName,
      serializerRefForClass(className, parentClass),
      nullableMemberName,
    )
  }
  return serializerObjectForClass(className, parentClass)?.let {
    CodeBlock.of("%T.listSerializer", it)
  }
    ?: CodeBlock.of(
      "%M(%L)",
      listSerializerMemberName,
      serializerRefForClass(className, parentClass),
    )
}

internal fun serializerRefForTypeName(typeName: TypeName, parentClass: ClassName): CodeBlock {
  return when (val nonNull = typeName.copy(nullable = false)) {
    is ClassName -> serializerRefForClass(nonNull, parentClass)
    is ParameterizedTypeName -> {
      when (nonNull.rawType) {
        ClassName("kotlin.collections", "List"),
        ClassName("kotlin.collections", "MutableList") -> {
          val inner = nonNull.typeArguments.single()
          val innerClass = inner.copy(nullable = false) as ClassName
          listSerializerRefForClass(innerClass, parentClass, nullableElement = inner.isNullable)
        }
        else -> serializerRefForClass(nonNull.rawType, parentClass)
      }
    }
    else -> error("Unexpected TypeName: $typeName")
  }
}

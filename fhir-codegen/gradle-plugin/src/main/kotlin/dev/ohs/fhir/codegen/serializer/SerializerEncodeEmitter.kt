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
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.CodegenContext
import dev.ohs.fhir.codegen.choiceTypeExpansionName
import dev.ohs.fhir.codegen.primitives.FhirPathType
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.Type
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getContentReferenceType
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.getPathSimpleNames
import dev.ohs.fhir.codegen.schema.isBackboneElement
import dev.ohs.fhir.codegen.schema.typeIsEnumeratedCode

/**
 * Emits the streaming-encode side of a serializer object — `serializeInternal(encoder, value)` and
 * the supporting `emit*` helpers. Writes each wire field directly to the structure encoder via
 * [CompositeEncoder.encodeXxxElement] / [CompositeEncoder.encodeSerializableElement], with no
 * intermediate `JsonObject` tree.
 */
internal class SerializerEncodeEmitter(private val codegenContext: CodegenContext) {

  /**
   * Emits `private fun serializeInternal(encoder: CompositeEncoder, value: X)` — writes each field
   * directly to the structure encoder via [CompositeEncoder.encodeXxxElement] /
   * [CompositeEncoder.encodeSerializableElement], with no intermediate `JsonObject` tree.
   */
  fun buildSerializeInternal(
    className: ClassName,
    elements: List<Element>,
    parameterized: Boolean,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ): FunSpec {
    val codeBlock = CodeBlock.builder()
    // `resourceType` is written by the outer `serialize` wrapper, not here — keeps this body
    // reusable from `XPolymorphicSerializer` (polymorphic path injects the discriminator itself).
    elements.forEach { element ->
      emitJsonEncodeForElement(codeBlock, element, className, nameToIdx, hoister)
    }
    val builder =
      FunSpec.builder("serializeInternal")
        .addModifiers(if (parameterized) KModifier.INTERNAL else KModifier.PRIVATE)
        .addParameter("encoder", ClassName(KOTLINX_SERIALIZATION_ENCODING, "CompositeEncoder"))
    if (parameterized) {
      builder.addParameter("descriptor", serialDescriptorClassName)
      builder.addParameter("descriptorOffset", Int::class)
    }
    return builder.addParameter("value", className).addCode(codeBlock.build()).build()
  }

  private fun emitJsonEncodeForElement(
    codeBlock: CodeBlock.Builder,
    element: Element,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val propertyName = element.getElementName()
    // Choice type: emit per-expansion flat keys inline against the parent's composite encoder.
    // Each expansion's value / element is written to a flat descriptor slot on the parent instead
    // of via a nested sub-object — there is no standalone choice-type serializer.
    if (element.type != null && element.type.size > 1) {
      emitChoiceTypeExpansionEncoding(codeBlock, element, modelClassName, nameToIdx, hoister)
      return
    }
    val typeCode = element.type?.singleOrNull()?.code ?: ""
    val isFhirPrimitive = FhirPathType.containsFhirTypeCode(typeCode)
    val isFhirPathUri = FhirPathType.getUris().contains(typeCode)
    if (element.max == "*" || propertyName == "extension") {
      if (isFhirPrimitive) {
        emitJsonEncodePrimitiveList(
          codeBlock,
          element,
          propertyName,
          modelClassName,
          nameToIdx,
          hoister,
        )
      } else {
        val elemCls = typeForComplexElement(element, modelClassName)
        val idx = nameToIdx.getValue(propertyName)
        val innerSer =
          hoistedSerializerForClass(
            elemCls,
            modelClassName,
            hoister,
            "${elemCls.simpleName.lowercase()}Ser",
          )
        val listSer =
          hoister.refLazy(
            CodeBlock.of("%M(%L)", listSerializerMemberName, innerSer),
            "${propertyName}ListSer",
            ClassName("kotlin.collections", "List").parameterizedBy(elemCls),
          )
        codeBlock.add(
          "if (value.%N.isNotEmpty()) encoder.encodeSerializableElement(descriptor, %L, %L, value.%N)\n",
          propertyName,
          idx,
          listSer,
          propertyName,
        )
      }
      return
    }
    if (isFhirPrimitive) {
      emitJsonEncodeSinglePrimitive(
        codeBlock,
        element,
        propertyName,
        modelClassName,
        nameToIdx,
        hoister,
      )
    } else if (isFhirPathUri) {
      val kotlinType =
        FhirPathType.getFromUri(typeCode)!!.getDataModelType(modelClassName.packageName)
      val idx = nameToIdx.getValue(propertyName)
      emitPrimitiveOrSerializableEncode(
        codeBlock,
        encoderExpr = "encoder",
        idx,
        kotlinType,
        CodeBlock.of("value.%N", propertyName),
        modelClassName,
        hoister,
        "${propertyName}Ser",
        nullable = element.min == 0,
      )
    } else {
      val singleType = typeForComplexElement(element, modelClassName)
      val idx = nameToIdx.getValue(propertyName)
      val ser =
        hoistedSerializerForClass(
          singleType,
          modelClassName,
          hoister,
          "${singleType.simpleName.lowercase()}Ser",
        )
      if (element.min == 0) {
        codeBlock.add(
          "(value.%N)?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
          propertyName,
          idx,
          ser,
        )
      } else {
        codeBlock.add(
          "encoder.encodeSerializableElement(descriptor, %L, %L, value.%N)\n",
          idx,
          ser,
          propertyName,
        )
      }
    }
  }

  /**
   * Name of the specialized `encodeXxxElement` on [CompositeEncoder] for a stdlib primitive, or
   * null if no specialized call exists (fall back to `encodeSerializableElement`).
   */
  private fun specializedEncodeElementCall(className: ClassName): String? =
    if (className.packageName != "kotlin") null
    else
      when (className.simpleName) {
        "String" -> "encodeStringElement"
        "Boolean" -> "encodeBooleanElement"
        "Int" -> "encodeIntElement"
        "Long" -> "encodeLongElement"
        "Double" -> "encodeDoubleElement"
        "Char" -> "encodeCharElement"
        else -> null
      }

  /**
   * Emits `(valueExpr)?.let { encoder.encodeXxxElement(descriptor, idx, it) }` using the
   * specialized primitive call when [type] is a stdlib primitive, falling back to
   * `encodeSerializableElement` with a hoisted serializer reference otherwise.
   */
  fun emitPrimitiveOrSerializableEncode(
    codeBlock: CodeBlock.Builder,
    encoderExpr: String,
    idx: CodeBlock,
    type: ClassName,
    valueExpr: CodeBlock,
    parentClass: ClassName,
    hoister: SerializerHoister,
    nameHint: String,
    nullable: Boolean = true,
  ) {
    val specialized = specializedEncodeElementCall(type)
    if (specialized != null) {
      if (nullable) {
        codeBlock.add(
          "(%L)?.let·{ %N.%N(descriptor, %L, it) }\n",
          valueExpr,
          encoderExpr,
          specialized,
          idx,
        )
      } else {
        codeBlock.add("%N.%N(descriptor, %L, %L)\n", encoderExpr, specialized, idx, valueExpr)
      }
      return
    }
    val ser = hoistedSerializerForClass(type, parentClass, hoister, nameHint)
    if (nullable) {
      codeBlock.add(
        "(%L)?.let·{ %N.encodeSerializableElement(descriptor, %L, %L, it) }\n",
        valueExpr,
        encoderExpr,
        idx,
        ser,
      )
    } else {
      codeBlock.add(
        "%N.encodeSerializableElement(descriptor, %L, %L, %L)\n",
        encoderExpr,
        idx,
        ser,
        valueExpr,
      )
    }
  }

  /**
   * Serializer reference for [className] at a call site — hoisted via the deferred `Hoisted` object
   * so every call site compiles to a single `getstatic Hoisted.$nameHint`. See
   * `SerializerDecodeEmitter.serializerExpressionIn` for why deferred hoisting avoids class-init
   * cycles.
   */
  fun hoistedSerializerForClass(
    className: ClassName,
    parentClass: ClassName,
    hoister: SerializerHoister,
    nameHint: String,
  ): CodeBlock {
    customSerializerFor(className, parentClass)?.let {
      return CodeBlock.of("%T", it)
    }
    return hoister.refLazy(serializerForClassName(className), nameHint, className)
  }

  /**
   * Emits the full `when (val choice = value.field) { is Arm -> … }` dispatch for a choice-type
   * element, writing each expansion's flat wire keys (e.g., `deceasedBoolean` + `_deceasedBoolean`)
   * directly into the parent's composite encoder using its flat descriptor slots. Replaces the old
   * "encode nested via sealed serializer, then flatten" pipeline.
   */
  private fun emitChoiceTypeExpansionEncoding(
    codeBlock: CodeBlock.Builder,
    element: Element,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val propertyName = element.getElementName()
    val sealedTypeClass = ClassName(modelClassName.packageName, element.getPathSimpleNames())
    codeBlock.add("when (val choice = value.%N) {\n", propertyName)
    codeBlock.indent()
    if (element.min == 0) {
      codeBlock.add("null -> {}\n")
    }
    for (type in element.type!!) {
      val expansionClassName = sealedTypeClass.nestedClass(choiceTypeExpansionName(type))
      val expansionBaseName = "$propertyName${type.code.capitalized()}"
      codeBlock.add("is %T -> {\n", expansionClassName)
      codeBlock.indent()
      emitJsonEncodeChoiceTypeExpansion(
        codeBlock,
        type,
        expansionBaseName,
        modelClassName,
        nameToIdx,
        hoister,
      )
      codeBlock.unindent()
      codeBlock.add("}\n")
    }
    codeBlock.unindent()
    codeBlock.add("}\n")
  }

  /**
   * Writes both expansion keys (`deceasedBoolean` + `_deceasedBoolean`) for a matched choice type
   * expansion.
   */
  private fun emitJsonEncodeChoiceTypeExpansion(
    codeBlock: CodeBlock.Builder,
    type: Type,
    choiceFieldBaseName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val typeCode = type.code
    val valueIdx = nameToIdx.getValue(choiceFieldBaseName)
    val elementIdx = nameToIdx["_$choiceFieldBaseName"]
    if (FhirPathType.containsFhirTypeCode(typeCode)) {
      val fhirPathType = FhirPathType.getFromFhirTypeCode(typeCode)!!
      val wireClassName = fhirPathType.getWireType(modelClassName.packageName)
      // Value expansion
      val valueExpr =
        CodeBlock.builder()
          .apply {
            add("(choice.value")
            fhirPathType.addCodeToEncodeModelToWire(this)
            add(")")
          }
          .build()
      emitPrimitiveOrSerializableEncode(
        codeBlock,
        "encoder",
        valueIdx,
        wireClassName,
        valueExpr,
        modelClassName,
        hoister,
        "${choiceFieldBaseName}Ser",
      )
      // Element (_field) expansion
      if (elementIdx != null) {
        val elementClassName = ClassName(modelClassName.packageName, "Element")
        val elementSer =
          hoistedSerializerForClass(elementClassName, modelClassName, hoister, "elementSer")
        codeBlock.add(
          "(choice.value.toElement())?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
          elementIdx,
          elementSer,
        )
      }
    } else {
      // Complex expansion — e.g. Annotation.authorReference
      val complexClassName = ClassName(modelClassName.packageName, typeCode.capitalized())
      val complexSer =
        hoistedSerializerForClass(
          complexClassName,
          modelClassName,
          hoister,
          "${complexClassName.simpleName.lowercase()}Ser",
        )
      codeBlock.add(
        "encoder.encodeSerializableElement(descriptor, %L, %L, choice.value)\n",
        valueIdx,
        complexSer,
      )
    }
  }

  private fun emitJsonEncodeSinglePrimitive(
    codeBlock: CodeBlock.Builder,
    element: Element,
    propertyName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val typeCode = element.type!!.single().code
    val fhirPathType = FhirPathType.getFromFhirTypeCode(typeCode)!!
    val isEnum = element.typeIsEnumeratedCode(codegenContext.valueSetMap)
    val isRequired = element.min == 1 && element.max == "1"
    val wireClassName: ClassName = fhirPathType.getWireType(modelClassName.packageName)
    val valueIdx = nameToIdx.getValue(propertyName)
    val elementIdx = nameToIdx.getValue("_$propertyName")
    val valueType: ClassName = if (isEnum) String::class.asClassName() else wireClassName
    val valueExpr =
      CodeBlock.builder()
        .apply {
          add("(")
          if (isEnum) {
            add(
              if (isRequired) "value.%N.value?.getCode()" else "value.%N?.value?.getCode()",
              propertyName,
            )
          } else {
            add("value.%N", propertyName)
            if (!isRequired) add("?")
            fhirPathType.addCodeToEncodeModelToWire(this)
          }
          add(")")
        }
        .build()
    // The wire-encoded value is non-null only when both the wrapper itself is required AND its
    // `.value` field is non-null on the model side (which is true only for primitives whose own
    // StructureDefinition has `<Type>.value` with `min > 0`, atm only `xhtml`). Enums always
    // go through a `?.getCode()` chain and stay nullable.
    val wireIsNonNull = codegenContext.primitiveValueIsNonNull[typeCode] == true && !isEnum
    emitPrimitiveOrSerializableEncode(
      codeBlock,
      "encoder",
      valueIdx,
      valueType,
      valueExpr,
      modelClassName,
      hoister,
      "${propertyName}Ser",
      nullable = !(isRequired && wireIsNonNull),
    )
    val elementClassName = ClassName(modelClassName.packageName, "Element")
    val elementSer =
      hoistedSerializerForClass(elementClassName, modelClassName, hoister, "elementSer")
    codeBlock.add("(value.%N", propertyName)
    if (!isRequired) codeBlock.add("?")
    codeBlock.add(
      ".toElement())?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
      elementIdx,
      elementSer,
    )
  }

  private fun emitJsonEncodePrimitiveList(
    codeBlock: CodeBlock.Builder,
    element: Element,
    propertyName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val typeCode = element.type!!.single().code
    val fhirPathType = FhirPathType.getFromFhirTypeCode(typeCode)!!
    val isEnum = element.typeIsEnumeratedCode(codegenContext.valueSetMap)
    val wireClassName: ClassName = fhirPathType.getWireType(modelClassName.packageName)
    val valueIdx = nameToIdx.getValue(propertyName)
    val elementIdx = nameToIdx.getValue("_$propertyName")
    val valueInnerType: ClassName = if (isEnum) String::class.asClassName() else wireClassName
    val valueInnerSer =
      if (isEnum)
        hoistedSerializerForClass(String::class.asClassName(), modelClassName, hoister, "stringSer")
      else
        customSerializerFor(wireClassName, modelClassName)?.let { CodeBlock.of("%T", it) }
          ?: hoistedSerializerForClass(
            wireClassName,
            modelClassName,
            hoister,
            "${wireClassName.simpleName.lowercase()}Ser",
          )
    val listOfNullableType: (ClassName) -> TypeName = { inner ->
      ClassName("kotlin.collections", "List").parameterizedBy(inner.copy(nullable = true))
    }
    val valueListSer =
      hoister.refLazy(
        CodeBlock.of("%M((%L).%M)", listSerializerMemberName, valueInnerSer, nullableMemberName),
        "${propertyName}ListSer",
        listOfNullableType(valueInnerType),
      )
    val elementClassName = ClassName(modelClassName.packageName, "Element")
    val elementSer =
      hoistedSerializerForClass(elementClassName, modelClassName, hoister, "elementSer")
    val elementListSer =
      hoister.refLazy(
        CodeBlock.of("%M((%L).%M)", listSerializerMemberName, elementSer, nullableMemberName),
        "_${propertyName}ListSer",
        listOfNullableType(elementClassName),
      )
    // values
    codeBlock.add("(")
    if (isEnum) {
      codeBlock.add(
        "value.%N.map·{·it.value?.getCode()·}.takeUnless·{·it.all·{·it == null·}·}",
        propertyName,
      )
    } else {
      codeBlock.add("value.%N.map·{·it", propertyName)
      fhirPathType.addCodeToEncodeModelToWire(codeBlock)
      codeBlock.add("·}.takeUnless·{·it.all·{·it == null·}·}")
    }
    codeBlock.add(
      ")?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
      valueIdx,
      valueListSer,
    )
    // element (_field) lists
    codeBlock.add(
      "(value.%N.map·{·it.toElement()·}.takeUnless·{·it.all·{·it == null·}·})?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
      propertyName,
      elementIdx,
      elementListSer,
    )
  }

  /** Resolves the model [ClassName] for a non-primitive complex element. */
  fun typeForComplexElement(element: Element, modelClassName: ClassName): ClassName {
    element.getContentReferenceType(modelClassName.packageName)?.let {
      return it
    }
    if (element.isBackboneElement()) {
      val simpleNames = element.path.split('.').map { it.capitalized() }
      return ClassName(modelClassName.packageName, simpleNames)
    }
    val typeCode = element.type?.singleOrNull()?.code
    if (typeCode != null) {
      return ClassName(modelClassName.packageName, typeCode.capitalized())
    }
    val simpleNames = element.path.split('.').map { it.capitalized() }
    return ClassName(modelClassName.packageName, simpleNames)
  }
}

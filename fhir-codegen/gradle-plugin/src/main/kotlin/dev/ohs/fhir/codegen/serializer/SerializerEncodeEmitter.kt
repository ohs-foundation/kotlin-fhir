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
import dev.ohs.fhir.codegen.schema.isExtensibleBinding
import dev.ohs.fhir.codegen.schema.typeShouldBindToEnum

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
  ): FunSpec {
    val codeBlock = CodeBlock.builder()
    if (parameterized) {
      // `resourceType` is written by the outer `serialize` wrapper, not here — keeps this body
      // reusable from `XPolymorphicSerializer` (polymorphic path injects the discriminator itself).
      elements.forEach { element ->
        emitJsonEncodeForElement(codeBlock, element, className, nameToIdx, recv = "encoder.")
      }
      return FunSpec.builder("serializeInternal")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("encoder", ClassName(KOTLINX_SERIALIZATION_ENCODING, "CompositeEncoder"))
        .addParameter("descriptor", serialDescriptorClassName)
        .addParameter("descriptorOffset", Int::class)
        .addParameter("value", className)
        .addCode(codeBlock.build())
        .build()
    } else {
      codeBlock.add("encoder.%M(descriptor) {\n", encodeStructureMemberName).indent()
      elements.forEach { element ->
        emitJsonEncodeForElement(codeBlock, element, className, nameToIdx, recv = "")
      }
      codeBlock.unindent().add("}\n")
      return FunSpec.builder("serialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("encoder", encoderClassName)
        .addParameter("value", className)
        .addCode(codeBlock.build())
        .build()
    }
  }

  private fun emitJsonEncodeForElement(
    codeBlock: CodeBlock.Builder,
    element: Element,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    recv: String,
  ) {
    val propertyName = element.getElementName()
    // Choice type: emit per-expansion flat keys inline against the parent's composite encoder.
    // Each expansion's value / element is written to a flat descriptor slot on the parent instead
    // of via a nested sub-object — there is no standalone choice-type serializer.
    if (element.type != null && element.type.size > 1) {
      emitChoiceTypeExpansionEncoding(codeBlock, element, modelClassName, nameToIdx, recv)
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
          recv,
        )
      } else {
        val elemCls = typeForComplexElement(element, modelClassName)
        val idx = nameToIdx.getValue(propertyName)
        val listSer = listSerializerRefForClass(elemCls, modelClassName, nullableElement = false)
        codeBlock.add(
          "if (value.%N.isNotEmpty()) ${recv}encodeSerializableElement(descriptor, %L, %L, value.%N)\n",
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
        recv,
      )
    } else if (isFhirPathUri) {
      val kotlinType =
        FhirPathType.getFromUri(typeCode)!!.getDataModelType(modelClassName.packageName)
      val idx = nameToIdx.getValue(propertyName)
      emitPrimitiveOrSerializableEncode(
        codeBlock,
        recv,
        idx,
        kotlinType,
        CodeBlock.of("value.%N", propertyName),
        modelClassName,
        nullable = element.min == 0,
      )
    } else {
      val singleType = typeForComplexElement(element, modelClassName)
      val idx = nameToIdx.getValue(propertyName)
      val ser = serializerRefForClass(singleType, modelClassName)
      if (element.min == 0) {
        codeBlock.add(
          "${recv}encodeSerializableIfNotNull(descriptor, %L, %L, value.%N)\n",
          idx,
          ser,
          propertyName,
        )
      } else {
        codeBlock.add(
          "${recv}encodeSerializableElement(descriptor, %L, %L, value.%N)\n",
          idx,
          ser,
          propertyName,
        )
      }
    }
  }

  /**
   * Name of the specialized `encodeXxxElement` (or `encodeXxxIfNotNull` when [nullable] is true) on
   * [CompositeEncoder] for a stdlib primitive, or null if no specialized call exists (fall back to
   * `encodeSerializableElement` / `encodeSerializableIfNotNull`).
   */
  private fun specializedEncodeElementCall(className: ClassName, nullable: Boolean): String? =
    if (className.packageName != "kotlin") null
    else if (nullable)
      when (className.simpleName) {
        "String" -> "encodeStringIfNotNull"
        "Boolean" -> "encodeBooleanIfNotNull"
        "Int" -> "encodeIntIfNotNull"
        else -> null
      }
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
   * Emits a non-null or null-checked encode call on [recv], using the specialized primitive call
   * when [type] is a stdlib primitive and falling back to `encodeSerializableElement` /
   * `encodeSerializableIfNotNull` with a singleton serializer reference otherwise.
   */
  fun emitPrimitiveOrSerializableEncode(
    codeBlock: CodeBlock.Builder,
    recv: String,
    idx: CodeBlock,
    type: ClassName,
    valueExpr: CodeBlock,
    parentClass: ClassName,
    nullable: Boolean = true,
  ) {
    val specialized = specializedEncodeElementCall(type, nullable)
    if (specialized != null) {
      codeBlock.add("${recv}%N(descriptor, %L, %L)\n", specialized, idx, valueExpr)
      return
    }
    val ser = serializerRefForClass(type, parentClass)
    val encodeFn = if (nullable) "encodeSerializableIfNotNull" else "encodeSerializableElement"
    codeBlock.add(
      "${recv}%N(descriptor, %L, %L, %L)\n",
      encodeFn,
      idx,
      ser,
      valueExpr,
    )
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
    recv: String,
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
        recv,
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
    recv: String,
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
            add("choice.value")
            fhirPathType.addCodeToEncodeModelToWire(this)
          }
          .build()
      emitPrimitiveOrSerializableEncode(
        codeBlock,
        recv,
        valueIdx,
        wireClassName,
        valueExpr,
        modelClassName,
      )
      // Element (_field) expansion
      if (elementIdx != null) {
        codeBlock.add(
          "${recv}encodeElementIfNotNull(descriptor, %L, choice.value)\n",
          elementIdx,
        )
      }
    } else {
      // Complex expansion — e.g. Annotation.authorReference
      val complexClassName = ClassName(modelClassName.packageName, typeCode.capitalized())
      val complexSer = serializerRefForClass(complexClassName, modelClassName)
      codeBlock.add(
        "${recv}encodeSerializableElement(descriptor, %L, %L, choice.value)\n",
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
    recv: String,
  ) {
    val typeCode = element.type!!.single().code
    val fhirPathType = FhirPathType.getFromFhirTypeCode(typeCode)!!
    val isEnum = element.typeShouldBindToEnum(codegenContext.valueSetMap)
    val isRequired = element.min == 1 && element.max == "1"
    val wireClassName: ClassName = fhirPathType.getWireType(modelClassName.packageName)
    val valueIdx = nameToIdx.getValue(propertyName)
    val elementIdx = nameToIdx.getValue("_$propertyName")
    val valueType: ClassName = if (isEnum) String::class.asClassName() else wireClassName
    val valueExpr =
      CodeBlock.builder()
        .apply {
          if (isEnum) {
            if (element.isExtensibleBinding) {
              add(
                if (isRequired) "value.%N.code" else "value.%N?.code",
                propertyName,
              )
            } else {
              add(
                if (isRequired) "value.%N.value?.code" else "value.%N?.value?.code",
                propertyName,
              )
            }
          } else {
            add("value.%N", propertyName)
            if (!isRequired) add("?")
            fhirPathType.addCodeToEncodeModelToWire(this)
          }
        }
        .build()
    // The wire-encoded value is non-null only when the wrapper itself is required AND either its
    // `.value` field is non-null on the model side (true for primitives whose StructureDefinition
    // has `<Type>.value` with `min > 0`, atm only `xhtml`) or it is an `ExtensibleEnumeration`
    // (whose `.code` property is non-null).
    val wireIsNonNull =
      (codegenContext.primitiveValueIsNonNull[typeCode] == true && !isEnum) ||
        (isEnum && element.isExtensibleBinding)
    emitPrimitiveOrSerializableEncode(
      codeBlock,
      recv,
      valueIdx,
      valueType,
      valueExpr,
      modelClassName,
      nullable = !(isRequired && wireIsNonNull),
    )
    codeBlock.add(
      "${recv}encodeElementIfNotNull(descriptor, %L, value.%N)\n",
      elementIdx,
      propertyName,
    )
  }

  private fun emitJsonEncodePrimitiveList(
    codeBlock: CodeBlock.Builder,
    element: Element,
    propertyName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    recv: String,
  ) {
    val typeCode = element.type!!.single().code
    val fhirPathType = FhirPathType.getFromFhirTypeCode(typeCode)!!
    val isEnum = element.typeShouldBindToEnum(codegenContext.valueSetMap)
    val wireClassName: ClassName = fhirPathType.getWireType(modelClassName.packageName)
    val valueIdx = nameToIdx.getValue(propertyName)
    val elementIdx = nameToIdx.getValue("_$propertyName")
    val valueInnerType: ClassName = if (isEnum) String::class.asClassName() else wireClassName
    val valueListSer =
      listSerializerRefForClass(valueInnerType, modelClassName, nullableElement = true)
    codeBlock.add("if (value.%N.isNotEmpty()) {\n", propertyName)
    codeBlock.indent()
    // values
    codeBlock.add(
      "${recv}encodeNullableListIfNotNull(descriptor, %L, %L, value.%N.map·{·",
      valueIdx,
      valueListSer,
      propertyName,
    )
    if (isEnum) {
      if (element.isExtensibleBinding) {
        codeBlock.add("it.code")
      } else {
        codeBlock.add("it.value?.code")
      }
    } else {
      codeBlock.add("it")
      fhirPathType.addCodeToEncodeModelToWire(codeBlock)
    }
    codeBlock.add("·})\n")
    // element (_field) lists
    codeBlock.add(
      "${recv}encodePrimitiveElementList(descriptor, %L, value.%N)\n",
      elementIdx,
      propertyName,
    )
    codeBlock.unindent()
    codeBlock.add("}\n")
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

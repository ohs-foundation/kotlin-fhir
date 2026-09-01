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

package dev.ohs.fhir.codegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import dev.ohs.fhir.codegen.primitives.FhirPathType
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.Type
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getBindingValueSetUrl
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.getPathSimpleNames
import dev.ohs.fhir.codegen.schema.isCommonBinding
import dev.ohs.fhir.codegen.schema.normalizeEnumName
import dev.ohs.fhir.codegen.schema.typeShouldBindToEnum
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/**
 * Model-construction helpers shared by [SerializerFileSpecGenerator]. Emits the per-field
 * expressions that reconstruct a model-class constructor argument from decoded JSON locals.
 */
class ModelConstructionHelpers(val codegenContext: CodegenContext) {

  private val serializationExceptionClassName =
    ClassName("kotlinx.serialization", "SerializationException")

  /** Emit the model-class constructor argument for [element]. */
  internal fun CodeBlock.Builder.addParamToModelClassConstructor(
    modelClassName: ClassName,
    element: Element,
    expandPolymorphicProperties: Boolean,
  ) {
    val propertyName = element.getElementName()
    val elementPropertyName = "_$propertyName"
    val modelDisplayName = modelClassName.simpleNames.joinToString(".")
    if (element.type != null && element.type.size > 1) {
      if (expandPolymorphicProperties) {
        val factoryClassName =
          if (element.path.endsWith("[x]")) {
            ClassName(modelClassName.packageName, element.getPathSimpleNames())
          } else {
            modelClassName
          }
        add("%T.from(", factoryClassName)
        for (type in element.type) {
          addChoiceTypeParamToModelClassConstructor(modelClassName, element, type)
          add(", ")
        }
        add(")")
        if (element.min == 1) {
          add(
            " ?: throw %T(%S)",
            serializationExceptionClassName,
            "Missing required property '$propertyName' on $modelDisplayName",
          )
        }
      } else {
        add("%N", propertyName)
        if (element.min == 1) {
          add(
            " ?: throw %T(%S)",
            serializationExceptionClassName,
            "Missing required property '$propertyName' on $modelDisplayName",
          )
        }
      }
    } else if ((element.max == "*" || propertyName == "extension")) {
      if (FhirPathType.containsFhirTypeCode(element.type?.singleOrNull()?.code ?: "")) {
        val fhirPathType = FhirPathType.getFromFhirTypeCode(element.type?.singleOrNull()?.code!!)!!
        if (element.typeShouldBindToEnum(codegenContext.valueSetMap)) {
          val enumClass = element.getEnumClass(modelClassName, codegenContext.valueSetMap)
          add(
            "(kotlin.collections.List(maxOf(%N?.size ?: 0, %N?.size ?: 0)) { index ->\n",
            propertyName,
            elementPropertyName,
          )
          add(
            "  %T.of(%N?.getOrNull(index)?.let·{ %T.fromCode(it) }, %N?.getOrNull(index))!!\n",
            ClassName(modelClassName.packageName, "Enumeration"),
            propertyName,
            enumClass,
            elementPropertyName,
          )
          add("})")
        } else {
          add(
            "(kotlin.collections.List(maxOf(%N?.size ?: 0, %N?.size ?: 0)) { index ->\n",
            propertyName,
            elementPropertyName,
          )
          add(
            "  %T.of(%N?.getOrNull(index)?.let·{ ",
            ClassName(modelClassName.packageName, element.type.single().code.capitalized()),
            propertyName,
          )
          fhirPathType.addCodeToDecodeWireVarToModel(this, modelClassName.packageName, "it")
          add(" }, %N?.getOrNull(index))!!\n", elementPropertyName)
          add("})")
        }
      } else {
        add("%N ?: listOf()", propertyName)
      }
    } else {
      addPrimitiveOrSimpleParam(
        modelClassName,
        codegenContext.valueSetMap,
        propertyName,
        element.type?.singleOrNull(),
        element,
      )
    }
  }

  private fun CodeBlock.Builder.addPrimitiveOrSimpleParam(
    modelClassName: ClassName,
    valueSetMap: Map<String, ValueSet>,
    propertyName: String,
    type: Type?,
    element: Element,
  ) {
    val elementPropertyName = "_$propertyName"
    val modelDisplayName = modelClassName.simpleNames.joinToString(".")
    if (element.typeShouldBindToEnum(valueSetMap)) {
      val enumClass = element.getEnumClass(modelClassName, valueSetMap)
      if (element.min == 0) {
        add(
          "%T.of(%N?.let·{ %T.fromCode(it) }, %N)",
          ClassName(modelClassName.packageName, "Enumeration"),
          propertyName,
          enumClass,
          elementPropertyName,
        )
      } else {
        add(
          "%T.of(%N?.let·{ %T.fromCode(it) }, %N) ?: throw %T(%S)",
          ClassName(modelClassName.packageName, "Enumeration"),
          propertyName,
          enumClass,
          elementPropertyName,
          serializationExceptionClassName,
          "Missing required property '$propertyName' on $modelDisplayName",
        )
      }
    } else if (type != null && FhirPathType.containsFhirTypeCode(type.code)) {
      val fhirPathType = FhirPathType.getFromFhirTypeCode(type.code)!!
      // Primitives whose StructureDefinition declares `<Type>.value` with `min > 0` have a
      // non-null `.value` field on the wrapper, so the wire value must be coerced non-null at the
      // call site. `Type.of(...)` then returns non-null, making any outer `!!` redundant.
      val wireValueIsNonNull = codegenContext.primitiveValueIsNonNull[type.code] == true
      val coerceWireValue = if (wireValueIsNonNull) "!!" else ""
      add("%T.of(", ClassName(modelClassName.packageName, type.code.capitalized()))
      fhirPathType.addCodeToDecodeWirePropertyToModel(
        this,
        modelClassName.packageName,
        propertyName,
      )
      add(coerceWireValue)
      add(", %N)", elementPropertyName)
      if (element.min == 1 && !wireValueIsNonNull) {
        add(
          " ?: throw %T(%S)",
          serializationExceptionClassName,
          "Missing required property '$propertyName' on $modelDisplayName",
        )
      }
    } else {
      add("%N", propertyName)
      if (element.min == 1 && element.max == "1") {
        add(
          " ?: throw %T(%S)",
          serializationExceptionClassName,
          "Missing required property '$propertyName' on $modelDisplayName",
        )
      }
    }
  }

  private fun Element.getEnumClass(
    modelClassName: ClassName,
    valueSetMap: Map<String, ValueSet>,
  ): ClassName {
    val elementBasePath: String? = base?.path
    val valueSetName = valueSetMap.getValue(getBindingValueSetUrl()!!).name.normalizeEnumName()
    return when {
      this.isCommonBinding -> ClassName("${modelClassName.packageName}.terminologies", valueSetName)
      !elementBasePath.isNullOrBlank() && path != elementBasePath -> {
        ClassName(modelClassName.packageName, elementBasePath.substringBefore("."))
          .nestedClass(valueSetName)
      }
      else -> {
        ClassName(modelClassName.packageName, modelClassName.simpleNames.first())
          .nestedClass(valueSetName)
      }
    }
  }

  private fun CodeBlock.Builder.addChoiceTypeParamToModelClassConstructor(
    modelClassName: ClassName,
    element: Element,
    type: Type,
  ) {
    val propertyName = "${element.getElementName()}${type.code.capitalized()}"
    val elementPropertyName = "_$propertyName"
    if (FhirPathType.containsFhirTypeCode(type.code)) {
      val fhirPathType = FhirPathType.getFromFhirTypeCode(type.code)!!
      add("%T.of(", ClassName(modelClassName.packageName, type.code.capitalized()))
      fhirPathType.addCodeToDecodeWirePropertyToModel(
        this,
        modelClassName.packageName,
        propertyName,
      )
      add(", %N)", elementPropertyName)
    } else {
      add("%N", propertyName)
    }
  }
}

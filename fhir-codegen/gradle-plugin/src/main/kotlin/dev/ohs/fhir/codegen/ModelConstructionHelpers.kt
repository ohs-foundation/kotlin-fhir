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
import com.squareup.kotlinpoet.MemberName
import dev.ohs.fhir.codegen.primitives.FhirPathType
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.Type
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.enumName
import dev.ohs.fhir.codegen.schema.getBindingValueSetUrl
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.getPathSimpleNames
import dev.ohs.fhir.codegen.schema.isExtensibleBinding
import dev.ohs.fhir.codegen.schema.typeShouldBindToEnum
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/**
 * Emits the `return Model(...)` argument list of a generated `deserialize` from the per-field
 * locals populated by the decode loop.
 *
 * Every argument expression is **branch-free**: null-coalescing, required-property checks and
 * wire→model conversions go through small non-inline helpers (`listOrEmpty`, `required`,
 * `entryRequired`, `at`, `maxSize` in the generated `SerializerHelpers.kt`) or happen earlier in
 * the decode `when`. A branch evaluated while earlier constructor arguments already sit on the JVM
 * operand stack forces a `full_frame` stack-map entry listing every local of the (often huge)
 * deserialize method; with hundreds of locals those frames outweighed the bytecode itself.
 * Repeating primitives, whose merge needs a loop, are hoisted into locals via [preamble] for the
 * same reason.
 */
class ModelConstructionHelpers(val codegenContext: CodegenContext) {

  /**
   * Emit the model-class constructor argument for [element]. Statements that must run before the
   * constructor call (merged repeating-primitive lists) are appended to [preamble].
   */
  internal fun CodeBlock.Builder.addParamToModelClassConstructor(
    modelClassName: ClassName,
    element: Element,
    expandPolymorphicProperties: Boolean,
    preamble: CodeBlock.Builder,
  ) {
    val propertyName = element.getElementName()
    val elementPropertyName = "_$propertyName"
    val modelDisplayName = modelClassName.simpleNames.joinToString(".")
    val required = CodeBlock.of("%M", helperMember(modelClassName, "required"))
    if (element.type != null && element.type.size > 1) {
      if (element.min == 1) add("%L(", required)
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
      } else {
        add("%N", propertyName)
      }
      if (element.min == 1) add(", %S, %S)", modelDisplayName, propertyName)
    } else if ((element.max == "*" || propertyName == "extension")) {
      if (FhirPathType.containsFhirTypeCode(element.type?.singleOrNull()?.code ?: "")) {
        val fhirPathType = FhirPathType.getFromFhirTypeCode(element.type?.singleOrNull()?.code!!)!!
        // Merge the value list and the `_field` list index-by-index. Hoisted into a local so the
        // loop (and its branches) run with an empty operand stack.
        val mergedName = "${propertyName}_"
        val at = CodeBlock.of("%M", helperMember(modelClassName, "at"))
        val valueAt = CodeBlock.of("%L(%N, index)", at, propertyName)
        val elementAt = CodeBlock.of("%L(%N, index)", at, elementPropertyName)
        preamble.add(
          "val %N = %T(%M(%N, %N)) { index ->\n",
          mergedName,
          ClassName("kotlin.collections", "List"),
          helperMember(modelClassName, "maxSize"),
          propertyName,
          elementPropertyName,
        )
        preamble.indent()
        preamble.add("%M(", helperMember(modelClassName, "entryRequired"))
        if (element.typeShouldBindToEnum(codegenContext.valueSetMap)) {
          val enumClass = element.getEnumClass(modelClassName, codegenContext.valueSetMap)
          val wrapperClass =
            ClassName(
              modelClassName.packageName,
              if (element.isExtensibleBinding) "ExtensibleEnumeration" else "Enumeration",
            )
          if (element.isExtensibleBinding) {
            preamble.add("%T.of<%T>(%L, %L)", wrapperClass, enumClass, valueAt, elementAt)
          } else {
            preamble.add(
              "%T.of(%L?.let·{ %T.fromCode(it) }, %L)",
              wrapperClass,
              valueAt,
              enumClass,
              elementAt,
            )
          }
        } else {
          preamble.add(
            "%T.of(",
            ClassName(modelClassName.packageName, element.type.single().code.capitalized()),
          )
          fhirPathType.addCodeToDecodeWireVarToModel(
            preamble,
            modelClassName.packageName,
            valueAt,
          )
          preamble.add(", %L)", elementAt)
        }
        preamble.add(", %S, %S)\n", modelDisplayName, propertyName)
        preamble.unindent()
        preamble.add("}\n")
        add("%N", mergedName)
      } else {
        add("%M(%N)", helperMember(modelClassName, "listOrEmpty"), propertyName)
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

  private fun helperMember(modelClassName: ClassName, name: String) =
    MemberName("${modelClassName.packageName}.serializers", name)

  private fun CodeBlock.Builder.addPrimitiveOrSimpleParam(
    modelClassName: ClassName,
    valueSetMap: Map<String, ValueSet>,
    propertyName: String,
    type: Type?,
    element: Element,
  ) {
    val elementPropertyName = "_$propertyName"
    val modelDisplayName = modelClassName.simpleNames.joinToString(".")
    val required = CodeBlock.of("%M", helperMember(modelClassName, "required"))
    val requiredTail = CodeBlock.of(", %S, %S)", modelDisplayName, propertyName)
    if (element.typeShouldBindToEnum(valueSetMap)) {
      val enumClass = element.getEnumClass(modelClassName, valueSetMap)
      val wrapperClass =
        ClassName(
          modelClassName.packageName,
          if (element.isExtensibleBinding) "ExtensibleEnumeration" else "Enumeration",
        )
      if (element.min == 1) add("%L(", required)
      if (element.isExtensibleBinding) {
        add("%T.of<%T>(%N, %N)", wrapperClass, enumClass, propertyName, elementPropertyName)
      } else {
        // The local is already decoded to the enum (`XEnum.fromCode(...)` in the decode loop).
        add("%T.of(%N, %N)", wrapperClass, propertyName, elementPropertyName)
      }
      if (element.min == 1) add(requiredTail)
    } else if (type != null && FhirPathType.containsFhirTypeCode(type.code)) {
      val fhirPathType = FhirPathType.getFromFhirTypeCode(type.code)!!
      // Primitives whose StructureDefinition declares `<Type>.value` with `min > 0` have a
      // non-null `.value` field on the wrapper, so the wire value must be coerced non-null at the
      // call site. `Type.of(...)` then returns non-null, making any outer check redundant.
      val wireValueIsNonNull = codegenContext.primitiveValueIsNonNull[type.code] == true
      if (element.min == 1 && !wireValueIsNonNull) add("%L(", required)
      add("%T.of(", ClassName(modelClassName.packageName, type.code.capitalized()))
      if (wireValueIsNonNull) add("%L(", required)
      fhirPathType.addCodeToDecodeWirePropertyToModel(
        this,
        modelClassName.packageName,
        propertyName,
      )
      if (wireValueIsNonNull) add(requiredTail)
      add(", %N)", elementPropertyName)
      if (element.min == 1 && !wireValueIsNonNull) add(requiredTail)
    } else {
      if (element.min == 1 && element.max == "1") {
        add("%L(%N%L", required, propertyName, requiredTail)
      } else {
        add("%N", propertyName)
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

/** Enum class generated for [this] element's required/extensible value-set binding. */
internal fun Element.getEnumClass(
  modelClassName: ClassName,
  valueSetMap: Map<String, ValueSet>,
): ClassName =
  ClassName(
    "${modelClassName.packageName}.terminologies",
    valueSetMap.getValue(getBindingValueSetUrl()!!).enumName,
  )

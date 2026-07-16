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
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import dev.ohs.fhir.codegen.primitives.FhirPathType
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.rootElements
import dev.ohs.fhir.codegen.schema.sanitizeKDoc
import dev.ohs.fhir.codegen.schema.typeIsEnumeratedCode
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/**
 * The list of classes without generated builder.
 *
 * Note this is a list of classes from different FHIR versions, e.g., DataType exists in R5 but not
 * in R4 or R4B.
 */
private val builderExclusionList =
  setOf("Base", "Element", "BackboneElement", "DataType", "BackboneType", "PrimitiveType")

/**
 * Adds a nested `Builder` class and `toBuilder` function to the model class in [TypeSpec.Builder].
 */
internal fun TypeSpec.Builder.addModelBuilderSupport(
  structureDefinition: StructureDefinition,
  modelClassName: ClassName,
  valueSetMap: Map<String, ValueSet>,
  isBaseClass: Boolean,
): TypeSpec.Builder {
  BuilderSupportGenerator(this, structureDefinition, modelClassName, valueSetMap, isBaseClass)
    .addResourceBuilderSupport()
  return this
}

/**
 * Adds a nested `Builder` class and `toBuilder` function to the backbone element in
 * [TypeSpec.Builder].
 */
internal fun TypeSpec.Builder.addBackboneElementBuilderSupport(
  structureDefinition: StructureDefinition,
  backboneElementClassName: ClassName,
  valueSetMap: Map<String, ValueSet>,
  elements: List<Element>,
): TypeSpec.Builder {
  // Backbone elements are leaf types — no subclasses, so the toBuilder method is never open.
  BuilderSupportGenerator(
      this,
      structureDefinition,
      backboneElementClassName,
      valueSetMap,
      isBaseClass = false,
    )
    .addBackboneElementBuilderSupport(elements)
  return this
}

private class BuilderSupportGenerator(
  val typeSpecBuilder: TypeSpec.Builder,
  val structureDefinition: StructureDefinition,
  val baseClassName: ClassName,
  val valueSetMap: Map<String, ValueSet>,
  val isBaseClass: Boolean,
) {
  fun addResourceBuilderSupport() {
    when (structureDefinition.kind) {
      StructureDefinition.Kind.RESOURCE -> {
        when (structureDefinition.name) {
          "Resource" -> {
            addBuilderForResource()
            addToBuilderFunctionForResource()
          }
          "DomainResource" -> {
            addBuilderForDomainResource()
            addToBuilderFunctionForDomainResource()
          }
          else -> {
            // Resource classes
            addBuilderClass(
              structureDefinition.rootElements,
              overrideBaseBuilder = true,
              overrideBaseProperties = false,
              open = false,
            )
            addToBuilderFunction(
              structureDefinition.rootElements,
              overrideBaseFunction = true,
              open = false,
            )
          }
        }
      }
      StructureDefinition.Kind.PRIMITIVE_TYPE,
      StructureDefinition.Kind.COMPLEX_TYPE -> {
        if (structureDefinition.name !in builderExclusionList) {
          when {
            structureDefinition.baseDefinition?.endsWith("Element") == true ||
              structureDefinition.baseDefinition?.endsWith("DataType") == true ||
              structureDefinition.baseDefinition?.endsWith("PrimitiveType") == true ||
              structureDefinition.baseDefinition?.endsWith("BackboneType") == true -> {
              // Builders for base types, namely types that directly inherit from Element (for
              // R4 and R4B) or DataType (for R5), do not have base builders.
              addBuilderClass(
                structureDefinition.rootElements,
                overrideBaseBuilder = false,
                overrideBaseProperties = false,
                open = true,
              )
              addToBuilderFunction(
                structureDefinition.rootElements,
                overrideBaseFunction = false,
                open = isBaseClass,
              )
            }

            else -> {
              addBuilderClass(
                structureDefinition.rootElements,
                overrideBaseBuilder = true,
                overrideBaseProperties = true,
                // Builder class stays open for simplicity (matches the historical pattern); the
                // toBuilder fun is only marked open when this class actually has subclasses.
                open = true,
              )
              addToBuilderFunction(
                structureDefinition.rootElements,
                overrideBaseFunction = true,
                open = isBaseClass,
              )
            }
          }
        }
      }

      else -> Unit // Do nothing
    }
  }

  fun addBackboneElementBuilderSupport(elements: List<Element>) {
    addBuilderClass(
      elements,
      overrideBaseBuilder = false,
      overrideBaseProperties = false,
      open = false,
    )
    addToBuilderFunction(elements, overrideBaseFunction = false, open = false)
  }

  private fun addBuilderForResource() {
    val builder = TypeSpec.classBuilder("Builder").addModifiers(KModifier.ABSTRACT)
    // Expose `id` as a settable, polymorphic property on the abstract base builder so callers can
    // set it without knowing the concrete resource type (e.g. `resource.toBuilder().apply { id =
    // … }.build()`). Concrete builders already back this field; they override it (see
    // `overridesResourceId` in addBuilderClass).
    structureDefinition.rootElements
      .firstOrNull { it.getElementName() == "id" }
      ?.let { idElement ->
        val propertyInfo =
          PropertyMapper(PropertyMapper.MappingContext.BUILDER, baseClassName, valueSetMap)
            .mapToProperty(idElement)
        // No KDoc copied from the spec here: the spec text says the id "never changes", which is
        // true of the immutable resource but contradicts this settable builder property.
        builder.addProperty(
          PropertySpec.builder(propertyInfo.name, propertyInfo.typeName)
            .mutable()
            .addModifiers(KModifier.ABSTRACT)
            .build()
        )
      }
    typeSpecBuilder.addType(
      builder
        .addFunction(
          FunSpec.builder("build").returns(baseClassName).addModifiers(KModifier.ABSTRACT).build()
        )
        .build()
    )
  }

  private fun addToBuilderFunctionForResource() {
    typeSpecBuilder.addFunction(
      FunSpec.builder("toBuilder")
        .addModifiers(KModifier.ABSTRACT)
        .returns(baseClassName.nestedClass("Builder"))
        .build()
    )
  }

  private fun addToBuilderFunctionForDomainResource() {
    typeSpecBuilder.addFunction(
      FunSpec.builder("toBuilder")
        .addModifiers(KModifier.ABSTRACT, KModifier.OVERRIDE)
        .returns(baseClassName.nestedClass("Builder"))
        .build()
    )
  }

  private fun addBuilderForDomainResource() {
    typeSpecBuilder.addType(
      TypeSpec.classBuilder("Builder")
        .addModifiers(KModifier.ABSTRACT)
        .superclass(ClassName(baseClassName.packageName, "Resource").nestedClass("Builder"))
        .build()
    )
  }

  private fun addBuilderClass(
    elements: List<Element>,
    overrideBaseBuilder: Boolean,
    overrideBaseProperties: Boolean,
    open: Boolean,
  ) =
    typeSpecBuilder.addType(
      TypeSpec.classBuilder(baseClassName.nestedClass("Builder"))
        .apply {
          if (overrideBaseBuilder) {
            structureDefinition.baseDefinition?.substringAfterLast('/')?.capitalized()?.also {
              superclass(ClassName(baseClassName.packageName, it).nestedClass("Builder"))
            }
          }
          if (open) {
            addModifiers(KModifier.OPEN)
          }
          buildBuilderProperties(
            this@apply,
            elements,
            override = overrideBaseProperties,
            open = open,
            overridesResourceId =
              overrideBaseBuilder && structureDefinition.kind == StructureDefinition.Kind.RESOURCE,
          )
        }
        .addFunction(
          FunSpec.builder("build")
            .apply {
              val modifiers = buildList {
                if (overrideBaseBuilder) add(KModifier.OVERRIDE)
                if (open) add(KModifier.OPEN)
              }
              if (modifiers.isNotEmpty()) addModifiers(modifiers)
            }
            .returns(baseClassName)
            .addCode(
              CodeBlock.builder()
                .add("return %T(", baseClassName)
                .indent()
                .apply {
                  for (element in elements) {
                    val name = element.getElementName()
                    if (element.typeIsEnumeratedCode(valueSetMap)) {
                      addStatement("%N = %N,", name, name)
                      continue
                    }
                    if ((element.type?.size ?: 0) > 1) {
                      // Sealed interface
                      addStatement("%N = %N,", name, name)
                      continue
                    }
                    if (element.type?.singleOrNull()?.code in FhirPathType.getUris()) {
                      // Base types
                      addStatement("%N = %N,", name, name)
                      continue
                    }
                    if (element.max == "*" || element.getElementName() == "extension") {
                      addStatement("%N = %N.map { it.build() },", name, name)
                    } else if (element.min == 0) {
                      addStatement("%N = %N?.build(),", name, name)
                    } else {
                      addStatement("%N = %N.build(),", name, name)
                    }
                  }
                }
                .unindent()
                .add(")")
                .build()
            )
            .build()
        )
        .build()
    )

  /**
   * Builds properties from [elements] for the builder class in [builderTypeSpecBuilder], marking
   * them as [override] and [open] as appropriate.
   */
  private fun buildBuilderProperties(
    builderTypeSpecBuilder: TypeSpec.Builder,
    elements: List<Element>,
    override: Boolean,
    open: Boolean,
    overridesResourceId: Boolean,
  ) {
    val propertyMapper =
      PropertyMapper(PropertyMapper.MappingContext.BUILDER, baseClassName, valueSetMap)
    val constructorBuilder = FunSpec.constructorBuilder()
    elements.forEach { element ->
      val propertyInfo = propertyMapper.mapToProperty(element)
      // Concrete resource builders inherit an abstract `id` from Resource.Builder, so their backing
      // `id` property overrides it. (`path != base.path` confirms `id` is inherited, never declared
      // locally.)
      val isInheritedResourceId =
        overridesResourceId &&
          element.getElementName() == "id" &&
          element.path != element.base?.path
      val property =
        PropertySpec.builder(propertyInfo.name, propertyInfo.typeName)
          .mutable()
          .apply {
            initializer(propertyInfo.defaultValue ?: propertyInfo.name)
            val modifiers = buildList {
              if (override || isInheritedResourceId) add(KModifier.OVERRIDE)
              if (open) add(KModifier.OPEN)
            }
            if (modifiers.isNotEmpty()) addModifiers(modifiers)
            addKdoc("%L", element.definition.sanitizeKDoc())
            element.comment?.let { addKdoc("\n\n%L", it.sanitizeKDoc()) }
          }
          .build()
      builderTypeSpecBuilder.addProperty(property)
      if (element.min != 0) {
        constructorBuilder.addParameter(
          ParameterSpec.builder(name = propertyInfo.name, type = propertyInfo.typeName).build()
        )
      }
    }
    builderTypeSpecBuilder.primaryConstructor(constructorBuilder.build())
  }

  private fun addToBuilderFunction(
    elements: List<Element>,
    overrideBaseFunction: Boolean,
    open: Boolean,
  ) {
    val builderClassName = baseClassName.nestedClass("Builder")
    typeSpecBuilder.addFunction(
      FunSpec.builder("toBuilder")
        .apply {
          val modifiers = buildList {
            if (overrideBaseFunction) add(KModifier.OVERRIDE)
            if (open) add(KModifier.OPEN)
          }
          if (modifiers.isNotEmpty()) addModifiers(modifiers)
        }
        .returns(builderClassName)
        .addCode(
          CodeBlock.builder()
            .add("return with(this) {")
            .indent()
            .add("%T(", builderClassName)
            .apply {
              elements
                .filter { it.min != 0 }
                .forEach {
                  if (it.type?.singleOrNull()?.code in FhirPathType.getUris()) {
                    add("%N,", it.getElementName())
                  } else if (it.typeIsEnumeratedCode(valueSetMap)) {
                    if (it.max == "*") {
                      addStatement("%N.toMutableList(),", it.getElementName())
                    } else {
                      addStatement("%N,", it.getElementName())
                    }
                  } else if ((it.type?.size ?: 0) > 1) {
                    addStatement("%N,", it.getElementName())
                  } else if (it.max == "*" || it.getElementName() == "extension") {
                    // Handle the extension field in XHTML
                    addStatement("%N.map { it.toBuilder() }.toMutableList(),", it.getElementName())
                  } else if (it.min == 0) {
                    add("%N?.toBuilder(),", it.getElementName())
                  } else {
                    add("%N.toBuilder(),", it.getElementName())
                  }
                }
            }
            .add(").apply{")
            .indent()
            .apply {
              elements
                .filter { it.min == 0 }
                .forEach {
                  val name = it.getElementName()
                  if (it.typeIsEnumeratedCode(valueSetMap)) {
                    if (it.max == "*") {
                      addStatement("%N = this@with.%N.toMutableList()", name, name)
                    } else {
                      addStatement("%N = this@with.%N", name, name)
                    }
                    return@forEach
                  }
                  if ((it.type?.size ?: 0) > 1) {
                    // Sealed interface
                    addStatement("%N = this@with.%N", name, name)
                    return@forEach
                  }
                  if (it.type?.singleOrNull()?.code in FhirPathType.getUris()) {
                    addStatement("%N = this@with.%N", name, name)
                    return@forEach
                  }
                  if (it.max == "*" || name == "extension") {
                    // Handle the extension field in XHTML
                    addStatement(
                      "%N = this@with.%N.map { it.toBuilder() }.toMutableList()",
                      name,
                      name,
                    )
                  } else if (it.min == 0) {
                    addStatement("%N = this@with.%N?.toBuilder()", name, name)
                  } else {
                    addStatement("%N = this@with.%N.toBuilder()", name, name)
                  }
                }
            }
            .unindent()
            .add("}")
            .unindent()
            .add("}")
            .build()
        )
        .build()
    )
  }
}

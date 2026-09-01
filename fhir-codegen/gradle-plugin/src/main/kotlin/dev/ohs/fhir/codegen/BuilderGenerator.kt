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
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeSpec
import dev.ohs.fhir.codegen.primitives.FhirPathType
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.rootElements
import dev.ohs.fhir.codegen.schema.sanitizeKDoc
import dev.ohs.fhir.codegen.schema.typeShouldBindToEnum
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
internal fun TypeSpec.Builder.addModelBuilder(
  structureDefinition: StructureDefinition,
  modelClassName: ClassName,
  valueSetMap: Map<String, ValueSet>,
  isBaseClass: Boolean,
): TypeSpec.Builder {
  BuilderGenerator(this, structureDefinition, modelClassName, valueSetMap, isBaseClass)
    .generateForModel()
  return this
}

/**
 * Adds a nested `Builder` class and `toBuilder` function to the backbone element in
 * [TypeSpec.Builder].
 */
internal fun TypeSpec.Builder.addBackboneElementBuilder(
  structureDefinition: StructureDefinition,
  backboneElementClassName: ClassName,
  valueSetMap: Map<String, ValueSet>,
  elements: List<Element>,
): TypeSpec.Builder {
  // Backbone elements are leaf types — no subclasses, so the toBuilder method is never open.
  BuilderGenerator(
      this,
      structureDefinition,
      backboneElementClassName,
      valueSetMap,
      isBaseClass = false,
    )
    .generateForBackboneElement(elements)
  return this
}

private class BuilderGenerator(
  private val typeSpecBuilder: TypeSpec.Builder,
  private val structureDefinition: StructureDefinition,
  private val baseClassName: ClassName,
  private val valueSetMap: Map<String, ValueSet>,
  private val isBaseClass: Boolean,
) {
  private enum class Kind(
    val overridesBaseBuilder: Boolean,
    val overridesBaseProperties: Boolean,
    val isOpen: Boolean,
  ) {
    RESOURCE(
      overridesBaseBuilder = true,
      overridesBaseProperties = false,
      isOpen = false,
    ),
    BASE_TYPE(
      overridesBaseBuilder = false,
      overridesBaseProperties = false,
      isOpen = true,
    ),
    DERIVED_TYPE(
      overridesBaseBuilder = true,
      overridesBaseProperties = true,
      isOpen = true,
    ),
    BACKBONE_ELEMENT(
      overridesBaseBuilder = false,
      overridesBaseProperties = false,
      isOpen = false,
    ),
  }

  /** Generates builder support for top-level models (Resources, DataTypes, Primitives). */
  fun generateForModel() {
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
          else -> generate(structureDefinition.rootElements, Kind.RESOURCE)
        }
      }
      StructureDefinition.Kind.PRIMITIVE_TYPE,
      StructureDefinition.Kind.COMPLEX_TYPE -> {
        if (structureDefinition.name !in builderExclusionList) {
          val kind = if (isBaseType(structureDefinition)) Kind.BASE_TYPE else Kind.DERIVED_TYPE
          generate(structureDefinition.rootElements, kind)
        }
      }

      else -> Unit // Do nothing
    }
  }

  /** Generates builder support for nested backbone elements. */
  fun generateForBackboneElement(elements: List<Element>) {
    generate(elements, Kind.BACKBONE_ELEMENT)
  }

  /** Core generation pipeline: adds the nested `Builder` class and the `toBuilder()` method. */
  private fun generate(elements: List<Element>, kind: Kind) {
    addBuilderClass(elements, kind)
    addToBuilderFunction(elements, kind)
  }

  private fun isBaseType(structureDefinition: StructureDefinition): Boolean {
    val base = structureDefinition.baseDefinition ?: return false
    return base.endsWith("Element") ||
      base.endsWith("DataType") ||
      base.endsWith("PrimitiveType") ||
      base.endsWith("BackboneType")
  }

  private fun addBuilderForResource() {
    typeSpecBuilder.addType(
      TypeSpec.classBuilder("Builder")
        .addModifiers(KModifier.ABSTRACT)
        // Lets callers set an id on any resource without knowing its concrete type; concrete
        // builders override this property. KDoc is not generated from the element comment since
        // the generated code allows setting the id.
        .addProperty(
          PropertySpec.builder("id", STRING.copy(nullable = true))
            .mutable()
            .addModifiers(KModifier.ABSTRACT)
            .build()
        )
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

  private fun addBuilderClass(elements: List<Element>, kind: Kind) =
    typeSpecBuilder.addType(
      TypeSpec.classBuilder(baseClassName.nestedClass("Builder"))
        .apply {
          if (kind.overridesBaseBuilder) {
            structureDefinition.baseDefinition?.substringAfterLast('/')?.capitalized()?.also {
              superclass(ClassName(baseClassName.packageName, it).nestedClass("Builder"))
            }
          }
          if (kind.isOpen) {
            addModifiers(KModifier.OPEN)
          }
          buildBuilderProperties(
            this@apply,
            elements,
            override = kind.overridesBaseProperties,
            open = kind.isOpen,
            overridesResourceId = kind == Kind.RESOURCE,
          )
        }
        .addFunction(
          FunSpec.builder("build")
            .apply {
              val modifiers = buildList {
                if (kind.overridesBaseBuilder) add(KModifier.OVERRIDE)
                if (kind.isOpen) add(KModifier.OPEN)
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
                    if (element.typeShouldBindToEnum(valueSetMap)) {
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
      // Concrete resource builders override the abstract `id` declared on Resource.Builder.
      val isInheritedResourceId = overridesResourceId && element.getElementName() == "id"
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

  private fun addToBuilderFunction(elements: List<Element>, kind: Kind) {
    val builderClassName = baseClassName.nestedClass("Builder")
    typeSpecBuilder.addFunction(
      FunSpec.builder("toBuilder")
        .apply {
          val modifiers = buildList {
            if (kind.overridesBaseBuilder) add(KModifier.OVERRIDE)
            if (kind.isOpen && isBaseClass) add(KModifier.OPEN)
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
                  } else if (it.typeShouldBindToEnum(valueSetMap)) {
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
                  if (it.typeShouldBindToEnum(valueSetMap)) {
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

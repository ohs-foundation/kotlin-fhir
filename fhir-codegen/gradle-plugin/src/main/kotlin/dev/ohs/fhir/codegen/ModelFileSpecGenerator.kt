/*
 * Copyright 2025-2026 Google LLC
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

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.Type
import dev.ohs.fhir.codegen.schema.backboneElements
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getBindingValueSetUrl
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.hasPrimaryConstructor
import dev.ohs.fhir.codegen.schema.isCommonBinding
import dev.ohs.fhir.codegen.schema.normalizeEnumName
import dev.ohs.fhir.codegen.schema.rootElements
import dev.ohs.fhir.codegen.schema.sanitizeKDoc
import dev.ohs.fhir.codegen.schema.serializableWithCustomSerializer
import dev.ohs.fhir.codegen.schema.typeIsEnumeratedCode
import dev.ohs.fhir.codegen.schema.valueset.ValueSet
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Generates a [FileSpec] for a model class. */
class ModelFileSpecGenerator(val codegenContext: CodegenContext) {

  fun generate(structureDefinition: StructureDefinition): FileSpec {
    // Nested enums are all created inside the enclosing parent class for reusability
    val enumClassesMap = mutableMapOf<String, TypeSpec>()
    val modelClassName = codegenContext.getModelClassName(structureDefinition)
    val typeSpec =
      TypeSpec.classBuilder(modelClassName)
        .apply {
          val structureDefinitionName = structureDefinition.name
          val isBaseClass = codegenContext.isBaseClass(structureDefinition)
          if (
            structureDefinitionName == "Resource" || structureDefinitionName == "DomainResource"
          ) {
            // We use open polymorphism to allow for runtime decision on which concrete class to
            // instantiate. So instead of sealing the `Resource` class and `DomainResource` class,
            // we keep them abstract.
            // See
            // https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/polymorphism.md#open-polymorphism
            addModifiers(KModifier.ABSTRACT)
          } else if (structureDefinition.abstract) {
            // All other abstract structure definitions should be sealed (and therefore abstract)
            // classes, except for Element which is concrete but open to be used for fields prefixed
            // with '_'.
            if (structureDefinition.name == "Element") {
              addModifiers(KModifier.OPEN)
              // Implement equals/hashCode for Element to compare properties (like data classes).
              addEqualsAndHashCodeFunctions(
                structureDefinition.name,
                structureDefinition.rootElements,
              )
            } else {
              addModifiers(KModifier.SEALED)
            }
          } else if (
            (structureDefinition.kind == StructureDefinition.Kind.COMPLEX_TYPE ||
              structureDefinition.kind == StructureDefinition.Kind.PRIMITIVE_TYPE) && isBaseClass
          ) {
            // Some primitive types and complex types have to be kept open (therefore not abstract)
            // since they need to be subclassed. E.g. Uri can be extended by Url, and Quantity can
            // be extended by Duration.
            addModifiers(KModifier.OPEN)
            // Implement equals/hashCode for open classes (to perform property-based comparison,
            // like data classes).
            addEqualsAndHashCodeFunctions(
              structureDefinition.name,
              structureDefinition.rootElements,
            )
          } else {
            addModifiers(KModifier.DATA)
          }

          // Serialization annotations
          if (structureDefinition.serializableWithCustomSerializer) {
            addAnnotation(
              AnnotationSpec.builder(Serializable::class)
                .addMember("with = %T::class", modelClassName.toSerializerClassName())
                .build()
            )
          } else if (structureDefinition.kind == StructureDefinition.Kind.RESOURCE) {
            // All resources (Resource class and its subclasses) are serializable
            addAnnotation(Serializable::class)
          } else if (structureDefinitionName == "Element") {
            // Element is serializable for fields prefixed with '_'
            addAnnotation(Serializable::class)
          }

          // Serial name annotations for resources
          if (
            structureDefinition.kind == StructureDefinition.Kind.RESOURCE &&
              !structureDefinition.abstract
          ) {
            addAnnotation(
              AnnotationSpec.builder(SerialName::class)
                .addMember("%S", structureDefinitionName)
                .build()
            )
          }

          addKdoc(structureDefinition.description.sanitizeKDoc())

          // Set superclass if defined
          structureDefinition.baseDefinition?.substringAfterLast('/')?.capitalized()?.also {
            superclass(ClassName(modelClassName.packageName, it))
          }

          buildProperties(
            modelClassName,
            structureDefinition.rootElements,
            structureDefinition,
            isBaseClass,
            codegenContext.valueSetMap,
          )

          addBackboneElement(
            path = structureDefinitionName,
            enclosingModelClassName = modelClassName,
            backboneElements = structureDefinition.backboneElements,
            structureDefinition = structureDefinition,
            valueSetMap = codegenContext.valueSetMap,
            createEnumNameToTypeSpecEntry = { enumClassName, typeSpec ->
              enumClassesMap.putIfAbsent(enumClassName, typeSpec)
            },
          )

          addSealedInterfaces(modelClassName, structureDefinition.rootElements)

          addModelBuilderSupport(structureDefinition, modelClassName, codegenContext.valueSetMap)

          addEnumClassTypeSpec(
            valueSetMap = codegenContext.valueSetMap,
            elements = structureDefinition.rootElements,
            createEnumNameToTypeSpecEntry = { enumClassName, typeSpec ->
              enumClassesMap.putIfAbsent(enumClassName, typeSpec)
            },
          )

          if (structureDefinition.kind == StructureDefinition.Kind.PRIMITIVE_TYPE) {
            addToElementFunction(
              modelClassName.packageName,
              isBaseClass,
              // In R4 primitive types inherit from Element and in R5 they inherit from
              // PrimitiveType. If a type directly inherits Element or PrimitiveType do not
              // generate override modifier for the toElement function.
              structureDefinition.baseDefinition ==
                "http://hl7.org/fhir/StructureDefinition/Element" ||
                structureDefinition.baseDefinition ==
                  "http://hl7.org/fhir/StructureDefinition/PrimitiveType",
            )
            val valueType = propertySpecs.single { it.name == "value" }.type
            addType(
              TypeSpec.companionObjectBuilder()
                .apply {
                  when (structureDefinitionName) {
                    "xhtml" -> addOfFunctionForXhtml(modelClassName, valueType)
                    "decimal" -> addOfFunctionForDecimal(modelClassName)
                    else -> addOfFunction(modelClassName, valueType)
                  }
                }
                .build()
            )
          }

          enumClassesMap.forEach {
            modelClassName.nestedClass(it.key)
            addType(it.value)
          }
        }
        .build()
    return FileSpec.builder(modelClassName).addSuppressAnnotation().addType(typeSpec).build()
  }

  private fun TypeSpec.Builder.addEqualsAndHashCodeFunctions(
    name: String,
    elements: List<Element>,
  ) {
    if (elements.isEmpty()) return
    val equalsFunSpec =
      FunSpec.builder("equals")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("other", Any::class.asTypeName().copy(nullable = true))
        .returns(Boolean::class)
        .addCode(
          """
            if (this === other) return true
            if (other !is ${name.capitalized()}) return false
          """
            .trimIndent()
        )
        .addCode(
          elements.joinToString(separator = "\n", prefix = "\n", postfix = "\n") {
            "if( ${it.getElementName()} != other.${it.getElementName()}) return false"
          }
        )
        .addCode("return true")
        .build()

    this.addFunction(equalsFunSpec)

    val hashCodeFunSpec =
      FunSpec.builder("hashCode")
        .addModifiers(KModifier.OVERRIDE)
        .returns(Int::class)
        .addCode(
          "// Using 31 improves hash distribution and reduces collisions in hash-based collections\n"
        )
        .addCode("var result = ${elements.first().getElementName()}?.hashCode() ?: 0")
        .addCode(
          elements.subList(1, elements.size).joinToString(
            separator = "\n",
            prefix = "\n",
            postfix = "\n",
          ) {
            "result = 31 * result + (${it.getElementName()}?.hashCode() ?: 0)"
          }
        )
        .addCode("return result")
        .build()
    this.addFunction(hashCodeFunSpec)
  }

  /** Adds a nested class for each BackboneElement in the [StructureDefinition]. */
  private fun TypeSpec.Builder.addBackboneElement(
    path: String,
    enclosingModelClassName: ClassName,
    backboneElements: Map<Element, List<Element>>,
    structureDefinition: StructureDefinition,
    valueSetMap: Map<String, ValueSet>,
    createEnumNameToTypeSpecEntry: (String, TypeSpec) -> Unit,
  ): TypeSpec.Builder {
    backboneElements
      .filter { (backboneElement, _) ->
        backboneElement.path.matches("$path\\.[A-Za-z0-9]+".toRegex())
      }
      .forEach { (backboneElement, elements) ->
        val name = backboneElement.path.substringAfterLast('.').capitalized()
        val backboneElementClassName = enclosingModelClassName.nestedClass(name)
        addType(
          TypeSpec.classBuilder(name)
            .addModifiers(KModifier.DATA)
            .addAnnotation(
              AnnotationSpec.builder(Serializable::class)
                .addMember("with = %T::class", backboneElementClassName.toSerializerClassName())
                .build()
            )
            .apply { addKdoc(backboneElement.definition.sanitizeKDoc()) }
            .apply {
              superclass(
                ClassName(enclosingModelClassName.packageName, backboneElement.type!!.single().code)
              )
            }
            .buildProperties(backboneElementClassName, elements, null, false, valueSetMap)
            // Recursively add backbone elements inside a backbone element
            .addBackboneElement(
              backboneElement.path,
              backboneElementClassName,
              backboneElements,
              structureDefinition,
              valueSetMap,
              createEnumNameToTypeSpecEntry,
            )
            // Add sealed interfaces inside a backbone element
            .addSealedInterfaces(backboneElementClassName, elements)
            .addBackboneElementBuilderSupport(
              structureDefinition,
              backboneElementClassName,
              valueSetMap,
              elements,
            )
            .build()
        )
      }

    addEnumClassTypeSpec(
      valueSetMap = valueSetMap,
      elements = backboneElements.values.flatten(),
      createEnumNameToTypeSpecEntry = createEnumNameToTypeSpecEntry,
    )
    return this
  }

  /**
   * Adds [TypeSpec] for enum classes based on the [Element] definitions. This function also tracks
   * the ValueSet urls for common binding Elements.
   */
  private fun addEnumClassTypeSpec(
    valueSetMap: Map<String, ValueSet>,
    elements: List<Element>,
    createEnumNameToTypeSpecEntry: (String, TypeSpec) -> Unit,
  ) {
    elements
      .filter { it.typeIsEnumeratedCode(valueSetMap) && !it.isCommonBinding }
      .mapNotNull { element ->
        val valueSet = valueSetMap.getValue(element.getBindingValueSetUrl()!!)
        val valueSetName = valueSet.name.normalizeEnumName()
        EnumTypeSpecGenerator.generate(valueSetName, valueSet)?.let { typeSpec ->
          valueSetName to typeSpec
        }
      }
      .forEach { createEnumNameToTypeSpecEntry(it.first, it.second) }
  }
}

private fun TypeSpec.Builder.buildProperties(
  modelClassName: ClassName,
  elements: List<Element>,
  structureDefinition: StructureDefinition?, // null means backbone element
  isBaseClass: Boolean = false,
  valueSetMap: Map<String, ValueSet>,
): TypeSpec.Builder {
  val propertyParameterPairs =
    elements.map { element ->
      val propertyMapper =
        PropertyMapper(PropertyMapper.MappingContext.MODEL, modelClassName, valueSetMap)
      val propertyInfo = propertyMapper.mapToProperty(element)
      val property =
        PropertySpec.builder(propertyInfo.name, propertyInfo.typeName)
          .apply {
            if (structureDefinition == null || structureDefinition.hasPrimaryConstructor) {
              initializer(propertyInfo.name)
            }

            if (element.path != element.base?.path) {
              // Override properties in base classes
              addModifiers(KModifier.OVERRIDE)
            }

            if (structureDefinition?.abstract == true) {
              // Make properties open in base classes
              // Keep element's properties concrete since it is used in serialization
              if (modelClassName.simpleName == "Element") {
                addModifiers(KModifier.OPEN)
              } else {
                addModifiers(KModifier.ABSTRACT)
              }
            } else if (isBaseClass) {
              addModifiers(KModifier.OPEN)
            }

            addKdoc("%L", element.definition.sanitizeKDoc())
            element.comment?.let { addKdoc("\n\n%L", it.sanitizeKDoc()) }
          }
          .build()

      val parameter =
        ParameterSpec.builder(name = propertyInfo.name, type = propertyInfo.typeName)
          .apply { propertyInfo.defaultValue?.let { defaultValue(it) } }
          .build()

      return@map Pair(property, parameter)
    }

  addProperties(propertyParameterPairs.map { it.first })

  // Create primary constructor
  if (structureDefinition == null || structureDefinition.hasPrimaryConstructor) {
    primaryConstructor(
      FunSpec.constructorBuilder()
        .apply { propertyParameterPairs.forEach { addParameter(it.second) } }
        .build()
    )

    // Create superclass constructor
    if (
      structureDefinition?.kind == StructureDefinition.Kind.PRIMITIVE_TYPE &&
        structureDefinition.baseDefinition?.substringAfterLast('/')?.capitalized() !=
          "PrimitiveType"
    ) {
      elements
        .filter { it.path != it.base?.path }
        .forEach {
          addSuperclassConstructorParameter(
            "%N",
            PropertySpec.builder(
                it.getElementName(),
                String::class.asTypeName().copy(nullable = true),
              )
              .apply { initializer(it.id) }
              .build(),
          )
        }
    }
  }
  return this
}

/** Adds a nested sealed interface for each choice type in the [StructureDefinition]. */
private fun TypeSpec.Builder.addSealedInterfaces(
  enclosingModelClassName: ClassName,
  elements: List<Element>,
): TypeSpec.Builder {
  val propertyMapper =
    PropertyMapper(PropertyMapper.MappingContext.MODEL, enclosingModelClassName, emptyMap())

  for (element in elements.filter { it.path.endsWith("[x]") }) {
    val sealedInterfaceClassName =
      enclosingModelClassName.nestedClass(element.getElementName().capitalized())
    addType(
      TypeSpec.interfaceBuilder(sealedInterfaceClassName)
        .addModifiers(KModifier.SEALED)
        .addAnnotation(
          AnnotationSpec.builder(Serializable::class)
            .addMember("with = %T::class", sealedInterfaceClassName.toSerializerClassName())
            .build()
        )
        .apply {
          for (type in element.type!!) {
            addType(
              TypeSpec.classBuilder(type.code.capitalized())
                .addModifiers(KModifier.DATA)
                .primaryConstructor(
                  FunSpec.constructorBuilder()
                    .addParameter("value", propertyMapper.mapTypeToClassName(type))
                    .build()
                )
                .addProperty(
                  PropertySpec.builder("value", propertyMapper.mapTypeToClassName(type))
                    .initializer("value")
                    .build()
                )
                .addSuperinterface(sealedInterfaceClassName)
                .build()
            )
          }
          addType(
              TypeSpec.companionObjectBuilder()
                .addFromFunction(element.type, enclosingModelClassName, sealedInterfaceClassName)
                .build()
            )
            .apply {
              // Add an `asDataType` function for each choice type. This function is used
              // to deconstruct the property of the sealed interface in the data class into
              // separate properties in the surrogate class.
              for (type in element.type) {
                addDataTypeFunction(type, sealedInterfaceClassName)
              }
            }
        }
        .build()
    )
  }
  return this
}

/**
 * Adds a [FunSpec] for the `toElement` function that returns
 * - an `Element` for the FHIR primitive data type if either `id` or `extension` is present,
 * - `null`, otherwise.
 */
private fun TypeSpec.Builder.addToElementFunction(
  packageName: String,
  isBaseClass: Boolean,
  inheritsElement: Boolean,
) {
  addFunction(
    FunSpec.builder("toElement")
      .returns(ClassName(packageName, "Element").copy(nullable = true))
      .apply {
        if (isBaseClass) {
          addModifiers(KModifier.OPEN)
        }
        if (!inheritsElement) {
          addModifiers(KModifier.OVERRIDE)
        }
      }
      .addStatement(
        "if (id != null || extension.isNotEmpty()) { return %T(id, extension) }",
        ClassName(packageName, "Element"),
      )
      .addStatement("return null")
      .build()
  )
}

/**
 * Adds an `of` function in the companion object to return a FHIR primitive date type object from a
 * Kotlin primitive value and a FHIR `Element`.
 *
 * The generated function is useful for merging the two fields in the surrogate class representing
 * the two JSON properties into a single field in the data class.
 *
 * For example, the `birthDate` and `_birthDate` JSON properties in a patient object are
 * deserialized into two fields in the `PatientSurrogate` class:
 * - `birthDate`: `LocalDate` storing the primitive value
 * - `_birthDate`: `Element` storing the id and extensions of the FHIR data type
 *
 * N.B. The `LocalDate` type here is `kotlinx.datetime.LocalDate`.
 *
 * They are then merged into a single field in the `Patient` class:
 * - `birthDate`: `Date`
 *
 * N.B. The `Date` type here is a FHIR primitive type that contains both the primitive Kotlin value
 * and the `Element` with id and extensions.
 *
 * For this example, this function will add the following code to the FHIR primitive data type
 * `Date`:
 * ```
 * public companion object {
 *   public fun of(`value`: FhirDate?, element: Element?): Date? =
 *     if (value != null || element?.id != null || element?.extension?.isEmpty() == false) {
 *       Date(element?.id, element?.extension ?: mutableListOf(), value)
 *     } else {
 *       null
 *     }
 * }
 * ```
 *
 * The generated function is also useful for merging choice of types as separate fields in the
 * surrogate class into a single object in the data model class. For example:
 * ```
 * Extension.Value?.from(
 *   Base64Binary.of(
 *     this@ExtensionSurrogate.valueBase64Binary,
 *     this@ExtensionSurrogate._valueBase64Binary,
 *   ),
 *   R4bBoolean.of(
 *     this@ExtensionSurrogate.valueBoolean,
 *     this@ExtensionSurrogate._valueBoolean,
 *   ),
 *   Canonical.of(
 *     this@ExtensionSurrogate.valueCanonical,
 *     this@ExtensionSurrogate._valueCanonical,
 *   ),
 *   ...
 * )
 * ```
 *
 * The nullability here is critical since we must generate `null` for types that do not have a value
 * in the surrogate class. As a result, only one of the data types will be non-null, and the
 * serialization code will be able to correctly serialize the in-memory value to the correct data
 * type.
 */
private fun TypeSpec.Builder.addOfFunction(
  className: ClassName,
  primitiveTypeName: TypeName,
): TypeSpec.Builder {
  addFunction(
    FunSpec.builder("of")
      .addParameter("value", primitiveTypeName.copy(nullable = true))
      .addParameter("element", ClassName(className.packageName, "Element").copy(nullable = true))
      .addCode(
        "return if (value != null || element?.id != null || element?.extension?.isEmpty() == false) { %T(element?.id, element?.extension ?: mutableListOf(), value) } else { null }",
        className,
      )
      .returns(className.copy(nullable = true))
      .build()
  )
  return this
}

/**
 * Adds an `of` function in the companion object in the `Xhtml` class to return a FHIR primitive
 * date type object from a Kotlin primitive string value and a FHIR `Element`.
 *
 * The generated function is useful for merging the two fields in the surrogate class representing
 * the two JSON properties into a single field in the data class.
 *
 * The generated function is a special case of the `of` function for primitive types since the
 * `Xhtml` class cannot have extensions.
 */
private fun TypeSpec.Builder.addOfFunctionForXhtml(
  className: ClassName,
  primitiveTypeName: TypeName,
): TypeSpec.Builder {
  addFunction(
    FunSpec.builder("of")
      .addParameter("value", primitiveTypeName)
      .addParameter("element", ClassName(className.packageName, "Element").copy(nullable = true))
      .addCode("return %T(element?.id, element?.extension ?: mutableListOf(), value)", className)
      .returns(className)
      .build()
  )
  return this
}

/**
 * Adds an `of` function in the companion object in the `Decimal` class to return a FHIR primitive
 * data type object from a Kotlin primitive string value and a FHIR `Element`.
 *
 * The generated function is useful for merging the two fields in the surrogate class representing
 * the two JSON properties into a single field in the data class.
 *
 * The generated function is a special case of the `of` function for primitive types since the
 * `Decimal` class has type `BigDecimal` in the model but `Double` in the surrogate class.
 */
private fun TypeSpec.Builder.addOfFunctionForDecimal(className: ClassName): TypeSpec.Builder {
  addFunction(
    FunSpec.builder("of")
      .addParameter("value", Double::class.asTypeName().copy(nullable = true))
      .addParameter("element", ClassName(className.packageName, "Element").copy(nullable = true))
      .addCode(
        "return if (value != null || element?.id != null || element?.extension?.isEmpty() == false) { %T(element?.id, element?.extension ?: mutableListOf(), value?.%M()) } else { null }",
        className,
        MemberName("com.ionspin.kotlin.bignum.decimal", "toBigDecimal"),
      )
      .returns(className.copy(nullable = true))
      .build()
  )
  return this
}

/**
 * Adds a `from` function to return a sealed interface object from a list of parameters
 * corresponding to JSON properties of each data type in the surrogate class.
 *
 * This function is used in the surrogate class during deserialization to construct the data element
 * in the model class.
 *
 * N.B. The return type is kept nullable for the ease of code generation. The caller of the `from`
 * function in the surrogate class should check the return value is not null when necessary (e.g.
 * when the element is required).
 *
 * For example, the following function is generated `Patient.deceased` element.
 *
 * ```
 * internal fun from(
 *   booleanValue: dev.ohs.fhir.model.r4.Boolean?,
 *   dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
 * ): Deceased? {
 *   if (booleanValue != null) return Boolean(booleanValue)
 *   if (dateTimeValue != null) return DateTime(dateTimeValue)
 *   return null
 * }
 * ```
 */
private fun TypeSpec.Builder.addFromFunction(
  typeList: List<Type>,
  enclosingModelClassName: ClassName,
  sealedInterfaceClassName: ClassName,
): TypeSpec.Builder =
  addFunction(
    FunSpec.builder("from")
      .addModifiers(KModifier.INTERNAL)
      .apply {
        val propertyMapper =
          PropertyMapper(PropertyMapper.MappingContext.MODEL, enclosingModelClassName, emptyMap())
        for (type in typeList) {
          addParameter(
            ParameterSpec(
              "${type.code.replaceFirstChar { it.lowercase() }}Value",
              propertyMapper.mapTypeToClassName(type).copy(nullable = true),
            )
          )
          addCode(
            CodeBlock.builder()
              .add(
                "if(%N != null) return %T(%N) \n",
                "${type.code.replaceFirstChar { it.lowercase() }}Value",
                sealedInterfaceClassName.nestedClass(type.code.capitalized()),
                "${type.code.replaceFirstChar { it.lowercase() }}Value",
              )
              .build()
          )
        }
        addCode(CodeBlock.builder().add("return null").build())
      }
      .returns(sealedInterfaceClassName.copy(nullable = true))
      .build()
  )

private fun TypeSpec.Builder.addDataTypeFunction(type: Type, sealedInterfaceClassName: ClassName) =
  addFunction(
    FunSpec.builder("as${type.code.capitalized()}")
      .returns(sealedInterfaceClassName.nestedClass(type.code.capitalized()).copy(nullable = true))
      .addCode(
        CodeBlock.builder()
          .add("return this as? %T", sealedInterfaceClassName.nestedClass(type.code.capitalized()))
          .build()
      )
      .build()
  )

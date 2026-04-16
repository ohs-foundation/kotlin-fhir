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

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.backboneElements
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.rootElements
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder

// Package names
private const val KOTLINX_SERIALIZATION_DESCRIPTORS = "kotlinx.serialization.descriptors"
private const val KOTLINX_SERIALIZATION_ENCODING = "kotlinx.serialization.encoding"

// Class names used in the code generation
private val serialDescriptorClassName =
  ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "SerialDescriptor")
private val primitiveSerialDescriptorClassName =
  ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "PrimitiveSerialDescriptor")
private val encoderClassName = ClassName(KOTLINX_SERIALIZATION_ENCODING, "Encoder")
private val decoderClassName = ClassName(KOTLINX_SERIALIZATION_ENCODING, "Decoder")

/**
 * Generates a [FileSpec] for a custom serializer object that delegates
 * serialization/deserialization to a surrogate class. The [FileSpec] will include the custom
 * serializer for the model class as well as custom serializers for sealed interfaces and backbone
 * elements defined as nested structures in the model class. See
 * [surrogate](https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/serializers.md#composite-serializer-via-surrogate).
 */
class SerializerFileSpecGenerator(val codegenContext: CodegenContext) {

  fun generate(structureDefinition: StructureDefinition): FileSpec {
    val modelClassName = codegenContext.getModelClassName(structureDefinition)
    return modelClassName
      .toSerializerFileSpecBuilder()
      .apply {
        addBackboneElementSerializers(structureDefinition, modelClassName)

        addSealedInterfaceSerializers(structureDefinition, modelClassName)

        // Add type spec for the model class serializer e.g. PatientSerializer
        addType(
          createSerializerObjectTypeSpec(
            modelClassName,
            structureDefinition.kind to structureDefinition.name,
            structureDefinition.rootElements,
          )
        )
      }
      .build()
  }

  /**
   * Adds [TypeSpec] for backbone element serializer classes
   *
   * Examples: PatientContactSerializer, PatientCommunicationSerializer and PatientLinkSerializer
   */
  private fun FileSpec.Builder.addBackboneElementSerializers(
    structureDefinition: StructureDefinition,
    modelClassName: ClassName,
  ): FileSpec.Builder = apply {
    structureDefinition.backboneElements.forEach { (backboneElement, elements) ->
      val simpleNames = backboneElement.path.split('.').map { it.capitalized() }
      val backboneElementClassName = ClassName(modelClassName.packageName, simpleNames)
      addType(
        this@SerializerFileSpecGenerator.createSerializerObjectTypeSpec(
          className = backboneElementClassName,
          elements = elements,
        )
      )
    }
  }

  /**
   * Adds [TypeSpec] for sealed interfaces serializer classes
   *
   * Examples: PatientDeceasedSerializer and PatientMultipleBirthSerializer
   */
  private fun FileSpec.Builder.addSealedInterfaceSerializers(
    structureDefinition: StructureDefinition,
    modelClassName: ClassName,
  ) = apply {
    addTypes(
      structureDefinition.snapshot
        ?.element
        ?.filter { it.path.endsWith("[x]") }
        ?.map { element ->
          val simpleNames = element.path.replace("[x]", "").split('.').map { it.capitalized() }
          val sealedInterfaceClassName = ClassName(modelClassName.packageName, simpleNames)
          createSerializerObjectTypeSpec(sealedInterfaceClassName)
        } ?: emptyList()
    )
  }

  private fun createSerializerObjectTypeSpec(
    className: ClassName,
    structureDefinitionKindNamePair: Pair<StructureDefinition.Kind, String>? = null,
    elements: List<Element>? = null,
  ): TypeSpec {
    val multiChoiceElements = elements?.filter { it.path.endsWith("[x]") }
    val hasMultiChoiceProperties = !multiChoiceElements.isNullOrEmpty()
    return TypeSpec.objectBuilder(className.toSerializerClassName())
      .addSuperinterface(KSerializer::class.asClassName().parameterizedBy(className))
      .addSurrogateSerializerProperty(className)
      .apply {
        if (hasMultiChoiceProperties) {
          addMultiChoicePropertiesProperty(
            multiChoiceElements.map { it.getElementName() },
            structureDefinitionKindNamePair,
          )
        }
      }
      .addDescriptorProperty(className)
      .addDeserializeFunction(className, hasMultiChoiceProperties)
      .addSerializeFunction(className, hasMultiChoiceProperties)
      .build()
  }
}

/**
 * Adds the `multiChoiceProperties` property to the [TypeSpec.Builder]. This will be used to track
 * FHIR model properties that can be provided in multiple forms, e.g. Patient.deceased that can
 * exist either as as Boolean or DateTime
 */
private fun TypeSpec.Builder.addMultiChoicePropertiesProperty(
  paths: List<String>,
  structureDefinitionKindAndName: Pair<StructureDefinition.Kind, String>?,
): TypeSpec.Builder {
  return apply {
    if (paths.isNotEmpty()) {
      addProperty(
        PropertySpec.builder("multiChoiceProperties", List::class.parameterizedBy(String::class))
          .addModifiers(KModifier.PRIVATE)
          .mutable(false)
          .initializer("listOf(${paths.joinToString(",") { """"$it"""" }})")
          .build()
      )
    }
  }
}

/** Adds the `surrogateSerializer` property to the [TypeSpec.Builder]. */
private fun TypeSpec.Builder.addSurrogateSerializerProperty(
  className: ClassName
): TypeSpec.Builder =
  addProperty(
    PropertySpec.builder(
        "surrogateSerializer",
        KSerializer::class.asClassName().parameterizedBy(className.toSurrogateClassName()),
      )
      .addModifiers(KModifier.INTERNAL)
      .initializeWithLazy("%T.serializer()", className.toSurrogateClassName())
      .build()
  )

/** Adds the `descriptor` property to the [TypeSpec.Builder]. */
private fun TypeSpec.Builder.addDescriptorProperty(className: ClassName): TypeSpec.Builder =
  addProperty(
    PropertySpec.builder("descriptor", serialDescriptorClassName)
      .addModifiers(KModifier.OVERRIDE)
      .apply {
        if (className.simpleName == "Extension") {
          // A cyclic dependency caused by the `Extension` class prevents the kotlinx
          // serialization compiler plugin from generating serializers correctly. The
          // `descriptor` of `ExtensionSerializer` would use the descriptor of
          // `ExtensionSurrogate`'s serializer. But the `ExtensionSurrogate`'s serializer
          // is automatically generated, using the serializers of its data members, some of
          // which in turn can only be generated using `ExtensionSerializer`.
          // To resolve this, a placeholder [PrimitiveSerialDescriptor] of type [String]
          // is used for the `ExtensionSerializer`. This workaround is safe because
          // serialization and deserialization are delegated entirely to the surrogate
          // serializer, rendering the `ExtensionSerializer`'s descriptor effectively unused.
          initializeWithLazy(
            "%T(%S, %T(%S, %T.STRING))",
            serialDescriptorClassName,
            className.packageName,
            primitiveSerialDescriptorClassName,
            "Extension",
            ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "PrimitiveKind"),
          )
        } else {
          initializeWithLazy(
            "%T(%S, surrogateSerializer.descriptor)",
            serialDescriptorClassName,
            className.simpleName,
          )
        }
      }
      .build()
  )

/**
 * Adds the `deserialize` function to the [TypeSpec.Builder]. This function delegates
 * deserialization to `surrogateSerializer`.
 */
private fun TypeSpec.Builder.addDeserializeFunction(
  className: ClassName,
  hasMultiChoiceProperties: Boolean,
): TypeSpec.Builder {
  return addFunction(
    FunSpec.builder("deserialize")
      .addModifiers(KModifier.OVERRIDE)
      .addParameter("decoder", decoderClassName)
      .returns(className)
      .apply {
        if (hasMultiChoiceProperties) {
          // Unflatten the multi-choice JsonObjects; recreate nested JsonObject
          addCode(
            """
              val jsonDecoder = 
                decoder as? %T ?: error("This serializer only supports JSON decoding")
              val oldJsonObject =
                %T(jsonDecoder.decodeJsonElement().%M.toMutableMap().apply {
                  remove("resourceType")
                })
              val unflattenedJsonObject = %T.unflatten(oldJsonObject, multiChoiceProperties)
              val surrogate = 
                jsonDecoder.json.decodeFromJsonElement(surrogateSerializer, unflattenedJsonObject)
              return surrogate.toModel()
            """
              .trimIndent(),
            JsonDecoder::class,
            ClassName("kotlinx.serialization.json", "JsonObject"),
            MemberName("kotlinx.serialization.json", "jsonObject"),
            ClassName(className.packageName, "FhirJsonTransformer"),
          )
        } else {
          addStatement("return surrogateSerializer.deserialize(decoder).toModel()")
        }
      }
      .build()
  )
}

/**
 * Adds the `serialize` function to the [TypeSpec.Builder]. This function delegates serialization to
 * `surrogateSerializer`.
 */
private fun TypeSpec.Builder.addSerializeFunction(
  className: ClassName,
  hasMultiChoiceProperties: Boolean,
): TypeSpec.Builder {
  return addFunction(
    FunSpec.builder("serialize")
      .addModifiers(KModifier.OVERRIDE)
      .addParameter("encoder", encoderClassName)
      .addParameter("value", className)
      .apply {
        if (hasMultiChoiceProperties) {
          // Flatten the multi-choice JsonObjects; unwrap nested Json items
          addCode(
            """
              val jsonEncoder = 
                encoder as? %T ?: error("This serializer only supports JSON encoding")
              val surrogate = %T.fromModel(value)
              val oldJsonObject = 
                jsonEncoder.json.encodeToJsonElement(
                  surrogateSerializer,
                  surrogate
                ).jsonObject
              val flattenedJsonObject = %T.flatten(oldJsonObject, multiChoiceProperties)
              jsonEncoder.encodeJsonElement(flattenedJsonObject)
            """
              .trimIndent(),
            JsonEncoder::class,
            className.toSurrogateClassName(),
            ClassName(className.packageName, "FhirJsonTransformer"),
          )
        } else {
          addStatement(
            "surrogateSerializer.serialize(encoder, %T.fromModel(value))",
            className.toSurrogateClassName(),
          )
        }
      }
      .build()
  )
}

/** Initializes the property with a lazy delegate. */
private fun PropertySpec.Builder.initializeWithLazy(statement: String, vararg args: Any) =
  this.delegate(
    CodeBlock.builder()
      .beginControlFlow("lazy")
      .addStatement(statement, *args)
      .endControlFlow()
      .build()
  )

/**
 * Returns the [ClassName] that represents the serializer for this [ClassName]. The generated
 * serializer resides in the same package and its name is derived by concatenating the names of any
 * nested classes, ending with "Serializer".
 *
 * For example:
 * - `dev.ohs.fhir.r4.Patient` will return `dev.ohs.fhir.r4.PatientSerializer`, and
 * - `dev.ohs.fhir.r4.Patient.Contact` will return `dev.ohs.fhir.r4.PatientContactSerializer`.
 */
fun ClassName.toSerializerClassName(): ClassName =
  ClassName("${packageName}.serializers", simpleNames.joinToString("").plus("Serializer"))

/**
 * Returns the [FileSpec.Builder] that represents the serializer file for this [ClassName]. The
 * serializer file will contain the serializer for the given [ClassName] and all serializers for its
 * nested classes. The serializer file will be under the `serializers` package with a name suffixed
 * with "Serializers".
 *
 * For example:
 * - `dev.ohs.fhir.r4.Patient` will return [FileSpec] for `PatientSerializers.kt` in package
 *   `dev.ohs.fhir.r4.serializers`.
 */
private fun ClassName.toSerializerFileSpecBuilder(): FileSpec.Builder =
  FileSpec.builder("${packageName}.serializers", simpleName.plus("Serializers"))
    .addSuppressAnnotation()

/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ConditionDefinition
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ConditionDefinitionObservationSerializer :
  KSerializer<ConditionDefinition.Observation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Observation") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConditionDefinition.Observation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Observation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConditionDefinition.Observation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var code: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 -> code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Observation: " + __i)
      }
    }
    return ConditionDefinition.Observation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      code = code,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConditionDefinition.Observation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ConditionDefinitionMedicationSerializer :
  KSerializer<ConditionDefinition.Medication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Medication") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConditionDefinition.Medication =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Medication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConditionDefinition.Medication {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var code: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 -> code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Medication: " + __i)
      }
    }
    return ConditionDefinition.Medication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      code = code,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConditionDefinition.Medication) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ConditionDefinitionPreconditionSerializer :
  KSerializer<ConditionDefinition.Precondition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Precondition") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConditionDefinition.Precondition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Precondition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConditionDefinition.Precondition {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var code: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Precondition: " + __i)
      }
    }
    return ConditionDefinition.Precondition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(ConditionDefinition.ConditionPreconditionType.fromCode(type!!), _type),
      code = code!!,
      `value` = ConditionDefinition.Precondition.Value.from(valueCodeableConcept, valueQuantity),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConditionDefinition.Precondition) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is ConditionDefinition.Precondition.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, __d.value)
      }
      is ConditionDefinition.Precondition.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueQuantitySer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object ConditionDefinitionQuestionnaireSerializer :
  KSerializer<ConditionDefinition.Questionnaire> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Questionnaire") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("reference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConditionDefinition.Questionnaire =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Questionnaire) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConditionDefinition.Questionnaire {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var reference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> purpose = decoder.decodeStringElement(__desc, 3)
        4 ->
          _purpose = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.purposeSer, null)
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Questionnaire: " + __i)
      }
    }
    return ConditionDefinition.Questionnaire(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      purpose =
        Enumeration.of(
          ConditionDefinition.ConditionQuestionnairePurpose.fromCode(purpose!!),
          _purpose,
        ),
      reference = reference!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConditionDefinition.Questionnaire) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.purpose.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.purpose.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.purposeSer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.referenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val purposeSer: KSerializer<Element> = Element.serializer()

    public val referenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ConditionDefinitionPlanSerializer : KSerializer<ConditionDefinition.Plan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Plan") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConditionDefinition.Plan =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Plan) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConditionDefinition.Plan {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: CodeableConcept? = null
    var reference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.roleSer, null)
        4 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Plan: " + __i)
      }
    }
    return ConditionDefinition.Plan(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role = role,
      reference = reference!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConditionDefinition.Plan) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.roleSer, it) }
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.referenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val referenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ConditionDefinitionVersionAlgorithmSerializer :
  KSerializer<ConditionDefinition.VersionAlgorithm> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConditionDefinition.VersionAlgorithm") {
      element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.VersionAlgorithm) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ConditionDefinition.VersionAlgorithm.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ConditionDefinition.VersionAlgorithm.Coding -> {
          encodeSerializableElement(__desc, 2, Hoisted.versionAlgorithmCodingSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ConditionDefinition.VersionAlgorithm =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ConditionDefinition.VersionAlgorithm {
    val __desc = descriptor
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 0)
        1 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              2,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ConditionDefinition.VersionAlgorithm: " + __i
          )
      }
    }
    return ConditionDefinition.VersionAlgorithm.from(
      R5String.of(versionAlgorithmString, _versionAlgorithmString),
      versionAlgorithmCoding,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object ConditionDefinitionPreconditionValueSerializer :
  KSerializer<ConditionDefinition.Precondition.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConditionDefinition.Precondition.Value") {
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Precondition.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ConditionDefinition.Precondition.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is ConditionDefinition.Precondition.Value.Quantity -> {
          encodeSerializableElement(__desc, 1, Hoisted.valueQuantitySer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ConditionDefinition.Precondition.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ConditionDefinition.Precondition.Value {
    val __desc = descriptor
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        1 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.valueQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ConditionDefinition.Precondition.Value: " + __i
          )
      }
    }
    return ConditionDefinition.Precondition.Value.from(valueCodeableConcept, valueQuantity)!!
  }

  private object Hoisted {
    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object ConditionDefinitionSerializer : KSerializer<ConditionDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConditionDefinition") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
      element("_subtitle", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("severity", CodeableConcept.serializer().descriptor, isOptional = true)
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element("stage", CodeableConcept.serializer().descriptor, isOptional = true)
      element("hasSeverity", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_hasSeverity", Element.serializer().descriptor, isOptional = true)
      element("hasBodySite", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_hasBodySite", Element.serializer().descriptor, isOptional = true)
      element("hasStage", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_hasStage", Element.serializer().descriptor, isOptional = true)
      element(
        "definition",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_definition",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "observation",
        listSerialDescriptor(
          lazyDescriptor { ConditionDefinition.Observation.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "medication",
        listSerialDescriptor(
          lazyDescriptor { ConditionDefinition.Medication.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "precondition",
        listSerialDescriptor(
          lazyDescriptor { ConditionDefinition.Precondition.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("team", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "questionnaire",
        listSerialDescriptor(
          lazyDescriptor { ConditionDefinition.Questionnaire.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "plan",
        listSerialDescriptor(lazyDescriptor { ConditionDefinition.Plan.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ConditionDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ConditionDefinition {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var severity: CodeableConcept? = null
    var bodySite: CodeableConcept? = null
    var stage: CodeableConcept? = null
    var hasSeverity: KotlinBoolean? = null
    var _hasSeverity: Element? = null
    var hasBodySite: KotlinBoolean? = null
    var _hasBodySite: Element? = null
    var hasStage: KotlinBoolean? = null
    var _hasStage: Element? = null
    var definition: List<KotlinString?>? = null
    var _definition: List<Element?>? = null
    var observation: List<ConditionDefinition.Observation>? = null
    var medication: List<ConditionDefinition.Medication>? = null
    var precondition: List<ConditionDefinition.Precondition>? = null
    var team: List<Reference>? = null
    var questionnaire: List<ConditionDefinition.Questionnaire>? = null
    var plan: List<ConditionDefinition.Plan>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 16)
        17 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        19 -> name = decoder.decodeStringElement(__desc, 19)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> title = decoder.decodeStringElement(__desc, 21)
        22 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> subtitle = decoder.decodeStringElement(__desc, 23)
        24 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> status = decoder.decodeStringElement(__desc, 25)
        26 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> experimental = decoder.decodeBooleanElement(__desc, 27)
        28 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> date = decoder.decodeStringElement(__desc, 29)
        30 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> publisher = decoder.decodeStringElement(__desc, 31)
        32 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.contactSer, null)
        34 -> description = decoder.decodeStringElement(__desc, 34)
        35 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.useContextSer, null)
        37 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.jurisdictionSer, null)
        38 ->
          code =
            decoder.decodeNullableSerializableElement(
              __desc,
              38,
              Hoisted.jurisdictionSerInner,
              null,
            )
        39 ->
          severity =
            decoder.decodeNullableSerializableElement(
              __desc,
              39,
              Hoisted.jurisdictionSerInner,
              null,
            )
        40 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              __desc,
              40,
              Hoisted.jurisdictionSerInner,
              null,
            )
        41 ->
          stage =
            decoder.decodeNullableSerializableElement(
              __desc,
              41,
              Hoisted.jurisdictionSerInner,
              null,
            )
        42 -> hasSeverity = decoder.decodeBooleanElement(__desc, 42)
        43 ->
          _hasSeverity =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 -> hasBodySite = decoder.decodeBooleanElement(__desc, 44)
        45 ->
          _hasBodySite =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 -> hasStage = decoder.decodeBooleanElement(__desc, 46)
        47 ->
          _hasStage =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.implicitRulesSer, null)
        48 ->
          definition =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.definitionSer, null)
        49 ->
          _definition =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.definitionSer2, null)
        50 ->
          observation =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.observationSer, null)
        51 ->
          medication =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.medicationSer, null)
        52 ->
          precondition =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.preconditionSer, null)
        53 -> team = decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.teamSer, null)
        54 ->
          questionnaire =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.questionnaireSer, null)
        55 -> plan = decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.planSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ConditionDefinition: " + __i)
      }
    }
    return ConditionDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        ConditionDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      subtitle = R5String.of(subtitle, _subtitle),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      code = code!!,
      severity = severity,
      bodySite = bodySite,
      stage = stage,
      hasSeverity = R5Boolean.of(hasSeverity, _hasSeverity),
      hasBodySite = R5Boolean.of(hasBodySite, _hasBodySite),
      hasStage = R5Boolean.of(hasStage, _hasStage),
      definition =
        (kotlin.collections.List(maxOf(definition?.size ?: 0, _definition?.size ?: 0)) { __i ->
          Uri.of(definition?.getOrNull(__i)?.let { it }, _definition?.getOrNull(__i))!!
        }),
      observation = observation ?: listOf(),
      medication = medication ?: listOf(),
      precondition = precondition ?: listOf(),
      team = team ?: listOf(),
      questionnaire = questionnaire ?: listOf(),
      plan = plan ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConditionDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ConditionDefinition")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is ConditionDefinition.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is ConditionDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.versionAlgorithmCodingSer, __d.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.subtitle?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 27, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.jurisdictionSer, value.jurisdiction)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.jurisdictionSerInner, it)
    }
    (value.severity)?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.jurisdictionSerInner, it)
    }
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.jurisdictionSerInner, it)
    }
    (value.stage)?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.jurisdictionSerInner, it)
    }
    ((value.hasSeverity?.value))?.let { encoder.encodeBooleanElement(__desc, 42, it) }
    (value.hasSeverity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    ((value.hasBodySite?.value))?.let { encoder.encodeBooleanElement(__desc, 44, it) }
    (value.hasBodySite?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
    }
    ((value.hasStage?.value))?.let { encoder.encodeBooleanElement(__desc, 46, it) }
    (value.hasStage?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.implicitRulesSer, it)
    }
    (value.definition.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.definitionSer, it)
    }
    (value.definition.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.definitionSer2, it)
    }
    if (value.observation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.observationSer, value.observation)
    if (value.medication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.medicationSer, value.medication)
    if (value.precondition.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52, Hoisted.preconditionSer, value.precondition)
    if (value.team.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.teamSer, value.team)
    if (value.questionnaire.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54, Hoisted.questionnaireSer, value.questionnaire)
    if (value.plan.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 55, Hoisted.planSer, value.plan)
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val definitionSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val definitionSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.definitionSerInner).nullable)

    public val definitionSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val observationSerInner: KSerializer<ConditionDefinition.Observation> =
      ConditionDefinition.Observation.serializer()

    public val observationSer: KSerializer<List<ConditionDefinition.Observation>> =
      ListSerializer(Hoisted.observationSerInner)

    public val medicationSerInner: KSerializer<ConditionDefinition.Medication> =
      ConditionDefinition.Medication.serializer()

    public val medicationSer: KSerializer<List<ConditionDefinition.Medication>> =
      ListSerializer(Hoisted.medicationSerInner)

    public val preconditionSerInner: KSerializer<ConditionDefinition.Precondition> =
      ConditionDefinition.Precondition.serializer()

    public val preconditionSer: KSerializer<List<ConditionDefinition.Precondition>> =
      ListSerializer(Hoisted.preconditionSerInner)

    public val teamSerInner: KSerializer<Reference> = Reference.serializer()

    public val teamSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.teamSerInner)

    public val questionnaireSerInner: KSerializer<ConditionDefinition.Questionnaire> =
      ConditionDefinition.Questionnaire.serializer()

    public val questionnaireSer: KSerializer<List<ConditionDefinition.Questionnaire>> =
      ListSerializer(Hoisted.questionnaireSerInner)

    public val planSerInner: KSerializer<ConditionDefinition.Plan> =
      ConditionDefinition.Plan.serializer()

    public val planSer: KSerializer<List<ConditionDefinition.Plan>> =
      ListSerializer(Hoisted.planSerInner)
  }
}

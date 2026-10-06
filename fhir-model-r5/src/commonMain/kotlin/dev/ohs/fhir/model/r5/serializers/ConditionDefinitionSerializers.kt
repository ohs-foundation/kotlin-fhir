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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ConditionDefinition.Observation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ConditionDefinition.Observation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var code: CodeableConcept? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Observation: " + i)
        }
      }
      ConditionDefinition.Observation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category = category,
        code = code,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Observation) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.code)
    }
  }
}

internal object ConditionDefinitionMedicationSerializer :
  KSerializer<ConditionDefinition.Medication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Medication") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ConditionDefinition.Medication>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ConditionDefinition.Medication =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var code: CodeableConcept? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Medication: " + i)
        }
      }
      ConditionDefinition.Medication(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category = category,
        code = code,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Medication) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.code)
    }
  }
}

internal object ConditionDefinitionPreconditionSerializer :
  KSerializer<ConditionDefinition.Precondition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Precondition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ConditionDefinition.Precondition>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ConditionDefinition.Precondition =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var code: CodeableConcept? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Precondition: " + i)
        }
      }
      ConditionDefinition.Precondition(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) ConditionDefinition.ConditionPreconditionType.fromCode(type)
            else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on ConditionDefinition.Precondition"
            ),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on ConditionDefinition.Precondition"
            ),
        `value` = ConditionDefinition.Precondition.Value.from(valueCodeableConcept, valueQuantity),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Precondition) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.code)
      when (val choice = value.`value`) {
        null -> {}
        is ConditionDefinition.Precondition.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
        is ConditionDefinition.Precondition.Value.Quantity -> {
          encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
        }
      }
    }
  }
}

internal object ConditionDefinitionQuestionnaireSerializer :
  KSerializer<ConditionDefinition.Questionnaire> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Questionnaire") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("purpose", KotlinString.serializer().descriptor)
      optionalElement("_purpose", ElementSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ConditionDefinition.Questionnaire>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ConditionDefinition.Questionnaire =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var purpose: KotlinString? = null
      var _purpose: Element? = null
      var reference: Reference? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> purpose = decodeStringElement(descriptor, i)
          4 -> _purpose = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Questionnaire: " + i)
        }
      }
      ConditionDefinition.Questionnaire(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        purpose =
          Enumeration.of(
            if (purpose != null) ConditionDefinition.ConditionQuestionnairePurpose.fromCode(purpose)
            else null,
            _purpose,
          )
            ?: throw SerializationException(
              "Missing required property 'purpose' on ConditionDefinition.Questionnaire"
            ),
        reference =
          reference
            ?: throw SerializationException(
              "Missing required property 'reference' on ConditionDefinition.Questionnaire"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Questionnaire) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.purpose.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.purpose)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.reference)
    }
  }
}

internal object ConditionDefinitionPlanSerializer : KSerializer<ConditionDefinition.Plan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Plan") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ConditionDefinition.Plan>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ConditionDefinition.Plan =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var role: CodeableConcept? = null
      var reference: Reference? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Plan: " + i)
        }
      }
      ConditionDefinition.Plan(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        role = role,
        reference =
          reference
            ?: throw SerializationException(
              "Missing required property 'reference' on ConditionDefinition.Plan"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ConditionDefinition.Plan) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.role)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.reference)
    }
  }
}

internal object ConditionDefinitionSerializer : FhirResourceSerializer<ConditionDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ConditionDefinition")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("subtitle", KotlinString.serializer().descriptor)
    b.optionalElement("_subtitle", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("severity", CodeableConceptSerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.descriptor)
    b.optionalElement("stage", CodeableConceptSerializer.descriptor)
    b.optionalElement("hasSeverity", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_hasSeverity", ElementSerializer.descriptor)
    b.optionalElement("hasBodySite", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_hasBodySite", ElementSerializer.descriptor)
    b.optionalElement("hasStage", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_hasStage", ElementSerializer.descriptor)
    b.optionalElement("definition", stringNullableListSerializer.descriptor)
    b.optionalElement("_definition", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement(
      "observation",
      ConditionDefinitionObservationSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "medication",
      ConditionDefinitionMedicationSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "precondition",
      ConditionDefinitionPreconditionSerializer.listSerializer.descriptor,
    )
    b.optionalElement("team", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "questionnaire",
      ConditionDefinitionQuestionnaireSerializer.listSerializer.descriptor,
    )
    b.optionalElement("plan", ConditionDefinitionPlanSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ConditionDefinition {
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> subtitle = decoder.decodeStringElement(descriptor, i)
        23 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> status = decoder.decodeStringElement(descriptor, i)
        25 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> date = decoder.decodeStringElement(descriptor, i)
        29 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> publisher = decoder.decodeStringElement(descriptor, i)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        33 -> description = decoder.decodeStringElement(descriptor, i)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        37 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        38 ->
          severity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        39 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        40 ->
          stage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        41 -> hasSeverity = decoder.decodeBooleanElement(descriptor, i)
        42 ->
          _hasSeverity =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 -> hasBodySite = decoder.decodeBooleanElement(descriptor, i)
        44 ->
          _hasBodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 -> hasStage = decoder.decodeBooleanElement(descriptor, i)
        46 ->
          _hasStage =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 ->
          definition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        48 ->
          _definition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        49 ->
          observation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionDefinitionObservationSerializer.listSerializer,
              null,
            )
        50 ->
          medication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionDefinitionMedicationSerializer.listSerializer,
              null,
            )
        51 ->
          precondition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionDefinitionPreconditionSerializer.listSerializer,
              null,
            )
        52 ->
          team =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        53 ->
          questionnaire =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionDefinitionQuestionnaireSerializer.listSerializer,
              null,
            )
        54 ->
          plan =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionDefinitionPlanSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ConditionDefinition: " + i)
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
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on ConditionDefinition"
          ),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on ConditionDefinition"
          ),
      severity = severity,
      bodySite = bodySite,
      stage = stage,
      hasSeverity = R5Boolean.of(hasSeverity, _hasSeverity),
      hasBodySite = R5Boolean.of(hasBodySite, _hasBodySite),
      hasStage = R5Boolean.of(hasStage, _hasStage),
      definition =
        (kotlin.collections.List(maxOf(definition?.size ?: 0, _definition?.size ?: 0)) { index ->
          Uri.of(definition?.getOrNull(index), _definition?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'definition' on ConditionDefinition has neither a value nor an id/extension"
            )
        }),
      observation = observation ?: listOf(),
      medication = medication ?: listOf(),
      precondition = precondition ?: listOf(),
      team = team ?: listOf(),
      questionnaire = questionnaire ?: listOf(),
      plan = plan ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ConditionDefinition,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is ConditionDefinition.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is ConditionDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.subtitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.subtitle)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 26 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeSerializableElement(
      descriptor,
      37 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      CodeableConceptSerializer,
      value.severity,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      CodeableConceptSerializer,
      value.bodySite,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      CodeableConceptSerializer,
      value.stage,
    )
    encoder.encodeBooleanIfNotNull(descriptor, 41 + descriptorOffset, value.hasSeverity?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.hasSeverity)
    encoder.encodeBooleanIfNotNull(descriptor, 43 + descriptorOffset, value.hasBodySite?.value)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.hasBodySite)
    encoder.encodeBooleanIfNotNull(descriptor, 45 + descriptorOffset, value.hasStage?.value)
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.hasStage)
    if (value.definition.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        47 + descriptorOffset,
        stringNullableListSerializer,
        value.definition.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 48 + descriptorOffset, value.definition)
    }
    if (value.observation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ConditionDefinitionObservationSerializer.listSerializer,
        value.observation,
      )
    if (value.medication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ConditionDefinitionMedicationSerializer.listSerializer,
        value.medication,
      )
    if (value.precondition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ConditionDefinitionPreconditionSerializer.listSerializer,
        value.precondition,
      )
    if (value.team.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.team,
      )
    if (value.questionnaire.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        ConditionDefinitionQuestionnaireSerializer.listSerializer,
        value.questionnaire,
      )
    if (value.plan.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        ConditionDefinitionPlanSerializer.listSerializer,
        value.plan,
      )
  }
}

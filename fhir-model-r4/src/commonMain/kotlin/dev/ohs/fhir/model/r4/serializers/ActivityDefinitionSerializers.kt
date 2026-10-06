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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.ActivityDefinition
import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Dosage
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object ActivityDefinitionParticipantSerializer :
  KSerializer<ActivityDefinition.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ActivityDefinition.Participant>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ActivityDefinition.Participant =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var role: CodeableConcept? = null
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
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      ActivityDefinition.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) ActivityDefinition.ActionParticipantType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on ActivityDefinition.Participant"
            ),
        role = role,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Participant) {
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
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.role)
    }
  }
}

internal object ActivityDefinitionDynamicValueSerializer :
  KSerializer<ActivityDefinition.DynamicValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DynamicValue") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("path", KotlinString.serializer().descriptor)
      optionalElement("_path", ElementSerializer.descriptor)
      optionalElement("expression", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ActivityDefinition.DynamicValue>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ActivityDefinition.DynamicValue =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var path: KotlinString? = null
      var _path: Element? = null
      var expression: Expression? = null
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
          3 -> path = decodeStringElement(descriptor, i)
          4 -> _path = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            expression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DynamicValue: " + i)
        }
      }
      ActivityDefinition.DynamicValue(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        path =
          R4String.of(path, _path)
            ?: throw SerializationException(
              "Missing required property 'path' on ActivityDefinition.DynamicValue"
            ),
        expression =
          expression
            ?: throw SerializationException(
              "Missing required property 'expression' on ActivityDefinition.DynamicValue"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.DynamicValue) {
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
      encodeStringIfNotNull(descriptor, 3, value.path.value)
      encodeElementIfNotNull(descriptor, 4, value.path)
      encodeSerializableElement(descriptor, 5, ExpressionSerializer, value.expression)
    }
  }
}

internal object ActivityDefinitionSerializer : FhirResourceSerializer<ActivityDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ActivityDefinition")

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
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("usage", KotlinString.serializer().descriptor)
    b.optionalElement("_usage", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("library", stringNullableListSerializer.descriptor)
    b.optionalElement("_library", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("kind", KotlinString.serializer().descriptor)
    b.optionalElement("_kind", ElementSerializer.descriptor)
    b.optionalElement("profile", KotlinString.serializer().descriptor)
    b.optionalElement("_profile", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("intent", KotlinString.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("priority", KotlinString.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_doNotPerform", ElementSerializer.descriptor)
    b.optionalElement("timingTiming", TimingSerializer.descriptor)
    b.optionalElement("timingDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_timingDateTime", ElementSerializer.descriptor)
    b.optionalElement("timingAge", AgeSerializer.descriptor)
    b.optionalElement("timingPeriod", PeriodSerializer.descriptor)
    b.optionalElement("timingRange", RangeSerializer.descriptor)
    b.optionalElement("timingDuration", DurationSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement(
      "participant",
      ActivityDefinitionParticipantSerializer.listSerializer.descriptor,
    )
    b.optionalElement("productReference", ReferenceSerializer.descriptor)
    b.optionalElement("productCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("dosage", DosageSerializer.listSerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("specimenRequirement", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("observationRequirement", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("observationResultRequirement", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("transform", KotlinString.serializer().descriptor)
    b.optionalElement("_transform", ElementSerializer.descriptor)
    b.optionalElement(
      "dynamicValue",
      ActivityDefinitionDynamicValueSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ActivityDefinition {
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
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var usage: KotlinString? = null
    var _usage: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    var code: CodeableConcept? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var timingTiming: Timing? = null
    var timingDateTime: KotlinString? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingRange: Range? = null
    var timingDuration: Duration? = null
    var location: Reference? = null
    var participant: List<ActivityDefinition.Participant>? = null
    var productReference: Reference? = null
    var productCodeableConcept: CodeableConcept? = null
    var quantity: Quantity? = null
    var dosage: List<Dosage>? = null
    var bodySite: List<CodeableConcept>? = null
    var specimenRequirement: List<Reference>? = null
    var observationRequirement: List<Reference>? = null
    var observationResultRequirement: List<Reference>? = null
    var transform: KotlinString? = null
    var _transform: Element? = null
    var dynamicValue: List<ActivityDefinition.DynamicValue>? = null
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
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> subtitle = decoder.decodeStringElement(descriptor, i)
        20 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> status = decoder.decodeStringElement(descriptor, i)
        22 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 -> date = decoder.decodeStringElement(descriptor, i)
        28 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> publisher = decoder.decodeStringElement(descriptor, i)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        32 -> description = decoder.decodeStringElement(descriptor, i)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        36 -> purpose = decoder.decodeStringElement(descriptor, i)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 -> usage = decoder.decodeStringElement(descriptor, i)
        39 ->
          _usage = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 -> copyright = decoder.decodeStringElement(descriptor, i)
        41 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        42 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        43 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        45 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        46 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        47 ->
          topic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        48 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        49 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        50 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        51 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        52 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        53 ->
          library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        54 ->
          _library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        55 -> kind = decoder.decodeStringElement(descriptor, i)
        56 ->
          _kind = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        57 -> profile = decoder.decodeStringElement(descriptor, i)
        58 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        59 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        60 -> intent = decoder.decodeStringElement(descriptor, i)
        61 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        62 -> priority = decoder.decodeStringElement(descriptor, i)
        63 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        64 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        65 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        66 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        67 -> timingDateTime = decoder.decodeStringElement(descriptor, i)
        68 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        69 ->
          timingAge = decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        70 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        71 ->
          timingRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        72 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        73 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        74 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ActivityDefinitionParticipantSerializer.listSerializer,
              null,
            )
        75 ->
          productReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        76 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        77 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        78 ->
          dosage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        79 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        80 ->
          specimenRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        81 ->
          observationRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        82 ->
          observationResultRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        83 -> transform = decoder.decodeStringElement(descriptor, i)
        84 ->
          _transform =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        85 ->
          dynamicValue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ActivityDefinitionDynamicValueSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ActivityDefinition: " + i)
      }
    }
    return ActivityDefinition(
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      subtitle = R4String.of(subtitle, _subtitle),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on ActivityDefinition"
          ),
      experimental = R4Boolean.of(experimental, _experimental),
      subject = ActivityDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4String.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index), _library?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'library' on ActivityDefinition has neither a value nor an id/extension"
            )
        }),
      kind =
        Enumeration.of(
          if (kind != null) ActivityDefinition.RequestResourceType.fromCode(kind) else null,
          _kind,
        ),
      profile = Canonical.of(profile, _profile),
      code = code,
      intent =
        Enumeration.of(
          if (intent != null) ActivityDefinition.RequestIntent.fromCode(intent) else null,
          _intent,
        ),
      priority =
        Enumeration.of(
          if (priority != null) ActivityDefinition.RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      doNotPerform = R4Boolean.of(doNotPerform, _doNotPerform),
      timing =
        ActivityDefinition.Timing.from(
          timingTiming,
          DateTime.of(
            if (timingDateTime != null) FhirDateTime.fromString(timingDateTime) else null,
            _timingDateTime,
          ),
          timingAge,
          timingPeriod,
          timingRange,
          timingDuration,
        ),
      location = location,
      participant = participant ?: listOf(),
      product = ActivityDefinition.Product.from(productReference, productCodeableConcept),
      quantity = quantity,
      dosage = dosage ?: listOf(),
      bodySite = bodySite ?: listOf(),
      specimenRequirement = specimenRequirement ?: listOf(),
      observationRequirement = observationRequirement ?: listOf(),
      observationResultRequirement = observationResultRequirement ?: listOf(),
      transform = Canonical.of(transform, _transform),
      dynamicValue = dynamicValue ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ActivityDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.subtitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.subtitle)
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 23 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is ActivityDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 36 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 38 + descriptorOffset, value.usage?.value)
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.usage)
    encoder.encodeStringIfNotNull(descriptor, 40 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(
      descriptor,
      42 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      44 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    if (value.library.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        53 + descriptorOffset,
        stringNullableListSerializer,
        value.library.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 54 + descriptorOffset, value.library)
    }
    encoder.encodeStringIfNotNull(descriptor, 55 + descriptorOffset, value.kind?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 56 + descriptorOffset, value.kind)
    encoder.encodeStringIfNotNull(descriptor, 57 + descriptorOffset, value.profile?.value)
    encoder.encodeElementIfNotNull(descriptor, 58 + descriptorOffset, value.profile)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      59 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeStringIfNotNull(descriptor, 60 + descriptorOffset, value.intent?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 61 + descriptorOffset, value.intent)
    encoder.encodeStringIfNotNull(descriptor, 62 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 63 + descriptorOffset, value.priority)
    encoder.encodeBooleanIfNotNull(descriptor, 64 + descriptorOffset, value.doNotPerform?.value)
    encoder.encodeElementIfNotNull(descriptor, 65 + descriptorOffset, value.doNotPerform)
    when (val choice = value.timing) {
      null -> {}
      is ActivityDefinition.Timing.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          66 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          67 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 68 + descriptorOffset, choice.value)
      }
      is ActivityDefinition.Timing.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          69 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          70 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          71 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          72 + descriptorOffset,
          DurationSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      73 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        74 + descriptorOffset,
        ActivityDefinitionParticipantSerializer.listSerializer,
        value.participant,
      )
    when (val choice = value.product) {
      null -> {}
      is ActivityDefinition.Product.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          75 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Product.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          76 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      77 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        78 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosage,
      )
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        79 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.bodySite,
      )
    if (value.specimenRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        80 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.specimenRequirement,
      )
    if (value.observationRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        81 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.observationRequirement,
      )
    if (value.observationResultRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        82 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.observationResultRequirement,
      )
    encoder.encodeStringIfNotNull(descriptor, 83 + descriptorOffset, value.transform?.value)
    encoder.encodeElementIfNotNull(descriptor, 84 + descriptorOffset, value.transform)
    if (value.dynamicValue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        85 + descriptorOffset,
        ActivityDefinitionDynamicValueSerializer.listSerializer,
        value.dynamicValue,
      )
  }
}

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
import dev.ohs.fhir.model.r4.terminologies.ActionParticipantType
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.RequestIntent
import dev.ohs.fhir.model.r4.terminologies.RequestPriority
import dev.ohs.fhir.model.r4.terminologies.RequestResourceType
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

  override fun deserialize(decoder: Decoder): ActivityDefinition.Participant {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var role: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ActivityDefinition.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(if (type != null) ActionParticipantType.fromCode(type) else null, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on ActivityDefinition.Participant"
          ),
      role = role,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Participant) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): ActivityDefinition.DynamicValue {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> path = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DynamicValue: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ActivityDefinition.DynamicValue(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.path.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.path)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      5,
      ExpressionSerializer,
      value.expression,
    )
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> subtitle = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _subtitle =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        24 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          subjectCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          subjectReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        27 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        32 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        35 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        36 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        37 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 -> usage = compositeDecoder.decodeStringElement(descriptor, i)
        39 ->
          _usage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 -> approvalDate = compositeDecoder.decodeStringElement(descriptor, i)
        43 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 -> lastReviewDate = compositeDecoder.decodeStringElement(descriptor, i)
        45 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        46 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        47 ->
          topic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        48 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        49 ->
          editor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        50 ->
          reviewer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        51 ->
          endorser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        52 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        53 ->
          library =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        54 ->
          _library =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        55 -> kind = compositeDecoder.decodeStringElement(descriptor, i)
        56 ->
          _kind =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        57 -> profile = compositeDecoder.decodeStringElement(descriptor, i)
        58 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        59 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        60 -> intent = compositeDecoder.decodeStringElement(descriptor, i)
        61 ->
          _intent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        62 -> priority = compositeDecoder.decodeStringElement(descriptor, i)
        63 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        64 -> doNotPerform = compositeDecoder.decodeBooleanElement(descriptor, i)
        65 ->
          _doNotPerform =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        66 ->
          timingTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        67 -> timingDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        68 ->
          _timingDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        69 ->
          timingAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        70 ->
          timingPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        71 ->
          timingRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        72 ->
          timingDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        73 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        74 ->
          participant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ActivityDefinitionParticipantSerializer.listSerializer,
              null,
            )
        75 ->
          productReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        76 ->
          productCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        77 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        78 ->
          dosage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DosageSerializer.listSerializer,
              null,
            )
        79 ->
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        80 ->
          specimenRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        81 ->
          observationRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        82 ->
          observationResultRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        83 -> transform = compositeDecoder.decodeStringElement(descriptor, i)
        84 ->
          _transform =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        85 ->
          dynamicValue =
            compositeDecoder.decodeNullableSerializableElement(
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
      kind = Enumeration.of(if (kind != null) RequestResourceType.fromCode(kind) else null, _kind),
      profile = Canonical.of(profile, _profile),
      code = code,
      intent =
        Enumeration.of(if (intent != null) RequestIntent.fromCode(intent) else null, _intent),
      priority =
        Enumeration.of(
          if (priority != null) RequestPriority.fromCode(priority) else null,
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ActivityDefinition,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.subtitle?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.subtitle)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is ActivityDefinition.Subject.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Subject.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      32 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 36 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(descriptor, 38 + descriptorOffset, value.usage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.usage)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      40 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      42 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      44 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.topic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    if (value.library.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        53 + descriptorOffset,
        stringNullableListSerializer,
        value.library.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 54 + descriptorOffset, value.library)
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      55 + descriptorOffset,
      value.kind?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 56 + descriptorOffset, value.kind)
    compositeEncoder.encodeStringIfNotNull(descriptor, 57 + descriptorOffset, value.profile?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 58 + descriptorOffset, value.profile)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      59 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      60 + descriptorOffset,
      value.intent?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 61 + descriptorOffset, value.intent)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      62 + descriptorOffset,
      value.priority?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 63 + descriptorOffset, value.priority)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      64 + descriptorOffset,
      value.doNotPerform?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 65 + descriptorOffset, value.doNotPerform)
    when (val choice = value.timing) {
      null -> {}
      is ActivityDefinition.Timing.Timing -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          66 + descriptorOffset,
          TimingSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          67 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 68 + descriptorOffset, choice.value)
      }
      is ActivityDefinition.Timing.Age -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          69 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          70 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Range -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          71 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Duration -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          72 + descriptorOffset,
          DurationSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      73 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    if (value.participant.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        74 + descriptorOffset,
        ActivityDefinitionParticipantSerializer.listSerializer,
        value.participant,
      )
    when (val choice = value.product) {
      null -> {}
      is ActivityDefinition.Product.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          75 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ActivityDefinition.Product.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          76 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      77 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    if (value.dosage.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        78 + descriptorOffset,
        DosageSerializer.listSerializer,
        value.dosage,
      )
    if (value.bodySite.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        79 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.bodySite,
      )
    if (value.specimenRequirement.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        80 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.specimenRequirement,
      )
    if (value.observationRequirement.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        81 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.observationRequirement,
      )
    if (value.observationResultRequirement.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        82 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.observationResultRequirement,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      83 + descriptorOffset,
      value.transform?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 84 + descriptorOffset, value.transform)
    if (value.dynamicValue.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        85 + descriptorOffset,
        ActivityDefinitionDynamicValueSerializer.listSerializer,
        value.dynamicValue,
      )
  }
}

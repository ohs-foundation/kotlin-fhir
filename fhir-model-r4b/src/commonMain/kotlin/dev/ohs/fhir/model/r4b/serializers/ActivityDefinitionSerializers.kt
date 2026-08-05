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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.ActivityDefinition
import dev.ohs.fhir.model.r4b.Age
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.RequestResourceType
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
import kotlinx.serialization.builtins.nullable
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
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ActivityDefinition.Participant =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ActivityDefinition.Participant {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var role: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    return ActivityDefinition.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          ActivityDefinition.ActionParticipantType.fromCode(
            type
              ?: throw SerializationException(
                "Missing required property 'type' on ActivityDefinition.Participant"
              )
          ),
          _type,
        ),
      role = role,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ActivityDefinition.Participant,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.roleSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ActivityDefinitionDynamicValueSerializer :
  KSerializer<ActivityDefinition.DynamicValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DynamicValue") {
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
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element("expression", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ActivityDefinition.DynamicValue =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.DynamicValue) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ActivityDefinition.DynamicValue {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(descriptor, i)
        4 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        5 ->
          expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DynamicValue: " + i)
      }
    }
    return ActivityDefinition.DynamicValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path =
        R4bString.of(path, _path)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ActivityDefinition.DynamicValue,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.path.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.pathSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.expressionSer, value.expression)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()

    public val expressionSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object ActivityDefinitionSerializer : KSerializer<ActivityDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ActivityDefinition") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subtitle", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    b.element("subjectCanonical", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subjectCanonical", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("usage", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_usage", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "topic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "library",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_library", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("kind", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_kind", Element.serializer().descriptor, isOptional = true)
    b.element("profile", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_profile", Element.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("intent", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element("priority", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_priority", Element.serializer().descriptor, isOptional = true)
    b.element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
    b.element("timingTiming", Timing.serializer().descriptor, isOptional = true)
    b.element("timingDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("timingAge", Age.serializer().descriptor, isOptional = true)
    b.element("timingPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("timingRange", Range.serializer().descriptor, isOptional = true)
    b.element("timingDuration", Duration.serializer().descriptor, isOptional = true)
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "participant",
      listSerialDescriptor(
        lazyDescriptor { ActivityDefinition.Participant.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("productReference", Reference.serializer().descriptor, isOptional = true)
    b.element("productCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("quantity", Quantity.serializer().descriptor, isOptional = true)
    b.element("dosage", listSerialDescriptor(Dosage.serializer().descriptor), isOptional = true)
    b.element(
      "bodySite",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specimenRequirement",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "observationRequirement",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "observationResultRequirement",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("transform", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_transform", Element.serializer().descriptor, isOptional = true)
    b.element(
      "dynamicValue",
      listSerialDescriptor(
        lazyDescriptor { ActivityDefinition.DynamicValue.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ActivityDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
    var subjectCanonical: KotlinString? = null
    var _subjectCanonical: Element? = null
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> subtitle = decoder.decodeStringElement(descriptor, i)
        20 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> status = decoder.decodeStringElement(descriptor, i)
        22 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        26 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
        27 -> subjectCanonical = decoder.decodeStringElement(descriptor, i)
        28 ->
          _subjectCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> date = decoder.decodeStringElement(descriptor, i)
        30 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 -> publisher = decoder.decodeStringElement(descriptor, i)
        32 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        34 -> description = decoder.decodeStringElement(descriptor, i)
        35 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        37 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        38 -> purpose = decoder.decodeStringElement(descriptor, i)
        39 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        40 -> usage = decoder.decodeStringElement(descriptor, i)
        41 ->
          _usage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        42 -> copyright = decoder.decodeStringElement(descriptor, i)
        43 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        44 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        45 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        46 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        47 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        48 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        49 ->
          topic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        50 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        51 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        52 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        53 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        54 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        55 ->
          library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.librarySer, null)
        56 ->
          _library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.librarySer2, null)
        57 -> kind = decoder.decodeStringElement(descriptor, i)
        58 ->
          _kind =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        59 -> profile = decoder.decodeStringElement(descriptor, i)
        60 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        61 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        62 -> intent = decoder.decodeStringElement(descriptor, i)
        63 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        64 -> priority = decoder.decodeStringElement(descriptor, i)
        65 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        66 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        67 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        68 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingTimingSer, null)
        69 -> timingDateTime = decoder.decodeStringElement(descriptor, i)
        70 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        71 ->
          timingAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingAgeSer, null)
        72 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        73 ->
          timingRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingRangeSer, null)
        74 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.timingDurationSer,
              null,
            )
        75 ->
          location =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
        76 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        77 ->
          productReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
        78 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        79 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        80 ->
          dosage = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dosageSer, null)
        81 ->
          bodySite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        82 ->
          specimenRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.specimenRequirementSer,
              null,
            )
        83 ->
          observationRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.specimenRequirementSer,
              null,
            )
        84 ->
          observationResultRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.specimenRequirementSer,
              null,
            )
        85 -> transform = decoder.decodeStringElement(descriptor, i)
        86 ->
          _transform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        87 ->
          dynamicValue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dynamicValueSer, null)
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      subtitle = R4bString.of(subtitle, _subtitle),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on ActivityDefinition"
              )
          ),
          _status,
        ),
      experimental = R4bBoolean.of(experimental, _experimental),
      subject =
        ActivityDefinition.Subject.from(
          subjectCodeableConcept,
          subjectReference,
          Canonical.of(subjectCanonical, _subjectCanonical),
        ),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4bString.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index)?.let { it }, _library?.getOrNull(index))!!
        }),
      kind = kind?.let { Enumeration.of(RequestResourceType.fromCode(it), _kind) },
      profile = Canonical.of(profile, _profile),
      code = code,
      intent =
        intent?.let { Enumeration.of(ActivityDefinition.RequestIntent.fromCode(it), _intent) },
      priority =
        priority?.let {
          Enumeration.of(ActivityDefinition.RequestPriority.fromCode(it), _priority)
        },
      doNotPerform = R4bBoolean.of(doNotPerform, _doNotPerform),
      timing =
        ActivityDefinition.Timing.from(
          timingTiming,
          DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ActivityDefinition,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.subtitle?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.subject) {
      null -> {}
      is ActivityDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          Hoisted.subjectCodeableConceptSer,
          choice.value,
        )
      }
      is ActivityDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          Hoisted.subjectReferenceSer,
          choice.value,
        )
      }
      is ActivityDefinition.Subject.Canonical -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            28 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 38 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.usage?.value))?.let {
      encoder.encodeStringElement(descriptor, 40 + descriptorOffset, it)
    }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 42 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 44 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 46 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 55 + descriptorOffset, Hoisted.librarySer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 56 + descriptorOffset, Hoisted.librarySer2, it)
    }
    ((value.kind?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 57 + descriptorOffset, it)
    }
    (value.kind?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.profile?.value))?.let {
      encoder.encodeStringElement(descriptor, 59 + descriptorOffset, it)
    }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        61 + descriptorOffset,
        Hoisted.subjectCodeableConceptSer,
        it,
      )
    }
    ((value.intent?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 62 + descriptorOffset, it)
    }
    (value.intent?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.priority?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 64 + descriptorOffset, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.doNotPerform?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 66 + descriptorOffset, it)
    }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        67 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.timing) {
      null -> {}
      is ActivityDefinition.Timing.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          68 + descriptorOffset,
          Hoisted.timingTimingSer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 69 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            70 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ActivityDefinition.Timing.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          71 + descriptorOffset,
          Hoisted.timingAgeSer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          72 + descriptorOffset,
          Hoisted.effectivePeriodSer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          73 + descriptorOffset,
          Hoisted.timingRangeSer,
          choice.value,
        )
      }
      is ActivityDefinition.Timing.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          74 + descriptorOffset,
          Hoisted.timingDurationSer,
          choice.value,
        )
      }
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        75 + descriptorOffset,
        Hoisted.subjectReferenceSer,
        it,
      )
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        76 + descriptorOffset,
        Hoisted.participantSer,
        value.participant,
      )
    when (val choice = value.product) {
      null -> {}
      is ActivityDefinition.Product.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          77 + descriptorOffset,
          Hoisted.subjectReferenceSer,
          choice.value,
        )
      }
      is ActivityDefinition.Product.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          78 + descriptorOffset,
          Hoisted.subjectCodeableConceptSer,
          choice.value,
        )
      }
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 79 + descriptorOffset, Hoisted.quantitySer, it)
    }
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        80 + descriptorOffset,
        Hoisted.dosageSer,
        value.dosage,
      )
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        81 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.bodySite,
      )
    if (value.specimenRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        82 + descriptorOffset,
        Hoisted.specimenRequirementSer,
        value.specimenRequirement,
      )
    if (value.observationRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        83 + descriptorOffset,
        Hoisted.specimenRequirementSer,
        value.observationRequirement,
      )
    if (value.observationResultRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        84 + descriptorOffset,
        Hoisted.specimenRequirementSer,
        value.observationResultRequirement,
      )
    ((value.transform?.value))?.let {
      encoder.encodeStringElement(descriptor, 85 + descriptorOffset, it)
    }
    (value.transform?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        86 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.dynamicValue.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        87 + descriptorOffset,
        Hoisted.dynamicValueSer,
        value.dynamicValue,
      )
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

    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.subjectCodeableConceptSer)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val librarySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val librarySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.librarySerInner).nullable)

    public val librarySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val timingAgeSer: KSerializer<Age> = Age.serializer()

    public val timingRangeSer: KSerializer<Range> = Range.serializer()

    public val timingDurationSer: KSerializer<Duration> = Duration.serializer()

    public val participantSerInner: KSerializer<ActivityDefinition.Participant> =
      ActivityDefinition.Participant.serializer()

    public val participantSer: KSerializer<List<ActivityDefinition.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val dosageSerInner: KSerializer<Dosage> = Dosage.serializer()

    public val dosageSer: KSerializer<List<Dosage>> = ListSerializer(Hoisted.dosageSerInner)

    public val specimenRequirementSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.subjectReferenceSer)

    public val dynamicValueSerInner: KSerializer<ActivityDefinition.DynamicValue> =
      ActivityDefinition.DynamicValue.serializer()

    public val dynamicValueSer: KSerializer<List<ActivityDefinition.DynamicValue>> =
      ListSerializer(Hoisted.dynamicValueSerInner)
  }
}

internal object ActivityDefinitionPolymorphicSerializer : KSerializer<ActivityDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ActivityDefinition") {
      ActivityDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition) {
    encoder.encodeStructure(descriptor) {
      ActivityDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition =
    decoder.decodeStructure(descriptor) {
      ActivityDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}

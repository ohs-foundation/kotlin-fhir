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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.EvidenceVariable
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.TriggerDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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

internal object EvidenceVariableCharacteristicSerializer :
  KSerializer<EvidenceVariable.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("definitionReference", Reference.serializer().descriptor, isOptional = true)
      element("definitionCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionCanonical", Element.serializer().descriptor, isOptional = true)
      element(
        "definitionCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("definitionExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "definitionDataRequirement",
        DataRequirement.serializer().descriptor,
        isOptional = true,
      )
      element(
        "definitionTriggerDefinition",
        TriggerDefinition.serializer().descriptor,
        isOptional = true,
      )
      element(
        "usageContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element("exclude", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exclude", Element.serializer().descriptor, isOptional = true)
      element(
        "participantEffectiveDateTime",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element("_participantEffectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("participantEffectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("participantEffectiveDuration", Duration.serializer().descriptor, isOptional = true)
      element("participantEffectiveTiming", Timing.serializer().descriptor, isOptional = true)
      element("timeFromStart", Duration.serializer().descriptor, isOptional = true)
      element("groupMeasure", KotlinString.serializer().descriptor, isOptional = true)
      element("_groupMeasure", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EvidenceVariable.Characteristic {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var definitionReference: Reference? = null
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionCodeableConcept: CodeableConcept? = null
    var definitionExpression: Expression? = null
    var definitionDataRequirement: DataRequirement? = null
    var definitionTriggerDefinition: TriggerDefinition? = null
    var usageContext: List<UsageContext>? = null
    var exclude: KotlinBoolean? = null
    var _exclude: Element? = null
    var participantEffectiveDateTime: KotlinString? = null
    var _participantEffectiveDateTime: Element? = null
    var participantEffectivePeriod: Period? = null
    var participantEffectiveDuration: Duration? = null
    var participantEffectiveTiming: Timing? = null
    var timeFromStart: Duration? = null
    var groupMeasure: KotlinString? = null
    var _groupMeasure: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 ->
          definitionReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.definitionReferenceSer,
              null,
            )
        6 -> definitionCanonical = decoder.decodeStringElement(__desc, 6)
        7 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.descriptionSer, null)
        8 ->
          definitionCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.definitionCodeableConceptSer,
              null,
            )
        9 ->
          definitionExpression =
            decoder.decodeNullableSerializableElement(
              __desc,
              9,
              Hoisted.definitionExpressionSer,
              null,
            )
        10 ->
          definitionDataRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.definitionDataRequirementSer,
              null,
            )
        11 ->
          definitionTriggerDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.definitionTriggerDefinitionSer,
              null,
            )
        12 ->
          usageContext =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.usageContextSer, null)
        13 -> exclude = decoder.decodeBooleanElement(__desc, 13)
        14 ->
          _exclude =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.descriptionSer, null)
        15 -> participantEffectiveDateTime = decoder.decodeStringElement(__desc, 15)
        16 ->
          _participantEffectiveDateTime =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.descriptionSer, null)
        17 ->
          participantEffectivePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.participantEffectivePeriodSer,
              null,
            )
        18 ->
          participantEffectiveDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.participantEffectiveDurationSer,
              null,
            )
        19 ->
          participantEffectiveTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.participantEffectiveTimingSer,
              null,
            )
        20 ->
          timeFromStart =
            decoder.decodeNullableSerializableElement(
              __desc,
              20,
              Hoisted.participantEffectiveDurationSer,
              null,
            )
        21 -> groupMeasure = decoder.decodeStringElement(__desc, 21)
        22 ->
          _groupMeasure =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + __i)
      }
    }
    return EvidenceVariable.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      definition =
        EvidenceVariable.Characteristic.Definition.from(
          definitionReference,
          Canonical.of(definitionCanonical, _definitionCanonical),
          definitionCodeableConcept,
          definitionExpression,
          definitionDataRequirement,
          definitionTriggerDefinition,
        )!!,
      usageContext = usageContext ?: listOf(),
      exclude = R4Boolean.of(exclude, _exclude),
      participantEffective =
        EvidenceVariable.Characteristic.ParticipantEffective.from(
          DateTime.of(
            FhirDateTime.fromString(participantEffectiveDateTime),
            _participantEffectiveDateTime,
          ),
          participantEffectivePeriod,
          participantEffectiveDuration,
          participantEffectiveTiming,
        ),
      timeFromStart = timeFromStart,
      groupMeasure =
        groupMeasure?.let {
          Enumeration.of(EvidenceVariable.GroupMeasure.fromCode(it), _groupMeasure)
        },
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceVariable.Characteristic) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    when (val __d = value.definition) {
      null -> {}
      is EvidenceVariable.Characteristic.Definition.Reference -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.definitionReferenceSer, __d.value)
      }
      is EvidenceVariable.Characteristic.Definition.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.descriptionSer, it)
        }
      }
      is EvidenceVariable.Characteristic.Definition.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          8,
          Hoisted.definitionCodeableConceptSer,
          __d.value,
        )
      }
      is EvidenceVariable.Characteristic.Definition.Expression -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.definitionExpressionSer, __d.value)
      }
      is EvidenceVariable.Characteristic.Definition.DataRequirement -> {
        encoder.encodeSerializableElement(
          __desc,
          10,
          Hoisted.definitionDataRequirementSer,
          __d.value,
        )
      }
      is EvidenceVariable.Characteristic.Definition.TriggerDefinition -> {
        encoder.encodeSerializableElement(
          __desc,
          11,
          Hoisted.definitionTriggerDefinitionSer,
          __d.value,
        )
      }
    }
    if (value.usageContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.usageContextSer, value.usageContext)
    ((value.exclude?.value))?.let { encoder.encodeBooleanElement(__desc, 13, it) }
    (value.exclude?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.descriptionSer, it)
    }
    when (val __d = value.participantEffective) {
      null -> {}
      is EvidenceVariable.Characteristic.ParticipantEffective.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.descriptionSer, it)
        }
      }
      is EvidenceVariable.Characteristic.ParticipantEffective.Period -> {
        encoder.encodeSerializableElement(
          __desc,
          17,
          Hoisted.participantEffectivePeriodSer,
          __d.value,
        )
      }
      is EvidenceVariable.Characteristic.ParticipantEffective.Duration -> {
        encoder.encodeSerializableElement(
          __desc,
          18,
          Hoisted.participantEffectiveDurationSer,
          __d.value,
        )
      }
      is EvidenceVariable.Characteristic.ParticipantEffective.Timing -> {
        encoder.encodeSerializableElement(
          __desc,
          19,
          Hoisted.participantEffectiveTimingSer,
          __d.value,
        )
      }
    }
    (value.timeFromStart)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.participantEffectiveDurationSer, it)
    }
    ((value.groupMeasure?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.groupMeasure?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val definitionReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val definitionCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val definitionExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val definitionDataRequirementSer: KSerializer<DataRequirement> =
      DataRequirement.serializer()

    public val definitionTriggerDefinitionSer: KSerializer<TriggerDefinition> =
      TriggerDefinition.serializer()

    public val usageContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val usageContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.usageContextSerInner)

    public val participantEffectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val participantEffectiveDurationSer: KSerializer<Duration> = Duration.serializer()

    public val participantEffectiveTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object EvidenceVariableSerializer : KSerializer<EvidenceVariable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EvidenceVariable") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("shortTitle", KotlinString.serializer().descriptor, isOptional = true)
      element("_shortTitle", Element.serializer().descriptor, isOptional = true)
      element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
      element("_subtitle", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
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
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
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
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_approvalDate", Element.serializer().descriptor, isOptional = true)
      element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "topic",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "author",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "editor",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewer",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "endorser",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element(
        "characteristic",
        listSerialDescriptor(
          lazyDescriptor { EvidenceVariable.Characteristic.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): EvidenceVariable =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): EvidenceVariable {
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
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var shortTitle: KotlinString? = null
    var _shortTitle: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
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
    var type: KotlinString? = null
    var _type: Element? = null
    var characteristic: List<EvidenceVariable.Characteristic>? = null
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
        16 -> name = decoder.decodeStringElement(__desc, 16)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> title = decoder.decodeStringElement(__desc, 18)
        19 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> shortTitle = decoder.decodeStringElement(__desc, 20)
        21 ->
          _shortTitle =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> subtitle = decoder.decodeStringElement(__desc, 22)
        23 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> status = decoder.decodeStringElement(__desc, 24)
        25 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(__desc, 26)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(__desc, 28)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(__desc, 31)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 -> note = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.noteSer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.useContextSer, null)
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.jurisdictionSer, null)
        36 -> copyright = decoder.decodeStringElement(__desc, 36)
        37 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> approvalDate = decoder.decodeStringElement(__desc, 38)
        39 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> lastReviewDate = decoder.decodeStringElement(__desc, 40)
        41 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.effectivePeriodSer, null)
        43 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.jurisdictionSer, null)
        44 ->
          author = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.contactSer, null)
        45 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.contactSer, null)
        46 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.contactSer, null)
        47 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.contactSer, null)
        48 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.relatedArtifactSer, null)
        49 -> type = decoder.decodeStringElement(__desc, 49)
        50 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.implicitRulesSer, null)
        51 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.characteristicSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EvidenceVariable: " + __i)
      }
    }
    return EvidenceVariable(
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
      shortTitle = R4String.of(shortTitle, _shortTitle),
      subtitle = R4String.of(subtitle, _subtitle),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
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
      type =
        type?.let { Enumeration.of(EvidenceVariable.EvidenceVariableType.fromCode(it), _type) },
      characteristic = characteristic ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceVariable) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "EvidenceVariable")
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
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.shortTitle?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.shortTitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.subtitle?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.noteSer, value.note)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        48,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 49, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 50, Hoisted.implicitRulesSer, it)
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.characteristicSer, value.characteristic)
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

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val characteristicSerInner: KSerializer<EvidenceVariable.Characteristic> =
      EvidenceVariable.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<EvidenceVariable.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)
  }
}

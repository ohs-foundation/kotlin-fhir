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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DataRequirement
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
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
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.ResearchElementDefinition
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object ResearchElementDefinitionCharacteristicSerializer :
  KSerializer<ResearchElementDefinition.Characteristic> {
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
      element(
        "definitionCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("definitionCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionCanonical", Element.serializer().descriptor, isOptional = true)
      element("definitionExpression", Expression.serializer().descriptor, isOptional = true)
      element(
        "definitionDataRequirement",
        DataRequirement.serializer().descriptor,
        isOptional = true,
      )
      element(
        "usageContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element("exclude", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exclude", Element.serializer().descriptor, isOptional = true)
      element("unitOfMeasure", CodeableConcept.serializer().descriptor, isOptional = true)
      element("studyEffectiveDescription", KotlinString.serializer().descriptor, isOptional = true)
      element("_studyEffectiveDescription", Element.serializer().descriptor, isOptional = true)
      element("studyEffectiveDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_studyEffectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("studyEffectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("studyEffectiveDuration", Duration.serializer().descriptor, isOptional = true)
      element("studyEffectiveTiming", Timing.serializer().descriptor, isOptional = true)
      element("studyEffectiveTimeFromStart", Duration.serializer().descriptor, isOptional = true)
      element("studyEffectiveGroupMeasure", KotlinString.serializer().descriptor, isOptional = true)
      element("_studyEffectiveGroupMeasure", Element.serializer().descriptor, isOptional = true)
      element(
        "participantEffectiveDescription",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element(
        "_participantEffectiveDescription",
        Element.serializer().descriptor,
        isOptional = true,
      )
      element(
        "participantEffectiveDateTime",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element("_participantEffectiveDateTime", Element.serializer().descriptor, isOptional = true)
      element("participantEffectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("participantEffectiveDuration", Duration.serializer().descriptor, isOptional = true)
      element("participantEffectiveTiming", Timing.serializer().descriptor, isOptional = true)
      element(
        "participantEffectiveTimeFromStart",
        Duration.serializer().descriptor,
        isOptional = true,
      )
      element(
        "participantEffectiveGroupMeasure",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element(
        "_participantEffectiveGroupMeasure",
        Element.serializer().descriptor,
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition.Characteristic =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition.Characteristic) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ResearchElementDefinition.Characteristic {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var definitionCodeableConcept: CodeableConcept? = null
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionExpression: Expression? = null
    var definitionDataRequirement: DataRequirement? = null
    var usageContext: List<UsageContext>? = null
    var exclude: KotlinBoolean? = null
    var _exclude: Element? = null
    var unitOfMeasure: CodeableConcept? = null
    var studyEffectiveDescription: KotlinString? = null
    var _studyEffectiveDescription: Element? = null
    var studyEffectiveDateTime: KotlinString? = null
    var _studyEffectiveDateTime: Element? = null
    var studyEffectivePeriod: Period? = null
    var studyEffectiveDuration: Duration? = null
    var studyEffectiveTiming: Timing? = null
    var studyEffectiveTimeFromStart: Duration? = null
    var studyEffectiveGroupMeasure: KotlinString? = null
    var _studyEffectiveGroupMeasure: Element? = null
    var participantEffectiveDescription: KotlinString? = null
    var _participantEffectiveDescription: Element? = null
    var participantEffectiveDateTime: KotlinString? = null
    var _participantEffectiveDateTime: Element? = null
    var participantEffectivePeriod: Period? = null
    var participantEffectiveDuration: Duration? = null
    var participantEffectiveTiming: Timing? = null
    var participantEffectiveTimeFromStart: Duration? = null
    var participantEffectiveGroupMeasure: KotlinString? = null
    var _participantEffectiveGroupMeasure: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          definitionCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCodeableConceptSer,
              null,
            )
        4 -> definitionCanonical = decoder.decodeStringElement(descriptor, i)
        5 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCanonicalSer,
              null,
            )
        6 ->
          definitionExpression =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionExpressionSer,
              null,
            )
        7 ->
          definitionDataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionDataRequirementSer,
              null,
            )
        8 ->
          usageContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.usageContextSer, null)
        9 -> exclude = decoder.decodeBooleanElement(descriptor, i)
        10 ->
          _exclude =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCanonicalSer,
              null,
            )
        11 ->
          unitOfMeasure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCodeableConceptSer,
              null,
            )
        12 -> studyEffectiveDescription = decoder.decodeStringElement(descriptor, i)
        13 ->
          _studyEffectiveDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCanonicalSer,
              null,
            )
        14 -> studyEffectiveDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _studyEffectiveDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCanonicalSer,
              null,
            )
        16 ->
          studyEffectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.studyEffectivePeriodSer,
              null,
            )
        17 ->
          studyEffectiveDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.studyEffectiveDurationSer,
              null,
            )
        18 ->
          studyEffectiveTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.studyEffectiveTimingSer,
              null,
            )
        19 ->
          studyEffectiveTimeFromStart =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.studyEffectiveDurationSer,
              null,
            )
        20 -> studyEffectiveGroupMeasure = decoder.decodeStringElement(descriptor, i)
        21 ->
          _studyEffectiveGroupMeasure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCanonicalSer,
              null,
            )
        22 -> participantEffectiveDescription = decoder.decodeStringElement(descriptor, i)
        23 ->
          _participantEffectiveDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCanonicalSer,
              null,
            )
        24 -> participantEffectiveDateTime = decoder.decodeStringElement(descriptor, i)
        25 ->
          _participantEffectiveDateTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCanonicalSer,
              null,
            )
        26 ->
          participantEffectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.studyEffectivePeriodSer,
              null,
            )
        27 ->
          participantEffectiveDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.studyEffectiveDurationSer,
              null,
            )
        28 ->
          participantEffectiveTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.studyEffectiveTimingSer,
              null,
            )
        29 ->
          participantEffectiveTimeFromStart =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.studyEffectiveDurationSer,
              null,
            )
        30 -> participantEffectiveGroupMeasure = decoder.decodeStringElement(descriptor, i)
        31 ->
          _participantEffectiveGroupMeasure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.definitionCanonicalSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
    return ResearchElementDefinition.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      definition =
        ResearchElementDefinition.Characteristic.Definition.from(
          definitionCodeableConcept,
          Canonical.of(definitionCanonical, _definitionCanonical),
          definitionExpression,
          definitionDataRequirement,
        )!!,
      usageContext = usageContext ?: listOf(),
      exclude = R4bBoolean.of(exclude, _exclude),
      unitOfMeasure = unitOfMeasure,
      studyEffectiveDescription =
        R4bString.of(studyEffectiveDescription, _studyEffectiveDescription),
      studyEffective =
        ResearchElementDefinition.Characteristic.StudyEffective.from(
          DateTime.of(FhirDateTime.fromString(studyEffectiveDateTime), _studyEffectiveDateTime),
          studyEffectivePeriod,
          studyEffectiveDuration,
          studyEffectiveTiming,
        ),
      studyEffectiveTimeFromStart = studyEffectiveTimeFromStart,
      studyEffectiveGroupMeasure =
        studyEffectiveGroupMeasure?.let {
          Enumeration.of(
            ResearchElementDefinition.GroupMeasure.fromCode(it),
            _studyEffectiveGroupMeasure,
          )
        },
      participantEffectiveDescription =
        R4bString.of(participantEffectiveDescription, _participantEffectiveDescription),
      participantEffective =
        ResearchElementDefinition.Characteristic.ParticipantEffective.from(
          DateTime.of(
            FhirDateTime.fromString(participantEffectiveDateTime),
            _participantEffectiveDateTime,
          ),
          participantEffectivePeriod,
          participantEffectiveDuration,
          participantEffectiveTiming,
        ),
      participantEffectiveTimeFromStart = participantEffectiveTimeFromStart,
      participantEffectiveGroupMeasure =
        participantEffectiveGroupMeasure?.let {
          Enumeration.of(
            ResearchElementDefinition.GroupMeasure.fromCode(it),
            _participantEffectiveGroupMeasure,
          )
        },
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ResearchElementDefinition.Characteristic,
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
    when (val choice = value.definition) {
      is ResearchElementDefinition.Characteristic.Definition.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.definitionCodeableConceptSer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Characteristic.Definition.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.definitionCanonicalSer, it)
        }
      }
      is ResearchElementDefinition.Characteristic.Definition.Expression -> {
        encoder.encodeSerializableElement(
          descriptor,
          6,
          Hoisted.definitionExpressionSer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Characteristic.Definition.DataRequirement -> {
        encoder.encodeSerializableElement(
          descriptor,
          7,
          Hoisted.definitionDataRequirementSer,
          choice.value,
        )
      }
    }
    if (value.usageContext.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.usageContextSer, value.usageContext)
    ((value.exclude?.value))?.let { encoder.encodeBooleanElement(descriptor, 9, it) }
    (value.exclude?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.definitionCanonicalSer, it)
    }
    (value.unitOfMeasure)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.definitionCodeableConceptSer, it)
    }
    ((value.studyEffectiveDescription?.value))?.let {
      encoder.encodeStringElement(descriptor, 12, it)
    }
    (value.studyEffectiveDescription?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.definitionCanonicalSer, it)
    }
    when (val choice = value.studyEffective) {
      null -> {}
      is ResearchElementDefinition.Characteristic.StudyEffective.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.definitionCanonicalSer, it)
        }
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          16,
          Hoisted.studyEffectivePeriodSer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          17,
          Hoisted.studyEffectiveDurationSer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          18,
          Hoisted.studyEffectiveTimingSer,
          choice.value,
        )
      }
    }
    (value.studyEffectiveTimeFromStart)?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.studyEffectiveDurationSer, it)
    }
    ((value.studyEffectiveGroupMeasure?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 20, it)
    }
    (value.studyEffectiveGroupMeasure?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.definitionCanonicalSer, it)
    }
    ((value.participantEffectiveDescription?.value))?.let {
      encoder.encodeStringElement(descriptor, 22, it)
    }
    (value.participantEffectiveDescription?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.definitionCanonicalSer, it)
    }
    when (val choice = value.participantEffective) {
      null -> {}
      is ResearchElementDefinition.Characteristic.ParticipantEffective.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 24, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 25, Hoisted.definitionCanonicalSer, it)
        }
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          26,
          Hoisted.studyEffectivePeriodSer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          27,
          Hoisted.studyEffectiveDurationSer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Timing -> {
        encoder.encodeSerializableElement(
          descriptor,
          28,
          Hoisted.studyEffectiveTimingSer,
          choice.value,
        )
      }
    }
    (value.participantEffectiveTimeFromStart)?.let {
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.studyEffectiveDurationSer, it)
    }
    ((value.participantEffectiveGroupMeasure?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 30, it)
    }
    (value.participantEffectiveGroupMeasure?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 31, Hoisted.definitionCanonicalSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val definitionCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val definitionCanonicalSer: KSerializer<Element> = Element.serializer()

    public val definitionExpressionSer: KSerializer<Expression> = Expression.serializer()

    public val definitionDataRequirementSer: KSerializer<DataRequirement> =
      DataRequirement.serializer()

    public val usageContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val usageContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.usageContextSerInner)

    public val studyEffectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val studyEffectiveDurationSer: KSerializer<Duration> = Duration.serializer()

    public val studyEffectiveTimingSer: KSerializer<Timing> = Timing.serializer()
  }
}

internal object ResearchElementDefinitionSerializer : KSerializer<ResearchElementDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchElementDefinition") {
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
    b.element("shortTitle", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_shortTitle", Element.serializer().descriptor, isOptional = true)
    b.element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subtitle", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subjectReference", Reference.serializer().descriptor, isOptional = true)
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
      "comment",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_comment", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
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
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("variableType", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_variableType", Element.serializer().descriptor, isOptional = true)
    b.element(
      "characteristic",
      listSerialDescriptor(
        lazyDescriptor { ResearchElementDefinition.Characteristic.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ResearchElementDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ResearchElementDefinition {
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
    var comment: List<KotlinString?>? = null
    var _comment: List<Element?>? = null
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
    var type: KotlinString? = null
    var _type: Element? = null
    var variableType: KotlinString? = null
    var _variableType: Element? = null
    var characteristic: List<ResearchElementDefinition.Characteristic>? = null
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
        19 -> shortTitle = decoder.decodeStringElement(descriptor, i)
        20 ->
          _shortTitle =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 -> subtitle = decoder.decodeStringElement(descriptor, i)
        22 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> status = decoder.decodeStringElement(descriptor, i)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        28 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
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
          comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.commentSer, null)
        37 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.commentSer2, null)
        38 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        39 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        40 -> purpose = decoder.decodeStringElement(descriptor, i)
        41 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        42 -> usage = decoder.decodeStringElement(descriptor, i)
        43 ->
          _usage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        44 -> copyright = decoder.decodeStringElement(descriptor, i)
        45 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        46 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        47 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        48 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        49 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        50 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        51 ->
          topic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        52 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        53 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        54 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        55 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        56 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        57 ->
          library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.commentSer, null)
        58 ->
          _library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.commentSer2, null)
        59 -> type = decoder.decodeStringElement(descriptor, i)
        60 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        61 -> variableType = decoder.decodeStringElement(descriptor, i)
        62 ->
          _variableType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        63 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characteristicSer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding ResearchElementDefinition: " + i)
      }
    }
    return ResearchElementDefinition(
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
      shortTitle = R4bString.of(shortTitle, _shortTitle),
      subtitle = R4bString.of(subtitle, _subtitle),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4bBoolean.of(experimental, _experimental),
      subject = ResearchElementDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      comment =
        (kotlin.collections.List(maxOf(comment?.size ?: 0, _comment?.size ?: 0)) { index ->
          R4bString.of(comment?.getOrNull(index)?.let { it }, _comment?.getOrNull(index))!!
        }),
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
      type = Enumeration.of(ResearchElementDefinition.ResearchElementType.fromCode(type!!), _type),
      variableType =
        variableType?.let {
          Enumeration.of(ResearchElementDefinition.VariableType.fromCode(it), _variableType)
        },
      characteristic = characteristic ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ResearchElementDefinition,
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
    ((value.shortTitle?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.shortTitle?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.subtitle?.value))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.subject) {
      null -> {}
      is ResearchElementDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          27 + descriptorOffset,
          Hoisted.subjectCodeableConceptSer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          28 + descriptorOffset,
          Hoisted.subjectReferenceSer,
          choice.value,
        )
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
    (value.comment.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 36 + descriptorOffset, Hoisted.commentSer, it)
    }
    (value.comment.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 37 + descriptorOffset, Hoisted.commentSer2, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 40 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.usage?.value))?.let {
      encoder.encodeStringElement(descriptor, 42 + descriptorOffset, it)
    }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 44 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 46 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 48 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 57 + descriptorOffset, Hoisted.commentSer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 58 + descriptorOffset, Hoisted.commentSer2, it)
    }
    ((value.type.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 59 + descriptorOffset, it)
    }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.variableType?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 61 + descriptorOffset, it)
    }
    (value.variableType?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        62 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        Hoisted.characteristicSer,
        value.characteristic,
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

    public val commentSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val commentSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.commentSerInner).nullable)

    public val commentSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.subjectCodeableConceptSer)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val characteristicSerInner: KSerializer<ResearchElementDefinition.Characteristic> =
      ResearchElementDefinition.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<ResearchElementDefinition.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)
  }
}

internal object ResearchElementDefinitionPolymorphicSerializer :
  KSerializer<ResearchElementDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResearchElementDefinition") {
      ResearchElementDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition) {
    encoder.encodeStructure(descriptor) {
      ResearchElementDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition =
    decoder.decodeStructure(descriptor) {
      ResearchElementDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}

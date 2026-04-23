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
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ActivityDefinition.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var role: CodeableConcept? = null
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
        5 -> role = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return ActivityDefinition.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(ActivityDefinition.ActionParticipantType.fromCode(type!!), _type),
      role = role,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ActivityDefinition.Participant) {
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
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.roleSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.DynamicValue) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ActivityDefinition.DynamicValue {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(__desc, 3)
        4 -> _path = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.pathSer, null)
        5 ->
          expression =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DynamicValue: " + __i)
      }
    }
    return ActivityDefinition.DynamicValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path = R4String.of(path, _path)!!,
      expression = expression!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ActivityDefinition.DynamicValue) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.path.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.path.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.pathSer, it)
    }
    (value.expression)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.expressionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()

    public val expressionSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object ActivityDefinitionSubjectSerializer : KSerializer<ActivityDefinition.Subject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ActivityDefinition.Subject") {
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Subject) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ActivityDefinition.Subject.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.subjectCodeableConceptSer, __d.value)
        }
        is ActivityDefinition.Subject.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition.Subject =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ActivityDefinition.Subject {
    val __desc = descriptor
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        1 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ActivityDefinition.Subject: " + __i
          )
      }
    }
    return ActivityDefinition.Subject.from(subjectCodeableConcept, subjectReference)!!
  }

  private object Hoisted {
    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ActivityDefinitionTimingSerializer : KSerializer<ActivityDefinition.Timing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ActivityDefinition.Timing") {
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
      element("timingDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
      element("timingAge", Age.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("timingRange", Range.serializer().descriptor, isOptional = true)
      element("timingDuration", Duration.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Timing) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ActivityDefinition.Timing.Timing -> {
          encodeSerializableElement(__desc, 0, Hoisted.timingTimingSer, __d.value)
        }
        is ActivityDefinition.Timing.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 1, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 2, Hoisted.elementSer, it)
          }
        }
        is ActivityDefinition.Timing.Age -> {
          encodeSerializableElement(__desc, 3, Hoisted.timingAgeSer, __d.value)
        }
        is ActivityDefinition.Timing.Period -> {
          encodeSerializableElement(__desc, 4, Hoisted.timingPeriodSer, __d.value)
        }
        is ActivityDefinition.Timing.Range -> {
          encodeSerializableElement(__desc, 5, Hoisted.timingRangeSer, __d.value)
        }
        is ActivityDefinition.Timing.Duration -> {
          encodeSerializableElement(__desc, 6, Hoisted.timingDurationSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition.Timing =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ActivityDefinition.Timing {
    val __desc = descriptor
    var timingTiming: Timing? = null
    var timingDateTime: KotlinString? = null
    var _timingDateTime: Element? = null
    var timingAge: Age? = null
    var timingPeriod: Period? = null
    var timingRange: Range? = null
    var timingDuration: Duration? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.timingTimingSer, null)
        1 -> timingDateTime = decoder.decodeStringElement(__desc, 1)
        2 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.elementSer, null)
        3 ->
          timingAge =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.timingAgeSer, null)
        4 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.timingPeriodSer, null)
        5 ->
          timingRange =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.timingRangeSer, null)
        6 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.timingDurationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ActivityDefinition.Timing: " + __i
          )
      }
    }
    return ActivityDefinition.Timing.from(
      timingTiming,
      DateTime.of(FhirDateTime.fromString(timingDateTime), _timingDateTime),
      timingAge,
      timingPeriod,
      timingRange,
      timingDuration,
    )!!
  }

  private object Hoisted {
    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()

    public val timingAgeSer: KSerializer<Age> = Age.serializer()

    public val timingPeriodSer: KSerializer<Period> = Period.serializer()

    public val timingRangeSer: KSerializer<Range> = Range.serializer()

    public val timingDurationSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object ActivityDefinitionProductSerializer : KSerializer<ActivityDefinition.Product> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ActivityDefinition.Product") {
      element("productReference", Reference.serializer().descriptor, isOptional = true)
      element("productCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition.Product) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ActivityDefinition.Product.Reference -> {
          encodeSerializableElement(__desc, 0, Hoisted.productReferenceSer, __d.value)
        }
        is ActivityDefinition.Product.CodeableConcept -> {
          encodeSerializableElement(__desc, 1, Hoisted.productCodeableConceptSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ActivityDefinition.Product =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ActivityDefinition.Product {
    val __desc = descriptor
    var productReference: Reference? = null
    var productCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          productReference =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.productReferenceSer, null)
        1 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.productCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ActivityDefinition.Product: " + __i
          )
      }
    }
    return ActivityDefinition.Product.from(productReference, productCodeableConcept)!!
  }

  private object Hoisted {
    public val productReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val productCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()
  }
}

internal object ActivityDefinitionSerializer : KSerializer<ActivityDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ActivityDefinition") {
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
      element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
      element("_subtitle", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
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
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("usage", KotlinString.serializer().descriptor, isOptional = true)
      element("_usage", Element.serializer().descriptor, isOptional = true)
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
      element(
        "library",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_library", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("kind", KotlinString.serializer().descriptor, isOptional = true)
      element("_kind", Element.serializer().descriptor, isOptional = true)
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("intent", KotlinString.serializer().descriptor, isOptional = true)
      element("_intent", Element.serializer().descriptor, isOptional = true)
      element("priority", KotlinString.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
      element("timingDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timingDateTime", Element.serializer().descriptor, isOptional = true)
      element("timingAge", Age.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("timingRange", Range.serializer().descriptor, isOptional = true)
      element("timingDuration", Duration.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element(
        "participant",
        listSerialDescriptor(
          lazyDescriptor { ActivityDefinition.Participant.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("productReference", Reference.serializer().descriptor, isOptional = true)
      element("productCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("dosage", listSerialDescriptor(Dosage.serializer().descriptor), isOptional = true)
      element(
        "bodySite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specimenRequirement",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "observationRequirement",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "observationResultRequirement",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("transform", KotlinString.serializer().descriptor, isOptional = true)
      element("_transform", Element.serializer().descriptor, isOptional = true)
      element(
        "dynamicValue",
        listSerialDescriptor(
          lazyDescriptor { ActivityDefinition.DynamicValue.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ActivityDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ActivityDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ActivityDefinition {
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
        20 -> subtitle = decoder.decodeStringElement(__desc, 20)
        21 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(__desc, 22)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(__desc, 24)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        27 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.subjectReferenceSer, null)
        28 -> date = decoder.decodeStringElement(__desc, 28)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> publisher = decoder.decodeStringElement(__desc, 30)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.contactSer, null)
        33 -> description = decoder.decodeStringElement(__desc, 33)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.useContextSer, null)
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.jurisdictionSer, null)
        37 -> purpose = decoder.decodeStringElement(__desc, 37)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 -> usage = decoder.decodeStringElement(__desc, 39)
        40 ->
          _usage =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.implicitRulesSer, null)
        41 -> copyright = decoder.decodeStringElement(__desc, 41)
        42 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.implicitRulesSer, null)
        43 -> approvalDate = decoder.decodeStringElement(__desc, 43)
        44 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.implicitRulesSer, null)
        45 -> lastReviewDate = decoder.decodeStringElement(__desc, 45)
        46 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.implicitRulesSer, null)
        47 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.effectivePeriodSer, null)
        48 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.jurisdictionSer, null)
        49 ->
          author = decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.contactSer, null)
        50 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.contactSer, null)
        51 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.contactSer, null)
        52 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.contactSer, null)
        53 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.relatedArtifactSer, null)
        54 ->
          library = decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.librarySer, null)
        55 ->
          _library =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.librarySer2, null)
        56 -> kind = decoder.decodeStringElement(__desc, 56)
        57 ->
          _kind =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.implicitRulesSer, null)
        58 -> profile = decoder.decodeStringElement(__desc, 58)
        59 ->
          _profile =
            decoder.decodeNullableSerializableElement(__desc, 59, Hoisted.implicitRulesSer, null)
        60 ->
          code =
            decoder.decodeNullableSerializableElement(
              __desc,
              60,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        61 -> intent = decoder.decodeStringElement(__desc, 61)
        62 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.implicitRulesSer, null)
        63 -> priority = decoder.decodeStringElement(__desc, 63)
        64 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.implicitRulesSer, null)
        65 -> doNotPerform = decoder.decodeBooleanElement(__desc, 65)
        66 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.implicitRulesSer, null)
        67 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(__desc, 67, Hoisted.timingTimingSer, null)
        68 -> timingDateTime = decoder.decodeStringElement(__desc, 68)
        69 ->
          _timingDateTime =
            decoder.decodeNullableSerializableElement(__desc, 69, Hoisted.implicitRulesSer, null)
        70 ->
          timingAge =
            decoder.decodeNullableSerializableElement(__desc, 70, Hoisted.timingAgeSer, null)
        71 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(__desc, 71, Hoisted.effectivePeriodSer, null)
        72 ->
          timingRange =
            decoder.decodeNullableSerializableElement(__desc, 72, Hoisted.timingRangeSer, null)
        73 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(__desc, 73, Hoisted.timingDurationSer, null)
        74 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 74, Hoisted.subjectReferenceSer, null)
        75 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 75, Hoisted.participantSer, null)
        76 ->
          productReference =
            decoder.decodeNullableSerializableElement(__desc, 76, Hoisted.subjectReferenceSer, null)
        77 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              77,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        78 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 78, Hoisted.quantitySer, null)
        79 ->
          dosage = decoder.decodeNullableSerializableElement(__desc, 79, Hoisted.dosageSer, null)
        80 ->
          bodySite =
            decoder.decodeNullableSerializableElement(__desc, 80, Hoisted.jurisdictionSer, null)
        81 ->
          specimenRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              81,
              Hoisted.specimenRequirementSer,
              null,
            )
        82 ->
          observationRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              82,
              Hoisted.specimenRequirementSer,
              null,
            )
        83 ->
          observationResultRequirement =
            decoder.decodeNullableSerializableElement(
              __desc,
              83,
              Hoisted.specimenRequirementSer,
              null,
            )
        84 -> transform = decoder.decodeStringElement(__desc, 84)
        85 ->
          _transform =
            decoder.decodeNullableSerializableElement(__desc, 85, Hoisted.implicitRulesSer, null)
        86 ->
          dynamicValue =
            decoder.decodeNullableSerializableElement(__desc, 86, Hoisted.dynamicValueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ActivityDefinition: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      subject = ActivityDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4String.of(usage, _usage),
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
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { __i ->
          Canonical.of(library?.getOrNull(__i)?.let { it }, _library?.getOrNull(__i))!!
        }),
      kind =
        kind?.let { Enumeration.of(ActivityDefinition.RequestResourceType.fromCode(it), _kind) },
      profile = Canonical.of(profile, _profile),
      code = code,
      intent =
        intent?.let { Enumeration.of(ActivityDefinition.RequestIntent.fromCode(it), _intent) },
      priority =
        priority?.let {
          Enumeration.of(ActivityDefinition.RequestPriority.fromCode(it), _priority)
        },
      doNotPerform = R4Boolean.of(doNotPerform, _doNotPerform),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ActivityDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ActivityDefinition")
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
    ((value.subtitle?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 24, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.subject) {
      null -> {}
      is ActivityDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.subjectCodeableConceptSer, __d.value)
      }
      is ActivityDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(__desc, 27, Hoisted.subjectReferenceSer, __d.value)
      }
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
    }
    ((value.usage?.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 41, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 43, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 45, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        53,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 54, Hoisted.librarySer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 55, Hoisted.librarySer2, it)
    }
    ((value.kind?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 56, it) }
    (value.kind?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 57, Hoisted.implicitRulesSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(__desc, 58, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 59, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 60, Hoisted.subjectCodeableConceptSer, it)
    }
    ((value.intent?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 61, it) }
    (value.intent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 62, Hoisted.implicitRulesSer, it)
    }
    ((value.priority?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 63, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 64, Hoisted.implicitRulesSer, it)
    }
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(__desc, 65, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 66, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.timing) {
      null -> {}
      is ActivityDefinition.Timing.Timing -> {
        encoder.encodeSerializableElement(__desc, 67, Hoisted.timingTimingSer, __d.value)
      }
      is ActivityDefinition.Timing.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 68, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 69, Hoisted.implicitRulesSer, it)
        }
      }
      is ActivityDefinition.Timing.Age -> {
        encoder.encodeSerializableElement(__desc, 70, Hoisted.timingAgeSer, __d.value)
      }
      is ActivityDefinition.Timing.Period -> {
        encoder.encodeSerializableElement(__desc, 71, Hoisted.effectivePeriodSer, __d.value)
      }
      is ActivityDefinition.Timing.Range -> {
        encoder.encodeSerializableElement(__desc, 72, Hoisted.timingRangeSer, __d.value)
      }
      is ActivityDefinition.Timing.Duration -> {
        encoder.encodeSerializableElement(__desc, 73, Hoisted.timingDurationSer, __d.value)
      }
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 74, Hoisted.subjectReferenceSer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 75, Hoisted.participantSer, value.participant)
    when (val __d = value.product) {
      null -> {}
      is ActivityDefinition.Product.Reference -> {
        encoder.encodeSerializableElement(__desc, 76, Hoisted.subjectReferenceSer, __d.value)
      }
      is ActivityDefinition.Product.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 77, Hoisted.subjectCodeableConceptSer, __d.value)
      }
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 78, Hoisted.quantitySer, it) }
    if (value.dosage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 79, Hoisted.dosageSer, value.dosage)
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 80, Hoisted.jurisdictionSer, value.bodySite)
    if (value.specimenRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        81,
        Hoisted.specimenRequirementSer,
        value.specimenRequirement,
      )
    if (value.observationRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        82,
        Hoisted.specimenRequirementSer,
        value.observationRequirement,
      )
    if (value.observationResultRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        83,
        Hoisted.specimenRequirementSer,
        value.observationResultRequirement,
      )
    ((value.transform?.value))?.let { encoder.encodeStringElement(__desc, 84, it) }
    (value.transform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 85, Hoisted.implicitRulesSer, it)
    }
    if (value.dynamicValue.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 86, Hoisted.dynamicValueSer, value.dynamicValue)
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

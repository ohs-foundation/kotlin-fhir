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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.CarePlan
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
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

internal object CarePlanActivitySerializer : KSerializer<CarePlan.Activity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Activity") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("outcomeCodeableConcept", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("outcomeReference", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("progress", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
      optionalElement("detail", CarePlanActivityDetailSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CarePlan.Activity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CarePlan.Activity =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var outcomeCodeableConcept: List<CodeableConcept>? = null
      var outcomeReference: List<Reference>? = null
      var progress: List<Annotation>? = null
      var reference: Reference? = null
      var detail: CarePlan.Activity.Detail? = null
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
            outcomeCodeableConcept =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            outcomeReference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          5 ->
            progress =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          6 ->
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CarePlanActivityDetailSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Activity: " + i)
        }
      }
      CarePlan.Activity(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        outcomeCodeableConcept = outcomeCodeableConcept ?: listOf(),
        outcomeReference = outcomeReference ?: listOf(),
        progress = progress ?: listOf(),
        reference = reference,
        detail = detail,
      )
    }

  override fun serialize(encoder: Encoder, `value`: CarePlan.Activity) {
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
      if (value.outcomeCodeableConcept.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.outcomeCodeableConcept,
        )
      if (value.outcomeReference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ReferenceSerializer.listSerializer,
          value.outcomeReference,
        )
      if (value.progress.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          AnnotationSerializer.listSerializer,
          value.progress,
        )
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.reference)
      encodeSerializableIfNotNull(descriptor, 7, CarePlanActivityDetailSerializer, value.detail)
    }
  }
}

internal object CarePlanActivityDetailSerializer : KSerializer<CarePlan.Activity.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("kind", KotlinString.serializer().descriptor)
      optionalElement("_kind", ElementSerializer.descriptor)
      optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
      optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
      optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("goal", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("status", KotlinString.serializer().descriptor)
      optionalElement("_status", ElementSerializer.descriptor)
      optionalElement("statusReason", CodeableConceptSerializer.descriptor)
      optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
      optionalElement("_doNotPerform", ElementSerializer.descriptor)
      optionalElement("scheduledTiming", TimingSerializer.descriptor)
      optionalElement("scheduledPeriod", PeriodSerializer.descriptor)
      optionalElement("scheduledString", KotlinString.serializer().descriptor)
      optionalElement("_scheduledString", ElementSerializer.descriptor)
      optionalElement("location", ReferenceSerializer.descriptor)
      optionalElement("performer", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("productCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("productReference", ReferenceSerializer.descriptor)
      optionalElement("dailyAmount", QuantitySerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CarePlan.Activity.Detail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): CarePlan.Activity.Detail =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var kind: KotlinString? = null
      var _kind: Element? = null
      var instantiatesCanonical: List<KotlinString?>? = null
      var _instantiatesCanonical: List<Element?>? = null
      var instantiatesUri: List<KotlinString?>? = null
      var _instantiatesUri: List<Element?>? = null
      var code: CodeableConcept? = null
      var reasonCode: List<CodeableConcept>? = null
      var reasonReference: List<Reference>? = null
      var goal: List<Reference>? = null
      var status: KotlinString? = null
      var _status: Element? = null
      var statusReason: CodeableConcept? = null
      var doNotPerform: KotlinBoolean? = null
      var _doNotPerform: Element? = null
      var scheduledTiming: Timing? = null
      var scheduledPeriod: Period? = null
      var scheduledString: KotlinString? = null
      var _scheduledString: Element? = null
      var location: Reference? = null
      var performer: List<Reference>? = null
      var productCodeableConcept: CodeableConcept? = null
      var productReference: Reference? = null
      var dailyAmount: Quantity? = null
      var quantity: Quantity? = null
      var description: KotlinString? = null
      var _description: Element? = null
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
          3 -> kind = decodeStringElement(descriptor, i)
          4 -> _kind = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            instantiatesCanonical =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          6 ->
            _instantiatesCanonical =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          7 ->
            instantiatesUri =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          8 ->
            _instantiatesUri =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            reasonCode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          11 ->
            reasonReference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          12 ->
            goal =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          13 -> status = decodeStringElement(descriptor, i)
          14 -> _status = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            statusReason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          16 -> doNotPerform = decodeBooleanElement(descriptor, i)
          17 ->
            _doNotPerform =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 ->
            scheduledTiming =
              decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          19 ->
            scheduledPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          20 -> scheduledString = decodeStringElement(descriptor, i)
          21 ->
            _scheduledString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          22 ->
            location = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          23 ->
            performer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          24 ->
            productCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          25 ->
            productReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          26 ->
            dailyAmount = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          27 ->
            quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          28 -> description = decodeStringElement(descriptor, i)
          29 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Detail: " + i)
        }
      }
      CarePlan.Activity.Detail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        kind =
          Enumeration.of(
            if (kind != null) CarePlan.CarePlanActivityKind.fromCode(kind) else null,
            _kind,
          ),
        instantiatesCanonical =
          (kotlin.collections.List(
            maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
          ) { index ->
            Canonical.of(
              instantiatesCanonical?.getOrNull(index),
              _instantiatesCanonical?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'instantiatesCanonical' on CarePlan.Activity.Detail has neither a value nor an id/extension"
              )
          }),
        instantiatesUri =
          (kotlin.collections.List(
            maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)
          ) { index ->
            Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'instantiatesUri' on CarePlan.Activity.Detail has neither a value nor an id/extension"
              )
          }),
        code = code,
        reasonCode = reasonCode ?: listOf(),
        reasonReference = reasonReference ?: listOf(),
        goal = goal ?: listOf(),
        status =
          Enumeration.of(
            if (status != null) CarePlan.CarePlanActivityStatus.fromCode(status) else null,
            _status,
          )
            ?: throw SerializationException(
              "Missing required property 'status' on CarePlan.Activity.Detail"
            ),
        statusReason = statusReason,
        doNotPerform = R4bBoolean.of(doNotPerform, _doNotPerform),
        scheduled =
          CarePlan.Activity.Detail.Scheduled.from(
            scheduledTiming,
            scheduledPeriod,
            R4bString.of(scheduledString, _scheduledString),
          ),
        location = location,
        performer = performer ?: listOf(),
        product = CarePlan.Activity.Detail.Product.from(productCodeableConcept, productReference),
        dailyAmount = dailyAmount,
        quantity = quantity,
        description = R4bString.of(description, _description),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CarePlan.Activity.Detail) {
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
      encodeStringIfNotNull(descriptor, 3, value.kind?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.kind)
      if (value.instantiatesCanonical.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          stringNullableListSerializer,
          value.instantiatesCanonical.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.instantiatesCanonical)
      }
      if (value.instantiatesUri.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          stringNullableListSerializer,
          value.instantiatesUri.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 8, value.instantiatesUri)
      }
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.code)
      if (value.reasonCode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CodeableConceptSerializer.listSerializer,
          value.reasonCode,
        )
      if (value.reasonReference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          ReferenceSerializer.listSerializer,
          value.reasonReference,
        )
      if (value.goal.isNotEmpty())
        encodeSerializableElement(descriptor, 12, ReferenceSerializer.listSerializer, value.goal)
      encodeStringIfNotNull(descriptor, 13, value.status.value?.code)
      encodeElementIfNotNull(descriptor, 14, value.status)
      encodeSerializableIfNotNull(descriptor, 15, CodeableConceptSerializer, value.statusReason)
      encodeBooleanIfNotNull(descriptor, 16, value.doNotPerform?.value)
      encodeElementIfNotNull(descriptor, 17, value.doNotPerform)
      when (val choice = value.scheduled) {
        null -> {}
        is CarePlan.Activity.Detail.Scheduled.Timing -> {
          encodeSerializableElement(descriptor, 18, TimingSerializer, choice.value)
        }
        is CarePlan.Activity.Detail.Scheduled.Period -> {
          encodeSerializableElement(descriptor, 19, PeriodSerializer, choice.value)
        }
        is CarePlan.Activity.Detail.Scheduled.String -> {
          encodeStringIfNotNull(descriptor, 20, choice.value.value)
          encodeElementIfNotNull(descriptor, 21, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 22, ReferenceSerializer, value.location)
      if (value.performer.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          23,
          ReferenceSerializer.listSerializer,
          value.performer,
        )
      when (val choice = value.product) {
        null -> {}
        is CarePlan.Activity.Detail.Product.CodeableConcept -> {
          encodeSerializableElement(descriptor, 24, CodeableConceptSerializer, choice.value)
        }
        is CarePlan.Activity.Detail.Product.Reference -> {
          encodeSerializableElement(descriptor, 25, ReferenceSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 26, QuantitySerializer, value.dailyAmount)
      encodeSerializableIfNotNull(descriptor, 27, QuantitySerializer, value.quantity)
      encodeStringIfNotNull(descriptor, 28, value.description?.value)
      encodeElementIfNotNull(descriptor, 29, value.description)
    }
  }
}

internal object CarePlanSerializer : FhirResourceSerializer<CarePlan> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CarePlan")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("intent", KotlinString.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("created", KotlinString.serializer().descriptor)
    b.optionalElement("_created", ElementSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
    b.optionalElement("contributor", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("careTeam", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("addresses", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInfo", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("goal", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("activity", CarePlanActivitySerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): CarePlan {
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
    var identifier: List<Identifier>? = null
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var replaces: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var category: List<CodeableConcept>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var period: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var author: Reference? = null
    var contributor: List<Reference>? = null
    var careTeam: List<Reference>? = null
    var addresses: List<Reference>? = null
    var supportingInfo: List<Reference>? = null
    var goal: List<Reference>? = null
    var activity: List<CarePlan.Activity>? = null
    var note: List<Annotation>? = null
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 -> status = decoder.decodeStringElement(descriptor, i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> intent = decoder.decodeStringElement(descriptor, i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        23 -> title = decoder.decodeStringElement(descriptor, i)
        24 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> description = decoder.decodeStringElement(descriptor, i)
        26 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        30 -> created = decoder.decodeStringElement(descriptor, i)
        31 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        33 ->
          contributor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        34 ->
          careTeam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
          addresses =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        36 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 ->
          goal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        38 ->
          activity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CarePlanActivitySerializer.listSerializer,
              null,
            )
        39 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding CarePlan: " + i)
      }
    }
    return CarePlan(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(index),
            _instantiatesCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'instantiatesCanonical' on CarePlan has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on CarePlan has neither a value nor an id/extension"
            )
        }),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) CarePlan.RequestStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on CarePlan"),
      intent =
        Enumeration.of(
          if (intent != null) CarePlan.CarePlanIntent.fromCode(intent) else null,
          _intent,
        ) ?: throw SerializationException("Missing required property 'intent' on CarePlan"),
      category = category ?: listOf(),
      title = R4bString.of(title, _title),
      description = R4bString.of(description, _description),
      subject =
        subject ?: throw SerializationException("Missing required property 'subject' on CarePlan"),
      encounter = encounter,
      period = period,
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created),
      author = author,
      contributor = contributor ?: listOf(),
      careTeam = careTeam ?: listOf(),
      addresses = addresses ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      goal = goal ?: listOf(),
      activity = activity ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CarePlan,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.instantiatesCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.instantiatesUri)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.replaces,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.intent)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.description)
    encoder.encodeSerializableElement(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.created?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.created)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    if (value.contributor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.contributor,
      )
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.careTeam,
      )
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.addresses,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.goal,
      )
    if (value.activity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        CarePlanActivitySerializer.listSerializer,
        value.activity,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}

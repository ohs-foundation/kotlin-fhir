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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImmunizationEvaluation
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder

internal object ImmunizationEvaluationSerializer : FhirResourceSerializer<ImmunizationEvaluation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ImmunizationEvaluation")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("authority", ReferenceSerializer.descriptor)
    b.optionalElement("targetDisease", CodeableConceptSerializer.descriptor)
    b.optionalElement("immunizationEvent", ReferenceSerializer.descriptor)
    b.optionalElement("doseStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("doseStatusReason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("series", KotlinString.serializer().descriptor)
    b.optionalElement("_series", ElementSerializer.descriptor)
    b.optionalElement("doseNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_doseNumber", ElementSerializer.descriptor)
    b.optionalElement("seriesDoses", KotlinString.serializer().descriptor)
    b.optionalElement("_seriesDoses", ElementSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ImmunizationEvaluation {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var patient: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var authority: Reference? = null
    var targetDisease: CodeableConcept? = null
    var immunizationEvent: Reference? = null
    var doseStatus: CodeableConcept? = null
    var doseStatusReason: List<CodeableConcept>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var series: KotlinString? = null
    var _series: Element? = null
    var doseNumber: KotlinString? = null
    var _doseNumber: Element? = null
    var seriesDoses: KotlinString? = null
    var _seriesDoses: Element? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        14 -> date = decoder.decodeStringElement(descriptor, i)
        15 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          authority =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          targetDisease =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          immunizationEvent =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          doseStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 ->
          doseStatusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        21 -> description = decoder.decodeStringElement(descriptor, i)
        22 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> series = decoder.decodeStringElement(descriptor, i)
        24 ->
          _series =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> doseNumber = decoder.decodeStringElement(descriptor, i)
        26 ->
          _doseNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> seriesDoses = decoder.decodeStringElement(descriptor, i)
        28 ->
          _seriesDoses =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        else ->
          throw SerializationException("Unexpected index decoding ImmunizationEvaluation: " + i)
      }
    }
    return ImmunizationEvaluation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          if (status != null)
            ImmunizationEvaluation.ImmunizationEvaluationStatusCodes.fromCode(status)
          else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on ImmunizationEvaluation"
          ),
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on ImmunizationEvaluation"
          ),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      authority = authority,
      targetDisease =
        targetDisease
          ?: throw SerializationException(
            "Missing required property 'targetDisease' on ImmunizationEvaluation"
          ),
      immunizationEvent =
        immunizationEvent
          ?: throw SerializationException(
            "Missing required property 'immunizationEvent' on ImmunizationEvaluation"
          ),
      doseStatus =
        doseStatus
          ?: throw SerializationException(
            "Missing required property 'doseStatus' on ImmunizationEvaluation"
          ),
      doseStatusReason = doseStatusReason ?: listOf(),
      description = Markdown.of(description, _description),
      series = R5String.of(series, _series),
      doseNumber = R5String.of(doseNumber, _doseNumber),
      seriesDoses = R5String.of(seriesDoses, _seriesDoses),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImmunizationEvaluation,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.date)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.authority,
    )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.targetDisease,
    )
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.immunizationEvent,
    )
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.doseStatus,
    )
    if (value.doseStatusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.doseStatusReason,
      )
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.description)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.series?.value)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.series)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.doseNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.doseNumber)
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.seriesDoses?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.seriesDoses)
  }
}

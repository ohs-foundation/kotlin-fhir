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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImmunizationEvaluation
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object ImmunizationEvaluationSerializer : KSerializer<ImmunizationEvaluation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImmunizationEvaluation") {
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("authority", Reference.serializer().descriptor, isOptional = true)
      element("targetDisease", CodeableConcept.serializer().descriptor, isOptional = true)
      element("immunizationEvent", Reference.serializer().descriptor, isOptional = true)
      element("doseStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "doseStatusReason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("series", KotlinString.serializer().descriptor, isOptional = true)
      element("_series", Element.serializer().descriptor, isOptional = true)
      element("doseNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_doseNumber", Element.serializer().descriptor, isOptional = true)
      element("seriesDoses", KotlinString.serializer().descriptor, isOptional = true)
      element("_seriesDoses", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ImmunizationEvaluation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImmunizationEvaluation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ImmunizationEvaluation {
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
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.patientSer, null)
        15 -> date = decoder.decodeStringElement(__desc, 15)
        16 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          authority =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.patientSer, null)
        18 ->
          targetDisease =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.targetDiseaseSer, null)
        19 ->
          immunizationEvent =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.patientSer, null)
        20 ->
          doseStatus =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.targetDiseaseSer, null)
        21 ->
          doseStatusReason =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.doseStatusReasonSer, null)
        22 -> description = decoder.decodeStringElement(__desc, 22)
        23 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> series = decoder.decodeStringElement(__desc, 24)
        25 ->
          _series =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> doseNumber = decoder.decodeStringElement(__desc, 26)
        27 ->
          _doseNumber =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> seriesDoses = decoder.decodeStringElement(__desc, 28)
        29 ->
          _seriesDoses =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ImmunizationEvaluation: " + __i)
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
          ImmunizationEvaluation.ImmunizationEvaluationStatusCodes.fromCode(status!!),
          _status,
        ),
      patient = patient!!,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      authority = authority,
      targetDisease = targetDisease!!,
      immunizationEvent = immunizationEvent!!,
      doseStatus = doseStatus!!,
      doseStatusReason = doseStatusReason ?: listOf(),
      description = Markdown.of(description, _description),
      series = R5String.of(series, _series),
      doseNumber = R5String.of(doseNumber, _doseNumber),
      seriesDoses = R5String.of(seriesDoses, _seriesDoses),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImmunizationEvaluation) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ImmunizationEvaluation")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.patientSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    (value.authority)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.patientSer, it) }
    (value.targetDisease)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.targetDiseaseSer, it)
    }
    (value.immunizationEvent)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.patientSer, it)
    }
    (value.doseStatus)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.targetDiseaseSer, it)
    }
    if (value.doseStatusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        21,
        Hoisted.doseStatusReasonSer,
        value.doseStatusReason,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.series?.value))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.series?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.doseNumber?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.doseNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.seriesDoses?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.seriesDoses?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
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

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val targetDiseaseSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val doseStatusReasonSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.targetDiseaseSer)
  }
}

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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.ImmunizationEvaluation
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object ImmunizationEvaluationSerializer : KSerializer<ImmunizationEvaluation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImmunizationEvaluation") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("authority", Reference.serializer().descriptor, isOptional = true)
    b.element("targetDisease", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("immunizationEvent", Reference.serializer().descriptor, isOptional = true)
    b.element("doseStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "doseStatusReason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("series", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_series", Element.serializer().descriptor, isOptional = true)
    b.element("doseNumberPositiveInt", Int.serializer().descriptor, isOptional = true)
    b.element("_doseNumberPositiveInt", Element.serializer().descriptor, isOptional = true)
    b.element("doseNumberString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_doseNumberString", Element.serializer().descriptor, isOptional = true)
    b.element("seriesDosesPositiveInt", Int.serializer().descriptor, isOptional = true)
    b.element("_seriesDosesPositiveInt", Element.serializer().descriptor, isOptional = true)
    b.element("seriesDosesString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_seriesDosesString", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): ImmunizationEvaluation =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ImmunizationEvaluation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ImmunizationEvaluation")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
    var doseNumberPositiveInt: Int? = null
    var _doseNumberPositiveInt: Element? = null
    var doseNumberString: KotlinString? = null
    var _doseNumberString: Element? = null
    var seriesDosesPositiveInt: Int? = null
    var _seriesDosesPositiveInt: Element? = null
    var seriesDosesString: KotlinString? = null
    var _seriesDosesString: Element? = null
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        14 -> date = decoder.decodeStringElement(descriptor, i)
        15 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          authority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        17 ->
          targetDisease =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetDiseaseSer, null)
        18 ->
          immunizationEvent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        19 ->
          doseStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetDiseaseSer, null)
        20 ->
          doseStatusReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.doseStatusReasonSer,
              null,
            )
        21 -> description = decoder.decodeStringElement(descriptor, i)
        22 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> series = decoder.decodeStringElement(descriptor, i)
        24 ->
          _series =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> doseNumberPositiveInt = decoder.decodeIntElement(descriptor, i)
        26 ->
          _doseNumberPositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> doseNumberString = decoder.decodeStringElement(descriptor, i)
        28 ->
          _doseNumberString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> seriesDosesPositiveInt = decoder.decodeIntElement(descriptor, i)
        30 ->
          _seriesDosesPositiveInt =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 -> seriesDosesString = decoder.decodeStringElement(descriptor, i)
        32 ->
          _seriesDosesString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
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
      description = R4bString.of(description, _description),
      series = R4bString.of(series, _series),
      doseNumber =
        ImmunizationEvaluation.DoseNumber.from(
          PositiveInt.of(doseNumberPositiveInt, _doseNumberPositiveInt),
          R4bString.of(doseNumberString, _doseNumberString),
        ),
      seriesDoses =
        ImmunizationEvaluation.SeriesDoses.from(
          PositiveInt.of(seriesDosesPositiveInt, _seriesDosesPositiveInt),
          R4bString.of(seriesDosesString, _seriesDosesString),
        ),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImmunizationEvaluation,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.patientSer, it)
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.authority)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.targetDisease)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.targetDiseaseSer,
        it,
      )
    }
    (value.immunizationEvent)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.doseStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.targetDiseaseSer,
        it,
      )
    }
    if (value.doseStatusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.doseStatusReasonSer,
        value.doseStatusReason,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.series?.value))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.series?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val __d = value.doseNumber) {
      null -> {}
      is ImmunizationEvaluation.DoseNumber.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(descriptor, 25 + descriptorOffset, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            26 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ImmunizationEvaluation.DoseNumber.String -> {
        ((__d.value.value))?.let {
          encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            28 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    when (val __d = value.seriesDoses) {
      null -> {}
      is ImmunizationEvaluation.SeriesDoses.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(descriptor, 29 + descriptorOffset, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            30 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is ImmunizationEvaluation.SeriesDoses.String -> {
        ((__d.value.value))?.let {
          encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            32 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
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

internal object ImmunizationEvaluationPolymorphicSerializer : KSerializer<ImmunizationEvaluation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImmunizationEvaluation") {
      ImmunizationEvaluationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImmunizationEvaluation) {
    encoder.encodeStructure(descriptor) {
      ImmunizationEvaluationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ImmunizationEvaluation =
    decoder.decodeStructure(descriptor) {
      ImmunizationEvaluationSerializer.deserializeInternal(this, descriptor, 0)
    }
}

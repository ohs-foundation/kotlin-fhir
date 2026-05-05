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
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.ImmunizationRecommendation
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object ImmunizationRecommendationRecommendationSerializer :
  KSerializer<ImmunizationRecommendation.Recommendation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Recommendation") {
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
        "vaccineCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "targetDisease",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "contraindicatedVaccineCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("forecastStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "forecastReason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "dateCriterion",
        listSerialDescriptor(
          lazyDescriptor {
            ImmunizationRecommendation.Recommendation.DateCriterion.serializer().descriptor
          }
        ),
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
      element(
        "supportingImmunization",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "supportingPatientInformation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation.Recommendation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImmunizationRecommendation.Recommendation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ImmunizationRecommendation.Recommendation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var vaccineCode: List<CodeableConcept>? = null
    var targetDisease: List<CodeableConcept>? = null
    var contraindicatedVaccineCode: List<CodeableConcept>? = null
    var forecastStatus: CodeableConcept? = null
    var forecastReason: List<CodeableConcept>? = null
    var dateCriterion: List<ImmunizationRecommendation.Recommendation.DateCriterion>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var series: KotlinString? = null
    var _series: Element? = null
    var doseNumber: KotlinString? = null
    var _doseNumber: Element? = null
    var seriesDoses: KotlinString? = null
    var _seriesDoses: Element? = null
    var supportingImmunization: List<Reference>? = null
    var supportingPatientInformation: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          vaccineCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.vaccineCodeSer, null)
        4 ->
          targetDisease =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.vaccineCodeSer, null)
        5 ->
          contraindicatedVaccineCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.vaccineCodeSer, null)
        6 ->
          forecastStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.vaccineCodeSerInner,
              null,
            )
        7 ->
          forecastReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.vaccineCodeSer, null)
        8 ->
          dateCriterion =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateCriterionSer, null)
        9 -> description = decoder.decodeStringElement(__desc, __i)
        10 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        11 -> series = decoder.decodeStringElement(__desc, __i)
        12 ->
          _series =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        13 -> doseNumber = decoder.decodeStringElement(__desc, __i)
        14 ->
          _doseNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        15 -> seriesDoses = decoder.decodeStringElement(__desc, __i)
        16 ->
          _seriesDoses =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        17 ->
          supportingImmunization =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.supportingImmunizationSer,
              null,
            )
        18 ->
          supportingPatientInformation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.supportingImmunizationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Recommendation: " + __i)
      }
    }
    return ImmunizationRecommendation.Recommendation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      vaccineCode = vaccineCode ?: listOf(),
      targetDisease = targetDisease ?: listOf(),
      contraindicatedVaccineCode = contraindicatedVaccineCode ?: listOf(),
      forecastStatus = forecastStatus!!,
      forecastReason = forecastReason ?: listOf(),
      dateCriterion = dateCriterion ?: listOf(),
      description = Markdown.of(description, _description),
      series = R5String.of(series, _series),
      doseNumber = R5String.of(doseNumber, _doseNumber),
      seriesDoses = R5String.of(seriesDoses, _seriesDoses),
      supportingImmunization = supportingImmunization ?: listOf(),
      supportingPatientInformation = supportingPatientInformation ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ImmunizationRecommendation.Recommendation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.vaccineCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.vaccineCodeSer, value.vaccineCode)
    if (value.targetDisease.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.vaccineCodeSer, value.targetDisease)
    if (value.contraindicatedVaccineCode.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        5,
        Hoisted.vaccineCodeSer,
        value.contraindicatedVaccineCode,
      )
    (value.forecastStatus)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.vaccineCodeSerInner, it)
    }
    if (value.forecastReason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.vaccineCodeSer, value.forecastReason)
    if (value.dateCriterion.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.dateCriterionSer, value.dateCriterion)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.descriptionSer, it)
    }
    ((value.series?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.series?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.descriptionSer, it)
    }
    ((value.doseNumber?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.doseNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.descriptionSer, it)
    }
    ((value.seriesDoses?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.seriesDoses?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.descriptionSer, it)
    }
    if (value.supportingImmunization.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        17,
        Hoisted.supportingImmunizationSer,
        value.supportingImmunization,
      )
    if (value.supportingPatientInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        18,
        Hoisted.supportingImmunizationSer,
        value.supportingPatientInformation,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val vaccineCodeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val vaccineCodeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.vaccineCodeSerInner)

    public val dateCriterionSerInner:
      KSerializer<ImmunizationRecommendation.Recommendation.DateCriterion> =
      ImmunizationRecommendation.Recommendation.DateCriterion.serializer()

    public val dateCriterionSer:
      KSerializer<List<ImmunizationRecommendation.Recommendation.DateCriterion>> =
      ListSerializer(Hoisted.dateCriterionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val supportingImmunizationSerInner: KSerializer<Reference> = Reference.serializer()

    public val supportingImmunizationSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.supportingImmunizationSerInner)
  }
}

internal object ImmunizationRecommendationRecommendationDateCriterionSerializer :
  KSerializer<ImmunizationRecommendation.Recommendation.DateCriterion> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DateCriterion") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): ImmunizationRecommendation.Recommendation.DateCriterion =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: ImmunizationRecommendation.Recommendation.DateCriterion,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ImmunizationRecommendation.Recommendation.DateCriterion {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 -> `value` = decoder.decodeStringElement(__desc, __i)
        5 -> _value = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DateCriterion: " + __i)
      }
    }
    return ImmunizationRecommendation.Recommendation.DateCriterion(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      `value` = DateTime.of(FhirDateTime.fromString(`value`), _value)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ImmunizationRecommendation.Recommendation.DateCriterion,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.`value`.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ImmunizationRecommendationSerializer : KSerializer<ImmunizationRecommendation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImmunizationRecommendation") {
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
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("authority", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "recommendation",
      listSerialDescriptor(
        lazyDescriptor { ImmunizationRecommendation.Recommendation.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ImmunizationRecommendation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ImmunizationRecommendation")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): ImmunizationRecommendation {
    val __desc = desc
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
    var patient: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var authority: Reference? = null
    var recommendation: List<ImmunizationRecommendation.Recommendation>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          patient = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        12 -> date = decoder.decodeStringElement(__desc, __i)
        13 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 ->
          authority =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        15 ->
          recommendation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.recommendationSer, null)
        else ->
          throw SerializationException(
            "Unexpected index decoding ImmunizationRecommendation: " + __i
          )
      }
    }
    return ImmunizationRecommendation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      patient = patient!!,
      date = DateTime.of(FhirDateTime.fromString(date), _date)!!,
      authority = authority,
      recommendation = recommendation ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: ImmunizationRecommendation,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.patientSer, it)
    }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.authority)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.patientSer, it)
    }
    if (value.recommendation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15 + __off,
        Hoisted.recommendationSer,
        value.recommendation,
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

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val recommendationSerInner: KSerializer<ImmunizationRecommendation.Recommendation> =
      ImmunizationRecommendation.Recommendation.serializer()

    public val recommendationSer: KSerializer<List<ImmunizationRecommendation.Recommendation>> =
      ListSerializer(Hoisted.recommendationSerInner)
  }
}

internal object ImmunizationRecommendationPolymorphicSerializer :
  KSerializer<ImmunizationRecommendation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ImmunizationRecommendation") {
      ImmunizationRecommendationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ImmunizationRecommendation) {
    encoder.encodeStructure(descriptor) {
      ImmunizationRecommendationSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation =
    decoder.decodeStructure(descriptor) {
      ImmunizationRecommendationSerializer.deserializeJson(this, descriptor, 0)
    }
}

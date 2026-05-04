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

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.ImmunizationRecommendation
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
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
      element("targetDisease", CodeableConcept.serializer().descriptor, isOptional = true)
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
      element("doseNumberPositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_doseNumberPositiveInt", Element.serializer().descriptor, isOptional = true)
      element("doseNumberString", KotlinString.serializer().descriptor, isOptional = true)
      element("_doseNumberString", Element.serializer().descriptor, isOptional = true)
      element("seriesDosesPositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_seriesDosesPositiveInt", Element.serializer().descriptor, isOptional = true)
      element("seriesDosesString", KotlinString.serializer().descriptor, isOptional = true)
      element("_seriesDosesString", Element.serializer().descriptor, isOptional = true)
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
    var targetDisease: CodeableConcept? = null
    var contraindicatedVaccineCode: List<CodeableConcept>? = null
    var forecastStatus: CodeableConcept? = null
    var forecastReason: List<CodeableConcept>? = null
    var dateCriterion: List<ImmunizationRecommendation.Recommendation.DateCriterion>? = null
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
    var supportingImmunization: List<Reference>? = null
    var supportingPatientInformation: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          vaccineCode =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.vaccineCodeSer, null)
        4 ->
          targetDisease =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.vaccineCodeSerInner, null)
        5 ->
          contraindicatedVaccineCode =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.vaccineCodeSer, null)
        6 ->
          forecastStatus =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.vaccineCodeSerInner, null)
        7 ->
          forecastReason =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.vaccineCodeSer, null)
        8 ->
          dateCriterion =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.dateCriterionSer, null)
        9 -> description = decoder.decodeStringElement(__desc, 9)
        10 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.descriptionSer, null)
        11 -> series = decoder.decodeStringElement(__desc, 11)
        12 ->
          _series =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.descriptionSer, null)
        13 -> doseNumberPositiveInt = decoder.decodeIntElement(__desc, 13)
        14 ->
          _doseNumberPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.descriptionSer, null)
        15 -> doseNumberString = decoder.decodeStringElement(__desc, 15)
        16 ->
          _doseNumberString =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.descriptionSer, null)
        17 -> seriesDosesPositiveInt = decoder.decodeIntElement(__desc, 17)
        18 ->
          _seriesDosesPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.descriptionSer, null)
        19 -> seriesDosesString = decoder.decodeStringElement(__desc, 19)
        20 ->
          _seriesDosesString =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.descriptionSer, null)
        21 ->
          supportingImmunization =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.supportingImmunizationSer,
              null,
            )
        22 ->
          supportingPatientInformation =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
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
      targetDisease = targetDisease,
      contraindicatedVaccineCode = contraindicatedVaccineCode ?: listOf(),
      forecastStatus = forecastStatus!!,
      forecastReason = forecastReason ?: listOf(),
      dateCriterion = dateCriterion ?: listOf(),
      description = R4String.of(description, _description),
      series = R4String.of(series, _series),
      doseNumber =
        ImmunizationRecommendation.Recommendation.DoseNumber.from(
          PositiveInt.of(doseNumberPositiveInt, _doseNumberPositiveInt),
          R4String.of(doseNumberString, _doseNumberString),
        ),
      seriesDoses =
        ImmunizationRecommendation.Recommendation.SeriesDoses.from(
          PositiveInt.of(seriesDosesPositiveInt, _seriesDosesPositiveInt),
          R4String.of(seriesDosesString, _seriesDosesString),
        ),
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
    (value.targetDisease)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.vaccineCodeSerInner, it)
    }
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
    when (val __d = value.doseNumber) {
      null -> {}
      is ImmunizationRecommendation.Recommendation.DoseNumber.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.descriptionSer, it)
        }
      }
      is ImmunizationRecommendation.Recommendation.DoseNumber.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.descriptionSer, it)
        }
      }
    }
    when (val __d = value.seriesDoses) {
      null -> {}
      is ImmunizationRecommendation.Recommendation.SeriesDoses.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.descriptionSer, it)
        }
      }
      is ImmunizationRecommendation.Recommendation.SeriesDoses.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.descriptionSer, it)
        }
      }
    }
    if (value.supportingImmunization.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        21,
        Hoisted.supportingImmunizationSer,
        value.supportingImmunization,
      )
    if (value.supportingPatientInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22,
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> `value` = decoder.decodeStringElement(__desc, 4)
        5 -> _value = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueSer, null)
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
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("authority", Reference.serializer().descriptor, isOptional = true)
      element(
        "recommendation",
        listSerialDescriptor(
          lazyDescriptor { ImmunizationRecommendation.Recommendation.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ImmunizationRecommendation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ImmunizationRecommendation {
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
    var patient: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var authority: Reference? = null
    var recommendation: List<ImmunizationRecommendation.Recommendation>? = null
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
        12 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.patientSer, null)
        13 -> date = decoder.decodeStringElement(__desc, 13)
        14 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          authority =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.patientSer, null)
        16 ->
          recommendation =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.recommendationSer, null)
        CompositeDecoder.DECODE_DONE -> break
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ImmunizationRecommendation) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ImmunizationRecommendation")
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
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.patientSer, it) }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.authority)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.patientSer, it) }
    if (value.recommendation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.recommendationSer, value.recommendation)
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

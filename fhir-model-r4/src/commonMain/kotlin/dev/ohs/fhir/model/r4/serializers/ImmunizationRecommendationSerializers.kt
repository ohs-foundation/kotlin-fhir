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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.ImmunizationRecommendation
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object ImmunizationRecommendationRecommendationSerializer :
  FhirSerializer<ImmunizationRecommendation.Recommendation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Recommendation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ImmunizationRecommendation.Recommendation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("vaccineCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("targetDisease", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "contraindicatedVaccineCode",
      CodeableConceptSerializer.listSerializer.descriptor,
    )
    b.optionalElement("forecastStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("forecastReason", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "dateCriterion",
      ImmunizationRecommendationRecommendationDateCriterionSerializer.listSerializer.descriptor,
    )
    b.strPrim("description")
    b.strPrim("series")
    b.intPrim("doseNumberPositiveInt")
    b.strPrim("doseNumberString")
    b.intPrim("seriesDosesPositiveInt")
    b.strPrim("seriesDosesString")
    b.optionalElement("supportingImmunization", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("supportingPatientInformation", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation.Recommendation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          vaccineCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          targetDisease =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          contraindicatedVaccineCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 ->
          forecastStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          forecastReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          dateCriterion =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationRecommendationRecommendationDateCriterionSerializer.listSerializer,
              null,
            )
        9 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> series = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _series =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> doseNumberPositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        14 ->
          _doseNumberPositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> doseNumberString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _doseNumberString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> seriesDosesPositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        18 ->
          _seriesDosesPositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> seriesDosesString = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _seriesDosesString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          supportingImmunization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          supportingPatientInformation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ImmunizationRecommendation.Recommendation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      vaccineCode = listOrEmpty(vaccineCode),
      targetDisease = targetDisease,
      contraindicatedVaccineCode = listOrEmpty(contraindicatedVaccineCode),
      forecastStatus =
        required(forecastStatus, "ImmunizationRecommendation.Recommendation", "forecastStatus"),
      forecastReason = listOrEmpty(forecastReason),
      dateCriterion = listOrEmpty(dateCriterion),
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
      supportingImmunization = listOrEmpty(supportingImmunization),
      supportingPatientInformation = listOrEmpty(supportingPatientInformation),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ImmunizationRecommendation.Recommendation) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      CodeableConceptSerializer.listSerializer,
      value.vaccineCode,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.targetDisease,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      CodeableConceptSerializer.listSerializer,
      value.contraindicatedVaccineCode,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.forecastStatus,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.forecastReason,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      ImmunizationRecommendationRecommendationDateCriterionSerializer.listSerializer,
      value.dateCriterion,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.series?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.series)
    when (val choice = value.doseNumber) {
      null -> {}
      is ImmunizationRecommendation.Recommendation.DoseNumber.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 13, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is ImmunizationRecommendation.Recommendation.DoseNumber.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 15, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
    }
    when (val choice = value.seriesDoses) {
      null -> {}
      is ImmunizationRecommendation.Recommendation.SeriesDoses.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 17, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is ImmunizationRecommendation.Recommendation.SeriesDoses.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 19, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 20, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21,
      ReferenceSerializer.listSerializer,
      value.supportingImmunization,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22,
      ReferenceSerializer.listSerializer,
      value.supportingPatientInformation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImmunizationRecommendationRecommendationDateCriterionSerializer :
  FhirSerializer<ImmunizationRecommendation.Recommendation.DateCriterion> {
  override val descriptor: SerialDescriptor = buildDescriptor("DateCriterion", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<ImmunizationRecommendation.Recommendation.DateCriterion>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.strPrim("value")
  }

  override fun deserialize(
    decoder: Decoder
  ): ImmunizationRecommendation.Recommendation.DateCriterion {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var `value`: FhirDateTime? = null
    var _value: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> `value` = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ImmunizationRecommendation.Recommendation.DateCriterion(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "ImmunizationRecommendation.Recommendation.DateCriterion", "code"),
      `value` =
        required(
          DateTime.of(`value`, _value),
          "ImmunizationRecommendation.Recommendation.DateCriterion",
          "value",
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: ImmunizationRecommendation.Recommendation.DateCriterion,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.`value`.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ImmunizationRecommendationSerializer :
  FhirResourceSerializer<ImmunizationRecommendation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ImmunizationRecommendation")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.strPrim("date")
    b.optionalElement("authority", ReferenceSerializer.descriptor)
    b.optionalElement(
      "recommendation",
      ImmunizationRecommendationRecommendationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ImmunizationRecommendation {
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
    var date: FhirDateTime? = null
    var _date: Element? = null
    var authority: Reference? = null
    var recommendation: List<ImmunizationRecommendation.Recommendation>? = null
    while (true) {
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        12 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          authority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        15 ->
          recommendation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ImmunizationRecommendationRecommendationSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return ImmunizationRecommendation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      patient = required(patient, "ImmunizationRecommendation", "patient"),
      date = required(DateTime.of(date, _date), "ImmunizationRecommendation", "date"),
      authority = authority,
      recommendation = listOrEmpty(recommendation),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ImmunizationRecommendation,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.date.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.authority,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      ImmunizationRecommendationRecommendationSerializer.listSerializer,
      value.recommendation,
    )
  }
}

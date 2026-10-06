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

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.EffectEvidenceSynthesis
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object EffectEvidenceSynthesisSampleSizeSerializer :
  KSerializer<EffectEvidenceSynthesis.SampleSize> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SampleSize") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("numberOfStudies", Int.serializer().descriptor)
      optionalElement("_numberOfStudies", ElementSerializer.descriptor)
      optionalElement("numberOfParticipants", Int.serializer().descriptor)
      optionalElement("_numberOfParticipants", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EffectEvidenceSynthesis.SampleSize>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.SampleSize =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var numberOfStudies: Int? = null
      var _numberOfStudies: Element? = null
      var numberOfParticipants: Int? = null
      var _numberOfParticipants: Element? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> numberOfStudies = decodeIntElement(descriptor, i)
          6 ->
            _numberOfStudies =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> numberOfParticipants = decodeIntElement(descriptor, i)
          8 ->
            _numberOfParticipants =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SampleSize: " + i)
        }
      }
      EffectEvidenceSynthesis.SampleSize(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4String.of(description, _description),
        numberOfStudies = Integer.of(numberOfStudies, _numberOfStudies),
        numberOfParticipants = Integer.of(numberOfParticipants, _numberOfParticipants),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.SampleSize) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeIntIfNotNull(descriptor, 5, value.numberOfStudies?.value)
      encodeElementIfNotNull(descriptor, 6, value.numberOfStudies)
      encodeIntIfNotNull(descriptor, 7, value.numberOfParticipants?.value)
      encodeElementIfNotNull(descriptor, 8, value.numberOfParticipants)
    }
  }
}

internal object EffectEvidenceSynthesisResultsByExposureSerializer :
  KSerializer<EffectEvidenceSynthesis.ResultsByExposure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResultsByExposure") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("exposureState", KotlinString.serializer().descriptor)
      optionalElement("_exposureState", ElementSerializer.descriptor)
      optionalElement("variantState", CodeableConceptSerializer.descriptor)
      optionalElement("riskEvidenceSynthesis", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EffectEvidenceSynthesis.ResultsByExposure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.ResultsByExposure =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var exposureState: KotlinString? = null
      var _exposureState: Element? = null
      var variantState: CodeableConcept? = null
      var riskEvidenceSynthesis: Reference? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> exposureState = decodeStringElement(descriptor, i)
          6 ->
            _exposureState =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            variantState =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            riskEvidenceSynthesis =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ResultsByExposure: " + i)
        }
      }
      EffectEvidenceSynthesis.ResultsByExposure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4String.of(description, _description),
        exposureState =
          Enumeration.of(
            if (exposureState != null) EffectEvidenceSynthesis.ExposureState.fromCode(exposureState)
            else null,
            _exposureState,
          ),
        variantState = variantState,
        riskEvidenceSynthesis =
          riskEvidenceSynthesis
            ?: throw SerializationException(
              "Missing required property 'riskEvidenceSynthesis' on EffectEvidenceSynthesis.ResultsByExposure"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.ResultsByExposure) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeStringIfNotNull(descriptor, 5, value.exposureState?.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.exposureState)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.variantState)
      encodeSerializableElement(descriptor, 8, ReferenceSerializer, value.riskEvidenceSynthesis)
    }
  }
}

internal object EffectEvidenceSynthesisEffectEstimateSerializer :
  KSerializer<EffectEvidenceSynthesis.EffectEstimate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EffectEstimate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("variantState", CodeableConceptSerializer.descriptor)
      optionalElement("value", FhirDecimalSerializer.descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("unitOfMeasure", CodeableConceptSerializer.descriptor)
      optionalElement(
        "precisionEstimate",
        EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<EffectEvidenceSynthesis.EffectEstimate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.EffectEstimate =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var type: CodeableConcept? = null
      var variantState: CodeableConcept? = null
      var `value`: FhirDecimal? = null
      var _value: Element? = null
      var unitOfMeasure: CodeableConcept? = null
      var precisionEstimate: List<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate>? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            variantState =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            `value` = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          8 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            unitOfMeasure =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            precisionEstimate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding EffectEstimate: " + i)
        }
      }
      EffectEvidenceSynthesis.EffectEstimate(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4String.of(description, _description),
        type = type,
        variantState = variantState,
        `value` = Decimal.of(`value`, _value),
        unitOfMeasure = unitOfMeasure,
        precisionEstimate = precisionEstimate ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.EffectEstimate) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.variantState)
      encodeSerializableIfNotNull(descriptor, 7, FhirDecimalSerializer, value.`value`?.value)
      encodeElementIfNotNull(descriptor, 8, value.`value`)
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.unitOfMeasure)
      if (value.precisionEstimate.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSerializer.listSerializer,
          value.precisionEstimate,
        )
    }
  }
}

internal object EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSerializer :
  KSerializer<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PrecisionEstimate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("level", FhirDecimalSerializer.descriptor)
      optionalElement("_level", ElementSerializer.descriptor)
      optionalElement("from", FhirDecimalSerializer.descriptor)
      optionalElement("_from", ElementSerializer.descriptor)
      optionalElement("to", FhirDecimalSerializer.descriptor)
      optionalElement("_to", ElementSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var level: FhirDecimal? = null
      var _level: Element? = null
      var from: FhirDecimal? = null
      var _from: Element? = null
      var to: FhirDecimal? = null
      var _to: Element? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> level = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          5 -> _level = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> from = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          7 -> _from = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> to = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          9 -> _to = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PrecisionEstimate: " + i)
        }
      }
      EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        level = Decimal.of(level, _level),
        from = Decimal.of(from, _from),
        to = Decimal.of(to, _to),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, FhirDecimalSerializer, value.level?.value)
      encodeElementIfNotNull(descriptor, 5, value.level)
      encodeSerializableIfNotNull(descriptor, 6, FhirDecimalSerializer, value.from?.value)
      encodeElementIfNotNull(descriptor, 7, value.from)
      encodeSerializableIfNotNull(descriptor, 8, FhirDecimalSerializer, value.to?.value)
      encodeElementIfNotNull(descriptor, 9, value.to)
    }
  }
}

internal object EffectEvidenceSynthesisCertaintySerializer :
  KSerializer<EffectEvidenceSynthesis.Certainty> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Certainty") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("rating", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement(
        "certaintySubcomponent",
        EffectEvidenceSynthesisCertaintyCertaintySubcomponentSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<EffectEvidenceSynthesis.Certainty>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.Certainty =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var rating: List<CodeableConcept>? = null
      var note: List<Annotation>? = null
      var certaintySubcomponent: List<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent>? =
        null
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
            rating =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          5 ->
            certaintySubcomponent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EffectEvidenceSynthesisCertaintyCertaintySubcomponentSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Certainty: " + i)
        }
      }
      EffectEvidenceSynthesis.Certainty(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        rating = rating ?: listOf(),
        note = note ?: listOf(),
        certaintySubcomponent = certaintySubcomponent ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.Certainty) {
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
      if (value.rating.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.rating,
        )
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 4, AnnotationSerializer.listSerializer, value.note)
      if (value.certaintySubcomponent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          EffectEvidenceSynthesisCertaintyCertaintySubcomponentSerializer.listSerializer,
          value.certaintySubcomponent,
        )
    }
  }
}

internal object EffectEvidenceSynthesisCertaintyCertaintySubcomponentSerializer :
  KSerializer<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CertaintySubcomponent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("rating", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): EffectEvidenceSynthesis.Certainty.CertaintySubcomponent =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var rating: List<CodeableConcept>? = null
      var note: List<Annotation>? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            rating =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding CertaintySubcomponent: " + i)
        }
      }
      EffectEvidenceSynthesis.Certainty.CertaintySubcomponent(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        rating = rating ?: listOf(),
        note = note ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: EffectEvidenceSynthesis.Certainty.CertaintySubcomponent,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      if (value.rating.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.rating,
        )
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 5, AnnotationSerializer.listSerializer, value.note)
    }
  }
}

internal object EffectEvidenceSynthesisSerializer :
  FhirResourceSerializer<EffectEvidenceSynthesis> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("EffectEvidenceSynthesis")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("synthesisType", CodeableConceptSerializer.descriptor)
    b.optionalElement("studyType", CodeableConceptSerializer.descriptor)
    b.optionalElement("population", ReferenceSerializer.descriptor)
    b.optionalElement("exposure", ReferenceSerializer.descriptor)
    b.optionalElement("exposureAlternative", ReferenceSerializer.descriptor)
    b.optionalElement("outcome", ReferenceSerializer.descriptor)
    b.optionalElement("sampleSize", EffectEvidenceSynthesisSampleSizeSerializer.descriptor)
    b.optionalElement(
      "resultsByExposure",
      EffectEvidenceSynthesisResultsByExposureSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "effectEstimate",
      EffectEvidenceSynthesisEffectEstimateSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "certainty",
      EffectEvidenceSynthesisCertaintySerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): EffectEvidenceSynthesis {
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
    var synthesisType: CodeableConcept? = null
    var studyType: CodeableConcept? = null
    var population: Reference? = null
    var exposure: Reference? = null
    var exposureAlternative: Reference? = null
    var outcome: Reference? = null
    var sampleSize: EffectEvidenceSynthesis.SampleSize? = null
    var resultsByExposure: List<EffectEvidenceSynthesis.ResultsByExposure>? = null
    var effectEstimate: List<EffectEvidenceSynthesis.EffectEstimate>? = null
    var certainty: List<EffectEvidenceSynthesis.Certainty>? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> date = decoder.decodeStringElement(descriptor, i)
        22 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> publisher = decoder.decodeStringElement(descriptor, i)
        24 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        26 -> description = decoder.decodeStringElement(descriptor, i)
        27 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        29 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        30 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 -> copyright = decoder.decodeStringElement(descriptor, i)
        32 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        34 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        36 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        38 ->
          topic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        39 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        40 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        41 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        42 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        43 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        44 ->
          synthesisType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        45 ->
          studyType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        46 ->
          population =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        47 ->
          exposure =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        48 ->
          exposureAlternative =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        49 ->
          outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        50 ->
          sampleSize =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EffectEvidenceSynthesisSampleSizeSerializer,
              null,
            )
        51 ->
          resultsByExposure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EffectEvidenceSynthesisResultsByExposureSerializer.listSerializer,
              null,
            )
        52 ->
          effectEstimate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EffectEvidenceSynthesisEffectEstimateSerializer.listSerializer,
              null,
            )
        53 ->
          certainty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EffectEvidenceSynthesisCertaintySerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding EffectEvidenceSynthesis: " + i)
      }
    }
    return EffectEvidenceSynthesis(
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
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on EffectEvidenceSynthesis"
          ),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      synthesisType = synthesisType,
      studyType = studyType,
      population =
        population
          ?: throw SerializationException(
            "Missing required property 'population' on EffectEvidenceSynthesis"
          ),
      exposure =
        exposure
          ?: throw SerializationException(
            "Missing required property 'exposure' on EffectEvidenceSynthesis"
          ),
      exposureAlternative =
        exposureAlternative
          ?: throw SerializationException(
            "Missing required property 'exposureAlternative' on EffectEvidenceSynthesis"
          ),
      outcome =
        outcome
          ?: throw SerializationException(
            "Missing required property 'outcome' on EffectEvidenceSynthesis"
          ),
      sampleSize = sampleSize,
      resultsByExposure = resultsByExposure ?: listOf(),
      effectEstimate = effectEstimate ?: listOf(),
      certainty = certainty ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: EffectEvidenceSynthesis,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.description)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      CodeableConceptSerializer,
      value.synthesisType,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      CodeableConceptSerializer,
      value.studyType,
    )
    encoder.encodeSerializableElement(
      descriptor,
      46 + descriptorOffset,
      ReferenceSerializer,
      value.population,
    )
    encoder.encodeSerializableElement(
      descriptor,
      47 + descriptorOffset,
      ReferenceSerializer,
      value.exposure,
    )
    encoder.encodeSerializableElement(
      descriptor,
      48 + descriptorOffset,
      ReferenceSerializer,
      value.exposureAlternative,
    )
    encoder.encodeSerializableElement(
      descriptor,
      49 + descriptorOffset,
      ReferenceSerializer,
      value.outcome,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      50 + descriptorOffset,
      EffectEvidenceSynthesisSampleSizeSerializer,
      value.sampleSize,
    )
    if (value.resultsByExposure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        EffectEvidenceSynthesisResultsByExposureSerializer.listSerializer,
        value.resultsByExposure,
      )
    if (value.effectEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        EffectEvidenceSynthesisEffectEstimateSerializer.listSerializer,
        value.effectEstimate,
      )
    if (value.certainty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        EffectEvidenceSynthesisCertaintySerializer.listSerializer,
        value.certainty,
      )
  }
}

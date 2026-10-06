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

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
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
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object DosageDoseAndRateSerializer : KSerializer<Dosage.DoseAndRate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DoseAndRate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("doseRange", RangeSerializer.descriptor)
      optionalElement("doseQuantity", QuantitySerializer.descriptor)
      optionalElement("rateRatio", RatioSerializer.descriptor)
      optionalElement("rateRange", RangeSerializer.descriptor)
      optionalElement("rateQuantity", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Dosage.DoseAndRate>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Dosage.DoseAndRate =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var type: CodeableConcept? = null
      var doseRange: Range? = null
      var doseQuantity: Quantity? = null
      var rateRatio: Ratio? = null
      var rateRange: Range? = null
      var rateQuantity: Quantity? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          3 -> doseRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          4 ->
            doseQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 -> rateRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          6 -> rateRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          7 ->
            rateQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DoseAndRate: " + i)
        }
      }
      Dosage.DoseAndRate(
        id = id,
        extension = extension ?: listOf(),
        type = type,
        dose = Dosage.DoseAndRate.Dose.from(doseRange, doseQuantity),
        rate = Dosage.DoseAndRate.Rate.from(rateRatio, rateRange, rateQuantity),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Dosage.DoseAndRate) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeSerializableIfNotNull(descriptor, 2, CodeableConceptSerializer, value.type)
      when (val choice = value.dose) {
        null -> {}
        is Dosage.DoseAndRate.Dose.Range -> {
          encodeSerializableElement(descriptor, 3, RangeSerializer, choice.value)
        }
        is Dosage.DoseAndRate.Dose.Quantity -> {
          encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
        }
      }
      when (val choice = value.rate) {
        null -> {}
        is Dosage.DoseAndRate.Rate.Ratio -> {
          encodeSerializableElement(descriptor, 5, RatioSerializer, choice.value)
        }
        is Dosage.DoseAndRate.Rate.Range -> {
          encodeSerializableElement(descriptor, 6, RangeSerializer, choice.value)
        }
        is Dosage.DoseAndRate.Rate.Quantity -> {
          encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
        }
      }
    }
  }
}

internal object DosageSerializer : KSerializer<Dosage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("additionalInstruction", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("patientInstruction", KotlinString.serializer().descriptor)
      optionalElement("_patientInstruction", ElementSerializer.descriptor)
      optionalElement("timing", TimingSerializer.descriptor)
      optionalElement("asNeededBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_asNeededBoolean", ElementSerializer.descriptor)
      optionalElement("asNeededCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("site", CodeableConceptSerializer.descriptor)
      optionalElement("route", CodeableConceptSerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.descriptor)
      optionalElement("doseAndRate", DosageDoseAndRateSerializer.listSerializer.descriptor)
      optionalElement("maxDosePerPeriod", RatioSerializer.descriptor)
      optionalElement("maxDosePerAdministration", QuantitySerializer.descriptor)
      optionalElement("maxDosePerLifetime", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Dosage>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Dosage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var text: KotlinString? = null
      var _text: Element? = null
      var additionalInstruction: List<CodeableConcept>? = null
      var patientInstruction: KotlinString? = null
      var _patientInstruction: Element? = null
      var timing: Timing? = null
      var asNeededBoolean: KotlinBoolean? = null
      var _asNeededBoolean: Element? = null
      var asNeededCodeableConcept: CodeableConcept? = null
      var site: CodeableConcept? = null
      var route: CodeableConcept? = null
      var method: CodeableConcept? = null
      var doseAndRate: List<Dosage.DoseAndRate>? = null
      var maxDosePerPeriod: Ratio? = null
      var maxDosePerAdministration: Quantity? = null
      var maxDosePerLifetime: Quantity? = null
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> text = decodeStringElement(descriptor, i)
          6 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            additionalInstruction =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 -> patientInstruction = decodeStringElement(descriptor, i)
          9 ->
            _patientInstruction =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> timing = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          11 -> asNeededBoolean = decodeBooleanElement(descriptor, i)
          12 ->
            _asNeededBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            asNeededCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          14 ->
            site = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          15 ->
            route =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          16 ->
            method =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          17 ->
            doseAndRate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                DosageDoseAndRateSerializer.listSerializer,
                null,
              )
          18 ->
            maxDosePerPeriod =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          19 ->
            maxDosePerAdministration =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          20 ->
            maxDosePerLifetime =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Dosage: " + i)
        }
      }
      Dosage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence = Integer.of(sequence, _sequence),
        text = R4bString.of(text, _text),
        additionalInstruction = additionalInstruction ?: listOf(),
        patientInstruction = R4bString.of(patientInstruction, _patientInstruction),
        timing = timing,
        asNeeded =
          Dosage.AsNeeded.from(
            R4bBoolean.of(asNeededBoolean, _asNeededBoolean),
            asNeededCodeableConcept,
          ),
        site = site,
        route = route,
        method = method,
        doseAndRate = doseAndRate ?: listOf(),
        maxDosePerPeriod = maxDosePerPeriod,
        maxDosePerAdministration = maxDosePerAdministration,
        maxDosePerLifetime = maxDosePerLifetime,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Dosage) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence?.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      encodeStringIfNotNull(descriptor, 5, value.text?.value)
      encodeElementIfNotNull(descriptor, 6, value.text)
      if (value.additionalInstruction.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.additionalInstruction,
        )
      encodeStringIfNotNull(descriptor, 8, value.patientInstruction?.value)
      encodeElementIfNotNull(descriptor, 9, value.patientInstruction)
      encodeSerializableIfNotNull(descriptor, 10, TimingSerializer, value.timing)
      when (val choice = value.asNeeded) {
        null -> {}
        is Dosage.AsNeeded.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is Dosage.AsNeeded.CodeableConcept -> {
          encodeSerializableElement(descriptor, 13, CodeableConceptSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 14, CodeableConceptSerializer, value.site)
      encodeSerializableIfNotNull(descriptor, 15, CodeableConceptSerializer, value.route)
      encodeSerializableIfNotNull(descriptor, 16, CodeableConceptSerializer, value.method)
      if (value.doseAndRate.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          17,
          DosageDoseAndRateSerializer.listSerializer,
          value.doseAndRate,
        )
      encodeSerializableIfNotNull(descriptor, 18, RatioSerializer, value.maxDosePerPeriod)
      encodeSerializableIfNotNull(
        descriptor,
        19,
        QuantitySerializer,
        value.maxDosePerAdministration,
      )
      encodeSerializableIfNotNull(descriptor, 20, QuantitySerializer, value.maxDosePerLifetime)
    }
  }
}

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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.MeasureReport
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object MeasureReportGroupSerializer : KSerializer<MeasureReport.Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement(
        "population",
        MeasureReportGroupPopulationSerializer.listSerializer.descriptor,
      )
      optionalElement("measureScore", QuantitySerializer.descriptor)
      optionalElement(
        "stratifier",
        MeasureReportGroupStratifierSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var population: List<MeasureReport.Group.Population>? = null
      var measureScore: Quantity? = null
      var stratifier: List<MeasureReport.Group.Stratifier>? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            population =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupPopulationSerializer.listSerializer,
                null,
              )
          5 ->
            measureScore =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 ->
            stratifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupStratifierSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Group: " + i)
        }
      }
      MeasureReport.Group(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        population = population ?: listOf(),
        measureScore = measureScore,
        stratifier = stratifier ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.code)
      if (value.population.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          MeasureReportGroupPopulationSerializer.listSerializer,
          value.population,
        )
      encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.measureScore)
      if (value.stratifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MeasureReportGroupStratifierSerializer.listSerializer,
          value.stratifier,
        )
    }
  }
}

internal object MeasureReportGroupPopulationSerializer :
  KSerializer<MeasureReport.Group.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("count", Int.serializer().descriptor)
      optionalElement("_count", ElementSerializer.descriptor)
      optionalElement("subjectResults", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group.Population>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Population =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var count: Int? = null
      var _count: Element? = null
      var subjectResults: Reference? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> count = decodeIntElement(descriptor, i)
          5 -> _count = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            subjectResults =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Population: " + i)
        }
      }
      MeasureReport.Group.Population(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        count = Integer.of(count, _count),
        subjectResults = subjectResults,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Population) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeIntIfNotNull(descriptor, 4, value.count?.value)
      encodeElementIfNotNull(descriptor, 5, value.count)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.subjectResults)
    }
  }
}

internal object MeasureReportGroupStratifierSerializer :
  KSerializer<MeasureReport.Group.Stratifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratifier") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "stratum",
        MeasureReportGroupStratifierStratumSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: List<CodeableConcept>? = null
      var stratum: List<MeasureReport.Group.Stratifier.Stratum>? = null
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
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            stratum =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupStratifierStratumSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Stratifier: " + i)
        }
      }
      MeasureReport.Group.Stratifier(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code ?: listOf(),
        stratum = stratum ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier) {
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
      if (value.code.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.code,
        )
      if (value.stratum.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          MeasureReportGroupStratifierStratumSerializer.listSerializer,
          value.stratum,
        )
    }
  }
}

internal object MeasureReportGroupStratifierStratumSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratum") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("value", CodeableConceptSerializer.descriptor)
      optionalElement(
        "component",
        MeasureReportGroupStratifierStratumComponentSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "population",
        MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer.descriptor,
      )
      optionalElement("measureScore", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var `value`: CodeableConcept? = null
      var component: List<MeasureReport.Group.Stratifier.Stratum.Component>? = null
      var population: List<MeasureReport.Group.Stratifier.Stratum.Population>? = null
      var measureScore: Quantity? = null
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
            `value` =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            component =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupStratifierStratumComponentSerializer.listSerializer,
                null,
              )
          5 ->
            population =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer,
                null,
              )
          6 ->
            measureScore =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Stratum: " + i)
        }
      }
      MeasureReport.Group.Stratifier.Stratum(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` = `value`,
        component = component ?: listOf(),
        population = population ?: listOf(),
        measureScore = measureScore,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.`value`)
      if (value.component.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          MeasureReportGroupStratifierStratumComponentSerializer.listSerializer,
          value.component,
        )
      if (value.population.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer,
          value.population,
        )
      encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.measureScore)
    }
  }
}

internal object MeasureReportGroupStratifierStratumComponentSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("value", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Component>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Component =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var `value`: CodeableConcept? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            `value` =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Component: " + i)
        }
      }
      MeasureReport.Group.Stratifier.Stratum.Component(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on MeasureReport.Group.Stratifier.Stratum.Component"
            ),
        `value` =
          `value`
            ?: throw SerializationException(
              "Missing required property 'value' on MeasureReport.Group.Stratifier.Stratum.Component"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.`value`)
    }
  }
}

internal object MeasureReportGroupStratifierStratumPopulationSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("count", Int.serializer().descriptor)
      optionalElement("_count", ElementSerializer.descriptor)
      optionalElement("subjectResults", ReferenceSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Population>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Population =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var count: Int? = null
      var _count: Element? = null
      var subjectResults: Reference? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> count = decodeIntElement(descriptor, i)
          5 -> _count = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            subjectResults =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Population: " + i)
        }
      }
      MeasureReport.Group.Stratifier.Stratum.Population(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        count = Integer.of(count, _count),
        subjectResults = subjectResults,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeIntIfNotNull(descriptor, 4, value.count?.value)
      encodeElementIfNotNull(descriptor, 5, value.count)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.subjectResults)
    }
  }
}

internal object MeasureReportSerializer : FhirResourceSerializer<MeasureReport> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MeasureReport")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("type", String.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("measure", String.serializer().descriptor)
    b.optionalElement("_measure", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("date", String.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("reporter", ReferenceSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("improvementNotation", CodeableConceptSerializer.descriptor)
    b.optionalElement("group", MeasureReportGroupSerializer.listSerializer.descriptor)
    b.optionalElement("evaluatedResource", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MeasureReport {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var status: String? = null
    var _status: Element? = null
    var type: String? = null
    var _type: Element? = null
    var measure: String? = null
    var _measure: Element? = null
    var subject: Reference? = null
    var date: String? = null
    var _date: Element? = null
    var reporter: Reference? = null
    var period: Period? = null
    var improvementNotation: CodeableConcept? = null
    var group: List<MeasureReport.Group>? = null
    var evaluatedResource: List<Reference>? = null
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
        13 -> type = decoder.decodeStringElement(descriptor, i)
        14 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> measure = decoder.decodeStringElement(descriptor, i)
        16 ->
          _measure =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 -> date = decoder.decodeStringElement(descriptor, i)
        19 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          reporter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        22 ->
          improvementNotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        23 ->
          group =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureReportGroupSerializer.listSerializer,
              null,
            )
        24 ->
          evaluatedResource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MeasureReport: " + i)
      }
    }
    return MeasureReport(
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
          if (status != null) MeasureReport.MeasureReportStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on MeasureReport"),
      type =
        Enumeration.of(
          if (type != null) MeasureReport.MeasureReportType.fromCode(type) else null,
          _type,
        ) ?: throw SerializationException("Missing required property 'type' on MeasureReport"),
      measure =
        Canonical.of(measure, _measure)
          ?: throw SerializationException("Missing required property 'measure' on MeasureReport"),
      subject = subject,
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      reporter = reporter,
      period =
        period
          ?: throw SerializationException("Missing required property 'period' on MeasureReport"),
      improvementNotation = improvementNotation,
      group = group ?: listOf(),
      evaluatedResource = evaluatedResource ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MeasureReport,
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
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.type.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.type)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.measure.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.measure)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.date)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.reporter,
    )
    encoder.encodeSerializableElement(
      descriptor,
      21 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      CodeableConceptSerializer,
      value.improvementNotation,
    )
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        MeasureReportGroupSerializer.listSerializer,
        value.group,
      )
    if (value.evaluatedResource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.evaluatedResource,
      )
  }
}

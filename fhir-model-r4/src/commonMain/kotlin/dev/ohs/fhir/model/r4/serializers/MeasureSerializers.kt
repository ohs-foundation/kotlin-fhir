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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Measure
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

internal object MeasureGroupSerializer : KSerializer<Measure.Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("population", MeasureGroupPopulationSerializer.listSerializer.descriptor)
      optionalElement("stratifier", MeasureGroupStratifierSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Measure.Group>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Measure.Group =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var population: List<Measure.Group.Population>? = null
      var stratifier: List<Measure.Group.Stratifier>? = null
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
          4 -> description = decodeStringElement(descriptor, i)
          5 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            population =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureGroupPopulationSerializer.listSerializer,
                null,
              )
          7 ->
            stratifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureGroupStratifierSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Group: " + i)
        }
      }
      Measure.Group(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        description = R4String.of(description, _description),
        population = population ?: listOf(),
        stratifier = stratifier ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Measure.Group) {
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
      encodeStringIfNotNull(descriptor, 4, value.description?.value)
      encodeElementIfNotNull(descriptor, 5, value.description)
      if (value.population.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MeasureGroupPopulationSerializer.listSerializer,
          value.population,
        )
      if (value.stratifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          MeasureGroupStratifierSerializer.listSerializer,
          value.stratifier,
        )
    }
  }
}

internal object MeasureGroupPopulationSerializer : KSerializer<Measure.Group.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("criteria", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Measure.Group.Population>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Measure.Group.Population =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var criteria: Expression? = null
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
          4 -> description = decodeStringElement(descriptor, i)
          5 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            criteria = decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Population: " + i)
        }
      }
      Measure.Group.Population(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        description = R4String.of(description, _description),
        criteria =
          criteria
            ?: throw SerializationException(
              "Missing required property 'criteria' on Measure.Group.Population"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Population) {
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
      encodeStringIfNotNull(descriptor, 4, value.description?.value)
      encodeElementIfNotNull(descriptor, 5, value.description)
      encodeSerializableElement(descriptor, 6, ExpressionSerializer, value.criteria)
    }
  }
}

internal object MeasureGroupStratifierSerializer : KSerializer<Measure.Group.Stratifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratifier") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("criteria", ExpressionSerializer.descriptor)
      optionalElement(
        "component",
        MeasureGroupStratifierComponentSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Measure.Group.Stratifier>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Measure.Group.Stratifier =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var criteria: Expression? = null
      var component: List<Measure.Group.Stratifier.Component>? = null
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
          4 -> description = decodeStringElement(descriptor, i)
          5 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            criteria = decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          7 ->
            component =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureGroupStratifierComponentSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Stratifier: " + i)
        }
      }
      Measure.Group.Stratifier(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        description = R4String.of(description, _description),
        criteria = criteria,
        component = component ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Stratifier) {
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
      encodeStringIfNotNull(descriptor, 4, value.description?.value)
      encodeElementIfNotNull(descriptor, 5, value.description)
      encodeSerializableIfNotNull(descriptor, 6, ExpressionSerializer, value.criteria)
      if (value.component.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          MeasureGroupStratifierComponentSerializer.listSerializer,
          value.component,
        )
    }
  }
}

internal object MeasureGroupStratifierComponentSerializer :
  KSerializer<Measure.Group.Stratifier.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("criteria", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Measure.Group.Stratifier.Component>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Measure.Group.Stratifier.Component =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var criteria: Expression? = null
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
          4 -> description = decodeStringElement(descriptor, i)
          5 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            criteria = decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Component: " + i)
        }
      }
      Measure.Group.Stratifier.Component(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        description = R4String.of(description, _description),
        criteria =
          criteria
            ?: throw SerializationException(
              "Missing required property 'criteria' on Measure.Group.Stratifier.Component"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Stratifier.Component) {
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
      encodeStringIfNotNull(descriptor, 4, value.description?.value)
      encodeElementIfNotNull(descriptor, 5, value.description)
      encodeSerializableElement(descriptor, 6, ExpressionSerializer, value.criteria)
    }
  }
}

internal object MeasureSupplementalDataSerializer : KSerializer<Measure.SupplementalData> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupplementalData") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("usage", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("criteria", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Measure.SupplementalData>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Measure.SupplementalData =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var usage: List<CodeableConcept>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var criteria: Expression? = null
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
            usage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            criteria = decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SupplementalData: " + i)
        }
      }
      Measure.SupplementalData(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        usage = usage ?: listOf(),
        description = R4String.of(description, _description),
        criteria =
          criteria
            ?: throw SerializationException(
              "Missing required property 'criteria' on Measure.SupplementalData"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Measure.SupplementalData) {
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
      if (value.usage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.usage,
        )
      encodeStringIfNotNull(descriptor, 5, value.description?.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
      encodeSerializableElement(descriptor, 7, ExpressionSerializer, value.criteria)
    }
  }
}

internal object MeasureSerializer : FhirResourceSerializer<Measure> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Measure")

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
    b.optionalElement("subtitle", KotlinString.serializer().descriptor)
    b.optionalElement("_subtitle", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("usage", KotlinString.serializer().descriptor)
    b.optionalElement("_usage", ElementSerializer.descriptor)
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
    b.optionalElement("library", stringNullableListSerializer.descriptor)
    b.optionalElement("_library", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("disclaimer", KotlinString.serializer().descriptor)
    b.optionalElement("_disclaimer", ElementSerializer.descriptor)
    b.optionalElement("scoring", CodeableConceptSerializer.descriptor)
    b.optionalElement("compositeScoring", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("riskAdjustment", KotlinString.serializer().descriptor)
    b.optionalElement("_riskAdjustment", ElementSerializer.descriptor)
    b.optionalElement("rateAggregation", KotlinString.serializer().descriptor)
    b.optionalElement("_rateAggregation", ElementSerializer.descriptor)
    b.optionalElement("rationale", KotlinString.serializer().descriptor)
    b.optionalElement("_rationale", ElementSerializer.descriptor)
    b.optionalElement("clinicalRecommendationStatement", KotlinString.serializer().descriptor)
    b.optionalElement("_clinicalRecommendationStatement", ElementSerializer.descriptor)
    b.optionalElement("improvementNotation", CodeableConceptSerializer.descriptor)
    b.optionalElement("definition", stringNullableListSerializer.descriptor)
    b.optionalElement("_definition", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("guidance", KotlinString.serializer().descriptor)
    b.optionalElement("_guidance", ElementSerializer.descriptor)
    b.optionalElement("group", MeasureGroupSerializer.listSerializer.descriptor)
    b.optionalElement(
      "supplementalData",
      MeasureSupplementalDataSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Measure {
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
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var usage: KotlinString? = null
    var _usage: Element? = null
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
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var disclaimer: KotlinString? = null
    var _disclaimer: Element? = null
    var scoring: CodeableConcept? = null
    var compositeScoring: CodeableConcept? = null
    var type: List<CodeableConcept>? = null
    var riskAdjustment: KotlinString? = null
    var _riskAdjustment: Element? = null
    var rateAggregation: KotlinString? = null
    var _rateAggregation: Element? = null
    var rationale: KotlinString? = null
    var _rationale: Element? = null
    var clinicalRecommendationStatement: KotlinString? = null
    var _clinicalRecommendationStatement: Element? = null
    var improvementNotation: CodeableConcept? = null
    var definition: List<KotlinString?>? = null
    var _definition: List<Element?>? = null
    var guidance: KotlinString? = null
    var _guidance: Element? = null
    var group: List<Measure.Group>? = null
    var supplementalData: List<Measure.SupplementalData>? = null
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
        19 -> subtitle = decoder.decodeStringElement(descriptor, i)
        20 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> status = decoder.decodeStringElement(descriptor, i)
        22 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 -> date = decoder.decodeStringElement(descriptor, i)
        28 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> publisher = decoder.decodeStringElement(descriptor, i)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        32 -> description = decoder.decodeStringElement(descriptor, i)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        36 -> purpose = decoder.decodeStringElement(descriptor, i)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 -> usage = decoder.decodeStringElement(descriptor, i)
        39 ->
          _usage = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 -> copyright = decoder.decodeStringElement(descriptor, i)
        41 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        42 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        43 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        45 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        46 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        47 ->
          topic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        48 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        49 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        50 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        51 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        52 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        53 ->
          library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        54 ->
          _library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        55 -> disclaimer = decoder.decodeStringElement(descriptor, i)
        56 ->
          _disclaimer =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        57 ->
          scoring =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        58 ->
          compositeScoring =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        59 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        60 -> riskAdjustment = decoder.decodeStringElement(descriptor, i)
        61 ->
          _riskAdjustment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        62 -> rateAggregation = decoder.decodeStringElement(descriptor, i)
        63 ->
          _rateAggregation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        64 -> rationale = decoder.decodeStringElement(descriptor, i)
        65 ->
          _rationale =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        66 -> clinicalRecommendationStatement = decoder.decodeStringElement(descriptor, i)
        67 ->
          _clinicalRecommendationStatement =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        68 ->
          improvementNotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        69 ->
          definition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        70 ->
          _definition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        71 -> guidance = decoder.decodeStringElement(descriptor, i)
        72 ->
          _guidance =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        73 ->
          group =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureGroupSerializer.listSerializer,
              null,
            )
        74 ->
          supplementalData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureSupplementalDataSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Measure: " + i)
      }
    }
    return Measure(
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
      subtitle = R4String.of(subtitle, _subtitle),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Measure"),
      experimental = R4Boolean.of(experimental, _experimental),
      subject = Measure.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4String.of(usage, _usage),
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
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index), _library?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'library' on Measure has neither a value nor an id/extension"
            )
        }),
      disclaimer = Markdown.of(disclaimer, _disclaimer),
      scoring = scoring,
      compositeScoring = compositeScoring,
      type = type ?: listOf(),
      riskAdjustment = R4String.of(riskAdjustment, _riskAdjustment),
      rateAggregation = R4String.of(rateAggregation, _rateAggregation),
      rationale = Markdown.of(rationale, _rationale),
      clinicalRecommendationStatement =
        Markdown.of(clinicalRecommendationStatement, _clinicalRecommendationStatement),
      improvementNotation = improvementNotation,
      definition =
        (kotlin.collections.List(maxOf(definition?.size ?: 0, _definition?.size ?: 0)) { index ->
          Markdown.of(definition?.getOrNull(index), _definition?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'definition' on Measure has neither a value nor an id/extension"
            )
        }),
      guidance = Markdown.of(guidance, _guidance),
      group = group ?: listOf(),
      supplementalData = supplementalData ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Measure,
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
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.subtitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.subtitle)
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 23 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is Measure.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Measure.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 36 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 38 + descriptorOffset, value.usage?.value)
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.usage)
    encoder.encodeStringIfNotNull(descriptor, 40 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(
      descriptor,
      42 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      44 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    if (value.library.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        53 + descriptorOffset,
        stringNullableListSerializer,
        value.library.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 54 + descriptorOffset, value.library)
    }
    encoder.encodeStringIfNotNull(descriptor, 55 + descriptorOffset, value.disclaimer?.value)
    encoder.encodeElementIfNotNull(descriptor, 56 + descriptorOffset, value.disclaimer)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      57 + descriptorOffset,
      CodeableConceptSerializer,
      value.scoring,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      58 + descriptorOffset,
      CodeableConceptSerializer,
      value.compositeScoring,
    )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    encoder.encodeStringIfNotNull(descriptor, 60 + descriptorOffset, value.riskAdjustment?.value)
    encoder.encodeElementIfNotNull(descriptor, 61 + descriptorOffset, value.riskAdjustment)
    encoder.encodeStringIfNotNull(descriptor, 62 + descriptorOffset, value.rateAggregation?.value)
    encoder.encodeElementIfNotNull(descriptor, 63 + descriptorOffset, value.rateAggregation)
    encoder.encodeStringIfNotNull(descriptor, 64 + descriptorOffset, value.rationale?.value)
    encoder.encodeElementIfNotNull(descriptor, 65 + descriptorOffset, value.rationale)
    encoder.encodeStringIfNotNull(
      descriptor,
      66 + descriptorOffset,
      value.clinicalRecommendationStatement?.value,
    )
    encoder.encodeElementIfNotNull(
      descriptor,
      67 + descriptorOffset,
      value.clinicalRecommendationStatement,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      68 + descriptorOffset,
      CodeableConceptSerializer,
      value.improvementNotation,
    )
    if (value.definition.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        69 + descriptorOffset,
        stringNullableListSerializer,
        value.definition.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 70 + descriptorOffset, value.definition)
    }
    encoder.encodeStringIfNotNull(descriptor, 71 + descriptorOffset, value.guidance?.value)
    encoder.encodeElementIfNotNull(descriptor, 72 + descriptorOffset, value.guidance)
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        73 + descriptorOffset,
        MeasureGroupSerializer.listSerializer,
        value.group,
      )
    if (value.supplementalData.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        74 + descriptorOffset,
        MeasureSupplementalDataSerializer.listSerializer,
        value.supplementalData,
      )
  }
}

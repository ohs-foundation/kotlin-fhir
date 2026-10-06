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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.EvidenceVariable
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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

internal object EvidenceVariableCharacteristicSerializer :
  KSerializer<EvidenceVariable.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("definitionReference", ReferenceSerializer.descriptor)
      optionalElement("definitionCanonical", KotlinString.serializer().descriptor)
      optionalElement("_definitionCanonical", ElementSerializer.descriptor)
      optionalElement("definitionCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("definitionExpression", ExpressionSerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.descriptor)
      optionalElement("device", ReferenceSerializer.descriptor)
      optionalElement("exclude", KotlinBoolean.serializer().descriptor)
      optionalElement("_exclude", ElementSerializer.descriptor)
      optionalElement(
        "timeFromStart",
        EvidenceVariableCharacteristicTimeFromStartSerializer.descriptor,
      )
      optionalElement("groupMeasure", KotlinString.serializer().descriptor)
      optionalElement("_groupMeasure", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceVariable.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var definitionReference: Reference? = null
      var definitionCanonical: KotlinString? = null
      var _definitionCanonical: Element? = null
      var definitionCodeableConcept: CodeableConcept? = null
      var definitionExpression: Expression? = null
      var method: CodeableConcept? = null
      var device: Reference? = null
      var exclude: KotlinBoolean? = null
      var _exclude: Element? = null
      var timeFromStart: EvidenceVariable.Characteristic.TimeFromStart? = null
      var groupMeasure: KotlinString? = null
      var _groupMeasure: Element? = null
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
            definitionReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> definitionCanonical = decodeStringElement(descriptor, i)
          7 ->
            _definitionCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            definitionCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            definitionExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          10 ->
            method =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          11 -> device = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          12 -> exclude = decodeBooleanElement(descriptor, i)
          13 -> _exclude = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            timeFromStart =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceVariableCharacteristicTimeFromStartSerializer,
                null,
              )
          15 -> groupMeasure = decodeStringElement(descriptor, i)
          16 ->
            _groupMeasure =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
        }
      }
      EvidenceVariable.Characteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4bString.of(description, _description),
        definition =
          EvidenceVariable.Characteristic.Definition.from(
            definitionReference,
            Canonical.of(definitionCanonical, _definitionCanonical),
            definitionCodeableConcept,
            definitionExpression,
          )
            ?: throw SerializationException(
              "Missing required property 'definition' on EvidenceVariable.Characteristic"
            ),
        method = method,
        device = device,
        exclude = R4bBoolean.of(exclude, _exclude),
        timeFromStart = timeFromStart,
        groupMeasure =
          Enumeration.of(
            if (groupMeasure != null) EvidenceVariable.GroupMeasure.fromCode(groupMeasure)
            else null,
            _groupMeasure,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic) {
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
      when (val choice = value.definition) {
        is EvidenceVariable.Characteristic.Definition.Reference -> {
          encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
        }
        is EvidenceVariable.Characteristic.Definition.Canonical -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is EvidenceVariable.Characteristic.Definition.CodeableConcept -> {
          encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
        }
        is EvidenceVariable.Characteristic.Definition.Expression -> {
          encodeSerializableElement(descriptor, 9, ExpressionSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 10, CodeableConceptSerializer, value.method)
      encodeSerializableIfNotNull(descriptor, 11, ReferenceSerializer, value.device)
      encodeBooleanIfNotNull(descriptor, 12, value.exclude?.value)
      encodeElementIfNotNull(descriptor, 13, value.exclude)
      encodeSerializableIfNotNull(
        descriptor,
        14,
        EvidenceVariableCharacteristicTimeFromStartSerializer,
        value.timeFromStart,
      )
      encodeStringIfNotNull(descriptor, 15, value.groupMeasure?.value?.code)
      encodeElementIfNotNull(descriptor, 16, value.groupMeasure)
    }
  }
}

internal object EvidenceVariableCharacteristicTimeFromStartSerializer :
  KSerializer<EvidenceVariable.Characteristic.TimeFromStart> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TimeFromStart") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("range", RangeSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceVariable.Characteristic.TimeFromStart>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.TimeFromStart =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var quantity: Quantity? = null
      var range: Range? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> range = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          7 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TimeFromStart: " + i)
        }
      }
      EvidenceVariable.Characteristic.TimeFromStart(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4bString.of(description, _description),
        quantity = quantity,
        range = range,
        note = note ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic.TimeFromStart) {
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
      encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 6, RangeSerializer, value.range)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 7, AnnotationSerializer.listSerializer, value.note)
    }
  }
}

internal object EvidenceVariableCategorySerializer : KSerializer<EvidenceVariable.Category> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Category") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceVariable.Category>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceVariable.Category =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueRange: Range? = null
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          7 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Category: " + i)
        }
      }
      EvidenceVariable.Category(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name = R4bString.of(name, _name),
        `value` =
          EvidenceVariable.Category.Value.from(valueCodeableConcept, valueQuantity, valueRange),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Category) {
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
      encodeStringIfNotNull(descriptor, 3, value.name?.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      when (val choice = value.`value`) {
        null -> {}
        is EvidenceVariable.Category.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is EvidenceVariable.Category.Value.Quantity -> {
          encodeSerializableElement(descriptor, 6, QuantitySerializer, choice.value)
        }
        is EvidenceVariable.Category.Value.Range -> {
          encodeSerializableElement(descriptor, 7, RangeSerializer, choice.value)
        }
      }
    }
  }
}

internal object EvidenceVariableSerializer : FhirResourceSerializer<EvidenceVariable> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("EvidenceVariable")

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
    b.optionalElement("shortTitle", KotlinString.serializer().descriptor)
    b.optionalElement("_shortTitle", ElementSerializer.descriptor)
    b.optionalElement("subtitle", KotlinString.serializer().descriptor)
    b.optionalElement("_subtitle", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("actual", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_actual", ElementSerializer.descriptor)
    b.optionalElement("characteristicCombination", KotlinString.serializer().descriptor)
    b.optionalElement("_characteristicCombination", ElementSerializer.descriptor)
    b.optionalElement(
      "characteristic",
      EvidenceVariableCharacteristicSerializer.listSerializer.descriptor,
    )
    b.optionalElement("handling", KotlinString.serializer().descriptor)
    b.optionalElement("_handling", ElementSerializer.descriptor)
    b.optionalElement("category", EvidenceVariableCategorySerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): EvidenceVariable {
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
    var shortTitle: KotlinString? = null
    var _shortTitle: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var useContext: List<UsageContext>? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var characteristicCombination: KotlinString? = null
    var _characteristicCombination: Element? = null
    var characteristic: List<EvidenceVariable.Characteristic>? = null
    var handling: KotlinString? = null
    var _handling: Element? = null
    var category: List<EvidenceVariable.Category>? = null
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
        19 -> shortTitle = decoder.decodeStringElement(descriptor, i)
        20 ->
          _shortTitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> subtitle = decoder.decodeStringElement(descriptor, i)
        22 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> status = decoder.decodeStringElement(descriptor, i)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> date = decoder.decodeStringElement(descriptor, i)
        26 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> description = decoder.decodeStringElement(descriptor, i)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 -> publisher = decoder.decodeStringElement(descriptor, i)
        32 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        34 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        35 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        36 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        37 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        38 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        39 -> `actual` = decoder.decodeBooleanElement(descriptor, i)
        40 ->
          _actual =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 -> characteristicCombination = decoder.decodeStringElement(descriptor, i)
        42 ->
          _characteristicCombination =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCharacteristicSerializer.listSerializer,
              null,
            )
        44 -> handling = decoder.decodeStringElement(descriptor, i)
        45 ->
          _handling =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        46 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCategorySerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding EvidenceVariable: " + i)
      }
    }
    return EvidenceVariable(
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      shortTitle = R4bString.of(shortTitle, _shortTitle),
      subtitle = R4bString.of(subtitle, _subtitle),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on EvidenceVariable"),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      useContext = useContext ?: listOf(),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      `actual` = R4bBoolean.of(`actual`, _actual),
      characteristicCombination =
        Enumeration.of(
          if (characteristicCombination != null)
            EvidenceVariable.CharacteristicCombination.fromCode(characteristicCombination)
          else null,
          _characteristicCombination,
        ),
      characteristic = characteristic ?: listOf(),
      handling =
        Enumeration.of(
          if (handling != null) EvidenceVariable.EvidenceVariableHandling.fromCode(handling)
          else null,
          _handling,
        ),
      category = category ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: EvidenceVariable,
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
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.shortTitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.shortTitle)
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.subtitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.subtitle)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.description)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    encoder.encodeBooleanIfNotNull(descriptor, 39 + descriptorOffset, value.`actual`?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.`actual`)
    encoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.characteristicCombination?.value?.code,
    )
    encoder.encodeElementIfNotNull(
      descriptor,
      42 + descriptorOffset,
      value.characteristicCombination,
    )
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        EvidenceVariableCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
    encoder.encodeStringIfNotNull(descriptor, 44 + descriptorOffset, value.handling?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, value.handling)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        EvidenceVariableCategorySerializer.listSerializer,
        value.category,
      )
  }
}

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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubstanceProtein
import dev.ohs.fhir.model.r5.Uri
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

internal object SubstanceProteinSubunitSerializer : KSerializer<SubstanceProtein.Subunit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Subunit") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("subunit", Int.serializer().descriptor)
      optionalElement("_subunit", ElementSerializer.descriptor)
      optionalElement("sequence", KotlinString.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("length", Int.serializer().descriptor)
      optionalElement("_length", ElementSerializer.descriptor)
      optionalElement("sequenceAttachment", AttachmentSerializer.descriptor)
      optionalElement("nTerminalModificationId", IdentifierSerializer.descriptor)
      optionalElement("nTerminalModification", KotlinString.serializer().descriptor)
      optionalElement("_nTerminalModification", ElementSerializer.descriptor)
      optionalElement("cTerminalModificationId", IdentifierSerializer.descriptor)
      optionalElement("cTerminalModification", KotlinString.serializer().descriptor)
      optionalElement("_cTerminalModification", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceProtein.Subunit>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceProtein.Subunit =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var subunit: Int? = null
      var _subunit: Element? = null
      var sequence: KotlinString? = null
      var _sequence: Element? = null
      var length: Int? = null
      var _length: Element? = null
      var sequenceAttachment: Attachment? = null
      var nTerminalModificationId: Identifier? = null
      var nTerminalModification: KotlinString? = null
      var _nTerminalModification: Element? = null
      var cTerminalModificationId: Identifier? = null
      var cTerminalModification: KotlinString? = null
      var _cTerminalModification: Element? = null
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
          3 -> subunit = decodeIntElement(descriptor, i)
          4 -> _subunit = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> sequence = decodeStringElement(descriptor, i)
          6 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> length = decodeIntElement(descriptor, i)
          8 -> _length = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            sequenceAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          10 ->
            nTerminalModificationId =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          11 -> nTerminalModification = decodeStringElement(descriptor, i)
          12 ->
            _nTerminalModification =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            cTerminalModificationId =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          14 -> cTerminalModification = decodeStringElement(descriptor, i)
          15 ->
            _cTerminalModification =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Subunit: " + i)
        }
      }
      SubstanceProtein.Subunit(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        subunit = Integer.of(subunit, _subunit),
        sequence = R5String.of(sequence, _sequence),
        length = Integer.of(length, _length),
        sequenceAttachment = sequenceAttachment,
        nTerminalModificationId = nTerminalModificationId,
        nTerminalModification = R5String.of(nTerminalModification, _nTerminalModification),
        cTerminalModificationId = cTerminalModificationId,
        cTerminalModification = R5String.of(cTerminalModification, _cTerminalModification),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceProtein.Subunit) {
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
      encodeIntIfNotNull(descriptor, 3, value.subunit?.value)
      encodeElementIfNotNull(descriptor, 4, value.subunit)
      encodeStringIfNotNull(descriptor, 5, value.sequence?.value)
      encodeElementIfNotNull(descriptor, 6, value.sequence)
      encodeIntIfNotNull(descriptor, 7, value.length?.value)
      encodeElementIfNotNull(descriptor, 8, value.length)
      encodeSerializableIfNotNull(descriptor, 9, AttachmentSerializer, value.sequenceAttachment)
      encodeSerializableIfNotNull(
        descriptor,
        10,
        IdentifierSerializer,
        value.nTerminalModificationId,
      )
      encodeStringIfNotNull(descriptor, 11, value.nTerminalModification?.value)
      encodeElementIfNotNull(descriptor, 12, value.nTerminalModification)
      encodeSerializableIfNotNull(
        descriptor,
        13,
        IdentifierSerializer,
        value.cTerminalModificationId,
      )
      encodeStringIfNotNull(descriptor, 14, value.cTerminalModification?.value)
      encodeElementIfNotNull(descriptor, 15, value.cTerminalModification)
    }
  }
}

internal object SubstanceProteinSerializer : FhirResourceSerializer<SubstanceProtein> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstanceProtein")

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
    b.optionalElement("sequenceType", CodeableConceptSerializer.descriptor)
    b.optionalElement("numberOfSubunits", Int.serializer().descriptor)
    b.optionalElement("_numberOfSubunits", ElementSerializer.descriptor)
    b.optionalElement("disulfideLinkage", stringNullableListSerializer.descriptor)
    b.optionalElement("_disulfideLinkage", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("subunit", SubstanceProteinSubunitSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubstanceProtein {
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
    var sequenceType: CodeableConcept? = null
    var numberOfSubunits: Int? = null
    var _numberOfSubunits: Element? = null
    var disulfideLinkage: List<KotlinString?>? = null
    var _disulfideLinkage: List<Element?>? = null
    var subunit: List<SubstanceProtein.Subunit>? = null
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
          sequenceType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 -> numberOfSubunits = decoder.decodeIntElement(descriptor, i)
        12 ->
          _numberOfSubunits =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          disulfideLinkage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _disulfideLinkage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          subunit =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceProteinSubunitSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SubstanceProtein: " + i)
      }
    }
    return SubstanceProtein(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequenceType = sequenceType,
      numberOfSubunits = Integer.of(numberOfSubunits, _numberOfSubunits),
      disulfideLinkage =
        (kotlin.collections.List(
          maxOf(disulfideLinkage?.size ?: 0, _disulfideLinkage?.size ?: 0)
        ) { index ->
          R5String.of(disulfideLinkage?.getOrNull(index), _disulfideLinkage?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'disulfideLinkage' on SubstanceProtein has neither a value nor an id/extension"
            )
        }),
      subunit = subunit ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceProtein,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      CodeableConceptSerializer,
      value.sequenceType,
    )
    encoder.encodeIntIfNotNull(descriptor, 11 + descriptorOffset, value.numberOfSubunits?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.numberOfSubunits)
    if (value.disulfideLinkage.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.disulfideLinkage.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.disulfideLinkage)
    }
    if (value.subunit.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        SubstanceProteinSubunitSerializer.listSerializer,
        value.subunit,
      )
  }
}

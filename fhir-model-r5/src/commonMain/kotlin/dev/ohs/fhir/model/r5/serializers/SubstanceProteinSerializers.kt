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

  override fun deserialize(decoder: Decoder): SubstanceProtein.Subunit {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> subunit = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _subunit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> sequence = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> length = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _length =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          sequenceAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        10 ->
          nTerminalModificationId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        11 -> nTerminalModification = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _nTerminalModification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          cTerminalModificationId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        14 -> cTerminalModification = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _cTerminalModification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subunit: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceProtein.Subunit(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.subunit?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.subunit)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.sequence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.sequence)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.length?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.length)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      AttachmentSerializer,
      value.sequenceAttachment,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      IdentifierSerializer,
      value.nTerminalModificationId,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.nTerminalModification?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.nTerminalModification)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      IdentifierSerializer,
      value.cTerminalModificationId,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 14, value.cTerminalModification?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.cTerminalModification)
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
          sequenceType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 -> numberOfSubunits = compositeDecoder.decodeIntElement(descriptor, i)
        12 ->
          _numberOfSubunits =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          disulfideLinkage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _disulfideLinkage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          subunit =
            compositeDecoder.decodeNullableSerializableElement(
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceProtein,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      CodeableConceptSerializer,
      value.sequenceType,
    )
    compositeEncoder.encodeIntIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.numberOfSubunits?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.numberOfSubunits,
    )
    if (value.disulfideLinkage.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.disulfideLinkage.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        14 + descriptorOffset,
        value.disulfideLinkage,
      )
    }
    if (value.subunit.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        SubstanceProteinSubunitSerializer.listSerializer,
        value.subunit,
      )
  }
}

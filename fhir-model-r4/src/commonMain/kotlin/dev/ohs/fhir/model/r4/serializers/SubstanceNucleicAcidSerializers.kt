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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceNucleicAcid
import dev.ohs.fhir.model.r4.Uri
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

internal object SubstanceNucleicAcidSubunitSerializer : KSerializer<SubstanceNucleicAcid.Subunit> {
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
      optionalElement("fivePrime", CodeableConceptSerializer.descriptor)
      optionalElement("threePrime", CodeableConceptSerializer.descriptor)
      optionalElement(
        "linkage",
        SubstanceNucleicAcidSubunitLinkageSerializer.listSerializer.descriptor,
      )
      optionalElement("sugar", SubstanceNucleicAcidSubunitSugarSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceNucleicAcid.Subunit>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit {
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
    var fivePrime: CodeableConcept? = null
    var threePrime: CodeableConcept? = null
    var linkage: List<SubstanceNucleicAcid.Subunit.Linkage>? = null
    var sugar: List<SubstanceNucleicAcid.Subunit.Sugar>? = null
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
          fivePrime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          threePrime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          linkage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceNucleicAcidSubunitLinkageSerializer.listSerializer,
              null,
            )
        13 ->
          sugar =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceNucleicAcidSubunitSugarSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subunit: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceNucleicAcid.Subunit(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      subunit = Integer.of(subunit, _subunit),
      sequence = R4String.of(sequence, _sequence),
      length = Integer.of(length, _length),
      sequenceAttachment = sequenceAttachment,
      fivePrime = fivePrime,
      threePrime = threePrime,
      linkage = linkage ?: listOf(),
      sugar = sugar ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit) {
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
      CodeableConceptSerializer,
      value.fivePrime,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      CodeableConceptSerializer,
      value.threePrime,
    )
    if (value.linkage.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        SubstanceNucleicAcidSubunitLinkageSerializer.listSerializer,
        value.linkage,
      )
    if (value.sugar.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13,
        SubstanceNucleicAcidSubunitSugarSerializer.listSerializer,
        value.sugar,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceNucleicAcidSubunitLinkageSerializer :
  KSerializer<SubstanceNucleicAcid.Subunit.Linkage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Linkage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("connectivity", KotlinString.serializer().descriptor)
      optionalElement("_connectivity", ElementSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("residueSite", KotlinString.serializer().descriptor)
      optionalElement("_residueSite", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceNucleicAcid.Subunit.Linkage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit.Linkage {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var connectivity: KotlinString? = null
    var _connectivity: Element? = null
    var identifier: Identifier? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var residueSite: KotlinString? = null
    var _residueSite: Element? = null
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
        3 -> connectivity = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _connectivity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        6 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> residueSite = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _residueSite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Linkage: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceNucleicAcid.Subunit.Linkage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      connectivity = R4String.of(connectivity, _connectivity),
      identifier = identifier,
      name = R4String.of(name, _name),
      residueSite = R4String.of(residueSite, _residueSite),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Linkage) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.connectivity?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.connectivity)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.residueSite?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.residueSite)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceNucleicAcidSubunitSugarSerializer :
  KSerializer<SubstanceNucleicAcid.Subunit.Sugar> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Sugar") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("residueSite", KotlinString.serializer().descriptor)
      optionalElement("_residueSite", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceNucleicAcid.Subunit.Sugar>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit.Sugar {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var residueSite: KotlinString? = null
    var _residueSite: Element? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        4 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> residueSite = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _residueSite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Sugar: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceNucleicAcid.Subunit.Sugar(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      name = R4String.of(name, _name),
      residueSite = R4String.of(residueSite, _residueSite),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Sugar) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.residueSite?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.residueSite)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceNucleicAcidSerializer : FhirResourceSerializer<SubstanceNucleicAcid> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstanceNucleicAcid")

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
    b.optionalElement("areaOfHybridisation", KotlinString.serializer().descriptor)
    b.optionalElement("_areaOfHybridisation", ElementSerializer.descriptor)
    b.optionalElement("oligoNucleotideType", CodeableConceptSerializer.descriptor)
    b.optionalElement("subunit", SubstanceNucleicAcidSubunitSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubstanceNucleicAcid {
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
    var areaOfHybridisation: KotlinString? = null
    var _areaOfHybridisation: Element? = null
    var oligoNucleotideType: CodeableConcept? = null
    var subunit: List<SubstanceNucleicAcid.Subunit>? = null
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
        13 -> areaOfHybridisation = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _areaOfHybridisation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          oligoNucleotideType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          subunit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceNucleicAcidSubunitSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SubstanceNucleicAcid: " + i)
      }
    }
    return SubstanceNucleicAcid(
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
      areaOfHybridisation = R4String.of(areaOfHybridisation, _areaOfHybridisation),
      oligoNucleotideType = oligoNucleotideType,
      subunit = subunit ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceNucleicAcid,
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.areaOfHybridisation?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.areaOfHybridisation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.oligoNucleotideType,
    )
    if (value.subunit.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        SubstanceNucleicAcidSubunitSerializer.listSerializer,
        value.subunit,
      )
  }
}

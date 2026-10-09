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
import dev.ohs.fhir.model.r5.SubstanceNucleicAcid
import dev.ohs.fhir.model.r5.Uri
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

internal object SubstanceNucleicAcidSubunitSerializer :
  FhirSerializer<SubstanceNucleicAcid.Subunit> {
  override val descriptor: SerialDescriptor = buildDescriptor("Subunit", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceNucleicAcid.Subunit>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("subunit")
    b.strPrim("sequence")
    b.intPrim("length")
    b.optionalElement("sequenceAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("fivePrime", CodeableConceptSerializer.descriptor)
    b.optionalElement("threePrime", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "linkage",
      SubstanceNucleicAcidSubunitLinkageSerializer.listSerializer.descriptor,
    )
    b.optionalElement("sugar", SubstanceNucleicAcidSubunitSugarSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceNucleicAcid.Subunit(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      subunit = Integer.of(subunit, _subunit),
      sequence = R5String.of(sequence, _sequence),
      length = Integer.of(length, _length),
      sequenceAttachment = sequenceAttachment,
      fivePrime = fivePrime,
      threePrime = threePrime,
      linkage = listOrEmpty(linkage),
      sugar = listOrEmpty(sugar),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit) {
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      SubstanceNucleicAcidSubunitLinkageSerializer.listSerializer,
      value.linkage,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      SubstanceNucleicAcidSubunitSugarSerializer.listSerializer,
      value.sugar,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubstanceNucleicAcidSubunitLinkageSerializer :
  FhirSerializer<SubstanceNucleicAcid.Subunit.Linkage> {
  override val descriptor: SerialDescriptor = buildDescriptor("Linkage", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceNucleicAcid.Subunit.Linkage>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("connectivity")
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("residueSite")
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit.Linkage {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceNucleicAcid.Subunit.Linkage(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      connectivity = R5String.of(connectivity, _connectivity),
      identifier = identifier,
      name = R5String.of(name, _name),
      residueSite = R5String.of(residueSite, _residueSite),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Linkage) {
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
  FhirSerializer<SubstanceNucleicAcid.Subunit.Sugar> {
  override val descriptor: SerialDescriptor = buildDescriptor("Sugar", this)

  @JvmField
  internal val listSerializer: KSerializer<List<SubstanceNucleicAcid.Subunit.Sugar>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("residueSite")
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit.Sugar {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubstanceNucleicAcid.Subunit.Sugar(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = identifier,
      name = R5String.of(name, _name),
      residueSite = R5String.of(residueSite, _residueSite),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Sugar) {
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
    b.optionalElement("sequenceType", CodeableConceptSerializer.descriptor)
    b.intPrim("numberOfSubunits")
    b.strPrim("areaOfHybridisation")
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
        else -> unknownIndex(descriptor, i)
      }
    }
    return SubstanceNucleicAcid(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequenceType = sequenceType,
      numberOfSubunits = Integer.of(numberOfSubunits, _numberOfSubunits),
      areaOfHybridisation = R5String.of(areaOfHybridisation, _areaOfHybridisation),
      oligoNucleotideType = oligoNucleotideType,
      subunit = listOrEmpty(subunit),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      SubstanceNucleicAcidSubunitSerializer.listSerializer,
      value.subunit,
    )
  }
}

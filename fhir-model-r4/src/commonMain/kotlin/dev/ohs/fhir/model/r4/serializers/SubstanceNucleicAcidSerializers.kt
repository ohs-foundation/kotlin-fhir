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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object SubstanceNucleicAcidSubunitSerializer : KSerializer<SubstanceNucleicAcid.Subunit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Subunit") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("subunit", Int.serializer().descriptor, isOptional = true)
      element("_subunit", Element.serializer().descriptor, isOptional = true)
      element("sequence", KotlinString.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("length", Int.serializer().descriptor, isOptional = true)
      element("_length", Element.serializer().descriptor, isOptional = true)
      element("sequenceAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("fivePrime", CodeableConcept.serializer().descriptor, isOptional = true)
      element("threePrime", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "linkage",
        listSerialDescriptor(
          lazyDescriptor { SubstanceNucleicAcid.Subunit.Linkage.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "sugar",
        listSerialDescriptor(
          lazyDescriptor { SubstanceNucleicAcid.Subunit.Sugar.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceNucleicAcid.Subunit {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> subunit = decoder.decodeIntElement(descriptor, i)
        4 ->
          _subunit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subunitSer, null)
        5 -> sequence = decoder.decodeStringElement(descriptor, i)
        6 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subunitSer, null)
        7 -> length = decoder.decodeIntElement(descriptor, i)
        8 ->
          _length =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subunitSer, null)
        9 ->
          sequenceAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sequenceAttachmentSer,
              null,
            )
        10 ->
          fivePrime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fivePrimeSer, null)
        11 ->
          threePrime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fivePrimeSer, null)
        12 ->
          linkage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkageSer, null)
        13 ->
          sugar = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sugarSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subunit: " + i)
      }
    }
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: SubstanceNucleicAcid.Subunit) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.subunit?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.subunit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.subunitSer, it)
    }
    ((value.sequence?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.subunitSer, it)
    }
    ((value.length?.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.length?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.subunitSer, it)
    }
    (value.sequenceAttachment)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.sequenceAttachmentSer, it)
    }
    (value.fivePrime)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.fivePrimeSer, it)
    }
    (value.threePrime)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.fivePrimeSer, it)
    }
    if (value.linkage.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.linkageSer, value.linkage)
    if (value.sugar.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.sugarSer, value.sugar)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val subunitSer: KSerializer<Element> = Element.serializer()

    public val sequenceAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val fivePrimeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val linkageSerInner: KSerializer<SubstanceNucleicAcid.Subunit.Linkage> =
      SubstanceNucleicAcid.Subunit.Linkage.serializer()

    public val linkageSer: KSerializer<List<SubstanceNucleicAcid.Subunit.Linkage>> =
      ListSerializer(Hoisted.linkageSerInner)

    public val sugarSerInner: KSerializer<SubstanceNucleicAcid.Subunit.Sugar> =
      SubstanceNucleicAcid.Subunit.Sugar.serializer()

    public val sugarSer: KSerializer<List<SubstanceNucleicAcid.Subunit.Sugar>> =
      ListSerializer(Hoisted.sugarSerInner)
  }
}

internal object SubstanceNucleicAcidSubunitLinkageSerializer :
  KSerializer<SubstanceNucleicAcid.Subunit.Linkage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Linkage") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("connectivity", KotlinString.serializer().descriptor, isOptional = true)
      element("_connectivity", Element.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("residueSite", KotlinString.serializer().descriptor, isOptional = true)
      element("_residueSite", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit.Linkage =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Linkage) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceNucleicAcid.Subunit.Linkage {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> connectivity = decoder.decodeStringElement(descriptor, i)
        4 ->
          _connectivity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.connectivitySer, null)
        5 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        6 -> name = decoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.connectivitySer, null)
        8 -> residueSite = decoder.decodeStringElement(descriptor, i)
        9 ->
          _residueSite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.connectivitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Linkage: " + i)
      }
    }
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceNucleicAcid.Subunit.Linkage,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.connectivity?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.connectivity?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.connectivitySer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.identifierSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.connectivitySer, it)
    }
    ((value.residueSite?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.residueSite?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.connectivitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val connectivitySer: KSerializer<Element> = Element.serializer()

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()
  }
}

internal object SubstanceNucleicAcidSubunitSugarSerializer :
  KSerializer<SubstanceNucleicAcid.Subunit.Sugar> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Sugar") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("residueSite", KotlinString.serializer().descriptor, isOptional = true)
      element("_residueSite", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit.Sugar =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Sugar) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceNucleicAcid.Subunit.Sugar {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var residueSite: KotlinString? = null
    var _residueSite: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 -> name = decoder.decodeStringElement(descriptor, i)
        5 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        6 -> residueSite = decoder.decodeStringElement(descriptor, i)
        7 ->
          _residueSite =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Sugar: " + i)
      }
    }
    return SubstanceNucleicAcid.Subunit.Sugar(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      name = R4String.of(name, _name),
      residueSite = R4String.of(residueSite, _residueSite),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceNucleicAcid.Subunit.Sugar,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.nameSer, it)
    }
    ((value.residueSite?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.residueSite?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SubstanceNucleicAcidSerializer : KSerializer<SubstanceNucleicAcid> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceNucleicAcid") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("sequenceType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("numberOfSubunits", Int.serializer().descriptor, isOptional = true)
    b.element("_numberOfSubunits", Element.serializer().descriptor, isOptional = true)
    b.element("areaOfHybridisation", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_areaOfHybridisation", Element.serializer().descriptor, isOptional = true)
    b.element("oligoNucleotideType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "subunit",
      listSerialDescriptor(lazyDescriptor { SubstanceNucleicAcid.Subunit.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstanceNucleicAcid")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          sequenceType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceTypeSer, null)
        11 -> numberOfSubunits = decoder.decodeIntElement(descriptor, i)
        12 ->
          _numberOfSubunits =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> areaOfHybridisation = decoder.decodeStringElement(descriptor, i)
        14 ->
          _areaOfHybridisation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          oligoNucleotideType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceTypeSer, null)
        16 ->
          subunit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subunitSer, null)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceNucleicAcid,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.sequenceType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.sequenceTypeSer,
        it,
      )
    }
    ((value.numberOfSubunits?.value))?.let {
      encoder.encodeIntElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.numberOfSubunits?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.areaOfHybridisation?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.areaOfHybridisation?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.oligoNucleotideType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.sequenceTypeSer,
        it,
      )
    }
    if (value.subunit.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.subunitSer,
        value.subunit,
      )
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subunitSerInner: KSerializer<SubstanceNucleicAcid.Subunit> =
      SubstanceNucleicAcid.Subunit.serializer()

    public val subunitSer: KSerializer<List<SubstanceNucleicAcid.Subunit>> =
      ListSerializer(Hoisted.subunitSerInner)
  }
}

internal object SubstanceNucleicAcidPolymorphicSerializer : KSerializer<SubstanceNucleicAcid> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceNucleicAcid") {
      SubstanceNucleicAcidSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid) {
    encoder.encodeStructure(descriptor) {
      SubstanceNucleicAcidSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid =
    decoder.decodeStructure(descriptor) {
      SubstanceNucleicAcidSerializer.deserializeInternal(this, descriptor, 0)
    }
}

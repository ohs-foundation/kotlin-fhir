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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceNucleicAcid.Subunit {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> subunit = decoder.decodeIntElement(__desc, 3)
        4 ->
          _subunit = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.subunitSer, null)
        5 -> sequence = decoder.decodeStringElement(__desc, 5)
        6 ->
          _sequence = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.subunitSer, null)
        7 -> length = decoder.decodeIntElement(__desc, 7)
        8 ->
          _length = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.subunitSer, null)
        9 ->
          sequenceAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              9,
              Hoisted.sequenceAttachmentSer,
              null,
            )
        10 ->
          fivePrime =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.fivePrimeSer, null)
        11 ->
          threePrime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.fivePrimeSer, null)
        12 ->
          linkage = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.linkageSer, null)
        13 -> sugar = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.sugarSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subunit: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceNucleicAcid.Subunit) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.subunit?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.subunit?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.subunitSer, it)
    }
    ((value.sequence?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.subunitSer, it)
    }
    ((value.length?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.length?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.subunitSer, it)
    }
    (value.sequenceAttachment)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.sequenceAttachmentSer, it)
    }
    (value.fivePrime)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.fivePrimeSer, it)
    }
    (value.threePrime)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.fivePrimeSer, it)
    }
    if (value.linkage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.linkageSer, value.linkage)
    if (value.sugar.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.sugarSer, value.sugar)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Linkage) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceNucleicAcid.Subunit.Linkage {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> connectivity = decoder.decodeStringElement(__desc, 3)
        4 ->
          _connectivity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.connectivitySer, null)
        5 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.identifierSer, null)
        6 -> name = decoder.decodeStringElement(__desc, 6)
        7 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.connectivitySer, null)
        8 -> residueSite = decoder.decodeStringElement(__desc, 8)
        9 ->
          _residueSite =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.connectivitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Linkage: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceNucleicAcid.Subunit.Linkage,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.connectivity?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.connectivity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.connectivitySer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.identifierSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.connectivitySer, it)
    }
    ((value.residueSite?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.residueSite?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.connectivitySer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Sugar) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceNucleicAcid.Subunit.Sugar {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var residueSite: KotlinString? = null
    var _residueSite: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 -> name = decoder.decodeStringElement(__desc, 4)
        5 -> _name = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.nameSer, null)
        6 -> residueSite = decoder.decodeStringElement(__desc, 6)
        7 ->
          _residueSite = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Sugar: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceNucleicAcid.Subunit.Sugar,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.nameSer, it)
    }
    ((value.residueSite?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.residueSite?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.nameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstanceNucleicAcid")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): SubstanceNucleicAcid {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          sequenceType =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.sequenceTypeSer, null)
        12 -> numberOfSubunits = decoder.decodeIntElement(__desc, 12)
        13 ->
          _numberOfSubunits =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> areaOfHybridisation = decoder.decodeStringElement(__desc, 14)
        15 ->
          _areaOfHybridisation =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          oligoNucleotideType =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.sequenceTypeSer, null)
        17 ->
          subunit = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.subunitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding SubstanceNucleicAcid: " + __i)
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

  internal fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceNucleicAcid) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    (value.sequenceType)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.sequenceTypeSer, it)
    }
    ((value.numberOfSubunits?.value))?.let { encoder.encodeIntElement(__desc, 12, it) }
    (value.numberOfSubunits?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.areaOfHybridisation?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.areaOfHybridisation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.oligoNucleotideType)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.sequenceTypeSer, it)
    }
    if (value.subunit.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.subunitSer, value.subunit)
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
      SubstanceNucleicAcidSerializer.serializeJson(this, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid =
    decoder.decodeStructure(descriptor) { SubstanceNucleicAcidSerializer.deserializeJson(this) }
}

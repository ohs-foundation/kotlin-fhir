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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubstanceProtein
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
      element("nTerminalModificationId", Identifier.serializer().descriptor, isOptional = true)
      element("nTerminalModification", KotlinString.serializer().descriptor, isOptional = true)
      element("_nTerminalModification", Element.serializer().descriptor, isOptional = true)
      element("cTerminalModificationId", Identifier.serializer().descriptor, isOptional = true)
      element("cTerminalModification", KotlinString.serializer().descriptor, isOptional = true)
      element("_cTerminalModification", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceProtein.Subunit =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceProtein.Subunit) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceProtein.Subunit {
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
    var nTerminalModificationId: Identifier? = null
    var nTerminalModification: KotlinString? = null
    var _nTerminalModification: Element? = null
    var cTerminalModificationId: Identifier? = null
    var cTerminalModification: KotlinString? = null
    var _cTerminalModification: Element? = null
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
          nTerminalModificationId =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.nTerminalModificationIdSer,
              null,
            )
        11 -> nTerminalModification = decoder.decodeStringElement(__desc, 11)
        12 ->
          _nTerminalModification =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.subunitSer, null)
        13 ->
          cTerminalModificationId =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.nTerminalModificationIdSer,
              null,
            )
        14 -> cTerminalModification = decoder.decodeStringElement(__desc, 14)
        15 ->
          _cTerminalModification =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.subunitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subunit: " + __i)
      }
    }
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceProtein.Subunit) {
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
    (value.nTerminalModificationId)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.nTerminalModificationIdSer, it)
    }
    ((value.nTerminalModification?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.nTerminalModification?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.subunitSer, it)
    }
    (value.cTerminalModificationId)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.nTerminalModificationIdSer, it)
    }
    ((value.cTerminalModification?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.cTerminalModification?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.subunitSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val subunitSer: KSerializer<Element> = Element.serializer()

    public val sequenceAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val nTerminalModificationIdSer: KSerializer<Identifier> = Identifier.serializer()
  }
}

internal object SubstanceProteinSerializer : KSerializer<SubstanceProtein> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceProtein") {
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
    b.element(
      "disulfideLinkage",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_disulfideLinkage",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "subunit",
      listSerialDescriptor(lazyDescriptor { SubstanceProtein.Subunit.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SubstanceProtein =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceProtein) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstanceProtein")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): SubstanceProtein {
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
    var disulfideLinkage: List<KotlinString?>? = null
    var _disulfideLinkage: List<Element?>? = null
    var subunit: List<SubstanceProtein.Subunit>? = null
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
        14 ->
          disulfideLinkage =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.disulfideLinkageSer, null)
        15 ->
          _disulfideLinkage =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.disulfideLinkageSer2,
              null,
            )
        16 ->
          subunit = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.subunitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubstanceProtein: " + __i)
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
        ) { __i ->
          R5String.of(
            disulfideLinkage?.getOrNull(__i)?.let { it },
            _disulfideLinkage?.getOrNull(__i),
          )!!
        }),
      subunit = subunit ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceProtein) {
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
    (value.disulfideLinkage.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.disulfideLinkageSer, it)
    }
    (value.disulfideLinkage.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.disulfideLinkageSer2, it)
    }
    if (value.subunit.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.subunitSer, value.subunit)
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

    public val disulfideLinkageSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val disulfideLinkageSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.disulfideLinkageSerInner).nullable)

    public val disulfideLinkageSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val subunitSerInner: KSerializer<SubstanceProtein.Subunit> =
      SubstanceProtein.Subunit.serializer()

    public val subunitSer: KSerializer<List<SubstanceProtein.Subunit>> =
      ListSerializer(Hoisted.subunitSerInner)
  }
}

internal object SubstanceProteinPolymorphicSerializer : KSerializer<SubstanceProtein> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceProtein") {
      SubstanceProteinSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceProtein) {
    encoder.encodeStructure(descriptor) { SubstanceProteinSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): SubstanceProtein =
    decoder.decodeStructure(descriptor) { SubstanceProteinSerializer.deserializeJson(this) }
}

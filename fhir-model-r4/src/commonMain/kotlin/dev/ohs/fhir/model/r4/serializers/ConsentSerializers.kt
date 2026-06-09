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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Consent
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object ConsentPolicySerializer : KSerializer<Consent.Policy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Policy") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("authority", String.serializer().descriptor, isOptional = true)
      element("_authority", Element.serializer().descriptor, isOptional = true)
      element("uri", String.serializer().descriptor, isOptional = true)
      element("_uri", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Consent.Policy =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Policy) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Consent.Policy {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var authority: String? = null
    var _authority: Element? = null
    var uri: String? = null
    var _uri: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> authority = decoder.decodeStringElement(descriptor, i)
        4 ->
          _authority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authoritySer, null)
        5 -> uri = decoder.decodeStringElement(descriptor, i)
        6 ->
          _uri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authoritySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Policy: " + i)
      }
    }
    return Consent.Policy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      authority = Uri.of(authority, _authority),
      uri = Uri.of(uri, _uri),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Consent.Policy) {
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
    ((value.authority?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.authority?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.authoritySer, it)
    }
    ((value.uri?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.authoritySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val authoritySer: KSerializer<Element> = Element.serializer()
  }
}

internal object ConsentVerificationSerializer : KSerializer<Consent.Verification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Verification") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("verified", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_verified", Element.serializer().descriptor, isOptional = true)
      element("verifiedWith", Reference.serializer().descriptor, isOptional = true)
      element("verificationDate", String.serializer().descriptor, isOptional = true)
      element("_verificationDate", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Consent.Verification =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Verification) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Consent.Verification {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var verified: KotlinBoolean? = null
    var _verified: Element? = null
    var verifiedWith: Reference? = null
    var verificationDate: String? = null
    var _verificationDate: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> verified = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _verified =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.verifiedSer, null)
        5 ->
          verifiedWith =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.verifiedWithSer, null)
        6 -> verificationDate = decoder.decodeStringElement(descriptor, i)
        7 ->
          _verificationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.verifiedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Verification: " + i)
      }
    }
    return Consent.Verification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      verified = R4Boolean.of(verified, _verified)!!,
      verifiedWith = verifiedWith,
      verificationDate = DateTime.of(FhirDateTime.fromString(verificationDate), _verificationDate),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Consent.Verification) {
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
    ((value.verified.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.verified.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.verifiedSer, it)
    }
    (value.verifiedWith)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.verifiedWithSer, it)
    }
    ((value.verificationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 6, it)
    }
    (value.verificationDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.verifiedSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val verifiedSer: KSerializer<Element> = Element.serializer()

    public val verifiedWithSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ConsentProvisionSerializer : KSerializer<Consent.Provision> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Provision") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("type", String.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element(
        "actor",
        listSerialDescriptor(lazyDescriptor { Consent.Provision.Actor.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "action",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "securityLabel",
        listSerialDescriptor(Coding.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element("class", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("dataPeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "data",
        listSerialDescriptor(lazyDescriptor { Consent.Provision.Data.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "provision",
        listSerialDescriptor(lazyDescriptor { Consent.Provision.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Consent.Provision =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Consent.Provision {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: String? = null
    var _type: Element? = null
    var period: Period? = null
    var actor: List<Consent.Provision.Actor>? = null
    var action: List<CodeableConcept>? = null
    var securityLabel: List<Coding>? = null
    var purpose: List<Coding>? = null
    var `class`: List<Coding>? = null
    var code: List<CodeableConcept>? = null
    var dataPeriod: Period? = null
    var `data`: List<Consent.Provision.Data>? = null
    var provision: List<Consent.Provision>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        6 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        7 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        8 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securityLabelSer, null)
        9 ->
          purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securityLabelSer, null)
        10 ->
          `class` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securityLabelSer, null)
        11 ->
          code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        12 ->
          dataPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        13 ->
          `data` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dataSer, null)
        14 ->
          provision =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.provisionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Provision: " + i)
      }
    }
    return Consent.Provision(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type?.let { Enumeration.of(Consent.ConsentProvisionType.fromCode(it), _type) },
      period = period,
      actor = actor ?: listOf(),
      action = action ?: listOf(),
      securityLabel = securityLabel ?: listOf(),
      purpose = purpose ?: listOf(),
      `class` = `class` ?: listOf(),
      code = code ?: listOf(),
      dataPeriod = dataPeriod,
      `data` = `data` ?: listOf(),
      provision = provision ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Consent.Provision) {
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
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.periodSer, it) }
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.actorSer, value.actor)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.actionSer, value.action)
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        Hoisted.securityLabelSer,
        value.securityLabel,
      )
    if (value.purpose.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.securityLabelSer, value.purpose)
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.securityLabelSer, value.`class`)
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.actionSer, value.code)
    (value.dataPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.periodSer, it)
    }
    if (value.`data`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.dataSer, value.`data`)
    if (value.provision.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.provisionSer, value.provision)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val actorSerInner: KSerializer<Consent.Provision.Actor> =
      Consent.Provision.Actor.serializer()

    public val actorSer: KSerializer<List<Consent.Provision.Actor>> =
      ListSerializer(Hoisted.actorSerInner)

    public val actionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.actionSerInner)

    public val securityLabelSerInner: KSerializer<Coding> = Coding.serializer()

    public val securityLabelSer: KSerializer<List<Coding>> =
      ListSerializer(Hoisted.securityLabelSerInner)

    public val dataSerInner: KSerializer<Consent.Provision.Data> =
      Consent.Provision.Data.serializer()

    public val dataSer: KSerializer<List<Consent.Provision.Data>> =
      ListSerializer(Hoisted.dataSerInner)

    public val provisionSerInner: KSerializer<Consent.Provision> = Consent.Provision.serializer()

    public val provisionSer: KSerializer<List<Consent.Provision>> =
      ListSerializer(Hoisted.provisionSerInner)
  }
}

internal object ConsentProvisionActorSerializer : KSerializer<Consent.Provision.Actor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Actor") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Consent.Provision.Actor =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Actor) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Consent.Provision.Actor {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: CodeableConcept? = null
    var reference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        4 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Actor: " + i)
      }
    }
    return Consent.Provision.Actor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role = role!!,
      reference = reference!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Consent.Provision.Actor) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.roleSer, value.role)
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.referenceSer, value.reference)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val referenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ConsentProvisionDataSerializer : KSerializer<Consent.Provision.Data> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Data") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("meaning", String.serializer().descriptor, isOptional = true)
      element("_meaning", Element.serializer().descriptor, isOptional = true)
      element("reference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Consent.Provision.Data =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Data) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Consent.Provision.Data {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var meaning: String? = null
    var _meaning: Element? = null
    var reference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> meaning = decoder.decodeStringElement(descriptor, i)
        4 ->
          _meaning =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.meaningSer, null)
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Data: " + i)
      }
    }
    return Consent.Provision.Data(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      meaning = Enumeration.of(Consent.ConsentDataMeaning.fromCode(meaning!!), _meaning),
      reference = reference!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Consent.Provision.Data) {
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
    ((value.meaning.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.meaning.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.meaningSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.referenceSer, value.reference)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val meaningSer: KSerializer<Element> = Element.serializer()

    public val referenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ConsentSerializer : KSerializer<Consent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Consent") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("scope", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("dateTime", String.serializer().descriptor, isOptional = true)
    b.element("_dateTime", Element.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "organization",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("sourceAttachment", Attachment.serializer().descriptor, isOptional = true)
    b.element("sourceReference", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "policy",
      listSerialDescriptor(lazyDescriptor { Consent.Policy.serializer().descriptor }),
      isOptional = true,
    )
    b.element("policyRule", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "verification",
      listSerialDescriptor(lazyDescriptor { Consent.Verification.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "provision",
      lazyDescriptor { Consent.Provision.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Consent =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Consent) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Consent")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Consent {
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
    var scope: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var patient: Reference? = null
    var dateTime: String? = null
    var _dateTime: Element? = null
    var performer: List<Reference>? = null
    var organization: List<Reference>? = null
    var sourceAttachment: Attachment? = null
    var sourceReference: Reference? = null
    var policy: List<Consent.Policy>? = null
    var policyRule: CodeableConcept? = null
    var verification: List<Consent.Verification>? = null
    var provision: Consent.Provision? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          scope = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scopeSer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        16 -> dateTime = decoder.decodeStringElement(descriptor, i)
        17 ->
          _dateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        19 ->
          organization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerSer, null)
        20 ->
          sourceAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sourceAttachmentSer,
              null,
            )
        21 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        22 ->
          policy = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policySer, null)
        23 ->
          policyRule =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scopeSer, null)
        24 ->
          verification =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.verificationSer, null)
        25 ->
          provision =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.provisionSer, null)
        else -> throw SerializationException("Unexpected index decoding Consent: " + i)
      }
    }
    return Consent(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(Consent.ConsentState.fromCode(status!!), _status),
      scope = scope!!,
      category = category ?: listOf(),
      patient = patient,
      dateTime = DateTime.of(FhirDateTime.fromString(dateTime), _dateTime),
      performer = performer ?: listOf(),
      organization = organization ?: listOf(),
      source = Consent.Source.from(sourceAttachment, sourceReference),
      policy = policy ?: listOf(),
      policyRule = policyRule,
      verification = verification ?: listOf(),
      provision = provision,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Consent,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      Hoisted.scopeSer,
      value.scope,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    (value.patient)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.patientSer, it)
    }
    ((value.dateTime?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.dateTime?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.performerSer,
        value.performer,
      )
    if (value.organization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.performerSer,
        value.organization,
      )
    when (val choice = value.source) {
      null -> {}
      is Consent.Source.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          20 + descriptorOffset,
          Hoisted.sourceAttachmentSer,
          choice.value,
        )
      }
      is Consent.Source.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          Hoisted.patientSer,
          choice.value,
        )
      }
    }
    if (value.policy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.policySer,
        value.policy,
      )
    (value.policyRule)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, Hoisted.scopeSer, it)
    }
    if (value.verification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.verificationSer,
        value.verification,
      )
    (value.provision)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.provisionSer, it)
    }
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val scopeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.scopeSer)

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val performerSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)

    public val sourceAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val policySerInner: KSerializer<Consent.Policy> = Consent.Policy.serializer()

    public val policySer: KSerializer<List<Consent.Policy>> = ListSerializer(Hoisted.policySerInner)

    public val verificationSerInner: KSerializer<Consent.Verification> =
      Consent.Verification.serializer()

    public val verificationSer: KSerializer<List<Consent.Verification>> =
      ListSerializer(Hoisted.verificationSerInner)

    public val provisionSer: KSerializer<Consent.Provision> = Consent.Provision.serializer()
  }
}

internal object ConsentPolymorphicSerializer : KSerializer<Consent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Consent") { ConsentSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Consent) {
    encoder.encodeStructure(descriptor) {
      ConsentSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Consent =
    decoder.decodeStructure(descriptor) {
      ConsentSerializer.deserializeInternal(this, descriptor, 0)
    }
}

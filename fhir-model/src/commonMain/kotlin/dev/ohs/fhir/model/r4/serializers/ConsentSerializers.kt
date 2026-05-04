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
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Policy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Consent.Policy {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var authority: String? = null
    var _authority: Element? = null
    var uri: String? = null
    var _uri: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> authority = decoder.decodeStringElement(__desc, 3)
        4 ->
          _authority =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.authoritySer, null)
        5 -> uri = decoder.decodeStringElement(__desc, 5)
        6 -> _uri = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.authoritySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Policy: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Consent.Policy) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.authority?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.authority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.authoritySer, it)
    }
    ((value.uri?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.authoritySer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Verification) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Consent.Verification {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var verified: KotlinBoolean? = null
    var _verified: Element? = null
    var verifiedWith: Reference? = null
    var verificationDate: String? = null
    var _verificationDate: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> verified = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _verified =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.verifiedSer, null)
        5 ->
          verifiedWith =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.verifiedWithSer, null)
        6 -> verificationDate = decoder.decodeStringElement(__desc, 6)
        7 ->
          _verificationDate =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.verifiedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Verification: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Consent.Verification) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.verified.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.verified.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.verifiedSer, it)
    }
    (value.verifiedWith)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.verifiedWithSer, it)
    }
    ((value.verificationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 6, it)
    }
    (value.verificationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.verifiedSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Consent.Provision {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> period = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.periodSer, null)
        6 -> actor = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.actorSer, null)
        7 -> action = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.actionSer, null)
        8 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.securityLabelSer, null)
        9 ->
          purpose =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.securityLabelSer, null)
        10 ->
          `class` =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.securityLabelSer, null)
        11 -> code = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.actionSer, null)
        12 ->
          dataPeriod =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.periodSer, null)
        13 -> `data` = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.dataSer, null)
        14 ->
          provision =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.provisionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Provision: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Consent.Provision) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.periodSer, it) }
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.actorSer, value.actor)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.actionSer, value.action)
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.securityLabelSer, value.securityLabel)
    if (value.purpose.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.securityLabelSer, value.purpose)
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.securityLabelSer, value.`class`)
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.actionSer, value.code)
    (value.dataPeriod)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.periodSer, it) }
    if (value.`data`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.dataSer, value.`data`)
    if (value.provision.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.provisionSer, value.provision)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Actor) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Consent.Provision.Actor {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: CodeableConcept? = null
    var reference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.roleSer, null)
        4 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Actor: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Consent.Provision.Actor) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.roleSer, it) }
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.referenceSer, it)
    }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.Provision.Data) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Consent.Provision.Data {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var meaning: String? = null
    var _meaning: Element? = null
    var reference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> meaning = decoder.decodeStringElement(__desc, 3)
        4 ->
          _meaning = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.meaningSer, null)
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Data: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Consent.Provision.Data) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.meaning.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.meaning.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.meaningSer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.referenceSer, it)
    }
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
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("scope", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("dateTime", String.serializer().descriptor, isOptional = true)
      element("_dateTime", Element.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "organization",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("sourceAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("sourceReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "policy",
        listSerialDescriptor(lazyDescriptor { Consent.Policy.serializer().descriptor }),
        isOptional = true,
      )
      element("policyRule", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "verification",
        listSerialDescriptor(lazyDescriptor { Consent.Verification.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "provision",
        lazyDescriptor { Consent.Provision.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Consent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Consent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Consent {
    val __desc = descriptor
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
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> scope = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.scopeSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.patientSer, null)
        17 -> dateTime = decoder.decodeStringElement(__desc, 17)
        18 ->
          _dateTime =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.performerSer, null)
        20 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.performerSer, null)
        21 ->
          sourceAttachment =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.sourceAttachmentSer, null)
        22 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.patientSer, null)
        23 ->
          policy = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.policySer, null)
        24 ->
          policyRule = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.scopeSer, null)
        25 ->
          verification =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.verificationSer, null)
        26 ->
          provision =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.provisionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Consent: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Consent) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Consent")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.scope)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.scopeSer, it) }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, value.category)
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.patientSer, it) }
    ((value.dateTime?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.dateTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.performerSer, value.performer)
    if (value.organization.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.performerSer, value.organization)
    when (val __d = value.source) {
      null -> {}
      is Consent.Source.Attachment -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.sourceAttachmentSer, __d.value)
      }
      is Consent.Source.Reference -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.patientSer, __d.value)
      }
    }
    if (value.policy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.policySer, value.policy)
    (value.policyRule)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.scopeSer, it) }
    if (value.verification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.verificationSer, value.verification)
    (value.provision)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.provisionSer, it)
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

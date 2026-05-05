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
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Consent
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import kotlin.Boolean as KotlinBoolean
import kotlin.String
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

internal object ConsentPolicyBasisSerializer : KSerializer<Consent.PolicyBasis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PolicyBasis") {
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
      element("reference", Reference.serializer().descriptor, isOptional = true)
      element("url", String.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Consent.PolicyBasis =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Consent.PolicyBasis) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Consent.PolicyBasis {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var url: String? = null
    var _url: Element? = null
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
          reference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.referenceSer, null)
        4 -> url = decoder.decodeStringElement(__desc, 4)
        5 -> _url = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.urlSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PolicyBasis: " + __i)
      }
    }
    return Consent.PolicyBasis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference,
      url = Url.of(url, _url),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Consent.PolicyBasis) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.referenceSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.urlSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSer: KSerializer<Reference> = Reference.serializer()

    public val urlSer: KSerializer<Element> = Element.serializer()
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
      element("verificationType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("verifiedBy", Reference.serializer().descriptor, isOptional = true)
      element("verifiedWith", Reference.serializer().descriptor, isOptional = true)
      element(
        "verificationDate",
        listSerialDescriptor(String.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_verificationDate",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
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
    var verificationType: CodeableConcept? = null
    var verifiedBy: Reference? = null
    var verifiedWith: Reference? = null
    var verificationDate: List<String?>? = null
    var _verificationDate: List<Element?>? = null
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
          verificationType =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.verificationTypeSer, null)
        6 ->
          verifiedBy =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.verifiedBySer, null)
        7 ->
          verifiedWith =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.verifiedBySer, null)
        8 ->
          verificationDate =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.verificationDateSer, null)
        9 ->
          _verificationDate =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.verificationDateSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Verification: " + __i)
      }
    }
    return Consent.Verification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      verified = R5Boolean.of(verified, _verified)!!,
      verificationType = verificationType,
      verifiedBy = verifiedBy,
      verifiedWith = verifiedWith,
      verificationDate =
        (kotlin.collections.List(
          maxOf(verificationDate?.size ?: 0, _verificationDate?.size ?: 0)
        ) { __i ->
          DateTime.of(
            verificationDate?.getOrNull(__i)?.let { FhirDateTime.fromString(it) },
            _verificationDate?.getOrNull(__i),
          )!!
        }),
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
    (value.verificationType)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.verificationTypeSer, it)
    }
    (value.verifiedBy)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.verifiedBySer, it)
    }
    (value.verifiedWith)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.verifiedBySer, it)
    }
    (value.verificationDate.map { it.value?.toString() }.takeUnless { it.all { it == null } })
      ?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.verificationDateSer, it) }
    (value.verificationDate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.verificationDateSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val verifiedSer: KSerializer<Element> = Element.serializer()

    public val verificationTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val verifiedBySer: KSerializer<Reference> = Reference.serializer()

    public val verificationDateSerInner: KSerializer<String> = String.serializer()

    public val verificationDateSer: KSerializer<List<String?>> =
      ListSerializer((Hoisted.verificationDateSerInner).nullable)

    public val verificationDateSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.verifiedSer).nullable)
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
      element(
        "documentType",
        listSerialDescriptor(Coding.serializer().descriptor),
        isOptional = true,
      )
      element(
        "resourceType",
        listSerialDescriptor(Coding.serializer().descriptor),
        isOptional = true,
      )
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
      element("expression", Expression.serializer().descriptor, isOptional = true)
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
    var period: Period? = null
    var actor: List<Consent.Provision.Actor>? = null
    var action: List<CodeableConcept>? = null
    var securityLabel: List<Coding>? = null
    var purpose: List<Coding>? = null
    var documentType: List<Coding>? = null
    var resourceType: List<Coding>? = null
    var code: List<CodeableConcept>? = null
    var dataPeriod: Period? = null
    var `data`: List<Consent.Provision.Data>? = null
    var expression: Expression? = null
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
        3 -> period = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.periodSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        5 -> action = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.actionSer, null)
        6 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.securityLabelSer, null)
        7 ->
          purpose =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.securityLabelSer, null)
        8 ->
          documentType =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.securityLabelSer, null)
        9 ->
          resourceType =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.securityLabelSer, null)
        10 -> code = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.actionSer, null)
        11 ->
          dataPeriod =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.periodSer, null)
        12 -> `data` = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.dataSer, null)
        13 ->
          expression =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.expressionSer, null)
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
      period = period,
      actor = actor ?: listOf(),
      action = action ?: listOf(),
      securityLabel = securityLabel ?: listOf(),
      purpose = purpose ?: listOf(),
      documentType = documentType ?: listOf(),
      resourceType = resourceType ?: listOf(),
      code = code ?: listOf(),
      dataPeriod = dataPeriod,
      `data` = `data` ?: listOf(),
      expression = expression,
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
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.periodSer, it) }
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, value.actor)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.actionSer, value.action)
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.securityLabelSer, value.securityLabel)
    if (value.purpose.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.securityLabelSer, value.purpose)
    if (value.documentType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.securityLabelSer, value.documentType)
    if (value.resourceType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.securityLabelSer, value.resourceType)
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.actionSer, value.code)
    (value.dataPeriod)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.periodSer, it) }
    if (value.`data`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.dataSer, value.`data`)
    (value.expression)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.expressionSer, it)
    }
    if (value.provision.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.provisionSer, value.provision)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

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

    public val expressionSer: KSerializer<Expression> = Expression.serializer()

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
      role = role,
      reference = reference,
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
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("date", String.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("grantor", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("grantee", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("manager", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "controller",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "sourceAttachment",
      listSerialDescriptor(Attachment.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "sourceReference",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "regulatoryBasis",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "policyBasis",
      lazyDescriptor { Consent.PolicyBasis.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "policyText",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "verification",
      listSerialDescriptor(lazyDescriptor { Consent.Verification.serializer().descriptor }),
      isOptional = true,
    )
    b.element("decision", String.serializer().descriptor, isOptional = true)
    b.element("_decision", Element.serializer().descriptor, isOptional = true)
    b.element(
      "provision",
      listSerialDescriptor(lazyDescriptor { Consent.Provision.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Consent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Consent) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Consent")
      serializeJson(this, value)
    }
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
    var category: List<CodeableConcept>? = null
    var subject: Reference? = null
    var date: String? = null
    var _date: Element? = null
    var period: Period? = null
    var grantor: List<Reference>? = null
    var grantee: List<Reference>? = null
    var manager: List<Reference>? = null
    var controller: List<Reference>? = null
    var sourceAttachment: List<Attachment>? = null
    var sourceReference: List<Reference>? = null
    var regulatoryBasis: List<CodeableConcept>? = null
    var policyBasis: Consent.PolicyBasis? = null
    var policyText: List<Reference>? = null
    var verification: List<Consent.Verification>? = null
    var decision: String? = null
    var _decision: Element? = null
    var provision: List<Consent.Provision>? = null
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
        14 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.categorySer, null)
        15 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.subjectSer, null)
        16 -> date = decoder.decodeStringElement(__desc, 16)
        17 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          period = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.periodSer, null)
        19 ->
          grantor = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.grantorSer, null)
        20 ->
          grantee = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.grantorSer, null)
        21 ->
          manager = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.grantorSer, null)
        22 ->
          controller =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.grantorSer, null)
        23 ->
          sourceAttachment =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.sourceAttachmentSer, null)
        24 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.grantorSer, null)
        25 ->
          regulatoryBasis =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.categorySer, null)
        26 ->
          policyBasis =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.policyBasisSer, null)
        27 ->
          policyText =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.grantorSer, null)
        28 ->
          verification =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.verificationSer, null)
        29 -> decision = decoder.decodeStringElement(__desc, 29)
        30 ->
          _decision =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          provision =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.provisionSer, null)
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
      category = category ?: listOf(),
      subject = subject,
      date = Date.of(FhirDate.fromString(date), _date),
      period = period,
      grantor = grantor ?: listOf(),
      grantee = grantee ?: listOf(),
      manager = manager ?: listOf(),
      controller = controller ?: listOf(),
      sourceAttachment = sourceAttachment ?: listOf(),
      sourceReference = sourceReference ?: listOf(),
      regulatoryBasis = regulatoryBasis ?: listOf(),
      policyBasis = policyBasis,
      policyText = policyText ?: listOf(),
      verification = verification ?: listOf(),
      decision =
        decision?.let { Enumeration.of(Consent.ConsentProvisionType.fromCode(it), _decision) },
      provision = provision ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: Consent) {
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.categorySer, value.category)
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.subjectSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.periodSer, it) }
    if (value.grantor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.grantorSer, value.grantor)
    if (value.grantee.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.grantorSer, value.grantee)
    if (value.manager.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.grantorSer, value.manager)
    if (value.controller.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.grantorSer, value.controller)
    if (value.sourceAttachment.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23,
        Hoisted.sourceAttachmentSer,
        value.sourceAttachment,
      )
    if (value.sourceReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.grantorSer, value.sourceReference)
    if (value.regulatoryBasis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.categorySer, value.regulatoryBasis)
    (value.policyBasis)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.policyBasisSer, it)
    }
    if (value.policyText.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.grantorSer, value.policyText)
    if (value.verification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.verificationSer, value.verification)
    ((value.decision?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.decision?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.provision.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.provisionSer, value.provision)
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val grantorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val sourceAttachmentSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val sourceAttachmentSer: KSerializer<List<Attachment>> =
      ListSerializer(Hoisted.sourceAttachmentSerInner)

    public val policyBasisSer: KSerializer<Consent.PolicyBasis> = Consent.PolicyBasis.serializer()

    public val verificationSerInner: KSerializer<Consent.Verification> =
      Consent.Verification.serializer()

    public val verificationSer: KSerializer<List<Consent.Verification>> =
      ListSerializer(Hoisted.verificationSerInner)

    public val provisionSerInner: KSerializer<Consent.Provision> = Consent.Provision.serializer()

    public val provisionSer: KSerializer<List<Consent.Provision>> =
      ListSerializer(Hoisted.provisionSerInner)
  }
}

internal object ConsentPolymorphicSerializer : KSerializer<Consent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Consent") { ConsentSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Consent) {
    encoder.encodeStructure(descriptor) { ConsentSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): Consent =
    decoder.decodeStructure(descriptor) { ConsentSerializer.deserializeJson(this) }
}

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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Endpoint
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.Url
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

internal object EndpointSerializer : KSerializer<Endpoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Endpoint") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("connectionType", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("managingOrganization", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element(
      "payloadType",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "payloadMimeType",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_payloadMimeType",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("address", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_address", Element.serializer().descriptor, isOptional = true)
    b.element(
      "header",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_header", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Endpoint =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Endpoint) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Endpoint")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Endpoint {
    val __desc = desc
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
    var identifier: List<Identifier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var connectionType: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var managingOrganization: Reference? = null
    var contact: List<ContactPoint>? = null
    var period: Period? = null
    var payloadType: List<CodeableConcept>? = null
    var payloadMimeType: List<KotlinString?>? = null
    var _payloadMimeType: List<Element?>? = null
    var address: KotlinString? = null
    var _address: Element? = null
    var `header`: List<KotlinString?>? = null
    var _header: List<Element?>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(__desc, __i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          connectionType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.connectionTypeSer, null)
        14 -> name = decoder.decodeStringElement(__desc, __i)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.managingOrganizationSer,
              null,
            )
        17 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        18 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        19 ->
          payloadType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.payloadTypeSer, null)
        20 ->
          payloadMimeType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.payloadMimeTypeSer, null)
        21 ->
          _payloadMimeType =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.payloadMimeTypeSer2,
              null,
            )
        22 -> address = decoder.decodeStringElement(__desc, __i)
        23 ->
          _address =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 ->
          `header` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.payloadMimeTypeSer, null)
        25 ->
          _header =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.payloadMimeTypeSer2,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Endpoint: " + __i)
      }
    }
    return Endpoint(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(Endpoint.EndpointStatus.fromCode(status!!), _status),
      connectionType = connectionType!!,
      name = R4bString.of(name, _name),
      managingOrganization = managingOrganization,
      contact = contact ?: listOf(),
      period = period,
      payloadType = payloadType ?: listOf(),
      payloadMimeType =
        (kotlin.collections.List(maxOf(payloadMimeType?.size ?: 0, _payloadMimeType?.size ?: 0)) {
          __i ->
          Code.of(payloadMimeType?.getOrNull(__i)?.let { it }, _payloadMimeType?.getOrNull(__i))!!
        }),
      address = Url.of(address, _address)!!,
      `header` =
        (kotlin.collections.List(maxOf(`header`?.size ?: 0, _header?.size ?: 0)) { __i ->
          R4bString.of(`header`?.getOrNull(__i)?.let { it }, _header?.getOrNull(__i))!!
        }),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Endpoint,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.connectionType)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.connectionTypeSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.managingOrganizationSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.contactSer, value.contact)
    (value.period)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.periodSer, it)
    }
    if (value.payloadType.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19 + __off,
        Hoisted.payloadTypeSer,
        value.payloadType,
      )
    (value.payloadMimeType.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.payloadMimeTypeSer, it)
    }
    (value.payloadMimeType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.payloadMimeTypeSer2, it)
    }
    ((value.address.value))?.let { encoder.encodeStringElement(__desc, 22 + __off, it) }
    (value.address.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.`header`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.payloadMimeTypeSer, it)
    }
    (value.`header`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.payloadMimeTypeSer2, it)
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

    public val connectionTypeSer: KSerializer<Coding> = Coding.serializer()

    public val managingOrganizationSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val contactSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.contactSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val payloadTypeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val payloadTypeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.payloadTypeSerInner)

    public val payloadMimeTypeSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val payloadMimeTypeSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.payloadMimeTypeSerInner).nullable)

    public val payloadMimeTypeSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)
  }
}

internal object EndpointPolymorphicSerializer : KSerializer<Endpoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Endpoint") { EndpointSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Endpoint) {
    encoder.encodeStructure(descriptor) {
      EndpointSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Endpoint =
    decoder.decodeStructure(descriptor) { EndpointSerializer.deserializeJson(this, descriptor, 0) }
}

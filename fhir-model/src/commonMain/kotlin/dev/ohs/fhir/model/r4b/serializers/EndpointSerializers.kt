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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object EndpointSerializer : KSerializer<Endpoint> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Endpoint") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("connectionType", Coding.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("managingOrganization", Reference.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactPoint.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
      element(
        "payloadType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "payloadMimeType",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_payloadMimeType",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("address", KotlinString.serializer().descriptor, isOptional = true)
      element("_address", Element.serializer().descriptor, isOptional = true)
      element(
        "header",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_header", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Endpoint =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Endpoint) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Endpoint {
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
          connectionType =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.connectionTypeSer, null)
        15 -> name = decoder.decodeStringElement(__desc, 15)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.managingOrganizationSer,
              null,
            )
        18 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.contactSer, null)
        19 ->
          period = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.periodSer, null)
        20 ->
          payloadType =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.payloadTypeSer, null)
        21 ->
          payloadMimeType =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.payloadMimeTypeSer, null)
        22 ->
          _payloadMimeType =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.payloadMimeTypeSer2, null)
        23 -> address = decoder.decodeStringElement(__desc, 23)
        24 ->
          _address =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          `header` =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.payloadMimeTypeSer, null)
        26 ->
          _header =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.payloadMimeTypeSer2, null)
        CompositeDecoder.DECODE_DONE -> break
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Endpoint) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Endpoint")
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
    (value.connectionType)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.connectionTypeSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.managingOrganizationSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.contactSer, value.contact)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.periodSer, it) }
    if (value.payloadType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.payloadTypeSer, value.payloadType)
    (value.payloadMimeType.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.payloadMimeTypeSer, it)
    }
    (value.payloadMimeType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.payloadMimeTypeSer2, it)
    }
    ((value.address.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.address.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    (value.`header`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.payloadMimeTypeSer, it)
    }
    (value.`header`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.payloadMimeTypeSer2, it)
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

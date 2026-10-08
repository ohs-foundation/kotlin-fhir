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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Endpoint
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.terminologies.EndpointStatus
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

internal object EndpointPayloadSerializer : KSerializer<Endpoint.Payload> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payload") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("mimeType", stringNullableListSerializer.descriptor)
      optionalElement("_mimeType", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Endpoint.Payload>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Endpoint.Payload {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var mimeType: List<KotlinString?>? = null
    var _mimeType: List<Element?>? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          mimeType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        5 ->
          _mimeType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payload: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Endpoint.Payload(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: listOf(),
      mimeType =
        (kotlin.collections.List(maxOf(mimeType?.size ?: 0, _mimeType?.size ?: 0)) { index ->
          Code.of(mimeType?.getOrNull(index), _mimeType?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'mimeType' on Endpoint.Payload has neither a value nor an id/extension"
            )
        }),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Endpoint.Payload) {
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
    if (value.type.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    if (value.mimeType.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        4,
        stringNullableListSerializer,
        value.mimeType.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 5, value.mimeType)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object EndpointSerializer : FhirResourceSerializer<Endpoint> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Endpoint")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("connectionType", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("environmentType", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("managingOrganization", ReferenceSerializer.descriptor)
    b.optionalElement("contact", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("payload", EndpointPayloadSerializer.listSerializer.descriptor)
    b.optionalElement("address", KotlinString.serializer().descriptor)
    b.optionalElement("_address", ElementSerializer.descriptor)
    b.optionalElement("header", stringNullableListSerializer.descriptor)
    b.optionalElement("_header", ElementSerializer.nullableListSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Endpoint {
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
    var connectionType: List<CodeableConcept>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var environmentType: List<CodeableConcept>? = null
    var managingOrganization: Reference? = null
    var contact: List<ContactPoint>? = null
    var period: Period? = null
    var payload: List<Endpoint.Payload>? = null
    var address: KotlinString? = null
    var _address: Element? = null
    var `header`: List<KotlinString?>? = null
    var _header: List<Element?>? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          connectionType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          environmentType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          managingOrganization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        21 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        22 ->
          payload =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EndpointPayloadSerializer.listSerializer,
              null,
            )
        23 -> address = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _address =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          `header` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        26 ->
          _header =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Endpoint: " + i)
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
      status =
        Enumeration.of(if (status != null) EndpointStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Endpoint"),
      connectionType = connectionType ?: listOf(),
      name = R5String.of(name, _name),
      description = R5String.of(description, _description),
      environmentType = environmentType ?: listOf(),
      managingOrganization = managingOrganization,
      contact = contact ?: listOf(),
      period = period,
      payload = payload ?: listOf(),
      address =
        Url.of(address, _address)
          ?: throw SerializationException("Missing required property 'address' on Endpoint"),
      `header` =
        (kotlin.collections.List(maxOf(`header`?.size ?: 0, _header?.size ?: 0)) { index ->
          R5String.of(`header`?.getOrNull(index), _header?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'header' on Endpoint has neither a value nor an id/extension"
            )
        }),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Endpoint,
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
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.connectionType.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.connectionType,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.description)
    if (value.environmentType.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.environmentType,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.managingOrganization,
    )
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    if (value.payload.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        EndpointPayloadSerializer.listSerializer,
        value.payload,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.address.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.address)
    if (value.`header`.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        25 + descriptorOffset,
        stringNullableListSerializer,
        value.`header`.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 26 + descriptorOffset, value.`header`)
    }
  }
}

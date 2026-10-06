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

import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.Availability
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VirtualServiceDetail
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

internal object LocationPositionSerializer : KSerializer<Location.Position> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Position") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("longitude", FhirDecimalSerializer.descriptor)
      optionalElement("_longitude", ElementSerializer.descriptor)
      optionalElement("latitude", FhirDecimalSerializer.descriptor)
      optionalElement("_latitude", ElementSerializer.descriptor)
      optionalElement("altitude", FhirDecimalSerializer.descriptor)
      optionalElement("_altitude", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Location.Position>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Location.Position =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var longitude: FhirDecimal? = null
      var _longitude: Element? = null
      var latitude: FhirDecimal? = null
      var _latitude: Element? = null
      var altitude: FhirDecimal? = null
      var _altitude: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            longitude =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          4 ->
            _longitude = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            latitude = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          6 -> _latitude = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            altitude = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          8 -> _altitude = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Position: " + i)
        }
      }
      Location.Position(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        longitude =
          Decimal.of(longitude, _longitude)
            ?: throw SerializationException(
              "Missing required property 'longitude' on Location.Position"
            ),
        latitude =
          Decimal.of(latitude, _latitude)
            ?: throw SerializationException(
              "Missing required property 'latitude' on Location.Position"
            ),
        altitude = Decimal.of(altitude, _altitude),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Location.Position) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, FhirDecimalSerializer, value.longitude.value)
      encodeElementIfNotNull(descriptor, 4, value.longitude)
      encodeSerializableIfNotNull(descriptor, 5, FhirDecimalSerializer, value.latitude.value)
      encodeElementIfNotNull(descriptor, 6, value.latitude)
      encodeSerializableIfNotNull(descriptor, 7, FhirDecimalSerializer, value.altitude?.value)
      encodeElementIfNotNull(descriptor, 8, value.altitude)
    }
  }
}

internal object LocationSerializer : FhirResourceSerializer<Location> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Location")

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
    b.optionalElement("operationalStatus", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("alias", stringNullableListSerializer.descriptor)
    b.optionalElement("_alias", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("mode", KotlinString.serializer().descriptor)
    b.optionalElement("_mode", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("contact", ExtendedContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("address", AddressSerializer.descriptor)
    b.optionalElement("form", CodeableConceptSerializer.descriptor)
    b.optionalElement("position", LocationPositionSerializer.descriptor)
    b.optionalElement("managingOrganization", ReferenceSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.descriptor)
    b.optionalElement("characteristic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("hoursOfOperation", AvailabilitySerializer.listSerializer.descriptor)
    b.optionalElement("virtualService", VirtualServiceDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Location {
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
    var operationalStatus: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var alias: List<KotlinString?>? = null
    var _alias: List<Element?>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var type: List<CodeableConcept>? = null
    var contact: List<ExtendedContactDetail>? = null
    var address: Address? = null
    var form: CodeableConcept? = null
    var position: Location.Position? = null
    var managingOrganization: Reference? = null
    var partOf: Reference? = null
    var characteristic: List<CodeableConcept>? = null
    var hoursOfOperation: List<Availability>? = null
    var virtualService: List<VirtualServiceDetail>? = null
    var endpoint: List<Reference>? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          operationalStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          alias =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _alias =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 -> description = decoder.decodeStringElement(descriptor, i)
        19 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> mode = decoder.decodeStringElement(descriptor, i)
        21 ->
          _mode = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        23 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer.listSerializer,
              null,
            )
        24 ->
          address =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        25 ->
          form =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          position =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocationPositionSerializer,
              null,
            )
        27 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        30 ->
          hoursOfOperation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilitySerializer.listSerializer,
              null,
            )
        31 ->
          virtualService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VirtualServiceDetailSerializer.listSerializer,
              null,
            )
        32 ->
          endpoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Location: " + i)
      }
    }
    return Location(
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
        Enumeration.of(
          if (status != null) Location.LocationStatus.fromCode(status) else null,
          _status,
        ),
      operationalStatus = operationalStatus,
      name = R5String.of(name, _name),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
          R5String.of(alias?.getOrNull(index), _alias?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'alias' on Location has neither a value nor an id/extension"
            )
        }),
      description = Markdown.of(description, _description),
      mode =
        Enumeration.of(if (mode != null) Location.LocationMode.fromCode(mode) else null, _mode),
      type = type ?: listOf(),
      contact = contact ?: listOf(),
      address = address,
      form = form,
      position = position,
      managingOrganization = managingOrganization,
      partOf = partOf,
      characteristic = characteristic ?: listOf(),
      hoursOfOperation = hoursOfOperation ?: listOf(),
      virtualService = virtualService ?: listOf(),
      endpoint = endpoint ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Location,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodingSerializer,
      value.operationalStatus,
    )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    if (value.alias.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.alias.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 17 + descriptorOffset, value.alias)
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.description)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.mode?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.mode)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ExtendedContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      AddressSerializer,
      value.address,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.form,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      LocationPositionSerializer,
      value.position,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.managingOrganization,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.partOf,
    )
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.characteristic,
      )
    if (value.hoursOfOperation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        AvailabilitySerializer.listSerializer,
        value.hoursOfOperation,
      )
    if (value.virtualService.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        VirtualServiceDetailSerializer.listSerializer,
        value.virtualService,
      )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.endpoint,
      )
  }
}

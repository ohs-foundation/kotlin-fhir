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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object LocationHoursOfOperationSerializer : KSerializer<Location.HoursOfOperation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("HoursOfOperation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("daysOfWeek", stringNullableListSerializer.descriptor)
      optionalElement("_daysOfWeek", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("allDay", KotlinBoolean.serializer().descriptor)
      optionalElement("_allDay", ElementSerializer.descriptor)
      optionalElement("openingTime", LocalTimeSerializer.descriptor)
      optionalElement("_openingTime", ElementSerializer.descriptor)
      optionalElement("closingTime", LocalTimeSerializer.descriptor)
      optionalElement("_closingTime", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Location.HoursOfOperation>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Location.HoursOfOperation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var daysOfWeek: List<KotlinString?>? = null
      var _daysOfWeek: List<Element?>? = null
      var allDay: KotlinBoolean? = null
      var _allDay: Element? = null
      var openingTime: LocalTime? = null
      var _openingTime: Element? = null
      var closingTime: LocalTime? = null
      var _closingTime: Element? = null
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
            daysOfWeek =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          4 ->
            _daysOfWeek =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          5 -> allDay = decodeBooleanElement(descriptor, i)
          6 -> _allDay = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            openingTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          8 ->
            _openingTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            closingTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          10 ->
            _closingTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding HoursOfOperation: " + i)
        }
      }
      Location.HoursOfOperation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        daysOfWeek =
          (kotlin.collections.List(maxOf(daysOfWeek?.size ?: 0, _daysOfWeek?.size ?: 0)) { index ->
            Enumeration.of(
              daysOfWeek?.getOrNull(index)?.let { Location.DaysOfWeek.fromCode(it) },
              _daysOfWeek?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'daysOfWeek' on Location.HoursOfOperation has neither a value nor an id/extension"
              )
          }),
        allDay = R4bBoolean.of(allDay, _allDay),
        openingTime = Time.of(openingTime, _openingTime),
        closingTime = Time.of(closingTime, _closingTime),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Location.HoursOfOperation) {
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
      if (value.daysOfWeek.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          3,
          stringNullableListSerializer,
          value.daysOfWeek.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 4, value.daysOfWeek)
      }
      encodeBooleanIfNotNull(descriptor, 5, value.allDay?.value)
      encodeElementIfNotNull(descriptor, 6, value.allDay)
      encodeSerializableIfNotNull(descriptor, 7, LocalTimeSerializer, value.openingTime?.value)
      encodeElementIfNotNull(descriptor, 8, value.openingTime)
      encodeSerializableIfNotNull(descriptor, 9, LocalTimeSerializer, value.closingTime?.value)
      encodeElementIfNotNull(descriptor, 10, value.closingTime)
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
    b.optionalElement("telecom", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("address", AddressSerializer.descriptor)
    b.optionalElement("physicalType", CodeableConceptSerializer.descriptor)
    b.optionalElement("position", LocationPositionSerializer.descriptor)
    b.optionalElement("managingOrganization", ReferenceSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.descriptor)
    b.optionalElement(
      "hoursOfOperation",
      LocationHoursOfOperationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("availabilityExceptions", KotlinString.serializer().descriptor)
    b.optionalElement("_availabilityExceptions", ElementSerializer.descriptor)
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
    var telecom: List<ContactPoint>? = null
    var address: Address? = null
    var physicalType: CodeableConcept? = null
    var position: Location.Position? = null
    var managingOrganization: Reference? = null
    var partOf: Reference? = null
    var hoursOfOperation: List<Location.HoursOfOperation>? = null
    var availabilityExceptions: KotlinString? = null
    var _availabilityExceptions: Element? = null
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
          telecom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        24 ->
          address =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        25 ->
          physicalType =
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
          hoursOfOperation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocationHoursOfOperationSerializer.listSerializer,
              null,
            )
        30 -> availabilityExceptions = decoder.decodeStringElement(descriptor, i)
        31 ->
          _availabilityExceptions =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
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
      name = R4bString.of(name, _name),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
          R4bString.of(alias?.getOrNull(index), _alias?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'alias' on Location has neither a value nor an id/extension"
            )
        }),
      description = R4bString.of(description, _description),
      mode =
        Enumeration.of(if (mode != null) Location.LocationMode.fromCode(mode) else null, _mode),
      type = type ?: listOf(),
      telecom = telecom ?: listOf(),
      address = address,
      physicalType = physicalType,
      position = position,
      managingOrganization = managingOrganization,
      partOf = partOf,
      hoursOfOperation = hoursOfOperation ?: listOf(),
      availabilityExceptions = R4bString.of(availabilityExceptions, _availabilityExceptions),
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
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.telecom,
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
      value.physicalType,
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
    if (value.hoursOfOperation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        LocationHoursOfOperationSerializer.listSerializer,
        value.hoursOfOperation,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.availabilityExceptions?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.availabilityExceptions)
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.endpoint,
      )
  }
}

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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Location
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object LocationPositionSerializer : KSerializer<Location.Position> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Position") {
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
      element("longitude", BigDecimalSerializer.descriptor, isOptional = true)
      element("_longitude", Element.serializer().descriptor, isOptional = true)
      element("latitude", BigDecimalSerializer.descriptor, isOptional = true)
      element("_latitude", Element.serializer().descriptor, isOptional = true)
      element("altitude", BigDecimalSerializer.descriptor, isOptional = true)
      element("_altitude", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Location.Position =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Location.Position) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Location.Position {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var longitude: BigDecimal? = null
    var _longitude: Element? = null
    var latitude: BigDecimal? = null
    var _latitude: Element? = null
    var altitude: BigDecimal? = null
    var _altitude: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          longitude =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        4 ->
          _longitude =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.longitudeSer, null)
        5 ->
          latitude =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        6 ->
          _latitude =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.longitudeSer, null)
        7 ->
          altitude =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        8 ->
          _altitude =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.longitudeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Position: " + __i)
      }
    }
    return Location.Position(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      longitude = Decimal.of(longitude, _longitude)!!,
      latitude = Decimal.of(latitude, _latitude)!!,
      altitude = Decimal.of(altitude, _altitude),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Location.Position) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.longitude.value))?.let {
      encoder.encodeSerializableElement(__desc, 3, BigDecimalSerializer, it)
    }
    (value.longitude.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.longitudeSer, it)
    }
    ((value.latitude.value))?.let {
      encoder.encodeSerializableElement(__desc, 5, BigDecimalSerializer, it)
    }
    (value.latitude.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.longitudeSer, it)
    }
    ((value.altitude?.value))?.let {
      encoder.encodeSerializableElement(__desc, 7, BigDecimalSerializer, it)
    }
    (value.altitude?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.longitudeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val longitudeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object LocationHoursOfOperationSerializer : KSerializer<Location.HoursOfOperation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("HoursOfOperation") {
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
      element(
        "daysOfWeek",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_daysOfWeek",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("allDay", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_allDay", Element.serializer().descriptor, isOptional = true)
      element("openingTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_openingTime", Element.serializer().descriptor, isOptional = true)
      element("closingTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_closingTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Location.HoursOfOperation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Location.HoursOfOperation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Location.HoursOfOperation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          daysOfWeek =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.daysOfWeekSer, null)
        4 ->
          _daysOfWeek =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.daysOfWeekSer2, null)
        5 -> allDay = decoder.decodeBooleanElement(__desc, __i)
        6 ->
          _allDay =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.daysOfWeekSerInner2,
              null,
            )
        7 ->
          openingTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        8 ->
          _openingTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.daysOfWeekSerInner2,
              null,
            )
        9 ->
          closingTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        10 ->
          _closingTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.daysOfWeekSerInner2,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding HoursOfOperation: " + __i)
      }
    }
    return Location.HoursOfOperation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      daysOfWeek =
        (kotlin.collections.List(maxOf(daysOfWeek?.size ?: 0, _daysOfWeek?.size ?: 0)) { __i ->
          Enumeration.of(
            Location.DaysOfWeek.fromCode(daysOfWeek?.getOrNull(__i)!!),
            _daysOfWeek?.getOrNull(__i),
          )
        }),
      allDay = R4bBoolean.of(allDay, _allDay),
      openingTime = Time.of(openingTime, _openingTime),
      closingTime = Time.of(closingTime, _closingTime),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Location.HoursOfOperation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.daysOfWeek.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.daysOfWeekSer, it)
    }
    (value.daysOfWeek.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.daysOfWeekSer2, it)
    }
    ((value.allDay?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.allDay?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.daysOfWeekSerInner2, it)
    }
    ((value.openingTime?.value))?.let {
      encoder.encodeSerializableElement(__desc, 7, LocalTimeSerializer, it)
    }
    (value.openingTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.daysOfWeekSerInner2, it)
    }
    ((value.closingTime?.value))?.let {
      encoder.encodeSerializableElement(__desc, 9, LocalTimeSerializer, it)
    }
    (value.closingTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.daysOfWeekSerInner2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val daysOfWeekSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val daysOfWeekSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.daysOfWeekSerInner).nullable)

    public val daysOfWeekSerInner2: KSerializer<Element> = Element.serializer()

    public val daysOfWeekSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.daysOfWeekSerInner2).nullable)
  }
}

internal object LocationSerializer : KSerializer<Location> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Location") {
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
    b.element("operationalStatus", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element(
      "alias",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_alias", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("mode", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_mode", Element.serializer().descriptor, isOptional = true)
    b.element(
      "type",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "telecom",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element("address", Address.serializer().descriptor, isOptional = true)
    b.element("physicalType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "position",
      lazyDescriptor { Location.Position.serializer().descriptor },
      isOptional = true,
    )
    b.element("managingOrganization", Reference.serializer().descriptor, isOptional = true)
    b.element("partOf", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "hoursOfOperation",
      listSerialDescriptor(lazyDescriptor { Location.HoursOfOperation.serializer().descriptor }),
      isOptional = true,
    )
    b.element("availabilityExceptions", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_availabilityExceptions", Element.serializer().descriptor, isOptional = true)
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Location =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Location) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Location")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Location {
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
          operationalStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.operationalStatusSer,
              null,
            )
        14 -> name = decoder.decodeStringElement(__desc, __i)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 -> alias = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.aliasSer, null)
        17 ->
          _alias = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.aliasSer2, null)
        18 -> description = decoder.decodeStringElement(__desc, __i)
        19 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> mode = decoder.decodeStringElement(__desc, __i)
        21 ->
          _mode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        23 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.telecomSer, null)
        24 ->
          address = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.addressSer, null)
        25 ->
          physicalType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSerInner, null)
        26 ->
          position =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.positionSer, null)
        27 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.managingOrganizationSer,
              null,
            )
        28 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.managingOrganizationSer,
              null,
            )
        29 ->
          hoursOfOperation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.hoursOfOperationSer,
              null,
            )
        30 -> availabilityExceptions = decoder.decodeStringElement(__desc, __i)
        31 ->
          _availabilityExceptions =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 ->
          endpoint =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.endpointSer, null)
        else -> throw SerializationException("Unexpected index decoding Location: " + __i)
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
      status = status?.let { Enumeration.of(Location.LocationStatus.fromCode(it), _status) },
      operationalStatus = operationalStatus,
      name = R4bString.of(name, _name),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { __i ->
          R4bString.of(alias?.getOrNull(__i)?.let { it }, _alias?.getOrNull(__i))!!
        }),
      description = R4bString.of(description, _description),
      mode = mode?.let { Enumeration.of(Location.LocationMode.fromCode(it), _mode) },
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Location,
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
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.operationalStatus)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.operationalStatusSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.alias.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.aliasSer, it)
    }
    (value.alias.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.aliasSer2, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.mode?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
    (value.mode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.typeSer, value.type)
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.telecomSer, value.telecom)
    (value.address)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.addressSer, it)
    }
    (value.physicalType)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.typeSerInner, it)
    }
    (value.position)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.positionSer, it)
    }
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.managingOrganizationSer, it)
    }
    (value.partOf)?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.managingOrganizationSer, it)
    }
    if (value.hoursOfOperation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
        Hoisted.hoursOfOperationSer,
        value.hoursOfOperation,
      )
    ((value.availabilityExceptions?.value))?.let {
      encoder.encodeStringElement(__desc, 30 + __off, it)
    }
    (value.availabilityExceptions?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.endpointSer, value.endpoint)
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

    public val operationalStatusSer: KSerializer<Coding> = Coding.serializer()

    public val aliasSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val aliasSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.aliasSerInner).nullable)

    public val aliasSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val telecomSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val telecomSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.telecomSerInner)

    public val addressSer: KSerializer<Address> = Address.serializer()

    public val positionSer: KSerializer<Location.Position> = Location.Position.serializer()

    public val managingOrganizationSer: KSerializer<Reference> = Reference.serializer()

    public val hoursOfOperationSerInner: KSerializer<Location.HoursOfOperation> =
      Location.HoursOfOperation.serializer()

    public val hoursOfOperationSer: KSerializer<List<Location.HoursOfOperation>> =
      ListSerializer(Hoisted.hoursOfOperationSerInner)

    public val endpointSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.managingOrganizationSer)
  }
}

internal object LocationPolymorphicSerializer : KSerializer<Location> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Location") { LocationSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Location) {
    encoder.encodeStructure(descriptor) {
      LocationSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Location =
    decoder.decodeStructure(descriptor) { LocationSerializer.deserializeJson(this, descriptor, 0) }
}

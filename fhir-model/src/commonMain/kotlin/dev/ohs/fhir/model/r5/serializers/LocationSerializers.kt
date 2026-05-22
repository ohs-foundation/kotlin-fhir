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

package dev.ohs.fhir.model.r5.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Location
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Location.Position) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Location.Position {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          longitude =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        4 ->
          _longitude =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.longitudeSer, null)
        5 ->
          latitude =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        6 ->
          _latitude =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.longitudeSer, null)
        7 ->
          altitude =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        8 ->
          _altitude =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.longitudeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Position: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Location.Position) {
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
    ((value.longitude.value))?.let {
      encoder.encodeSerializableElement(descriptor, 3, BigDecimalSerializer, it)
    }
    (value.longitude.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.longitudeSer, it)
    }
    ((value.latitude.value))?.let {
      encoder.encodeSerializableElement(descriptor, 5, BigDecimalSerializer, it)
    }
    (value.latitude.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.longitudeSer, it)
    }
    ((value.altitude?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 7, BigDecimalSerializer, it)
    }
    (value.altitude?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.longitudeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val longitudeSer: KSerializer<Element> = Element.serializer()
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
      "contact",
      listSerialDescriptor(ExtendedContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("address", Address.serializer().descriptor, isOptional = true)
    b.element("form", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "position",
      lazyDescriptor { Location.Position.serializer().descriptor },
      isOptional = true,
    )
    b.element("managingOrganization", Reference.serializer().descriptor, isOptional = true)
    b.element("partOf", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "characteristic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "hoursOfOperation",
      listSerialDescriptor(Availability.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "virtualService",
      listSerialDescriptor(VirtualServiceDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Location =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Location) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Location")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
          operationalStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.operationalStatusSer,
              null,
            )
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          alias = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.aliasSer, null)
        17 ->
          _alias = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.aliasSer2, null)
        18 -> description = decoder.decodeStringElement(descriptor, i)
        19 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> mode = decoder.decodeStringElement(descriptor, i)
        21 ->
          _mode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        23 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        24 ->
          address =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressSer, null)
        25 ->
          form =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSerInner, null)
        26 ->
          position =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.positionSer, null)
        27 ->
          managingOrganization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.managingOrganizationSer,
              null,
            )
        28 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.managingOrganizationSer,
              null,
            )
        29 ->
          characteristic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        30 ->
          hoursOfOperation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.hoursOfOperationSer,
              null,
            )
        31 ->
          virtualService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.virtualServiceSer,
              null,
            )
        32 ->
          endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.endpointSer, null)
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
      status = status?.let { Enumeration.of(Location.LocationStatus.fromCode(it), _status) },
      operationalStatus = operationalStatus,
      name = R5String.of(name, _name),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
          R5String.of(alias?.getOrNull(index)?.let { it }, _alias?.getOrNull(index))!!
        }),
      description = Markdown.of(description, _description),
      mode = mode?.let { Enumeration.of(Location.LocationMode.fromCode(it), _mode) },
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Location,
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
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.operationalStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.operationalStatusSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.alias.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.aliasSer, it)
    }
    (value.alias.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.aliasSer2, it)
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.mode?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.mode?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.typeSer,
        value.type,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    (value.address)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.addressSer, it)
    }
    (value.form)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.typeSerInner, it)
    }
    (value.position)?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, Hoisted.positionSer, it)
    }
    (value.managingOrganization)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.managingOrganizationSer,
        it,
      )
    }
    (value.partOf)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.managingOrganizationSer,
        it,
      )
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.typeSer,
        value.characteristic,
      )
    if (value.hoursOfOperation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.hoursOfOperationSer,
        value.hoursOfOperation,
      )
    if (value.virtualService.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.virtualServiceSer,
        value.virtualService,
      )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.endpointSer,
        value.endpoint,
      )
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

    public val contactSerInner: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val contactSer: KSerializer<List<ExtendedContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val addressSer: KSerializer<Address> = Address.serializer()

    public val positionSer: KSerializer<Location.Position> = Location.Position.serializer()

    public val managingOrganizationSer: KSerializer<Reference> = Reference.serializer()

    public val hoursOfOperationSerInner: KSerializer<Availability> = Availability.serializer()

    public val hoursOfOperationSer: KSerializer<List<Availability>> =
      ListSerializer(Hoisted.hoursOfOperationSerInner)

    public val virtualServiceSerInner: KSerializer<VirtualServiceDetail> =
      VirtualServiceDetail.serializer()

    public val virtualServiceSer: KSerializer<List<VirtualServiceDetail>> =
      ListSerializer(Hoisted.virtualServiceSerInner)

    public val endpointSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.managingOrganizationSer)
  }
}

internal object LocationPolymorphicSerializer : KSerializer<Location> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Location") { LocationSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Location) {
    encoder.encodeStructure(descriptor) {
      LocationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Location =
    decoder.decodeStructure(descriptor) {
      LocationSerializer.deserializeInternal(this, descriptor, 0)
    }
}

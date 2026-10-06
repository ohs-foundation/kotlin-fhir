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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.VisionPrescription
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

internal object VisionPrescriptionLensSpecificationSerializer :
  KSerializer<VisionPrescription.LensSpecification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("LensSpecification") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("product", CodeableConceptSerializer.descriptor)
      optionalElement("eye", KotlinString.serializer().descriptor)
      optionalElement("_eye", ElementSerializer.descriptor)
      optionalElement("sphere", FhirDecimalSerializer.descriptor)
      optionalElement("_sphere", ElementSerializer.descriptor)
      optionalElement("cylinder", FhirDecimalSerializer.descriptor)
      optionalElement("_cylinder", ElementSerializer.descriptor)
      optionalElement("axis", Int.serializer().descriptor)
      optionalElement("_axis", ElementSerializer.descriptor)
      optionalElement(
        "prism",
        VisionPrescriptionLensSpecificationPrismSerializer.listSerializer.descriptor,
      )
      optionalElement("add", FhirDecimalSerializer.descriptor)
      optionalElement("_add", ElementSerializer.descriptor)
      optionalElement("power", FhirDecimalSerializer.descriptor)
      optionalElement("_power", ElementSerializer.descriptor)
      optionalElement("backCurve", FhirDecimalSerializer.descriptor)
      optionalElement("_backCurve", ElementSerializer.descriptor)
      optionalElement("diameter", FhirDecimalSerializer.descriptor)
      optionalElement("_diameter", ElementSerializer.descriptor)
      optionalElement("duration", QuantitySerializer.descriptor)
      optionalElement("color", KotlinString.serializer().descriptor)
      optionalElement("_color", ElementSerializer.descriptor)
      optionalElement("brand", KotlinString.serializer().descriptor)
      optionalElement("_brand", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<VisionPrescription.LensSpecification>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var product: CodeableConcept? = null
      var eye: KotlinString? = null
      var _eye: Element? = null
      var sphere: FhirDecimal? = null
      var _sphere: Element? = null
      var cylinder: FhirDecimal? = null
      var _cylinder: Element? = null
      var axis: Int? = null
      var _axis: Element? = null
      var prism: List<VisionPrescription.LensSpecification.Prism>? = null
      var add: FhirDecimal? = null
      var _add: Element? = null
      var power: FhirDecimal? = null
      var _power: Element? = null
      var backCurve: FhirDecimal? = null
      var _backCurve: Element? = null
      var diameter: FhirDecimal? = null
      var _diameter: Element? = null
      var duration: Quantity? = null
      var color: KotlinString? = null
      var _color: Element? = null
      var brand: KotlinString? = null
      var _brand: Element? = null
      var note: List<Annotation>? = null
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
            product =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> eye = decodeStringElement(descriptor, i)
          5 -> _eye = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            sphere = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          7 -> _sphere = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            cylinder = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          9 -> _cylinder = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> axis = decodeIntElement(descriptor, i)
          11 -> _axis = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            prism =
              decodeNullableSerializableElement(
                descriptor,
                i,
                VisionPrescriptionLensSpecificationPrismSerializer.listSerializer,
                null,
              )
          13 -> add = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          14 -> _add = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            power = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          16 -> _power = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 ->
            backCurve =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          18 ->
            _backCurve = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 ->
            diameter = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          20 ->
            _diameter = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          21 ->
            duration = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          22 -> color = decodeStringElement(descriptor, i)
          23 -> _color = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 -> brand = decodeStringElement(descriptor, i)
          25 -> _brand = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          26 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding LensSpecification: " + i)
        }
      }
      VisionPrescription.LensSpecification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        product =
          product
            ?: throw SerializationException(
              "Missing required property 'product' on VisionPrescription.LensSpecification"
            ),
        eye =
          Enumeration.of(
            if (eye != null) VisionPrescription.VisionEyes.fromCode(eye) else null,
            _eye,
          )
            ?: throw SerializationException(
              "Missing required property 'eye' on VisionPrescription.LensSpecification"
            ),
        sphere = Decimal.of(sphere, _sphere),
        cylinder = Decimal.of(cylinder, _cylinder),
        axis = Integer.of(axis, _axis),
        prism = prism ?: listOf(),
        add = Decimal.of(add, _add),
        power = Decimal.of(power, _power),
        backCurve = Decimal.of(backCurve, _backCurve),
        diameter = Decimal.of(diameter, _diameter),
        duration = duration,
        color = R4bString.of(color, _color),
        brand = R4bString.of(brand, _brand),
        note = note ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.product)
      encodeStringIfNotNull(descriptor, 4, value.eye.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.eye)
      encodeSerializableIfNotNull(descriptor, 6, FhirDecimalSerializer, value.sphere?.value)
      encodeElementIfNotNull(descriptor, 7, value.sphere)
      encodeSerializableIfNotNull(descriptor, 8, FhirDecimalSerializer, value.cylinder?.value)
      encodeElementIfNotNull(descriptor, 9, value.cylinder)
      encodeIntIfNotNull(descriptor, 10, value.axis?.value)
      encodeElementIfNotNull(descriptor, 11, value.axis)
      if (value.prism.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          VisionPrescriptionLensSpecificationPrismSerializer.listSerializer,
          value.prism,
        )
      encodeSerializableIfNotNull(descriptor, 13, FhirDecimalSerializer, value.add?.value)
      encodeElementIfNotNull(descriptor, 14, value.add)
      encodeSerializableIfNotNull(descriptor, 15, FhirDecimalSerializer, value.power?.value)
      encodeElementIfNotNull(descriptor, 16, value.power)
      encodeSerializableIfNotNull(descriptor, 17, FhirDecimalSerializer, value.backCurve?.value)
      encodeElementIfNotNull(descriptor, 18, value.backCurve)
      encodeSerializableIfNotNull(descriptor, 19, FhirDecimalSerializer, value.diameter?.value)
      encodeElementIfNotNull(descriptor, 20, value.diameter)
      encodeSerializableIfNotNull(descriptor, 21, QuantitySerializer, value.duration)
      encodeStringIfNotNull(descriptor, 22, value.color?.value)
      encodeElementIfNotNull(descriptor, 23, value.color)
      encodeStringIfNotNull(descriptor, 24, value.brand?.value)
      encodeElementIfNotNull(descriptor, 25, value.brand)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 26, AnnotationSerializer.listSerializer, value.note)
    }
  }
}

internal object VisionPrescriptionLensSpecificationPrismSerializer :
  KSerializer<VisionPrescription.LensSpecification.Prism> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Prism") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("amount", FhirDecimalSerializer.descriptor)
      optionalElement("_amount", ElementSerializer.descriptor)
      optionalElement("base", KotlinString.serializer().descriptor)
      optionalElement("_base", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<VisionPrescription.LensSpecification.Prism>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification.Prism =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var amount: FhirDecimal? = null
      var _amount: Element? = null
      var base: KotlinString? = null
      var _base: Element? = null
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
            amount = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          4 -> _amount = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> base = decodeStringElement(descriptor, i)
          6 -> _base = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Prism: " + i)
        }
      }
      VisionPrescription.LensSpecification.Prism(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        amount =
          Decimal.of(amount, _amount)
            ?: throw SerializationException(
              "Missing required property 'amount' on VisionPrescription.LensSpecification.Prism"
            ),
        base =
          Enumeration.of(
            if (base != null) VisionPrescription.VisionBase.fromCode(base) else null,
            _base,
          )
            ?: throw SerializationException(
              "Missing required property 'base' on VisionPrescription.LensSpecification.Prism"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification.Prism) {
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
      encodeSerializableIfNotNull(descriptor, 3, FhirDecimalSerializer, value.amount.value)
      encodeElementIfNotNull(descriptor, 4, value.amount)
      encodeStringIfNotNull(descriptor, 5, value.base.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.base)
    }
  }
}

internal object VisionPrescriptionSerializer : FhirResourceSerializer<VisionPrescription> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("VisionPrescription")

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
    b.optionalElement("created", KotlinString.serializer().descriptor)
    b.optionalElement("_created", ElementSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("dateWritten", KotlinString.serializer().descriptor)
    b.optionalElement("_dateWritten", ElementSerializer.descriptor)
    b.optionalElement("prescriber", ReferenceSerializer.descriptor)
    b.optionalElement(
      "lensSpecification",
      VisionPrescriptionLensSpecificationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): VisionPrescription {
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
    var created: KotlinString? = null
    var _created: Element? = null
    var patient: Reference? = null
    var encounter: Reference? = null
    var dateWritten: KotlinString? = null
    var _dateWritten: Element? = null
    var prescriber: Reference? = null
    var lensSpecification: List<VisionPrescription.LensSpecification>? = null
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
        13 -> created = decoder.decodeStringElement(descriptor, i)
        14 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 -> dateWritten = decoder.decodeStringElement(descriptor, i)
        18 ->
          _dateWritten =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          prescriber =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          lensSpecification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VisionPrescriptionLensSpecificationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding VisionPrescription: " + i)
      }
    }
    return VisionPrescription(
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
          if (status != null) VisionPrescription.FinancialResourceStatusCodes.fromCode(status)
          else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on VisionPrescription"
          ),
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created)
          ?: throw SerializationException(
            "Missing required property 'created' on VisionPrescription"
          ),
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on VisionPrescription"
          ),
      encounter = encounter,
      dateWritten =
        DateTime.of(
          if (dateWritten != null) FhirDateTime.fromString(dateWritten) else null,
          _dateWritten,
        )
          ?: throw SerializationException(
            "Missing required property 'dateWritten' on VisionPrescription"
          ),
      prescriber =
        prescriber
          ?: throw SerializationException(
            "Missing required property 'prescriber' on VisionPrescription"
          ),
      lensSpecification = lensSpecification ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: VisionPrescription,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.created.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.created)
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.dateWritten.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.dateWritten)
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.prescriber,
    )
    if (value.lensSpecification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        VisionPrescriptionLensSpecificationSerializer.listSerializer,
        value.lensSpecification,
      )
  }
}

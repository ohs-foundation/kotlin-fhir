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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VisionPrescription
import dev.ohs.fhir.model.r5.terminologies.FinancialResourceStatusCodes
import dev.ohs.fhir.model.r5.terminologies.VisionBase
import dev.ohs.fhir.model.r5.terminologies.VisionEyes
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

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          product =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> eye = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _eye =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          sphere =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        7 ->
          _sphere =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          cylinder =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        9 ->
          _cylinder =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> axis = compositeDecoder.decodeIntElement(descriptor, i)
        11 ->
          _axis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          prism =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VisionPrescriptionLensSpecificationPrismSerializer.listSerializer,
              null,
            )
        13 ->
          add =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        14 ->
          _add =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          power =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        16 ->
          _power =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          backCurve =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        18 ->
          _backCurve =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          diameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        20 ->
          _diameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          duration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        22 -> color = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _color =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> brand = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _brand =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding LensSpecification: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VisionPrescription.LensSpecification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      product =
        product
          ?: throw SerializationException(
            "Missing required property 'product' on VisionPrescription.LensSpecification"
          ),
      eye =
        Enumeration.of(if (eye != null) VisionEyes.fromCode(eye) else null, _eye)
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
      color = R5String.of(color, _color),
      brand = R5String.of(brand, _brand),
      note = note ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.product,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.eye.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.eye)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      FhirDecimalSerializer,
      value.sphere?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.sphere)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      FhirDecimalSerializer,
      value.cylinder?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.cylinder)
    compositeEncoder.encodeIntIfNotNull(descriptor, 10, value.axis?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.axis)
    if (value.prism.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        VisionPrescriptionLensSpecificationPrismSerializer.listSerializer,
        value.prism,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      FhirDecimalSerializer,
      value.add?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.add)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15,
      FhirDecimalSerializer,
      value.power?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.power)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17,
      FhirDecimalSerializer,
      value.backCurve?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.backCurve)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19,
      FhirDecimalSerializer,
      value.diameter?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20, value.diameter)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 21, QuantitySerializer, value.duration)
    compositeEncoder.encodeStringIfNotNull(descriptor, 22, value.color?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 23, value.color)
    compositeEncoder.encodeStringIfNotNull(descriptor, 24, value.brand?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 25, value.brand)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification.Prism {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var amount: FhirDecimal? = null
    var _amount: Element? = null
    var base: KotlinString? = null
    var _base: Element? = null
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
          amount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        4 ->
          _amount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> base = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _base =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Prism: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VisionPrescription.LensSpecification.Prism(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      amount =
        Decimal.of(amount, _amount)
          ?: throw SerializationException(
            "Missing required property 'amount' on VisionPrescription.LensSpecification.Prism"
          ),
      base =
        Enumeration.of(if (base != null) VisionBase.fromCode(base) else null, _base)
          ?: throw SerializationException(
            "Missing required property 'base' on VisionPrescription.LensSpecification.Prism"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification.Prism) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      FhirDecimalSerializer,
      value.amount.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.amount)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.base.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.base)
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
        13 -> created = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _created =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 -> dateWritten = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _dateWritten =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          prescriber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 ->
          lensSpecification =
            compositeDecoder.decodeNullableSerializableElement(
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
          if (status != null) FinancialResourceStatusCodes.fromCode(status) else null,
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: VisionPrescription,
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
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.created.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.created)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.dateWritten.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.dateWritten)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.prescriber,
    )
    if (value.lensSpecification.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        VisionPrescriptionLensSpecificationSerializer.listSerializer,
        value.lensSpecification,
      )
  }
}

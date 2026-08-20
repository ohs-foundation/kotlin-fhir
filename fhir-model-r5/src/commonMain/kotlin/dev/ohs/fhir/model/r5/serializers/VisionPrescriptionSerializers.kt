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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VisionPrescription
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
      element("product", CodeableConcept.serializer().descriptor, isOptional = true)
      element("eye", KotlinString.serializer().descriptor, isOptional = true)
      element("_eye", Element.serializer().descriptor, isOptional = true)
      element("sphere", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_sphere", Element.serializer().descriptor, isOptional = true)
      element("cylinder", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_cylinder", Element.serializer().descriptor, isOptional = true)
      element("axis", Int.serializer().descriptor, isOptional = true)
      element("_axis", Element.serializer().descriptor, isOptional = true)
      element(
        "prism",
        listSerialDescriptor(
          lazyDescriptor { VisionPrescription.LensSpecification.Prism.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("add", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_add", Element.serializer().descriptor, isOptional = true)
      element("power", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_power", Element.serializer().descriptor, isOptional = true)
      element("backCurve", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_backCurve", Element.serializer().descriptor, isOptional = true)
      element("diameter", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_diameter", Element.serializer().descriptor, isOptional = true)
      element("duration", Quantity.serializer().descriptor, isOptional = true)
      element("color", KotlinString.serializer().descriptor, isOptional = true)
      element("_color", Element.serializer().descriptor, isOptional = true)
      element("brand", KotlinString.serializer().descriptor, isOptional = true)
      element("_brand", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): VisionPrescription.LensSpecification {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          product =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.productSer, null)
        4 -> eye = decoder.decodeStringElement(descriptor, i)
        5 -> _eye = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        6 ->
          sphere =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        7 ->
          _sphere = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        8 ->
          cylinder =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        9 ->
          _cylinder = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        10 -> axis = decoder.decodeIntElement(descriptor, i)
        11 -> _axis = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        12 ->
          prism = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prismSer, null)
        13 ->
          add =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        14 -> _add = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        15 ->
          power =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        16 ->
          _power = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        17 ->
          backCurve =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        18 ->
          _backCurve =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        19 ->
          diameter =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        20 ->
          _diameter = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        21 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.durationSer, null)
        22 -> color = decoder.decodeStringElement(descriptor, i)
        23 ->
          _color = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        24 -> brand = decoder.decodeStringElement(descriptor, i)
        25 ->
          _brand = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eyeSer, null)
        26 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding LensSpecification: " + i)
      }
    }
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
        Enumeration.of(eye?.let { VisionPrescription.VisionEyes.fromCode(it) }, _eye)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: VisionPrescription.LensSpecification,
  ) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.productSer, value.product)
    ((value.eye.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.eye.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.eyeSer, it)
    }
    ((value.sphere?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 6, FhirDecimalSerializer, it)
    }
    (value.sphere?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.eyeSer, it)
    }
    ((value.cylinder?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 8, FhirDecimalSerializer, it)
    }
    (value.cylinder?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.eyeSer, it)
    }
    ((value.axis?.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
    (value.axis?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.eyeSer, it)
    }
    if (value.prism.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.prismSer, value.prism)
    ((value.add?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 13, FhirDecimalSerializer, it)
    }
    (value.add?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.eyeSer, it)
    }
    ((value.power?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 15, FhirDecimalSerializer, it)
    }
    (value.power?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.eyeSer, it)
    }
    ((value.backCurve?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 17, FhirDecimalSerializer, it)
    }
    (value.backCurve?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.eyeSer, it)
    }
    ((value.diameter?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 19, FhirDecimalSerializer, it)
    }
    (value.diameter?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.eyeSer, it)
    }
    (value.duration)?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.durationSer, it)
    }
    ((value.color?.value))?.let { encoder.encodeStringElement(descriptor, 22, it) }
    (value.color?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.eyeSer, it)
    }
    ((value.brand?.value))?.let { encoder.encodeStringElement(descriptor, 24, it) }
    (value.brand?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.eyeSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val eyeSer: KSerializer<Element> = Element.serializer()

    public val prismSerInner: KSerializer<VisionPrescription.LensSpecification.Prism> =
      VisionPrescription.LensSpecification.Prism.serializer()

    public val prismSer: KSerializer<List<VisionPrescription.LensSpecification.Prism>> =
      ListSerializer(Hoisted.prismSerInner)

    public val durationSer: KSerializer<Quantity> = Quantity.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object VisionPrescriptionLensSpecificationPrismSerializer :
  KSerializer<VisionPrescription.LensSpecification.Prism> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Prism") {
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
      element("amount", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_amount", Element.serializer().descriptor, isOptional = true)
      element("base", KotlinString.serializer().descriptor, isOptional = true)
      element("_base", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification.Prism =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification.Prism) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): VisionPrescription.LensSpecification.Prism {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var amount: FhirDecimal? = null
    var _amount: Element? = null
    var base: KotlinString? = null
    var _base: Element? = null
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
          amount =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        4 ->
          _amount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        5 -> base = decoder.decodeStringElement(descriptor, i)
        6 ->
          _base = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Prism: " + i)
      }
    }
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
        Enumeration.of(base?.let { VisionPrescription.VisionBase.fromCode(it) }, _base)
          ?: throw SerializationException(
            "Missing required property 'base' on VisionPrescription.LensSpecification.Prism"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: VisionPrescription.LensSpecification.Prism,
  ) {
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
    ((value.amount.value))?.let {
      encoder.encodeSerializableElement(descriptor, 3, FhirDecimalSerializer, it)
    }
    (value.amount.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.amountSer, it)
    }
    ((value.base.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.base.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.amountSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val amountSer: KSerializer<Element> = Element.serializer()
  }
}

internal object VisionPrescriptionSerializer : KSerializer<VisionPrescription> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("VisionPrescription") {
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
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("dateWritten", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_dateWritten", Element.serializer().descriptor, isOptional = true)
    b.element("prescriber", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "lensSpecification",
      listSerialDescriptor(
        lazyDescriptor { VisionPrescription.LensSpecification.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): VisionPrescription =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "VisionPrescription")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        13 -> created = decoder.decodeStringElement(descriptor, i)
        14 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        17 -> dateWritten = decoder.decodeStringElement(descriptor, i)
        18 ->
          _dateWritten =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          prescriber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        20 ->
          lensSpecification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.lensSpecificationSer,
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
          status?.let { VisionPrescription.FinancialResourceStatusCodes.fromCode(it) },
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on VisionPrescription"
          ),
      created =
        DateTime.of(FhirDateTime.fromString(created), _created)
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
        DateTime.of(FhirDateTime.fromString(dateWritten), _dateWritten)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: VisionPrescription,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      Hoisted.patientSer,
      value.patient,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.patientSer, it)
    }
    ((value.dateWritten.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.dateWritten.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      Hoisted.patientSer,
      value.prescriber,
    )
    if (value.lensSpecification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.lensSpecificationSer,
        value.lensSpecification,
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

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val lensSpecificationSerInner: KSerializer<VisionPrescription.LensSpecification> =
      VisionPrescription.LensSpecification.serializer()

    public val lensSpecificationSer: KSerializer<List<VisionPrescription.LensSpecification>> =
      ListSerializer(Hoisted.lensSpecificationSerInner)
  }
}

internal object VisionPrescriptionPolymorphicSerializer : KSerializer<VisionPrescription> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("VisionPrescription") {
      VisionPrescriptionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription) {
    encoder.encodeStructure(descriptor) {
      VisionPrescriptionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): VisionPrescription =
    decoder.decodeStructure(descriptor) {
      VisionPrescriptionSerializer.deserializeInternal(this, descriptor, 0)
    }
}

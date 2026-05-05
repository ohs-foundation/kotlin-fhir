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

package dev.ohs.fhir.model.r4.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.VisionPrescription
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
      element("sphere", BigDecimalSerializer.descriptor, isOptional = true)
      element("_sphere", Element.serializer().descriptor, isOptional = true)
      element("cylinder", BigDecimalSerializer.descriptor, isOptional = true)
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
      element("add", BigDecimalSerializer.descriptor, isOptional = true)
      element("_add", Element.serializer().descriptor, isOptional = true)
      element("power", BigDecimalSerializer.descriptor, isOptional = true)
      element("_power", Element.serializer().descriptor, isOptional = true)
      element("backCurve", BigDecimalSerializer.descriptor, isOptional = true)
      element("_backCurve", Element.serializer().descriptor, isOptional = true)
      element("diameter", BigDecimalSerializer.descriptor, isOptional = true)
      element("_diameter", Element.serializer().descriptor, isOptional = true)
      element("duration", Quantity.serializer().descriptor, isOptional = true)
      element("color", KotlinString.serializer().descriptor, isOptional = true)
      element("_color", Element.serializer().descriptor, isOptional = true)
      element("brand", KotlinString.serializer().descriptor, isOptional = true)
      element("_brand", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): VisionPrescription.LensSpecification {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var product: CodeableConcept? = null
    var eye: KotlinString? = null
    var _eye: Element? = null
    var sphere: BigDecimal? = null
    var _sphere: Element? = null
    var cylinder: BigDecimal? = null
    var _cylinder: Element? = null
    var axis: Int? = null
    var _axis: Element? = null
    var prism: List<VisionPrescription.LensSpecification.Prism>? = null
    var add: BigDecimal? = null
    var _add: Element? = null
    var power: BigDecimal? = null
    var _power: Element? = null
    var backCurve: BigDecimal? = null
    var _backCurve: Element? = null
    var diameter: BigDecimal? = null
    var _diameter: Element? = null
    var duration: Quantity? = null
    var color: KotlinString? = null
    var _color: Element? = null
    var brand: KotlinString? = null
    var _brand: Element? = null
    var note: List<Annotation>? = null
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
          product = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.productSer, null)
        4 -> eye = decoder.decodeStringElement(__desc, __i)
        5 -> _eye = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        6 ->
          sphere =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        7 -> _sphere = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        8 ->
          cylinder =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        9 ->
          _cylinder = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        10 -> axis = decoder.decodeIntElement(__desc, __i)
        11 -> _axis = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        12 -> prism = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.prismSer, null)
        13 ->
          add = decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        14 -> _add = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        15 ->
          power = decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        16 -> _power = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        17 ->
          backCurve =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        18 ->
          _backCurve = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        19 ->
          diameter =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        20 ->
          _diameter = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        21 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.durationSer, null)
        22 -> color = decoder.decodeStringElement(__desc, __i)
        23 -> _color = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        24 -> brand = decoder.decodeStringElement(__desc, __i)
        25 -> _brand = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eyeSer, null)
        26 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding LensSpecification: " + __i)
      }
    }
    return VisionPrescription.LensSpecification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      product = product!!,
      eye = Enumeration.of(VisionPrescription.VisionEyes.fromCode(eye!!), _eye),
      sphere = Decimal.of(sphere, _sphere),
      cylinder = Decimal.of(cylinder, _cylinder),
      axis = Integer.of(axis, _axis),
      prism = prism ?: listOf(),
      add = Decimal.of(add, _add),
      power = Decimal.of(power, _power),
      backCurve = Decimal.of(backCurve, _backCurve),
      diameter = Decimal.of(diameter, _diameter),
      duration = duration,
      color = R4String.of(color, _color),
      brand = R4String.of(brand, _brand),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: VisionPrescription.LensSpecification,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.product)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.productSer, it) }
    ((value.eye.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.eye.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.eyeSer, it)
    }
    ((value.sphere?.value))?.let {
      encoder.encodeSerializableElement(__desc, 6, BigDecimalSerializer, it)
    }
    (value.sphere?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.eyeSer, it)
    }
    ((value.cylinder?.value))?.let {
      encoder.encodeSerializableElement(__desc, 8, BigDecimalSerializer, it)
    }
    (value.cylinder?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.eyeSer, it)
    }
    ((value.axis?.value))?.let { encoder.encodeIntElement(__desc, 10, it) }
    (value.axis?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.eyeSer, it)
    }
    if (value.prism.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.prismSer, value.prism)
    ((value.add?.value))?.let {
      encoder.encodeSerializableElement(__desc, 13, BigDecimalSerializer, it)
    }
    (value.add?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.eyeSer, it)
    }
    ((value.power?.value))?.let {
      encoder.encodeSerializableElement(__desc, 15, BigDecimalSerializer, it)
    }
    (value.power?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.eyeSer, it)
    }
    ((value.backCurve?.value))?.let {
      encoder.encodeSerializableElement(__desc, 17, BigDecimalSerializer, it)
    }
    (value.backCurve?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.eyeSer, it)
    }
    ((value.diameter?.value))?.let {
      encoder.encodeSerializableElement(__desc, 19, BigDecimalSerializer, it)
    }
    (value.diameter?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.eyeSer, it)
    }
    (value.duration)?.let { encoder.encodeSerializableElement(__desc, 21, Hoisted.durationSer, it) }
    ((value.color?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.color?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.eyeSer, it)
    }
    ((value.brand?.value))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.brand?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.eyeSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.noteSer, value.note)
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
      element("amount", BigDecimalSerializer.descriptor, isOptional = true)
      element("_amount", Element.serializer().descriptor, isOptional = true)
      element("base", KotlinString.serializer().descriptor, isOptional = true)
      element("_base", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification.Prism =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification.Prism) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): VisionPrescription.LensSpecification.Prism {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var amount: BigDecimal? = null
    var _amount: Element? = null
    var base: KotlinString? = null
    var _base: Element? = null
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
          amount =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        4 ->
          _amount = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.amountSer, null)
        5 -> base = decoder.decodeStringElement(__desc, __i)
        6 -> _base = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Prism: " + __i)
      }
    }
    return VisionPrescription.LensSpecification.Prism(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      amount = Decimal.of(amount, _amount)!!,
      base = Enumeration.of(VisionPrescription.VisionBase.fromCode(base!!), _base),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: VisionPrescription.LensSpecification.Prism,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.amount.value))?.let {
      encoder.encodeSerializableElement(__desc, 3, BigDecimalSerializer, it)
    }
    (value.amount.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.amountSer, it)
    }
    ((value.base.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.base.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.amountSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: VisionPrescription) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "VisionPrescription")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): VisionPrescription {
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
    var created: KotlinString? = null
    var _created: Element? = null
    var patient: Reference? = null
    var encounter: Reference? = null
    var dateWritten: KotlinString? = null
    var _dateWritten: Element? = null
    var prescriber: Reference? = null
    var lensSpecification: List<VisionPrescription.LensSpecification>? = null
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
        13 -> created = decoder.decodeStringElement(__desc, __i)
        14 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          patient = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        17 -> dateWritten = decoder.decodeStringElement(__desc, __i)
        18 ->
          _dateWritten =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 ->
          prescriber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        20 ->
          lensSpecification =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.lensSpecificationSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding VisionPrescription: " + __i)
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
        Enumeration.of(VisionPrescription.FinancialResourceStatusCodes.fromCode(status!!), _status),
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      patient = patient!!,
      encounter = encounter,
      dateWritten = DateTime.of(FhirDateTime.fromString(dateWritten), _dateWritten)!!,
      prescriber = prescriber!!,
      lensSpecification = lensSpecification ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: VisionPrescription,
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
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.patientSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.patientSer, it)
    }
    ((value.dateWritten.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 17 + __off, it)
    }
    (value.dateWritten.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.prescriber)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.patientSer, it)
    }
    if (value.lensSpecification.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20 + __off,
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
      VisionPrescriptionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): VisionPrescription =
    decoder.decodeStructure(descriptor) {
      VisionPrescriptionSerializer.deserializeJson(this, descriptor, 0)
    }
}

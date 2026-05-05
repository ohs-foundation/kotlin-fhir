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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.BiologicallyDerivedProductDispense
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object BiologicallyDerivedProductDispensePerformerSerializer :
  KSerializer<BiologicallyDerivedProductDispense.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProductDispense.Performer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProductDispense.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): BiologicallyDerivedProductDispense.Performer {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + __i)
      }
    }
    return BiologicallyDerivedProductDispense.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProductDispense.Performer,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.functionSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object BiologicallyDerivedProductDispenseSerializer :
  KSerializer<BiologicallyDerivedProductDispense> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProductDispense") {
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("originRelationshipType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("product", Reference.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("matchStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "performer",
      listSerialDescriptor(
        lazyDescriptor { BiologicallyDerivedProductDispense.Performer.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("quantity", Quantity.serializer().descriptor, isOptional = true)
    b.element("preparedDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_preparedDate", Element.serializer().descriptor, isOptional = true)
    b.element("whenHandedOver", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_whenHandedOver", Element.serializer().descriptor, isOptional = true)
    b.element("destination", Reference.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("usageInstruction", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_usageInstruction", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProductDispense =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProductDispense) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "BiologicallyDerivedProductDispense")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): BiologicallyDerivedProductDispense {
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
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var originRelationshipType: CodeableConcept? = null
    var product: Reference? = null
    var patient: Reference? = null
    var matchStatus: CodeableConcept? = null
    var performer: List<BiologicallyDerivedProductDispense.Performer>? = null
    var location: Reference? = null
    var quantity: Quantity? = null
    var preparedDate: KotlinString? = null
    var _preparedDate: Element? = null
    var whenHandedOver: KotlinString? = null
    var _whenHandedOver: Element? = null
    var destination: Reference? = null
    var note: List<Annotation>? = null
    var usageInstruction: KotlinString? = null
    var _usageInstruction: Element? = null
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
        11 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        12 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(__desc, __i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 ->
          originRelationshipType =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.originRelationshipTypeSer,
              null,
            )
        16 ->
          product =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        17 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        18 ->
          matchStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.originRelationshipTypeSer,
              null,
            )
        19 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerSer, null)
        20 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        21 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        22 -> preparedDate = decoder.decodeStringElement(__desc, __i)
        23 ->
          _preparedDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 -> whenHandedOver = decoder.decodeStringElement(__desc, __i)
        25 ->
          _whenHandedOver =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        26 ->
          destination =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        27 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        28 -> usageInstruction = decoder.decodeStringElement(__desc, __i)
        29 ->
          _usageInstruction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        else ->
          throw SerializationException(
            "Unexpected index decoding BiologicallyDerivedProductDispense: " + __i
          )
      }
    }
    return BiologicallyDerivedProductDispense(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      status =
        Enumeration.of(
          BiologicallyDerivedProductDispense.BiologicallyDerivedProductDispenseCodes.fromCode(
            status!!
          ),
          _status,
        ),
      originRelationshipType = originRelationshipType,
      product = product!!,
      patient = patient!!,
      matchStatus = matchStatus,
      performer = performer ?: listOf(),
      location = location,
      quantity = quantity,
      preparedDate = DateTime.of(FhirDateTime.fromString(preparedDate), _preparedDate),
      whenHandedOver = DateTime.of(FhirDateTime.fromString(whenHandedOver), _whenHandedOver),
      destination = destination,
      note = note ?: listOf(),
      usageInstruction = R5String.of(usageInstruction, _usageInstruction),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: BiologicallyDerivedProductDispense,
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
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.originRelationshipType)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.originRelationshipTypeSer, it)
    }
    (value.product)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.matchStatus)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.originRelationshipTypeSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.performerSer, value.performer)
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.quantitySer, it)
    }
    ((value.preparedDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 22 + __off, it)
    }
    (value.preparedDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.whenHandedOver?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 24 + __off, it)
    }
    (value.whenHandedOver?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.destination)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.noteSer, value.note)
    ((value.usageInstruction?.value))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
    (value.usageInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val originRelationshipTypeSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val performerSerInner: KSerializer<BiologicallyDerivedProductDispense.Performer> =
      BiologicallyDerivedProductDispense.Performer.serializer()

    public val performerSer: KSerializer<List<BiologicallyDerivedProductDispense.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object BiologicallyDerivedProductDispensePolymorphicSerializer :
  KSerializer<BiologicallyDerivedProductDispense> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProductDispense") {
      BiologicallyDerivedProductDispenseSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProductDispense) {
    encoder.encodeStructure(descriptor) {
      BiologicallyDerivedProductDispenseSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProductDispense =
    decoder.decodeStructure(descriptor) {
      BiologicallyDerivedProductDispenseSerializer.deserializeJson(this, descriptor, 0)
    }
}

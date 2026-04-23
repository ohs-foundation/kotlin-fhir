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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          function = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.functionSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("originRelationshipType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("product", Reference.serializer().descriptor, isOptional = true)
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("matchStatus", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(
          lazyDescriptor { BiologicallyDerivedProductDispense.Performer.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("preparedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_preparedDate", Element.serializer().descriptor, isOptional = true)
      element("whenHandedOver", KotlinString.serializer().descriptor, isOptional = true)
      element("_whenHandedOver", Element.serializer().descriptor, isOptional = true)
      element("destination", Reference.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("usageInstruction", KotlinString.serializer().descriptor, isOptional = true)
      element("_usageInstruction", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProductDispense =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProductDispense) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): BiologicallyDerivedProductDispense {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.basedOnSer, null)
        13 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.basedOnSer, null)
        14 -> status = decoder.decodeStringElement(__desc, 14)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          originRelationshipType =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.originRelationshipTypeSer,
              null,
            )
        17 ->
          product =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSerInner, null)
        18 ->
          patient =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.basedOnSerInner, null)
        19 ->
          matchStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.originRelationshipTypeSer,
              null,
            )
        20 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.performerSer, null)
        21 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.basedOnSerInner, null)
        22 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.quantitySer, null)
        23 -> preparedDate = decoder.decodeStringElement(__desc, 23)
        24 ->
          _preparedDate =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> whenHandedOver = decoder.decodeStringElement(__desc, 25)
        26 ->
          _whenHandedOver =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          destination =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.basedOnSerInner, null)
        28 -> note = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.noteSer, null)
        29 -> usageInstruction = decoder.decodeStringElement(__desc, 29)
        30 ->
          _usageInstruction =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        CompositeDecoder.DECODE_DONE -> break
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProductDispense,
  ) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "BiologicallyDerivedProductDispense")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.originRelationshipType)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.originRelationshipTypeSer, it)
    }
    (value.product)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSerInner, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.basedOnSerInner, it)
    }
    (value.matchStatus)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.originRelationshipTypeSer, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.performerSer, value.performer)
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.basedOnSerInner, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.quantitySer, it) }
    ((value.preparedDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.preparedDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.whenHandedOver?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.whenHandedOver?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    (value.destination)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.basedOnSerInner, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.noteSer, value.note)
    ((value.usageInstruction?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.usageInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
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

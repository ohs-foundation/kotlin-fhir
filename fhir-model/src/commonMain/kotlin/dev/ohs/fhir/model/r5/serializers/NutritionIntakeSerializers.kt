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
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.NutritionIntake
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object NutritionIntakeConsumedItemSerializer : KSerializer<NutritionIntake.ConsumedItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConsumedItem") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("nutritionProduct", CodeableReference.serializer().descriptor, isOptional = true)
      element("schedule", Timing.serializer().descriptor, isOptional = true)
      element("amount", Quantity.serializer().descriptor, isOptional = true)
      element("rate", Quantity.serializer().descriptor, isOptional = true)
      element("notConsumed", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_notConsumed", Element.serializer().descriptor, isOptional = true)
      element("notConsumedReason", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionIntake.ConsumedItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.ConsumedItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): NutritionIntake.ConsumedItem {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var nutritionProduct: CodeableReference? = null
    var schedule: Timing? = null
    var amount: Quantity? = null
    var rate: Quantity? = null
    var notConsumed: KotlinBoolean? = null
    var _notConsumed: Element? = null
    var notConsumedReason: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          nutritionProduct =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nutritionProductSer, null)
        5 ->
          schedule = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.scheduleSer, null)
        6 -> amount = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.amountSer, null)
        7 -> rate = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.amountSer, null)
        8 -> notConsumed = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _notConsumed =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.notConsumedSer, null)
        10 ->
          notConsumedReason =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ConsumedItem: " + __i)
      }
    }
    return NutritionIntake.ConsumedItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      nutritionProduct = nutritionProduct!!,
      schedule = schedule,
      amount = amount,
      rate = rate,
      notConsumed = R5Boolean.of(notConsumed, _notConsumed),
      notConsumedReason = notConsumedReason,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionIntake.ConsumedItem) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.nutritionProduct)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nutritionProductSer, it)
    }
    (value.schedule)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.scheduleSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.amountSer, it) }
    (value.rate)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.amountSer, it) }
    ((value.notConsumed?.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
    (value.notConsumed?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.notConsumedSer, it)
    }
    (value.notConsumedReason)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val nutritionProductSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val scheduleSer: KSerializer<Timing> = Timing.serializer()

    public val amountSer: KSerializer<Quantity> = Quantity.serializer()

    public val notConsumedSer: KSerializer<Element> = Element.serializer()
  }
}

internal object NutritionIntakeIngredientLabelSerializer :
  KSerializer<NutritionIntake.IngredientLabel> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("IngredientLabel") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("nutrient", CodeableReference.serializer().descriptor, isOptional = true)
      element("amount", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionIntake.IngredientLabel =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.IngredientLabel) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): NutritionIntake.IngredientLabel {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var nutrient: CodeableReference? = null
    var amount: Quantity? = null
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
          nutrient = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.nutrientSer, null)
        4 -> amount = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding IngredientLabel: " + __i)
      }
    }
    return NutritionIntake.IngredientLabel(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      nutrient = nutrient!!,
      amount = amount!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionIntake.IngredientLabel) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.nutrient)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.nutrientSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nutrientSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val amountSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object NutritionIntakePerformerSerializer : KSerializer<NutritionIntake.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      element("id", String.serializer().descriptor, isOptional = true)
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

  override fun deserialize(decoder: Decoder): NutritionIntake.Performer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): NutritionIntake.Performer {
    val __desc = descriptor
    var id: String? = null
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
    return NutritionIntake.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor = actor!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionIntake.Performer) {
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

internal object NutritionIntakeOccurrenceSerializer : KSerializer<NutritionIntake.Occurrence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NutritionIntake.Occurrence") {
      element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.Occurrence) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is NutritionIntake.Occurrence.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is NutritionIntake.Occurrence.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.occurrencePeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): NutritionIntake.Occurrence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): NutritionIntake.Occurrence {
    val __desc = descriptor
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.occurrencePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding NutritionIntake.Occurrence: " + __i
          )
      }
    }
    return NutritionIntake.Occurrence.from(
      DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
      occurrencePeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object NutritionIntakeReportedSerializer : KSerializer<NutritionIntake.Reported> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NutritionIntake.Reported") {
      element("reportedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_reportedBoolean", Element.serializer().descriptor, isOptional = true)
      element("reportedReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.Reported) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is NutritionIntake.Reported.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is NutritionIntake.Reported.Reference -> {
          encodeSerializableElement(__desc, 2, Hoisted.reportedReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): NutritionIntake.Reported =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): NutritionIntake.Reported {
    val __desc = descriptor
    var reportedBoolean: KotlinBoolean? = null
    var _reportedBoolean: Element? = null
    var reportedReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> reportedBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _reportedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          reportedReference =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.reportedReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding NutritionIntake.Reported: " + __i)
      }
    }
    return NutritionIntake.Reported.from(
      R5Boolean.of(reportedBoolean, _reportedBoolean),
      reportedReference,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val reportedReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object NutritionIntakeSerializer : KSerializer<NutritionIntake> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NutritionIntake") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
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
      element(
        "instantiatesCanonical",
        listSerialDescriptor(String.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesCanonical",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesUri",
        listSerialDescriptor(String.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", String.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "statusReason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("recorded", String.serializer().descriptor, isOptional = true)
      element("_recorded", Element.serializer().descriptor, isOptional = true)
      element("reportedBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_reportedBoolean", Element.serializer().descriptor, isOptional = true)
      element("reportedReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "consumedItem",
        listSerialDescriptor(
          lazyDescriptor { NutritionIntake.ConsumedItem.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "ingredientLabel",
        listSerialDescriptor(
          lazyDescriptor { NutritionIntake.IngredientLabel.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "performer",
        listSerialDescriptor(lazyDescriptor { NutritionIntake.Performer.serializer().descriptor }),
        isOptional = true,
      )
      element("location", Reference.serializer().descriptor, isOptional = true)
      element(
        "derivedFrom",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionIntake =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionIntake) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): NutritionIntake {
    val __desc = descriptor
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var instantiatesCanonical: List<String?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<String?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: String? = null
    var _status: Element? = null
    var statusReason: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var recorded: String? = null
    var _recorded: Element? = null
    var reportedBoolean: KotlinBoolean? = null
    var _reportedBoolean: Element? = null
    var reportedReference: Reference? = null
    var consumedItem: List<NutritionIntake.ConsumedItem>? = null
    var ingredientLabel: List<NutritionIntake.IngredientLabel>? = null
    var performer: List<NutritionIntake.Performer>? = null
    var location: Reference? = null
    var derivedFrom: List<Reference>? = null
    var reason: List<CodeableReference>? = null
    var note: List<Annotation>? = null
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
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        13 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        14 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        15 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        16 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSer, null)
        17 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSer, null)
        18 -> status = decoder.decodeStringElement(__desc, 18)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.statusReasonSer, null)
        21 ->
          code =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.statusReasonSerInner,
              null,
            )
        22 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.basedOnSerInner, null)
        23 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.basedOnSerInner, null)
        24 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 24)
        25 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.occurrencePeriodSer, null)
        27 -> recorded = decoder.decodeStringElement(__desc, 27)
        28 ->
          _recorded =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> reportedBoolean = decoder.decodeBooleanElement(__desc, 29)
        30 ->
          _reportedBoolean =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          reportedReference =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.basedOnSerInner, null)
        32 ->
          consumedItem =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.consumedItemSer, null)
        33 ->
          ingredientLabel =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.ingredientLabelSer, null)
        34 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.performerSer, null)
        35 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.basedOnSerInner, null)
        36 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.basedOnSer, null)
        37 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.reasonSer, null)
        38 -> note = decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NutritionIntake: " + __i)
      }
    }
    return NutritionIntake(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { __i ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(__i)?.let { it },
            _instantiatesCanonical?.getOrNull(__i),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          __i ->
          Uri.of(instantiatesUri?.getOrNull(__i)?.let { it }, _instantiatesUri?.getOrNull(__i))!!
        }),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      status = Enumeration.of(NutritionIntake.EventStatus.fromCode(status!!), _status),
      statusReason = statusReason ?: listOf(),
      code = code,
      subject = subject!!,
      encounter = encounter,
      occurrence =
        NutritionIntake.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
        ),
      recorded = DateTime.of(FhirDateTime.fromString(recorded), _recorded),
      reported =
        NutritionIntake.Reported.from(
          R5Boolean.of(reportedBoolean, _reportedBoolean),
          reportedReference,
        ),
      consumedItem = consumedItem ?: listOf(),
      ingredientLabel = ingredientLabel ?: listOf(),
      performer = performer ?: listOf(),
      location = location,
      derivedFrom = derivedFrom ?: listOf(),
      reason = reason ?: listOf(),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionIntake) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "NutritionIntake")
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
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.statusReasonSer, value.statusReason)
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.statusReasonSerInner, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.basedOnSerInner, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is NutritionIntake.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 24, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
        }
      }
      is NutritionIntake.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.occurrencePeriodSer, __d.value)
      }
    }
    ((value.recorded?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.recorded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.reported) {
      null -> {}
      is NutritionIntake.Reported.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 29, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
        }
      }
      is NutritionIntake.Reported.Reference -> {
        encoder.encodeSerializableElement(__desc, 31, Hoisted.basedOnSerInner, __d.value)
      }
    }
    if (value.consumedItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.consumedItemSer, value.consumedItem)
    if (value.ingredientLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        33,
        Hoisted.ingredientLabelSer,
        value.ingredientLabel,
      )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.performerSer, value.performer)
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.basedOnSerInner, it)
    }
    if (value.derivedFrom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.basedOnSer, value.derivedFrom)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.reasonSer, value.reason)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.noteSer, value.note)
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

    public val instantiatesCanonicalSerInner: KSerializer<String> = String.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<String?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val statusReasonSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val statusReasonSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.statusReasonSerInner)

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val consumedItemSerInner: KSerializer<NutritionIntake.ConsumedItem> =
      NutritionIntake.ConsumedItem.serializer()

    public val consumedItemSer: KSerializer<List<NutritionIntake.ConsumedItem>> =
      ListSerializer(Hoisted.consumedItemSerInner)

    public val ingredientLabelSerInner: KSerializer<NutritionIntake.IngredientLabel> =
      NutritionIntake.IngredientLabel.serializer()

    public val ingredientLabelSer: KSerializer<List<NutritionIntake.IngredientLabel>> =
      ListSerializer(Hoisted.ingredientLabelSerInner)

    public val performerSerInner: KSerializer<NutritionIntake.Performer> =
      NutritionIntake.Performer.serializer()

    public val performerSer: KSerializer<List<NutritionIntake.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

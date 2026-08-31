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

import dev.ohs.fhir.model.r5.Age
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DataRequirement
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PlanDefinition
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.TriggerDefinition
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
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

internal object PlanDefinitionGoalSerializer : KSerializer<PlanDefinition.Goal> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Goal") {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", CodeableConcept.serializer().descriptor, isOptional = true)
      element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
      element("start", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "addresses",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "documentation",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "target",
        listSerialDescriptor(lazyDescriptor { PlanDefinition.Goal.Target.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Goal {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var description: CodeableConcept? = null
    var priority: CodeableConcept? = null
    var start: CodeableConcept? = null
    var addresses: List<CodeableConcept>? = null
    var documentation: List<RelatedArtifact>? = null
    var target: List<PlanDefinition.Goal.Target>? = null
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
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        5 ->
          priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        6 ->
          start =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        7 ->
          addresses =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressesSer, null)
        8 ->
          documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentationSer, null)
        9 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Goal: " + i)
      }
    }
    return PlanDefinition.Goal(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      description =
        description
          ?: throw SerializationException(
            "Missing required property 'description' on PlanDefinition.Goal"
          ),
      priority = priority,
      start = start,
      addresses = addresses ?: listOf(),
      documentation = documentation ?: listOf(),
      target = target ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Goal) {
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
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.categorySer, value.description)
    (value.priority)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.categorySer, it)
    }
    (value.start)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.categorySer, it) }
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.addressesSer, value.addresses)
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        Hoisted.documentationSer,
        value.documentation,
      )
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.targetSer, value.target)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val addressesSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySer)

    public val documentationSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val documentationSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.documentationSerInner)

    public val targetSerInner: KSerializer<PlanDefinition.Goal.Target> =
      PlanDefinition.Goal.Target.serializer()

    public val targetSer: KSerializer<List<PlanDefinition.Goal.Target>> =
      ListSerializer(Hoisted.targetSerInner)
  }
}

internal object PlanDefinitionGoalTargetSerializer : KSerializer<PlanDefinition.Goal.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
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
      element("measure", CodeableConcept.serializer().descriptor, isOptional = true)
      element("detailQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("detailRange", Range.serializer().descriptor, isOptional = true)
      element("detailCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("detailString", KotlinString.serializer().descriptor, isOptional = true)
      element("_detailString", Element.serializer().descriptor, isOptional = true)
      element("detailBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_detailBoolean", Element.serializer().descriptor, isOptional = true)
      element("detailInteger", Int.serializer().descriptor, isOptional = true)
      element("_detailInteger", Element.serializer().descriptor, isOptional = true)
      element("detailRatio", Ratio.serializer().descriptor, isOptional = true)
      element("due", Duration.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal.Target =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal.Target) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Goal.Target {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var measure: CodeableConcept? = null
    var detailQuantity: Quantity? = null
    var detailRange: Range? = null
    var detailCodeableConcept: CodeableConcept? = null
    var detailString: KotlinString? = null
    var _detailString: Element? = null
    var detailBoolean: KotlinBoolean? = null
    var _detailBoolean: Element? = null
    var detailInteger: Int? = null
    var _detailInteger: Element? = null
    var detailRatio: Ratio? = null
    var due: Duration? = null
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
          measure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.measureSer, null)
        4 ->
          detailQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.detailQuantitySer,
              null,
            )
        5 ->
          detailRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailRangeSer, null)
        6 ->
          detailCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.measureSer, null)
        7 -> detailString = decoder.decodeStringElement(descriptor, i)
        8 ->
          _detailString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailStringSer, null)
        9 -> detailBoolean = decoder.decodeBooleanElement(descriptor, i)
        10 ->
          _detailBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailStringSer, null)
        11 -> detailInteger = decoder.decodeIntElement(descriptor, i)
        12 ->
          _detailInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailStringSer, null)
        13 ->
          detailRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailRatioSer, null)
        14 -> due = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + i)
      }
    }
    return PlanDefinition.Goal.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      measure = measure,
      detail =
        PlanDefinition.Goal.Target.Detail.from(
          detailQuantity,
          detailRange,
          detailCodeableConcept,
          R5String.of(detailString, _detailString),
          R5Boolean.of(detailBoolean, _detailBoolean),
          Integer.of(detailInteger, _detailInteger),
          detailRatio,
        ),
      due = due,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Goal.Target) {
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
    (value.measure)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.measureSer, it)
    }
    when (val choice = value.detail) {
      null -> {}
      is PlanDefinition.Goal.Target.Detail.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.detailQuantitySer, choice.value)
      }
      is PlanDefinition.Goal.Target.Detail.Range -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.detailRangeSer, choice.value)
      }
      is PlanDefinition.Goal.Target.Detail.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.measureSer, choice.value)
      }
      is PlanDefinition.Goal.Target.Detail.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.detailStringSer, it)
        }
      }
      is PlanDefinition.Goal.Target.Detail.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.detailStringSer, it)
        }
      }
      is PlanDefinition.Goal.Target.Detail.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.detailStringSer, it)
        }
      }
      is PlanDefinition.Goal.Target.Detail.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 13, Hoisted.detailRatioSer, choice.value)
      }
    }
    (value.due)?.let { encoder.encodeSerializableElement(descriptor, 14, Hoisted.dueSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val measureSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val detailQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val detailRangeSer: KSerializer<Range> = Range.serializer()

    public val detailStringSer: KSerializer<Element> = Element.serializer()

    public val detailRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val dueSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object PlanDefinitionActorSerializer : KSerializer<PlanDefinition.Actor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Actor") {
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
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "option",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Actor.Option.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Actor =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Actor) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Actor {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var option: List<PlanDefinition.Actor.Option>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> title = decoder.decodeStringElement(descriptor, i)
        4 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        7 ->
          option = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.optionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Actor: " + i)
      }
    }
    return PlanDefinition.Actor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R5String.of(title, _title),
      description = Markdown.of(description, _description),
      option = option ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Actor) {
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
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.titleSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.titleSer, it)
    }
    if (value.option.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.optionSer, value.option)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val optionSerInner: KSerializer<PlanDefinition.Actor.Option> =
      PlanDefinition.Actor.Option.serializer()

    public val optionSer: KSerializer<List<PlanDefinition.Actor.Option>> =
      ListSerializer(Hoisted.optionSerInner)
  }
}

internal object PlanDefinitionActorOptionSerializer : KSerializer<PlanDefinition.Actor.Option> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Option") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("typeCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_typeCanonical", Element.serializer().descriptor, isOptional = true)
      element("typeReference", Reference.serializer().descriptor, isOptional = true)
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Actor.Option =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Actor.Option) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Actor.Option {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var typeCanonical: KotlinString? = null
    var _typeCanonical: Element? = null
    var typeReference: Reference? = null
    var role: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> typeCanonical = decoder.decodeStringElement(descriptor, i)
        6 ->
          _typeCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          typeReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeReferenceSer, null)
        8 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Option: " + i)
      }
    }
    return PlanDefinition.Actor.Option(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(type?.let { PlanDefinition.ActionParticipantType.fromCode(it) }, _type),
      typeCanonical = Canonical.of(typeCanonical, _typeCanonical),
      typeReference = typeReference,
      role = role,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Actor.Option) {
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
    ((value.type?.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.typeCanonical?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.typeCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
    (value.typeReference)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeReferenceSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 8, Hoisted.roleSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val typeReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object PlanDefinitionActionSerializer : KSerializer<PlanDefinition.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
      element("prefix", KotlinString.serializer().descriptor, isOptional = true)
      element("_prefix", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("textEquivalent", KotlinString.serializer().descriptor, isOptional = true)
      element("_textEquivalent", Element.serializer().descriptor, isOptional = true)
      element("priority", KotlinString.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "reason",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "documentation",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "goalId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_goalId", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
      element("subjectCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_subjectCanonical", Element.serializer().descriptor, isOptional = true)
      element(
        "trigger",
        listSerialDescriptor(TriggerDefinition.serializer().descriptor),
        isOptional = true,
      )
      element(
        "condition",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.Condition.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "input",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.Input.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "output",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.Output.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "relatedAction",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.RelatedAction.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("timingAge", Age.serializer().descriptor, isOptional = true)
      element("timingDuration", Duration.serializer().descriptor, isOptional = true)
      element("timingRange", Range.serializer().descriptor, isOptional = true)
      element("timingTiming", Timing.serializer().descriptor, isOptional = true)
      element("location", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "participant",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.Participant.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("groupingBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_groupingBehavior", Element.serializer().descriptor, isOptional = true)
      element("selectionBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_selectionBehavior", Element.serializer().descriptor, isOptional = true)
      element("requiredBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_requiredBehavior", Element.serializer().descriptor, isOptional = true)
      element("precheckBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_precheckBehavior", Element.serializer().descriptor, isOptional = true)
      element("cardinalityBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_cardinalityBehavior", Element.serializer().descriptor, isOptional = true)
      element("definitionCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionCanonical", Element.serializer().descriptor, isOptional = true)
      element("definitionUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_definitionUri", Element.serializer().descriptor, isOptional = true)
      element("transform", KotlinString.serializer().descriptor, isOptional = true)
      element("_transform", Element.serializer().descriptor, isOptional = true)
      element(
        "dynamicValue",
        listSerialDescriptor(
          lazyDescriptor { PlanDefinition.Action.DynamicValue.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { PlanDefinition.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var prefix: KotlinString? = null
    var _prefix: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var textEquivalent: KotlinString? = null
    var _textEquivalent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var code: CodeableConcept? = null
    var reason: List<CodeableConcept>? = null
    var documentation: List<RelatedArtifact>? = null
    var goalId: List<KotlinString?>? = null
    var _goalId: List<Element?>? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var subjectCanonical: KotlinString? = null
    var _subjectCanonical: Element? = null
    var trigger: List<TriggerDefinition>? = null
    var condition: List<PlanDefinition.Action.Condition>? = null
    var input: List<PlanDefinition.Action.Input>? = null
    var output: List<PlanDefinition.Action.Output>? = null
    var relatedAction: List<PlanDefinition.Action.RelatedAction>? = null
    var timingAge: Age? = null
    var timingDuration: Duration? = null
    var timingRange: Range? = null
    var timingTiming: Timing? = null
    var location: CodeableReference? = null
    var participant: List<PlanDefinition.Action.Participant>? = null
    var type: CodeableConcept? = null
    var groupingBehavior: KotlinString? = null
    var _groupingBehavior: Element? = null
    var selectionBehavior: KotlinString? = null
    var _selectionBehavior: Element? = null
    var requiredBehavior: KotlinString? = null
    var _requiredBehavior: Element? = null
    var precheckBehavior: KotlinString? = null
    var _precheckBehavior: Element? = null
    var cardinalityBehavior: KotlinString? = null
    var _cardinalityBehavior: Element? = null
    var definitionCanonical: KotlinString? = null
    var _definitionCanonical: Element? = null
    var definitionUri: KotlinString? = null
    var _definitionUri: Element? = null
    var transform: KotlinString? = null
    var _transform: Element? = null
    var dynamicValue: List<PlanDefinition.Action.DynamicValue>? = null
    var action: List<PlanDefinition.Action>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> prefix = decoder.decodeStringElement(descriptor, i)
        6 ->
          _prefix =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        7 -> title = decoder.decodeStringElement(descriptor, i)
        8 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        9 -> description = decoder.decodeStringElement(descriptor, i)
        10 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        11 -> textEquivalent = decoder.decodeStringElement(descriptor, i)
        12 ->
          _textEquivalent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        13 -> priority = decoder.decodeStringElement(descriptor, i)
        14 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        15 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        16 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        17 ->
          documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentationSer, null)
        18 ->
          goalId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.goalIdSer, null)
        19 ->
          _goalId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.goalIdSer2, null)
        20 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        21 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
        22 -> subjectCanonical = decoder.decodeStringElement(descriptor, i)
        23 ->
          _subjectCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        24 ->
          trigger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.triggerSer, null)
        25 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        26 ->
          input = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.inputSer, null)
        27 ->
          output = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.outputSer, null)
        28 ->
          relatedAction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatedActionSer, null)
        29 ->
          timingAge =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingAgeSer, null)
        30 ->
          timingDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.timingDurationSer,
              null,
            )
        31 ->
          timingRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingRangeSer, null)
        32 ->
          timingTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingTimingSer, null)
        33 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.locationSer, null)
        34 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        35 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        36 -> groupingBehavior = decoder.decodeStringElement(descriptor, i)
        37 ->
          _groupingBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        38 -> selectionBehavior = decoder.decodeStringElement(descriptor, i)
        39 ->
          _selectionBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        40 -> requiredBehavior = decoder.decodeStringElement(descriptor, i)
        41 ->
          _requiredBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        42 -> precheckBehavior = decoder.decodeStringElement(descriptor, i)
        43 ->
          _precheckBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        44 -> cardinalityBehavior = decoder.decodeStringElement(descriptor, i)
        45 ->
          _cardinalityBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        46 -> definitionCanonical = decoder.decodeStringElement(descriptor, i)
        47 ->
          _definitionCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        48 -> definitionUri = decoder.decodeStringElement(descriptor, i)
        49 ->
          _definitionUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        50 -> transform = decoder.decodeStringElement(descriptor, i)
        51 ->
          _transform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        52 ->
          dynamicValue =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dynamicValueSer, null)
        53 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    return PlanDefinition.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = R5String.of(linkId, _linkId),
      prefix = R5String.of(prefix, _prefix),
      title = R5String.of(title, _title),
      description = Markdown.of(description, _description),
      textEquivalent = Markdown.of(textEquivalent, _textEquivalent),
      priority =
        Enumeration.of(priority?.let { PlanDefinition.RequestPriority.fromCode(it) }, _priority),
      code = code,
      reason = reason ?: listOf(),
      documentation = documentation ?: listOf(),
      goalId =
        (kotlin.collections.List(maxOf(goalId?.size ?: 0, _goalId?.size ?: 0)) { index ->
          Id.of(goalId?.getOrNull(index)?.let { it }, _goalId?.getOrNull(index))!!
        }),
      subject =
        PlanDefinition.Action.Subject.from(
          subjectCodeableConcept,
          subjectReference,
          Canonical.of(subjectCanonical, _subjectCanonical),
        ),
      trigger = trigger ?: listOf(),
      condition = condition ?: listOf(),
      input = input ?: listOf(),
      output = output ?: listOf(),
      relatedAction = relatedAction ?: listOf(),
      timing =
        PlanDefinition.Action.Timing.from(timingAge, timingDuration, timingRange, timingTiming),
      location = location,
      participant = participant ?: listOf(),
      type = type,
      groupingBehavior =
        Enumeration.of(
          groupingBehavior?.let { PlanDefinition.ActionGroupingBehavior.fromCode(it) },
          _groupingBehavior,
        ),
      selectionBehavior =
        Enumeration.of(
          selectionBehavior?.let { PlanDefinition.ActionSelectionBehavior.fromCode(it) },
          _selectionBehavior,
        ),
      requiredBehavior =
        Enumeration.of(
          requiredBehavior?.let { PlanDefinition.ActionRequiredBehavior.fromCode(it) },
          _requiredBehavior,
        ),
      precheckBehavior =
        Enumeration.of(
          precheckBehavior?.let { PlanDefinition.ActionPrecheckBehavior.fromCode(it) },
          _precheckBehavior,
        ),
      cardinalityBehavior =
        Enumeration.of(
          cardinalityBehavior?.let { PlanDefinition.ActionCardinalityBehavior.fromCode(it) },
          _cardinalityBehavior,
        ),
      definition =
        PlanDefinition.Action.Definition.from(
          Canonical.of(definitionCanonical, _definitionCanonical),
          Uri.of(definitionUri, _definitionUri),
        ),
      transform = Canonical.of(transform, _transform),
      dynamicValue = dynamicValue ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Action) {
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
    ((value.linkId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    ((value.prefix?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.prefix?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.linkIdSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.linkIdSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.linkIdSer, it)
    }
    ((value.textEquivalent?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.textEquivalent?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.linkIdSer, it)
    }
    ((value.priority?.value?.code))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 15, Hoisted.codeSer, it) }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.reasonSer, value.reason)
    if (value.documentation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17,
        Hoisted.documentationSer,
        value.documentation,
      )
    (value.goalId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.goalIdSer, it)
    }
    (value.goalId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.goalIdSer2, it)
    }
    when (val choice = value.subject) {
      null -> {}
      is PlanDefinition.Action.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 20, Hoisted.codeSer, choice.value)
      }
      is PlanDefinition.Action.Subject.Reference -> {
        encoder.encodeSerializableElement(descriptor, 21, Hoisted.subjectReferenceSer, choice.value)
      }
      is PlanDefinition.Action.Subject.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 22, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 23, Hoisted.linkIdSer, it)
        }
      }
    }
    if (value.trigger.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.triggerSer, value.trigger)
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.conditionSer, value.condition)
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.inputSer, value.input)
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.outputSer, value.output)
    if (value.relatedAction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28,
        Hoisted.relatedActionSer,
        value.relatedAction,
      )
    when (val choice = value.timing) {
      null -> {}
      is PlanDefinition.Action.Timing.Age -> {
        encoder.encodeSerializableElement(descriptor, 29, Hoisted.timingAgeSer, choice.value)
      }
      is PlanDefinition.Action.Timing.Duration -> {
        encoder.encodeSerializableElement(descriptor, 30, Hoisted.timingDurationSer, choice.value)
      }
      is PlanDefinition.Action.Timing.Range -> {
        encoder.encodeSerializableElement(descriptor, 31, Hoisted.timingRangeSer, choice.value)
      }
      is PlanDefinition.Action.Timing.Timing -> {
        encoder.encodeSerializableElement(descriptor, 32, Hoisted.timingTimingSer, choice.value)
      }
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 33, Hoisted.locationSer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 34, Hoisted.participantSer, value.participant)
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 35, Hoisted.codeSer, it) }
    ((value.groupingBehavior?.value?.code))?.let { encoder.encodeStringElement(descriptor, 36, it) }
    (value.groupingBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 37, Hoisted.linkIdSer, it)
    }
    ((value.selectionBehavior?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 38, it)
    }
    (value.selectionBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 39, Hoisted.linkIdSer, it)
    }
    ((value.requiredBehavior?.value?.code))?.let { encoder.encodeStringElement(descriptor, 40, it) }
    (value.requiredBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 41, Hoisted.linkIdSer, it)
    }
    ((value.precheckBehavior?.value?.code))?.let { encoder.encodeStringElement(descriptor, 42, it) }
    (value.precheckBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 43, Hoisted.linkIdSer, it)
    }
    ((value.cardinalityBehavior?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 44, it)
    }
    (value.cardinalityBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 45, Hoisted.linkIdSer, it)
    }
    when (val choice = value.definition) {
      null -> {}
      is PlanDefinition.Action.Definition.Canonical -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 46, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 47, Hoisted.linkIdSer, it)
        }
      }
      is PlanDefinition.Action.Definition.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 48, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 49, Hoisted.linkIdSer, it)
        }
      }
    }
    ((value.transform?.value))?.let { encoder.encodeStringElement(descriptor, 50, it) }
    (value.transform?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 51, Hoisted.linkIdSer, it)
    }
    if (value.dynamicValue.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 52, Hoisted.dynamicValueSer, value.dynamicValue)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 53, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSer)

    public val documentationSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val documentationSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.documentationSerInner)

    public val goalIdSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val goalIdSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.goalIdSerInner).nullable)

    public val goalIdSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.linkIdSer).nullable)

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val triggerSerInner: KSerializer<TriggerDefinition> = TriggerDefinition.serializer()

    public val triggerSer: KSerializer<List<TriggerDefinition>> =
      ListSerializer(Hoisted.triggerSerInner)

    public val conditionSerInner: KSerializer<PlanDefinition.Action.Condition> =
      PlanDefinition.Action.Condition.serializer()

    public val conditionSer: KSerializer<List<PlanDefinition.Action.Condition>> =
      ListSerializer(Hoisted.conditionSerInner)

    public val inputSerInner: KSerializer<PlanDefinition.Action.Input> =
      PlanDefinition.Action.Input.serializer()

    public val inputSer: KSerializer<List<PlanDefinition.Action.Input>> =
      ListSerializer(Hoisted.inputSerInner)

    public val outputSerInner: KSerializer<PlanDefinition.Action.Output> =
      PlanDefinition.Action.Output.serializer()

    public val outputSer: KSerializer<List<PlanDefinition.Action.Output>> =
      ListSerializer(Hoisted.outputSerInner)

    public val relatedActionSerInner: KSerializer<PlanDefinition.Action.RelatedAction> =
      PlanDefinition.Action.RelatedAction.serializer()

    public val relatedActionSer: KSerializer<List<PlanDefinition.Action.RelatedAction>> =
      ListSerializer(Hoisted.relatedActionSerInner)

    public val timingAgeSer: KSerializer<Age> = Age.serializer()

    public val timingDurationSer: KSerializer<Duration> = Duration.serializer()

    public val timingRangeSer: KSerializer<Range> = Range.serializer()

    public val timingTimingSer: KSerializer<Timing> = Timing.serializer()

    public val locationSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val participantSerInner: KSerializer<PlanDefinition.Action.Participant> =
      PlanDefinition.Action.Participant.serializer()

    public val participantSer: KSerializer<List<PlanDefinition.Action.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val dynamicValueSerInner: KSerializer<PlanDefinition.Action.DynamicValue> =
      PlanDefinition.Action.DynamicValue.serializer()

    public val dynamicValueSer: KSerializer<List<PlanDefinition.Action.DynamicValue>> =
      ListSerializer(Hoisted.dynamicValueSerInner)

    public val actionSerInner: KSerializer<PlanDefinition.Action> =
      PlanDefinition.Action.serializer()

    public val actionSer: KSerializer<List<PlanDefinition.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object PlanDefinitionActionConditionSerializer :
  KSerializer<PlanDefinition.Action.Condition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Condition") {
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
      element("kind", KotlinString.serializer().descriptor, isOptional = true)
      element("_kind", Element.serializer().descriptor, isOptional = true)
      element("expression", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Condition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Condition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.Condition {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> kind = decoder.decodeStringElement(descriptor, i)
        4 -> _kind = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.kindSer, null)
        5 ->
          expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Condition: " + i)
      }
    }
    return PlanDefinition.Action.Condition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kind =
        Enumeration.of(kind?.let { PlanDefinition.ActionConditionKind.fromCode(it) }, _kind)
          ?: throw SerializationException(
            "Missing required property 'kind' on PlanDefinition.Action.Condition"
          ),
      expression = expression,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.Condition,
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
    ((value.kind.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.kindSer, it)
    }
    (value.expression)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.expressionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val kindSer: KSerializer<Element> = Element.serializer()

    public val expressionSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object PlanDefinitionActionInputSerializer : KSerializer<PlanDefinition.Action.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
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
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("requirement", DataRequirement.serializer().descriptor, isOptional = true)
      element("relatedData", KotlinString.serializer().descriptor, isOptional = true)
      element("_relatedData", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Input =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Input) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.Input {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var requirement: DataRequirement? = null
    var relatedData: KotlinString? = null
    var _relatedData: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> title = decoder.decodeStringElement(descriptor, i)
        4 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        5 ->
          requirement =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requirementSer, null)
        6 -> relatedData = decoder.decodeStringElement(descriptor, i)
        7 ->
          _relatedData =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Input: " + i)
      }
    }
    return PlanDefinition.Action.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R5String.of(title, _title),
      requirement = requirement,
      relatedData = Id.of(relatedData, _relatedData),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Action.Input) {
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
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.titleSer, it)
    }
    (value.requirement)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.requirementSer, it)
    }
    ((value.relatedData?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.relatedData?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.titleSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val requirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()
  }
}

internal object PlanDefinitionActionOutputSerializer : KSerializer<PlanDefinition.Action.Output> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Output") {
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
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("requirement", DataRequirement.serializer().descriptor, isOptional = true)
      element("relatedData", KotlinString.serializer().descriptor, isOptional = true)
      element("_relatedData", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Output =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Output) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.Output {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var requirement: DataRequirement? = null
    var relatedData: KotlinString? = null
    var _relatedData: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> title = decoder.decodeStringElement(descriptor, i)
        4 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        5 ->
          requirement =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requirementSer, null)
        6 -> relatedData = decoder.decodeStringElement(descriptor, i)
        7 ->
          _relatedData =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Output: " + i)
      }
    }
    return PlanDefinition.Action.Output(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R5String.of(title, _title),
      requirement = requirement,
      relatedData = R5String.of(relatedData, _relatedData),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: PlanDefinition.Action.Output) {
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
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.titleSer, it)
    }
    (value.requirement)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.requirementSer, it)
    }
    ((value.relatedData?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.relatedData?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.titleSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val requirementSer: KSerializer<DataRequirement> = DataRequirement.serializer()
  }
}

internal object PlanDefinitionActionRelatedActionSerializer :
  KSerializer<PlanDefinition.Action.RelatedAction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedAction") {
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
      element("targetId", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetId", Element.serializer().descriptor, isOptional = true)
      element("relationship", KotlinString.serializer().descriptor, isOptional = true)
      element("_relationship", Element.serializer().descriptor, isOptional = true)
      element("endRelationship", KotlinString.serializer().descriptor, isOptional = true)
      element("_endRelationship", Element.serializer().descriptor, isOptional = true)
      element("offsetDuration", Duration.serializer().descriptor, isOptional = true)
      element("offsetRange", Range.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.RelatedAction =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.RelatedAction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.RelatedAction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var targetId: KotlinString? = null
    var _targetId: Element? = null
    var relationship: KotlinString? = null
    var _relationship: Element? = null
    var endRelationship: KotlinString? = null
    var _endRelationship: Element? = null
    var offsetDuration: Duration? = null
    var offsetRange: Range? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> targetId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _targetId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetIdSer, null)
        5 -> relationship = decoder.decodeStringElement(descriptor, i)
        6 ->
          _relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetIdSer, null)
        7 -> endRelationship = decoder.decodeStringElement(descriptor, i)
        8 ->
          _endRelationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetIdSer, null)
        9 ->
          offsetDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.offsetDurationSer,
              null,
            )
        10 ->
          offsetRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.offsetRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedAction: " + i)
      }
    }
    return PlanDefinition.Action.RelatedAction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      targetId =
        Id.of(targetId, _targetId)
          ?: throw SerializationException(
            "Missing required property 'targetId' on PlanDefinition.Action.RelatedAction"
          ),
      relationship =
        Enumeration.of(
          relationship?.let { PlanDefinition.ActionRelationshipType.fromCode(it) },
          _relationship,
        )
          ?: throw SerializationException(
            "Missing required property 'relationship' on PlanDefinition.Action.RelatedAction"
          ),
      endRelationship =
        Enumeration.of(
          endRelationship?.let { PlanDefinition.ActionRelationshipType.fromCode(it) },
          _endRelationship,
        ),
      offset = PlanDefinition.Action.RelatedAction.Offset.from(offsetDuration, offsetRange),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.RelatedAction,
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
    ((value.targetId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.targetId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.targetIdSer, it)
    }
    ((value.relationship.value?.code))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.relationship.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.targetIdSer, it)
    }
    ((value.endRelationship?.value?.code))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.endRelationship?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.targetIdSer, it)
    }
    when (val choice = value.offset) {
      null -> {}
      is PlanDefinition.Action.RelatedAction.Offset.Duration -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.offsetDurationSer, choice.value)
      }
      is PlanDefinition.Action.RelatedAction.Offset.Range -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.offsetRangeSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val targetIdSer: KSerializer<Element> = Element.serializer()

    public val offsetDurationSer: KSerializer<Duration> = Duration.serializer()

    public val offsetRangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object PlanDefinitionActionParticipantSerializer :
  KSerializer<PlanDefinition.Action.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
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
      element("actorId", KotlinString.serializer().descriptor, isOptional = true)
      element("_actorId", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("typeCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_typeCanonical", Element.serializer().descriptor, isOptional = true)
      element("typeReference", Reference.serializer().descriptor, isOptional = true)
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Participant =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.Participant {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var actorId: KotlinString? = null
    var _actorId: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var typeCanonical: KotlinString? = null
    var _typeCanonical: Element? = null
    var typeReference: Reference? = null
    var role: CodeableConcept? = null
    var function: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> actorId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _actorId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorIdSer, null)
        5 -> type = decoder.decodeStringElement(descriptor, i)
        6 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorIdSer, null)
        7 -> typeCanonical = decoder.decodeStringElement(descriptor, i)
        8 ->
          _typeCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorIdSer, null)
        9 ->
          typeReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeReferenceSer, null)
        10 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        11 ->
          function = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    return PlanDefinition.Action.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actorId = R5String.of(actorId, _actorId),
      type = Enumeration.of(type?.let { PlanDefinition.ActionParticipantType.fromCode(it) }, _type),
      typeCanonical = Canonical.of(typeCanonical, _typeCanonical),
      typeReference = typeReference,
      role = role,
      function = function,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.Participant,
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
    ((value.actorId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.actorId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorIdSer, it)
    }
    ((value.type?.value?.code))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.actorIdSer, it)
    }
    ((value.typeCanonical?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.typeCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.actorIdSer, it)
    }
    (value.typeReference)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.typeReferenceSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 10, Hoisted.roleSer, it) }
    (value.function)?.let { encoder.encodeSerializableElement(descriptor, 11, Hoisted.roleSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actorIdSer: KSerializer<Element> = Element.serializer()

    public val typeReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object PlanDefinitionActionDynamicValueSerializer :
  KSerializer<PlanDefinition.Action.DynamicValue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DynamicValue") {
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
      element("path", KotlinString.serializer().descriptor, isOptional = true)
      element("_path", Element.serializer().descriptor, isOptional = true)
      element("expression", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.DynamicValue =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.DynamicValue) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PlanDefinition.Action.DynamicValue {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var path: KotlinString? = null
    var _path: Element? = null
    var expression: Expression? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> path = decoder.decodeStringElement(descriptor, i)
        4 -> _path = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pathSer, null)
        5 ->
          expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DynamicValue: " + i)
      }
    }
    return PlanDefinition.Action.DynamicValue(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      path = R5String.of(path, _path),
      expression = expression,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PlanDefinition.Action.DynamicValue,
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
    ((value.path?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.path?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.pathSer, it)
    }
    (value.expression)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.expressionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val pathSer: KSerializer<Element> = Element.serializer()

    public val expressionSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object PlanDefinitionSerializer : KSerializer<PlanDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subtitle", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    b.element("subjectCanonical", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subjectCanonical", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("usage", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_usage", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "topic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "library",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_library", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "goal",
      listSerialDescriptor(lazyDescriptor { PlanDefinition.Goal.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "actor",
      listSerialDescriptor(lazyDescriptor { PlanDefinition.Actor.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "action",
      listSerialDescriptor(lazyDescriptor { PlanDefinition.Action.serializer().descriptor }),
      isOptional = true,
    )
    b.element("asNeededBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_asNeededBoolean", Element.serializer().descriptor, isOptional = true)
    b.element("asNeededCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PlanDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): PlanDefinition {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var type: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var subjectCanonical: KotlinString? = null
    var _subjectCanonical: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var usage: KotlinString? = null
    var _usage: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var goal: List<PlanDefinition.Goal>? = null
    var actor: List<PlanDefinition.Actor>? = null
    var action: List<PlanDefinition.Action>? = null
    var asNeededBoolean: KotlinBoolean? = null
    var _asNeededBoolean: Element? = null
    var asNeededCodeableConcept: CodeableConcept? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> subtitle = decoder.decodeStringElement(descriptor, i)
        23 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        25 -> status = decoder.decodeStringElement(descriptor, i)
        26 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        28 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        30 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectReferenceSer,
              null,
            )
        31 -> subjectCanonical = decoder.decodeStringElement(descriptor, i)
        32 ->
          _subjectCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> date = decoder.decodeStringElement(descriptor, i)
        34 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> publisher = decoder.decodeStringElement(descriptor, i)
        36 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        38 -> description = decoder.decodeStringElement(descriptor, i)
        39 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        40 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        41 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        42 -> purpose = decoder.decodeStringElement(descriptor, i)
        43 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        44 -> usage = decoder.decodeStringElement(descriptor, i)
        45 ->
          _usage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        46 -> copyright = decoder.decodeStringElement(descriptor, i)
        47 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        48 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        49 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        50 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        51 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        52 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        53 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        54 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        55 ->
          topic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        56 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        57 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        58 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        59 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        60 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        61 ->
          library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.librarySer, null)
        62 ->
          _library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.librarySer2, null)
        63 -> goal = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.goalSer, null)
        64 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        65 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        66 -> asNeededBoolean = decoder.decodeBooleanElement(descriptor, i)
        67 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        68 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        else -> throw SerializationException("Unexpected index decoding PlanDefinition: " + i)
      }
    }
    return PlanDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        PlanDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      subtitle = R5String.of(subtitle, _subtitle),
      type = type,
      status =
        Enumeration.of(status?.let { PublicationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on PlanDefinition"),
      experimental = R5Boolean.of(experimental, _experimental),
      subject =
        PlanDefinition.Subject.from(
          subjectCodeableConcept,
          subjectReference,
          Canonical.of(subjectCanonical, _subjectCanonical),
        ),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = Markdown.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index)?.let { it }, _library?.getOrNull(index))!!
        }),
      goal = goal ?: listOf(),
      actor = actor ?: listOf(),
      action = action ?: listOf(),
      asNeeded =
        PlanDefinition.AsNeeded.from(
          R5Boolean.of(asNeededBoolean, _asNeededBoolean),
          asNeededCodeableConcept,
        ),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PlanDefinition,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is PlanDefinition.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is PlanDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.subtitle?.value))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.subject) {
      null -> {}
      is PlanDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          29 + descriptorOffset,
          Hoisted.typeSer,
          choice.value,
        )
      }
      is PlanDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          Hoisted.subjectReferenceSer,
          choice.value,
        )
      }
      is PlanDefinition.Subject.Canonical -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            32 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 38 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 42 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.usage?.value))?.let {
      encoder.encodeStringElement(descriptor, 44 + descriptorOffset, it)
    }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 46 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 48 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 50 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 52 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        60 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 61 + descriptorOffset, Hoisted.librarySer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 62 + descriptorOffset, Hoisted.librarySer2, it)
    }
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        Hoisted.goalSer,
        value.goal,
      )
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        64 + descriptorOffset,
        Hoisted.actorSer,
        value.actor,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        Hoisted.actionSer,
        value.action,
      )
    when (val choice = value.asNeeded) {
      null -> {}
      is PlanDefinition.AsNeeded.Boolean -> {
        ((choice.value.value))?.let {
          encoder.encodeBooleanElement(descriptor, 66 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            67 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is PlanDefinition.AsNeeded.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          68 + descriptorOffset,
          Hoisted.typeSer,
          choice.value,
        )
      }
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

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val librarySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val librarySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.librarySerInner).nullable)

    public val librarySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val goalSerInner: KSerializer<PlanDefinition.Goal> = PlanDefinition.Goal.serializer()

    public val goalSer: KSerializer<List<PlanDefinition.Goal>> =
      ListSerializer(Hoisted.goalSerInner)

    public val actorSerInner: KSerializer<PlanDefinition.Actor> = PlanDefinition.Actor.serializer()

    public val actorSer: KSerializer<List<PlanDefinition.Actor>> =
      ListSerializer(Hoisted.actorSerInner)

    public val actionSerInner: KSerializer<PlanDefinition.Action> =
      PlanDefinition.Action.serializer()

    public val actionSer: KSerializer<List<PlanDefinition.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object PlanDefinitionPolymorphicSerializer : KSerializer<PlanDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PlanDefinition") { PlanDefinitionSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: PlanDefinition) {
    encoder.encodeStructure(descriptor) {
      PlanDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PlanDefinition =
    decoder.decodeStructure(descriptor) {
      PlanDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}

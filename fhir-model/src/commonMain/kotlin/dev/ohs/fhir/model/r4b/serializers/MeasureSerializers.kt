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

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Measure
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
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

internal object MeasureGroupSerializer : KSerializer<Measure.Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "population",
        listSerialDescriptor(lazyDescriptor { Measure.Group.Population.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "stratifier",
        listSerialDescriptor(lazyDescriptor { Measure.Group.Stratifier.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Measure.Group =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Measure.Group) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Measure.Group {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var population: List<Measure.Group.Population>? = null
    var stratifier: List<Measure.Group.Stratifier>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> description = decoder.decodeStringElement(__desc, 4)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.descriptionSer, null)
        6 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.populationSer, null)
        7 ->
          stratifier =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.stratifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Group: " + __i)
      }
    }
    return Measure.Group(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      description = R4bString.of(description, _description),
      population = population ?: listOf(),
      stratifier = stratifier ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Measure.Group) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.descriptionSer, it)
    }
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.populationSer, value.population)
    if (value.stratifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.stratifierSer, value.stratifier)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val populationSerInner: KSerializer<Measure.Group.Population> =
      Measure.Group.Population.serializer()

    public val populationSer: KSerializer<List<Measure.Group.Population>> =
      ListSerializer(Hoisted.populationSerInner)

    public val stratifierSerInner: KSerializer<Measure.Group.Stratifier> =
      Measure.Group.Stratifier.serializer()

    public val stratifierSer: KSerializer<List<Measure.Group.Stratifier>> =
      ListSerializer(Hoisted.stratifierSerInner)
  }
}

internal object MeasureGroupPopulationSerializer : KSerializer<Measure.Group.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("criteria", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Measure.Group.Population =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Population) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Measure.Group.Population {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var criteria: Expression? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> description = decoder.decodeStringElement(__desc, 4)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.descriptionSer, null)
        6 ->
          criteria = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.criteriaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + __i)
      }
    }
    return Measure.Group.Population(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      description = R4bString.of(description, _description),
      criteria = criteria!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Measure.Group.Population) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.descriptionSer, it)
    }
    (value.criteria)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.criteriaSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val criteriaSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object MeasureGroupStratifierSerializer : KSerializer<Measure.Group.Stratifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratifier") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("criteria", Expression.serializer().descriptor, isOptional = true)
      element(
        "component",
        listSerialDescriptor(
          lazyDescriptor { Measure.Group.Stratifier.Component.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Measure.Group.Stratifier =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Stratifier) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Measure.Group.Stratifier {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var criteria: Expression? = null
    var component: List<Measure.Group.Stratifier.Component>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> description = decoder.decodeStringElement(__desc, 4)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.descriptionSer, null)
        6 ->
          criteria = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.criteriaSer, null)
        7 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.componentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Stratifier: " + __i)
      }
    }
    return Measure.Group.Stratifier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      description = R4bString.of(description, _description),
      criteria = criteria,
      component = component ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Measure.Group.Stratifier) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.descriptionSer, it)
    }
    (value.criteria)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.criteriaSer, it) }
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.componentSer, value.component)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val criteriaSer: KSerializer<Expression> = Expression.serializer()

    public val componentSerInner: KSerializer<Measure.Group.Stratifier.Component> =
      Measure.Group.Stratifier.Component.serializer()

    public val componentSer: KSerializer<List<Measure.Group.Stratifier.Component>> =
      ListSerializer(Hoisted.componentSerInner)
  }
}

internal object MeasureGroupStratifierComponentSerializer :
  KSerializer<Measure.Group.Stratifier.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("criteria", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Measure.Group.Stratifier.Component =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Stratifier.Component) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Measure.Group.Stratifier.Component {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var criteria: Expression? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> description = decoder.decodeStringElement(__desc, 4)
        5 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.descriptionSer, null)
        6 ->
          criteria = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.criteriaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + __i)
      }
    }
    return Measure.Group.Stratifier.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      description = R4bString.of(description, _description),
      criteria = criteria!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Measure.Group.Stratifier.Component,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.descriptionSer, it)
    }
    (value.criteria)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.criteriaSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val criteriaSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object MeasureSupplementalDataSerializer : KSerializer<Measure.SupplementalData> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupplementalData") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "usage",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("criteria", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Measure.SupplementalData =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Measure.SupplementalData) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Measure.SupplementalData {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var usage: List<CodeableConcept>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var criteria: Expression? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> usage = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.usageSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        7 ->
          criteria = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.criteriaSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupplementalData: " + __i)
      }
    }
    return Measure.SupplementalData(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      usage = usage ?: listOf(),
      description = R4bString.of(description, _description),
      criteria = criteria!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Measure.SupplementalData) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    if (value.usage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.usageSer, value.usage)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    (value.criteria)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.criteriaSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val usageSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSer)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val criteriaSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object MeasureSubjectSerializer : KSerializer<Measure.Subject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Measure.Subject") {
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Measure.Subject) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Measure.Subject.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.subjectCodeableConceptSer, __d.value)
        }
        is Measure.Subject.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Measure.Subject =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Measure.Subject {
    val __desc = descriptor
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        1 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.subjectReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Measure.Subject: " + __i)
      }
    }
    return Measure.Subject.from(subjectCodeableConcept, subjectReference)!!
  }

  private object Hoisted {
    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MeasureSerializer : KSerializer<Measure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Measure") {
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
      element("_subtitle", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("subjectCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subjectReference", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("usage", KotlinString.serializer().descriptor, isOptional = true)
      element("_usage", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_approvalDate", Element.serializer().descriptor, isOptional = true)
      element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "topic",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "author",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "editor",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewer",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "endorser",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "library",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_library", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("disclaimer", KotlinString.serializer().descriptor, isOptional = true)
      element("_disclaimer", Element.serializer().descriptor, isOptional = true)
      element("scoring", CodeableConcept.serializer().descriptor, isOptional = true)
      element("compositeScoring", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("riskAdjustment", KotlinString.serializer().descriptor, isOptional = true)
      element("_riskAdjustment", Element.serializer().descriptor, isOptional = true)
      element("rateAggregation", KotlinString.serializer().descriptor, isOptional = true)
      element("_rateAggregation", Element.serializer().descriptor, isOptional = true)
      element("rationale", KotlinString.serializer().descriptor, isOptional = true)
      element("_rationale", Element.serializer().descriptor, isOptional = true)
      element(
        "clinicalRecommendationStatement",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element(
        "_clinicalRecommendationStatement",
        Element.serializer().descriptor,
        isOptional = true,
      )
      element("improvementNotation", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "definition",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_definition",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("guidance", KotlinString.serializer().descriptor, isOptional = true)
      element("_guidance", Element.serializer().descriptor, isOptional = true)
      element(
        "group",
        listSerialDescriptor(lazyDescriptor { Measure.Group.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "supplementalData",
        listSerialDescriptor(lazyDescriptor { Measure.SupplementalData.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Measure =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Measure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Measure {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
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
    var disclaimer: KotlinString? = null
    var _disclaimer: Element? = null
    var scoring: CodeableConcept? = null
    var compositeScoring: CodeableConcept? = null
    var type: List<CodeableConcept>? = null
    var riskAdjustment: KotlinString? = null
    var _riskAdjustment: Element? = null
    var rateAggregation: KotlinString? = null
    var _rateAggregation: Element? = null
    var rationale: KotlinString? = null
    var _rationale: Element? = null
    var clinicalRecommendationStatement: KotlinString? = null
    var _clinicalRecommendationStatement: Element? = null
    var improvementNotation: CodeableConcept? = null
    var definition: List<KotlinString?>? = null
    var _definition: List<Element?>? = null
    var guidance: KotlinString? = null
    var _guidance: Element? = null
    var group: List<Measure.Group>? = null
    var supplementalData: List<Measure.SupplementalData>? = null
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> name = decoder.decodeStringElement(__desc, 16)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> title = decoder.decodeStringElement(__desc, 18)
        19 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 -> subtitle = decoder.decodeStringElement(__desc, 20)
        21 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(__desc, 22)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(__desc, 24)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        27 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.subjectReferenceSer, null)
        28 -> date = decoder.decodeStringElement(__desc, 28)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> publisher = decoder.decodeStringElement(__desc, 30)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.contactSer, null)
        33 -> description = decoder.decodeStringElement(__desc, 33)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.useContextSer, null)
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.jurisdictionSer, null)
        37 -> purpose = decoder.decodeStringElement(__desc, 37)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 -> usage = decoder.decodeStringElement(__desc, 39)
        40 ->
          _usage =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.implicitRulesSer, null)
        41 -> copyright = decoder.decodeStringElement(__desc, 41)
        42 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.implicitRulesSer, null)
        43 -> approvalDate = decoder.decodeStringElement(__desc, 43)
        44 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.implicitRulesSer, null)
        45 -> lastReviewDate = decoder.decodeStringElement(__desc, 45)
        46 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.implicitRulesSer, null)
        47 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.effectivePeriodSer, null)
        48 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.jurisdictionSer, null)
        49 ->
          author = decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.contactSer, null)
        50 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.contactSer, null)
        51 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.contactSer, null)
        52 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.contactSer, null)
        53 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.relatedArtifactSer, null)
        54 ->
          library = decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.librarySer, null)
        55 ->
          _library =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.librarySer2, null)
        56 -> disclaimer = decoder.decodeStringElement(__desc, 56)
        57 ->
          _disclaimer =
            decoder.decodeNullableSerializableElement(__desc, 57, Hoisted.implicitRulesSer, null)
        58 ->
          scoring =
            decoder.decodeNullableSerializableElement(
              __desc,
              58,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        59 ->
          compositeScoring =
            decoder.decodeNullableSerializableElement(
              __desc,
              59,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        60 ->
          type =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.jurisdictionSer, null)
        61 -> riskAdjustment = decoder.decodeStringElement(__desc, 61)
        62 ->
          _riskAdjustment =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.implicitRulesSer, null)
        63 -> rateAggregation = decoder.decodeStringElement(__desc, 63)
        64 ->
          _rateAggregation =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.implicitRulesSer, null)
        65 -> rationale = decoder.decodeStringElement(__desc, 65)
        66 ->
          _rationale =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.implicitRulesSer, null)
        67 -> clinicalRecommendationStatement = decoder.decodeStringElement(__desc, 67)
        68 ->
          _clinicalRecommendationStatement =
            decoder.decodeNullableSerializableElement(__desc, 68, Hoisted.implicitRulesSer, null)
        69 ->
          improvementNotation =
            decoder.decodeNullableSerializableElement(
              __desc,
              69,
              Hoisted.subjectCodeableConceptSer,
              null,
            )
        70 ->
          definition =
            decoder.decodeNullableSerializableElement(__desc, 70, Hoisted.librarySer, null)
        71 ->
          _definition =
            decoder.decodeNullableSerializableElement(__desc, 71, Hoisted.librarySer2, null)
        72 -> guidance = decoder.decodeStringElement(__desc, 72)
        73 ->
          _guidance =
            decoder.decodeNullableSerializableElement(__desc, 73, Hoisted.implicitRulesSer, null)
        74 -> group = decoder.decodeNullableSerializableElement(__desc, 74, Hoisted.groupSer, null)
        75 ->
          supplementalData =
            decoder.decodeNullableSerializableElement(__desc, 75, Hoisted.supplementalDataSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Measure: " + __i)
      }
    }
    return Measure(
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      subtitle = R4bString.of(subtitle, _subtitle),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4bBoolean.of(experimental, _experimental),
      subject = Measure.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4bString.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
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
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { __i ->
          Canonical.of(library?.getOrNull(__i)?.let { it }, _library?.getOrNull(__i))!!
        }),
      disclaimer = Markdown.of(disclaimer, _disclaimer),
      scoring = scoring,
      compositeScoring = compositeScoring,
      type = type ?: listOf(),
      riskAdjustment = R4bString.of(riskAdjustment, _riskAdjustment),
      rateAggregation = R4bString.of(rateAggregation, _rateAggregation),
      rationale = Markdown.of(rationale, _rationale),
      clinicalRecommendationStatement =
        Markdown.of(clinicalRecommendationStatement, _clinicalRecommendationStatement),
      improvementNotation = improvementNotation,
      definition =
        (kotlin.collections.List(maxOf(definition?.size ?: 0, _definition?.size ?: 0)) { __i ->
          Markdown.of(definition?.getOrNull(__i)?.let { it }, _definition?.getOrNull(__i))!!
        }),
      guidance = Markdown.of(guidance, _guidance),
      group = group ?: listOf(),
      supplementalData = supplementalData ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Measure) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Measure")
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    ((value.subtitle?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 24, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.subject) {
      null -> {}
      is Measure.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 26, Hoisted.subjectCodeableConceptSer, __d.value)
      }
      is Measure.Subject.Reference -> {
        encoder.encodeSerializableElement(__desc, 27, Hoisted.subjectReferenceSer, __d.value)
      }
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
    }
    ((value.usage?.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
    (value.usage?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 41, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 43, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 45, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        53,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 54, Hoisted.librarySer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 55, Hoisted.librarySer2, it)
    }
    ((value.disclaimer?.value))?.let { encoder.encodeStringElement(__desc, 56, it) }
    (value.disclaimer?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 57, Hoisted.implicitRulesSer, it)
    }
    (value.scoring)?.let {
      encoder.encodeSerializableElement(__desc, 58, Hoisted.subjectCodeableConceptSer, it)
    }
    (value.compositeScoring)?.let {
      encoder.encodeSerializableElement(__desc, 59, Hoisted.subjectCodeableConceptSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 60, Hoisted.jurisdictionSer, value.type)
    ((value.riskAdjustment?.value))?.let { encoder.encodeStringElement(__desc, 61, it) }
    (value.riskAdjustment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 62, Hoisted.implicitRulesSer, it)
    }
    ((value.rateAggregation?.value))?.let { encoder.encodeStringElement(__desc, 63, it) }
    (value.rateAggregation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 64, Hoisted.implicitRulesSer, it)
    }
    ((value.rationale?.value))?.let { encoder.encodeStringElement(__desc, 65, it) }
    (value.rationale?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 66, Hoisted.implicitRulesSer, it)
    }
    ((value.clinicalRecommendationStatement?.value))?.let {
      encoder.encodeStringElement(__desc, 67, it)
    }
    (value.clinicalRecommendationStatement?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 68, Hoisted.implicitRulesSer, it)
    }
    (value.improvementNotation)?.let {
      encoder.encodeSerializableElement(__desc, 69, Hoisted.subjectCodeableConceptSer, it)
    }
    (value.definition.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 70, Hoisted.librarySer, it)
    }
    (value.definition.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 71, Hoisted.librarySer2, it)
    }
    ((value.guidance?.value))?.let { encoder.encodeStringElement(__desc, 72, it) }
    (value.guidance?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 73, Hoisted.implicitRulesSer, it)
    }
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 74, Hoisted.groupSer, value.group)
    if (value.supplementalData.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        75,
        Hoisted.supplementalDataSer,
        value.supplementalData,
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

    public val subjectCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val subjectReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.subjectCodeableConceptSer)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val librarySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val librarySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.librarySerInner).nullable)

    public val librarySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val groupSerInner: KSerializer<Measure.Group> = Measure.Group.serializer()

    public val groupSer: KSerializer<List<Measure.Group>> = ListSerializer(Hoisted.groupSerInner)

    public val supplementalDataSerInner: KSerializer<Measure.SupplementalData> =
      Measure.SupplementalData.serializer()

    public val supplementalDataSer: KSerializer<List<Measure.SupplementalData>> =
      ListSerializer(Hoisted.supplementalDataSerInner)
  }
}

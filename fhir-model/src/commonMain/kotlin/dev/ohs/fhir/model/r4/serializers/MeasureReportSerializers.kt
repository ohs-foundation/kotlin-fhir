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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.MeasureReport
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.String
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

internal object MeasureReportGroupSerializer : KSerializer<MeasureReport.Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "population",
        listSerialDescriptor(
          lazyDescriptor { MeasureReport.Group.Population.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("measureScore", Quantity.serializer().descriptor, isOptional = true)
      element(
        "stratifier",
        listSerialDescriptor(
          lazyDescriptor { MeasureReport.Group.Stratifier.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MeasureReport.Group {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var population: List<MeasureReport.Group.Population>? = null
    var measureScore: Quantity? = null
    var stratifier: List<MeasureReport.Group.Stratifier>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.populationSer, null)
        5 ->
          measureScore =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.measureScoreSer, null)
        6 ->
          stratifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.stratifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Group: " + __i)
      }
    }
    return MeasureReport.Group(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      population = population ?: listOf(),
      measureScore = measureScore,
      stratifier = stratifier ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MeasureReport.Group) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.populationSer, value.population)
    (value.measureScore)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.measureScoreSer, it)
    }
    if (value.stratifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.stratifierSer, value.stratifier)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val populationSerInner: KSerializer<MeasureReport.Group.Population> =
      MeasureReport.Group.Population.serializer()

    public val populationSer: KSerializer<List<MeasureReport.Group.Population>> =
      ListSerializer(Hoisted.populationSerInner)

    public val measureScoreSer: KSerializer<Quantity> = Quantity.serializer()

    public val stratifierSerInner: KSerializer<MeasureReport.Group.Stratifier> =
      MeasureReport.Group.Stratifier.serializer()

    public val stratifierSer: KSerializer<List<MeasureReport.Group.Stratifier>> =
      ListSerializer(Hoisted.stratifierSerInner)
  }
}

internal object MeasureReportGroupPopulationSerializer :
  KSerializer<MeasureReport.Group.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("count", Int.serializer().descriptor, isOptional = true)
      element("_count", Element.serializer().descriptor, isOptional = true)
      element("subjectResults", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Population =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Population) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MeasureReport.Group.Population {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var count: Int? = null
    var _count: Element? = null
    var subjectResults: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 -> count = decoder.decodeIntElement(__desc, __i)
        5 -> _count = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        6 ->
          subjectResults =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectResultsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + __i)
      }
    }
    return MeasureReport.Group.Population(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      count = Integer.of(count, _count),
      subjectResults = subjectResults,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MeasureReport.Group.Population) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 4, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.countSer, it)
    }
    (value.subjectResults)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.subjectResultsSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val countSer: KSerializer<Element> = Element.serializer()

    public val subjectResultsSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MeasureReportGroupStratifierSerializer :
  KSerializer<MeasureReport.Group.Stratifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratifier") {
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
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "stratum",
        listSerialDescriptor(
          lazyDescriptor { MeasureReport.Group.Stratifier.Stratum.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MeasureReport.Group.Stratifier {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: List<CodeableConcept>? = null
    var stratum: List<MeasureReport.Group.Stratifier.Stratum>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          stratum = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.stratumSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Stratifier: " + __i)
      }
    }
    return MeasureReport.Group.Stratifier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code ?: listOf(),
      stratum = stratum ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MeasureReport.Group.Stratifier) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, value.code)
    if (value.stratum.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.stratumSer, value.stratum)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val stratumSerInner: KSerializer<MeasureReport.Group.Stratifier.Stratum> =
      MeasureReport.Group.Stratifier.Stratum.serializer()

    public val stratumSer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum>> =
      ListSerializer(Hoisted.stratumSerInner)
  }
}

internal object MeasureReportGroupStratifierStratumSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratum") {
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
      element("value", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "component",
        listSerialDescriptor(
          lazyDescriptor {
            MeasureReport.Group.Stratifier.Stratum.Component.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "population",
        listSerialDescriptor(
          lazyDescriptor {
            MeasureReport.Group.Stratifier.Stratum.Population.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element("measureScore", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MeasureReport.Group.Stratifier.Stratum {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `value`: CodeableConcept? = null
    var component: List<MeasureReport.Group.Stratifier.Stratum.Component>? = null
    var population: List<MeasureReport.Group.Stratifier.Stratum.Population>? = null
    var measureScore: Quantity? = null
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
          `value` = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSer, null)
        4 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.componentSer, null)
        5 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.populationSer, null)
        6 ->
          measureScore =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.measureScoreSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Stratum: " + __i)
      }
    }
    return MeasureReport.Group.Stratifier.Stratum(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` = `value`,
      component = component ?: listOf(),
      population = population ?: listOf(),
      measureScore = measureScore,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.`value`)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.valueSer, it) }
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.componentSer, value.component)
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.populationSer, value.population)
    (value.measureScore)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.measureScoreSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val componentSerInner: KSerializer<MeasureReport.Group.Stratifier.Stratum.Component> =
      MeasureReport.Group.Stratifier.Stratum.Component.serializer()

    public val componentSer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Component>> =
      ListSerializer(Hoisted.componentSerInner)

    public val populationSerInner: KSerializer<MeasureReport.Group.Stratifier.Stratum.Population> =
      MeasureReport.Group.Stratifier.Stratum.Population.serializer()

    public val populationSer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Population>> =
      ListSerializer(Hoisted.populationSerInner)

    public val measureScoreSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object MeasureReportGroupStratifierStratumComponentSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("value", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Component =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MeasureReport.Group.Stratifier.Stratum.Component {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var `value`: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 -> `value` = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + __i)
      }
    }
    return MeasureReport.Group.Stratifier.Stratum.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      `value` = `value`!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.`value`)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object MeasureReportGroupStratifierStratumPopulationSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("count", Int.serializer().descriptor, isOptional = true)
      element("_count", Element.serializer().descriptor, isOptional = true)
      element("subjectResults", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Population =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MeasureReport.Group.Stratifier.Stratum.Population {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var count: Int? = null
    var _count: Element? = null
    var subjectResults: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 -> count = decoder.decodeIntElement(__desc, __i)
        5 -> _count = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        6 ->
          subjectResults =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectResultsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + __i)
      }
    }
    return MeasureReport.Group.Stratifier.Stratum.Population(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      count = Integer.of(count, _count),
      subjectResults = subjectResults,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 4, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.countSer, it)
    }
    (value.subjectResults)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.subjectResultsSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val countSer: KSerializer<Element> = Element.serializer()

    public val subjectResultsSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MeasureReportSerializer : KSerializer<MeasureReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MeasureReport") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("type", String.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("measure", String.serializer().descriptor, isOptional = true)
    b.element("_measure", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("date", String.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("reporter", Reference.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("improvementNotation", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "group",
      listSerialDescriptor(lazyDescriptor { MeasureReport.Group.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "evaluatedResource",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MeasureReport =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MeasureReport")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): MeasureReport {
    val __desc = desc
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
    var status: String? = null
    var _status: Element? = null
    var type: String? = null
    var _type: Element? = null
    var measure: String? = null
    var _measure: Element? = null
    var subject: Reference? = null
    var date: String? = null
    var _date: Element? = null
    var reporter: Reference? = null
    var period: Period? = null
    var improvementNotation: CodeableConcept? = null
    var group: List<MeasureReport.Group>? = null
    var evaluatedResource: List<Reference>? = null
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
        13 -> type = decoder.decodeStringElement(__desc, __i)
        14 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> measure = decoder.decodeStringElement(__desc, __i)
        16 ->
          _measure =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        18 -> date = decoder.decodeStringElement(__desc, __i)
        19 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 ->
          reporter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        21 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        22 ->
          improvementNotation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.improvementNotationSer,
              null,
            )
        23 -> group = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.groupSer, null)
        24 ->
          evaluatedResource =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.evaluatedResourceSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MeasureReport: " + __i)
      }
    }
    return MeasureReport(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(MeasureReport.MeasureReportStatus.fromCode(status!!), _status),
      type = Enumeration.of(MeasureReport.MeasureReportType.fromCode(type!!), _type),
      measure = Canonical.of(measure, _measure)!!,
      subject = subject,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      reporter = reporter,
      period = period!!,
      improvementNotation = improvementNotation,
      group = group ?: listOf(),
      evaluatedResource = evaluatedResource ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: MeasureReport,
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
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.measure.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.measure.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.subjectSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.reporter)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.subjectSer, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.periodSer, it)
    }
    (value.improvementNotation)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.improvementNotationSer, it)
    }
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.groupSer, value.group)
    if (value.evaluatedResource.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24 + __off,
        Hoisted.evaluatedResourceSer,
        value.evaluatedResource,
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

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val improvementNotationSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val groupSerInner: KSerializer<MeasureReport.Group> = MeasureReport.Group.serializer()

    public val groupSer: KSerializer<List<MeasureReport.Group>> =
      ListSerializer(Hoisted.groupSerInner)

    public val evaluatedResourceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.subjectSer)
  }
}

internal object MeasureReportPolymorphicSerializer : KSerializer<MeasureReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MeasureReport") { MeasureReportSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport) {
    encoder.encodeStructure(descriptor) {
      MeasureReportSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MeasureReport =
    decoder.decodeStructure(descriptor) {
      MeasureReportSerializer.deserializeJson(this, descriptor, 0)
    }
}

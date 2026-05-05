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
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.RiskEvidenceSynthesis
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object RiskEvidenceSynthesisSampleSizeSerializer :
  KSerializer<RiskEvidenceSynthesis.SampleSize> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SampleSize") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("numberOfStudies", Int.serializer().descriptor, isOptional = true)
      element("_numberOfStudies", Element.serializer().descriptor, isOptional = true)
      element("numberOfParticipants", Int.serializer().descriptor, isOptional = true)
      element("_numberOfParticipants", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis.SampleSize =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis.SampleSize) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RiskEvidenceSynthesis.SampleSize {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var numberOfStudies: Int? = null
    var _numberOfStudies: Element? = null
    var numberOfParticipants: Int? = null
    var _numberOfParticipants: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, __i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        5 -> numberOfStudies = decoder.decodeIntElement(__desc, __i)
        6 ->
          _numberOfStudies =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        7 -> numberOfParticipants = decoder.decodeIntElement(__desc, __i)
        8 ->
          _numberOfParticipants =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampleSize: " + __i)
      }
    }
    return RiskEvidenceSynthesis.SampleSize(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      numberOfStudies = Integer.of(numberOfStudies, _numberOfStudies),
      numberOfParticipants = Integer.of(numberOfParticipants, _numberOfParticipants),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RiskEvidenceSynthesis.SampleSize) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    ((value.numberOfStudies?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.numberOfStudies?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    ((value.numberOfParticipants?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.numberOfParticipants?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object RiskEvidenceSynthesisRiskEstimateSerializer :
  KSerializer<RiskEvidenceSynthesis.RiskEstimate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskEstimate") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("value", BigDecimalSerializer.descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
      element("unitOfMeasure", CodeableConcept.serializer().descriptor, isOptional = true)
      element("denominatorCount", Int.serializer().descriptor, isOptional = true)
      element("_denominatorCount", Element.serializer().descriptor, isOptional = true)
      element("numeratorCount", Int.serializer().descriptor, isOptional = true)
      element("_numeratorCount", Element.serializer().descriptor, isOptional = true)
      element(
        "precisionEstimate",
        listSerialDescriptor(
          lazyDescriptor {
            RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis.RiskEstimate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis.RiskEstimate) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RiskEvidenceSynthesis.RiskEstimate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var type: CodeableConcept? = null
    var `value`: BigDecimal? = null
    var _value: Element? = null
    var unitOfMeasure: CodeableConcept? = null
    var denominatorCount: Int? = null
    var _denominatorCount: Element? = null
    var numeratorCount: Int? = null
    var _numeratorCount: Element? = null
    var precisionEstimate: List<RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, __i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 ->
          `value` =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        7 ->
          _value =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        8 ->
          unitOfMeasure =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        9 -> denominatorCount = decoder.decodeIntElement(__desc, __i)
        10 ->
          _denominatorCount =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        11 -> numeratorCount = decoder.decodeIntElement(__desc, __i)
        12 ->
          _numeratorCount =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        13 ->
          precisionEstimate =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.precisionEstimateSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RiskEstimate: " + __i)
      }
    }
    return RiskEvidenceSynthesis.RiskEstimate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      type = type,
      `value` = Decimal.of(`value`, _value),
      unitOfMeasure = unitOfMeasure,
      denominatorCount = Integer.of(denominatorCount, _denominatorCount),
      numeratorCount = Integer.of(numeratorCount, _numeratorCount),
      precisionEstimate = precisionEstimate ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: RiskEvidenceSynthesis.RiskEstimate,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    ((value.`value`?.value))?.let {
      encoder.encodeSerializableElement(__desc, 6, BigDecimalSerializer, it)
    }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.descriptionSer, it)
    }
    (value.unitOfMeasure)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it) }
    ((value.denominatorCount?.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
    (value.denominatorCount?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.descriptionSer, it)
    }
    ((value.numeratorCount?.value))?.let { encoder.encodeIntElement(__desc, 11, it) }
    (value.numeratorCount?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.descriptionSer, it)
    }
    if (value.precisionEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        13,
        Hoisted.precisionEstimateSer,
        value.precisionEstimate,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val precisionEstimateSerInner:
      KSerializer<RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate> =
      RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate.serializer()

    public val precisionEstimateSer:
      KSerializer<List<RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate>> =
      ListSerializer(Hoisted.precisionEstimateSerInner)
  }
}

internal object RiskEvidenceSynthesisRiskEstimatePrecisionEstimateSerializer :
  KSerializer<RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PrecisionEstimate") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("level", BigDecimalSerializer.descriptor, isOptional = true)
      element("_level", Element.serializer().descriptor, isOptional = true)
      element("from", BigDecimalSerializer.descriptor, isOptional = true)
      element("_from", Element.serializer().descriptor, isOptional = true)
      element("to", BigDecimalSerializer.descriptor, isOptional = true)
      element("_to", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var level: BigDecimal? = null
    var _level: Element? = null
    var from: BigDecimal? = null
    var _from: Element? = null
    var to: BigDecimal? = null
    var _to: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          level = decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        5 -> _level = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.levelSer, null)
        6 ->
          from = decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        7 -> _from = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.levelSer, null)
        8 -> to = decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        9 -> _to = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.levelSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PrecisionEstimate: " + __i)
      }
    }
    return RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      level = Decimal.of(level, _level),
      from = Decimal.of(from, _from),
      to = Decimal.of(to, _to),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    ((value.level?.value))?.let {
      encoder.encodeSerializableElement(__desc, 4, BigDecimalSerializer, it)
    }
    (value.level?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.levelSer, it)
    }
    ((value.from?.value))?.let {
      encoder.encodeSerializableElement(__desc, 6, BigDecimalSerializer, it)
    }
    (value.from?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.levelSer, it)
    }
    ((value.to?.value))?.let {
      encoder.encodeSerializableElement(__desc, 8, BigDecimalSerializer, it)
    }
    (value.to?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.levelSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val levelSer: KSerializer<Element> = Element.serializer()
  }
}

internal object RiskEvidenceSynthesisCertaintySerializer :
  KSerializer<RiskEvidenceSynthesis.Certainty> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Certainty") {
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
      element(
        "rating",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "certaintySubcomponent",
        listSerialDescriptor(
          lazyDescriptor {
            RiskEvidenceSynthesis.Certainty.CertaintySubcomponent.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis.Certainty =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis.Certainty) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RiskEvidenceSynthesis.Certainty {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var rating: List<CodeableConcept>? = null
    var note: List<Annotation>? = null
    var certaintySubcomponent: List<RiskEvidenceSynthesis.Certainty.CertaintySubcomponent>? = null
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
          rating = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ratingSer, null)
        4 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        5 ->
          certaintySubcomponent =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.certaintySubcomponentSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Certainty: " + __i)
      }
    }
    return RiskEvidenceSynthesis.Certainty(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      rating = rating ?: listOf(),
      note = note ?: listOf(),
      certaintySubcomponent = certaintySubcomponent ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RiskEvidenceSynthesis.Certainty) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.rating.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.ratingSer, value.rating)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.noteSer, value.note)
    if (value.certaintySubcomponent.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        5,
        Hoisted.certaintySubcomponentSer,
        value.certaintySubcomponent,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val ratingSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val ratingSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.ratingSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val certaintySubcomponentSerInner:
      KSerializer<RiskEvidenceSynthesis.Certainty.CertaintySubcomponent> =
      RiskEvidenceSynthesis.Certainty.CertaintySubcomponent.serializer()

    public val certaintySubcomponentSer:
      KSerializer<List<RiskEvidenceSynthesis.Certainty.CertaintySubcomponent>> =
      ListSerializer(Hoisted.certaintySubcomponentSerInner)
  }
}

internal object RiskEvidenceSynthesisCertaintyCertaintySubcomponentSerializer :
  KSerializer<RiskEvidenceSynthesis.Certainty.CertaintySubcomponent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CertaintySubcomponent") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "rating",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): RiskEvidenceSynthesis.Certainty.CertaintySubcomponent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: RiskEvidenceSynthesis.Certainty.CertaintySubcomponent,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): RiskEvidenceSynthesis.Certainty.CertaintySubcomponent {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var rating: List<CodeableConcept>? = null
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
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          rating = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ratingSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding CertaintySubcomponent: " + __i)
      }
    }
    return RiskEvidenceSynthesis.Certainty.CertaintySubcomponent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      rating = rating ?: listOf(),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: RiskEvidenceSynthesis.Certainty.CertaintySubcomponent,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    if (value.rating.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.ratingSer, value.rating)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val ratingSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object RiskEvidenceSynthesisSerializer : KSerializer<RiskEvidenceSynthesis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskEvidenceSynthesis") {
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
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
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
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
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
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
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
    b.element("synthesisType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("studyType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("population", Reference.serializer().descriptor, isOptional = true)
    b.element("exposure", Reference.serializer().descriptor, isOptional = true)
    b.element("outcome", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "sampleSize",
      lazyDescriptor { RiskEvidenceSynthesis.SampleSize.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "riskEstimate",
      lazyDescriptor { RiskEvidenceSynthesis.RiskEstimate.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "certainty",
      listSerialDescriptor(
        lazyDescriptor { RiskEvidenceSynthesis.Certainty.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "RiskEvidenceSynthesis")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): RiskEvidenceSynthesis {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
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
    var synthesisType: CodeableConcept? = null
    var studyType: CodeableConcept? = null
    var population: Reference? = null
    var exposure: Reference? = null
    var outcome: Reference? = null
    var sampleSize: RiskEvidenceSynthesis.SampleSize? = null
    var riskEstimate: RiskEvidenceSynthesis.RiskEstimate? = null
    var certainty: List<RiskEvidenceSynthesis.Certainty>? = null
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
        10 -> url = decoder.decodeStringElement(__desc, __i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(__desc, __i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(__desc, __i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(__desc, __i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> status = decoder.decodeStringElement(__desc, __i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> date = decoder.decodeStringElement(__desc, __i)
        22 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> publisher = decoder.decodeStringElement(__desc, __i)
        24 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        26 -> description = decoder.decodeStringElement(__desc, __i)
        27 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        29 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useContextSer, null)
        30 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        31 -> copyright = decoder.decodeStringElement(__desc, __i)
        32 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        33 -> approvalDate = decoder.decodeStringElement(__desc, __i)
        34 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        35 -> lastReviewDate = decoder.decodeStringElement(__desc, __i)
        36 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        37 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectivePeriodSer, null)
        38 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        39 ->
          author = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        40 ->
          editor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        41 ->
          reviewer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        42 ->
          endorser =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        43 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relatedArtifactSer, null)
        44 ->
          synthesisType =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.jurisdictionSerInner,
              null,
            )
        45 ->
          studyType =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.jurisdictionSerInner,
              null,
            )
        46 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.populationSer, null)
        47 ->
          exposure =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.populationSer, null)
        48 ->
          outcome =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.populationSer, null)
        49 ->
          sampleSize =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.sampleSizeSer, null)
        50 ->
          riskEstimate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.riskEstimateSer, null)
        51 ->
          certainty =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.certaintySer, null)
        else ->
          throw SerializationException("Unexpected index decoding RiskEvidenceSynthesis: " + __i)
      }
    }
    return RiskEvidenceSynthesis(
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
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
      synthesisType = synthesisType,
      studyType = studyType,
      population = population!!,
      exposure = exposure,
      outcome = outcome!!,
      sampleSize = sampleSize,
      riskEstimate = riskEstimate,
      certainty = certainty ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: RiskEvidenceSynthesis,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 23 + __off, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 26 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.noteSer, value.note)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30 + __off,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 31 + __off, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 33 + __off, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 35 + __off, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        43 + __off,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.synthesisType)?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.jurisdictionSerInner, it)
    }
    (value.studyType)?.let {
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.jurisdictionSerInner, it)
    }
    (value.population)?.let {
      encoder.encodeSerializableElement(__desc, 46 + __off, Hoisted.populationSer, it)
    }
    (value.exposure)?.let {
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.populationSer, it)
    }
    (value.outcome)?.let {
      encoder.encodeSerializableElement(__desc, 48 + __off, Hoisted.populationSer, it)
    }
    (value.sampleSize)?.let {
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.sampleSizeSer, it)
    }
    (value.riskEstimate)?.let {
      encoder.encodeSerializableElement(__desc, 50 + __off, Hoisted.riskEstimateSer, it)
    }
    if (value.certainty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51 + __off, Hoisted.certaintySer, value.certainty)
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

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val populationSer: KSerializer<Reference> = Reference.serializer()

    public val sampleSizeSer: KSerializer<RiskEvidenceSynthesis.SampleSize> =
      RiskEvidenceSynthesis.SampleSize.serializer()

    public val riskEstimateSer: KSerializer<RiskEvidenceSynthesis.RiskEstimate> =
      RiskEvidenceSynthesis.RiskEstimate.serializer()

    public val certaintySerInner: KSerializer<RiskEvidenceSynthesis.Certainty> =
      RiskEvidenceSynthesis.Certainty.serializer()

    public val certaintySer: KSerializer<List<RiskEvidenceSynthesis.Certainty>> =
      ListSerializer(Hoisted.certaintySerInner)
  }
}

internal object RiskEvidenceSynthesisPolymorphicSerializer : KSerializer<RiskEvidenceSynthesis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskEvidenceSynthesis") {
      RiskEvidenceSynthesisSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis) {
    encoder.encodeStructure(descriptor) {
      RiskEvidenceSynthesisSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis =
    decoder.decodeStructure(descriptor) {
      RiskEvidenceSynthesisSerializer.deserializeJson(this, descriptor, 0)
    }
}

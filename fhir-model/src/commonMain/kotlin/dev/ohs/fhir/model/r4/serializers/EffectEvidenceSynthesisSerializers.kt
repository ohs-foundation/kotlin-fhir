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
import dev.ohs.fhir.model.r4.EffectEvidenceSynthesis
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
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object EffectEvidenceSynthesisSampleSizeSerializer :
  KSerializer<EffectEvidenceSynthesis.SampleSize> {
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

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.SampleSize =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.SampleSize) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EffectEvidenceSynthesis.SampleSize {
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> numberOfStudies = decoder.decodeIntElement(__desc, 5)
        6 ->
          _numberOfStudies =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        7 -> numberOfParticipants = decoder.decodeIntElement(__desc, 7)
        8 ->
          _numberOfParticipants =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SampleSize: " + __i)
      }
    }
    return EffectEvidenceSynthesis.SampleSize(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      numberOfStudies = Integer.of(numberOfStudies, _numberOfStudies),
      numberOfParticipants = Integer.of(numberOfParticipants, _numberOfParticipants),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: EffectEvidenceSynthesis.SampleSize,
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

internal object EffectEvidenceSynthesisResultsByExposureSerializer :
  KSerializer<EffectEvidenceSynthesis.ResultsByExposure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResultsByExposure") {
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
      element("exposureState", KotlinString.serializer().descriptor, isOptional = true)
      element("_exposureState", Element.serializer().descriptor, isOptional = true)
      element("variantState", CodeableConcept.serializer().descriptor, isOptional = true)
      element("riskEvidenceSynthesis", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.ResultsByExposure =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.ResultsByExposure) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): EffectEvidenceSynthesis.ResultsByExposure {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var exposureState: KotlinString? = null
    var _exposureState: Element? = null
    var variantState: CodeableConcept? = null
    var riskEvidenceSynthesis: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> exposureState = decoder.decodeStringElement(__desc, 5)
        6 ->
          _exposureState =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        7 ->
          variantState =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.variantStateSer, null)
        8 ->
          riskEvidenceSynthesis =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.riskEvidenceSynthesisSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ResultsByExposure: " + __i)
      }
    }
    return EffectEvidenceSynthesis.ResultsByExposure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      exposureState =
        exposureState?.let {
          Enumeration.of(EffectEvidenceSynthesis.ExposureState.fromCode(it), _exposureState)
        },
      variantState = variantState,
      riskEvidenceSynthesis = riskEvidenceSynthesis!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: EffectEvidenceSynthesis.ResultsByExposure,
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
    ((value.exposureState?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.exposureState?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    (value.variantState)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.variantStateSer, it)
    }
    (value.riskEvidenceSynthesis)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.riskEvidenceSynthesisSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val variantStateSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val riskEvidenceSynthesisSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object EffectEvidenceSynthesisEffectEstimateSerializer :
  KSerializer<EffectEvidenceSynthesis.EffectEstimate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EffectEstimate") {
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
      element("variantState", CodeableConcept.serializer().descriptor, isOptional = true)
      element("value", BigDecimalSerializer.descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
      element("unitOfMeasure", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "precisionEstimate",
        listSerialDescriptor(
          lazyDescriptor {
            EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.EffectEstimate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.EffectEstimate) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EffectEvidenceSynthesis.EffectEstimate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var type: CodeableConcept? = null
    var variantState: CodeableConcept? = null
    var `value`: BigDecimal? = null
    var _value: Element? = null
    var unitOfMeasure: CodeableConcept? = null
    var precisionEstimate: List<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 ->
          variantState = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          `value` = decoder.decodeNullableSerializableElement(__desc, 7, BigDecimalSerializer, null)
        8 ->
          _value =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.descriptionSer, null)
        9 ->
          unitOfMeasure =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.typeSer, null)
        10 ->
          precisionEstimate =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.precisionEstimateSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EffectEstimate: " + __i)
      }
    }
    return EffectEvidenceSynthesis.EffectEstimate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      type = type,
      variantState = variantState,
      `value` = Decimal.of(`value`, _value),
      unitOfMeasure = unitOfMeasure,
      precisionEstimate = precisionEstimate ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: EffectEvidenceSynthesis.EffectEstimate,
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
    (value.variantState)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    ((value.`value`?.value))?.let {
      encoder.encodeSerializableElement(__desc, 7, BigDecimalSerializer, it)
    }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
    }
    (value.unitOfMeasure)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.typeSer, it) }
    if (value.precisionEstimate.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        10,
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
      KSerializer<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate> =
      EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate.serializer()

    public val precisionEstimateSer:
      KSerializer<List<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate>> =
      ListSerializer(Hoisted.precisionEstimateSerInner)
  }
}

internal object EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSerializer :
  KSerializer<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate> {
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

  override fun deserialize(
    decoder: Decoder
  ): EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate {
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          level = decoder.decodeNullableSerializableElement(__desc, 4, BigDecimalSerializer, null)
        5 -> _level = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.levelSer, null)
        6 -> from = decoder.decodeNullableSerializableElement(__desc, 6, BigDecimalSerializer, null)
        7 -> _from = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.levelSer, null)
        8 -> to = decoder.decodeNullableSerializableElement(__desc, 8, BigDecimalSerializer, null)
        9 -> _to = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.levelSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PrecisionEstimate: " + __i)
      }
    }
    return EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate(
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
    `value`: EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate,
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

internal object EffectEvidenceSynthesisCertaintySerializer :
  KSerializer<EffectEvidenceSynthesis.Certainty> {
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
            EffectEvidenceSynthesis.Certainty.CertaintySubcomponent.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.Certainty =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.Certainty) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EffectEvidenceSynthesis.Certainty {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var rating: List<CodeableConcept>? = null
    var note: List<Annotation>? = null
    var certaintySubcomponent: List<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> rating = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.ratingSer, null)
        4 -> note = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.noteSer, null)
        5 ->
          certaintySubcomponent =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.certaintySubcomponentSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Certainty: " + __i)
      }
    }
    return EffectEvidenceSynthesis.Certainty(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      rating = rating ?: listOf(),
      note = note ?: listOf(),
      certaintySubcomponent = certaintySubcomponent ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: EffectEvidenceSynthesis.Certainty) {
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
      KSerializer<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent> =
      EffectEvidenceSynthesis.Certainty.CertaintySubcomponent.serializer()

    public val certaintySubcomponentSer:
      KSerializer<List<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent>> =
      ListSerializer(Hoisted.certaintySubcomponentSerInner)
  }
}

internal object EffectEvidenceSynthesisCertaintyCertaintySubcomponentSerializer :
  KSerializer<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent> {
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
  ): EffectEvidenceSynthesis.Certainty.CertaintySubcomponent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: EffectEvidenceSynthesis.Certainty.CertaintySubcomponent,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): EffectEvidenceSynthesis.Certainty.CertaintySubcomponent {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var rating: List<CodeableConcept>? = null
    var note: List<Annotation>? = null
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
        4 -> rating = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.ratingSer, null)
        5 -> note = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding CertaintySubcomponent: " + __i)
      }
    }
    return EffectEvidenceSynthesis.Certainty.CertaintySubcomponent(
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
    `value`: EffectEvidenceSynthesis.Certainty.CertaintySubcomponent,
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

internal object EffectEvidenceSynthesisSerializer : KSerializer<EffectEvidenceSynthesis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EffectEvidenceSynthesis") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
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
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
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
      element("synthesisType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("studyType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("population", Reference.serializer().descriptor, isOptional = true)
      element("exposure", Reference.serializer().descriptor, isOptional = true)
      element("exposureAlternative", Reference.serializer().descriptor, isOptional = true)
      element("outcome", Reference.serializer().descriptor, isOptional = true)
      element(
        "sampleSize",
        lazyDescriptor { EffectEvidenceSynthesis.SampleSize.serializer().descriptor },
        isOptional = true,
      )
      element(
        "resultsByExposure",
        listSerialDescriptor(
          lazyDescriptor { EffectEvidenceSynthesis.ResultsByExposure.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "effectEstimate",
        listSerialDescriptor(
          lazyDescriptor { EffectEvidenceSynthesis.EffectEstimate.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "certainty",
        listSerialDescriptor(
          lazyDescriptor { EffectEvidenceSynthesis.Certainty.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): EffectEvidenceSynthesis {
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
    var exposureAlternative: Reference? = null
    var outcome: Reference? = null
    var sampleSize: EffectEvidenceSynthesis.SampleSize? = null
    var resultsByExposure: List<EffectEvidenceSynthesis.ResultsByExposure>? = null
    var effectEstimate: List<EffectEvidenceSynthesis.EffectEstimate>? = null
    var certainty: List<EffectEvidenceSynthesis.Certainty>? = null
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
        20 -> status = decoder.decodeStringElement(__desc, 20)
        21 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 -> date = decoder.decodeStringElement(__desc, 22)
        23 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> publisher = decoder.decodeStringElement(__desc, 24)
        25 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.contactSer, null)
        27 -> description = decoder.decodeStringElement(__desc, 27)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> note = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.noteSer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.useContextSer, null)
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.jurisdictionSer, null)
        32 -> copyright = decoder.decodeStringElement(__desc, 32)
        33 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 -> approvalDate = decoder.decodeStringElement(__desc, 34)
        35 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> lastReviewDate = decoder.decodeStringElement(__desc, 36)
        37 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.effectivePeriodSer, null)
        39 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.jurisdictionSer, null)
        40 ->
          author = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.contactSer, null)
        41 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.contactSer, null)
        42 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.contactSer, null)
        43 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.contactSer, null)
        44 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.relatedArtifactSer, null)
        45 ->
          synthesisType =
            decoder.decodeNullableSerializableElement(
              __desc,
              45,
              Hoisted.jurisdictionSerInner,
              null,
            )
        46 ->
          studyType =
            decoder.decodeNullableSerializableElement(
              __desc,
              46,
              Hoisted.jurisdictionSerInner,
              null,
            )
        47 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.populationSer, null)
        48 ->
          exposure =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.populationSer, null)
        49 ->
          exposureAlternative =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.populationSer, null)
        50 ->
          outcome =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.populationSer, null)
        51 ->
          sampleSize =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.sampleSizeSer, null)
        52 ->
          resultsByExposure =
            decoder.decodeNullableSerializableElement(
              __desc,
              52,
              Hoisted.resultsByExposureSer,
              null,
            )
        53 ->
          effectEstimate =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.effectEstimateSer, null)
        54 ->
          certainty =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.certaintySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding EffectEvidenceSynthesis: " + __i)
      }
    }
    return EffectEvidenceSynthesis(
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
      exposure = exposure!!,
      exposureAlternative = exposureAlternative!!,
      outcome = outcome!!,
      sampleSize = sampleSize,
      resultsByExposure = resultsByExposure ?: listOf(),
      effectEstimate = effectEstimate ?: listOf(),
      certainty = certainty ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: EffectEvidenceSynthesis) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "EffectEvidenceSynthesis")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.noteSer, value.note)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        44,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.synthesisType)?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.jurisdictionSerInner, it)
    }
    (value.studyType)?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.jurisdictionSerInner, it)
    }
    (value.population)?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.populationSer, it)
    }
    (value.exposure)?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.populationSer, it)
    }
    (value.exposureAlternative)?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.populationSer, it)
    }
    (value.outcome)?.let {
      encoder.encodeSerializableElement(__desc, 50, Hoisted.populationSer, it)
    }
    (value.sampleSize)?.let {
      encoder.encodeSerializableElement(__desc, 51, Hoisted.sampleSizeSer, it)
    }
    if (value.resultsByExposure.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        52,
        Hoisted.resultsByExposureSer,
        value.resultsByExposure,
      )
    if (value.effectEstimate.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.effectEstimateSer, value.effectEstimate)
    if (value.certainty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54, Hoisted.certaintySer, value.certainty)
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

    public val sampleSizeSer: KSerializer<EffectEvidenceSynthesis.SampleSize> =
      EffectEvidenceSynthesis.SampleSize.serializer()

    public val resultsByExposureSerInner: KSerializer<EffectEvidenceSynthesis.ResultsByExposure> =
      EffectEvidenceSynthesis.ResultsByExposure.serializer()

    public val resultsByExposureSer: KSerializer<List<EffectEvidenceSynthesis.ResultsByExposure>> =
      ListSerializer(Hoisted.resultsByExposureSerInner)

    public val effectEstimateSerInner: KSerializer<EffectEvidenceSynthesis.EffectEstimate> =
      EffectEvidenceSynthesis.EffectEstimate.serializer()

    public val effectEstimateSer: KSerializer<List<EffectEvidenceSynthesis.EffectEstimate>> =
      ListSerializer(Hoisted.effectEstimateSerInner)

    public val certaintySerInner: KSerializer<EffectEvidenceSynthesis.Certainty> =
      EffectEvidenceSynthesis.Certainty.serializer()

    public val certaintySer: KSerializer<List<EffectEvidenceSynthesis.Certainty>> =
      ListSerializer(Hoisted.certaintySerInner)
  }
}

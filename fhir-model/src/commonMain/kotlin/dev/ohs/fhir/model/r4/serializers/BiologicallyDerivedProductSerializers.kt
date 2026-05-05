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
import dev.ohs.fhir.model.r4.BiologicallyDerivedProduct
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
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object BiologicallyDerivedProductCollectionSerializer :
  KSerializer<BiologicallyDerivedProduct.Collection> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Collection") {
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
      element("collector", Reference.serializer().descriptor, isOptional = true)
      element("source", Reference.serializer().descriptor, isOptional = true)
      element("collectedDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_collectedDateTime", Element.serializer().descriptor, isOptional = true)
      element("collectedPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Collection =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Collection) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): BiologicallyDerivedProduct.Collection {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var collector: Reference? = null
    var source: Reference? = null
    var collectedDateTime: KotlinString? = null
    var _collectedDateTime: Element? = null
    var collectedPeriod: Period? = null
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
          collector =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.collectorSer, null)
        4 ->
          source =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.collectorSer, null)
        5 -> collectedDateTime = decoder.decodeStringElement(__desc, __i)
        6 ->
          _collectedDateTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.collectedDateTimeSer,
              null,
            )
        7 ->
          collectedPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.collectedPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Collection: " + __i)
      }
    }
    return BiologicallyDerivedProduct.Collection(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      collector = collector,
      source = source,
      collected =
        BiologicallyDerivedProduct.Collection.Collected.from(
          DateTime.of(FhirDateTime.fromString(collectedDateTime), _collectedDateTime),
          collectedPeriod,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProduct.Collection,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.collector)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.collectorSer, it)
    }
    (value.source)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.collectorSer, it) }
    when (val __d = value.collected) {
      null -> {}
      is BiologicallyDerivedProduct.Collection.Collected.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.collectedDateTimeSer, it)
        }
      }
      is BiologicallyDerivedProduct.Collection.Collected.Period -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.collectedPeriodSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val collectorSer: KSerializer<Reference> = Reference.serializer()

    public val collectedDateTimeSer: KSerializer<Element> = Element.serializer()

    public val collectedPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object BiologicallyDerivedProductProcessingSerializer :
  KSerializer<BiologicallyDerivedProduct.Processing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Processing") {
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
      element("procedure", CodeableConcept.serializer().descriptor, isOptional = true)
      element("additive", Reference.serializer().descriptor, isOptional = true)
      element("timeDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timeDateTime", Element.serializer().descriptor, isOptional = true)
      element("timePeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Processing =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Processing) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): BiologicallyDerivedProduct.Processing {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var procedure: CodeableConcept? = null
    var additive: Reference? = null
    var timeDateTime: KotlinString? = null
    var _timeDateTime: Element? = null
    var timePeriod: Period? = null
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
        5 ->
          procedure =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.procedureSer, null)
        6 ->
          additive =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.additiveSer, null)
        7 -> timeDateTime = decoder.decodeStringElement(__desc, __i)
        8 ->
          _timeDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        9 ->
          timePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.timePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Processing: " + __i)
      }
    }
    return BiologicallyDerivedProduct.Processing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      procedure = procedure,
      additive = additive,
      time =
        BiologicallyDerivedProduct.Processing.Time.from(
          DateTime.of(FhirDateTime.fromString(timeDateTime), _timeDateTime),
          timePeriod,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProduct.Processing,
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
    (value.procedure)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.procedureSer, it)
    }
    (value.additive)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.additiveSer, it) }
    when (val __d = value.time) {
      null -> {}
      is BiologicallyDerivedProduct.Processing.Time.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
        }
      }
      is BiologicallyDerivedProduct.Processing.Time.Period -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.timePeriodSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val procedureSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val additiveSer: KSerializer<Reference> = Reference.serializer()

    public val timePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object BiologicallyDerivedProductManipulationSerializer :
  KSerializer<BiologicallyDerivedProduct.Manipulation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Manipulation") {
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
      element("timeDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_timeDateTime", Element.serializer().descriptor, isOptional = true)
      element("timePeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Manipulation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Manipulation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): BiologicallyDerivedProduct.Manipulation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var timeDateTime: KotlinString? = null
    var _timeDateTime: Element? = null
    var timePeriod: Period? = null
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
        5 -> timeDateTime = decoder.decodeStringElement(__desc, __i)
        6 ->
          _timeDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        7 ->
          timePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.timePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Manipulation: " + __i)
      }
    }
    return BiologicallyDerivedProduct.Manipulation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      time =
        BiologicallyDerivedProduct.Manipulation.Time.from(
          DateTime.of(FhirDateTime.fromString(timeDateTime), _timeDateTime),
          timePeriod,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProduct.Manipulation,
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
    when (val __d = value.time) {
      null -> {}
      is BiologicallyDerivedProduct.Manipulation.Time.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
        }
      }
      is BiologicallyDerivedProduct.Manipulation.Time.Period -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.timePeriodSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val timePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object BiologicallyDerivedProductStorageSerializer :
  KSerializer<BiologicallyDerivedProduct.Storage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Storage") {
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
      element("temperature", BigDecimalSerializer.descriptor, isOptional = true)
      element("_temperature", Element.serializer().descriptor, isOptional = true)
      element("scale", KotlinString.serializer().descriptor, isOptional = true)
      element("_scale", Element.serializer().descriptor, isOptional = true)
      element("duration", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Storage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Storage) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): BiologicallyDerivedProduct.Storage {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var temperature: BigDecimal? = null
    var _temperature: Element? = null
    var scale: KotlinString? = null
    var _scale: Element? = null
    var duration: Period? = null
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
        5 ->
          temperature =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        6 ->
          _temperature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        7 -> scale = decoder.decodeStringElement(__desc, __i)
        8 ->
          _scale =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        9 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.durationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Storage: " + __i)
      }
    }
    return BiologicallyDerivedProduct.Storage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description),
      temperature = Decimal.of(temperature, _temperature),
      scale =
        scale?.let {
          Enumeration.of(
            BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.fromCode(it),
            _scale,
          )
        },
      duration = duration,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: BiologicallyDerivedProduct.Storage,
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
    ((value.temperature?.value))?.let {
      encoder.encodeSerializableElement(__desc, 5, BigDecimalSerializer, it)
    }
    (value.temperature?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    ((value.scale?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.scale?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
    }
    (value.duration)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.durationSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val durationSer: KSerializer<Period> = Period.serializer()
  }
}

internal object BiologicallyDerivedProductSerializer : KSerializer<BiologicallyDerivedProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProduct") {
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
    b.element("productCategory", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_productCategory", Element.serializer().descriptor, isOptional = true)
    b.element("productCode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("request", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("quantity", Int.serializer().descriptor, isOptional = true)
    b.element("_quantity", Element.serializer().descriptor, isOptional = true)
    b.element("parent", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "collection",
      lazyDescriptor { BiologicallyDerivedProduct.Collection.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "processing",
      listSerialDescriptor(
        lazyDescriptor { BiologicallyDerivedProduct.Processing.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "manipulation",
      lazyDescriptor { BiologicallyDerivedProduct.Manipulation.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "storage",
      listSerialDescriptor(
        lazyDescriptor { BiologicallyDerivedProduct.Storage.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "BiologicallyDerivedProduct")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): BiologicallyDerivedProduct {
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
    var productCategory: KotlinString? = null
    var _productCategory: Element? = null
    var productCode: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var request: List<Reference>? = null
    var quantity: Int? = null
    var _quantity: Element? = null
    var parent: List<Reference>? = null
    var collection: BiologicallyDerivedProduct.Collection? = null
    var processing: List<BiologicallyDerivedProduct.Processing>? = null
    var manipulation: BiologicallyDerivedProduct.Manipulation? = null
    var storage: List<BiologicallyDerivedProduct.Storage>? = null
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
        11 -> productCategory = decoder.decodeStringElement(__desc, __i)
        12 ->
          _productCategory =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          productCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.productCodeSer, null)
        14 -> status = decoder.decodeStringElement(__desc, __i)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 ->
          request = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        17 -> quantity = decoder.decodeIntElement(__desc, __i)
        18 ->
          _quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 ->
          parent = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        20 ->
          collection =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.collectionSer, null)
        21 ->
          processing =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.processingSer, null)
        22 ->
          manipulation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.manipulationSer, null)
        23 ->
          storage = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.storageSer, null)
        else ->
          throw SerializationException(
            "Unexpected index decoding BiologicallyDerivedProduct: " + __i
          )
      }
    }
    return BiologicallyDerivedProduct(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      productCategory =
        productCategory?.let {
          Enumeration.of(
            BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.fromCode(it),
            _productCategory,
          )
        },
      productCode = productCode,
      status =
        status?.let {
          Enumeration.of(
            BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.fromCode(it),
            _status,
          )
        },
      request = request ?: listOf(),
      quantity = Integer.of(quantity, _quantity),
      parent = parent ?: listOf(),
      collection = collection,
      processing = processing ?: listOf(),
      manipulation = manipulation,
      storage = storage ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: BiologicallyDerivedProduct,
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
    ((value.productCategory?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 11 + __off, it)
    }
    (value.productCategory?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.productCode)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.productCodeSer, it)
    }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.request.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.requestSer, value.request)
    ((value.quantity?.value))?.let { encoder.encodeIntElement(__desc, 17 + __off, it) }
    (value.quantity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.parent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.requestSer, value.parent)
    (value.collection)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.collectionSer, it)
    }
    if (value.processing.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.processingSer, value.processing)
    (value.manipulation)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.manipulationSer, it)
    }
    if (value.storage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.storageSer, value.storage)
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

    public val productCodeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val requestSerInner: KSerializer<Reference> = Reference.serializer()

    public val requestSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.requestSerInner)

    public val collectionSer: KSerializer<BiologicallyDerivedProduct.Collection> =
      BiologicallyDerivedProduct.Collection.serializer()

    public val processingSerInner: KSerializer<BiologicallyDerivedProduct.Processing> =
      BiologicallyDerivedProduct.Processing.serializer()

    public val processingSer: KSerializer<List<BiologicallyDerivedProduct.Processing>> =
      ListSerializer(Hoisted.processingSerInner)

    public val manipulationSer: KSerializer<BiologicallyDerivedProduct.Manipulation> =
      BiologicallyDerivedProduct.Manipulation.serializer()

    public val storageSerInner: KSerializer<BiologicallyDerivedProduct.Storage> =
      BiologicallyDerivedProduct.Storage.serializer()

    public val storageSer: KSerializer<List<BiologicallyDerivedProduct.Storage>> =
      ListSerializer(Hoisted.storageSerInner)
  }
}

internal object BiologicallyDerivedProductPolymorphicSerializer :
  KSerializer<BiologicallyDerivedProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BiologicallyDerivedProduct") {
      BiologicallyDerivedProductSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct) {
    encoder.encodeStructure(descriptor) {
      BiologicallyDerivedProductSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct =
    decoder.decodeStructure(descriptor) {
      BiologicallyDerivedProductSerializer.deserializeJson(this, descriptor, 0)
    }
}

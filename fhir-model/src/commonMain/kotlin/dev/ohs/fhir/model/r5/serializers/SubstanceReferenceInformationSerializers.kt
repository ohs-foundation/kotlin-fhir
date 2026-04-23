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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.SubstanceReferenceInformation
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

internal object SubstanceReferenceInformationGeneSerializer :
  KSerializer<SubstanceReferenceInformation.Gene> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Gene") {
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
      element("geneSequenceOrigin", CodeableConcept.serializer().descriptor, isOptional = true)
      element("gene", CodeableConcept.serializer().descriptor, isOptional = true)
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Gene =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Gene) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceReferenceInformation.Gene {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var geneSequenceOrigin: CodeableConcept? = null
    var gene: CodeableConcept? = null
    var source: List<Reference>? = null
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
          geneSequenceOrigin =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.geneSequenceOriginSer,
              null,
            )
        4 ->
          gene =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.geneSequenceOriginSer,
              null,
            )
        5 -> source = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Gene: " + __i)
      }
    }
    return SubstanceReferenceInformation.Gene(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      geneSequenceOrigin = geneSequenceOrigin,
      gene = gene,
      source = source ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceReferenceInformation.Gene,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.geneSequenceOrigin)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.geneSequenceOriginSer, it)
    }
    (value.gene)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.geneSequenceOriginSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val geneSequenceOriginSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object SubstanceReferenceInformationGeneElementSerializer :
  KSerializer<SubstanceReferenceInformation.GeneElement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GeneElement") {
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
      element("element", Identifier.serializer().descriptor, isOptional = true)
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.GeneElement =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.GeneElement) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): SubstanceReferenceInformation.GeneElement {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var element: Identifier? = null
    var source: List<Reference>? = null
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
          element = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.elementSer, null)
        5 -> source = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding GeneElement: " + __i)
      }
    }
    return SubstanceReferenceInformation.GeneElement(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      element = element,
      source = source ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceReferenceInformation.GeneElement,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.element)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.elementSer, it) }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val elementSer: KSerializer<Identifier> = Identifier.serializer()

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object SubstanceReferenceInformationTargetSerializer :
  KSerializer<SubstanceReferenceInformation.Target> {
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
      element("target", Identifier.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("interaction", CodeableConcept.serializer().descriptor, isOptional = true)
      element("organism", CodeableConcept.serializer().descriptor, isOptional = true)
      element("organismType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amountQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("amountRange", Range.serializer().descriptor, isOptional = true)
      element("amountString", KotlinString.serializer().descriptor, isOptional = true)
      element("_amountString", Element.serializer().descriptor, isOptional = true)
      element("amountType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Target =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Target) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubstanceReferenceInformation.Target {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var target: Identifier? = null
    var type: CodeableConcept? = null
    var interaction: CodeableConcept? = null
    var organism: CodeableConcept? = null
    var organismType: CodeableConcept? = null
    var amountQuantity: Quantity? = null
    var amountRange: Range? = null
    var amountString: KotlinString? = null
    var _amountString: Element? = null
    var amountType: CodeableConcept? = null
    var source: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> target = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.targetSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 ->
          interaction = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> organism = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          organismType = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeSer, null)
        8 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.amountQuantitySer, null)
        9 ->
          amountRange =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.amountRangeSer, null)
        10 -> amountString = decoder.decodeStringElement(__desc, 10)
        11 ->
          _amountString =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.amountStringSer, null)
        12 ->
          amountType = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.typeSer, null)
        13 ->
          source = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + __i)
      }
    }
    return SubstanceReferenceInformation.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      target = target,
      type = type,
      interaction = interaction,
      organism = organism,
      organismType = organismType,
      amount =
        SubstanceReferenceInformation.Target.Amount.from(
          amountQuantity,
          amountRange,
          R5String.of(amountString, _amountString),
        ),
      amountType = amountType,
      source = source ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubstanceReferenceInformation.Target,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.target)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.targetSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    (value.interaction)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    (value.organism)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    (value.organismType)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it) }
    when (val __d = value.amount) {
      null -> {}
      is SubstanceReferenceInformation.Target.Amount.Quantity -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.amountQuantitySer, __d.value)
      }
      is SubstanceReferenceInformation.Target.Amount.Range -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.amountRangeSer, __d.value)
      }
      is SubstanceReferenceInformation.Target.Amount.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.amountStringSer, it)
        }
      }
    }
    (value.amountType)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.typeSer, it) }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val targetSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val amountRangeSer: KSerializer<Range> = Range.serializer()

    public val amountStringSer: KSerializer<Element> = Element.serializer()

    public val sourceSerInner: KSerializer<Reference> = Reference.serializer()

    public val sourceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.sourceSerInner)
  }
}

internal object SubstanceReferenceInformationTargetAmountSerializer :
  KSerializer<SubstanceReferenceInformation.Target.Amount> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceReferenceInformation.Target.Amount") {
      element("amountQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("amountRange", Range.serializer().descriptor, isOptional = true)
      element("amountString", KotlinString.serializer().descriptor, isOptional = true)
      element("_amountString", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Target.Amount) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is SubstanceReferenceInformation.Target.Amount.Quantity -> {
          encodeSerializableElement(__desc, 0, Hoisted.amountQuantitySer, __d.value)
        }
        is SubstanceReferenceInformation.Target.Amount.Range -> {
          encodeSerializableElement(__desc, 1, Hoisted.amountRangeSer, __d.value)
        }
        is SubstanceReferenceInformation.Target.Amount.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Target.Amount =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): SubstanceReferenceInformation.Target.Amount {
    val __desc = descriptor
    var amountQuantity: Quantity? = null
    var amountRange: Range? = null
    var amountString: KotlinString? = null
    var _amountString: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.amountQuantitySer, null)
        1 ->
          amountRange =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.amountRangeSer, null)
        2 -> amountString = decoder.decodeStringElement(__desc, 2)
        3 ->
          _amountString =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding SubstanceReferenceInformation.Target.Amount: " + __i
          )
      }
    }
    return SubstanceReferenceInformation.Target.Amount.from(
      amountQuantity,
      amountRange,
      R5String.of(amountString, _amountString),
    )!!
  }

  private object Hoisted {
    public val amountQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val amountRangeSer: KSerializer<Range> = Range.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SubstanceReferenceInformationSerializer :
  KSerializer<SubstanceReferenceInformation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceReferenceInformation") {
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
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element(
        "gene",
        listSerialDescriptor(
          lazyDescriptor { SubstanceReferenceInformation.Gene.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "geneElement",
        listSerialDescriptor(
          lazyDescriptor { SubstanceReferenceInformation.GeneElement.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "target",
        listSerialDescriptor(
          lazyDescriptor { SubstanceReferenceInformation.Target.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): SubstanceReferenceInformation {
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
    var comment: KotlinString? = null
    var _comment: Element? = null
    var gene: List<SubstanceReferenceInformation.Gene>? = null
    var geneElement: List<SubstanceReferenceInformation.GeneElement>? = null
    var target: List<SubstanceReferenceInformation.Target>? = null
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
        11 -> comment = decoder.decodeStringElement(__desc, 11)
        12 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 -> gene = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.geneSer, null)
        14 ->
          geneElement =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.geneElementSer, null)
        15 ->
          target = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding SubstanceReferenceInformation: " + __i
          )
      }
    }
    return SubstanceReferenceInformation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      comment = R5String.of(comment, _comment),
      gene = gene ?: listOf(),
      geneElement = geneElement ?: listOf(),
      target = target ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubstanceReferenceInformation) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "SubstanceReferenceInformation")
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
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.gene.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.geneSer, value.gene)
    if (value.geneElement.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.geneElementSer, value.geneElement)
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.targetSer, value.target)
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

    public val geneSerInner: KSerializer<SubstanceReferenceInformation.Gene> =
      SubstanceReferenceInformation.Gene.serializer()

    public val geneSer: KSerializer<List<SubstanceReferenceInformation.Gene>> =
      ListSerializer(Hoisted.geneSerInner)

    public val geneElementSerInner: KSerializer<SubstanceReferenceInformation.GeneElement> =
      SubstanceReferenceInformation.GeneElement.serializer()

    public val geneElementSer: KSerializer<List<SubstanceReferenceInformation.GeneElement>> =
      ListSerializer(Hoisted.geneElementSerInner)

    public val targetSerInner: KSerializer<SubstanceReferenceInformation.Target> =
      SubstanceReferenceInformation.Target.serializer()

    public val targetSer: KSerializer<List<SubstanceReferenceInformation.Target>> =
      ListSerializer(Hoisted.targetSerInner)
  }
}

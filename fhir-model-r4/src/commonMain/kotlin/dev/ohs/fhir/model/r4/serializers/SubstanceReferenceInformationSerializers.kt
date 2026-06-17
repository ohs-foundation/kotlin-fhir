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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceReferenceInformation
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Gene) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceReferenceInformation.Gene {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var geneSequenceOrigin: CodeableConcept? = null
    var gene: CodeableConcept? = null
    var source: List<Reference>? = null
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
          geneSequenceOrigin =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.geneSequenceOriginSer,
              null,
            )
        4 ->
          gene =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.geneSequenceOriginSer,
              null,
            )
        5 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Gene: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceReferenceInformation.Gene,
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
    (value.geneSequenceOrigin)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.geneSequenceOriginSer, it)
    }
    (value.gene)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.geneSequenceOriginSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.sourceSer, value.source)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.GeneElement) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceReferenceInformation.GeneElement {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var element: Identifier? = null
    var source: List<Reference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          element =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.elementSer, null)
        5 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding GeneElement: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceReferenceInformation.GeneElement,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    (value.element)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.elementSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.sourceSer, value.source)
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

internal object SubstanceReferenceInformationClassificationSerializer :
  KSerializer<SubstanceReferenceInformation.Classification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Classification") {
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
      element("domain", CodeableConcept.serializer().descriptor, isOptional = true)
      element("classification", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "subtype",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("source", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Classification =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Classification) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceReferenceInformation.Classification {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var domain: CodeableConcept? = null
    var classification: CodeableConcept? = null
    var subtype: List<CodeableConcept>? = null
    var source: List<Reference>? = null
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
          domain = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.domainSer, null)
        4 ->
          classification =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.domainSer, null)
        5 ->
          subtype =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subtypeSer, null)
        6 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Classification: " + i)
      }
    }
    return SubstanceReferenceInformation.Classification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      domain = domain,
      classification = classification,
      subtype = subtype ?: listOf(),
      source = source ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceReferenceInformation.Classification,
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
    (value.domain)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.domainSer, it) }
    (value.classification)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.domainSer, it)
    }
    if (value.subtype.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.subtypeSer, value.subtype)
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.sourceSer, value.source)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val domainSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subtypeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.domainSer)

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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Target) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceReferenceInformation.Target {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          interaction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 ->
          organism = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          organismType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 ->
          amountQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.amountQuantitySer,
              null,
            )
        9 ->
          amountRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountRangeSer, null)
        10 -> amountString = decoder.decodeStringElement(descriptor, i)
        11 ->
          _amountString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountStringSer, null)
        12 ->
          amountType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        13 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + i)
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
          R4String.of(amountString, _amountString),
        ),
      amountType = amountType,
      source = source ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceReferenceInformation.Target,
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
    (value.target)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.targetSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    (value.interaction)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it)
    }
    (value.organism)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    (value.organismType)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, it)
    }
    when (val choice = value.amount) {
      null -> {}
      is SubstanceReferenceInformation.Target.Amount.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.amountQuantitySer, choice.value)
      }
      is SubstanceReferenceInformation.Target.Amount.Range -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.amountRangeSer, choice.value)
      }
      is SubstanceReferenceInformation.Target.Amount.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.amountStringSer, it)
        }
      }
    }
    (value.amountType)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.typeSer, it)
    }
    if (value.source.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.sourceSer, value.source)
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

internal object SubstanceReferenceInformationSerializer :
  KSerializer<SubstanceReferenceInformation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceReferenceInformation") {
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
    b.element("comment", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_comment", Element.serializer().descriptor, isOptional = true)
    b.element(
      "gene",
      listSerialDescriptor(
        lazyDescriptor { SubstanceReferenceInformation.Gene.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "geneElement",
      listSerialDescriptor(
        lazyDescriptor { SubstanceReferenceInformation.GeneElement.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "classification",
      listSerialDescriptor(
        lazyDescriptor { SubstanceReferenceInformation.Classification.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "target",
      listSerialDescriptor(
        lazyDescriptor { SubstanceReferenceInformation.Target.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstanceReferenceInformation")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubstanceReferenceInformation {
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
    var classification: List<SubstanceReferenceInformation.Classification>? = null
    var target: List<SubstanceReferenceInformation.Target>? = null
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
        10 -> comment = decoder.decodeStringElement(descriptor, i)
        11 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 -> gene = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.geneSer, null)
        13 ->
          geneElement =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.geneElementSer, null)
        14 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        15 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        else ->
          throw SerializationException(
            "Unexpected index decoding SubstanceReferenceInformation: " + i
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
      comment = R4String.of(comment, _comment),
      gene = gene ?: listOf(),
      geneElement = geneElement ?: listOf(),
      classification = classification ?: listOf(),
      target = target ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceReferenceInformation,
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
    ((value.comment?.value))?.let {
      encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it)
    }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.gene.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.geneSer,
        value.gene,
      )
    if (value.geneElement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.geneElementSer,
        value.geneElement,
      )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.classificationSer,
        value.classification,
      )
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.targetSer,
        value.target,
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

    public val geneSerInner: KSerializer<SubstanceReferenceInformation.Gene> =
      SubstanceReferenceInformation.Gene.serializer()

    public val geneSer: KSerializer<List<SubstanceReferenceInformation.Gene>> =
      ListSerializer(Hoisted.geneSerInner)

    public val geneElementSerInner: KSerializer<SubstanceReferenceInformation.GeneElement> =
      SubstanceReferenceInformation.GeneElement.serializer()

    public val geneElementSer: KSerializer<List<SubstanceReferenceInformation.GeneElement>> =
      ListSerializer(Hoisted.geneElementSerInner)

    public val classificationSerInner: KSerializer<SubstanceReferenceInformation.Classification> =
      SubstanceReferenceInformation.Classification.serializer()

    public val classificationSer: KSerializer<List<SubstanceReferenceInformation.Classification>> =
      ListSerializer(Hoisted.classificationSerInner)

    public val targetSerInner: KSerializer<SubstanceReferenceInformation.Target> =
      SubstanceReferenceInformation.Target.serializer()

    public val targetSer: KSerializer<List<SubstanceReferenceInformation.Target>> =
      ListSerializer(Hoisted.targetSerInner)
  }
}

internal object SubstanceReferenceInformationPolymorphicSerializer :
  KSerializer<SubstanceReferenceInformation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceReferenceInformation") {
      SubstanceReferenceInformationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation) {
    encoder.encodeStructure(descriptor) {
      SubstanceReferenceInformationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation =
    decoder.decodeStructure(descriptor) {
      SubstanceReferenceInformationSerializer.deserializeInternal(this, descriptor, 0)
    }
}

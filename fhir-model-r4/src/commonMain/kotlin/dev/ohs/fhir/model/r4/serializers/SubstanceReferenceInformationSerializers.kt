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
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("geneSequenceOrigin", CodeableConceptSerializer.descriptor)
      optionalElement("gene", CodeableConceptSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceReferenceInformation.Gene>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Gene =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var geneSequenceOrigin: CodeableConcept? = null
      var gene: CodeableConcept? = null
      var source: List<Reference>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            geneSequenceOrigin =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            gene = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Gene: " + i)
        }
      }
      SubstanceReferenceInformation.Gene(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        geneSequenceOrigin = geneSequenceOrigin,
        gene = gene,
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Gene) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(
        descriptor,
        3,
        CodeableConceptSerializer,
        value.geneSequenceOrigin,
      )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.gene)
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 5, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceReferenceInformationGeneElementSerializer :
  KSerializer<SubstanceReferenceInformation.GeneElement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GeneElement") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("element", IdentifierSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceReferenceInformation.GeneElement>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.GeneElement =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var element: Identifier? = null
      var source: List<Reference>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            element = decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          5 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding GeneElement: " + i)
        }
      }
      SubstanceReferenceInformation.GeneElement(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        element = element,
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.GeneElement) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, IdentifierSerializer, value.element)
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 5, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceReferenceInformationClassificationSerializer :
  KSerializer<SubstanceReferenceInformation.Classification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Classification") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("domain", CodeableConceptSerializer.descriptor)
      optionalElement("classification", CodeableConceptSerializer.descriptor)
      optionalElement("subtype", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceReferenceInformation.Classification>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Classification =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var domain: CodeableConcept? = null
      var classification: CodeableConcept? = null
      var subtype: List<CodeableConcept>? = null
      var source: List<Reference>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            domain =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            classification =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            subtype =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Classification: " + i)
        }
      }
      SubstanceReferenceInformation.Classification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        domain = domain,
        classification = classification,
        subtype = subtype ?: listOf(),
        source = source ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Classification) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.domain)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.classification)
      if (value.subtype.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.subtype,
        )
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 6, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceReferenceInformationTargetSerializer :
  KSerializer<SubstanceReferenceInformation.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("target", IdentifierSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("interaction", CodeableConceptSerializer.descriptor)
      optionalElement("organism", CodeableConceptSerializer.descriptor)
      optionalElement("organismType", CodeableConceptSerializer.descriptor)
      optionalElement("amountQuantity", QuantitySerializer.descriptor)
      optionalElement("amountRange", RangeSerializer.descriptor)
      optionalElement("amountString", KotlinString.serializer().descriptor)
      optionalElement("_amountString", ElementSerializer.descriptor)
      optionalElement("amountType", CodeableConceptSerializer.descriptor)
      optionalElement("source", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceReferenceInformation.Target>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Target =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> target = decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            interaction =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            organism =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            organismType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            amountQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> amountRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          10 -> amountString = decodeStringElement(descriptor, i)
          11 ->
            _amountString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            amountType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          13 ->
            source =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Target: " + i)
        }
      }
      SubstanceReferenceInformation.Target(
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

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Target) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, IdentifierSerializer, value.target)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.interaction)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.organism)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.organismType)
      when (val choice = value.amount) {
        null -> {}
        is SubstanceReferenceInformation.Target.Amount.Quantity -> {
          encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
        }
        is SubstanceReferenceInformation.Target.Amount.Range -> {
          encodeSerializableElement(descriptor, 9, RangeSerializer, choice.value)
        }
        is SubstanceReferenceInformation.Target.Amount.String -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 12, CodeableConceptSerializer, value.amountType)
      if (value.source.isNotEmpty())
        encodeSerializableElement(descriptor, 13, ReferenceSerializer.listSerializer, value.source)
    }
  }
}

internal object SubstanceReferenceInformationSerializer :
  FhirResourceSerializer<SubstanceReferenceInformation> {
  override val descriptor: SerialDescriptor =
    buildResourceDescriptor("SubstanceReferenceInformation")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("comment", KotlinString.serializer().descriptor)
    b.optionalElement("_comment", ElementSerializer.descriptor)
    b.optionalElement("gene", SubstanceReferenceInformationGeneSerializer.listSerializer.descriptor)
    b.optionalElement(
      "geneElement",
      SubstanceReferenceInformationGeneElementSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "classification",
      SubstanceReferenceInformationClassificationSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "target",
      SubstanceReferenceInformationTargetSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> comment = decoder.decodeStringElement(descriptor, i)
        11 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          gene =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceReferenceInformationGeneSerializer.listSerializer,
              null,
            )
        13 ->
          geneElement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceReferenceInformationGeneElementSerializer.listSerializer,
              null,
            )
        14 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceReferenceInformationClassificationSerializer.listSerializer,
              null,
            )
        15 ->
          target =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceReferenceInformationTargetSerializer.listSerializer,
              null,
            )
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceReferenceInformation,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.comment?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.comment)
    if (value.gene.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        SubstanceReferenceInformationGeneSerializer.listSerializer,
        value.gene,
      )
    if (value.geneElement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        SubstanceReferenceInformationGeneElementSerializer.listSerializer,
        value.geneElement,
      )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        SubstanceReferenceInformationClassificationSerializer.listSerializer,
        value.classification,
      )
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        SubstanceReferenceInformationTargetSerializer.listSerializer,
        value.target,
      )
  }
}

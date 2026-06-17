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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.ClinicalUseDefinition
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object ClinicalUseDefinitionContraindicationSerializer :
  KSerializer<ClinicalUseDefinition.Contraindication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contraindication") {
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
        "diseaseSymptomProcedure",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
      element("diseaseStatus", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "comorbidity",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "indication",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("applicability", Expression.serializer().descriptor, isOptional = true)
      element(
        "otherTherapy",
        listSerialDescriptor(
          lazyDescriptor {
            ClinicalUseDefinition.Contraindication.OtherTherapy.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Contraindication =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Contraindication) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ClinicalUseDefinition.Contraindication {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var diseaseSymptomProcedure: CodeableReference? = null
    var diseaseStatus: CodeableReference? = null
    var comorbidity: List<CodeableReference>? = null
    var indication: List<Reference>? = null
    var applicability: Expression? = null
    var otherTherapy: List<ClinicalUseDefinition.Contraindication.OtherTherapy>? = null
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
          diseaseSymptomProcedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        4 ->
          diseaseStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        5 ->
          comorbidity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.comorbiditySer, null)
        6 ->
          indication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.indicationSer, null)
        7 ->
          applicability =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.applicabilitySer, null)
        8 ->
          otherTherapy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.otherTherapySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contraindication: " + i)
      }
    }
    return ClinicalUseDefinition.Contraindication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      diseaseSymptomProcedure = diseaseSymptomProcedure,
      diseaseStatus = diseaseStatus,
      comorbidity = comorbidity ?: listOf(),
      indication = indication ?: listOf(),
      applicability = applicability,
      otherTherapy = otherTherapy ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.Contraindication,
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
    (value.diseaseSymptomProcedure)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.diseaseSymptomProcedureSer, it)
    }
    (value.diseaseStatus)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.diseaseSymptomProcedureSer, it)
    }
    if (value.comorbidity.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.comorbiditySer, value.comorbidity)
    if (value.indication.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.indicationSer, value.indication)
    (value.applicability)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.applicabilitySer, it)
    }
    if (value.otherTherapy.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.otherTherapySer, value.otherTherapy)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val diseaseSymptomProcedureSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val comorbiditySer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.diseaseSymptomProcedureSer)

    public val indicationSerInner: KSerializer<Reference> = Reference.serializer()

    public val indicationSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.indicationSerInner)

    public val applicabilitySer: KSerializer<Expression> = Expression.serializer()

    public val otherTherapySerInner:
      KSerializer<ClinicalUseDefinition.Contraindication.OtherTherapy> =
      ClinicalUseDefinition.Contraindication.OtherTherapy.serializer()

    public val otherTherapySer:
      KSerializer<List<ClinicalUseDefinition.Contraindication.OtherTherapy>> =
      ListSerializer(Hoisted.otherTherapySerInner)
  }
}

internal object ClinicalUseDefinitionContraindicationOtherTherapySerializer :
  KSerializer<ClinicalUseDefinition.Contraindication.OtherTherapy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OtherTherapy") {
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
      element("relationshipType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("treatment", CodeableReference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Contraindication.OtherTherapy =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: ClinicalUseDefinition.Contraindication.OtherTherapy,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ClinicalUseDefinition.Contraindication.OtherTherapy {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationshipType: CodeableConcept? = null
    var treatment: CodeableReference? = null
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
          relationshipType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relationshipTypeSer,
              null,
            )
        4 ->
          treatment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.treatmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OtherTherapy: " + i)
      }
    }
    return ClinicalUseDefinition.Contraindication.OtherTherapy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relationshipType = relationshipType!!,
      treatment = treatment!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.Contraindication.OtherTherapy,
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
    encoder.encodeSerializableElement(
      descriptor,
      3,
      Hoisted.relationshipTypeSer,
      value.relationshipType,
    )
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.treatmentSer, value.treatment)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val relationshipTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val treatmentSer: KSerializer<CodeableReference> = CodeableReference.serializer()
  }
}

internal object ClinicalUseDefinitionIndicationSerializer :
  KSerializer<ClinicalUseDefinition.Indication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Indication") {
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
        "diseaseSymptomProcedure",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
      element("diseaseStatus", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "comorbidity",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("intendedEffect", CodeableReference.serializer().descriptor, isOptional = true)
      element("durationRange", Range.serializer().descriptor, isOptional = true)
      element("durationString", KotlinString.serializer().descriptor, isOptional = true)
      element("_durationString", Element.serializer().descriptor, isOptional = true)
      element(
        "undesirableEffect",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("applicability", Expression.serializer().descriptor, isOptional = true)
      element(
        "otherTherapy",
        listSerialDescriptor(
          lazyDescriptor {
            ClinicalUseDefinition.Contraindication.OtherTherapy.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Indication =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Indication) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClinicalUseDefinition.Indication {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var diseaseSymptomProcedure: CodeableReference? = null
    var diseaseStatus: CodeableReference? = null
    var comorbidity: List<CodeableReference>? = null
    var intendedEffect: CodeableReference? = null
    var durationRange: Range? = null
    var durationString: KotlinString? = null
    var _durationString: Element? = null
    var undesirableEffect: List<Reference>? = null
    var applicability: Expression? = null
    var otherTherapy: List<ClinicalUseDefinition.Contraindication.OtherTherapy>? = null
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
          diseaseSymptomProcedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        4 ->
          diseaseStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        5 ->
          comorbidity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.comorbiditySer, null)
        6 ->
          intendedEffect =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        7 ->
          durationRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.durationRangeSer, null)
        8 -> durationString = decoder.decodeStringElement(descriptor, i)
        9 ->
          _durationString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.durationStringSer,
              null,
            )
        10 ->
          undesirableEffect =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.undesirableEffectSer,
              null,
            )
        11 ->
          applicability =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.applicabilitySer, null)
        12 ->
          otherTherapy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.otherTherapySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Indication: " + i)
      }
    }
    return ClinicalUseDefinition.Indication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      diseaseSymptomProcedure = diseaseSymptomProcedure,
      diseaseStatus = diseaseStatus,
      comorbidity = comorbidity ?: listOf(),
      intendedEffect = intendedEffect,
      duration =
        ClinicalUseDefinition.Indication.Duration.from(
          durationRange,
          R5String.of(durationString, _durationString),
        ),
      undesirableEffect = undesirableEffect ?: listOf(),
      applicability = applicability,
      otherTherapy = otherTherapy ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.Indication,
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
    (value.diseaseSymptomProcedure)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.diseaseSymptomProcedureSer, it)
    }
    (value.diseaseStatus)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.diseaseSymptomProcedureSer, it)
    }
    if (value.comorbidity.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.comorbiditySer, value.comorbidity)
    (value.intendedEffect)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.diseaseSymptomProcedureSer, it)
    }
    when (val choice = value.duration) {
      null -> {}
      is ClinicalUseDefinition.Indication.Duration.Range -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.durationRangeSer, choice.value)
      }
      is ClinicalUseDefinition.Indication.Duration.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.durationStringSer, it)
        }
      }
    }
    if (value.undesirableEffect.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        Hoisted.undesirableEffectSer,
        value.undesirableEffect,
      )
    (value.applicability)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.applicabilitySer, it)
    }
    if (value.otherTherapy.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.otherTherapySer, value.otherTherapy)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val diseaseSymptomProcedureSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val comorbiditySer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.diseaseSymptomProcedureSer)

    public val durationRangeSer: KSerializer<Range> = Range.serializer()

    public val durationStringSer: KSerializer<Element> = Element.serializer()

    public val undesirableEffectSerInner: KSerializer<Reference> = Reference.serializer()

    public val undesirableEffectSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.undesirableEffectSerInner)

    public val applicabilitySer: KSerializer<Expression> = Expression.serializer()

    public val otherTherapySerInner:
      KSerializer<ClinicalUseDefinition.Contraindication.OtherTherapy> =
      ClinicalUseDefinition.Contraindication.OtherTherapy.serializer()

    public val otherTherapySer:
      KSerializer<List<ClinicalUseDefinition.Contraindication.OtherTherapy>> =
      ListSerializer(Hoisted.otherTherapySerInner)
  }
}

internal object ClinicalUseDefinitionInteractionSerializer :
  KSerializer<ClinicalUseDefinition.Interaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Interaction") {
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
        "interactant",
        listSerialDescriptor(
          lazyDescriptor { ClinicalUseDefinition.Interaction.Interactant.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("effect", CodeableReference.serializer().descriptor, isOptional = true)
      element("incidence", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "management",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Interaction =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Interaction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClinicalUseDefinition.Interaction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var interactant: List<ClinicalUseDefinition.Interaction.Interactant>? = null
    var type: CodeableConcept? = null
    var effect: CodeableReference? = null
    var incidence: CodeableConcept? = null
    var management: List<CodeableConcept>? = null
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
          interactant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.interactantSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          effect = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.effectSer, null)
        6 ->
          incidence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          management =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.managementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Interaction: " + i)
      }
    }
    return ClinicalUseDefinition.Interaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      interactant = interactant ?: listOf(),
      type = type,
      effect = effect,
      incidence = incidence,
      management = management ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.Interaction,
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
    if (value.interactant.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.interactantSer, value.interactant)
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    (value.effect)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.effectSer, it) }
    (value.incidence)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    if (value.management.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.managementSer, value.management)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val interactantSerInner: KSerializer<ClinicalUseDefinition.Interaction.Interactant> =
      ClinicalUseDefinition.Interaction.Interactant.serializer()

    public val interactantSer: KSerializer<List<ClinicalUseDefinition.Interaction.Interactant>> =
      ListSerializer(Hoisted.interactantSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val effectSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val managementSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)
  }
}

internal object ClinicalUseDefinitionInteractionInteractantSerializer :
  KSerializer<ClinicalUseDefinition.Interaction.Interactant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Interactant") {
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
      element("itemReference", Reference.serializer().descriptor, isOptional = true)
      element("itemCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Interaction.Interactant =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Interaction.Interactant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ClinicalUseDefinition.Interaction.Interactant {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Interactant: " + i)
      }
    }
    return ClinicalUseDefinition.Interaction.Interactant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item =
        ClinicalUseDefinition.Interaction.Interactant.Item.from(
          itemReference,
          itemCodeableConcept,
        )!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.Interaction.Interactant,
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
    when (val choice = value.item) {
      is ClinicalUseDefinition.Interaction.Interactant.Item.Reference -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemReferenceSer, choice.value)
      }
      is ClinicalUseDefinition.Interaction.Interactant.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.itemCodeableConceptSer,
          choice.value,
        )
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val itemCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ClinicalUseDefinitionUndesirableEffectSerializer :
  KSerializer<ClinicalUseDefinition.UndesirableEffect> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("UndesirableEffect") {
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
        "symptomConditionEffect",
        CodeableReference.serializer().descriptor,
        isOptional = true,
      )
      element("classification", CodeableConcept.serializer().descriptor, isOptional = true)
      element("frequencyOfOccurrence", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.UndesirableEffect =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.UndesirableEffect) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): ClinicalUseDefinition.UndesirableEffect {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var symptomConditionEffect: CodeableReference? = null
    var classification: CodeableConcept? = null
    var frequencyOfOccurrence: CodeableConcept? = null
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
          symptomConditionEffect =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.symptomConditionEffectSer,
              null,
            )
        4 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        5 ->
          frequencyOfOccurrence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding UndesirableEffect: " + i)
      }
    }
    return ClinicalUseDefinition.UndesirableEffect(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      symptomConditionEffect = symptomConditionEffect,
      classification = classification,
      frequencyOfOccurrence = frequencyOfOccurrence,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.UndesirableEffect,
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
    (value.symptomConditionEffect)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.symptomConditionEffectSer, it)
    }
    (value.classification)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.classificationSer, it)
    }
    (value.frequencyOfOccurrence)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.classificationSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val symptomConditionEffectSer: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val classificationSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ClinicalUseDefinitionWarningSerializer :
  KSerializer<ClinicalUseDefinition.Warning> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Warning") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Warning =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Warning) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ClinicalUseDefinition.Warning {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var code: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Warning: " + i)
      }
    }
    return ClinicalUseDefinition.Warning(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      code = code,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ClinicalUseDefinition.Warning) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object ClinicalUseDefinitionSerializer : KSerializer<ClinicalUseDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClinicalUseDefinition") {
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
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "contraindication",
      lazyDescriptor { ClinicalUseDefinition.Contraindication.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "indication",
      lazyDescriptor { ClinicalUseDefinition.Indication.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "interaction",
      lazyDescriptor { ClinicalUseDefinition.Interaction.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "population",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "library",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_library", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element(
      "undesirableEffect",
      lazyDescriptor { ClinicalUseDefinition.UndesirableEffect.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "warning",
      lazyDescriptor { ClinicalUseDefinition.Warning.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ClinicalUseDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ClinicalUseDefinition {
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
    var type: KotlinString? = null
    var _type: Element? = null
    var category: List<CodeableConcept>? = null
    var subject: List<Reference>? = null
    var status: CodeableConcept? = null
    var contraindication: ClinicalUseDefinition.Contraindication? = null
    var indication: ClinicalUseDefinition.Indication? = null
    var interaction: ClinicalUseDefinition.Interaction? = null
    var population: List<Reference>? = null
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var undesirableEffect: ClinicalUseDefinition.UndesirableEffect? = null
    var warning: ClinicalUseDefinition.Warning? = null
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> type = decoder.decodeStringElement(descriptor, i)
        12 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        14 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        15 ->
          status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        16 ->
          contraindication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contraindicationSer,
              null,
            )
        17 ->
          indication =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.indicationSer, null)
        18 ->
          interaction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.interactionSer, null)
        19 ->
          population =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        20 ->
          library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.librarySer, null)
        21 ->
          _library =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.librarySer2, null)
        22 ->
          undesirableEffect =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.undesirableEffectSer,
              null,
            )
        23 ->
          warning =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.warningSer, null)
        else ->
          throw SerializationException("Unexpected index decoding ClinicalUseDefinition: " + i)
      }
    }
    return ClinicalUseDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type =
        Enumeration.of(ClinicalUseDefinition.ClinicalUseDefinitionType.fromCode(type!!), _type),
      category = category ?: listOf(),
      subject = subject ?: listOf(),
      status = status,
      contraindication = contraindication,
      indication = indication,
      interaction = interaction,
      population = population ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index)?.let { it }, _library?.getOrNull(index))!!
        }),
      undesirableEffect = undesirableEffect,
      warning = warning,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ClinicalUseDefinition,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.type.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.subjectSer,
        value.subject,
      )
    (value.status)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.categorySerInner,
        it,
      )
    }
    (value.contraindication)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.contraindicationSer,
        it,
      )
    }
    (value.indication)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.indicationSer,
        it,
      )
    }
    (value.interaction)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.interactionSer,
        it,
      )
    }
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.subjectSer,
        value.population,
      )
    (value.library.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, Hoisted.librarySer, it)
    }
    (value.library.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.librarySer2, it)
    }
    (value.undesirableEffect)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.undesirableEffectSer,
        it,
      )
    }
    (value.warning)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, Hoisted.warningSer, it)
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val subjectSerInner: KSerializer<Reference> = Reference.serializer()

    public val subjectSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSerInner)

    public val contraindicationSer: KSerializer<ClinicalUseDefinition.Contraindication> =
      ClinicalUseDefinition.Contraindication.serializer()

    public val indicationSer: KSerializer<ClinicalUseDefinition.Indication> =
      ClinicalUseDefinition.Indication.serializer()

    public val interactionSer: KSerializer<ClinicalUseDefinition.Interaction> =
      ClinicalUseDefinition.Interaction.serializer()

    public val librarySerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val librarySer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.librarySerInner).nullable)

    public val librarySer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val undesirableEffectSer: KSerializer<ClinicalUseDefinition.UndesirableEffect> =
      ClinicalUseDefinition.UndesirableEffect.serializer()

    public val warningSer: KSerializer<ClinicalUseDefinition.Warning> =
      ClinicalUseDefinition.Warning.serializer()
  }
}

internal object ClinicalUseDefinitionPolymorphicSerializer : KSerializer<ClinicalUseDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClinicalUseDefinition") {
      ClinicalUseDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition) {
    encoder.encodeStructure(descriptor) {
      ClinicalUseDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition =
    decoder.decodeStructure(descriptor) {
      ClinicalUseDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}

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

import dev.ohs.fhir.model.r4b.ClinicalUseDefinition
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CodeableReference
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Contraindication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClinicalUseDefinition.Contraindication {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var diseaseSymptomProcedure: CodeableReference? = null
    var diseaseStatus: CodeableReference? = null
    var comorbidity: List<CodeableReference>? = null
    var indication: List<Reference>? = null
    var otherTherapy: List<ClinicalUseDefinition.Contraindication.OtherTherapy>? = null
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
          diseaseSymptomProcedure =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        4 ->
          diseaseStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        5 ->
          comorbidity =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.comorbiditySer, null)
        6 ->
          indication =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.indicationSer, null)
        7 ->
          otherTherapy =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.otherTherapySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contraindication: " + __i)
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
      otherTherapy = otherTherapy ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.Contraindication,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.diseaseSymptomProcedure)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.diseaseSymptomProcedureSer, it)
    }
    (value.diseaseStatus)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.diseaseSymptomProcedureSer, it)
    }
    if (value.comorbidity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.comorbiditySer, value.comorbidity)
    if (value.indication.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.indicationSer, value.indication)
    if (value.otherTherapy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.otherTherapySer, value.otherTherapy)
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
      element("therapy", CodeableReference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition.Contraindication.OtherTherapy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: ClinicalUseDefinition.Contraindication.OtherTherapy,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ClinicalUseDefinition.Contraindication.OtherTherapy {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationshipType: CodeableConcept? = null
    var therapy: CodeableReference? = null
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
          relationshipType =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.relationshipTypeSer, null)
        4 ->
          therapy = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.therapySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OtherTherapy: " + __i)
      }
    }
    return ClinicalUseDefinition.Contraindication.OtherTherapy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relationshipType = relationshipType!!,
      therapy = therapy!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.Contraindication.OtherTherapy,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.relationshipType)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.relationshipTypeSer, it)
    }
    (value.therapy)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.therapySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val relationshipTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val therapySer: KSerializer<CodeableReference> = CodeableReference.serializer()
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Indication) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClinicalUseDefinition.Indication {
    val __desc = descriptor
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
    var otherTherapy: List<ClinicalUseDefinition.Contraindication.OtherTherapy>? = null
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
          diseaseSymptomProcedure =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        4 ->
          diseaseStatus =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        5 ->
          comorbidity =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.comorbiditySer, null)
        6 ->
          intendedEffect =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.diseaseSymptomProcedureSer,
              null,
            )
        7 ->
          durationRange =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.durationRangeSer, null)
        8 -> durationString = decoder.decodeStringElement(__desc, 8)
        9 ->
          _durationString =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.durationStringSer, null)
        10 ->
          undesirableEffect =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.undesirableEffectSer,
              null,
            )
        11 ->
          otherTherapy =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.otherTherapySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Indication: " + __i)
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
          R4bString.of(durationString, _durationString),
        ),
      undesirableEffect = undesirableEffect ?: listOf(),
      otherTherapy = otherTherapy ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClinicalUseDefinition.Indication) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.diseaseSymptomProcedure)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.diseaseSymptomProcedureSer, it)
    }
    (value.diseaseStatus)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.diseaseSymptomProcedureSer, it)
    }
    if (value.comorbidity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.comorbiditySer, value.comorbidity)
    (value.intendedEffect)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.diseaseSymptomProcedureSer, it)
    }
    when (val __d = value.duration) {
      null -> {}
      is ClinicalUseDefinition.Indication.Duration.Range -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.durationRangeSer, __d.value)
      }
      is ClinicalUseDefinition.Indication.Duration.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.durationStringSer, it)
        }
      }
    }
    if (value.undesirableEffect.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        10,
        Hoisted.undesirableEffectSer,
        value.undesirableEffect,
      )
    if (value.otherTherapy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.otherTherapySer, value.otherTherapy)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Interaction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClinicalUseDefinition.Interaction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var interactant: List<ClinicalUseDefinition.Interaction.Interactant>? = null
    var type: CodeableConcept? = null
    var effect: CodeableReference? = null
    var incidence: CodeableConcept? = null
    var management: List<CodeableConcept>? = null
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
          interactant =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.interactantSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> effect = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.effectSer, null)
        6 -> incidence = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          management =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.managementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Interaction: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClinicalUseDefinition.Interaction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.interactant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.interactantSer, value.interactant)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    (value.effect)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.effectSer, it) }
    (value.incidence)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    if (value.management.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.managementSer, value.management)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Interaction.Interactant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ClinicalUseDefinition.Interaction.Interactant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemReference: Reference? = null
    var itemCodeableConcept: CodeableConcept? = null
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
          itemReference =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.itemReferenceSer, null)
        4 ->
          itemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.itemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Interactant: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.Interaction.Interactant,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.item) {
      null -> {}
      is ClinicalUseDefinition.Interaction.Interactant.Item.Reference -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.itemReferenceSer, __d.value)
      }
      is ClinicalUseDefinition.Interaction.Interactant.Item.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.itemCodeableConceptSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.UndesirableEffect) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClinicalUseDefinition.UndesirableEffect {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var symptomConditionEffect: CodeableReference? = null
    var classification: CodeableConcept? = null
    var frequencyOfOccurrence: CodeableConcept? = null
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
          symptomConditionEffect =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.symptomConditionEffectSer,
              null,
            )
        4 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.classificationSer, null)
        5 ->
          frequencyOfOccurrence =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.classificationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding UndesirableEffect: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ClinicalUseDefinition.UndesirableEffect,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.symptomConditionEffect)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.symptomConditionEffectSer, it)
    }
    (value.classification)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.classificationSer, it)
    }
    (value.frequencyOfOccurrence)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.classificationSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition.Warning) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ClinicalUseDefinition.Warning {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var code: CodeableConcept? = null
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
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Warning: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClinicalUseDefinition.Warning) {
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
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "contraindication",
        lazyDescriptor { ClinicalUseDefinition.Contraindication.serializer().descriptor },
        isOptional = true,
      )
      element(
        "indication",
        lazyDescriptor { ClinicalUseDefinition.Indication.serializer().descriptor },
        isOptional = true,
      )
      element(
        "interaction",
        lazyDescriptor { ClinicalUseDefinition.Interaction.serializer().descriptor },
        isOptional = true,
      )
      element(
        "population",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "undesirableEffect",
        lazyDescriptor { ClinicalUseDefinition.UndesirableEffect.serializer().descriptor },
        isOptional = true,
      )
      element(
        "warning",
        lazyDescriptor { ClinicalUseDefinition.Warning.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ClinicalUseDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ClinicalUseDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ClinicalUseDefinition {
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
    var undesirableEffect: ClinicalUseDefinition.UndesirableEffect? = null
    var warning: ClinicalUseDefinition.Warning? = null
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
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> type = decoder.decodeStringElement(__desc, 12)
        13 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.categorySer, null)
        15 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.subjectSer, null)
        16 ->
          status =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.categorySerInner, null)
        17 ->
          contraindication =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.contraindicationSer, null)
        18 ->
          indication =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.indicationSer, null)
        19 ->
          interaction =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.interactionSer, null)
        20 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.subjectSer, null)
        21 ->
          undesirableEffect =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.undesirableEffectSer,
              null,
            )
        22 ->
          warning = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.warningSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ClinicalUseDefinition: " + __i)
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
      undesirableEffect = undesirableEffect,
      warning = warning,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ClinicalUseDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ClinicalUseDefinition")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.categorySer, value.category)
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.subjectSer, value.subject)
    (value.status)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.categorySerInner, it)
    }
    (value.contraindication)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.contraindicationSer, it)
    }
    (value.indication)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.indicationSer, it)
    }
    (value.interaction)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.interactionSer, it)
    }
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.subjectSer, value.population)
    (value.undesirableEffect)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.undesirableEffectSer, it)
    }
    (value.warning)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.warningSer, it) }
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

    public val undesirableEffectSer: KSerializer<ClinicalUseDefinition.UndesirableEffect> =
      ClinicalUseDefinition.UndesirableEffect.serializer()

    public val warningSer: KSerializer<ClinicalUseDefinition.Warning> =
      ClinicalUseDefinition.Warning.serializer()
  }
}

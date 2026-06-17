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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DataRequirement
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.GuidanceResponse
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object GuidanceResponseSerializer : KSerializer<GuidanceResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GuidanceResponse") {
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
    b.element("requestIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("moduleUri", String.serializer().descriptor, isOptional = true)
    b.element("_moduleUri", Element.serializer().descriptor, isOptional = true)
    b.element("moduleCanonical", String.serializer().descriptor, isOptional = true)
    b.element("_moduleCanonical", Element.serializer().descriptor, isOptional = true)
    b.element("moduleCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("occurrenceDateTime", String.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("performer", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reasonCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reasonReference",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "evaluationMessage",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("outputParameters", Reference.serializer().descriptor, isOptional = true)
    b.element("result", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "dataRequirement",
      listSerialDescriptor(DataRequirement.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): GuidanceResponse =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: GuidanceResponse) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "GuidanceResponse")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): GuidanceResponse {
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
    var requestIdentifier: Identifier? = null
    var identifier: List<Identifier>? = null
    var moduleUri: String? = null
    var _moduleUri: Element? = null
    var moduleCanonical: String? = null
    var _moduleCanonical: Element? = null
    var moduleCodeableConcept: CodeableConcept? = null
    var status: String? = null
    var _status: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: String? = null
    var _occurrenceDateTime: Element? = null
    var performer: Reference? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var evaluationMessage: List<Reference>? = null
    var outputParameters: Reference? = null
    var result: Reference? = null
    var dataRequirement: List<DataRequirement>? = null
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
          requestIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.requestIdentifierSer,
              null,
            )
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        12 -> moduleUri = decoder.decodeStringElement(descriptor, i)
        13 ->
          _moduleUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> moduleCanonical = decoder.decodeStringElement(descriptor, i)
        15 ->
          _moduleCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          moduleCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.moduleCodeableConceptSer,
              null,
            )
        17 -> status = decoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        20 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        21 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        24 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonCodeSer, null)
        25 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reasonReferenceSer,
              null,
            )
        26 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        27 ->
          evaluationMessage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reasonReferenceSer,
              null,
            )
        28 ->
          outputParameters =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        29 ->
          result =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        30 ->
          dataRequirement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.dataRequirementSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding GuidanceResponse: " + i)
      }
    }
    return GuidanceResponse(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      requestIdentifier = requestIdentifier,
      identifier = identifier ?: listOf(),
      module =
        GuidanceResponse.Module.from(
          Uri.of(moduleUri, _moduleUri),
          Canonical.of(moduleCanonical, _moduleCanonical),
          moduleCodeableConcept,
        )!!,
      status = Enumeration.of(GuidanceResponse.GuidanceResponseStatus.fromCode(status!!), _status),
      subject = subject,
      encounter = encounter,
      occurrenceDateTime =
        DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
      performer = performer,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      evaluationMessage = evaluationMessage ?: listOf(),
      outputParameters = outputParameters,
      result = result,
      dataRequirement = dataRequirement ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: GuidanceResponse,
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
    (value.requestIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.requestIdentifierSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    when (val choice = value.module) {
      is GuidanceResponse.Module.Uri -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            13 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is GuidanceResponse.Module.Canonical -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            15 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is GuidanceResponse.Module.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          16 + descriptorOffset,
          Hoisted.moduleCodeableConceptSer,
          choice.value,
        )
      }
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, Hoisted.subjectSer, it)
    }
    ((value.occurrenceDateTime?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.occurrenceDateTime?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.reasonCodeSer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.evaluationMessage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.reasonReferenceSer,
        value.evaluationMessage,
      )
    (value.outputParameters)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.result)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.dataRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.dataRequirementSer,
        value.dataRequirement,
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

    public val requestIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.requestIdentifierSer)

    public val moduleCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val reasonCodeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.moduleCodeableConceptSer)

    public val reasonReferenceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val dataRequirementSerInner: KSerializer<DataRequirement> = DataRequirement.serializer()

    public val dataRequirementSer: KSerializer<List<DataRequirement>> =
      ListSerializer(Hoisted.dataRequirementSerInner)
  }
}

internal object GuidanceResponsePolymorphicSerializer : KSerializer<GuidanceResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GuidanceResponse") {
      GuidanceResponseSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: GuidanceResponse) {
    encoder.encodeStructure(descriptor) {
      GuidanceResponseSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): GuidanceResponse =
    decoder.decodeStructure(descriptor) {
      GuidanceResponseSerializer.deserializeInternal(this, descriptor, 0)
    }
}

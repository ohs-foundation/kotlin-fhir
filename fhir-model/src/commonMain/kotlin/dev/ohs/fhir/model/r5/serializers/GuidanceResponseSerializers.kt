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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DataRequirement
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.GuidanceResponse
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
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
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element("evaluationMessage", Reference.serializer().descriptor, isOptional = true)
    b.element("outputParameters", Reference.serializer().descriptor, isOptional = true)
    b.element("result", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "dataRequirement",
      listSerialDescriptor(DataRequirement.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): GuidanceResponse =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: GuidanceResponse) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "GuidanceResponse")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): GuidanceResponse {
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
    var reason: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var evaluationMessage: Reference? = null
    var outputParameters: Reference? = null
    var result: List<Reference>? = null
    var dataRequirement: List<DataRequirement>? = null
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
          requestIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.requestIdentifierSer,
              null,
            )
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        12 -> moduleUri = decoder.decodeStringElement(__desc, __i)
        13 ->
          _moduleUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 -> moduleCanonical = decoder.decodeStringElement(__desc, __i)
        15 ->
          _moduleCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 ->
          moduleCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.moduleCodeableConceptSer,
              null,
            )
        17 -> status = decoder.decodeStringElement(__desc, __i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 ->
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        20 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        21 -> occurrenceDateTime = decoder.decodeStringElement(__desc, __i)
        22 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        24 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.reasonSer, null)
        25 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        26 ->
          evaluationMessage =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        27 ->
          outputParameters =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        28 ->
          result = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resultSer, null)
        29 ->
          dataRequirement =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dataRequirementSer, null)
        else -> throw SerializationException("Unexpected index decoding GuidanceResponse: " + __i)
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
      reason = reason ?: listOf(),
      note = note ?: listOf(),
      evaluationMessage = evaluationMessage,
      outputParameters = outputParameters,
      result = result ?: listOf(),
      dataRequirement = dataRequirement ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: GuidanceResponse,
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
    (value.requestIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.requestIdentifierSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.identifierSer, value.identifier)
    when (val __d = value.module) {
      null -> {}
      is GuidanceResponse.Module.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is GuidanceResponse.Module.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is GuidanceResponse.Module.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          16 + __off,
          Hoisted.moduleCodeableConceptSer,
          __d.value,
        )
      }
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.subjectSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.subjectSer, it)
    }
    ((value.occurrenceDateTime?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 21 + __off, it)
    }
    (value.occurrenceDateTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.subjectSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.reasonSer, value.reason)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.noteSer, value.note)
    (value.evaluationMessage)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.subjectSer, it)
    }
    (value.outputParameters)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.subjectSer, it)
    }
    if (value.result.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.resultSer, value.result)
    if (value.dataRequirement.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
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

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val resultSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

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
      GuidanceResponseSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): GuidanceResponse =
    decoder.decodeStructure(descriptor) {
      GuidanceResponseSerializer.deserializeJson(this, descriptor, 0)
    }
}

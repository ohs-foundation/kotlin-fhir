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

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.GuidanceResponse
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.GuidanceResponseStatus
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder

internal object GuidanceResponseSerializer : FhirResourceSerializer<GuidanceResponse> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("GuidanceResponse")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("requestIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("moduleUri", String.serializer().descriptor)
    b.optionalElement("_moduleUri", ElementSerializer.descriptor)
    b.optionalElement("moduleCanonical", String.serializer().descriptor)
    b.optionalElement("_moduleCanonical", ElementSerializer.descriptor)
    b.optionalElement("moduleCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", String.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.descriptor)
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("evaluationMessage", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("outputParameters", ReferenceSerializer.descriptor)
    b.optionalElement("result", ReferenceSerializer.descriptor)
    b.optionalElement("dataRequirement", DataRequirementSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          requestIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        11 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        12 -> moduleUri = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _moduleUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> moduleCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _moduleCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          moduleCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 -> occurrenceDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _occurrenceDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          reasonCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        25 ->
          reasonReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        27 ->
          evaluationMessage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          outputParameters =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        29 ->
          result =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        30 ->
          dataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer.listSerializer,
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
        ) ?: throw SerializationException("Missing required property 'module' on GuidanceResponse"),
      status =
        Enumeration.of(
          if (status != null) GuidanceResponseStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on GuidanceResponse"),
      subject = subject,
      encounter = encounter,
      occurrenceDateTime =
        DateTime.of(
          if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
          _occurrenceDateTime,
        ),
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

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: GuidanceResponse,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.requestIdentifier,
    )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    when (val choice = value.module) {
      is GuidanceResponse.Module.Uri -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          12 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, choice.value)
      }
      is GuidanceResponse.Module.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          14 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, choice.value)
      }
      is GuidanceResponse.Module.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          16 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.occurrenceDateTime?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.occurrenceDateTime,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.performer,
    )
    if (value.reasonCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.evaluationMessage.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.evaluationMessage,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.outputParameters,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.result,
    )
    if (value.dataRequirement.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        DataRequirementSerializer.listSerializer,
        value.dataRequirement,
      )
  }
}

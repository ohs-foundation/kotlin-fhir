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

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.DetectedIssue
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.DetectedIssueSeverity
import dev.ohs.fhir.model.r4b.terminologies.ObservationStatus
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

internal object DetectedIssueEvidenceSerializer : KSerializer<DetectedIssue.Evidence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Evidence") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("detail", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DetectedIssue.Evidence>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DetectedIssue.Evidence {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: List<CodeableConcept>? = null
    var detail: List<Reference>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Evidence: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DetectedIssue.Evidence(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Evidence) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.code.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    if (value.detail.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        ReferenceSerializer.listSerializer,
        value.detail,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DetectedIssueMitigationSerializer : KSerializer<DetectedIssue.Mitigation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Mitigation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("action", CodeableConceptSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("author", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<DetectedIssue.Mitigation>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): DetectedIssue.Mitigation {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: CodeableConcept? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var author: Reference? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mitigation: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return DetectedIssue.Mitigation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action =
        action
          ?: throw SerializationException(
            "Missing required property 'action' on DetectedIssue.Mitigation"
          ),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      author = author,
    )
  }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Mitigation) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.action,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.date)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.author)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object DetectedIssueSerializer : FhirResourceSerializer<DetectedIssue> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("DetectedIssue")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("severity", KotlinString.serializer().descriptor)
    b.optionalElement("_severity", ElementSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("identifiedDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_identifiedDateTime", ElementSerializer.descriptor)
    b.optionalElement("identifiedPeriod", PeriodSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
    b.optionalElement("implicated", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("evidence", DetectedIssueEvidenceSerializer.listSerializer.descriptor)
    b.optionalElement("detail", KotlinString.serializer().descriptor)
    b.optionalElement("_detail", ElementSerializer.descriptor)
    b.optionalElement("reference", KotlinString.serializer().descriptor)
    b.optionalElement("_reference", ElementSerializer.descriptor)
    b.optionalElement("mitigation", DetectedIssueMitigationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): DetectedIssue {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var code: CodeableConcept? = null
    var severity: KotlinString? = null
    var _severity: Element? = null
    var patient: Reference? = null
    var identifiedDateTime: KotlinString? = null
    var _identifiedDateTime: Element? = null
    var identifiedPeriod: Period? = null
    var author: Reference? = null
    var implicated: List<Reference>? = null
    var evidence: List<DetectedIssue.Evidence>? = null
    var detail: KotlinString? = null
    var _detail: Element? = null
    var reference: KotlinString? = null
    var _reference: Element? = null
    var mitigation: List<DetectedIssue.Mitigation>? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 -> severity = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _severity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 -> identifiedDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _identifiedDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          identifiedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        20 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 ->
          implicated =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          evidence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DetectedIssueEvidenceSerializer.listSerializer,
              null,
            )
        23 -> detail = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> reference = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          mitigation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DetectedIssueMitigationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding DetectedIssue: " + i)
      }
    }
    return DetectedIssue(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(if (status != null) ObservationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on DetectedIssue"),
      code = code,
      severity =
        Enumeration.of(
          if (severity != null) DetectedIssueSeverity.fromCode(severity) else null,
          _severity,
        ),
      patient = patient,
      identified =
        DetectedIssue.Identified.from(
          DateTime.of(
            if (identifiedDateTime != null) FhirDateTime.fromString(identifiedDateTime) else null,
            _identifiedDateTime,
          ),
          identifiedPeriod,
        ),
      author = author,
      implicated = implicated ?: listOf(),
      evidence = evidence ?: listOf(),
      detail = R4bString.of(detail, _detail),
      reference = Uri.of(reference, _reference),
      mitigation = mitigation ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DetectedIssue,
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
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.severity?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.severity)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    when (val choice = value.identified) {
      null -> {}
      is DetectedIssue.Identified.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          17 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, choice.value)
      }
      is DetectedIssue.Identified.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          19 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    if (value.implicated.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.implicated,
      )
    if (value.evidence.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        DetectedIssueEvidenceSerializer.listSerializer,
        value.evidence,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.detail?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.detail)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.reference?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.reference)
    if (value.mitigation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        DetectedIssueMitigationSerializer.listSerializer,
        value.mitigation,
      )
  }
}

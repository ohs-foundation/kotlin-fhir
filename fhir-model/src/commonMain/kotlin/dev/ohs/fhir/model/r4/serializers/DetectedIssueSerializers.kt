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

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.DetectedIssue
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
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

internal object DetectedIssueEvidenceSerializer : KSerializer<DetectedIssue.Evidence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Evidence") {
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
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("detail", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DetectedIssue.Evidence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Evidence) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DetectedIssue.Evidence {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: List<CodeableConcept>? = null
    var detail: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          detail = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Evidence: " + __i)
      }
    }
    return DetectedIssue.Evidence(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DetectedIssue.Evidence) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, value.code)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val detailSerInner: KSerializer<Reference> = Reference.serializer()

    public val detailSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.detailSerInner)
  }
}

internal object DetectedIssueMitigationSerializer : KSerializer<DetectedIssue.Mitigation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Mitigation") {
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
      element("action", CodeableConcept.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("author", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DetectedIssue.Mitigation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Mitigation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): DetectedIssue.Mitigation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: CodeableConcept? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var author: Reference? = null
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
          action = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actionSer, null)
        4 -> date = decoder.decodeStringElement(__desc, __i)
        5 -> _date = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer, null)
        6 ->
          author = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.authorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Mitigation: " + __i)
      }
    }
    return DetectedIssue.Mitigation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action!!,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      author = author,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: DetectedIssue.Mitigation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.action)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.actionSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.dateSer, it)
    }
    (value.author)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.authorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()

    public val authorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object DetectedIssueSerializer : KSerializer<DetectedIssue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DetectedIssue") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("severity", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_severity", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("identifiedDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_identifiedDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("identifiedPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("author", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "implicated",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "evidence",
      listSerialDescriptor(lazyDescriptor { DetectedIssue.Evidence.serializer().descriptor }),
      isOptional = true,
    )
    b.element("detail", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_detail", Element.serializer().descriptor, isOptional = true)
    b.element("reference", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_reference", Element.serializer().descriptor, isOptional = true)
    b.element(
      "mitigation",
      listSerialDescriptor(lazyDescriptor { DetectedIssue.Mitigation.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): DetectedIssue =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DetectedIssue")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): DetectedIssue {
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
        11 -> status = decoder.decodeStringElement(__desc, __i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        14 -> severity = decoder.decodeStringElement(__desc, __i)
        15 ->
          _severity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 ->
          patient = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        17 -> identifiedDateTime = decoder.decodeStringElement(__desc, __i)
        18 ->
          _identifiedDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 ->
          identifiedPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.identifiedPeriodSer,
              null,
            )
        20 ->
          author = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        21 ->
          implicated =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicatedSer, null)
        22 ->
          evidence =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.evidenceSer, null)
        23 -> detail = decoder.decodeStringElement(__desc, __i)
        24 ->
          _detail =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 -> reference = decoder.decodeStringElement(__desc, __i)
        26 ->
          _reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 ->
          mitigation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.mitigationSer, null)
        else -> throw SerializationException("Unexpected index decoding DetectedIssue: " + __i)
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
      status = Enumeration.of(DetectedIssue.ObservationStatus.fromCode(status!!), _status),
      code = code,
      severity =
        severity?.let {
          Enumeration.of(DetectedIssue.DetectedIssueSeverity.fromCode(it), _severity)
        },
      patient = patient,
      identified =
        DetectedIssue.Identified.from(
          DateTime.of(FhirDateTime.fromString(identifiedDateTime), _identifiedDateTime),
          identifiedPeriod,
        ),
      author = author,
      implicated = implicated ?: listOf(),
      evidence = evidence ?: listOf(),
      detail = R4String.of(detail, _detail),
      reference = Uri.of(reference, _reference),
      mitigation = mitigation ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: DetectedIssue,
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.codeSer, it) }
    ((value.severity?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 14 + __off, it)
    }
    (value.severity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.patientSer, it)
    }
    when (val __d = value.identified) {
      null -> {}
      is DetectedIssue.Identified.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is DetectedIssue.Identified.Period -> {
        encoder.encodeSerializableElement(
          __desc,
          19 + __off,
          Hoisted.identifiedPeriodSer,
          __d.value,
        )
      }
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.patientSer, it)
    }
    if (value.implicated.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicatedSer, value.implicated)
    if (value.evidence.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.evidenceSer, value.evidence)
    ((value.detail?.value))?.let { encoder.encodeStringElement(__desc, 23 + __off, it) }
    (value.detail?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.reference?.value))?.let { encoder.encodeStringElement(__desc, 25 + __off, it) }
    (value.reference?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.mitigation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.mitigationSer, value.mitigation)
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

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val identifiedPeriodSer: KSerializer<Period> = Period.serializer()

    public val implicatedSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)

    public val evidenceSerInner: KSerializer<DetectedIssue.Evidence> =
      DetectedIssue.Evidence.serializer()

    public val evidenceSer: KSerializer<List<DetectedIssue.Evidence>> =
      ListSerializer(Hoisted.evidenceSerInner)

    public val mitigationSerInner: KSerializer<DetectedIssue.Mitigation> =
      DetectedIssue.Mitigation.serializer()

    public val mitigationSer: KSerializer<List<DetectedIssue.Mitigation>> =
      ListSerializer(Hoisted.mitigationSerInner)
  }
}

internal object DetectedIssuePolymorphicSerializer : KSerializer<DetectedIssue> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DetectedIssue") { DetectedIssueSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: DetectedIssue) {
    encoder.encodeStructure(descriptor) {
      DetectedIssueSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DetectedIssue =
    decoder.decodeStructure(descriptor) {
      DetectedIssueSerializer.deserializeJson(this, descriptor, 0)
    }
}

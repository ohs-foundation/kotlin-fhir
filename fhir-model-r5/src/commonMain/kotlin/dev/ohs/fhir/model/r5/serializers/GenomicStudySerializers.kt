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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.GenomicStudy
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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

internal object GenomicStudyAnalysisSerializer : KSerializer<GenomicStudy.Analysis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Analysis") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("methodType", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("changeType", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("genomeBuild", CodeableConceptSerializer.descriptor)
      optionalElement("instantiatesCanonical", KotlinString.serializer().descriptor)
      optionalElement("_instantiatesCanonical", ElementSerializer.descriptor)
      optionalElement("instantiatesUri", KotlinString.serializer().descriptor)
      optionalElement("_instantiatesUri", ElementSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("specimen", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("protocolPerformed", ReferenceSerializer.descriptor)
      optionalElement("regionsStudied", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("regionsCalled", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("input", GenomicStudyAnalysisInputSerializer.listSerializer.descriptor)
      optionalElement("output", GenomicStudyAnalysisOutputSerializer.listSerializer.descriptor)
      optionalElement(
        "performer",
        GenomicStudyAnalysisPerformerSerializer.listSerializer.descriptor,
      )
      optionalElement("device", GenomicStudyAnalysisDeviceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<GenomicStudy.Analysis>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: List<Identifier>? = null
      var methodType: List<CodeableConcept>? = null
      var changeType: List<CodeableConcept>? = null
      var genomeBuild: CodeableConcept? = null
      var instantiatesCanonical: KotlinString? = null
      var _instantiatesCanonical: Element? = null
      var instantiatesUri: KotlinString? = null
      var _instantiatesUri: Element? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var focus: List<Reference>? = null
      var specimen: List<Reference>? = null
      var date: KotlinString? = null
      var _date: Element? = null
      var note: List<Annotation>? = null
      var protocolPerformed: Reference? = null
      var regionsStudied: List<Reference>? = null
      var regionsCalled: List<Reference>? = null
      var input: List<GenomicStudy.Analysis.Input>? = null
      var output: List<GenomicStudy.Analysis.Output>? = null
      var performer: List<GenomicStudy.Analysis.Performer>? = null
      var device: List<GenomicStudy.Analysis.Device>? = null
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
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            methodType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            changeType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            genomeBuild =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> instantiatesCanonical = decodeStringElement(descriptor, i)
          8 ->
            _instantiatesCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> instantiatesUri = decodeStringElement(descriptor, i)
          10 ->
            _instantiatesUri =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> title = decodeStringElement(descriptor, i)
          12 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            focus =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          14 ->
            specimen =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          15 -> date = decodeStringElement(descriptor, i)
          16 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          18 ->
            protocolPerformed =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          19 ->
            regionsStudied =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          20 ->
            regionsCalled =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          21 ->
            input =
              decodeNullableSerializableElement(
                descriptor,
                i,
                GenomicStudyAnalysisInputSerializer.listSerializer,
                null,
              )
          22 ->
            output =
              decodeNullableSerializableElement(
                descriptor,
                i,
                GenomicStudyAnalysisOutputSerializer.listSerializer,
                null,
              )
          23 ->
            performer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                GenomicStudyAnalysisPerformerSerializer.listSerializer,
                null,
              )
          24 ->
            device =
              decodeNullableSerializableElement(
                descriptor,
                i,
                GenomicStudyAnalysisDeviceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Analysis: " + i)
        }
      }
      GenomicStudy.Analysis(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        methodType = methodType ?: listOf(),
        changeType = changeType ?: listOf(),
        genomeBuild = genomeBuild,
        instantiatesCanonical = Canonical.of(instantiatesCanonical, _instantiatesCanonical),
        instantiatesUri = Uri.of(instantiatesUri, _instantiatesUri),
        title = R5String.of(title, _title),
        focus = focus ?: listOf(),
        specimen = specimen ?: listOf(),
        date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
        note = note ?: listOf(),
        protocolPerformed = protocolPerformed,
        regionsStudied = regionsStudied ?: listOf(),
        regionsCalled = regionsCalled ?: listOf(),
        input = input ?: listOf(),
        output = output ?: listOf(),
        performer = performer ?: listOf(),
        device = device ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis) {
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
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      if (value.methodType.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.methodType,
        )
      if (value.changeType.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.changeType,
        )
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.genomeBuild)
      encodeStringIfNotNull(descriptor, 7, value.instantiatesCanonical?.value)
      encodeElementIfNotNull(descriptor, 8, value.instantiatesCanonical)
      encodeStringIfNotNull(descriptor, 9, value.instantiatesUri?.value)
      encodeElementIfNotNull(descriptor, 10, value.instantiatesUri)
      encodeStringIfNotNull(descriptor, 11, value.title?.value)
      encodeElementIfNotNull(descriptor, 12, value.title)
      if (value.focus.isNotEmpty())
        encodeSerializableElement(descriptor, 13, ReferenceSerializer.listSerializer, value.focus)
      if (value.specimen.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          ReferenceSerializer.listSerializer,
          value.specimen,
        )
      encodeStringIfNotNull(descriptor, 15, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 16, value.date)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 17, AnnotationSerializer.listSerializer, value.note)
      encodeSerializableIfNotNull(descriptor, 18, ReferenceSerializer, value.protocolPerformed)
      if (value.regionsStudied.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          19,
          ReferenceSerializer.listSerializer,
          value.regionsStudied,
        )
      if (value.regionsCalled.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          20,
          ReferenceSerializer.listSerializer,
          value.regionsCalled,
        )
      if (value.input.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          21,
          GenomicStudyAnalysisInputSerializer.listSerializer,
          value.input,
        )
      if (value.output.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          22,
          GenomicStudyAnalysisOutputSerializer.listSerializer,
          value.output,
        )
      if (value.performer.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          23,
          GenomicStudyAnalysisPerformerSerializer.listSerializer,
          value.performer,
        )
      if (value.device.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          24,
          GenomicStudyAnalysisDeviceSerializer.listSerializer,
          value.device,
        )
    }
  }
}

internal object GenomicStudyAnalysisInputSerializer : KSerializer<GenomicStudy.Analysis.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("file", ReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("generatedByIdentifier", IdentifierSerializer.descriptor)
      optionalElement("generatedByReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<GenomicStudy.Analysis.Input>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis.Input =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var `file`: Reference? = null
      var type: CodeableConcept? = null
      var generatedByIdentifier: Identifier? = null
      var generatedByReference: Reference? = null
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
          3 -> `file` = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            generatedByIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          6 ->
            generatedByReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Input: " + i)
        }
      }
      GenomicStudy.Analysis.Input(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `file` = `file`,
        type = type,
        generatedBy =
          GenomicStudy.Analysis.Input.GeneratedBy.from(generatedByIdentifier, generatedByReference),
      )
    }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis.Input) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.`file`)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      when (val choice = value.generatedBy) {
        null -> {}
        is GenomicStudy.Analysis.Input.GeneratedBy.Identifier -> {
          encodeSerializableElement(descriptor, 5, IdentifierSerializer, choice.value)
        }
        is GenomicStudy.Analysis.Input.GeneratedBy.Reference -> {
          encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object GenomicStudyAnalysisOutputSerializer : KSerializer<GenomicStudy.Analysis.Output> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Output") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("file", ReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<GenomicStudy.Analysis.Output>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis.Output =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var `file`: Reference? = null
      var type: CodeableConcept? = null
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
          3 -> `file` = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Output: " + i)
        }
      }
      GenomicStudy.Analysis.Output(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `file` = `file`,
        type = type,
      )
    }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis.Output) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.`file`)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
    }
  }
}

internal object GenomicStudyAnalysisPerformerSerializer :
  KSerializer<GenomicStudy.Analysis.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<GenomicStudy.Analysis.Performer>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis.Performer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var actor: Reference? = null
      var role: CodeableConcept? = null
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
          3 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Performer: " + i)
        }
      }
      GenomicStudy.Analysis.Performer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        actor = actor,
        role = role,
      )
    }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis.Performer) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.actor)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.role)
    }
  }
}

internal object GenomicStudyAnalysisDeviceSerializer : KSerializer<GenomicStudy.Analysis.Device> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Device") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("device", ReferenceSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<GenomicStudy.Analysis.Device>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis.Device =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var device: Reference? = null
      var function: CodeableConcept? = null
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
          3 -> device = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Device: " + i)
        }
      }
      GenomicStudy.Analysis.Device(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        device = device,
        function = function,
      )
    }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis.Device) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.device)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.function)
    }
  }
}

internal object GenomicStudySerializer : FhirResourceSerializer<GenomicStudy> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("GenomicStudy")

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
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("startDate", KotlinString.serializer().descriptor)
    b.optionalElement("_startDate", ElementSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("referrer", ReferenceSerializer.descriptor)
    b.optionalElement("interpreter", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", KotlinString.serializer().descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.descriptor)
    b.optionalElement("instantiatesUri", KotlinString.serializer().descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("analysis", GenomicStudyAnalysisSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): GenomicStudy {
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
    var type: List<CodeableConcept>? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var startDate: KotlinString? = null
    var _startDate: Element? = null
    var basedOn: List<Reference>? = null
    var referrer: Reference? = null
    var interpreter: List<Reference>? = null
    var reason: List<CodeableReference>? = null
    var instantiatesCanonical: KotlinString? = null
    var _instantiatesCanonical: Element? = null
    var instantiatesUri: KotlinString? = null
    var _instantiatesUri: Element? = null
    var note: List<Annotation>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var analysis: List<GenomicStudy.Analysis>? = null
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        15 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 -> startDate = decoder.decodeStringElement(descriptor, i)
        17 ->
          _startDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          referrer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          interpreter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        21 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        22 -> instantiatesCanonical = decoder.decodeStringElement(descriptor, i)
        23 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> instantiatesUri = decoder.decodeStringElement(descriptor, i)
        25 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        27 -> description = decoder.decodeStringElement(descriptor, i)
        28 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          analysis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              GenomicStudyAnalysisSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding GenomicStudy: " + i)
      }
    }
    return GenomicStudy(
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
        Enumeration.of(
          if (status != null) GenomicStudy.GenomicStudyStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on GenomicStudy"),
      type = type ?: listOf(),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on GenomicStudy"),
      encounter = encounter,
      startDate =
        DateTime.of(
          if (startDate != null) FhirDateTime.fromString(startDate) else null,
          _startDate,
        ),
      basedOn = basedOn ?: listOf(),
      referrer = referrer,
      interpreter = interpreter ?: listOf(),
      reason = reason ?: listOf(),
      instantiatesCanonical = Canonical.of(instantiatesCanonical, _instantiatesCanonical),
      instantiatesUri = Uri.of(instantiatesUri, _instantiatesUri),
      note = note ?: listOf(),
      description = Markdown.of(description, _description),
      analysis = analysis ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: GenomicStudy,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.startDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.startDate)
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.referrer,
    )
    if (value.interpreter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.interpreter,
      )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.instantiatesCanonical?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.instantiatesCanonical)
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.instantiatesUri?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.instantiatesUri)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.description)
    if (value.analysis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        GenomicStudyAnalysisSerializer.listSerializer,
        value.analysis,
      )
  }
}

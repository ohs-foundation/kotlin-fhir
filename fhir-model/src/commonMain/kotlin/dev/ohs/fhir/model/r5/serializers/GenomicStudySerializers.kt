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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.GenomicStudy
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object GenomicStudyAnalysisSerializer : KSerializer<GenomicStudy.Analysis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Analysis") {
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element(
        "methodType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "changeType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("genomeBuild", CodeableConcept.serializer().descriptor, isOptional = true)
      element("instantiatesCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_instantiatesCanonical", Element.serializer().descriptor, isOptional = true)
      element("instantiatesUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_instantiatesUri", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "specimen",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("protocolPerformed", Reference.serializer().descriptor, isOptional = true)
      element(
        "regionsStudied",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "regionsCalled",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "input",
        listSerialDescriptor(
          lazyDescriptor { GenomicStudy.Analysis.Input.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "output",
        listSerialDescriptor(
          lazyDescriptor { GenomicStudy.Analysis.Output.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "performer",
        listSerialDescriptor(
          lazyDescriptor { GenomicStudy.Analysis.Performer.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "device",
        listSerialDescriptor(
          lazyDescriptor { GenomicStudy.Analysis.Device.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GenomicStudy.Analysis {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 ->
          methodType =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.methodTypeSer, null)
        5 ->
          changeType =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.methodTypeSer, null)
        6 ->
          genomeBuild =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.methodTypeSerInner, null)
        7 -> instantiatesCanonical = decoder.decodeStringElement(__desc, 7)
        8 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        9 -> instantiatesUri = decoder.decodeStringElement(__desc, 9)
        10 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        11 -> title = decoder.decodeStringElement(__desc, 11)
        12 ->
          _title =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        13 -> focus = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.focusSer, null)
        14 ->
          specimen = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.focusSer, null)
        15 -> date = decoder.decodeStringElement(__desc, 15)
        16 ->
          _date =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        17 -> note = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.noteSer, null)
        18 ->
          protocolPerformed =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.focusSerInner, null)
        19 ->
          regionsStudied =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.focusSer, null)
        20 ->
          regionsCalled =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.focusSer, null)
        21 -> input = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.inputSer, null)
        22 ->
          output = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.outputSer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.performerSer, null)
        24 ->
          device = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.deviceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Analysis: " + __i)
      }
    }
    return GenomicStudy.Analysis(
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
      date = DateTime.of(FhirDateTime.fromString(date), _date),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: GenomicStudy.Analysis) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, value.identifier)
    if (value.methodType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.methodTypeSer, value.methodType)
    if (value.changeType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.methodTypeSer, value.changeType)
    (value.genomeBuild)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.methodTypeSerInner, it)
    }
    ((value.instantiatesCanonical?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.instantiatesCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.instantiatesCanonicalSer, it)
    }
    ((value.instantiatesUri?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.instantiatesUri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.instantiatesCanonicalSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.instantiatesCanonicalSer, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.focusSer, value.focus)
    if (value.specimen.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.focusSer, value.specimen)
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.instantiatesCanonicalSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.noteSer, value.note)
    (value.protocolPerformed)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.focusSerInner, it)
    }
    if (value.regionsStudied.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.focusSer, value.regionsStudied)
    if (value.regionsCalled.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.focusSer, value.regionsCalled)
    if (value.input.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.inputSer, value.input)
    if (value.output.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.outputSer, value.output)
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.performerSer, value.performer)
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.deviceSer, value.device)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val methodTypeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val methodTypeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.methodTypeSerInner)

    public val instantiatesCanonicalSer: KSerializer<Element> = Element.serializer()

    public val focusSerInner: KSerializer<Reference> = Reference.serializer()

    public val focusSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.focusSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val inputSerInner: KSerializer<GenomicStudy.Analysis.Input> =
      GenomicStudy.Analysis.Input.serializer()

    public val inputSer: KSerializer<List<GenomicStudy.Analysis.Input>> =
      ListSerializer(Hoisted.inputSerInner)

    public val outputSerInner: KSerializer<GenomicStudy.Analysis.Output> =
      GenomicStudy.Analysis.Output.serializer()

    public val outputSer: KSerializer<List<GenomicStudy.Analysis.Output>> =
      ListSerializer(Hoisted.outputSerInner)

    public val performerSerInner: KSerializer<GenomicStudy.Analysis.Performer> =
      GenomicStudy.Analysis.Performer.serializer()

    public val performerSer: KSerializer<List<GenomicStudy.Analysis.Performer>> =
      ListSerializer(Hoisted.performerSerInner)

    public val deviceSerInner: KSerializer<GenomicStudy.Analysis.Device> =
      GenomicStudy.Analysis.Device.serializer()

    public val deviceSer: KSerializer<List<GenomicStudy.Analysis.Device>> =
      ListSerializer(Hoisted.deviceSerInner)
  }
}

internal object GenomicStudyAnalysisInputSerializer : KSerializer<GenomicStudy.Analysis.Input> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Input") {
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
      element("file", Reference.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("generatedByIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("generatedByReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis.Input =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis.Input) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GenomicStudy.Analysis.Input {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `file`: Reference? = null
    var type: CodeableConcept? = null
    var generatedByIdentifier: Identifier? = null
    var generatedByReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> `file` = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.fileSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 ->
          generatedByIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.generatedByIdentifierSer,
              null,
            )
        6 ->
          generatedByReference =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.fileSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Input: " + __i)
      }
    }
    return GenomicStudy.Analysis.Input(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `file` = `file`,
      type = type,
      generatedBy =
        GenomicStudy.Analysis.Input.GeneratedBy.from(generatedByIdentifier, generatedByReference),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GenomicStudy.Analysis.Input) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.`file`)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.fileSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    when (val __d = value.generatedBy) {
      null -> {}
      is GenomicStudy.Analysis.Input.GeneratedBy.Identifier -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.generatedByIdentifierSer, __d.value)
      }
      is GenomicStudy.Analysis.Input.GeneratedBy.Reference -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.fileSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val fileSer: KSerializer<Reference> = Reference.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val generatedByIdentifierSer: KSerializer<Identifier> = Identifier.serializer()
  }
}

internal object GenomicStudyAnalysisOutputSerializer : KSerializer<GenomicStudy.Analysis.Output> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Output") {
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
      element("file", Reference.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis.Output =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis.Output) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GenomicStudy.Analysis.Output {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `file`: Reference? = null
    var type: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> `file` = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.fileSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Output: " + __i)
      }
    }
    return GenomicStudy.Analysis.Output(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `file` = `file`,
      type = type,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GenomicStudy.Analysis.Output) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.`file`)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.fileSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val fileSer: KSerializer<Reference> = Reference.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object GenomicStudyAnalysisPerformerSerializer :
  KSerializer<GenomicStudy.Analysis.Performer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Performer") {
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
      element("actor", Reference.serializer().descriptor, isOptional = true)
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis.Performer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis.Performer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GenomicStudy.Analysis.Performer {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var actor: Reference? = null
    var role: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> actor = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.actorSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Performer: " + __i)
      }
    }
    return GenomicStudy.Analysis.Performer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actor = actor,
      role = role,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GenomicStudy.Analysis.Performer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.actorSer, it) }
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.roleSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actorSer: KSerializer<Reference> = Reference.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object GenomicStudyAnalysisDeviceSerializer : KSerializer<GenomicStudy.Analysis.Device> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Device") {
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
      element("device", Reference.serializer().descriptor, isOptional = true)
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): GenomicStudy.Analysis.Device =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy.Analysis.Device) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): GenomicStudy.Analysis.Device {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var device: Reference? = null
    var function: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> device = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.deviceSer, null)
        4 ->
          function = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.functionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Device: " + __i)
      }
    }
    return GenomicStudy.Analysis.Device(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      device = device,
      function = function,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: GenomicStudy.Analysis.Device) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.device)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.deviceSer, it) }
    (value.function)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.functionSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val deviceSer: KSerializer<Reference> = Reference.serializer()

    public val functionSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object GenomicStudySerializer : KSerializer<GenomicStudy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GenomicStudy") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("startDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_startDate", Element.serializer().descriptor, isOptional = true)
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("referrer", Reference.serializer().descriptor, isOptional = true)
      element(
        "interpreter",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element("instantiatesCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_instantiatesCanonical", Element.serializer().descriptor, isOptional = true)
      element("instantiatesUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_instantiatesUri", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "analysis",
        listSerialDescriptor(lazyDescriptor { GenomicStudy.Analysis.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): GenomicStudy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: GenomicStudy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): GenomicStudy {
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> type = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.typeSer, null)
        15 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.subjectSer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.subjectSer, null)
        17 -> startDate = decoder.decodeStringElement(__desc, 17)
        18 ->
          _startDate =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.basedOnSer, null)
        20 ->
          referrer = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.subjectSer, null)
        21 ->
          interpreter =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.basedOnSer, null)
        22 ->
          reason = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.reasonSer, null)
        23 -> instantiatesCanonical = decoder.decodeStringElement(__desc, 23)
        24 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> instantiatesUri = decoder.decodeStringElement(__desc, 25)
        26 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> note = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.noteSer, null)
        28 -> description = decoder.decodeStringElement(__desc, 28)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          analysis =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.analysisSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding GenomicStudy: " + __i)
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
      status = Enumeration.of(GenomicStudy.GenomicStudyStatus.fromCode(status!!), _status),
      type = type ?: listOf(),
      subject = subject!!,
      encounter = encounter,
      startDate = DateTime.of(FhirDateTime.fromString(startDate), _startDate),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: GenomicStudy) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "GenomicStudy")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.typeSer, value.type)
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.subjectSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.subjectSer, it) }
    ((value.startDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.startDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.basedOnSer, value.basedOn)
    (value.referrer)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.subjectSer, it) }
    if (value.interpreter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.basedOnSer, value.interpreter)
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.reasonSer, value.reason)
    ((value.instantiatesCanonical?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.instantiatesCanonical?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.instantiatesUri?.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.instantiatesUri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.noteSer, value.note)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.analysis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.analysisSer, value.analysis)
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

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val analysisSerInner: KSerializer<GenomicStudy.Analysis> =
      GenomicStudy.Analysis.serializer()

    public val analysisSer: KSerializer<List<GenomicStudy.Analysis>> =
      ListSerializer(Hoisted.analysisSerInner)
  }
}

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
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Citation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
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

internal object CitationSummarySerializer : KSerializer<Citation.Summary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Summary") {
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
      element("style", CodeableConcept.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.Summary =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.Summary) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.Summary {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var style: CodeableConcept? = null
    var text: KotlinString? = null
    var _text: Element? = null
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
          style = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.styleSer, null)
        4 -> text = decoder.decodeStringElement(descriptor, i)
        5 -> _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Summary: " + i)
      }
    }
    return Citation.Summary(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      style = style,
      text =
        Markdown.of(text, _text)
          ?: throw SerializationException("Missing required property 'text' on Citation.Summary"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Citation.Summary) {
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
    (value.style)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.styleSer, it) }
    ((value.text.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.text.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.textSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val styleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val textSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CitationClassificationSerializer : KSerializer<Citation.Classification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Classification") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "classifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Citation.Classification =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.Classification) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.Classification {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var classifier: List<CodeableConcept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          classifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Classification: " + i)
      }
    }
    return Citation.Classification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      classifier = classifier ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Citation.Classification) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.classifierSer, value.classifier)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)
  }
}

internal object CitationStatusDateSerializer : KSerializer<Citation.StatusDate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StatusDate") {
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
      element("activity", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actual", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_actual", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.StatusDate =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.StatusDate) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.StatusDate {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var activity: CodeableConcept? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var period: Period? = null
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
          activity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.activitySer, null)
        4 -> `actual` = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _actual =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actualSer, null)
        6 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StatusDate: " + i)
      }
    }
    return Citation.StatusDate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      activity =
        activity
          ?: throw SerializationException(
            "Missing required property 'activity' on Citation.StatusDate"
          ),
      `actual` = R5Boolean.of(`actual`, _actual),
      period =
        period
          ?: throw SerializationException(
            "Missing required property 'period' on Citation.StatusDate"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Citation.StatusDate) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.activitySer, value.activity)
    ((value.`actual`?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.`actual`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.actualSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 6, Hoisted.periodSer, value.period)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val activitySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actualSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object CitationCitedArtifactSerializer : KSerializer<Citation.CitedArtifact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CitedArtifact") {
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
        "relatedIdentifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("dateAccessed", KotlinString.serializer().descriptor, isOptional = true)
      element("_dateAccessed", Element.serializer().descriptor, isOptional = true)
      element(
        "version",
        lazyDescriptor { Citation.CitedArtifact.Version.serializer().descriptor },
        isOptional = true,
      )
      element(
        "currentState",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "statusDate",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.StatusDate.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "title",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.Title.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "abstract",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.Abstract.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "part",
        lazyDescriptor { Citation.CitedArtifact.Part.serializer().descriptor },
        isOptional = true,
      )
      element(
        "relatesTo",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.RelatesTo.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "publicationForm",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.PublicationForm.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "webLocation",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.WebLocation.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "classification",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.Classification.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "contributorship",
        lazyDescriptor { Citation.CitedArtifact.Contributorship.serializer().descriptor },
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.CitedArtifact {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var relatedIdentifier: List<Identifier>? = null
    var dateAccessed: KotlinString? = null
    var _dateAccessed: Element? = null
    var version: Citation.CitedArtifact.Version? = null
    var currentState: List<CodeableConcept>? = null
    var statusDate: List<Citation.CitedArtifact.StatusDate>? = null
    var title: List<Citation.CitedArtifact.Title>? = null
    var `abstract`: List<Citation.CitedArtifact.Abstract>? = null
    var part: Citation.CitedArtifact.Part? = null
    var relatesTo: List<Citation.CitedArtifact.RelatesTo>? = null
    var publicationForm: List<Citation.CitedArtifact.PublicationForm>? = null
    var webLocation: List<Citation.CitedArtifact.WebLocation>? = null
    var classification: List<Citation.CitedArtifact.Classification>? = null
    var contributorship: Citation.CitedArtifact.Contributorship? = null
    var note: List<Annotation>? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 ->
          relatedIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        5 -> dateAccessed = decoder.decodeStringElement(descriptor, i)
        6 ->
          _dateAccessed =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateAccessedSer, null)
        7 ->
          version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionSer, null)
        8 ->
          currentState =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.currentStateSer, null)
        9 ->
          statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusDateSer, null)
        10 ->
          title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        11 ->
          `abstract` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.abstractSer, null)
        12 -> part = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partSer, null)
        13 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relatesToSer, null)
        14 ->
          publicationForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.publicationFormSer,
              null,
            )
        15 ->
          webLocation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.webLocationSer, null)
        16 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        17 ->
          contributorship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributorshipSer,
              null,
            )
        18 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CitedArtifact: " + i)
      }
    }
    return Citation.CitedArtifact(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      relatedIdentifier = relatedIdentifier ?: listOf(),
      dateAccessed = DateTime.of(dateAccessed?.let { FhirDateTime.fromString(it) }, _dateAccessed),
      version = version,
      currentState = currentState ?: listOf(),
      statusDate = statusDate ?: listOf(),
      title = title ?: listOf(),
      `abstract` = `abstract` ?: listOf(),
      part = part,
      relatesTo = relatesTo ?: listOf(),
      publicationForm = publicationForm ?: listOf(),
      webLocation = webLocation ?: listOf(),
      classification = classification ?: listOf(),
      contributorship = contributorship,
      note = note ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Citation.CitedArtifact) {
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, value.identifier)
    if (value.relatedIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        Hoisted.identifierSer,
        value.relatedIdentifier,
      )
    ((value.dateAccessed?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 5, it)
    }
    (value.dateAccessed?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.dateAccessedSer, it)
    }
    (value.version)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.versionSer, it)
    }
    if (value.currentState.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.currentStateSer, value.currentState)
    if (value.statusDate.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.statusDateSer, value.statusDate)
    if (value.title.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.titleSer, value.title)
    if (value.`abstract`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.abstractSer, value.`abstract`)
    (value.part)?.let { encoder.encodeSerializableElement(descriptor, 12, Hoisted.partSer, it) }
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.relatesToSer, value.relatesTo)
    if (value.publicationForm.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        Hoisted.publicationFormSer,
        value.publicationForm,
      )
    if (value.webLocation.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.webLocationSer, value.webLocation)
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16,
        Hoisted.classificationSer,
        value.classification,
      )
    (value.contributorship)?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.contributorshipSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val dateAccessedSer: KSerializer<Element> = Element.serializer()

    public val versionSer: KSerializer<Citation.CitedArtifact.Version> =
      Citation.CitedArtifact.Version.serializer()

    public val currentStateSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val currentStateSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.currentStateSerInner)

    public val statusDateSerInner: KSerializer<Citation.CitedArtifact.StatusDate> =
      Citation.CitedArtifact.StatusDate.serializer()

    public val statusDateSer: KSerializer<List<Citation.CitedArtifact.StatusDate>> =
      ListSerializer(Hoisted.statusDateSerInner)

    public val titleSerInner: KSerializer<Citation.CitedArtifact.Title> =
      Citation.CitedArtifact.Title.serializer()

    public val titleSer: KSerializer<List<Citation.CitedArtifact.Title>> =
      ListSerializer(Hoisted.titleSerInner)

    public val abstractSerInner: KSerializer<Citation.CitedArtifact.Abstract> =
      Citation.CitedArtifact.Abstract.serializer()

    public val abstractSer: KSerializer<List<Citation.CitedArtifact.Abstract>> =
      ListSerializer(Hoisted.abstractSerInner)

    public val partSer: KSerializer<Citation.CitedArtifact.Part> =
      Citation.CitedArtifact.Part.serializer()

    public val relatesToSerInner: KSerializer<Citation.CitedArtifact.RelatesTo> =
      Citation.CitedArtifact.RelatesTo.serializer()

    public val relatesToSer: KSerializer<List<Citation.CitedArtifact.RelatesTo>> =
      ListSerializer(Hoisted.relatesToSerInner)

    public val publicationFormSerInner: KSerializer<Citation.CitedArtifact.PublicationForm> =
      Citation.CitedArtifact.PublicationForm.serializer()

    public val publicationFormSer: KSerializer<List<Citation.CitedArtifact.PublicationForm>> =
      ListSerializer(Hoisted.publicationFormSerInner)

    public val webLocationSerInner: KSerializer<Citation.CitedArtifact.WebLocation> =
      Citation.CitedArtifact.WebLocation.serializer()

    public val webLocationSer: KSerializer<List<Citation.CitedArtifact.WebLocation>> =
      ListSerializer(Hoisted.webLocationSerInner)

    public val classificationSerInner: KSerializer<Citation.CitedArtifact.Classification> =
      Citation.CitedArtifact.Classification.serializer()

    public val classificationSer: KSerializer<List<Citation.CitedArtifact.Classification>> =
      ListSerializer(Hoisted.classificationSerInner)

    public val contributorshipSer: KSerializer<Citation.CitedArtifact.Contributorship> =
      Citation.CitedArtifact.Contributorship.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object CitationCitedArtifactVersionSerializer :
  KSerializer<Citation.CitedArtifact.Version> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Version") {
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
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
      element("baseCitation", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Version =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Version) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.CitedArtifact.Version {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var baseCitation: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> `value` = decoder.decodeStringElement(descriptor, i)
        4 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        5 ->
          baseCitation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseCitationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Version: " + i)
      }
    }
    return Citation.CitedArtifact.Version(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        R5String.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on Citation.CitedArtifact.Version"
          ),
      baseCitation = baseCitation,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.Version,
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
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueSer, it)
    }
    (value.baseCitation)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.baseCitationSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueSer: KSerializer<Element> = Element.serializer()

    public val baseCitationSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CitationCitedArtifactStatusDateSerializer :
  KSerializer<Citation.CitedArtifact.StatusDate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StatusDate") {
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
      element("activity", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actual", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_actual", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.StatusDate =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.StatusDate) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.CitedArtifact.StatusDate {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var activity: CodeableConcept? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var period: Period? = null
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
          activity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.activitySer, null)
        4 -> `actual` = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _actual =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actualSer, null)
        6 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StatusDate: " + i)
      }
    }
    return Citation.CitedArtifact.StatusDate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      activity =
        activity
          ?: throw SerializationException(
            "Missing required property 'activity' on Citation.CitedArtifact.StatusDate"
          ),
      `actual` = R5Boolean.of(`actual`, _actual),
      period =
        period
          ?: throw SerializationException(
            "Missing required property 'period' on Citation.CitedArtifact.StatusDate"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.StatusDate,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.activitySer, value.activity)
    ((value.`actual`?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.`actual`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.actualSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 6, Hoisted.periodSer, value.period)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val activitySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actualSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object CitationCitedArtifactTitleSerializer : KSerializer<Citation.CitedArtifact.Title> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Title") {
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
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("language", CodeableConcept.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Title =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Title) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.CitedArtifact.Title {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var language: CodeableConcept? = null
    var text: KotlinString? = null
    var _text: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSerInner, null)
        5 -> text = decoder.decodeStringElement(descriptor, i)
        6 -> _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Title: " + i)
      }
    }
    return Citation.CitedArtifact.Title(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: listOf(),
      language = language,
      text =
        Markdown.of(text, _text)
          ?: throw SerializationException(
            "Missing required property 'text' on Citation.CitedArtifact.Title"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Citation.CitedArtifact.Title) {
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
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    (value.language)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSerInner, it)
    }
    ((value.text.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.text.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.textSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val textSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CitationCitedArtifactAbstractSerializer :
  KSerializer<Citation.CitedArtifact.Abstract> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Abstract") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("language", CodeableConcept.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Abstract =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Abstract) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.CitedArtifact.Abstract {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var language: CodeableConcept? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          language = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> text = decoder.decodeStringElement(descriptor, i)
        6 -> _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 -> copyright = decoder.decodeStringElement(descriptor, i)
        8 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Abstract: " + i)
      }
    }
    return Citation.CitedArtifact.Abstract(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      language = language,
      text =
        Markdown.of(text, _text)
          ?: throw SerializationException(
            "Missing required property 'text' on Citation.CitedArtifact.Abstract"
          ),
      copyright = Markdown.of(copyright, _copyright),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.Abstract,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    (value.language)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    ((value.text.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.text.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.textSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.textSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val textSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CitationCitedArtifactPartSerializer : KSerializer<Citation.CitedArtifact.Part> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Part") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
      element("baseCitation", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Part =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Part) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.CitedArtifact.Part {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var baseCitation: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> `value` = decoder.decodeStringElement(descriptor, i)
        5 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        6 ->
          baseCitation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.baseCitationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Part: " + i)
      }
    }
    return Citation.CitedArtifact.Part(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      `value` = R5String.of(`value`, _value),
      baseCitation = baseCitation,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Citation.CitedArtifact.Part) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    ((value.`value`?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueSer, it)
    }
    (value.baseCitation)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.baseCitationSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()

    public val baseCitationSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CitationCitedArtifactRelatesToSerializer :
  KSerializer<Citation.CitedArtifact.RelatesTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatesTo") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element(
        "classifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("label", KotlinString.serializer().descriptor, isOptional = true)
      element("_label", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
      element("citation", KotlinString.serializer().descriptor, isOptional = true)
      element("_citation", Element.serializer().descriptor, isOptional = true)
      element("document", Attachment.serializer().descriptor, isOptional = true)
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", Element.serializer().descriptor, isOptional = true)
      element("resourceReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.RelatesTo =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.RelatesTo) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.CitedArtifact.RelatesTo {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var classifier: List<CodeableConcept>? = null
    var label: KotlinString? = null
    var _label: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var citation: KotlinString? = null
    var _citation: Element? = null
    var document: Attachment? = null
    var resource: KotlinString? = null
    var _resource: Element? = null
    var resourceReference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          classifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classifierSer, null)
        6 -> label = decoder.decodeStringElement(descriptor, i)
        7 ->
          _label = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 -> display = decoder.decodeStringElement(descriptor, i)
        9 ->
          _display = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        10 -> citation = decoder.decodeStringElement(descriptor, i)
        11 ->
          _citation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        12 ->
          document =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentSer, null)
        13 -> resource = decoder.decodeStringElement(descriptor, i)
        14 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        15 ->
          resourceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resourceReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatesTo: " + i)
      }
    }
    return Citation.CitedArtifact.RelatesTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          Citation.RelatedArtifactTypeExpanded.fromCode(
            type
              ?: throw SerializationException(
                "Missing required property 'type' on Citation.CitedArtifact.RelatesTo"
              )
          ),
          _type,
        ),
      classifier = classifier ?: listOf(),
      label = R5String.of(label, _label),
      display = R5String.of(display, _display),
      citation = Markdown.of(citation, _citation),
      document = document,
      resource = Canonical.of(resource, _resource),
      resourceReference = resourceReference,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.RelatesTo,
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
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.classifierSer, value.classifier)
    ((value.label?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.typeSer, it)
    }
    ((value.citation?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.citation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.typeSer, it)
    }
    (value.document)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.documentSer, it)
    }
    ((value.resource?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.typeSer, it)
    }
    (value.resourceReference)?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.resourceReferenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val classifierSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.classifierSerInner)

    public val documentSer: KSerializer<Attachment> = Attachment.serializer()

    public val resourceReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CitationCitedArtifactPublicationFormSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PublicationForm") {
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
        "publishedIn",
        lazyDescriptor {
          Citation.CitedArtifact.PublicationForm.PublishedIn.serializer().descriptor
        },
        isOptional = true,
      )
      element("citedMedium", CodeableConcept.serializer().descriptor, isOptional = true)
      element("volume", KotlinString.serializer().descriptor, isOptional = true)
      element("_volume", Element.serializer().descriptor, isOptional = true)
      element("issue", KotlinString.serializer().descriptor, isOptional = true)
      element("_issue", Element.serializer().descriptor, isOptional = true)
      element("articleDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_articleDate", Element.serializer().descriptor, isOptional = true)
      element("publicationDateText", KotlinString.serializer().descriptor, isOptional = true)
      element("_publicationDateText", Element.serializer().descriptor, isOptional = true)
      element("publicationDateSeason", KotlinString.serializer().descriptor, isOptional = true)
      element("_publicationDateSeason", Element.serializer().descriptor, isOptional = true)
      element("lastRevisionDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastRevisionDate", Element.serializer().descriptor, isOptional = true)
      element(
        "language",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("accessionNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_accessionNumber", Element.serializer().descriptor, isOptional = true)
      element("pageString", KotlinString.serializer().descriptor, isOptional = true)
      element("_pageString", Element.serializer().descriptor, isOptional = true)
      element("firstPage", KotlinString.serializer().descriptor, isOptional = true)
      element("_firstPage", Element.serializer().descriptor, isOptional = true)
      element("lastPage", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastPage", Element.serializer().descriptor, isOptional = true)
      element("pageCount", KotlinString.serializer().descriptor, isOptional = true)
      element("_pageCount", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.PublicationForm =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.PublicationForm) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Citation.CitedArtifact.PublicationForm {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var publishedIn: Citation.CitedArtifact.PublicationForm.PublishedIn? = null
    var citedMedium: CodeableConcept? = null
    var volume: KotlinString? = null
    var _volume: Element? = null
    var issue: KotlinString? = null
    var _issue: Element? = null
    var articleDate: KotlinString? = null
    var _articleDate: Element? = null
    var publicationDateText: KotlinString? = null
    var _publicationDateText: Element? = null
    var publicationDateSeason: KotlinString? = null
    var _publicationDateSeason: Element? = null
    var lastRevisionDate: KotlinString? = null
    var _lastRevisionDate: Element? = null
    var language: List<CodeableConcept>? = null
    var accessionNumber: KotlinString? = null
    var _accessionNumber: Element? = null
    var pageString: KotlinString? = null
    var _pageString: Element? = null
    var firstPage: KotlinString? = null
    var _firstPage: Element? = null
    var lastPage: KotlinString? = null
    var _lastPage: Element? = null
    var pageCount: KotlinString? = null
    var _pageCount: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
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
          publishedIn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.publishedInSer, null)
        4 ->
          citedMedium =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.citedMediumSer, null)
        5 -> volume = decoder.decodeStringElement(descriptor, i)
        6 ->
          _volume =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        7 -> issue = decoder.decodeStringElement(descriptor, i)
        8 ->
          _issue = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        9 -> articleDate = decoder.decodeStringElement(descriptor, i)
        10 ->
          _articleDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        11 -> publicationDateText = decoder.decodeStringElement(descriptor, i)
        12 ->
          _publicationDateText =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        13 -> publicationDateSeason = decoder.decodeStringElement(descriptor, i)
        14 ->
          _publicationDateSeason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        15 -> lastRevisionDate = decoder.decodeStringElement(descriptor, i)
        16 ->
          _lastRevisionDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        17 ->
          language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        18 -> accessionNumber = decoder.decodeStringElement(descriptor, i)
        19 ->
          _accessionNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        20 -> pageString = decoder.decodeStringElement(descriptor, i)
        21 ->
          _pageString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        22 -> firstPage = decoder.decodeStringElement(descriptor, i)
        23 ->
          _firstPage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        24 -> lastPage = decoder.decodeStringElement(descriptor, i)
        25 ->
          _lastPage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        26 -> pageCount = decoder.decodeStringElement(descriptor, i)
        27 ->
          _pageCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        28 -> copyright = decoder.decodeStringElement(descriptor, i)
        29 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.volumeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PublicationForm: " + i)
      }
    }
    return Citation.CitedArtifact.PublicationForm(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      publishedIn = publishedIn,
      citedMedium = citedMedium,
      volume = R5String.of(volume, _volume),
      issue = R5String.of(issue, _issue),
      articleDate = DateTime.of(articleDate?.let { FhirDateTime.fromString(it) }, _articleDate),
      publicationDateText = R5String.of(publicationDateText, _publicationDateText),
      publicationDateSeason = R5String.of(publicationDateSeason, _publicationDateSeason),
      lastRevisionDate =
        DateTime.of(lastRevisionDate?.let { FhirDateTime.fromString(it) }, _lastRevisionDate),
      language = language ?: listOf(),
      accessionNumber = R5String.of(accessionNumber, _accessionNumber),
      pageString = R5String.of(pageString, _pageString),
      firstPage = R5String.of(firstPage, _firstPage),
      lastPage = R5String.of(lastPage, _lastPage),
      pageCount = R5String.of(pageCount, _pageCount),
      copyright = Markdown.of(copyright, _copyright),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.PublicationForm,
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
    (value.publishedIn)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.publishedInSer, it)
    }
    (value.citedMedium)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.citedMediumSer, it)
    }
    ((value.volume?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.volume?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.volumeSer, it)
    }
    ((value.issue?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.issue?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.volumeSer, it)
    }
    ((value.articleDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.articleDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.volumeSer, it)
    }
    ((value.publicationDateText?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.publicationDateText?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.volumeSer, it)
    }
    ((value.publicationDateSeason?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.publicationDateSeason?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.volumeSer, it)
    }
    ((value.lastRevisionDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 15, it)
    }
    (value.lastRevisionDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.volumeSer, it)
    }
    if (value.language.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.languageSer, value.language)
    ((value.accessionNumber?.value))?.let { encoder.encodeStringElement(descriptor, 18, it) }
    (value.accessionNumber?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.volumeSer, it)
    }
    ((value.pageString?.value))?.let { encoder.encodeStringElement(descriptor, 20, it) }
    (value.pageString?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.volumeSer, it)
    }
    ((value.firstPage?.value))?.let { encoder.encodeStringElement(descriptor, 22, it) }
    (value.firstPage?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.volumeSer, it)
    }
    ((value.lastPage?.value))?.let { encoder.encodeStringElement(descriptor, 24, it) }
    (value.lastPage?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.volumeSer, it)
    }
    ((value.pageCount?.value))?.let { encoder.encodeStringElement(descriptor, 26, it) }
    (value.pageCount?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.volumeSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(descriptor, 28, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.volumeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val publishedInSer: KSerializer<Citation.CitedArtifact.PublicationForm.PublishedIn> =
      Citation.CitedArtifact.PublicationForm.PublishedIn.serializer()

    public val citedMediumSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val volumeSer: KSerializer<Element> = Element.serializer()

    public val languageSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.citedMediumSer)
  }
}

internal object CitationCitedArtifactPublicationFormPublishedInSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm.PublishedIn> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PublishedIn") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("publisher", Reference.serializer().descriptor, isOptional = true)
      element("publisherLocation", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisherLocation", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.PublicationForm.PublishedIn =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.PublicationForm.PublishedIn,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Citation.CitedArtifact.PublicationForm.PublishedIn {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var identifier: List<Identifier>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var publisher: Reference? = null
    var publisherLocation: KotlinString? = null
    var _publisherLocation: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        5 -> title = decoder.decodeStringElement(descriptor, i)
        6 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        7 ->
          publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.publisherSer, null)
        8 -> publisherLocation = decoder.decodeStringElement(descriptor, i)
        9 ->
          _publisherLocation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.titleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PublishedIn: " + i)
      }
    }
    return Citation.CitedArtifact.PublicationForm.PublishedIn(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      identifier = identifier ?: listOf(),
      title = R5String.of(title, _title),
      publisher = publisher,
      publisherLocation = R5String.of(publisherLocation, _publisherLocation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.PublicationForm.PublishedIn,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.identifierSer, value.identifier)
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.titleSer, it)
    }
    (value.publisher)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.publisherSer, it)
    }
    ((value.publisherLocation?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.publisherLocation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.titleSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val publisherSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CitationCitedArtifactWebLocationSerializer :
  KSerializer<Citation.CitedArtifact.WebLocation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("WebLocation") {
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
        "classifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.WebLocation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.WebLocation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Citation.CitedArtifact.WebLocation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var classifier: List<CodeableConcept>? = null
    var url: KotlinString? = null
    var _url: Element? = null
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
          classifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classifierSer, null)
        4 -> url = decoder.decodeStringElement(descriptor, i)
        5 -> _url = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.urlSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding WebLocation: " + i)
      }
    }
    return Citation.CitedArtifact.WebLocation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      classifier = classifier ?: listOf(),
      url = Uri.of(url, _url),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.WebLocation,
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
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.classifierSer, value.classifier)
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.urlSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val classifierSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.classifierSerInner)

    public val urlSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CitationCitedArtifactClassificationSerializer :
  KSerializer<Citation.CitedArtifact.Classification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Classification") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "classifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "artifactAssessment",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Classification =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Classification) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Citation.CitedArtifact.Classification {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var classifier: List<CodeableConcept>? = null
    var artifactAssessment: List<Reference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          classifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classifierSer, null)
        5 ->
          artifactAssessment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.artifactAssessmentSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Classification: " + i)
      }
    }
    return Citation.CitedArtifact.Classification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      classifier = classifier ?: listOf(),
      artifactAssessment = artifactAssessment ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.Classification,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.classifierSer, value.classifier)
    if (value.artifactAssessment.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        Hoisted.artifactAssessmentSer,
        value.artifactAssessment,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val artifactAssessmentSerInner: KSerializer<Reference> = Reference.serializer()

    public val artifactAssessmentSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.artifactAssessmentSerInner)
  }
}

internal object CitationCitedArtifactContributorshipSerializer :
  KSerializer<Citation.CitedArtifact.Contributorship> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contributorship") {
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
      element("complete", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_complete", Element.serializer().descriptor, isOptional = true)
      element(
        "entry",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.Contributorship.Entry.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "summary",
        listSerialDescriptor(
          lazyDescriptor { Citation.CitedArtifact.Contributorship.Summary.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Contributorship) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Citation.CitedArtifact.Contributorship {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var complete: KotlinBoolean? = null
    var _complete: Element? = null
    var entry: List<Citation.CitedArtifact.Contributorship.Entry>? = null
    var summary: List<Citation.CitedArtifact.Contributorship.Summary>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> complete = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _complete =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.completeSer, null)
        5 ->
          entry = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entrySer, null)
        6 ->
          summary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.summarySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contributorship: " + i)
      }
    }
    return Citation.CitedArtifact.Contributorship(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      complete = R5Boolean.of(complete, _complete),
      entry = entry ?: listOf(),
      summary = summary ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.Contributorship,
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
    ((value.complete?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.complete?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.completeSer, it)
    }
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.entrySer, value.entry)
    if (value.summary.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.summarySer, value.summary)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val completeSer: KSerializer<Element> = Element.serializer()

    public val entrySerInner: KSerializer<Citation.CitedArtifact.Contributorship.Entry> =
      Citation.CitedArtifact.Contributorship.Entry.serializer()

    public val entrySer: KSerializer<List<Citation.CitedArtifact.Contributorship.Entry>> =
      ListSerializer(Hoisted.entrySerInner)

    public val summarySerInner: KSerializer<Citation.CitedArtifact.Contributorship.Summary> =
      Citation.CitedArtifact.Contributorship.Summary.serializer()

    public val summarySer: KSerializer<List<Citation.CitedArtifact.Contributorship.Summary>> =
      ListSerializer(Hoisted.summarySerInner)
  }
}

internal object CitationCitedArtifactContributorshipEntrySerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Entry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entry") {
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
      element("contributor", Reference.serializer().descriptor, isOptional = true)
      element("forenameInitials", KotlinString.serializer().descriptor, isOptional = true)
      element("_forenameInitials", Element.serializer().descriptor, isOptional = true)
      element(
        "affiliation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "contributionType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "contributionInstance",
        listSerialDescriptor(
          lazyDescriptor {
            Citation.CitedArtifact.Contributorship.Entry.ContributionInstance.serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
      element("correspondingContact", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_correspondingContact", Element.serializer().descriptor, isOptional = true)
      element("rankingOrder", Int.serializer().descriptor, isOptional = true)
      element("_rankingOrder", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Entry =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Contributorship.Entry) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Citation.CitedArtifact.Contributorship.Entry {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contributor: Reference? = null
    var forenameInitials: KotlinString? = null
    var _forenameInitials: Element? = null
    var affiliation: List<Reference>? = null
    var contributionType: List<CodeableConcept>? = null
    var role: CodeableConcept? = null
    var contributionInstance:
      List<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance>? =
      null
    var correspondingContact: KotlinBoolean? = null
    var _correspondingContact: Element? = null
    var rankingOrder: Int? = null
    var _rankingOrder: Element? = null
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
          contributor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contributorSer, null)
        4 -> forenameInitials = decoder.decodeStringElement(descriptor, i)
        5 ->
          _forenameInitials =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.forenameInitialsSer,
              null,
            )
        6 ->
          affiliation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.affiliationSer, null)
        7 ->
          contributionType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributionTypeSer,
              null,
            )
        8 ->
          role =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributionTypeSerInner,
              null,
            )
        9 ->
          contributionInstance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contributionInstanceSer,
              null,
            )
        10 -> correspondingContact = decoder.decodeBooleanElement(descriptor, i)
        11 ->
          _correspondingContact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.forenameInitialsSer,
              null,
            )
        12 -> rankingOrder = decoder.decodeIntElement(descriptor, i)
        13 ->
          _rankingOrder =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.forenameInitialsSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entry: " + i)
      }
    }
    return Citation.CitedArtifact.Contributorship.Entry(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      contributor =
        contributor
          ?: throw SerializationException(
            "Missing required property 'contributor' on Citation.CitedArtifact.Contributorship.Entry"
          ),
      forenameInitials = R5String.of(forenameInitials, _forenameInitials),
      affiliation = affiliation ?: listOf(),
      contributionType = contributionType ?: listOf(),
      role = role,
      contributionInstance = contributionInstance ?: listOf(),
      correspondingContact = R5Boolean.of(correspondingContact, _correspondingContact),
      rankingOrder = PositiveInt.of(rankingOrder, _rankingOrder),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.contributorSer, value.contributor)
    ((value.forenameInitials?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.forenameInitials?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.forenameInitialsSer, it)
    }
    if (value.affiliation.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.affiliationSer, value.affiliation)
    if (value.contributionType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        Hoisted.contributionTypeSer,
        value.contributionType,
      )
    (value.role)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.contributionTypeSerInner, it)
    }
    if (value.contributionInstance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        Hoisted.contributionInstanceSer,
        value.contributionInstance,
      )
    ((value.correspondingContact?.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
    (value.correspondingContact?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.forenameInitialsSer, it)
    }
    ((value.rankingOrder?.value))?.let { encoder.encodeIntElement(descriptor, 12, it) }
    (value.rankingOrder?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.forenameInitialsSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contributorSer: KSerializer<Reference> = Reference.serializer()

    public val forenameInitialsSer: KSerializer<Element> = Element.serializer()

    public val affiliationSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.contributorSer)

    public val contributionTypeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val contributionTypeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.contributionTypeSerInner)

    public val contributionInstanceSerInner:
      KSerializer<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance> =
      Citation.CitedArtifact.Contributorship.Entry.ContributionInstance.serializer()

    public val contributionInstanceSer:
      KSerializer<List<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance>> =
      ListSerializer(Hoisted.contributionInstanceSerInner)
  }
}

internal object CitationCitedArtifactContributorshipEntryContributionInstanceSerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContributionInstance") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("time", KotlinString.serializer().descriptor, isOptional = true)
      element("_time", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.Contributorship.Entry.ContributionInstance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry.ContributionInstance,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Citation.CitedArtifact.Contributorship.Entry.ContributionInstance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var time: KotlinString? = null
    var _time: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> time = decoder.decodeStringElement(descriptor, i)
        5 -> _time = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContributionInstance: " + i)
      }
    }
    return Citation.CitedArtifact.Contributorship.Entry.ContributionInstance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on Citation.CitedArtifact.Contributorship.Entry.ContributionInstance"
          ),
      time = DateTime.of(time?.let { FhirDateTime.fromString(it) }, _time),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry.ContributionInstance,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.timeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val timeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CitationCitedArtifactContributorshipSummarySerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Summary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Summary") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("style", CodeableConcept.serializer().descriptor, isOptional = true)
      element("source", CodeableConcept.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Summary =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Summary,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Citation.CitedArtifact.Contributorship.Summary {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var style: CodeableConcept? = null
    var source: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> style = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          source = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> `value` = decoder.decodeStringElement(descriptor, i)
        7 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Summary: " + i)
      }
    }
    return Citation.CitedArtifact.Contributorship.Summary(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      style = style,
      source = source,
      `value` =
        Markdown.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on Citation.CitedArtifact.Contributorship.Summary"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Citation.CitedArtifact.Contributorship.Summary,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    (value.style)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    (value.source)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it) }
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CitationSerializer : KSerializer<Citation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Citation") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "summary",
      listSerialDescriptor(lazyDescriptor { Citation.Summary.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "classification",
      listSerialDescriptor(lazyDescriptor { Citation.Classification.serializer().descriptor }),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "currentState",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "statusDate",
      listSerialDescriptor(lazyDescriptor { Citation.StatusDate.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "citedArtifact",
      lazyDescriptor { Citation.CitedArtifact.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Citation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Citation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Citation")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Citation {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var summary: List<Citation.Summary>? = null
    var classification: List<Citation.Classification>? = null
    var note: List<Annotation>? = null
    var currentState: List<CodeableConcept>? = null
    var statusDate: List<Citation.StatusDate>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var citedArtifact: Citation.CitedArtifact? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        42 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        44 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        46 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        47 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        48 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        49 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        50 ->
          summary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.summarySer, null)
        51 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        52 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        53 ->
          currentState =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        54 ->
          statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusDateSer, null)
        55 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        56 ->
          citedArtifact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.citedArtifactSer, null)
        else -> throw SerializationException("Unexpected index decoding Citation: " + i)
      }
    }
    return Citation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R5String.of(version, _version),
      versionAlgorithm =
        Citation.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(
            status ?: throw SerializationException("Missing required property 'status' on Citation")
          ),
          _status,
        ),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(approvalDate?.let { FhirDate.fromString(it) }, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate?.let { FhirDate.fromString(it) }, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      summary = summary ?: listOf(),
      classification = classification ?: listOf(),
      note = note ?: listOf(),
      currentState = currentState ?: listOf(),
      statusDate = statusDate ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      citedArtifact = citedArtifact,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Citation,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is Citation.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is Citation.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.summary.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.summarySer,
        value.summary,
      )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.classificationSer,
        value.classification,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.currentState.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.currentState,
      )
    if (value.statusDate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        Hoisted.statusDateSer,
        value.statusDate,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.citedArtifact)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        Hoisted.citedArtifactSer,
        it,
      )
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

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val summarySerInner: KSerializer<Citation.Summary> = Citation.Summary.serializer()

    public val summarySer: KSerializer<List<Citation.Summary>> =
      ListSerializer(Hoisted.summarySerInner)

    public val classificationSerInner: KSerializer<Citation.Classification> =
      Citation.Classification.serializer()

    public val classificationSer: KSerializer<List<Citation.Classification>> =
      ListSerializer(Hoisted.classificationSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val statusDateSerInner: KSerializer<Citation.StatusDate> =
      Citation.StatusDate.serializer()

    public val statusDateSer: KSerializer<List<Citation.StatusDate>> =
      ListSerializer(Hoisted.statusDateSerInner)

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val citedArtifactSer: KSerializer<Citation.CitedArtifact> =
      Citation.CitedArtifact.serializer()
  }
}

internal object CitationPolymorphicSerializer : KSerializer<Citation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Citation") { CitationSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Citation) {
    encoder.encodeStructure(descriptor) {
      CitationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Citation =
    decoder.decodeStructure(descriptor) {
      CitationSerializer.deserializeInternal(this, descriptor, 0)
    }
}

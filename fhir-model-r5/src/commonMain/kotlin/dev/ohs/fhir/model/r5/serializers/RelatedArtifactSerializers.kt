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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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

internal object RelatedArtifactSerializer : KSerializer<RelatedArtifact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedArtifact") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element(
        "classifier",
        listSerialDescriptor(lazyDescriptor { CodeableConcept.serializer().descriptor }),
        isOptional = true,
      )
      element("label", KotlinString.serializer().descriptor, isOptional = true)
      element("_label", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("citation", KotlinString.serializer().descriptor, isOptional = true)
      element("_citation", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("document", lazyDescriptor { Attachment.serializer().descriptor }, isOptional = true)
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element(
        "resourceReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element("publicationStatus", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_publicationStatus",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("publicationDate", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_publicationDate",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): RelatedArtifact =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): RelatedArtifact {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
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
    var publicationStatus: KotlinString? = null
    var _publicationStatus: Element? = null
    var publicationDate: KotlinString? = null
    var _publicationDate: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(descriptor, i)
        3 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          classifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classifierSer, null)
        5 -> label = decoder.decodeStringElement(descriptor, i)
        6 ->
          _label = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> display = decoder.decodeStringElement(descriptor, i)
        8 ->
          _display = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        9 -> citation = decoder.decodeStringElement(descriptor, i)
        10 ->
          _citation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        11 ->
          document =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentSer, null)
        12 -> resource = decoder.decodeStringElement(descriptor, i)
        13 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 ->
          resourceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.resourceReferenceSer,
              null,
            )
        15 -> publicationStatus = decoder.decodeStringElement(descriptor, i)
        16 ->
          _publicationStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        17 -> publicationDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _publicationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedArtifact: " + i)
      }
    }
    return RelatedArtifact(
      id = id,
      extension = extension ?: listOf(),
      type = Enumeration.of(RelatedArtifact.RelatedArtifactType.fromCode(type!!), _type),
      classifier = classifier ?: listOf(),
      label = R5String.of(label, _label),
      display = R5String.of(display, _display),
      citation = Markdown.of(citation, _citation),
      document = document,
      resource = Canonical.of(resource, _resource),
      resourceReference = resourceReference,
      publicationStatus =
        publicationStatus?.let {
          Enumeration.of(PublicationStatus.fromCode(it), _publicationStatus)
        },
      publicationDate = Date.of(FhirDate.fromString(publicationDate), _publicationDate),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: RelatedArtifact) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it)
    }
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.classifierSer, value.classifier)
    ((value.label?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, it)
    }
    ((value.citation?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.citation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.typeSer, it)
    }
    (value.document)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.documentSer, it)
    }
    ((value.resource?.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.typeSer, it)
    }
    (value.resourceReference)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.resourceReferenceSer, it)
    }
    ((value.publicationStatus?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 15, it)
    }
    (value.publicationStatus?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.typeSer, it)
    }
    ((value.publicationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17, it)
    }
    (value.publicationDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.typeSer, it)
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

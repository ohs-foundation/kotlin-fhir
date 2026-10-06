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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object RelatedArtifactSerializer : KSerializer<RelatedArtifact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedArtifact") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("label", KotlinString.serializer().descriptor)
      optionalElement("_label", ElementSerializer.descriptor)
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", ElementSerializer.descriptor)
      optionalElement("citation", KotlinString.serializer().descriptor)
      optionalElement("_citation", ElementSerializer.descriptor)
      optionalElement("document", AttachmentSerializer.descriptor)
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", ElementSerializer.descriptor)
      optionalElement("resourceReference", ReferenceSerializer.descriptor)
      optionalElement("publicationStatus", KotlinString.serializer().descriptor)
      optionalElement("_publicationStatus", ElementSerializer.descriptor)
      optionalElement("publicationDate", KotlinString.serializer().descriptor)
      optionalElement("_publicationDate", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<RelatedArtifact>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): RelatedArtifact =
    decoder.decodeStructure(descriptor) {
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
          2 -> type = decodeStringElement(descriptor, i)
          3 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 ->
            classifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 -> label = decodeStringElement(descriptor, i)
          6 -> _label = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> display = decodeStringElement(descriptor, i)
          8 -> _display = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> citation = decodeStringElement(descriptor, i)
          10 ->
            _citation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            document = decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          12 -> resource = decodeStringElement(descriptor, i)
          13 ->
            _resource = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            resourceReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          15 -> publicationStatus = decodeStringElement(descriptor, i)
          16 ->
            _publicationStatus =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> publicationDate = decodeStringElement(descriptor, i)
          18 ->
            _publicationDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatedArtifact: " + i)
        }
      }
      RelatedArtifact(
        id = id,
        extension = extension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) RelatedArtifact.RelatedArtifactType.fromCode(type) else null,
            _type,
          ) ?: throw SerializationException("Missing required property 'type' on RelatedArtifact"),
        classifier = classifier ?: listOf(),
        label = R5String.of(label, _label),
        display = R5String.of(display, _display),
        citation = Markdown.of(citation, _citation),
        document = document,
        resource = Canonical.of(resource, _resource),
        resourceReference = resourceReference,
        publicationStatus =
          Enumeration.of(
            if (publicationStatus != null) PublicationStatus.fromCode(publicationStatus) else null,
            _publicationStatus,
          ),
        publicationDate =
          Date.of(
            if (publicationDate != null) FhirDate.fromString(publicationDate) else null,
            _publicationDate,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.type)
      if (value.classifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.classifier,
        )
      encodeStringIfNotNull(descriptor, 5, value.label?.value)
      encodeElementIfNotNull(descriptor, 6, value.label)
      encodeStringIfNotNull(descriptor, 7, value.display?.value)
      encodeElementIfNotNull(descriptor, 8, value.display)
      encodeStringIfNotNull(descriptor, 9, value.citation?.value)
      encodeElementIfNotNull(descriptor, 10, value.citation)
      encodeSerializableIfNotNull(descriptor, 11, AttachmentSerializer, value.document)
      encodeStringIfNotNull(descriptor, 12, value.resource?.value)
      encodeElementIfNotNull(descriptor, 13, value.resource)
      encodeSerializableIfNotNull(descriptor, 14, ReferenceSerializer, value.resourceReference)
      encodeStringIfNotNull(descriptor, 15, value.publicationStatus?.value?.code)
      encodeElementIfNotNull(descriptor, 16, value.publicationStatus)
      encodeStringIfNotNull(descriptor, 17, value.publicationDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 18, value.publicationDate)
    }
  }
}

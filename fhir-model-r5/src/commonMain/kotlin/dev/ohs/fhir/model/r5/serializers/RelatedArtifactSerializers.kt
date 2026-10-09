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
import dev.ohs.fhir.model.r5.terminologies.RelatedArtifactType
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object RelatedArtifactSerializer : FhirSerializer<RelatedArtifact> {
  override val descriptor: SerialDescriptor = buildDescriptor("RelatedArtifact", this)

  @JvmField internal val listSerializer: KSerializer<List<RelatedArtifact>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("type")
    b.optionalElement(
      "classifier",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.CodeableConceptSerializer)),
    )
    b.strPrim("label")
    b.strPrim("display")
    b.strPrim("citation")
    b.optionalElement("document", lazyDescriptor(LazyDescriptorId.AttachmentSerializer))
    b.strPrim("resource")
    b.optionalElement("resourceReference", lazyDescriptor(LazyDescriptorId.ReferenceSerializer))
    b.strPrim("publicationStatus")
    b.strPrim("publicationDate")
  }

  override fun deserialize(decoder: Decoder): RelatedArtifact {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: RelatedArtifactType? = null
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
    var publicationStatus: PublicationStatus? = null
    var _publicationStatus: Element? = null
    var publicationDate: FhirDate? = null
    var _publicationDate: Element? = null
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
          type = RelatedArtifactType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        3 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 ->
          classifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 -> label = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _label =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> citation = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _citation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          document =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        12 -> resource = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          resourceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        15 ->
          publicationStatus =
            PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _publicationStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          publicationDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _publicationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RelatedArtifact(
      id = id,
      extension = listOrEmpty(extension),
      type = required(Enumeration.of(type, _type), "RelatedArtifact", "type"),
      classifier = listOrEmpty(classifier),
      label = R5String.of(label, _label),
      display = R5String.of(display, _display),
      citation = Markdown.of(citation, _citation),
      document = document,
      resource = Canonical.of(resource, _resource),
      resourceReference = resourceReference,
      publicationStatus = Enumeration.of(publicationStatus, _publicationStatus),
      publicationDate = Date.of(publicationDate, _publicationDate),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.type)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.classifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.label?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.label)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.display)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.citation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.citation)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      AttachmentSerializer,
      value.document,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.resource?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.resource)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      ReferenceSerializer,
      value.resourceReference,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.publicationStatus?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.publicationStatus)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17, value.publicationDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.publicationDate)
    compositeEncoder.endStructure(descriptor)
  }
}

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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RelatedArtifact {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(__desc, 2)
        3 -> _type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          classifier =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.classifierSer, null)
        5 -> label = decoder.decodeStringElement(__desc, 5)
        6 -> _label = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 -> display = decoder.decodeStringElement(__desc, 7)
        8 -> _display = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSer, null)
        9 -> citation = decoder.decodeStringElement(__desc, 9)
        10 ->
          _citation = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.typeSer, null)
        11 ->
          document =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.documentSer, null)
        12 -> resource = decoder.decodeStringElement(__desc, 12)
        13 ->
          _resource = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.typeSer, null)
        14 ->
          resourceReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.resourceReferenceSer,
              null,
            )
        15 -> publicationStatus = decoder.decodeStringElement(__desc, 15)
        16 ->
          _publicationStatus =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.typeSer, null)
        17 -> publicationDate = decoder.decodeStringElement(__desc, 17)
        18 ->
          _publicationDate =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedArtifact: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: RelatedArtifact) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it)
    }
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.classifierSer, value.classifier)
    ((value.label?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it)
    }
    ((value.citation?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.citation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.typeSer, it)
    }
    (value.document)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.documentSer, it) }
    ((value.resource?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.typeSer, it)
    }
    (value.resourceReference)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.resourceReferenceSer, it)
    }
    ((value.publicationStatus?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 15, it)
    }
    (value.publicationStatus?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.typeSer, it)
    }
    ((value.publicationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 17, it)
    }
    (value.publicationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.typeSer, it)
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

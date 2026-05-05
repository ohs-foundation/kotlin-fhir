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

import dev.ohs.fhir.model.r5.ArtifactAssessment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
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
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object ArtifactAssessmentContentSerializer : KSerializer<ArtifactAssessment.Content> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Content") {
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
      element("informationType", KotlinString.serializer().descriptor, isOptional = true)
      element("_informationType", Element.serializer().descriptor, isOptional = true)
      element("summary", KotlinString.serializer().descriptor, isOptional = true)
      element("_summary", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "classifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("author", Reference.serializer().descriptor, isOptional = true)
      element("path", listSerialDescriptor(KotlinString.serializer().descriptor), isOptional = true)
      element("_path", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element("freeToShare", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_freeToShare", Element.serializer().descriptor, isOptional = true)
      element(
        "component",
        listSerialDescriptor(lazyDescriptor { ArtifactAssessment.Content.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ArtifactAssessment.Content =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ArtifactAssessment.Content) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ArtifactAssessment.Content {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var informationType: KotlinString? = null
    var _informationType: Element? = null
    var summary: KotlinString? = null
    var _summary: Element? = null
    var type: CodeableConcept? = null
    var classifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var author: Reference? = null
    var path: List<KotlinString?>? = null
    var _path: List<Element?>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var freeToShare: KotlinBoolean? = null
    var _freeToShare: Element? = null
    var component: List<ArtifactAssessment.Content>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> informationType = decoder.decodeStringElement(__desc, __i)
        4 ->
          _informationType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.informationTypeSer, null)
        5 -> summary = decoder.decodeStringElement(__desc, __i)
        6 ->
          _summary =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.informationTypeSer, null)
        7 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        8 ->
          classifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.classifierSer, null)
        9 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        10 ->
          author = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.authorSer, null)
        11 -> path = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.pathSer, null)
        12 -> _path = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.pathSer2, null)
        13 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relatedArtifactSer, null)
        14 -> freeToShare = decoder.decodeBooleanElement(__desc, __i)
        15 ->
          _freeToShare =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.informationTypeSer, null)
        16 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.componentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Content: " + __i)
      }
    }
    return ArtifactAssessment.Content(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      informationType =
        informationType?.let {
          Enumeration.of(
            ArtifactAssessment.ArtifactAssessmentInformationType.fromCode(it),
            _informationType,
          )
        },
      summary = Markdown.of(summary, _summary),
      type = type,
      classifier = classifier ?: listOf(),
      quantity = quantity,
      author = author,
      path =
        (kotlin.collections.List(maxOf(path?.size ?: 0, _path?.size ?: 0)) { __i ->
          Uri.of(path?.getOrNull(__i)?.let { it }, _path?.getOrNull(__i))!!
        }),
      relatedArtifact = relatedArtifact ?: listOf(),
      freeToShare = R5Boolean.of(freeToShare, _freeToShare),
      component = component ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ArtifactAssessment.Content) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.informationType?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.informationType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.informationTypeSer, it)
    }
    ((value.summary?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.summary?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.informationTypeSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it) }
    if (value.classifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.classifierSer, value.classifier)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.quantitySer, it) }
    (value.author)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.authorSer, it) }
    (value.path.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.pathSer, it)
    }
    (value.path.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.pathSer2, it)
    }
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        13,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.freeToShare?.value))?.let { encoder.encodeBooleanElement(__desc, 14, it) }
    (value.freeToShare?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.informationTypeSer, it)
    }
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.componentSer, value.component)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val informationTypeSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val authorSer: KSerializer<Reference> = Reference.serializer()

    public val pathSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val pathSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.pathSerInner).nullable)

    public val pathSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.informationTypeSer).nullable)

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val componentSerInner: KSerializer<ArtifactAssessment.Content> =
      ArtifactAssessment.Content.serializer()

    public val componentSer: KSerializer<List<ArtifactAssessment.Content>> =
      ListSerializer(Hoisted.componentSerInner)
  }
}

internal object ArtifactAssessmentSerializer : KSerializer<ArtifactAssessment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ArtifactAssessment") {
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
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("citeAsReference", Reference.serializer().descriptor, isOptional = true)
    b.element("citeAsMarkdown", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_citeAsMarkdown", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("artifactReference", Reference.serializer().descriptor, isOptional = true)
    b.element("artifactCanonical", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_artifactCanonical", Element.serializer().descriptor, isOptional = true)
    b.element("artifactUri", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_artifactUri", Element.serializer().descriptor, isOptional = true)
    b.element(
      "content",
      listSerialDescriptor(lazyDescriptor { ArtifactAssessment.Content.serializer().descriptor }),
      isOptional = true,
    )
    b.element("workflowStatus", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_workflowStatus", Element.serializer().descriptor, isOptional = true)
    b.element("disposition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_disposition", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): ArtifactAssessment =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: ArtifactAssessment) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "ArtifactAssessment")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): ArtifactAssessment {
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
    var title: KotlinString? = null
    var _title: Element? = null
    var citeAsReference: Reference? = null
    var citeAsMarkdown: KotlinString? = null
    var _citeAsMarkdown: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var artifactReference: Reference? = null
    var artifactCanonical: KotlinString? = null
    var _artifactCanonical: Element? = null
    var artifactUri: KotlinString? = null
    var _artifactUri: Element? = null
    var content: List<ArtifactAssessment.Content>? = null
    var workflowStatus: KotlinString? = null
    var _workflowStatus: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
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
        11 -> title = decoder.decodeStringElement(__desc, __i)
        12 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          citeAsReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.citeAsReferenceSer, null)
        14 -> citeAsMarkdown = decoder.decodeStringElement(__desc, __i)
        15 ->
          _citeAsMarkdown =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 -> date = decoder.decodeStringElement(__desc, __i)
        17 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 -> copyright = decoder.decodeStringElement(__desc, __i)
        19 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> approvalDate = decoder.decodeStringElement(__desc, __i)
        21 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> lastReviewDate = decoder.decodeStringElement(__desc, __i)
        23 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 ->
          artifactReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.citeAsReferenceSer, null)
        25 -> artifactCanonical = decoder.decodeStringElement(__desc, __i)
        26 ->
          _artifactCanonical =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 -> artifactUri = decoder.decodeStringElement(__desc, __i)
        28 ->
          _artifactUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        29 ->
          content = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contentSer, null)
        30 -> workflowStatus = decoder.decodeStringElement(__desc, __i)
        31 ->
          _workflowStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 -> disposition = decoder.decodeStringElement(__desc, __i)
        33 ->
          _disposition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        else -> throw SerializationException("Unexpected index decoding ArtifactAssessment: " + __i)
      }
    }
    return ArtifactAssessment(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      title = R5String.of(title, _title),
      citeAs =
        ArtifactAssessment.CiteAs.from(
          citeAsReference,
          Markdown.of(citeAsMarkdown, _citeAsMarkdown),
        ),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      artifact =
        ArtifactAssessment.Artifact.from(
          artifactReference,
          Canonical.of(artifactCanonical, _artifactCanonical),
          Uri.of(artifactUri, _artifactUri),
        )!!,
      content = content ?: listOf(),
      workflowStatus =
        workflowStatus?.let {
          Enumeration.of(
            ArtifactAssessment.ArtifactAssessmentWorkflowStatus.fromCode(it),
            _workflowStatus,
          )
        },
      disposition =
        disposition?.let {
          Enumeration.of(
            ArtifactAssessment.ArtifactAssessmentDisposition.fromCode(it),
            _disposition,
          )
        },
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: ArtifactAssessment,
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
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.citeAs) {
      null -> {}
      is ArtifactAssessment.CiteAs.Reference -> {
        encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.citeAsReferenceSer, __d.value)
      }
      is ArtifactAssessment.CiteAs.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 20 + __off, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 22 + __off, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.artifact) {
      null -> {}
      is ArtifactAssessment.Artifact.Reference -> {
        encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.citeAsReferenceSer, __d.value)
      }
      is ArtifactAssessment.Artifact.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 25 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
        }
      }
      is ArtifactAssessment.Artifact.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 27 + __off, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.content.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.contentSer, value.content)
    ((value.workflowStatus?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 30 + __off, it)
    }
    (value.workflowStatus?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.disposition?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 32 + __off, it)
    }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.implicitRulesSer, it)
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

    public val citeAsReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val contentSerInner: KSerializer<ArtifactAssessment.Content> =
      ArtifactAssessment.Content.serializer()

    public val contentSer: KSerializer<List<ArtifactAssessment.Content>> =
      ListSerializer(Hoisted.contentSerInner)
  }
}

internal object ArtifactAssessmentPolymorphicSerializer : KSerializer<ArtifactAssessment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ArtifactAssessment") {
      ArtifactAssessmentSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: ArtifactAssessment) {
    encoder.encodeStructure(descriptor) {
      ArtifactAssessmentSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): ArtifactAssessment =
    decoder.decodeStructure(descriptor) {
      ArtifactAssessmentSerializer.deserializeJson(this, descriptor, 0)
    }
}

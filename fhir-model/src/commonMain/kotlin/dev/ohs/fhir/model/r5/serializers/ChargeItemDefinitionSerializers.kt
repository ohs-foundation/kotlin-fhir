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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.ChargeItemDefinition
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.MonetaryComponent
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object ChargeItemDefinitionApplicabilitySerializer :
  KSerializer<ChargeItemDefinition.Applicability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Applicability") {
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
      element("condition", Expression.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("relatedArtifact", RelatedArtifact.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.Applicability =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.Applicability) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ChargeItemDefinition.Applicability {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var condition: Expression? = null
    var effectivePeriod: Period? = null
    var relatedArtifact: RelatedArtifact? = null
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
          condition =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.conditionSer, null)
        4 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.effectivePeriodSer, null)
        5 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.relatedArtifactSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Applicability: " + __i)
      }
    }
    return ChargeItemDefinition.Applicability(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      condition = condition,
      effectivePeriod = effectivePeriod,
      relatedArtifact = relatedArtifact,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ChargeItemDefinition.Applicability,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.condition)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.conditionSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.effectivePeriodSer, it)
    }
    (value.relatedArtifact)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.relatedArtifactSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val conditionSer: KSerializer<Expression> = Expression.serializer()

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSer: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()
  }
}

internal object ChargeItemDefinitionPropertyGroupSerializer :
  KSerializer<ChargeItemDefinition.PropertyGroup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PropertyGroup") {
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
        "applicability",
        listSerialDescriptor(
          lazyDescriptor { ChargeItemDefinition.Applicability.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "priceComponent",
        listSerialDescriptor(MonetaryComponent.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.PropertyGroup =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.PropertyGroup) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ChargeItemDefinition.PropertyGroup {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var applicability: List<ChargeItemDefinition.Applicability>? = null
    var priceComponent: List<MonetaryComponent>? = null
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
          applicability =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.applicabilitySer, null)
        4 ->
          priceComponent =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.priceComponentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PropertyGroup: " + __i)
      }
    }
    return ChargeItemDefinition.PropertyGroup(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      applicability = applicability ?: listOf(),
      priceComponent = priceComponent ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ChargeItemDefinition.PropertyGroup,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.applicability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.applicabilitySer, value.applicability)
    if (value.priceComponent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.priceComponentSer, value.priceComponent)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val applicabilitySerInner: KSerializer<ChargeItemDefinition.Applicability> =
      ChargeItemDefinition.Applicability.serializer()

    public val applicabilitySer: KSerializer<List<ChargeItemDefinition.Applicability>> =
      ListSerializer(Hoisted.applicabilitySerInner)

    public val priceComponentSerInner: KSerializer<MonetaryComponent> =
      MonetaryComponent.serializer()

    public val priceComponentSer: KSerializer<List<MonetaryComponent>> =
      ListSerializer(Hoisted.priceComponentSerInner)
  }
}

internal object ChargeItemDefinitionVersionAlgorithmSerializer :
  KSerializer<ChargeItemDefinition.VersionAlgorithm> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItemDefinition.VersionAlgorithm") {
      element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.VersionAlgorithm) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is ChargeItemDefinition.VersionAlgorithm.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is ChargeItemDefinition.VersionAlgorithm.Coding -> {
          encodeSerializableElement(__desc, 2, Hoisted.versionAlgorithmCodingSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.VersionAlgorithm =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): ChargeItemDefinition.VersionAlgorithm {
    val __desc = descriptor
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 0)
        1 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              2,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ChargeItemDefinition.VersionAlgorithm: " + __i
          )
      }
    }
    return ChargeItemDefinition.VersionAlgorithm.from(
      R5String.of(versionAlgorithmString, _versionAlgorithmString),
      versionAlgorithmCoding,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object ChargeItemDefinitionSerializer : KSerializer<ChargeItemDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItemDefinition") {
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
      element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
      element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element(
        "derivedFromUri",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_derivedFromUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "partOf",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_partOf", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "replaces",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_replaces", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
      element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_approvalDate", Element.serializer().descriptor, isOptional = true)
      element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "instance",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "applicability",
        listSerialDescriptor(
          lazyDescriptor { ChargeItemDefinition.Applicability.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "propertyGroup",
        listSerialDescriptor(
          lazyDescriptor { ChargeItemDefinition.PropertyGroup.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ChargeItemDefinition {
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
    var derivedFromUri: List<KotlinString?>? = null
    var _derivedFromUri: List<Element?>? = null
    var partOf: List<KotlinString?>? = null
    var _partOf: List<Element?>? = null
    var replaces: List<KotlinString?>? = null
    var _replaces: List<Element?>? = null
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
    var code: CodeableConcept? = null
    var instance: List<Reference>? = null
    var applicability: List<ChargeItemDefinition.Applicability>? = null
    var propertyGroup: List<ChargeItemDefinition.PropertyGroup>? = null
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> versionAlgorithmString = decoder.decodeStringElement(__desc, 16)
        17 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        19 -> name = decoder.decodeStringElement(__desc, 19)
        20 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> title = decoder.decodeStringElement(__desc, 21)
        22 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          derivedFromUri =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.derivedFromUriSer, null)
        24 ->
          _derivedFromUri =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.derivedFromUriSer2, null)
        25 ->
          partOf =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.derivedFromUriSer, null)
        26 ->
          _partOf =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.derivedFromUriSer2, null)
        27 ->
          replaces =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.derivedFromUriSer, null)
        28 ->
          _replaces =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.derivedFromUriSer2, null)
        29 -> status = decoder.decodeStringElement(__desc, 29)
        30 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> experimental = decoder.decodeBooleanElement(__desc, 31)
        32 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 -> date = decoder.decodeStringElement(__desc, 33)
        34 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 -> publisher = decoder.decodeStringElement(__desc, 35)
        36 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.contactSer, null)
        38 -> description = decoder.decodeStringElement(__desc, 38)
        39 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.useContextSer, null)
        41 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.jurisdictionSer, null)
        42 -> purpose = decoder.decodeStringElement(__desc, 42)
        43 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 -> copyright = decoder.decodeStringElement(__desc, 44)
        45 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 -> copyrightLabel = decoder.decodeStringElement(__desc, 46)
        47 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.implicitRulesSer, null)
        48 -> approvalDate = decoder.decodeStringElement(__desc, 48)
        49 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.implicitRulesSer, null)
        50 -> lastReviewDate = decoder.decodeStringElement(__desc, 50)
        51 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.implicitRulesSer, null)
        52 ->
          code =
            decoder.decodeNullableSerializableElement(
              __desc,
              52,
              Hoisted.jurisdictionSerInner,
              null,
            )
        53 ->
          instance =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.instanceSer, null)
        54 ->
          applicability =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.applicabilitySer, null)
        55 ->
          propertyGroup =
            decoder.decodeNullableSerializableElement(__desc, 55, Hoisted.propertyGroupSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ChargeItemDefinition: " + __i)
      }
    }
    return ChargeItemDefinition(
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
        ChargeItemDefinition.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      derivedFromUri =
        (kotlin.collections.List(maxOf(derivedFromUri?.size ?: 0, _derivedFromUri?.size ?: 0)) { __i
          ->
          Uri.of(derivedFromUri?.getOrNull(__i)?.let { it }, _derivedFromUri?.getOrNull(__i))!!
        }),
      partOf =
        (kotlin.collections.List(maxOf(partOf?.size ?: 0, _partOf?.size ?: 0)) { __i ->
          Canonical.of(partOf?.getOrNull(__i)?.let { it }, _partOf?.getOrNull(__i))!!
        }),
      replaces =
        (kotlin.collections.List(maxOf(replaces?.size ?: 0, _replaces?.size ?: 0)) { __i ->
          Canonical.of(replaces?.getOrNull(__i)?.let { it }, _replaces?.getOrNull(__i))!!
        }),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      code = code,
      instance = instance ?: listOf(),
      applicability = applicability ?: listOf(),
      propertyGroup = propertyGroup ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ChargeItemDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ChargeItemDefinition")
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.versionAlgorithm) {
      null -> {}
      is ChargeItemDefinition.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is ChargeItemDefinition.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.versionAlgorithmCodingSer, __d.value)
      }
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.derivedFromUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.derivedFromUriSer, it)
    }
    (value.derivedFromUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.derivedFromUriSer2, it)
    }
    (value.partOf.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.derivedFromUriSer, it)
    }
    (value.partOf.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.derivedFromUriSer2, it)
    }
    (value.replaces.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.derivedFromUriSer, it)
    }
    (value.replaces.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.derivedFromUriSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 31, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 44, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 46, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 48, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 49, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 50, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 51, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 52, Hoisted.jurisdictionSerInner, it)
    }
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.instanceSer, value.instance)
    if (value.applicability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54, Hoisted.applicabilitySer, value.applicability)
    if (value.propertyGroup.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 55, Hoisted.propertyGroupSer, value.propertyGroup)
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

    public val derivedFromUriSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val derivedFromUriSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.derivedFromUriSerInner).nullable)

    public val derivedFromUriSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val instanceSerInner: KSerializer<Reference> = Reference.serializer()

    public val instanceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.instanceSerInner)

    public val applicabilitySerInner: KSerializer<ChargeItemDefinition.Applicability> =
      ChargeItemDefinition.Applicability.serializer()

    public val applicabilitySer: KSerializer<List<ChargeItemDefinition.Applicability>> =
      ListSerializer(Hoisted.applicabilitySerInner)

    public val propertyGroupSerInner: KSerializer<ChargeItemDefinition.PropertyGroup> =
      ChargeItemDefinition.PropertyGroup.serializer()

    public val propertyGroupSer: KSerializer<List<ChargeItemDefinition.PropertyGroup>> =
      ListSerializer(Hoisted.propertyGroupSerInner)
  }
}

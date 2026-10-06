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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Permission
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object PermissionJustificationSerializer : KSerializer<Permission.Justification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Justification") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("basis", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("evidence", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Permission.Justification>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Justification =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var basis: List<CodeableConcept>? = null
      var evidence: List<Reference>? = null
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
            basis =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            evidence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Justification: " + i)
        }
      }
      Permission.Justification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        basis = basis ?: listOf(),
        evidence = evidence ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Justification) {
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
      if (value.basis.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.basis,
        )
      if (value.evidence.isNotEmpty())
        encodeSerializableElement(descriptor, 4, ReferenceSerializer.listSerializer, value.evidence)
    }
  }
}

internal object PermissionRuleSerializer : KSerializer<Permission.Rule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rule") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", String.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("data", PermissionRuleDataSerializer.listSerializer.descriptor)
      optionalElement("activity", PermissionRuleActivitySerializer.listSerializer.descriptor)
      optionalElement("limit", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Permission.Rule>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Rule =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: String? = null
      var _type: Element? = null
      var `data`: List<Permission.Rule.Data>? = null
      var activity: List<Permission.Rule.Activity>? = null
      var limit: List<CodeableConcept>? = null
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            `data` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PermissionRuleDataSerializer.listSerializer,
                null,
              )
          6 ->
            activity =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PermissionRuleActivitySerializer.listSerializer,
                null,
              )
          7 ->
            limit =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Rule: " + i)
        }
      }
      Permission.Rule(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) Permission.ConsentProvisionType.fromCode(type) else null,
            _type,
          ),
        `data` = `data` ?: listOf(),
        activity = activity ?: listOf(),
        limit = limit ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule) {
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
      encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      if (value.`data`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          PermissionRuleDataSerializer.listSerializer,
          value.`data`,
        )
      if (value.activity.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          PermissionRuleActivitySerializer.listSerializer,
          value.activity,
        )
      if (value.limit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.limit,
        )
    }
  }
}

internal object PermissionRuleDataSerializer : KSerializer<Permission.Rule.Data> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Data") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("resource", PermissionRuleDataResourceSerializer.listSerializer.descriptor)
      optionalElement("security", CodingSerializer.listSerializer.descriptor)
      optionalElement("period", PeriodSerializer.listSerializer.descriptor)
      optionalElement("expression", ExpressionSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Permission.Rule.Data>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Rule.Data =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var resource: List<Permission.Rule.Data.Resource>? = null
      var security: List<Coding>? = null
      var period: List<Period>? = null
      var expression: Expression? = null
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
            resource =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PermissionRuleDataResourceSerializer.listSerializer,
                null,
              )
          4 ->
            security =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          5 ->
            period =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PeriodSerializer.listSerializer,
                null,
              )
          6 ->
            expression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Data: " + i)
        }
      }
      Permission.Rule.Data(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        resource = resource ?: listOf(),
        security = security ?: listOf(),
        period = period ?: listOf(),
        expression = expression,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Data) {
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
      if (value.resource.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          PermissionRuleDataResourceSerializer.listSerializer,
          value.resource,
        )
      if (value.security.isNotEmpty())
        encodeSerializableElement(descriptor, 4, CodingSerializer.listSerializer, value.security)
      if (value.period.isNotEmpty())
        encodeSerializableElement(descriptor, 5, PeriodSerializer.listSerializer, value.period)
      encodeSerializableIfNotNull(descriptor, 6, ExpressionSerializer, value.expression)
    }
  }
}

internal object PermissionRuleDataResourceSerializer : KSerializer<Permission.Rule.Data.Resource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("meaning", String.serializer().descriptor)
      optionalElement("_meaning", ElementSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Permission.Rule.Data.Resource>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Rule.Data.Resource =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var meaning: String? = null
      var _meaning: Element? = null
      var reference: Reference? = null
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
          3 -> meaning = decodeStringElement(descriptor, i)
          4 -> _meaning = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Resource: " + i)
        }
      }
      Permission.Rule.Data.Resource(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        meaning =
          Enumeration.of(
            if (meaning != null) Permission.ConsentDataMeaning.fromCode(meaning) else null,
            _meaning,
          )
            ?: throw SerializationException(
              "Missing required property 'meaning' on Permission.Rule.Data.Resource"
            ),
        reference =
          reference
            ?: throw SerializationException(
              "Missing required property 'reference' on Permission.Rule.Data.Resource"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Data.Resource) {
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
      encodeStringIfNotNull(descriptor, 3, value.meaning.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.meaning)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.reference)
    }
  }
}

internal object PermissionRuleActivitySerializer : KSerializer<Permission.Rule.Activity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Activity") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("action", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("purpose", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Permission.Rule.Activity>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Permission.Rule.Activity =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var actor: List<Reference>? = null
      var action: List<CodeableConcept>? = null
      var purpose: List<CodeableConcept>? = null
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
            actor =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            purpose =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Activity: " + i)
        }
      }
      Permission.Rule.Activity(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        actor = actor ?: listOf(),
        action = action ?: listOf(),
        purpose = purpose ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Activity) {
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
      if (value.actor.isNotEmpty())
        encodeSerializableElement(descriptor, 3, ReferenceSerializer.listSerializer, value.actor)
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.action,
        )
      if (value.purpose.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.purpose,
        )
    }
  }
}

internal object PermissionSerializer : FhirResourceSerializer<Permission> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Permission")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("asserter", ReferenceSerializer.descriptor)
    b.optionalElement("date", stringNullableListSerializer.descriptor)
    b.optionalElement("_date", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("validity", PeriodSerializer.descriptor)
    b.optionalElement("justification", PermissionJustificationSerializer.descriptor)
    b.optionalElement("combining", String.serializer().descriptor)
    b.optionalElement("_combining", ElementSerializer.descriptor)
    b.optionalElement("rule", PermissionRuleSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Permission {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var status: String? = null
    var _status: Element? = null
    var asserter: Reference? = null
    var date: List<String?>? = null
    var _date: List<Element?>? = null
    var validity: Period? = null
    var justification: Permission.Justification? = null
    var combining: String? = null
    var _combining: Element? = null
    var rule: List<Permission.Rule>? = null
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
        10 -> status = decoder.decodeStringElement(descriptor, i)
        11 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          asserter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        13 ->
          date =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _date =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          validity =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        16 ->
          justification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PermissionJustificationSerializer,
              null,
            )
        17 -> combining = decoder.decodeStringElement(descriptor, i)
        18 ->
          _combining =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          rule =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PermissionRuleSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Permission: " + i)
      }
    }
    return Permission(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) Permission.PermissionStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Permission"),
      asserter = asserter,
      date =
        (kotlin.collections.List(maxOf(date?.size ?: 0, _date?.size ?: 0)) { index ->
          DateTime.of(
            date?.getOrNull(index)?.let { FhirDateTime.fromString(it) },
            _date?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'date' on Permission has neither a value nor an id/extension"
            )
        }),
      validity = validity,
      justification = justification,
      combining =
        Enumeration.of(
          if (combining != null) Permission.PermissionRuleCombining.fromCode(combining) else null,
          _combining,
        ) ?: throw SerializationException("Missing required property 'combining' on Permission"),
      rule = rule ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Permission,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      ReferenceSerializer,
      value.asserter,
    )
    if (value.date.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.date.map { it.value?.toString() },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.date)
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      PeriodSerializer,
      value.validity,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      PermissionJustificationSerializer,
      value.justification,
    )
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.combining.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.combining)
    if (value.rule.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        PermissionRuleSerializer.listSerializer,
        value.rule,
      )
  }
}

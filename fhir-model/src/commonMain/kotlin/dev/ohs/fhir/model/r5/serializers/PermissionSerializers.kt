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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Permission
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
import kotlin.String
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

internal object PermissionJustificationSerializer : KSerializer<Permission.Justification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Justification") {
      element("id", String.serializer().descriptor, isOptional = true)
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
        "basis",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "evidence",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Permission.Justification =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Permission.Justification) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Permission.Justification {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var basis: List<CodeableConcept>? = null
    var evidence: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> basis = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basisSer, null)
        4 ->
          evidence =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.evidenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Justification: " + __i)
      }
    }
    return Permission.Justification(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      basis = basis ?: listOf(),
      evidence = evidence ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Permission.Justification) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.basis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.basisSer, value.basis)
    if (value.evidence.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.evidenceSer, value.evidence)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val basisSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val basisSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.basisSerInner)

    public val evidenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val evidenceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.evidenceSerInner)
  }
}

internal object PermissionRuleSerializer : KSerializer<Permission.Rule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rule") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("type", String.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element(
        "data",
        listSerialDescriptor(lazyDescriptor { Permission.Rule.Data.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "activity",
        listSerialDescriptor(lazyDescriptor { Permission.Rule.Activity.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "limit",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Permission.Rule =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Permission.Rule {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: String? = null
    var _type: Element? = null
    var `data`: List<Permission.Rule.Data>? = null
    var activity: List<Permission.Rule.Activity>? = null
    var limit: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, __i)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 -> `data` = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dataSer, null)
        6 ->
          activity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.activitySer, null)
        7 -> limit = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.limitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Rule: " + __i)
      }
    }
    return Permission.Rule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type?.let { Enumeration.of(Permission.ConsentProvisionType.fromCode(it), _type) },
      `data` = `data` ?: listOf(),
      activity = activity ?: listOf(),
      limit = limit ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Permission.Rule) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    if (value.`data`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.dataSer, value.`data`)
    if (value.activity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.activitySer, value.activity)
    if (value.limit.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.limitSer, value.limit)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val dataSerInner: KSerializer<Permission.Rule.Data> = Permission.Rule.Data.serializer()

    public val dataSer: KSerializer<List<Permission.Rule.Data>> =
      ListSerializer(Hoisted.dataSerInner)

    public val activitySerInner: KSerializer<Permission.Rule.Activity> =
      Permission.Rule.Activity.serializer()

    public val activitySer: KSerializer<List<Permission.Rule.Activity>> =
      ListSerializer(Hoisted.activitySerInner)

    public val limitSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val limitSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.limitSerInner)
  }
}

internal object PermissionRuleDataSerializer : KSerializer<Permission.Rule.Data> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Data") {
      element("id", String.serializer().descriptor, isOptional = true)
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
        "resource",
        listSerialDescriptor(
          lazyDescriptor { Permission.Rule.Data.Resource.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("security", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element("period", listSerialDescriptor(Period.serializer().descriptor), isOptional = true)
      element("expression", Expression.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Permission.Rule.Data =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Data) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Permission.Rule.Data {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var resource: List<Permission.Rule.Data.Resource>? = null
    var security: List<Coding>? = null
    var period: List<Period>? = null
    var expression: Expression? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          resource =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.resourceSer, null)
        4 ->
          security =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.securitySer, null)
        5 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        6 ->
          expression =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.expressionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Data: " + __i)
      }
    }
    return Permission.Rule.Data(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      resource = resource ?: listOf(),
      security = security ?: listOf(),
      period = period ?: listOf(),
      expression = expression,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Permission.Rule.Data) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.resource.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.resourceSer, value.resource)
    if (value.security.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.securitySer, value.security)
    if (value.period.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.periodSer, value.period)
    (value.expression)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.expressionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val resourceSerInner: KSerializer<Permission.Rule.Data.Resource> =
      Permission.Rule.Data.Resource.serializer()

    public val resourceSer: KSerializer<List<Permission.Rule.Data.Resource>> =
      ListSerializer(Hoisted.resourceSerInner)

    public val securitySerInner: KSerializer<Coding> = Coding.serializer()

    public val securitySer: KSerializer<List<Coding>> = ListSerializer(Hoisted.securitySerInner)

    public val periodSerInner: KSerializer<Period> = Period.serializer()

    public val periodSer: KSerializer<List<Period>> = ListSerializer(Hoisted.periodSerInner)

    public val expressionSer: KSerializer<Expression> = Expression.serializer()
  }
}

internal object PermissionRuleDataResourceSerializer : KSerializer<Permission.Rule.Data.Resource> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Resource") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("meaning", String.serializer().descriptor, isOptional = true)
      element("_meaning", Element.serializer().descriptor, isOptional = true)
      element("reference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Permission.Rule.Data.Resource =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Data.Resource) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Permission.Rule.Data.Resource {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var meaning: String? = null
    var _meaning: Element? = null
    var reference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> meaning = decoder.decodeStringElement(__desc, __i)
        4 ->
          _meaning =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.meaningSer, null)
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Resource: " + __i)
      }
    }
    return Permission.Rule.Data.Resource(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      meaning = Enumeration.of(Permission.ConsentDataMeaning.fromCode(meaning!!), _meaning),
      reference = reference!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Permission.Rule.Data.Resource) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.meaning.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.meaning.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.meaningSer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.referenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val meaningSer: KSerializer<Element> = Element.serializer()

    public val referenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object PermissionRuleActivitySerializer : KSerializer<Permission.Rule.Activity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Activity") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("actor", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "action",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "purpose",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Permission.Rule.Activity =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Permission.Rule.Activity) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Permission.Rule.Activity {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var actor: List<Reference>? = null
    var action: List<CodeableConcept>? = null
    var purpose: List<CodeableConcept>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> actor = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actorSer, null)
        4 ->
          action = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actionSer, null)
        5 ->
          purpose = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Activity: " + __i)
      }
    }
    return Permission.Rule.Activity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      actor = actor ?: listOf(),
      action = action ?: listOf(),
      purpose = purpose ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Permission.Rule.Activity) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.actor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.actorSer, value.actor)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.actionSer, value.action)
    if (value.purpose.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.actionSer, value.purpose)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actorSerInner: KSerializer<Reference> = Reference.serializer()

    public val actorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.actorSerInner)

    public val actionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object PermissionSerializer : KSerializer<Permission> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Permission") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("asserter", Reference.serializer().descriptor, isOptional = true)
    b.element("date", listSerialDescriptor(String.serializer().descriptor), isOptional = true)
    b.element("_date", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("validity", Period.serializer().descriptor, isOptional = true)
    b.element(
      "justification",
      lazyDescriptor { Permission.Justification.serializer().descriptor },
      isOptional = true,
    )
    b.element("combining", String.serializer().descriptor, isOptional = true)
    b.element("_combining", Element.serializer().descriptor, isOptional = true)
    b.element(
      "rule",
      listSerialDescriptor(lazyDescriptor { Permission.Rule.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Permission =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Permission) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Permission")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Permission {
    val __desc = desc
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
        10 -> status = decoder.decodeStringElement(__desc, __i)
        11 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        12 ->
          asserter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.asserterSer, null)
        13 -> date = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer, null)
        14 -> _date = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer2, null)
        15 ->
          validity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.validitySer, null)
        16 ->
          justification =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.justificationSer, null)
        17 -> combining = decoder.decodeStringElement(__desc, __i)
        18 ->
          _combining =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> rule = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ruleSer, null)
        else -> throw SerializationException("Unexpected index decoding Permission: " + __i)
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
      status = Enumeration.of(Permission.PermissionStatus.fromCode(status!!), _status),
      asserter = asserter,
      date =
        (kotlin.collections.List(maxOf(date?.size ?: 0, _date?.size ?: 0)) { __i ->
          DateTime.of(
            date?.getOrNull(__i)?.let { FhirDateTime.fromString(it) },
            _date?.getOrNull(__i),
          )!!
        }),
      validity = validity,
      justification = justification,
      combining =
        Enumeration.of(Permission.PermissionRuleCombining.fromCode(combining!!), _combining),
      rule = rule ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Permission,
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.asserter)?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.asserterSer, it)
    }
    (value.date.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.dateSer, it)
    }
    (value.date.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.dateSer2, it)
    }
    (value.validity)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.validitySer, it)
    }
    (value.justification)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.justificationSer, it)
    }
    ((value.combining.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 17 + __off, it)
    }
    (value.combining.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.rule.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.ruleSer, value.rule)
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

    public val asserterSer: KSerializer<Reference> = Reference.serializer()

    public val dateSerInner: KSerializer<String> = String.serializer()

    public val dateSer: KSerializer<List<String?>> = ListSerializer((Hoisted.dateSerInner).nullable)

    public val dateSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val validitySer: KSerializer<Period> = Period.serializer()

    public val justificationSer: KSerializer<Permission.Justification> =
      Permission.Justification.serializer()

    public val ruleSerInner: KSerializer<Permission.Rule> = Permission.Rule.serializer()

    public val ruleSer: KSerializer<List<Permission.Rule>> = ListSerializer(Hoisted.ruleSerInner)
  }
}

internal object PermissionPolymorphicSerializer : KSerializer<Permission> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Permission") { PermissionSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Permission) {
    encoder.encodeStructure(descriptor) {
      PermissionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Permission =
    decoder.decodeStructure(descriptor) {
      PermissionSerializer.deserializeJson(this, descriptor, 0)
    }
}

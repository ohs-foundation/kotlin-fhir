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
import dev.ohs.fhir.model.r5.DeviceAssociation
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
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

internal object DeviceAssociationOperationSerializer : KSerializer<DeviceAssociation.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
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
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "operator",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): DeviceAssociation.Operation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: DeviceAssociation.Operation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): DeviceAssociation.Operation {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var status: CodeableConcept? = null
    var `operator`: List<Reference>? = null
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
          status = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        4 ->
          `operator` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operatorSer, null)
        5 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + i)
      }
    }
    return DeviceAssociation.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status =
        status
          ?: throw SerializationException(
            "Missing required property 'status' on DeviceAssociation.Operation"
          ),
      `operator` = `operator` ?: listOf(),
      period = period,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: DeviceAssociation.Operation) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.statusSer, value.status)
    if (value.`operator`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.operatorSer, value.`operator`)
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val statusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val operatorSerInner: KSerializer<Reference> = Reference.serializer()

    public val operatorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.operatorSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object DeviceAssociationSerializer : KSerializer<DeviceAssociation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceAssociation") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("device", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "statusReason",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("bodyStructure", Reference.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element(
      "operation",
      listSerialDescriptor(lazyDescriptor { DeviceAssociation.Operation.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): DeviceAssociation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: DeviceAssociation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "DeviceAssociation")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): DeviceAssociation {
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
    var identifier: List<Identifier>? = null
    var device: Reference? = null
    var category: List<CodeableConcept>? = null
    var status: CodeableConcept? = null
    var statusReason: List<CodeableConcept>? = null
    var subject: Reference? = null
    var bodyStructure: Reference? = null
    var period: Period? = null
    var operation: List<DeviceAssociation.Operation>? = null
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 ->
          device = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        12 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        13 ->
          status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySerInner, null)
        14 ->
          statusReason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        15 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        16 ->
          bodyStructure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        17 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        18 ->
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        else -> throw SerializationException("Unexpected index decoding DeviceAssociation: " + i)
      }
    }
    return DeviceAssociation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      device =
        device
          ?: throw SerializationException(
            "Missing required property 'device' on DeviceAssociation"
          ),
      category = category ?: listOf(),
      status =
        status
          ?: throw SerializationException(
            "Missing required property 'status' on DeviceAssociation"
          ),
      statusReason = statusReason ?: listOf(),
      subject = subject,
      bodyStructure = bodyStructure,
      period = period,
      operation = operation ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: DeviceAssociation,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      Hoisted.deviceSer,
      value.device,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    encoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      Hoisted.categorySerInner,
      value.status,
    )
    if (value.statusReason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.categorySer,
        value.statusReason,
      )
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.deviceSer, it)
    }
    (value.bodyStructure)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.deviceSer, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.periodSer, it)
    }
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.operationSer,
        value.operation,
      )
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

    public val deviceSer: KSerializer<Reference> = Reference.serializer()

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val operationSerInner: KSerializer<DeviceAssociation.Operation> =
      DeviceAssociation.Operation.serializer()

    public val operationSer: KSerializer<List<DeviceAssociation.Operation>> =
      ListSerializer(Hoisted.operationSerInner)
  }
}

internal object DeviceAssociationPolymorphicSerializer : KSerializer<DeviceAssociation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DeviceAssociation") {
      DeviceAssociationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: DeviceAssociation) {
    encoder.encodeStructure(descriptor) {
      DeviceAssociationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): DeviceAssociation =
    decoder.decodeStructure(descriptor) {
      DeviceAssociationSerializer.deserializeInternal(this, descriptor, 0)
    }
}

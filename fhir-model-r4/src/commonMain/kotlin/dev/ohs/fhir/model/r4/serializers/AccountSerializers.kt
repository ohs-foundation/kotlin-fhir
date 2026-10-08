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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Account
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.AccountStatus
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

internal object AccountCoverageSerializer : KSerializer<Account.Coverage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("coverage", ReferenceSerializer.descriptor)
      optionalElement("priority", Int.serializer().descriptor)
      optionalElement("_priority", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Account.Coverage>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Account.Coverage {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var coverage: Reference? = null
    var priority: Int? = null
    var _priority: Element? = null
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
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          coverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> priority = compositeDecoder.decodeIntElement(descriptor, i)
        5 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Coverage: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Account.Coverage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on Account.Coverage"
          ),
      priority = PositiveInt.of(priority, _priority),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Account.Coverage) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.coverage)
    compositeEncoder.encodeIntIfNotNull(descriptor, 4, value.priority?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.priority)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AccountGuarantorSerializer : KSerializer<Account.Guarantor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Guarantor") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
      optionalElement("onHold", KotlinBoolean.serializer().descriptor)
      optionalElement("_onHold", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Account.Guarantor>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Account.Guarantor {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var party: Reference? = null
    var onHold: KotlinBoolean? = null
    var _onHold: Element? = null
    var period: Period? = null
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
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          party =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> onHold = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _onHold =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Guarantor: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Account.Guarantor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      party =
        party
          ?: throw SerializationException("Missing required property 'party' on Account.Guarantor"),
      onHold = R4Boolean.of(onHold, _onHold),
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Account.Guarantor) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.party)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.onHold?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.onHold)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AccountSerializer : FhirResourceSerializer<Account> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Account")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("servicePeriod", PeriodSerializer.descriptor)
    b.optionalElement("coverage", AccountCoverageSerializer.listSerializer.descriptor)
    b.optionalElement("owner", ReferenceSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("guarantor", AccountGuarantorSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Account {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var subject: List<Reference>? = null
    var servicePeriod: Period? = null
    var coverage: List<Account.Coverage>? = null
    var owner: Reference? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var guarantor: List<Account.Guarantor>? = null
    var partOf: Reference? = null
    while (true) {
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          servicePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        18 ->
          coverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountCoverageSerializer.listSerializer,
              null,
            )
        19 ->
          owner =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          guarantor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountGuarantorSerializer.listSerializer,
              null,
            )
        23 ->
          partOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Account: " + i)
      }
    }
    return Account(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(if (status != null) AccountStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Account"),
      type = type,
      name = R4String.of(name, _name),
      subject = subject ?: listOf(),
      servicePeriod = servicePeriod,
      coverage = coverage ?: listOf(),
      owner = owner,
      description = R4String.of(description, _description),
      guarantor = guarantor ?: listOf(),
      partOf = partOf,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Account,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    if (value.subject.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subject,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      PeriodSerializer,
      value.servicePeriod,
    )
    if (value.coverage.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        AccountCoverageSerializer.listSerializer,
        value.coverage,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.description)
    if (value.guarantor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        AccountGuarantorSerializer.listSerializer,
        value.guarantor,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.partOf,
    )
  }
}

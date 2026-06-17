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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeSystem
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object CodeSystemFilterSerializer : KSerializer<CodeSystem.Filter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Filter") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "operator",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_operator", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CodeSystem.Filter =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Filter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CodeSystem.Filter {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var `operator`: List<KotlinString?>? = null
    var _operator: List<Element?>? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 ->
          `operator` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operatorSer, null)
        8 ->
          _operator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operatorSer2, null)
        9 -> `value` = decoder.decodeStringElement(descriptor, i)
        10 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + i)
      }
    }
    return CodeSystem.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      description = R5String.of(description, _description),
      `operator` =
        (kotlin.collections.List(maxOf(`operator`?.size ?: 0, _operator?.size ?: 0)) { index ->
          Enumeration.of(
            CodeSystem.FilterOperator.fromCode(`operator`?.getOrNull(index)!!),
            _operator?.getOrNull(index),
          )
        }),
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CodeSystem.Filter) {
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
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
    (value.`operator`.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.operatorSer, it)
    }
    (value.`operator`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.operatorSer2, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val operatorSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val operatorSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.operatorSerInner).nullable)

    public val operatorSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.codeSer).nullable)
  }
}

internal object CodeSystemPropertySerializer : KSerializer<CodeSystem.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("uri", KotlinString.serializer().descriptor, isOptional = true)
      element("_uri", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CodeSystem.Property =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Property) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CodeSystem.Property {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> uri = decoder.decodeStringElement(descriptor, i)
        6 -> _uri = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 -> description = decoder.decodeStringElement(descriptor, i)
        8 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        9 -> type = decoder.decodeStringElement(descriptor, i)
        10 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    return CodeSystem.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      uri = Uri.of(uri, _uri),
      description = R5String.of(description, _description),
      type = Enumeration.of(CodeSystem.PropertyType.fromCode(type!!), _type),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CodeSystem.Property) {
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
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.uri?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.codeSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CodeSystemConceptSerializer : KSerializer<CodeSystem.Concept> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Concept") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
      element("definition", KotlinString.serializer().descriptor, isOptional = true)
      element("_definition", Element.serializer().descriptor, isOptional = true)
      element(
        "designation",
        listSerialDescriptor(
          lazyDescriptor { CodeSystem.Concept.Designation.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(
          lazyDescriptor { CodeSystem.Concept.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "concept",
        listSerialDescriptor(lazyDescriptor { CodeSystem.Concept.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): CodeSystem.Concept =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CodeSystem.Concept {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var designation: List<CodeSystem.Concept.Designation>? = null
    var `property`: List<CodeSystem.Concept.Property>? = null
    var concept: List<CodeSystem.Concept>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> display = decoder.decodeStringElement(descriptor, i)
        6 ->
          _display = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 -> definition = decoder.decodeStringElement(descriptor, i)
        8 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        9 ->
          designation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.designationSer, null)
        10 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        11 ->
          concept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conceptSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Concept: " + i)
      }
    }
    return CodeSystem.Concept(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      display = R5String.of(display, _display),
      definition = R5String.of(definition, _definition),
      designation = designation ?: listOf(),
      `property` = `property` ?: listOf(),
      concept = concept ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CodeSystem.Concept) {
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
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.codeSer, it)
    }
    if (value.designation.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.designationSer, value.designation)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.propertySer, value.`property`)
    if (value.concept.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.conceptSer, value.concept)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val designationSerInner: KSerializer<CodeSystem.Concept.Designation> =
      CodeSystem.Concept.Designation.serializer()

    public val designationSer: KSerializer<List<CodeSystem.Concept.Designation>> =
      ListSerializer(Hoisted.designationSerInner)

    public val propertySerInner: KSerializer<CodeSystem.Concept.Property> =
      CodeSystem.Concept.Property.serializer()

    public val propertySer: KSerializer<List<CodeSystem.Concept.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val conceptSerInner: KSerializer<CodeSystem.Concept> = CodeSystem.Concept.serializer()

    public val conceptSer: KSerializer<List<CodeSystem.Concept>> =
      ListSerializer(Hoisted.conceptSerInner)
  }
}

internal object CodeSystemConceptDesignationSerializer :
  KSerializer<CodeSystem.Concept.Designation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Designation") {
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
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("use", Coding.serializer().descriptor, isOptional = true)
      element(
        "additionalUse",
        listSerialDescriptor(Coding.serializer().descriptor),
        isOptional = true,
      )
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CodeSystem.Concept.Designation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Designation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CodeSystem.Concept.Designation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var use: Coding? = null
    var additionalUse: List<Coding>? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> language = decoder.decodeStringElement(descriptor, i)
        4 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        5 -> use = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useSer, null)
        6 ->
          additionalUse =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.additionalUseSer, null)
        7 -> `value` = decoder.decodeStringElement(descriptor, i)
        8 ->
          _value =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Designation: " + i)
      }
    }
    return CodeSystem.Concept.Designation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = Code.of(language, _language),
      use = use,
      additionalUse = additionalUse ?: listOf(),
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CodeSystem.Concept.Designation,
  ) {
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
    ((value.language?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.languageSer, it)
    }
    (value.use)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.useSer, it) }
    if (value.additionalUse.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        Hoisted.additionalUseSer,
        value.additionalUse,
      )
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.languageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val languageSer: KSerializer<Element> = Element.serializer()

    public val useSer: KSerializer<Coding> = Coding.serializer()

    public val additionalUseSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.useSer)
  }
}

internal object CodeSystemConceptPropertySerializer : KSerializer<CodeSystem.Concept.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CodeSystem.Concept.Property =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Property) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CodeSystem.Concept.Property {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueCoding: Coding? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valueDecimal: BigDecimal? = null
    var _valueDecimal: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 -> _code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> valueCode = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        8 -> valueString = decoder.decodeStringElement(descriptor, i)
        9 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        10 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        12 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        14 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
      }
    }
    return CodeSystem.Concept.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      `value` =
        CodeSystem.Concept.Property.Value.from(
          Code.of(valueCode, _valueCode),
          valueCoding,
          R5String.of(valueString, _valueString),
          Integer.of(valueInteger, _valueInteger),
          R5Boolean.of(valueBoolean, _valueBoolean),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
        )!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: CodeSystem.Concept.Property) {
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
    ((value.code.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
    when (val choice = value.`value`) {
      is CodeSystem.Concept.Property.Value.Code -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueCodingSer, choice.value)
      }
      is CodeSystem.Concept.Property.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 16, BigDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 17, Hoisted.codeSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object CodeSystemSerializer : KSerializer<CodeSystem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CodeSystem") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_versionAlgorithmString", Element.serializer().descriptor, isOptional = true)
    b.element("versionAlgorithmCoding", Coding.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("copyrightLabel", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyrightLabel", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element(
      "topic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element("caseSensitive", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_caseSensitive", Element.serializer().descriptor, isOptional = true)
    b.element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_valueSet", Element.serializer().descriptor, isOptional = true)
    b.element("hierarchyMeaning", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_hierarchyMeaning", Element.serializer().descriptor, isOptional = true)
    b.element("compositional", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_compositional", Element.serializer().descriptor, isOptional = true)
    b.element("versionNeeded", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_versionNeeded", Element.serializer().descriptor, isOptional = true)
    b.element("content", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_content", Element.serializer().descriptor, isOptional = true)
    b.element("supplements", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_supplements", Element.serializer().descriptor, isOptional = true)
    b.element("count", Int.serializer().descriptor, isOptional = true)
    b.element("_count", Element.serializer().descriptor, isOptional = true)
    b.element(
      "filter",
      listSerialDescriptor(lazyDescriptor { CodeSystem.Filter.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "property",
      listSerialDescriptor(lazyDescriptor { CodeSystem.Property.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "concept",
      listSerialDescriptor(lazyDescriptor { CodeSystem.Concept.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): CodeSystem =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: CodeSystem) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CodeSystem")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): CodeSystem {
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
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var caseSensitive: KotlinBoolean? = null
    var _caseSensitive: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var hierarchyMeaning: KotlinString? = null
    var _hierarchyMeaning: Element? = null
    var compositional: KotlinBoolean? = null
    var _compositional: Element? = null
    var versionNeeded: KotlinBoolean? = null
    var _versionNeeded: Element? = null
    var content: KotlinString? = null
    var _content: Element? = null
    var supplements: KotlinString? = null
    var _supplements: Element? = null
    var count: Int? = null
    var _count: Element? = null
    var filter: List<CodeSystem.Filter>? = null
    var `property`: List<CodeSystem.Property>? = null
    var concept: List<CodeSystem.Concept>? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.versionAlgorithmCodingSer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        42 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        44 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        46 ->
          topic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        47 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        48 ->
          editor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        49 ->
          reviewer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        50 ->
          endorser =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        51 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.relatedArtifactSer,
              null,
            )
        52 -> caseSensitive = decoder.decodeBooleanElement(descriptor, i)
        53 ->
          _caseSensitive =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        54 -> valueSet = decoder.decodeStringElement(descriptor, i)
        55 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        56 -> hierarchyMeaning = decoder.decodeStringElement(descriptor, i)
        57 ->
          _hierarchyMeaning =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        58 -> compositional = decoder.decodeBooleanElement(descriptor, i)
        59 ->
          _compositional =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        60 -> versionNeeded = decoder.decodeBooleanElement(descriptor, i)
        61 ->
          _versionNeeded =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        62 -> content = decoder.decodeStringElement(descriptor, i)
        63 ->
          _content =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        64 -> supplements = decoder.decodeStringElement(descriptor, i)
        65 ->
          _supplements =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        66 -> count = decoder.decodeIntElement(descriptor, i)
        67 ->
          _count =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        68 ->
          filter = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.filterSer, null)
        69 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        70 ->
          concept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conceptSer, null)
        else -> throw SerializationException("Unexpected index decoding CodeSystem: " + i)
      }
    }
    return CodeSystem(
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
        CodeSystem.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
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
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      caseSensitive = R5Boolean.of(caseSensitive, _caseSensitive),
      valueSet = Canonical.of(valueSet, _valueSet),
      hierarchyMeaning =
        hierarchyMeaning?.let {
          Enumeration.of(CodeSystem.CodeSystemHierarchyMeaning.fromCode(it), _hierarchyMeaning)
        },
      compositional = R5Boolean.of(compositional, _compositional),
      versionNeeded = R5Boolean.of(versionNeeded, _versionNeeded),
      content = Enumeration.of(CodeSystem.CodeSystemContentMode.fromCode(content!!), _content),
      supplements = Canonical.of(supplements, _supplements),
      count = UnsignedInt.of(count, _count),
      filter = filter ?: listOf(),
      `property` = `property` ?: listOf(),
      concept = concept ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CodeSystem,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is CodeSystem.VersionAlgorithm.String -> {
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            16 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is CodeSystem.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          Hoisted.versionAlgorithmCodingSer,
          choice.value,
        )
      }
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 24 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyrightLabel?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.contactSer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.contactSer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.contactSer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.contactSer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.caseSensitive?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 52 + descriptorOffset, it)
    }
    (value.caseSensitive?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.valueSet?.value))?.let {
      encoder.encodeStringElement(descriptor, 54 + descriptorOffset, it)
    }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.hierarchyMeaning?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 56 + descriptorOffset, it)
    }
    (value.hierarchyMeaning?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.compositional?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 58 + descriptorOffset, it)
    }
    (value.compositional?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.versionNeeded?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 60 + descriptorOffset, it)
    }
    (value.versionNeeded?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        61 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.content.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 62 + descriptorOffset, it)
    }
    (value.content.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.supplements?.value))?.let {
      encoder.encodeStringElement(descriptor, 64 + descriptorOffset, it)
    }
    (value.supplements?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.count?.value))?.let { encoder.encodeIntElement(descriptor, 66 + descriptorOffset, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        67 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.filter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        68 + descriptorOffset,
        Hoisted.filterSer,
        value.filter,
      )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        69 + descriptorOffset,
        Hoisted.propertySer,
        value.`property`,
      )
    if (value.concept.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        70 + descriptorOffset,
        Hoisted.conceptSer,
        value.concept,
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

    public val versionAlgorithmCodingSer: KSerializer<Coding> = Coding.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val filterSerInner: KSerializer<CodeSystem.Filter> = CodeSystem.Filter.serializer()

    public val filterSer: KSerializer<List<CodeSystem.Filter>> =
      ListSerializer(Hoisted.filterSerInner)

    public val propertySerInner: KSerializer<CodeSystem.Property> = CodeSystem.Property.serializer()

    public val propertySer: KSerializer<List<CodeSystem.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val conceptSerInner: KSerializer<CodeSystem.Concept> = CodeSystem.Concept.serializer()

    public val conceptSer: KSerializer<List<CodeSystem.Concept>> =
      ListSerializer(Hoisted.conceptSerInner)
  }
}

internal object CodeSystemPolymorphicSerializer : KSerializer<CodeSystem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CodeSystem") { CodeSystemSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: CodeSystem) {
    encoder.encodeStructure(descriptor) {
      CodeSystemSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CodeSystem =
    decoder.decodeStructure(descriptor) {
      CodeSystemSerializer.deserializeInternal(this, descriptor, 0)
    }
}

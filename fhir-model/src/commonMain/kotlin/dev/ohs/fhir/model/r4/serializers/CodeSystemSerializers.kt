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

package dev.ohs.fhir.model.r4.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeSystem
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.CommonLanguages
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Filter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CodeSystem.Filter {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, __i)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> description = decoder.decodeStringElement(__desc, __i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        7 ->
          `operator` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.operatorSer, null)
        8 ->
          _operator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.operatorSer2, null)
        9 -> `value` = decoder.decodeStringElement(__desc, __i)
        10 -> _value = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + __i)
      }
    }
    return CodeSystem.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      description = R4String.of(description, _description),
      `operator` =
        (kotlin.collections.List(maxOf(`operator`?.size ?: 0, _operator?.size ?: 0)) { __i ->
          Enumeration.of(
            CodeSystem.FilterOperator.fromCode(`operator`?.getOrNull(__i)!!),
            _operator?.getOrNull(__i),
          )
        }),
      `value` = R4String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CodeSystem.Filter) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    (value.`operator`.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.operatorSer, it)
    }
    (value.`operator`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.operatorSer2, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.codeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CodeSystem.Property {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, __i)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> uri = decoder.decodeStringElement(__desc, __i)
        6 -> _uri = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        7 -> description = decoder.decodeStringElement(__desc, __i)
        8 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        9 -> type = decoder.decodeStringElement(__desc, __i)
        10 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return CodeSystem.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      uri = Uri.of(uri, _uri),
      description = R4String.of(description, _description),
      type = Enumeration.of(CodeSystem.PropertyType.fromCode(type!!), _type),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CodeSystem.Property) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.uri?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.uri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.codeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CodeSystem.Concept {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, __i)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> display = decoder.decodeStringElement(__desc, __i)
        6 ->
          _display = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        7 -> definition = decoder.decodeStringElement(__desc, __i)
        8 ->
          _definition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        9 ->
          designation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.designationSer, null)
        10 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        11 ->
          concept = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conceptSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Concept: " + __i)
      }
    }
    return CodeSystem.Concept(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      display = R4String.of(display, _display),
      definition = R4String.of(definition, _definition),
      designation = designation ?: listOf(),
      `property` = `property` ?: listOf(),
      concept = concept ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CodeSystem.Concept) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
    if (value.designation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.designationSer, value.designation)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.propertySer, value.`property`)
    if (value.concept.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.conceptSer, value.concept)
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
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CodeSystem.Concept.Designation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Designation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CodeSystem.Concept.Designation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var use: Coding? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> language = decoder.decodeStringElement(__desc, __i)
        4 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.languageSer, null)
        5 -> use = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useSer, null)
        6 -> `value` = decoder.decodeStringElement(__desc, __i)
        7 ->
          _value = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Designation: " + __i)
      }
    }
    return CodeSystem.Concept.Designation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = language?.let { Enumeration.of(CommonLanguages.fromCode(it), _language) },
      use = use,
      `value` = R4String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CodeSystem.Concept.Designation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.language?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.languageSer, it)
    }
    (value.use)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.useSer, it) }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.languageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val languageSer: KSerializer<Element> = Element.serializer()

    public val useSer: KSerializer<Coding> = Coding.serializer()
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CodeSystem.Concept.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CodeSystem.Concept.Property {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, __i)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> valueCode = decoder.decodeStringElement(__desc, __i)
        6 ->
          _valueCode = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        7 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCodingSer, null)
        8 -> valueString = decoder.decodeStringElement(__desc, __i)
        9 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        10 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        12 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        13 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        14 -> valueDateTime = decoder.decodeStringElement(__desc, __i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
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
          R4String.of(valueString, _valueString),
          Integer.of(valueInteger, _valueInteger),
          R4Boolean.of(valueBoolean, _valueBoolean),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CodeSystem.Concept.Property) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is CodeSystem.Concept.Property.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueCodingSer, __d.value)
      }
      is CodeSystem.Concept.Property.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.codeSer, it)
        }
      }
      is CodeSystem.Concept.Property.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 16, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.codeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: CodeSystem) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CodeSystem")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): CodeSystem {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
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
        10 -> url = decoder.decodeStringElement(__desc, __i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(__desc, __i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(__desc, __i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(__desc, __i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> status = decoder.decodeStringElement(__desc, __i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> experimental = decoder.decodeBooleanElement(__desc, __i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> date = decoder.decodeStringElement(__desc, __i)
        24 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 -> publisher = decoder.decodeStringElement(__desc, __i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        28 -> description = decoder.decodeStringElement(__desc, __i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.useContextSer, null)
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.jurisdictionSer, null)
        32 -> purpose = decoder.decodeStringElement(__desc, __i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        34 -> copyright = decoder.decodeStringElement(__desc, __i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        36 -> caseSensitive = decoder.decodeBooleanElement(__desc, __i)
        37 ->
          _caseSensitive =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        38 -> valueSet = decoder.decodeStringElement(__desc, __i)
        39 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        40 -> hierarchyMeaning = decoder.decodeStringElement(__desc, __i)
        41 ->
          _hierarchyMeaning =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        42 -> compositional = decoder.decodeBooleanElement(__desc, __i)
        43 ->
          _compositional =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        44 -> versionNeeded = decoder.decodeBooleanElement(__desc, __i)
        45 ->
          _versionNeeded =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        46 -> content = decoder.decodeStringElement(__desc, __i)
        47 ->
          _content =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        48 -> supplements = decoder.decodeStringElement(__desc, __i)
        49 ->
          _supplements =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        50 -> count = decoder.decodeIntElement(__desc, __i)
        51 ->
          _count =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        52 ->
          filter = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.filterSer, null)
        53 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        54 ->
          concept = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conceptSer, null)
        else -> throw SerializationException("Unexpected index decoding CodeSystem: " + __i)
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      caseSensitive = R4Boolean.of(caseSensitive, _caseSensitive),
      valueSet = Canonical.of(valueSet, _valueSet),
      hierarchyMeaning =
        hierarchyMeaning?.let {
          Enumeration.of(CodeSystem.CodeSystemHierarchyMeaning.fromCode(it), _hierarchyMeaning)
        },
      compositional = R4Boolean.of(compositional, _compositional),
      versionNeeded = R4Boolean.of(versionNeeded, _versionNeeded),
      content = Enumeration.of(CodeSystem.CodeSystemContentMode.fromCode(content!!), _content),
      supplements = Canonical.of(supplements, _supplements),
      count = UnsignedInt.of(count, _count),
      filter = filter ?: listOf(),
      `property` = `property` ?: listOf(),
      concept = concept ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: CodeSystem,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 10 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 21 + __off, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 25 + __off, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 28 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        31 + __off,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 32 + __off, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 34 + __off, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.caseSensitive?.value))?.let { encoder.encodeBooleanElement(__desc, 36 + __off, it) }
    (value.caseSensitive?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(__desc, 38 + __off, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.hierarchyMeaning?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 40 + __off, it)
    }
    (value.hierarchyMeaning?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.compositional?.value))?.let { encoder.encodeBooleanElement(__desc, 42 + __off, it) }
    (value.compositional?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.versionNeeded?.value))?.let { encoder.encodeBooleanElement(__desc, 44 + __off, it) }
    (value.versionNeeded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.content.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 46 + __off, it) }
    (value.content.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 47 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.supplements?.value))?.let { encoder.encodeStringElement(__desc, 48 + __off, it) }
    (value.supplements?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 50 + __off, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 51 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.filter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 52 + __off, Hoisted.filterSer, value.filter)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53 + __off, Hoisted.propertySer, value.`property`)
    if (value.concept.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 54 + __off, Hoisted.conceptSer, value.concept)
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

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

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
      CodeSystemSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CodeSystem =
    decoder.decodeStructure(descriptor) {
      CodeSystemSerializer.deserializeJson(this, descriptor, 0)
    }
}

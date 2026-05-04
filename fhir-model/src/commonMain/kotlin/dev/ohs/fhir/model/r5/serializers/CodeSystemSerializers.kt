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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 ->
          `operator` =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.operatorSer, null)
        8 ->
          _operator =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.operatorSer2, null)
        9 -> `value` = decoder.decodeStringElement(__desc, 9)
        10 -> _value = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Filter: " + __i)
      }
    }
    return CodeSystem.Filter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      description = R5String.of(description, _description),
      `operator` =
        (kotlin.collections.List(maxOf(`operator`?.size ?: 0, _operator?.size ?: 0)) { __i ->
          Enumeration.of(
            CodeSystem.FilterOperator.fromCode(`operator`?.getOrNull(__i)!!),
            _operator?.getOrNull(__i),
          )
        }),
      `value` = R5String.of(`value`, _value)!!,
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> uri = decoder.decodeStringElement(__desc, 5)
        6 -> _uri = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 -> description = decoder.decodeStringElement(__desc, 7)
        8 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        9 -> type = decoder.decodeStringElement(__desc, 9)
        10 -> _type = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.codeSer, null)
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
      description = R5String.of(description, _description),
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> display = decoder.decodeStringElement(__desc, 5)
        6 -> _display = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 -> definition = decoder.decodeStringElement(__desc, 7)
        8 ->
          _definition = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        9 ->
          designation =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.designationSer, null)
        10 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.propertySer, null)
        11 ->
          concept = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.conceptSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Concept: " + __i)
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
      element(
        "additionalUse",
        listSerialDescriptor(Coding.serializer().descriptor),
        isOptional = true,
      )
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
    var additionalUse: List<Coding>? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> language = decoder.decodeStringElement(__desc, 3)
        4 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.languageSer, null)
        5 -> use = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.useSer, null)
        6 ->
          additionalUse =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.additionalUseSer, null)
        7 -> `value` = decoder.decodeStringElement(__desc, 7)
        8 ->
          _value = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Designation: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: CodeSystem.Concept.Designation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.languageSer, it)
    }
    (value.use)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.useSer, it) }
    if (value.additionalUse.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.additionalUseSer, value.additionalUse)
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.languageSer, it)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 -> valueCode = decoder.decodeStringElement(__desc, 5)
        6 ->
          _valueCode = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueCodingSer, null)
        8 -> valueString = decoder.decodeStringElement(__desc, 8)
        9 ->
          _valueString = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.codeSer, null)
        10 -> valueInteger = decoder.decodeIntElement(__desc, 10)
        11 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.codeSer, null)
        12 -> valueBoolean = decoder.decodeBooleanElement(__desc, 12)
        13 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.codeSer, null)
        14 -> valueDateTime = decoder.decodeStringElement(__desc, 14)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.codeSer, null)
        16 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 16, BigDecimalSerializer, null)
        17 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.codeSer, null)
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
          R5String.of(valueString, _valueString),
          Integer.of(valueInteger, _valueInteger),
          R5Boolean.of(valueBoolean, _valueBoolean),
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
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "topic",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "author",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "editor",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reviewer",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "endorser",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element(
        "relatedArtifact",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element("caseSensitive", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_caseSensitive", Element.serializer().descriptor, isOptional = true)
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", Element.serializer().descriptor, isOptional = true)
      element("hierarchyMeaning", KotlinString.serializer().descriptor, isOptional = true)
      element("_hierarchyMeaning", Element.serializer().descriptor, isOptional = true)
      element("compositional", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_compositional", Element.serializer().descriptor, isOptional = true)
      element("versionNeeded", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_versionNeeded", Element.serializer().descriptor, isOptional = true)
      element("content", KotlinString.serializer().descriptor, isOptional = true)
      element("_content", Element.serializer().descriptor, isOptional = true)
      element("supplements", KotlinString.serializer().descriptor, isOptional = true)
      element("_supplements", Element.serializer().descriptor, isOptional = true)
      element("count", Int.serializer().descriptor, isOptional = true)
      element("_count", Element.serializer().descriptor, isOptional = true)
      element(
        "filter",
        listSerialDescriptor(lazyDescriptor { CodeSystem.Filter.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(lazyDescriptor { CodeSystem.Property.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "concept",
        listSerialDescriptor(lazyDescriptor { CodeSystem.Concept.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): CodeSystem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CodeSystem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CodeSystem {
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
        23 -> status = decoder.decodeStringElement(__desc, 23)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> experimental = decoder.decodeBooleanElement(__desc, 25)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> date = decoder.decodeStringElement(__desc, 27)
        28 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> publisher = decoder.decodeStringElement(__desc, 29)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.contactSer, null)
        32 -> description = decoder.decodeStringElement(__desc, 32)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.useContextSer, null)
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.jurisdictionSer, null)
        36 -> purpose = decoder.decodeStringElement(__desc, 36)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> copyright = decoder.decodeStringElement(__desc, 38)
        39 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> copyrightLabel = decoder.decodeStringElement(__desc, 40)
        41 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 -> approvalDate = decoder.decodeStringElement(__desc, 42)
        43 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 -> lastReviewDate = decoder.decodeStringElement(__desc, 44)
        45 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.effectivePeriodSer, null)
        47 ->
          topic =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.jurisdictionSer, null)
        48 ->
          author = decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.contactSer, null)
        49 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.contactSer, null)
        50 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.contactSer, null)
        51 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 51, Hoisted.contactSer, null)
        52 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 52, Hoisted.relatedArtifactSer, null)
        53 -> caseSensitive = decoder.decodeBooleanElement(__desc, 53)
        54 ->
          _caseSensitive =
            decoder.decodeNullableSerializableElement(__desc, 54, Hoisted.implicitRulesSer, null)
        55 -> valueSet = decoder.decodeStringElement(__desc, 55)
        56 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.implicitRulesSer, null)
        57 -> hierarchyMeaning = decoder.decodeStringElement(__desc, 57)
        58 ->
          _hierarchyMeaning =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.implicitRulesSer, null)
        59 -> compositional = decoder.decodeBooleanElement(__desc, 59)
        60 ->
          _compositional =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.implicitRulesSer, null)
        61 -> versionNeeded = decoder.decodeBooleanElement(__desc, 61)
        62 ->
          _versionNeeded =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.implicitRulesSer, null)
        63 -> content = decoder.decodeStringElement(__desc, 63)
        64 ->
          _content =
            decoder.decodeNullableSerializableElement(__desc, 64, Hoisted.implicitRulesSer, null)
        65 -> supplements = decoder.decodeStringElement(__desc, 65)
        66 ->
          _supplements =
            decoder.decodeNullableSerializableElement(__desc, 66, Hoisted.implicitRulesSer, null)
        67 -> count = decoder.decodeIntElement(__desc, 67)
        68 ->
          _count =
            decoder.decodeNullableSerializableElement(__desc, 68, Hoisted.implicitRulesSer, null)
        69 ->
          filter = decoder.decodeNullableSerializableElement(__desc, 69, Hoisted.filterSer, null)
        70 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 70, Hoisted.propertySer, null)
        71 ->
          concept = decoder.decodeNullableSerializableElement(__desc, 71, Hoisted.conceptSer, null)
        CompositeDecoder.DECODE_DONE -> break
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: CodeSystem) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "CodeSystem")
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
      is CodeSystem.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is CodeSystem.VersionAlgorithm.Coding -> {
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 25, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.copyrightLabel?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.copyrightLabel?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 44, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.effectivePeriodSer, it)
    }
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.jurisdictionSer, value.topic)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51, Hoisted.contactSer, value.endorser)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        52,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    ((value.caseSensitive?.value))?.let { encoder.encodeBooleanElement(__desc, 53, it) }
    (value.caseSensitive?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 54, Hoisted.implicitRulesSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(__desc, 55, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 56, Hoisted.implicitRulesSer, it)
    }
    ((value.hierarchyMeaning?.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 57, it)
    }
    (value.hierarchyMeaning?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 58, Hoisted.implicitRulesSer, it)
    }
    ((value.compositional?.value))?.let { encoder.encodeBooleanElement(__desc, 59, it) }
    (value.compositional?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 60, Hoisted.implicitRulesSer, it)
    }
    ((value.versionNeeded?.value))?.let { encoder.encodeBooleanElement(__desc, 61, it) }
    (value.versionNeeded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 62, Hoisted.implicitRulesSer, it)
    }
    ((value.content.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 63, it) }
    (value.content.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 64, Hoisted.implicitRulesSer, it)
    }
    ((value.supplements?.value))?.let { encoder.encodeStringElement(__desc, 65, it) }
    (value.supplements?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 66, Hoisted.implicitRulesSer, it)
    }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 67, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 68, Hoisted.implicitRulesSer, it)
    }
    if (value.filter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 69, Hoisted.filterSer, value.filter)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 70, Hoisted.propertySer, value.`property`)
    if (value.concept.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 71, Hoisted.conceptSer, value.concept)
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

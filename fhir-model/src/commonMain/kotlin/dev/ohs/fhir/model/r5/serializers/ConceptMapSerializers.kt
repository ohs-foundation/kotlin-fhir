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
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ConceptMap
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
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.ConceptMapRelationship
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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

internal object ConceptMapPropertySerializer : KSerializer<ConceptMap.Property> {
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
      element("system", KotlinString.serializer().descriptor, isOptional = true)
      element("_system", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Property {
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
    var system: KotlinString? = null
    var _system: Element? = null
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
        11 -> system = decoder.decodeStringElement(__desc, 11)
        12 -> _system = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return ConceptMap.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      uri = Uri.of(uri, _uri),
      description = R5String.of(description, _description),
      type = Enumeration.of(ConceptMap.ConceptMapPropertyType.fromCode(type!!), _type),
      system = Canonical.of(system, _system),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Property) {
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
    ((value.system?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.system?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ConceptMapAdditionalAttributeSerializer :
  KSerializer<ConceptMap.AdditionalAttribute> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AdditionalAttribute") {
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

  override fun deserialize(decoder: Decoder): ConceptMap.AdditionalAttribute =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.AdditionalAttribute) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.AdditionalAttribute {
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
        else ->
          throw SerializationException("Unexpected index decoding AdditionalAttribute: " + __i)
      }
    }
    return ConceptMap.AdditionalAttribute(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      uri = Uri.of(uri, _uri),
      description = R5String.of(description, _description),
      type = Enumeration.of(ConceptMap.ConceptMapAttributeType.fromCode(type!!), _type),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.AdditionalAttribute) {
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

internal object ConceptMapGroupSerializer : KSerializer<ConceptMap.Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
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
      element("source", KotlinString.serializer().descriptor, isOptional = true)
      element("_source", Element.serializer().descriptor, isOptional = true)
      element("target", KotlinString.serializer().descriptor, isOptional = true)
      element("_target", Element.serializer().descriptor, isOptional = true)
      element(
        "element",
        listSerialDescriptor(lazyDescriptor { ConceptMap.Group.Element.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "unmapped",
        lazyDescriptor { ConceptMap.Group.Unmapped.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var source: KotlinString? = null
    var _source: Element? = null
    var target: KotlinString? = null
    var _target: Element? = null
    var element: List<ConceptMap.Group.Element>? = null
    var unmapped: ConceptMap.Group.Unmapped? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> source = decoder.decodeStringElement(__desc, 3)
        4 -> _source = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sourceSer, null)
        5 -> target = decoder.decodeStringElement(__desc, 5)
        6 -> _target = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.sourceSer, null)
        7 ->
          element = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 ->
          unmapped = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.unmappedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Group: " + __i)
      }
    }
    return ConceptMap.Group(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      source = Canonical.of(source, _source),
      target = Canonical.of(target, _target),
      element = element ?: listOf(),
      unmapped = unmapped,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Group) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.source?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sourceSer, it)
    }
    ((value.target?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.target?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.sourceSer, it)
    }
    if (value.element.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.elementSer, value.element)
    (value.unmapped)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.unmappedSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sourceSer: KSerializer<Element> = Element.serializer()

    public val elementSerInner: KSerializer<ConceptMap.Group.Element> =
      ConceptMap.Group.Element.serializer()

    public val elementSer: KSerializer<List<ConceptMap.Group.Element>> =
      ListSerializer(Hoisted.elementSerInner)

    public val unmappedSer: KSerializer<ConceptMap.Group.Unmapped> =
      ConceptMap.Group.Unmapped.serializer()
  }
}

internal object ConceptMapGroupElementSerializer : KSerializer<ConceptMap.Group.Element> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Element") {
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
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", Element.serializer().descriptor, isOptional = true)
      element("noMap", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_noMap", Element.serializer().descriptor, isOptional = true)
      element(
        "target",
        listSerialDescriptor(
          lazyDescriptor { ConceptMap.Group.Element.Target.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group.Element {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var noMap: KotlinBoolean? = null
    var _noMap: Element? = null
    var target: List<ConceptMap.Group.Element.Target>? = null
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
        7 -> valueSet = decoder.decodeStringElement(__desc, 7)
        8 -> _valueSet = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        9 -> noMap = decoder.decodeBooleanElement(__desc, 9)
        10 -> _noMap = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.codeSer, null)
        11 ->
          target = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.targetSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Element: " + __i)
      }
    }
    return ConceptMap.Group.Element(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code),
      display = R5String.of(display, _display),
      valueSet = Canonical.of(valueSet, _valueSet),
      noMap = R5Boolean.of(noMap, _noMap),
      target = target ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Group.Element) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
    ((value.noMap?.value))?.let { encoder.encodeBooleanElement(__desc, 9, it) }
    (value.noMap?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.codeSer, it)
    }
    if (value.target.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.targetSer, value.target)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val targetSerInner: KSerializer<ConceptMap.Group.Element.Target> =
      ConceptMap.Group.Element.Target.serializer()

    public val targetSer: KSerializer<List<ConceptMap.Group.Element.Target>> =
      ListSerializer(Hoisted.targetSerInner)
  }
}

internal object ConceptMapGroupElementTargetSerializer :
  KSerializer<ConceptMap.Group.Element.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Target") {
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
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", Element.serializer().descriptor, isOptional = true)
      element("relationship", KotlinString.serializer().descriptor, isOptional = true)
      element("_relationship", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element(
        "property",
        listSerialDescriptor(
          lazyDescriptor { ConceptMap.Group.Element.Target.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "dependsOn",
        listSerialDescriptor(
          lazyDescriptor { ConceptMap.Group.Element.Target.DependsOn.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "product",
        listSerialDescriptor(
          lazyDescriptor { ConceptMap.Group.Element.Target.DependsOn.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group.Element.Target {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var relationship: KotlinString? = null
    var _relationship: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var `property`: List<ConceptMap.Group.Element.Target.Property>? = null
    var dependsOn: List<ConceptMap.Group.Element.Target.DependsOn>? = null
    var product: List<ConceptMap.Group.Element.Target.DependsOn>? = null
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
        7 -> valueSet = decoder.decodeStringElement(__desc, 7)
        8 -> _valueSet = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.codeSer, null)
        9 -> relationship = decoder.decodeStringElement(__desc, 9)
        10 ->
          _relationship =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.codeSer, null)
        11 -> comment = decoder.decodeStringElement(__desc, 11)
        12 ->
          _comment = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.codeSer, null)
        13 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.propertySer, null)
        14 ->
          dependsOn =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.dependsOnSer, null)
        15 ->
          product =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.dependsOnSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Target: " + __i)
      }
    }
    return ConceptMap.Group.Element.Target(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code),
      display = R5String.of(display, _display),
      valueSet = Canonical.of(valueSet, _valueSet),
      relationship = Enumeration.of(ConceptMapRelationship.fromCode(relationship!!), _relationship),
      comment = R5String.of(comment, _comment),
      `property` = `property` ?: listOf(),
      dependsOn = dependsOn ?: listOf(),
      product = product ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Group.Element.Target) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.codeSer, it)
    }
    ((value.relationship.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.relationship.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.codeSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.codeSer, it)
    }
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.propertySer, value.`property`)
    if (value.dependsOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.dependsOnSer, value.dependsOn)
    if (value.product.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.dependsOnSer, value.product)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val propertySerInner: KSerializer<ConceptMap.Group.Element.Target.Property> =
      ConceptMap.Group.Element.Target.Property.serializer()

    public val propertySer: KSerializer<List<ConceptMap.Group.Element.Target.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val dependsOnSerInner: KSerializer<ConceptMap.Group.Element.Target.DependsOn> =
      ConceptMap.Group.Element.Target.DependsOn.serializer()

    public val dependsOnSer: KSerializer<List<ConceptMap.Group.Element.Target.DependsOn>> =
      ListSerializer(Hoisted.dependsOnSerInner)
  }
}

internal object ConceptMapGroupElementTargetPropertySerializer :
  KSerializer<ConceptMap.Group.Element.Target.Property> {
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
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group.Element.Target.Property {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
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
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
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
        5 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueCodingSer, null)
        6 -> valueString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueString = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.codeSer, null)
        8 -> valueInteger = decoder.decodeIntElement(__desc, 8)
        9 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.codeSer, null)
        10 -> valueBoolean = decoder.decodeBooleanElement(__desc, 10)
        11 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.codeSer, null)
        12 -> valueDateTime = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.codeSer, null)
        14 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 14, BigDecimalSerializer, null)
        15 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.codeSer, null)
        16 -> valueCode = decoder.decodeStringElement(__desc, 16)
        17 ->
          _valueCode = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return ConceptMap.Group.Element.Target.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Code.of(code, _code)!!,
      `value` =
        ConceptMap.Group.Element.Target.Property.Value.from(
          valueCoding,
          R5String.of(valueString, _valueString),
          Integer.of(valueInteger, _valueInteger),
          R5Boolean.of(valueBoolean, _valueBoolean),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Decimal.of(valueDecimal, _valueDecimal),
          Code.of(valueCode, _valueCode),
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ConceptMap.Group.Element.Target.Property,
  ) {
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
      is ConceptMap.Group.Element.Target.Property.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueCodingSer, __d.value)
      }
      is ConceptMap.Group.Element.Target.Property.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.codeSer, it)
        }
      }
      is ConceptMap.Group.Element.Target.Property.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.codeSer, it)
        }
      }
      is ConceptMap.Group.Element.Target.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.codeSer, it)
        }
      }
      is ConceptMap.Group.Element.Target.Property.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.codeSer, it)
        }
      }
      is ConceptMap.Group.Element.Target.Property.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 14, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.codeSer, it)
        }
      }
      is ConceptMap.Group.Element.Target.Property.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
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

internal object ConceptMapGroupElementTargetDependsOnSerializer :
  KSerializer<ConceptMap.Group.Element.Target.DependsOn> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DependsOn") {
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
      element("attribute", KotlinString.serializer().descriptor, isOptional = true)
      element("_attribute", Element.serializer().descriptor, isOptional = true)
      element("valueCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueCode", Element.serializer().descriptor, isOptional = true)
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target.DependsOn =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target.DependsOn) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ConceptMap.Group.Element.Target.DependsOn {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var attribute: KotlinString? = null
    var _attribute: Element? = null
    var valueCode: KotlinString? = null
    var _valueCode: Element? = null
    var valueCoding: Coding? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueQuantity: Quantity? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> attribute = decoder.decodeStringElement(__desc, 3)
        4 ->
          _attribute =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.attributeSer, null)
        5 -> valueCode = decoder.decodeStringElement(__desc, 5)
        6 ->
          _valueCode =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.attributeSer, null)
        7 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueCodingSer, null)
        8 -> valueString = decoder.decodeStringElement(__desc, 8)
        9 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.attributeSer, null)
        10 -> valueBoolean = decoder.decodeBooleanElement(__desc, 10)
        11 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.attributeSer, null)
        12 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueQuantitySer, null)
        13 -> valueSet = decoder.decodeStringElement(__desc, 13)
        14 ->
          _valueSet =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.attributeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DependsOn: " + __i)
      }
    }
    return ConceptMap.Group.Element.Target.DependsOn(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      attribute = Code.of(attribute, _attribute)!!,
      `value` =
        ConceptMap.Group.Element.Target.DependsOn.Value.from(
          Code.of(valueCode, _valueCode),
          valueCoding,
          R5String.of(valueString, _valueString),
          R5Boolean.of(valueBoolean, _valueBoolean),
          valueQuantity,
        ),
      valueSet = Canonical.of(valueSet, _valueSet),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ConceptMap.Group.Element.Target.DependsOn,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.attribute.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.attribute.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.attributeSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is ConceptMap.Group.Element.Target.DependsOn.Value.Code -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.attributeSer, it)
        }
      }
      is ConceptMap.Group.Element.Target.DependsOn.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueCodingSer, __d.value)
      }
      is ConceptMap.Group.Element.Target.DependsOn.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.attributeSer, it)
        }
      }
      is ConceptMap.Group.Element.Target.DependsOn.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.attributeSer, it)
        }
      }
      is ConceptMap.Group.Element.Target.DependsOn.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valueQuantitySer, __d.value)
      }
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.attributeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val attributeSer: KSerializer<Element> = Element.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object ConceptMapGroupUnmappedSerializer : KSerializer<ConceptMap.Group.Unmapped> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Unmapped") {
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
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
      element("valueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueSet", Element.serializer().descriptor, isOptional = true)
      element("relationship", KotlinString.serializer().descriptor, isOptional = true)
      element("_relationship", Element.serializer().descriptor, isOptional = true)
      element("otherMap", KotlinString.serializer().descriptor, isOptional = true)
      element("_otherMap", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Unmapped =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Unmapped) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ConceptMap.Group.Unmapped {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var valueSet: KotlinString? = null
    var _valueSet: Element? = null
    var relationship: KotlinString? = null
    var _relationship: Element? = null
    var otherMap: KotlinString? = null
    var _otherMap: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(__desc, 3)
        4 -> _mode = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.modeSer, null)
        5 -> code = decoder.decodeStringElement(__desc, 5)
        6 -> _code = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.modeSer, null)
        7 -> display = decoder.decodeStringElement(__desc, 7)
        8 -> _display = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.modeSer, null)
        9 -> valueSet = decoder.decodeStringElement(__desc, 9)
        10 ->
          _valueSet = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.modeSer, null)
        11 -> relationship = decoder.decodeStringElement(__desc, 11)
        12 ->
          _relationship =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.modeSer, null)
        13 -> otherMap = decoder.decodeStringElement(__desc, 13)
        14 ->
          _otherMap = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.modeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Unmapped: " + __i)
      }
    }
    return ConceptMap.Group.Unmapped(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = Enumeration.of(ConceptMap.ConceptMapGroupUnmappedMode.fromCode(mode!!), _mode),
      code = Code.of(code, _code),
      display = R5String.of(display, _display),
      valueSet = Canonical.of(valueSet, _valueSet),
      relationship =
        relationship?.let { Enumeration.of(ConceptMapRelationship.fromCode(it), _relationship) },
      otherMap = Canonical.of(otherMap, _otherMap),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap.Group.Unmapped) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.modeSer, it)
    }
    ((value.code?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.code?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.modeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.modeSer, it)
    }
    ((value.valueSet?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.valueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.modeSer, it)
    }
    ((value.relationship?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.relationship?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.modeSer, it)
    }
    ((value.otherMap?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.otherMap?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.modeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ConceptMapSerializer : KSerializer<ConceptMap> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ConceptMap") {
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
      element(
        "property",
        listSerialDescriptor(lazyDescriptor { ConceptMap.Property.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "additionalAttribute",
        listSerialDescriptor(
          lazyDescriptor { ConceptMap.AdditionalAttribute.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("sourceScopeUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceScopeUri", Element.serializer().descriptor, isOptional = true)
      element("sourceScopeCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceScopeCanonical", Element.serializer().descriptor, isOptional = true)
      element("targetScopeUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetScopeUri", Element.serializer().descriptor, isOptional = true)
      element("targetScopeCanonical", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetScopeCanonical", Element.serializer().descriptor, isOptional = true)
      element(
        "group",
        listSerialDescriptor(lazyDescriptor { ConceptMap.Group.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ConceptMap =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ConceptMap) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ConceptMap {
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
    var `property`: List<ConceptMap.Property>? = null
    var additionalAttribute: List<ConceptMap.AdditionalAttribute>? = null
    var sourceScopeUri: KotlinString? = null
    var _sourceScopeUri: Element? = null
    var sourceScopeCanonical: KotlinString? = null
    var _sourceScopeCanonical: Element? = null
    var targetScopeUri: KotlinString? = null
    var _targetScopeUri: Element? = null
    var targetScopeCanonical: KotlinString? = null
    var _targetScopeCanonical: Element? = null
    var group: List<ConceptMap.Group>? = null
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
        53 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 53, Hoisted.propertySer, null)
        54 ->
          additionalAttribute =
            decoder.decodeNullableSerializableElement(
              __desc,
              54,
              Hoisted.additionalAttributeSer,
              null,
            )
        55 -> sourceScopeUri = decoder.decodeStringElement(__desc, 55)
        56 ->
          _sourceScopeUri =
            decoder.decodeNullableSerializableElement(__desc, 56, Hoisted.implicitRulesSer, null)
        57 -> sourceScopeCanonical = decoder.decodeStringElement(__desc, 57)
        58 ->
          _sourceScopeCanonical =
            decoder.decodeNullableSerializableElement(__desc, 58, Hoisted.implicitRulesSer, null)
        59 -> targetScopeUri = decoder.decodeStringElement(__desc, 59)
        60 ->
          _targetScopeUri =
            decoder.decodeNullableSerializableElement(__desc, 60, Hoisted.implicitRulesSer, null)
        61 -> targetScopeCanonical = decoder.decodeStringElement(__desc, 61)
        62 ->
          _targetScopeCanonical =
            decoder.decodeNullableSerializableElement(__desc, 62, Hoisted.implicitRulesSer, null)
        63 -> group = decoder.decodeNullableSerializableElement(__desc, 63, Hoisted.groupSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ConceptMap: " + __i)
      }
    }
    return ConceptMap(
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
        ConceptMap.VersionAlgorithm.from(
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
      `property` = `property` ?: listOf(),
      additionalAttribute = additionalAttribute ?: listOf(),
      sourceScope =
        ConceptMap.SourceScope.from(
          Uri.of(sourceScopeUri, _sourceScopeUri),
          Canonical.of(sourceScopeCanonical, _sourceScopeCanonical),
        ),
      targetScope =
        ConceptMap.TargetScope.from(
          Uri.of(targetScopeUri, _targetScopeUri),
          Canonical.of(targetScopeCanonical, _targetScopeCanonical),
        ),
      group = group ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ConceptMap) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ConceptMap")
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
      is ConceptMap.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is ConceptMap.VersionAlgorithm.Coding -> {
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
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 53, Hoisted.propertySer, value.`property`)
    if (value.additionalAttribute.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        54,
        Hoisted.additionalAttributeSer,
        value.additionalAttribute,
      )
    when (val __d = value.sourceScope) {
      null -> {}
      is ConceptMap.SourceScope.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 55, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 56, Hoisted.implicitRulesSer, it)
        }
      }
      is ConceptMap.SourceScope.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 57, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 58, Hoisted.implicitRulesSer, it)
        }
      }
    }
    when (val __d = value.targetScope) {
      null -> {}
      is ConceptMap.TargetScope.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 59, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 60, Hoisted.implicitRulesSer, it)
        }
      }
      is ConceptMap.TargetScope.Canonical -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 61, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 62, Hoisted.implicitRulesSer, it)
        }
      }
    }
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 63, Hoisted.groupSer, value.group)
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

    public val propertySerInner: KSerializer<ConceptMap.Property> = ConceptMap.Property.serializer()

    public val propertySer: KSerializer<List<ConceptMap.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val additionalAttributeSerInner: KSerializer<ConceptMap.AdditionalAttribute> =
      ConceptMap.AdditionalAttribute.serializer()

    public val additionalAttributeSer: KSerializer<List<ConceptMap.AdditionalAttribute>> =
      ListSerializer(Hoisted.additionalAttributeSerInner)

    public val groupSerInner: KSerializer<ConceptMap.Group> = ConceptMap.Group.serializer()

    public val groupSer: KSerializer<List<ConceptMap.Group>> = ListSerializer(Hoisted.groupSerInner)
  }
}

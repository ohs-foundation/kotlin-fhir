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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.TestPlan
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

internal object TestPlanDependencySerializer : KSerializer<TestPlan.Dependency> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dependency") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("predecessor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestPlan.Dependency =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan.Dependency) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestPlan.Dependency {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var predecessor: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 ->
          predecessor =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.predecessorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dependency: " + __i)
      }
    }
    return TestPlan.Dependency(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      predecessor = predecessor,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestPlan.Dependency) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    (value.predecessor)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.predecessorSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val predecessorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object TestPlanTestCaseSerializer : KSerializer<TestPlan.TestCase> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestCase") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("scope", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "dependency",
        listSerialDescriptor(
          lazyDescriptor { TestPlan.TestCase.Dependency.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "testRun",
        listSerialDescriptor(lazyDescriptor { TestPlan.TestCase.TestRun.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "testData",
        listSerialDescriptor(lazyDescriptor { TestPlan.TestCase.TestData.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "assertion",
        listSerialDescriptor(
          lazyDescriptor { TestPlan.TestCase.Assertion.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestPlan.TestCase {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var scope: List<Reference>? = null
    var dependency: List<TestPlan.TestCase.Dependency>? = null
    var testRun: List<TestPlan.TestCase.TestRun>? = null
    var testData: List<TestPlan.TestCase.TestData>? = null
    var assertion: List<TestPlan.TestCase.Assertion>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 -> scope = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.scopeSer, null)
        6 ->
          dependency =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.dependencySer, null)
        7 ->
          testRun = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.testRunSer, null)
        8 ->
          testData = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.testDataSer, null)
        9 ->
          assertion =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.assertionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestCase: " + __i)
      }
    }
    return TestPlan.TestCase(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = Integer.of(sequence, _sequence),
      scope = scope ?: listOf(),
      dependency = dependency ?: listOf(),
      testRun = testRun ?: listOf(),
      testData = testData ?: listOf(),
      assertion = assertion ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestPlan.TestCase) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    if (value.scope.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.scopeSer, value.scope)
    if (value.dependency.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.dependencySer, value.dependency)
    if (value.testRun.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.testRunSer, value.testRun)
    if (value.testData.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.testDataSer, value.testData)
    if (value.assertion.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.assertionSer, value.assertion)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val scopeSerInner: KSerializer<Reference> = Reference.serializer()

    public val scopeSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.scopeSerInner)

    public val dependencySerInner: KSerializer<TestPlan.TestCase.Dependency> =
      TestPlan.TestCase.Dependency.serializer()

    public val dependencySer: KSerializer<List<TestPlan.TestCase.Dependency>> =
      ListSerializer(Hoisted.dependencySerInner)

    public val testRunSerInner: KSerializer<TestPlan.TestCase.TestRun> =
      TestPlan.TestCase.TestRun.serializer()

    public val testRunSer: KSerializer<List<TestPlan.TestCase.TestRun>> =
      ListSerializer(Hoisted.testRunSerInner)

    public val testDataSerInner: KSerializer<TestPlan.TestCase.TestData> =
      TestPlan.TestCase.TestData.serializer()

    public val testDataSer: KSerializer<List<TestPlan.TestCase.TestData>> =
      ListSerializer(Hoisted.testDataSerInner)

    public val assertionSerInner: KSerializer<TestPlan.TestCase.Assertion> =
      TestPlan.TestCase.Assertion.serializer()

    public val assertionSer: KSerializer<List<TestPlan.TestCase.Assertion>> =
      ListSerializer(Hoisted.assertionSerInner)
  }
}

internal object TestPlanTestCaseDependencySerializer : KSerializer<TestPlan.TestCase.Dependency> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dependency") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("predecessor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.Dependency =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.Dependency) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestPlan.TestCase.Dependency {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var predecessor: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 ->
          predecessor =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.predecessorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dependency: " + __i)
      }
    }
    return TestPlan.TestCase.Dependency(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = Markdown.of(description, _description),
      predecessor = predecessor,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestPlan.TestCase.Dependency) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    (value.predecessor)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.predecessorSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val predecessorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object TestPlanTestCaseTestRunSerializer : KSerializer<TestPlan.TestCase.TestRun> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestRun") {
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
      element("narrative", KotlinString.serializer().descriptor, isOptional = true)
      element("_narrative", Element.serializer().descriptor, isOptional = true)
      element(
        "script",
        lazyDescriptor { TestPlan.TestCase.TestRun.Script.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestRun =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestPlan.TestCase.TestRun {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var narrative: KotlinString? = null
    var _narrative: Element? = null
    var script: TestPlan.TestCase.TestRun.Script? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> narrative = decoder.decodeStringElement(__desc, 3)
        4 ->
          _narrative =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.narrativeSer, null)
        5 -> script = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.scriptSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestRun: " + __i)
      }
    }
    return TestPlan.TestCase.TestRun(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      narrative = Markdown.of(narrative, _narrative),
      script = script,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestPlan.TestCase.TestRun) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.narrative?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.narrative?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.narrativeSer, it)
    }
    (value.script)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.scriptSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val narrativeSer: KSerializer<Element> = Element.serializer()

    public val scriptSer: KSerializer<TestPlan.TestCase.TestRun.Script> =
      TestPlan.TestCase.TestRun.Script.serializer()
  }
}

internal object TestPlanTestCaseTestRunScriptSerializer :
  KSerializer<TestPlan.TestCase.TestRun.Script> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Script") {
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
      element("language", CodeableConcept.serializer().descriptor, isOptional = true)
      element("sourceString", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceString", Element.serializer().descriptor, isOptional = true)
      element("sourceReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestRun.Script =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun.Script) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestPlan.TestCase.TestRun.Script {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: CodeableConcept? = null
    var sourceString: KotlinString? = null
    var _sourceString: Element? = null
    var sourceReference: Reference? = null
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
          language = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.languageSer, null)
        4 -> sourceString = decoder.decodeStringElement(__desc, 4)
        5 ->
          _sourceString =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.sourceStringSer, null)
        6 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.sourceReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Script: " + __i)
      }
    }
    return TestPlan.TestCase.TestRun.Script(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language = language,
      source =
        TestPlan.TestCase.TestRun.Script.Source.from(
          R5String.of(sourceString, _sourceString),
          sourceReference,
        ),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestPlan.TestCase.TestRun.Script) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.language)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.languageSer, it) }
    when (val __d = value.source) {
      null -> {}
      is TestPlan.TestCase.TestRun.Script.Source.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.sourceStringSer, it)
        }
      }
      is TestPlan.TestCase.TestRun.Script.Source.Reference -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.sourceReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val languageSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sourceStringSer: KSerializer<Element> = Element.serializer()

    public val sourceReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object TestPlanTestCaseTestDataSerializer : KSerializer<TestPlan.TestCase.TestData> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestData") {
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
      element("type", Coding.serializer().descriptor, isOptional = true)
      element("content", Reference.serializer().descriptor, isOptional = true)
      element("sourceString", KotlinString.serializer().descriptor, isOptional = true)
      element("_sourceString", Element.serializer().descriptor, isOptional = true)
      element("sourceReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestData =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestData) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestPlan.TestCase.TestData {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: Coding? = null
    var content: Reference? = null
    var sourceString: KotlinString? = null
    var _sourceString: Element? = null
    var sourceReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          content = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.contentSer, null)
        5 -> sourceString = decoder.decodeStringElement(__desc, 5)
        6 ->
          _sourceString =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.sourceStringSer, null)
        7 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.contentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestData: " + __i)
      }
    }
    return TestPlan.TestCase.TestData(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      content = content,
      source =
        TestPlan.TestCase.TestData.Source.from(
          R5String.of(sourceString, _sourceString),
          sourceReference,
        ),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestPlan.TestCase.TestData) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.content)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.contentSer, it) }
    when (val __d = value.source) {
      null -> {}
      is TestPlan.TestCase.TestData.Source.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.sourceStringSer, it)
        }
      }
      is TestPlan.TestCase.TestData.Source.Reference -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.contentSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Coding> = Coding.serializer()

    public val contentSer: KSerializer<Reference> = Reference.serializer()

    public val sourceStringSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TestPlanTestCaseAssertionSerializer : KSerializer<TestPlan.TestCase.Assertion> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Assertion") {
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
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "object",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "result",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.Assertion =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.Assertion) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestPlan.TestCase.Assertion {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var `object`: List<CodeableReference>? = null
    var result: List<CodeableReference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          `object` = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.objectSer, null)
        5 -> result = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.objectSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Assertion: " + __i)
      }
    }
    return TestPlan.TestCase.Assertion(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: listOf(),
      `object` = `object` ?: listOf(),
      result = result ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestPlan.TestCase.Assertion) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, value.type)
    if (value.`object`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.objectSer, value.`object`)
    if (value.result.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.objectSer, value.result)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val objectSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val objectSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.objectSerInner)
  }
}

internal object TestPlanSerializer : KSerializer<TestPlan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestPlan") {
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
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("scope", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("testTools", KotlinString.serializer().descriptor, isOptional = true)
      element("_testTools", Element.serializer().descriptor, isOptional = true)
      element(
        "dependency",
        listSerialDescriptor(lazyDescriptor { TestPlan.Dependency.serializer().descriptor }),
        isOptional = true,
      )
      element("exitCriteria", KotlinString.serializer().descriptor, isOptional = true)
      element("_exitCriteria", Element.serializer().descriptor, isOptional = true)
      element(
        "testCase",
        listSerialDescriptor(lazyDescriptor { TestPlan.TestCase.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestPlan =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): TestPlan {
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
    var category: List<CodeableConcept>? = null
    var scope: List<Reference>? = null
    var testTools: KotlinString? = null
    var _testTools: Element? = null
    var dependency: List<TestPlan.Dependency>? = null
    var exitCriteria: KotlinString? = null
    var _exitCriteria: Element? = null
    var testCase: List<TestPlan.TestCase>? = null
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
        42 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.jurisdictionSer, null)
        43 -> scope = decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.scopeSer, null)
        44 -> testTools = decoder.decodeStringElement(__desc, 44)
        45 ->
          _testTools =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.implicitRulesSer, null)
        46 ->
          dependency =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.dependencySer, null)
        47 -> exitCriteria = decoder.decodeStringElement(__desc, 47)
        48 ->
          _exitCriteria =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.implicitRulesSer, null)
        49 ->
          testCase =
            decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.testCaseSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestPlan: " + __i)
      }
    }
    return TestPlan(
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
        TestPlan.VersionAlgorithm.from(
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
      category = category ?: listOf(),
      scope = scope ?: listOf(),
      testTools = Markdown.of(testTools, _testTools),
      dependency = dependency ?: listOf(),
      exitCriteria = Markdown.of(exitCriteria, _exitCriteria),
      testCase = testCase ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestPlan) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "TestPlan")
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
      is TestPlan.VersionAlgorithm.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
        }
      }
      is TestPlan.VersionAlgorithm.Coding -> {
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.jurisdictionSer, value.category)
    if (value.scope.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.scopeSer, value.scope)
    ((value.testTools?.value))?.let { encoder.encodeStringElement(__desc, 44, it) }
    (value.testTools?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.implicitRulesSer, it)
    }
    if (value.dependency.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.dependencySer, value.dependency)
    ((value.exitCriteria?.value))?.let { encoder.encodeStringElement(__desc, 47, it) }
    (value.exitCriteria?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.implicitRulesSer, it)
    }
    if (value.testCase.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49, Hoisted.testCaseSer, value.testCase)
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

    public val scopeSerInner: KSerializer<Reference> = Reference.serializer()

    public val scopeSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.scopeSerInner)

    public val dependencySerInner: KSerializer<TestPlan.Dependency> =
      TestPlan.Dependency.serializer()

    public val dependencySer: KSerializer<List<TestPlan.Dependency>> =
      ListSerializer(Hoisted.dependencySerInner)

    public val testCaseSerInner: KSerializer<TestPlan.TestCase> = TestPlan.TestCase.serializer()

    public val testCaseSer: KSerializer<List<TestPlan.TestCase>> =
      ListSerializer(Hoisted.testCaseSerInner)
  }
}

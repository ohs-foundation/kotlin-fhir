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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.Dependency) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestPlan.Dependency {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var predecessor: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 ->
          predecessor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.predecessorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dependency: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestPlan.Dependency) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    (value.predecessor)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.predecessorSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestPlan.TestCase {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        5 ->
          scope = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scopeSer, null)
        6 ->
          dependency =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dependencySer, null)
        7 ->
          testRun =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.testRunSer, null)
        8 ->
          testData =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.testDataSer, null)
        9 ->
          assertion =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.assertionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestCase: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestPlan.TestCase) {
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
    ((value.sequence?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    if (value.scope.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.scopeSer, value.scope)
    if (value.dependency.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.dependencySer, value.dependency)
    if (value.testRun.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.testRunSer, value.testRun)
    if (value.testData.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.testDataSer, value.testData)
    if (value.assertion.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.assertionSer, value.assertion)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.Dependency) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestPlan.TestCase.Dependency {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var predecessor: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(descriptor, i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        5 ->
          predecessor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.predecessorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dependency: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestPlan.TestCase.Dependency) {
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
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.descriptionSer, it)
    }
    (value.predecessor)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.predecessorSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestPlan.TestCase.TestRun {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var narrative: KotlinString? = null
    var _narrative: Element? = null
    var script: TestPlan.TestCase.TestRun.Script? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> narrative = decoder.decodeStringElement(descriptor, i)
        4 ->
          _narrative =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.narrativeSer, null)
        5 ->
          script = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scriptSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestRun: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestPlan.TestCase.TestRun) {
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
    ((value.narrative?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.narrative?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.narrativeSer, it)
    }
    (value.script)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.scriptSer, it) }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun.Script) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestPlan.TestCase.TestRun.Script {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: CodeableConcept? = null
    var sourceString: KotlinString? = null
    var _sourceString: Element? = null
    var sourceReference: Reference? = null
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
          language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.languageSer, null)
        4 -> sourceString = decoder.decodeStringElement(descriptor, i)
        5 ->
          _sourceString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceStringSer, null)
        6 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sourceReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Script: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TestPlan.TestCase.TestRun.Script,
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
    (value.language)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.languageSer, it)
    }
    when (val choice = value.source) {
      null -> {}
      is TestPlan.TestCase.TestRun.Script.Source.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.sourceStringSer, it)
        }
      }
      is TestPlan.TestCase.TestRun.Script.Source.Reference -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.sourceReferenceSer, choice.value)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestData) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestPlan.TestCase.TestData {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: Coding? = null
    var content: Reference? = null
    var sourceString: KotlinString? = null
    var _sourceString: Element? = null
    var sourceReference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          content =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentSer, null)
        5 -> sourceString = decoder.decodeStringElement(descriptor, i)
        6 ->
          _sourceString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sourceStringSer, null)
        7 ->
          sourceReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestData: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestPlan.TestCase.TestData) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    (value.content)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.contentSer, it)
    }
    when (val choice = value.source) {
      null -> {}
      is TestPlan.TestCase.TestData.Source.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.sourceStringSer, it)
        }
      }
      is TestPlan.TestCase.TestData.Source.Reference -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.contentSer, choice.value)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.Assertion) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestPlan.TestCase.Assertion {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var `object`: List<CodeableReference>? = null
    var result: List<CodeableReference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          `object` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.objectSer, null)
        5 ->
          result = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.objectSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Assertion: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestPlan.TestCase.Assertion) {
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
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    if (value.`object`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.objectSer, value.`object`)
    if (value.result.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.objectSer, value.result)
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
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("scope", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("testTools", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_testTools", Element.serializer().descriptor, isOptional = true)
    b.element(
      "dependency",
      listSerialDescriptor(lazyDescriptor { TestPlan.Dependency.serializer().descriptor }),
      isOptional = true,
    )
    b.element("exitCriteria", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_exitCriteria", Element.serializer().descriptor, isOptional = true)
    b.element(
      "testCase",
      listSerialDescriptor(lazyDescriptor { TestPlan.TestCase.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): TestPlan =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "TestPlan")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): TestPlan {
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
        41 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        42 ->
          scope = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scopeSer, null)
        43 -> testTools = decoder.decodeStringElement(descriptor, i)
        44 ->
          _testTools =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        45 ->
          dependency =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dependencySer, null)
        46 -> exitCriteria = decoder.decodeStringElement(descriptor, i)
        47 ->
          _exitCriteria =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        48 ->
          testCase =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.testCaseSer, null)
        else -> throw SerializationException("Unexpected index decoding TestPlan: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TestPlan,
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
      is TestPlan.VersionAlgorithm.String -> {
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
      is TestPlan.VersionAlgorithm.Coding -> {
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
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.category,
      )
    if (value.scope.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.scopeSer,
        value.scope,
      )
    ((value.testTools?.value))?.let {
      encoder.encodeStringElement(descriptor, 43 + descriptorOffset, it)
    }
    (value.testTools?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.dependency.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.dependencySer,
        value.dependency,
      )
    ((value.exitCriteria?.value))?.let {
      encoder.encodeStringElement(descriptor, 46 + descriptorOffset, it)
    }
    (value.exitCriteria?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.testCase.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.testCaseSer,
        value.testCase,
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

internal object TestPlanPolymorphicSerializer : KSerializer<TestPlan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestPlan") { TestPlanSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: TestPlan) {
    encoder.encodeStructure(descriptor) {
      TestPlanSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): TestPlan =
    decoder.decodeStructure(descriptor) {
      TestPlanSerializer.deserializeInternal(this, descriptor, 0)
    }
}

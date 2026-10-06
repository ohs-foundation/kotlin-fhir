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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("predecessor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestPlan.Dependency>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestPlan.Dependency =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var predecessor: Reference? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            predecessor =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Dependency: " + i)
        }
      }
      TestPlan.Dependency(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = Markdown.of(description, _description),
        predecessor = predecessor,
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.Dependency) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.predecessor)
    }
  }
}

internal object TestPlanTestCaseSerializer : KSerializer<TestPlan.TestCase> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestCase") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("scope", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("dependency", TestPlanTestCaseDependencySerializer.listSerializer.descriptor)
      optionalElement("testRun", TestPlanTestCaseTestRunSerializer.listSerializer.descriptor)
      optionalElement("testData", TestPlanTestCaseTestDataSerializer.listSerializer.descriptor)
      optionalElement("assertion", TestPlanTestCaseAssertionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestPlan.TestCase>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestPlan.TestCase =
    decoder.decodeStructure(descriptor) {
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            scope =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          6 ->
            dependency =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestPlanTestCaseDependencySerializer.listSerializer,
                null,
              )
          7 ->
            testRun =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestPlanTestCaseTestRunSerializer.listSerializer,
                null,
              )
          8 ->
            testData =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestPlanTestCaseTestDataSerializer.listSerializer,
                null,
              )
          9 ->
            assertion =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestPlanTestCaseAssertionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TestCase: " + i)
        }
      }
      TestPlan.TestCase(
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

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence?.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      if (value.scope.isNotEmpty())
        encodeSerializableElement(descriptor, 5, ReferenceSerializer.listSerializer, value.scope)
      if (value.dependency.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          TestPlanTestCaseDependencySerializer.listSerializer,
          value.dependency,
        )
      if (value.testRun.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          TestPlanTestCaseTestRunSerializer.listSerializer,
          value.testRun,
        )
      if (value.testData.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          TestPlanTestCaseTestDataSerializer.listSerializer,
          value.testData,
        )
      if (value.assertion.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          TestPlanTestCaseAssertionSerializer.listSerializer,
          value.assertion,
        )
    }
  }
}

internal object TestPlanTestCaseDependencySerializer : KSerializer<TestPlan.TestCase.Dependency> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dependency") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("predecessor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestPlan.TestCase.Dependency>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.Dependency =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var predecessor: Reference? = null
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            predecessor =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Dependency: " + i)
        }
      }
      TestPlan.TestCase.Dependency(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = Markdown.of(description, _description),
        predecessor = predecessor,
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.Dependency) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.predecessor)
    }
  }
}

internal object TestPlanTestCaseTestRunSerializer : KSerializer<TestPlan.TestCase.TestRun> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestRun") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("narrative", KotlinString.serializer().descriptor)
      optionalElement("_narrative", ElementSerializer.descriptor)
      optionalElement("script", TestPlanTestCaseTestRunScriptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestPlan.TestCase.TestRun>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestRun =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var narrative: KotlinString? = null
      var _narrative: Element? = null
      var script: TestPlan.TestCase.TestRun.Script? = null
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
          3 -> narrative = decodeStringElement(descriptor, i)
          4 ->
            _narrative = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            script =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestPlanTestCaseTestRunScriptSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TestRun: " + i)
        }
      }
      TestPlan.TestCase.TestRun(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        narrative = Markdown.of(narrative, _narrative),
        script = script,
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun) {
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
      encodeStringIfNotNull(descriptor, 3, value.narrative?.value)
      encodeElementIfNotNull(descriptor, 4, value.narrative)
      encodeSerializableIfNotNull(
        descriptor,
        5,
        TestPlanTestCaseTestRunScriptSerializer,
        value.script,
      )
    }
  }
}

internal object TestPlanTestCaseTestRunScriptSerializer :
  KSerializer<TestPlan.TestCase.TestRun.Script> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Script") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.descriptor)
      optionalElement("sourceString", KotlinString.serializer().descriptor)
      optionalElement("_sourceString", ElementSerializer.descriptor)
      optionalElement("sourceReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestPlan.TestCase.TestRun.Script>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestRun.Script =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var language: CodeableConcept? = null
      var sourceString: KotlinString? = null
      var _sourceString: Element? = null
      var sourceReference: Reference? = null
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
            language =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> sourceString = decodeStringElement(descriptor, i)
          5 ->
            _sourceString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            sourceReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Script: " + i)
        }
      }
      TestPlan.TestCase.TestRun.Script(
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

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun.Script) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.language)
      when (val choice = value.source) {
        null -> {}
        is TestPlan.TestCase.TestRun.Script.Source.String -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is TestPlan.TestCase.TestRun.Script.Source.Reference -> {
          encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object TestPlanTestCaseTestDataSerializer : KSerializer<TestPlan.TestCase.TestData> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestData") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodingSerializer.descriptor)
      optionalElement("content", ReferenceSerializer.descriptor)
      optionalElement("sourceString", KotlinString.serializer().descriptor)
      optionalElement("_sourceString", ElementSerializer.descriptor)
      optionalElement("sourceReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestPlan.TestCase.TestData>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestData =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: Coding? = null
      var content: Reference? = null
      var sourceString: KotlinString? = null
      var _sourceString: Element? = null
      var sourceReference: Reference? = null
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
          3 -> type = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 -> content = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 -> sourceString = decodeStringElement(descriptor, i)
          6 ->
            _sourceString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            sourceReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TestData: " + i)
        }
      }
      TestPlan.TestCase.TestData(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on TestPlan.TestCase.TestData"
            ),
        content = content,
        source =
          TestPlan.TestCase.TestData.Source.from(
            R5String.of(sourceString, _sourceString),
            sourceReference,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestData) {
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
      encodeSerializableElement(descriptor, 3, CodingSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.content)
      when (val choice = value.source) {
        null -> {}
        is TestPlan.TestCase.TestData.Source.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is TestPlan.TestCase.TestData.Source.Reference -> {
          encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object TestPlanTestCaseAssertionSerializer : KSerializer<TestPlan.TestCase.Assertion> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Assertion") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("object", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("result", CodeableReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestPlan.TestCase.Assertion>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.Assertion =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: List<CodeableConcept>? = null
      var `object`: List<CodeableReference>? = null
      var result: List<CodeableReference>? = null
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
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            `object` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          5 ->
            result =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Assertion: " + i)
        }
      }
      TestPlan.TestCase.Assertion(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type ?: listOf(),
        `object` = `object` ?: listOf(),
        result = result ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.Assertion) {
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
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      if (value.`object`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableReferenceSerializer.listSerializer,
          value.`object`,
        )
      if (value.result.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableReferenceSerializer.listSerializer,
          value.result,
        )
    }
  }
}

internal object TestPlanSerializer : FhirResourceSerializer<TestPlan> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("TestPlan")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("scope", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("testTools", KotlinString.serializer().descriptor)
    b.optionalElement("_testTools", ElementSerializer.descriptor)
    b.optionalElement("dependency", TestPlanDependencySerializer.listSerializer.descriptor)
    b.optionalElement("exitCriteria", KotlinString.serializer().descriptor)
    b.optionalElement("_exitCriteria", ElementSerializer.descriptor)
    b.optionalElement("testCase", TestPlanTestCaseSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> status = decoder.decodeStringElement(descriptor, i)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> date = decoder.decodeStringElement(descriptor, i)
        27 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> publisher = decoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 -> description = decoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> purpose = decoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> copyright = decoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        42 ->
          scope =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        43 -> testTools = decoder.decodeStringElement(descriptor, i)
        44 ->
          _testTools =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 ->
          dependency =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestPlanDependencySerializer.listSerializer,
              null,
            )
        46 -> exitCriteria = decoder.decodeStringElement(descriptor, i)
        47 ->
          _exitCriteria =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        48 ->
          testCase =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestPlanTestCaseSerializer.listSerializer,
              null,
            )
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
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on TestPlan"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TestPlan,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is TestPlan.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is TestPlan.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyrightLabel)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    if (value.scope.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.scope,
      )
    encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, value.testTools?.value)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.testTools)
    if (value.dependency.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        TestPlanDependencySerializer.listSerializer,
        value.dependency,
      )
    encoder.encodeStringIfNotNull(descriptor, 46 + descriptorOffset, value.exitCriteria?.value)
    encoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, value.exitCriteria)
    if (value.testCase.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        TestPlanTestCaseSerializer.listSerializer,
        value.testCase,
      )
  }
}

/*
 * Copyright 2026 Google LLC
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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactDetail
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.TestPlan
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class TestPlanDependencySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var predecessor: Reference? = null,
) {
  public fun toModel(): TestPlan.Dependency =
    TestPlan.Dependency(
      id = this@TestPlanDependencySurrogate.id,
      extension = this@TestPlanDependencySurrogate.extension ?: listOf(),
      modifierExtension = this@TestPlanDependencySurrogate.modifierExtension ?: listOf(),
      description =
        Markdown.of(
          this@TestPlanDependencySurrogate.description,
          this@TestPlanDependencySurrogate._description,
        ),
      predecessor = this@TestPlanDependencySurrogate.predecessor,
    )

  public companion object {
    public fun fromModel(model: TestPlan.Dependency): TestPlanDependencySurrogate =
      with(model) {
        TestPlanDependencySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          predecessor = this@with.predecessor,
        )
      }
  }
}

@Serializable
internal data class TestPlanTestCaseSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var scope: List<Reference>? = null,
  public var dependency: List<TestPlan.TestCase.Dependency>? = null,
  public var testRun: List<TestPlan.TestCase.TestRun>? = null,
  public var testData: List<TestPlan.TestCase.TestData>? = null,
  public var assertion: List<TestPlan.TestCase.Assertion>? = null,
) {
  public fun toModel(): TestPlan.TestCase =
    TestPlan.TestCase(
      id = this@TestPlanTestCaseSurrogate.id,
      extension = this@TestPlanTestCaseSurrogate.extension ?: listOf(),
      modifierExtension = this@TestPlanTestCaseSurrogate.modifierExtension ?: listOf(),
      sequence =
        Integer.of(
          this@TestPlanTestCaseSurrogate.sequence,
          this@TestPlanTestCaseSurrogate._sequence,
        ),
      scope = this@TestPlanTestCaseSurrogate.scope ?: listOf(),
      dependency = this@TestPlanTestCaseSurrogate.dependency ?: listOf(),
      testRun = this@TestPlanTestCaseSurrogate.testRun ?: listOf(),
      testData = this@TestPlanTestCaseSurrogate.testData ?: listOf(),
      assertion = this@TestPlanTestCaseSurrogate.assertion ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: TestPlan.TestCase): TestPlanTestCaseSurrogate =
      with(model) {
        TestPlanTestCaseSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence?.value,
          _sequence = this@with.sequence?.toElement(),
          scope = this@with.scope.takeIf { it.isNotEmpty() },
          dependency = this@with.dependency.takeIf { it.isNotEmpty() },
          testRun = this@with.testRun.takeIf { it.isNotEmpty() },
          testData = this@with.testData.takeIf { it.isNotEmpty() },
          assertion = this@with.assertion.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class TestPlanTestCaseDependencySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var predecessor: Reference? = null,
) {
  public fun toModel(): TestPlan.TestCase.Dependency =
    TestPlan.TestCase.Dependency(
      id = this@TestPlanTestCaseDependencySurrogate.id,
      extension = this@TestPlanTestCaseDependencySurrogate.extension ?: listOf(),
      modifierExtension = this@TestPlanTestCaseDependencySurrogate.modifierExtension ?: listOf(),
      description =
        Markdown.of(
          this@TestPlanTestCaseDependencySurrogate.description,
          this@TestPlanTestCaseDependencySurrogate._description,
        ),
      predecessor = this@TestPlanTestCaseDependencySurrogate.predecessor,
    )

  public companion object {
    public fun fromModel(model: TestPlan.TestCase.Dependency): TestPlanTestCaseDependencySurrogate =
      with(model) {
        TestPlanTestCaseDependencySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          predecessor = this@with.predecessor,
        )
      }
  }
}

@Serializable
internal data class TestPlanTestCaseTestRunSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var narrative: KotlinString? = null,
  public var _narrative: Element? = null,
  public var script: TestPlan.TestCase.TestRun.Script? = null,
) {
  public fun toModel(): TestPlan.TestCase.TestRun =
    TestPlan.TestCase.TestRun(
      id = this@TestPlanTestCaseTestRunSurrogate.id,
      extension = this@TestPlanTestCaseTestRunSurrogate.extension ?: listOf(),
      modifierExtension = this@TestPlanTestCaseTestRunSurrogate.modifierExtension ?: listOf(),
      narrative =
        Markdown.of(
          this@TestPlanTestCaseTestRunSurrogate.narrative,
          this@TestPlanTestCaseTestRunSurrogate._narrative,
        ),
      script = this@TestPlanTestCaseTestRunSurrogate.script,
    )

  public companion object {
    public fun fromModel(model: TestPlan.TestCase.TestRun): TestPlanTestCaseTestRunSurrogate =
      with(model) {
        TestPlanTestCaseTestRunSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          narrative = this@with.narrative?.value,
          _narrative = this@with.narrative?.toElement(),
          script = this@with.script,
        )
      }
  }
}

@Serializable
internal data class TestPlanTestCaseTestRunScriptSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var language: CodeableConcept? = null,
  public var source: TestPlan.TestCase.TestRun.Script.Source? = null,
) {
  public fun toModel(): TestPlan.TestCase.TestRun.Script =
    TestPlan.TestCase.TestRun.Script(
      id = this@TestPlanTestCaseTestRunScriptSurrogate.id,
      extension = this@TestPlanTestCaseTestRunScriptSurrogate.extension ?: listOf(),
      modifierExtension = this@TestPlanTestCaseTestRunScriptSurrogate.modifierExtension ?: listOf(),
      language = this@TestPlanTestCaseTestRunScriptSurrogate.language,
      source = this@TestPlanTestCaseTestRunScriptSurrogate.source,
    )

  public companion object {
    public fun fromModel(
      model: TestPlan.TestCase.TestRun.Script
    ): TestPlanTestCaseTestRunScriptSurrogate =
      with(model) {
        TestPlanTestCaseTestRunScriptSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          language = this@with.language,
          source = this@with.source,
        )
      }
  }
}

@Serializable
internal data class TestPlanTestCaseTestDataSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: Coding,
  public var content: Reference? = null,
  public var source: TestPlan.TestCase.TestData.Source? = null,
) {
  public fun toModel(): TestPlan.TestCase.TestData =
    TestPlan.TestCase.TestData(
      id = this@TestPlanTestCaseTestDataSurrogate.id,
      extension = this@TestPlanTestCaseTestDataSurrogate.extension ?: listOf(),
      modifierExtension = this@TestPlanTestCaseTestDataSurrogate.modifierExtension ?: listOf(),
      type = this@TestPlanTestCaseTestDataSurrogate.type,
      content = this@TestPlanTestCaseTestDataSurrogate.content,
      source = this@TestPlanTestCaseTestDataSurrogate.source,
    )

  public companion object {
    public fun fromModel(model: TestPlan.TestCase.TestData): TestPlanTestCaseTestDataSurrogate =
      with(model) {
        TestPlanTestCaseTestDataSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          content = this@with.content,
          source = this@with.source,
        )
      }
  }
}

@Serializable
internal data class TestPlanTestCaseAssertionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: List<CodeableConcept>? = null,
  public var `object`: List<CodeableReference>? = null,
  public var result: List<CodeableReference>? = null,
) {
  public fun toModel(): TestPlan.TestCase.Assertion =
    TestPlan.TestCase.Assertion(
      id = this@TestPlanTestCaseAssertionSurrogate.id,
      extension = this@TestPlanTestCaseAssertionSurrogate.extension ?: listOf(),
      modifierExtension = this@TestPlanTestCaseAssertionSurrogate.modifierExtension ?: listOf(),
      type = this@TestPlanTestCaseAssertionSurrogate.type ?: listOf(),
      `object` = this@TestPlanTestCaseAssertionSurrogate.`object` ?: listOf(),
      result = this@TestPlanTestCaseAssertionSurrogate.result ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: TestPlan.TestCase.Assertion): TestPlanTestCaseAssertionSurrogate =
      with(model) {
        TestPlanTestCaseAssertionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.takeIf { it.isNotEmpty() },
          `object` = this@with.`object`.takeIf { it.isNotEmpty() },
          result = this@with.result.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class TestPlanVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): TestPlan.VersionAlgorithm =
    TestPlan.VersionAlgorithm.from(
      R5String.of(
        this@TestPlanVersionAlgorithmSurrogate.versionAlgorithmString,
        this@TestPlanVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@TestPlanVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(model: TestPlan.VersionAlgorithm): TestPlanVersionAlgorithmSurrogate =
      with(model) {
        TestPlanVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class TestPlanTestCaseTestRunScriptSourceSurrogate(
  public var sourceString: KotlinString? = null,
  public var _sourceString: Element? = null,
  public var sourceReference: Reference? = null,
) {
  public fun toModel(): TestPlan.TestCase.TestRun.Script.Source =
    TestPlan.TestCase.TestRun.Script.Source.from(
      R5String.of(
        this@TestPlanTestCaseTestRunScriptSourceSurrogate.sourceString,
        this@TestPlanTestCaseTestRunScriptSourceSurrogate._sourceString,
      ),
      this@TestPlanTestCaseTestRunScriptSourceSurrogate.sourceReference,
    )!!

  public companion object {
    public fun fromModel(
      model: TestPlan.TestCase.TestRun.Script.Source
    ): TestPlanTestCaseTestRunScriptSourceSurrogate =
      with(model) {
        TestPlanTestCaseTestRunScriptSourceSurrogate(
          sourceString = this@with.asString()?.value?.value,
          _sourceString = this@with.asString()?.value?.toElement(),
          sourceReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class TestPlanTestCaseTestDataSourceSurrogate(
  public var sourceString: KotlinString? = null,
  public var _sourceString: Element? = null,
  public var sourceReference: Reference? = null,
) {
  public fun toModel(): TestPlan.TestCase.TestData.Source =
    TestPlan.TestCase.TestData.Source.from(
      R5String.of(
        this@TestPlanTestCaseTestDataSourceSurrogate.sourceString,
        this@TestPlanTestCaseTestDataSourceSurrogate._sourceString,
      ),
      this@TestPlanTestCaseTestDataSourceSurrogate.sourceReference,
    )!!

  public companion object {
    public fun fromModel(
      model: TestPlan.TestCase.TestData.Source
    ): TestPlanTestCaseTestDataSourceSurrogate =
      with(model) {
        TestPlanTestCaseTestDataSourceSurrogate(
          sourceString = this@with.asString()?.value?.value,
          _sourceString = this@with.asString()?.value?.toElement(),
          sourceReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class TestPlanSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var versionAlgorithm: TestPlan.VersionAlgorithm? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var experimental: KotlinBoolean? = null,
  public var _experimental: Element? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var copyrightLabel: KotlinString? = null,
  public var _copyrightLabel: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var scope: List<Reference>? = null,
  public var testTools: KotlinString? = null,
  public var _testTools: Element? = null,
  public var dependency: List<TestPlan.Dependency>? = null,
  public var exitCriteria: KotlinString? = null,
  public var _exitCriteria: Element? = null,
  public var testCase: List<TestPlan.TestCase>? = null,
) {
  public fun toModel(): TestPlan =
    TestPlan(
      id = this@TestPlanSurrogate.id,
      meta = this@TestPlanSurrogate.meta,
      implicitRules =
        Uri.of(this@TestPlanSurrogate.implicitRules, this@TestPlanSurrogate._implicitRules),
      language = Code.of(this@TestPlanSurrogate.language, this@TestPlanSurrogate._language),
      text = this@TestPlanSurrogate.text,
      contained = this@TestPlanSurrogate.contained ?: listOf(),
      extension = this@TestPlanSurrogate.extension ?: listOf(),
      modifierExtension = this@TestPlanSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@TestPlanSurrogate.url, this@TestPlanSurrogate._url),
      identifier = this@TestPlanSurrogate.identifier ?: listOf(),
      version = R5String.of(this@TestPlanSurrogate.version, this@TestPlanSurrogate._version),
      versionAlgorithm = this@TestPlanSurrogate.versionAlgorithm,
      name = R5String.of(this@TestPlanSurrogate.name, this@TestPlanSurrogate._name),
      title = R5String.of(this@TestPlanSurrogate.title, this@TestPlanSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@TestPlanSurrogate.status!!),
          this@TestPlanSurrogate._status,
        ),
      experimental =
        R5Boolean.of(this@TestPlanSurrogate.experimental, this@TestPlanSurrogate._experimental),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@TestPlanSurrogate.date),
          this@TestPlanSurrogate._date,
        ),
      publisher = R5String.of(this@TestPlanSurrogate.publisher, this@TestPlanSurrogate._publisher),
      contact = this@TestPlanSurrogate.contact ?: listOf(),
      description =
        Markdown.of(this@TestPlanSurrogate.description, this@TestPlanSurrogate._description),
      useContext = this@TestPlanSurrogate.useContext ?: listOf(),
      jurisdiction = this@TestPlanSurrogate.jurisdiction ?: listOf(),
      purpose = Markdown.of(this@TestPlanSurrogate.purpose, this@TestPlanSurrogate._purpose),
      copyright = Markdown.of(this@TestPlanSurrogate.copyright, this@TestPlanSurrogate._copyright),
      copyrightLabel =
        R5String.of(this@TestPlanSurrogate.copyrightLabel, this@TestPlanSurrogate._copyrightLabel),
      category = this@TestPlanSurrogate.category ?: listOf(),
      scope = this@TestPlanSurrogate.scope ?: listOf(),
      testTools = Markdown.of(this@TestPlanSurrogate.testTools, this@TestPlanSurrogate._testTools),
      dependency = this@TestPlanSurrogate.dependency ?: listOf(),
      exitCriteria =
        Markdown.of(this@TestPlanSurrogate.exitCriteria, this@TestPlanSurrogate._exitCriteria),
      testCase = this@TestPlanSurrogate.testCase ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: TestPlan): TestPlanSurrogate =
      with(model) {
        TestPlanSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          versionAlgorithm = this@with.versionAlgorithm,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          copyrightLabel = this@with.copyrightLabel?.value,
          _copyrightLabel = this@with.copyrightLabel?.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          scope = this@with.scope.takeIf { it.isNotEmpty() },
          testTools = this@with.testTools?.value,
          _testTools = this@with.testTools?.toElement(),
          dependency = this@with.dependency.takeIf { it.isNotEmpty() },
          exitCriteria = this@with.exitCriteria?.value,
          _exitCriteria = this@with.exitCriteria?.toElement(),
          testCase = this@with.testCase.takeIf { it.isNotEmpty() },
        )
      }
  }
}

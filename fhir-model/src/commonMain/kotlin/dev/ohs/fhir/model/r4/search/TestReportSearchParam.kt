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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.TestReport
import dev.ohs.fhir.model.r4.TestScript
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [TestReport] resource type. */
public object TestReportSearchParam {
  /** All search parameters for the TestReport resource type. */
  public val ALL: List<SearchParam<TestReport, *>> =
    listOf(Identifier, Issued, Participant, Result, Tester, Testscript)

  public data object Identifier : SearchParam<TestReport, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestReport.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestReport): List<dev.ohs.fhir.model.r4.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Issued : SearchParam<TestReport, DateTime> {
    public override val name: KotlinString = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "TestReport.issued"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestReport): List<DateTime> =
      listOfNotNull(resource.issued)
  }

  public data object Participant : SearchParam<TestReport, Uri> {
    public override val name: KotlinString = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "TestReport.participant.uri"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestReport): List<Uri> =
      resource.participant.map { it.uri }
  }

  public data object Result : SearchParam<TestReport, Any> {
    public override val name: KotlinString = "result"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestReport.result"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestReport): List<Any> = listOf(resource.result)
  }

  public data object Tester : SearchParam<TestReport, R4String> {
    public override val name: KotlinString = "tester"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestReport.tester"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: TestReport): List<R4String> =
      listOfNotNull(resource.tester)
  }

  public data object Testscript : SearchParam<TestReport, Reference> {
    public override val name: KotlinString = "testscript"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "TestReport.testScript"

    public override val target: List<KClass<out Resource>> = listOf(TestScript::class)

    public override fun extract(resource: TestReport): List<Reference> = listOf(resource.testScript)
  }
}

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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.TestReport
import dev.ohs.fhir.model.r4b.TestScript
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TestReport] resource type. */
public object TestReportSearchParams {
  public val identifier: SearchParam<TestReport, Identifier> =
    SearchParam<TestReport, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "TestReport.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val issued: SearchParam<TestReport, DateTime> =
    SearchParam<TestReport, DateTime>(
      name = "issued",
      type = SearchParamType.fromCode("date"),
      expression = "TestReport.issued",
      extractor = { resource -> listOfNotNull(resource.issued) },
    )

  public val participant: SearchParam<TestReport, Uri> =
    SearchParam<TestReport, Uri>(
      name = "participant",
      type = SearchParamType.fromCode("uri"),
      expression = "TestReport.participant.uri",
      extractor = { resource -> resource.participant.map { it.uri } },
    )

  public val result: SearchParam<TestReport, Any> =
    SearchParam<TestReport, Any>(
      name = "result",
      type = SearchParamType.fromCode("token"),
      expression = "TestReport.result",
      extractor = { resource -> listOf(resource.result) },
    )

  public val tester: SearchParam<TestReport, String> =
    SearchParam<TestReport, String>(
      name = "tester",
      type = SearchParamType.fromCode("string"),
      expression = "TestReport.tester",
      extractor = { resource -> listOfNotNull(resource.tester) },
    )

  public val testscript: SearchParam<TestReport, Reference> =
    SearchParam<TestReport, Reference>(
      name = "testscript",
      type = SearchParamType.fromCode("reference"),
      expression = "TestReport.testScript",
      target = listOf(TestScript::class),
      extractor = { resource -> listOf(resource.testScript) },
    )

  /** All search parameters for the TestReport resource type. */
  public val all: List<SearchParam<TestReport, *>> =
    listOf(identifier, issued, participant, result, tester, testscript)
}

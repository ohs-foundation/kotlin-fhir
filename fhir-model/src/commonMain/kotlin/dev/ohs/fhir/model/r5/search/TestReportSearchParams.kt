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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.TestReport
import dev.ohs.fhir.model.r5.TestScript
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TestReport] resource type. */
public object TestReportSearchParams {
  public val Identifier: SearchParam<TestReport, Identifier> =
    SimpleSearchParam<TestReport, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "TestReport.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val Issued: SearchParam<TestReport, DateTime> =
    SimpleSearchParam<TestReport, DateTime>(
      name = "issued",
      type = SearchParamType.fromCode("date"),
      expression = "TestReport.issued",
      extractor = { resource -> listOfNotNull(resource.issued) },
    )

  public val Participant: SearchParam<TestReport, Uri> =
    SimpleSearchParam<TestReport, Uri>(
      name = "participant",
      type = SearchParamType.fromCode("uri"),
      expression = "TestReport.participant.uri",
      extractor = { resource -> resource.participant.map { it.uri } },
    )

  public val Result: SearchParam<TestReport, Any> =
    SimpleSearchParam<TestReport, Any>(
      name = "result",
      type = SearchParamType.fromCode("token"),
      expression = "TestReport.result",
      extractor = { resource -> listOf(resource.result) },
    )

  public val Status: SearchParam<TestReport, Any> =
    SimpleSearchParam<TestReport, Any>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "TestReport.status",
      extractor = { resource -> listOf(resource.status) },
    )

  public val Tester: SearchParam<TestReport, String> =
    SimpleSearchParam<TestReport, String>(
      name = "tester",
      type = SearchParamType.fromCode("string"),
      expression = "TestReport.tester",
      extractor = { resource -> listOfNotNull(resource.tester) },
    )

  public val Testscript: SearchParam<TestReport, Canonical> =
    SimpleSearchParam<TestReport, Canonical>(
      name = "testscript",
      type = SearchParamType.fromCode("reference"),
      expression = "TestReport.testScript",
      target = listOf(TestScript::class),
      extractor = { resource -> listOf(resource.testScript) },
    )

  /** All search parameters for the TestReport resource type. */
  public val ALL: List<SearchParam<TestReport, *>> =
    listOf(Identifier, Issued, Participant, Result, Status, Tester, Testscript)
}

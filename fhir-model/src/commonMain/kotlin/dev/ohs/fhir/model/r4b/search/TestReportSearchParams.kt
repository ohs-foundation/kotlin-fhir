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
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "TestReport.identifier",
      extractor = { resource -> listOfNotNull(resource.identifier) },
    )

  public val issued: SearchParam<TestReport, DateTime> =
    SearchParam(
      name = "issued",
      type = SearchParamType.Date,
      expression = "TestReport.issued",
      extractor = { resource -> listOfNotNull(resource.issued) },
    )

  public val participant: SearchParam<TestReport, Uri> =
    SearchParam(
      name = "participant",
      type = SearchParamType.Uri,
      expression = "TestReport.participant.uri",
      extractor = { resource -> resource.participant.map { it.uri } },
    )

  public val result: SearchParam<TestReport, Any> =
    SearchParam(
      name = "result",
      type = SearchParamType.Token,
      expression = "TestReport.result",
      extractor = { resource -> listOf(resource.result) },
    )

  public val tester: SearchParam<TestReport, String> =
    SearchParam(
      name = "tester",
      type = SearchParamType.String,
      expression = "TestReport.tester",
      extractor = { resource -> listOfNotNull(resource.tester) },
    )

  public val testscript: SearchParam<TestReport, Reference> =
    SearchParam(
      name = "testscript",
      type = SearchParamType.Reference,
      expression = "TestReport.testScript",
      target = listOf(TestScript::class),
      extractor = { resource -> listOf(resource.testScript) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * excluded from [all].
   */
  public val unsupported: List<SearchParam<TestReport, *>> = listOf()

  /**
   * Supported search parameters for the TestReport resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<TestReport, *>> =
    listOf(identifier, issued, participant, result, tester, testscript)
}

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
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.TestReport
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TestReport] resource type. */
public sealed class TestReportSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: TestReport): List<T>

  public data object Identifier : TestReportSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestReport.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestReport): List<dev.ohs.fhir.model.r5.Identifier> =
      listOfNotNull(resource.identifier)
  }

  public data object Issued : TestReportSearchParam<DateTime>() {
    public override val paramName: KotlinString = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "TestReport.issued"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestReport): List<DateTime> =
      listOfNotNull(resource.issued)
  }

  public data object Participant : TestReportSearchParam<Uri>() {
    public override val paramName: KotlinString = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: KotlinString = "TestReport.participant.uri"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestReport): List<Uri> =
      resource.participant.map { it.uri }
  }

  public data object Result : TestReportSearchParam<Any>() {
    public override val paramName: KotlinString = "result"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestReport.result"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestReport): List<Any> = listOf(resource.result)
  }

  public data object Status : TestReportSearchParam<Any>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "TestReport.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestReport): List<Any> = listOf(resource.status)
  }

  public data object Tester : TestReportSearchParam<R5String>() {
    public override val paramName: KotlinString = "tester"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "TestReport.tester"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: TestReport): List<R5String> =
      listOfNotNull(resource.tester)
  }

  public data object Testscript : TestReportSearchParam<Canonical>() {
    public override val paramName: KotlinString = "testscript"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "TestReport.testScript"

    public override val target: List<KotlinString> = listOf("TestScript")

    public override fun extract(resource: TestReport): List<Canonical> = listOf(resource.testScript)
  }

  public companion object {
    /** All search parameters for the TestReport resource type. */
    public val ALL: List<TestReportSearchParam<*>> =
      listOf(Identifier, Issued, Participant, Result, Status, Tester, Testscript)
  }
}

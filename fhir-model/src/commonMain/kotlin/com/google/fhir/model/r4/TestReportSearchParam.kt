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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4

import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [TestReport] resource type. */
public sealed class TestReportSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: TestReport): List<T>

  public data object Identifier : TestReportSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "TestReport.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestReport): List<Any> = emptyList()
  }

  public data object Issued : TestReportSearchParam<Any>() {
    public override val paramName: String = "issued"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "TestReport.issued"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestReport): List<Any> = emptyList()
  }

  public data object Participant : TestReportSearchParam<Any>() {
    public override val paramName: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "TestReport.participant.uri"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestReport): List<Any> = emptyList()
  }

  public data object Result : TestReportSearchParam<Any>() {
    public override val paramName: String = "result"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "TestReport.result"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestReport): List<Any> = emptyList()
  }

  public data object Tester : TestReportSearchParam<Any>() {
    public override val paramName: String = "tester"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "TestReport.tester"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: TestReport): List<Any> = emptyList()
  }

  public data object Testscript : TestReportSearchParam<Any>() {
    public override val paramName: String = "testscript"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "TestReport.testScript"

    public override val target: List<String> = listOf("TestScript")

    public override fun extract(resource: TestReport): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the TestReport resource type. */
    public val ALL: List<TestReportSearchParam<*>> =
      listOf(Identifier, Issued, Participant, Result, Tester, Testscript)
  }
}

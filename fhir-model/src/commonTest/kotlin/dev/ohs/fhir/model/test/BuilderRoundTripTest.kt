/*
 * Copyright 2025-2026 Open Health Stack Foundation
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

package dev.ohs.fhir.model.test

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.Enabled
import kotlin.sequences.forEach
import kotlin.test.assertEquals

/** A map from the test case name to the reason why the test case is skipped in R4. */
private val skippedR4TestCaseNameToReasonMap =
  mapOf(
    "ActivityDefinition-administer-zika-virus-exposure-assessment.json" to "Invalid resources",
    "ImplementationGuide-fhir.json" to "Invalid resources",
    "Questionnaire-qs1.json" to "Invalid resources",
    "ig-r4.json" to "Invalid resources",
  )

/** A map from the test case name to the reason why the test case is skipped in R4B. */
private val skippedR4BTestCaseNameToReasonMap =
  mapOf(
    "Bundle-valuesets.json" to "Invalid resources",
    "CodeSystem-catalogType.json" to "Invalid resources",
    "ValueSet-catalogType.json" to "Invalid resources",
    "ActivityDefinition-administer-zika-virus-exposure-assessment.json" to "Invalid resources",
  )

/** A map from the test case name to the reason why the test case is skipped in R5. */
private val skippedR5TestCaseNameToReasonMap =
  mapOf(
    "ChargeItemDefinition-ebm.json" to
      "Unknown code 'text/CQL' for enum ExpressionLanguage; codes are case-sensitive"
  )

open class BuilderRoundTripTest :
  FunSpec({
    listOf(
        BuilderRoundTripTestSuite("R4", ::loadR4Examples, skippedR4TestCaseNameToReasonMap) {
          jsonR4.decodeFromString(it).let { resource -> resource to resource.toBuilder().build() }
        },
        BuilderRoundTripTestSuite("R4B", ::loadR4BExamples, skippedR4BTestCaseNameToReasonMap) {
          jsonR4B.decodeFromString(it).let { resource -> resource to resource.toBuilder().build() }
        },
        BuilderRoundTripTestSuite("R5", ::loadR5Examples, skippedR5TestCaseNameToReasonMap) {
          jsonR5.decodeFromString(it).let { resource -> resource to resource.toBuilder().build() }
        },
      )
      .forEach { testSuite ->
        context("${testSuite.fhirVersion} builder should reconstruct resource") {
          testSuite.exampleLoader().forEach { (fileName, json) ->
            test(fileName).config(
              enabledOrReasonIf = {
                testSuite.skippedTestCaseNameToReasonMap[fileName]?.let { Enabled.disabled(it) }
                  ?: Enabled.enabled
              }
            ) {
              val (resource, copy) = testSuite.decodeAndCopyFunction(json)
              assertEquals(resource, copy)
            }
          }
        }
      }
  })

private data class BuilderRoundTripTestSuite(
  val fhirVersion: String,
  val exampleLoader: () -> Sequence<FhirResourceJsonExample>,
  val skippedTestCaseNameToReasonMap: Map<String, String>,
  val decodeAndCopyFunction: (String) -> Pair<Any, Any>,
)

/*
 * Copyright 2025-2026 Google LLC
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
import kotlin.test.assertEquals

/** A map from the test case name to the reason why the test case is skipped in R4. */
private val skippedR4TestCaseNameToReasonMap =
  mapOf(
    "ActivityDefinition-administer-zika-virus-exposure-assessment.json" to "Invalid resource",
    "ImplementationGuide-fhir.json" to "Invalid resource",
    "Questionnaire-qs1.json" to "Invalid resource",
    "ig-r4.json" to "Invalid resource",
  )

/** A map from the test case name to the reason why the test case is skipped in R4B. */
private val skippedR4BTestCaseNameToReasonMap =
  mapOf(
    "Bundle-valuesets.json" to "Invalid resource",
    "CodeSystem-catalogType.json" to "Invalid resource",
    "ValueSet-catalogType.json" to "Invalid resource",
    "ActivityDefinition-administer-zika-virus-exposure-assessment.json" to "Invalid resource",
  )

/** A map from the test case name to the reason why the test case is skipped in R5. */
private val skippedR5TestCaseNameToReasonMap =
  mapOf(
    "ChargeItemDefinition-ebm.json" to
      "Unknown code 'text/CQL' for enum ExpressionLanguage; codes are case-sensitive"
  )

class EqualityTest :
  FunSpec({
    listOf(
        EqualityTestSuite(
          "R4",
          ::loadR4Examples,
          skippedR4TestCaseNameToReasonMap,
          jsonR4::decodeFromString,
        ),
        EqualityTestSuite(
          "R4B",
          ::loadR4BExamples,
          skippedR4BTestCaseNameToReasonMap,
          jsonR4B::decodeFromString,
        ),
        EqualityTestSuite(
          "R5",
          ::loadR5Examples,
          skippedR5TestCaseNameToReasonMap,
          jsonR5::decodeFromString,
        ),
      )
      .forEach { testSuite ->
        context("${testSuite.fhirVersion} resources should be equal") {
          testSuite.exampleLoader().forEach { (fileName, json) ->
            test(fileName).config(
              enabledOrReasonIf = {
                testSuite.skippedTestCaseNameToReasonMap[fileName]?.let { Enabled.disabled(it) }
                  ?: Enabled.enabled
              }
            ) {
              val firstResource = testSuite.decodeFunction(json)
              val secondResource = testSuite.decodeFunction(json)
              assertEquals(firstResource, secondResource)
            }
          }
        }
      }
  })

private data class EqualityTestSuite(
  val fhirVersion: String,
  val exampleLoader: () -> Sequence<FhirResourceJsonExample>,
  val skippedTestCaseNameToReasonMap: Map<String, String>,
  val decodeFunction: (String) -> Any,
)

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

import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r5.Resource as R5Resource
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.Enabled
import kotlin.test.assertEquals

/** A map from the test case name to the reason why the test case is skipped in R4. */
private val skippedR4TestCaseNameToReasonMap =
  mapOf(
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
  )

/** A map from the test case name to the reason why the test case is skipped in R5. */
private val skippedR5TestCaseNameToReasonMap = emptyMap<String, String>()

class EqualityTest :
  FunSpec({
    listOf(
        EqualityTestSuite(
          "R4",
          ::loadR4Examples,
          skippedR4TestCaseNameToReasonMap,
          { testJson.decodeFromString<R4Resource>(it) },
        ),
        EqualityTestSuite(
          "R4B",
          ::loadR4BExamples,
          skippedR4BTestCaseNameToReasonMap,
          { testJson.decodeFromString<R4bResource>(it) },
        ),
        EqualityTestSuite(
          "R5",
          ::loadR5Examples,
          skippedR5TestCaseNameToReasonMap,
          { testJson.decodeFromString<R5Resource>(it) },
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

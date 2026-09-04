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

package dev.ohs.fhir.codegen.searchparam

import dev.ohs.fhir.codegen.FhirPathExpressionResolver
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.Type
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class SearchParamUnionTest {

  @Test
  fun splitting_topLevelUnion_shouldReturnTrimmedBranches() {
    assertEquals(
      listOf("Observation.value.ofType(dateTime)", "Observation.value.ofType(Period)"),
      splitTopLevelUnion("Observation.value.ofType(dateTime) | Observation.value.ofType(Period)"),
    )
  }

  @Test
  fun splitting_parenthesizedBranches_shouldNotSplitInsideParentheses() {
    assertEquals(
      listOf("(A.useContext.value.ofType(Quantity))", "(A.useContext.value.ofType(Range))"),
      splitTopLevelUnion(
        "(A.useContext.value.ofType(Quantity)) | (A.useContext.value.ofType(Range))"
      ),
    )
  }

  @Test
  fun splitting_pipeInsideStringLiteral_shouldNotSplit() {
    assertEquals(
      listOf("Patient.telecom.where(system='a|b')"),
      splitTopLevelUnion("Patient.telecom.where(system='a|b')"),
    )
  }

  @Test
  fun splitting_nonUnionExpression_shouldReturnSingleBranch() {
    assertEquals(listOf("Patient.birthDate"), splitTopLevelUnion("Patient.birthDate"))
  }

  @Test
  fun splitting_emptyAndBlankBranches_shouldBeDropped() {
    assertEquals(listOf("A.b"), splitTopLevelUnion("A.b |"))
    assertEquals(emptyList(), splitTopLevelUnion(""))
    assertEquals(emptyList(), splitTopLevelUnion("|"))
  }

  @Test
  fun splitting_pipeInsideUnbalancedParentheses_shouldNotSplitAtNegativeDepth() {
    assertEquals(listOf("a) | (b"), splitTopLevelUnion("a) | (b"))
  }

  @Test
  fun parsing_unionOfSupportedBranches_shouldReturnUnionOfBranchPatterns() {
    val pattern = parse("Patient.deceased.ofType(boolean) | Patient.deceased.ofType(dateTime)")

    val union = assertIs<SearchParamPattern.Union>(pattern)
    assertEquals(2, union.branches.size)
    assertEquals("boolean", assertIs<SearchParamPattern.ElementCast>(union.branches[0]).targetType)
    assertEquals("dateTime", assertIs<SearchParamPattern.ElementCast>(union.branches[1]).targetType)
  }

  @Test
  fun parsing_unionAcrossDifferentPaths_shouldReturnUnion() {
    val pattern = parse("Patient.birthDate | Patient.name.family")

    val union = assertIs<SearchParamPattern.Union>(pattern)
    assertIs<SearchParamPattern.SimplePath>(union.branches[0])
    assertIs<SearchParamPattern.SimplePath>(union.branches[1])
  }

  @Test
  fun parsing_unionWithOneUnsupportedBranch_shouldExtractTheSupportedBranch() {
    // The second branch is not a supported pattern (extension access) and is dropped; the
    // surviving branch is returned directly rather than as a single-branch union.
    val pattern = parse("Patient.birthDate | Patient.extension('http://example.org/x').value")

    val simplePath = assertIs<SearchParamPattern.SimplePath>(pattern)
    assertEquals("birthDate", simplePath.resolved.segments.single().propertyName)
  }

  @Test
  fun parsing_unionWithInvalidCastBranch_shouldExtractTheValidBranch() {
    val pattern = parse("Patient.deceased.ofType(boolean) | Patient.deceased.ofType(Quantity)")

    val cast = assertIs<SearchParamPattern.ElementCast>(pattern)
    assertEquals("boolean", cast.targetType)
  }

  @Test
  fun parsing_unionWithNoSupportedBranch_shouldReturnUnsupported() {
    assertEquals(
      SearchParamPattern.Unsupported,
      parse("Patient.extension('http://example.org/x').value | Patient.deceased.ofType(Quantity)"),
    )
  }

  @Test
  fun parsing_unionWhereNoBranchMatchesResource_shouldReturnUnsupported() {
    assertEquals(SearchParamPattern.Unsupported, parse("name | alias"))
  }

  private fun parse(expression: String): SearchParamPattern =
    parseSearchParamExpression(expression, "Patient", resolver)

  private val resolver =
    FhirPathExpressionResolver(
      mapOf(
        "Patient" to
          listOf(
            element("Patient.birthDate", "date"),
            element("Patient.deceased[x]", "boolean", "dateTime"),
            element("Patient.name", "HumanName", max = "*"),
            element("Patient.telecom", "ContactPoint", max = "*"),
          ),
        "HumanName" to listOf(element("HumanName.family", "string")),
        "ContactPoint" to
          listOf(element("ContactPoint.system", "code"), element("ContactPoint.value", "string")),
      )
    )

  private fun element(path: String, vararg typeCodes: String, max: String = "1"): Element =
    Element(
      id = path,
      path = path,
      definition = "",
      min = 0,
      max = max,
      isModifier = false,
      type = typeCodes.map { Type(it) },
    )
}

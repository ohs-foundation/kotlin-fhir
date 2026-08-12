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

import kotlin.test.Test
import kotlin.test.assertEquals

class SearchParamPatternTest {

  @Test
  fun unwrapOuterParentheses_withoutParentheses_returnsTrimmedExpression() {
    assertEquals("Patient.name", unwrapOuterParentheses("  Patient.name  "))
  }

  @Test
  fun unwrapOuterParentheses_emptyString_returnsEmptyString() {
    assertEquals("", unwrapOuterParentheses(""))
  }

  @Test
  fun unwrapOuterParentheses_singleEnclosingPair_unwraps() {
    assertEquals("Patient.name", unwrapOuterParentheses("(Patient.name)"))
  }

  @Test
  fun unwrapOuterParentheses_multipleEnclosingLayers_unwrapsAllLayers() {
    assertEquals("Patient.name", unwrapOuterParentheses("(((Patient.name)))"))
  }

  @Test
  fun unwrapOuterParentheses_enclosingPairWithWhitespace_trimsAndUnwraps() {
    assertEquals("Patient.name", unwrapOuterParentheses("  (  Patient.name  )  "))
  }

  @Test
  fun unwrapOuterParentheses_expressionWithInnerParentheses_preservesInnerParentheses() {
    assertEquals(
      "Patient.telecom.where(system = 'email')",
      unwrapOuterParentheses("(Patient.telecom.where(system = 'email'))"),
    )
  }

  @Test
  fun unwrapOuterParentheses_siblingExpressions_doesNotUnwrap() {
    assertEquals(
      "(Patient.name) | (Patient.telecom)",
      unwrapOuterParentheses("(Patient.name) | (Patient.telecom)"),
    )
  }

  @Test
  fun unwrapOuterParentheses_nestedSiblingExpressions_unwrapsOnlyOuterLayer() {
    assertEquals(
      "(Patient.name) | (Patient.telecom)",
      unwrapOuterParentheses("((Patient.name) | (Patient.telecom))"),
    )
  }

  @Test
  fun unwrapOuterParentheses_emptyParentheses_returnsEmptyString() {
    assertEquals("", unwrapOuterParentheses("()"))
  }

  @Test
  fun unwrapOuterParentheses_unbalancedClosingParenthesis_returnsOriginal() {
    assertEquals("(Patient.name))", unwrapOuterParentheses("(Patient.name))"))
  }

  @Test
  fun unwrapOuterParentheses_unbalancedOpeningParenthesis_returnsOriginal() {
    assertEquals("((Patient.name)", unwrapOuterParentheses("((Patient.name)"))
  }

  @Test
  fun unwrapOuterParentheses_invertedParentheses_returnsOriginal() {
    assertEquals(")Patient.name(", unwrapOuterParentheses(")Patient.name("))
  }
}

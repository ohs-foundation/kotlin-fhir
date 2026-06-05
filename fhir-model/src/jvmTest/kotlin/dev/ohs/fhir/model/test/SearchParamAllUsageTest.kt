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

package dev.ohs.fhir.model.test

import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.String as FhirString
import dev.ohs.fhir.model.r4.search.PatientSearchParams
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

private typealias ContactPointSystem = ContactPoint.ContactPointSystem

class SearchParamAllUsageTest :
  FunSpec({
    test("indexing builds (name, value) rows with extractFrom; search queries the rows") {
      val email =
        ContactPoint(
          system = Enumeration(`value` = ContactPointSystem.Email),
          `value` = FhirString(`value` = "alice@example.com"),
        )
      val phone =
        ContactPoint(
          system = Enumeration(`value` = ContactPointSystem.Phone),
          `value` = FhirString(`value` = "555-1234"),
        )
      val alice = Patient(telecom = listOf(email, phone))

      // ---------- INDEX TIME ----------
      // When a Patient is saved, the server walks every search param in `all` and calls
      // `extractFrom` to produce (name, value) index rows. The `all` list is generated from
      // the spec, so the index automatically covers every supported search param.
      //
      // `extractFrom` does the real work. For the `email` param, it filters `telecom` by
      // `system` (FHIRPath: `Patient.telecom.where(system='email')`), a computation that
      // has no equivalent direct field on Patient.
      //
      // Params whose FHIRPath isn't supported yet are listed in `unsupported` and excluded
      // from `all`, so this loop never calls `extractFrom` on a param that would throw.
      val index: List<Pair<String, Any?>> =
        PatientSearchParams.all.flatMap { sp ->
          sp.extractFrom(alice).map { value -> sp.name to value }
        }

      // ---------- SEARCH TIME ----------
      // For a request like `GET /Patient?email=alice@example.com`, the server filters the
      // pre-built index by both the name (`"email"`) and the value (`"alice@example.com"`).
      // `extractFrom` is never called at search time. Filtering an in-memory list of
      // (name, value) pairs is what makes search fast and uniform across every spec-defined
      // search param.
      val queryName = "email"
      val queryValue = "alice@example.com"
      val matches =
        index.filter { (name, value) ->
          name == queryName && (value as? ContactPoint)?.`value`?.`value` == queryValue
        }

      // The email row matched; the phone row was rejected by the value check.
      matches.size shouldBe 1
      matches.first().second shouldBe email
    }
  })

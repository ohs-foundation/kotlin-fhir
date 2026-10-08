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

package dev.ohs.fhir.model.r5.terminologies

import dev.ohs.fhir.model.r5.FhirEnum
import kotlin.String

/** The validation status of the target */
public enum class VerificationResultStatus(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Attested("attested", "http://hl7.org/fhir/CodeSystem/verificationresult-status", "Attested"),
  Validated("validated", "http://hl7.org/fhir/CodeSystem/verificationresult-status", "Validated"),
  In_Process(
    "in-process",
    "http://hl7.org/fhir/CodeSystem/verificationresult-status",
    "In process",
  ),
  Req_Revalid(
    "req-revalid",
    "http://hl7.org/fhir/CodeSystem/verificationresult-status",
    "Requires revalidation",
  ),
  Val_Fail(
    "val-fail",
    "http://hl7.org/fhir/CodeSystem/verificationresult-status",
    "Validation failed",
  ),
  Reval_Fail(
    "reval-fail",
    "http://hl7.org/fhir/CodeSystem/verificationresult-status",
    "Re-Validation failed",
  ),
  Entered_In_Error(
    "entered-in-error",
    "http://hl7.org/fhir/CodeSystem/verificationresult-status",
    "Entered in Error",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): VerificationResultStatus =
      when (code) {
        "attested" -> Attested
        "validated" -> Validated
        "in-process" -> In_Process
        "req-revalid" -> Req_Revalid
        "val-fail" -> Val_Fail
        "reval-fail" -> Reval_Fail
        "entered-in-error" -> Entered_In_Error
        else ->
          throw IllegalArgumentException("Unknown code $code for enum VerificationResultStatus")
      }
  }
}

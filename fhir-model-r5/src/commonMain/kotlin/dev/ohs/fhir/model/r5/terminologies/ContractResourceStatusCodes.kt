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

/** This value set contract specific codes for status. */
public enum class ContractResourceStatusCodes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Amended("amended", "http://hl7.org/fhir/contract-status", "Amended"),
  Appended("appended", "http://hl7.org/fhir/contract-status", "Appended"),
  Cancelled("cancelled", "http://hl7.org/fhir/contract-status", "Cancelled"),
  Disputed("disputed", "http://hl7.org/fhir/contract-status", "Disputed"),
  Entered_In_Error("entered-in-error", "http://hl7.org/fhir/contract-status", "Entered in Error"),
  Executable("executable", "http://hl7.org/fhir/contract-status", "Executable"),
  Executed("executed", "http://hl7.org/fhir/contract-status", "Executed"),
  Negotiable("negotiable", "http://hl7.org/fhir/contract-status", "Negotiable"),
  Offered("offered", "http://hl7.org/fhir/contract-status", "Offered"),
  Policy("policy", "http://hl7.org/fhir/contract-status", "Policy"),
  Rejected("rejected", "http://hl7.org/fhir/contract-status", "Rejected"),
  Renewed("renewed", "http://hl7.org/fhir/contract-status", "Renewed"),
  Revoked("revoked", "http://hl7.org/fhir/contract-status", "Revoked"),
  Resolved("resolved", "http://hl7.org/fhir/contract-status", "Resolved"),
  Terminated("terminated", "http://hl7.org/fhir/contract-status", "Terminated");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ContractResourceStatusCodes =
      when (code) {
        "amended" -> Amended
        "appended" -> Appended
        "cancelled" -> Cancelled
        "disputed" -> Disputed
        "entered-in-error" -> Entered_In_Error
        "executable" -> Executable
        "executed" -> Executed
        "negotiable" -> Negotiable
        "offered" -> Offered
        "policy" -> Policy
        "rejected" -> Rejected
        "renewed" -> Renewed
        "revoked" -> Revoked
        "resolved" -> Resolved
        "terminated" -> Terminated
        else ->
          throw IllegalArgumentException("Unknown code $code for enum ContractResourceStatusCodes")
      }
  }
}

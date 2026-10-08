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

package dev.ohs.fhir.model.r4.terminologies

import dev.ohs.fhir.model.r4.FhirEnum
import kotlin.String

/** A code that describes the type of issue. */
public enum class IssueType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Invalid("invalid", "http://hl7.org/fhir/issue-type", "Invalid Content"),
  Structure("structure", "http://hl7.org/fhir/issue-type", "Structural Issue"),
  Required("required", "http://hl7.org/fhir/issue-type", "Required element missing"),
  Value("value", "http://hl7.org/fhir/issue-type", "Element value invalid"),
  Invariant("invariant", "http://hl7.org/fhir/issue-type", "Validation rule failed"),
  Security("security", "http://hl7.org/fhir/issue-type", "Security Problem"),
  Login("login", "http://hl7.org/fhir/issue-type", "Login Required"),
  Unknown("unknown", "http://hl7.org/fhir/issue-type", "Unknown User"),
  Expired("expired", "http://hl7.org/fhir/issue-type", "Session Expired"),
  Forbidden("forbidden", "http://hl7.org/fhir/issue-type", "Forbidden"),
  Suppressed("suppressed", "http://hl7.org/fhir/issue-type", "Information  Suppressed"),
  Processing("processing", "http://hl7.org/fhir/issue-type", "Processing Failure"),
  Not_Supported("not-supported", "http://hl7.org/fhir/issue-type", "Content not supported"),
  Duplicate("duplicate", "http://hl7.org/fhir/issue-type", "Duplicate"),
  Multiple_Matches("multiple-matches", "http://hl7.org/fhir/issue-type", "Multiple Matches"),
  Not_Found("not-found", "http://hl7.org/fhir/issue-type", "Not Found"),
  Deleted("deleted", "http://hl7.org/fhir/issue-type", "Deleted"),
  Too_Long("too-long", "http://hl7.org/fhir/issue-type", "Content Too Long"),
  Code_Invalid("code-invalid", "http://hl7.org/fhir/issue-type", "Invalid Code"),
  Extension("extension", "http://hl7.org/fhir/issue-type", "Unacceptable Extension"),
  Too_Costly("too-costly", "http://hl7.org/fhir/issue-type", "Operation Too Costly"),
  Business_Rule("business-rule", "http://hl7.org/fhir/issue-type", "Business Rule Violation"),
  Conflict("conflict", "http://hl7.org/fhir/issue-type", "Edit Version Conflict"),
  Transient("transient", "http://hl7.org/fhir/issue-type", "Transient Issue"),
  Lock_Error("lock-error", "http://hl7.org/fhir/issue-type", "Lock Error"),
  No_Store("no-store", "http://hl7.org/fhir/issue-type", "No Store Available"),
  Exception("exception", "http://hl7.org/fhir/issue-type", "Exception"),
  Timeout("timeout", "http://hl7.org/fhir/issue-type", "Timeout"),
  Incomplete("incomplete", "http://hl7.org/fhir/issue-type", "Incomplete Results"),
  Throttled("throttled", "http://hl7.org/fhir/issue-type", "Throttled"),
  Informational("informational", "http://hl7.org/fhir/issue-type", "Informational Note");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): IssueType =
      when (code) {
        "invalid" -> Invalid
        "structure" -> Structure
        "required" -> Required
        "value" -> Value
        "invariant" -> Invariant
        "security" -> Security
        "login" -> Login
        "unknown" -> Unknown
        "expired" -> Expired
        "forbidden" -> Forbidden
        "suppressed" -> Suppressed
        "processing" -> Processing
        "not-supported" -> Not_Supported
        "duplicate" -> Duplicate
        "multiple-matches" -> Multiple_Matches
        "not-found" -> Not_Found
        "deleted" -> Deleted
        "too-long" -> Too_Long
        "code-invalid" -> Code_Invalid
        "extension" -> Extension
        "too-costly" -> Too_Costly
        "business-rule" -> Business_Rule
        "conflict" -> Conflict
        "transient" -> Transient
        "lock-error" -> Lock_Error
        "no-store" -> No_Store
        "exception" -> Exception
        "timeout" -> Timeout
        "incomplete" -> Incomplete
        "throttled" -> Throttled
        "informational" -> Informational
        else -> throw IllegalArgumentException("Unknown code $code for enum IssueType")
      }
  }
}

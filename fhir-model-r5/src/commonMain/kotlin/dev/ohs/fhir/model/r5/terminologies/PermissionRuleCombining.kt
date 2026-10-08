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

/** Codes identifying rule combining algorithm. */
public enum class PermissionRuleCombining(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Deny_Overrides(
    "deny-overrides",
    "http://hl7.org/fhir/permission-rule-combining",
    "Deny-overrides",
  ),
  Permit_Overrides(
    "permit-overrides",
    "http://hl7.org/fhir/permission-rule-combining",
    "Permit-overrides",
  ),
  Ordered_Deny_Overrides(
    "ordered-deny-overrides",
    "http://hl7.org/fhir/permission-rule-combining",
    "Ordered-deny-overrides",
  ),
  Ordered_Permit_Overrides(
    "ordered-permit-overrides",
    "http://hl7.org/fhir/permission-rule-combining",
    "Ordered-permit-overrides",
  ),
  Deny_Unless_Permit(
    "deny-unless-permit",
    "http://hl7.org/fhir/permission-rule-combining",
    "Deny-unless-permit",
  ),
  Permit_Unless_Deny(
    "permit-unless-deny",
    "http://hl7.org/fhir/permission-rule-combining",
    "Permit-unless-deny",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): PermissionRuleCombining =
      when (code) {
        "deny-overrides" -> Deny_Overrides
        "permit-overrides" -> Permit_Overrides
        "ordered-deny-overrides" -> Ordered_Deny_Overrides
        "ordered-permit-overrides" -> Ordered_Permit_Overrides
        "deny-unless-permit" -> Deny_Unless_Permit
        "permit-unless-deny" -> Permit_Unless_Deny
        else ->
          throw IllegalArgumentException("Unknown code $code for enum PermissionRuleCombining")
      }
  }
}

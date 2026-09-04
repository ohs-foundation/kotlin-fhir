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

package dev.ohs.fhir.model.r4

import kotlin.String

/** A common interface for all FHIR enumerated terminology concepts. */
public interface FhirEnum {
  /** The machine code string defined by the code system. */
  public val code: String

  /** The URI of the code system that defines the code. */
  public val system: String

  /** The human-readable display title of the code, if defined. */
  public val display: String?
}

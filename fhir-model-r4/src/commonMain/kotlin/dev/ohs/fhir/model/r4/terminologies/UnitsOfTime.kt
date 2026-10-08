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

/** A unit of time (units from UCUM). */
public enum class UnitsOfTime(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  S("s", "http://unitsofmeasure.org", "秒"),
  Min("min", "http://unitsofmeasure.org", "分钟"),
  H("h", "http://unitsofmeasure.org", "小时"),
  D("d", "http://unitsofmeasure.org", "天"),
  Wk("wk", "http://unitsofmeasure.org", "星期"),
  Mo("mo", "http://unitsofmeasure.org", "月"),
  A("a", "http://unitsofmeasure.org", "年");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): UnitsOfTime =
      when (code) {
        "s" -> S
        "min" -> Min
        "h" -> H
        "d" -> D
        "wk" -> Wk
        "mo" -> Mo
        "a" -> A
        else -> throw IllegalArgumentException("Unknown code $code for enum UnitsOfTime")
      }
  }
}

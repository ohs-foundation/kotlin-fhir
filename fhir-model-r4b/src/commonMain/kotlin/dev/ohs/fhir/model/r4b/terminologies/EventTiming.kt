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

package dev.ohs.fhir.model.r4b.terminologies

import dev.ohs.fhir.model.r4b.FhirEnum
import kotlin.String

/** Real world event relating to the schedule. */
public enum class EventTiming(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Morn("MORN", "http://hl7.org/fhir/event-timing", "Morning"),
  Morn_Early("MORN.early", "http://hl7.org/fhir/event-timing", "Early Morning"),
  Morn_Late("MORN.late", "http://hl7.org/fhir/event-timing", "Late Morning"),
  Noon("NOON", "http://hl7.org/fhir/event-timing", "Noon"),
  Aft("AFT", "http://hl7.org/fhir/event-timing", "Afternoon"),
  Aft_Early("AFT.early", "http://hl7.org/fhir/event-timing", "Early Afternoon"),
  Aft_Late("AFT.late", "http://hl7.org/fhir/event-timing", "Late Afternoon"),
  Eve("EVE", "http://hl7.org/fhir/event-timing", "Evening"),
  Eve_Early("EVE.early", "http://hl7.org/fhir/event-timing", "Early Evening"),
  Eve_Late("EVE.late", "http://hl7.org/fhir/event-timing", "Late Evening"),
  Night("NIGHT", "http://hl7.org/fhir/event-timing", "Night"),
  Phs("PHS", "http://hl7.org/fhir/event-timing", "After Sleep"),
  Hs("HS", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "HS"),
  Wake("WAKE", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "WAKE"),
  C("C", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "C"),
  Cm("CM", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "CM"),
  Cd("CD", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "CD"),
  Cv("CV", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "CV"),
  Ac("AC", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "AC"),
  Acm("ACM", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "ACM"),
  Acd("ACD", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "ACD"),
  Acv("ACV", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "ACV"),
  Pc("PC", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "PC"),
  Pcm("PCM", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "PCM"),
  Pcd("PCD", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "PCD"),
  Pcv("PCV", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "PCV");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): EventTiming =
      when (code) {
        "MORN" -> Morn
        "MORN.early" -> Morn_Early
        "MORN.late" -> Morn_Late
        "NOON" -> Noon
        "AFT" -> Aft
        "AFT.early" -> Aft_Early
        "AFT.late" -> Aft_Late
        "EVE" -> Eve
        "EVE.early" -> Eve_Early
        "EVE.late" -> Eve_Late
        "NIGHT" -> Night
        "PHS" -> Phs
        "HS" -> Hs
        "WAKE" -> Wake
        "C" -> C
        "CM" -> Cm
        "CD" -> Cd
        "CV" -> Cv
        "AC" -> Ac
        "ACM" -> Acm
        "ACD" -> Acd
        "ACV" -> Acv
        "PC" -> Pc
        "PCM" -> Pcm
        "PCD" -> Pcd
        "PCV" -> Pcv
        else -> throw IllegalArgumentException("Unknown code $code for enum EventTiming")
      }
  }
}

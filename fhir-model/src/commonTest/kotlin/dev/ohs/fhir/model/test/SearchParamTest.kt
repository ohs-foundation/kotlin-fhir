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

import dev.ohs.fhir.model.r4.DateTime as R4DateTime
import dev.ohs.fhir.model.r4.FhirDateTime as R4FhirDateTime
import dev.ohs.fhir.model.r4.Patient as R4Patient
import dev.ohs.fhir.model.r4.search.PatientSearchParams as R4PatientSearchParams
import dev.ohs.fhir.model.r5.ActivityDefinition
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Device
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Observation
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.search.ActivityDefinitionSearchParams
import dev.ohs.fhir.model.r5.search.DeviceSearchParams
import dev.ohs.fhir.model.r5.search.ObservationSearchParams
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SearchParamTest {

  @Test
  fun extractingOfTypeChoice_withMatchingType_shouldReturnExtractedValue() {
    val quantity = Quantity(unit = dev.ohs.fhir.model.r5.String(value = "kg"))
    val observation =
      Observation(
        status = Enumeration(value = Observation.ObservationStatus.Final),
        code = CodeableConcept(text = dev.ohs.fhir.model.r5.String(value = "Weight")),
        value = Observation.Value.Quantity(quantity),
      )

    assertEquals(
      listOf(quantity),
      ObservationSearchParams.valueQuantity.extractFrom(observation),
    )
  }

  @Test
  fun extractingOfTypeChoice_withMismatchedType_shouldReturnEmptyList() {
    val quantity = Quantity(unit = dev.ohs.fhir.model.r5.String(value = "kg"))
    val observation =
      Observation(
        status = Enumeration(value = Observation.ObservationStatus.Final),
        code = CodeableConcept(text = dev.ohs.fhir.model.r5.String(value = "Weight")),
        value = Observation.Value.Quantity(quantity),
      )

    assertTrue(ObservationSearchParams.valueConcept.extractFrom(observation).isEmpty())
  }

  @Test
  fun extractingOfTypeChoice_withNullValue_shouldReturnEmptyList() {
    val observation =
      Observation(
        status = Enumeration(value = Observation.ObservationStatus.Final),
        code = CodeableConcept(text = dev.ohs.fhir.model.r5.String(value = "Finding")),
        value = null,
      )

    assertTrue(ObservationSearchParams.valueQuantity.extractFrom(observation).isEmpty())
    assertTrue(ObservationSearchParams.valueConcept.extractFrom(observation).isEmpty())
  }

  @Test
  fun extractingParenthesizedOfTypeChoice_fromList_shouldReturnFilteredElements() {
    val contextConcept = CodeableConcept(text = dev.ohs.fhir.model.r5.String(value = "Cardiology"))
    val contextQuantity = Quantity(unit = dev.ohs.fhir.model.r5.String(value = "years"))

    val activityDefinition =
      ActivityDefinition(
        status = Enumeration(value = PublicationStatus.Draft),
        useContext =
          listOf(
            UsageContext(
              code = Coding(code = dev.ohs.fhir.model.r5.Code(value = "focus")),
              value = UsageContext.Value.CodeableConcept(contextConcept),
            ),
            UsageContext(
              code = Coding(code = dev.ohs.fhir.model.r5.Code(value = "age")),
              value = UsageContext.Value.Quantity(contextQuantity),
            ),
          ),
      )

    assertEquals(
      listOf(contextConcept),
      ActivityDefinitionSearchParams.context.extractFrom(activityDefinition),
    )
    assertEquals(
      listOf(contextQuantity),
      ActivityDefinitionSearchParams.contextQuantity.extractFrom(activityDefinition),
    )
  }

  @Test
  fun extractingParenthesizedAsChoice_withMatchingType_shouldReturnExtractedValue() {
    val dateTime = R4DateTime(value = R4FhirDateTime.fromString("2026-08-11T12:00:00Z"))
    val patient = R4Patient(deceased = R4Patient.Deceased.DateTime(dateTime))

    assertEquals(
      listOf(dateTime),
      R4PatientSearchParams.deathDate.extractFrom(patient),
    )
  }

  @Test
  fun extractingUnionChoice_withFirstBranchType_shouldReturnExtractedValue() {
    // value-date is `Observation.value.ofType(dateTime) | Observation.value.ofType(Period)`.
    val dateTime =
      dev.ohs.fhir.model.r5.DateTime(value = FhirDateTime.fromString("2026-08-12T09:30:00Z"))
    val observation =
      Observation(
        status = Enumeration(value = Observation.ObservationStatus.Final),
        code = CodeableConcept(text = dev.ohs.fhir.model.r5.String(value = "Onset")),
        value = Observation.Value.DateTime(dateTime),
      )

    assertEquals(listOf<Any>(dateTime), ObservationSearchParams.valueDate.extractFrom(observation))
  }

  @Test
  fun extractingUnionChoice_withSecondBranchType_shouldReturnExtractedValue() {
    val period =
      Period(start = dev.ohs.fhir.model.r5.DateTime(value = FhirDateTime.fromString("2026-08-01")))
    val observation =
      Observation(
        status = Enumeration(value = Observation.ObservationStatus.Final),
        code = CodeableConcept(text = dev.ohs.fhir.model.r5.String(value = "Onset")),
        value = Observation.Value.Period(period),
      )

    assertEquals(listOf<Any>(period), ObservationSearchParams.valueDate.extractFrom(observation))
  }

  @Test
  fun extractingUnionChoice_withValuesInBothBranches_shouldConcatenateInExpressionOrder() {
    // context-quantity is `(...ofType(Quantity)) | (...ofType(Range))`. Results follow the
    // branch order in the expression: all Quantity values first, then all Range values.
    val contextQuantity = Quantity(unit = dev.ohs.fhir.model.r5.String(value = "years"))
    val contextRange = Range(low = Quantity(unit = dev.ohs.fhir.model.r5.String(value = "months")))

    val activityDefinition =
      ActivityDefinition(
        status = Enumeration(value = PublicationStatus.Draft),
        useContext =
          listOf(
            UsageContext(
              code = Coding(code = dev.ohs.fhir.model.r5.Code(value = "age")),
              value = UsageContext.Value.Range(contextRange),
            ),
            UsageContext(
              code = Coding(code = dev.ohs.fhir.model.r5.Code(value = "age")),
              value = UsageContext.Value.Quantity(contextQuantity),
            ),
          ),
      )

    assertEquals(
      listOf<Any>(contextQuantity, contextRange),
      ActivityDefinitionSearchParams.contextQuantity.extractFrom(activityDefinition),
    )
  }

  @Test
  fun extractingPartiallySupportedUnion_shouldReturnOnlySupportedBranchValues() {
    // serial-number is `Device.serialNumber | Device.identifier.where(type='SNO')`. The second
    // branch is not supported and is skipped, so only the serialNumber value is extracted. See
    // "Partially extracted unions" in docs/search-parameter-patterns.md.
    val serialNumber = dev.ohs.fhir.model.r5.String(value = "SN-123")
    val device =
      Device(
        serialNumber = serialNumber,
        identifier =
          listOf(
            Identifier(
              type =
                CodeableConcept(
                  coding = listOf(Coding(code = dev.ohs.fhir.model.r5.Code(value = "SNO")))
                ),
              value = dev.ohs.fhir.model.r5.String(value = "SN-456"),
            )
          ),
      )

    assertEquals(listOf(serialNumber), DeviceSearchParams.serialNumber.extractFrom(device))
  }
}

/*
 * Copyright 2025-2026 Open Health Stack Foundation
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

import dev.ohs.fhir.model.r4.BodyStructure as R4BodyStructure
import dev.ohs.fhir.model.r4.Patient as R4Patient
import dev.ohs.fhir.model.r4.Questionnaire as R4Questionnaire
import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4b.BodyStructure as R4bBodyStructure
import dev.ohs.fhir.model.r4b.Patient as R4bPatient
import dev.ohs.fhir.model.r4b.Questionnaire as R4bQuestionnaire
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r5.BodyStructure as R5BodyStructure
import dev.ohs.fhir.model.r5.Patient as R5Patient
import dev.ohs.fhir.model.r5.Questionnaire as R5Questionnaire
import dev.ohs.fhir.model.r5.Resource as R5Resource
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.serializer

/**
 * Explicit JSON `null`s must surface as a [SerializationException] (or decode as "absent"), never
 * as a [NullPointerException] escaping from generated decode code. Exercised both through the
 * polymorphic `Resource` serializer and the standalone per-resource serializers, which share
 * `deserializeInternal` but have their own descriptor layout. Malformed non-null primitives (bad
 * dates, unknown required codes, non-numeric `integer64`) are out of scope here.
 */
class NullSafetyTest :
  FunSpec({
    val questionnaireWithNullStatus =
      """
      {
        "resourceType": "Questionnaire",
        "status": null
      }
      """
        .trimIndent()

    val questionnaireWithNullLinkId =
      """
      {
        "resourceType": "Questionnaire",
        "status": "draft",
        "item": [{ "linkId": null }]
      }
      """
        .trimIndent()

    val questionnaireWithNullItemEntry =
      """
      {
        "resourceType": "Questionnaire",
        "status": "draft",
        "item": [null]
      }
      """
        .trimIndent()

    val questionnaireWithoutStatus =
      """
      {
        "resourceType": "Questionnaire",
        "title": "Sample"
      }
      """
        .trimIndent()

    val bodyStructureWithNullPatient =
      """
      {
        "resourceType": "BodyStructure",
        "patient": null
      }
      """
        .trimIndent()

    val bodyStructureWithoutPatient =
      """
      {
        "resourceType": "BodyStructure",
        "id": "bs-1"
      }
      """
        .trimIndent()

    val patientWithNullNameList =
      """
      {
        "resourceType": "Patient",
        "name": null
      }
      """
        .trimIndent()

    val patientWithNullNameEntry =
      """
      {
        "resourceType": "Patient",
        "name": [null]
      }
      """
        .trimIndent()

    val patientWithNullText =
      """
      {
        "resourceType": "Patient",
        "text": null
      }
      """
        .trimIndent()

    val patientWithNullGivenOnly =
      """
      {
        "resourceType": "Patient",
        "name": [{ "given": [null] }]
      }
      """
        .trimIndent()

    val patientWithNullGivenButExtension =
      """
      {
        "resourceType": "Patient",
        "name": [{ "given": [null, "Ann"], "_given": [{ "id": "g1" }, null] }]
      }
      """
        .trimIndent()

    fun <
      TResource : Any,
      TQuestionnaire : TResource,
      TPatient : TResource,
      TBody : TResource,
    > nullSafetyTestSuite(
      fhirVersion: String,
      resourceSerializer: KSerializer<TResource>,
      questionnaireSerializer: KSerializer<TQuestionnaire>,
      patientSerializer: KSerializer<TPatient>,
      bodyStructureSerializer: KSerializer<TBody>,
      emptyPatient: TPatient,
      givenIdsAndValues: (TPatient) -> List<Pair<String?, String?>>,
    ) {
      fun <T> decodeFails(serializer: KSerializer<T>, json: String): SerializationException =
        assertFailsWith<SerializationException> { testJson.decodeFromString(serializer, json) }

      context("$fhirVersion explicit null for required properties") {
        test("null required enum is a SerializationException") {
          decodeFails(resourceSerializer, questionnaireWithNullStatus)
          decodeFails(questionnaireSerializer, questionnaireWithNullStatus)
        }

        test("null required primitive on a backbone element is a SerializationException") {
          decodeFails(resourceSerializer, questionnaireWithNullLinkId)
          decodeFails(questionnaireSerializer, questionnaireWithNullLinkId)
        }

        test("null required complex property is a SerializationException") {
          decodeFails(resourceSerializer, bodyStructureWithNullPatient)
          decodeFails(bodyStructureSerializer, bodyStructureWithNullPatient)
        }
      }

      context("$fhirVersion null where a list or object is expected") {
        // Optional lists and complex properties are read with `decodeNullableSerializableElement`,
        // which yields null for a JSON `null` token, and the constructor call then applies the
        // default (`listOrEmpty` / nullable property), so these decode like an absent key.
        test("null in place of a list decodes as an empty list") {
          val viaResource = testJson.decodeFromString(resourceSerializer, patientWithNullNameList)
          val viaPatient = testJson.decodeFromString(patientSerializer, patientWithNullNameList)
          assertEquals(emptyPatient, viaResource)
          assertEquals(emptyPatient, viaPatient)
        }

        test("null entry in a complex list is a SerializationException") {
          decodeFails(resourceSerializer, patientWithNullNameEntry)
          decodeFails(patientSerializer, patientWithNullNameEntry)
        }

        test("null entry in a backbone list is a SerializationException") {
          decodeFails(resourceSerializer, questionnaireWithNullItemEntry)
          decodeFails(questionnaireSerializer, questionnaireWithNullItemEntry)
        }

        test("null in place of an optional complex property decodes as absent") {
          val viaResource = testJson.decodeFromString(resourceSerializer, patientWithNullText)
          val viaPatient = testJson.decodeFromString(patientSerializer, patientWithNullText)
          assertEquals(emptyPatient, viaResource)
          assertEquals(emptyPatient, viaPatient)
        }

        test("null document is a SerializationException") {
          decodeFails(resourceSerializer, "null")
          decodeFails(patientSerializer, "null")
        }
      }

      context("$fhirVersion standalone serializers report missing required properties") {
        test("missing required enum has the same message as the polymorphic path") {
          val expected = decodeFails(resourceSerializer, questionnaireWithoutStatus).message
          assertEquals("Missing required property 'status' on Questionnaire", expected)
          assertEquals(
            expected,
            decodeFails(questionnaireSerializer, questionnaireWithoutStatus).message,
          )
        }

        test("missing required complex property has the same message as the polymorphic path") {
          val expected = decodeFails(resourceSerializer, bodyStructureWithoutPatient).message
          assertEquals("Missing required property 'patient' on BodyStructure", expected)
          assertEquals(
            expected,
            decodeFails(bodyStructureSerializer, bodyStructureWithoutPatient).message,
          )
        }
      }

      context("$fhirVersion repeated primitives with null positions") {
        test("null position without id/extension is a SerializationException on both paths") {
          val expected = decodeFails(resourceSerializer, patientWithNullGivenOnly).message
          assertEquals(
            "An entry of 'given' on HumanName has neither a value nor an id/extension",
            expected,
          )
          assertEquals(expected, decodeFails(patientSerializer, patientWithNullGivenOnly).message)
        }

        test("null position with an id/extension decodes to the merged entries") {
          val expected = listOf("g1" to null, null to "Ann")
          val viaResource =
            testJson.decodeFromString(resourceSerializer, patientWithNullGivenButExtension)
          val viaPatient =
            testJson.decodeFromString(patientSerializer, patientWithNullGivenButExtension)
          assertEquals(expected, givenIdsAndValues(viaPatient))
          assertEquals(viaPatient, viaResource)
        }
      }
    }

    nullSafetyTestSuite(
      fhirVersion = "R4",
      resourceSerializer = serializer<R4Resource>(),
      questionnaireSerializer = R4Questionnaire.serializer(),
      patientSerializer = R4Patient.serializer(),
      bodyStructureSerializer = R4BodyStructure.serializer(),
      emptyPatient = R4Patient(),
      givenIdsAndValues = { p -> p.name.single().given.map { g -> g.id to g.value } },
    )
    nullSafetyTestSuite(
      fhirVersion = "R4B",
      resourceSerializer = serializer<R4bResource>(),
      questionnaireSerializer = R4bQuestionnaire.serializer(),
      patientSerializer = R4bPatient.serializer(),
      bodyStructureSerializer = R4bBodyStructure.serializer(),
      emptyPatient = R4bPatient(),
      givenIdsAndValues = { p -> p.name.single().given.map { g -> g.id to g.value } },
    )
    nullSafetyTestSuite(
      fhirVersion = "R5",
      resourceSerializer = serializer<R5Resource>(),
      questionnaireSerializer = R5Questionnaire.serializer(),
      patientSerializer = R5Patient.serializer(),
      bodyStructureSerializer = R5BodyStructure.serializer(),
      emptyPatient = R5Patient(),
      givenIdsAndValues = { p -> p.name.single().given.map { g -> g.id to g.value } },
    )
  })

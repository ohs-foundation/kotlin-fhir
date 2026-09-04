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

import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r5.Resource as R5Resource
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.serializer

class SerializationExceptionTest :
  FunSpec({
    val questionnaireWithoutStatusJson =
      """
      {
        "resourceType": "Questionnaire",
        "title": "Sample"
      }
      """
        .trimIndent()

    val questionnaireWithoutLinkIdJson =
      """
      {
        "resourceType": "Questionnaire",
        "status": "draft",
        "item": [
          {
            "text": "Question"
          }
        ]
      }
      """
        .trimIndent()

    fun <TResource : Any> serializationExceptionTestSuite(
      fhirVersion: String,
      resourceSerializer: KSerializer<TResource>,
    ) {
      context("$fhirVersion Missing Required Properties") {
        test("missing required enum property throws SerializationException") {
          val exception =
            assertFailsWith<SerializationException> {
              testJson.decodeFromString(resourceSerializer, questionnaireWithoutStatusJson)
            }
          assertEquals("Missing required property 'status' on Questionnaire", exception.message)
        }

        test("missing required primitive property throws SerializationException") {
          val exception =
            assertFailsWith<SerializationException> {
              testJson.decodeFromString(resourceSerializer, questionnaireWithoutLinkIdJson)
            }
          assertEquals(
            "Missing required property 'linkId' on Questionnaire.Item",
            exception.message,
          )
        }
      }
    }

    serializationExceptionTestSuite("R4", serializer<R4Resource>())
    serializationExceptionTestSuite("R4B", serializer<R4bResource>())
    serializationExceptionTestSuite("R5", serializer<R5Resource>())
  })

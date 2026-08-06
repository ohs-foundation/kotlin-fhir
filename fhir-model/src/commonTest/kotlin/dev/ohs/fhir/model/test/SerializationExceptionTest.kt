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
    fun <TResource : Any> runMissingPropertyTests(
      fhirVersionName: String,
      resourceSerializer: KSerializer<TResource>,
    ) {
      context("$fhirVersionName Missing Required Properties") {
        test("$fhirVersionName missing required enum property throws SerializationException") {
          val json = """{"resourceType":"Questionnaire","title":"Sample"}"""
          val exception =
            assertFailsWith<SerializationException> {
              testJson.decodeFromString(resourceSerializer, json)
            }
          assertEquals("Missing required property 'status' on Questionnaire", exception.message)
        }

        test("$fhirVersionName missing required primitive property throws SerializationException") {
          val json =
            """{"resourceType":"Questionnaire","status":"draft","item":[{"text":"Question"}]}"""
          val exception =
            assertFailsWith<SerializationException> {
              testJson.decodeFromString(resourceSerializer, json)
            }
          assertEquals(
            "Missing required property 'linkId' on Questionnaire.Item",
            exception.message,
          )
        }
      }
    }

    runMissingPropertyTests("R4", serializer<R4Resource>())
    runMissingPropertyTests("R4B", serializer<R4bResource>())
    runMissingPropertyTests("R5", serializer<R5Resource>())
  })

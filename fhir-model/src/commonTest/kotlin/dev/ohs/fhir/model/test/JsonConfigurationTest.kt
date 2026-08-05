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

@file:Suppress("RedundantJson")

package dev.ohs.fhir.model.test

import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Resource
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

/**
 * Behavior under non-default `JsonBuilder` settings. Pinned so future changes to the polymorphic
 * serializer or descriptor wiring don't silently change wire shape under common configurations.
 */
class JsonConfigurationTest :
  FunSpec({
    // R4 covers the per-version codegen; r4b/r5 share the same SerializerFileSpecGenerator so a
    // representative version is enough for config-behavior tests.

    test("prettyPrint=false produces compact polymorphic JSON with resourceType first") {
      val patient = Patient(id = "patient-01")
      val json = Json { prettyPrint = false }.encodeToString<Resource>(patient)
      assertEquals("""{"resourceType":"Patient","id":"patient-01"}""", json)
    }

    test("prettyPrint=false standalone serializer also emits resourceType first") {
      val patient = Patient(id = "patient-01")
      val s = Json { prettyPrint = false }.encodeToString(Patient.serializer(), patient)
      assertTrue(s.startsWith("""{"resourceType":"Patient","""))
      assertTrue(s.contains(""""id":"patient-01""""))
    }

    test("encodeDefaults=true does not change wire shape") {
      // Our generators write fields with explicit `?.let { … }` / `if (isNotEmpty)` guards rather
      // than relying on kotlinx's default-handling, so toggling `encodeDefaults` should be a no-op.
      val patient = Patient(id = "patient-01")
      val withDefault = Json { encodeDefaults = false }.encodeToString<Resource>(patient)
      val withDefaultsOn = Json { encodeDefaults = true }.encodeToString<Resource>(patient)
      assertEquals(withDefault, withDefaultsOn)
    }

    test("explicitNulls=false does not change wire shape") {
      // Same rationale as encodeDefaults — our generators never emit JSON `null`, so flipping
      // explicitNulls has no observable effect.
      val patient = Patient(id = "patient-01")
      val withNullsOn = Json { explicitNulls = true }.encodeToString<Resource>(patient)
      val withNullsOff = Json { explicitNulls = false }.encodeToString<Resource>(patient)
      assertEquals(withNullsOn, withNullsOff)
    }

    test("custom Json.classDiscriminator is overridden by @JsonClassDiscriminator on descriptor") {
      // `JsonClassDiscriminator` lives on `ResourcePolymorphicSerializer.descriptor.annotations`,
      // which `Polymorphic.kt:97` consults before falling back to
      // `Json.configuration.classDiscriminator`.
      // So a user's custom `classDiscriminator` setting should not affect resource encoding.
      val patient = Patient(id = "patient-01")
      val json =
        Json {
            prettyPrint = false
            classDiscriminator = "kind"
          }
          .encodeToString<Resource>(patient)
      assertTrue(json.contains(""""resourceType":"Patient""""))
      assertFalse(json.contains(""""kind":"Patient""""))
    }

    test("ignoreUnknownKeys=true allows decoding unknown fields") {
      // FHIR forward-compatibility: a server may send fields we don't know about. With
      // `ignoreUnknownKeys = true`, the decoder skips them instead of throwing.
      val withExtra =
        """
        {
          "resourceType": "Patient",
          "id": "patient-01",
          "_some_brand_new_field_we_do_not_know_about": {"x": 1}
        }
        """
          .trimIndent()
      val decoded =
        Json { ignoreUnknownKeys = true }.decodeFromString<Resource>(withExtra) as Patient
      assertEquals("patient-01", decoded.id)
    }

    test("default Json (ignoreUnknownKeys=false) rejects unknown fields") {
      val withExtra =
        """
        {
          "resourceType": "Patient",
          "id": "patient-01",
          "_some_brand_new_field_we_do_not_know_about": {"x": 1}
        }
        """
          .trimIndent()
      assertFailsWith<SerializationException> { testJson.decodeFromString<Resource>(withExtra) }
    }

    test("isLenient=true accepts unquoted resourceType discriminator") {
      // `isLenient` lets the lexer accept unquoted strings. Confirms our polymorphic decode path
      // (which goes through kotlinx-json's tree decoder) inherits the leniency.
      val lenient =
        """
        {
          "resourceType": Patient,
          "id": "patient-01"
        }
        """
          .trimIndent()
      val decoded = Json { isLenient = true }.decodeFromString<Resource>(lenient) as Patient
      assertEquals("patient-01", decoded.id)
    }

    test("polymorphic round-trip preserves equality under non-default config") {
      val original = Patient(id = "patient-01")
      val json = Json {
        prettyPrint = false
        encodeDefaults = true
        ignoreUnknownKeys = true
        classDiscriminator = "kind" // intentionally non-default; should be overridden
      }
      val s = json.encodeToString<Resource>(original)
      val decoded = json.decodeFromString<Resource>(s) as Patient
      assertEquals(original.id, decoded.id)
    }

    test("resourceType-not-leading still decodes") {
      // FHIR allows `resourceType` anywhere in the object. kotlinx-json's polymorphic decode reads
      // the JSON as a tree, so position-independence comes for free.
      val midObject =
        """
        {
          "id": "patient-01",
          "resourceType": "Patient"
        }
        """
          .trimIndent()
      val decoded: Resource = testJson.decodeFromString<Resource>(midObject)
      assertEquals("patient-01", (decoded as Patient).id)
    }
  })

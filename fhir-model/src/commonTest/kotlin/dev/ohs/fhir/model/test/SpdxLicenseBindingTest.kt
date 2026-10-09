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

import dev.ohs.fhir.model.r4.ExtensibleEnumeration as R4ExtensibleEnumeration
import dev.ohs.fhir.model.r4.ImplementationGuide as R4ImplementationGuide
import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4.terminologies.SPDXLicense as R4SPDXLicense
import dev.ohs.fhir.model.r4b.ExtensibleEnumeration as R4bExtensibleEnumeration
import dev.ohs.fhir.model.r4b.ImplementationGuide as R4bImplementationGuide
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r4b.terminologies.SPDXLicense as R4bSPDXLicense
import dev.ohs.fhir.model.r5.ExtensibleEnumeration as R5ExtensibleEnumeration
import dev.ohs.fhir.model.r5.ImplementationGuide as R5ImplementationGuide
import dev.ohs.fhir.model.r5.Resource as R5Resource
import dev.ohs.fhir.model.r5.terminologies.SPDXLicense as R5SPDXLicense
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlinx.serialization.serializer

/**
 * `ImplementationGuide.license` has a required binding to the SPDX license value set, but the
 * binding description allows SPDX identifiers added after the value set was published. It is
 * therefore generated as an `ExtensibleEnumeration`.
 */
class SpdxLicenseBindingTest :
  FunSpec({
    fun implementationGuideJson(fhirVersion: String, license: String) =
      """
      {
        "resourceType": "ImplementationGuide",
        "url": "http://example.org/ImplementationGuide/example",
        "name": "Example",
        "status": "draft",
        "packageId": "example.ig",
        "license": "$license",
        "fhirVersion": ["$fhirVersion"]
      }
      """
        .trimIndent()

    context("R4") {
      val serializer = serializer<R4Resource>()

      test("license in the value set is decoded as Predefined") {
        val resource =
          testJson.decodeFromString(serializer, implementationGuideJson("4.0.1", "CC0-1.0"))
        val license = assertIs<R4ImplementationGuide>(resource).license
        assertIs<R4ExtensibleEnumeration.Predefined<R4SPDXLicense>>(license)
        assertEquals(R4SPDXLicense.CC0_1_0, license.value)
      }

      test("SPDX license outside the value set is decoded as Custom and encoded unchanged") {
        val resource =
          testJson.decodeFromString(
            serializer,
            implementationGuideJson("4.0.1", "CC-BY-SA-3.0-IGO"),
          )
        val license = assertIs<R4ImplementationGuide>(resource).license
        assertIs<R4ExtensibleEnumeration.Custom>(license)
        assertEquals("CC-BY-SA-3.0-IGO", license.code)
        assertContains(testJson.encodeToString(serializer, resource), "\"CC-BY-SA-3.0-IGO\"")
      }
    }

    context("R4B") {
      val serializer = serializer<R4bResource>()

      test("license in the value set is decoded as Predefined") {
        val resource =
          testJson.decodeFromString(serializer, implementationGuideJson("4.3.0", "CC0-1.0"))
        val license = assertIs<R4bImplementationGuide>(resource).license
        assertIs<R4bExtensibleEnumeration.Predefined<R4bSPDXLicense>>(license)
        assertEquals(R4bSPDXLicense.CC0_1_0, license.value)
      }

      test("SPDX license outside the value set is decoded as Custom and encoded unchanged") {
        val resource =
          testJson.decodeFromString(
            serializer,
            implementationGuideJson("4.3.0", "CC-BY-SA-3.0-IGO"),
          )
        val license = assertIs<R4bImplementationGuide>(resource).license
        assertIs<R4bExtensibleEnumeration.Custom>(license)
        assertEquals("CC-BY-SA-3.0-IGO", license.code)
        assertContains(testJson.encodeToString(serializer, resource), "\"CC-BY-SA-3.0-IGO\"")
      }
    }

    context("R5") {
      val serializer = serializer<R5Resource>()

      test("license in the value set is decoded as Predefined") {
        val resource =
          testJson.decodeFromString(serializer, implementationGuideJson("5.0.0", "CC0-1.0"))
        val license = assertIs<R5ImplementationGuide>(resource).license
        assertIs<R5ExtensibleEnumeration.Predefined<R5SPDXLicense>>(license)
        assertEquals(R5SPDXLicense.CC0_1_0, license.value)
      }

      test("SPDX license outside the value set is decoded as Custom and encoded unchanged") {
        val resource =
          testJson.decodeFromString(
            serializer,
            implementationGuideJson("5.0.0", "CC-BY-SA-3.0-IGO"),
          )
        val license = assertIs<R5ImplementationGuide>(resource).license
        assertIs<R5ExtensibleEnumeration.Custom>(license)
        assertEquals("CC-BY-SA-3.0-IGO", license.code)
        assertContains(testJson.encodeToString(serializer, resource), "\"CC-BY-SA-3.0-IGO\"")
      }
    }
  })

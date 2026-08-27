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
import dev.ohs.fhir.model.r4.Reference as R4Reference
import dev.ohs.fhir.model.r4.Resource as R4Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4b.BodyStructure as R4bBodyStructure
import dev.ohs.fhir.model.r4b.Reference as R4bReference
import dev.ohs.fhir.model.r4b.Resource as R4bResource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r5.BodyStructure as R5BodyStructure
import dev.ohs.fhir.model.r5.Reference as R5Reference
import dev.ohs.fhir.model.r5.Resource as R5Resource
import dev.ohs.fhir.model.r5.String as R5String
import io.kotest.core.spec.style.FunSpec
import kotlin.test.assertEquals
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.protobuf.ProtoBuf
import kotlinx.serialization.serializer

/**
 * Tests ProtoBuf descriptor field index ordering between resource-type-specific and polymorphic
 * serializers.
 */
@OptIn(ExperimentalSerializationApi::class)
class IndexOrderingTest :
  FunSpec({
    val proto = ProtoBuf {}

    fun <TResource : Any, TBodyStructure : TResource> indexOrderingTestSuite(
      fhirVersion: String,
      resourceSerializer: KSerializer<TResource>,
      bodyStructureSerializer: KSerializer<TBodyStructure>,
      createBodyStructure: () -> TBodyStructure,
    ) {
      context("$fhirVersion Index Ordering") {
        test("resource-type-specific serializer round-trips through ProtoBuf") {
          val original = createBodyStructure()
          val decoded =
            proto.decodeFromByteArray(
              bodyStructureSerializer,
              proto.encodeToByteArray(bodyStructureSerializer, original),
            )
          assertEquals(original, decoded)
        }

        test("polymorphic Resource serializer round-trips through ProtoBuf") {
          val original = createBodyStructure()
          val decoded =
            proto.decodeFromByteArray(
              resourceSerializer,
              proto.encodeToByteArray(resourceSerializer, original),
            )
          assertEquals(original, decoded)
        }
      }
    }

    // BodyStructure is used because its required `patient` field occupies a high descriptor index.
    indexOrderingTestSuite(
      fhirVersion = "R4",
      resourceSerializer = serializer<R4Resource>(),
      bodyStructureSerializer = R4BodyStructure.serializer(),
      createBodyStructure = {
        R4BodyStructure(
          id = "bs-1",
          patient = R4Reference(reference = R4String.of("Patient/example", null)),
        )
      },
    )
    indexOrderingTestSuite(
      fhirVersion = "R4B",
      resourceSerializer = serializer<R4bResource>(),
      bodyStructureSerializer = R4bBodyStructure.serializer(),
      createBodyStructure = {
        R4bBodyStructure(
          id = "bs-1",
          patient = R4bReference(reference = R4bString.of("Patient/example", null)),
        )
      },
    )
    indexOrderingTestSuite(
      fhirVersion = "R5",
      resourceSerializer = serializer<R5Resource>(),
      bodyStructureSerializer = R5BodyStructure.serializer(),
      createBodyStructure = {
        R5BodyStructure(
          id = "bs-1",
          includedStructure = listOf(),
          patient = R5Reference(reference = R5String.of("Patient/example", null)),
        )
      },
    )
  })

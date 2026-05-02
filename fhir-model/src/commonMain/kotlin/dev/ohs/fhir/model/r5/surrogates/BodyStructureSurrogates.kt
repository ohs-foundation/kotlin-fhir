/*
 * Copyright 2026 Google LLC
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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.BodyStructure
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class BodyStructureIncludedStructureSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var structure: CodeableConcept,
  public var laterality: CodeableConcept? = null,
  public var bodyLandmarkOrientation:
    List<BodyStructure.IncludedStructure.BodyLandmarkOrientation>? =
    null,
  public var spatialReference: List<Reference>? = null,
  public var qualifier: List<CodeableConcept>? = null,
) {
  public fun toModel(): BodyStructure.IncludedStructure =
    BodyStructure.IncludedStructure(
      id = this@BodyStructureIncludedStructureSurrogate.id,
      extension = this@BodyStructureIncludedStructureSurrogate.extension ?: listOf(),
      modifierExtension =
        this@BodyStructureIncludedStructureSurrogate.modifierExtension ?: listOf(),
      structure = this@BodyStructureIncludedStructureSurrogate.structure,
      laterality = this@BodyStructureIncludedStructureSurrogate.laterality,
      bodyLandmarkOrientation =
        this@BodyStructureIncludedStructureSurrogate.bodyLandmarkOrientation ?: listOf(),
      spatialReference = this@BodyStructureIncludedStructureSurrogate.spatialReference ?: listOf(),
      qualifier = this@BodyStructureIncludedStructureSurrogate.qualifier ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: BodyStructure.IncludedStructure
    ): BodyStructureIncludedStructureSurrogate =
      with(model) {
        BodyStructureIncludedStructureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          structure = this@with.structure,
          laterality = this@with.laterality,
          bodyLandmarkOrientation = this@with.bodyLandmarkOrientation.takeIf { it.isNotEmpty() },
          spatialReference = this@with.spatialReference.takeIf { it.isNotEmpty() },
          qualifier = this@with.qualifier.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var landmarkDescription: List<CodeableConcept>? = null,
  public var clockFacePosition: List<CodeableConcept>? = null,
  public var distanceFromLandmark:
    List<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark>? =
    null,
  public var surfaceOrientation: List<CodeableConcept>? = null,
) {
  public fun toModel(): BodyStructure.IncludedStructure.BodyLandmarkOrientation =
    BodyStructure.IncludedStructure.BodyLandmarkOrientation(
      id = this@BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.id,
      extension =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.modifierExtension
          ?: listOf(),
      landmarkDescription =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.landmarkDescription
          ?: listOf(),
      clockFacePosition =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.clockFacePosition
          ?: listOf(),
      distanceFromLandmark =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.distanceFromLandmark
          ?: listOf(),
      surfaceOrientation =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.surfaceOrientation
          ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: BodyStructure.IncludedStructure.BodyLandmarkOrientation
    ): BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate =
      with(model) {
        BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          landmarkDescription = this@with.landmarkDescription.takeIf { it.isNotEmpty() },
          clockFacePosition = this@with.clockFacePosition.takeIf { it.isNotEmpty() },
          distanceFromLandmark = this@with.distanceFromLandmark.takeIf { it.isNotEmpty() },
          surfaceOrientation = this@with.surfaceOrientation.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var device: List<CodeableReference>? = null,
  public var `value`: List<Quantity>? = null,
) {
  public fun toModel():
    BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark =
    BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark(
      id =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate.id,
      extension =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate
          .extension ?: listOf(),
      modifierExtension =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate
          .modifierExtension ?: listOf(),
      device =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate
          .device ?: listOf(),
      `value` =
        this@BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate
          .`value` ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark
    ): BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate =
      with(model) {
        BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          device = this@with.device.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class BodyStructureSurrogate(
  public var id: String? = null,
  public var meta: Meta? = null,
  public var implicitRules: String? = null,
  public var _implicitRules: Element? = null,
  public var language: String? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var active: KotlinBoolean? = null,
  public var _active: Element? = null,
  public var morphology: CodeableConcept? = null,
  public var includedStructure: List<BodyStructure.IncludedStructure>? = null,
  public var excludedStructure: List<BodyStructure.IncludedStructure>? = null,
  public var description: String? = null,
  public var _description: Element? = null,
  public var image: List<Attachment>? = null,
  public var patient: Reference,
) {
  public fun toModel(): BodyStructure =
    BodyStructure(
      id = this@BodyStructureSurrogate.id,
      meta = this@BodyStructureSurrogate.meta,
      implicitRules =
        Uri.of(
          this@BodyStructureSurrogate.implicitRules,
          this@BodyStructureSurrogate._implicitRules,
        ),
      language =
        Code.of(this@BodyStructureSurrogate.language, this@BodyStructureSurrogate._language),
      text = this@BodyStructureSurrogate.text,
      contained = this@BodyStructureSurrogate.contained ?: listOf(),
      extension = this@BodyStructureSurrogate.extension ?: listOf(),
      modifierExtension = this@BodyStructureSurrogate.modifierExtension ?: listOf(),
      identifier = this@BodyStructureSurrogate.identifier ?: listOf(),
      active =
        R5Boolean.of(this@BodyStructureSurrogate.active, this@BodyStructureSurrogate._active),
      morphology = this@BodyStructureSurrogate.morphology,
      includedStructure = this@BodyStructureSurrogate.includedStructure ?: listOf(),
      excludedStructure = this@BodyStructureSurrogate.excludedStructure ?: listOf(),
      description =
        Markdown.of(
          this@BodyStructureSurrogate.description,
          this@BodyStructureSurrogate._description,
        ),
      image = this@BodyStructureSurrogate.image ?: listOf(),
      patient = this@BodyStructureSurrogate.patient,
    )

  public companion object {
    public fun fromModel(model: BodyStructure): BodyStructureSurrogate =
      with(model) {
        BodyStructureSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          active = this@with.active?.value,
          _active = this@with.active?.toElement(),
          morphology = this@with.morphology,
          includedStructure = this@with.includedStructure.takeIf { it.isNotEmpty() },
          excludedStructure = this@with.excludedStructure.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          image = this@with.image.takeIf { it.isNotEmpty() },
          patient = this@with.patient,
        )
      }
  }
}

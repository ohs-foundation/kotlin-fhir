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

package com.google.fhir.model.r4.surrogates

import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Duration
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.SpecimenDefinition
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SpecimenDefinitionTypeTestedSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var isDerived: KotlinBoolean? = null,
  public var _isDerived: Element? = null,
  public var type: CodeableConcept? = null,
  public var preference: KotlinString? = null,
  public var _preference: Element? = null,
  public var container: SpecimenDefinition.TypeTested.Container? = null,
  public var requirement: KotlinString? = null,
  public var _requirement: Element? = null,
  public var retentionTime: Duration? = null,
  public var rejectionCriterion: List<CodeableConcept>? = null,
  public var handling: List<SpecimenDefinition.TypeTested.Handling>? = null,
) {
  public fun toModel(): SpecimenDefinition.TypeTested =
    SpecimenDefinition.TypeTested(
      id = this@SpecimenDefinitionTypeTestedSurrogate.id,
      extension = this@SpecimenDefinitionTypeTestedSurrogate.extension ?: listOf(),
      modifierExtension = this@SpecimenDefinitionTypeTestedSurrogate.modifierExtension ?: listOf(),
      isDerived =
        R4Boolean.of(
          this@SpecimenDefinitionTypeTestedSurrogate.isDerived,
          this@SpecimenDefinitionTypeTestedSurrogate._isDerived,
        ),
      type = this@SpecimenDefinitionTypeTestedSurrogate.type,
      preference =
        Enumeration.of(
          SpecimenDefinition.SpecimenContainedPreference.fromCode(
            this@SpecimenDefinitionTypeTestedSurrogate.preference!!
          ),
          this@SpecimenDefinitionTypeTestedSurrogate._preference,
        ),
      container = this@SpecimenDefinitionTypeTestedSurrogate.container,
      requirement =
        R4String.of(
          this@SpecimenDefinitionTypeTestedSurrogate.requirement,
          this@SpecimenDefinitionTypeTestedSurrogate._requirement,
        ),
      retentionTime = this@SpecimenDefinitionTypeTestedSurrogate.retentionTime,
      rejectionCriterion =
        this@SpecimenDefinitionTypeTestedSurrogate.rejectionCriterion ?: listOf(),
      handling = this@SpecimenDefinitionTypeTestedSurrogate.handling ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SpecimenDefinition.TypeTested
    ): SpecimenDefinitionTypeTestedSurrogate =
      with(model) {
        SpecimenDefinitionTypeTestedSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          isDerived = this@with.isDerived?.value,
          _isDerived = this@with.isDerived?.toElement(),
          type = this@with.type,
          preference = this@with.preference.value?.getCode(),
          _preference = this@with.preference.toElement(),
          container = this@with.container,
          requirement = this@with.requirement?.value,
          _requirement = this@with.requirement?.toElement(),
          retentionTime = this@with.retentionTime,
          rejectionCriterion = this@with.rejectionCriterion.takeIf { it.isNotEmpty() },
          handling = this@with.handling.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SpecimenDefinitionTypeTestedContainerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var material: CodeableConcept? = null,
  public var type: CodeableConcept? = null,
  public var cap: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var capacity: Quantity? = null,
  public var minimumVolume: SpecimenDefinition.TypeTested.Container.MinimumVolume? = null,
  public var additive: List<SpecimenDefinition.TypeTested.Container.Additive>? = null,
  public var preparation: KotlinString? = null,
  public var _preparation: Element? = null,
) {
  public fun toModel(): SpecimenDefinition.TypeTested.Container =
    SpecimenDefinition.TypeTested.Container(
      id = this@SpecimenDefinitionTypeTestedContainerSurrogate.id,
      extension = this@SpecimenDefinitionTypeTestedContainerSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SpecimenDefinitionTypeTestedContainerSurrogate.modifierExtension ?: listOf(),
      material = this@SpecimenDefinitionTypeTestedContainerSurrogate.material,
      type = this@SpecimenDefinitionTypeTestedContainerSurrogate.type,
      cap = this@SpecimenDefinitionTypeTestedContainerSurrogate.cap,
      description =
        R4String.of(
          this@SpecimenDefinitionTypeTestedContainerSurrogate.description,
          this@SpecimenDefinitionTypeTestedContainerSurrogate._description,
        ),
      capacity = this@SpecimenDefinitionTypeTestedContainerSurrogate.capacity,
      minimumVolume = this@SpecimenDefinitionTypeTestedContainerSurrogate.minimumVolume,
      additive = this@SpecimenDefinitionTypeTestedContainerSurrogate.additive ?: listOf(),
      preparation =
        R4String.of(
          this@SpecimenDefinitionTypeTestedContainerSurrogate.preparation,
          this@SpecimenDefinitionTypeTestedContainerSurrogate._preparation,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SpecimenDefinition.TypeTested.Container
    ): SpecimenDefinitionTypeTestedContainerSurrogate =
      with(model) {
        SpecimenDefinitionTypeTestedContainerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          material = this@with.material,
          type = this@with.type,
          cap = this@with.cap,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          capacity = this@with.capacity,
          minimumVolume = this@with.minimumVolume,
          additive = this@with.additive.takeIf { it.isNotEmpty() },
          preparation = this@with.preparation?.value,
          _preparation = this@with.preparation?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SpecimenDefinitionTypeTestedContainerAdditiveSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var additive: SpecimenDefinition.TypeTested.Container.Additive.Additive,
) {
  public fun toModel(): SpecimenDefinition.TypeTested.Container.Additive =
    SpecimenDefinition.TypeTested.Container.Additive(
      id = this@SpecimenDefinitionTypeTestedContainerAdditiveSurrogate.id,
      extension = this@SpecimenDefinitionTypeTestedContainerAdditiveSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SpecimenDefinitionTypeTestedContainerAdditiveSurrogate.modifierExtension ?: listOf(),
      additive = this@SpecimenDefinitionTypeTestedContainerAdditiveSurrogate.additive,
    )

  public companion object {
    public fun fromModel(
      model: SpecimenDefinition.TypeTested.Container.Additive
    ): SpecimenDefinitionTypeTestedContainerAdditiveSurrogate =
      with(model) {
        SpecimenDefinitionTypeTestedContainerAdditiveSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          additive = this@with.additive,
        )
      }
  }
}

@Serializable
internal data class SpecimenDefinitionTypeTestedHandlingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var temperatureQualifier: CodeableConcept? = null,
  public var temperatureRange: Range? = null,
  public var maxDuration: Duration? = null,
  public var instruction: KotlinString? = null,
  public var _instruction: Element? = null,
) {
  public fun toModel(): SpecimenDefinition.TypeTested.Handling =
    SpecimenDefinition.TypeTested.Handling(
      id = this@SpecimenDefinitionTypeTestedHandlingSurrogate.id,
      extension = this@SpecimenDefinitionTypeTestedHandlingSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SpecimenDefinitionTypeTestedHandlingSurrogate.modifierExtension ?: listOf(),
      temperatureQualifier =
        this@SpecimenDefinitionTypeTestedHandlingSurrogate.temperatureQualifier,
      temperatureRange = this@SpecimenDefinitionTypeTestedHandlingSurrogate.temperatureRange,
      maxDuration = this@SpecimenDefinitionTypeTestedHandlingSurrogate.maxDuration,
      instruction =
        R4String.of(
          this@SpecimenDefinitionTypeTestedHandlingSurrogate.instruction,
          this@SpecimenDefinitionTypeTestedHandlingSurrogate._instruction,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SpecimenDefinition.TypeTested.Handling
    ): SpecimenDefinitionTypeTestedHandlingSurrogate =
      with(model) {
        SpecimenDefinitionTypeTestedHandlingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          temperatureQualifier = this@with.temperatureQualifier,
          temperatureRange = this@with.temperatureRange,
          maxDuration = this@with.maxDuration,
          instruction = this@with.instruction?.value,
          _instruction = this@with.instruction?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate(
  public var minimumVolumeQuantity: Quantity? = null,
  public var minimumVolumeString: KotlinString? = null,
  public var _minimumVolumeString: Element? = null,
) {
  public fun toModel(): SpecimenDefinition.TypeTested.Container.MinimumVolume =
    SpecimenDefinition.TypeTested.Container.MinimumVolume.from(
      this@SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate.minimumVolumeQuantity,
      R4String.of(
        this@SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate.minimumVolumeString,
        this@SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate._minimumVolumeString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: SpecimenDefinition.TypeTested.Container.MinimumVolume
    ): SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate =
      with(model) {
        SpecimenDefinitionTypeTestedContainerMinimumVolumeSurrogate(
          minimumVolumeQuantity = this@with.asQuantity()?.value,
          minimumVolumeString = this@with.asString()?.value?.value,
          _minimumVolumeString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate(
  public var additiveCodeableConcept: CodeableConcept? = null,
  public var additiveReference: Reference? = null,
) {
  public fun toModel(): SpecimenDefinition.TypeTested.Container.Additive.Additive =
    SpecimenDefinition.TypeTested.Container.Additive.Additive.from(
      this@SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate.additiveCodeableConcept,
      this@SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate.additiveReference,
    )!!

  public companion object {
    public fun fromModel(
      model: SpecimenDefinition.TypeTested.Container.Additive.Additive
    ): SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate =
      with(model) {
        SpecimenDefinitionTypeTestedContainerAdditiveAdditiveSurrogate(
          additiveCodeableConcept = this@with.asCodeableConcept()?.value,
          additiveReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class SpecimenDefinitionSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var typeCollected: CodeableConcept? = null,
  public var patientPreparation: List<CodeableConcept>? = null,
  public var timeAspect: KotlinString? = null,
  public var _timeAspect: Element? = null,
  public var collection: List<CodeableConcept>? = null,
  public var typeTested: List<SpecimenDefinition.TypeTested>? = null,
) {
  public fun toModel(): SpecimenDefinition =
    SpecimenDefinition(
      id = this@SpecimenDefinitionSurrogate.id,
      meta = this@SpecimenDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SpecimenDefinitionSurrogate.implicitRules,
          this@SpecimenDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@SpecimenDefinitionSurrogate.language,
          this@SpecimenDefinitionSurrogate._language,
        ),
      text = this@SpecimenDefinitionSurrogate.text,
      contained = this@SpecimenDefinitionSurrogate.contained ?: listOf(),
      extension = this@SpecimenDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@SpecimenDefinitionSurrogate.modifierExtension ?: listOf(),
      identifier = this@SpecimenDefinitionSurrogate.identifier,
      typeCollected = this@SpecimenDefinitionSurrogate.typeCollected,
      patientPreparation = this@SpecimenDefinitionSurrogate.patientPreparation ?: listOf(),
      timeAspect =
        R4String.of(
          this@SpecimenDefinitionSurrogate.timeAspect,
          this@SpecimenDefinitionSurrogate._timeAspect,
        ),
      collection = this@SpecimenDefinitionSurrogate.collection ?: listOf(),
      typeTested = this@SpecimenDefinitionSurrogate.typeTested ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SpecimenDefinition): SpecimenDefinitionSurrogate =
      with(model) {
        SpecimenDefinitionSurrogate(
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
          identifier = this@with.identifier,
          typeCollected = this@with.typeCollected,
          patientPreparation = this@with.patientPreparation.takeIf { it.isNotEmpty() },
          timeAspect = this@with.timeAspect?.value,
          _timeAspect = this@with.timeAspect?.toElement(),
          collection = this@with.collection.takeIf { it.isNotEmpty() },
          typeTested = this@with.typeTested.takeIf { it.isNotEmpty() },
        )
      }
  }
}

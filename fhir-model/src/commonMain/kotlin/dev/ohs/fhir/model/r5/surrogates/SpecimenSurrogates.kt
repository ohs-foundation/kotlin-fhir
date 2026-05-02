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

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Duration
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Specimen
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.SpecimenCombined
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SpecimenFeatureSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
) {
  public fun toModel(): Specimen.Feature =
    Specimen.Feature(
      id = this@SpecimenFeatureSurrogate.id,
      extension = this@SpecimenFeatureSurrogate.extension ?: listOf(),
      modifierExtension = this@SpecimenFeatureSurrogate.modifierExtension ?: listOf(),
      type = this@SpecimenFeatureSurrogate.type,
      description =
        R5String.of(
          this@SpecimenFeatureSurrogate.description,
          this@SpecimenFeatureSurrogate._description,
        )!!,
    )

  public companion object {
    public fun fromModel(model: Specimen.Feature): SpecimenFeatureSurrogate =
      with(model) {
        SpecimenFeatureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          description = this@with.description.value,
          _description = this@with.description.toElement(),
        )
      }
  }
}

@Serializable
internal data class SpecimenCollectionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var collector: Reference? = null,
  public var collected: Specimen.Collection.Collected? = null,
  public var duration: Duration? = null,
  public var quantity: Quantity? = null,
  public var method: CodeableConcept? = null,
  public var device: CodeableReference? = null,
  public var procedure: Reference? = null,
  public var bodySite: CodeableReference? = null,
  public var fastingStatus: Specimen.Collection.FastingStatus? = null,
) {
  public fun toModel(): Specimen.Collection =
    Specimen.Collection(
      id = this@SpecimenCollectionSurrogate.id,
      extension = this@SpecimenCollectionSurrogate.extension ?: listOf(),
      modifierExtension = this@SpecimenCollectionSurrogate.modifierExtension ?: listOf(),
      collector = this@SpecimenCollectionSurrogate.collector,
      collected = this@SpecimenCollectionSurrogate.collected,
      duration = this@SpecimenCollectionSurrogate.duration,
      quantity = this@SpecimenCollectionSurrogate.quantity,
      method = this@SpecimenCollectionSurrogate.method,
      device = this@SpecimenCollectionSurrogate.device,
      procedure = this@SpecimenCollectionSurrogate.procedure,
      bodySite = this@SpecimenCollectionSurrogate.bodySite,
      fastingStatus = this@SpecimenCollectionSurrogate.fastingStatus,
    )

  public companion object {
    public fun fromModel(model: Specimen.Collection): SpecimenCollectionSurrogate =
      with(model) {
        SpecimenCollectionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          collector = this@with.collector,
          collected = this@with.collected,
          duration = this@with.duration,
          quantity = this@with.quantity,
          method = this@with.method,
          device = this@with.device,
          procedure = this@with.procedure,
          bodySite = this@with.bodySite,
          fastingStatus = this@with.fastingStatus,
        )
      }
  }
}

@Serializable
internal data class SpecimenProcessingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var method: CodeableConcept? = null,
  public var additive: List<Reference>? = null,
  public var time: Specimen.Processing.Time? = null,
) {
  public fun toModel(): Specimen.Processing =
    Specimen.Processing(
      id = this@SpecimenProcessingSurrogate.id,
      extension = this@SpecimenProcessingSurrogate.extension ?: listOf(),
      modifierExtension = this@SpecimenProcessingSurrogate.modifierExtension ?: listOf(),
      description =
        R5String.of(
          this@SpecimenProcessingSurrogate.description,
          this@SpecimenProcessingSurrogate._description,
        ),
      method = this@SpecimenProcessingSurrogate.method,
      additive = this@SpecimenProcessingSurrogate.additive ?: listOf(),
      time = this@SpecimenProcessingSurrogate.time,
    )

  public companion object {
    public fun fromModel(model: Specimen.Processing): SpecimenProcessingSurrogate =
      with(model) {
        SpecimenProcessingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          method = this@with.method,
          additive = this@with.additive.takeIf { it.isNotEmpty() },
          time = this@with.time,
        )
      }
  }
}

@Serializable
internal data class SpecimenContainerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var device: Reference,
  public var location: Reference? = null,
  public var specimenQuantity: Quantity? = null,
) {
  public fun toModel(): Specimen.Container =
    Specimen.Container(
      id = this@SpecimenContainerSurrogate.id,
      extension = this@SpecimenContainerSurrogate.extension ?: listOf(),
      modifierExtension = this@SpecimenContainerSurrogate.modifierExtension ?: listOf(),
      device = this@SpecimenContainerSurrogate.device,
      location = this@SpecimenContainerSurrogate.location,
      specimenQuantity = this@SpecimenContainerSurrogate.specimenQuantity,
    )

  public companion object {
    public fun fromModel(model: Specimen.Container): SpecimenContainerSurrogate =
      with(model) {
        SpecimenContainerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          device = this@with.device,
          location = this@with.location,
          specimenQuantity = this@with.specimenQuantity,
        )
      }
  }
}

@Serializable
internal data class SpecimenCollectionCollectedSurrogate(
  public var collectedDateTime: KotlinString? = null,
  public var _collectedDateTime: Element? = null,
  public var collectedPeriod: Period? = null,
) {
  public fun toModel(): Specimen.Collection.Collected =
    Specimen.Collection.Collected.from(
      DateTime.of(
        FhirDateTime.fromString(this@SpecimenCollectionCollectedSurrogate.collectedDateTime),
        this@SpecimenCollectionCollectedSurrogate._collectedDateTime,
      ),
      this@SpecimenCollectionCollectedSurrogate.collectedPeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: Specimen.Collection.Collected
    ): SpecimenCollectionCollectedSurrogate =
      with(model) {
        SpecimenCollectionCollectedSurrogate(
          collectedDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _collectedDateTime = this@with.asDateTime()?.value?.toElement(),
          collectedPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class SpecimenCollectionFastingStatusSurrogate(
  public var fastingStatusCodeableConcept: CodeableConcept? = null,
  public var fastingStatusDuration: Duration? = null,
) {
  public fun toModel(): Specimen.Collection.FastingStatus =
    Specimen.Collection.FastingStatus.from(
      this@SpecimenCollectionFastingStatusSurrogate.fastingStatusCodeableConcept,
      this@SpecimenCollectionFastingStatusSurrogate.fastingStatusDuration,
    )!!

  public companion object {
    public fun fromModel(
      model: Specimen.Collection.FastingStatus
    ): SpecimenCollectionFastingStatusSurrogate =
      with(model) {
        SpecimenCollectionFastingStatusSurrogate(
          fastingStatusCodeableConcept = this@with.asCodeableConcept()?.value,
          fastingStatusDuration = this@with.asDuration()?.value,
        )
      }
  }
}

@Serializable
internal data class SpecimenProcessingTimeSurrogate(
  public var timeDateTime: KotlinString? = null,
  public var _timeDateTime: Element? = null,
  public var timePeriod: Period? = null,
) {
  public fun toModel(): Specimen.Processing.Time =
    Specimen.Processing.Time.from(
      DateTime.of(
        FhirDateTime.fromString(this@SpecimenProcessingTimeSurrogate.timeDateTime),
        this@SpecimenProcessingTimeSurrogate._timeDateTime,
      ),
      this@SpecimenProcessingTimeSurrogate.timePeriod,
    )!!

  public companion object {
    public fun fromModel(model: Specimen.Processing.Time): SpecimenProcessingTimeSurrogate =
      with(model) {
        SpecimenProcessingTimeSurrogate(
          timeDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _timeDateTime = this@with.asDateTime()?.value?.toElement(),
          timePeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class SpecimenSurrogate(
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
  public var identifier: List<Identifier>? = null,
  public var accessionIdentifier: Identifier? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var type: CodeableConcept? = null,
  public var subject: Reference? = null,
  public var receivedTime: KotlinString? = null,
  public var _receivedTime: Element? = null,
  public var parent: List<Reference>? = null,
  public var request: List<Reference>? = null,
  public var combined: KotlinString? = null,
  public var _combined: Element? = null,
  public var role: List<CodeableConcept>? = null,
  public var feature: List<Specimen.Feature>? = null,
  public var collection: Specimen.Collection? = null,
  public var processing: List<Specimen.Processing>? = null,
  public var container: List<Specimen.Container>? = null,
  public var condition: List<CodeableConcept>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): Specimen =
    Specimen(
      id = this@SpecimenSurrogate.id,
      meta = this@SpecimenSurrogate.meta,
      implicitRules =
        Uri.of(this@SpecimenSurrogate.implicitRules, this@SpecimenSurrogate._implicitRules),
      language = Code.of(this@SpecimenSurrogate.language, this@SpecimenSurrogate._language),
      text = this@SpecimenSurrogate.text,
      contained = this@SpecimenSurrogate.contained ?: listOf(),
      extension = this@SpecimenSurrogate.extension ?: listOf(),
      modifierExtension = this@SpecimenSurrogate.modifierExtension ?: listOf(),
      identifier = this@SpecimenSurrogate.identifier ?: listOf(),
      accessionIdentifier = this@SpecimenSurrogate.accessionIdentifier,
      status =
        this@SpecimenSurrogate.status?.let {
          Enumeration.of(Specimen.SpecimenStatus.fromCode(it), this@SpecimenSurrogate._status)
        },
      type = this@SpecimenSurrogate.type,
      subject = this@SpecimenSurrogate.subject,
      receivedTime =
        DateTime.of(
          FhirDateTime.fromString(this@SpecimenSurrogate.receivedTime),
          this@SpecimenSurrogate._receivedTime,
        ),
      parent = this@SpecimenSurrogate.parent ?: listOf(),
      request = this@SpecimenSurrogate.request ?: listOf(),
      combined =
        this@SpecimenSurrogate.combined?.let {
          Enumeration.of(SpecimenCombined.fromCode(it), this@SpecimenSurrogate._combined)
        },
      role = this@SpecimenSurrogate.role ?: listOf(),
      feature = this@SpecimenSurrogate.feature ?: listOf(),
      collection = this@SpecimenSurrogate.collection,
      processing = this@SpecimenSurrogate.processing ?: listOf(),
      container = this@SpecimenSurrogate.container ?: listOf(),
      condition = this@SpecimenSurrogate.condition ?: listOf(),
      note = this@SpecimenSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Specimen): SpecimenSurrogate =
      with(model) {
        SpecimenSurrogate(
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
          accessionIdentifier = this@with.accessionIdentifier,
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          type = this@with.type,
          subject = this@with.subject,
          receivedTime = this@with.receivedTime?.value?.toString(),
          _receivedTime = this@with.receivedTime?.toElement(),
          parent = this@with.parent.takeIf { it.isNotEmpty() },
          request = this@with.request.takeIf { it.isNotEmpty() },
          combined = this@with.combined?.value?.getCode(),
          _combined = this@with.combined?.toElement(),
          role = this@with.role.takeIf { it.isNotEmpty() },
          feature = this@with.feature.takeIf { it.isNotEmpty() },
          collection = this@with.collection,
          processing = this@with.processing.takeIf { it.isNotEmpty() },
          container = this@with.container.takeIf { it.isNotEmpty() },
          condition = this@with.condition.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}

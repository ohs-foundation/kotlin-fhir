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
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.CarePlan
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CarePlanActivitySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var performedActivity: List<CodeableReference>? = null,
  public var progress: List<Annotation>? = null,
  public var plannedActivityReference: Reference? = null,
) {
  public fun toModel(): CarePlan.Activity =
    CarePlan.Activity(
      id = this@CarePlanActivitySurrogate.id,
      extension = this@CarePlanActivitySurrogate.extension ?: listOf(),
      modifierExtension = this@CarePlanActivitySurrogate.modifierExtension ?: listOf(),
      performedActivity = this@CarePlanActivitySurrogate.performedActivity ?: listOf(),
      progress = this@CarePlanActivitySurrogate.progress ?: listOf(),
      plannedActivityReference = this@CarePlanActivitySurrogate.plannedActivityReference,
    )

  public companion object {
    public fun fromModel(model: CarePlan.Activity): CarePlanActivitySurrogate =
      with(model) {
        CarePlanActivitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          performedActivity = this@with.performedActivity.takeIf { it.isNotEmpty() },
          progress = this@with.progress.takeIf { it.isNotEmpty() },
          plannedActivityReference = this@with.plannedActivityReference,
        )
      }
  }
}

@Serializable
internal data class CarePlanSurrogate(
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
  public var instantiatesCanonical: List<KotlinString?>? = null,
  public var _instantiatesCanonical: List<Element?>? = null,
  public var instantiatesUri: List<KotlinString?>? = null,
  public var _instantiatesUri: List<Element?>? = null,
  public var basedOn: List<Reference>? = null,
  public var replaces: List<Reference>? = null,
  public var partOf: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var intent: KotlinString? = null,
  public var _intent: Element? = null,
  public var category: List<CodeableConcept>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var period: Period? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var custodian: Reference? = null,
  public var contributor: List<Reference>? = null,
  public var careTeam: List<Reference>? = null,
  public var addresses: List<CodeableReference>? = null,
  public var supportingInfo: List<Reference>? = null,
  public var goal: List<Reference>? = null,
  public var activity: List<CarePlan.Activity>? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): CarePlan =
    CarePlan(
      id = this@CarePlanSurrogate.id,
      meta = this@CarePlanSurrogate.meta,
      implicitRules =
        Uri.of(this@CarePlanSurrogate.implicitRules, this@CarePlanSurrogate._implicitRules),
      language = Code.of(this@CarePlanSurrogate.language, this@CarePlanSurrogate._language),
      text = this@CarePlanSurrogate.text,
      contained = this@CarePlanSurrogate.contained ?: listOf(),
      extension = this@CarePlanSurrogate.extension ?: listOf(),
      modifierExtension = this@CarePlanSurrogate.modifierExtension ?: listOf(),
      identifier = this@CarePlanSurrogate.identifier ?: listOf(),
      instantiatesCanonical =
        if (
          this@CarePlanSurrogate.instantiatesCanonical == null &&
            this@CarePlanSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@CarePlanSurrogate.instantiatesCanonical
              ?: List(this@CarePlanSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@CarePlanSurrogate._instantiatesCanonical
                ?: List(this@CarePlanSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@CarePlanSurrogate.instantiatesUri == null &&
            this@CarePlanSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@CarePlanSurrogate.instantiatesUri
              ?: List(this@CarePlanSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@CarePlanSurrogate._instantiatesUri
                ?: List(this@CarePlanSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      basedOn = this@CarePlanSurrogate.basedOn ?: listOf(),
      replaces = this@CarePlanSurrogate.replaces ?: listOf(),
      partOf = this@CarePlanSurrogate.partOf ?: listOf(),
      status =
        Enumeration.of(
          CarePlan.RequestStatus.fromCode(this@CarePlanSurrogate.status!!),
          this@CarePlanSurrogate._status,
        ),
      intent =
        Enumeration.of(
          CarePlan.CarePlanIntent.fromCode(this@CarePlanSurrogate.intent!!),
          this@CarePlanSurrogate._intent,
        ),
      category = this@CarePlanSurrogate.category ?: listOf(),
      title = R5String.of(this@CarePlanSurrogate.title, this@CarePlanSurrogate._title),
      description =
        R5String.of(this@CarePlanSurrogate.description, this@CarePlanSurrogate._description),
      subject = this@CarePlanSurrogate.subject,
      encounter = this@CarePlanSurrogate.encounter,
      period = this@CarePlanSurrogate.period,
      created =
        DateTime.of(
          FhirDateTime.fromString(this@CarePlanSurrogate.created),
          this@CarePlanSurrogate._created,
        ),
      custodian = this@CarePlanSurrogate.custodian,
      contributor = this@CarePlanSurrogate.contributor ?: listOf(),
      careTeam = this@CarePlanSurrogate.careTeam ?: listOf(),
      addresses = this@CarePlanSurrogate.addresses ?: listOf(),
      supportingInfo = this@CarePlanSurrogate.supportingInfo ?: listOf(),
      goal = this@CarePlanSurrogate.goal ?: listOf(),
      activity = this@CarePlanSurrogate.activity ?: listOf(),
      note = this@CarePlanSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: CarePlan): CarePlanSurrogate =
      with(model) {
        CarePlanSurrogate(
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
          instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesCanonical =
            this@with.instantiatesCanonical
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          instantiatesUri =
            this@with.instantiatesUri
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _instantiatesUri =
            this@with.instantiatesUri
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          replaces = this@with.replaces.takeIf { it.isNotEmpty() },
          partOf = this@with.partOf.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          intent = this@with.intent.value?.getCode(),
          _intent = this@with.intent.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          subject = this@with.subject,
          encounter = this@with.encounter,
          period = this@with.period,
          created = this@with.created?.value?.toString(),
          _created = this@with.created?.toElement(),
          custodian = this@with.custodian,
          contributor = this@with.contributor.takeIf { it.isNotEmpty() },
          careTeam = this@with.careTeam.takeIf { it.isNotEmpty() },
          addresses = this@with.addresses.takeIf { it.isNotEmpty() },
          supportingInfo = this@with.supportingInfo.takeIf { it.isNotEmpty() },
          goal = this@with.goal.takeIf { it.isNotEmpty() },
          activity = this@with.activity.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}

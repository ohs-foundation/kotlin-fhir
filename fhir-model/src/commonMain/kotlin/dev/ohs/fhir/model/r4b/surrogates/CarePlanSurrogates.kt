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

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.Annotation
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.CarePlan
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Timing
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
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
  public var outcomeCodeableConcept: List<CodeableConcept>? = null,
  public var outcomeReference: List<Reference>? = null,
  public var progress: List<Annotation>? = null,
  public var reference: Reference? = null,
  public var detail: CarePlan.Activity.Detail? = null,
) {
  public fun toModel(): CarePlan.Activity =
    CarePlan.Activity(
      id = this@CarePlanActivitySurrogate.id,
      extension = this@CarePlanActivitySurrogate.extension ?: listOf(),
      modifierExtension = this@CarePlanActivitySurrogate.modifierExtension ?: listOf(),
      outcomeCodeableConcept = this@CarePlanActivitySurrogate.outcomeCodeableConcept ?: listOf(),
      outcomeReference = this@CarePlanActivitySurrogate.outcomeReference ?: listOf(),
      progress = this@CarePlanActivitySurrogate.progress ?: listOf(),
      reference = this@CarePlanActivitySurrogate.reference,
      detail = this@CarePlanActivitySurrogate.detail,
    )

  public companion object {
    public fun fromModel(model: CarePlan.Activity): CarePlanActivitySurrogate =
      with(model) {
        CarePlanActivitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          outcomeCodeableConcept = this@with.outcomeCodeableConcept.takeIf { it.isNotEmpty() },
          outcomeReference = this@with.outcomeReference.takeIf { it.isNotEmpty() },
          progress = this@with.progress.takeIf { it.isNotEmpty() },
          reference = this@with.reference,
          detail = this@with.detail,
        )
      }
  }
}

@Serializable
internal data class CarePlanActivityDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var kind: KotlinString? = null,
  public var _kind: Element? = null,
  public var instantiatesCanonical: List<KotlinString?>? = null,
  public var _instantiatesCanonical: List<Element?>? = null,
  public var instantiatesUri: List<KotlinString?>? = null,
  public var _instantiatesUri: List<Element?>? = null,
  public var code: CodeableConcept? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var goal: List<Reference>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var statusReason: CodeableConcept? = null,
  public var doNotPerform: KotlinBoolean? = null,
  public var _doNotPerform: Element? = null,
  public var scheduled: CarePlan.Activity.Detail.Scheduled? = null,
  public var location: Reference? = null,
  public var performer: List<Reference>? = null,
  public var product: CarePlan.Activity.Detail.Product? = null,
  public var dailyAmount: Quantity? = null,
  public var quantity: Quantity? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
) {
  public fun toModel(): CarePlan.Activity.Detail =
    CarePlan.Activity.Detail(
      id = this@CarePlanActivityDetailSurrogate.id,
      extension = this@CarePlanActivityDetailSurrogate.extension ?: listOf(),
      modifierExtension = this@CarePlanActivityDetailSurrogate.modifierExtension ?: listOf(),
      kind =
        this@CarePlanActivityDetailSurrogate.kind?.let {
          Enumeration.of(
            CarePlan.CarePlanActivityKind.fromCode(it),
            this@CarePlanActivityDetailSurrogate._kind,
          )
        },
      instantiatesCanonical =
        if (
          this@CarePlanActivityDetailSurrogate.instantiatesCanonical == null &&
            this@CarePlanActivityDetailSurrogate._instantiatesCanonical == null
        ) {
          listOf()
        } else {
          (this@CarePlanActivityDetailSurrogate.instantiatesCanonical
              ?: List(this@CarePlanActivityDetailSurrogate._instantiatesCanonical!!.size) { null })
            .zip(
              this@CarePlanActivityDetailSurrogate._instantiatesCanonical
                ?: List(this@CarePlanActivityDetailSurrogate.instantiatesCanonical!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      instantiatesUri =
        if (
          this@CarePlanActivityDetailSurrogate.instantiatesUri == null &&
            this@CarePlanActivityDetailSurrogate._instantiatesUri == null
        ) {
          listOf()
        } else {
          (this@CarePlanActivityDetailSurrogate.instantiatesUri
              ?: List(this@CarePlanActivityDetailSurrogate._instantiatesUri!!.size) { null })
            .zip(
              this@CarePlanActivityDetailSurrogate._instantiatesUri
                ?: List(this@CarePlanActivityDetailSurrogate.instantiatesUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      code = this@CarePlanActivityDetailSurrogate.code,
      reasonCode = this@CarePlanActivityDetailSurrogate.reasonCode ?: listOf(),
      reasonReference = this@CarePlanActivityDetailSurrogate.reasonReference ?: listOf(),
      goal = this@CarePlanActivityDetailSurrogate.goal ?: listOf(),
      status =
        Enumeration.of(
          CarePlan.CarePlanActivityStatus.fromCode(this@CarePlanActivityDetailSurrogate.status!!),
          this@CarePlanActivityDetailSurrogate._status,
        ),
      statusReason = this@CarePlanActivityDetailSurrogate.statusReason,
      doNotPerform =
        R4bBoolean.of(
          this@CarePlanActivityDetailSurrogate.doNotPerform,
          this@CarePlanActivityDetailSurrogate._doNotPerform,
        ),
      scheduled = this@CarePlanActivityDetailSurrogate.scheduled,
      location = this@CarePlanActivityDetailSurrogate.location,
      performer = this@CarePlanActivityDetailSurrogate.performer ?: listOf(),
      product = this@CarePlanActivityDetailSurrogate.product,
      dailyAmount = this@CarePlanActivityDetailSurrogate.dailyAmount,
      quantity = this@CarePlanActivityDetailSurrogate.quantity,
      description =
        R4bString.of(
          this@CarePlanActivityDetailSurrogate.description,
          this@CarePlanActivityDetailSurrogate._description,
        ),
    )

  public companion object {
    public fun fromModel(model: CarePlan.Activity.Detail): CarePlanActivityDetailSurrogate =
      with(model) {
        CarePlanActivityDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          kind = this@with.kind?.value?.getCode(),
          _kind = this@with.kind?.toElement(),
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
          code = this@with.code,
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          goal = this@with.goal.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          statusReason = this@with.statusReason,
          doNotPerform = this@with.doNotPerform?.value,
          _doNotPerform = this@with.doNotPerform?.toElement(),
          scheduled = this@with.scheduled,
          location = this@with.location,
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          product = this@with.product,
          dailyAmount = this@with.dailyAmount,
          quantity = this@with.quantity,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CarePlanActivityDetailScheduledSurrogate(
  public var scheduledTiming: Timing? = null,
  public var scheduledPeriod: Period? = null,
  public var scheduledString: KotlinString? = null,
  public var _scheduledString: Element? = null,
) {
  public fun toModel(): CarePlan.Activity.Detail.Scheduled =
    CarePlan.Activity.Detail.Scheduled.from(
      this@CarePlanActivityDetailScheduledSurrogate.scheduledTiming,
      this@CarePlanActivityDetailScheduledSurrogate.scheduledPeriod,
      R4bString.of(
        this@CarePlanActivityDetailScheduledSurrogate.scheduledString,
        this@CarePlanActivityDetailScheduledSurrogate._scheduledString,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: CarePlan.Activity.Detail.Scheduled
    ): CarePlanActivityDetailScheduledSurrogate =
      with(model) {
        CarePlanActivityDetailScheduledSurrogate(
          scheduledTiming = this@with.asTiming()?.value,
          scheduledPeriod = this@with.asPeriod()?.value,
          scheduledString = this@with.asString()?.value?.value,
          _scheduledString = this@with.asString()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CarePlanActivityDetailProductSurrogate(
  public var productCodeableConcept: CodeableConcept? = null,
  public var productReference: Reference? = null,
) {
  public fun toModel(): CarePlan.Activity.Detail.Product =
    CarePlan.Activity.Detail.Product.from(
      this@CarePlanActivityDetailProductSurrogate.productCodeableConcept,
      this@CarePlanActivityDetailProductSurrogate.productReference,
    )!!

  public companion object {
    public fun fromModel(
      model: CarePlan.Activity.Detail.Product
    ): CarePlanActivityDetailProductSurrogate =
      with(model) {
        CarePlanActivityDetailProductSurrogate(
          productCodeableConcept = this@with.asCodeableConcept()?.value,
          productReference = this@with.asReference()?.value,
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
  public var author: Reference? = null,
  public var contributor: List<Reference>? = null,
  public var careTeam: List<Reference>? = null,
  public var addresses: List<Reference>? = null,
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
      title = R4bString.of(this@CarePlanSurrogate.title, this@CarePlanSurrogate._title),
      description =
        R4bString.of(this@CarePlanSurrogate.description, this@CarePlanSurrogate._description),
      subject = this@CarePlanSurrogate.subject,
      encounter = this@CarePlanSurrogate.encounter,
      period = this@CarePlanSurrogate.period,
      created =
        DateTime.of(
          FhirDateTime.fromString(this@CarePlanSurrogate.created),
          this@CarePlanSurrogate._created,
        ),
      author = this@CarePlanSurrogate.author,
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
          author = this@with.author,
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

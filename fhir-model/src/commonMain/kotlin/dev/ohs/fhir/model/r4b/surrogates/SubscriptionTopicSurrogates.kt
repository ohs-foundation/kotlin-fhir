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

import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.SubscriptionTopic
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubscriptionTopicResourceTriggerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var resource: KotlinString? = null,
  public var _resource: Element? = null,
  public var supportedInteraction: List<KotlinString?>? = null,
  public var _supportedInteraction: List<Element?>? = null,
  public var queryCriteria: SubscriptionTopic.ResourceTrigger.QueryCriteria? = null,
  public var fhirPathCriteria: KotlinString? = null,
  public var _fhirPathCriteria: Element? = null,
) {
  public fun toModel(): SubscriptionTopic.ResourceTrigger =
    SubscriptionTopic.ResourceTrigger(
      id = this@SubscriptionTopicResourceTriggerSurrogate.id,
      extension = this@SubscriptionTopicResourceTriggerSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubscriptionTopicResourceTriggerSurrogate.modifierExtension ?: listOf(),
      description =
        Markdown.of(
          this@SubscriptionTopicResourceTriggerSurrogate.description,
          this@SubscriptionTopicResourceTriggerSurrogate._description,
        ),
      resource =
        Uri.of(
          this@SubscriptionTopicResourceTriggerSurrogate.resource,
          this@SubscriptionTopicResourceTriggerSurrogate._resource,
        )!!,
      supportedInteraction =
        if (
          this@SubscriptionTopicResourceTriggerSurrogate.supportedInteraction == null &&
            this@SubscriptionTopicResourceTriggerSurrogate._supportedInteraction == null
        ) {
          listOf()
        } else {
          (this@SubscriptionTopicResourceTriggerSurrogate.supportedInteraction
              ?: List(this@SubscriptionTopicResourceTriggerSurrogate._supportedInteraction!!.size) {
                null
              })
            .zip(
              this@SubscriptionTopicResourceTriggerSurrogate._supportedInteraction
                ?: List(
                  this@SubscriptionTopicResourceTriggerSurrogate.supportedInteraction!!.size
                ) {
                  null
                }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { SubscriptionTopic.InteractionTrigger.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      queryCriteria = this@SubscriptionTopicResourceTriggerSurrogate.queryCriteria,
      fhirPathCriteria =
        R4bString.of(
          this@SubscriptionTopicResourceTriggerSurrogate.fhirPathCriteria,
          this@SubscriptionTopicResourceTriggerSurrogate._fhirPathCriteria,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SubscriptionTopic.ResourceTrigger
    ): SubscriptionTopicResourceTriggerSurrogate =
      with(model) {
        SubscriptionTopicResourceTriggerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          resource = this@with.resource.value,
          _resource = this@with.resource.toElement(),
          supportedInteraction =
            this@with.supportedInteraction
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _supportedInteraction =
            this@with.supportedInteraction
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          queryCriteria = this@with.queryCriteria,
          fhirPathCriteria = this@with.fhirPathCriteria?.value,
          _fhirPathCriteria = this@with.fhirPathCriteria?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubscriptionTopicResourceTriggerQueryCriteriaSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var previous: KotlinString? = null,
  public var _previous: Element? = null,
  public var resultForCreate: KotlinString? = null,
  public var _resultForCreate: Element? = null,
  public var current: KotlinString? = null,
  public var _current: Element? = null,
  public var resultForDelete: KotlinString? = null,
  public var _resultForDelete: Element? = null,
  public var requireBoth: KotlinBoolean? = null,
  public var _requireBoth: Element? = null,
) {
  public fun toModel(): SubscriptionTopic.ResourceTrigger.QueryCriteria =
    SubscriptionTopic.ResourceTrigger.QueryCriteria(
      id = this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.id,
      extension = this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.modifierExtension ?: listOf(),
      previous =
        R4bString.of(
          this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.previous,
          this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate._previous,
        ),
      resultForCreate =
        this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.resultForCreate?.let {
          Enumeration.of(
            SubscriptionTopic.CriteriaNotExistsBehavior.fromCode(it),
            this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate._resultForCreate,
          )
        },
      current =
        R4bString.of(
          this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.current,
          this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate._current,
        ),
      resultForDelete =
        this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.resultForDelete?.let {
          Enumeration.of(
            SubscriptionTopic.CriteriaNotExistsBehavior.fromCode(it),
            this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate._resultForDelete,
          )
        },
      requireBoth =
        R4bBoolean.of(
          this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.requireBoth,
          this@SubscriptionTopicResourceTriggerQueryCriteriaSurrogate._requireBoth,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SubscriptionTopic.ResourceTrigger.QueryCriteria
    ): SubscriptionTopicResourceTriggerQueryCriteriaSurrogate =
      with(model) {
        SubscriptionTopicResourceTriggerQueryCriteriaSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          previous = this@with.previous?.value,
          _previous = this@with.previous?.toElement(),
          resultForCreate = this@with.resultForCreate?.value?.getCode(),
          _resultForCreate = this@with.resultForCreate?.toElement(),
          current = this@with.current?.value,
          _current = this@with.current?.toElement(),
          resultForDelete = this@with.resultForDelete?.value?.getCode(),
          _resultForDelete = this@with.resultForDelete?.toElement(),
          requireBoth = this@with.requireBoth?.value,
          _requireBoth = this@with.requireBoth?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubscriptionTopicEventTriggerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var event: CodeableConcept,
  public var resource: KotlinString? = null,
  public var _resource: Element? = null,
) {
  public fun toModel(): SubscriptionTopic.EventTrigger =
    SubscriptionTopic.EventTrigger(
      id = this@SubscriptionTopicEventTriggerSurrogate.id,
      extension = this@SubscriptionTopicEventTriggerSurrogate.extension ?: listOf(),
      modifierExtension = this@SubscriptionTopicEventTriggerSurrogate.modifierExtension ?: listOf(),
      description =
        Markdown.of(
          this@SubscriptionTopicEventTriggerSurrogate.description,
          this@SubscriptionTopicEventTriggerSurrogate._description,
        ),
      event = this@SubscriptionTopicEventTriggerSurrogate.event,
      resource =
        Uri.of(
          this@SubscriptionTopicEventTriggerSurrogate.resource,
          this@SubscriptionTopicEventTriggerSurrogate._resource,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: SubscriptionTopic.EventTrigger
    ): SubscriptionTopicEventTriggerSurrogate =
      with(model) {
        SubscriptionTopicEventTriggerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          event = this@with.event,
          resource = this@with.resource.value,
          _resource = this@with.resource.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubscriptionTopicCanFilterBySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var resource: KotlinString? = null,
  public var _resource: Element? = null,
  public var filterParameter: KotlinString? = null,
  public var _filterParameter: Element? = null,
  public var filterDefinition: KotlinString? = null,
  public var _filterDefinition: Element? = null,
  public var modifier: List<KotlinString?>? = null,
  public var _modifier: List<Element?>? = null,
) {
  public fun toModel(): SubscriptionTopic.CanFilterBy =
    SubscriptionTopic.CanFilterBy(
      id = this@SubscriptionTopicCanFilterBySurrogate.id,
      extension = this@SubscriptionTopicCanFilterBySurrogate.extension ?: listOf(),
      modifierExtension = this@SubscriptionTopicCanFilterBySurrogate.modifierExtension ?: listOf(),
      description =
        Markdown.of(
          this@SubscriptionTopicCanFilterBySurrogate.description,
          this@SubscriptionTopicCanFilterBySurrogate._description,
        ),
      resource =
        Uri.of(
          this@SubscriptionTopicCanFilterBySurrogate.resource,
          this@SubscriptionTopicCanFilterBySurrogate._resource,
        ),
      filterParameter =
        R4bString.of(
          this@SubscriptionTopicCanFilterBySurrogate.filterParameter,
          this@SubscriptionTopicCanFilterBySurrogate._filterParameter,
        )!!,
      filterDefinition =
        Uri.of(
          this@SubscriptionTopicCanFilterBySurrogate.filterDefinition,
          this@SubscriptionTopicCanFilterBySurrogate._filterDefinition,
        ),
      modifier =
        if (
          this@SubscriptionTopicCanFilterBySurrogate.modifier == null &&
            this@SubscriptionTopicCanFilterBySurrogate._modifier == null
        ) {
          listOf()
        } else {
          (this@SubscriptionTopicCanFilterBySurrogate.modifier
              ?: List(this@SubscriptionTopicCanFilterBySurrogate._modifier!!.size) { null })
            .zip(
              this@SubscriptionTopicCanFilterBySurrogate._modifier
                ?: List(this@SubscriptionTopicCanFilterBySurrogate.modifier!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { SubscriptionTopic.SubscriptionSearchModifier.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(
      model: SubscriptionTopic.CanFilterBy
    ): SubscriptionTopicCanFilterBySurrogate =
      with(model) {
        SubscriptionTopicCanFilterBySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          resource = this@with.resource?.value,
          _resource = this@with.resource?.toElement(),
          filterParameter = this@with.filterParameter.value,
          _filterParameter = this@with.filterParameter.toElement(),
          filterDefinition = this@with.filterDefinition?.value,
          _filterDefinition = this@with.filterDefinition?.toElement(),
          modifier =
            this@with.modifier
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _modifier =
            this@with.modifier
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class SubscriptionTopicNotificationShapeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var resource: KotlinString? = null,
  public var _resource: Element? = null,
  public var include: List<KotlinString?>? = null,
  public var _include: List<Element?>? = null,
  public var revInclude: List<KotlinString?>? = null,
  public var _revInclude: List<Element?>? = null,
) {
  public fun toModel(): SubscriptionTopic.NotificationShape =
    SubscriptionTopic.NotificationShape(
      id = this@SubscriptionTopicNotificationShapeSurrogate.id,
      extension = this@SubscriptionTopicNotificationShapeSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubscriptionTopicNotificationShapeSurrogate.modifierExtension ?: listOf(),
      resource =
        Uri.of(
          this@SubscriptionTopicNotificationShapeSurrogate.resource,
          this@SubscriptionTopicNotificationShapeSurrogate._resource,
        )!!,
      include =
        if (
          this@SubscriptionTopicNotificationShapeSurrogate.include == null &&
            this@SubscriptionTopicNotificationShapeSurrogate._include == null
        ) {
          listOf()
        } else {
          (this@SubscriptionTopicNotificationShapeSurrogate.include
              ?: List(this@SubscriptionTopicNotificationShapeSurrogate._include!!.size) { null })
            .zip(
              this@SubscriptionTopicNotificationShapeSurrogate._include
                ?: List(this@SubscriptionTopicNotificationShapeSurrogate.include!!.size) { null }
            )
            .map { (value, element) -> R4bString.of(value, element)!! }
            .toList()
        },
      revInclude =
        if (
          this@SubscriptionTopicNotificationShapeSurrogate.revInclude == null &&
            this@SubscriptionTopicNotificationShapeSurrogate._revInclude == null
        ) {
          listOf()
        } else {
          (this@SubscriptionTopicNotificationShapeSurrogate.revInclude
              ?: List(this@SubscriptionTopicNotificationShapeSurrogate._revInclude!!.size) { null })
            .zip(
              this@SubscriptionTopicNotificationShapeSurrogate._revInclude
                ?: List(this@SubscriptionTopicNotificationShapeSurrogate.revInclude!!.size) { null }
            )
            .map { (value, element) -> R4bString.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(
      model: SubscriptionTopic.NotificationShape
    ): SubscriptionTopicNotificationShapeSurrogate =
      with(model) {
        SubscriptionTopicNotificationShapeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          resource = this@with.resource.value,
          _resource = this@with.resource.toElement(),
          include =
            this@with.include.map { it.value }.toList().takeUnless { it.all { it == null } },
          _include =
            this@with.include
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          revInclude =
            this@with.revInclude.map { it.value }.toList().takeUnless { it.all { it == null } },
          _revInclude =
            this@with.revInclude
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class SubscriptionTopicSurrogate(
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
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var derivedFrom: List<KotlinString?>? = null,
  public var _derivedFrom: List<Element?>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var experimental: KotlinBoolean? = null,
  public var _experimental: Element? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var approvalDate: KotlinString? = null,
  public var _approvalDate: Element? = null,
  public var lastReviewDate: KotlinString? = null,
  public var _lastReviewDate: Element? = null,
  public var effectivePeriod: Period? = null,
  public var resourceTrigger: List<SubscriptionTopic.ResourceTrigger>? = null,
  public var eventTrigger: List<SubscriptionTopic.EventTrigger>? = null,
  public var canFilterBy: List<SubscriptionTopic.CanFilterBy>? = null,
  public var notificationShape: List<SubscriptionTopic.NotificationShape>? = null,
) {
  public fun toModel(): SubscriptionTopic =
    SubscriptionTopic(
      id = this@SubscriptionTopicSurrogate.id,
      meta = this@SubscriptionTopicSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SubscriptionTopicSurrogate.implicitRules,
          this@SubscriptionTopicSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@SubscriptionTopicSurrogate.language,
          this@SubscriptionTopicSurrogate._language,
        ),
      text = this@SubscriptionTopicSurrogate.text,
      contained = this@SubscriptionTopicSurrogate.contained ?: listOf(),
      extension = this@SubscriptionTopicSurrogate.extension ?: listOf(),
      modifierExtension = this@SubscriptionTopicSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@SubscriptionTopicSurrogate.url, this@SubscriptionTopicSurrogate._url)!!,
      identifier = this@SubscriptionTopicSurrogate.identifier ?: listOf(),
      version =
        R4bString.of(
          this@SubscriptionTopicSurrogate.version,
          this@SubscriptionTopicSurrogate._version,
        ),
      title =
        R4bString.of(this@SubscriptionTopicSurrogate.title, this@SubscriptionTopicSurrogate._title),
      derivedFrom =
        if (
          this@SubscriptionTopicSurrogate.derivedFrom == null &&
            this@SubscriptionTopicSurrogate._derivedFrom == null
        ) {
          listOf()
        } else {
          (this@SubscriptionTopicSurrogate.derivedFrom
              ?: List(this@SubscriptionTopicSurrogate._derivedFrom!!.size) { null })
            .zip(
              this@SubscriptionTopicSurrogate._derivedFrom
                ?: List(this@SubscriptionTopicSurrogate.derivedFrom!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@SubscriptionTopicSurrogate.status!!),
          this@SubscriptionTopicSurrogate._status,
        ),
      experimental =
        R4bBoolean.of(
          this@SubscriptionTopicSurrogate.experimental,
          this@SubscriptionTopicSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@SubscriptionTopicSurrogate.date),
          this@SubscriptionTopicSurrogate._date,
        ),
      publisher =
        R4bString.of(
          this@SubscriptionTopicSurrogate.publisher,
          this@SubscriptionTopicSurrogate._publisher,
        ),
      contact = this@SubscriptionTopicSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@SubscriptionTopicSurrogate.description,
          this@SubscriptionTopicSurrogate._description,
        ),
      useContext = this@SubscriptionTopicSurrogate.useContext ?: listOf(),
      jurisdiction = this@SubscriptionTopicSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(
          this@SubscriptionTopicSurrogate.purpose,
          this@SubscriptionTopicSurrogate._purpose,
        ),
      copyright =
        Markdown.of(
          this@SubscriptionTopicSurrogate.copyright,
          this@SubscriptionTopicSurrogate._copyright,
        ),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@SubscriptionTopicSurrogate.approvalDate),
          this@SubscriptionTopicSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@SubscriptionTopicSurrogate.lastReviewDate),
          this@SubscriptionTopicSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@SubscriptionTopicSurrogate.effectivePeriod,
      resourceTrigger = this@SubscriptionTopicSurrogate.resourceTrigger ?: listOf(),
      eventTrigger = this@SubscriptionTopicSurrogate.eventTrigger ?: listOf(),
      canFilterBy = this@SubscriptionTopicSurrogate.canFilterBy ?: listOf(),
      notificationShape = this@SubscriptionTopicSurrogate.notificationShape ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubscriptionTopic): SubscriptionTopicSurrogate =
      with(model) {
        SubscriptionTopicSurrogate(
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
          url = this@with.url.value,
          _url = this@with.url.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          derivedFrom =
            this@with.derivedFrom.map { it.value }.toList().takeUnless { it.all { it == null } },
          _derivedFrom =
            this@with.derivedFrom
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          approvalDate = this@with.approvalDate?.value?.toString(),
          _approvalDate = this@with.approvalDate?.toElement(),
          lastReviewDate = this@with.lastReviewDate?.value?.toString(),
          _lastReviewDate = this@with.lastReviewDate?.toElement(),
          effectivePeriod = this@with.effectivePeriod,
          resourceTrigger = this@with.resourceTrigger.takeIf { it.isNotEmpty() },
          eventTrigger = this@with.eventTrigger.takeIf { it.isNotEmpty() },
          canFilterBy = this@with.canFilterBy.takeIf { it.isNotEmpty() },
          notificationShape = this@with.notificationShape.takeIf { it.isNotEmpty() },
        )
      }
  }
}

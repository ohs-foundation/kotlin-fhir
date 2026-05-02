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

import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactPoint
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Instant
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Subscription
import com.google.fhir.model.r5.UnsignedInt
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.Url
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubscriptionFilterBySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var resourceType: KotlinString? = null,
  public var _resourceType: Element? = null,
  public var filterParameter: KotlinString? = null,
  public var _filterParameter: Element? = null,
  public var comparator: KotlinString? = null,
  public var _comparator: Element? = null,
  public var modifier: KotlinString? = null,
  public var _modifier: Element? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): Subscription.FilterBy =
    Subscription.FilterBy(
      id = this@SubscriptionFilterBySurrogate.id,
      extension = this@SubscriptionFilterBySurrogate.extension ?: listOf(),
      modifierExtension = this@SubscriptionFilterBySurrogate.modifierExtension ?: listOf(),
      resourceType =
        Uri.of(
          this@SubscriptionFilterBySurrogate.resourceType,
          this@SubscriptionFilterBySurrogate._resourceType,
        ),
      filterParameter =
        R5String.of(
          this@SubscriptionFilterBySurrogate.filterParameter,
          this@SubscriptionFilterBySurrogate._filterParameter,
        )!!,
      comparator =
        this@SubscriptionFilterBySurrogate.comparator?.let {
          Enumeration.of(
            Subscription.SearchComparator.fromCode(it),
            this@SubscriptionFilterBySurrogate._comparator,
          )
        },
      modifier =
        this@SubscriptionFilterBySurrogate.modifier?.let {
          Enumeration.of(
            Subscription.SearchModifierCode.fromCode(it),
            this@SubscriptionFilterBySurrogate._modifier,
          )
        },
      `value` =
        R5String.of(
          this@SubscriptionFilterBySurrogate.`value`,
          this@SubscriptionFilterBySurrogate._value,
        )!!,
    )

  public companion object {
    public fun fromModel(model: Subscription.FilterBy): SubscriptionFilterBySurrogate =
      with(model) {
        SubscriptionFilterBySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          resourceType = this@with.resourceType?.value,
          _resourceType = this@with.resourceType?.toElement(),
          filterParameter = this@with.filterParameter.value,
          _filterParameter = this@with.filterParameter.toElement(),
          comparator = this@with.comparator?.value?.getCode(),
          _comparator = this@with.comparator?.toElement(),
          modifier = this@with.modifier?.value?.getCode(),
          _modifier = this@with.modifier?.toElement(),
          `value` = this@with.`value`.value,
          _value = this@with.`value`.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubscriptionParameterSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): Subscription.Parameter =
    Subscription.Parameter(
      id = this@SubscriptionParameterSurrogate.id,
      extension = this@SubscriptionParameterSurrogate.extension ?: listOf(),
      modifierExtension = this@SubscriptionParameterSurrogate.modifierExtension ?: listOf(),
      name =
        R5String.of(
          this@SubscriptionParameterSurrogate.name,
          this@SubscriptionParameterSurrogate._name,
        )!!,
      `value` =
        R5String.of(
          this@SubscriptionParameterSurrogate.`value`,
          this@SubscriptionParameterSurrogate._value,
        )!!,
    )

  public companion object {
    public fun fromModel(model: Subscription.Parameter): SubscriptionParameterSurrogate =
      with(model) {
        SubscriptionParameterSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          `value` = this@with.`value`.value,
          _value = this@with.`value`.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubscriptionSurrogate(
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
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var topic: KotlinString? = null,
  public var _topic: Element? = null,
  public var contact: List<ContactPoint>? = null,
  public var end: KotlinString? = null,
  public var _end: Element? = null,
  public var managingEntity: Reference? = null,
  public var reason: KotlinString? = null,
  public var _reason: Element? = null,
  public var filterBy: List<Subscription.FilterBy>? = null,
  public var channelType: Coding,
  public var endpoint: KotlinString? = null,
  public var _endpoint: Element? = null,
  public var parameter: List<Subscription.Parameter>? = null,
  public var heartbeatPeriod: Int? = null,
  public var _heartbeatPeriod: Element? = null,
  public var timeout: Int? = null,
  public var _timeout: Element? = null,
  public var contentType: KotlinString? = null,
  public var _contentType: Element? = null,
  public var content: KotlinString? = null,
  public var _content: Element? = null,
  public var maxCount: Int? = null,
  public var _maxCount: Element? = null,
) {
  public fun toModel(): Subscription =
    Subscription(
      id = this@SubscriptionSurrogate.id,
      meta = this@SubscriptionSurrogate.meta,
      implicitRules =
        Uri.of(this@SubscriptionSurrogate.implicitRules, this@SubscriptionSurrogate._implicitRules),
      language = Code.of(this@SubscriptionSurrogate.language, this@SubscriptionSurrogate._language),
      text = this@SubscriptionSurrogate.text,
      contained = this@SubscriptionSurrogate.contained ?: listOf(),
      extension = this@SubscriptionSurrogate.extension ?: listOf(),
      modifierExtension = this@SubscriptionSurrogate.modifierExtension ?: listOf(),
      identifier = this@SubscriptionSurrogate.identifier ?: listOf(),
      name = R5String.of(this@SubscriptionSurrogate.name, this@SubscriptionSurrogate._name),
      status =
        Enumeration.of(
          Subscription.SubscriptionStatusCodes.fromCode(this@SubscriptionSurrogate.status!!),
          this@SubscriptionSurrogate._status,
        ),
      topic = Canonical.of(this@SubscriptionSurrogate.topic, this@SubscriptionSurrogate._topic)!!,
      contact = this@SubscriptionSurrogate.contact ?: listOf(),
      end =
        Instant.of(
          FhirDateTime.fromString(this@SubscriptionSurrogate.end),
          this@SubscriptionSurrogate._end,
        ),
      managingEntity = this@SubscriptionSurrogate.managingEntity,
      reason = R5String.of(this@SubscriptionSurrogate.reason, this@SubscriptionSurrogate._reason),
      filterBy = this@SubscriptionSurrogate.filterBy ?: listOf(),
      channelType = this@SubscriptionSurrogate.channelType,
      endpoint = Url.of(this@SubscriptionSurrogate.endpoint, this@SubscriptionSurrogate._endpoint),
      parameter = this@SubscriptionSurrogate.parameter ?: listOf(),
      heartbeatPeriod =
        UnsignedInt.of(
          this@SubscriptionSurrogate.heartbeatPeriod,
          this@SubscriptionSurrogate._heartbeatPeriod,
        ),
      timeout =
        UnsignedInt.of(this@SubscriptionSurrogate.timeout, this@SubscriptionSurrogate._timeout),
      contentType =
        Code.of(this@SubscriptionSurrogate.contentType, this@SubscriptionSurrogate._contentType),
      content =
        this@SubscriptionSurrogate.content?.let {
          Enumeration.of(
            Subscription.SubscriptionPayloadContent.fromCode(it),
            this@SubscriptionSurrogate._content,
          )
        },
      maxCount =
        PositiveInt.of(this@SubscriptionSurrogate.maxCount, this@SubscriptionSurrogate._maxCount),
    )

  public companion object {
    public fun fromModel(model: Subscription): SubscriptionSurrogate =
      with(model) {
        SubscriptionSurrogate(
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
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          topic = this@with.topic.value,
          _topic = this@with.topic.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          end = this@with.end?.value?.toString(),
          _end = this@with.end?.toElement(),
          managingEntity = this@with.managingEntity,
          reason = this@with.reason?.value,
          _reason = this@with.reason?.toElement(),
          filterBy = this@with.filterBy.takeIf { it.isNotEmpty() },
          channelType = this@with.channelType,
          endpoint = this@with.endpoint?.value,
          _endpoint = this@with.endpoint?.toElement(),
          parameter = this@with.parameter.takeIf { it.isNotEmpty() },
          heartbeatPeriod = this@with.heartbeatPeriod?.value,
          _heartbeatPeriod = this@with.heartbeatPeriod?.toElement(),
          timeout = this@with.timeout?.value,
          _timeout = this@with.timeout?.toElement(),
          contentType = this@with.contentType?.value,
          _contentType = this@with.contentType?.toElement(),
          content = this@with.content?.value?.getCode(),
          _content = this@with.content?.toElement(),
          maxCount = this@with.maxCount?.value,
          _maxCount = this@with.maxCount?.toElement(),
        )
      }
  }
}

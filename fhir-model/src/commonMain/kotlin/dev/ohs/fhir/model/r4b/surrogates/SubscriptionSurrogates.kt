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

import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.ContactPoint
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Instant
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Subscription
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.Url
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubscriptionChannelSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var endpoint: KotlinString? = null,
  public var _endpoint: Element? = null,
  public var payload: KotlinString? = null,
  public var _payload: Element? = null,
  public var `header`: List<KotlinString?>? = null,
  public var _header: List<Element?>? = null,
) {
  public fun toModel(): Subscription.Channel =
    Subscription.Channel(
      id = this@SubscriptionChannelSurrogate.id,
      extension = this@SubscriptionChannelSurrogate.extension ?: listOf(),
      modifierExtension = this@SubscriptionChannelSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          Subscription.SubscriptionChannelType.fromCode(this@SubscriptionChannelSurrogate.type!!),
          this@SubscriptionChannelSurrogate._type,
        ),
      endpoint =
        Url.of(
          this@SubscriptionChannelSurrogate.endpoint,
          this@SubscriptionChannelSurrogate._endpoint,
        ),
      payload =
        Code.of(
          this@SubscriptionChannelSurrogate.payload,
          this@SubscriptionChannelSurrogate._payload,
        ),
      `header` =
        if (
          this@SubscriptionChannelSurrogate.`header` == null &&
            this@SubscriptionChannelSurrogate._header == null
        ) {
          listOf()
        } else {
          (this@SubscriptionChannelSurrogate.`header`
              ?: List(this@SubscriptionChannelSurrogate._header!!.size) { null })
            .zip(
              this@SubscriptionChannelSurrogate._header
                ?: List(this@SubscriptionChannelSurrogate.`header`!!.size) { null }
            )
            .map { (value, element) -> R4bString.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(model: Subscription.Channel): SubscriptionChannelSurrogate =
      with(model) {
        SubscriptionChannelSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          endpoint = this@with.endpoint?.value,
          _endpoint = this@with.endpoint?.toElement(),
          payload = this@with.payload?.value,
          _payload = this@with.payload?.toElement(),
          `header` =
            this@with.`header`.map { it.value }.toList().takeUnless { it.all { it == null } },
          _header =
            this@with.`header`
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
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
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var contact: List<ContactPoint>? = null,
  public var end: KotlinString? = null,
  public var _end: Element? = null,
  public var reason: KotlinString? = null,
  public var _reason: Element? = null,
  public var criteria: KotlinString? = null,
  public var _criteria: Element? = null,
  public var error: KotlinString? = null,
  public var _error: Element? = null,
  public var channel: Subscription.Channel,
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
      status =
        Enumeration.of(
          Subscription.SubscriptionStatusCodes.fromCode(this@SubscriptionSurrogate.status!!),
          this@SubscriptionSurrogate._status,
        ),
      contact = this@SubscriptionSurrogate.contact ?: listOf(),
      end =
        Instant.of(
          FhirDateTime.fromString(this@SubscriptionSurrogate.end),
          this@SubscriptionSurrogate._end,
        ),
      reason =
        R4bString.of(this@SubscriptionSurrogate.reason, this@SubscriptionSurrogate._reason)!!,
      criteria =
        R4bString.of(this@SubscriptionSurrogate.criteria, this@SubscriptionSurrogate._criteria)!!,
      error = R4bString.of(this@SubscriptionSurrogate.error, this@SubscriptionSurrogate._error),
      channel = this@SubscriptionSurrogate.channel,
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          end = this@with.end?.value?.toString(),
          _end = this@with.end?.toElement(),
          reason = this@with.reason.value,
          _reason = this@with.reason.toElement(),
          criteria = this@with.criteria.value,
          _criteria = this@with.criteria.toElement(),
          error = this@with.error?.value,
          _error = this@with.error?.toElement(),
          channel = this@with.channel,
        )
      }
  }
}

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

import com.google.fhir.model.r4.Bundle
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.Decimal
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Instant
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.Signature
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.UnsignedInt
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class BundleLinkSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var relation: KotlinString? = null,
  public var _relation: Element? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
) {
  public fun toModel(): Bundle.Link =
    Bundle.Link(
      id = this@BundleLinkSurrogate.id,
      extension = this@BundleLinkSurrogate.extension ?: listOf(),
      modifierExtension = this@BundleLinkSurrogate.modifierExtension ?: listOf(),
      relation =
        R4String.of(this@BundleLinkSurrogate.relation, this@BundleLinkSurrogate._relation)!!,
      url = Uri.of(this@BundleLinkSurrogate.url, this@BundleLinkSurrogate._url)!!,
    )

  public companion object {
    public fun fromModel(model: Bundle.Link): BundleLinkSurrogate =
      with(model) {
        BundleLinkSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          relation = this@with.relation.value,
          _relation = this@with.relation.toElement(),
          url = this@with.url.value,
          _url = this@with.url.toElement(),
        )
      }
  }
}

@Serializable
internal data class BundleEntrySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var link: List<Bundle.Link>? = null,
  public var fullUrl: KotlinString? = null,
  public var _fullUrl: Element? = null,
  public var resource: Resource? = null,
  public var search: Bundle.Entry.Search? = null,
  public var request: Bundle.Entry.Request? = null,
  public var response: Bundle.Entry.Response? = null,
) {
  public fun toModel(): Bundle.Entry =
    Bundle.Entry(
      id = this@BundleEntrySurrogate.id,
      extension = this@BundleEntrySurrogate.extension ?: listOf(),
      modifierExtension = this@BundleEntrySurrogate.modifierExtension ?: listOf(),
      link = this@BundleEntrySurrogate.link ?: listOf(),
      fullUrl = Uri.of(this@BundleEntrySurrogate.fullUrl, this@BundleEntrySurrogate._fullUrl),
      resource = this@BundleEntrySurrogate.resource,
      search = this@BundleEntrySurrogate.search,
      request = this@BundleEntrySurrogate.request,
      response = this@BundleEntrySurrogate.response,
    )

  public companion object {
    public fun fromModel(model: Bundle.Entry): BundleEntrySurrogate =
      with(model) {
        BundleEntrySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          link = this@with.link.takeIf { it.isNotEmpty() },
          fullUrl = this@with.fullUrl?.value,
          _fullUrl = this@with.fullUrl?.toElement(),
          resource = this@with.resource,
          search = this@with.search,
          request = this@with.request,
          response = this@with.response,
        )
      }
  }
}

@Serializable
internal data class BundleEntrySearchSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
  public var score: Double? = null,
  public var _score: Element? = null,
) {
  public fun toModel(): Bundle.Entry.Search =
    Bundle.Entry.Search(
      id = this@BundleEntrySearchSurrogate.id,
      extension = this@BundleEntrySearchSurrogate.extension ?: listOf(),
      modifierExtension = this@BundleEntrySearchSurrogate.modifierExtension ?: listOf(),
      mode =
        this@BundleEntrySearchSurrogate.mode?.let {
          Enumeration.of(Bundle.SearchEntryMode.fromCode(it), this@BundleEntrySearchSurrogate._mode)
        },
      score =
        Decimal.of(this@BundleEntrySearchSurrogate.score, this@BundleEntrySearchSurrogate._score),
    )

  public companion object {
    public fun fromModel(model: Bundle.Entry.Search): BundleEntrySearchSurrogate =
      with(model) {
        BundleEntrySearchSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          mode = this@with.mode?.value?.getCode(),
          _mode = this@with.mode?.toElement(),
          score = this@with.score?.value?.toString()?.toDouble(),
          _score = this@with.score?.toElement(),
        )
      }
  }
}

@Serializable
internal data class BundleEntryRequestSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var method: KotlinString? = null,
  public var _method: Element? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var ifNoneMatch: KotlinString? = null,
  public var _ifNoneMatch: Element? = null,
  public var ifModifiedSince: KotlinString? = null,
  public var _ifModifiedSince: Element? = null,
  public var ifMatch: KotlinString? = null,
  public var _ifMatch: Element? = null,
  public var ifNoneExist: KotlinString? = null,
  public var _ifNoneExist: Element? = null,
) {
  public fun toModel(): Bundle.Entry.Request =
    Bundle.Entry.Request(
      id = this@BundleEntryRequestSurrogate.id,
      extension = this@BundleEntryRequestSurrogate.extension ?: listOf(),
      modifierExtension = this@BundleEntryRequestSurrogate.modifierExtension ?: listOf(),
      method =
        Enumeration.of(
          Bundle.HTTPVerb.fromCode(this@BundleEntryRequestSurrogate.method!!),
          this@BundleEntryRequestSurrogate._method,
        ),
      url = Uri.of(this@BundleEntryRequestSurrogate.url, this@BundleEntryRequestSurrogate._url)!!,
      ifNoneMatch =
        R4String.of(
          this@BundleEntryRequestSurrogate.ifNoneMatch,
          this@BundleEntryRequestSurrogate._ifNoneMatch,
        ),
      ifModifiedSince =
        Instant.of(
          FhirDateTime.fromString(this@BundleEntryRequestSurrogate.ifModifiedSince),
          this@BundleEntryRequestSurrogate._ifModifiedSince,
        ),
      ifMatch =
        R4String.of(
          this@BundleEntryRequestSurrogate.ifMatch,
          this@BundleEntryRequestSurrogate._ifMatch,
        ),
      ifNoneExist =
        R4String.of(
          this@BundleEntryRequestSurrogate.ifNoneExist,
          this@BundleEntryRequestSurrogate._ifNoneExist,
        ),
    )

  public companion object {
    public fun fromModel(model: Bundle.Entry.Request): BundleEntryRequestSurrogate =
      with(model) {
        BundleEntryRequestSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          method = this@with.method.value?.getCode(),
          _method = this@with.method.toElement(),
          url = this@with.url.value,
          _url = this@with.url.toElement(),
          ifNoneMatch = this@with.ifNoneMatch?.value,
          _ifNoneMatch = this@with.ifNoneMatch?.toElement(),
          ifModifiedSince = this@with.ifModifiedSince?.value?.toString(),
          _ifModifiedSince = this@with.ifModifiedSince?.toElement(),
          ifMatch = this@with.ifMatch?.value,
          _ifMatch = this@with.ifMatch?.toElement(),
          ifNoneExist = this@with.ifNoneExist?.value,
          _ifNoneExist = this@with.ifNoneExist?.toElement(),
        )
      }
  }
}

@Serializable
internal data class BundleEntryResponseSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var location: KotlinString? = null,
  public var _location: Element? = null,
  public var etag: KotlinString? = null,
  public var _etag: Element? = null,
  public var lastModified: KotlinString? = null,
  public var _lastModified: Element? = null,
  public var outcome: Resource? = null,
) {
  public fun toModel(): Bundle.Entry.Response =
    Bundle.Entry.Response(
      id = this@BundleEntryResponseSurrogate.id,
      extension = this@BundleEntryResponseSurrogate.extension ?: listOf(),
      modifierExtension = this@BundleEntryResponseSurrogate.modifierExtension ?: listOf(),
      status =
        R4String.of(
          this@BundleEntryResponseSurrogate.status,
          this@BundleEntryResponseSurrogate._status,
        )!!,
      location =
        Uri.of(
          this@BundleEntryResponseSurrogate.location,
          this@BundleEntryResponseSurrogate._location,
        ),
      etag =
        R4String.of(
          this@BundleEntryResponseSurrogate.etag,
          this@BundleEntryResponseSurrogate._etag,
        ),
      lastModified =
        Instant.of(
          FhirDateTime.fromString(this@BundleEntryResponseSurrogate.lastModified),
          this@BundleEntryResponseSurrogate._lastModified,
        ),
      outcome = this@BundleEntryResponseSurrogate.outcome,
    )

  public companion object {
    public fun fromModel(model: Bundle.Entry.Response): BundleEntryResponseSurrogate =
      with(model) {
        BundleEntryResponseSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          status = this@with.status.value,
          _status = this@with.status.toElement(),
          location = this@with.location?.value,
          _location = this@with.location?.toElement(),
          etag = this@with.etag?.value,
          _etag = this@with.etag?.toElement(),
          lastModified = this@with.lastModified?.value?.toString(),
          _lastModified = this@with.lastModified?.toElement(),
          outcome = this@with.outcome,
        )
      }
  }
}

@Serializable
internal data class BundleSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var identifier: Identifier? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var timestamp: KotlinString? = null,
  public var _timestamp: Element? = null,
  public var total: Int? = null,
  public var _total: Element? = null,
  public var link: List<Bundle.Link>? = null,
  public var entry: List<Bundle.Entry>? = null,
  public var signature: Signature? = null,
) {
  public fun toModel(): Bundle =
    Bundle(
      id = this@BundleSurrogate.id,
      meta = this@BundleSurrogate.meta,
      implicitRules =
        Uri.of(this@BundleSurrogate.implicitRules, this@BundleSurrogate._implicitRules),
      language = Code.of(this@BundleSurrogate.language, this@BundleSurrogate._language),
      identifier = this@BundleSurrogate.identifier,
      type =
        Enumeration.of(
          Bundle.BundleType.fromCode(this@BundleSurrogate.type!!),
          this@BundleSurrogate._type,
        ),
      timestamp =
        Instant.of(
          FhirDateTime.fromString(this@BundleSurrogate.timestamp),
          this@BundleSurrogate._timestamp,
        ),
      total = UnsignedInt.of(this@BundleSurrogate.total, this@BundleSurrogate._total),
      link = this@BundleSurrogate.link ?: listOf(),
      entry = this@BundleSurrogate.entry ?: listOf(),
      signature = this@BundleSurrogate.signature,
    )

  public companion object {
    public fun fromModel(model: Bundle): BundleSurrogate =
      with(model) {
        BundleSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          identifier = this@with.identifier,
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          timestamp = this@with.timestamp?.value?.toString(),
          _timestamp = this@with.timestamp?.toElement(),
          total = this@with.total?.value,
          _total = this@with.total?.toElement(),
          link = this@with.link.takeIf { it.isNotEmpty() },
          entry = this@with.entry.takeIf { it.isNotEmpty() },
          signature = this@with.signature,
        )
      }
  }
}

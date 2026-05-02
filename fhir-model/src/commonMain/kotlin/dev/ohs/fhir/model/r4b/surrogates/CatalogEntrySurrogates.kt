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
import com.google.fhir.model.r4b.CatalogEntry
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
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CatalogEntryRelatedEntrySurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var relationtype: String? = null,
  public var _relationtype: Element? = null,
  public var item: Reference,
) {
  public fun toModel(): CatalogEntry.RelatedEntry =
    CatalogEntry.RelatedEntry(
      id = this@CatalogEntryRelatedEntrySurrogate.id,
      extension = this@CatalogEntryRelatedEntrySurrogate.extension ?: listOf(),
      modifierExtension = this@CatalogEntryRelatedEntrySurrogate.modifierExtension ?: listOf(),
      relationtype =
        Enumeration.of(
          CatalogEntry.CatalogEntryRelationType.fromCode(
            this@CatalogEntryRelatedEntrySurrogate.relationtype!!
          ),
          this@CatalogEntryRelatedEntrySurrogate._relationtype,
        ),
      item = this@CatalogEntryRelatedEntrySurrogate.item,
    )

  public companion object {
    public fun fromModel(model: CatalogEntry.RelatedEntry): CatalogEntryRelatedEntrySurrogate =
      with(model) {
        CatalogEntryRelatedEntrySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          relationtype = this@with.relationtype.value?.getCode(),
          _relationtype = this@with.relationtype.toElement(),
          item = this@with.item,
        )
      }
  }
}

@Serializable
internal data class CatalogEntrySurrogate(
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
  public var type: CodeableConcept? = null,
  public var orderable: KotlinBoolean? = null,
  public var _orderable: Element? = null,
  public var referencedItem: Reference,
  public var additionalIdentifier: List<Identifier>? = null,
  public var classification: List<CodeableConcept>? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var validityPeriod: Period? = null,
  public var validTo: String? = null,
  public var _validTo: Element? = null,
  public var lastUpdated: String? = null,
  public var _lastUpdated: Element? = null,
  public var additionalCharacteristic: List<CodeableConcept>? = null,
  public var additionalClassification: List<CodeableConcept>? = null,
  public var relatedEntry: List<CatalogEntry.RelatedEntry>? = null,
) {
  public fun toModel(): CatalogEntry =
    CatalogEntry(
      id = this@CatalogEntrySurrogate.id,
      meta = this@CatalogEntrySurrogate.meta,
      implicitRules =
        Uri.of(this@CatalogEntrySurrogate.implicitRules, this@CatalogEntrySurrogate._implicitRules),
      language = Code.of(this@CatalogEntrySurrogate.language, this@CatalogEntrySurrogate._language),
      text = this@CatalogEntrySurrogate.text,
      contained = this@CatalogEntrySurrogate.contained ?: listOf(),
      extension = this@CatalogEntrySurrogate.extension ?: listOf(),
      modifierExtension = this@CatalogEntrySurrogate.modifierExtension ?: listOf(),
      identifier = this@CatalogEntrySurrogate.identifier ?: listOf(),
      type = this@CatalogEntrySurrogate.type,
      orderable =
        R4bBoolean.of(
          this@CatalogEntrySurrogate.orderable,
          this@CatalogEntrySurrogate._orderable,
        )!!,
      referencedItem = this@CatalogEntrySurrogate.referencedItem,
      additionalIdentifier = this@CatalogEntrySurrogate.additionalIdentifier ?: listOf(),
      classification = this@CatalogEntrySurrogate.classification ?: listOf(),
      status =
        this@CatalogEntrySurrogate.status?.let {
          Enumeration.of(PublicationStatus.fromCode(it), this@CatalogEntrySurrogate._status)
        },
      validityPeriod = this@CatalogEntrySurrogate.validityPeriod,
      validTo =
        DateTime.of(
          FhirDateTime.fromString(this@CatalogEntrySurrogate.validTo),
          this@CatalogEntrySurrogate._validTo,
        ),
      lastUpdated =
        DateTime.of(
          FhirDateTime.fromString(this@CatalogEntrySurrogate.lastUpdated),
          this@CatalogEntrySurrogate._lastUpdated,
        ),
      additionalCharacteristic = this@CatalogEntrySurrogate.additionalCharacteristic ?: listOf(),
      additionalClassification = this@CatalogEntrySurrogate.additionalClassification ?: listOf(),
      relatedEntry = this@CatalogEntrySurrogate.relatedEntry ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: CatalogEntry): CatalogEntrySurrogate =
      with(model) {
        CatalogEntrySurrogate(
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
          type = this@with.type,
          orderable = this@with.orderable.value,
          _orderable = this@with.orderable.toElement(),
          referencedItem = this@with.referencedItem,
          additionalIdentifier = this@with.additionalIdentifier.takeIf { it.isNotEmpty() },
          classification = this@with.classification.takeIf { it.isNotEmpty() },
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          validityPeriod = this@with.validityPeriod,
          validTo = this@with.validTo?.value?.toString(),
          _validTo = this@with.validTo?.toElement(),
          lastUpdated = this@with.lastUpdated?.value?.toString(),
          _lastUpdated = this@with.lastUpdated?.toElement(),
          additionalCharacteristic = this@with.additionalCharacteristic.takeIf { it.isNotEmpty() },
          additionalClassification = this@with.additionalClassification.takeIf { it.isNotEmpty() },
          relatedEntry = this@with.relatedEntry.takeIf { it.isNotEmpty() },
        )
      }
  }
}

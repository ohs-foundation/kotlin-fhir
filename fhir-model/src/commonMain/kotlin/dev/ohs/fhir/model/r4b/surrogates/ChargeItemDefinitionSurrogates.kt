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
import com.google.fhir.model.r4b.ChargeItemDefinition
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Decimal
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Money
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Double
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ChargeItemDefinitionApplicabilitySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var expression: KotlinString? = null,
  public var _expression: Element? = null,
) {
  public fun toModel(): ChargeItemDefinition.Applicability =
    ChargeItemDefinition.Applicability(
      id = this@ChargeItemDefinitionApplicabilitySurrogate.id,
      extension = this@ChargeItemDefinitionApplicabilitySurrogate.extension ?: listOf(),
      modifierExtension =
        this@ChargeItemDefinitionApplicabilitySurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@ChargeItemDefinitionApplicabilitySurrogate.description,
          this@ChargeItemDefinitionApplicabilitySurrogate._description,
        ),
      language =
        R4bString.of(
          this@ChargeItemDefinitionApplicabilitySurrogate.language,
          this@ChargeItemDefinitionApplicabilitySurrogate._language,
        ),
      expression =
        R4bString.of(
          this@ChargeItemDefinitionApplicabilitySurrogate.expression,
          this@ChargeItemDefinitionApplicabilitySurrogate._expression,
        ),
    )

  public companion object {
    public fun fromModel(
      model: ChargeItemDefinition.Applicability
    ): ChargeItemDefinitionApplicabilitySurrogate =
      with(model) {
        ChargeItemDefinitionApplicabilitySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          expression = this@with.expression?.value,
          _expression = this@with.expression?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ChargeItemDefinitionPropertyGroupSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var applicability: List<ChargeItemDefinition.Applicability>? = null,
  public var priceComponent: List<ChargeItemDefinition.PropertyGroup.PriceComponent>? = null,
) {
  public fun toModel(): ChargeItemDefinition.PropertyGroup =
    ChargeItemDefinition.PropertyGroup(
      id = this@ChargeItemDefinitionPropertyGroupSurrogate.id,
      extension = this@ChargeItemDefinitionPropertyGroupSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ChargeItemDefinitionPropertyGroupSurrogate.modifierExtension ?: listOf(),
      applicability = this@ChargeItemDefinitionPropertyGroupSurrogate.applicability ?: listOf(),
      priceComponent = this@ChargeItemDefinitionPropertyGroupSurrogate.priceComponent ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ChargeItemDefinition.PropertyGroup
    ): ChargeItemDefinitionPropertyGroupSurrogate =
      with(model) {
        ChargeItemDefinitionPropertyGroupSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          applicability = this@with.applicability.takeIf { it.isNotEmpty() },
          priceComponent = this@with.priceComponent.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ChargeItemDefinitionPropertyGroupPriceComponentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var code: CodeableConcept? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var amount: Money? = null,
) {
  public fun toModel(): ChargeItemDefinition.PropertyGroup.PriceComponent =
    ChargeItemDefinition.PropertyGroup.PriceComponent(
      id = this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.id,
      extension =
        this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          ChargeItemDefinition.InvoicePriceComponentType.fromCode(
            this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.type!!
          ),
          this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate._type,
        ),
      code = this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.code,
      factor =
        Decimal.of(
          this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.factor,
          this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate._factor,
        ),
      amount = this@ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.amount,
    )

  public companion object {
    public fun fromModel(
      model: ChargeItemDefinition.PropertyGroup.PriceComponent
    ): ChargeItemDefinitionPropertyGroupPriceComponentSurrogate =
      with(model) {
        ChargeItemDefinitionPropertyGroupPriceComponentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          code = this@with.code,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          amount = this@with.amount,
        )
      }
  }
}

@Serializable
internal data class ChargeItemDefinitionSurrogate(
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
  public var derivedFromUri: List<KotlinString?>? = null,
  public var _derivedFromUri: List<Element?>? = null,
  public var partOf: List<KotlinString?>? = null,
  public var _partOf: List<Element?>? = null,
  public var replaces: List<KotlinString?>? = null,
  public var _replaces: List<Element?>? = null,
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
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var approvalDate: KotlinString? = null,
  public var _approvalDate: Element? = null,
  public var lastReviewDate: KotlinString? = null,
  public var _lastReviewDate: Element? = null,
  public var effectivePeriod: Period? = null,
  public var code: CodeableConcept? = null,
  public var instance: List<Reference>? = null,
  public var applicability: List<ChargeItemDefinition.Applicability>? = null,
  public var propertyGroup: List<ChargeItemDefinition.PropertyGroup>? = null,
) {
  public fun toModel(): ChargeItemDefinition =
    ChargeItemDefinition(
      id = this@ChargeItemDefinitionSurrogate.id,
      meta = this@ChargeItemDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ChargeItemDefinitionSurrogate.implicitRules,
          this@ChargeItemDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ChargeItemDefinitionSurrogate.language,
          this@ChargeItemDefinitionSurrogate._language,
        ),
      text = this@ChargeItemDefinitionSurrogate.text,
      contained = this@ChargeItemDefinitionSurrogate.contained ?: listOf(),
      extension = this@ChargeItemDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@ChargeItemDefinitionSurrogate.modifierExtension ?: listOf(),
      url =
        Uri.of(this@ChargeItemDefinitionSurrogate.url, this@ChargeItemDefinitionSurrogate._url)!!,
      identifier = this@ChargeItemDefinitionSurrogate.identifier ?: listOf(),
      version =
        R4bString.of(
          this@ChargeItemDefinitionSurrogate.version,
          this@ChargeItemDefinitionSurrogate._version,
        ),
      title =
        R4bString.of(
          this@ChargeItemDefinitionSurrogate.title,
          this@ChargeItemDefinitionSurrogate._title,
        ),
      derivedFromUri =
        if (
          this@ChargeItemDefinitionSurrogate.derivedFromUri == null &&
            this@ChargeItemDefinitionSurrogate._derivedFromUri == null
        ) {
          listOf()
        } else {
          (this@ChargeItemDefinitionSurrogate.derivedFromUri
              ?: List(this@ChargeItemDefinitionSurrogate._derivedFromUri!!.size) { null })
            .zip(
              this@ChargeItemDefinitionSurrogate._derivedFromUri
                ?: List(this@ChargeItemDefinitionSurrogate.derivedFromUri!!.size) { null }
            )
            .map { (value, element) -> Uri.of(value, element)!! }
            .toList()
        },
      partOf =
        if (
          this@ChargeItemDefinitionSurrogate.partOf == null &&
            this@ChargeItemDefinitionSurrogate._partOf == null
        ) {
          listOf()
        } else {
          (this@ChargeItemDefinitionSurrogate.partOf
              ?: List(this@ChargeItemDefinitionSurrogate._partOf!!.size) { null })
            .zip(
              this@ChargeItemDefinitionSurrogate._partOf
                ?: List(this@ChargeItemDefinitionSurrogate.partOf!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      replaces =
        if (
          this@ChargeItemDefinitionSurrogate.replaces == null &&
            this@ChargeItemDefinitionSurrogate._replaces == null
        ) {
          listOf()
        } else {
          (this@ChargeItemDefinitionSurrogate.replaces
              ?: List(this@ChargeItemDefinitionSurrogate._replaces!!.size) { null })
            .zip(
              this@ChargeItemDefinitionSurrogate._replaces
                ?: List(this@ChargeItemDefinitionSurrogate.replaces!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ChargeItemDefinitionSurrogate.status!!),
          this@ChargeItemDefinitionSurrogate._status,
        ),
      experimental =
        R4bBoolean.of(
          this@ChargeItemDefinitionSurrogate.experimental,
          this@ChargeItemDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ChargeItemDefinitionSurrogate.date),
          this@ChargeItemDefinitionSurrogate._date,
        ),
      publisher =
        R4bString.of(
          this@ChargeItemDefinitionSurrogate.publisher,
          this@ChargeItemDefinitionSurrogate._publisher,
        ),
      contact = this@ChargeItemDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@ChargeItemDefinitionSurrogate.description,
          this@ChargeItemDefinitionSurrogate._description,
        ),
      useContext = this@ChargeItemDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@ChargeItemDefinitionSurrogate.jurisdiction ?: listOf(),
      copyright =
        Markdown.of(
          this@ChargeItemDefinitionSurrogate.copyright,
          this@ChargeItemDefinitionSurrogate._copyright,
        ),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@ChargeItemDefinitionSurrogate.approvalDate),
          this@ChargeItemDefinitionSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@ChargeItemDefinitionSurrogate.lastReviewDate),
          this@ChargeItemDefinitionSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@ChargeItemDefinitionSurrogate.effectivePeriod,
      code = this@ChargeItemDefinitionSurrogate.code,
      instance = this@ChargeItemDefinitionSurrogate.instance ?: listOf(),
      applicability = this@ChargeItemDefinitionSurrogate.applicability ?: listOf(),
      propertyGroup = this@ChargeItemDefinitionSurrogate.propertyGroup ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ChargeItemDefinition): ChargeItemDefinitionSurrogate =
      with(model) {
        ChargeItemDefinitionSurrogate(
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
          derivedFromUri =
            this@with.derivedFromUri.map { it.value }.toList().takeUnless { it.all { it == null } },
          _derivedFromUri =
            this@with.derivedFromUri
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          partOf = this@with.partOf.map { it.value }.toList().takeUnless { it.all { it == null } },
          _partOf =
            this@with.partOf
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          replaces =
            this@with.replaces.map { it.value }.toList().takeUnless { it.all { it == null } },
          _replaces =
            this@with.replaces
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
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          approvalDate = this@with.approvalDate?.value?.toString(),
          _approvalDate = this@with.approvalDate?.toElement(),
          lastReviewDate = this@with.lastReviewDate?.value?.toString(),
          _lastReviewDate = this@with.lastReviewDate?.toElement(),
          effectivePeriod = this@with.effectivePeriod,
          code = this@with.code,
          instance = this@with.instance.takeIf { it.isNotEmpty() },
          applicability = this@with.applicability.takeIf { it.isNotEmpty() },
          propertyGroup = this@with.propertyGroup.takeIf { it.isNotEmpty() },
        )
      }
  }
}

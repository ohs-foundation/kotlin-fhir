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

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.ManufacturedItemDefinition
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.MarketingStatus
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ManufacturedItemDefinitionPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: ManufacturedItemDefinition.Property.Value? = null,
) {
  public fun toModel(): ManufacturedItemDefinition.Property =
    ManufacturedItemDefinition.Property(
      id = this@ManufacturedItemDefinitionPropertySurrogate.id,
      extension = this@ManufacturedItemDefinitionPropertySurrogate.extension ?: listOf(),
      modifierExtension =
        this@ManufacturedItemDefinitionPropertySurrogate.modifierExtension ?: listOf(),
      type = this@ManufacturedItemDefinitionPropertySurrogate.type,
      `value` = this@ManufacturedItemDefinitionPropertySurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: ManufacturedItemDefinition.Property
    ): ManufacturedItemDefinitionPropertySurrogate =
      with(model) {
        ManufacturedItemDefinitionPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class ManufacturedItemDefinitionComponentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var function: List<CodeableConcept>? = null,
  public var amount: List<Quantity>? = null,
  public var constituent: List<ManufacturedItemDefinition.Component.Constituent>? = null,
  public var `property`: List<ManufacturedItemDefinition.Property>? = null,
  public var component: List<ManufacturedItemDefinition.Component>? = null,
) {
  public fun toModel(): ManufacturedItemDefinition.Component =
    ManufacturedItemDefinition.Component(
      id = this@ManufacturedItemDefinitionComponentSurrogate.id,
      extension = this@ManufacturedItemDefinitionComponentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ManufacturedItemDefinitionComponentSurrogate.modifierExtension ?: listOf(),
      type = this@ManufacturedItemDefinitionComponentSurrogate.type,
      function = this@ManufacturedItemDefinitionComponentSurrogate.function ?: listOf(),
      amount = this@ManufacturedItemDefinitionComponentSurrogate.amount ?: listOf(),
      constituent = this@ManufacturedItemDefinitionComponentSurrogate.constituent ?: listOf(),
      `property` = this@ManufacturedItemDefinitionComponentSurrogate.`property` ?: listOf(),
      component = this@ManufacturedItemDefinitionComponentSurrogate.component ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ManufacturedItemDefinition.Component
    ): ManufacturedItemDefinitionComponentSurrogate =
      with(model) {
        ManufacturedItemDefinitionComponentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          function = this@with.function.takeIf { it.isNotEmpty() },
          amount = this@with.amount.takeIf { it.isNotEmpty() },
          constituent = this@with.constituent.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          component = this@with.component.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ManufacturedItemDefinitionComponentConstituentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var amount: List<Quantity>? = null,
  public var location: List<CodeableConcept>? = null,
  public var function: List<CodeableConcept>? = null,
  public var hasIngredient: List<CodeableReference>? = null,
) {
  public fun toModel(): ManufacturedItemDefinition.Component.Constituent =
    ManufacturedItemDefinition.Component.Constituent(
      id = this@ManufacturedItemDefinitionComponentConstituentSurrogate.id,
      extension =
        this@ManufacturedItemDefinitionComponentConstituentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ManufacturedItemDefinitionComponentConstituentSurrogate.modifierExtension ?: listOf(),
      amount = this@ManufacturedItemDefinitionComponentConstituentSurrogate.amount ?: listOf(),
      location = this@ManufacturedItemDefinitionComponentConstituentSurrogate.location ?: listOf(),
      function = this@ManufacturedItemDefinitionComponentConstituentSurrogate.function ?: listOf(),
      hasIngredient =
        this@ManufacturedItemDefinitionComponentConstituentSurrogate.hasIngredient ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ManufacturedItemDefinition.Component.Constituent
    ): ManufacturedItemDefinitionComponentConstituentSurrogate =
      with(model) {
        ManufacturedItemDefinitionComponentConstituentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          amount = this@with.amount.takeIf { it.isNotEmpty() },
          location = this@with.location.takeIf { it.isNotEmpty() },
          function = this@with.function.takeIf { it.isNotEmpty() },
          hasIngredient = this@with.hasIngredient.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ManufacturedItemDefinitionPropertyValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueMarkdown: KotlinString? = null,
  public var _valueMarkdown: Element? = null,
  public var valueAttachment: Attachment? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): ManufacturedItemDefinition.Property.Value =
    ManufacturedItemDefinition.Property.Value.from(
      this@ManufacturedItemDefinitionPropertyValueSurrogate.valueCodeableConcept,
      this@ManufacturedItemDefinitionPropertyValueSurrogate.valueQuantity,
      Date.of(
        FhirDate.fromString(this@ManufacturedItemDefinitionPropertyValueSurrogate.valueDate),
        this@ManufacturedItemDefinitionPropertyValueSurrogate._valueDate,
      ),
      R5Boolean.of(
        this@ManufacturedItemDefinitionPropertyValueSurrogate.valueBoolean,
        this@ManufacturedItemDefinitionPropertyValueSurrogate._valueBoolean,
      ),
      Markdown.of(
        this@ManufacturedItemDefinitionPropertyValueSurrogate.valueMarkdown,
        this@ManufacturedItemDefinitionPropertyValueSurrogate._valueMarkdown,
      ),
      this@ManufacturedItemDefinitionPropertyValueSurrogate.valueAttachment,
      this@ManufacturedItemDefinitionPropertyValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ManufacturedItemDefinition.Property.Value
    ): ManufacturedItemDefinitionPropertyValueSurrogate =
      with(model) {
        ManufacturedItemDefinitionPropertyValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueMarkdown = this@with.asMarkdown()?.value?.value,
          _valueMarkdown = this@with.asMarkdown()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ManufacturedItemDefinitionSurrogate(
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
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var manufacturedDoseForm: CodeableConcept,
  public var unitOfPresentation: CodeableConcept? = null,
  public var manufacturer: List<Reference>? = null,
  public var marketingStatus: List<MarketingStatus>? = null,
  public var ingredient: List<CodeableConcept>? = null,
  public var `property`: List<ManufacturedItemDefinition.Property>? = null,
  public var component: List<ManufacturedItemDefinition.Component>? = null,
) {
  public fun toModel(): ManufacturedItemDefinition =
    ManufacturedItemDefinition(
      id = this@ManufacturedItemDefinitionSurrogate.id,
      meta = this@ManufacturedItemDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ManufacturedItemDefinitionSurrogate.implicitRules,
          this@ManufacturedItemDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ManufacturedItemDefinitionSurrogate.language,
          this@ManufacturedItemDefinitionSurrogate._language,
        ),
      text = this@ManufacturedItemDefinitionSurrogate.text,
      contained = this@ManufacturedItemDefinitionSurrogate.contained ?: listOf(),
      extension = this@ManufacturedItemDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@ManufacturedItemDefinitionSurrogate.modifierExtension ?: listOf(),
      identifier = this@ManufacturedItemDefinitionSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ManufacturedItemDefinitionSurrogate.status!!),
          this@ManufacturedItemDefinitionSurrogate._status,
        ),
      name =
        R5String.of(
          this@ManufacturedItemDefinitionSurrogate.name,
          this@ManufacturedItemDefinitionSurrogate._name,
        ),
      manufacturedDoseForm = this@ManufacturedItemDefinitionSurrogate.manufacturedDoseForm,
      unitOfPresentation = this@ManufacturedItemDefinitionSurrogate.unitOfPresentation,
      manufacturer = this@ManufacturedItemDefinitionSurrogate.manufacturer ?: listOf(),
      marketingStatus = this@ManufacturedItemDefinitionSurrogate.marketingStatus ?: listOf(),
      ingredient = this@ManufacturedItemDefinitionSurrogate.ingredient ?: listOf(),
      `property` = this@ManufacturedItemDefinitionSurrogate.`property` ?: listOf(),
      component = this@ManufacturedItemDefinitionSurrogate.component ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ManufacturedItemDefinition): ManufacturedItemDefinitionSurrogate =
      with(model) {
        ManufacturedItemDefinitionSurrogate(
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
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          manufacturedDoseForm = this@with.manufacturedDoseForm,
          unitOfPresentation = this@with.unitOfPresentation,
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          marketingStatus = this@with.marketingStatus.takeIf { it.isNotEmpty() },
          ingredient = this@with.ingredient.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          component = this@with.component.takeIf { it.isNotEmpty() },
        )
      }
  }
}

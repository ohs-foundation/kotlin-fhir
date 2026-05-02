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

import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.ManufacturedItemDefinition
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Quantity
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
internal data class ManufacturedItemDefinitionPropertySurrogate(
  public var id: String? = null,
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
internal data class ManufacturedItemDefinitionPropertyValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueDate: String? = null,
  public var _valueDate: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueAttachment: Attachment? = null,
) {
  public fun toModel(): ManufacturedItemDefinition.Property.Value =
    ManufacturedItemDefinition.Property.Value.from(
      this@ManufacturedItemDefinitionPropertyValueSurrogate.valueCodeableConcept,
      this@ManufacturedItemDefinitionPropertyValueSurrogate.valueQuantity,
      Date.of(
        FhirDate.fromString(this@ManufacturedItemDefinitionPropertyValueSurrogate.valueDate),
        this@ManufacturedItemDefinitionPropertyValueSurrogate._valueDate,
      ),
      R4bBoolean.of(
        this@ManufacturedItemDefinitionPropertyValueSurrogate.valueBoolean,
        this@ManufacturedItemDefinitionPropertyValueSurrogate._valueBoolean,
      ),
      this@ManufacturedItemDefinitionPropertyValueSurrogate.valueAttachment,
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
          valueAttachment = this@with.asAttachment()?.value,
        )
      }
  }
}

@Serializable
internal data class ManufacturedItemDefinitionSurrogate(
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
  public var status: String? = null,
  public var _status: Element? = null,
  public var manufacturedDoseForm: CodeableConcept,
  public var unitOfPresentation: CodeableConcept? = null,
  public var manufacturer: List<Reference>? = null,
  public var ingredient: List<CodeableConcept>? = null,
  public var `property`: List<ManufacturedItemDefinition.Property>? = null,
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
      manufacturedDoseForm = this@ManufacturedItemDefinitionSurrogate.manufacturedDoseForm,
      unitOfPresentation = this@ManufacturedItemDefinitionSurrogate.unitOfPresentation,
      manufacturer = this@ManufacturedItemDefinitionSurrogate.manufacturer ?: listOf(),
      ingredient = this@ManufacturedItemDefinitionSurrogate.ingredient ?: listOf(),
      `property` = this@ManufacturedItemDefinitionSurrogate.`property` ?: listOf(),
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
          manufacturedDoseForm = this@with.manufacturedDoseForm,
          unitOfPresentation = this@with.unitOfPresentation,
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          ingredient = this@with.ingredient.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
        )
      }
  }
}

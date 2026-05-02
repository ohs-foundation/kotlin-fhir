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

import com.google.fhir.model.r4.DataRequirement
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Expression
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDate
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Timing
import com.google.fhir.model.r4.TriggerDefinition
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class TriggerDefinitionTimingSurrogate(
  public var timingTiming: Timing? = null,
  public var timingReference: Reference? = null,
  public var timingDate: KotlinString? = null,
  public var _timingDate: Element? = null,
  public var timingDateTime: KotlinString? = null,
  public var _timingDateTime: Element? = null,
) {
  public fun toModel(): TriggerDefinition.Timing =
    TriggerDefinition.Timing.from(
      this@TriggerDefinitionTimingSurrogate.timingTiming,
      this@TriggerDefinitionTimingSurrogate.timingReference,
      Date.of(
        FhirDate.fromString(this@TriggerDefinitionTimingSurrogate.timingDate),
        this@TriggerDefinitionTimingSurrogate._timingDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@TriggerDefinitionTimingSurrogate.timingDateTime),
        this@TriggerDefinitionTimingSurrogate._timingDateTime,
      ),
    )!!

  public companion object {
    public fun fromModel(model: TriggerDefinition.Timing): TriggerDefinitionTimingSurrogate =
      with(model) {
        TriggerDefinitionTimingSurrogate(
          timingTiming = this@with.asTiming()?.value,
          timingReference = this@with.asReference()?.value,
          timingDate = this@with.asDate()?.value?.value?.toString(),
          _timingDate = this@with.asDate()?.value?.toElement(),
          timingDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _timingDateTime = this@with.asDateTime()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class TriggerDefinitionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var timing: TriggerDefinition.Timing? = null,
  public var `data`: List<DataRequirement>? = null,
  public var condition: Expression? = null,
) {
  public fun toModel(): TriggerDefinition =
    TriggerDefinition(
      id = this@TriggerDefinitionSurrogate.id,
      extension = this@TriggerDefinitionSurrogate.extension ?: listOf(),
      type =
        Enumeration.of(
          TriggerDefinition.TriggerType.fromCode(this@TriggerDefinitionSurrogate.type!!),
          this@TriggerDefinitionSurrogate._type,
        ),
      name =
        R4String.of(this@TriggerDefinitionSurrogate.name, this@TriggerDefinitionSurrogate._name),
      timing = this@TriggerDefinitionSurrogate.timing,
      `data` = this@TriggerDefinitionSurrogate.`data` ?: listOf(),
      condition = this@TriggerDefinitionSurrogate.condition,
    )

  public companion object {
    public fun fromModel(model: TriggerDefinition): TriggerDefinitionSurrogate =
      with(model) {
        TriggerDefinitionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          timing = this@with.timing,
          `data` = this@with.`data`.takeIf { it.isNotEmpty() },
          condition = this@with.condition,
        )
      }
  }
}

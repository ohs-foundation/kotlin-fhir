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

import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.MedicinalProductUndesirableEffect
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Population
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MedicinalProductUndesirableEffectSurrogate(
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
  public var subject: List<Reference>? = null,
  public var symptomConditionEffect: CodeableConcept? = null,
  public var classification: CodeableConcept? = null,
  public var frequencyOfOccurrence: CodeableConcept? = null,
  public var population: List<Population>? = null,
) {
  public fun toModel(): MedicinalProductUndesirableEffect =
    MedicinalProductUndesirableEffect(
      id = this@MedicinalProductUndesirableEffectSurrogate.id,
      meta = this@MedicinalProductUndesirableEffectSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicinalProductUndesirableEffectSurrogate.implicitRules,
          this@MedicinalProductUndesirableEffectSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicinalProductUndesirableEffectSurrogate.language,
          this@MedicinalProductUndesirableEffectSurrogate._language,
        ),
      text = this@MedicinalProductUndesirableEffectSurrogate.text,
      contained = this@MedicinalProductUndesirableEffectSurrogate.contained ?: listOf(),
      extension = this@MedicinalProductUndesirableEffectSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductUndesirableEffectSurrogate.modifierExtension ?: listOf(),
      subject = this@MedicinalProductUndesirableEffectSurrogate.subject ?: listOf(),
      symptomConditionEffect =
        this@MedicinalProductUndesirableEffectSurrogate.symptomConditionEffect,
      classification = this@MedicinalProductUndesirableEffectSurrogate.classification,
      frequencyOfOccurrence = this@MedicinalProductUndesirableEffectSurrogate.frequencyOfOccurrence,
      population = this@MedicinalProductUndesirableEffectSurrogate.population ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductUndesirableEffect
    ): MedicinalProductUndesirableEffectSurrogate =
      with(model) {
        MedicinalProductUndesirableEffectSurrogate(
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
          subject = this@with.subject.takeIf { it.isNotEmpty() },
          symptomConditionEffect = this@with.symptomConditionEffect,
          classification = this@with.classification,
          frequencyOfOccurrence = this@with.frequencyOfOccurrence,
          population = this@with.population.takeIf { it.isNotEmpty() },
        )
      }
  }
}

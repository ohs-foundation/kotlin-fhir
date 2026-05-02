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
import com.google.fhir.model.r4.MedicinalProductInteraction
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MedicinalProductInteractionInteractantSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var item: MedicinalProductInteraction.Interactant.Item,
) {
  public fun toModel(): MedicinalProductInteraction.Interactant =
    MedicinalProductInteraction.Interactant(
      id = this@MedicinalProductInteractionInteractantSurrogate.id,
      extension = this@MedicinalProductInteractionInteractantSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductInteractionInteractantSurrogate.modifierExtension ?: listOf(),
      item = this@MedicinalProductInteractionInteractantSurrogate.item,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductInteraction.Interactant
    ): MedicinalProductInteractionInteractantSurrogate =
      with(model) {
        MedicinalProductInteractionInteractantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          item = this@with.item,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductInteractionInteractantItemSurrogate(
  public var itemReference: Reference? = null,
  public var itemCodeableConcept: CodeableConcept? = null,
) {
  public fun toModel(): MedicinalProductInteraction.Interactant.Item =
    MedicinalProductInteraction.Interactant.Item.from(
      this@MedicinalProductInteractionInteractantItemSurrogate.itemReference,
      this@MedicinalProductInteractionInteractantItemSurrogate.itemCodeableConcept,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicinalProductInteraction.Interactant.Item
    ): MedicinalProductInteractionInteractantItemSurrogate =
      with(model) {
        MedicinalProductInteractionInteractantItemSurrogate(
          itemReference = this@with.asReference()?.value,
          itemCodeableConcept = this@with.asCodeableConcept()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductInteractionSurrogate(
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
  public var subject: List<Reference>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var interactant: List<MedicinalProductInteraction.Interactant>? = null,
  public var type: CodeableConcept? = null,
  public var effect: CodeableConcept? = null,
  public var incidence: CodeableConcept? = null,
  public var management: CodeableConcept? = null,
) {
  public fun toModel(): MedicinalProductInteraction =
    MedicinalProductInteraction(
      id = this@MedicinalProductInteractionSurrogate.id,
      meta = this@MedicinalProductInteractionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicinalProductInteractionSurrogate.implicitRules,
          this@MedicinalProductInteractionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicinalProductInteractionSurrogate.language,
          this@MedicinalProductInteractionSurrogate._language,
        ),
      text = this@MedicinalProductInteractionSurrogate.text,
      contained = this@MedicinalProductInteractionSurrogate.contained ?: listOf(),
      extension = this@MedicinalProductInteractionSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicinalProductInteractionSurrogate.modifierExtension ?: listOf(),
      subject = this@MedicinalProductInteractionSurrogate.subject ?: listOf(),
      description =
        R4String.of(
          this@MedicinalProductInteractionSurrogate.description,
          this@MedicinalProductInteractionSurrogate._description,
        ),
      interactant = this@MedicinalProductInteractionSurrogate.interactant ?: listOf(),
      type = this@MedicinalProductInteractionSurrogate.type,
      effect = this@MedicinalProductInteractionSurrogate.effect,
      incidence = this@MedicinalProductInteractionSurrogate.incidence,
      management = this@MedicinalProductInteractionSurrogate.management,
    )

  public companion object {
    public fun fromModel(model: MedicinalProductInteraction): MedicinalProductInteractionSurrogate =
      with(model) {
        MedicinalProductInteractionSurrogate(
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
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          interactant = this@with.interactant.takeIf { it.isNotEmpty() },
          type = this@with.type,
          effect = this@with.effect,
          incidence = this@with.incidence,
          management = this@with.management,
        )
      }
  }
}

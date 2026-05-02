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
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.ProdCharacteristic
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ProdCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var height: Quantity? = null,
  public var width: Quantity? = null,
  public var depth: Quantity? = null,
  public var weight: Quantity? = null,
  public var nominalVolume: Quantity? = null,
  public var externalDiameter: Quantity? = null,
  public var shape: KotlinString? = null,
  public var _shape: Element? = null,
  public var color: List<KotlinString?>? = null,
  public var _color: List<Element?>? = null,
  public var imprint: List<KotlinString?>? = null,
  public var _imprint: List<Element?>? = null,
  public var image: List<Attachment>? = null,
  public var scoring: CodeableConcept? = null,
) {
  public fun toModel(): ProdCharacteristic =
    ProdCharacteristic(
      id = this@ProdCharacteristicSurrogate.id,
      extension = this@ProdCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension = this@ProdCharacteristicSurrogate.modifierExtension ?: listOf(),
      height = this@ProdCharacteristicSurrogate.height,
      width = this@ProdCharacteristicSurrogate.width,
      depth = this@ProdCharacteristicSurrogate.depth,
      weight = this@ProdCharacteristicSurrogate.weight,
      nominalVolume = this@ProdCharacteristicSurrogate.nominalVolume,
      externalDiameter = this@ProdCharacteristicSurrogate.externalDiameter,
      shape =
        R4bString.of(
          this@ProdCharacteristicSurrogate.shape,
          this@ProdCharacteristicSurrogate._shape,
        ),
      color =
        if (
          this@ProdCharacteristicSurrogate.color == null &&
            this@ProdCharacteristicSurrogate._color == null
        ) {
          listOf()
        } else {
          (this@ProdCharacteristicSurrogate.color
              ?: List(this@ProdCharacteristicSurrogate._color!!.size) { null })
            .zip(
              this@ProdCharacteristicSurrogate._color
                ?: List(this@ProdCharacteristicSurrogate.color!!.size) { null }
            )
            .map { (value, element) -> R4bString.of(value, element)!! }
            .toList()
        },
      imprint =
        if (
          this@ProdCharacteristicSurrogate.imprint == null &&
            this@ProdCharacteristicSurrogate._imprint == null
        ) {
          listOf()
        } else {
          (this@ProdCharacteristicSurrogate.imprint
              ?: List(this@ProdCharacteristicSurrogate._imprint!!.size) { null })
            .zip(
              this@ProdCharacteristicSurrogate._imprint
                ?: List(this@ProdCharacteristicSurrogate.imprint!!.size) { null }
            )
            .map { (value, element) -> R4bString.of(value, element)!! }
            .toList()
        },
      image = this@ProdCharacteristicSurrogate.image ?: listOf(),
      scoring = this@ProdCharacteristicSurrogate.scoring,
    )

  public companion object {
    public fun fromModel(model: ProdCharacteristic): ProdCharacteristicSurrogate =
      with(model) {
        ProdCharacteristicSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          height = this@with.height,
          width = this@with.width,
          depth = this@with.depth,
          weight = this@with.weight,
          nominalVolume = this@with.nominalVolume,
          externalDiameter = this@with.externalDiameter,
          shape = this@with.shape?.value,
          _shape = this@with.shape?.toElement(),
          color = this@with.color.map { it.value }.toList().takeUnless { it.all { it == null } },
          _color =
            this@with.color
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          imprint =
            this@with.imprint.map { it.value }.toList().takeUnless { it.all { it == null } },
          _imprint =
            this@with.imprint
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          image = this@with.image.takeIf { it.isNotEmpty() },
          scoring = this@with.scoring,
        )
      }
  }
}

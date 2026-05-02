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

import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Group
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.UnsignedInt
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class GroupCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var `value`: Group.Characteristic.Value,
  public var exclude: KotlinBoolean? = null,
  public var _exclude: Element? = null,
  public var period: Period? = null,
) {
  public fun toModel(): Group.Characteristic =
    Group.Characteristic(
      id = this@GroupCharacteristicSurrogate.id,
      extension = this@GroupCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension = this@GroupCharacteristicSurrogate.modifierExtension ?: listOf(),
      code = this@GroupCharacteristicSurrogate.code,
      `value` = this@GroupCharacteristicSurrogate.`value`,
      exclude =
        R5Boolean.of(
          this@GroupCharacteristicSurrogate.exclude,
          this@GroupCharacteristicSurrogate._exclude,
        )!!,
      period = this@GroupCharacteristicSurrogate.period,
    )

  public companion object {
    public fun fromModel(model: Group.Characteristic): GroupCharacteristicSurrogate =
      with(model) {
        GroupCharacteristicSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          `value` = this@with.`value`,
          exclude = this@with.exclude.value,
          _exclude = this@with.exclude.toElement(),
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class GroupMemberSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var entity: Reference,
  public var period: Period? = null,
  public var inactive: KotlinBoolean? = null,
  public var _inactive: Element? = null,
) {
  public fun toModel(): Group.Member =
    Group.Member(
      id = this@GroupMemberSurrogate.id,
      extension = this@GroupMemberSurrogate.extension ?: listOf(),
      modifierExtension = this@GroupMemberSurrogate.modifierExtension ?: listOf(),
      entity = this@GroupMemberSurrogate.entity,
      period = this@GroupMemberSurrogate.period,
      inactive =
        R5Boolean.of(this@GroupMemberSurrogate.inactive, this@GroupMemberSurrogate._inactive),
    )

  public companion object {
    public fun fromModel(model: Group.Member): GroupMemberSurrogate =
      with(model) {
        GroupMemberSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          entity = this@with.entity,
          period = this@with.period,
          inactive = this@with.inactive?.value,
          _inactive = this@with.inactive?.toElement(),
        )
      }
  }
}

@Serializable
internal data class GroupCharacteristicValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): Group.Characteristic.Value =
    Group.Characteristic.Value.from(
      this@GroupCharacteristicValueSurrogate.valueCodeableConcept,
      R5Boolean.of(
        this@GroupCharacteristicValueSurrogate.valueBoolean,
        this@GroupCharacteristicValueSurrogate._valueBoolean,
      ),
      this@GroupCharacteristicValueSurrogate.valueQuantity,
      this@GroupCharacteristicValueSurrogate.valueRange,
      this@GroupCharacteristicValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(model: Group.Characteristic.Value): GroupCharacteristicValueSurrogate =
      with(model) {
        GroupCharacteristicValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class GroupSurrogate(
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
  public var active: KotlinBoolean? = null,
  public var _active: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var membership: KotlinString? = null,
  public var _membership: Element? = null,
  public var code: CodeableConcept? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var quantity: Int? = null,
  public var _quantity: Element? = null,
  public var managingEntity: Reference? = null,
  public var characteristic: List<Group.Characteristic>? = null,
  public var member: List<Group.Member>? = null,
) {
  public fun toModel(): Group =
    Group(
      id = this@GroupSurrogate.id,
      meta = this@GroupSurrogate.meta,
      implicitRules = Uri.of(this@GroupSurrogate.implicitRules, this@GroupSurrogate._implicitRules),
      language = Code.of(this@GroupSurrogate.language, this@GroupSurrogate._language),
      text = this@GroupSurrogate.text,
      contained = this@GroupSurrogate.contained ?: listOf(),
      extension = this@GroupSurrogate.extension ?: listOf(),
      modifierExtension = this@GroupSurrogate.modifierExtension ?: listOf(),
      identifier = this@GroupSurrogate.identifier ?: listOf(),
      active = R5Boolean.of(this@GroupSurrogate.active, this@GroupSurrogate._active),
      type =
        Enumeration.of(
          Group.GroupType.fromCode(this@GroupSurrogate.type!!),
          this@GroupSurrogate._type,
        ),
      membership =
        Enumeration.of(
          Group.GroupMembershipBasis.fromCode(this@GroupSurrogate.membership!!),
          this@GroupSurrogate._membership,
        ),
      code = this@GroupSurrogate.code,
      name = R5String.of(this@GroupSurrogate.name, this@GroupSurrogate._name),
      description = Markdown.of(this@GroupSurrogate.description, this@GroupSurrogate._description),
      quantity = UnsignedInt.of(this@GroupSurrogate.quantity, this@GroupSurrogate._quantity),
      managingEntity = this@GroupSurrogate.managingEntity,
      characteristic = this@GroupSurrogate.characteristic ?: listOf(),
      member = this@GroupSurrogate.member ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Group): GroupSurrogate =
      with(model) {
        GroupSurrogate(
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
          active = this@with.active?.value,
          _active = this@with.active?.toElement(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          membership = this@with.membership.value?.getCode(),
          _membership = this@with.membership.toElement(),
          code = this@with.code,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          quantity = this@with.quantity?.value,
          _quantity = this@with.quantity?.toElement(),
          managingEntity = this@with.managingEntity,
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
          member = this@with.member.takeIf { it.isNotEmpty() },
        )
      }
  }
}

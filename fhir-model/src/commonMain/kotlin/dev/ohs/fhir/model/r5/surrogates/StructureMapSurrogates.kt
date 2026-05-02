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
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactDetail
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Decimal
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Id
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.StructureMap
import com.google.fhir.model.r5.Time
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class StructureMapStructureSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
  public var alias: KotlinString? = null,
  public var _alias: Element? = null,
  public var documentation: KotlinString? = null,
  public var _documentation: Element? = null,
) {
  public fun toModel(): StructureMap.Structure =
    StructureMap.Structure(
      id = this@StructureMapStructureSurrogate.id,
      extension = this@StructureMapStructureSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureMapStructureSurrogate.modifierExtension ?: listOf(),
      url =
        Canonical.of(
          this@StructureMapStructureSurrogate.url,
          this@StructureMapStructureSurrogate._url,
        )!!,
      mode =
        Enumeration.of(
          StructureMap.StructureMapModelMode.fromCode(this@StructureMapStructureSurrogate.mode!!),
          this@StructureMapStructureSurrogate._mode,
        ),
      alias =
        R5String.of(
          this@StructureMapStructureSurrogate.alias,
          this@StructureMapStructureSurrogate._alias,
        ),
      documentation =
        R5String.of(
          this@StructureMapStructureSurrogate.documentation,
          this@StructureMapStructureSurrogate._documentation,
        ),
    )

  public companion object {
    public fun fromModel(model: StructureMap.Structure): StructureMapStructureSurrogate =
      with(model) {
        StructureMapStructureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          url = this@with.url.value,
          _url = this@with.url.toElement(),
          mode = this@with.mode.value?.getCode(),
          _mode = this@with.mode.toElement(),
          alias = this@with.alias?.value,
          _alias = this@with.alias?.toElement(),
          documentation = this@with.documentation?.value,
          _documentation = this@with.documentation?.toElement(),
        )
      }
  }
}

@Serializable
internal data class StructureMapConstSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): StructureMap.Const =
    StructureMap.Const(
      id = this@StructureMapConstSurrogate.id,
      extension = this@StructureMapConstSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureMapConstSurrogate.modifierExtension ?: listOf(),
      name = Id.of(this@StructureMapConstSurrogate.name, this@StructureMapConstSurrogate._name),
      `value` =
        R5String.of(this@StructureMapConstSurrogate.`value`, this@StructureMapConstSurrogate._value),
    )

  public companion object {
    public fun fromModel(model: StructureMap.Const): StructureMapConstSurrogate =
      with(model) {
        StructureMapConstSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          `value` = this@with.`value`?.value,
          _value = this@with.`value`?.toElement(),
        )
      }
  }
}

@Serializable
internal data class StructureMapGroupSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var extends: KotlinString? = null,
  public var _extends: Element? = null,
  public var typeMode: KotlinString? = null,
  public var _typeMode: Element? = null,
  public var documentation: KotlinString? = null,
  public var _documentation: Element? = null,
  public var input: List<StructureMap.Group.Input>? = null,
  public var rule: List<StructureMap.Group.Rule>? = null,
) {
  public fun toModel(): StructureMap.Group =
    StructureMap.Group(
      id = this@StructureMapGroupSurrogate.id,
      extension = this@StructureMapGroupSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureMapGroupSurrogate.modifierExtension ?: listOf(),
      name = Id.of(this@StructureMapGroupSurrogate.name, this@StructureMapGroupSurrogate._name)!!,
      extends =
        Id.of(this@StructureMapGroupSurrogate.extends, this@StructureMapGroupSurrogate._extends),
      typeMode =
        this@StructureMapGroupSurrogate.typeMode?.let {
          Enumeration.of(
            StructureMap.StructureMapGroupTypeMode.fromCode(it),
            this@StructureMapGroupSurrogate._typeMode,
          )
        },
      documentation =
        R5String.of(
          this@StructureMapGroupSurrogate.documentation,
          this@StructureMapGroupSurrogate._documentation,
        ),
      input = this@StructureMapGroupSurrogate.input ?: listOf(),
      rule = this@StructureMapGroupSurrogate.rule ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: StructureMap.Group): StructureMapGroupSurrogate =
      with(model) {
        StructureMapGroupSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          extends = this@with.extends?.value,
          _extends = this@with.extends?.toElement(),
          typeMode = this@with.typeMode?.value?.getCode(),
          _typeMode = this@with.typeMode?.toElement(),
          documentation = this@with.documentation?.value,
          _documentation = this@with.documentation?.toElement(),
          input = this@with.input.takeIf { it.isNotEmpty() },
          rule = this@with.rule.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class StructureMapGroupInputSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
  public var documentation: KotlinString? = null,
  public var _documentation: Element? = null,
) {
  public fun toModel(): StructureMap.Group.Input =
    StructureMap.Group.Input(
      id = this@StructureMapGroupInputSurrogate.id,
      extension = this@StructureMapGroupInputSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureMapGroupInputSurrogate.modifierExtension ?: listOf(),
      name =
        Id.of(
          this@StructureMapGroupInputSurrogate.name,
          this@StructureMapGroupInputSurrogate._name,
        )!!,
      type =
        R5String.of(
          this@StructureMapGroupInputSurrogate.type,
          this@StructureMapGroupInputSurrogate._type,
        ),
      mode =
        Enumeration.of(
          StructureMap.StructureMapInputMode.fromCode(this@StructureMapGroupInputSurrogate.mode!!),
          this@StructureMapGroupInputSurrogate._mode,
        ),
      documentation =
        R5String.of(
          this@StructureMapGroupInputSurrogate.documentation,
          this@StructureMapGroupInputSurrogate._documentation,
        ),
    )

  public companion object {
    public fun fromModel(model: StructureMap.Group.Input): StructureMapGroupInputSurrogate =
      with(model) {
        StructureMapGroupInputSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          type = this@with.type?.value,
          _type = this@with.type?.toElement(),
          mode = this@with.mode.value?.getCode(),
          _mode = this@with.mode.toElement(),
          documentation = this@with.documentation?.value,
          _documentation = this@with.documentation?.toElement(),
        )
      }
  }
}

@Serializable
internal data class StructureMapGroupRuleSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var source: List<StructureMap.Group.Rule.Source>? = null,
  public var target: List<StructureMap.Group.Rule.Target>? = null,
  public var rule: List<StructureMap.Group.Rule>? = null,
  public var dependent: List<StructureMap.Group.Rule.Dependent>? = null,
  public var documentation: KotlinString? = null,
  public var _documentation: Element? = null,
) {
  public fun toModel(): StructureMap.Group.Rule =
    StructureMap.Group.Rule(
      id = this@StructureMapGroupRuleSurrogate.id,
      extension = this@StructureMapGroupRuleSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureMapGroupRuleSurrogate.modifierExtension ?: listOf(),
      name =
        Id.of(this@StructureMapGroupRuleSurrogate.name, this@StructureMapGroupRuleSurrogate._name),
      source = this@StructureMapGroupRuleSurrogate.source ?: listOf(),
      target = this@StructureMapGroupRuleSurrogate.target ?: listOf(),
      rule = this@StructureMapGroupRuleSurrogate.rule ?: listOf(),
      dependent = this@StructureMapGroupRuleSurrogate.dependent ?: listOf(),
      documentation =
        R5String.of(
          this@StructureMapGroupRuleSurrogate.documentation,
          this@StructureMapGroupRuleSurrogate._documentation,
        ),
    )

  public companion object {
    public fun fromModel(model: StructureMap.Group.Rule): StructureMapGroupRuleSurrogate =
      with(model) {
        StructureMapGroupRuleSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          source = this@with.source.takeIf { it.isNotEmpty() },
          target = this@with.target.takeIf { it.isNotEmpty() },
          rule = this@with.rule.takeIf { it.isNotEmpty() },
          dependent = this@with.dependent.takeIf { it.isNotEmpty() },
          documentation = this@with.documentation?.value,
          _documentation = this@with.documentation?.toElement(),
        )
      }
  }
}

@Serializable
internal data class StructureMapGroupRuleSourceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var context: KotlinString? = null,
  public var _context: Element? = null,
  public var min: Int? = null,
  public var _min: Element? = null,
  public var max: KotlinString? = null,
  public var _max: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var defaultValue: KotlinString? = null,
  public var _defaultValue: Element? = null,
  public var element: KotlinString? = null,
  public var _element: Element? = null,
  public var listMode: KotlinString? = null,
  public var _listMode: Element? = null,
  public var variable: KotlinString? = null,
  public var _variable: Element? = null,
  public var condition: KotlinString? = null,
  public var _condition: Element? = null,
  public var check: KotlinString? = null,
  public var _check: Element? = null,
  public var logMessage: KotlinString? = null,
  public var _logMessage: Element? = null,
) {
  public fun toModel(): StructureMap.Group.Rule.Source =
    StructureMap.Group.Rule.Source(
      id = this@StructureMapGroupRuleSourceSurrogate.id,
      extension = this@StructureMapGroupRuleSourceSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureMapGroupRuleSourceSurrogate.modifierExtension ?: listOf(),
      context =
        Id.of(
          this@StructureMapGroupRuleSourceSurrogate.context,
          this@StructureMapGroupRuleSourceSurrogate._context,
        )!!,
      min =
        Integer.of(
          this@StructureMapGroupRuleSourceSurrogate.min,
          this@StructureMapGroupRuleSourceSurrogate._min,
        ),
      max =
        R5String.of(
          this@StructureMapGroupRuleSourceSurrogate.max,
          this@StructureMapGroupRuleSourceSurrogate._max,
        ),
      type =
        R5String.of(
          this@StructureMapGroupRuleSourceSurrogate.type,
          this@StructureMapGroupRuleSourceSurrogate._type,
        ),
      defaultValue =
        R5String.of(
          this@StructureMapGroupRuleSourceSurrogate.defaultValue,
          this@StructureMapGroupRuleSourceSurrogate._defaultValue,
        ),
      element =
        R5String.of(
          this@StructureMapGroupRuleSourceSurrogate.element,
          this@StructureMapGroupRuleSourceSurrogate._element,
        ),
      listMode =
        this@StructureMapGroupRuleSourceSurrogate.listMode?.let {
          Enumeration.of(
            StructureMap.StructureMapSourceListMode.fromCode(it),
            this@StructureMapGroupRuleSourceSurrogate._listMode,
          )
        },
      variable =
        Id.of(
          this@StructureMapGroupRuleSourceSurrogate.variable,
          this@StructureMapGroupRuleSourceSurrogate._variable,
        ),
      condition =
        R5String.of(
          this@StructureMapGroupRuleSourceSurrogate.condition,
          this@StructureMapGroupRuleSourceSurrogate._condition,
        ),
      check =
        R5String.of(
          this@StructureMapGroupRuleSourceSurrogate.check,
          this@StructureMapGroupRuleSourceSurrogate._check,
        ),
      logMessage =
        R5String.of(
          this@StructureMapGroupRuleSourceSurrogate.logMessage,
          this@StructureMapGroupRuleSourceSurrogate._logMessage,
        ),
    )

  public companion object {
    public fun fromModel(
      model: StructureMap.Group.Rule.Source
    ): StructureMapGroupRuleSourceSurrogate =
      with(model) {
        StructureMapGroupRuleSourceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          context = this@with.context.value,
          _context = this@with.context.toElement(),
          min = this@with.min?.value,
          _min = this@with.min?.toElement(),
          max = this@with.max?.value,
          _max = this@with.max?.toElement(),
          type = this@with.type?.value,
          _type = this@with.type?.toElement(),
          defaultValue = this@with.defaultValue?.value,
          _defaultValue = this@with.defaultValue?.toElement(),
          element = this@with.element?.value,
          _element = this@with.element?.toElement(),
          listMode = this@with.listMode?.value?.getCode(),
          _listMode = this@with.listMode?.toElement(),
          variable = this@with.variable?.value,
          _variable = this@with.variable?.toElement(),
          condition = this@with.condition?.value,
          _condition = this@with.condition?.toElement(),
          check = this@with.check?.value,
          _check = this@with.check?.toElement(),
          logMessage = this@with.logMessage?.value,
          _logMessage = this@with.logMessage?.toElement(),
        )
      }
  }
}

@Serializable
internal data class StructureMapGroupRuleTargetSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var context: KotlinString? = null,
  public var _context: Element? = null,
  public var element: KotlinString? = null,
  public var _element: Element? = null,
  public var variable: KotlinString? = null,
  public var _variable: Element? = null,
  public var listMode: List<KotlinString?>? = null,
  public var _listMode: List<Element?>? = null,
  public var listRuleId: KotlinString? = null,
  public var _listRuleId: Element? = null,
  public var transform: KotlinString? = null,
  public var _transform: Element? = null,
  public var parameter: List<StructureMap.Group.Rule.Target.Parameter>? = null,
) {
  public fun toModel(): StructureMap.Group.Rule.Target =
    StructureMap.Group.Rule.Target(
      id = this@StructureMapGroupRuleTargetSurrogate.id,
      extension = this@StructureMapGroupRuleTargetSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureMapGroupRuleTargetSurrogate.modifierExtension ?: listOf(),
      context =
        R5String.of(
          this@StructureMapGroupRuleTargetSurrogate.context,
          this@StructureMapGroupRuleTargetSurrogate._context,
        ),
      element =
        R5String.of(
          this@StructureMapGroupRuleTargetSurrogate.element,
          this@StructureMapGroupRuleTargetSurrogate._element,
        ),
      variable =
        Id.of(
          this@StructureMapGroupRuleTargetSurrogate.variable,
          this@StructureMapGroupRuleTargetSurrogate._variable,
        ),
      listMode =
        if (
          this@StructureMapGroupRuleTargetSurrogate.listMode == null &&
            this@StructureMapGroupRuleTargetSurrogate._listMode == null
        ) {
          listOf()
        } else {
          (this@StructureMapGroupRuleTargetSurrogate.listMode
              ?: List(this@StructureMapGroupRuleTargetSurrogate._listMode!!.size) { null })
            .zip(
              this@StructureMapGroupRuleTargetSurrogate._listMode
                ?: List(this@StructureMapGroupRuleTargetSurrogate.listMode!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { StructureMap.StructureMapTargetListMode.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      listRuleId =
        Id.of(
          this@StructureMapGroupRuleTargetSurrogate.listRuleId,
          this@StructureMapGroupRuleTargetSurrogate._listRuleId,
        ),
      transform =
        this@StructureMapGroupRuleTargetSurrogate.transform?.let {
          Enumeration.of(
            StructureMap.StructureMapTransform.fromCode(it),
            this@StructureMapGroupRuleTargetSurrogate._transform,
          )
        },
      parameter = this@StructureMapGroupRuleTargetSurrogate.parameter ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: StructureMap.Group.Rule.Target
    ): StructureMapGroupRuleTargetSurrogate =
      with(model) {
        StructureMapGroupRuleTargetSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          context = this@with.context?.value,
          _context = this@with.context?.toElement(),
          element = this@with.element?.value,
          _element = this@with.element?.toElement(),
          variable = this@with.variable?.value,
          _variable = this@with.variable?.toElement(),
          listMode =
            this@with.listMode
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _listMode =
            this@with.listMode
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          listRuleId = this@with.listRuleId?.value,
          _listRuleId = this@with.listRuleId?.toElement(),
          transform = this@with.transform?.value?.getCode(),
          _transform = this@with.transform?.toElement(),
          parameter = this@with.parameter.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class StructureMapGroupRuleTargetParameterSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: StructureMap.Group.Rule.Target.Parameter.Value,
) {
  public fun toModel(): StructureMap.Group.Rule.Target.Parameter =
    StructureMap.Group.Rule.Target.Parameter(
      id = this@StructureMapGroupRuleTargetParameterSurrogate.id,
      extension = this@StructureMapGroupRuleTargetParameterSurrogate.extension ?: listOf(),
      modifierExtension =
        this@StructureMapGroupRuleTargetParameterSurrogate.modifierExtension ?: listOf(),
      `value` = this@StructureMapGroupRuleTargetParameterSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: StructureMap.Group.Rule.Target.Parameter
    ): StructureMapGroupRuleTargetParameterSurrogate =
      with(model) {
        StructureMapGroupRuleTargetParameterSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class StructureMapGroupRuleDependentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var parameter: List<StructureMap.Group.Rule.Target.Parameter>? = null,
) {
  public fun toModel(): StructureMap.Group.Rule.Dependent =
    StructureMap.Group.Rule.Dependent(
      id = this@StructureMapGroupRuleDependentSurrogate.id,
      extension = this@StructureMapGroupRuleDependentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@StructureMapGroupRuleDependentSurrogate.modifierExtension ?: listOf(),
      name =
        Id.of(
          this@StructureMapGroupRuleDependentSurrogate.name,
          this@StructureMapGroupRuleDependentSurrogate._name,
        )!!,
      parameter = this@StructureMapGroupRuleDependentSurrogate.parameter ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: StructureMap.Group.Rule.Dependent
    ): StructureMapGroupRuleDependentSurrogate =
      with(model) {
        StructureMapGroupRuleDependentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          parameter = this@with.parameter.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class StructureMapVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): StructureMap.VersionAlgorithm =
    StructureMap.VersionAlgorithm.from(
      R5String.of(
        this@StructureMapVersionAlgorithmSurrogate.versionAlgorithmString,
        this@StructureMapVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@StructureMapVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(
      model: StructureMap.VersionAlgorithm
    ): StructureMapVersionAlgorithmSurrogate =
      with(model) {
        StructureMapVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class StructureMapGroupRuleTargetParameterValueSurrogate(
  public var valueId: KotlinString? = null,
  public var _valueId: Element? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
) {
  public fun toModel(): StructureMap.Group.Rule.Target.Parameter.Value =
    StructureMap.Group.Rule.Target.Parameter.Value.from(
      Id.of(
        this@StructureMapGroupRuleTargetParameterValueSurrogate.valueId,
        this@StructureMapGroupRuleTargetParameterValueSurrogate._valueId,
      ),
      R5String.of(
        this@StructureMapGroupRuleTargetParameterValueSurrogate.valueString,
        this@StructureMapGroupRuleTargetParameterValueSurrogate._valueString,
      ),
      R5Boolean.of(
        this@StructureMapGroupRuleTargetParameterValueSurrogate.valueBoolean,
        this@StructureMapGroupRuleTargetParameterValueSurrogate._valueBoolean,
      ),
      Integer.of(
        this@StructureMapGroupRuleTargetParameterValueSurrogate.valueInteger,
        this@StructureMapGroupRuleTargetParameterValueSurrogate._valueInteger,
      ),
      Decimal.of(
        this@StructureMapGroupRuleTargetParameterValueSurrogate.valueDecimal,
        this@StructureMapGroupRuleTargetParameterValueSurrogate._valueDecimal,
      ),
      Date.of(
        FhirDate.fromString(this@StructureMapGroupRuleTargetParameterValueSurrogate.valueDate),
        this@StructureMapGroupRuleTargetParameterValueSurrogate._valueDate,
      ),
      Time.of(
        this@StructureMapGroupRuleTargetParameterValueSurrogate.valueTime,
        this@StructureMapGroupRuleTargetParameterValueSurrogate._valueTime,
      ),
      DateTime.of(
        FhirDateTime.fromString(
          this@StructureMapGroupRuleTargetParameterValueSurrogate.valueDateTime
        ),
        this@StructureMapGroupRuleTargetParameterValueSurrogate._valueDateTime,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: StructureMap.Group.Rule.Target.Parameter.Value
    ): StructureMapGroupRuleTargetParameterValueSurrogate =
      with(model) {
        StructureMapGroupRuleTargetParameterValueSurrogate(
          valueId = this@with.asId()?.value?.value,
          _valueId = this@with.asId()?.value?.toElement(),
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class StructureMapSurrogate(
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
  public var versionAlgorithm: StructureMap.VersionAlgorithm? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
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
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var copyrightLabel: KotlinString? = null,
  public var _copyrightLabel: Element? = null,
  public var structure: List<StructureMap.Structure>? = null,
  public var `import`: List<KotlinString?>? = null,
  public var _import: List<Element?>? = null,
  public var `const`: List<StructureMap.Const>? = null,
  public var group: List<StructureMap.Group>? = null,
) {
  public fun toModel(): StructureMap =
    StructureMap(
      id = this@StructureMapSurrogate.id,
      meta = this@StructureMapSurrogate.meta,
      implicitRules =
        Uri.of(this@StructureMapSurrogate.implicitRules, this@StructureMapSurrogate._implicitRules),
      language = Code.of(this@StructureMapSurrogate.language, this@StructureMapSurrogate._language),
      text = this@StructureMapSurrogate.text,
      contained = this@StructureMapSurrogate.contained ?: listOf(),
      extension = this@StructureMapSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureMapSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@StructureMapSurrogate.url, this@StructureMapSurrogate._url)!!,
      identifier = this@StructureMapSurrogate.identifier ?: listOf(),
      version =
        R5String.of(this@StructureMapSurrogate.version, this@StructureMapSurrogate._version),
      versionAlgorithm = this@StructureMapSurrogate.versionAlgorithm,
      name = R5String.of(this@StructureMapSurrogate.name, this@StructureMapSurrogate._name)!!,
      title = R5String.of(this@StructureMapSurrogate.title, this@StructureMapSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@StructureMapSurrogate.status!!),
          this@StructureMapSurrogate._status,
        ),
      experimental =
        R5Boolean.of(
          this@StructureMapSurrogate.experimental,
          this@StructureMapSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@StructureMapSurrogate.date),
          this@StructureMapSurrogate._date,
        ),
      publisher =
        R5String.of(this@StructureMapSurrogate.publisher, this@StructureMapSurrogate._publisher),
      contact = this@StructureMapSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@StructureMapSurrogate.description,
          this@StructureMapSurrogate._description,
        ),
      useContext = this@StructureMapSurrogate.useContext ?: listOf(),
      jurisdiction = this@StructureMapSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(this@StructureMapSurrogate.purpose, this@StructureMapSurrogate._purpose),
      copyright =
        Markdown.of(this@StructureMapSurrogate.copyright, this@StructureMapSurrogate._copyright),
      copyrightLabel =
        R5String.of(
          this@StructureMapSurrogate.copyrightLabel,
          this@StructureMapSurrogate._copyrightLabel,
        ),
      structure = this@StructureMapSurrogate.structure ?: listOf(),
      `import` =
        if (
          this@StructureMapSurrogate.`import` == null && this@StructureMapSurrogate._import == null
        ) {
          listOf()
        } else {
          (this@StructureMapSurrogate.`import`
              ?: List(this@StructureMapSurrogate._import!!.size) { null })
            .zip(
              this@StructureMapSurrogate._import
                ?: List(this@StructureMapSurrogate.`import`!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      `const` = this@StructureMapSurrogate.`const` ?: listOf(),
      group = this@StructureMapSurrogate.group ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: StructureMap): StructureMapSurrogate =
      with(model) {
        StructureMapSurrogate(
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
          versionAlgorithm = this@with.versionAlgorithm,
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
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
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          copyrightLabel = this@with.copyrightLabel?.value,
          _copyrightLabel = this@with.copyrightLabel?.toElement(),
          structure = this@with.structure.takeIf { it.isNotEmpty() },
          `import` =
            this@with.`import`.map { it.value }.toList().takeUnless { it.all { it == null } },
          _import =
            this@with.`import`
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          `const` = this@with.`const`.takeIf { it.isNotEmpty() },
          group = this@with.group.takeIf { it.isNotEmpty() },
        )
      }
  }
}

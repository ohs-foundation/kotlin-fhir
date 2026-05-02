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

import com.google.fhir.model.r4.Address
import com.google.fhir.model.r4.Age
import com.google.fhir.model.r4.Annotation
import com.google.fhir.model.r4.Attachment
import com.google.fhir.model.r4.Base64Binary
import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Canonical
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Coding
import com.google.fhir.model.r4.ContactDetail
import com.google.fhir.model.r4.ContactPoint
import com.google.fhir.model.r4.Contributor
import com.google.fhir.model.r4.Count
import com.google.fhir.model.r4.DataRequirement
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Decimal
import com.google.fhir.model.r4.Distance
import com.google.fhir.model.r4.Dosage
import com.google.fhir.model.r4.Duration
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.ElementDefinition
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Expression
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDate
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.HumanName
import com.google.fhir.model.r4.Id
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Instant
import com.google.fhir.model.r4.Integer
import com.google.fhir.model.r4.Markdown
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Money
import com.google.fhir.model.r4.Oid
import com.google.fhir.model.r4.ParameterDefinition
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.PositiveInt
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Range
import com.google.fhir.model.r4.Ratio
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.RelatedArtifact
import com.google.fhir.model.r4.SampledData
import com.google.fhir.model.r4.Signature
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Time
import com.google.fhir.model.r4.Timing
import com.google.fhir.model.r4.TriggerDefinition
import com.google.fhir.model.r4.UnsignedInt
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.Url
import com.google.fhir.model.r4.UsageContext
import com.google.fhir.model.r4.Uuid
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.BindingStrength
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
internal data class ElementDefinitionSlicingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var discriminator: List<ElementDefinition.Slicing.Discriminator>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var ordered: KotlinBoolean? = null,
  public var _ordered: Element? = null,
  public var rules: KotlinString? = null,
  public var _rules: Element? = null,
) {
  public fun toModel(): ElementDefinition.Slicing =
    ElementDefinition.Slicing(
      id = this@ElementDefinitionSlicingSurrogate.id,
      extension = this@ElementDefinitionSlicingSurrogate.extension ?: listOf(),
      discriminator = this@ElementDefinitionSlicingSurrogate.discriminator ?: listOf(),
      description =
        R4String.of(
          this@ElementDefinitionSlicingSurrogate.description,
          this@ElementDefinitionSlicingSurrogate._description,
        ),
      ordered =
        R4Boolean.of(
          this@ElementDefinitionSlicingSurrogate.ordered,
          this@ElementDefinitionSlicingSurrogate._ordered,
        ),
      rules =
        Enumeration.of(
          ElementDefinition.SlicingRules.fromCode(this@ElementDefinitionSlicingSurrogate.rules!!),
          this@ElementDefinitionSlicingSurrogate._rules,
        ),
    )

  public companion object {
    public fun fromModel(model: ElementDefinition.Slicing): ElementDefinitionSlicingSurrogate =
      with(model) {
        ElementDefinitionSlicingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          discriminator = this@with.discriminator.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          ordered = this@with.ordered?.value,
          _ordered = this@with.ordered?.toElement(),
          rules = this@with.rules.value?.getCode(),
          _rules = this@with.rules.toElement(),
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionSlicingDiscriminatorSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var path: KotlinString? = null,
  public var _path: Element? = null,
) {
  public fun toModel(): ElementDefinition.Slicing.Discriminator =
    ElementDefinition.Slicing.Discriminator(
      id = this@ElementDefinitionSlicingDiscriminatorSurrogate.id,
      extension = this@ElementDefinitionSlicingDiscriminatorSurrogate.extension ?: listOf(),
      type =
        Enumeration.of(
          ElementDefinition.DiscriminatorType.fromCode(
            this@ElementDefinitionSlicingDiscriminatorSurrogate.type!!
          ),
          this@ElementDefinitionSlicingDiscriminatorSurrogate._type,
        ),
      path =
        R4String.of(
          this@ElementDefinitionSlicingDiscriminatorSurrogate.path,
          this@ElementDefinitionSlicingDiscriminatorSurrogate._path,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: ElementDefinition.Slicing.Discriminator
    ): ElementDefinitionSlicingDiscriminatorSurrogate =
      with(model) {
        ElementDefinitionSlicingDiscriminatorSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          path = this@with.path.value,
          _path = this@with.path.toElement(),
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionBaseSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var path: KotlinString? = null,
  public var _path: Element? = null,
  public var min: Int? = null,
  public var _min: Element? = null,
  public var max: KotlinString? = null,
  public var _max: Element? = null,
) {
  public fun toModel(): ElementDefinition.Base =
    ElementDefinition.Base(
      id = this@ElementDefinitionBaseSurrogate.id,
      extension = this@ElementDefinitionBaseSurrogate.extension ?: listOf(),
      path =
        R4String.of(
          this@ElementDefinitionBaseSurrogate.path,
          this@ElementDefinitionBaseSurrogate._path,
        )!!,
      min =
        UnsignedInt.of(
          this@ElementDefinitionBaseSurrogate.min,
          this@ElementDefinitionBaseSurrogate._min,
        )!!,
      max =
        R4String.of(
          this@ElementDefinitionBaseSurrogate.max,
          this@ElementDefinitionBaseSurrogate._max,
        )!!,
    )

  public companion object {
    public fun fromModel(model: ElementDefinition.Base): ElementDefinitionBaseSurrogate =
      with(model) {
        ElementDefinitionBaseSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          path = this@with.path.value,
          _path = this@with.path.toElement(),
          min = this@with.min.value,
          _min = this@with.min.toElement(),
          max = this@with.max.value,
          _max = this@with.max.toElement(),
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionTypeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var profile: List<KotlinString?>? = null,
  public var _profile: List<Element?>? = null,
  public var targetProfile: List<KotlinString?>? = null,
  public var _targetProfile: List<Element?>? = null,
  public var aggregation: List<KotlinString?>? = null,
  public var _aggregation: List<Element?>? = null,
  public var versioning: KotlinString? = null,
  public var _versioning: Element? = null,
) {
  public fun toModel(): ElementDefinition.Type =
    ElementDefinition.Type(
      id = this@ElementDefinitionTypeSurrogate.id,
      extension = this@ElementDefinitionTypeSurrogate.extension ?: listOf(),
      code =
        Uri.of(
          this@ElementDefinitionTypeSurrogate.code,
          this@ElementDefinitionTypeSurrogate._code,
        )!!,
      profile =
        if (
          this@ElementDefinitionTypeSurrogate.profile == null &&
            this@ElementDefinitionTypeSurrogate._profile == null
        ) {
          listOf()
        } else {
          (this@ElementDefinitionTypeSurrogate.profile
              ?: List(this@ElementDefinitionTypeSurrogate._profile!!.size) { null })
            .zip(
              this@ElementDefinitionTypeSurrogate._profile
                ?: List(this@ElementDefinitionTypeSurrogate.profile!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      targetProfile =
        if (
          this@ElementDefinitionTypeSurrogate.targetProfile == null &&
            this@ElementDefinitionTypeSurrogate._targetProfile == null
        ) {
          listOf()
        } else {
          (this@ElementDefinitionTypeSurrogate.targetProfile
              ?: List(this@ElementDefinitionTypeSurrogate._targetProfile!!.size) { null })
            .zip(
              this@ElementDefinitionTypeSurrogate._targetProfile
                ?: List(this@ElementDefinitionTypeSurrogate.targetProfile!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      aggregation =
        if (
          this@ElementDefinitionTypeSurrogate.aggregation == null &&
            this@ElementDefinitionTypeSurrogate._aggregation == null
        ) {
          listOf()
        } else {
          (this@ElementDefinitionTypeSurrogate.aggregation
              ?: List(this@ElementDefinitionTypeSurrogate._aggregation!!.size) { null })
            .zip(
              this@ElementDefinitionTypeSurrogate._aggregation
                ?: List(this@ElementDefinitionTypeSurrogate.aggregation!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { ElementDefinition.AggregationMode.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      versioning =
        this@ElementDefinitionTypeSurrogate.versioning?.let {
          Enumeration.of(
            ElementDefinition.ReferenceVersionRules.fromCode(it),
            this@ElementDefinitionTypeSurrogate._versioning,
          )
        },
    )

  public companion object {
    public fun fromModel(model: ElementDefinition.Type): ElementDefinitionTypeSurrogate =
      with(model) {
        ElementDefinitionTypeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          profile =
            this@with.profile.map { it.value }.toList().takeUnless { it.all { it == null } },
          _profile =
            this@with.profile
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          targetProfile =
            this@with.targetProfile.map { it.value }.toList().takeUnless { it.all { it == null } },
          _targetProfile =
            this@with.targetProfile
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          aggregation =
            this@with.aggregation
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _aggregation =
            this@with.aggregation
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          versioning = this@with.versioning?.value?.getCode(),
          _versioning = this@with.versioning?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionExampleSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var label: KotlinString? = null,
  public var _label: Element? = null,
  public var `value`: ElementDefinition.Example.Value,
) {
  public fun toModel(): ElementDefinition.Example =
    ElementDefinition.Example(
      id = this@ElementDefinitionExampleSurrogate.id,
      extension = this@ElementDefinitionExampleSurrogate.extension ?: listOf(),
      label =
        R4String.of(
          this@ElementDefinitionExampleSurrogate.label,
          this@ElementDefinitionExampleSurrogate._label,
        )!!,
      `value` = this@ElementDefinitionExampleSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: ElementDefinition.Example): ElementDefinitionExampleSurrogate =
      with(model) {
        ElementDefinitionExampleSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          label = this@with.label.value,
          _label = this@with.label.toElement(),
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionConstraintSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var key: KotlinString? = null,
  public var _key: Element? = null,
  public var requirements: KotlinString? = null,
  public var _requirements: Element? = null,
  public var severity: KotlinString? = null,
  public var _severity: Element? = null,
  public var human: KotlinString? = null,
  public var _human: Element? = null,
  public var expression: KotlinString? = null,
  public var _expression: Element? = null,
  public var xpath: KotlinString? = null,
  public var _xpath: Element? = null,
  public var source: KotlinString? = null,
  public var _source: Element? = null,
) {
  public fun toModel(): ElementDefinition.Constraint =
    ElementDefinition.Constraint(
      id = this@ElementDefinitionConstraintSurrogate.id,
      extension = this@ElementDefinitionConstraintSurrogate.extension ?: listOf(),
      key =
        Id.of(
          this@ElementDefinitionConstraintSurrogate.key,
          this@ElementDefinitionConstraintSurrogate._key,
        )!!,
      requirements =
        R4String.of(
          this@ElementDefinitionConstraintSurrogate.requirements,
          this@ElementDefinitionConstraintSurrogate._requirements,
        ),
      severity =
        Enumeration.of(
          ElementDefinition.ConstraintSeverity.fromCode(
            this@ElementDefinitionConstraintSurrogate.severity!!
          ),
          this@ElementDefinitionConstraintSurrogate._severity,
        ),
      human =
        R4String.of(
          this@ElementDefinitionConstraintSurrogate.human,
          this@ElementDefinitionConstraintSurrogate._human,
        )!!,
      expression =
        R4String.of(
          this@ElementDefinitionConstraintSurrogate.expression,
          this@ElementDefinitionConstraintSurrogate._expression,
        ),
      xpath =
        R4String.of(
          this@ElementDefinitionConstraintSurrogate.xpath,
          this@ElementDefinitionConstraintSurrogate._xpath,
        ),
      source =
        Canonical.of(
          this@ElementDefinitionConstraintSurrogate.source,
          this@ElementDefinitionConstraintSurrogate._source,
        ),
    )

  public companion object {
    public fun fromModel(
      model: ElementDefinition.Constraint
    ): ElementDefinitionConstraintSurrogate =
      with(model) {
        ElementDefinitionConstraintSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          key = this@with.key.value,
          _key = this@with.key.toElement(),
          requirements = this@with.requirements?.value,
          _requirements = this@with.requirements?.toElement(),
          severity = this@with.severity.value?.getCode(),
          _severity = this@with.severity.toElement(),
          human = this@with.human.value,
          _human = this@with.human.toElement(),
          expression = this@with.expression?.value,
          _expression = this@with.expression?.toElement(),
          xpath = this@with.xpath?.value,
          _xpath = this@with.xpath?.toElement(),
          source = this@with.source?.value,
          _source = this@with.source?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionBindingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var strength: KotlinString? = null,
  public var _strength: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var valueSet: KotlinString? = null,
  public var _valueSet: Element? = null,
) {
  public fun toModel(): ElementDefinition.Binding =
    ElementDefinition.Binding(
      id = this@ElementDefinitionBindingSurrogate.id,
      extension = this@ElementDefinitionBindingSurrogate.extension ?: listOf(),
      strength =
        Enumeration.of(
          BindingStrength.fromCode(this@ElementDefinitionBindingSurrogate.strength!!),
          this@ElementDefinitionBindingSurrogate._strength,
        ),
      description =
        R4String.of(
          this@ElementDefinitionBindingSurrogate.description,
          this@ElementDefinitionBindingSurrogate._description,
        ),
      valueSet =
        Canonical.of(
          this@ElementDefinitionBindingSurrogate.valueSet,
          this@ElementDefinitionBindingSurrogate._valueSet,
        ),
    )

  public companion object {
    public fun fromModel(model: ElementDefinition.Binding): ElementDefinitionBindingSurrogate =
      with(model) {
        ElementDefinitionBindingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          strength = this@with.strength.value?.getCode(),
          _strength = this@with.strength.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          valueSet = this@with.valueSet?.value,
          _valueSet = this@with.valueSet?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionMappingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var identity: KotlinString? = null,
  public var _identity: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var map: KotlinString? = null,
  public var _map: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
) {
  public fun toModel(): ElementDefinition.Mapping =
    ElementDefinition.Mapping(
      id = this@ElementDefinitionMappingSurrogate.id,
      extension = this@ElementDefinitionMappingSurrogate.extension ?: listOf(),
      identity =
        Id.of(
          this@ElementDefinitionMappingSurrogate.identity,
          this@ElementDefinitionMappingSurrogate._identity,
        )!!,
      language =
        Code.of(
          this@ElementDefinitionMappingSurrogate.language,
          this@ElementDefinitionMappingSurrogate._language,
        ),
      map =
        R4String.of(
          this@ElementDefinitionMappingSurrogate.map,
          this@ElementDefinitionMappingSurrogate._map,
        )!!,
      comment =
        R4String.of(
          this@ElementDefinitionMappingSurrogate.comment,
          this@ElementDefinitionMappingSurrogate._comment,
        ),
    )

  public companion object {
    public fun fromModel(model: ElementDefinition.Mapping): ElementDefinitionMappingSurrogate =
      with(model) {
        ElementDefinitionMappingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          identity = this@with.identity.value,
          _identity = this@with.identity.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          map = this@with.map.value,
          _map = this@with.map.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionDefaultValueSurrogate(
  public var defaultValueBase64Binary: KotlinString? = null,
  public var _defaultValueBase64Binary: Element? = null,
  public var defaultValueBoolean: KotlinBoolean? = null,
  public var _defaultValueBoolean: Element? = null,
  public var defaultValueCanonical: KotlinString? = null,
  public var _defaultValueCanonical: Element? = null,
  public var defaultValueCode: KotlinString? = null,
  public var _defaultValueCode: Element? = null,
  public var defaultValueDate: KotlinString? = null,
  public var _defaultValueDate: Element? = null,
  public var defaultValueDateTime: KotlinString? = null,
  public var _defaultValueDateTime: Element? = null,
  public var defaultValueDecimal: Double? = null,
  public var _defaultValueDecimal: Element? = null,
  public var defaultValueId: KotlinString? = null,
  public var _defaultValueId: Element? = null,
  public var defaultValueInstant: KotlinString? = null,
  public var _defaultValueInstant: Element? = null,
  public var defaultValueInteger: Int? = null,
  public var _defaultValueInteger: Element? = null,
  public var defaultValueMarkdown: KotlinString? = null,
  public var _defaultValueMarkdown: Element? = null,
  public var defaultValueOid: KotlinString? = null,
  public var _defaultValueOid: Element? = null,
  public var defaultValuePositiveInt: Int? = null,
  public var _defaultValuePositiveInt: Element? = null,
  public var defaultValueString: KotlinString? = null,
  public var _defaultValueString: Element? = null,
  public var defaultValueTime: LocalTime? = null,
  public var _defaultValueTime: Element? = null,
  public var defaultValueUnsignedInt: Int? = null,
  public var _defaultValueUnsignedInt: Element? = null,
  public var defaultValueUri: KotlinString? = null,
  public var _defaultValueUri: Element? = null,
  public var defaultValueUrl: KotlinString? = null,
  public var _defaultValueUrl: Element? = null,
  public var defaultValueUuid: KotlinString? = null,
  public var _defaultValueUuid: Element? = null,
  public var defaultValueAddress: Address? = null,
  public var defaultValueAge: Age? = null,
  public var defaultValueAnnotation: Annotation? = null,
  public var defaultValueAttachment: Attachment? = null,
  public var defaultValueCodeableConcept: CodeableConcept? = null,
  public var defaultValueCoding: Coding? = null,
  public var defaultValueContactPoint: ContactPoint? = null,
  public var defaultValueCount: Count? = null,
  public var defaultValueDistance: Distance? = null,
  public var defaultValueDuration: Duration? = null,
  public var defaultValueHumanName: HumanName? = null,
  public var defaultValueIdentifier: Identifier? = null,
  public var defaultValueMoney: Money? = null,
  public var defaultValuePeriod: Period? = null,
  public var defaultValueQuantity: Quantity? = null,
  public var defaultValueRange: Range? = null,
  public var defaultValueRatio: Ratio? = null,
  public var defaultValueReference: Reference? = null,
  public var defaultValueSampledData: SampledData? = null,
  public var defaultValueSignature: Signature? = null,
  public var defaultValueTiming: Timing? = null,
  public var defaultValueContactDetail: ContactDetail? = null,
  public var defaultValueContributor: Contributor? = null,
  public var defaultValueDataRequirement: DataRequirement? = null,
  public var defaultValueExpression: Expression? = null,
  public var defaultValueParameterDefinition: ParameterDefinition? = null,
  public var defaultValueRelatedArtifact: RelatedArtifact? = null,
  public var defaultValueTriggerDefinition: TriggerDefinition? = null,
  public var defaultValueUsageContext: UsageContext? = null,
  public var defaultValueDosage: Dosage? = null,
  public var defaultValueMeta: Meta? = null,
) {
  public fun toModel(): ElementDefinition.DefaultValue =
    ElementDefinition.DefaultValue.from(
      Base64Binary.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueBase64Binary,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueBase64Binary,
      ),
      R4Boolean.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueBoolean,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueBoolean,
      ),
      Canonical.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueCanonical,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueCanonical,
      ),
      Code.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueCode,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueCode,
      ),
      Date.of(
        FhirDate.fromString(this@ElementDefinitionDefaultValueSurrogate.defaultValueDate),
        this@ElementDefinitionDefaultValueSurrogate._defaultValueDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ElementDefinitionDefaultValueSurrogate.defaultValueDateTime),
        this@ElementDefinitionDefaultValueSurrogate._defaultValueDateTime,
      ),
      Decimal.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueDecimal,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueDecimal,
      ),
      Id.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueId,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueId,
      ),
      Instant.of(
        FhirDateTime.fromString(this@ElementDefinitionDefaultValueSurrogate.defaultValueInstant),
        this@ElementDefinitionDefaultValueSurrogate._defaultValueInstant,
      ),
      Integer.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueInteger,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueInteger,
      ),
      Markdown.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueMarkdown,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueMarkdown,
      ),
      Oid.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueOid,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueOid,
      ),
      PositiveInt.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValuePositiveInt,
        this@ElementDefinitionDefaultValueSurrogate._defaultValuePositiveInt,
      ),
      R4String.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueString,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueString,
      ),
      Time.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueTime,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueTime,
      ),
      UnsignedInt.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueUnsignedInt,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueUnsignedInt,
      ),
      Uri.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueUri,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueUri,
      ),
      Url.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueUrl,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueUrl,
      ),
      Uuid.of(
        this@ElementDefinitionDefaultValueSurrogate.defaultValueUuid,
        this@ElementDefinitionDefaultValueSurrogate._defaultValueUuid,
      ),
      this@ElementDefinitionDefaultValueSurrogate.defaultValueAddress,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueAge,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueAnnotation,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueAttachment,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueCodeableConcept,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueCoding,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueContactPoint,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueCount,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueDistance,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueDuration,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueHumanName,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueIdentifier,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueMoney,
      this@ElementDefinitionDefaultValueSurrogate.defaultValuePeriod,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueQuantity,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueRange,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueRatio,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueReference,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueSampledData,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueSignature,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueTiming,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueContactDetail,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueContributor,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueDataRequirement,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueExpression,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueParameterDefinition,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueRelatedArtifact,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueTriggerDefinition,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueUsageContext,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueDosage,
      this@ElementDefinitionDefaultValueSurrogate.defaultValueMeta,
    )!!

  public companion object {
    public fun fromModel(
      model: ElementDefinition.DefaultValue
    ): ElementDefinitionDefaultValueSurrogate =
      with(model) {
        ElementDefinitionDefaultValueSurrogate(
          defaultValueBase64Binary = this@with.asBase64Binary()?.value?.value,
          _defaultValueBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
          defaultValueBoolean = this@with.asBoolean()?.value?.value,
          _defaultValueBoolean = this@with.asBoolean()?.value?.toElement(),
          defaultValueCanonical = this@with.asCanonical()?.value?.value,
          _defaultValueCanonical = this@with.asCanonical()?.value?.toElement(),
          defaultValueCode = this@with.asCode()?.value?.value,
          _defaultValueCode = this@with.asCode()?.value?.toElement(),
          defaultValueDate = this@with.asDate()?.value?.value?.toString(),
          _defaultValueDate = this@with.asDate()?.value?.toElement(),
          defaultValueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _defaultValueDateTime = this@with.asDateTime()?.value?.toElement(),
          defaultValueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _defaultValueDecimal = this@with.asDecimal()?.value?.toElement(),
          defaultValueId = this@with.asId()?.value?.value,
          _defaultValueId = this@with.asId()?.value?.toElement(),
          defaultValueInstant = this@with.asInstant()?.value?.value?.toString(),
          _defaultValueInstant = this@with.asInstant()?.value?.toElement(),
          defaultValueInteger = this@with.asInteger()?.value?.value,
          _defaultValueInteger = this@with.asInteger()?.value?.toElement(),
          defaultValueMarkdown = this@with.asMarkdown()?.value?.value,
          _defaultValueMarkdown = this@with.asMarkdown()?.value?.toElement(),
          defaultValueOid = this@with.asOid()?.value?.value,
          _defaultValueOid = this@with.asOid()?.value?.toElement(),
          defaultValuePositiveInt = this@with.asPositiveInt()?.value?.value,
          _defaultValuePositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          defaultValueString = this@with.asString()?.value?.value,
          _defaultValueString = this@with.asString()?.value?.toElement(),
          defaultValueTime = this@with.asTime()?.value?.value,
          _defaultValueTime = this@with.asTime()?.value?.toElement(),
          defaultValueUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _defaultValueUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          defaultValueUri = this@with.asUri()?.value?.value,
          _defaultValueUri = this@with.asUri()?.value?.toElement(),
          defaultValueUrl = this@with.asUrl()?.value?.value,
          _defaultValueUrl = this@with.asUrl()?.value?.toElement(),
          defaultValueUuid = this@with.asUuid()?.value?.value,
          _defaultValueUuid = this@with.asUuid()?.value?.toElement(),
          defaultValueAddress = this@with.asAddress()?.value,
          defaultValueAge = this@with.asAge()?.value,
          defaultValueAnnotation = this@with.asAnnotation()?.value,
          defaultValueAttachment = this@with.asAttachment()?.value,
          defaultValueCodeableConcept = this@with.asCodeableConcept()?.value,
          defaultValueCoding = this@with.asCoding()?.value,
          defaultValueContactPoint = this@with.asContactPoint()?.value,
          defaultValueCount = this@with.asCount()?.value,
          defaultValueDistance = this@with.asDistance()?.value,
          defaultValueDuration = this@with.asDuration()?.value,
          defaultValueHumanName = this@with.asHumanName()?.value,
          defaultValueIdentifier = this@with.asIdentifier()?.value,
          defaultValueMoney = this@with.asMoney()?.value,
          defaultValuePeriod = this@with.asPeriod()?.value,
          defaultValueQuantity = this@with.asQuantity()?.value,
          defaultValueRange = this@with.asRange()?.value,
          defaultValueRatio = this@with.asRatio()?.value,
          defaultValueReference = this@with.asReference()?.value,
          defaultValueSampledData = this@with.asSampledData()?.value,
          defaultValueSignature = this@with.asSignature()?.value,
          defaultValueTiming = this@with.asTiming()?.value,
          defaultValueContactDetail = this@with.asContactDetail()?.value,
          defaultValueContributor = this@with.asContributor()?.value,
          defaultValueDataRequirement = this@with.asDataRequirement()?.value,
          defaultValueExpression = this@with.asExpression()?.value,
          defaultValueParameterDefinition = this@with.asParameterDefinition()?.value,
          defaultValueRelatedArtifact = this@with.asRelatedArtifact()?.value,
          defaultValueTriggerDefinition = this@with.asTriggerDefinition()?.value,
          defaultValueUsageContext = this@with.asUsageContext()?.value,
          defaultValueDosage = this@with.asDosage()?.value,
          defaultValueMeta = this@with.asMeta()?.value,
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionFixedSurrogate(
  public var fixedBase64Binary: KotlinString? = null,
  public var _fixedBase64Binary: Element? = null,
  public var fixedBoolean: KotlinBoolean? = null,
  public var _fixedBoolean: Element? = null,
  public var fixedCanonical: KotlinString? = null,
  public var _fixedCanonical: Element? = null,
  public var fixedCode: KotlinString? = null,
  public var _fixedCode: Element? = null,
  public var fixedDate: KotlinString? = null,
  public var _fixedDate: Element? = null,
  public var fixedDateTime: KotlinString? = null,
  public var _fixedDateTime: Element? = null,
  public var fixedDecimal: Double? = null,
  public var _fixedDecimal: Element? = null,
  public var fixedId: KotlinString? = null,
  public var _fixedId: Element? = null,
  public var fixedInstant: KotlinString? = null,
  public var _fixedInstant: Element? = null,
  public var fixedInteger: Int? = null,
  public var _fixedInteger: Element? = null,
  public var fixedMarkdown: KotlinString? = null,
  public var _fixedMarkdown: Element? = null,
  public var fixedOid: KotlinString? = null,
  public var _fixedOid: Element? = null,
  public var fixedPositiveInt: Int? = null,
  public var _fixedPositiveInt: Element? = null,
  public var fixedString: KotlinString? = null,
  public var _fixedString: Element? = null,
  public var fixedTime: LocalTime? = null,
  public var _fixedTime: Element? = null,
  public var fixedUnsignedInt: Int? = null,
  public var _fixedUnsignedInt: Element? = null,
  public var fixedUri: KotlinString? = null,
  public var _fixedUri: Element? = null,
  public var fixedUrl: KotlinString? = null,
  public var _fixedUrl: Element? = null,
  public var fixedUuid: KotlinString? = null,
  public var _fixedUuid: Element? = null,
  public var fixedAddress: Address? = null,
  public var fixedAge: Age? = null,
  public var fixedAnnotation: Annotation? = null,
  public var fixedAttachment: Attachment? = null,
  public var fixedCodeableConcept: CodeableConcept? = null,
  public var fixedCoding: Coding? = null,
  public var fixedContactPoint: ContactPoint? = null,
  public var fixedCount: Count? = null,
  public var fixedDistance: Distance? = null,
  public var fixedDuration: Duration? = null,
  public var fixedHumanName: HumanName? = null,
  public var fixedIdentifier: Identifier? = null,
  public var fixedMoney: Money? = null,
  public var fixedPeriod: Period? = null,
  public var fixedQuantity: Quantity? = null,
  public var fixedRange: Range? = null,
  public var fixedRatio: Ratio? = null,
  public var fixedReference: Reference? = null,
  public var fixedSampledData: SampledData? = null,
  public var fixedSignature: Signature? = null,
  public var fixedTiming: Timing? = null,
  public var fixedContactDetail: ContactDetail? = null,
  public var fixedContributor: Contributor? = null,
  public var fixedDataRequirement: DataRequirement? = null,
  public var fixedExpression: Expression? = null,
  public var fixedParameterDefinition: ParameterDefinition? = null,
  public var fixedRelatedArtifact: RelatedArtifact? = null,
  public var fixedTriggerDefinition: TriggerDefinition? = null,
  public var fixedUsageContext: UsageContext? = null,
  public var fixedDosage: Dosage? = null,
  public var fixedMeta: Meta? = null,
) {
  public fun toModel(): ElementDefinition.Fixed =
    ElementDefinition.Fixed.from(
      Base64Binary.of(
        this@ElementDefinitionFixedSurrogate.fixedBase64Binary,
        this@ElementDefinitionFixedSurrogate._fixedBase64Binary,
      ),
      R4Boolean.of(
        this@ElementDefinitionFixedSurrogate.fixedBoolean,
        this@ElementDefinitionFixedSurrogate._fixedBoolean,
      ),
      Canonical.of(
        this@ElementDefinitionFixedSurrogate.fixedCanonical,
        this@ElementDefinitionFixedSurrogate._fixedCanonical,
      ),
      Code.of(
        this@ElementDefinitionFixedSurrogate.fixedCode,
        this@ElementDefinitionFixedSurrogate._fixedCode,
      ),
      Date.of(
        FhirDate.fromString(this@ElementDefinitionFixedSurrogate.fixedDate),
        this@ElementDefinitionFixedSurrogate._fixedDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ElementDefinitionFixedSurrogate.fixedDateTime),
        this@ElementDefinitionFixedSurrogate._fixedDateTime,
      ),
      Decimal.of(
        this@ElementDefinitionFixedSurrogate.fixedDecimal,
        this@ElementDefinitionFixedSurrogate._fixedDecimal,
      ),
      Id.of(
        this@ElementDefinitionFixedSurrogate.fixedId,
        this@ElementDefinitionFixedSurrogate._fixedId,
      ),
      Instant.of(
        FhirDateTime.fromString(this@ElementDefinitionFixedSurrogate.fixedInstant),
        this@ElementDefinitionFixedSurrogate._fixedInstant,
      ),
      Integer.of(
        this@ElementDefinitionFixedSurrogate.fixedInteger,
        this@ElementDefinitionFixedSurrogate._fixedInteger,
      ),
      Markdown.of(
        this@ElementDefinitionFixedSurrogate.fixedMarkdown,
        this@ElementDefinitionFixedSurrogate._fixedMarkdown,
      ),
      Oid.of(
        this@ElementDefinitionFixedSurrogate.fixedOid,
        this@ElementDefinitionFixedSurrogate._fixedOid,
      ),
      PositiveInt.of(
        this@ElementDefinitionFixedSurrogate.fixedPositiveInt,
        this@ElementDefinitionFixedSurrogate._fixedPositiveInt,
      ),
      R4String.of(
        this@ElementDefinitionFixedSurrogate.fixedString,
        this@ElementDefinitionFixedSurrogate._fixedString,
      ),
      Time.of(
        this@ElementDefinitionFixedSurrogate.fixedTime,
        this@ElementDefinitionFixedSurrogate._fixedTime,
      ),
      UnsignedInt.of(
        this@ElementDefinitionFixedSurrogate.fixedUnsignedInt,
        this@ElementDefinitionFixedSurrogate._fixedUnsignedInt,
      ),
      Uri.of(
        this@ElementDefinitionFixedSurrogate.fixedUri,
        this@ElementDefinitionFixedSurrogate._fixedUri,
      ),
      Url.of(
        this@ElementDefinitionFixedSurrogate.fixedUrl,
        this@ElementDefinitionFixedSurrogate._fixedUrl,
      ),
      Uuid.of(
        this@ElementDefinitionFixedSurrogate.fixedUuid,
        this@ElementDefinitionFixedSurrogate._fixedUuid,
      ),
      this@ElementDefinitionFixedSurrogate.fixedAddress,
      this@ElementDefinitionFixedSurrogate.fixedAge,
      this@ElementDefinitionFixedSurrogate.fixedAnnotation,
      this@ElementDefinitionFixedSurrogate.fixedAttachment,
      this@ElementDefinitionFixedSurrogate.fixedCodeableConcept,
      this@ElementDefinitionFixedSurrogate.fixedCoding,
      this@ElementDefinitionFixedSurrogate.fixedContactPoint,
      this@ElementDefinitionFixedSurrogate.fixedCount,
      this@ElementDefinitionFixedSurrogate.fixedDistance,
      this@ElementDefinitionFixedSurrogate.fixedDuration,
      this@ElementDefinitionFixedSurrogate.fixedHumanName,
      this@ElementDefinitionFixedSurrogate.fixedIdentifier,
      this@ElementDefinitionFixedSurrogate.fixedMoney,
      this@ElementDefinitionFixedSurrogate.fixedPeriod,
      this@ElementDefinitionFixedSurrogate.fixedQuantity,
      this@ElementDefinitionFixedSurrogate.fixedRange,
      this@ElementDefinitionFixedSurrogate.fixedRatio,
      this@ElementDefinitionFixedSurrogate.fixedReference,
      this@ElementDefinitionFixedSurrogate.fixedSampledData,
      this@ElementDefinitionFixedSurrogate.fixedSignature,
      this@ElementDefinitionFixedSurrogate.fixedTiming,
      this@ElementDefinitionFixedSurrogate.fixedContactDetail,
      this@ElementDefinitionFixedSurrogate.fixedContributor,
      this@ElementDefinitionFixedSurrogate.fixedDataRequirement,
      this@ElementDefinitionFixedSurrogate.fixedExpression,
      this@ElementDefinitionFixedSurrogate.fixedParameterDefinition,
      this@ElementDefinitionFixedSurrogate.fixedRelatedArtifact,
      this@ElementDefinitionFixedSurrogate.fixedTriggerDefinition,
      this@ElementDefinitionFixedSurrogate.fixedUsageContext,
      this@ElementDefinitionFixedSurrogate.fixedDosage,
      this@ElementDefinitionFixedSurrogate.fixedMeta,
    )!!

  public companion object {
    public fun fromModel(model: ElementDefinition.Fixed): ElementDefinitionFixedSurrogate =
      with(model) {
        ElementDefinitionFixedSurrogate(
          fixedBase64Binary = this@with.asBase64Binary()?.value?.value,
          _fixedBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
          fixedBoolean = this@with.asBoolean()?.value?.value,
          _fixedBoolean = this@with.asBoolean()?.value?.toElement(),
          fixedCanonical = this@with.asCanonical()?.value?.value,
          _fixedCanonical = this@with.asCanonical()?.value?.toElement(),
          fixedCode = this@with.asCode()?.value?.value,
          _fixedCode = this@with.asCode()?.value?.toElement(),
          fixedDate = this@with.asDate()?.value?.value?.toString(),
          _fixedDate = this@with.asDate()?.value?.toElement(),
          fixedDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _fixedDateTime = this@with.asDateTime()?.value?.toElement(),
          fixedDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _fixedDecimal = this@with.asDecimal()?.value?.toElement(),
          fixedId = this@with.asId()?.value?.value,
          _fixedId = this@with.asId()?.value?.toElement(),
          fixedInstant = this@with.asInstant()?.value?.value?.toString(),
          _fixedInstant = this@with.asInstant()?.value?.toElement(),
          fixedInteger = this@with.asInteger()?.value?.value,
          _fixedInteger = this@with.asInteger()?.value?.toElement(),
          fixedMarkdown = this@with.asMarkdown()?.value?.value,
          _fixedMarkdown = this@with.asMarkdown()?.value?.toElement(),
          fixedOid = this@with.asOid()?.value?.value,
          _fixedOid = this@with.asOid()?.value?.toElement(),
          fixedPositiveInt = this@with.asPositiveInt()?.value?.value,
          _fixedPositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          fixedString = this@with.asString()?.value?.value,
          _fixedString = this@with.asString()?.value?.toElement(),
          fixedTime = this@with.asTime()?.value?.value,
          _fixedTime = this@with.asTime()?.value?.toElement(),
          fixedUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _fixedUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          fixedUri = this@with.asUri()?.value?.value,
          _fixedUri = this@with.asUri()?.value?.toElement(),
          fixedUrl = this@with.asUrl()?.value?.value,
          _fixedUrl = this@with.asUrl()?.value?.toElement(),
          fixedUuid = this@with.asUuid()?.value?.value,
          _fixedUuid = this@with.asUuid()?.value?.toElement(),
          fixedAddress = this@with.asAddress()?.value,
          fixedAge = this@with.asAge()?.value,
          fixedAnnotation = this@with.asAnnotation()?.value,
          fixedAttachment = this@with.asAttachment()?.value,
          fixedCodeableConcept = this@with.asCodeableConcept()?.value,
          fixedCoding = this@with.asCoding()?.value,
          fixedContactPoint = this@with.asContactPoint()?.value,
          fixedCount = this@with.asCount()?.value,
          fixedDistance = this@with.asDistance()?.value,
          fixedDuration = this@with.asDuration()?.value,
          fixedHumanName = this@with.asHumanName()?.value,
          fixedIdentifier = this@with.asIdentifier()?.value,
          fixedMoney = this@with.asMoney()?.value,
          fixedPeriod = this@with.asPeriod()?.value,
          fixedQuantity = this@with.asQuantity()?.value,
          fixedRange = this@with.asRange()?.value,
          fixedRatio = this@with.asRatio()?.value,
          fixedReference = this@with.asReference()?.value,
          fixedSampledData = this@with.asSampledData()?.value,
          fixedSignature = this@with.asSignature()?.value,
          fixedTiming = this@with.asTiming()?.value,
          fixedContactDetail = this@with.asContactDetail()?.value,
          fixedContributor = this@with.asContributor()?.value,
          fixedDataRequirement = this@with.asDataRequirement()?.value,
          fixedExpression = this@with.asExpression()?.value,
          fixedParameterDefinition = this@with.asParameterDefinition()?.value,
          fixedRelatedArtifact = this@with.asRelatedArtifact()?.value,
          fixedTriggerDefinition = this@with.asTriggerDefinition()?.value,
          fixedUsageContext = this@with.asUsageContext()?.value,
          fixedDosage = this@with.asDosage()?.value,
          fixedMeta = this@with.asMeta()?.value,
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionPatternSurrogate(
  public var patternBase64Binary: KotlinString? = null,
  public var _patternBase64Binary: Element? = null,
  public var patternBoolean: KotlinBoolean? = null,
  public var _patternBoolean: Element? = null,
  public var patternCanonical: KotlinString? = null,
  public var _patternCanonical: Element? = null,
  public var patternCode: KotlinString? = null,
  public var _patternCode: Element? = null,
  public var patternDate: KotlinString? = null,
  public var _patternDate: Element? = null,
  public var patternDateTime: KotlinString? = null,
  public var _patternDateTime: Element? = null,
  public var patternDecimal: Double? = null,
  public var _patternDecimal: Element? = null,
  public var patternId: KotlinString? = null,
  public var _patternId: Element? = null,
  public var patternInstant: KotlinString? = null,
  public var _patternInstant: Element? = null,
  public var patternInteger: Int? = null,
  public var _patternInteger: Element? = null,
  public var patternMarkdown: KotlinString? = null,
  public var _patternMarkdown: Element? = null,
  public var patternOid: KotlinString? = null,
  public var _patternOid: Element? = null,
  public var patternPositiveInt: Int? = null,
  public var _patternPositiveInt: Element? = null,
  public var patternString: KotlinString? = null,
  public var _patternString: Element? = null,
  public var patternTime: LocalTime? = null,
  public var _patternTime: Element? = null,
  public var patternUnsignedInt: Int? = null,
  public var _patternUnsignedInt: Element? = null,
  public var patternUri: KotlinString? = null,
  public var _patternUri: Element? = null,
  public var patternUrl: KotlinString? = null,
  public var _patternUrl: Element? = null,
  public var patternUuid: KotlinString? = null,
  public var _patternUuid: Element? = null,
  public var patternAddress: Address? = null,
  public var patternAge: Age? = null,
  public var patternAnnotation: Annotation? = null,
  public var patternAttachment: Attachment? = null,
  public var patternCodeableConcept: CodeableConcept? = null,
  public var patternCoding: Coding? = null,
  public var patternContactPoint: ContactPoint? = null,
  public var patternCount: Count? = null,
  public var patternDistance: Distance? = null,
  public var patternDuration: Duration? = null,
  public var patternHumanName: HumanName? = null,
  public var patternIdentifier: Identifier? = null,
  public var patternMoney: Money? = null,
  public var patternPeriod: Period? = null,
  public var patternQuantity: Quantity? = null,
  public var patternRange: Range? = null,
  public var patternRatio: Ratio? = null,
  public var patternReference: Reference? = null,
  public var patternSampledData: SampledData? = null,
  public var patternSignature: Signature? = null,
  public var patternTiming: Timing? = null,
  public var patternContactDetail: ContactDetail? = null,
  public var patternContributor: Contributor? = null,
  public var patternDataRequirement: DataRequirement? = null,
  public var patternExpression: Expression? = null,
  public var patternParameterDefinition: ParameterDefinition? = null,
  public var patternRelatedArtifact: RelatedArtifact? = null,
  public var patternTriggerDefinition: TriggerDefinition? = null,
  public var patternUsageContext: UsageContext? = null,
  public var patternDosage: Dosage? = null,
  public var patternMeta: Meta? = null,
) {
  public fun toModel(): ElementDefinition.Pattern =
    ElementDefinition.Pattern.from(
      Base64Binary.of(
        this@ElementDefinitionPatternSurrogate.patternBase64Binary,
        this@ElementDefinitionPatternSurrogate._patternBase64Binary,
      ),
      R4Boolean.of(
        this@ElementDefinitionPatternSurrogate.patternBoolean,
        this@ElementDefinitionPatternSurrogate._patternBoolean,
      ),
      Canonical.of(
        this@ElementDefinitionPatternSurrogate.patternCanonical,
        this@ElementDefinitionPatternSurrogate._patternCanonical,
      ),
      Code.of(
        this@ElementDefinitionPatternSurrogate.patternCode,
        this@ElementDefinitionPatternSurrogate._patternCode,
      ),
      Date.of(
        FhirDate.fromString(this@ElementDefinitionPatternSurrogate.patternDate),
        this@ElementDefinitionPatternSurrogate._patternDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ElementDefinitionPatternSurrogate.patternDateTime),
        this@ElementDefinitionPatternSurrogate._patternDateTime,
      ),
      Decimal.of(
        this@ElementDefinitionPatternSurrogate.patternDecimal,
        this@ElementDefinitionPatternSurrogate._patternDecimal,
      ),
      Id.of(
        this@ElementDefinitionPatternSurrogate.patternId,
        this@ElementDefinitionPatternSurrogate._patternId,
      ),
      Instant.of(
        FhirDateTime.fromString(this@ElementDefinitionPatternSurrogate.patternInstant),
        this@ElementDefinitionPatternSurrogate._patternInstant,
      ),
      Integer.of(
        this@ElementDefinitionPatternSurrogate.patternInteger,
        this@ElementDefinitionPatternSurrogate._patternInteger,
      ),
      Markdown.of(
        this@ElementDefinitionPatternSurrogate.patternMarkdown,
        this@ElementDefinitionPatternSurrogate._patternMarkdown,
      ),
      Oid.of(
        this@ElementDefinitionPatternSurrogate.patternOid,
        this@ElementDefinitionPatternSurrogate._patternOid,
      ),
      PositiveInt.of(
        this@ElementDefinitionPatternSurrogate.patternPositiveInt,
        this@ElementDefinitionPatternSurrogate._patternPositiveInt,
      ),
      R4String.of(
        this@ElementDefinitionPatternSurrogate.patternString,
        this@ElementDefinitionPatternSurrogate._patternString,
      ),
      Time.of(
        this@ElementDefinitionPatternSurrogate.patternTime,
        this@ElementDefinitionPatternSurrogate._patternTime,
      ),
      UnsignedInt.of(
        this@ElementDefinitionPatternSurrogate.patternUnsignedInt,
        this@ElementDefinitionPatternSurrogate._patternUnsignedInt,
      ),
      Uri.of(
        this@ElementDefinitionPatternSurrogate.patternUri,
        this@ElementDefinitionPatternSurrogate._patternUri,
      ),
      Url.of(
        this@ElementDefinitionPatternSurrogate.patternUrl,
        this@ElementDefinitionPatternSurrogate._patternUrl,
      ),
      Uuid.of(
        this@ElementDefinitionPatternSurrogate.patternUuid,
        this@ElementDefinitionPatternSurrogate._patternUuid,
      ),
      this@ElementDefinitionPatternSurrogate.patternAddress,
      this@ElementDefinitionPatternSurrogate.patternAge,
      this@ElementDefinitionPatternSurrogate.patternAnnotation,
      this@ElementDefinitionPatternSurrogate.patternAttachment,
      this@ElementDefinitionPatternSurrogate.patternCodeableConcept,
      this@ElementDefinitionPatternSurrogate.patternCoding,
      this@ElementDefinitionPatternSurrogate.patternContactPoint,
      this@ElementDefinitionPatternSurrogate.patternCount,
      this@ElementDefinitionPatternSurrogate.patternDistance,
      this@ElementDefinitionPatternSurrogate.patternDuration,
      this@ElementDefinitionPatternSurrogate.patternHumanName,
      this@ElementDefinitionPatternSurrogate.patternIdentifier,
      this@ElementDefinitionPatternSurrogate.patternMoney,
      this@ElementDefinitionPatternSurrogate.patternPeriod,
      this@ElementDefinitionPatternSurrogate.patternQuantity,
      this@ElementDefinitionPatternSurrogate.patternRange,
      this@ElementDefinitionPatternSurrogate.patternRatio,
      this@ElementDefinitionPatternSurrogate.patternReference,
      this@ElementDefinitionPatternSurrogate.patternSampledData,
      this@ElementDefinitionPatternSurrogate.patternSignature,
      this@ElementDefinitionPatternSurrogate.patternTiming,
      this@ElementDefinitionPatternSurrogate.patternContactDetail,
      this@ElementDefinitionPatternSurrogate.patternContributor,
      this@ElementDefinitionPatternSurrogate.patternDataRequirement,
      this@ElementDefinitionPatternSurrogate.patternExpression,
      this@ElementDefinitionPatternSurrogate.patternParameterDefinition,
      this@ElementDefinitionPatternSurrogate.patternRelatedArtifact,
      this@ElementDefinitionPatternSurrogate.patternTriggerDefinition,
      this@ElementDefinitionPatternSurrogate.patternUsageContext,
      this@ElementDefinitionPatternSurrogate.patternDosage,
      this@ElementDefinitionPatternSurrogate.patternMeta,
    )!!

  public companion object {
    public fun fromModel(model: ElementDefinition.Pattern): ElementDefinitionPatternSurrogate =
      with(model) {
        ElementDefinitionPatternSurrogate(
          patternBase64Binary = this@with.asBase64Binary()?.value?.value,
          _patternBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
          patternBoolean = this@with.asBoolean()?.value?.value,
          _patternBoolean = this@with.asBoolean()?.value?.toElement(),
          patternCanonical = this@with.asCanonical()?.value?.value,
          _patternCanonical = this@with.asCanonical()?.value?.toElement(),
          patternCode = this@with.asCode()?.value?.value,
          _patternCode = this@with.asCode()?.value?.toElement(),
          patternDate = this@with.asDate()?.value?.value?.toString(),
          _patternDate = this@with.asDate()?.value?.toElement(),
          patternDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _patternDateTime = this@with.asDateTime()?.value?.toElement(),
          patternDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _patternDecimal = this@with.asDecimal()?.value?.toElement(),
          patternId = this@with.asId()?.value?.value,
          _patternId = this@with.asId()?.value?.toElement(),
          patternInstant = this@with.asInstant()?.value?.value?.toString(),
          _patternInstant = this@with.asInstant()?.value?.toElement(),
          patternInteger = this@with.asInteger()?.value?.value,
          _patternInteger = this@with.asInteger()?.value?.toElement(),
          patternMarkdown = this@with.asMarkdown()?.value?.value,
          _patternMarkdown = this@with.asMarkdown()?.value?.toElement(),
          patternOid = this@with.asOid()?.value?.value,
          _patternOid = this@with.asOid()?.value?.toElement(),
          patternPositiveInt = this@with.asPositiveInt()?.value?.value,
          _patternPositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          patternString = this@with.asString()?.value?.value,
          _patternString = this@with.asString()?.value?.toElement(),
          patternTime = this@with.asTime()?.value?.value,
          _patternTime = this@with.asTime()?.value?.toElement(),
          patternUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _patternUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          patternUri = this@with.asUri()?.value?.value,
          _patternUri = this@with.asUri()?.value?.toElement(),
          patternUrl = this@with.asUrl()?.value?.value,
          _patternUrl = this@with.asUrl()?.value?.toElement(),
          patternUuid = this@with.asUuid()?.value?.value,
          _patternUuid = this@with.asUuid()?.value?.toElement(),
          patternAddress = this@with.asAddress()?.value,
          patternAge = this@with.asAge()?.value,
          patternAnnotation = this@with.asAnnotation()?.value,
          patternAttachment = this@with.asAttachment()?.value,
          patternCodeableConcept = this@with.asCodeableConcept()?.value,
          patternCoding = this@with.asCoding()?.value,
          patternContactPoint = this@with.asContactPoint()?.value,
          patternCount = this@with.asCount()?.value,
          patternDistance = this@with.asDistance()?.value,
          patternDuration = this@with.asDuration()?.value,
          patternHumanName = this@with.asHumanName()?.value,
          patternIdentifier = this@with.asIdentifier()?.value,
          patternMoney = this@with.asMoney()?.value,
          patternPeriod = this@with.asPeriod()?.value,
          patternQuantity = this@with.asQuantity()?.value,
          patternRange = this@with.asRange()?.value,
          patternRatio = this@with.asRatio()?.value,
          patternReference = this@with.asReference()?.value,
          patternSampledData = this@with.asSampledData()?.value,
          patternSignature = this@with.asSignature()?.value,
          patternTiming = this@with.asTiming()?.value,
          patternContactDetail = this@with.asContactDetail()?.value,
          patternContributor = this@with.asContributor()?.value,
          patternDataRequirement = this@with.asDataRequirement()?.value,
          patternExpression = this@with.asExpression()?.value,
          patternParameterDefinition = this@with.asParameterDefinition()?.value,
          patternRelatedArtifact = this@with.asRelatedArtifact()?.value,
          patternTriggerDefinition = this@with.asTriggerDefinition()?.value,
          patternUsageContext = this@with.asUsageContext()?.value,
          patternDosage = this@with.asDosage()?.value,
          patternMeta = this@with.asMeta()?.value,
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionExampleValueSurrogate(
  public var valueBase64Binary: KotlinString? = null,
  public var _valueBase64Binary: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueCanonical: KotlinString? = null,
  public var _valueCanonical: Element? = null,
  public var valueCode: KotlinString? = null,
  public var _valueCode: Element? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
  public var valueId: KotlinString? = null,
  public var _valueId: Element? = null,
  public var valueInstant: KotlinString? = null,
  public var _valueInstant: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueMarkdown: KotlinString? = null,
  public var _valueMarkdown: Element? = null,
  public var valueOid: KotlinString? = null,
  public var _valueOid: Element? = null,
  public var valuePositiveInt: Int? = null,
  public var _valuePositiveInt: Element? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueUnsignedInt: Int? = null,
  public var _valueUnsignedInt: Element? = null,
  public var valueUri: KotlinString? = null,
  public var _valueUri: Element? = null,
  public var valueUrl: KotlinString? = null,
  public var _valueUrl: Element? = null,
  public var valueUuid: KotlinString? = null,
  public var _valueUuid: Element? = null,
  public var valueAddress: Address? = null,
  public var valueAge: Age? = null,
  public var valueAnnotation: Annotation? = null,
  public var valueAttachment: Attachment? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueCoding: Coding? = null,
  public var valueContactPoint: ContactPoint? = null,
  public var valueCount: Count? = null,
  public var valueDistance: Distance? = null,
  public var valueDuration: Duration? = null,
  public var valueHumanName: HumanName? = null,
  public var valueIdentifier: Identifier? = null,
  public var valueMoney: Money? = null,
  public var valuePeriod: Period? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueRatio: Ratio? = null,
  public var valueReference: Reference? = null,
  public var valueSampledData: SampledData? = null,
  public var valueSignature: Signature? = null,
  public var valueTiming: Timing? = null,
  public var valueContactDetail: ContactDetail? = null,
  public var valueContributor: Contributor? = null,
  public var valueDataRequirement: DataRequirement? = null,
  public var valueExpression: Expression? = null,
  public var valueParameterDefinition: ParameterDefinition? = null,
  public var valueRelatedArtifact: RelatedArtifact? = null,
  public var valueTriggerDefinition: TriggerDefinition? = null,
  public var valueUsageContext: UsageContext? = null,
  public var valueDosage: Dosage? = null,
  public var valueMeta: Meta? = null,
) {
  public fun toModel(): ElementDefinition.Example.Value =
    ElementDefinition.Example.Value.from(
      Base64Binary.of(
        this@ElementDefinitionExampleValueSurrogate.valueBase64Binary,
        this@ElementDefinitionExampleValueSurrogate._valueBase64Binary,
      ),
      R4Boolean.of(
        this@ElementDefinitionExampleValueSurrogate.valueBoolean,
        this@ElementDefinitionExampleValueSurrogate._valueBoolean,
      ),
      Canonical.of(
        this@ElementDefinitionExampleValueSurrogate.valueCanonical,
        this@ElementDefinitionExampleValueSurrogate._valueCanonical,
      ),
      Code.of(
        this@ElementDefinitionExampleValueSurrogate.valueCode,
        this@ElementDefinitionExampleValueSurrogate._valueCode,
      ),
      Date.of(
        FhirDate.fromString(this@ElementDefinitionExampleValueSurrogate.valueDate),
        this@ElementDefinitionExampleValueSurrogate._valueDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ElementDefinitionExampleValueSurrogate.valueDateTime),
        this@ElementDefinitionExampleValueSurrogate._valueDateTime,
      ),
      Decimal.of(
        this@ElementDefinitionExampleValueSurrogate.valueDecimal,
        this@ElementDefinitionExampleValueSurrogate._valueDecimal,
      ),
      Id.of(
        this@ElementDefinitionExampleValueSurrogate.valueId,
        this@ElementDefinitionExampleValueSurrogate._valueId,
      ),
      Instant.of(
        FhirDateTime.fromString(this@ElementDefinitionExampleValueSurrogate.valueInstant),
        this@ElementDefinitionExampleValueSurrogate._valueInstant,
      ),
      Integer.of(
        this@ElementDefinitionExampleValueSurrogate.valueInteger,
        this@ElementDefinitionExampleValueSurrogate._valueInteger,
      ),
      Markdown.of(
        this@ElementDefinitionExampleValueSurrogate.valueMarkdown,
        this@ElementDefinitionExampleValueSurrogate._valueMarkdown,
      ),
      Oid.of(
        this@ElementDefinitionExampleValueSurrogate.valueOid,
        this@ElementDefinitionExampleValueSurrogate._valueOid,
      ),
      PositiveInt.of(
        this@ElementDefinitionExampleValueSurrogate.valuePositiveInt,
        this@ElementDefinitionExampleValueSurrogate._valuePositiveInt,
      ),
      R4String.of(
        this@ElementDefinitionExampleValueSurrogate.valueString,
        this@ElementDefinitionExampleValueSurrogate._valueString,
      ),
      Time.of(
        this@ElementDefinitionExampleValueSurrogate.valueTime,
        this@ElementDefinitionExampleValueSurrogate._valueTime,
      ),
      UnsignedInt.of(
        this@ElementDefinitionExampleValueSurrogate.valueUnsignedInt,
        this@ElementDefinitionExampleValueSurrogate._valueUnsignedInt,
      ),
      Uri.of(
        this@ElementDefinitionExampleValueSurrogate.valueUri,
        this@ElementDefinitionExampleValueSurrogate._valueUri,
      ),
      Url.of(
        this@ElementDefinitionExampleValueSurrogate.valueUrl,
        this@ElementDefinitionExampleValueSurrogate._valueUrl,
      ),
      Uuid.of(
        this@ElementDefinitionExampleValueSurrogate.valueUuid,
        this@ElementDefinitionExampleValueSurrogate._valueUuid,
      ),
      this@ElementDefinitionExampleValueSurrogate.valueAddress,
      this@ElementDefinitionExampleValueSurrogate.valueAge,
      this@ElementDefinitionExampleValueSurrogate.valueAnnotation,
      this@ElementDefinitionExampleValueSurrogate.valueAttachment,
      this@ElementDefinitionExampleValueSurrogate.valueCodeableConcept,
      this@ElementDefinitionExampleValueSurrogate.valueCoding,
      this@ElementDefinitionExampleValueSurrogate.valueContactPoint,
      this@ElementDefinitionExampleValueSurrogate.valueCount,
      this@ElementDefinitionExampleValueSurrogate.valueDistance,
      this@ElementDefinitionExampleValueSurrogate.valueDuration,
      this@ElementDefinitionExampleValueSurrogate.valueHumanName,
      this@ElementDefinitionExampleValueSurrogate.valueIdentifier,
      this@ElementDefinitionExampleValueSurrogate.valueMoney,
      this@ElementDefinitionExampleValueSurrogate.valuePeriod,
      this@ElementDefinitionExampleValueSurrogate.valueQuantity,
      this@ElementDefinitionExampleValueSurrogate.valueRange,
      this@ElementDefinitionExampleValueSurrogate.valueRatio,
      this@ElementDefinitionExampleValueSurrogate.valueReference,
      this@ElementDefinitionExampleValueSurrogate.valueSampledData,
      this@ElementDefinitionExampleValueSurrogate.valueSignature,
      this@ElementDefinitionExampleValueSurrogate.valueTiming,
      this@ElementDefinitionExampleValueSurrogate.valueContactDetail,
      this@ElementDefinitionExampleValueSurrogate.valueContributor,
      this@ElementDefinitionExampleValueSurrogate.valueDataRequirement,
      this@ElementDefinitionExampleValueSurrogate.valueExpression,
      this@ElementDefinitionExampleValueSurrogate.valueParameterDefinition,
      this@ElementDefinitionExampleValueSurrogate.valueRelatedArtifact,
      this@ElementDefinitionExampleValueSurrogate.valueTriggerDefinition,
      this@ElementDefinitionExampleValueSurrogate.valueUsageContext,
      this@ElementDefinitionExampleValueSurrogate.valueDosage,
      this@ElementDefinitionExampleValueSurrogate.valueMeta,
    )!!

  public companion object {
    public fun fromModel(
      model: ElementDefinition.Example.Value
    ): ElementDefinitionExampleValueSurrogate =
      with(model) {
        ElementDefinitionExampleValueSurrogate(
          valueBase64Binary = this@with.asBase64Binary()?.value?.value,
          _valueBase64Binary = this@with.asBase64Binary()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueCanonical = this@with.asCanonical()?.value?.value,
          _valueCanonical = this@with.asCanonical()?.value?.toElement(),
          valueCode = this@with.asCode()?.value?.value,
          _valueCode = this@with.asCode()?.value?.toElement(),
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
          valueId = this@with.asId()?.value?.value,
          _valueId = this@with.asId()?.value?.toElement(),
          valueInstant = this@with.asInstant()?.value?.value?.toString(),
          _valueInstant = this@with.asInstant()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueMarkdown = this@with.asMarkdown()?.value?.value,
          _valueMarkdown = this@with.asMarkdown()?.value?.toElement(),
          valueOid = this@with.asOid()?.value?.value,
          _valueOid = this@with.asOid()?.value?.toElement(),
          valuePositiveInt = this@with.asPositiveInt()?.value?.value,
          _valuePositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _valueUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          valueUri = this@with.asUri()?.value?.value,
          _valueUri = this@with.asUri()?.value?.toElement(),
          valueUrl = this@with.asUrl()?.value?.value,
          _valueUrl = this@with.asUrl()?.value?.toElement(),
          valueUuid = this@with.asUuid()?.value?.value,
          _valueUuid = this@with.asUuid()?.value?.toElement(),
          valueAddress = this@with.asAddress()?.value,
          valueAge = this@with.asAge()?.value,
          valueAnnotation = this@with.asAnnotation()?.value,
          valueAttachment = this@with.asAttachment()?.value,
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueCoding = this@with.asCoding()?.value,
          valueContactPoint = this@with.asContactPoint()?.value,
          valueCount = this@with.asCount()?.value,
          valueDistance = this@with.asDistance()?.value,
          valueDuration = this@with.asDuration()?.value,
          valueHumanName = this@with.asHumanName()?.value,
          valueIdentifier = this@with.asIdentifier()?.value,
          valueMoney = this@with.asMoney()?.value,
          valuePeriod = this@with.asPeriod()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueRatio = this@with.asRatio()?.value,
          valueReference = this@with.asReference()?.value,
          valueSampledData = this@with.asSampledData()?.value,
          valueSignature = this@with.asSignature()?.value,
          valueTiming = this@with.asTiming()?.value,
          valueContactDetail = this@with.asContactDetail()?.value,
          valueContributor = this@with.asContributor()?.value,
          valueDataRequirement = this@with.asDataRequirement()?.value,
          valueExpression = this@with.asExpression()?.value,
          valueParameterDefinition = this@with.asParameterDefinition()?.value,
          valueRelatedArtifact = this@with.asRelatedArtifact()?.value,
          valueTriggerDefinition = this@with.asTriggerDefinition()?.value,
          valueUsageContext = this@with.asUsageContext()?.value,
          valueDosage = this@with.asDosage()?.value,
          valueMeta = this@with.asMeta()?.value,
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionMinValueSurrogate(
  public var minValueDate: KotlinString? = null,
  public var _minValueDate: Element? = null,
  public var minValueDateTime: KotlinString? = null,
  public var _minValueDateTime: Element? = null,
  public var minValueInstant: KotlinString? = null,
  public var _minValueInstant: Element? = null,
  public var minValueTime: LocalTime? = null,
  public var _minValueTime: Element? = null,
  public var minValueDecimal: Double? = null,
  public var _minValueDecimal: Element? = null,
  public var minValueInteger: Int? = null,
  public var _minValueInteger: Element? = null,
  public var minValuePositiveInt: Int? = null,
  public var _minValuePositiveInt: Element? = null,
  public var minValueUnsignedInt: Int? = null,
  public var _minValueUnsignedInt: Element? = null,
  public var minValueQuantity: Quantity? = null,
) {
  public fun toModel(): ElementDefinition.MinValue =
    ElementDefinition.MinValue.from(
      Date.of(
        FhirDate.fromString(this@ElementDefinitionMinValueSurrogate.minValueDate),
        this@ElementDefinitionMinValueSurrogate._minValueDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ElementDefinitionMinValueSurrogate.minValueDateTime),
        this@ElementDefinitionMinValueSurrogate._minValueDateTime,
      ),
      Instant.of(
        FhirDateTime.fromString(this@ElementDefinitionMinValueSurrogate.minValueInstant),
        this@ElementDefinitionMinValueSurrogate._minValueInstant,
      ),
      Time.of(
        this@ElementDefinitionMinValueSurrogate.minValueTime,
        this@ElementDefinitionMinValueSurrogate._minValueTime,
      ),
      Decimal.of(
        this@ElementDefinitionMinValueSurrogate.minValueDecimal,
        this@ElementDefinitionMinValueSurrogate._minValueDecimal,
      ),
      Integer.of(
        this@ElementDefinitionMinValueSurrogate.minValueInteger,
        this@ElementDefinitionMinValueSurrogate._minValueInteger,
      ),
      PositiveInt.of(
        this@ElementDefinitionMinValueSurrogate.minValuePositiveInt,
        this@ElementDefinitionMinValueSurrogate._minValuePositiveInt,
      ),
      UnsignedInt.of(
        this@ElementDefinitionMinValueSurrogate.minValueUnsignedInt,
        this@ElementDefinitionMinValueSurrogate._minValueUnsignedInt,
      ),
      this@ElementDefinitionMinValueSurrogate.minValueQuantity,
    )!!

  public companion object {
    public fun fromModel(model: ElementDefinition.MinValue): ElementDefinitionMinValueSurrogate =
      with(model) {
        ElementDefinitionMinValueSurrogate(
          minValueDate = this@with.asDate()?.value?.value?.toString(),
          _minValueDate = this@with.asDate()?.value?.toElement(),
          minValueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _minValueDateTime = this@with.asDateTime()?.value?.toElement(),
          minValueInstant = this@with.asInstant()?.value?.value?.toString(),
          _minValueInstant = this@with.asInstant()?.value?.toElement(),
          minValueTime = this@with.asTime()?.value?.value,
          _minValueTime = this@with.asTime()?.value?.toElement(),
          minValueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _minValueDecimal = this@with.asDecimal()?.value?.toElement(),
          minValueInteger = this@with.asInteger()?.value?.value,
          _minValueInteger = this@with.asInteger()?.value?.toElement(),
          minValuePositiveInt = this@with.asPositiveInt()?.value?.value,
          _minValuePositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          minValueUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _minValueUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          minValueQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionMaxValueSurrogate(
  public var maxValueDate: KotlinString? = null,
  public var _maxValueDate: Element? = null,
  public var maxValueDateTime: KotlinString? = null,
  public var _maxValueDateTime: Element? = null,
  public var maxValueInstant: KotlinString? = null,
  public var _maxValueInstant: Element? = null,
  public var maxValueTime: LocalTime? = null,
  public var _maxValueTime: Element? = null,
  public var maxValueDecimal: Double? = null,
  public var _maxValueDecimal: Element? = null,
  public var maxValueInteger: Int? = null,
  public var _maxValueInteger: Element? = null,
  public var maxValuePositiveInt: Int? = null,
  public var _maxValuePositiveInt: Element? = null,
  public var maxValueUnsignedInt: Int? = null,
  public var _maxValueUnsignedInt: Element? = null,
  public var maxValueQuantity: Quantity? = null,
) {
  public fun toModel(): ElementDefinition.MaxValue =
    ElementDefinition.MaxValue.from(
      Date.of(
        FhirDate.fromString(this@ElementDefinitionMaxValueSurrogate.maxValueDate),
        this@ElementDefinitionMaxValueSurrogate._maxValueDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ElementDefinitionMaxValueSurrogate.maxValueDateTime),
        this@ElementDefinitionMaxValueSurrogate._maxValueDateTime,
      ),
      Instant.of(
        FhirDateTime.fromString(this@ElementDefinitionMaxValueSurrogate.maxValueInstant),
        this@ElementDefinitionMaxValueSurrogate._maxValueInstant,
      ),
      Time.of(
        this@ElementDefinitionMaxValueSurrogate.maxValueTime,
        this@ElementDefinitionMaxValueSurrogate._maxValueTime,
      ),
      Decimal.of(
        this@ElementDefinitionMaxValueSurrogate.maxValueDecimal,
        this@ElementDefinitionMaxValueSurrogate._maxValueDecimal,
      ),
      Integer.of(
        this@ElementDefinitionMaxValueSurrogate.maxValueInteger,
        this@ElementDefinitionMaxValueSurrogate._maxValueInteger,
      ),
      PositiveInt.of(
        this@ElementDefinitionMaxValueSurrogate.maxValuePositiveInt,
        this@ElementDefinitionMaxValueSurrogate._maxValuePositiveInt,
      ),
      UnsignedInt.of(
        this@ElementDefinitionMaxValueSurrogate.maxValueUnsignedInt,
        this@ElementDefinitionMaxValueSurrogate._maxValueUnsignedInt,
      ),
      this@ElementDefinitionMaxValueSurrogate.maxValueQuantity,
    )!!

  public companion object {
    public fun fromModel(model: ElementDefinition.MaxValue): ElementDefinitionMaxValueSurrogate =
      with(model) {
        ElementDefinitionMaxValueSurrogate(
          maxValueDate = this@with.asDate()?.value?.value?.toString(),
          _maxValueDate = this@with.asDate()?.value?.toElement(),
          maxValueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _maxValueDateTime = this@with.asDateTime()?.value?.toElement(),
          maxValueInstant = this@with.asInstant()?.value?.value?.toString(),
          _maxValueInstant = this@with.asInstant()?.value?.toElement(),
          maxValueTime = this@with.asTime()?.value?.value,
          _maxValueTime = this@with.asTime()?.value?.toElement(),
          maxValueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _maxValueDecimal = this@with.asDecimal()?.value?.toElement(),
          maxValueInteger = this@with.asInteger()?.value?.value,
          _maxValueInteger = this@with.asInteger()?.value?.toElement(),
          maxValuePositiveInt = this@with.asPositiveInt()?.value?.value,
          _maxValuePositiveInt = this@with.asPositiveInt()?.value?.toElement(),
          maxValueUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _maxValueUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          maxValueQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class ElementDefinitionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var path: KotlinString? = null,
  public var _path: Element? = null,
  public var representation: List<KotlinString?>? = null,
  public var _representation: List<Element?>? = null,
  public var sliceName: KotlinString? = null,
  public var _sliceName: Element? = null,
  public var sliceIsConstraining: KotlinBoolean? = null,
  public var _sliceIsConstraining: Element? = null,
  public var label: KotlinString? = null,
  public var _label: Element? = null,
  public var code: List<Coding>? = null,
  public var slicing: ElementDefinition.Slicing? = null,
  public var short: KotlinString? = null,
  public var _short: Element? = null,
  public var definition: KotlinString? = null,
  public var _definition: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
  public var requirements: KotlinString? = null,
  public var _requirements: Element? = null,
  public var alias: List<KotlinString?>? = null,
  public var _alias: List<Element?>? = null,
  public var min: Int? = null,
  public var _min: Element? = null,
  public var max: KotlinString? = null,
  public var _max: Element? = null,
  public var base: ElementDefinition.Base? = null,
  public var contentReference: KotlinString? = null,
  public var _contentReference: Element? = null,
  public var type: List<ElementDefinition.Type>? = null,
  public var defaultValue: ElementDefinition.DefaultValue? = null,
  public var meaningWhenMissing: KotlinString? = null,
  public var _meaningWhenMissing: Element? = null,
  public var orderMeaning: KotlinString? = null,
  public var _orderMeaning: Element? = null,
  public var fixed: ElementDefinition.Fixed? = null,
  public var pattern: ElementDefinition.Pattern? = null,
  public var example: List<ElementDefinition.Example>? = null,
  public var minValue: ElementDefinition.MinValue? = null,
  public var maxValue: ElementDefinition.MaxValue? = null,
  public var maxLength: Int? = null,
  public var _maxLength: Element? = null,
  public var condition: List<KotlinString?>? = null,
  public var _condition: List<Element?>? = null,
  public var constraint: List<ElementDefinition.Constraint>? = null,
  public var mustSupport: KotlinBoolean? = null,
  public var _mustSupport: Element? = null,
  public var isModifier: KotlinBoolean? = null,
  public var _isModifier: Element? = null,
  public var isModifierReason: KotlinString? = null,
  public var _isModifierReason: Element? = null,
  public var isSummary: KotlinBoolean? = null,
  public var _isSummary: Element? = null,
  public var binding: ElementDefinition.Binding? = null,
  public var mapping: List<ElementDefinition.Mapping>? = null,
) {
  public fun toModel(): ElementDefinition =
    ElementDefinition(
      id = this@ElementDefinitionSurrogate.id,
      extension = this@ElementDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@ElementDefinitionSurrogate.modifierExtension ?: listOf(),
      path =
        R4String.of(this@ElementDefinitionSurrogate.path, this@ElementDefinitionSurrogate._path)!!,
      representation =
        if (
          this@ElementDefinitionSurrogate.representation == null &&
            this@ElementDefinitionSurrogate._representation == null
        ) {
          listOf()
        } else {
          (this@ElementDefinitionSurrogate.representation
              ?: List(this@ElementDefinitionSurrogate._representation!!.size) { null })
            .zip(
              this@ElementDefinitionSurrogate._representation
                ?: List(this@ElementDefinitionSurrogate.representation!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { ElementDefinition.PropertyRepresentation.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      sliceName =
        R4String.of(
          this@ElementDefinitionSurrogate.sliceName,
          this@ElementDefinitionSurrogate._sliceName,
        ),
      sliceIsConstraining =
        R4Boolean.of(
          this@ElementDefinitionSurrogate.sliceIsConstraining,
          this@ElementDefinitionSurrogate._sliceIsConstraining,
        ),
      label =
        R4String.of(this@ElementDefinitionSurrogate.label, this@ElementDefinitionSurrogate._label),
      code = this@ElementDefinitionSurrogate.code ?: listOf(),
      slicing = this@ElementDefinitionSurrogate.slicing,
      short =
        R4String.of(this@ElementDefinitionSurrogate.short, this@ElementDefinitionSurrogate._short),
      definition =
        Markdown.of(
          this@ElementDefinitionSurrogate.definition,
          this@ElementDefinitionSurrogate._definition,
        ),
      comment =
        Markdown.of(
          this@ElementDefinitionSurrogate.comment,
          this@ElementDefinitionSurrogate._comment,
        ),
      requirements =
        Markdown.of(
          this@ElementDefinitionSurrogate.requirements,
          this@ElementDefinitionSurrogate._requirements,
        ),
      alias =
        if (
          this@ElementDefinitionSurrogate.alias == null &&
            this@ElementDefinitionSurrogate._alias == null
        ) {
          listOf()
        } else {
          (this@ElementDefinitionSurrogate.alias
              ?: List(this@ElementDefinitionSurrogate._alias!!.size) { null })
            .zip(
              this@ElementDefinitionSurrogate._alias
                ?: List(this@ElementDefinitionSurrogate.alias!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      min =
        UnsignedInt.of(this@ElementDefinitionSurrogate.min, this@ElementDefinitionSurrogate._min),
      max = R4String.of(this@ElementDefinitionSurrogate.max, this@ElementDefinitionSurrogate._max),
      base = this@ElementDefinitionSurrogate.base,
      contentReference =
        Uri.of(
          this@ElementDefinitionSurrogate.contentReference,
          this@ElementDefinitionSurrogate._contentReference,
        ),
      type = this@ElementDefinitionSurrogate.type ?: listOf(),
      defaultValue = this@ElementDefinitionSurrogate.defaultValue,
      meaningWhenMissing =
        Markdown.of(
          this@ElementDefinitionSurrogate.meaningWhenMissing,
          this@ElementDefinitionSurrogate._meaningWhenMissing,
        ),
      orderMeaning =
        R4String.of(
          this@ElementDefinitionSurrogate.orderMeaning,
          this@ElementDefinitionSurrogate._orderMeaning,
        ),
      fixed = this@ElementDefinitionSurrogate.fixed,
      pattern = this@ElementDefinitionSurrogate.pattern,
      example = this@ElementDefinitionSurrogate.example ?: listOf(),
      minValue = this@ElementDefinitionSurrogate.minValue,
      maxValue = this@ElementDefinitionSurrogate.maxValue,
      maxLength =
        Integer.of(
          this@ElementDefinitionSurrogate.maxLength,
          this@ElementDefinitionSurrogate._maxLength,
        ),
      condition =
        if (
          this@ElementDefinitionSurrogate.condition == null &&
            this@ElementDefinitionSurrogate._condition == null
        ) {
          listOf()
        } else {
          (this@ElementDefinitionSurrogate.condition
              ?: List(this@ElementDefinitionSurrogate._condition!!.size) { null })
            .zip(
              this@ElementDefinitionSurrogate._condition
                ?: List(this@ElementDefinitionSurrogate.condition!!.size) { null }
            )
            .map { (value, element) -> Id.of(value, element)!! }
            .toList()
        },
      constraint = this@ElementDefinitionSurrogate.constraint ?: listOf(),
      mustSupport =
        R4Boolean.of(
          this@ElementDefinitionSurrogate.mustSupport,
          this@ElementDefinitionSurrogate._mustSupport,
        ),
      isModifier =
        R4Boolean.of(
          this@ElementDefinitionSurrogate.isModifier,
          this@ElementDefinitionSurrogate._isModifier,
        ),
      isModifierReason =
        R4String.of(
          this@ElementDefinitionSurrogate.isModifierReason,
          this@ElementDefinitionSurrogate._isModifierReason,
        ),
      isSummary =
        R4Boolean.of(
          this@ElementDefinitionSurrogate.isSummary,
          this@ElementDefinitionSurrogate._isSummary,
        ),
      binding = this@ElementDefinitionSurrogate.binding,
      mapping = this@ElementDefinitionSurrogate.mapping ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ElementDefinition): ElementDefinitionSurrogate =
      with(model) {
        ElementDefinitionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          path = this@with.path.value,
          _path = this@with.path.toElement(),
          representation =
            this@with.representation
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _representation =
            this@with.representation
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          sliceName = this@with.sliceName?.value,
          _sliceName = this@with.sliceName?.toElement(),
          sliceIsConstraining = this@with.sliceIsConstraining?.value,
          _sliceIsConstraining = this@with.sliceIsConstraining?.toElement(),
          label = this@with.label?.value,
          _label = this@with.label?.toElement(),
          code = this@with.code.takeIf { it.isNotEmpty() },
          slicing = this@with.slicing,
          short = this@with.short?.value,
          _short = this@with.short?.toElement(),
          definition = this@with.definition?.value,
          _definition = this@with.definition?.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
          requirements = this@with.requirements?.value,
          _requirements = this@with.requirements?.toElement(),
          alias = this@with.alias.map { it.value }.toList().takeUnless { it.all { it == null } },
          _alias =
            this@with.alias
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          min = this@with.min?.value,
          _min = this@with.min?.toElement(),
          max = this@with.max?.value,
          _max = this@with.max?.toElement(),
          base = this@with.base,
          contentReference = this@with.contentReference?.value,
          _contentReference = this@with.contentReference?.toElement(),
          type = this@with.type.takeIf { it.isNotEmpty() },
          defaultValue = this@with.defaultValue,
          meaningWhenMissing = this@with.meaningWhenMissing?.value,
          _meaningWhenMissing = this@with.meaningWhenMissing?.toElement(),
          orderMeaning = this@with.orderMeaning?.value,
          _orderMeaning = this@with.orderMeaning?.toElement(),
          fixed = this@with.fixed,
          pattern = this@with.pattern,
          example = this@with.example.takeIf { it.isNotEmpty() },
          minValue = this@with.minValue,
          maxValue = this@with.maxValue,
          maxLength = this@with.maxLength?.value,
          _maxLength = this@with.maxLength?.toElement(),
          condition =
            this@with.condition.map { it.value }.toList().takeUnless { it.all { it == null } },
          _condition =
            this@with.condition
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          constraint = this@with.constraint.takeIf { it.isNotEmpty() },
          mustSupport = this@with.mustSupport?.value,
          _mustSupport = this@with.mustSupport?.toElement(),
          isModifier = this@with.isModifier?.value,
          _isModifier = this@with.isModifier?.toElement(),
          isModifierReason = this@with.isModifierReason?.value,
          _isModifierReason = this@with.isModifierReason?.toElement(),
          isSummary = this@with.isSummary?.value,
          _isSummary = this@with.isSummary?.toElement(),
          binding = this@with.binding,
          mapping = this@with.mapping.takeIf { it.isNotEmpty() },
        )
      }
  }
}

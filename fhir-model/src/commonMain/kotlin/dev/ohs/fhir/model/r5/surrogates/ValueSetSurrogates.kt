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
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.ValueSet
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ValueSetComposeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var lockedDate: KotlinString? = null,
  public var _lockedDate: Element? = null,
  public var inactive: KotlinBoolean? = null,
  public var _inactive: Element? = null,
  public var include: List<ValueSet.Compose.Include>? = null,
  public var exclude: List<ValueSet.Compose.Include>? = null,
  public var `property`: List<KotlinString?>? = null,
  public var _property: List<Element?>? = null,
) {
  public fun toModel(): ValueSet.Compose =
    ValueSet.Compose(
      id = this@ValueSetComposeSurrogate.id,
      extension = this@ValueSetComposeSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetComposeSurrogate.modifierExtension ?: listOf(),
      lockedDate =
        Date.of(
          FhirDate.fromString(this@ValueSetComposeSurrogate.lockedDate),
          this@ValueSetComposeSurrogate._lockedDate,
        ),
      inactive =
        R5Boolean.of(
          this@ValueSetComposeSurrogate.inactive,
          this@ValueSetComposeSurrogate._inactive,
        ),
      include = this@ValueSetComposeSurrogate.include ?: listOf(),
      exclude = this@ValueSetComposeSurrogate.exclude ?: listOf(),
      `property` =
        if (
          this@ValueSetComposeSurrogate.`property` == null &&
            this@ValueSetComposeSurrogate._property == null
        ) {
          listOf()
        } else {
          (this@ValueSetComposeSurrogate.`property`
              ?: List(this@ValueSetComposeSurrogate._property!!.size) { null })
            .zip(
              this@ValueSetComposeSurrogate._property
                ?: List(this@ValueSetComposeSurrogate.`property`!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(model: ValueSet.Compose): ValueSetComposeSurrogate =
      with(model) {
        ValueSetComposeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          lockedDate = this@with.lockedDate?.value?.toString(),
          _lockedDate = this@with.lockedDate?.toElement(),
          inactive = this@with.inactive?.value,
          _inactive = this@with.inactive?.toElement(),
          include = this@with.include.takeIf { it.isNotEmpty() },
          exclude = this@with.exclude.takeIf { it.isNotEmpty() },
          `property` =
            this@with.`property`.map { it.value }.toList().takeUnless { it.all { it == null } },
          _property =
            this@with.`property`
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class ValueSetComposeIncludeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var system: KotlinString? = null,
  public var _system: Element? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var concept: List<ValueSet.Compose.Include.Concept>? = null,
  public var filter: List<ValueSet.Compose.Include.Filter>? = null,
  public var valueSet: List<KotlinString?>? = null,
  public var _valueSet: List<Element?>? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
) {
  public fun toModel(): ValueSet.Compose.Include =
    ValueSet.Compose.Include(
      id = this@ValueSetComposeIncludeSurrogate.id,
      extension = this@ValueSetComposeIncludeSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetComposeIncludeSurrogate.modifierExtension ?: listOf(),
      system =
        Uri.of(
          this@ValueSetComposeIncludeSurrogate.system,
          this@ValueSetComposeIncludeSurrogate._system,
        ),
      version =
        R5String.of(
          this@ValueSetComposeIncludeSurrogate.version,
          this@ValueSetComposeIncludeSurrogate._version,
        ),
      concept = this@ValueSetComposeIncludeSurrogate.concept ?: listOf(),
      filter = this@ValueSetComposeIncludeSurrogate.filter ?: listOf(),
      valueSet =
        if (
          this@ValueSetComposeIncludeSurrogate.valueSet == null &&
            this@ValueSetComposeIncludeSurrogate._valueSet == null
        ) {
          listOf()
        } else {
          (this@ValueSetComposeIncludeSurrogate.valueSet
              ?: List(this@ValueSetComposeIncludeSurrogate._valueSet!!.size) { null })
            .zip(
              this@ValueSetComposeIncludeSurrogate._valueSet
                ?: List(this@ValueSetComposeIncludeSurrogate.valueSet!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      copyright =
        R5String.of(
          this@ValueSetComposeIncludeSurrogate.copyright,
          this@ValueSetComposeIncludeSurrogate._copyright,
        ),
    )

  public companion object {
    public fun fromModel(model: ValueSet.Compose.Include): ValueSetComposeIncludeSurrogate =
      with(model) {
        ValueSetComposeIncludeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          system = this@with.system?.value,
          _system = this@with.system?.toElement(),
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          concept = this@with.concept.takeIf { it.isNotEmpty() },
          filter = this@with.filter.takeIf { it.isNotEmpty() },
          valueSet =
            this@with.valueSet.map { it.value }.toList().takeUnless { it.all { it == null } },
          _valueSet =
            this@with.valueSet
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ValueSetComposeIncludeConceptSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var display: KotlinString? = null,
  public var _display: Element? = null,
  public var designation: List<ValueSet.Compose.Include.Concept.Designation>? = null,
) {
  public fun toModel(): ValueSet.Compose.Include.Concept =
    ValueSet.Compose.Include.Concept(
      id = this@ValueSetComposeIncludeConceptSurrogate.id,
      extension = this@ValueSetComposeIncludeConceptSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetComposeIncludeConceptSurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(
          this@ValueSetComposeIncludeConceptSurrogate.code,
          this@ValueSetComposeIncludeConceptSurrogate._code,
        )!!,
      display =
        R5String.of(
          this@ValueSetComposeIncludeConceptSurrogate.display,
          this@ValueSetComposeIncludeConceptSurrogate._display,
        ),
      designation = this@ValueSetComposeIncludeConceptSurrogate.designation ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ValueSet.Compose.Include.Concept
    ): ValueSetComposeIncludeConceptSurrogate =
      with(model) {
        ValueSetComposeIncludeConceptSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          display = this@with.display?.value,
          _display = this@with.display?.toElement(),
          designation = this@with.designation.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ValueSetComposeIncludeConceptDesignationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var use: Coding? = null,
  public var additionalUse: List<Coding>? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): ValueSet.Compose.Include.Concept.Designation =
    ValueSet.Compose.Include.Concept.Designation(
      id = this@ValueSetComposeIncludeConceptDesignationSurrogate.id,
      extension = this@ValueSetComposeIncludeConceptDesignationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ValueSetComposeIncludeConceptDesignationSurrogate.modifierExtension ?: listOf(),
      language =
        Code.of(
          this@ValueSetComposeIncludeConceptDesignationSurrogate.language,
          this@ValueSetComposeIncludeConceptDesignationSurrogate._language,
        ),
      use = this@ValueSetComposeIncludeConceptDesignationSurrogate.use,
      additionalUse =
        this@ValueSetComposeIncludeConceptDesignationSurrogate.additionalUse ?: listOf(),
      `value` =
        R5String.of(
          this@ValueSetComposeIncludeConceptDesignationSurrogate.`value`,
          this@ValueSetComposeIncludeConceptDesignationSurrogate._value,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: ValueSet.Compose.Include.Concept.Designation
    ): ValueSetComposeIncludeConceptDesignationSurrogate =
      with(model) {
        ValueSetComposeIncludeConceptDesignationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          use = this@with.use,
          additionalUse = this@with.additionalUse.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`.value,
          _value = this@with.`value`.toElement(),
        )
      }
  }
}

@Serializable
internal data class ValueSetComposeIncludeFilterSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `property`: KotlinString? = null,
  public var _property: Element? = null,
  public var op: KotlinString? = null,
  public var _op: Element? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): ValueSet.Compose.Include.Filter =
    ValueSet.Compose.Include.Filter(
      id = this@ValueSetComposeIncludeFilterSurrogate.id,
      extension = this@ValueSetComposeIncludeFilterSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetComposeIncludeFilterSurrogate.modifierExtension ?: listOf(),
      `property` =
        Code.of(
          this@ValueSetComposeIncludeFilterSurrogate.`property`,
          this@ValueSetComposeIncludeFilterSurrogate._property,
        )!!,
      op =
        Enumeration.of(
          ValueSet.FilterOperator.fromCode(this@ValueSetComposeIncludeFilterSurrogate.op!!),
          this@ValueSetComposeIncludeFilterSurrogate._op,
        ),
      `value` =
        R5String.of(
          this@ValueSetComposeIncludeFilterSurrogate.`value`,
          this@ValueSetComposeIncludeFilterSurrogate._value,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: ValueSet.Compose.Include.Filter
    ): ValueSetComposeIncludeFilterSurrogate =
      with(model) {
        ValueSetComposeIncludeFilterSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.value,
          _property = this@with.`property`.toElement(),
          op = this@with.op.value?.getCode(),
          _op = this@with.op.toElement(),
          `value` = this@with.`value`.value,
          _value = this@with.`value`.toElement(),
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: KotlinString? = null,
  public var _identifier: Element? = null,
  public var next: KotlinString? = null,
  public var _next: Element? = null,
  public var timestamp: KotlinString? = null,
  public var _timestamp: Element? = null,
  public var total: Int? = null,
  public var _total: Element? = null,
  public var offset: Int? = null,
  public var _offset: Element? = null,
  public var parameter: List<ValueSet.Expansion.Parameter>? = null,
  public var `property`: List<ValueSet.Expansion.Property>? = null,
  public var contains: List<ValueSet.Expansion.Contains>? = null,
) {
  public fun toModel(): ValueSet.Expansion =
    ValueSet.Expansion(
      id = this@ValueSetExpansionSurrogate.id,
      extension = this@ValueSetExpansionSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetExpansionSurrogate.modifierExtension ?: listOf(),
      identifier =
        Uri.of(
          this@ValueSetExpansionSurrogate.identifier,
          this@ValueSetExpansionSurrogate._identifier,
        ),
      next = Uri.of(this@ValueSetExpansionSurrogate.next, this@ValueSetExpansionSurrogate._next),
      timestamp =
        DateTime.of(
          FhirDateTime.fromString(this@ValueSetExpansionSurrogate.timestamp),
          this@ValueSetExpansionSurrogate._timestamp,
        )!!,
      total =
        Integer.of(this@ValueSetExpansionSurrogate.total, this@ValueSetExpansionSurrogate._total),
      offset =
        Integer.of(this@ValueSetExpansionSurrogate.offset, this@ValueSetExpansionSurrogate._offset),
      parameter = this@ValueSetExpansionSurrogate.parameter ?: listOf(),
      `property` = this@ValueSetExpansionSurrogate.`property` ?: listOf(),
      contains = this@ValueSetExpansionSurrogate.contains ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ValueSet.Expansion): ValueSetExpansionSurrogate =
      with(model) {
        ValueSetExpansionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier?.value,
          _identifier = this@with.identifier?.toElement(),
          next = this@with.next?.value,
          _next = this@with.next?.toElement(),
          timestamp = this@with.timestamp.value?.toString(),
          _timestamp = this@with.timestamp.toElement(),
          total = this@with.total?.value,
          _total = this@with.total?.toElement(),
          offset = this@with.offset?.value,
          _offset = this@with.offset?.toElement(),
          parameter = this@with.parameter.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          contains = this@with.contains.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionParameterSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var `value`: ValueSet.Expansion.Parameter.Value? = null,
) {
  public fun toModel(): ValueSet.Expansion.Parameter =
    ValueSet.Expansion.Parameter(
      id = this@ValueSetExpansionParameterSurrogate.id,
      extension = this@ValueSetExpansionParameterSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetExpansionParameterSurrogate.modifierExtension ?: listOf(),
      name =
        R5String.of(
          this@ValueSetExpansionParameterSurrogate.name,
          this@ValueSetExpansionParameterSurrogate._name,
        )!!,
      `value` = this@ValueSetExpansionParameterSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: ValueSet.Expansion.Parameter): ValueSetExpansionParameterSurrogate =
      with(model) {
        ValueSetExpansionParameterSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var uri: KotlinString? = null,
  public var _uri: Element? = null,
) {
  public fun toModel(): ValueSet.Expansion.Property =
    ValueSet.Expansion.Property(
      id = this@ValueSetExpansionPropertySurrogate.id,
      extension = this@ValueSetExpansionPropertySurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetExpansionPropertySurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(
          this@ValueSetExpansionPropertySurrogate.code,
          this@ValueSetExpansionPropertySurrogate._code,
        )!!,
      uri =
        Uri.of(
          this@ValueSetExpansionPropertySurrogate.uri,
          this@ValueSetExpansionPropertySurrogate._uri,
        ),
    )

  public companion object {
    public fun fromModel(model: ValueSet.Expansion.Property): ValueSetExpansionPropertySurrogate =
      with(model) {
        ValueSetExpansionPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          uri = this@with.uri?.value,
          _uri = this@with.uri?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionContainsSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var system: KotlinString? = null,
  public var _system: Element? = null,
  public var `abstract`: KotlinBoolean? = null,
  public var _abstract: Element? = null,
  public var inactive: KotlinBoolean? = null,
  public var _inactive: Element? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var display: KotlinString? = null,
  public var _display: Element? = null,
  public var designation: List<ValueSet.Compose.Include.Concept.Designation>? = null,
  public var `property`: List<ValueSet.Expansion.Contains.Property>? = null,
  public var contains: List<ValueSet.Expansion.Contains>? = null,
) {
  public fun toModel(): ValueSet.Expansion.Contains =
    ValueSet.Expansion.Contains(
      id = this@ValueSetExpansionContainsSurrogate.id,
      extension = this@ValueSetExpansionContainsSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetExpansionContainsSurrogate.modifierExtension ?: listOf(),
      system =
        Uri.of(
          this@ValueSetExpansionContainsSurrogate.system,
          this@ValueSetExpansionContainsSurrogate._system,
        ),
      `abstract` =
        R5Boolean.of(
          this@ValueSetExpansionContainsSurrogate.`abstract`,
          this@ValueSetExpansionContainsSurrogate._abstract,
        ),
      inactive =
        R5Boolean.of(
          this@ValueSetExpansionContainsSurrogate.inactive,
          this@ValueSetExpansionContainsSurrogate._inactive,
        ),
      version =
        R5String.of(
          this@ValueSetExpansionContainsSurrogate.version,
          this@ValueSetExpansionContainsSurrogate._version,
        ),
      code =
        Code.of(
          this@ValueSetExpansionContainsSurrogate.code,
          this@ValueSetExpansionContainsSurrogate._code,
        ),
      display =
        R5String.of(
          this@ValueSetExpansionContainsSurrogate.display,
          this@ValueSetExpansionContainsSurrogate._display,
        ),
      designation = this@ValueSetExpansionContainsSurrogate.designation ?: listOf(),
      `property` = this@ValueSetExpansionContainsSurrogate.`property` ?: listOf(),
      contains = this@ValueSetExpansionContainsSurrogate.contains ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ValueSet.Expansion.Contains): ValueSetExpansionContainsSurrogate =
      with(model) {
        ValueSetExpansionContainsSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          system = this@with.system?.value,
          _system = this@with.system?.toElement(),
          `abstract` = this@with.`abstract`?.value,
          _abstract = this@with.`abstract`?.toElement(),
          inactive = this@with.inactive?.value,
          _inactive = this@with.inactive?.toElement(),
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          code = this@with.code?.value,
          _code = this@with.code?.toElement(),
          display = this@with.display?.value,
          _display = this@with.display?.toElement(),
          designation = this@with.designation.takeIf { it.isNotEmpty() },
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          contains = this@with.contains.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionContainsPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var `value`: ValueSet.Expansion.Contains.Property.Value,
  public var subProperty: List<ValueSet.Expansion.Contains.Property.SubProperty>? = null,
) {
  public fun toModel(): ValueSet.Expansion.Contains.Property =
    ValueSet.Expansion.Contains.Property(
      id = this@ValueSetExpansionContainsPropertySurrogate.id,
      extension = this@ValueSetExpansionContainsPropertySurrogate.extension ?: listOf(),
      modifierExtension =
        this@ValueSetExpansionContainsPropertySurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(
          this@ValueSetExpansionContainsPropertySurrogate.code,
          this@ValueSetExpansionContainsPropertySurrogate._code,
        )!!,
      `value` = this@ValueSetExpansionContainsPropertySurrogate.`value`,
      subProperty = this@ValueSetExpansionContainsPropertySurrogate.subProperty ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ValueSet.Expansion.Contains.Property
    ): ValueSetExpansionContainsPropertySurrogate =
      with(model) {
        ValueSetExpansionContainsPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          `value` = this@with.`value`,
          subProperty = this@with.subProperty.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionContainsPropertySubPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var `value`: ValueSet.Expansion.Contains.Property.SubProperty.Value,
) {
  public fun toModel(): ValueSet.Expansion.Contains.Property.SubProperty =
    ValueSet.Expansion.Contains.Property.SubProperty(
      id = this@ValueSetExpansionContainsPropertySubPropertySurrogate.id,
      extension = this@ValueSetExpansionContainsPropertySubPropertySurrogate.extension ?: listOf(),
      modifierExtension =
        this@ValueSetExpansionContainsPropertySubPropertySurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(
          this@ValueSetExpansionContainsPropertySubPropertySurrogate.code,
          this@ValueSetExpansionContainsPropertySubPropertySurrogate._code,
        )!!,
      `value` = this@ValueSetExpansionContainsPropertySubPropertySurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: ValueSet.Expansion.Contains.Property.SubProperty
    ): ValueSetExpansionContainsPropertySubPropertySurrogate =
      with(model) {
        ValueSetExpansionContainsPropertySubPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class ValueSetScopeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var inclusionCriteria: KotlinString? = null,
  public var _inclusionCriteria: Element? = null,
  public var exclusionCriteria: KotlinString? = null,
  public var _exclusionCriteria: Element? = null,
) {
  public fun toModel(): ValueSet.Scope =
    ValueSet.Scope(
      id = this@ValueSetScopeSurrogate.id,
      extension = this@ValueSetScopeSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetScopeSurrogate.modifierExtension ?: listOf(),
      inclusionCriteria =
        R5String.of(
          this@ValueSetScopeSurrogate.inclusionCriteria,
          this@ValueSetScopeSurrogate._inclusionCriteria,
        ),
      exclusionCriteria =
        R5String.of(
          this@ValueSetScopeSurrogate.exclusionCriteria,
          this@ValueSetScopeSurrogate._exclusionCriteria,
        ),
    )

  public companion object {
    public fun fromModel(model: ValueSet.Scope): ValueSetScopeSurrogate =
      with(model) {
        ValueSetScopeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          inclusionCriteria = this@with.inclusionCriteria?.value,
          _inclusionCriteria = this@with.inclusionCriteria?.toElement(),
          exclusionCriteria = this@with.exclusionCriteria?.value,
          _exclusionCriteria = this@with.exclusionCriteria?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ValueSetVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): ValueSet.VersionAlgorithm =
    ValueSet.VersionAlgorithm.from(
      R5String.of(
        this@ValueSetVersionAlgorithmSurrogate.versionAlgorithmString,
        this@ValueSetVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@ValueSetVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(model: ValueSet.VersionAlgorithm): ValueSetVersionAlgorithmSurrogate =
      with(model) {
        ValueSetVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionParameterValueSurrogate(
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
  public var valueUri: KotlinString? = null,
  public var _valueUri: Element? = null,
  public var valueCode: KotlinString? = null,
  public var _valueCode: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
) {
  public fun toModel(): ValueSet.Expansion.Parameter.Value =
    ValueSet.Expansion.Parameter.Value.from(
      R5String.of(
        this@ValueSetExpansionParameterValueSurrogate.valueString,
        this@ValueSetExpansionParameterValueSurrogate._valueString,
      ),
      R5Boolean.of(
        this@ValueSetExpansionParameterValueSurrogate.valueBoolean,
        this@ValueSetExpansionParameterValueSurrogate._valueBoolean,
      ),
      Integer.of(
        this@ValueSetExpansionParameterValueSurrogate.valueInteger,
        this@ValueSetExpansionParameterValueSurrogate._valueInteger,
      ),
      Decimal.of(
        this@ValueSetExpansionParameterValueSurrogate.valueDecimal,
        this@ValueSetExpansionParameterValueSurrogate._valueDecimal,
      ),
      Uri.of(
        this@ValueSetExpansionParameterValueSurrogate.valueUri,
        this@ValueSetExpansionParameterValueSurrogate._valueUri,
      ),
      Code.of(
        this@ValueSetExpansionParameterValueSurrogate.valueCode,
        this@ValueSetExpansionParameterValueSurrogate._valueCode,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ValueSetExpansionParameterValueSurrogate.valueDateTime),
        this@ValueSetExpansionParameterValueSurrogate._valueDateTime,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: ValueSet.Expansion.Parameter.Value
    ): ValueSetExpansionParameterValueSurrogate =
      with(model) {
        ValueSetExpansionParameterValueSurrogate(
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
          valueUri = this@with.asUri()?.value?.value,
          _valueUri = this@with.asUri()?.value?.toElement(),
          valueCode = this@with.asCode()?.value?.value,
          _valueCode = this@with.asCode()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionContainsPropertyValueSurrogate(
  public var valueCode: KotlinString? = null,
  public var _valueCode: Element? = null,
  public var valueCoding: Coding? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
) {
  public fun toModel(): ValueSet.Expansion.Contains.Property.Value =
    ValueSet.Expansion.Contains.Property.Value.from(
      Code.of(
        this@ValueSetExpansionContainsPropertyValueSurrogate.valueCode,
        this@ValueSetExpansionContainsPropertyValueSurrogate._valueCode,
      ),
      this@ValueSetExpansionContainsPropertyValueSurrogate.valueCoding,
      R5String.of(
        this@ValueSetExpansionContainsPropertyValueSurrogate.valueString,
        this@ValueSetExpansionContainsPropertyValueSurrogate._valueString,
      ),
      Integer.of(
        this@ValueSetExpansionContainsPropertyValueSurrogate.valueInteger,
        this@ValueSetExpansionContainsPropertyValueSurrogate._valueInteger,
      ),
      R5Boolean.of(
        this@ValueSetExpansionContainsPropertyValueSurrogate.valueBoolean,
        this@ValueSetExpansionContainsPropertyValueSurrogate._valueBoolean,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@ValueSetExpansionContainsPropertyValueSurrogate.valueDateTime),
        this@ValueSetExpansionContainsPropertyValueSurrogate._valueDateTime,
      ),
      Decimal.of(
        this@ValueSetExpansionContainsPropertyValueSurrogate.valueDecimal,
        this@ValueSetExpansionContainsPropertyValueSurrogate._valueDecimal,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: ValueSet.Expansion.Contains.Property.Value
    ): ValueSetExpansionContainsPropertyValueSurrogate =
      with(model) {
        ValueSetExpansionContainsPropertyValueSurrogate(
          valueCode = this@with.asCode()?.value?.value,
          _valueCode = this@with.asCode()?.value?.toElement(),
          valueCoding = this@with.asCoding()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ValueSetExpansionContainsPropertySubPropertyValueSurrogate(
  public var valueCode: KotlinString? = null,
  public var _valueCode: Element? = null,
  public var valueCoding: Coding? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
) {
  public fun toModel(): ValueSet.Expansion.Contains.Property.SubProperty.Value =
    ValueSet.Expansion.Contains.Property.SubProperty.Value.from(
      Code.of(
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate.valueCode,
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate._valueCode,
      ),
      this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate.valueCoding,
      R5String.of(
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate.valueString,
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate._valueString,
      ),
      Integer.of(
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate.valueInteger,
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate._valueInteger,
      ),
      R5Boolean.of(
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate.valueBoolean,
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate._valueBoolean,
      ),
      DateTime.of(
        FhirDateTime.fromString(
          this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate.valueDateTime
        ),
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate._valueDateTime,
      ),
      Decimal.of(
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate.valueDecimal,
        this@ValueSetExpansionContainsPropertySubPropertyValueSurrogate._valueDecimal,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: ValueSet.Expansion.Contains.Property.SubProperty.Value
    ): ValueSetExpansionContainsPropertySubPropertyValueSurrogate =
      with(model) {
        ValueSetExpansionContainsPropertySubPropertyValueSurrogate(
          valueCode = this@with.asCode()?.value?.value,
          _valueCode = this@with.asCode()?.value?.toElement(),
          valueCoding = this@with.asCoding()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ValueSetSurrogate(
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
  public var versionAlgorithm: ValueSet.VersionAlgorithm? = null,
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
  public var immutable: KotlinBoolean? = null,
  public var _immutable: Element? = null,
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var copyrightLabel: KotlinString? = null,
  public var _copyrightLabel: Element? = null,
  public var approvalDate: KotlinString? = null,
  public var _approvalDate: Element? = null,
  public var lastReviewDate: KotlinString? = null,
  public var _lastReviewDate: Element? = null,
  public var effectivePeriod: Period? = null,
  public var topic: List<CodeableConcept>? = null,
  public var author: List<ContactDetail>? = null,
  public var editor: List<ContactDetail>? = null,
  public var reviewer: List<ContactDetail>? = null,
  public var endorser: List<ContactDetail>? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var compose: ValueSet.Compose? = null,
  public var expansion: ValueSet.Expansion? = null,
  public var scope: ValueSet.Scope? = null,
) {
  public fun toModel(): ValueSet =
    ValueSet(
      id = this@ValueSetSurrogate.id,
      meta = this@ValueSetSurrogate.meta,
      implicitRules =
        Uri.of(this@ValueSetSurrogate.implicitRules, this@ValueSetSurrogate._implicitRules),
      language = Code.of(this@ValueSetSurrogate.language, this@ValueSetSurrogate._language),
      text = this@ValueSetSurrogate.text,
      contained = this@ValueSetSurrogate.contained ?: listOf(),
      extension = this@ValueSetSurrogate.extension ?: listOf(),
      modifierExtension = this@ValueSetSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@ValueSetSurrogate.url, this@ValueSetSurrogate._url),
      identifier = this@ValueSetSurrogate.identifier ?: listOf(),
      version = R5String.of(this@ValueSetSurrogate.version, this@ValueSetSurrogate._version),
      versionAlgorithm = this@ValueSetSurrogate.versionAlgorithm,
      name = R5String.of(this@ValueSetSurrogate.name, this@ValueSetSurrogate._name),
      title = R5String.of(this@ValueSetSurrogate.title, this@ValueSetSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ValueSetSurrogate.status!!),
          this@ValueSetSurrogate._status,
        ),
      experimental =
        R5Boolean.of(this@ValueSetSurrogate.experimental, this@ValueSetSurrogate._experimental),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ValueSetSurrogate.date),
          this@ValueSetSurrogate._date,
        ),
      publisher = R5String.of(this@ValueSetSurrogate.publisher, this@ValueSetSurrogate._publisher),
      contact = this@ValueSetSurrogate.contact ?: listOf(),
      description =
        Markdown.of(this@ValueSetSurrogate.description, this@ValueSetSurrogate._description),
      useContext = this@ValueSetSurrogate.useContext ?: listOf(),
      jurisdiction = this@ValueSetSurrogate.jurisdiction ?: listOf(),
      immutable = R5Boolean.of(this@ValueSetSurrogate.immutable, this@ValueSetSurrogate._immutable),
      purpose = Markdown.of(this@ValueSetSurrogate.purpose, this@ValueSetSurrogate._purpose),
      copyright = Markdown.of(this@ValueSetSurrogate.copyright, this@ValueSetSurrogate._copyright),
      copyrightLabel =
        R5String.of(this@ValueSetSurrogate.copyrightLabel, this@ValueSetSurrogate._copyrightLabel),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@ValueSetSurrogate.approvalDate),
          this@ValueSetSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@ValueSetSurrogate.lastReviewDate),
          this@ValueSetSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@ValueSetSurrogate.effectivePeriod,
      topic = this@ValueSetSurrogate.topic ?: listOf(),
      author = this@ValueSetSurrogate.author ?: listOf(),
      editor = this@ValueSetSurrogate.editor ?: listOf(),
      reviewer = this@ValueSetSurrogate.reviewer ?: listOf(),
      endorser = this@ValueSetSurrogate.endorser ?: listOf(),
      relatedArtifact = this@ValueSetSurrogate.relatedArtifact ?: listOf(),
      compose = this@ValueSetSurrogate.compose,
      expansion = this@ValueSetSurrogate.expansion,
      scope = this@ValueSetSurrogate.scope,
    )

  public companion object {
    public fun fromModel(model: ValueSet): ValueSetSurrogate =
      with(model) {
        ValueSetSurrogate(
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
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          versionAlgorithm = this@with.versionAlgorithm,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
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
          immutable = this@with.immutable?.value,
          _immutable = this@with.immutable?.toElement(),
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          copyrightLabel = this@with.copyrightLabel?.value,
          _copyrightLabel = this@with.copyrightLabel?.toElement(),
          approvalDate = this@with.approvalDate?.value?.toString(),
          _approvalDate = this@with.approvalDate?.toElement(),
          lastReviewDate = this@with.lastReviewDate?.value?.toString(),
          _lastReviewDate = this@with.lastReviewDate?.toElement(),
          effectivePeriod = this@with.effectivePeriod,
          topic = this@with.topic.takeIf { it.isNotEmpty() },
          author = this@with.author.takeIf { it.isNotEmpty() },
          editor = this@with.editor.takeIf { it.isNotEmpty() },
          reviewer = this@with.reviewer.takeIf { it.isNotEmpty() },
          endorser = this@with.endorser.takeIf { it.isNotEmpty() },
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          compose = this@with.compose,
          expansion = this@with.expansion,
          scope = this@with.scope,
        )
      }
  }
}

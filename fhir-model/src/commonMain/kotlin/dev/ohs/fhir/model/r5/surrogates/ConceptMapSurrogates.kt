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
import com.google.fhir.model.r5.ConceptMap
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
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.ConceptMapRelationship
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
internal data class ConceptMapPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var uri: KotlinString? = null,
  public var _uri: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var system: KotlinString? = null,
  public var _system: Element? = null,
) {
  public fun toModel(): ConceptMap.Property =
    ConceptMap.Property(
      id = this@ConceptMapPropertySurrogate.id,
      extension = this@ConceptMapPropertySurrogate.extension ?: listOf(),
      modifierExtension = this@ConceptMapPropertySurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(this@ConceptMapPropertySurrogate.code, this@ConceptMapPropertySurrogate._code)!!,
      uri = Uri.of(this@ConceptMapPropertySurrogate.uri, this@ConceptMapPropertySurrogate._uri),
      description =
        R5String.of(
          this@ConceptMapPropertySurrogate.description,
          this@ConceptMapPropertySurrogate._description,
        ),
      type =
        Enumeration.of(
          ConceptMap.ConceptMapPropertyType.fromCode(this@ConceptMapPropertySurrogate.type!!),
          this@ConceptMapPropertySurrogate._type,
        ),
      system =
        Canonical.of(
          this@ConceptMapPropertySurrogate.system,
          this@ConceptMapPropertySurrogate._system,
        ),
    )

  public companion object {
    public fun fromModel(model: ConceptMap.Property): ConceptMapPropertySurrogate =
      with(model) {
        ConceptMapPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          uri = this@with.uri?.value,
          _uri = this@with.uri?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          system = this@with.system?.value,
          _system = this@with.system?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConceptMapAdditionalAttributeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var uri: KotlinString? = null,
  public var _uri: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
) {
  public fun toModel(): ConceptMap.AdditionalAttribute =
    ConceptMap.AdditionalAttribute(
      id = this@ConceptMapAdditionalAttributeSurrogate.id,
      extension = this@ConceptMapAdditionalAttributeSurrogate.extension ?: listOf(),
      modifierExtension = this@ConceptMapAdditionalAttributeSurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(
          this@ConceptMapAdditionalAttributeSurrogate.code,
          this@ConceptMapAdditionalAttributeSurrogate._code,
        )!!,
      uri =
        Uri.of(
          this@ConceptMapAdditionalAttributeSurrogate.uri,
          this@ConceptMapAdditionalAttributeSurrogate._uri,
        ),
      description =
        R5String.of(
          this@ConceptMapAdditionalAttributeSurrogate.description,
          this@ConceptMapAdditionalAttributeSurrogate._description,
        ),
      type =
        Enumeration.of(
          ConceptMap.ConceptMapAttributeType.fromCode(
            this@ConceptMapAdditionalAttributeSurrogate.type!!
          ),
          this@ConceptMapAdditionalAttributeSurrogate._type,
        ),
    )

  public companion object {
    public fun fromModel(
      model: ConceptMap.AdditionalAttribute
    ): ConceptMapAdditionalAttributeSurrogate =
      with(model) {
        ConceptMapAdditionalAttributeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          uri = this@with.uri?.value,
          _uri = this@with.uri?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConceptMapGroupSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var source: KotlinString? = null,
  public var _source: Element? = null,
  public var target: KotlinString? = null,
  public var _target: Element? = null,
  public var element: List<ConceptMap.Group.Element>? = null,
  public var unmapped: ConceptMap.Group.Unmapped? = null,
) {
  public fun toModel(): ConceptMap.Group =
    ConceptMap.Group(
      id = this@ConceptMapGroupSurrogate.id,
      extension = this@ConceptMapGroupSurrogate.extension ?: listOf(),
      modifierExtension = this@ConceptMapGroupSurrogate.modifierExtension ?: listOf(),
      source =
        Canonical.of(this@ConceptMapGroupSurrogate.source, this@ConceptMapGroupSurrogate._source),
      target =
        Canonical.of(this@ConceptMapGroupSurrogate.target, this@ConceptMapGroupSurrogate._target),
      element = this@ConceptMapGroupSurrogate.element ?: listOf(),
      unmapped = this@ConceptMapGroupSurrogate.unmapped,
    )

  public companion object {
    public fun fromModel(model: ConceptMap.Group): ConceptMapGroupSurrogate =
      with(model) {
        ConceptMapGroupSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          source = this@with.source?.value,
          _source = this@with.source?.toElement(),
          target = this@with.target?.value,
          _target = this@with.target?.toElement(),
          element = this@with.element.takeIf { it.isNotEmpty() },
          unmapped = this@with.unmapped,
        )
      }
  }
}

@Serializable
internal data class ConceptMapGroupElementSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var display: KotlinString? = null,
  public var _display: Element? = null,
  public var valueSet: KotlinString? = null,
  public var _valueSet: Element? = null,
  public var noMap: KotlinBoolean? = null,
  public var _noMap: Element? = null,
  public var target: List<ConceptMap.Group.Element.Target>? = null,
) {
  public fun toModel(): ConceptMap.Group.Element =
    ConceptMap.Group.Element(
      id = this@ConceptMapGroupElementSurrogate.id,
      extension = this@ConceptMapGroupElementSurrogate.extension ?: listOf(),
      modifierExtension = this@ConceptMapGroupElementSurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(
          this@ConceptMapGroupElementSurrogate.code,
          this@ConceptMapGroupElementSurrogate._code,
        ),
      display =
        R5String.of(
          this@ConceptMapGroupElementSurrogate.display,
          this@ConceptMapGroupElementSurrogate._display,
        ),
      valueSet =
        Canonical.of(
          this@ConceptMapGroupElementSurrogate.valueSet,
          this@ConceptMapGroupElementSurrogate._valueSet,
        ),
      noMap =
        R5Boolean.of(
          this@ConceptMapGroupElementSurrogate.noMap,
          this@ConceptMapGroupElementSurrogate._noMap,
        ),
      target = this@ConceptMapGroupElementSurrogate.target ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ConceptMap.Group.Element): ConceptMapGroupElementSurrogate =
      with(model) {
        ConceptMapGroupElementSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code?.value,
          _code = this@with.code?.toElement(),
          display = this@with.display?.value,
          _display = this@with.display?.toElement(),
          valueSet = this@with.valueSet?.value,
          _valueSet = this@with.valueSet?.toElement(),
          noMap = this@with.noMap?.value,
          _noMap = this@with.noMap?.toElement(),
          target = this@with.target.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ConceptMapGroupElementTargetSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var display: KotlinString? = null,
  public var _display: Element? = null,
  public var valueSet: KotlinString? = null,
  public var _valueSet: Element? = null,
  public var relationship: KotlinString? = null,
  public var _relationship: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
  public var `property`: List<ConceptMap.Group.Element.Target.Property>? = null,
  public var dependsOn: List<ConceptMap.Group.Element.Target.DependsOn>? = null,
  public var product: List<ConceptMap.Group.Element.Target.DependsOn>? = null,
) {
  public fun toModel(): ConceptMap.Group.Element.Target =
    ConceptMap.Group.Element.Target(
      id = this@ConceptMapGroupElementTargetSurrogate.id,
      extension = this@ConceptMapGroupElementTargetSurrogate.extension ?: listOf(),
      modifierExtension = this@ConceptMapGroupElementTargetSurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(
          this@ConceptMapGroupElementTargetSurrogate.code,
          this@ConceptMapGroupElementTargetSurrogate._code,
        ),
      display =
        R5String.of(
          this@ConceptMapGroupElementTargetSurrogate.display,
          this@ConceptMapGroupElementTargetSurrogate._display,
        ),
      valueSet =
        Canonical.of(
          this@ConceptMapGroupElementTargetSurrogate.valueSet,
          this@ConceptMapGroupElementTargetSurrogate._valueSet,
        ),
      relationship =
        Enumeration.of(
          ConceptMapRelationship.fromCode(
            this@ConceptMapGroupElementTargetSurrogate.relationship!!
          ),
          this@ConceptMapGroupElementTargetSurrogate._relationship,
        ),
      comment =
        R5String.of(
          this@ConceptMapGroupElementTargetSurrogate.comment,
          this@ConceptMapGroupElementTargetSurrogate._comment,
        ),
      `property` = this@ConceptMapGroupElementTargetSurrogate.`property` ?: listOf(),
      dependsOn = this@ConceptMapGroupElementTargetSurrogate.dependsOn ?: listOf(),
      product = this@ConceptMapGroupElementTargetSurrogate.product ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ConceptMap.Group.Element.Target
    ): ConceptMapGroupElementTargetSurrogate =
      with(model) {
        ConceptMapGroupElementTargetSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code?.value,
          _code = this@with.code?.toElement(),
          display = this@with.display?.value,
          _display = this@with.display?.toElement(),
          valueSet = this@with.valueSet?.value,
          _valueSet = this@with.valueSet?.toElement(),
          relationship = this@with.relationship.value?.getCode(),
          _relationship = this@with.relationship.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          dependsOn = this@with.dependsOn.takeIf { it.isNotEmpty() },
          product = this@with.product.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ConceptMapGroupElementTargetPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var `value`: ConceptMap.Group.Element.Target.Property.Value,
) {
  public fun toModel(): ConceptMap.Group.Element.Target.Property =
    ConceptMap.Group.Element.Target.Property(
      id = this@ConceptMapGroupElementTargetPropertySurrogate.id,
      extension = this@ConceptMapGroupElementTargetPropertySurrogate.extension ?: listOf(),
      modifierExtension =
        this@ConceptMapGroupElementTargetPropertySurrogate.modifierExtension ?: listOf(),
      code =
        Code.of(
          this@ConceptMapGroupElementTargetPropertySurrogate.code,
          this@ConceptMapGroupElementTargetPropertySurrogate._code,
        )!!,
      `value` = this@ConceptMapGroupElementTargetPropertySurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: ConceptMap.Group.Element.Target.Property
    ): ConceptMapGroupElementTargetPropertySurrogate =
      with(model) {
        ConceptMapGroupElementTargetPropertySurrogate(
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
internal data class ConceptMapGroupElementTargetDependsOnSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var attribute: KotlinString? = null,
  public var _attribute: Element? = null,
  public var `value`: ConceptMap.Group.Element.Target.DependsOn.Value? = null,
  public var valueSet: KotlinString? = null,
  public var _valueSet: Element? = null,
) {
  public fun toModel(): ConceptMap.Group.Element.Target.DependsOn =
    ConceptMap.Group.Element.Target.DependsOn(
      id = this@ConceptMapGroupElementTargetDependsOnSurrogate.id,
      extension = this@ConceptMapGroupElementTargetDependsOnSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ConceptMapGroupElementTargetDependsOnSurrogate.modifierExtension ?: listOf(),
      attribute =
        Code.of(
          this@ConceptMapGroupElementTargetDependsOnSurrogate.attribute,
          this@ConceptMapGroupElementTargetDependsOnSurrogate._attribute,
        )!!,
      `value` = this@ConceptMapGroupElementTargetDependsOnSurrogate.`value`,
      valueSet =
        Canonical.of(
          this@ConceptMapGroupElementTargetDependsOnSurrogate.valueSet,
          this@ConceptMapGroupElementTargetDependsOnSurrogate._valueSet,
        ),
    )

  public companion object {
    public fun fromModel(
      model: ConceptMap.Group.Element.Target.DependsOn
    ): ConceptMapGroupElementTargetDependsOnSurrogate =
      with(model) {
        ConceptMapGroupElementTargetDependsOnSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          attribute = this@with.attribute.value,
          _attribute = this@with.attribute.toElement(),
          `value` = this@with.`value`,
          valueSet = this@with.valueSet?.value,
          _valueSet = this@with.valueSet?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConceptMapGroupUnmappedSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var mode: KotlinString? = null,
  public var _mode: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var display: KotlinString? = null,
  public var _display: Element? = null,
  public var valueSet: KotlinString? = null,
  public var _valueSet: Element? = null,
  public var relationship: KotlinString? = null,
  public var _relationship: Element? = null,
  public var otherMap: KotlinString? = null,
  public var _otherMap: Element? = null,
) {
  public fun toModel(): ConceptMap.Group.Unmapped =
    ConceptMap.Group.Unmapped(
      id = this@ConceptMapGroupUnmappedSurrogate.id,
      extension = this@ConceptMapGroupUnmappedSurrogate.extension ?: listOf(),
      modifierExtension = this@ConceptMapGroupUnmappedSurrogate.modifierExtension ?: listOf(),
      mode =
        Enumeration.of(
          ConceptMap.ConceptMapGroupUnmappedMode.fromCode(
            this@ConceptMapGroupUnmappedSurrogate.mode!!
          ),
          this@ConceptMapGroupUnmappedSurrogate._mode,
        ),
      code =
        Code.of(
          this@ConceptMapGroupUnmappedSurrogate.code,
          this@ConceptMapGroupUnmappedSurrogate._code,
        ),
      display =
        R5String.of(
          this@ConceptMapGroupUnmappedSurrogate.display,
          this@ConceptMapGroupUnmappedSurrogate._display,
        ),
      valueSet =
        Canonical.of(
          this@ConceptMapGroupUnmappedSurrogate.valueSet,
          this@ConceptMapGroupUnmappedSurrogate._valueSet,
        ),
      relationship =
        this@ConceptMapGroupUnmappedSurrogate.relationship?.let {
          Enumeration.of(
            ConceptMapRelationship.fromCode(it),
            this@ConceptMapGroupUnmappedSurrogate._relationship,
          )
        },
      otherMap =
        Canonical.of(
          this@ConceptMapGroupUnmappedSurrogate.otherMap,
          this@ConceptMapGroupUnmappedSurrogate._otherMap,
        ),
    )

  public companion object {
    public fun fromModel(model: ConceptMap.Group.Unmapped): ConceptMapGroupUnmappedSurrogate =
      with(model) {
        ConceptMapGroupUnmappedSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          mode = this@with.mode.value?.getCode(),
          _mode = this@with.mode.toElement(),
          code = this@with.code?.value,
          _code = this@with.code?.toElement(),
          display = this@with.display?.value,
          _display = this@with.display?.toElement(),
          valueSet = this@with.valueSet?.value,
          _valueSet = this@with.valueSet?.toElement(),
          relationship = this@with.relationship?.value?.getCode(),
          _relationship = this@with.relationship?.toElement(),
          otherMap = this@with.otherMap?.value,
          _otherMap = this@with.otherMap?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConceptMapVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): ConceptMap.VersionAlgorithm =
    ConceptMap.VersionAlgorithm.from(
      R5String.of(
        this@ConceptMapVersionAlgorithmSurrogate.versionAlgorithmString,
        this@ConceptMapVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@ConceptMapVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(model: ConceptMap.VersionAlgorithm): ConceptMapVersionAlgorithmSurrogate =
      with(model) {
        ConceptMapVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class ConceptMapSourceScopeSurrogate(
  public var sourceScopeUri: KotlinString? = null,
  public var _sourceScopeUri: Element? = null,
  public var sourceScopeCanonical: KotlinString? = null,
  public var _sourceScopeCanonical: Element? = null,
) {
  public fun toModel(): ConceptMap.SourceScope =
    ConceptMap.SourceScope.from(
      Uri.of(
        this@ConceptMapSourceScopeSurrogate.sourceScopeUri,
        this@ConceptMapSourceScopeSurrogate._sourceScopeUri,
      ),
      Canonical.of(
        this@ConceptMapSourceScopeSurrogate.sourceScopeCanonical,
        this@ConceptMapSourceScopeSurrogate._sourceScopeCanonical,
      ),
    )!!

  public companion object {
    public fun fromModel(model: ConceptMap.SourceScope): ConceptMapSourceScopeSurrogate =
      with(model) {
        ConceptMapSourceScopeSurrogate(
          sourceScopeUri = this@with.asUri()?.value?.value,
          _sourceScopeUri = this@with.asUri()?.value?.toElement(),
          sourceScopeCanonical = this@with.asCanonical()?.value?.value,
          _sourceScopeCanonical = this@with.asCanonical()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConceptMapTargetScopeSurrogate(
  public var targetScopeUri: KotlinString? = null,
  public var _targetScopeUri: Element? = null,
  public var targetScopeCanonical: KotlinString? = null,
  public var _targetScopeCanonical: Element? = null,
) {
  public fun toModel(): ConceptMap.TargetScope =
    ConceptMap.TargetScope.from(
      Uri.of(
        this@ConceptMapTargetScopeSurrogate.targetScopeUri,
        this@ConceptMapTargetScopeSurrogate._targetScopeUri,
      ),
      Canonical.of(
        this@ConceptMapTargetScopeSurrogate.targetScopeCanonical,
        this@ConceptMapTargetScopeSurrogate._targetScopeCanonical,
      ),
    )!!

  public companion object {
    public fun fromModel(model: ConceptMap.TargetScope): ConceptMapTargetScopeSurrogate =
      with(model) {
        ConceptMapTargetScopeSurrogate(
          targetScopeUri = this@with.asUri()?.value?.value,
          _targetScopeUri = this@with.asUri()?.value?.toElement(),
          targetScopeCanonical = this@with.asCanonical()?.value?.value,
          _targetScopeCanonical = this@with.asCanonical()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConceptMapGroupElementTargetPropertyValueSurrogate(
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
  public var valueCode: KotlinString? = null,
  public var _valueCode: Element? = null,
) {
  public fun toModel(): ConceptMap.Group.Element.Target.Property.Value =
    ConceptMap.Group.Element.Target.Property.Value.from(
      this@ConceptMapGroupElementTargetPropertyValueSurrogate.valueCoding,
      R5String.of(
        this@ConceptMapGroupElementTargetPropertyValueSurrogate.valueString,
        this@ConceptMapGroupElementTargetPropertyValueSurrogate._valueString,
      ),
      Integer.of(
        this@ConceptMapGroupElementTargetPropertyValueSurrogate.valueInteger,
        this@ConceptMapGroupElementTargetPropertyValueSurrogate._valueInteger,
      ),
      R5Boolean.of(
        this@ConceptMapGroupElementTargetPropertyValueSurrogate.valueBoolean,
        this@ConceptMapGroupElementTargetPropertyValueSurrogate._valueBoolean,
      ),
      DateTime.of(
        FhirDateTime.fromString(
          this@ConceptMapGroupElementTargetPropertyValueSurrogate.valueDateTime
        ),
        this@ConceptMapGroupElementTargetPropertyValueSurrogate._valueDateTime,
      ),
      Decimal.of(
        this@ConceptMapGroupElementTargetPropertyValueSurrogate.valueDecimal,
        this@ConceptMapGroupElementTargetPropertyValueSurrogate._valueDecimal,
      ),
      Code.of(
        this@ConceptMapGroupElementTargetPropertyValueSurrogate.valueCode,
        this@ConceptMapGroupElementTargetPropertyValueSurrogate._valueCode,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: ConceptMap.Group.Element.Target.Property.Value
    ): ConceptMapGroupElementTargetPropertyValueSurrogate =
      with(model) {
        ConceptMapGroupElementTargetPropertyValueSurrogate(
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
          valueCode = this@with.asCode()?.value?.value,
          _valueCode = this@with.asCode()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ConceptMapGroupElementTargetDependsOnValueSurrogate(
  public var valueCode: KotlinString? = null,
  public var _valueCode: Element? = null,
  public var valueCoding: Coding? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueQuantity: Quantity? = null,
) {
  public fun toModel(): ConceptMap.Group.Element.Target.DependsOn.Value =
    ConceptMap.Group.Element.Target.DependsOn.Value.from(
      Code.of(
        this@ConceptMapGroupElementTargetDependsOnValueSurrogate.valueCode,
        this@ConceptMapGroupElementTargetDependsOnValueSurrogate._valueCode,
      ),
      this@ConceptMapGroupElementTargetDependsOnValueSurrogate.valueCoding,
      R5String.of(
        this@ConceptMapGroupElementTargetDependsOnValueSurrogate.valueString,
        this@ConceptMapGroupElementTargetDependsOnValueSurrogate._valueString,
      ),
      R5Boolean.of(
        this@ConceptMapGroupElementTargetDependsOnValueSurrogate.valueBoolean,
        this@ConceptMapGroupElementTargetDependsOnValueSurrogate._valueBoolean,
      ),
      this@ConceptMapGroupElementTargetDependsOnValueSurrogate.valueQuantity,
    )!!

  public companion object {
    public fun fromModel(
      model: ConceptMap.Group.Element.Target.DependsOn.Value
    ): ConceptMapGroupElementTargetDependsOnValueSurrogate =
      with(model) {
        ConceptMapGroupElementTargetDependsOnValueSurrogate(
          valueCode = this@with.asCode()?.value?.value,
          _valueCode = this@with.asCode()?.value?.toElement(),
          valueCoding = this@with.asCoding()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
        )
      }
  }
}

@Serializable
internal data class ConceptMapSurrogate(
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
  public var versionAlgorithm: ConceptMap.VersionAlgorithm? = null,
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
  public var `property`: List<ConceptMap.Property>? = null,
  public var additionalAttribute: List<ConceptMap.AdditionalAttribute>? = null,
  public var sourceScope: ConceptMap.SourceScope? = null,
  public var targetScope: ConceptMap.TargetScope? = null,
  public var group: List<ConceptMap.Group>? = null,
) {
  public fun toModel(): ConceptMap =
    ConceptMap(
      id = this@ConceptMapSurrogate.id,
      meta = this@ConceptMapSurrogate.meta,
      implicitRules =
        Uri.of(this@ConceptMapSurrogate.implicitRules, this@ConceptMapSurrogate._implicitRules),
      language = Code.of(this@ConceptMapSurrogate.language, this@ConceptMapSurrogate._language),
      text = this@ConceptMapSurrogate.text,
      contained = this@ConceptMapSurrogate.contained ?: listOf(),
      extension = this@ConceptMapSurrogate.extension ?: listOf(),
      modifierExtension = this@ConceptMapSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@ConceptMapSurrogate.url, this@ConceptMapSurrogate._url),
      identifier = this@ConceptMapSurrogate.identifier ?: listOf(),
      version = R5String.of(this@ConceptMapSurrogate.version, this@ConceptMapSurrogate._version),
      versionAlgorithm = this@ConceptMapSurrogate.versionAlgorithm,
      name = R5String.of(this@ConceptMapSurrogate.name, this@ConceptMapSurrogate._name),
      title = R5String.of(this@ConceptMapSurrogate.title, this@ConceptMapSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ConceptMapSurrogate.status!!),
          this@ConceptMapSurrogate._status,
        ),
      experimental =
        R5Boolean.of(this@ConceptMapSurrogate.experimental, this@ConceptMapSurrogate._experimental),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ConceptMapSurrogate.date),
          this@ConceptMapSurrogate._date,
        ),
      publisher =
        R5String.of(this@ConceptMapSurrogate.publisher, this@ConceptMapSurrogate._publisher),
      contact = this@ConceptMapSurrogate.contact ?: listOf(),
      description =
        Markdown.of(this@ConceptMapSurrogate.description, this@ConceptMapSurrogate._description),
      useContext = this@ConceptMapSurrogate.useContext ?: listOf(),
      jurisdiction = this@ConceptMapSurrogate.jurisdiction ?: listOf(),
      purpose = Markdown.of(this@ConceptMapSurrogate.purpose, this@ConceptMapSurrogate._purpose),
      copyright =
        Markdown.of(this@ConceptMapSurrogate.copyright, this@ConceptMapSurrogate._copyright),
      copyrightLabel =
        R5String.of(
          this@ConceptMapSurrogate.copyrightLabel,
          this@ConceptMapSurrogate._copyrightLabel,
        ),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@ConceptMapSurrogate.approvalDate),
          this@ConceptMapSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@ConceptMapSurrogate.lastReviewDate),
          this@ConceptMapSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@ConceptMapSurrogate.effectivePeriod,
      topic = this@ConceptMapSurrogate.topic ?: listOf(),
      author = this@ConceptMapSurrogate.author ?: listOf(),
      editor = this@ConceptMapSurrogate.editor ?: listOf(),
      reviewer = this@ConceptMapSurrogate.reviewer ?: listOf(),
      endorser = this@ConceptMapSurrogate.endorser ?: listOf(),
      relatedArtifact = this@ConceptMapSurrogate.relatedArtifact ?: listOf(),
      `property` = this@ConceptMapSurrogate.`property` ?: listOf(),
      additionalAttribute = this@ConceptMapSurrogate.additionalAttribute ?: listOf(),
      sourceScope = this@ConceptMapSurrogate.sourceScope,
      targetScope = this@ConceptMapSurrogate.targetScope,
      group = this@ConceptMapSurrogate.group ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ConceptMap): ConceptMapSurrogate =
      with(model) {
        ConceptMapSurrogate(
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
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          additionalAttribute = this@with.additionalAttribute.takeIf { it.isNotEmpty() },
          sourceScope = this@with.sourceScope,
          targetScope = this@with.targetScope,
          group = this@with.group.takeIf { it.isNotEmpty() },
        )
      }
  }
}

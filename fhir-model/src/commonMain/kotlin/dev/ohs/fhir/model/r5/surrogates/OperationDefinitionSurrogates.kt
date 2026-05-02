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
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.OperationDefinition
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.BindingStrength
import com.google.fhir.model.r5.terminologies.FHIRTypes
import com.google.fhir.model.r5.terminologies.PublicationStatus
import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class OperationDefinitionParameterSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var scope: List<KotlinString?>? = null,
  public var _scope: List<Element?>? = null,
  public var min: Int? = null,
  public var _min: Element? = null,
  public var max: KotlinString? = null,
  public var _max: Element? = null,
  public var documentation: KotlinString? = null,
  public var _documentation: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var allowedType: List<KotlinString?>? = null,
  public var _allowedType: List<Element?>? = null,
  public var targetProfile: List<KotlinString?>? = null,
  public var _targetProfile: List<Element?>? = null,
  public var searchType: KotlinString? = null,
  public var _searchType: Element? = null,
  public var binding: OperationDefinition.Parameter.Binding? = null,
  public var referencedFrom: List<OperationDefinition.Parameter.ReferencedFrom>? = null,
  public var part: List<OperationDefinition.Parameter>? = null,
) {
  public fun toModel(): OperationDefinition.Parameter =
    OperationDefinition.Parameter(
      id = this@OperationDefinitionParameterSurrogate.id,
      extension = this@OperationDefinitionParameterSurrogate.extension ?: listOf(),
      modifierExtension = this@OperationDefinitionParameterSurrogate.modifierExtension ?: listOf(),
      name =
        Code.of(
          this@OperationDefinitionParameterSurrogate.name,
          this@OperationDefinitionParameterSurrogate._name,
        )!!,
      use =
        Enumeration.of(
          OperationDefinition.OperationParameterUse.fromCode(
            this@OperationDefinitionParameterSurrogate.use!!
          ),
          this@OperationDefinitionParameterSurrogate._use,
        ),
      scope =
        if (
          this@OperationDefinitionParameterSurrogate.scope == null &&
            this@OperationDefinitionParameterSurrogate._scope == null
        ) {
          listOf()
        } else {
          (this@OperationDefinitionParameterSurrogate.scope
              ?: List(this@OperationDefinitionParameterSurrogate._scope!!.size) { null })
            .zip(
              this@OperationDefinitionParameterSurrogate._scope
                ?: List(this@OperationDefinitionParameterSurrogate.scope!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { OperationDefinition.OperationParameterScope.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      min =
        Integer.of(
          this@OperationDefinitionParameterSurrogate.min,
          this@OperationDefinitionParameterSurrogate._min,
        )!!,
      max =
        R5String.of(
          this@OperationDefinitionParameterSurrogate.max,
          this@OperationDefinitionParameterSurrogate._max,
        )!!,
      documentation =
        Markdown.of(
          this@OperationDefinitionParameterSurrogate.documentation,
          this@OperationDefinitionParameterSurrogate._documentation,
        ),
      type =
        this@OperationDefinitionParameterSurrogate.type?.let {
          Enumeration.of(FHIRTypes.fromCode(it), this@OperationDefinitionParameterSurrogate._type)
        },
      allowedType =
        if (
          this@OperationDefinitionParameterSurrogate.allowedType == null &&
            this@OperationDefinitionParameterSurrogate._allowedType == null
        ) {
          listOf()
        } else {
          (this@OperationDefinitionParameterSurrogate.allowedType
              ?: List(this@OperationDefinitionParameterSurrogate._allowedType!!.size) { null })
            .zip(
              this@OperationDefinitionParameterSurrogate._allowedType
                ?: List(this@OperationDefinitionParameterSurrogate.allowedType!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(value.let { FHIRTypes.fromCode(it!!) }, element)
            }
            .toList()
        },
      targetProfile =
        if (
          this@OperationDefinitionParameterSurrogate.targetProfile == null &&
            this@OperationDefinitionParameterSurrogate._targetProfile == null
        ) {
          listOf()
        } else {
          (this@OperationDefinitionParameterSurrogate.targetProfile
              ?: List(this@OperationDefinitionParameterSurrogate._targetProfile!!.size) { null })
            .zip(
              this@OperationDefinitionParameterSurrogate._targetProfile
                ?: List(this@OperationDefinitionParameterSurrogate.targetProfile!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      searchType =
        this@OperationDefinitionParameterSurrogate.searchType?.let {
          Enumeration.of(
            SearchParamType.fromCode(it),
            this@OperationDefinitionParameterSurrogate._searchType,
          )
        },
      binding = this@OperationDefinitionParameterSurrogate.binding,
      referencedFrom = this@OperationDefinitionParameterSurrogate.referencedFrom ?: listOf(),
      part = this@OperationDefinitionParameterSurrogate.part ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: OperationDefinition.Parameter
    ): OperationDefinitionParameterSurrogate =
      with(model) {
        OperationDefinitionParameterSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          use = this@with.use.value?.getCode(),
          _use = this@with.use.toElement(),
          scope =
            this@with.scope
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _scope =
            this@with.scope
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          min = this@with.min.value,
          _min = this@with.min.toElement(),
          max = this@with.max.value,
          _max = this@with.max.toElement(),
          documentation = this@with.documentation?.value,
          _documentation = this@with.documentation?.toElement(),
          type = this@with.type?.value?.getCode(),
          _type = this@with.type?.toElement(),
          allowedType =
            this@with.allowedType
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _allowedType =
            this@with.allowedType
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
          searchType = this@with.searchType?.value?.getCode(),
          _searchType = this@with.searchType?.toElement(),
          binding = this@with.binding,
          referencedFrom = this@with.referencedFrom.takeIf { it.isNotEmpty() },
          part = this@with.part.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class OperationDefinitionParameterBindingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var strength: KotlinString? = null,
  public var _strength: Element? = null,
  public var valueSet: KotlinString? = null,
  public var _valueSet: Element? = null,
) {
  public fun toModel(): OperationDefinition.Parameter.Binding =
    OperationDefinition.Parameter.Binding(
      id = this@OperationDefinitionParameterBindingSurrogate.id,
      extension = this@OperationDefinitionParameterBindingSurrogate.extension ?: listOf(),
      modifierExtension =
        this@OperationDefinitionParameterBindingSurrogate.modifierExtension ?: listOf(),
      strength =
        Enumeration.of(
          BindingStrength.fromCode(this@OperationDefinitionParameterBindingSurrogate.strength!!),
          this@OperationDefinitionParameterBindingSurrogate._strength,
        ),
      valueSet =
        Canonical.of(
          this@OperationDefinitionParameterBindingSurrogate.valueSet,
          this@OperationDefinitionParameterBindingSurrogate._valueSet,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: OperationDefinition.Parameter.Binding
    ): OperationDefinitionParameterBindingSurrogate =
      with(model) {
        OperationDefinitionParameterBindingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          strength = this@with.strength.value?.getCode(),
          _strength = this@with.strength.toElement(),
          valueSet = this@with.valueSet.value,
          _valueSet = this@with.valueSet.toElement(),
        )
      }
  }
}

@Serializable
internal data class OperationDefinitionParameterReferencedFromSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var source: KotlinString? = null,
  public var _source: Element? = null,
  public var sourceId: KotlinString? = null,
  public var _sourceId: Element? = null,
) {
  public fun toModel(): OperationDefinition.Parameter.ReferencedFrom =
    OperationDefinition.Parameter.ReferencedFrom(
      id = this@OperationDefinitionParameterReferencedFromSurrogate.id,
      extension = this@OperationDefinitionParameterReferencedFromSurrogate.extension ?: listOf(),
      modifierExtension =
        this@OperationDefinitionParameterReferencedFromSurrogate.modifierExtension ?: listOf(),
      source =
        R5String.of(
          this@OperationDefinitionParameterReferencedFromSurrogate.source,
          this@OperationDefinitionParameterReferencedFromSurrogate._source,
        )!!,
      sourceId =
        R5String.of(
          this@OperationDefinitionParameterReferencedFromSurrogate.sourceId,
          this@OperationDefinitionParameterReferencedFromSurrogate._sourceId,
        ),
    )

  public companion object {
    public fun fromModel(
      model: OperationDefinition.Parameter.ReferencedFrom
    ): OperationDefinitionParameterReferencedFromSurrogate =
      with(model) {
        OperationDefinitionParameterReferencedFromSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          source = this@with.source.value,
          _source = this@with.source.toElement(),
          sourceId = this@with.sourceId?.value,
          _sourceId = this@with.sourceId?.toElement(),
        )
      }
  }
}

@Serializable
internal data class OperationDefinitionOverloadSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var parameterName: List<KotlinString?>? = null,
  public var _parameterName: List<Element?>? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
) {
  public fun toModel(): OperationDefinition.Overload =
    OperationDefinition.Overload(
      id = this@OperationDefinitionOverloadSurrogate.id,
      extension = this@OperationDefinitionOverloadSurrogate.extension ?: listOf(),
      modifierExtension = this@OperationDefinitionOverloadSurrogate.modifierExtension ?: listOf(),
      parameterName =
        if (
          this@OperationDefinitionOverloadSurrogate.parameterName == null &&
            this@OperationDefinitionOverloadSurrogate._parameterName == null
        ) {
          listOf()
        } else {
          (this@OperationDefinitionOverloadSurrogate.parameterName
              ?: List(this@OperationDefinitionOverloadSurrogate._parameterName!!.size) { null })
            .zip(
              this@OperationDefinitionOverloadSurrogate._parameterName
                ?: List(this@OperationDefinitionOverloadSurrogate.parameterName!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      comment =
        R5String.of(
          this@OperationDefinitionOverloadSurrogate.comment,
          this@OperationDefinitionOverloadSurrogate._comment,
        ),
    )

  public companion object {
    public fun fromModel(
      model: OperationDefinition.Overload
    ): OperationDefinitionOverloadSurrogate =
      with(model) {
        OperationDefinitionOverloadSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          parameterName =
            this@with.parameterName.map { it.value }.toList().takeUnless { it.all { it == null } },
          _parameterName =
            this@with.parameterName
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
        )
      }
  }
}

@Serializable
internal data class OperationDefinitionVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): OperationDefinition.VersionAlgorithm =
    OperationDefinition.VersionAlgorithm.from(
      R5String.of(
        this@OperationDefinitionVersionAlgorithmSurrogate.versionAlgorithmString,
        this@OperationDefinitionVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@OperationDefinitionVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(
      model: OperationDefinition.VersionAlgorithm
    ): OperationDefinitionVersionAlgorithmSurrogate =
      with(model) {
        OperationDefinitionVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class OperationDefinitionSurrogate(
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
  public var versionAlgorithm: OperationDefinition.VersionAlgorithm? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var kind: KotlinString? = null,
  public var _kind: Element? = null,
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
  public var affectsState: KotlinBoolean? = null,
  public var _affectsState: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
  public var base: KotlinString? = null,
  public var _base: Element? = null,
  public var resource: List<KotlinString?>? = null,
  public var _resource: List<Element?>? = null,
  public var system: KotlinBoolean? = null,
  public var _system: Element? = null,
  public var type: KotlinBoolean? = null,
  public var _type: Element? = null,
  public var instance: KotlinBoolean? = null,
  public var _instance: Element? = null,
  public var inputProfile: KotlinString? = null,
  public var _inputProfile: Element? = null,
  public var outputProfile: KotlinString? = null,
  public var _outputProfile: Element? = null,
  public var parameter: List<OperationDefinition.Parameter>? = null,
  public var overload: List<OperationDefinition.Overload>? = null,
) {
  public fun toModel(): OperationDefinition =
    OperationDefinition(
      id = this@OperationDefinitionSurrogate.id,
      meta = this@OperationDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@OperationDefinitionSurrogate.implicitRules,
          this@OperationDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@OperationDefinitionSurrogate.language,
          this@OperationDefinitionSurrogate._language,
        ),
      text = this@OperationDefinitionSurrogate.text,
      contained = this@OperationDefinitionSurrogate.contained ?: listOf(),
      extension = this@OperationDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@OperationDefinitionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@OperationDefinitionSurrogate.url, this@OperationDefinitionSurrogate._url),
      identifier = this@OperationDefinitionSurrogate.identifier ?: listOf(),
      version =
        R5String.of(
          this@OperationDefinitionSurrogate.version,
          this@OperationDefinitionSurrogate._version,
        ),
      versionAlgorithm = this@OperationDefinitionSurrogate.versionAlgorithm,
      name =
        R5String.of(
          this@OperationDefinitionSurrogate.name,
          this@OperationDefinitionSurrogate._name,
        )!!,
      title =
        R5String.of(
          this@OperationDefinitionSurrogate.title,
          this@OperationDefinitionSurrogate._title,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@OperationDefinitionSurrogate.status!!),
          this@OperationDefinitionSurrogate._status,
        ),
      kind =
        Enumeration.of(
          OperationDefinition.OperationKind.fromCode(this@OperationDefinitionSurrogate.kind!!),
          this@OperationDefinitionSurrogate._kind,
        ),
      experimental =
        R5Boolean.of(
          this@OperationDefinitionSurrogate.experimental,
          this@OperationDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@OperationDefinitionSurrogate.date),
          this@OperationDefinitionSurrogate._date,
        ),
      publisher =
        R5String.of(
          this@OperationDefinitionSurrogate.publisher,
          this@OperationDefinitionSurrogate._publisher,
        ),
      contact = this@OperationDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@OperationDefinitionSurrogate.description,
          this@OperationDefinitionSurrogate._description,
        ),
      useContext = this@OperationDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@OperationDefinitionSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(
          this@OperationDefinitionSurrogate.purpose,
          this@OperationDefinitionSurrogate._purpose,
        ),
      copyright =
        Markdown.of(
          this@OperationDefinitionSurrogate.copyright,
          this@OperationDefinitionSurrogate._copyright,
        ),
      copyrightLabel =
        R5String.of(
          this@OperationDefinitionSurrogate.copyrightLabel,
          this@OperationDefinitionSurrogate._copyrightLabel,
        ),
      affectsState =
        R5Boolean.of(
          this@OperationDefinitionSurrogate.affectsState,
          this@OperationDefinitionSurrogate._affectsState,
        ),
      code =
        Code.of(this@OperationDefinitionSurrogate.code, this@OperationDefinitionSurrogate._code)!!,
      comment =
        Markdown.of(
          this@OperationDefinitionSurrogate.comment,
          this@OperationDefinitionSurrogate._comment,
        ),
      base =
        Canonical.of(
          this@OperationDefinitionSurrogate.base,
          this@OperationDefinitionSurrogate._base,
        ),
      resource =
        if (
          this@OperationDefinitionSurrogate.resource == null &&
            this@OperationDefinitionSurrogate._resource == null
        ) {
          listOf()
        } else {
          (this@OperationDefinitionSurrogate.resource
              ?: List(this@OperationDefinitionSurrogate._resource!!.size) { null })
            .zip(
              this@OperationDefinitionSurrogate._resource
                ?: List(this@OperationDefinitionSurrogate.resource!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { OperationDefinition.VersionIndependentResourceTypesAll.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      system =
        R5Boolean.of(
          this@OperationDefinitionSurrogate.system,
          this@OperationDefinitionSurrogate._system,
        )!!,
      type =
        R5Boolean.of(
          this@OperationDefinitionSurrogate.type,
          this@OperationDefinitionSurrogate._type,
        )!!,
      instance =
        R5Boolean.of(
          this@OperationDefinitionSurrogate.instance,
          this@OperationDefinitionSurrogate._instance,
        )!!,
      inputProfile =
        Canonical.of(
          this@OperationDefinitionSurrogate.inputProfile,
          this@OperationDefinitionSurrogate._inputProfile,
        ),
      outputProfile =
        Canonical.of(
          this@OperationDefinitionSurrogate.outputProfile,
          this@OperationDefinitionSurrogate._outputProfile,
        ),
      parameter = this@OperationDefinitionSurrogate.parameter ?: listOf(),
      overload = this@OperationDefinitionSurrogate.overload ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: OperationDefinition): OperationDefinitionSurrogate =
      with(model) {
        OperationDefinitionSurrogate(
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
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          kind = this@with.kind.value?.getCode(),
          _kind = this@with.kind.toElement(),
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
          affectsState = this@with.affectsState?.value,
          _affectsState = this@with.affectsState?.toElement(),
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
          base = this@with.base?.value,
          _base = this@with.base?.toElement(),
          resource =
            this@with.resource
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _resource =
            this@with.resource
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          system = this@with.system.value,
          _system = this@with.system.toElement(),
          type = this@with.type.value,
          _type = this@with.type.toElement(),
          instance = this@with.instance.value,
          _instance = this@with.instance.toElement(),
          inputProfile = this@with.inputProfile?.value,
          _inputProfile = this@with.inputProfile?.toElement(),
          outputProfile = this@with.outputProfile?.value,
          _outputProfile = this@with.outputProfile?.toElement(),
          parameter = this@with.parameter.takeIf { it.isNotEmpty() },
          overload = this@with.overload.takeIf { it.isNotEmpty() },
        )
      }
  }
}

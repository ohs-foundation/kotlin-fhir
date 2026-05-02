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

import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Canonical
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.ContactDetail
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Markdown
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.SearchParameter
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.UsageContext
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.PublicationStatus
import com.google.fhir.model.r4.terminologies.ResourceType
import com.google.fhir.model.r4.terminologies.SearchParamType
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SearchParameterComponentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var definition: KotlinString? = null,
  public var _definition: Element? = null,
  public var expression: KotlinString? = null,
  public var _expression: Element? = null,
) {
  public fun toModel(): SearchParameter.Component =
    SearchParameter.Component(
      id = this@SearchParameterComponentSurrogate.id,
      extension = this@SearchParameterComponentSurrogate.extension ?: listOf(),
      modifierExtension = this@SearchParameterComponentSurrogate.modifierExtension ?: listOf(),
      definition =
        Canonical.of(
          this@SearchParameterComponentSurrogate.definition,
          this@SearchParameterComponentSurrogate._definition,
        )!!,
      expression =
        R4String.of(
          this@SearchParameterComponentSurrogate.expression,
          this@SearchParameterComponentSurrogate._expression,
        )!!,
    )

  public companion object {
    public fun fromModel(model: SearchParameter.Component): SearchParameterComponentSurrogate =
      with(model) {
        SearchParameterComponentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          definition = this@with.definition.value,
          _definition = this@with.definition.toElement(),
          expression = this@with.expression.value,
          _expression = this@with.expression.toElement(),
        )
      }
  }
}

@Serializable
internal data class SearchParameterSurrogate(
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
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var derivedFrom: KotlinString? = null,
  public var _derivedFrom: Element? = null,
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
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var base: List<KotlinString?>? = null,
  public var _base: List<Element?>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var expression: KotlinString? = null,
  public var _expression: Element? = null,
  public var xpath: KotlinString? = null,
  public var _xpath: Element? = null,
  public var xpathUsage: KotlinString? = null,
  public var _xpathUsage: Element? = null,
  public var target: List<KotlinString?>? = null,
  public var _target: List<Element?>? = null,
  public var multipleOr: KotlinBoolean? = null,
  public var _multipleOr: Element? = null,
  public var multipleAnd: KotlinBoolean? = null,
  public var _multipleAnd: Element? = null,
  public var comparator: List<KotlinString?>? = null,
  public var _comparator: List<Element?>? = null,
  public var modifier: List<KotlinString?>? = null,
  public var _modifier: List<Element?>? = null,
  public var chain: List<KotlinString?>? = null,
  public var _chain: List<Element?>? = null,
  public var component: List<SearchParameter.Component>? = null,
) {
  public fun toModel(): SearchParameter =
    SearchParameter(
      id = this@SearchParameterSurrogate.id,
      meta = this@SearchParameterSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SearchParameterSurrogate.implicitRules,
          this@SearchParameterSurrogate._implicitRules,
        ),
      language =
        Code.of(this@SearchParameterSurrogate.language, this@SearchParameterSurrogate._language),
      text = this@SearchParameterSurrogate.text,
      contained = this@SearchParameterSurrogate.contained ?: listOf(),
      extension = this@SearchParameterSurrogate.extension ?: listOf(),
      modifierExtension = this@SearchParameterSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@SearchParameterSurrogate.url, this@SearchParameterSurrogate._url)!!,
      version =
        R4String.of(this@SearchParameterSurrogate.version, this@SearchParameterSurrogate._version),
      name = R4String.of(this@SearchParameterSurrogate.name, this@SearchParameterSurrogate._name)!!,
      derivedFrom =
        Canonical.of(
          this@SearchParameterSurrogate.derivedFrom,
          this@SearchParameterSurrogate._derivedFrom,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@SearchParameterSurrogate.status!!),
          this@SearchParameterSurrogate._status,
        ),
      experimental =
        R4Boolean.of(
          this@SearchParameterSurrogate.experimental,
          this@SearchParameterSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@SearchParameterSurrogate.date),
          this@SearchParameterSurrogate._date,
        ),
      publisher =
        R4String.of(
          this@SearchParameterSurrogate.publisher,
          this@SearchParameterSurrogate._publisher,
        ),
      contact = this@SearchParameterSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@SearchParameterSurrogate.description,
          this@SearchParameterSurrogate._description,
        )!!,
      useContext = this@SearchParameterSurrogate.useContext ?: listOf(),
      jurisdiction = this@SearchParameterSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(this@SearchParameterSurrogate.purpose, this@SearchParameterSurrogate._purpose),
      code = Code.of(this@SearchParameterSurrogate.code, this@SearchParameterSurrogate._code)!!,
      base =
        if (
          this@SearchParameterSurrogate.base == null && this@SearchParameterSurrogate._base == null
        ) {
          listOf()
        } else {
          (this@SearchParameterSurrogate.base
              ?: List(this@SearchParameterSurrogate._base!!.size) { null })
            .zip(
              this@SearchParameterSurrogate._base
                ?: List(this@SearchParameterSurrogate.base!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(value.let { ResourceType.fromCode(it!!) }, element)
            }
            .toList()
        },
      type =
        Enumeration.of(
          SearchParamType.fromCode(this@SearchParameterSurrogate.type!!),
          this@SearchParameterSurrogate._type,
        ),
      expression =
        R4String.of(
          this@SearchParameterSurrogate.expression,
          this@SearchParameterSurrogate._expression,
        ),
      xpath =
        R4String.of(this@SearchParameterSurrogate.xpath, this@SearchParameterSurrogate._xpath),
      xpathUsage =
        this@SearchParameterSurrogate.xpathUsage?.let {
          Enumeration.of(
            SearchParameter.XPathUsageType.fromCode(it),
            this@SearchParameterSurrogate._xpathUsage,
          )
        },
      target =
        if (
          this@SearchParameterSurrogate.target == null &&
            this@SearchParameterSurrogate._target == null
        ) {
          listOf()
        } else {
          (this@SearchParameterSurrogate.target
              ?: List(this@SearchParameterSurrogate._target!!.size) { null })
            .zip(
              this@SearchParameterSurrogate._target
                ?: List(this@SearchParameterSurrogate.target!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(value.let { ResourceType.fromCode(it!!) }, element)
            }
            .toList()
        },
      multipleOr =
        R4Boolean.of(
          this@SearchParameterSurrogate.multipleOr,
          this@SearchParameterSurrogate._multipleOr,
        ),
      multipleAnd =
        R4Boolean.of(
          this@SearchParameterSurrogate.multipleAnd,
          this@SearchParameterSurrogate._multipleAnd,
        ),
      comparator =
        if (
          this@SearchParameterSurrogate.comparator == null &&
            this@SearchParameterSurrogate._comparator == null
        ) {
          listOf()
        } else {
          (this@SearchParameterSurrogate.comparator
              ?: List(this@SearchParameterSurrogate._comparator!!.size) { null })
            .zip(
              this@SearchParameterSurrogate._comparator
                ?: List(this@SearchParameterSurrogate.comparator!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(value.let { SearchParameter.SearchComparator.fromCode(it!!) }, element)
            }
            .toList()
        },
      modifier =
        if (
          this@SearchParameterSurrogate.modifier == null &&
            this@SearchParameterSurrogate._modifier == null
        ) {
          listOf()
        } else {
          (this@SearchParameterSurrogate.modifier
              ?: List(this@SearchParameterSurrogate._modifier!!.size) { null })
            .zip(
              this@SearchParameterSurrogate._modifier
                ?: List(this@SearchParameterSurrogate.modifier!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { SearchParameter.SearchModifierCode.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      chain =
        if (
          this@SearchParameterSurrogate.chain == null &&
            this@SearchParameterSurrogate._chain == null
        ) {
          listOf()
        } else {
          (this@SearchParameterSurrogate.chain
              ?: List(this@SearchParameterSurrogate._chain!!.size) { null })
            .zip(
              this@SearchParameterSurrogate._chain
                ?: List(this@SearchParameterSurrogate.chain!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      component = this@SearchParameterSurrogate.component ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SearchParameter): SearchParameterSurrogate =
      with(model) {
        SearchParameterSurrogate(
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
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          name = this@with.name.value,
          _name = this@with.name.toElement(),
          derivedFrom = this@with.derivedFrom?.value,
          _derivedFrom = this@with.derivedFrom?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description.value,
          _description = this@with.description.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          code = this@with.code.value,
          _code = this@with.code.toElement(),
          base =
            this@with.base
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _base =
            this@with.base
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          expression = this@with.expression?.value,
          _expression = this@with.expression?.toElement(),
          xpath = this@with.xpath?.value,
          _xpath = this@with.xpath?.toElement(),
          xpathUsage = this@with.xpathUsage?.value?.getCode(),
          _xpathUsage = this@with.xpathUsage?.toElement(),
          target =
            this@with.target
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _target =
            this@with.target
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          multipleOr = this@with.multipleOr?.value,
          _multipleOr = this@with.multipleOr?.toElement(),
          multipleAnd = this@with.multipleAnd?.value,
          _multipleAnd = this@with.multipleAnd?.toElement(),
          comparator =
            this@with.comparator
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _comparator =
            this@with.comparator
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          modifier =
            this@with.modifier
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _modifier =
            this@with.modifier
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          chain = this@with.chain.map { it.value }.toList().takeUnless { it.all { it == null } },
          _chain =
            this@with.chain
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          component = this@with.component.takeIf { it.isNotEmpty() },
        )
      }
  }
}

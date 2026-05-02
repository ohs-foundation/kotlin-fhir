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

import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.GraphDefinition
import com.google.fhir.model.r4b.Integer
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import com.google.fhir.model.r4b.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class GraphDefinitionLinkSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var path: KotlinString? = null,
  public var _path: Element? = null,
  public var sliceName: KotlinString? = null,
  public var _sliceName: Element? = null,
  public var min: Int? = null,
  public var _min: Element? = null,
  public var max: KotlinString? = null,
  public var _max: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var target: List<GraphDefinition.Link.Target>? = null,
) {
  public fun toModel(): GraphDefinition.Link =
    GraphDefinition.Link(
      id = this@GraphDefinitionLinkSurrogate.id,
      extension = this@GraphDefinitionLinkSurrogate.extension ?: listOf(),
      modifierExtension = this@GraphDefinitionLinkSurrogate.modifierExtension ?: listOf(),
      path =
        R4bString.of(
          this@GraphDefinitionLinkSurrogate.path,
          this@GraphDefinitionLinkSurrogate._path,
        ),
      sliceName =
        R4bString.of(
          this@GraphDefinitionLinkSurrogate.sliceName,
          this@GraphDefinitionLinkSurrogate._sliceName,
        ),
      min =
        Integer.of(this@GraphDefinitionLinkSurrogate.min, this@GraphDefinitionLinkSurrogate._min),
      max =
        R4bString.of(this@GraphDefinitionLinkSurrogate.max, this@GraphDefinitionLinkSurrogate._max),
      description =
        R4bString.of(
          this@GraphDefinitionLinkSurrogate.description,
          this@GraphDefinitionLinkSurrogate._description,
        ),
      target = this@GraphDefinitionLinkSurrogate.target ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: GraphDefinition.Link): GraphDefinitionLinkSurrogate =
      with(model) {
        GraphDefinitionLinkSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          path = this@with.path?.value,
          _path = this@with.path?.toElement(),
          sliceName = this@with.sliceName?.value,
          _sliceName = this@with.sliceName?.toElement(),
          min = this@with.min?.value,
          _min = this@with.min?.toElement(),
          max = this@with.max?.value,
          _max = this@with.max?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          target = this@with.target.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class GraphDefinitionLinkTargetSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var params: KotlinString? = null,
  public var _params: Element? = null,
  public var profile: KotlinString? = null,
  public var _profile: Element? = null,
  public var compartment: List<GraphDefinition.Link.Target.Compartment>? = null,
  public var link: List<GraphDefinition.Link>? = null,
) {
  public fun toModel(): GraphDefinition.Link.Target =
    GraphDefinition.Link.Target(
      id = this@GraphDefinitionLinkTargetSurrogate.id,
      extension = this@GraphDefinitionLinkTargetSurrogate.extension ?: listOf(),
      modifierExtension = this@GraphDefinitionLinkTargetSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          ResourceType.fromCode(this@GraphDefinitionLinkTargetSurrogate.type!!),
          this@GraphDefinitionLinkTargetSurrogate._type,
        ),
      params =
        R4bString.of(
          this@GraphDefinitionLinkTargetSurrogate.params,
          this@GraphDefinitionLinkTargetSurrogate._params,
        ),
      profile =
        Canonical.of(
          this@GraphDefinitionLinkTargetSurrogate.profile,
          this@GraphDefinitionLinkTargetSurrogate._profile,
        ),
      compartment = this@GraphDefinitionLinkTargetSurrogate.compartment ?: listOf(),
      link = this@GraphDefinitionLinkTargetSurrogate.link ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: GraphDefinition.Link.Target): GraphDefinitionLinkTargetSurrogate =
      with(model) {
        GraphDefinitionLinkTargetSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          params = this@with.params?.value,
          _params = this@with.params?.toElement(),
          profile = this@with.profile?.value,
          _profile = this@with.profile?.toElement(),
          compartment = this@with.compartment.takeIf { it.isNotEmpty() },
          link = this@with.link.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class GraphDefinitionLinkTargetCompartmentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var rule: KotlinString? = null,
  public var _rule: Element? = null,
  public var expression: KotlinString? = null,
  public var _expression: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
) {
  public fun toModel(): GraphDefinition.Link.Target.Compartment =
    GraphDefinition.Link.Target.Compartment(
      id = this@GraphDefinitionLinkTargetCompartmentSurrogate.id,
      extension = this@GraphDefinitionLinkTargetCompartmentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@GraphDefinitionLinkTargetCompartmentSurrogate.modifierExtension ?: listOf(),
      use =
        Enumeration.of(
          GraphDefinition.GraphCompartmentUse.fromCode(
            this@GraphDefinitionLinkTargetCompartmentSurrogate.use!!
          ),
          this@GraphDefinitionLinkTargetCompartmentSurrogate._use,
        ),
      code =
        Enumeration.of(
          GraphDefinition.CompartmentType.fromCode(
            this@GraphDefinitionLinkTargetCompartmentSurrogate.code!!
          ),
          this@GraphDefinitionLinkTargetCompartmentSurrogate._code,
        ),
      rule =
        Enumeration.of(
          GraphDefinition.GraphCompartmentRule.fromCode(
            this@GraphDefinitionLinkTargetCompartmentSurrogate.rule!!
          ),
          this@GraphDefinitionLinkTargetCompartmentSurrogate._rule,
        ),
      expression =
        R4bString.of(
          this@GraphDefinitionLinkTargetCompartmentSurrogate.expression,
          this@GraphDefinitionLinkTargetCompartmentSurrogate._expression,
        ),
      description =
        R4bString.of(
          this@GraphDefinitionLinkTargetCompartmentSurrogate.description,
          this@GraphDefinitionLinkTargetCompartmentSurrogate._description,
        ),
    )

  public companion object {
    public fun fromModel(
      model: GraphDefinition.Link.Target.Compartment
    ): GraphDefinitionLinkTargetCompartmentSurrogate =
      with(model) {
        GraphDefinitionLinkTargetCompartmentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          use = this@with.use.value?.getCode(),
          _use = this@with.use.toElement(),
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          rule = this@with.rule.value?.getCode(),
          _rule = this@with.rule.toElement(),
          expression = this@with.expression?.value,
          _expression = this@with.expression?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
        )
      }
  }
}

@Serializable
internal data class GraphDefinitionSurrogate(
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
  public var start: KotlinString? = null,
  public var _start: Element? = null,
  public var profile: KotlinString? = null,
  public var _profile: Element? = null,
  public var link: List<GraphDefinition.Link>? = null,
) {
  public fun toModel(): GraphDefinition =
    GraphDefinition(
      id = this@GraphDefinitionSurrogate.id,
      meta = this@GraphDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@GraphDefinitionSurrogate.implicitRules,
          this@GraphDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(this@GraphDefinitionSurrogate.language, this@GraphDefinitionSurrogate._language),
      text = this@GraphDefinitionSurrogate.text,
      contained = this@GraphDefinitionSurrogate.contained ?: listOf(),
      extension = this@GraphDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@GraphDefinitionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@GraphDefinitionSurrogate.url, this@GraphDefinitionSurrogate._url),
      version =
        R4bString.of(this@GraphDefinitionSurrogate.version, this@GraphDefinitionSurrogate._version),
      name =
        R4bString.of(this@GraphDefinitionSurrogate.name, this@GraphDefinitionSurrogate._name)!!,
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@GraphDefinitionSurrogate.status!!),
          this@GraphDefinitionSurrogate._status,
        ),
      experimental =
        R4bBoolean.of(
          this@GraphDefinitionSurrogate.experimental,
          this@GraphDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@GraphDefinitionSurrogate.date),
          this@GraphDefinitionSurrogate._date,
        ),
      publisher =
        R4bString.of(
          this@GraphDefinitionSurrogate.publisher,
          this@GraphDefinitionSurrogate._publisher,
        ),
      contact = this@GraphDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@GraphDefinitionSurrogate.description,
          this@GraphDefinitionSurrogate._description,
        ),
      useContext = this@GraphDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@GraphDefinitionSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(this@GraphDefinitionSurrogate.purpose, this@GraphDefinitionSurrogate._purpose),
      start =
        Enumeration.of(
          ResourceType.fromCode(this@GraphDefinitionSurrogate.start!!),
          this@GraphDefinitionSurrogate._start,
        ),
      profile =
        Canonical.of(this@GraphDefinitionSurrogate.profile, this@GraphDefinitionSurrogate._profile),
      link = this@GraphDefinitionSurrogate.link ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: GraphDefinition): GraphDefinitionSurrogate =
      with(model) {
        GraphDefinitionSurrogate(
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
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          name = this@with.name.value,
          _name = this@with.name.toElement(),
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
          start = this@with.start.value?.getCode(),
          _start = this@with.start.toElement(),
          profile = this@with.profile?.value,
          _profile = this@with.profile?.toElement(),
          link = this@with.link.takeIf { it.isNotEmpty() },
        )
      }
  }
}

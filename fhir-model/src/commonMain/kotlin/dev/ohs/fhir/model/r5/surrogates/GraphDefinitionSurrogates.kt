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
import com.google.fhir.model.r5.GraphDefinition
import com.google.fhir.model.r5.Id
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class GraphDefinitionNodeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var nodeId: KotlinString? = null,
  public var _nodeId: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var profile: KotlinString? = null,
  public var _profile: Element? = null,
) {
  public fun toModel(): GraphDefinition.Node =
    GraphDefinition.Node(
      id = this@GraphDefinitionNodeSurrogate.id,
      extension = this@GraphDefinitionNodeSurrogate.extension ?: listOf(),
      modifierExtension = this@GraphDefinitionNodeSurrogate.modifierExtension ?: listOf(),
      nodeId =
        Id.of(
          this@GraphDefinitionNodeSurrogate.nodeId,
          this@GraphDefinitionNodeSurrogate._nodeId,
        )!!,
      description =
        R5String.of(
          this@GraphDefinitionNodeSurrogate.description,
          this@GraphDefinitionNodeSurrogate._description,
        ),
      type =
        Enumeration.of(
          GraphDefinition.VersionIndependentResourceTypesAll.fromCode(
            this@GraphDefinitionNodeSurrogate.type!!
          ),
          this@GraphDefinitionNodeSurrogate._type,
        ),
      profile =
        Canonical.of(
          this@GraphDefinitionNodeSurrogate.profile,
          this@GraphDefinitionNodeSurrogate._profile,
        ),
    )

  public companion object {
    public fun fromModel(model: GraphDefinition.Node): GraphDefinitionNodeSurrogate =
      with(model) {
        GraphDefinitionNodeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          nodeId = this@with.nodeId.value,
          _nodeId = this@with.nodeId.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          profile = this@with.profile?.value,
          _profile = this@with.profile?.toElement(),
        )
      }
  }
}

@Serializable
internal data class GraphDefinitionLinkSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var min: Int? = null,
  public var _min: Element? = null,
  public var max: KotlinString? = null,
  public var _max: Element? = null,
  public var sourceId: KotlinString? = null,
  public var _sourceId: Element? = null,
  public var path: KotlinString? = null,
  public var _path: Element? = null,
  public var sliceName: KotlinString? = null,
  public var _sliceName: Element? = null,
  public var targetId: KotlinString? = null,
  public var _targetId: Element? = null,
  public var params: KotlinString? = null,
  public var _params: Element? = null,
  public var compartment: List<GraphDefinition.Link.Compartment>? = null,
) {
  public fun toModel(): GraphDefinition.Link =
    GraphDefinition.Link(
      id = this@GraphDefinitionLinkSurrogate.id,
      extension = this@GraphDefinitionLinkSurrogate.extension ?: listOf(),
      modifierExtension = this@GraphDefinitionLinkSurrogate.modifierExtension ?: listOf(),
      description =
        R5String.of(
          this@GraphDefinitionLinkSurrogate.description,
          this@GraphDefinitionLinkSurrogate._description,
        ),
      min =
        Integer.of(this@GraphDefinitionLinkSurrogate.min, this@GraphDefinitionLinkSurrogate._min),
      max =
        R5String.of(this@GraphDefinitionLinkSurrogate.max, this@GraphDefinitionLinkSurrogate._max),
      sourceId =
        Id.of(
          this@GraphDefinitionLinkSurrogate.sourceId,
          this@GraphDefinitionLinkSurrogate._sourceId,
        )!!,
      path =
        R5String.of(
          this@GraphDefinitionLinkSurrogate.path,
          this@GraphDefinitionLinkSurrogate._path,
        ),
      sliceName =
        R5String.of(
          this@GraphDefinitionLinkSurrogate.sliceName,
          this@GraphDefinitionLinkSurrogate._sliceName,
        ),
      targetId =
        Id.of(
          this@GraphDefinitionLinkSurrogate.targetId,
          this@GraphDefinitionLinkSurrogate._targetId,
        )!!,
      params =
        R5String.of(
          this@GraphDefinitionLinkSurrogate.params,
          this@GraphDefinitionLinkSurrogate._params,
        ),
      compartment = this@GraphDefinitionLinkSurrogate.compartment ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: GraphDefinition.Link): GraphDefinitionLinkSurrogate =
      with(model) {
        GraphDefinitionLinkSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          min = this@with.min?.value,
          _min = this@with.min?.toElement(),
          max = this@with.max?.value,
          _max = this@with.max?.toElement(),
          sourceId = this@with.sourceId.value,
          _sourceId = this@with.sourceId.toElement(),
          path = this@with.path?.value,
          _path = this@with.path?.toElement(),
          sliceName = this@with.sliceName?.value,
          _sliceName = this@with.sliceName?.toElement(),
          targetId = this@with.targetId.value,
          _targetId = this@with.targetId.toElement(),
          params = this@with.params?.value,
          _params = this@with.params?.toElement(),
          compartment = this@with.compartment.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class GraphDefinitionLinkCompartmentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var rule: KotlinString? = null,
  public var _rule: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var expression: KotlinString? = null,
  public var _expression: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
) {
  public fun toModel(): GraphDefinition.Link.Compartment =
    GraphDefinition.Link.Compartment(
      id = this@GraphDefinitionLinkCompartmentSurrogate.id,
      extension = this@GraphDefinitionLinkCompartmentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@GraphDefinitionLinkCompartmentSurrogate.modifierExtension ?: listOf(),
      use =
        Enumeration.of(
          GraphDefinition.GraphCompartmentUse.fromCode(
            this@GraphDefinitionLinkCompartmentSurrogate.use!!
          ),
          this@GraphDefinitionLinkCompartmentSurrogate._use,
        ),
      rule =
        Enumeration.of(
          GraphDefinition.GraphCompartmentRule.fromCode(
            this@GraphDefinitionLinkCompartmentSurrogate.rule!!
          ),
          this@GraphDefinitionLinkCompartmentSurrogate._rule,
        ),
      code =
        Enumeration.of(
          GraphDefinition.CompartmentType.fromCode(
            this@GraphDefinitionLinkCompartmentSurrogate.code!!
          ),
          this@GraphDefinitionLinkCompartmentSurrogate._code,
        ),
      expression =
        R5String.of(
          this@GraphDefinitionLinkCompartmentSurrogate.expression,
          this@GraphDefinitionLinkCompartmentSurrogate._expression,
        ),
      description =
        R5String.of(
          this@GraphDefinitionLinkCompartmentSurrogate.description,
          this@GraphDefinitionLinkCompartmentSurrogate._description,
        ),
    )

  public companion object {
    public fun fromModel(
      model: GraphDefinition.Link.Compartment
    ): GraphDefinitionLinkCompartmentSurrogate =
      with(model) {
        GraphDefinitionLinkCompartmentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          use = this@with.use.value?.getCode(),
          _use = this@with.use.toElement(),
          rule = this@with.rule.value?.getCode(),
          _rule = this@with.rule.toElement(),
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          expression = this@with.expression?.value,
          _expression = this@with.expression?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
        )
      }
  }
}

@Serializable
internal data class GraphDefinitionVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): GraphDefinition.VersionAlgorithm =
    GraphDefinition.VersionAlgorithm.from(
      R5String.of(
        this@GraphDefinitionVersionAlgorithmSurrogate.versionAlgorithmString,
        this@GraphDefinitionVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@GraphDefinitionVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(
      model: GraphDefinition.VersionAlgorithm
    ): GraphDefinitionVersionAlgorithmSurrogate =
      with(model) {
        GraphDefinitionVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
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
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var versionAlgorithm: GraphDefinition.VersionAlgorithm? = null,
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
  public var start: KotlinString? = null,
  public var _start: Element? = null,
  public var node: List<GraphDefinition.Node>? = null,
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
      identifier = this@GraphDefinitionSurrogate.identifier ?: listOf(),
      version =
        R5String.of(this@GraphDefinitionSurrogate.version, this@GraphDefinitionSurrogate._version),
      versionAlgorithm = this@GraphDefinitionSurrogate.versionAlgorithm,
      name = R5String.of(this@GraphDefinitionSurrogate.name, this@GraphDefinitionSurrogate._name)!!,
      title =
        R5String.of(this@GraphDefinitionSurrogate.title, this@GraphDefinitionSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@GraphDefinitionSurrogate.status!!),
          this@GraphDefinitionSurrogate._status,
        ),
      experimental =
        R5Boolean.of(
          this@GraphDefinitionSurrogate.experimental,
          this@GraphDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@GraphDefinitionSurrogate.date),
          this@GraphDefinitionSurrogate._date,
        ),
      publisher =
        R5String.of(
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
      copyright =
        Markdown.of(
          this@GraphDefinitionSurrogate.copyright,
          this@GraphDefinitionSurrogate._copyright,
        ),
      copyrightLabel =
        R5String.of(
          this@GraphDefinitionSurrogate.copyrightLabel,
          this@GraphDefinitionSurrogate._copyrightLabel,
        ),
      start = Id.of(this@GraphDefinitionSurrogate.start, this@GraphDefinitionSurrogate._start),
      node = this@GraphDefinitionSurrogate.node ?: listOf(),
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
          start = this@with.start?.value,
          _start = this@with.start?.toElement(),
          node = this@with.node.takeIf { it.isNotEmpty() },
          link = this@with.link.takeIf { it.isNotEmpty() },
        )
      }
  }
}

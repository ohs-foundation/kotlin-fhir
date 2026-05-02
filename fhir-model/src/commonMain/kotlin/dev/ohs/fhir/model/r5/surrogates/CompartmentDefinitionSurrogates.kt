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
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.CompartmentDefinition
import com.google.fhir.model.r5.ContactDetail
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
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
import com.google.fhir.model.r5.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CompartmentDefinitionResourceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var `param`: List<KotlinString?>? = null,
  public var _param: List<Element?>? = null,
  public var documentation: KotlinString? = null,
  public var _documentation: Element? = null,
  public var startParam: KotlinString? = null,
  public var _startParam: Element? = null,
  public var endParam: KotlinString? = null,
  public var _endParam: Element? = null,
) {
  public fun toModel(): CompartmentDefinition.Resource =
    CompartmentDefinition.Resource(
      id = this@CompartmentDefinitionResourceSurrogate.id,
      extension = this@CompartmentDefinitionResourceSurrogate.extension ?: listOf(),
      modifierExtension = this@CompartmentDefinitionResourceSurrogate.modifierExtension ?: listOf(),
      code =
        Enumeration.of(
          ResourceType.fromCode(this@CompartmentDefinitionResourceSurrogate.code!!),
          this@CompartmentDefinitionResourceSurrogate._code,
        ),
      `param` =
        if (
          this@CompartmentDefinitionResourceSurrogate.`param` == null &&
            this@CompartmentDefinitionResourceSurrogate._param == null
        ) {
          listOf()
        } else {
          (this@CompartmentDefinitionResourceSurrogate.`param`
              ?: List(this@CompartmentDefinitionResourceSurrogate._param!!.size) { null })
            .zip(
              this@CompartmentDefinitionResourceSurrogate._param
                ?: List(this@CompartmentDefinitionResourceSurrogate.`param`!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      documentation =
        R5String.of(
          this@CompartmentDefinitionResourceSurrogate.documentation,
          this@CompartmentDefinitionResourceSurrogate._documentation,
        ),
      startParam =
        Uri.of(
          this@CompartmentDefinitionResourceSurrogate.startParam,
          this@CompartmentDefinitionResourceSurrogate._startParam,
        ),
      endParam =
        Uri.of(
          this@CompartmentDefinitionResourceSurrogate.endParam,
          this@CompartmentDefinitionResourceSurrogate._endParam,
        ),
    )

  public companion object {
    public fun fromModel(
      model: CompartmentDefinition.Resource
    ): CompartmentDefinitionResourceSurrogate =
      with(model) {
        CompartmentDefinitionResourceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          `param` =
            this@with.`param`.map { it.value }.toList().takeUnless { it.all { it == null } },
          _param =
            this@with.`param`
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          documentation = this@with.documentation?.value,
          _documentation = this@with.documentation?.toElement(),
          startParam = this@with.startParam?.value,
          _startParam = this@with.startParam?.toElement(),
          endParam = this@with.endParam?.value,
          _endParam = this@with.endParam?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CompartmentDefinitionVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): CompartmentDefinition.VersionAlgorithm =
    CompartmentDefinition.VersionAlgorithm.from(
      R5String.of(
        this@CompartmentDefinitionVersionAlgorithmSurrogate.versionAlgorithmString,
        this@CompartmentDefinitionVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@CompartmentDefinitionVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(
      model: CompartmentDefinition.VersionAlgorithm
    ): CompartmentDefinitionVersionAlgorithmSurrogate =
      with(model) {
        CompartmentDefinitionVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class CompartmentDefinitionSurrogate(
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
  public var versionAlgorithm: CompartmentDefinition.VersionAlgorithm? = null,
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
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var search: KotlinBoolean? = null,
  public var _search: Element? = null,
  public var resource: List<CompartmentDefinition.Resource>? = null,
) {
  public fun toModel(): CompartmentDefinition =
    CompartmentDefinition(
      id = this@CompartmentDefinitionSurrogate.id,
      meta = this@CompartmentDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@CompartmentDefinitionSurrogate.implicitRules,
          this@CompartmentDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@CompartmentDefinitionSurrogate.language,
          this@CompartmentDefinitionSurrogate._language,
        ),
      text = this@CompartmentDefinitionSurrogate.text,
      contained = this@CompartmentDefinitionSurrogate.contained ?: listOf(),
      extension = this@CompartmentDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@CompartmentDefinitionSurrogate.modifierExtension ?: listOf(),
      url =
        Uri.of(this@CompartmentDefinitionSurrogate.url, this@CompartmentDefinitionSurrogate._url)!!,
      version =
        R5String.of(
          this@CompartmentDefinitionSurrogate.version,
          this@CompartmentDefinitionSurrogate._version,
        ),
      versionAlgorithm = this@CompartmentDefinitionSurrogate.versionAlgorithm,
      name =
        R5String.of(
          this@CompartmentDefinitionSurrogate.name,
          this@CompartmentDefinitionSurrogate._name,
        )!!,
      title =
        R5String.of(
          this@CompartmentDefinitionSurrogate.title,
          this@CompartmentDefinitionSurrogate._title,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@CompartmentDefinitionSurrogate.status!!),
          this@CompartmentDefinitionSurrogate._status,
        ),
      experimental =
        R5Boolean.of(
          this@CompartmentDefinitionSurrogate.experimental,
          this@CompartmentDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@CompartmentDefinitionSurrogate.date),
          this@CompartmentDefinitionSurrogate._date,
        ),
      publisher =
        R5String.of(
          this@CompartmentDefinitionSurrogate.publisher,
          this@CompartmentDefinitionSurrogate._publisher,
        ),
      contact = this@CompartmentDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@CompartmentDefinitionSurrogate.description,
          this@CompartmentDefinitionSurrogate._description,
        ),
      useContext = this@CompartmentDefinitionSurrogate.useContext ?: listOf(),
      purpose =
        Markdown.of(
          this@CompartmentDefinitionSurrogate.purpose,
          this@CompartmentDefinitionSurrogate._purpose,
        ),
      code =
        Enumeration.of(
          CompartmentDefinition.CompartmentType.fromCode(
            this@CompartmentDefinitionSurrogate.code!!
          ),
          this@CompartmentDefinitionSurrogate._code,
        ),
      search =
        R5Boolean.of(
          this@CompartmentDefinitionSurrogate.search,
          this@CompartmentDefinitionSurrogate._search,
        )!!,
      resource = this@CompartmentDefinitionSurrogate.resource ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: CompartmentDefinition): CompartmentDefinitionSurrogate =
      with(model) {
        CompartmentDefinitionSurrogate(
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
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          search = this@with.search.value,
          _search = this@with.search.toElement(),
          resource = this@with.resource.takeIf { it.isNotEmpty() },
        )
      }
  }
}

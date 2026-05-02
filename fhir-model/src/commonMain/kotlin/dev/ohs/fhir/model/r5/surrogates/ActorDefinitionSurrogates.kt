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

import com.google.fhir.model.r5.ActorDefinition
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
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.Url
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ActorDefinitionVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): ActorDefinition.VersionAlgorithm =
    ActorDefinition.VersionAlgorithm.from(
      R5String.of(
        this@ActorDefinitionVersionAlgorithmSurrogate.versionAlgorithmString,
        this@ActorDefinitionVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@ActorDefinitionVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(
      model: ActorDefinition.VersionAlgorithm
    ): ActorDefinitionVersionAlgorithmSurrogate =
      with(model) {
        ActorDefinitionVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class ActorDefinitionSurrogate(
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
  public var versionAlgorithm: ActorDefinition.VersionAlgorithm? = null,
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
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var documentation: KotlinString? = null,
  public var _documentation: Element? = null,
  public var reference: List<KotlinString?>? = null,
  public var _reference: List<Element?>? = null,
  public var capabilities: KotlinString? = null,
  public var _capabilities: Element? = null,
  public var derivedFrom: List<KotlinString?>? = null,
  public var _derivedFrom: List<Element?>? = null,
) {
  public fun toModel(): ActorDefinition =
    ActorDefinition(
      id = this@ActorDefinitionSurrogate.id,
      meta = this@ActorDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ActorDefinitionSurrogate.implicitRules,
          this@ActorDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(this@ActorDefinitionSurrogate.language, this@ActorDefinitionSurrogate._language),
      text = this@ActorDefinitionSurrogate.text,
      contained = this@ActorDefinitionSurrogate.contained ?: listOf(),
      extension = this@ActorDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@ActorDefinitionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@ActorDefinitionSurrogate.url, this@ActorDefinitionSurrogate._url),
      identifier = this@ActorDefinitionSurrogate.identifier ?: listOf(),
      version =
        R5String.of(this@ActorDefinitionSurrogate.version, this@ActorDefinitionSurrogate._version),
      versionAlgorithm = this@ActorDefinitionSurrogate.versionAlgorithm,
      name = R5String.of(this@ActorDefinitionSurrogate.name, this@ActorDefinitionSurrogate._name),
      title =
        R5String.of(this@ActorDefinitionSurrogate.title, this@ActorDefinitionSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ActorDefinitionSurrogate.status!!),
          this@ActorDefinitionSurrogate._status,
        ),
      experimental =
        R5Boolean.of(
          this@ActorDefinitionSurrogate.experimental,
          this@ActorDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ActorDefinitionSurrogate.date),
          this@ActorDefinitionSurrogate._date,
        ),
      publisher =
        R5String.of(
          this@ActorDefinitionSurrogate.publisher,
          this@ActorDefinitionSurrogate._publisher,
        ),
      contact = this@ActorDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@ActorDefinitionSurrogate.description,
          this@ActorDefinitionSurrogate._description,
        ),
      useContext = this@ActorDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@ActorDefinitionSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(this@ActorDefinitionSurrogate.purpose, this@ActorDefinitionSurrogate._purpose),
      copyright =
        Markdown.of(
          this@ActorDefinitionSurrogate.copyright,
          this@ActorDefinitionSurrogate._copyright,
        ),
      copyrightLabel =
        R5String.of(
          this@ActorDefinitionSurrogate.copyrightLabel,
          this@ActorDefinitionSurrogate._copyrightLabel,
        ),
      type =
        Enumeration.of(
          ActorDefinition.ExampleScenarioActorType.fromCode(this@ActorDefinitionSurrogate.type!!),
          this@ActorDefinitionSurrogate._type,
        ),
      documentation =
        Markdown.of(
          this@ActorDefinitionSurrogate.documentation,
          this@ActorDefinitionSurrogate._documentation,
        ),
      reference =
        if (
          this@ActorDefinitionSurrogate.reference == null &&
            this@ActorDefinitionSurrogate._reference == null
        ) {
          listOf()
        } else {
          (this@ActorDefinitionSurrogate.reference
              ?: List(this@ActorDefinitionSurrogate._reference!!.size) { null })
            .zip(
              this@ActorDefinitionSurrogate._reference
                ?: List(this@ActorDefinitionSurrogate.reference!!.size) { null }
            )
            .map { (value, element) -> Url.of(value, element)!! }
            .toList()
        },
      capabilities =
        Canonical.of(
          this@ActorDefinitionSurrogate.capabilities,
          this@ActorDefinitionSurrogate._capabilities,
        ),
      derivedFrom =
        if (
          this@ActorDefinitionSurrogate.derivedFrom == null &&
            this@ActorDefinitionSurrogate._derivedFrom == null
        ) {
          listOf()
        } else {
          (this@ActorDefinitionSurrogate.derivedFrom
              ?: List(this@ActorDefinitionSurrogate._derivedFrom!!.size) { null })
            .zip(
              this@ActorDefinitionSurrogate._derivedFrom
                ?: List(this@ActorDefinitionSurrogate.derivedFrom!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(model: ActorDefinition): ActorDefinitionSurrogate =
      with(model) {
        ActorDefinitionSurrogate(
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
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          documentation = this@with.documentation?.value,
          _documentation = this@with.documentation?.toElement(),
          reference =
            this@with.reference.map { it.value }.toList().takeUnless { it.all { it == null } },
          _reference =
            this@with.reference
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          capabilities = this@with.capabilities?.value,
          _capabilities = this@with.capabilities?.toElement(),
          derivedFrom =
            this@with.derivedFrom.map { it.value }.toList().takeUnless { it.all { it == null } },
          _derivedFrom =
            this@with.derivedFrom
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

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
import com.google.fhir.model.r4.Coding
import com.google.fhir.model.r4.ContactDetail
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.ElementDefinition
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Id
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Markdown
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.StructureDefinition
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.UsageContext
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.FHIRVersion
import com.google.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class StructureDefinitionMappingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identity: KotlinString? = null,
  public var _identity: Element? = null,
  public var uri: KotlinString? = null,
  public var _uri: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
) {
  public fun toModel(): StructureDefinition.Mapping =
    StructureDefinition.Mapping(
      id = this@StructureDefinitionMappingSurrogate.id,
      extension = this@StructureDefinitionMappingSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureDefinitionMappingSurrogate.modifierExtension ?: listOf(),
      identity =
        Id.of(
          this@StructureDefinitionMappingSurrogate.identity,
          this@StructureDefinitionMappingSurrogate._identity,
        )!!,
      uri =
        Uri.of(
          this@StructureDefinitionMappingSurrogate.uri,
          this@StructureDefinitionMappingSurrogate._uri,
        ),
      name =
        R4String.of(
          this@StructureDefinitionMappingSurrogate.name,
          this@StructureDefinitionMappingSurrogate._name,
        ),
      comment =
        R4String.of(
          this@StructureDefinitionMappingSurrogate.comment,
          this@StructureDefinitionMappingSurrogate._comment,
        ),
    )

  public companion object {
    public fun fromModel(model: StructureDefinition.Mapping): StructureDefinitionMappingSurrogate =
      with(model) {
        StructureDefinitionMappingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identity = this@with.identity.value,
          _identity = this@with.identity.toElement(),
          uri = this@with.uri?.value,
          _uri = this@with.uri?.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
        )
      }
  }
}

@Serializable
internal data class StructureDefinitionContextSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var expression: KotlinString? = null,
  public var _expression: Element? = null,
) {
  public fun toModel(): StructureDefinition.Context =
    StructureDefinition.Context(
      id = this@StructureDefinitionContextSurrogate.id,
      extension = this@StructureDefinitionContextSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureDefinitionContextSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          StructureDefinition.ExtensionContextType.fromCode(
            this@StructureDefinitionContextSurrogate.type!!
          ),
          this@StructureDefinitionContextSurrogate._type,
        ),
      expression =
        R4String.of(
          this@StructureDefinitionContextSurrogate.expression,
          this@StructureDefinitionContextSurrogate._expression,
        )!!,
    )

  public companion object {
    public fun fromModel(model: StructureDefinition.Context): StructureDefinitionContextSurrogate =
      with(model) {
        StructureDefinitionContextSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          expression = this@with.expression.value,
          _expression = this@with.expression.toElement(),
        )
      }
  }
}

@Serializable
internal data class StructureDefinitionSnapshotSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var element: List<ElementDefinition>? = null,
) {
  public fun toModel(): StructureDefinition.Snapshot =
    StructureDefinition.Snapshot(
      id = this@StructureDefinitionSnapshotSurrogate.id,
      extension = this@StructureDefinitionSnapshotSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureDefinitionSnapshotSurrogate.modifierExtension ?: listOf(),
      element = this@StructureDefinitionSnapshotSurrogate.element ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: StructureDefinition.Snapshot
    ): StructureDefinitionSnapshotSurrogate =
      with(model) {
        StructureDefinitionSnapshotSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          element = this@with.element.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class StructureDefinitionDifferentialSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var element: List<ElementDefinition>? = null,
) {
  public fun toModel(): StructureDefinition.Differential =
    StructureDefinition.Differential(
      id = this@StructureDefinitionDifferentialSurrogate.id,
      extension = this@StructureDefinitionDifferentialSurrogate.extension ?: listOf(),
      modifierExtension =
        this@StructureDefinitionDifferentialSurrogate.modifierExtension ?: listOf(),
      element = this@StructureDefinitionDifferentialSurrogate.element ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: StructureDefinition.Differential
    ): StructureDefinitionDifferentialSurrogate =
      with(model) {
        StructureDefinitionDifferentialSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          element = this@with.element.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class StructureDefinitionSurrogate(
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
  public var keyword: List<Coding>? = null,
  public var fhirVersion: KotlinString? = null,
  public var _fhirVersion: Element? = null,
  public var mapping: List<StructureDefinition.Mapping>? = null,
  public var kind: KotlinString? = null,
  public var _kind: Element? = null,
  public var `abstract`: KotlinBoolean? = null,
  public var _abstract: Element? = null,
  public var context: List<StructureDefinition.Context>? = null,
  public var contextInvariant: List<KotlinString?>? = null,
  public var _contextInvariant: List<Element?>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var baseDefinition: KotlinString? = null,
  public var _baseDefinition: Element? = null,
  public var derivation: KotlinString? = null,
  public var _derivation: Element? = null,
  public var snapshot: StructureDefinition.Snapshot? = null,
  public var differential: StructureDefinition.Differential? = null,
) {
  public fun toModel(): StructureDefinition =
    StructureDefinition(
      id = this@StructureDefinitionSurrogate.id,
      meta = this@StructureDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@StructureDefinitionSurrogate.implicitRules,
          this@StructureDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@StructureDefinitionSurrogate.language,
          this@StructureDefinitionSurrogate._language,
        ),
      text = this@StructureDefinitionSurrogate.text,
      contained = this@StructureDefinitionSurrogate.contained ?: listOf(),
      extension = this@StructureDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@StructureDefinitionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@StructureDefinitionSurrogate.url, this@StructureDefinitionSurrogate._url)!!,
      identifier = this@StructureDefinitionSurrogate.identifier ?: listOf(),
      version =
        R4String.of(
          this@StructureDefinitionSurrogate.version,
          this@StructureDefinitionSurrogate._version,
        ),
      name =
        R4String.of(
          this@StructureDefinitionSurrogate.name,
          this@StructureDefinitionSurrogate._name,
        )!!,
      title =
        R4String.of(
          this@StructureDefinitionSurrogate.title,
          this@StructureDefinitionSurrogate._title,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@StructureDefinitionSurrogate.status!!),
          this@StructureDefinitionSurrogate._status,
        ),
      experimental =
        R4Boolean.of(
          this@StructureDefinitionSurrogate.experimental,
          this@StructureDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@StructureDefinitionSurrogate.date),
          this@StructureDefinitionSurrogate._date,
        ),
      publisher =
        R4String.of(
          this@StructureDefinitionSurrogate.publisher,
          this@StructureDefinitionSurrogate._publisher,
        ),
      contact = this@StructureDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@StructureDefinitionSurrogate.description,
          this@StructureDefinitionSurrogate._description,
        ),
      useContext = this@StructureDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@StructureDefinitionSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(
          this@StructureDefinitionSurrogate.purpose,
          this@StructureDefinitionSurrogate._purpose,
        ),
      copyright =
        Markdown.of(
          this@StructureDefinitionSurrogate.copyright,
          this@StructureDefinitionSurrogate._copyright,
        ),
      keyword = this@StructureDefinitionSurrogate.keyword ?: listOf(),
      fhirVersion =
        this@StructureDefinitionSurrogate.fhirVersion?.let {
          Enumeration.of(FHIRVersion.fromCode(it), this@StructureDefinitionSurrogate._fhirVersion)
        },
      mapping = this@StructureDefinitionSurrogate.mapping ?: listOf(),
      kind =
        Enumeration.of(
          StructureDefinition.StructureDefinitionKind.fromCode(
            this@StructureDefinitionSurrogate.kind!!
          ),
          this@StructureDefinitionSurrogate._kind,
        ),
      `abstract` =
        R4Boolean.of(
          this@StructureDefinitionSurrogate.`abstract`,
          this@StructureDefinitionSurrogate._abstract,
        )!!,
      context = this@StructureDefinitionSurrogate.context ?: listOf(),
      contextInvariant =
        if (
          this@StructureDefinitionSurrogate.contextInvariant == null &&
            this@StructureDefinitionSurrogate._contextInvariant == null
        ) {
          listOf()
        } else {
          (this@StructureDefinitionSurrogate.contextInvariant
              ?: List(this@StructureDefinitionSurrogate._contextInvariant!!.size) { null })
            .zip(
              this@StructureDefinitionSurrogate._contextInvariant
                ?: List(this@StructureDefinitionSurrogate.contextInvariant!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      type =
        Uri.of(this@StructureDefinitionSurrogate.type, this@StructureDefinitionSurrogate._type)!!,
      baseDefinition =
        Canonical.of(
          this@StructureDefinitionSurrogate.baseDefinition,
          this@StructureDefinitionSurrogate._baseDefinition,
        ),
      derivation =
        this@StructureDefinitionSurrogate.derivation?.let {
          Enumeration.of(
            StructureDefinition.TypeDerivationRule.fromCode(it),
            this@StructureDefinitionSurrogate._derivation,
          )
        },
      snapshot = this@StructureDefinitionSurrogate.snapshot,
      differential = this@StructureDefinitionSurrogate.differential,
    )

  public companion object {
    public fun fromModel(model: StructureDefinition): StructureDefinitionSurrogate =
      with(model) {
        StructureDefinitionSurrogate(
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
          keyword = this@with.keyword.takeIf { it.isNotEmpty() },
          fhirVersion = this@with.fhirVersion?.value?.getCode(),
          _fhirVersion = this@with.fhirVersion?.toElement(),
          mapping = this@with.mapping.takeIf { it.isNotEmpty() },
          kind = this@with.kind.value?.getCode(),
          _kind = this@with.kind.toElement(),
          `abstract` = this@with.`abstract`.value,
          _abstract = this@with.`abstract`.toElement(),
          context = this@with.context.takeIf { it.isNotEmpty() },
          contextInvariant =
            this@with.contextInvariant
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _contextInvariant =
            this@with.contextInvariant
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          type = this@with.type.value,
          _type = this@with.type.toElement(),
          baseDefinition = this@with.baseDefinition?.value,
          _baseDefinition = this@with.baseDefinition?.toElement(),
          derivation = this@with.derivation?.value?.getCode(),
          _derivation = this@with.derivation?.toElement(),
          snapshot = this@with.snapshot,
          differential = this@with.differential,
        )
      }
  }
}

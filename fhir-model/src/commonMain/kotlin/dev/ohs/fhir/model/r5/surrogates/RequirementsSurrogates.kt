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
import com.google.fhir.model.r5.Id
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Requirements
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
internal data class RequirementsStatementSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var key: KotlinString? = null,
  public var _key: Element? = null,
  public var label: KotlinString? = null,
  public var _label: Element? = null,
  public var conformance: List<KotlinString?>? = null,
  public var _conformance: List<Element?>? = null,
  public var conditionality: KotlinBoolean? = null,
  public var _conditionality: Element? = null,
  public var requirement: KotlinString? = null,
  public var _requirement: Element? = null,
  public var derivedFrom: KotlinString? = null,
  public var _derivedFrom: Element? = null,
  public var parent: KotlinString? = null,
  public var _parent: Element? = null,
  public var satisfiedBy: List<KotlinString?>? = null,
  public var _satisfiedBy: List<Element?>? = null,
  public var reference: List<KotlinString?>? = null,
  public var _reference: List<Element?>? = null,
  public var source: List<Reference>? = null,
) {
  public fun toModel(): Requirements.Statement =
    Requirements.Statement(
      id = this@RequirementsStatementSurrogate.id,
      extension = this@RequirementsStatementSurrogate.extension ?: listOf(),
      modifierExtension = this@RequirementsStatementSurrogate.modifierExtension ?: listOf(),
      key =
        Id.of(this@RequirementsStatementSurrogate.key, this@RequirementsStatementSurrogate._key)!!,
      label =
        R5String.of(
          this@RequirementsStatementSurrogate.label,
          this@RequirementsStatementSurrogate._label,
        ),
      conformance =
        if (
          this@RequirementsStatementSurrogate.conformance == null &&
            this@RequirementsStatementSurrogate._conformance == null
        ) {
          listOf()
        } else {
          (this@RequirementsStatementSurrogate.conformance
              ?: List(this@RequirementsStatementSurrogate._conformance!!.size) { null })
            .zip(
              this@RequirementsStatementSurrogate._conformance
                ?: List(this@RequirementsStatementSurrogate.conformance!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { Requirements.ConformanceExpectation.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      conditionality =
        R5Boolean.of(
          this@RequirementsStatementSurrogate.conditionality,
          this@RequirementsStatementSurrogate._conditionality,
        ),
      requirement =
        Markdown.of(
          this@RequirementsStatementSurrogate.requirement,
          this@RequirementsStatementSurrogate._requirement,
        )!!,
      derivedFrom =
        R5String.of(
          this@RequirementsStatementSurrogate.derivedFrom,
          this@RequirementsStatementSurrogate._derivedFrom,
        ),
      parent =
        R5String.of(
          this@RequirementsStatementSurrogate.parent,
          this@RequirementsStatementSurrogate._parent,
        ),
      satisfiedBy =
        if (
          this@RequirementsStatementSurrogate.satisfiedBy == null &&
            this@RequirementsStatementSurrogate._satisfiedBy == null
        ) {
          listOf()
        } else {
          (this@RequirementsStatementSurrogate.satisfiedBy
              ?: List(this@RequirementsStatementSurrogate._satisfiedBy!!.size) { null })
            .zip(
              this@RequirementsStatementSurrogate._satisfiedBy
                ?: List(this@RequirementsStatementSurrogate.satisfiedBy!!.size) { null }
            )
            .map { (value, element) -> Url.of(value, element)!! }
            .toList()
        },
      reference =
        if (
          this@RequirementsStatementSurrogate.reference == null &&
            this@RequirementsStatementSurrogate._reference == null
        ) {
          listOf()
        } else {
          (this@RequirementsStatementSurrogate.reference
              ?: List(this@RequirementsStatementSurrogate._reference!!.size) { null })
            .zip(
              this@RequirementsStatementSurrogate._reference
                ?: List(this@RequirementsStatementSurrogate.reference!!.size) { null }
            )
            .map { (value, element) -> Url.of(value, element)!! }
            .toList()
        },
      source = this@RequirementsStatementSurrogate.source ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Requirements.Statement): RequirementsStatementSurrogate =
      with(model) {
        RequirementsStatementSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          key = this@with.key.value,
          _key = this@with.key.toElement(),
          label = this@with.label?.value,
          _label = this@with.label?.toElement(),
          conformance =
            this@with.conformance
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _conformance =
            this@with.conformance
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          conditionality = this@with.conditionality?.value,
          _conditionality = this@with.conditionality?.toElement(),
          requirement = this@with.requirement.value,
          _requirement = this@with.requirement.toElement(),
          derivedFrom = this@with.derivedFrom?.value,
          _derivedFrom = this@with.derivedFrom?.toElement(),
          parent = this@with.parent?.value,
          _parent = this@with.parent?.toElement(),
          satisfiedBy =
            this@with.satisfiedBy.map { it.value }.toList().takeUnless { it.all { it == null } },
          _satisfiedBy =
            this@with.satisfiedBy
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          reference =
            this@with.reference.map { it.value }.toList().takeUnless { it.all { it == null } },
          _reference =
            this@with.reference
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          source = this@with.source.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class RequirementsVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): Requirements.VersionAlgorithm =
    Requirements.VersionAlgorithm.from(
      R5String.of(
        this@RequirementsVersionAlgorithmSurrogate.versionAlgorithmString,
        this@RequirementsVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@RequirementsVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(
      model: Requirements.VersionAlgorithm
    ): RequirementsVersionAlgorithmSurrogate =
      with(model) {
        RequirementsVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class RequirementsSurrogate(
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
  public var versionAlgorithm: Requirements.VersionAlgorithm? = null,
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
  public var derivedFrom: List<KotlinString?>? = null,
  public var _derivedFrom: List<Element?>? = null,
  public var reference: List<KotlinString?>? = null,
  public var _reference: List<Element?>? = null,
  public var actor: List<KotlinString?>? = null,
  public var _actor: List<Element?>? = null,
  public var statement: List<Requirements.Statement>? = null,
) {
  public fun toModel(): Requirements =
    Requirements(
      id = this@RequirementsSurrogate.id,
      meta = this@RequirementsSurrogate.meta,
      implicitRules =
        Uri.of(this@RequirementsSurrogate.implicitRules, this@RequirementsSurrogate._implicitRules),
      language = Code.of(this@RequirementsSurrogate.language, this@RequirementsSurrogate._language),
      text = this@RequirementsSurrogate.text,
      contained = this@RequirementsSurrogate.contained ?: listOf(),
      extension = this@RequirementsSurrogate.extension ?: listOf(),
      modifierExtension = this@RequirementsSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@RequirementsSurrogate.url, this@RequirementsSurrogate._url),
      identifier = this@RequirementsSurrogate.identifier ?: listOf(),
      version =
        R5String.of(this@RequirementsSurrogate.version, this@RequirementsSurrogate._version),
      versionAlgorithm = this@RequirementsSurrogate.versionAlgorithm,
      name = R5String.of(this@RequirementsSurrogate.name, this@RequirementsSurrogate._name),
      title = R5String.of(this@RequirementsSurrogate.title, this@RequirementsSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@RequirementsSurrogate.status!!),
          this@RequirementsSurrogate._status,
        ),
      experimental =
        R5Boolean.of(
          this@RequirementsSurrogate.experimental,
          this@RequirementsSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@RequirementsSurrogate.date),
          this@RequirementsSurrogate._date,
        ),
      publisher =
        R5String.of(this@RequirementsSurrogate.publisher, this@RequirementsSurrogate._publisher),
      contact = this@RequirementsSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@RequirementsSurrogate.description,
          this@RequirementsSurrogate._description,
        ),
      useContext = this@RequirementsSurrogate.useContext ?: listOf(),
      jurisdiction = this@RequirementsSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(this@RequirementsSurrogate.purpose, this@RequirementsSurrogate._purpose),
      copyright =
        Markdown.of(this@RequirementsSurrogate.copyright, this@RequirementsSurrogate._copyright),
      copyrightLabel =
        R5String.of(
          this@RequirementsSurrogate.copyrightLabel,
          this@RequirementsSurrogate._copyrightLabel,
        ),
      derivedFrom =
        if (
          this@RequirementsSurrogate.derivedFrom == null &&
            this@RequirementsSurrogate._derivedFrom == null
        ) {
          listOf()
        } else {
          (this@RequirementsSurrogate.derivedFrom
              ?: List(this@RequirementsSurrogate._derivedFrom!!.size) { null })
            .zip(
              this@RequirementsSurrogate._derivedFrom
                ?: List(this@RequirementsSurrogate.derivedFrom!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      reference =
        if (
          this@RequirementsSurrogate.reference == null &&
            this@RequirementsSurrogate._reference == null
        ) {
          listOf()
        } else {
          (this@RequirementsSurrogate.reference
              ?: List(this@RequirementsSurrogate._reference!!.size) { null })
            .zip(
              this@RequirementsSurrogate._reference
                ?: List(this@RequirementsSurrogate.reference!!.size) { null }
            )
            .map { (value, element) -> Url.of(value, element)!! }
            .toList()
        },
      actor =
        if (this@RequirementsSurrogate.actor == null && this@RequirementsSurrogate._actor == null) {
          listOf()
        } else {
          (this@RequirementsSurrogate.actor
              ?: List(this@RequirementsSurrogate._actor!!.size) { null })
            .zip(
              this@RequirementsSurrogate._actor
                ?: List(this@RequirementsSurrogate.actor!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      statement = this@RequirementsSurrogate.statement ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Requirements): RequirementsSurrogate =
      with(model) {
        RequirementsSurrogate(
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
          derivedFrom =
            this@with.derivedFrom.map { it.value }.toList().takeUnless { it.all { it == null } },
          _derivedFrom =
            this@with.derivedFrom
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          reference =
            this@with.reference.map { it.value }.toList().takeUnless { it.all { it == null } },
          _reference =
            this@with.reference
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          actor = this@with.actor.map { it.value }.toList().takeUnless { it.all { it == null } },
          _actor =
            this@with.actor
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          statement = this@with.statement.takeIf { it.isNotEmpty() },
        )
      }
  }
}

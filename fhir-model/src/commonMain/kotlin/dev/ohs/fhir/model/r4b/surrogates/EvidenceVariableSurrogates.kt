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

import com.google.fhir.model.r4b.Annotation
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.EvidenceVariable
import com.google.fhir.model.r4b.Expression
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Range
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.RelatedArtifact
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class EvidenceVariableCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var definition: EvidenceVariable.Characteristic.Definition,
  public var method: CodeableConcept? = null,
  public var device: Reference? = null,
  public var exclude: KotlinBoolean? = null,
  public var _exclude: Element? = null,
  public var timeFromStart: EvidenceVariable.Characteristic.TimeFromStart? = null,
  public var groupMeasure: KotlinString? = null,
  public var _groupMeasure: Element? = null,
) {
  public fun toModel(): EvidenceVariable.Characteristic =
    EvidenceVariable.Characteristic(
      id = this@EvidenceVariableCharacteristicSurrogate.id,
      extension = this@EvidenceVariableCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EvidenceVariableCharacteristicSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@EvidenceVariableCharacteristicSurrogate.description,
          this@EvidenceVariableCharacteristicSurrogate._description,
        ),
      definition = this@EvidenceVariableCharacteristicSurrogate.definition,
      method = this@EvidenceVariableCharacteristicSurrogate.method,
      device = this@EvidenceVariableCharacteristicSurrogate.device,
      exclude =
        R4bBoolean.of(
          this@EvidenceVariableCharacteristicSurrogate.exclude,
          this@EvidenceVariableCharacteristicSurrogate._exclude,
        ),
      timeFromStart = this@EvidenceVariableCharacteristicSurrogate.timeFromStart,
      groupMeasure =
        this@EvidenceVariableCharacteristicSurrogate.groupMeasure?.let {
          Enumeration.of(
            EvidenceVariable.GroupMeasure.fromCode(it),
            this@EvidenceVariableCharacteristicSurrogate._groupMeasure,
          )
        },
    )

  public companion object {
    public fun fromModel(
      model: EvidenceVariable.Characteristic
    ): EvidenceVariableCharacteristicSurrogate =
      with(model) {
        EvidenceVariableCharacteristicSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          definition = this@with.definition,
          method = this@with.method,
          device = this@with.device,
          exclude = this@with.exclude?.value,
          _exclude = this@with.exclude?.toElement(),
          timeFromStart = this@with.timeFromStart,
          groupMeasure = this@with.groupMeasure?.value?.getCode(),
          _groupMeasure = this@with.groupMeasure?.toElement(),
        )
      }
  }
}

@Serializable
internal data class EvidenceVariableCharacteristicTimeFromStartSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var quantity: Quantity? = null,
  public var range: Range? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): EvidenceVariable.Characteristic.TimeFromStart =
    EvidenceVariable.Characteristic.TimeFromStart(
      id = this@EvidenceVariableCharacteristicTimeFromStartSurrogate.id,
      extension = this@EvidenceVariableCharacteristicTimeFromStartSurrogate.extension ?: listOf(),
      modifierExtension =
        this@EvidenceVariableCharacteristicTimeFromStartSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@EvidenceVariableCharacteristicTimeFromStartSurrogate.description,
          this@EvidenceVariableCharacteristicTimeFromStartSurrogate._description,
        ),
      quantity = this@EvidenceVariableCharacteristicTimeFromStartSurrogate.quantity,
      range = this@EvidenceVariableCharacteristicTimeFromStartSurrogate.range,
      note = this@EvidenceVariableCharacteristicTimeFromStartSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: EvidenceVariable.Characteristic.TimeFromStart
    ): EvidenceVariableCharacteristicTimeFromStartSurrogate =
      with(model) {
        EvidenceVariableCharacteristicTimeFromStartSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          quantity = this@with.quantity,
          range = this@with.range,
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class EvidenceVariableCategorySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var `value`: EvidenceVariable.Category.Value? = null,
) {
  public fun toModel(): EvidenceVariable.Category =
    EvidenceVariable.Category(
      id = this@EvidenceVariableCategorySurrogate.id,
      extension = this@EvidenceVariableCategorySurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceVariableCategorySurrogate.modifierExtension ?: listOf(),
      name =
        R4bString.of(
          this@EvidenceVariableCategorySurrogate.name,
          this@EvidenceVariableCategorySurrogate._name,
        ),
      `value` = this@EvidenceVariableCategorySurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: EvidenceVariable.Category): EvidenceVariableCategorySurrogate =
      with(model) {
        EvidenceVariableCategorySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class EvidenceVariableCharacteristicDefinitionSurrogate(
  public var definitionReference: Reference? = null,
  public var definitionCanonical: KotlinString? = null,
  public var _definitionCanonical: Element? = null,
  public var definitionCodeableConcept: CodeableConcept? = null,
  public var definitionExpression: Expression? = null,
) {
  public fun toModel(): EvidenceVariable.Characteristic.Definition =
    EvidenceVariable.Characteristic.Definition.from(
      this@EvidenceVariableCharacteristicDefinitionSurrogate.definitionReference,
      Canonical.of(
        this@EvidenceVariableCharacteristicDefinitionSurrogate.definitionCanonical,
        this@EvidenceVariableCharacteristicDefinitionSurrogate._definitionCanonical,
      ),
      this@EvidenceVariableCharacteristicDefinitionSurrogate.definitionCodeableConcept,
      this@EvidenceVariableCharacteristicDefinitionSurrogate.definitionExpression,
    )!!

  public companion object {
    public fun fromModel(
      model: EvidenceVariable.Characteristic.Definition
    ): EvidenceVariableCharacteristicDefinitionSurrogate =
      with(model) {
        EvidenceVariableCharacteristicDefinitionSurrogate(
          definitionReference = this@with.asReference()?.value,
          definitionCanonical = this@with.asCanonical()?.value?.value,
          _definitionCanonical = this@with.asCanonical()?.value?.toElement(),
          definitionCodeableConcept = this@with.asCodeableConcept()?.value,
          definitionExpression = this@with.asExpression()?.value,
        )
      }
  }
}

@Serializable
internal data class EvidenceVariableCategoryValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
) {
  public fun toModel(): EvidenceVariable.Category.Value =
    EvidenceVariable.Category.Value.from(
      this@EvidenceVariableCategoryValueSurrogate.valueCodeableConcept,
      this@EvidenceVariableCategoryValueSurrogate.valueQuantity,
      this@EvidenceVariableCategoryValueSurrogate.valueRange,
    )!!

  public companion object {
    public fun fromModel(
      model: EvidenceVariable.Category.Value
    ): EvidenceVariableCategoryValueSurrogate =
      with(model) {
        EvidenceVariableCategoryValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
        )
      }
  }
}

@Serializable
internal data class EvidenceVariableSurrogate(
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
  public var shortTitle: KotlinString? = null,
  public var _shortTitle: Element? = null,
  public var subtitle: KotlinString? = null,
  public var _subtitle: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var note: List<Annotation>? = null,
  public var useContext: List<UsageContext>? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var author: List<ContactDetail>? = null,
  public var editor: List<ContactDetail>? = null,
  public var reviewer: List<ContactDetail>? = null,
  public var endorser: List<ContactDetail>? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var `actual`: KotlinBoolean? = null,
  public var _actual: Element? = null,
  public var characteristicCombination: KotlinString? = null,
  public var _characteristicCombination: Element? = null,
  public var characteristic: List<EvidenceVariable.Characteristic>? = null,
  public var handling: KotlinString? = null,
  public var _handling: Element? = null,
  public var category: List<EvidenceVariable.Category>? = null,
) {
  public fun toModel(): EvidenceVariable =
    EvidenceVariable(
      id = this@EvidenceVariableSurrogate.id,
      meta = this@EvidenceVariableSurrogate.meta,
      implicitRules =
        Uri.of(
          this@EvidenceVariableSurrogate.implicitRules,
          this@EvidenceVariableSurrogate._implicitRules,
        ),
      language =
        Code.of(this@EvidenceVariableSurrogate.language, this@EvidenceVariableSurrogate._language),
      text = this@EvidenceVariableSurrogate.text,
      contained = this@EvidenceVariableSurrogate.contained ?: listOf(),
      extension = this@EvidenceVariableSurrogate.extension ?: listOf(),
      modifierExtension = this@EvidenceVariableSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@EvidenceVariableSurrogate.url, this@EvidenceVariableSurrogate._url),
      identifier = this@EvidenceVariableSurrogate.identifier ?: listOf(),
      version =
        R4bString.of(
          this@EvidenceVariableSurrogate.version,
          this@EvidenceVariableSurrogate._version,
        ),
      name =
        R4bString.of(this@EvidenceVariableSurrogate.name, this@EvidenceVariableSurrogate._name),
      title =
        R4bString.of(this@EvidenceVariableSurrogate.title, this@EvidenceVariableSurrogate._title),
      shortTitle =
        R4bString.of(
          this@EvidenceVariableSurrogate.shortTitle,
          this@EvidenceVariableSurrogate._shortTitle,
        ),
      subtitle =
        R4bString.of(
          this@EvidenceVariableSurrogate.subtitle,
          this@EvidenceVariableSurrogate._subtitle,
        ),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@EvidenceVariableSurrogate.status!!),
          this@EvidenceVariableSurrogate._status,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@EvidenceVariableSurrogate.date),
          this@EvidenceVariableSurrogate._date,
        ),
      description =
        Markdown.of(
          this@EvidenceVariableSurrogate.description,
          this@EvidenceVariableSurrogate._description,
        ),
      note = this@EvidenceVariableSurrogate.note ?: listOf(),
      useContext = this@EvidenceVariableSurrogate.useContext ?: listOf(),
      publisher =
        R4bString.of(
          this@EvidenceVariableSurrogate.publisher,
          this@EvidenceVariableSurrogate._publisher,
        ),
      contact = this@EvidenceVariableSurrogate.contact ?: listOf(),
      author = this@EvidenceVariableSurrogate.author ?: listOf(),
      editor = this@EvidenceVariableSurrogate.editor ?: listOf(),
      reviewer = this@EvidenceVariableSurrogate.reviewer ?: listOf(),
      endorser = this@EvidenceVariableSurrogate.endorser ?: listOf(),
      relatedArtifact = this@EvidenceVariableSurrogate.relatedArtifact ?: listOf(),
      `actual` =
        R4bBoolean.of(
          this@EvidenceVariableSurrogate.`actual`,
          this@EvidenceVariableSurrogate._actual,
        ),
      characteristicCombination =
        this@EvidenceVariableSurrogate.characteristicCombination?.let {
          Enumeration.of(
            EvidenceVariable.CharacteristicCombination.fromCode(it),
            this@EvidenceVariableSurrogate._characteristicCombination,
          )
        },
      characteristic = this@EvidenceVariableSurrogate.characteristic ?: listOf(),
      handling =
        this@EvidenceVariableSurrogate.handling?.let {
          Enumeration.of(
            EvidenceVariable.EvidenceVariableHandling.fromCode(it),
            this@EvidenceVariableSurrogate._handling,
          )
        },
      category = this@EvidenceVariableSurrogate.category ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: EvidenceVariable): EvidenceVariableSurrogate =
      with(model) {
        EvidenceVariableSurrogate(
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
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          shortTitle = this@with.shortTitle?.value,
          _shortTitle = this@with.shortTitle?.toElement(),
          subtitle = this@with.subtitle?.value,
          _subtitle = this@with.subtitle?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          author = this@with.author.takeIf { it.isNotEmpty() },
          editor = this@with.editor.takeIf { it.isNotEmpty() },
          reviewer = this@with.reviewer.takeIf { it.isNotEmpty() },
          endorser = this@with.endorser.takeIf { it.isNotEmpty() },
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          `actual` = this@with.`actual`?.value,
          _actual = this@with.`actual`?.toElement(),
          characteristicCombination = this@with.characteristicCombination?.value?.getCode(),
          _characteristicCombination = this@with.characteristicCombination?.toElement(),
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
          handling = this@with.handling?.value?.getCode(),
          _handling = this@with.handling?.toElement(),
          category = this@with.category.takeIf { it.isNotEmpty() },
        )
      }
  }
}

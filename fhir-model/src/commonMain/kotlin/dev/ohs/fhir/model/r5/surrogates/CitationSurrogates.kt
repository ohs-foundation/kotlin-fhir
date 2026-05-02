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

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Citation
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactDetail
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.RelatedArtifact
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
internal data class CitationSummarySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var style: CodeableConcept? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
) {
  public fun toModel(): Citation.Summary =
    Citation.Summary(
      id = this@CitationSummarySurrogate.id,
      extension = this@CitationSummarySurrogate.extension ?: listOf(),
      modifierExtension = this@CitationSummarySurrogate.modifierExtension ?: listOf(),
      style = this@CitationSummarySurrogate.style,
      text = Markdown.of(this@CitationSummarySurrogate.text, this@CitationSummarySurrogate._text)!!,
    )

  public companion object {
    public fun fromModel(model: Citation.Summary): CitationSummarySurrogate =
      with(model) {
        CitationSummarySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          style = this@with.style,
          text = this@with.text.value,
          _text = this@with.text.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationClassificationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var classifier: List<CodeableConcept>? = null,
) {
  public fun toModel(): Citation.Classification =
    Citation.Classification(
      id = this@CitationClassificationSurrogate.id,
      extension = this@CitationClassificationSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationClassificationSurrogate.modifierExtension ?: listOf(),
      type = this@CitationClassificationSurrogate.type,
      classifier = this@CitationClassificationSurrogate.classifier ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Citation.Classification): CitationClassificationSurrogate =
      with(model) {
        CitationClassificationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          classifier = this@with.classifier.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CitationStatusDateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var activity: CodeableConcept,
  public var `actual`: KotlinBoolean? = null,
  public var _actual: Element? = null,
  public var period: Period,
) {
  public fun toModel(): Citation.StatusDate =
    Citation.StatusDate(
      id = this@CitationStatusDateSurrogate.id,
      extension = this@CitationStatusDateSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationStatusDateSurrogate.modifierExtension ?: listOf(),
      activity = this@CitationStatusDateSurrogate.activity,
      `actual` =
        R5Boolean.of(
          this@CitationStatusDateSurrogate.`actual`,
          this@CitationStatusDateSurrogate._actual,
        ),
      period = this@CitationStatusDateSurrogate.period,
    )

  public companion object {
    public fun fromModel(model: Citation.StatusDate): CitationStatusDateSurrogate =
      with(model) {
        CitationStatusDateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          activity = this@with.activity,
          `actual` = this@with.`actual`?.value,
          _actual = this@with.`actual`?.toElement(),
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var relatedIdentifier: List<Identifier>? = null,
  public var dateAccessed: KotlinString? = null,
  public var _dateAccessed: Element? = null,
  public var version: Citation.CitedArtifact.Version? = null,
  public var currentState: List<CodeableConcept>? = null,
  public var statusDate: List<Citation.CitedArtifact.StatusDate>? = null,
  public var title: List<Citation.CitedArtifact.Title>? = null,
  public var `abstract`: List<Citation.CitedArtifact.Abstract>? = null,
  public var part: Citation.CitedArtifact.Part? = null,
  public var relatesTo: List<Citation.CitedArtifact.RelatesTo>? = null,
  public var publicationForm: List<Citation.CitedArtifact.PublicationForm>? = null,
  public var webLocation: List<Citation.CitedArtifact.WebLocation>? = null,
  public var classification: List<Citation.CitedArtifact.Classification>? = null,
  public var contributorship: Citation.CitedArtifact.Contributorship? = null,
  public var note: List<Annotation>? = null,
) {
  public fun toModel(): Citation.CitedArtifact =
    Citation.CitedArtifact(
      id = this@CitationCitedArtifactSurrogate.id,
      extension = this@CitationCitedArtifactSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationCitedArtifactSurrogate.modifierExtension ?: listOf(),
      identifier = this@CitationCitedArtifactSurrogate.identifier ?: listOf(),
      relatedIdentifier = this@CitationCitedArtifactSurrogate.relatedIdentifier ?: listOf(),
      dateAccessed =
        DateTime.of(
          FhirDateTime.fromString(this@CitationCitedArtifactSurrogate.dateAccessed),
          this@CitationCitedArtifactSurrogate._dateAccessed,
        ),
      version = this@CitationCitedArtifactSurrogate.version,
      currentState = this@CitationCitedArtifactSurrogate.currentState ?: listOf(),
      statusDate = this@CitationCitedArtifactSurrogate.statusDate ?: listOf(),
      title = this@CitationCitedArtifactSurrogate.title ?: listOf(),
      `abstract` = this@CitationCitedArtifactSurrogate.`abstract` ?: listOf(),
      part = this@CitationCitedArtifactSurrogate.part,
      relatesTo = this@CitationCitedArtifactSurrogate.relatesTo ?: listOf(),
      publicationForm = this@CitationCitedArtifactSurrogate.publicationForm ?: listOf(),
      webLocation = this@CitationCitedArtifactSurrogate.webLocation ?: listOf(),
      classification = this@CitationCitedArtifactSurrogate.classification ?: listOf(),
      contributorship = this@CitationCitedArtifactSurrogate.contributorship,
      note = this@CitationCitedArtifactSurrogate.note ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Citation.CitedArtifact): CitationCitedArtifactSurrogate =
      with(model) {
        CitationCitedArtifactSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          relatedIdentifier = this@with.relatedIdentifier.takeIf { it.isNotEmpty() },
          dateAccessed = this@with.dateAccessed?.value?.toString(),
          _dateAccessed = this@with.dateAccessed?.toElement(),
          version = this@with.version,
          currentState = this@with.currentState.takeIf { it.isNotEmpty() },
          statusDate = this@with.statusDate.takeIf { it.isNotEmpty() },
          title = this@with.title.takeIf { it.isNotEmpty() },
          `abstract` = this@with.`abstract`.takeIf { it.isNotEmpty() },
          part = this@with.part,
          relatesTo = this@with.relatesTo.takeIf { it.isNotEmpty() },
          publicationForm = this@with.publicationForm.takeIf { it.isNotEmpty() },
          webLocation = this@with.webLocation.takeIf { it.isNotEmpty() },
          classification = this@with.classification.takeIf { it.isNotEmpty() },
          contributorship = this@with.contributorship,
          note = this@with.note.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactVersionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
  public var baseCitation: Reference? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Version =
    Citation.CitedArtifact.Version(
      id = this@CitationCitedArtifactVersionSurrogate.id,
      extension = this@CitationCitedArtifactVersionSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationCitedArtifactVersionSurrogate.modifierExtension ?: listOf(),
      `value` =
        R5String.of(
          this@CitationCitedArtifactVersionSurrogate.`value`,
          this@CitationCitedArtifactVersionSurrogate._value,
        )!!,
      baseCitation = this@CitationCitedArtifactVersionSurrogate.baseCitation,
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Version
    ): CitationCitedArtifactVersionSurrogate =
      with(model) {
        CitationCitedArtifactVersionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`.value,
          _value = this@with.`value`.toElement(),
          baseCitation = this@with.baseCitation,
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactStatusDateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var activity: CodeableConcept,
  public var `actual`: KotlinBoolean? = null,
  public var _actual: Element? = null,
  public var period: Period,
) {
  public fun toModel(): Citation.CitedArtifact.StatusDate =
    Citation.CitedArtifact.StatusDate(
      id = this@CitationCitedArtifactStatusDateSurrogate.id,
      extension = this@CitationCitedArtifactStatusDateSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactStatusDateSurrogate.modifierExtension ?: listOf(),
      activity = this@CitationCitedArtifactStatusDateSurrogate.activity,
      `actual` =
        R5Boolean.of(
          this@CitationCitedArtifactStatusDateSurrogate.`actual`,
          this@CitationCitedArtifactStatusDateSurrogate._actual,
        ),
      period = this@CitationCitedArtifactStatusDateSurrogate.period,
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.StatusDate
    ): CitationCitedArtifactStatusDateSurrogate =
      with(model) {
        CitationCitedArtifactStatusDateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          activity = this@with.activity,
          `actual` = this@with.`actual`?.value,
          _actual = this@with.`actual`?.toElement(),
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactTitleSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: List<CodeableConcept>? = null,
  public var language: CodeableConcept? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Title =
    Citation.CitedArtifact.Title(
      id = this@CitationCitedArtifactTitleSurrogate.id,
      extension = this@CitationCitedArtifactTitleSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationCitedArtifactTitleSurrogate.modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactTitleSurrogate.type ?: listOf(),
      language = this@CitationCitedArtifactTitleSurrogate.language,
      text =
        Markdown.of(
          this@CitationCitedArtifactTitleSurrogate.text,
          this@CitationCitedArtifactTitleSurrogate._text,
        )!!,
    )

  public companion object {
    public fun fromModel(model: Citation.CitedArtifact.Title): CitationCitedArtifactTitleSurrogate =
      with(model) {
        CitationCitedArtifactTitleSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.takeIf { it.isNotEmpty() },
          language = this@with.language,
          text = this@with.text.value,
          _text = this@with.text.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactAbstractSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var language: CodeableConcept? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Abstract =
    Citation.CitedArtifact.Abstract(
      id = this@CitationCitedArtifactAbstractSurrogate.id,
      extension = this@CitationCitedArtifactAbstractSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationCitedArtifactAbstractSurrogate.modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactAbstractSurrogate.type,
      language = this@CitationCitedArtifactAbstractSurrogate.language,
      text =
        Markdown.of(
          this@CitationCitedArtifactAbstractSurrogate.text,
          this@CitationCitedArtifactAbstractSurrogate._text,
        )!!,
      copyright =
        Markdown.of(
          this@CitationCitedArtifactAbstractSurrogate.copyright,
          this@CitationCitedArtifactAbstractSurrogate._copyright,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Abstract
    ): CitationCitedArtifactAbstractSurrogate =
      with(model) {
        CitationCitedArtifactAbstractSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          language = this@with.language,
          text = this@with.text.value,
          _text = this@with.text.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactPartSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
  public var baseCitation: Reference? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Part =
    Citation.CitedArtifact.Part(
      id = this@CitationCitedArtifactPartSurrogate.id,
      extension = this@CitationCitedArtifactPartSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationCitedArtifactPartSurrogate.modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactPartSurrogate.type,
      `value` =
        R5String.of(
          this@CitationCitedArtifactPartSurrogate.`value`,
          this@CitationCitedArtifactPartSurrogate._value,
        ),
      baseCitation = this@CitationCitedArtifactPartSurrogate.baseCitation,
    )

  public companion object {
    public fun fromModel(model: Citation.CitedArtifact.Part): CitationCitedArtifactPartSurrogate =
      with(model) {
        CitationCitedArtifactPartSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`?.value,
          _value = this@with.`value`?.toElement(),
          baseCitation = this@with.baseCitation,
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactRelatesToSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var classifier: List<CodeableConcept>? = null,
  public var label: KotlinString? = null,
  public var _label: Element? = null,
  public var display: KotlinString? = null,
  public var _display: Element? = null,
  public var citation: KotlinString? = null,
  public var _citation: Element? = null,
  public var document: Attachment? = null,
  public var resource: KotlinString? = null,
  public var _resource: Element? = null,
  public var resourceReference: Reference? = null,
) {
  public fun toModel(): Citation.CitedArtifact.RelatesTo =
    Citation.CitedArtifact.RelatesTo(
      id = this@CitationCitedArtifactRelatesToSurrogate.id,
      extension = this@CitationCitedArtifactRelatesToSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactRelatesToSurrogate.modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          Citation.RelatedArtifactTypeExpanded.fromCode(
            this@CitationCitedArtifactRelatesToSurrogate.type!!
          ),
          this@CitationCitedArtifactRelatesToSurrogate._type,
        ),
      classifier = this@CitationCitedArtifactRelatesToSurrogate.classifier ?: listOf(),
      label =
        R5String.of(
          this@CitationCitedArtifactRelatesToSurrogate.label,
          this@CitationCitedArtifactRelatesToSurrogate._label,
        ),
      display =
        R5String.of(
          this@CitationCitedArtifactRelatesToSurrogate.display,
          this@CitationCitedArtifactRelatesToSurrogate._display,
        ),
      citation =
        Markdown.of(
          this@CitationCitedArtifactRelatesToSurrogate.citation,
          this@CitationCitedArtifactRelatesToSurrogate._citation,
        ),
      document = this@CitationCitedArtifactRelatesToSurrogate.document,
      resource =
        Canonical.of(
          this@CitationCitedArtifactRelatesToSurrogate.resource,
          this@CitationCitedArtifactRelatesToSurrogate._resource,
        ),
      resourceReference = this@CitationCitedArtifactRelatesToSurrogate.resourceReference,
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.RelatesTo
    ): CitationCitedArtifactRelatesToSurrogate =
      with(model) {
        CitationCitedArtifactRelatesToSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          classifier = this@with.classifier.takeIf { it.isNotEmpty() },
          label = this@with.label?.value,
          _label = this@with.label?.toElement(),
          display = this@with.display?.value,
          _display = this@with.display?.toElement(),
          citation = this@with.citation?.value,
          _citation = this@with.citation?.toElement(),
          document = this@with.document,
          resource = this@with.resource?.value,
          _resource = this@with.resource?.toElement(),
          resourceReference = this@with.resourceReference,
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactPublicationFormSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var publishedIn: Citation.CitedArtifact.PublicationForm.PublishedIn? = null,
  public var citedMedium: CodeableConcept? = null,
  public var volume: KotlinString? = null,
  public var _volume: Element? = null,
  public var issue: KotlinString? = null,
  public var _issue: Element? = null,
  public var articleDate: KotlinString? = null,
  public var _articleDate: Element? = null,
  public var publicationDateText: KotlinString? = null,
  public var _publicationDateText: Element? = null,
  public var publicationDateSeason: KotlinString? = null,
  public var _publicationDateSeason: Element? = null,
  public var lastRevisionDate: KotlinString? = null,
  public var _lastRevisionDate: Element? = null,
  public var language: List<CodeableConcept>? = null,
  public var accessionNumber: KotlinString? = null,
  public var _accessionNumber: Element? = null,
  public var pageString: KotlinString? = null,
  public var _pageString: Element? = null,
  public var firstPage: KotlinString? = null,
  public var _firstPage: Element? = null,
  public var lastPage: KotlinString? = null,
  public var _lastPage: Element? = null,
  public var pageCount: KotlinString? = null,
  public var _pageCount: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.PublicationForm =
    Citation.CitedArtifact.PublicationForm(
      id = this@CitationCitedArtifactPublicationFormSurrogate.id,
      extension = this@CitationCitedArtifactPublicationFormSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactPublicationFormSurrogate.modifierExtension ?: listOf(),
      publishedIn = this@CitationCitedArtifactPublicationFormSurrogate.publishedIn,
      citedMedium = this@CitationCitedArtifactPublicationFormSurrogate.citedMedium,
      volume =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.volume,
          this@CitationCitedArtifactPublicationFormSurrogate._volume,
        ),
      issue =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.issue,
          this@CitationCitedArtifactPublicationFormSurrogate._issue,
        ),
      articleDate =
        DateTime.of(
          FhirDateTime.fromString(this@CitationCitedArtifactPublicationFormSurrogate.articleDate),
          this@CitationCitedArtifactPublicationFormSurrogate._articleDate,
        ),
      publicationDateText =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.publicationDateText,
          this@CitationCitedArtifactPublicationFormSurrogate._publicationDateText,
        ),
      publicationDateSeason =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.publicationDateSeason,
          this@CitationCitedArtifactPublicationFormSurrogate._publicationDateSeason,
        ),
      lastRevisionDate =
        DateTime.of(
          FhirDateTime.fromString(
            this@CitationCitedArtifactPublicationFormSurrogate.lastRevisionDate
          ),
          this@CitationCitedArtifactPublicationFormSurrogate._lastRevisionDate,
        ),
      language = this@CitationCitedArtifactPublicationFormSurrogate.language ?: listOf(),
      accessionNumber =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.accessionNumber,
          this@CitationCitedArtifactPublicationFormSurrogate._accessionNumber,
        ),
      pageString =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.pageString,
          this@CitationCitedArtifactPublicationFormSurrogate._pageString,
        ),
      firstPage =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.firstPage,
          this@CitationCitedArtifactPublicationFormSurrogate._firstPage,
        ),
      lastPage =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.lastPage,
          this@CitationCitedArtifactPublicationFormSurrogate._lastPage,
        ),
      pageCount =
        R5String.of(
          this@CitationCitedArtifactPublicationFormSurrogate.pageCount,
          this@CitationCitedArtifactPublicationFormSurrogate._pageCount,
        ),
      copyright =
        Markdown.of(
          this@CitationCitedArtifactPublicationFormSurrogate.copyright,
          this@CitationCitedArtifactPublicationFormSurrogate._copyright,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.PublicationForm
    ): CitationCitedArtifactPublicationFormSurrogate =
      with(model) {
        CitationCitedArtifactPublicationFormSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          publishedIn = this@with.publishedIn,
          citedMedium = this@with.citedMedium,
          volume = this@with.volume?.value,
          _volume = this@with.volume?.toElement(),
          issue = this@with.issue?.value,
          _issue = this@with.issue?.toElement(),
          articleDate = this@with.articleDate?.value?.toString(),
          _articleDate = this@with.articleDate?.toElement(),
          publicationDateText = this@with.publicationDateText?.value,
          _publicationDateText = this@with.publicationDateText?.toElement(),
          publicationDateSeason = this@with.publicationDateSeason?.value,
          _publicationDateSeason = this@with.publicationDateSeason?.toElement(),
          lastRevisionDate = this@with.lastRevisionDate?.value?.toString(),
          _lastRevisionDate = this@with.lastRevisionDate?.toElement(),
          language = this@with.language.takeIf { it.isNotEmpty() },
          accessionNumber = this@with.accessionNumber?.value,
          _accessionNumber = this@with.accessionNumber?.toElement(),
          pageString = this@with.pageString?.value,
          _pageString = this@with.pageString?.toElement(),
          firstPage = this@with.firstPage?.value,
          _firstPage = this@with.firstPage?.toElement(),
          lastPage = this@with.lastPage?.value,
          _lastPage = this@with.lastPage?.toElement(),
          pageCount = this@with.pageCount?.value,
          _pageCount = this@with.pageCount?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactPublicationFormPublishedInSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var identifier: List<Identifier>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var publisher: Reference? = null,
  public var publisherLocation: KotlinString? = null,
  public var _publisherLocation: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.PublicationForm.PublishedIn =
    Citation.CitedArtifact.PublicationForm.PublishedIn(
      id = this@CitationCitedArtifactPublicationFormPublishedInSurrogate.id,
      extension =
        this@CitationCitedArtifactPublicationFormPublishedInSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactPublicationFormPublishedInSurrogate.modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactPublicationFormPublishedInSurrogate.type,
      identifier =
        this@CitationCitedArtifactPublicationFormPublishedInSurrogate.identifier ?: listOf(),
      title =
        R5String.of(
          this@CitationCitedArtifactPublicationFormPublishedInSurrogate.title,
          this@CitationCitedArtifactPublicationFormPublishedInSurrogate._title,
        ),
      publisher = this@CitationCitedArtifactPublicationFormPublishedInSurrogate.publisher,
      publisherLocation =
        R5String.of(
          this@CitationCitedArtifactPublicationFormPublishedInSurrogate.publisherLocation,
          this@CitationCitedArtifactPublicationFormPublishedInSurrogate._publisherLocation,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.PublicationForm.PublishedIn
    ): CitationCitedArtifactPublicationFormPublishedInSurrogate =
      with(model) {
        CitationCitedArtifactPublicationFormPublishedInSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          publisher = this@with.publisher,
          publisherLocation = this@with.publisherLocation?.value,
          _publisherLocation = this@with.publisherLocation?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactWebLocationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var classifier: List<CodeableConcept>? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.WebLocation =
    Citation.CitedArtifact.WebLocation(
      id = this@CitationCitedArtifactWebLocationSurrogate.id,
      extension = this@CitationCitedArtifactWebLocationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactWebLocationSurrogate.modifierExtension ?: listOf(),
      classifier = this@CitationCitedArtifactWebLocationSurrogate.classifier ?: listOf(),
      url =
        Uri.of(
          this@CitationCitedArtifactWebLocationSurrogate.url,
          this@CitationCitedArtifactWebLocationSurrogate._url,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.WebLocation
    ): CitationCitedArtifactWebLocationSurrogate =
      with(model) {
        CitationCitedArtifactWebLocationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          classifier = this@with.classifier.takeIf { it.isNotEmpty() },
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactClassificationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var classifier: List<CodeableConcept>? = null,
  public var artifactAssessment: List<Reference>? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Classification =
    Citation.CitedArtifact.Classification(
      id = this@CitationCitedArtifactClassificationSurrogate.id,
      extension = this@CitationCitedArtifactClassificationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactClassificationSurrogate.modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactClassificationSurrogate.type,
      classifier = this@CitationCitedArtifactClassificationSurrogate.classifier ?: listOf(),
      artifactAssessment =
        this@CitationCitedArtifactClassificationSurrogate.artifactAssessment ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Classification
    ): CitationCitedArtifactClassificationSurrogate =
      with(model) {
        CitationCitedArtifactClassificationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          classifier = this@with.classifier.takeIf { it.isNotEmpty() },
          artifactAssessment = this@with.artifactAssessment.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactContributorshipSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var complete: KotlinBoolean? = null,
  public var _complete: Element? = null,
  public var entry: List<Citation.CitedArtifact.Contributorship.Entry>? = null,
  public var summary: List<Citation.CitedArtifact.Contributorship.Summary>? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Contributorship =
    Citation.CitedArtifact.Contributorship(
      id = this@CitationCitedArtifactContributorshipSurrogate.id,
      extension = this@CitationCitedArtifactContributorshipSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactContributorshipSurrogate.modifierExtension ?: listOf(),
      complete =
        R5Boolean.of(
          this@CitationCitedArtifactContributorshipSurrogate.complete,
          this@CitationCitedArtifactContributorshipSurrogate._complete,
        ),
      entry = this@CitationCitedArtifactContributorshipSurrogate.entry ?: listOf(),
      summary = this@CitationCitedArtifactContributorshipSurrogate.summary ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Contributorship
    ): CitationCitedArtifactContributorshipSurrogate =
      with(model) {
        CitationCitedArtifactContributorshipSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          complete = this@with.complete?.value,
          _complete = this@with.complete?.toElement(),
          entry = this@with.entry.takeIf { it.isNotEmpty() },
          summary = this@with.summary.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactContributorshipEntrySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var contributor: Reference,
  public var forenameInitials: KotlinString? = null,
  public var _forenameInitials: Element? = null,
  public var affiliation: List<Reference>? = null,
  public var contributionType: List<CodeableConcept>? = null,
  public var role: CodeableConcept? = null,
  public var contributionInstance:
    List<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance>? =
    null,
  public var correspondingContact: KotlinBoolean? = null,
  public var _correspondingContact: Element? = null,
  public var rankingOrder: Int? = null,
  public var _rankingOrder: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Contributorship.Entry =
    Citation.CitedArtifact.Contributorship.Entry(
      id = this@CitationCitedArtifactContributorshipEntrySurrogate.id,
      extension = this@CitationCitedArtifactContributorshipEntrySurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactContributorshipEntrySurrogate.modifierExtension ?: listOf(),
      contributor = this@CitationCitedArtifactContributorshipEntrySurrogate.contributor,
      forenameInitials =
        R5String.of(
          this@CitationCitedArtifactContributorshipEntrySurrogate.forenameInitials,
          this@CitationCitedArtifactContributorshipEntrySurrogate._forenameInitials,
        ),
      affiliation = this@CitationCitedArtifactContributorshipEntrySurrogate.affiliation ?: listOf(),
      contributionType =
        this@CitationCitedArtifactContributorshipEntrySurrogate.contributionType ?: listOf(),
      role = this@CitationCitedArtifactContributorshipEntrySurrogate.role,
      contributionInstance =
        this@CitationCitedArtifactContributorshipEntrySurrogate.contributionInstance ?: listOf(),
      correspondingContact =
        R5Boolean.of(
          this@CitationCitedArtifactContributorshipEntrySurrogate.correspondingContact,
          this@CitationCitedArtifactContributorshipEntrySurrogate._correspondingContact,
        ),
      rankingOrder =
        PositiveInt.of(
          this@CitationCitedArtifactContributorshipEntrySurrogate.rankingOrder,
          this@CitationCitedArtifactContributorshipEntrySurrogate._rankingOrder,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Contributorship.Entry
    ): CitationCitedArtifactContributorshipEntrySurrogate =
      with(model) {
        CitationCitedArtifactContributorshipEntrySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          contributor = this@with.contributor,
          forenameInitials = this@with.forenameInitials?.value,
          _forenameInitials = this@with.forenameInitials?.toElement(),
          affiliation = this@with.affiliation.takeIf { it.isNotEmpty() },
          contributionType = this@with.contributionType.takeIf { it.isNotEmpty() },
          role = this@with.role,
          contributionInstance = this@with.contributionInstance.takeIf { it.isNotEmpty() },
          correspondingContact = this@with.correspondingContact?.value,
          _correspondingContact = this@with.correspondingContact?.toElement(),
          rankingOrder = this@with.rankingOrder?.value,
          _rankingOrder = this@with.rankingOrder?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var time: KotlinString? = null,
  public var _time: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Contributorship.Entry.ContributionInstance =
    Citation.CitedArtifact.Contributorship.Entry.ContributionInstance(
      id = this@CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate.id,
      extension =
        this@CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate.extension
          ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate
          .modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate.type,
      time =
        DateTime.of(
          FhirDateTime.fromString(
            this@CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate.time
          ),
          this@CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate._time,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Contributorship.Entry.ContributionInstance
    ): CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate =
      with(model) {
        CitationCitedArtifactContributorshipEntryContributionInstanceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          time = this@with.time?.value?.toString(),
          _time = this@with.time?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactContributorshipSummarySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var style: CodeableConcept? = null,
  public var source: CodeableConcept? = null,
  public var `value`: KotlinString? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Contributorship.Summary =
    Citation.CitedArtifact.Contributorship.Summary(
      id = this@CitationCitedArtifactContributorshipSummarySurrogate.id,
      extension = this@CitationCitedArtifactContributorshipSummarySurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactContributorshipSummarySurrogate.modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactContributorshipSummarySurrogate.type,
      style = this@CitationCitedArtifactContributorshipSummarySurrogate.style,
      source = this@CitationCitedArtifactContributorshipSummarySurrogate.source,
      `value` =
        Markdown.of(
          this@CitationCitedArtifactContributorshipSummarySurrogate.`value`,
          this@CitationCitedArtifactContributorshipSummarySurrogate._value,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Contributorship.Summary
    ): CitationCitedArtifactContributorshipSummarySurrogate =
      with(model) {
        CitationCitedArtifactContributorshipSummarySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          style = this@with.style,
          source = this@with.source,
          `value` = this@with.`value`.value,
          _value = this@with.`value`.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): Citation.VersionAlgorithm =
    Citation.VersionAlgorithm.from(
      R5String.of(
        this@CitationVersionAlgorithmSurrogate.versionAlgorithmString,
        this@CitationVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@CitationVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(model: Citation.VersionAlgorithm): CitationVersionAlgorithmSurrogate =
      with(model) {
        CitationVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class CitationSurrogate(
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
  public var versionAlgorithm: Citation.VersionAlgorithm? = null,
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
  public var author: List<ContactDetail>? = null,
  public var editor: List<ContactDetail>? = null,
  public var reviewer: List<ContactDetail>? = null,
  public var endorser: List<ContactDetail>? = null,
  public var summary: List<Citation.Summary>? = null,
  public var classification: List<Citation.Classification>? = null,
  public var note: List<Annotation>? = null,
  public var currentState: List<CodeableConcept>? = null,
  public var statusDate: List<Citation.StatusDate>? = null,
  public var relatedArtifact: List<RelatedArtifact>? = null,
  public var citedArtifact: Citation.CitedArtifact? = null,
) {
  public fun toModel(): Citation =
    Citation(
      id = this@CitationSurrogate.id,
      meta = this@CitationSurrogate.meta,
      implicitRules =
        Uri.of(this@CitationSurrogate.implicitRules, this@CitationSurrogate._implicitRules),
      language = Code.of(this@CitationSurrogate.language, this@CitationSurrogate._language),
      text = this@CitationSurrogate.text,
      contained = this@CitationSurrogate.contained ?: listOf(),
      extension = this@CitationSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@CitationSurrogate.url, this@CitationSurrogate._url),
      identifier = this@CitationSurrogate.identifier ?: listOf(),
      version = R5String.of(this@CitationSurrogate.version, this@CitationSurrogate._version),
      versionAlgorithm = this@CitationSurrogate.versionAlgorithm,
      name = R5String.of(this@CitationSurrogate.name, this@CitationSurrogate._name),
      title = R5String.of(this@CitationSurrogate.title, this@CitationSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@CitationSurrogate.status!!),
          this@CitationSurrogate._status,
        ),
      experimental =
        R5Boolean.of(this@CitationSurrogate.experimental, this@CitationSurrogate._experimental),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@CitationSurrogate.date),
          this@CitationSurrogate._date,
        ),
      publisher = R5String.of(this@CitationSurrogate.publisher, this@CitationSurrogate._publisher),
      contact = this@CitationSurrogate.contact ?: listOf(),
      description =
        Markdown.of(this@CitationSurrogate.description, this@CitationSurrogate._description),
      useContext = this@CitationSurrogate.useContext ?: listOf(),
      jurisdiction = this@CitationSurrogate.jurisdiction ?: listOf(),
      purpose = Markdown.of(this@CitationSurrogate.purpose, this@CitationSurrogate._purpose),
      copyright = Markdown.of(this@CitationSurrogate.copyright, this@CitationSurrogate._copyright),
      copyrightLabel =
        R5String.of(this@CitationSurrogate.copyrightLabel, this@CitationSurrogate._copyrightLabel),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@CitationSurrogate.approvalDate),
          this@CitationSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@CitationSurrogate.lastReviewDate),
          this@CitationSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@CitationSurrogate.effectivePeriod,
      author = this@CitationSurrogate.author ?: listOf(),
      editor = this@CitationSurrogate.editor ?: listOf(),
      reviewer = this@CitationSurrogate.reviewer ?: listOf(),
      endorser = this@CitationSurrogate.endorser ?: listOf(),
      summary = this@CitationSurrogate.summary ?: listOf(),
      classification = this@CitationSurrogate.classification ?: listOf(),
      note = this@CitationSurrogate.note ?: listOf(),
      currentState = this@CitationSurrogate.currentState ?: listOf(),
      statusDate = this@CitationSurrogate.statusDate ?: listOf(),
      relatedArtifact = this@CitationSurrogate.relatedArtifact ?: listOf(),
      citedArtifact = this@CitationSurrogate.citedArtifact,
    )

  public companion object {
    public fun fromModel(model: Citation): CitationSurrogate =
      with(model) {
        CitationSurrogate(
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
          author = this@with.author.takeIf { it.isNotEmpty() },
          editor = this@with.editor.takeIf { it.isNotEmpty() },
          reviewer = this@with.reviewer.takeIf { it.isNotEmpty() },
          endorser = this@with.endorser.takeIf { it.isNotEmpty() },
          summary = this@with.summary.takeIf { it.isNotEmpty() },
          classification = this@with.classification.takeIf { it.isNotEmpty() },
          note = this@with.note.takeIf { it.isNotEmpty() },
          currentState = this@with.currentState.takeIf { it.isNotEmpty() },
          statusDate = this@with.statusDate.takeIf { it.isNotEmpty() },
          relatedArtifact = this@with.relatedArtifact.takeIf { it.isNotEmpty() },
          citedArtifact = this@with.citedArtifact,
        )
      }
  }
}

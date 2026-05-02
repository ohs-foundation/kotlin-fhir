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

import com.google.fhir.model.r4b.Address
import com.google.fhir.model.r4b.Annotation
import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Citation
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.ContactPoint
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.HumanName
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.PositiveInt
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
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
        R4bBoolean.of(
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
internal data class CitationRelatesToSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var relationshipType: CodeableConcept,
  public var targetClassifier: List<CodeableConcept>? = null,
  public var target: Citation.RelatesTo.Target,
) {
  public fun toModel(): Citation.RelatesTo =
    Citation.RelatesTo(
      id = this@CitationRelatesToSurrogate.id,
      extension = this@CitationRelatesToSurrogate.extension ?: listOf(),
      modifierExtension = this@CitationRelatesToSurrogate.modifierExtension ?: listOf(),
      relationshipType = this@CitationRelatesToSurrogate.relationshipType,
      targetClassifier = this@CitationRelatesToSurrogate.targetClassifier ?: listOf(),
      target = this@CitationRelatesToSurrogate.target,
    )

  public companion object {
    public fun fromModel(model: Citation.RelatesTo): CitationRelatesToSurrogate =
      with(model) {
        CitationRelatesToSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          relationshipType = this@with.relationshipType,
          targetClassifier = this@with.targetClassifier.takeIf { it.isNotEmpty() },
          target = this@with.target,
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
        R4bString.of(
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
        R4bBoolean.of(
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
        R4bString.of(
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
  public var relationshipType: CodeableConcept,
  public var targetClassifier: List<CodeableConcept>? = null,
  public var target: Citation.CitedArtifact.RelatesTo.Target,
) {
  public fun toModel(): Citation.CitedArtifact.RelatesTo =
    Citation.CitedArtifact.RelatesTo(
      id = this@CitationCitedArtifactRelatesToSurrogate.id,
      extension = this@CitationCitedArtifactRelatesToSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactRelatesToSurrogate.modifierExtension ?: listOf(),
      relationshipType = this@CitationCitedArtifactRelatesToSurrogate.relationshipType,
      targetClassifier = this@CitationCitedArtifactRelatesToSurrogate.targetClassifier ?: listOf(),
      target = this@CitationCitedArtifactRelatesToSurrogate.target,
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
          relationshipType = this@with.relationshipType,
          targetClassifier = this@with.targetClassifier.takeIf { it.isNotEmpty() },
          target = this@with.target,
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
  public var periodicRelease: Citation.CitedArtifact.PublicationForm.PeriodicRelease? = null,
  public var articleDate: KotlinString? = null,
  public var _articleDate: Element? = null,
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
      periodicRelease = this@CitationCitedArtifactPublicationFormSurrogate.periodicRelease,
      articleDate =
        DateTime.of(
          FhirDateTime.fromString(this@CitationCitedArtifactPublicationFormSurrogate.articleDate),
          this@CitationCitedArtifactPublicationFormSurrogate._articleDate,
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
        R4bString.of(
          this@CitationCitedArtifactPublicationFormSurrogate.accessionNumber,
          this@CitationCitedArtifactPublicationFormSurrogate._accessionNumber,
        ),
      pageString =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormSurrogate.pageString,
          this@CitationCitedArtifactPublicationFormSurrogate._pageString,
        ),
      firstPage =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormSurrogate.firstPage,
          this@CitationCitedArtifactPublicationFormSurrogate._firstPage,
        ),
      lastPage =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormSurrogate.lastPage,
          this@CitationCitedArtifactPublicationFormSurrogate._lastPage,
        ),
      pageCount =
        R4bString.of(
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
          periodicRelease = this@with.periodicRelease,
          articleDate = this@with.articleDate?.value?.toString(),
          _articleDate = this@with.articleDate?.toElement(),
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
        R4bString.of(
          this@CitationCitedArtifactPublicationFormPublishedInSurrogate.title,
          this@CitationCitedArtifactPublicationFormPublishedInSurrogate._title,
        ),
      publisher = this@CitationCitedArtifactPublicationFormPublishedInSurrogate.publisher,
      publisherLocation =
        R4bString.of(
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
internal data class CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var citedMedium: CodeableConcept? = null,
  public var volume: KotlinString? = null,
  public var _volume: Element? = null,
  public var issue: KotlinString? = null,
  public var _issue: Element? = null,
  public var dateOfPublication:
    Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication? =
    null,
) {
  public fun toModel(): Citation.CitedArtifact.PublicationForm.PeriodicRelease =
    Citation.CitedArtifact.PublicationForm.PeriodicRelease(
      id = this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.id,
      extension =
        this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.modifierExtension
          ?: listOf(),
      citedMedium = this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.citedMedium,
      volume =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.volume,
          this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate._volume,
        ),
      issue =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.issue,
          this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate._issue,
        ),
      dateOfPublication =
        this@CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate.dateOfPublication,
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.PublicationForm.PeriodicRelease
    ): CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate =
      with(model) {
        CitationCitedArtifactPublicationFormPeriodicReleaseSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          citedMedium = this@with.citedMedium,
          volume = this@with.volume?.value,
          _volume = this@with.volume?.toElement(),
          issue = this@with.issue?.value,
          _issue = this@with.issue?.toElement(),
          dateOfPublication = this@with.dateOfPublication,
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var year: KotlinString? = null,
  public var _year: Element? = null,
  public var month: KotlinString? = null,
  public var _month: Element? = null,
  public var day: KotlinString? = null,
  public var _day: Element? = null,
  public var season: KotlinString? = null,
  public var _season: Element? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication =
    Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication(
      id = this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.id,
      extension =
        this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.extension
          ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate
          .modifierExtension ?: listOf(),
      date =
        Date.of(
          FhirDate.fromString(
            this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.date
          ),
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate._date,
        ),
      year =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.year,
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate._year,
        ),
      month =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.month,
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate._month,
        ),
      day =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.day,
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate._day,
        ),
      season =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.season,
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate._season,
        ),
      text =
        R4bString.of(
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate.text,
          this@CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate._text,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication
    ): CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate =
      with(model) {
        CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          year = this@with.year?.value,
          _year = this@with.year?.toElement(),
          month = this@with.month?.value,
          _month = this@with.month?.toElement(),
          day = this@with.day?.value,
          _day = this@with.day?.toElement(),
          season = this@with.season?.value,
          _season = this@with.season?.toElement(),
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactWebLocationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.WebLocation =
    Citation.CitedArtifact.WebLocation(
      id = this@CitationCitedArtifactWebLocationSurrogate.id,
      extension = this@CitationCitedArtifactWebLocationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactWebLocationSurrogate.modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactWebLocationSurrogate.type,
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
          type = this@with.type,
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
  public var whoClassified: Citation.CitedArtifact.Classification.WhoClassified? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Classification =
    Citation.CitedArtifact.Classification(
      id = this@CitationCitedArtifactClassificationSurrogate.id,
      extension = this@CitationCitedArtifactClassificationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactClassificationSurrogate.modifierExtension ?: listOf(),
      type = this@CitationCitedArtifactClassificationSurrogate.type,
      classifier = this@CitationCitedArtifactClassificationSurrogate.classifier ?: listOf(),
      whoClassified = this@CitationCitedArtifactClassificationSurrogate.whoClassified,
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
          whoClassified = this@with.whoClassified,
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactClassificationWhoClassifiedSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var person: Reference? = null,
  public var organization: Reference? = null,
  public var publisher: Reference? = null,
  public var classifierCopyright: KotlinString? = null,
  public var _classifierCopyright: Element? = null,
  public var freeToShare: KotlinBoolean? = null,
  public var _freeToShare: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Classification.WhoClassified =
    Citation.CitedArtifact.Classification.WhoClassified(
      id = this@CitationCitedArtifactClassificationWhoClassifiedSurrogate.id,
      extension =
        this@CitationCitedArtifactClassificationWhoClassifiedSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactClassificationWhoClassifiedSurrogate.modifierExtension
          ?: listOf(),
      person = this@CitationCitedArtifactClassificationWhoClassifiedSurrogate.person,
      organization = this@CitationCitedArtifactClassificationWhoClassifiedSurrogate.organization,
      publisher = this@CitationCitedArtifactClassificationWhoClassifiedSurrogate.publisher,
      classifierCopyright =
        R4bString.of(
          this@CitationCitedArtifactClassificationWhoClassifiedSurrogate.classifierCopyright,
          this@CitationCitedArtifactClassificationWhoClassifiedSurrogate._classifierCopyright,
        ),
      freeToShare =
        R4bBoolean.of(
          this@CitationCitedArtifactClassificationWhoClassifiedSurrogate.freeToShare,
          this@CitationCitedArtifactClassificationWhoClassifiedSurrogate._freeToShare,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Classification.WhoClassified
    ): CitationCitedArtifactClassificationWhoClassifiedSurrogate =
      with(model) {
        CitationCitedArtifactClassificationWhoClassifiedSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          person = this@with.person,
          organization = this@with.organization,
          publisher = this@with.publisher,
          classifierCopyright = this@with.classifierCopyright?.value,
          _classifierCopyright = this@with.classifierCopyright?.toElement(),
          freeToShare = this@with.freeToShare?.value,
          _freeToShare = this@with.freeToShare?.toElement(),
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
        R4bBoolean.of(
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
  public var name: HumanName? = null,
  public var initials: KotlinString? = null,
  public var _initials: Element? = null,
  public var collectiveName: KotlinString? = null,
  public var _collectiveName: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var affiliationInfo: List<Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo>? =
    null,
  public var address: List<Address>? = null,
  public var telecom: List<ContactPoint>? = null,
  public var contributionType: List<CodeableConcept>? = null,
  public var role: CodeableConcept? = null,
  public var contributionInstance:
    List<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance>? =
    null,
  public var correspondingContact: KotlinBoolean? = null,
  public var _correspondingContact: Element? = null,
  public var listOrder: Int? = null,
  public var _listOrder: Element? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Contributorship.Entry =
    Citation.CitedArtifact.Contributorship.Entry(
      id = this@CitationCitedArtifactContributorshipEntrySurrogate.id,
      extension = this@CitationCitedArtifactContributorshipEntrySurrogate.extension ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactContributorshipEntrySurrogate.modifierExtension ?: listOf(),
      name = this@CitationCitedArtifactContributorshipEntrySurrogate.name,
      initials =
        R4bString.of(
          this@CitationCitedArtifactContributorshipEntrySurrogate.initials,
          this@CitationCitedArtifactContributorshipEntrySurrogate._initials,
        ),
      collectiveName =
        R4bString.of(
          this@CitationCitedArtifactContributorshipEntrySurrogate.collectiveName,
          this@CitationCitedArtifactContributorshipEntrySurrogate._collectiveName,
        ),
      identifier = this@CitationCitedArtifactContributorshipEntrySurrogate.identifier ?: listOf(),
      affiliationInfo =
        this@CitationCitedArtifactContributorshipEntrySurrogate.affiliationInfo ?: listOf(),
      address = this@CitationCitedArtifactContributorshipEntrySurrogate.address ?: listOf(),
      telecom = this@CitationCitedArtifactContributorshipEntrySurrogate.telecom ?: listOf(),
      contributionType =
        this@CitationCitedArtifactContributorshipEntrySurrogate.contributionType ?: listOf(),
      role = this@CitationCitedArtifactContributorshipEntrySurrogate.role,
      contributionInstance =
        this@CitationCitedArtifactContributorshipEntrySurrogate.contributionInstance ?: listOf(),
      correspondingContact =
        R4bBoolean.of(
          this@CitationCitedArtifactContributorshipEntrySurrogate.correspondingContact,
          this@CitationCitedArtifactContributorshipEntrySurrogate._correspondingContact,
        ),
      listOrder =
        PositiveInt.of(
          this@CitationCitedArtifactContributorshipEntrySurrogate.listOrder,
          this@CitationCitedArtifactContributorshipEntrySurrogate._listOrder,
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
          name = this@with.name,
          initials = this@with.initials?.value,
          _initials = this@with.initials?.toElement(),
          collectiveName = this@with.collectiveName?.value,
          _collectiveName = this@with.collectiveName?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          affiliationInfo = this@with.affiliationInfo.takeIf { it.isNotEmpty() },
          address = this@with.address.takeIf { it.isNotEmpty() },
          telecom = this@with.telecom.takeIf { it.isNotEmpty() },
          contributionType = this@with.contributionType.takeIf { it.isNotEmpty() },
          role = this@with.role,
          contributionInstance = this@with.contributionInstance.takeIf { it.isNotEmpty() },
          correspondingContact = this@with.correspondingContact?.value,
          _correspondingContact = this@with.correspondingContact?.toElement(),
          listOrder = this@with.listOrder?.value,
          _listOrder = this@with.listOrder?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var affiliation: KotlinString? = null,
  public var _affiliation: Element? = null,
  public var role: KotlinString? = null,
  public var _role: Element? = null,
  public var identifier: List<Identifier>? = null,
) {
  public fun toModel(): Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo =
    Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo(
      id = this@CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate.id,
      extension =
        this@CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate.extension
          ?: listOf(),
      modifierExtension =
        this@CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate.modifierExtension
          ?: listOf(),
      affiliation =
        R4bString.of(
          this@CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate.affiliation,
          this@CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate._affiliation,
        ),
      role =
        R4bString.of(
          this@CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate.role,
          this@CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate._role,
        ),
      identifier =
        this@CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate.identifier
          ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo
    ): CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate =
      with(model) {
        CitationCitedArtifactContributorshipEntryAffiliationInfoSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          affiliation = this@with.affiliation?.value,
          _affiliation = this@with.affiliation?.toElement(),
          role = this@with.role?.value,
          _role = this@with.role?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
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
internal data class CitationRelatesToTargetSurrogate(
  public var targetUri: KotlinString? = null,
  public var _targetUri: Element? = null,
  public var targetIdentifier: Identifier? = null,
  public var targetReference: Reference? = null,
  public var targetAttachment: Attachment? = null,
) {
  public fun toModel(): Citation.RelatesTo.Target =
    Citation.RelatesTo.Target.from(
      Uri.of(
        this@CitationRelatesToTargetSurrogate.targetUri,
        this@CitationRelatesToTargetSurrogate._targetUri,
      ),
      this@CitationRelatesToTargetSurrogate.targetIdentifier,
      this@CitationRelatesToTargetSurrogate.targetReference,
      this@CitationRelatesToTargetSurrogate.targetAttachment,
    )!!

  public companion object {
    public fun fromModel(model: Citation.RelatesTo.Target): CitationRelatesToTargetSurrogate =
      with(model) {
        CitationRelatesToTargetSurrogate(
          targetUri = this@with.asUri()?.value?.value,
          _targetUri = this@with.asUri()?.value?.toElement(),
          targetIdentifier = this@with.asIdentifier()?.value,
          targetReference = this@with.asReference()?.value,
          targetAttachment = this@with.asAttachment()?.value,
        )
      }
  }
}

@Serializable
internal data class CitationCitedArtifactRelatesToTargetSurrogate(
  public var targetUri: KotlinString? = null,
  public var _targetUri: Element? = null,
  public var targetIdentifier: Identifier? = null,
  public var targetReference: Reference? = null,
  public var targetAttachment: Attachment? = null,
) {
  public fun toModel(): Citation.CitedArtifact.RelatesTo.Target =
    Citation.CitedArtifact.RelatesTo.Target.from(
      Uri.of(
        this@CitationCitedArtifactRelatesToTargetSurrogate.targetUri,
        this@CitationCitedArtifactRelatesToTargetSurrogate._targetUri,
      ),
      this@CitationCitedArtifactRelatesToTargetSurrogate.targetIdentifier,
      this@CitationCitedArtifactRelatesToTargetSurrogate.targetReference,
      this@CitationCitedArtifactRelatesToTargetSurrogate.targetAttachment,
    )!!

  public companion object {
    public fun fromModel(
      model: Citation.CitedArtifact.RelatesTo.Target
    ): CitationCitedArtifactRelatesToTargetSurrogate =
      with(model) {
        CitationCitedArtifactRelatesToTargetSurrogate(
          targetUri = this@with.asUri()?.value?.value,
          _targetUri = this@with.asUri()?.value?.toElement(),
          targetIdentifier = this@with.asIdentifier()?.value,
          targetReference = this@with.asReference()?.value,
          targetAttachment = this@with.asAttachment()?.value,
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
  public var relatesTo: List<Citation.RelatesTo>? = null,
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
      version = R4bString.of(this@CitationSurrogate.version, this@CitationSurrogate._version),
      name = R4bString.of(this@CitationSurrogate.name, this@CitationSurrogate._name),
      title = R4bString.of(this@CitationSurrogate.title, this@CitationSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@CitationSurrogate.status!!),
          this@CitationSurrogate._status,
        ),
      experimental =
        R4bBoolean.of(this@CitationSurrogate.experimental, this@CitationSurrogate._experimental),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@CitationSurrogate.date),
          this@CitationSurrogate._date,
        ),
      publisher = R4bString.of(this@CitationSurrogate.publisher, this@CitationSurrogate._publisher),
      contact = this@CitationSurrogate.contact ?: listOf(),
      description =
        Markdown.of(this@CitationSurrogate.description, this@CitationSurrogate._description),
      useContext = this@CitationSurrogate.useContext ?: listOf(),
      jurisdiction = this@CitationSurrogate.jurisdiction ?: listOf(),
      purpose = Markdown.of(this@CitationSurrogate.purpose, this@CitationSurrogate._purpose),
      copyright = Markdown.of(this@CitationSurrogate.copyright, this@CitationSurrogate._copyright),
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
      relatesTo = this@CitationSurrogate.relatesTo ?: listOf(),
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
          relatesTo = this@with.relatesTo.takeIf { it.isNotEmpty() },
          citedArtifact = this@with.citedArtifact,
        )
      }
  }
}

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
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Duration
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.MeasureReport
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MeasureReportGroupSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var linkId: KotlinString? = null,
  public var _linkId: Element? = null,
  public var code: CodeableConcept? = null,
  public var subject: Reference? = null,
  public var population: List<MeasureReport.Group.Population>? = null,
  public var measureScore: MeasureReport.Group.MeasureScore? = null,
  public var stratifier: List<MeasureReport.Group.Stratifier>? = null,
) {
  public fun toModel(): MeasureReport.Group =
    MeasureReport.Group(
      id = this@MeasureReportGroupSurrogate.id,
      extension = this@MeasureReportGroupSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureReportGroupSurrogate.modifierExtension ?: listOf(),
      linkId =
        R5String.of(
          this@MeasureReportGroupSurrogate.linkId,
          this@MeasureReportGroupSurrogate._linkId,
        ),
      code = this@MeasureReportGroupSurrogate.code,
      subject = this@MeasureReportGroupSurrogate.subject,
      population = this@MeasureReportGroupSurrogate.population ?: listOf(),
      measureScore = this@MeasureReportGroupSurrogate.measureScore,
      stratifier = this@MeasureReportGroupSurrogate.stratifier ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MeasureReport.Group): MeasureReportGroupSurrogate =
      with(model) {
        MeasureReportGroupSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          linkId = this@with.linkId?.value,
          _linkId = this@with.linkId?.toElement(),
          code = this@with.code,
          subject = this@with.subject,
          population = this@with.population.takeIf { it.isNotEmpty() },
          measureScore = this@with.measureScore,
          stratifier = this@with.stratifier.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupPopulationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var linkId: KotlinString? = null,
  public var _linkId: Element? = null,
  public var code: CodeableConcept? = null,
  public var count: Int? = null,
  public var _count: Element? = null,
  public var subjectResults: Reference? = null,
  public var subjectReport: List<Reference>? = null,
  public var subjects: Reference? = null,
) {
  public fun toModel(): MeasureReport.Group.Population =
    MeasureReport.Group.Population(
      id = this@MeasureReportGroupPopulationSurrogate.id,
      extension = this@MeasureReportGroupPopulationSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureReportGroupPopulationSurrogate.modifierExtension ?: listOf(),
      linkId =
        R5String.of(
          this@MeasureReportGroupPopulationSurrogate.linkId,
          this@MeasureReportGroupPopulationSurrogate._linkId,
        ),
      code = this@MeasureReportGroupPopulationSurrogate.code,
      count =
        Integer.of(
          this@MeasureReportGroupPopulationSurrogate.count,
          this@MeasureReportGroupPopulationSurrogate._count,
        ),
      subjectResults = this@MeasureReportGroupPopulationSurrogate.subjectResults,
      subjectReport = this@MeasureReportGroupPopulationSurrogate.subjectReport ?: listOf(),
      subjects = this@MeasureReportGroupPopulationSurrogate.subjects,
    )

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.Population
    ): MeasureReportGroupPopulationSurrogate =
      with(model) {
        MeasureReportGroupPopulationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          linkId = this@with.linkId?.value,
          _linkId = this@with.linkId?.toElement(),
          code = this@with.code,
          count = this@with.count?.value,
          _count = this@with.count?.toElement(),
          subjectResults = this@with.subjectResults,
          subjectReport = this@with.subjectReport.takeIf { it.isNotEmpty() },
          subjects = this@with.subjects,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var linkId: KotlinString? = null,
  public var _linkId: Element? = null,
  public var code: CodeableConcept? = null,
  public var stratum: List<MeasureReport.Group.Stratifier.Stratum>? = null,
) {
  public fun toModel(): MeasureReport.Group.Stratifier =
    MeasureReport.Group.Stratifier(
      id = this@MeasureReportGroupStratifierSurrogate.id,
      extension = this@MeasureReportGroupStratifierSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureReportGroupStratifierSurrogate.modifierExtension ?: listOf(),
      linkId =
        R5String.of(
          this@MeasureReportGroupStratifierSurrogate.linkId,
          this@MeasureReportGroupStratifierSurrogate._linkId,
        ),
      code = this@MeasureReportGroupStratifierSurrogate.code,
      stratum = this@MeasureReportGroupStratifierSurrogate.stratum ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.Stratifier
    ): MeasureReportGroupStratifierSurrogate =
      with(model) {
        MeasureReportGroupStratifierSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          linkId = this@with.linkId?.value,
          _linkId = this@with.linkId?.toElement(),
          code = this@with.code,
          stratum = this@with.stratum.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierStratumSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: MeasureReport.Group.Stratifier.Stratum.Value? = null,
  public var component: List<MeasureReport.Group.Stratifier.Stratum.Component>? = null,
  public var population: List<MeasureReport.Group.Stratifier.Stratum.Population>? = null,
  public var measureScore: MeasureReport.Group.Stratifier.Stratum.MeasureScore? = null,
) {
  public fun toModel(): MeasureReport.Group.Stratifier.Stratum =
    MeasureReport.Group.Stratifier.Stratum(
      id = this@MeasureReportGroupStratifierStratumSurrogate.id,
      extension = this@MeasureReportGroupStratifierStratumSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MeasureReportGroupStratifierStratumSurrogate.modifierExtension ?: listOf(),
      `value` = this@MeasureReportGroupStratifierStratumSurrogate.`value`,
      component = this@MeasureReportGroupStratifierStratumSurrogate.component ?: listOf(),
      population = this@MeasureReportGroupStratifierStratumSurrogate.population ?: listOf(),
      measureScore = this@MeasureReportGroupStratifierStratumSurrogate.measureScore,
    )

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.Stratifier.Stratum
    ): MeasureReportGroupStratifierStratumSurrogate =
      with(model) {
        MeasureReportGroupStratifierStratumSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
          component = this@with.component.takeIf { it.isNotEmpty() },
          population = this@with.population.takeIf { it.isNotEmpty() },
          measureScore = this@with.measureScore,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierStratumComponentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var linkId: KotlinString? = null,
  public var _linkId: Element? = null,
  public var code: CodeableConcept,
  public var `value`: MeasureReport.Group.Stratifier.Stratum.Component.Value,
) {
  public fun toModel(): MeasureReport.Group.Stratifier.Stratum.Component =
    MeasureReport.Group.Stratifier.Stratum.Component(
      id = this@MeasureReportGroupStratifierStratumComponentSurrogate.id,
      extension = this@MeasureReportGroupStratifierStratumComponentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MeasureReportGroupStratifierStratumComponentSurrogate.modifierExtension ?: listOf(),
      linkId =
        R5String.of(
          this@MeasureReportGroupStratifierStratumComponentSurrogate.linkId,
          this@MeasureReportGroupStratifierStratumComponentSurrogate._linkId,
        ),
      code = this@MeasureReportGroupStratifierStratumComponentSurrogate.code,
      `value` = this@MeasureReportGroupStratifierStratumComponentSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.Stratifier.Stratum.Component
    ): MeasureReportGroupStratifierStratumComponentSurrogate =
      with(model) {
        MeasureReportGroupStratifierStratumComponentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          linkId = this@with.linkId?.value,
          _linkId = this@with.linkId?.toElement(),
          code = this@with.code,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierStratumPopulationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var linkId: KotlinString? = null,
  public var _linkId: Element? = null,
  public var code: CodeableConcept? = null,
  public var count: Int? = null,
  public var _count: Element? = null,
  public var subjectResults: Reference? = null,
  public var subjectReport: List<Reference>? = null,
  public var subjects: Reference? = null,
) {
  public fun toModel(): MeasureReport.Group.Stratifier.Stratum.Population =
    MeasureReport.Group.Stratifier.Stratum.Population(
      id = this@MeasureReportGroupStratifierStratumPopulationSurrogate.id,
      extension = this@MeasureReportGroupStratifierStratumPopulationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MeasureReportGroupStratifierStratumPopulationSurrogate.modifierExtension ?: listOf(),
      linkId =
        R5String.of(
          this@MeasureReportGroupStratifierStratumPopulationSurrogate.linkId,
          this@MeasureReportGroupStratifierStratumPopulationSurrogate._linkId,
        ),
      code = this@MeasureReportGroupStratifierStratumPopulationSurrogate.code,
      count =
        Integer.of(
          this@MeasureReportGroupStratifierStratumPopulationSurrogate.count,
          this@MeasureReportGroupStratifierStratumPopulationSurrogate._count,
        ),
      subjectResults = this@MeasureReportGroupStratifierStratumPopulationSurrogate.subjectResults,
      subjectReport =
        this@MeasureReportGroupStratifierStratumPopulationSurrogate.subjectReport ?: listOf(),
      subjects = this@MeasureReportGroupStratifierStratumPopulationSurrogate.subjects,
    )

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.Stratifier.Stratum.Population
    ): MeasureReportGroupStratifierStratumPopulationSurrogate =
      with(model) {
        MeasureReportGroupStratifierStratumPopulationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          linkId = this@with.linkId?.value,
          _linkId = this@with.linkId?.toElement(),
          code = this@with.code,
          count = this@with.count?.value,
          _count = this@with.count?.toElement(),
          subjectResults = this@with.subjectResults,
          subjectReport = this@with.subjectReport.takeIf { it.isNotEmpty() },
          subjects = this@with.subjects,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupMeasureScoreSurrogate(
  public var measureScoreQuantity: Quantity? = null,
  public var measureScoreDateTime: KotlinString? = null,
  public var _measureScoreDateTime: Element? = null,
  public var measureScoreCodeableConcept: CodeableConcept? = null,
  public var measureScorePeriod: Period? = null,
  public var measureScoreRange: Range? = null,
  public var measureScoreDuration: Duration? = null,
) {
  public fun toModel(): MeasureReport.Group.MeasureScore =
    MeasureReport.Group.MeasureScore.from(
      this@MeasureReportGroupMeasureScoreSurrogate.measureScoreQuantity,
      DateTime.of(
        FhirDateTime.fromString(this@MeasureReportGroupMeasureScoreSurrogate.measureScoreDateTime),
        this@MeasureReportGroupMeasureScoreSurrogate._measureScoreDateTime,
      ),
      this@MeasureReportGroupMeasureScoreSurrogate.measureScoreCodeableConcept,
      this@MeasureReportGroupMeasureScoreSurrogate.measureScorePeriod,
      this@MeasureReportGroupMeasureScoreSurrogate.measureScoreRange,
      this@MeasureReportGroupMeasureScoreSurrogate.measureScoreDuration,
    )!!

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.MeasureScore
    ): MeasureReportGroupMeasureScoreSurrogate =
      with(model) {
        MeasureReportGroupMeasureScoreSurrogate(
          measureScoreQuantity = this@with.asQuantity()?.value,
          measureScoreDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _measureScoreDateTime = this@with.asDateTime()?.value?.toElement(),
          measureScoreCodeableConcept = this@with.asCodeableConcept()?.value,
          measureScorePeriod = this@with.asPeriod()?.value,
          measureScoreRange = this@with.asRange()?.value,
          measureScoreDuration = this@with.asDuration()?.value,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierStratumValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): MeasureReport.Group.Stratifier.Stratum.Value =
    MeasureReport.Group.Stratifier.Stratum.Value.from(
      this@MeasureReportGroupStratifierStratumValueSurrogate.valueCodeableConcept,
      R5Boolean.of(
        this@MeasureReportGroupStratifierStratumValueSurrogate.valueBoolean,
        this@MeasureReportGroupStratifierStratumValueSurrogate._valueBoolean,
      ),
      this@MeasureReportGroupStratifierStratumValueSurrogate.valueQuantity,
      this@MeasureReportGroupStratifierStratumValueSurrogate.valueRange,
      this@MeasureReportGroupStratifierStratumValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.Stratifier.Stratum.Value
    ): MeasureReportGroupStratifierStratumValueSurrogate =
      with(model) {
        MeasureReportGroupStratifierStratumValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierStratumComponentValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): MeasureReport.Group.Stratifier.Stratum.Component.Value =
    MeasureReport.Group.Stratifier.Stratum.Component.Value.from(
      this@MeasureReportGroupStratifierStratumComponentValueSurrogate.valueCodeableConcept,
      R5Boolean.of(
        this@MeasureReportGroupStratifierStratumComponentValueSurrogate.valueBoolean,
        this@MeasureReportGroupStratifierStratumComponentValueSurrogate._valueBoolean,
      ),
      this@MeasureReportGroupStratifierStratumComponentValueSurrogate.valueQuantity,
      this@MeasureReportGroupStratifierStratumComponentValueSurrogate.valueRange,
      this@MeasureReportGroupStratifierStratumComponentValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.Stratifier.Stratum.Component.Value
    ): MeasureReportGroupStratifierStratumComponentValueSurrogate =
      with(model) {
        MeasureReportGroupStratifierStratumComponentValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierStratumMeasureScoreSurrogate(
  public var measureScoreQuantity: Quantity? = null,
  public var measureScoreDateTime: KotlinString? = null,
  public var _measureScoreDateTime: Element? = null,
  public var measureScoreCodeableConcept: CodeableConcept? = null,
  public var measureScorePeriod: Period? = null,
  public var measureScoreRange: Range? = null,
  public var measureScoreDuration: Duration? = null,
) {
  public fun toModel(): MeasureReport.Group.Stratifier.Stratum.MeasureScore =
    MeasureReport.Group.Stratifier.Stratum.MeasureScore.from(
      this@MeasureReportGroupStratifierStratumMeasureScoreSurrogate.measureScoreQuantity,
      DateTime.of(
        FhirDateTime.fromString(
          this@MeasureReportGroupStratifierStratumMeasureScoreSurrogate.measureScoreDateTime
        ),
        this@MeasureReportGroupStratifierStratumMeasureScoreSurrogate._measureScoreDateTime,
      ),
      this@MeasureReportGroupStratifierStratumMeasureScoreSurrogate.measureScoreCodeableConcept,
      this@MeasureReportGroupStratifierStratumMeasureScoreSurrogate.measureScorePeriod,
      this@MeasureReportGroupStratifierStratumMeasureScoreSurrogate.measureScoreRange,
      this@MeasureReportGroupStratifierStratumMeasureScoreSurrogate.measureScoreDuration,
    )!!

  public companion object {
    public fun fromModel(
      model: MeasureReport.Group.Stratifier.Stratum.MeasureScore
    ): MeasureReportGroupStratifierStratumMeasureScoreSurrogate =
      with(model) {
        MeasureReportGroupStratifierStratumMeasureScoreSurrogate(
          measureScoreQuantity = this@with.asQuantity()?.value,
          measureScoreDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _measureScoreDateTime = this@with.asDateTime()?.value?.toElement(),
          measureScoreCodeableConcept = this@with.asCodeableConcept()?.value,
          measureScorePeriod = this@with.asPeriod()?.value,
          measureScoreRange = this@with.asRange()?.value,
          measureScoreDuration = this@with.asDuration()?.value,
        )
      }
  }
}

@Serializable
internal data class MeasureReportSurrogate(
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
  public var identifier: List<Identifier>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var dataUpdateType: KotlinString? = null,
  public var _dataUpdateType: Element? = null,
  public var measure: KotlinString? = null,
  public var _measure: Element? = null,
  public var subject: Reference? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var reporter: Reference? = null,
  public var reportingVendor: Reference? = null,
  public var location: Reference? = null,
  public var period: Period,
  public var inputParameters: Reference? = null,
  public var scoring: CodeableConcept? = null,
  public var improvementNotation: CodeableConcept? = null,
  public var group: List<MeasureReport.Group>? = null,
  public var supplementalData: List<Reference>? = null,
  public var evaluatedResource: List<Reference>? = null,
) {
  public fun toModel(): MeasureReport =
    MeasureReport(
      id = this@MeasureReportSurrogate.id,
      meta = this@MeasureReportSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MeasureReportSurrogate.implicitRules,
          this@MeasureReportSurrogate._implicitRules,
        ),
      language =
        Code.of(this@MeasureReportSurrogate.language, this@MeasureReportSurrogate._language),
      text = this@MeasureReportSurrogate.text,
      contained = this@MeasureReportSurrogate.contained ?: listOf(),
      extension = this@MeasureReportSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureReportSurrogate.modifierExtension ?: listOf(),
      identifier = this@MeasureReportSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          MeasureReport.MeasureReportStatus.fromCode(this@MeasureReportSurrogate.status!!),
          this@MeasureReportSurrogate._status,
        ),
      type =
        Enumeration.of(
          MeasureReport.MeasureReportType.fromCode(this@MeasureReportSurrogate.type!!),
          this@MeasureReportSurrogate._type,
        ),
      dataUpdateType =
        this@MeasureReportSurrogate.dataUpdateType?.let {
          Enumeration.of(
            MeasureReport.SubmitDataUpdateType.fromCode(it),
            this@MeasureReportSurrogate._dataUpdateType,
          )
        },
      measure =
        Canonical.of(this@MeasureReportSurrogate.measure, this@MeasureReportSurrogate._measure),
      subject = this@MeasureReportSurrogate.subject,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@MeasureReportSurrogate.date),
          this@MeasureReportSurrogate._date,
        ),
      reporter = this@MeasureReportSurrogate.reporter,
      reportingVendor = this@MeasureReportSurrogate.reportingVendor,
      location = this@MeasureReportSurrogate.location,
      period = this@MeasureReportSurrogate.period,
      inputParameters = this@MeasureReportSurrogate.inputParameters,
      scoring = this@MeasureReportSurrogate.scoring,
      improvementNotation = this@MeasureReportSurrogate.improvementNotation,
      group = this@MeasureReportSurrogate.group ?: listOf(),
      supplementalData = this@MeasureReportSurrogate.supplementalData ?: listOf(),
      evaluatedResource = this@MeasureReportSurrogate.evaluatedResource ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MeasureReport): MeasureReportSurrogate =
      with(model) {
        MeasureReportSurrogate(
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
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          dataUpdateType = this@with.dataUpdateType?.value?.getCode(),
          _dataUpdateType = this@with.dataUpdateType?.toElement(),
          measure = this@with.measure?.value,
          _measure = this@with.measure?.toElement(),
          subject = this@with.subject,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          reporter = this@with.reporter,
          reportingVendor = this@with.reportingVendor,
          location = this@with.location,
          period = this@with.period,
          inputParameters = this@with.inputParameters,
          scoring = this@with.scoring,
          improvementNotation = this@with.improvementNotation,
          group = this@with.group.takeIf { it.isNotEmpty() },
          supplementalData = this@with.supplementalData.takeIf { it.isNotEmpty() },
          evaluatedResource = this@with.evaluatedResource.takeIf { it.isNotEmpty() },
        )
      }
  }
}

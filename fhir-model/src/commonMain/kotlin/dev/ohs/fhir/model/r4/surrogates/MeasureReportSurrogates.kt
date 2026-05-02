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

import com.google.fhir.model.r4.Canonical
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Integer
import com.google.fhir.model.r4.MeasureReport
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MeasureReportGroupSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var population: List<MeasureReport.Group.Population>? = null,
  public var measureScore: Quantity? = null,
  public var stratifier: List<MeasureReport.Group.Stratifier>? = null,
) {
  public fun toModel(): MeasureReport.Group =
    MeasureReport.Group(
      id = this@MeasureReportGroupSurrogate.id,
      extension = this@MeasureReportGroupSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureReportGroupSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureReportGroupSurrogate.code,
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
          code = this@with.code,
          population = this@with.population.takeIf { it.isNotEmpty() },
          measureScore = this@with.measureScore,
          stratifier = this@with.stratifier.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupPopulationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var count: Int? = null,
  public var _count: Element? = null,
  public var subjectResults: Reference? = null,
) {
  public fun toModel(): MeasureReport.Group.Population =
    MeasureReport.Group.Population(
      id = this@MeasureReportGroupPopulationSurrogate.id,
      extension = this@MeasureReportGroupPopulationSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureReportGroupPopulationSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureReportGroupPopulationSurrogate.code,
      count =
        Integer.of(
          this@MeasureReportGroupPopulationSurrogate.count,
          this@MeasureReportGroupPopulationSurrogate._count,
        ),
      subjectResults = this@MeasureReportGroupPopulationSurrogate.subjectResults,
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
          code = this@with.code,
          count = this@with.count?.value,
          _count = this@with.count?.toElement(),
          subjectResults = this@with.subjectResults,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: List<CodeableConcept>? = null,
  public var stratum: List<MeasureReport.Group.Stratifier.Stratum>? = null,
) {
  public fun toModel(): MeasureReport.Group.Stratifier =
    MeasureReport.Group.Stratifier(
      id = this@MeasureReportGroupStratifierSurrogate.id,
      extension = this@MeasureReportGroupStratifierSurrogate.extension ?: listOf(),
      modifierExtension = this@MeasureReportGroupStratifierSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureReportGroupStratifierSurrogate.code ?: listOf(),
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
          code = this@with.code.takeIf { it.isNotEmpty() },
          stratum = this@with.stratum.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierStratumSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: CodeableConcept? = null,
  public var component: List<MeasureReport.Group.Stratifier.Stratum.Component>? = null,
  public var population: List<MeasureReport.Group.Stratifier.Stratum.Population>? = null,
  public var measureScore: Quantity? = null,
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
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var `value`: CodeableConcept,
) {
  public fun toModel(): MeasureReport.Group.Stratifier.Stratum.Component =
    MeasureReport.Group.Stratifier.Stratum.Component(
      id = this@MeasureReportGroupStratifierStratumComponentSurrogate.id,
      extension = this@MeasureReportGroupStratifierStratumComponentSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MeasureReportGroupStratifierStratumComponentSurrogate.modifierExtension ?: listOf(),
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
          code = this@with.code,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class MeasureReportGroupStratifierStratumPopulationSurrogate(
  public var id: String? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept? = null,
  public var count: Int? = null,
  public var _count: Element? = null,
  public var subjectResults: Reference? = null,
) {
  public fun toModel(): MeasureReport.Group.Stratifier.Stratum.Population =
    MeasureReport.Group.Stratifier.Stratum.Population(
      id = this@MeasureReportGroupStratifierStratumPopulationSurrogate.id,
      extension = this@MeasureReportGroupStratifierStratumPopulationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MeasureReportGroupStratifierStratumPopulationSurrogate.modifierExtension ?: listOf(),
      code = this@MeasureReportGroupStratifierStratumPopulationSurrogate.code,
      count =
        Integer.of(
          this@MeasureReportGroupStratifierStratumPopulationSurrogate.count,
          this@MeasureReportGroupStratifierStratumPopulationSurrogate._count,
        ),
      subjectResults = this@MeasureReportGroupStratifierStratumPopulationSurrogate.subjectResults,
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
          code = this@with.code,
          count = this@with.count?.value,
          _count = this@with.count?.toElement(),
          subjectResults = this@with.subjectResults,
        )
      }
  }
}

@Serializable
internal data class MeasureReportSurrogate(
  public var id: String? = null,
  public var meta: Meta? = null,
  public var implicitRules: String? = null,
  public var _implicitRules: Element? = null,
  public var language: String? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var status: String? = null,
  public var _status: Element? = null,
  public var type: String? = null,
  public var _type: Element? = null,
  public var measure: String? = null,
  public var _measure: Element? = null,
  public var subject: Reference? = null,
  public var date: String? = null,
  public var _date: Element? = null,
  public var reporter: Reference? = null,
  public var period: Period,
  public var improvementNotation: CodeableConcept? = null,
  public var group: List<MeasureReport.Group>? = null,
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
      measure =
        Canonical.of(this@MeasureReportSurrogate.measure, this@MeasureReportSurrogate._measure)!!,
      subject = this@MeasureReportSurrogate.subject,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@MeasureReportSurrogate.date),
          this@MeasureReportSurrogate._date,
        ),
      reporter = this@MeasureReportSurrogate.reporter,
      period = this@MeasureReportSurrogate.period,
      improvementNotation = this@MeasureReportSurrogate.improvementNotation,
      group = this@MeasureReportSurrogate.group ?: listOf(),
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
          measure = this@with.measure.value,
          _measure = this@with.measure.toElement(),
          subject = this@with.subject,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          reporter = this@with.reporter,
          period = this@with.period,
          improvementNotation = this@with.improvementNotation,
          group = this@with.group.takeIf { it.isNotEmpty() },
          evaluatedResource = this@with.evaluatedResource.takeIf { it.isNotEmpty() },
        )
      }
  }
}

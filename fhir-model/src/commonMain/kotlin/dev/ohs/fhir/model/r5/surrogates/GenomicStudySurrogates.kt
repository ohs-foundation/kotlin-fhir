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
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.GenomicStudy
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class GenomicStudyAnalysisSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var methodType: List<CodeableConcept>? = null,
  public var changeType: List<CodeableConcept>? = null,
  public var genomeBuild: CodeableConcept? = null,
  public var instantiatesCanonical: KotlinString? = null,
  public var _instantiatesCanonical: Element? = null,
  public var instantiatesUri: KotlinString? = null,
  public var _instantiatesUri: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var focus: List<Reference>? = null,
  public var specimen: List<Reference>? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var note: List<Annotation>? = null,
  public var protocolPerformed: Reference? = null,
  public var regionsStudied: List<Reference>? = null,
  public var regionsCalled: List<Reference>? = null,
  public var input: List<GenomicStudy.Analysis.Input>? = null,
  public var output: List<GenomicStudy.Analysis.Output>? = null,
  public var performer: List<GenomicStudy.Analysis.Performer>? = null,
  public var device: List<GenomicStudy.Analysis.Device>? = null,
) {
  public fun toModel(): GenomicStudy.Analysis =
    GenomicStudy.Analysis(
      id = this@GenomicStudyAnalysisSurrogate.id,
      extension = this@GenomicStudyAnalysisSurrogate.extension ?: listOf(),
      modifierExtension = this@GenomicStudyAnalysisSurrogate.modifierExtension ?: listOf(),
      identifier = this@GenomicStudyAnalysisSurrogate.identifier ?: listOf(),
      methodType = this@GenomicStudyAnalysisSurrogate.methodType ?: listOf(),
      changeType = this@GenomicStudyAnalysisSurrogate.changeType ?: listOf(),
      genomeBuild = this@GenomicStudyAnalysisSurrogate.genomeBuild,
      instantiatesCanonical =
        Canonical.of(
          this@GenomicStudyAnalysisSurrogate.instantiatesCanonical,
          this@GenomicStudyAnalysisSurrogate._instantiatesCanonical,
        ),
      instantiatesUri =
        Uri.of(
          this@GenomicStudyAnalysisSurrogate.instantiatesUri,
          this@GenomicStudyAnalysisSurrogate._instantiatesUri,
        ),
      title =
        R5String.of(
          this@GenomicStudyAnalysisSurrogate.title,
          this@GenomicStudyAnalysisSurrogate._title,
        ),
      focus = this@GenomicStudyAnalysisSurrogate.focus ?: listOf(),
      specimen = this@GenomicStudyAnalysisSurrogate.specimen ?: listOf(),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@GenomicStudyAnalysisSurrogate.date),
          this@GenomicStudyAnalysisSurrogate._date,
        ),
      note = this@GenomicStudyAnalysisSurrogate.note ?: listOf(),
      protocolPerformed = this@GenomicStudyAnalysisSurrogate.protocolPerformed,
      regionsStudied = this@GenomicStudyAnalysisSurrogate.regionsStudied ?: listOf(),
      regionsCalled = this@GenomicStudyAnalysisSurrogate.regionsCalled ?: listOf(),
      input = this@GenomicStudyAnalysisSurrogate.input ?: listOf(),
      output = this@GenomicStudyAnalysisSurrogate.output ?: listOf(),
      performer = this@GenomicStudyAnalysisSurrogate.performer ?: listOf(),
      device = this@GenomicStudyAnalysisSurrogate.device ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: GenomicStudy.Analysis): GenomicStudyAnalysisSurrogate =
      with(model) {
        GenomicStudyAnalysisSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          methodType = this@with.methodType.takeIf { it.isNotEmpty() },
          changeType = this@with.changeType.takeIf { it.isNotEmpty() },
          genomeBuild = this@with.genomeBuild,
          instantiatesCanonical = this@with.instantiatesCanonical?.value,
          _instantiatesCanonical = this@with.instantiatesCanonical?.toElement(),
          instantiatesUri = this@with.instantiatesUri?.value,
          _instantiatesUri = this@with.instantiatesUri?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          focus = this@with.focus.takeIf { it.isNotEmpty() },
          specimen = this@with.specimen.takeIf { it.isNotEmpty() },
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          protocolPerformed = this@with.protocolPerformed,
          regionsStudied = this@with.regionsStudied.takeIf { it.isNotEmpty() },
          regionsCalled = this@with.regionsCalled.takeIf { it.isNotEmpty() },
          input = this@with.input.takeIf { it.isNotEmpty() },
          output = this@with.output.takeIf { it.isNotEmpty() },
          performer = this@with.performer.takeIf { it.isNotEmpty() },
          device = this@with.device.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class GenomicStudyAnalysisInputSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `file`: Reference? = null,
  public var type: CodeableConcept? = null,
  public var generatedBy: GenomicStudy.Analysis.Input.GeneratedBy? = null,
) {
  public fun toModel(): GenomicStudy.Analysis.Input =
    GenomicStudy.Analysis.Input(
      id = this@GenomicStudyAnalysisInputSurrogate.id,
      extension = this@GenomicStudyAnalysisInputSurrogate.extension ?: listOf(),
      modifierExtension = this@GenomicStudyAnalysisInputSurrogate.modifierExtension ?: listOf(),
      `file` = this@GenomicStudyAnalysisInputSurrogate.`file`,
      type = this@GenomicStudyAnalysisInputSurrogate.type,
      generatedBy = this@GenomicStudyAnalysisInputSurrogate.generatedBy,
    )

  public companion object {
    public fun fromModel(model: GenomicStudy.Analysis.Input): GenomicStudyAnalysisInputSurrogate =
      with(model) {
        GenomicStudyAnalysisInputSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `file` = this@with.`file`,
          type = this@with.type,
          generatedBy = this@with.generatedBy,
        )
      }
  }
}

@Serializable
internal data class GenomicStudyAnalysisOutputSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `file`: Reference? = null,
  public var type: CodeableConcept? = null,
) {
  public fun toModel(): GenomicStudy.Analysis.Output =
    GenomicStudy.Analysis.Output(
      id = this@GenomicStudyAnalysisOutputSurrogate.id,
      extension = this@GenomicStudyAnalysisOutputSurrogate.extension ?: listOf(),
      modifierExtension = this@GenomicStudyAnalysisOutputSurrogate.modifierExtension ?: listOf(),
      `file` = this@GenomicStudyAnalysisOutputSurrogate.`file`,
      type = this@GenomicStudyAnalysisOutputSurrogate.type,
    )

  public companion object {
    public fun fromModel(model: GenomicStudy.Analysis.Output): GenomicStudyAnalysisOutputSurrogate =
      with(model) {
        GenomicStudyAnalysisOutputSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `file` = this@with.`file`,
          type = this@with.type,
        )
      }
  }
}

@Serializable
internal data class GenomicStudyAnalysisPerformerSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var actor: Reference? = null,
  public var role: CodeableConcept? = null,
) {
  public fun toModel(): GenomicStudy.Analysis.Performer =
    GenomicStudy.Analysis.Performer(
      id = this@GenomicStudyAnalysisPerformerSurrogate.id,
      extension = this@GenomicStudyAnalysisPerformerSurrogate.extension ?: listOf(),
      modifierExtension = this@GenomicStudyAnalysisPerformerSurrogate.modifierExtension ?: listOf(),
      actor = this@GenomicStudyAnalysisPerformerSurrogate.actor,
      role = this@GenomicStudyAnalysisPerformerSurrogate.role,
    )

  public companion object {
    public fun fromModel(
      model: GenomicStudy.Analysis.Performer
    ): GenomicStudyAnalysisPerformerSurrogate =
      with(model) {
        GenomicStudyAnalysisPerformerSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          actor = this@with.actor,
          role = this@with.role,
        )
      }
  }
}

@Serializable
internal data class GenomicStudyAnalysisDeviceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var device: Reference? = null,
  public var function: CodeableConcept? = null,
) {
  public fun toModel(): GenomicStudy.Analysis.Device =
    GenomicStudy.Analysis.Device(
      id = this@GenomicStudyAnalysisDeviceSurrogate.id,
      extension = this@GenomicStudyAnalysisDeviceSurrogate.extension ?: listOf(),
      modifierExtension = this@GenomicStudyAnalysisDeviceSurrogate.modifierExtension ?: listOf(),
      device = this@GenomicStudyAnalysisDeviceSurrogate.device,
      function = this@GenomicStudyAnalysisDeviceSurrogate.function,
    )

  public companion object {
    public fun fromModel(model: GenomicStudy.Analysis.Device): GenomicStudyAnalysisDeviceSurrogate =
      with(model) {
        GenomicStudyAnalysisDeviceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          device = this@with.device,
          function = this@with.function,
        )
      }
  }
}

@Serializable
internal data class GenomicStudyAnalysisInputGeneratedBySurrogate(
  public var generatedByIdentifier: Identifier? = null,
  public var generatedByReference: Reference? = null,
) {
  public fun toModel(): GenomicStudy.Analysis.Input.GeneratedBy =
    GenomicStudy.Analysis.Input.GeneratedBy.from(
      this@GenomicStudyAnalysisInputGeneratedBySurrogate.generatedByIdentifier,
      this@GenomicStudyAnalysisInputGeneratedBySurrogate.generatedByReference,
    )!!

  public companion object {
    public fun fromModel(
      model: GenomicStudy.Analysis.Input.GeneratedBy
    ): GenomicStudyAnalysisInputGeneratedBySurrogate =
      with(model) {
        GenomicStudyAnalysisInputGeneratedBySurrogate(
          generatedByIdentifier = this@with.asIdentifier()?.value,
          generatedByReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class GenomicStudySurrogate(
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
  public var type: List<CodeableConcept>? = null,
  public var subject: Reference,
  public var encounter: Reference? = null,
  public var startDate: KotlinString? = null,
  public var _startDate: Element? = null,
  public var basedOn: List<Reference>? = null,
  public var referrer: Reference? = null,
  public var interpreter: List<Reference>? = null,
  public var reason: List<CodeableReference>? = null,
  public var instantiatesCanonical: KotlinString? = null,
  public var _instantiatesCanonical: Element? = null,
  public var instantiatesUri: KotlinString? = null,
  public var _instantiatesUri: Element? = null,
  public var note: List<Annotation>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var analysis: List<GenomicStudy.Analysis>? = null,
) {
  public fun toModel(): GenomicStudy =
    GenomicStudy(
      id = this@GenomicStudySurrogate.id,
      meta = this@GenomicStudySurrogate.meta,
      implicitRules =
        Uri.of(this@GenomicStudySurrogate.implicitRules, this@GenomicStudySurrogate._implicitRules),
      language = Code.of(this@GenomicStudySurrogate.language, this@GenomicStudySurrogate._language),
      text = this@GenomicStudySurrogate.text,
      contained = this@GenomicStudySurrogate.contained ?: listOf(),
      extension = this@GenomicStudySurrogate.extension ?: listOf(),
      modifierExtension = this@GenomicStudySurrogate.modifierExtension ?: listOf(),
      identifier = this@GenomicStudySurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          GenomicStudy.GenomicStudyStatus.fromCode(this@GenomicStudySurrogate.status!!),
          this@GenomicStudySurrogate._status,
        ),
      type = this@GenomicStudySurrogate.type ?: listOf(),
      subject = this@GenomicStudySurrogate.subject,
      encounter = this@GenomicStudySurrogate.encounter,
      startDate =
        DateTime.of(
          FhirDateTime.fromString(this@GenomicStudySurrogate.startDate),
          this@GenomicStudySurrogate._startDate,
        ),
      basedOn = this@GenomicStudySurrogate.basedOn ?: listOf(),
      referrer = this@GenomicStudySurrogate.referrer,
      interpreter = this@GenomicStudySurrogate.interpreter ?: listOf(),
      reason = this@GenomicStudySurrogate.reason ?: listOf(),
      instantiatesCanonical =
        Canonical.of(
          this@GenomicStudySurrogate.instantiatesCanonical,
          this@GenomicStudySurrogate._instantiatesCanonical,
        ),
      instantiatesUri =
        Uri.of(
          this@GenomicStudySurrogate.instantiatesUri,
          this@GenomicStudySurrogate._instantiatesUri,
        ),
      note = this@GenomicStudySurrogate.note ?: listOf(),
      description =
        Markdown.of(
          this@GenomicStudySurrogate.description,
          this@GenomicStudySurrogate._description,
        ),
      analysis = this@GenomicStudySurrogate.analysis ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: GenomicStudy): GenomicStudySurrogate =
      with(model) {
        GenomicStudySurrogate(
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
          type = this@with.type.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          encounter = this@with.encounter,
          startDate = this@with.startDate?.value?.toString(),
          _startDate = this@with.startDate?.toElement(),
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          referrer = this@with.referrer,
          interpreter = this@with.interpreter.takeIf { it.isNotEmpty() },
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          instantiatesCanonical = this@with.instantiatesCanonical?.value,
          _instantiatesCanonical = this@with.instantiatesCanonical?.toElement(),
          instantiatesUri = this@with.instantiatesUri?.value,
          _instantiatesUri = this@with.instantiatesUri?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          analysis = this@with.analysis.takeIf { it.isNotEmpty() },
        )
      }
  }
}

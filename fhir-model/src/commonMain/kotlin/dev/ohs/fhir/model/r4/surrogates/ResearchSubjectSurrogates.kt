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

import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.ResearchSubject
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ResearchSubjectSurrogate(
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
  public var period: Period? = null,
  public var study: Reference,
  public var individual: Reference,
  public var assignedArm: KotlinString? = null,
  public var _assignedArm: Element? = null,
  public var actualArm: KotlinString? = null,
  public var _actualArm: Element? = null,
  public var consent: Reference? = null,
) {
  public fun toModel(): ResearchSubject =
    ResearchSubject(
      id = this@ResearchSubjectSurrogate.id,
      meta = this@ResearchSubjectSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ResearchSubjectSurrogate.implicitRules,
          this@ResearchSubjectSurrogate._implicitRules,
        ),
      language =
        Code.of(this@ResearchSubjectSurrogate.language, this@ResearchSubjectSurrogate._language),
      text = this@ResearchSubjectSurrogate.text,
      contained = this@ResearchSubjectSurrogate.contained ?: listOf(),
      extension = this@ResearchSubjectSurrogate.extension ?: listOf(),
      modifierExtension = this@ResearchSubjectSurrogate.modifierExtension ?: listOf(),
      identifier = this@ResearchSubjectSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          ResearchSubject.ResearchSubjectStatus.fromCode(this@ResearchSubjectSurrogate.status!!),
          this@ResearchSubjectSurrogate._status,
        ),
      period = this@ResearchSubjectSurrogate.period,
      study = this@ResearchSubjectSurrogate.study,
      individual = this@ResearchSubjectSurrogate.individual,
      assignedArm =
        R4String.of(
          this@ResearchSubjectSurrogate.assignedArm,
          this@ResearchSubjectSurrogate._assignedArm,
        ),
      actualArm =
        R4String.of(
          this@ResearchSubjectSurrogate.actualArm,
          this@ResearchSubjectSurrogate._actualArm,
        ),
      consent = this@ResearchSubjectSurrogate.consent,
    )

  public companion object {
    public fun fromModel(model: ResearchSubject): ResearchSubjectSurrogate =
      with(model) {
        ResearchSubjectSurrogate(
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
          period = this@with.period,
          study = this@with.study,
          individual = this@with.individual,
          assignedArm = this@with.assignedArm?.value,
          _assignedArm = this@with.assignedArm?.toElement(),
          actualArm = this@with.actualArm?.value,
          _actualArm = this@with.actualArm?.toElement(),
          consent = this@with.consent,
        )
      }
  }
}

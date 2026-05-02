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

import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.OperationOutcome
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class OperationOutcomeIssueSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var severity: KotlinString? = null,
  public var _severity: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var details: CodeableConcept? = null,
  public var diagnostics: KotlinString? = null,
  public var _diagnostics: Element? = null,
  public var location: List<KotlinString?>? = null,
  public var _location: List<Element?>? = null,
  public var expression: List<KotlinString?>? = null,
  public var _expression: List<Element?>? = null,
) {
  public fun toModel(): OperationOutcome.Issue =
    OperationOutcome.Issue(
      id = this@OperationOutcomeIssueSurrogate.id,
      extension = this@OperationOutcomeIssueSurrogate.extension ?: listOf(),
      modifierExtension = this@OperationOutcomeIssueSurrogate.modifierExtension ?: listOf(),
      severity =
        Enumeration.of(
          OperationOutcome.IssueSeverity.fromCode(this@OperationOutcomeIssueSurrogate.severity!!),
          this@OperationOutcomeIssueSurrogate._severity,
        ),
      code =
        Enumeration.of(
          OperationOutcome.IssueType.fromCode(this@OperationOutcomeIssueSurrogate.code!!),
          this@OperationOutcomeIssueSurrogate._code,
        ),
      details = this@OperationOutcomeIssueSurrogate.details,
      diagnostics =
        R4bString.of(
          this@OperationOutcomeIssueSurrogate.diagnostics,
          this@OperationOutcomeIssueSurrogate._diagnostics,
        ),
      location =
        if (
          this@OperationOutcomeIssueSurrogate.location == null &&
            this@OperationOutcomeIssueSurrogate._location == null
        ) {
          listOf()
        } else {
          (this@OperationOutcomeIssueSurrogate.location
              ?: List(this@OperationOutcomeIssueSurrogate._location!!.size) { null })
            .zip(
              this@OperationOutcomeIssueSurrogate._location
                ?: List(this@OperationOutcomeIssueSurrogate.location!!.size) { null }
            )
            .map { (value, element) -> R4bString.of(value, element)!! }
            .toList()
        },
      expression =
        if (
          this@OperationOutcomeIssueSurrogate.expression == null &&
            this@OperationOutcomeIssueSurrogate._expression == null
        ) {
          listOf()
        } else {
          (this@OperationOutcomeIssueSurrogate.expression
              ?: List(this@OperationOutcomeIssueSurrogate._expression!!.size) { null })
            .zip(
              this@OperationOutcomeIssueSurrogate._expression
                ?: List(this@OperationOutcomeIssueSurrogate.expression!!.size) { null }
            )
            .map { (value, element) -> R4bString.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(model: OperationOutcome.Issue): OperationOutcomeIssueSurrogate =
      with(model) {
        OperationOutcomeIssueSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          severity = this@with.severity.value?.getCode(),
          _severity = this@with.severity.toElement(),
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          details = this@with.details,
          diagnostics = this@with.diagnostics?.value,
          _diagnostics = this@with.diagnostics?.toElement(),
          location =
            this@with.location.map { it.value }.toList().takeUnless { it.all { it == null } },
          _location =
            this@with.location
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          expression =
            this@with.expression.map { it.value }.toList().takeUnless { it.all { it == null } },
          _expression =
            this@with.expression
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class OperationOutcomeSurrogate(
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
  public var issue: List<OperationOutcome.Issue>? = null,
) {
  public fun toModel(): OperationOutcome =
    OperationOutcome(
      id = this@OperationOutcomeSurrogate.id,
      meta = this@OperationOutcomeSurrogate.meta,
      implicitRules =
        Uri.of(
          this@OperationOutcomeSurrogate.implicitRules,
          this@OperationOutcomeSurrogate._implicitRules,
        ),
      language =
        Code.of(this@OperationOutcomeSurrogate.language, this@OperationOutcomeSurrogate._language),
      text = this@OperationOutcomeSurrogate.text,
      contained = this@OperationOutcomeSurrogate.contained ?: listOf(),
      extension = this@OperationOutcomeSurrogate.extension ?: listOf(),
      modifierExtension = this@OperationOutcomeSurrogate.modifierExtension ?: listOf(),
      issue = this@OperationOutcomeSurrogate.issue ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: OperationOutcome): OperationOutcomeSurrogate =
      with(model) {
        OperationOutcomeSurrogate(
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
          issue = this@with.issue.takeIf { it.isNotEmpty() },
        )
      }
  }
}

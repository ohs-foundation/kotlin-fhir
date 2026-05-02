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

import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.EnrollmentResponse
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
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
internal data class EnrollmentResponseSurrogate(
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
  public var request: Reference? = null,
  public var outcome: KotlinString? = null,
  public var _outcome: Element? = null,
  public var disposition: KotlinString? = null,
  public var _disposition: Element? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var organization: Reference? = null,
  public var requestProvider: Reference? = null,
) {
  public fun toModel(): EnrollmentResponse =
    EnrollmentResponse(
      id = this@EnrollmentResponseSurrogate.id,
      meta = this@EnrollmentResponseSurrogate.meta,
      implicitRules =
        Uri.of(
          this@EnrollmentResponseSurrogate.implicitRules,
          this@EnrollmentResponseSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@EnrollmentResponseSurrogate.language,
          this@EnrollmentResponseSurrogate._language,
        ),
      text = this@EnrollmentResponseSurrogate.text,
      contained = this@EnrollmentResponseSurrogate.contained ?: listOf(),
      extension = this@EnrollmentResponseSurrogate.extension ?: listOf(),
      modifierExtension = this@EnrollmentResponseSurrogate.modifierExtension ?: listOf(),
      identifier = this@EnrollmentResponseSurrogate.identifier ?: listOf(),
      status =
        this@EnrollmentResponseSurrogate.status?.let {
          Enumeration.of(
            EnrollmentResponse.FinancialResourceStatusCodes.fromCode(it),
            this@EnrollmentResponseSurrogate._status,
          )
        },
      request = this@EnrollmentResponseSurrogate.request,
      outcome =
        this@EnrollmentResponseSurrogate.outcome?.let {
          Enumeration.of(
            EnrollmentResponse.EnrollmentOutcome.fromCode(it),
            this@EnrollmentResponseSurrogate._outcome,
          )
        },
      disposition =
        R5String.of(
          this@EnrollmentResponseSurrogate.disposition,
          this@EnrollmentResponseSurrogate._disposition,
        ),
      created =
        DateTime.of(
          FhirDateTime.fromString(this@EnrollmentResponseSurrogate.created),
          this@EnrollmentResponseSurrogate._created,
        ),
      organization = this@EnrollmentResponseSurrogate.organization,
      requestProvider = this@EnrollmentResponseSurrogate.requestProvider,
    )

  public companion object {
    public fun fromModel(model: EnrollmentResponse): EnrollmentResponseSurrogate =
      with(model) {
        EnrollmentResponseSurrogate(
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
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          request = this@with.request,
          outcome = this@with.outcome?.value?.getCode(),
          _outcome = this@with.outcome?.toElement(),
          disposition = this@with.disposition?.value,
          _disposition = this@with.disposition?.toElement(),
          created = this@with.created?.value?.toString(),
          _created = this@with.created?.toElement(),
          organization = this@with.organization,
          requestProvider = this@with.requestProvider,
        )
      }
  }
}

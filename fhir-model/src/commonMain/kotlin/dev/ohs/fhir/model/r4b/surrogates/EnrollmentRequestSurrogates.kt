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
import com.google.fhir.model.r5.EnrollmentRequest
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class EnrollmentRequestSurrogate(
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
  public var created: String? = null,
  public var _created: Element? = null,
  public var insurer: Reference? = null,
  public var provider: Reference? = null,
  public var candidate: Reference? = null,
  public var coverage: Reference? = null,
) {
  public fun toModel(): EnrollmentRequest =
    EnrollmentRequest(
      id = this@EnrollmentRequestSurrogate.id,
      meta = this@EnrollmentRequestSurrogate.meta,
      implicitRules =
        Uri.of(
          this@EnrollmentRequestSurrogate.implicitRules,
          this@EnrollmentRequestSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@EnrollmentRequestSurrogate.language,
          this@EnrollmentRequestSurrogate._language,
        ),
      text = this@EnrollmentRequestSurrogate.text,
      contained = this@EnrollmentRequestSurrogate.contained ?: listOf(),
      extension = this@EnrollmentRequestSurrogate.extension ?: listOf(),
      modifierExtension = this@EnrollmentRequestSurrogate.modifierExtension ?: listOf(),
      identifier = this@EnrollmentRequestSurrogate.identifier ?: listOf(),
      status =
        this@EnrollmentRequestSurrogate.status?.let {
          Enumeration.of(
            EnrollmentRequest.FinancialResourceStatusCodes.fromCode(it),
            this@EnrollmentRequestSurrogate._status,
          )
        },
      created =
        DateTime.of(
          FhirDateTime.fromString(this@EnrollmentRequestSurrogate.created),
          this@EnrollmentRequestSurrogate._created,
        ),
      insurer = this@EnrollmentRequestSurrogate.insurer,
      provider = this@EnrollmentRequestSurrogate.provider,
      candidate = this@EnrollmentRequestSurrogate.candidate,
      coverage = this@EnrollmentRequestSurrogate.coverage,
    )

  public companion object {
    public fun fromModel(model: EnrollmentRequest): EnrollmentRequestSurrogate =
      with(model) {
        EnrollmentRequestSurrogate(
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
          created = this@with.created?.value?.toString(),
          _created = this@with.created?.toElement(),
          insurer = this@with.insurer,
          provider = this@with.provider,
          candidate = this@with.candidate,
          coverage = this@with.coverage,
        )
      }
  }
}

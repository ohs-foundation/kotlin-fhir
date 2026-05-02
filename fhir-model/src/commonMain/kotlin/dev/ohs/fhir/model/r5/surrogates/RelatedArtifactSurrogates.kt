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

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.RelatedArtifact
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class RelatedArtifactSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
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
  public var publicationStatus: KotlinString? = null,
  public var _publicationStatus: Element? = null,
  public var publicationDate: KotlinString? = null,
  public var _publicationDate: Element? = null,
) {
  public fun toModel(): RelatedArtifact =
    RelatedArtifact(
      id = this@RelatedArtifactSurrogate.id,
      extension = this@RelatedArtifactSurrogate.extension ?: listOf(),
      type =
        Enumeration.of(
          RelatedArtifact.RelatedArtifactType.fromCode(this@RelatedArtifactSurrogate.type!!),
          this@RelatedArtifactSurrogate._type,
        ),
      classifier = this@RelatedArtifactSurrogate.classifier ?: listOf(),
      label =
        R5String.of(this@RelatedArtifactSurrogate.label, this@RelatedArtifactSurrogate._label),
      display =
        R5String.of(this@RelatedArtifactSurrogate.display, this@RelatedArtifactSurrogate._display),
      citation =
        Markdown.of(
          this@RelatedArtifactSurrogate.citation,
          this@RelatedArtifactSurrogate._citation,
        ),
      document = this@RelatedArtifactSurrogate.document,
      resource =
        Canonical.of(
          this@RelatedArtifactSurrogate.resource,
          this@RelatedArtifactSurrogate._resource,
        ),
      resourceReference = this@RelatedArtifactSurrogate.resourceReference,
      publicationStatus =
        this@RelatedArtifactSurrogate.publicationStatus?.let {
          Enumeration.of(
            PublicationStatus.fromCode(it),
            this@RelatedArtifactSurrogate._publicationStatus,
          )
        },
      publicationDate =
        Date.of(
          FhirDate.fromString(this@RelatedArtifactSurrogate.publicationDate),
          this@RelatedArtifactSurrogate._publicationDate,
        ),
    )

  public companion object {
    public fun fromModel(model: RelatedArtifact): RelatedArtifactSurrogate =
      with(model) {
        RelatedArtifactSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
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
          publicationStatus = this@with.publicationStatus?.value?.getCode(),
          _publicationStatus = this@with.publicationStatus?.toElement(),
          publicationDate = this@with.publicationDate?.value?.toString(),
          _publicationDate = this@with.publicationDate?.toElement(),
        )
      }
  }
}

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
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.DocumentManifest
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.DocumentReferenceStatus
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class DocumentManifestRelatedSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var ref: Reference? = null,
) {
  public fun toModel(): DocumentManifest.Related =
    DocumentManifest.Related(
      id = this@DocumentManifestRelatedSurrogate.id,
      extension = this@DocumentManifestRelatedSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentManifestRelatedSurrogate.modifierExtension ?: listOf(),
      identifier = this@DocumentManifestRelatedSurrogate.identifier,
      ref = this@DocumentManifestRelatedSurrogate.ref,
    )

  public companion object {
    public fun fromModel(model: DocumentManifest.Related): DocumentManifestRelatedSurrogate =
      with(model) {
        DocumentManifestRelatedSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier,
          ref = this@with.ref,
        )
      }
  }
}

@Serializable
internal data class DocumentManifestSurrogate(
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
  public var masterIdentifier: Identifier? = null,
  public var identifier: List<Identifier>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var type: CodeableConcept? = null,
  public var subject: Reference? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var author: List<Reference>? = null,
  public var recipient: List<Reference>? = null,
  public var source: KotlinString? = null,
  public var _source: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var content: List<Reference>? = null,
  public var related: List<DocumentManifest.Related>? = null,
) {
  public fun toModel(): DocumentManifest =
    DocumentManifest(
      id = this@DocumentManifestSurrogate.id,
      meta = this@DocumentManifestSurrogate.meta,
      implicitRules =
        Uri.of(
          this@DocumentManifestSurrogate.implicitRules,
          this@DocumentManifestSurrogate._implicitRules,
        ),
      language =
        Code.of(this@DocumentManifestSurrogate.language, this@DocumentManifestSurrogate._language),
      text = this@DocumentManifestSurrogate.text,
      contained = this@DocumentManifestSurrogate.contained ?: listOf(),
      extension = this@DocumentManifestSurrogate.extension ?: listOf(),
      modifierExtension = this@DocumentManifestSurrogate.modifierExtension ?: listOf(),
      masterIdentifier = this@DocumentManifestSurrogate.masterIdentifier,
      identifier = this@DocumentManifestSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          DocumentReferenceStatus.fromCode(this@DocumentManifestSurrogate.status!!),
          this@DocumentManifestSurrogate._status,
        ),
      type = this@DocumentManifestSurrogate.type,
      subject = this@DocumentManifestSurrogate.subject,
      created =
        DateTime.of(
          FhirDateTime.fromString(this@DocumentManifestSurrogate.created),
          this@DocumentManifestSurrogate._created,
        ),
      author = this@DocumentManifestSurrogate.author ?: listOf(),
      recipient = this@DocumentManifestSurrogate.recipient ?: listOf(),
      source =
        Uri.of(this@DocumentManifestSurrogate.source, this@DocumentManifestSurrogate._source),
      description =
        R4bString.of(
          this@DocumentManifestSurrogate.description,
          this@DocumentManifestSurrogate._description,
        ),
      content = this@DocumentManifestSurrogate.content ?: listOf(),
      related = this@DocumentManifestSurrogate.related ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: DocumentManifest): DocumentManifestSurrogate =
      with(model) {
        DocumentManifestSurrogate(
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
          masterIdentifier = this@with.masterIdentifier,
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          type = this@with.type,
          subject = this@with.subject,
          created = this@with.created?.value?.toString(),
          _created = this@with.created?.toElement(),
          author = this@with.author.takeIf { it.isNotEmpty() },
          recipient = this@with.recipient.takeIf { it.isNotEmpty() },
          source = this@with.source?.value,
          _source = this@with.source?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          content = this@with.content.takeIf { it.isNotEmpty() },
          related = this@with.related.takeIf { it.isNotEmpty() },
        )
      }
  }
}

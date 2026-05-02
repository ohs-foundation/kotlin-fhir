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

import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Coding
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.MessageDefinition
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.UnsignedInt
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import com.google.fhir.model.r4b.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MessageDefinitionFocusSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var profile: KotlinString? = null,
  public var _profile: Element? = null,
  public var min: Int? = null,
  public var _min: Element? = null,
  public var max: KotlinString? = null,
  public var _max: Element? = null,
) {
  public fun toModel(): MessageDefinition.Focus =
    MessageDefinition.Focus(
      id = this@MessageDefinitionFocusSurrogate.id,
      extension = this@MessageDefinitionFocusSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageDefinitionFocusSurrogate.modifierExtension ?: listOf(),
      code =
        Enumeration.of(
          ResourceType.fromCode(this@MessageDefinitionFocusSurrogate.code!!),
          this@MessageDefinitionFocusSurrogate._code,
        ),
      profile =
        Canonical.of(
          this@MessageDefinitionFocusSurrogate.profile,
          this@MessageDefinitionFocusSurrogate._profile,
        ),
      min =
        UnsignedInt.of(
          this@MessageDefinitionFocusSurrogate.min,
          this@MessageDefinitionFocusSurrogate._min,
        )!!,
      max =
        R4bString.of(
          this@MessageDefinitionFocusSurrogate.max,
          this@MessageDefinitionFocusSurrogate._max,
        ),
    )

  public companion object {
    public fun fromModel(model: MessageDefinition.Focus): MessageDefinitionFocusSurrogate =
      with(model) {
        MessageDefinitionFocusSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code.value?.getCode(),
          _code = this@with.code.toElement(),
          profile = this@with.profile?.value,
          _profile = this@with.profile?.toElement(),
          min = this@with.min.value,
          _min = this@with.min.toElement(),
          max = this@with.max?.value,
          _max = this@with.max?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MessageDefinitionAllowedResponseSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var message: KotlinString? = null,
  public var _message: Element? = null,
  public var situation: KotlinString? = null,
  public var _situation: Element? = null,
) {
  public fun toModel(): MessageDefinition.AllowedResponse =
    MessageDefinition.AllowedResponse(
      id = this@MessageDefinitionAllowedResponseSurrogate.id,
      extension = this@MessageDefinitionAllowedResponseSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MessageDefinitionAllowedResponseSurrogate.modifierExtension ?: listOf(),
      message =
        Canonical.of(
          this@MessageDefinitionAllowedResponseSurrogate.message,
          this@MessageDefinitionAllowedResponseSurrogate._message,
        )!!,
      situation =
        Markdown.of(
          this@MessageDefinitionAllowedResponseSurrogate.situation,
          this@MessageDefinitionAllowedResponseSurrogate._situation,
        ),
    )

  public companion object {
    public fun fromModel(
      model: MessageDefinition.AllowedResponse
    ): MessageDefinitionAllowedResponseSurrogate =
      with(model) {
        MessageDefinitionAllowedResponseSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          message = this@with.message.value,
          _message = this@with.message.toElement(),
          situation = this@with.situation?.value,
          _situation = this@with.situation?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MessageDefinitionEventSurrogate(
  public var eventCoding: Coding? = null,
  public var eventUri: KotlinString? = null,
  public var _eventUri: Element? = null,
) {
  public fun toModel(): MessageDefinition.Event =
    MessageDefinition.Event.from(
      this@MessageDefinitionEventSurrogate.eventCoding,
      Uri.of(
        this@MessageDefinitionEventSurrogate.eventUri,
        this@MessageDefinitionEventSurrogate._eventUri,
      ),
    )!!

  public companion object {
    public fun fromModel(model: MessageDefinition.Event): MessageDefinitionEventSurrogate =
      with(model) {
        MessageDefinitionEventSurrogate(
          eventCoding = this@with.asCoding()?.value,
          eventUri = this@with.asUri()?.value?.value,
          _eventUri = this@with.asUri()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MessageDefinitionSurrogate(
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
  public var replaces: List<KotlinString?>? = null,
  public var _replaces: List<Element?>? = null,
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
  public var base: KotlinString? = null,
  public var _base: Element? = null,
  public var parent: List<KotlinString?>? = null,
  public var _parent: List<Element?>? = null,
  public var event: MessageDefinition.Event,
  public var category: KotlinString? = null,
  public var _category: Element? = null,
  public var focus: List<MessageDefinition.Focus>? = null,
  public var responseRequired: KotlinString? = null,
  public var _responseRequired: Element? = null,
  public var allowedResponse: List<MessageDefinition.AllowedResponse>? = null,
  public var graph: List<KotlinString?>? = null,
  public var _graph: List<Element?>? = null,
) {
  public fun toModel(): MessageDefinition =
    MessageDefinition(
      id = this@MessageDefinitionSurrogate.id,
      meta = this@MessageDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MessageDefinitionSurrogate.implicitRules,
          this@MessageDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MessageDefinitionSurrogate.language,
          this@MessageDefinitionSurrogate._language,
        ),
      text = this@MessageDefinitionSurrogate.text,
      contained = this@MessageDefinitionSurrogate.contained ?: listOf(),
      extension = this@MessageDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@MessageDefinitionSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@MessageDefinitionSurrogate.url, this@MessageDefinitionSurrogate._url),
      identifier = this@MessageDefinitionSurrogate.identifier ?: listOf(),
      version =
        R4bString.of(
          this@MessageDefinitionSurrogate.version,
          this@MessageDefinitionSurrogate._version,
        ),
      name =
        R4bString.of(this@MessageDefinitionSurrogate.name, this@MessageDefinitionSurrogate._name),
      title =
        R4bString.of(this@MessageDefinitionSurrogate.title, this@MessageDefinitionSurrogate._title),
      replaces =
        if (
          this@MessageDefinitionSurrogate.replaces == null &&
            this@MessageDefinitionSurrogate._replaces == null
        ) {
          listOf()
        } else {
          (this@MessageDefinitionSurrogate.replaces
              ?: List(this@MessageDefinitionSurrogate._replaces!!.size) { null })
            .zip(
              this@MessageDefinitionSurrogate._replaces
                ?: List(this@MessageDefinitionSurrogate.replaces!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@MessageDefinitionSurrogate.status!!),
          this@MessageDefinitionSurrogate._status,
        ),
      experimental =
        R4bBoolean.of(
          this@MessageDefinitionSurrogate.experimental,
          this@MessageDefinitionSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@MessageDefinitionSurrogate.date),
          this@MessageDefinitionSurrogate._date,
        )!!,
      publisher =
        R4bString.of(
          this@MessageDefinitionSurrogate.publisher,
          this@MessageDefinitionSurrogate._publisher,
        ),
      contact = this@MessageDefinitionSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@MessageDefinitionSurrogate.description,
          this@MessageDefinitionSurrogate._description,
        ),
      useContext = this@MessageDefinitionSurrogate.useContext ?: listOf(),
      jurisdiction = this@MessageDefinitionSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(
          this@MessageDefinitionSurrogate.purpose,
          this@MessageDefinitionSurrogate._purpose,
        ),
      copyright =
        Markdown.of(
          this@MessageDefinitionSurrogate.copyright,
          this@MessageDefinitionSurrogate._copyright,
        ),
      base =
        Canonical.of(this@MessageDefinitionSurrogate.base, this@MessageDefinitionSurrogate._base),
      parent =
        if (
          this@MessageDefinitionSurrogate.parent == null &&
            this@MessageDefinitionSurrogate._parent == null
        ) {
          listOf()
        } else {
          (this@MessageDefinitionSurrogate.parent
              ?: List(this@MessageDefinitionSurrogate._parent!!.size) { null })
            .zip(
              this@MessageDefinitionSurrogate._parent
                ?: List(this@MessageDefinitionSurrogate.parent!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      event = this@MessageDefinitionSurrogate.event,
      category =
        this@MessageDefinitionSurrogate.category?.let {
          Enumeration.of(
            MessageDefinition.MessageSignificanceCategory.fromCode(it),
            this@MessageDefinitionSurrogate._category,
          )
        },
      focus = this@MessageDefinitionSurrogate.focus ?: listOf(),
      responseRequired =
        this@MessageDefinitionSurrogate.responseRequired?.let {
          Enumeration.of(
            MessageDefinition.MessageheaderResponseRequest.fromCode(it),
            this@MessageDefinitionSurrogate._responseRequired,
          )
        },
      allowedResponse = this@MessageDefinitionSurrogate.allowedResponse ?: listOf(),
      graph =
        if (
          this@MessageDefinitionSurrogate.graph == null &&
            this@MessageDefinitionSurrogate._graph == null
        ) {
          listOf()
        } else {
          (this@MessageDefinitionSurrogate.graph
              ?: List(this@MessageDefinitionSurrogate._graph!!.size) { null })
            .zip(
              this@MessageDefinitionSurrogate._graph
                ?: List(this@MessageDefinitionSurrogate.graph!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(model: MessageDefinition): MessageDefinitionSurrogate =
      with(model) {
        MessageDefinitionSurrogate(
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
          replaces =
            this@with.replaces.map { it.value }.toList().takeUnless { it.all { it == null } },
          _replaces =
            this@with.replaces
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          date = this@with.date.value?.toString(),
          _date = this@with.date.toElement(),
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
          base = this@with.base?.value,
          _base = this@with.base?.toElement(),
          parent = this@with.parent.map { it.value }.toList().takeUnless { it.all { it == null } },
          _parent =
            this@with.parent
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          event = this@with.event,
          category = this@with.category?.value?.getCode(),
          _category = this@with.category?.toElement(),
          focus = this@with.focus.takeIf { it.isNotEmpty() },
          responseRequired = this@with.responseRequired?.value?.getCode(),
          _responseRequired = this@with.responseRequired?.toElement(),
          allowedResponse = this@with.allowedResponse.takeIf { it.isNotEmpty() },
          graph = this@with.graph.map { it.value }.toList().takeUnless { it.all { it == null } },
          _graph =
            this@with.graph
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5

import com.google.fhir.model.r5.serializers.MetaSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Meta Type: The metadata about a resource. This is content in the resource that is maintained by
 * the infrastructure. Changes to the content might not always be associated with version changes to
 * the resource.
 */
@Serializable(with = MetaSerializer::class)
public data class Meta(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and managable, there is a strict set of governance
   * applied to the definition and use of extensions. Though any implementer can define an
   * extension, there is a set of requirements that SHALL be met as part of the definition of the
   * extension.
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val extension: List<Extension> = listOf(),
  /**
   * The version specific identifier, as it appears in the version portion of the URL. This value
   * changes when the resource is created, updated, or deleted.
   *
   * The server assigns this value, and ignores what the client specifies, except in the case that
   * the server is imposing version integrity on updates/deletes.
   */
  public val versionId: Id? = null,
  /**
   * When the resource last changed - e.g. when the version changed.
   *
   * This element is generally omitted in instances submitted in a PUT or POST. Instead, it is
   * populated in the response instance and when retrieving information using a GET. The server /
   * resource manager sets this value; what a client provides is irrelevant. This is equivalent to
   * the HTTP Last-Modified and SHOULD have the same value on a [read](http.html#read) interaction.
   */
  public val lastUpdated: Instant? = null,
  /**
   * A uri that identifies the source system of the resource. This provides a minimal amount of
   * [Provenance](provenance.html#) information that can be used to track or differentiate the
   * source of information in the resource. The source may identify another FHIR server, document,
   * message, database, etc.
   *
   * The exact use of the source (and the possible implied Provenance.entity.role and agent.role) is
   * left to implementer discretion. Only one nominated source is allowed; for additional provenance
   * details, a full Provenance resource should be used. The source may correspond to
   * Provenance.entity.what[x] or Provenance.agent.who[x], though it may be a more general or
   * abstract reference.
   *
   * This element can be used to indicate where the current master source of a resource that has a
   * canonical URL if the resource is no longer hosted at the canonical URL.
   */
  public val source: Uri? = null,
  /**
   * A list of profiles (references to [StructureDefinition](structuredefinition.html#) resources)
   * that this resource claims to conform to. The URL is a reference to
   * [StructureDefinition.url](structuredefinition-definitions.html#StructureDefinition.url).
   *
   * It is up to the server and/or other infrastructure of policy to determine whether/how these
   * claims are verified and/or updated over time. The list of profile URLs is a set.
   */
  public val profile: List<Canonical> = listOf(),
  /**
   * Security labels applied to this resource. These tags connect specific resources to the overall
   * security policy and infrastructure.
   *
   * The security labels can be updated without changing the stated version of the resource. The
   * list of security labels is a set. Uniqueness is based the system/code, and version and display
   * are ignored.
   */
  public val security: List<Coding> = listOf(),
  /**
   * Tags applied to this resource. Tags are intended to be used to identify and relate resources to
   * process and workflow, and applications are not required to consider the tags when interpreting
   * the meaning of a resource.
   *
   * The tags can be updated without changing the stated version of the resource. The list of tags
   * is a set. Uniqueness is based the system/code, and version and display are ignored.
   */
  public val tag: List<Coding> = listOf(),
) : DataType() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        versionId = this@with.versionId?.toBuilder()
        lastUpdated = this@with.lastUpdated?.toBuilder()
        source = this@with.source?.toBuilder()
        profile = this@with.profile.map { it.toBuilder() }.toMutableList()
        security = this@with.security.map { it.toBuilder() }.toMutableList()
        tag = this@with.tag.map { it.toBuilder() }.toMutableList()
      }
    }

  public open class Builder() {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: String? = null

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element. To make the use of extensions safe and managable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * The version specific identifier, as it appears in the version portion of the URL. This value
     * changes when the resource is created, updated, or deleted.
     *
     * The server assigns this value, and ignores what the client specifies, except in the case that
     * the server is imposing version integrity on updates/deletes.
     */
    public open var versionId: Id.Builder? = null

    /**
     * When the resource last changed - e.g. when the version changed.
     *
     * This element is generally omitted in instances submitted in a PUT or POST. Instead, it is
     * populated in the response instance and when retrieving information using a GET. The server /
     * resource manager sets this value; what a client provides is irrelevant. This is equivalent to
     * the HTTP Last-Modified and SHOULD have the same value on a [read](http.html#read)
     * interaction.
     */
    public open var lastUpdated: Instant.Builder? = null

    /**
     * A uri that identifies the source system of the resource. This provides a minimal amount of
     * [Provenance](provenance.html#) information that can be used to track or differentiate the
     * source of information in the resource. The source may identify another FHIR server, document,
     * message, database, etc.
     *
     * The exact use of the source (and the possible implied Provenance.entity.role and agent.role)
     * is left to implementer discretion. Only one nominated source is allowed; for additional
     * provenance details, a full Provenance resource should be used. The source may correspond to
     * Provenance.entity.what[x] or Provenance.agent.who[x], though it may be a more general or
     * abstract reference.
     *
     * This element can be used to indicate where the current master source of a resource that has a
     * canonical URL if the resource is no longer hosted at the canonical URL.
     */
    public open var source: Uri.Builder? = null

    /**
     * A list of profiles (references to [StructureDefinition](structuredefinition.html#) resources)
     * that this resource claims to conform to. The URL is a reference to
     * [StructureDefinition.url](structuredefinition-definitions.html#StructureDefinition.url).
     *
     * It is up to the server and/or other infrastructure of policy to determine whether/how these
     * claims are verified and/or updated over time. The list of profile URLs is a set.
     */
    public open var profile: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * Security labels applied to this resource. These tags connect specific resources to the
     * overall security policy and infrastructure.
     *
     * The security labels can be updated without changing the stated version of the resource. The
     * list of security labels is a set. Uniqueness is based the system/code, and version and
     * display are ignored.
     */
    public open var security: MutableList<Coding.Builder> = mutableListOf()

    /**
     * Tags applied to this resource. Tags are intended to be used to identify and relate resources
     * to process and workflow, and applications are not required to consider the tags when
     * interpreting the meaning of a resource.
     *
     * The tags can be updated without changing the stated version of the resource. The list of tags
     * is a set. Uniqueness is based the system/code, and version and display are ignored.
     */
    public open var tag: MutableList<Coding.Builder> = mutableListOf()

    public open fun build(): Meta =
      Meta(
        id = id,
        extension = extension.map { it.build() },
        versionId = versionId?.build(),
        lastUpdated = lastUpdated?.build(),
        source = source?.build(),
        profile = profile.map { it.build() },
        security = security.map { it.build() },
        tag = tag.map { it.build() },
      )
  }
}

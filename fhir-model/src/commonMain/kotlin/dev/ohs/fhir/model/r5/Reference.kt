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

import com.google.fhir.model.r5.serializers.ReferenceSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/** Reference Type: A reference from one resource to another. */
@Serializable(with = ReferenceSerializer::class)
public data class Reference(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
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
   * A reference to a location at which the other resource is found. The reference may be a relative
   * reference, in which case it is relative to the service base URL, or an absolute URL that
   * resolves to the location where the resource is found. The reference may be version specific or
   * not. If the reference is not to a FHIR RESTful server, then it should be assumed to be version
   * specific. Internal fragment references (start with '#') refer to contained resources.
   *
   * Using absolute URLs provides a stable scalable approach suitable for a cloud/web context, while
   * using relative/logical references provides a flexible approach suitable for use when trading
   * across closed eco-system boundaries. Absolute URLs do not need to point to a FHIR RESTful
   * server, though this is the preferred approach. If the URL conforms to the structure
   * "[type]/[id]" then it should be assumed that the reference is to a FHIR RESTful server.
   */
  public val reference: String? = null,
  /**
   * The expected type of the target of the reference. If both Reference.type and
   * Reference.reference are populated and Reference.reference is a FHIR URL, both SHALL be
   * consistent.
   *
   * The type is the Canonical URL of Resource Definition that is the type this reference refers to.
   * References are URLs that are relative to http://hl7.org/fhir/StructureDefinition/ e.g.
   * "Patient" is a reference to http://hl7.org/fhir/StructureDefinition/Patient. Absolute URLs are
   * only allowed for logical models (and can only be used in references in logical models, not
   * resources).
   *
   * This element is used to indicate the type of the target of the reference. This may be used
   * which ever of the other elements are populated (or not). In some cases, the type of the target
   * may be determined by inspection of the reference (e.g. a known RESTful URL) or by resolving the
   * target of the reference.
   */
  public val type: Uri? = null,
  /**
   * An identifier for the target resource. This is used when there is no way to reference the other
   * resource directly, either because the entity it represents is not available through a FHIR
   * server, or because there is no way for the author of the resource to convert a known identifier
   * to an actual location. There is no requirement that a Reference.identifier point to something
   * that is actually exposed as a FHIR instance, but it SHALL point to a business concept that
   * would be expected to be exposed as a FHIR instance, and that instance would need to be of a
   * FHIR resource type allowed by the reference.
   *
   * When an identifier is provided in place of a reference, any system processing the reference
   * will only be able to resolve the identifier to a reference if it understands the business
   * context in which the identifier is used. Sometimes this is global (e.g. a national identifier)
   * but often it is not. For this reason, none of the useful mechanisms described for working with
   * references (e.g. chaining, includes) are possible, nor should servers be expected to be able
   * resolve the reference. Servers may accept an identifier based reference untouched, resolve it,
   * and/or reject it - see CapabilityStatement.rest.resource.referencePolicy.
   *
   * When both an identifier and a literal reference are provided, the literal reference is
   * preferred. Applications processing the resource are allowed - but not required - to check that
   * the identifier matches the literal reference
   *
   * Applications converting a logical reference to a literal reference may choose to leave the
   * logical reference present, or remove it.
   *
   * Reference is intended to point to a structure that can potentially be expressed as a FHIR
   * resource, though there is no need for it to exist as an actual FHIR resource instance - except
   * in as much as an application wishes to actual find the target of the reference. The content
   * referred to be the identifier must meet the logical constraints implied by any limitations on
   * what resource types are permitted for the reference. For example, it would not be legitimate to
   * send the identifier for a drug prescription if the type were
   * Reference(Observation|DiagnosticReport). One of the use-cases for Reference.identifier is the
   * situation where no FHIR representation exists (where the type is Reference (Any).
   *
   * This element only allows for a single identifier. In the case where additional identifers are
   * required, use the
   * [http://hl7.org/fhir/StructureDefinition/additionalIdentifier](http://hl7.org/fhir/extensions/StructureDefinition-additionalIdentifier.html)
   * extension.
   */
  public val identifier: Identifier? = null,
  /**
   * Plain text narrative that identifies the resource in addition to the resource reference.
   *
   * This is generally not the same as the Resource.text of the referenced resource. The purpose is
   * to identify what's being referenced, not to fully describe it.
   */
  public val display: String? = null,
) : DataType() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        reference = this@with.reference?.toBuilder()
        type = this@with.type?.toBuilder()
        identifier = this@with.identifier?.toBuilder()
        display = this@with.display?.toBuilder()
      }
    }

  public open class Builder() {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: kotlin.String? = null

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
     * A reference to a location at which the other resource is found. The reference may be a
     * relative reference, in which case it is relative to the service base URL, or an absolute URL
     * that resolves to the location where the resource is found. The reference may be version
     * specific or not. If the reference is not to a FHIR RESTful server, then it should be assumed
     * to be version specific. Internal fragment references (start with '#') refer to contained
     * resources.
     *
     * Using absolute URLs provides a stable scalable approach suitable for a cloud/web context,
     * while using relative/logical references provides a flexible approach suitable for use when
     * trading across closed eco-system boundaries. Absolute URLs do not need to point to a FHIR
     * RESTful server, though this is the preferred approach. If the URL conforms to the structure
     * "[type]/[id]" then it should be assumed that the reference is to a FHIR RESTful server.
     */
    public open var reference: String.Builder? = null

    /**
     * The expected type of the target of the reference. If both Reference.type and
     * Reference.reference are populated and Reference.reference is a FHIR URL, both SHALL be
     * consistent.
     *
     * The type is the Canonical URL of Resource Definition that is the type this reference refers
     * to. References are URLs that are relative to http://hl7.org/fhir/StructureDefinition/ e.g.
     * "Patient" is a reference to http://hl7.org/fhir/StructureDefinition/Patient. Absolute URLs
     * are only allowed for logical models (and can only be used in references in logical models,
     * not resources).
     *
     * This element is used to indicate the type of the target of the reference. This may be used
     * which ever of the other elements are populated (or not). In some cases, the type of the
     * target may be determined by inspection of the reference (e.g. a known RESTful URL) or by
     * resolving the target of the reference.
     */
    public open var type: Uri.Builder? = null

    /**
     * An identifier for the target resource. This is used when there is no way to reference the
     * other resource directly, either because the entity it represents is not available through a
     * FHIR server, or because there is no way for the author of the resource to convert a known
     * identifier to an actual location. There is no requirement that a Reference.identifier point
     * to something that is actually exposed as a FHIR instance, but it SHALL point to a business
     * concept that would be expected to be exposed as a FHIR instance, and that instance would need
     * to be of a FHIR resource type allowed by the reference.
     *
     * When an identifier is provided in place of a reference, any system processing the reference
     * will only be able to resolve the identifier to a reference if it understands the business
     * context in which the identifier is used. Sometimes this is global (e.g. a national
     * identifier) but often it is not. For this reason, none of the useful mechanisms described for
     * working with references (e.g. chaining, includes) are possible, nor should servers be
     * expected to be able resolve the reference. Servers may accept an identifier based reference
     * untouched, resolve it, and/or reject it - see
     * CapabilityStatement.rest.resource.referencePolicy.
     *
     * When both an identifier and a literal reference are provided, the literal reference is
     * preferred. Applications processing the resource are allowed - but not required - to check
     * that the identifier matches the literal reference
     *
     * Applications converting a logical reference to a literal reference may choose to leave the
     * logical reference present, or remove it.
     *
     * Reference is intended to point to a structure that can potentially be expressed as a FHIR
     * resource, though there is no need for it to exist as an actual FHIR resource instance -
     * except in as much as an application wishes to actual find the target of the reference. The
     * content referred to be the identifier must meet the logical constraints implied by any
     * limitations on what resource types are permitted for the reference. For example, it would not
     * be legitimate to send the identifier for a drug prescription if the type were
     * Reference(Observation|DiagnosticReport). One of the use-cases for Reference.identifier is the
     * situation where no FHIR representation exists (where the type is Reference (Any).
     *
     * This element only allows for a single identifier. In the case where additional identifers are
     * required, use the
     * [http://hl7.org/fhir/StructureDefinition/additionalIdentifier](http://hl7.org/fhir/extensions/StructureDefinition-additionalIdentifier.html)
     * extension.
     */
    public open var identifier: Identifier.Builder? = null

    /**
     * Plain text narrative that identifies the resource in addition to the resource reference.
     *
     * This is generally not the same as the Resource.text of the referenced resource. The purpose
     * is to identify what's being referenced, not to fully describe it.
     */
    public open var display: String.Builder? = null

    public open fun build(): Reference =
      Reference(
        id = id,
        extension = extension.map { it.build() },
        reference = reference?.build(),
        type = type?.build(),
        identifier = identifier?.build(),
        display = display?.build(),
      )
  }
}

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

import com.google.fhir.model.r5.serializers.ExtendedContactDetailSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * ExtendedContactDetail Type: Specifies contact information for a specific purpose over a period of
 * time, might be handled/monitored by a specific named person or organization.
 */
@Serializable(with = ExtendedContactDetailSerializer::class)
public data class ExtendedContactDetail(
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
   * The purpose/type of contact.
   *
   * If no purpose is defined, then these contact details may be used for any purpose.
   */
  public val purpose: CodeableConcept? = null,
  /**
   * The name of an individual to contact, some types of contact detail are usually blank.
   *
   * If there is no named individual, the telecom/address information is not generally monitored by
   * a specific individual.
   */
  public val name: List<HumanName> = listOf(),
  /** The contact details application for the purpose defined. */
  public val telecom: List<ContactPoint> = listOf(),
  /**
   * Address for the contact.
   *
   * More than 1 address would be for different purposes, and thus should be entered as a different
   * entry,.
   */
  public val address: Address? = null,
  /**
   * This contact detail is handled/monitored by a specific organization. If the name is provided in
   * the contact, then it is referring to the named individual within this organization.
   */
  public val organization: Reference? = null,
  /**
   * Period that this contact was valid for usage.
   *
   * If the details have multiple periods, then enter in a new ExtendedContact with the new period.
   */
  public val period: Period? = null,
) : DataType() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        name = this@with.name.map { it.toBuilder() }.toMutableList()
        telecom = this@with.telecom.map { it.toBuilder() }.toMutableList()
        address = this@with.address?.toBuilder()
        organization = this@with.organization?.toBuilder()
        period = this@with.period?.toBuilder()
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
     * The purpose/type of contact.
     *
     * If no purpose is defined, then these contact details may be used for any purpose.
     */
    public open var purpose: CodeableConcept.Builder? = null

    /**
     * The name of an individual to contact, some types of contact detail are usually blank.
     *
     * If there is no named individual, the telecom/address information is not generally monitored
     * by a specific individual.
     */
    public open var name: MutableList<HumanName.Builder> = mutableListOf()

    /** The contact details application for the purpose defined. */
    public open var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * Address for the contact.
     *
     * More than 1 address would be for different purposes, and thus should be entered as a
     * different entry,.
     */
    public open var address: Address.Builder? = null

    /**
     * This contact detail is handled/monitored by a specific organization. If the name is provided
     * in the contact, then it is referring to the named individual within this organization.
     */
    public open var organization: Reference.Builder? = null

    /**
     * Period that this contact was valid for usage.
     *
     * If the details have multiple periods, then enter in a new ExtendedContact with the new
     * period.
     */
    public open var period: Period.Builder? = null

    public open fun build(): ExtendedContactDetail =
      ExtendedContactDetail(
        id = id,
        extension = extension.map { it.build() },
        purpose = purpose?.build(),
        name = name.map { it.build() },
        telecom = telecom.map { it.build() },
        address = address?.build(),
        organization = organization?.build(),
        period = period?.build(),
      )
  }
}

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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.serializers.ContactPointSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for ContactPoint Type: Details for all kinds of technology mediated
 * contact points for a person or organization, including telephone, email, etc.
 */
@Serializable(with = ContactPointSerializer::class)
public data class ContactPoint(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and manageable, there is a strict set of governance
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
   * Telecommunications form for contact point - what communications system is required to make use
   * of the contact.
   */
  public val system: Enumeration<ContactPointSystem>? = null,
  /**
   * The actual contact point details, in a form that is meaningful to the designated communication
   * system (i.e. phone number or email address).
   *
   * Additional text data such as phone extension numbers, or notes about use of the contact are
   * sometimes included in the value.
   */
  public val `value`: String? = null,
  /**
   * Identifies the purpose for the contact point.
   *
   * Applications can assume that a contact is current unless it explicitly says that it is
   * temporary or old.
   */
  public val use: Enumeration<ContactPointUse>? = null,
  /**
   * Specifies a preferred order in which to use a set of contacts. ContactPoints with lower rank
   * values are more preferred than those with higher rank values.
   *
   * Note that rank does not necessarily follow the order in which the contacts are represented in
   * the instance.
   */
  public val rank: PositiveInt? = null,
  /** Time period when the contact point was/is in use. */
  public val period: Period? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        system = this@with.system
        `value` = this@with.`value`?.toBuilder()
        use = this@with.use
        rank = this@with.rank?.toBuilder()
        period = this@with.period?.toBuilder()
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
     * the element. To make the use of extensions safe and manageable, there is a strict set of
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
     * Telecommunications form for contact point - what communications system is required to make
     * use of the contact.
     */
    public open var system: Enumeration<ContactPointSystem>? = null

    /**
     * The actual contact point details, in a form that is meaningful to the designated
     * communication system (i.e. phone number or email address).
     *
     * Additional text data such as phone extension numbers, or notes about use of the contact are
     * sometimes included in the value.
     */
    public open var `value`: String.Builder? = null

    /**
     * Identifies the purpose for the contact point.
     *
     * Applications can assume that a contact is current unless it explicitly says that it is
     * temporary or old.
     */
    public open var use: Enumeration<ContactPointUse>? = null

    /**
     * Specifies a preferred order in which to use a set of contacts. ContactPoints with lower rank
     * values are more preferred than those with higher rank values.
     *
     * Note that rank does not necessarily follow the order in which the contacts are represented in
     * the instance.
     */
    public open var rank: PositiveInt.Builder? = null

    /** Time period when the contact point was/is in use. */
    public open var period: Period.Builder? = null

    public open fun build(): ContactPoint =
      ContactPoint(
        id = id,
        extension = extension.map { it.build() },
        system = system,
        `value` = `value`?.build(),
        use = use,
        rank = rank?.build(),
        period = period?.build(),
      )
  }

  /** Telecommunications form for contact point. */
  public enum class ContactPointSystem(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Phone("phone", "http://hl7.org/fhir/contact-point-system", "Phone"),
    Fax("fax", "http://hl7.org/fhir/contact-point-system", "Fax"),
    Email("email", "http://hl7.org/fhir/contact-point-system", "Email"),
    Pager("pager", "http://hl7.org/fhir/contact-point-system", "Pager"),
    Url("url", "http://hl7.org/fhir/contact-point-system", "URL"),
    Sms("sms", "http://hl7.org/fhir/contact-point-system", "SMS"),
    Other("other", "http://hl7.org/fhir/contact-point-system", "Other");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ContactPointSystem =
        when (code) {
          "phone" -> Phone
          "fax" -> Fax
          "email" -> Email
          "pager" -> Pager
          "url" -> Url
          "sms" -> Sms
          "other" -> Other
          else -> throw IllegalArgumentException("Unknown code $code for enum ContactPointSystem")
        }
    }
  }

  /** Use of contact point. */
  public enum class ContactPointUse(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Home("home", "http://hl7.org/fhir/contact-point-use", "Home"),
    Work("work", "http://hl7.org/fhir/contact-point-use", "Work"),
    Temp("temp", "http://hl7.org/fhir/contact-point-use", "Temp"),
    Old("old", "http://hl7.org/fhir/contact-point-use", "Old"),
    Mobile("mobile", "http://hl7.org/fhir/contact-point-use", "Mobile");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ContactPointUse =
        when (code) {
          "home" -> Home
          "work" -> Work
          "temp" -> Temp
          "old" -> Old
          "mobile" -> Mobile
          else -> throw IllegalArgumentException("Unknown code $code for enum ContactPointUse")
        }
    }
  }
}

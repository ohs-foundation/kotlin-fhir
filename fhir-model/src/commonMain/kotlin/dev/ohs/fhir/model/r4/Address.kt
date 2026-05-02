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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.serializers.AddressSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Address Type: An address expressed using postal conventions (as
 * opposed to GPS or other location definition formats). This data type may be used to convey
 * addresses for use in delivering mail as well as for visiting locations which might not be valid
 * for mail delivery. There are a variety of postal address formats defined around the world.
 */
@Serializable(with = AddressSerializer::class)
public data class Address(
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
   * The purpose of this address.
   *
   * Applications can assume that an address is current unless it explicitly says that it is
   * temporary or old.
   */
  public val use: Enumeration<AddressUse>? = null,
  /**
   * Distinguishes between physical addresses (those you can visit) and mailing addresses (e.g. PO
   * Boxes and care-of addresses). Most addresses are both.
   *
   * The definition of Address states that "address is intended to describe postal addresses, not
   * physical locations". However, many applications track whether an address has a dual purpose of
   * being a location that can be visited as well as being a valid delivery destination, and Postal
   * addresses are often used as proxies for physical locations (also see the
   * [Location](location.html#) resource).
   */
  public val type: Enumeration<AddressType>? = null,
  /**
   * Specifies the entire address as it should be displayed e.g. on a postal label. This may be
   * provided instead of or as well as the specific parts.
   *
   * Can provide both a text representation and parts. Applications updating an address SHALL ensure
   * that when both text and parts are present, no content is included in the text that isn't found
   * in a part.
   */
  public val text: String? = null,
  /**
   * This component contains the house number, apartment number, street name, street direction, P.O.
   * Box number, delivery hints, and similar address information.
   */
  public val line: List<String> = listOf(),
  /** The name of the city, town, suburb, village or other community or delivery center. */
  public val city: String? = null,
  /**
   * The name of the administrative area (county).
   *
   * District is sometimes known as county, but in some regions 'county' is used in place of city
   * (municipality), so county name should be conveyed in city instead.
   */
  public val district: String? = null,
  /**
   * Sub-unit of a country with limited sovereignty in a federally organized country. A code may be
   * used if codes are in common use (e.g. US 2 letter state codes).
   */
  public val state: String? = null,
  /** A postal code designating a region defined by the postal service. */
  public val postalCode: String? = null,
  /**
   * Country - a nation as commonly understood or generally accepted.
   *
   * ISO 3166 3 letter codes can be used in place of a human readable country name.
   */
  public val country: String? = null,
  /** Time period when address was/is in use. */
  public val period: Period? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        use = this@with.use
        type = this@with.type
        text = this@with.text?.toBuilder()
        line = this@with.line.map { it.toBuilder() }.toMutableList()
        city = this@with.city?.toBuilder()
        district = this@with.district?.toBuilder()
        state = this@with.state?.toBuilder()
        postalCode = this@with.postalCode?.toBuilder()
        country = this@with.country?.toBuilder()
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
     * The purpose of this address.
     *
     * Applications can assume that an address is current unless it explicitly says that it is
     * temporary or old.
     */
    public open var use: Enumeration<AddressUse>? = null

    /**
     * Distinguishes between physical addresses (those you can visit) and mailing addresses (e.g. PO
     * Boxes and care-of addresses). Most addresses are both.
     *
     * The definition of Address states that "address is intended to describe postal addresses, not
     * physical locations". However, many applications track whether an address has a dual purpose
     * of being a location that can be visited as well as being a valid delivery destination, and
     * Postal addresses are often used as proxies for physical locations (also see the
     * [Location](location.html#) resource).
     */
    public open var type: Enumeration<AddressType>? = null

    /**
     * Specifies the entire address as it should be displayed e.g. on a postal label. This may be
     * provided instead of or as well as the specific parts.
     *
     * Can provide both a text representation and parts. Applications updating an address SHALL
     * ensure that when both text and parts are present, no content is included in the text that
     * isn't found in a part.
     */
    public open var text: String.Builder? = null

    /**
     * This component contains the house number, apartment number, street name, street direction,
     * P.O. Box number, delivery hints, and similar address information.
     */
    public open var line: MutableList<String.Builder> = mutableListOf()

    /** The name of the city, town, suburb, village or other community or delivery center. */
    public open var city: String.Builder? = null

    /**
     * The name of the administrative area (county).
     *
     * District is sometimes known as county, but in some regions 'county' is used in place of city
     * (municipality), so county name should be conveyed in city instead.
     */
    public open var district: String.Builder? = null

    /**
     * Sub-unit of a country with limited sovereignty in a federally organized country. A code may
     * be used if codes are in common use (e.g. US 2 letter state codes).
     */
    public open var state: String.Builder? = null

    /** A postal code designating a region defined by the postal service. */
    public open var postalCode: String.Builder? = null

    /**
     * Country - a nation as commonly understood or generally accepted.
     *
     * ISO 3166 3 letter codes can be used in place of a human readable country name.
     */
    public open var country: String.Builder? = null

    /** Time period when address was/is in use. */
    public open var period: Period.Builder? = null

    public open fun build(): Address =
      Address(
        id = id,
        extension = extension.map { it.build() },
        use = use,
        type = type,
        text = text?.build(),
        line = line.map { it.build() },
        city = city?.build(),
        district = district?.build(),
        state = state?.build(),
        postalCode = postalCode?.build(),
        country = country?.build(),
        period = period?.build(),
      )
  }

  /** The use of an address. */
  public enum class AddressUse(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Home("home", "http://hl7.org/fhir/address-use", "Home"),
    Work("work", "http://hl7.org/fhir/address-use", "Work"),
    Temp("temp", "http://hl7.org/fhir/address-use", "Temporary"),
    Old("old", "http://hl7.org/fhir/address-use", "Old / Incorrect"),
    Billing("billing", "http://hl7.org/fhir/address-use", "Billing");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AddressUse =
        when (code) {
          "home" -> Home
          "work" -> Work
          "temp" -> Temp
          "old" -> Old
          "billing" -> Billing
          else -> throw IllegalArgumentException("Unknown code $code for enum AddressUse")
        }
    }
  }

  /** The type of an address (physical / postal). */
  public enum class AddressType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Postal("postal", "http://hl7.org/fhir/address-type", "Postal"),
    Physical("physical", "http://hl7.org/fhir/address-type", "Physical"),
    Both("both", "http://hl7.org/fhir/address-type", "Postal & Physical");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AddressType =
        when (code) {
          "postal" -> Postal
          "physical" -> Physical
          "both" -> Both
          else -> throw IllegalArgumentException("Unknown code $code for enum AddressType")
        }
    }
  }
}

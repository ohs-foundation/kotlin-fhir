/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.LocationHoursOfOperationSerializer
import dev.ohs.fhir.model.r4.serializers.LocationPositionSerializer
import dev.ohs.fhir.model.r4.serializers.LocationSerializer
import dev.ohs.fhir.model.r4.terminologies.DaysOfWeek
import dev.ohs.fhir.model.r4.terminologies.LocationMode
import dev.ohs.fhir.model.r4.terminologies.LocationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details and position information for a physical place where services are provided and resources
 * and participants may be stored, found, contained, or accommodated.
 */
@Serializable(with = LocationSerializer::class)
@SerialName("Location")
public data class Location(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
   */
  override val id: kotlin.String? = null,
  /**
   * The metadata about the resource. This is content that is maintained by the infrastructure.
   * Changes to the content might not always be associated with version changes to the resource.
   */
  override val meta: Meta? = null,
  /**
   * A reference to a set of rules that were followed when the resource was constructed, and which
   * must be understood when processing the content. Often, this is a reference to an implementation
   * guide that defines the special rules along with other profiles etc.
   *
   * Asserting this rule set restricts the content to be only understood by a limited set of trading
   * partners. This inherently limits the usefulness of the data in the long term. However, the
   * existing health eco-system is highly fractured, and not yet ready to define, collect, and
   * exchange data in a generally computable sense. Wherever possible, implementers and/or
   * specification writers should avoid using this element. Often, when used, the URL is a reference
   * to an implementation guide that defines these special rules as part of it's narrative along
   * with other profiles, value sets, etc.
   */
  override val implicitRules: Uri? = null,
  /**
   * The base language in which the resource is written.
   *
   * Language is provided to support indexing and accessibility (typically, services such as text to
   * speech use the language tag). The html language tag in the narrative applies to the narrative.
   * The language tag on the resource may be used to specify the language of other presentations
   * generated from the data in the resource. Not all the content has to be in the base language.
   * The Resource.language should not be assumed to apply to the narrative automatically. If a
   * language is specified, it should it also be specified on the div element in the html (see rules
   * in HTML5 for information about the relationship between xml:lang and the html lang attribute).
   */
  override val language: Code? = null,
  /**
   * A human-readable narrative that contains a summary of the resource and can be used to represent
   * the content of the resource to a human. The narrative need not encode all the structured data,
   * but is required to contain sufficient detail to make it "clinically safe" for a human to just
   * read the narrative. Resource definitions may define what content should be represented in the
   * narrative to ensure clinical safety.
   *
   * Contained resources do not have narrative. Resources that are not contained SHOULD have a
   * narrative. In some cases, a resource may only have text with little or no additional discrete
   * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
   * legacy systems where information is captured as a "text blob" or where text is additionally
   * entered raw or narrated and encoded information is added later.
   */
  override val text: Narrative? = null,
  /**
   * These resources do not have an independent existence apart from the resource that contains
   * them - they cannot be identified independently, and nor can they have their own independent
   * transaction scope.
   *
   * This should never be done when the content can be identified properly, as once identification
   * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
   * resources may have profiles and tags In their meta elements, but SHALL NOT have security
   * labels.
   */
  override val contained: List<Resource> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and manageable, there is a strict set of
   * governance applied to the definition and use of extensions. Though any implementer can define
   * an extension, there is a set of requirements that SHALL be met as part of the definition of the
   * extension.
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val extension: List<Extension> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource and that modifies the understanding of the element that contains it and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and manageable, there is a strict
   * set of governance applied to the definition and use of extensions. Though any implementer is
   * allowed to define an extension, there is a set of requirements that SHALL be met as part of the
   * definition of the extension. Applications processing a resource are required to check for
   * modifier extensions.
   *
   * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource
   * (including cannot change the meaning of modifierExtension itself).
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val modifierExtension: List<Extension> = listOf(),
  /** Unique code or number identifying the location to its users. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The status property covers the general availability of the resource, not the current value
   * which may be covered by the operationStatus, or by a schedule/slots if they are configured for
   * the location.
   */
  public val status: Enumeration<LocationStatus>? = null,
  /**
   * The operational status covers operation values most relevant to beds (but can also apply to
   * rooms/units/chairs/etc. such as an isolation unit/dialysis chair). This typically covers
   * concepts such as contamination, housekeeping, and other activities like maintenance.
   */
  public val operationalStatus: Coding? = null,
  /**
   * Name of the location as used by humans. Does not need to be unique.
   *
   * If the name of a location changes, consider putting the old name in the alias column so that it
   * can still be located through searches.
   */
  public val name: String? = null,
  /**
   * A list of alternate names that the location is known as, or was known as, in the past.
   *
   * There are no dates associated with the alias/historic names, as this is not intended to track
   * when names were used, but to assist in searching so that older names can still result in
   * identifying the location.
   */
  public val alias: List<String> = listOf(),
  /** Description of the Location, which helps in finding or referencing the place. */
  public val description: String? = null,
  /**
   * Indicates whether a resource instance represents a specific location or a class of locations.
   *
   * This is labeled as a modifier because whether or not the location is a class of locations
   * changes how it can be used and understood.
   */
  public val mode: Enumeration<LocationMode>? = null,
  /** Indicates the type of function performed at the location. */
  public val type: List<CodeableConcept> = listOf(),
  /**
   * The contact details of communication devices available at the location. This can include phone
   * numbers, fax numbers, mobile numbers, email addresses and web sites.
   */
  public val telecom: List<ContactPoint> = listOf(),
  /**
   * Physical location.
   *
   * Additional addresses should be recorded using another instance of the Location resource, or via
   * the Organization.
   */
  public val address: Address? = null,
  /** Physical form of the location, e.g. building, room, vehicle, road. */
  public val physicalType: CodeableConcept? = null,
  /**
   * The absolute geographic location of the Location, expressed using the WGS84 datum (This is the
   * same co-ordinate system used in KML).
   */
  public val position: Position? = null,
  /**
   * The organization responsible for the provisioning and upkeep of the location.
   *
   * This can also be used as the part of the organization hierarchy where this location provides
   * services. These services can be defined through the HealthcareService resource.
   */
  public val managingOrganization: Reference? = null,
  /** Another Location of which this Location is physically a part of. */
  public val partOf: Reference? = null,
  /**
   * What days/times during a week is this location usually open.
   *
   * This type of information is commonly found published in directories and on websites informing
   * customers when the facility is available.
   *
   * Specific services within the location may have their own hours which could be shorter (or
   * longer) than the locations hours.
   */
  public val hoursOfOperation: List<HoursOfOperation> = listOf(),
  /**
   * A description of when the locations opening ours are different to normal, e.g. public holiday
   * availability. Succinctly describing all possible exceptions to normal site availability as
   * detailed in the opening hours Times.
   */
  public val availabilityExceptions: String? = null,
  /** Technical endpoints providing access to services operated for the location. */
  public val endpoint: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder = Builder()
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.toBuilderList()
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.identifier = identifier.toBuilderList()
    builder.status = status
    builder.operationalStatus = operationalStatus?.toBuilder()
    builder.name = name?.toBuilder()
    builder.alias = alias.toBuilderList()
    builder.description = description?.toBuilder()
    builder.mode = mode
    builder.type = type.toBuilderList()
    builder.telecom = telecom.toBuilderList()
    builder.address = address?.toBuilder()
    builder.physicalType = physicalType?.toBuilder()
    builder.position = position?.toBuilder()
    builder.managingOrganization = managingOrganization?.toBuilder()
    builder.partOf = partOf?.toBuilder()
    builder.hoursOfOperation = hoursOfOperation.toBuilderList()
    builder.availabilityExceptions = availabilityExceptions?.toBuilder()
    builder.endpoint = endpoint.toBuilderList()
    return builder
  }

  /**
   * The absolute geographic location of the Location, expressed using the WGS84 datum (This is the
   * same co-ordinate system used in KML).
   */
  @Serializable(with = LocationPositionSerializer::class)
  public data class Position(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val modifierExtension: List<Extension> = listOf(),
    /**
     * Longitude. The value domain and the interpretation are the same as for the text of the
     * longitude element in KML (see notes below).
     */
    public val longitude: Decimal,
    /**
     * Latitude. The value domain and the interpretation are the same as for the text of the
     * latitude element in KML (see notes below).
     */
    public val latitude: Decimal,
    /**
     * Altitude. The value domain and the interpretation are the same as for the text of the
     * altitude element in KML (see notes below).
     */
    public val altitude: Decimal? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(longitude.toBuilder(), latitude.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.altitude = altitude?.toBuilder()
      return builder
    }

    public class Builder(
      /**
       * Longitude. The value domain and the interpretation are the same as for the text of the
       * longitude element in KML (see notes below).
       */
      public var longitude: Decimal.Builder,
      /**
       * Latitude. The value domain and the interpretation are the same as for the text of the
       * latitude element in KML (see notes below).
       */
      public var latitude: Decimal.Builder,
    ) : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and manageable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * Altitude. The value domain and the interpretation are the same as for the text of the
       * altitude element in KML (see notes below).
       */
      public var altitude: Decimal.Builder? = null

      override fun build(): Position =
        Position(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          longitude = longitude.build(),
          latitude = latitude.build(),
          altitude = altitude?.build(),
        )
    }
  }

  /** What days/times during a week is this location usually open. */
  @Serializable(with = LocationHoursOfOperationSerializer::class)
  public data class HoursOfOperation(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val modifierExtension: List<Extension> = listOf(),
    /** Indicates which days of the week are available between the start and end Times. */
    public val daysOfWeek: List<Enumeration<DaysOfWeek>> = listOf(),
    /** The Location is open all day. */
    public val allDay: Boolean? = null,
    /** Time that the Location opens. */
    public val openingTime: Time? = null,
    /** Time that the Location closes. */
    public val closingTime: Time? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.daysOfWeek = daysOfWeek.toMutableList()
      builder.allDay = allDay?.toBuilder()
      builder.openingTime = openingTime?.toBuilder()
      builder.closingTime = closingTime?.toBuilder()
      return builder
    }

    public class Builder() : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and manageable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /** Indicates which days of the week are available between the start and end Times. */
      public var daysOfWeek: MutableList<Enumeration<DaysOfWeek>> = mutableListOf()

      /** The Location is open all day. */
      public var allDay: Boolean.Builder? = null

      /** Time that the Location opens. */
      public var openingTime: Time.Builder? = null

      /** Time that the Location closes. */
      public var closingTime: Time.Builder? = null

      override fun build(): HoursOfOperation =
        HoursOfOperation(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          daysOfWeek = daysOfWeek,
          allDay = allDay?.build(),
          openingTime = openingTime?.build(),
          closingTime = closingTime?.build(),
        )
    }
  }

  public class Builder() : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
     */
    override var id: kotlin.String? = null

    /**
     * The metadata about the resource. This is content that is maintained by the infrastructure.
     * Changes to the content might not always be associated with version changes to the resource.
     */
    public var meta: Meta.Builder? = null

    /**
     * A reference to a set of rules that were followed when the resource was constructed, and which
     * must be understood when processing the content. Often, this is a reference to an
     * implementation guide that defines the special rules along with other profiles etc.
     *
     * Asserting this rule set restricts the content to be only understood by a limited set of
     * trading partners. This inherently limits the usefulness of the data in the long term.
     * However, the existing health eco-system is highly fractured, and not yet ready to define,
     * collect, and exchange data in a generally computable sense. Wherever possible, implementers
     * and/or specification writers should avoid using this element. Often, when used, the URL is a
     * reference to an implementation guide that defines these special rules as part of it's
     * narrative along with other profiles, value sets, etc.
     */
    public var implicitRules: Uri.Builder? = null

    /**
     * The base language in which the resource is written.
     *
     * Language is provided to support indexing and accessibility (typically, services such as text
     * to speech use the language tag). The html language tag in the narrative applies to the
     * narrative. The language tag on the resource may be used to specify the language of other
     * presentations generated from the data in the resource. Not all the content has to be in the
     * base language. The Resource.language should not be assumed to apply to the narrative
     * automatically. If a language is specified, it should it also be specified on the div element
     * in the html (see rules in HTML5 for information about the relationship between xml:lang and
     * the html lang attribute).
     */
    public var language: Code.Builder? = null

    /**
     * A human-readable narrative that contains a summary of the resource and can be used to
     * represent the content of the resource to a human. The narrative need not encode all the
     * structured data, but is required to contain sufficient detail to make it "clinically safe"
     * for a human to just read the narrative. Resource definitions may define what content should
     * be represented in the narrative to ensure clinical safety.
     *
     * Contained resources do not have narrative. Resources that are not contained SHOULD have a
     * narrative. In some cases, a resource may only have text with little or no additional discrete
     * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
     * legacy systems where information is captured as a "text blob" or where text is additionally
     * entered raw or narrated and encoded information is added later.
     */
    public var text: Narrative.Builder? = null

    /**
     * These resources do not have an independent existence apart from the resource that contains
     * them - they cannot be identified independently, and nor can they have their own independent
     * transaction scope.
     *
     * This should never be done when the content can be identified properly, as once identification
     * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
     * resources may have profiles and tags In their meta elements, but SHALL NOT have security
     * labels.
     */
    public var contained: MutableList<Resource.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource. To make the use of extensions safe and manageable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public var extension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource and that modifies the understanding of the element that contains it and/or the
     * understanding of the containing element's descendants. Usually modifier elements provide
     * negation or qualification. To make the use of extensions safe and manageable, there is a
     * strict set of governance applied to the definition and use of extensions. Though any
     * implementer is allowed to define an extension, there is a set of requirements that SHALL be
     * met as part of the definition of the extension. Applications processing a resource are
     * required to check for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

    /** Unique code or number identifying the location to its users. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The status property covers the general availability of the resource, not the current value
     * which may be covered by the operationStatus, or by a schedule/slots if they are configured
     * for the location.
     */
    public var status: Enumeration<LocationStatus>? = null

    /**
     * The operational status covers operation values most relevant to beds (but can also apply to
     * rooms/units/chairs/etc. such as an isolation unit/dialysis chair). This typically covers
     * concepts such as contamination, housekeeping, and other activities like maintenance.
     */
    public var operationalStatus: Coding.Builder? = null

    /**
     * Name of the location as used by humans. Does not need to be unique.
     *
     * If the name of a location changes, consider putting the old name in the alias column so that
     * it can still be located through searches.
     */
    public var name: String.Builder? = null

    /**
     * A list of alternate names that the location is known as, or was known as, in the past.
     *
     * There are no dates associated with the alias/historic names, as this is not intended to track
     * when names were used, but to assist in searching so that older names can still result in
     * identifying the location.
     */
    public var alias: MutableList<String.Builder> = mutableListOf()

    /** Description of the Location, which helps in finding or referencing the place. */
    public var description: String.Builder? = null

    /**
     * Indicates whether a resource instance represents a specific location or a class of locations.
     *
     * This is labeled as a modifier because whether or not the location is a class of locations
     * changes how it can be used and understood.
     */
    public var mode: Enumeration<LocationMode>? = null

    /** Indicates the type of function performed at the location. */
    public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The contact details of communication devices available at the location. This can include
     * phone numbers, fax numbers, mobile numbers, email addresses and web sites.
     */
    public var telecom: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * Physical location.
     *
     * Additional addresses should be recorded using another instance of the Location resource, or
     * via the Organization.
     */
    public var address: Address.Builder? = null

    /** Physical form of the location, e.g. building, room, vehicle, road. */
    public var physicalType: CodeableConcept.Builder? = null

    /**
     * The absolute geographic location of the Location, expressed using the WGS84 datum (This is
     * the same co-ordinate system used in KML).
     */
    public var position: Position.Builder? = null

    /**
     * The organization responsible for the provisioning and upkeep of the location.
     *
     * This can also be used as the part of the organization hierarchy where this location provides
     * services. These services can be defined through the HealthcareService resource.
     */
    public var managingOrganization: Reference.Builder? = null

    /** Another Location of which this Location is physically a part of. */
    public var partOf: Reference.Builder? = null

    /**
     * What days/times during a week is this location usually open.
     *
     * This type of information is commonly found published in directories and on websites informing
     * customers when the facility is available.
     *
     * Specific services within the location may have their own hours which could be shorter (or
     * longer) than the locations hours.
     */
    public var hoursOfOperation: MutableList<HoursOfOperation.Builder> = mutableListOf()

    /**
     * A description of when the locations opening ours are different to normal, e.g. public holiday
     * availability. Succinctly describing all possible exceptions to normal site availability as
     * detailed in the opening hours Times.
     */
    public var availabilityExceptions: String.Builder? = null

    /** Technical endpoints providing access to services operated for the location. */
    public var endpoint: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): Location =
      Location(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        identifier = identifier.buildList(),
        status = status,
        operationalStatus = operationalStatus?.build(),
        name = name?.build(),
        alias = alias.buildList(),
        description = description?.build(),
        mode = mode,
        type = type.buildList(),
        telecom = telecom.buildList(),
        address = address?.build(),
        physicalType = physicalType?.build(),
        position = position?.build(),
        managingOrganization = managingOrganization?.build(),
        partOf = partOf?.build(),
        hoursOfOperation = hoursOfOperation.buildList(),
        availabilityExceptions = availabilityExceptions?.build(),
        endpoint = endpoint.buildList(),
      )
  }
}

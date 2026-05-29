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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.DeviceConformsToSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceNameSerializer
import dev.ohs.fhir.model.r5.serializers.DevicePropertySerializer
import dev.ohs.fhir.model.r5.serializers.DeviceSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceUdiCarrierSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceVersionSerializer
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource describes the properties (regulated, has real time clock, etc.), adminstrative
 * (manufacturer name, model number, serial number, firmware, etc.), and type (knee replacement,
 * blood pressure cuff, MRI, etc.) of a physical unit (these values do not change much within a
 * given module, for example the serail number, manufacturer name, and model number). An actual unit
 * may consist of several modules in a distinct hierarchy and these are represented by multiple
 * Device resources and bound through the 'parent' element.
 */
@Serializable(with = DeviceSerializer::class)
@SerialName("Device")
public data class Device(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
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
   * to an implementation guide that defines these special rules as part of its narrative along with
   * other profiles, value sets, etc.
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
   * Contained resources do not have a narrative. Resources that are not contained SHOULD have a
   * narrative. In some cases, a resource may only have text with little or no additional discrete
   * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
   * legacy systems where information is captured as a "text blob" or where text is additionally
   * entered raw or narrated and encoded information is added later.
   */
  override val text: Narrative? = null,
  /**
   * These resources do not have an independent existence apart from the resource that contains
   * them - they cannot be identified independently, nor can they have their own independent
   * transaction scope. This is allowed to be a Parameters resource if and only if it is referenced
   * by a resource that provides context/meaning.
   *
   * This should never be done when the content can be identified properly, as once identification
   * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
   * resources may have profiles and tags in their meta elements, but SHALL NOT have security
   * labels.
   */
  override val contained: List<Resource> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and managable, there is a strict set of governance
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
   * May be used to represent additional information that is not part of the basic definition of the
   * resource and that modifies the understanding of the element that contains it and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and managable, there is a strict
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
  /**
   * Unique instance identifiers assigned to a device by manufacturers other organizations or
   * owners.
   *
   * Certain attributes, like serial number and UDI Carrier (the HRF or AIDC barcode string) are not
   * device instance identifiers as they are not consistently able to uniquely identify the instance
   * of a device, thus are not appropriate to be used to value Device.identifier. The barcode string
   * from a barcode present on a device label or package may identify the instance, include names
   * given to the device in local usage, or may identify the type of device. If the identifier
   * identifies the type of device, Device.type element should be used. The identifier is typically
   * valued if the serialNumber or lotNumber is not valued and represents a different type of
   * identifier. However, it is permissible to still include those identifiers in
   * DeviceDefinition.identifier with the appropriate identifier.type.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The name used to display by default when the device is referenced. Based on intent of use by
   * the resource creator, this may reflect one of the names in Device.name, or may be another
   * simple name.
   */
  public val displayName: String? = null,
  /** The reference to the definition for the device. */
  public val definition: CodeableReference? = null,
  /**
   * Unique device identifier (UDI) assigned to device label or package. Note that the Device may
   * include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction
   * it is sold, or for multiple jurisdictions it could have been sold.
   *
   * UDI may identify an unique instance of a device, or it may only identify the type of the
   * device. See [UDI mappings](device-mappings.html#udi) for a complete mapping of UDI parts to
   * Device.
   */
  public val udiCarrier: List<UdiCarrier> = listOf(),
  /** The Device record status. This is not the status of the device like availability. */
  public val status: Enumeration<FHIRDeviceStatus>? = null,
  /** The availability of the device. */
  public val availabilityStatus: CodeableConcept? = null,
  /**
   * An identifier that supports traceability to the event during which material in this product
   * from one or more biological entities was obtained or pooled.
   *
   * Necessary to support mandatory requirements for traceability from donor/source to recipient and
   * vice versa, while also satisfying donor anonymity requirements. The element is defined
   * consistently across BiologicallyDerivedProduct, NutritionProduct, and Device. The identifier
   * references an event that links to a single biological entity such as a blood donor, or to
   * multiple biological entities (e.g. when the product is an embryo or a pooled platelet product).
   * A single biologicalSourceEvent identifier may appear on multiple products of many types derived
   * from a single donation event or source extraction. As an example, a single donation event may
   * provide 2 kidneys and a liver for organ transplantation, 2 corneas for eye surgery, heart
   * valves and arterial tissue for cardiovascular surgery, multiple skin grafts, tendons, multiple
   * shaped bone grafts and a large number of bone putty/paste products; and each of them may be
   * assigned to the same biological source event identifier.
   */
  public val biologicalSourceEvent: Identifier? = null,
  /** A name of the manufacturer or entity legally responsible for the device. */
  public val manufacturer: String? = null,
  /** The date and time when the device was manufactured. */
  public val manufactureDate: DateTime? = null,
  /**
   * The date and time beyond which this device is no longer valid or should not be used (if
   * applicable).
   */
  public val expirationDate: DateTime? = null,
  /** Lot number assigned by the manufacturer. */
  public val lotNumber: String? = null,
  /**
   * The serial number assigned by the organization when the device was manufactured.
   *
   * Alphanumeric Maximum 20. While a serial number is a type of identifier, in the context of
   * devices for which a UDI is required, thus a serial number may be part of the production
   * identifier, it is more informative to have the serial number as a dedicated attribute together
   * with the other UDI production identifier. When the device is not subject to including the UDI
   * (e.g., its presence and exchange is not mandated by local regulatory requirements or specific
   * use case at hand), thus the concept of production identifiers is not relevant as a set, it
   * remains helpful for consistency to still use Device.serialNumber rather than using
   * Device.identifier with an appropriate type. Systems that do not realize an identifier is a
   * serial number may place it in Device.identifier or if the identifier.system is known for the
   * serial number, it may also be populated in the Device.identifier as a globally unique id_.
   */
  public val serialNumber: String? = null,
  /**
   * This represents the manufacturer's name of the device as provided by the device, from a UDI
   * label, or by a person describing the Device. This typically would be used when a person
   * provides the name(s) or when the device represents one of the names available from
   * DeviceDefinition.
   */
  public val name: List<Name> = listOf(),
  /** The manufacturer's model number for the device. */
  public val modelNumber: String? = null,
  /**
   * The part number or catalog number of the device.
   *
   * Alphanumeric Maximum 20.
   */
  public val partNumber: String? = null,
  /** Devices may be associated with one or more categories. */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * The kind or type of device. A device instance may have more than one type - in which case those
   * are the types that apply to the specific instance of the device.
   *
   * Multiple device types are use when a device is categorized in more than one context – for
   * example, hybrid devices in which the device is both of type gateway and sensor.
   */
  public val type: List<CodeableConcept> = listOf(),
  /** The actual design of the device or software version running on the device. */
  public val version: List<Version> = listOf(),
  /**
   * Identifies the standards, specifications, or formal guidances for the capabilities supported by
   * the device. The device may be certified as conformant to these specifications e.g.,
   * communication, performance, process, measurement, or specialization standards.
   */
  public val conformsTo: List<ConformsTo> = listOf(),
  /**
   * Static or essentially fixed characteristics or features of the device (e.g., time or timing
   * attributes, resolution, accuracy, intended use or instructions for use, and physical
   * attributes) that are not otherwise captured in more specific attributes.
   *
   * Dynamic or current properties, such as settings, of an individual device are described using a
   * Device instance-specific [DeviceMetric] and recorded using [Observation]. Static
   * characteristics of a device could also be documented in an associated [DeviceDefinition]
   * instance. The Device instance's properties, and their values, could be, but need not be, the
   * same as those described in an associated DeviceDefinition.
   */
  public val `property`: List<Property> = listOf(),
  /** The designated condition for performing a task with the device. */
  public val mode: CodeableConcept? = null,
  /** The series of occurrences that repeats during the operation of the device. */
  public val cycle: Count? = null,
  /** A measurement of time during the device's operation (e.g., days, hours, mins, etc.). */
  public val duration: Duration? = null,
  /**
   * An organization that is responsible for the provision and ongoing maintenance of the device.
   */
  public val owner: Reference? = null,
  /**
   * Contact details for an organization or a particular human that is responsible for the device.
   *
   * used for troubleshooting etc.
   */
  public val contact: List<ContactPoint> = listOf(),
  /** The place where the device can be found. */
  public val location: Reference? = null,
  /**
   * A network address on which the device may be contacted directly.
   *
   * If the device is running a FHIR server, the network address should be the Base URL from which a
   * conformance statement may be retrieved.
   */
  public val url: Uri? = null,
  /**
   * Technical endpoints providing access to services provided by the device defined at this
   * resource.
   */
  public val endpoint: List<Reference> = listOf(),
  /**
   * The linked device acting as a communication controller, data collector, translator, or
   * concentrator for the current device (e.g., mobile phone application that relays a blood
   * pressure device's data).
   *
   * The Device.gateway may be used when the Device being referenced has a gateway and/or to capture
   * one or more gateways associated with the device. If the Gateway is included in the Observation
   * resource, the Observation.gatewayDevice should be used instead.
   */
  public val gateway: List<CodeableReference> = listOf(),
  /**
   * Descriptive information, usage information or implantation information that is not captured in
   * an existing element.
   */
  public val note: List<Annotation> = listOf(),
  /**
   * Provides additional safety characteristics about a medical device. For example devices
   * containing latex.
   */
  public val safety: List<CodeableConcept> = listOf(),
  /**
   * The higher level or encompassing device that this device is a logical part of.
   *
   * For example a vital signs monitor (parent) where three separate modules can be plugged into
   * such as interchangeable blood pressure, oximeter, temperature modules. These modules are
   * represented as devices with the .parent valued to the vital signs monitor when plugged in.
   */
  public val parent: Reference? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        displayName = this@with.displayName?.toBuilder()
        definition = this@with.definition?.toBuilder()
        udiCarrier = this@with.udiCarrier.map { it.toBuilder() }.toMutableList()
        status = this@with.status
        availabilityStatus = this@with.availabilityStatus?.toBuilder()
        biologicalSourceEvent = this@with.biologicalSourceEvent?.toBuilder()
        manufacturer = this@with.manufacturer?.toBuilder()
        manufactureDate = this@with.manufactureDate?.toBuilder()
        expirationDate = this@with.expirationDate?.toBuilder()
        lotNumber = this@with.lotNumber?.toBuilder()
        serialNumber = this@with.serialNumber?.toBuilder()
        name = this@with.name.map { it.toBuilder() }.toMutableList()
        modelNumber = this@with.modelNumber?.toBuilder()
        partNumber = this@with.partNumber?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        type = this@with.type.map { it.toBuilder() }.toMutableList()
        version = this@with.version.map { it.toBuilder() }.toMutableList()
        conformsTo = this@with.conformsTo.map { it.toBuilder() }.toMutableList()
        `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
        mode = this@with.mode?.toBuilder()
        cycle = this@with.cycle?.toBuilder()
        duration = this@with.duration?.toBuilder()
        owner = this@with.owner?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        location = this@with.location?.toBuilder()
        url = this@with.url?.toBuilder()
        endpoint = this@with.endpoint.map { it.toBuilder() }.toMutableList()
        gateway = this@with.gateway.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        safety = this@with.safety.map { it.toBuilder() }.toMutableList()
        parent = this@with.parent?.toBuilder()
      }
    }

  /**
   * Unique device identifier (UDI) assigned to device label or package. Note that the Device may
   * include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction
   * it is sold, or for multiple jurisdictions it could have been sold.
   */
  @Serializable(with = DeviceUdiCarrierSerializer::class)
  public data class UdiCarrier(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and managable, there is
     * a strict set of governance applied to the definition and use of extensions. Though any
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
     * The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler
     * and the specific version or model of a device.
     */
    public val deviceIdentifier: String,
    /**
     * Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers
     * include:
     * 1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di,
     * 2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI,
     * 3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di,
     * 4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di #
     *    Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only):
     *    http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.
     */
    public val issuer: Uri,
    /**
     * The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs
     * are globally unique within a single namespace with the appropriate repository uri as the
     * system. For example, UDIs of devices managed in the U.S. by the FDA, the value is
     * http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European
     * Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.
     */
    public val jurisdiction: Uri? = null,
    /**
     * The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology
     * representation of the barcode string as printed on the packaging of the device - e.g., a
     * barcode or RFID. Because of limitations on character sets in XML and the need to round-trip
     * JSON data through XML, AIDC Formats *SHALL* be base64 encoded.
     *
     * The AIDC form of UDIs should be scanned or otherwise used for the identification of the
     * device whenever possible to minimize errors in records resulting from manual transcriptions.
     * If separate barcodes for DI and PI are present, concatenate the string with DI first and in
     * order of human readable expression on label.
     */
    public val carrierAIDC: Base64Binary? = null,
    /**
     * The full UDI carrier as the human readable form (HRF) representation of the barcode string as
     * printed on the packaging of the device.
     *
     * If separate barcodes for DI and PI are present, concatenate the string with DI first and in
     * order of human readable expression on label.
     */
    public val carrierHRF: String? = null,
    /** A coded entry to indicate how the data was entered. */
    public val entryType: Enumeration<UDIEntryType>? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(deviceIdentifier.toBuilder(), issuer.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          jurisdiction = this@with.jurisdiction?.toBuilder()
          carrierAIDC = this@with.carrierAIDC?.toBuilder()
          carrierHRF = this@with.carrierHRF?.toBuilder()
          entryType = this@with.entryType
        }
      }

    public class Builder(
      /**
       * The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the
       * labeler and the specific version or model of a device.
       */
      public var deviceIdentifier: String.Builder,
      /**
       * Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers
       * include:
       * 1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di,
       * 2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-diI,
       * 3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di,
       * 4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di #
       *    Informationsstelle für Arzneispezialitäten (IFA GmbH) (EU only):
       *    http://hl7.org/fhir/NamingSystem/ifa-gmbh-di.
       */
      public var issuer: Uri.Builder,
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and managable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and managable, there
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
       * The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs
       * are globally unique within a single namespace with the appropriate repository uri as the
       * system. For example, UDIs of devices managed in the U.S. by the FDA, the value is
       * http://hl7.org/fhir/NamingSystem/us-fda-udi or in the European Union by the European
       * Commission http://hl7.org/fhir/NamingSystem/eu-ec-udi.
       */
      public var jurisdiction: Uri.Builder? = null

      /**
       * The full UDI carrier of the Automatic Identification and Data Capture (AIDC) technology
       * representation of the barcode string as printed on the packaging of the device - e.g., a
       * barcode or RFID. Because of limitations on character sets in XML and the need to round-trip
       * JSON data through XML, AIDC Formats *SHALL* be base64 encoded.
       *
       * The AIDC form of UDIs should be scanned or otherwise used for the identification of the
       * device whenever possible to minimize errors in records resulting from manual
       * transcriptions. If separate barcodes for DI and PI are present, concatenate the string with
       * DI first and in order of human readable expression on label.
       */
      public var carrierAIDC: Base64Binary.Builder? = null

      /**
       * The full UDI carrier as the human readable form (HRF) representation of the barcode string
       * as printed on the packaging of the device.
       *
       * If separate barcodes for DI and PI are present, concatenate the string with DI first and in
       * order of human readable expression on label.
       */
      public var carrierHRF: String.Builder? = null

      /** A coded entry to indicate how the data was entered. */
      public var entryType: Enumeration<UDIEntryType>? = null

      public fun build(): UdiCarrier =
        UdiCarrier(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          deviceIdentifier = deviceIdentifier.build(),
          issuer = issuer.build(),
          jurisdiction = jurisdiction?.build(),
          carrierAIDC = carrierAIDC?.build(),
          carrierHRF = carrierHRF?.build(),
          entryType = entryType,
        )
    }
  }

  /**
   * This represents the manufacturer's name of the device as provided by the device, from a UDI
   * label, or by a person describing the Device. This typically would be used when a person
   * provides the name(s) or when the device represents one of the names available from
   * DeviceDefinition.
   */
  @Serializable(with = DeviceNameSerializer::class)
  public data class Name(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and managable, there is
     * a strict set of governance applied to the definition and use of extensions. Though any
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
    /** The actual name that identifies the device. */
    public val `value`: String,
    /** Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName. */
    public val type: Enumeration<DeviceNameType>,
    /** Indicates the default or preferred name to be displayed. */
    public val display: Boolean? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(`value`.toBuilder(), type).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          display = this@with.display?.toBuilder()
        }
      }

    public class Builder(
      /** The actual name that identifies the device. */
      public var `value`: String.Builder,
      /** Indicates the kind of name. RegisteredName | UserFriendlyName | PatientReportedName. */
      public var type: Enumeration<DeviceNameType>,
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and managable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and managable, there
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

      /** Indicates the default or preferred name to be displayed. */
      public var display: Boolean.Builder? = null

      public fun build(): Name =
        Name(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          `value` = `value`.build(),
          type = type,
          display = display?.build(),
        )
    }
  }

  /** The actual design of the device or software version running on the device. */
  @Serializable(with = DeviceVersionSerializer::class)
  public data class Version(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and managable, there is
     * a strict set of governance applied to the definition and use of extensions. Though any
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
    /** The type of the device version, e.g. manufacturer, approved, internal. */
    public val type: CodeableConcept? = null,
    /**
     * The hardware or software module of the device to which the version applies.
     *
     * Note that the module of the device would not need to be tracked as a separate device, e.g.,
     * using different UDI, thus would typically involve one or more software modules. For example,
     * a device may involve two software modules each on a different version.
     */
    public val component: Identifier? = null,
    /** The date the version was installed on the device. */
    public val installDate: DateTime? = null,
    /** The version text. */
    public val `value`: String,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(`value`.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          component = this@with.component?.toBuilder()
          installDate = this@with.installDate?.toBuilder()
        }
      }

    public class Builder(
      /** The version text. */
      public var `value`: String.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and managable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and managable, there
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

      /** The type of the device version, e.g. manufacturer, approved, internal. */
      public var type: CodeableConcept.Builder? = null

      /**
       * The hardware or software module of the device to which the version applies.
       *
       * Note that the module of the device would not need to be tracked as a separate device, e.g.,
       * using different UDI, thus would typically involve one or more software modules. For
       * example, a device may involve two software modules each on a different version.
       */
      public var component: Identifier.Builder? = null

      /** The date the version was installed on the device. */
      public var installDate: DateTime.Builder? = null

      public fun build(): Version =
        Version(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          component = component?.build(),
          installDate = installDate?.build(),
          `value` = `value`.build(),
        )
    }
  }

  /**
   * Identifies the standards, specifications, or formal guidances for the capabilities supported by
   * the device. The device may be certified as conformant to these specifications e.g.,
   * communication, performance, process, measurement, or specialization standards.
   */
  @Serializable(with = DeviceConformsToSerializer::class)
  public data class ConformsTo(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and managable, there is
     * a strict set of governance applied to the definition and use of extensions. Though any
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
    /** Describes the type of the standard, specification, or formal guidance. */
    public val category: CodeableConcept? = null,
    /**
     * Code that identifies the specific standard, specification, protocol, formal guidance,
     * regulation, legislation, or certification scheme to which the device adheres.
     */
    public val specification: CodeableConcept,
    /**
     * Identifies the specific form or variant of the standard, specification, or formal guidance.
     * This may be a 'version number', release, document edition, publication year, or other label.
     */
    public val version: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(specification.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          category = this@with.category?.toBuilder()
          version = this@with.version?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Code that identifies the specific standard, specification, protocol, formal guidance,
       * regulation, legislation, or certification scheme to which the device adheres.
       */
      public var specification: CodeableConcept.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and managable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and managable, there
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

      /** Describes the type of the standard, specification, or formal guidance. */
      public var category: CodeableConcept.Builder? = null

      /**
       * Identifies the specific form or variant of the standard, specification, or formal guidance.
       * This may be a 'version number', release, document edition, publication year, or other
       * label.
       */
      public var version: String.Builder? = null

      public fun build(): ConformsTo =
        ConformsTo(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          category = category?.build(),
          specification = specification.build(),
          version = version?.build(),
        )
    }
  }

  /**
   * Static or essentially fixed characteristics or features of the device (e.g., time or timing
   * attributes, resolution, accuracy, intended use or instructions for use, and physical
   * attributes) that are not otherwise captured in more specific attributes.
   */
  @Serializable(with = DevicePropertySerializer::class)
  public data class Property(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and managable, there is
     * a strict set of governance applied to the definition and use of extensions. Though any
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
    /** Code that specifies the property, such as resolution, color, size, being represented. */
    public val type: CodeableConcept,
    /**
     * The value of the property specified by the associated property.type code.
     *
     * The text element in CodeableConcept.text is used for properties which would usually be coded
     * (such as the size of an implant, or a security classification) but for which there is not
     * currently an appropriate concept in the vocabulary (e.g. a custom implant size, or a security
     * classification which depends on configuration). Otherwise the string choice type is used for
     * descriptive properties, or instructions.
     */
    public val `value`: Value,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder(), `value`).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Value {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asString(): String? = this as? String

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asInteger(): Integer? = this as? Integer

      public fun asRange(): Range? = this as? Range

      public fun asAttachment(): Attachment? = this as? Attachment

      @JvmInline
      public value class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      @JvmInline
      public value class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Value

      @JvmInline
      public value class String(public val `value`: dev.ohs.fhir.model.r5.String) : Value

      @JvmInline
      public value class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      @JvmInline
      public value class Integer(public val `value`: dev.ohs.fhir.model.r5.Integer) : Value

      @JvmInline public value class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

      @JvmInline
      public value class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      public companion object {
        internal fun from(
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          stringValue: dev.ohs.fhir.model.r5.String?,
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
          integerValue: dev.ohs.fhir.model.r5.Integer?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
          attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
        ): Value? {
          if (quantityValue != null) return Quantity(quantityValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (stringValue != null) return String(stringValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (integerValue != null) return Integer(integerValue)
          if (rangeValue != null) return Range(rangeValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          return null
        }
      }
    }

    public class Builder(
      /** Code that specifies the property, such as resolution, color, size, being represented. */
      public var type: CodeableConcept.Builder,
      /**
       * The value of the property specified by the associated property.type code.
       *
       * The text element in CodeableConcept.text is used for properties which would usually be
       * coded (such as the size of an implant, or a security classification) but for which there is
       * not currently an appropriate concept in the vocabulary (e.g. a custom implant size, or a
       * security classification which depends on configuration). Otherwise the string choice type
       * is used for descriptive properties, or instructions.
       */
      public var `value`: Value,
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and managable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and managable, there
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

      public fun build(): Property =
        Property(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          `value` = `value`,
        )
    }
  }

  public class Builder() : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
     */
    public var id: kotlin.String? = null

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
     * reference to an implementation guide that defines these special rules as part of its
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
     * Contained resources do not have a narrative. Resources that are not contained SHOULD have a
     * narrative. In some cases, a resource may only have text with little or no additional discrete
     * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
     * legacy systems where information is captured as a "text blob" or where text is additionally
     * entered raw or narrated and encoded information is added later.
     */
    public var text: Narrative.Builder? = null

    /**
     * These resources do not have an independent existence apart from the resource that contains
     * them - they cannot be identified independently, nor can they have their own independent
     * transaction scope. This is allowed to be a Parameters resource if and only if it is
     * referenced by a resource that provides context/meaning.
     *
     * This should never be done when the content can be identified properly, as once identification
     * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
     * resources may have profiles and tags in their meta elements, but SHALL NOT have security
     * labels.
     */
    public var contained: MutableList<Resource.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource. To make the use of extensions safe and managable, there is a strict set of
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
     * negation or qualification. To make the use of extensions safe and managable, there is a
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

    /**
     * Unique instance identifiers assigned to a device by manufacturers other organizations or
     * owners.
     *
     * Certain attributes, like serial number and UDI Carrier (the HRF or AIDC barcode string) are
     * not device instance identifiers as they are not consistently able to uniquely identify the
     * instance of a device, thus are not appropriate to be used to value Device.identifier. The
     * barcode string from a barcode present on a device label or package may identify the instance,
     * include names given to the device in local usage, or may identify the type of device. If the
     * identifier identifies the type of device, Device.type element should be used. The identifier
     * is typically valued if the serialNumber or lotNumber is not valued and represents a different
     * type of identifier. However, it is permissible to still include those identifiers in
     * DeviceDefinition.identifier with the appropriate identifier.type.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The name used to display by default when the device is referenced. Based on intent of use by
     * the resource creator, this may reflect one of the names in Device.name, or may be another
     * simple name.
     */
    public var displayName: String.Builder? = null

    /** The reference to the definition for the device. */
    public var definition: CodeableReference.Builder? = null

    /**
     * Unique device identifier (UDI) assigned to device label or package. Note that the Device may
     * include multiple udiCarriers as it either may include just the udiCarrier for the
     * jurisdiction it is sold, or for multiple jurisdictions it could have been sold.
     *
     * UDI may identify an unique instance of a device, or it may only identify the type of the
     * device. See [UDI mappings](device-mappings.html#udi) for a complete mapping of UDI parts to
     * Device.
     */
    public var udiCarrier: MutableList<UdiCarrier.Builder> = mutableListOf()

    /** The Device record status. This is not the status of the device like availability. */
    public var status: Enumeration<FHIRDeviceStatus>? = null

    /** The availability of the device. */
    public var availabilityStatus: CodeableConcept.Builder? = null

    /**
     * An identifier that supports traceability to the event during which material in this product
     * from one or more biological entities was obtained or pooled.
     *
     * Necessary to support mandatory requirements for traceability from donor/source to recipient
     * and vice versa, while also satisfying donor anonymity requirements. The element is defined
     * consistently across BiologicallyDerivedProduct, NutritionProduct, and Device. The identifier
     * references an event that links to a single biological entity such as a blood donor, or to
     * multiple biological entities (e.g. when the product is an embryo or a pooled platelet
     * product). A single biologicalSourceEvent identifier may appear on multiple products of many
     * types derived from a single donation event or source extraction. As an example, a single
     * donation event may provide 2 kidneys and a liver for organ transplantation, 2 corneas for eye
     * surgery, heart valves and arterial tissue for cardiovascular surgery, multiple skin grafts,
     * tendons, multiple shaped bone grafts and a large number of bone putty/paste products; and
     * each of them may be assigned to the same biological source event identifier.
     */
    public var biologicalSourceEvent: Identifier.Builder? = null

    /** A name of the manufacturer or entity legally responsible for the device. */
    public var manufacturer: String.Builder? = null

    /** The date and time when the device was manufactured. */
    public var manufactureDate: DateTime.Builder? = null

    /**
     * The date and time beyond which this device is no longer valid or should not be used (if
     * applicable).
     */
    public var expirationDate: DateTime.Builder? = null

    /** Lot number assigned by the manufacturer. */
    public var lotNumber: String.Builder? = null

    /**
     * The serial number assigned by the organization when the device was manufactured.
     *
     * Alphanumeric Maximum 20. While a serial number is a type of identifier, in the context of
     * devices for which a UDI is required, thus a serial number may be part of the production
     * identifier, it is more informative to have the serial number as a dedicated attribute
     * together with the other UDI production identifier. When the device is not subject to
     * including the UDI (e.g., its presence and exchange is not mandated by local regulatory
     * requirements or specific use case at hand), thus the concept of production identifiers is not
     * relevant as a set, it remains helpful for consistency to still use Device.serialNumber rather
     * than using Device.identifier with an appropriate type. Systems that do not realize an
     * identifier is a serial number may place it in Device.identifier or if the identifier.system
     * is known for the serial number, it may also be populated in the Device.identifier as a
     * globally unique id_.
     */
    public var serialNumber: String.Builder? = null

    /**
     * This represents the manufacturer's name of the device as provided by the device, from a UDI
     * label, or by a person describing the Device. This typically would be used when a person
     * provides the name(s) or when the device represents one of the names available from
     * DeviceDefinition.
     */
    public var name: MutableList<Name.Builder> = mutableListOf()

    /** The manufacturer's model number for the device. */
    public var modelNumber: String.Builder? = null

    /**
     * The part number or catalog number of the device.
     *
     * Alphanumeric Maximum 20.
     */
    public var partNumber: String.Builder? = null

    /** Devices may be associated with one or more categories. */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The kind or type of device. A device instance may have more than one type - in which case
     * those are the types that apply to the specific instance of the device.
     *
     * Multiple device types are use when a device is categorized in more than one context – for
     * example, hybrid devices in which the device is both of type gateway and sensor.
     */
    public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The actual design of the device or software version running on the device. */
    public var version: MutableList<Version.Builder> = mutableListOf()

    /**
     * Identifies the standards, specifications, or formal guidances for the capabilities supported
     * by the device. The device may be certified as conformant to these specifications e.g.,
     * communication, performance, process, measurement, or specialization standards.
     */
    public var conformsTo: MutableList<ConformsTo.Builder> = mutableListOf()

    /**
     * Static or essentially fixed characteristics or features of the device (e.g., time or timing
     * attributes, resolution, accuracy, intended use or instructions for use, and physical
     * attributes) that are not otherwise captured in more specific attributes.
     *
     * Dynamic or current properties, such as settings, of an individual device are described using
     * a Device instance-specific [DeviceMetric] and recorded using [Observation]. Static
     * characteristics of a device could also be documented in an associated [DeviceDefinition]
     * instance. The Device instance's properties, and their values, could be, but need not be, the
     * same as those described in an associated DeviceDefinition.
     */
    public var `property`: MutableList<Property.Builder> = mutableListOf()

    /** The designated condition for performing a task with the device. */
    public var mode: CodeableConcept.Builder? = null

    /** The series of occurrences that repeats during the operation of the device. */
    public var cycle: Count.Builder? = null

    /** A measurement of time during the device's operation (e.g., days, hours, mins, etc.). */
    public var duration: Duration.Builder? = null

    /**
     * An organization that is responsible for the provision and ongoing maintenance of the device.
     */
    public var owner: Reference.Builder? = null

    /**
     * Contact details for an organization or a particular human that is responsible for the device.
     *
     * used for troubleshooting etc.
     */
    public var contact: MutableList<ContactPoint.Builder> = mutableListOf()

    /** The place where the device can be found. */
    public var location: Reference.Builder? = null

    /**
     * A network address on which the device may be contacted directly.
     *
     * If the device is running a FHIR server, the network address should be the Base URL from which
     * a conformance statement may be retrieved.
     */
    public var url: Uri.Builder? = null

    /**
     * Technical endpoints providing access to services provided by the device defined at this
     * resource.
     */
    public var endpoint: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The linked device acting as a communication controller, data collector, translator, or
     * concentrator for the current device (e.g., mobile phone application that relays a blood
     * pressure device's data).
     *
     * The Device.gateway may be used when the Device being referenced has a gateway and/or to
     * capture one or more gateways associated with the device. If the Gateway is included in the
     * Observation resource, the Observation.gatewayDevice should be used instead.
     */
    public var gateway: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * Descriptive information, usage information or implantation information that is not captured
     * in an existing element.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Provides additional safety characteristics about a medical device. For example devices
     * containing latex.
     */
    public var safety: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The higher level or encompassing device that this device is a logical part of.
     *
     * For example a vital signs monitor (parent) where three separate modules can be plugged into
     * such as interchangeable blood pressure, oximeter, temperature modules. These modules are
     * represented as devices with the .parent valued to the vital signs monitor when plugged in.
     */
    public var parent: Reference.Builder? = null

    override fun build(): Device =
      Device(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        displayName = displayName?.build(),
        definition = definition?.build(),
        udiCarrier = udiCarrier.map { it.build() },
        status = status,
        availabilityStatus = availabilityStatus?.build(),
        biologicalSourceEvent = biologicalSourceEvent?.build(),
        manufacturer = manufacturer?.build(),
        manufactureDate = manufactureDate?.build(),
        expirationDate = expirationDate?.build(),
        lotNumber = lotNumber?.build(),
        serialNumber = serialNumber?.build(),
        name = name.map { it.build() },
        modelNumber = modelNumber?.build(),
        partNumber = partNumber?.build(),
        category = category.map { it.build() },
        type = type.map { it.build() },
        version = version.map { it.build() },
        conformsTo = conformsTo.map { it.build() },
        `property` = `property`.map { it.build() },
        mode = mode?.build(),
        cycle = cycle?.build(),
        duration = duration?.build(),
        owner = owner?.build(),
        contact = contact.map { it.build() },
        location = location?.build(),
        url = url?.build(),
        endpoint = endpoint.map { it.build() },
        gateway = gateway.map { it.build() },
        note = note.map { it.build() },
        safety = safety.map { it.build() },
        parent = parent?.build(),
      )
  }

  /** Codes to identify how UDI data was entered. */
  public enum class UDIEntryType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Barcode("barcode", "http://hl7.org/fhir/udi-entry-type", "Barcode"),
    Rfid("rfid", "http://hl7.org/fhir/udi-entry-type", "RFID"),
    Manual("manual", "http://hl7.org/fhir/udi-entry-type", "Manual"),
    Card("card", "http://hl7.org/fhir/udi-entry-type", "Card"),
    Self_Reported("self-reported", "http://hl7.org/fhir/udi-entry-type", "Self Reported"),
    Electronic_Transmission(
      "electronic-transmission",
      "http://hl7.org/fhir/udi-entry-type",
      "Electronic Transmission",
    ),
    Unknown("unknown", "http://hl7.org/fhir/udi-entry-type", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): UDIEntryType =
        when (code) {
          "barcode" -> Barcode
          "rfid" -> Rfid
          "manual" -> Manual
          "card" -> Card
          "self-reported" -> Self_Reported
          "electronic-transmission" -> Electronic_Transmission
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum UDIEntryType")
        }
    }
  }

  /** The type of name the device is referred by. */
  public enum class DeviceNameType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Registered_Name("registered-name", "http://hl7.org/fhir/device-nametype", "Registered name"),
    User_Friendly_Name(
      "user-friendly-name",
      "http://hl7.org/fhir/device-nametype",
      "User Friendly name",
    ),
    Patient_Reported_Name(
      "patient-reported-name",
      "http://hl7.org/fhir/device-nametype",
      "Patient Reported name",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DeviceNameType =
        when (code) {
          "registered-name" -> Registered_Name
          "user-friendly-name" -> User_Friendly_Name
          "patient-reported-name" -> Patient_Reported_Name
          else -> throw IllegalArgumentException("Unknown code $code for enum DeviceNameType")
        }
    }
  }

  /** The status of the Device record. */
  public enum class FHIRDeviceStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Active("active", "http://hl7.org/fhir/device-status", "Active"),
    Inactive("inactive", "http://hl7.org/fhir/device-status", "Inactive"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/device-status", "Entered in Error");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): FHIRDeviceStatus =
        when (code) {
          "active" -> Active
          "inactive" -> Inactive
          "entered-in-error" -> Entered_In_Error
          else -> throw IllegalArgumentException("Unknown code $code for enum FHIRDeviceStatus")
        }
    }
  }
}

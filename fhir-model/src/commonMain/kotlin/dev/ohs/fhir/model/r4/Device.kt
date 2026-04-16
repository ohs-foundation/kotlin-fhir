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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.DeviceDeviceNameSerializer
import dev.ohs.fhir.model.r4.serializers.DevicePropertySerializer
import dev.ohs.fhir.model.r4.serializers.DeviceSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceSpecializationSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceUdiCarrierSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceVersionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A type of a manufactured item that is used in the provision of healthcare without being
 * substantially changed through that activity. The device may be a medical or non-medical device.
 */
@Serializable(with = DeviceSerializer::class)
@SerialName("Device")
public data class Device(
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
  /**
   * Unique instance identifiers assigned to a device by manufacturers other organizations or
   * owners.
   *
   * The barcode string from a barcode present on a device label or package may identify the
   * instance, include names given to the device in local usage, or may identify the type of device.
   * If the identifier identifies the type of device, Device.type element should be used.
   */
  public val identifier: List<Identifier> = listOf(),
  /** The reference to the definition for the device. */
  public val definition: Reference? = null,
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
  /**
   * Status of the Device availability.
   *
   * This element is labeled as a modifier because the status contains the codes inactive and
   * entered-in-error that mark the device (record)as not currently valid.
   */
  public val status: Enumeration<FHIRDeviceStatus>? = null,
  /** Reason for the dtatus of the Device availability. */
  public val statusReason: List<CodeableConcept> = listOf(),
  /**
   * The distinct identification string as required by regulation for a human cell, tissue, or
   * cellular and tissue-based product.
   *
   * For example, this applies to devices in the United States regulated under *Code of Federal
   * Regulation 21CFR§1271.290(c)*.
   */
  public val distinctIdentifier: String? = null,
  /** A name of the manufacturer. */
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
   * Alphanumeric Maximum 20.
   */
  public val serialNumber: String? = null,
  /**
   * This represents the manufacturer's name of the device as provided by the device, from a UDI
   * label, or by a person describing the Device. This typically would be used when a person
   * provides the name(s) or when the device represents one of the names available from
   * DeviceDefinition.
   */
  public val deviceName: List<DeviceName> = listOf(),
  /** The model number for the device. */
  public val modelNumber: String? = null,
  /**
   * The part number of the device.
   *
   * Alphanumeric Maximum 20.
   */
  public val partNumber: String? = null,
  /** The kind or type of device. */
  public val type: CodeableConcept? = null,
  /**
   * The capabilities supported on a device, the standards to which the device conforms for a
   * particular purpose, and used for the communication.
   */
  public val specialization: List<Specialization> = listOf(),
  /** The actual design of the device or software version running on the device. */
  public val version: List<Version> = listOf(),
  /**
   * The actual configuration settings of a device as it actually operates, e.g., regulation status,
   * time properties.
   */
  public val `property`: List<Property> = listOf(),
  /** Patient information, If the device is affixed to a person. */
  public val patient: Reference? = null,
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
   * Descriptive information, usage information or implantation information that is not captured in
   * an existing element.
   */
  public val note: List<Annotation> = listOf(),
  /**
   * Provides additional safety characteristics about a medical device. For example devices
   * containing latex.
   */
  public val safety: List<CodeableConcept> = listOf(),
  /** The parent device. */
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
        definition = this@with.definition?.toBuilder()
        udiCarrier = this@with.udiCarrier.map { it.toBuilder() }.toMutableList()
        status = this@with.status
        statusReason = this@with.statusReason.map { it.toBuilder() }.toMutableList()
        distinctIdentifier = this@with.distinctIdentifier?.toBuilder()
        manufacturer = this@with.manufacturer?.toBuilder()
        manufactureDate = this@with.manufactureDate?.toBuilder()
        expirationDate = this@with.expirationDate?.toBuilder()
        lotNumber = this@with.lotNumber?.toBuilder()
        serialNumber = this@with.serialNumber?.toBuilder()
        deviceName = this@with.deviceName.map { it.toBuilder() }.toMutableList()
        modelNumber = this@with.modelNumber?.toBuilder()
        partNumber = this@with.partNumber?.toBuilder()
        type = this@with.type?.toBuilder()
        specialization = this@with.specialization.map { it.toBuilder() }.toMutableList()
        version = this@with.version.map { it.toBuilder() }.toMutableList()
        `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
        patient = this@with.patient?.toBuilder()
        owner = this@with.owner?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        location = this@with.location?.toBuilder()
        url = this@with.url?.toBuilder()
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
     * The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the labeler
     * and the specific version or model of a device.
     */
    public val deviceIdentifier: String? = null,
    /**
     * Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers
     * include :
     * 1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di,
     * 2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-dI,
     * 3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di,
     * 4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di.
     */
    public val issuer: Uri? = null,
    /**
     * The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs
     * are globally unique within a single namespace with the appropriate repository uri as the
     * system. For example, UDIs of devices managed in the U.S. by the FDA, the value is
     * http://hl7.org/fhir/NamingSystem/fda-udi.
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
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          deviceIdentifier = this@with.deviceIdentifier?.toBuilder()
          issuer = this@with.issuer?.toBuilder()
          jurisdiction = this@with.jurisdiction?.toBuilder()
          carrierAIDC = this@with.carrierAIDC?.toBuilder()
          carrierHRF = this@with.carrierHRF?.toBuilder()
          entryType = this@with.entryType
        }
      }

    public class Builder() {
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
       * The device identifier (DI) is a mandatory, fixed portion of a UDI that identifies the
       * labeler and the specific version or model of a device.
       */
      public var deviceIdentifier: String.Builder? = null

      /**
       * Organization that is charged with issuing UDIs for devices. For example, the US FDA issuers
       * include :
       * 1) GS1: http://hl7.org/fhir/NamingSystem/gs1-di,
       * 2) HIBCC: http://hl7.org/fhir/NamingSystem/hibcc-dI,
       * 3) ICCBBA for blood containers: http://hl7.org/fhir/NamingSystem/iccbba-blood-di,
       * 4) ICCBA for other devices: http://hl7.org/fhir/NamingSystem/iccbba-other-di.
       */
      public var issuer: Uri.Builder? = null

      /**
       * The identity of the authoritative source for UDI generation within a jurisdiction. All UDIs
       * are globally unique within a single namespace with the appropriate repository uri as the
       * system. For example, UDIs of devices managed in the U.S. by the FDA, the value is
       * http://hl7.org/fhir/NamingSystem/fda-udi.
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
          deviceIdentifier = deviceIdentifier?.build(),
          issuer = issuer?.build(),
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
  @Serializable(with = DeviceDeviceNameSerializer::class)
  public data class DeviceName(
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
    /** The name of the device. */
    public val name: String,
    /**
     * The type of deviceName. UDILabelName | UserFriendlyName | PatientReportedName |
     * ManufactureDeviceName | ModelName.
     */
    public val type: Enumeration<DeviceNameType>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(name.toBuilder(), type).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** The name of the device. */
      public var name: String.Builder,
      /**
       * The type of deviceName. UDILabelName | UserFriendlyName | PatientReportedName |
       * ManufactureDeviceName | ModelName.
       */
      public var type: Enumeration<DeviceNameType>,
    ) {
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

      public fun build(): DeviceName =
        DeviceName(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name.build(),
          type = type,
        )
    }
  }

  /**
   * The capabilities supported on a device, the standards to which the device conforms for a
   * particular purpose, and used for the communication.
   */
  @Serializable(with = DeviceSpecializationSerializer::class)
  public data class Specialization(
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
    /** The standard that is used to operate and communicate. */
    public val systemType: CodeableConcept,
    /** The version of the standard that is used to operate and communicate. */
    public val version: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(systemType.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          version = this@with.version?.toBuilder()
        }
      }

    public class Builder(
      /** The standard that is used to operate and communicate. */
      public var systemType: CodeableConcept.Builder
    ) {
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

      /** The version of the standard that is used to operate and communicate. */
      public var version: String.Builder? = null

      public fun build(): Specialization =
        Specialization(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          systemType = systemType.build(),
          version = version?.build(),
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
    /** The type of the device version. */
    public val type: CodeableConcept? = null,
    /** A single component of the device version. */
    public val component: Identifier? = null,
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

      /** The type of the device version. */
      public var type: CodeableConcept.Builder? = null

      /** A single component of the device version. */
      public var component: Identifier.Builder? = null

      public fun build(): Version =
        Version(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          component = component?.build(),
          `value` = `value`.build(),
        )
    }
  }

  /**
   * The actual configuration settings of a device as it actually operates, e.g., regulation status,
   * time properties.
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
    /** Code that specifies the property DeviceDefinitionPropetyCode (Extensible). */
    public val type: CodeableConcept,
    /** Property value as a quantity. */
    public val valueQuantity: List<Quantity> = listOf(),
    /** Property value as a code, e.g., NTP4 (synced to NTP). */
    public val valueCode: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          valueQuantity = this@with.valueQuantity.map { it.toBuilder() }.toMutableList()
          valueCode = this@with.valueCode.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** Code that specifies the property DeviceDefinitionPropetyCode (Extensible). */
      public var type: CodeableConcept.Builder
    ) {
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

      /** Property value as a quantity. */
      public var valueQuantity: MutableList<Quantity.Builder> = mutableListOf()

      /** Property value as a code, e.g., NTP4 (synced to NTP). */
      public var valueCode: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Property =
        Property(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          valueQuantity = valueQuantity.map { it.build() },
          valueCode = valueCode.map { it.build() },
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

    /**
     * Unique instance identifiers assigned to a device by manufacturers other organizations or
     * owners.
     *
     * The barcode string from a barcode present on a device label or package may identify the
     * instance, include names given to the device in local usage, or may identify the type of
     * device. If the identifier identifies the type of device, Device.type element should be used.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** The reference to the definition for the device. */
    public var definition: Reference.Builder? = null

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

    /**
     * Status of the Device availability.
     *
     * This element is labeled as a modifier because the status contains the codes inactive and
     * entered-in-error that mark the device (record)as not currently valid.
     */
    public var status: Enumeration<FHIRDeviceStatus>? = null

    /** Reason for the dtatus of the Device availability. */
    public var statusReason: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The distinct identification string as required by regulation for a human cell, tissue, or
     * cellular and tissue-based product.
     *
     * For example, this applies to devices in the United States regulated under *Code of Federal
     * Regulation 21CFR§1271.290(c)*.
     */
    public var distinctIdentifier: String.Builder? = null

    /** A name of the manufacturer. */
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
     * Alphanumeric Maximum 20.
     */
    public var serialNumber: String.Builder? = null

    /**
     * This represents the manufacturer's name of the device as provided by the device, from a UDI
     * label, or by a person describing the Device. This typically would be used when a person
     * provides the name(s) or when the device represents one of the names available from
     * DeviceDefinition.
     */
    public var deviceName: MutableList<DeviceName.Builder> = mutableListOf()

    /** The model number for the device. */
    public var modelNumber: String.Builder? = null

    /**
     * The part number of the device.
     *
     * Alphanumeric Maximum 20.
     */
    public var partNumber: String.Builder? = null

    /** The kind or type of device. */
    public var type: CodeableConcept.Builder? = null

    /**
     * The capabilities supported on a device, the standards to which the device conforms for a
     * particular purpose, and used for the communication.
     */
    public var specialization: MutableList<Specialization.Builder> = mutableListOf()

    /** The actual design of the device or software version running on the device. */
    public var version: MutableList<Version.Builder> = mutableListOf()

    /**
     * The actual configuration settings of a device as it actually operates, e.g., regulation
     * status, time properties.
     */
    public var `property`: MutableList<Property.Builder> = mutableListOf()

    /** Patient information, If the device is affixed to a person. */
    public var patient: Reference.Builder? = null

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
     * Descriptive information, usage information or implantation information that is not captured
     * in an existing element.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Provides additional safety characteristics about a medical device. For example devices
     * containing latex.
     */
    public var safety: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The parent device. */
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
        definition = definition?.build(),
        udiCarrier = udiCarrier.map { it.build() },
        status = status,
        statusReason = statusReason.map { it.build() },
        distinctIdentifier = distinctIdentifier?.build(),
        manufacturer = manufacturer?.build(),
        manufactureDate = manufactureDate?.build(),
        expirationDate = expirationDate?.build(),
        lotNumber = lotNumber?.build(),
        serialNumber = serialNumber?.build(),
        deviceName = deviceName.map { it.build() },
        modelNumber = modelNumber?.build(),
        partNumber = partNumber?.build(),
        type = type?.build(),
        specialization = specialization.map { it.build() },
        version = version.map { it.build() },
        `property` = `property`.map { it.build() },
        patient = patient?.build(),
        owner = owner?.build(),
        contact = contact.map { it.build() },
        location = location?.build(),
        url = url?.build(),
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
    Udi_Label_Name("udi-label-name", "http://hl7.org/fhir/device-nametype", "UDI Label name"),
    User_Friendly_Name(
      "user-friendly-name",
      "http://hl7.org/fhir/device-nametype",
      "User Friendly name",
    ),
    Patient_Reported_Name(
      "patient-reported-name",
      "http://hl7.org/fhir/device-nametype",
      "Patient Reported name",
    ),
    Manufacturer_Name(
      "manufacturer-name",
      "http://hl7.org/fhir/device-nametype",
      "Manufacturer name",
    ),
    Model_Name("model-name", "http://hl7.org/fhir/device-nametype", "Model name"),
    Other("other", "http://hl7.org/fhir/device-nametype", "other");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DeviceNameType =
        when (code) {
          "udi-label-name" -> Udi_Label_Name
          "user-friendly-name" -> User_Friendly_Name
          "patient-reported-name" -> Patient_Reported_Name
          "manufacturer-name" -> Manufacturer_Name
          "model-name" -> Model_Name
          "other" -> Other
          else -> throw IllegalArgumentException("Unknown code $code for enum DeviceNameType")
        }
    }
  }

  /** The availability status of the device. */
  public enum class FHIRDeviceStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Active("active", "http://hl7.org/fhir/device-status", "Active"),
    Inactive("inactive", "http://hl7.org/fhir/device-status", "Inactive"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/device-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/device-status", "Unknown");

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
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum FHIRDeviceStatus")
        }
    }
  }
}

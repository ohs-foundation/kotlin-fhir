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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionCapabilitySerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionDeviceNameSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionManufacturerSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionMaterialSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionPropertySerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionSpecializationSerializer
import dev.ohs.fhir.model.r4b.serializers.DeviceDefinitionUdiDeviceIdentifierSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The characteristics, operational status and capabilities of a medical-related component of a
 * medical device.
 */
@Serializable(with = DeviceDefinitionSerializer::class)
@SerialName("DeviceDefinition")
public data class DeviceDefinition(
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
   * Unique instance identifiers assigned to a device by the software, manufacturers, other
   * organizations or owners. For example: handle ID.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Unique device identifier (UDI) assigned to device label or package. Note that the Device may
   * include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction
   * it is sold, or for multiple jurisdictions it could have been sold.
   */
  public val udiDeviceIdentifier: List<UdiDeviceIdentifier> = listOf(),
  /** A name of the manufacturer. */
  public val manufacturer: Manufacturer? = null,
  /** A name given to the device to identify it. */
  public val deviceName: List<DeviceName> = listOf(),
  /** The model number for the device. */
  public val modelNumber: String? = null,
  /** What kind of device or device system this is. */
  public val type: CodeableConcept? = null,
  /**
   * The capabilities supported on a device, the standards to which the device conforms for a
   * particular purpose, and used for the communication.
   */
  public val specialization: List<Specialization> = listOf(),
  /** The available versions of the device, e.g., software versions. */
  public val version: List<String> = listOf(),
  /** Safety characteristics of the device. */
  public val safety: List<CodeableConcept> = listOf(),
  /** Shelf Life and storage information. */
  public val shelfLifeStorage: List<ProductShelfLife> = listOf(),
  /** Dimensions, color etc. */
  public val physicalCharacteristics: ProdCharacteristic? = null,
  /** Language code for the human-readable text strings produced by the device (all supported). */
  public val languageCode: List<CodeableConcept> = listOf(),
  /** Device capabilities. */
  public val capability: List<Capability> = listOf(),
  /**
   * The actual configuration settings of a device as it actually operates, e.g., regulation status,
   * time properties.
   */
  public val `property`: List<Property> = listOf(),
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
  /**
   * A network address on which the device may be contacted directly.
   *
   * If the device is running a FHIR server, the network address should be the Base URL from which a
   * conformance statement may be retrieved.
   */
  public val url: Uri? = null,
  /** Access to on-line information about the device. */
  public val onlineInformation: Uri? = null,
  /**
   * Descriptive information, usage information or implantation information that is not captured in
   * an existing element.
   */
  public val note: List<Annotation> = listOf(),
  /**
   * The quantity of the device present in the packaging (e.g. the number of devices present in a
   * pack, or the number of devices in the same package of the medicinal product).
   */
  public val quantity: Quantity? = null,
  /** The parent device it can be part of. */
  public val parentDevice: Reference? = null,
  /** A substance used to create the material(s) of which the device is made. */
  public val material: List<Material> = listOf(),
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
        udiDeviceIdentifier = this@with.udiDeviceIdentifier.map { it.toBuilder() }.toMutableList()
        manufacturer = this@with.manufacturer
        deviceName = this@with.deviceName.map { it.toBuilder() }.toMutableList()
        modelNumber = this@with.modelNumber?.toBuilder()
        type = this@with.type?.toBuilder()
        specialization = this@with.specialization.map { it.toBuilder() }.toMutableList()
        version = this@with.version.map { it.toBuilder() }.toMutableList()
        safety = this@with.safety.map { it.toBuilder() }.toMutableList()
        shelfLifeStorage = this@with.shelfLifeStorage.map { it.toBuilder() }.toMutableList()
        physicalCharacteristics = this@with.physicalCharacteristics?.toBuilder()
        languageCode = this@with.languageCode.map { it.toBuilder() }.toMutableList()
        capability = this@with.capability.map { it.toBuilder() }.toMutableList()
        `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
        owner = this@with.owner?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        url = this@with.url?.toBuilder()
        onlineInformation = this@with.onlineInformation?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        quantity = this@with.quantity?.toBuilder()
        parentDevice = this@with.parentDevice?.toBuilder()
        material = this@with.material.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * Unique device identifier (UDI) assigned to device label or package. Note that the Device may
   * include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction
   * it is sold, or for multiple jurisdictions it could have been sold.
   */
  @Serializable(with = DeviceDefinitionUdiDeviceIdentifierSerializer::class)
  public data class UdiDeviceIdentifier(
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
     * The identifier that is to be associated with every Device that references this
     * DeviceDefintiion for the issuer and jurisdication porvided in the
     * DeviceDefinition.udiDeviceIdentifier.
     */
    public val deviceIdentifier: String,
    /** The organization that assigns the identifier algorithm. */
    public val issuer: Uri,
    /** The jurisdiction to which the deviceIdentifier applies. */
    public val jurisdiction: Uri,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(deviceIdentifier.toBuilder(), issuer.toBuilder(), jurisdiction.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * The identifier that is to be associated with every Device that references this
       * DeviceDefintiion for the issuer and jurisdication porvided in the
       * DeviceDefinition.udiDeviceIdentifier.
       */
      public var deviceIdentifier: String.Builder,
      /** The organization that assigns the identifier algorithm. */
      public var issuer: Uri.Builder,
      /** The jurisdiction to which the deviceIdentifier applies. */
      public var jurisdiction: Uri.Builder,
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

      public fun build(): UdiDeviceIdentifier =
        UdiDeviceIdentifier(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          deviceIdentifier = deviceIdentifier.build(),
          issuer = issuer.build(),
          jurisdiction = jurisdiction.build(),
        )
    }
  }

  /** A name given to the device to identify it. */
  @Serializable(with = DeviceDefinitionDeviceNameSerializer::class)
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
  @Serializable(with = DeviceDefinitionSpecializationSerializer::class)
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
    public val systemType: String,
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
      public var systemType: String.Builder
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

  /** Device capabilities. */
  @Serializable(with = DeviceDefinitionCapabilitySerializer::class)
  public data class Capability(
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
    /** Type of capability. */
    public val type: CodeableConcept,
    /** Description of capability. */
    public val description: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          description = this@with.description.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** Type of capability. */
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

      /** Description of capability. */
      public var description: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Capability =
        Capability(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          description = description.map { it.build() },
        )
    }
  }

  /**
   * The actual configuration settings of a device as it actually operates, e.g., regulation status,
   * time properties.
   */
  @Serializable(with = DeviceDefinitionPropertySerializer::class)
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

  /** A substance used to create the material(s) of which the device is made. */
  @Serializable(with = DeviceDefinitionMaterialSerializer::class)
  public data class Material(
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
    /** The substance. */
    public val substance: CodeableConcept,
    /** Indicates an alternative material of the device. */
    public val alternate: Boolean? = null,
    /** Whether the substance is a known or suspected allergen. */
    public val allergenicIndicator: Boolean? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(substance.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          alternate = this@with.alternate?.toBuilder()
          allergenicIndicator = this@with.allergenicIndicator?.toBuilder()
        }
      }

    public class Builder(
      /** The substance. */
      public var substance: CodeableConcept.Builder
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

      /** Indicates an alternative material of the device. */
      public var alternate: Boolean.Builder? = null

      /** Whether the substance is a known or suspected allergen. */
      public var allergenicIndicator: Boolean.Builder? = null

      public fun build(): Material =
        Material(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          substance = substance.build(),
          alternate = alternate?.build(),
          allergenicIndicator = allergenicIndicator?.build(),
        )
    }
  }

  @Serializable(with = DeviceDefinitionManufacturerSerializer::class)
  public sealed interface Manufacturer {
    public fun asString(): String? = this as? String

    public fun asReference(): Reference? = this as? Reference

    public data class String(public val `value`: dev.ohs.fhir.model.r4b.String) : Manufacturer

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) :
      Manufacturer

    public companion object {
      internal fun from(
        stringValue: dev.ohs.fhir.model.r4b.String?,
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
      ): Manufacturer? {
        if (stringValue != null) return String(stringValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
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
     * Unique instance identifiers assigned to a device by the software, manufacturers, other
     * organizations or owners. For example: handle ID.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Unique device identifier (UDI) assigned to device label or package. Note that the Device may
     * include multiple udiCarriers as it either may include just the udiCarrier for the
     * jurisdiction it is sold, or for multiple jurisdictions it could have been sold.
     */
    public var udiDeviceIdentifier: MutableList<UdiDeviceIdentifier.Builder> = mutableListOf()

    /** A name of the manufacturer. */
    public var manufacturer: Manufacturer? = null

    /** A name given to the device to identify it. */
    public var deviceName: MutableList<DeviceName.Builder> = mutableListOf()

    /** The model number for the device. */
    public var modelNumber: String.Builder? = null

    /** What kind of device or device system this is. */
    public var type: CodeableConcept.Builder? = null

    /**
     * The capabilities supported on a device, the standards to which the device conforms for a
     * particular purpose, and used for the communication.
     */
    public var specialization: MutableList<Specialization.Builder> = mutableListOf()

    /** The available versions of the device, e.g., software versions. */
    public var version: MutableList<String.Builder> = mutableListOf()

    /** Safety characteristics of the device. */
    public var safety: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Shelf Life and storage information. */
    public var shelfLifeStorage: MutableList<ProductShelfLife.Builder> = mutableListOf()

    /** Dimensions, color etc. */
    public var physicalCharacteristics: ProdCharacteristic.Builder? = null

    /** Language code for the human-readable text strings produced by the device (all supported). */
    public var languageCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Device capabilities. */
    public var capability: MutableList<Capability.Builder> = mutableListOf()

    /**
     * The actual configuration settings of a device as it actually operates, e.g., regulation
     * status, time properties.
     */
    public var `property`: MutableList<Property.Builder> = mutableListOf()

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

    /**
     * A network address on which the device may be contacted directly.
     *
     * If the device is running a FHIR server, the network address should be the Base URL from which
     * a conformance statement may be retrieved.
     */
    public var url: Uri.Builder? = null

    /** Access to on-line information about the device. */
    public var onlineInformation: Uri.Builder? = null

    /**
     * Descriptive information, usage information or implantation information that is not captured
     * in an existing element.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * The quantity of the device present in the packaging (e.g. the number of devices present in a
     * pack, or the number of devices in the same package of the medicinal product).
     */
    public var quantity: Quantity.Builder? = null

    /** The parent device it can be part of. */
    public var parentDevice: Reference.Builder? = null

    /** A substance used to create the material(s) of which the device is made. */
    public var material: MutableList<Material.Builder> = mutableListOf()

    override fun build(): DeviceDefinition =
      DeviceDefinition(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        udiDeviceIdentifier = udiDeviceIdentifier.map { it.build() },
        manufacturer = manufacturer,
        deviceName = deviceName.map { it.build() },
        modelNumber = modelNumber?.build(),
        type = type?.build(),
        specialization = specialization.map { it.build() },
        version = version.map { it.build() },
        safety = safety.map { it.build() },
        shelfLifeStorage = shelfLifeStorage.map { it.build() },
        physicalCharacteristics = physicalCharacteristics?.build(),
        languageCode = languageCode.map { it.build() },
        capability = capability.map { it.build() },
        `property` = `property`.map { it.build() },
        owner = owner?.build(),
        contact = contact.map { it.build() },
        url = url?.build(),
        onlineInformation = onlineInformation?.build(),
        note = note.map { it.build() },
        quantity = quantity?.build(),
        parentDevice = parentDevice?.build(),
        material = material.map { it.build() },
      )
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
}

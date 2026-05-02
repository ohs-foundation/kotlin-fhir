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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionChargeItemSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionClassificationSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionConformsToSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionCorrectiveActionSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionDeviceNameSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionGuidelineSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionHasPartSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionLinkSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionMaterialSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionPackagingDistributorSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionPackagingSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionPropertySerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionPropertyValueSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionRegulatoryIdentifierSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionUdiDeviceIdentifierSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceDefinitionVersionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** This is a specialized resource that defines the characteristics and capabilities of a device. */
@Serializable(with = DeviceDefinitionSerializer::class)
@SerialName("DeviceDefinition")
public data class DeviceDefinition(
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
  /** Additional information to describe the device. */
  public val description: Markdown? = null,
  /**
   * Unique instance identifiers assigned to a device by the software, manufacturers, other
   * organizations or owners. For example: handle ID. The identifier is typically valued if the
   * udiDeviceIdentifier, partNumber or modelNumber is not valued and represents a different type of
   * identifier. However, it is permissible to still include those identifiers in
   * DeviceDefinition.identifier with the appropriate identifier.type.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Unique device identifier (UDI) assigned to device label or package. Note that the Device may
   * include multiple udiCarriers as it either may include just the udiCarrier for the jurisdiction
   * it is sold, or for multiple jurisdictions it could have been sold.
   */
  public val udiDeviceIdentifier: List<UdiDeviceIdentifier> = listOf(),
  /**
   * Identifier associated with the regulatory documentation (certificates, technical documentation,
   * post-market surveillance documentation and reports) of a set of device models sharing the same
   * intended purpose, risk class and essential design and manufacturing characteristics. One
   * example is the Basic UDI-DI in Europe.
   *
   * This should not be used for regulatory authorization numbers which are to be captured
   * elsewhere.
   */
  public val regulatoryIdentifier: List<RegulatoryIdentifier> = listOf(),
  /**
   * The part number or catalog number of the device.
   *
   * Alphanumeric Maximum 20.
   */
  public val partNumber: String? = null,
  /**
   * A name of the manufacturer or legal representative e.g. labeler. Whether this is the actual
   * manufacturer or the labeler or responsible depends on implementation and jurisdiction.
   */
  public val manufacturer: Reference? = null,
  /** The name or names of the device as given by the manufacturer. */
  public val deviceName: List<DeviceName> = listOf(),
  /**
   * The model number for the device for example as defined by the manufacturer or labeler, or other
   * agency.
   */
  public val modelNumber: String? = null,
  /**
   * What kind of device or device system this is.
   *
   * In this element various classifications can be used, such as GMDN, EMDN, SNOMED CT, risk
   * classes, national product codes.
   */
  public val classification: List<Classification> = listOf(),
  /**
   * Identifies the standards, specifications, or formal guidances for the capabilities supported by
   * the device. The device may be certified as conformant to these specifications e.g.,
   * communication, performance, process, measurement, or specialization standards.
   */
  public val conformsTo: List<ConformsTo> = listOf(),
  /** A device that is part (for example a component) of the present device. */
  public val hasPart: List<HasPart> = listOf(),
  /** Information about the packaging of the device, i.e. how the device is packaged. */
  public val packaging: List<Packaging> = listOf(),
  /** The version of the device or software. */
  public val version: List<Version> = listOf(),
  /** Safety characteristics of the device. */
  public val safety: List<CodeableConcept> = listOf(),
  /** Shelf Life and storage information. */
  public val shelfLifeStorage: List<ProductShelfLife> = listOf(),
  /** Language code for the human-readable text strings produced by the device (all supported). */
  public val languageCode: List<CodeableConcept> = listOf(),
  /**
   * Static or essentially fixed characteristics or features of this kind of device that are
   * otherwise not captured in more specific attributes, e.g., time or timing attributes,
   * resolution, accuracy, and physical attributes.
   *
   * Dynamic or current properties, such as settings, of an individual device are described using a
   * Device instance-specific DeviceMetric and recorded using Observation. Static characteristics of
   * an individual device could also be documented in a [Device] instance. The Device instance's
   * properties, and their values, could be, but need not be, the same as in the associated
   * DeviceDefinition.
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
   * An associated device, attached to, used with, communicating with or linking a previous or new
   * device model to the focal device.
   */
  public val link: List<Link> = listOf(),
  /**
   * Descriptive information, usage information or implantation information that is not captured in
   * an existing element.
   */
  public val note: List<Annotation> = listOf(),
  /** A substance used to create the material(s) of which the device is made. */
  public val material: List<Material> = listOf(),
  /**
   * Indicates the production identifier(s) that are expected to appear in the UDI carrier on the
   * device label.
   */
  public val productionIdentifierInUDI: List<Enumeration<DeviceProductionIdentifierInUDI>> =
    listOf(),
  /**
   * Information aimed at providing directions for the usage of this model of device.
   *
   * For more structured data, a ClinicalUseDefinition that points to the DeviceDefinition can be
   * used.
   */
  public val guideline: Guideline? = null,
  /** Tracking of latest field safety corrective action. */
  public val correctiveAction: CorrectiveAction? = null,
  /** Billing code or reference associated with the device. */
  public val chargeItem: List<ChargeItem> = listOf(),
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
        description = this@with.description?.toBuilder()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        udiDeviceIdentifier = this@with.udiDeviceIdentifier.map { it.toBuilder() }.toMutableList()
        regulatoryIdentifier = this@with.regulatoryIdentifier.map { it.toBuilder() }.toMutableList()
        partNumber = this@with.partNumber?.toBuilder()
        manufacturer = this@with.manufacturer?.toBuilder()
        deviceName = this@with.deviceName.map { it.toBuilder() }.toMutableList()
        modelNumber = this@with.modelNumber?.toBuilder()
        classification = this@with.classification.map { it.toBuilder() }.toMutableList()
        conformsTo = this@with.conformsTo.map { it.toBuilder() }.toMutableList()
        hasPart = this@with.hasPart.map { it.toBuilder() }.toMutableList()
        packaging = this@with.packaging.map { it.toBuilder() }.toMutableList()
        version = this@with.version.map { it.toBuilder() }.toMutableList()
        safety = this@with.safety.map { it.toBuilder() }.toMutableList()
        shelfLifeStorage = this@with.shelfLifeStorage.map { it.toBuilder() }.toMutableList()
        languageCode = this@with.languageCode.map { it.toBuilder() }.toMutableList()
        `property` = this@with.`property`.map { it.toBuilder() }.toMutableList()
        owner = this@with.owner?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        link = this@with.link.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        material = this@with.material.map { it.toBuilder() }.toMutableList()
        productionIdentifierInUDI = this@with.productionIdentifierInUDI.toMutableList()
        guideline = this@with.guideline?.toBuilder()
        correctiveAction = this@with.correctiveAction?.toBuilder()
        chargeItem = this@with.chargeItem.map { it.toBuilder() }.toMutableList()
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
     * The identifier that is to be associated with every Device that references this
     * DeviceDefintiion for the issuer and jurisdiction provided in the
     * DeviceDefinition.udiDeviceIdentifier.
     */
    public val deviceIdentifier: String,
    /** The organization that assigns the identifier algorithm. */
    public val issuer: Uri,
    /** The jurisdiction to which the deviceIdentifier applies. */
    public val jurisdiction: Uri,
    /** Indicates where and when the device is available on the market. */
    public val marketDistribution: List<MarketDistribution> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(deviceIdentifier.toBuilder(), issuer.toBuilder(), jurisdiction.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          marketDistribution = this@with.marketDistribution.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Indicates where and when the device is available on the market. */
    @Serializable(with = DeviceDefinitionUdiDeviceIdentifierMarketDistributionSerializer::class)
    public data class MarketDistribution(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** Begin and end dates for the commercial distribution of the device. */
      public val marketPeriod: Period,
      /**
       * National state or territory to which the marketDistribution recers, typically where the
       * device is commercialized.
       */
      public val subJurisdiction: Uri,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(marketPeriod.toBuilder(), subJurisdiction.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** Begin and end dates for the commercial distribution of the device. */
        public var marketPeriod: Period.Builder,
        /**
         * National state or territory to which the marketDistribution recers, typically where the
         * device is commercialized.
         */
        public var subJurisdiction: Uri.Builder,
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        public fun build(): MarketDistribution =
          MarketDistribution(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            marketPeriod = marketPeriod.build(),
            subJurisdiction = subJurisdiction.build(),
          )
      }
    }

    public class Builder(
      /**
       * The identifier that is to be associated with every Device that references this
       * DeviceDefintiion for the issuer and jurisdiction provided in the
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

      /** Indicates where and when the device is available on the market. */
      public var marketDistribution: MutableList<MarketDistribution.Builder> = mutableListOf()

      public fun build(): UdiDeviceIdentifier =
        UdiDeviceIdentifier(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          deviceIdentifier = deviceIdentifier.build(),
          issuer = issuer.build(),
          jurisdiction = jurisdiction.build(),
          marketDistribution = marketDistribution.map { it.build() },
        )
    }
  }

  /**
   * Identifier associated with the regulatory documentation (certificates, technical documentation,
   * post-market surveillance documentation and reports) of a set of device models sharing the same
   * intended purpose, risk class and essential design and manufacturing characteristics. One
   * example is the Basic UDI-DI in Europe.
   */
  @Serializable(with = DeviceDefinitionRegulatoryIdentifierSerializer::class)
  public data class RegulatoryIdentifier(
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
    /** The type of identifier itself. */
    public val type: Enumeration<DeviceDefinitionRegulatoryIdentifierType>,
    /** The identifier itself. */
    public val deviceIdentifier: String,
    /** The organization that issued this identifier. */
    public val issuer: Uri,
    /** The jurisdiction to which the deviceIdentifier applies. */
    public val jurisdiction: Uri,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type, deviceIdentifier.toBuilder(), issuer.toBuilder(), jurisdiction.toBuilder())
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
      }

    public class Builder(
      /** The type of identifier itself. */
      public var type: Enumeration<DeviceDefinitionRegulatoryIdentifierType>,
      /** The identifier itself. */
      public var deviceIdentifier: String.Builder,
      /** The organization that issued this identifier. */
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

      public fun build(): RegulatoryIdentifier =
        RegulatoryIdentifier(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type,
          deviceIdentifier = deviceIdentifier.build(),
          issuer = issuer.build(),
          jurisdiction = jurisdiction.build(),
        )
    }
  }

  /** The name or names of the device as given by the manufacturer. */
  @Serializable(with = DeviceDefinitionDeviceNameSerializer::class)
  public data class DeviceName(
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
     * A human-friendly name that is used to refer to the device - depending on the type, it can be
     * the brand name, the common name or alias, or other.
     */
    public val name: String,
    /** The type of deviceName. RegisteredName | UserFriendlyName | PatientReportedName. */
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
      /**
       * A human-friendly name that is used to refer to the device - depending on the type, it can
       * be the brand name, the common name or alias, or other.
       */
      public var name: String.Builder,
      /** The type of deviceName. RegisteredName | UserFriendlyName | PatientReportedName. */
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

  /** What kind of device or device system this is. */
  @Serializable(with = DeviceDefinitionClassificationSerializer::class)
  public data class Classification(
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
    /** A classification or risk class of the device model. */
    public val type: CodeableConcept,
    /** Further information qualifying this classification of the device model. */
    public val justification: List<RelatedArtifact> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          justification = this@with.justification.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** A classification or risk class of the device model. */
      public var type: CodeableConcept.Builder
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

      /** Further information qualifying this classification of the device model. */
      public var justification: MutableList<RelatedArtifact.Builder> = mutableListOf()

      public fun build(): Classification =
        Classification(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.build(),
          justification = justification.map { it.build() },
        )
    }
  }

  /**
   * Identifies the standards, specifications, or formal guidances for the capabilities supported by
   * the device. The device may be certified as conformant to these specifications e.g.,
   * communication, performance, process, measurement, or specialization standards.
   */
  @Serializable(with = DeviceDefinitionConformsToSerializer::class)
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
    public val version: List<String> = listOf(),
    /**
     * Standard, regulation, certification, or guidance website, document, or other publication, or
     * similar, supporting the conformance.
     */
    public val source: List<RelatedArtifact> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(specification.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          category = this@with.category?.toBuilder()
          version = this@with.version.map { it.toBuilder() }.toMutableList()
          source = this@with.source.map { it.toBuilder() }.toMutableList()
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
      public var version: MutableList<String.Builder> = mutableListOf()

      /**
       * Standard, regulation, certification, or guidance website, document, or other publication,
       * or similar, supporting the conformance.
       */
      public var source: MutableList<RelatedArtifact.Builder> = mutableListOf()

      public fun build(): ConformsTo =
        ConformsTo(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          category = category?.build(),
          specification = specification.build(),
          version = version.map { it.build() },
          source = source.map { it.build() },
        )
    }
  }

  /** A device that is part (for example a component) of the present device. */
  @Serializable(with = DeviceDefinitionHasPartSerializer::class)
  public data class HasPart(
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
    /** Reference to the device that is part of the current device. */
    public val reference: Reference,
    /** Number of instances of the component device in the current device. */
    public val count: Integer? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(reference.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          count = this@with.count?.toBuilder()
        }
      }

    public class Builder(
      /** Reference to the device that is part of the current device. */
      public var reference: Reference.Builder
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

      /** Number of instances of the component device in the current device. */
      public var count: Integer.Builder? = null

      public fun build(): HasPart =
        HasPart(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          reference = reference.build(),
          count = count?.build(),
        )
    }
  }

  /** Information about the packaging of the device, i.e. how the device is packaged. */
  @Serializable(with = DeviceDefinitionPackagingSerializer::class)
  public data class Packaging(
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
    /** The business identifier of the packaged medication. */
    public val identifier: Identifier? = null,
    /** A code that defines the specific type of packaging. */
    public val type: CodeableConcept? = null,
    /** The number of items contained in the package (devices or sub-packages). */
    public val count: Integer? = null,
    /** An organization that distributes the packaged device. */
    public val distributor: List<Distributor> = listOf(),
    /** Unique Device Identifier (UDI) Barcode string on the packaging. */
    public val udiDeviceIdentifier: List<UdiDeviceIdentifier> = listOf(),
    /** Allows packages within packages. */
    public val packaging: List<Packaging> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier?.toBuilder()
          type = this@with.type?.toBuilder()
          count = this@with.count?.toBuilder()
          distributor = this@with.distributor.map { it.toBuilder() }.toMutableList()
          udiDeviceIdentifier = this@with.udiDeviceIdentifier.map { it.toBuilder() }.toMutableList()
          packaging = this@with.packaging.map { it.toBuilder() }.toMutableList()
        }
      }

    /** An organization that distributes the packaged device. */
    @Serializable(with = DeviceDefinitionPackagingDistributorSerializer::class)
    public data class Distributor(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** Distributor's human-readable name. */
      public val name: String? = null,
      /** Distributor as an Organization resource. */
      public val organizationReference: List<Reference> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            name = this@with.name?.toBuilder()
            organizationReference =
              this@with.organizationReference.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** Distributor's human-readable name. */
        public var name: String.Builder? = null

        /** Distributor as an Organization resource. */
        public var organizationReference: MutableList<Reference.Builder> = mutableListOf()

        public fun build(): Distributor =
          Distributor(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            name = name?.build(),
            organizationReference = organizationReference.map { it.build() },
          )
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

      /** The business identifier of the packaged medication. */
      public var identifier: Identifier.Builder? = null

      /** A code that defines the specific type of packaging. */
      public var type: CodeableConcept.Builder? = null

      /** The number of items contained in the package (devices or sub-packages). */
      public var count: Integer.Builder? = null

      /** An organization that distributes the packaged device. */
      public var distributor: MutableList<Distributor.Builder> = mutableListOf()

      /** Unique Device Identifier (UDI) Barcode string on the packaging. */
      public var udiDeviceIdentifier: MutableList<UdiDeviceIdentifier.Builder> = mutableListOf()

      /** Allows packages within packages. */
      public var packaging: MutableList<Builder> = mutableListOf()

      public fun build(): Packaging =
        Packaging(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier?.build(),
          type = type?.build(),
          count = count?.build(),
          distributor = distributor.map { it.build() },
          udiDeviceIdentifier = udiDeviceIdentifier.map { it.build() },
          packaging = packaging.map { it.build() },
        )
    }
  }

  /** The version of the device or software. */
  @Serializable(with = DeviceDefinitionVersionSerializer::class)
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
   * Static or essentially fixed characteristics or features of this kind of device that are
   * otherwise not captured in more specific attributes, e.g., time or timing attributes,
   * resolution, accuracy, and physical attributes.
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
    /** Code that specifies the property such as a resolution or color being represented. */
    public val type: CodeableConcept,
    /**
     * The value of the property specified by the associated property.type code.
     *
     * This use of string or CodeableConcept is supported to address different purposes The text
     * element of the valueCodeableConcept choice type is used for properties which would usually be
     * coded (such as the size of an implant, or a security classification) but for which there is
     * not currently an appropriate concept in the vocabulary (e.g., a custom implant size, or a
     * security classification which depends on configuration. Otherwise the valueString choice type
     * is used for textual descriptive device properties that cannot be expressed in other elements.
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

    @Serializable(with = DeviceDefinitionPropertyValueSerializer::class)
    public sealed interface Value {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asString(): String? = this as? String

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asInteger(): Integer? = this as? Integer

      public fun asRange(): Range? = this as? Range

      public fun asAttachment(): Attachment? = this as? Attachment

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Value

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Value

      public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public data class Integer(public val `value`: dev.ohs.fhir.model.r5.Integer) : Value

      public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

      public data class Attachment(public val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

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
      /** Code that specifies the property such as a resolution or color being represented. */
      public var type: CodeableConcept.Builder,
      /**
       * The value of the property specified by the associated property.type code.
       *
       * This use of string or CodeableConcept is supported to address different purposes The text
       * element of the valueCodeableConcept choice type is used for properties which would usually
       * be coded (such as the size of an implant, or a security classification) but for which there
       * is not currently an appropriate concept in the vocabulary (e.g., a custom implant size, or
       * a security classification which depends on configuration. Otherwise the valueString choice
       * type is used for textual descriptive device properties that cannot be expressed in other
       * elements.
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

  /**
   * An associated device, attached to, used with, communicating with or linking a previous or new
   * device model to the focal device.
   */
  @Serializable(with = DeviceDefinitionLinkSerializer::class)
  public data class Link(
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
    /** The type indicates the relationship of the related device to the device instance. */
    public val relation: Coding,
    /** A reference to the linked device. */
    public val relatedDevice: CodeableReference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(relation.toBuilder(), relatedDevice.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** The type indicates the relationship of the related device to the device instance. */
      public var relation: Coding.Builder,
      /** A reference to the linked device. */
      public var relatedDevice: CodeableReference.Builder,
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

      public fun build(): Link =
        Link(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          relation = relation.build(),
          relatedDevice = relatedDevice.build(),
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
     * A substance that the device contains, may contain, or is made of - for example latex - to be
     * used to determine patient compatibility. This is not intended to represent the composition of
     * the device, only the clinically relevant materials.
     */
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
      /**
       * A substance that the device contains, may contain, or is made of - for example latex - to
       * be used to determine patient compatibility. This is not intended to represent the
       * composition of the device, only the clinically relevant materials.
       */
      public var substance: CodeableConcept.Builder
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

  /** Information aimed at providing directions for the usage of this model of device. */
  @Serializable(with = DeviceDefinitionGuidelineSerializer::class)
  public data class Guideline(
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
    /** The circumstances that form the setting for using the device. */
    public val useContext: List<UsageContext> = listOf(),
    /** Detailed written and visual directions for the user on how to use the device. */
    public val usageInstruction: Markdown? = null,
    /** A source of information or reference for this guideline. */
    public val relatedArtifact: List<RelatedArtifact> = listOf(),
    /**
     * A clinical condition for which the device was designed to be used.
     *
     * A ClinicalUseDefinition that points to the DeviceDefinition can be used if more structured
     * data is needed.
     */
    public val indication: List<CodeableConcept> = listOf(),
    /**
     * A specific situation when a device should not be used because it may cause harm.
     *
     * A ClinicalUseDefinition that points to the DeviceDefinition can be used if more structured
     * data is needed.
     */
    public val contraindication: List<CodeableConcept> = listOf(),
    /**
     * Specific hazard alert information that a user needs to know before using the device.
     *
     * A ClinicalUseDefinition that points to the DeviceDefinition can be used if more structured
     * data is needed.
     */
    public val warning: List<CodeableConcept> = listOf(),
    /** A description of the general purpose or medical use of the device or its function. */
    public val intendedUse: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
          usageInstruction = this@with.usageInstruction?.toBuilder()
          relatedArtifact = this@with.relatedArtifact.map { it.toBuilder() }.toMutableList()
          indication = this@with.indication.map { it.toBuilder() }.toMutableList()
          contraindication = this@with.contraindication.map { it.toBuilder() }.toMutableList()
          warning = this@with.warning.map { it.toBuilder() }.toMutableList()
          intendedUse = this@with.intendedUse?.toBuilder()
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

      /** The circumstances that form the setting for using the device. */
      public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

      /** Detailed written and visual directions for the user on how to use the device. */
      public var usageInstruction: Markdown.Builder? = null

      /** A source of information or reference for this guideline. */
      public var relatedArtifact: MutableList<RelatedArtifact.Builder> = mutableListOf()

      /**
       * A clinical condition for which the device was designed to be used.
       *
       * A ClinicalUseDefinition that points to the DeviceDefinition can be used if more structured
       * data is needed.
       */
      public var indication: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * A specific situation when a device should not be used because it may cause harm.
       *
       * A ClinicalUseDefinition that points to the DeviceDefinition can be used if more structured
       * data is needed.
       */
      public var contraindication: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Specific hazard alert information that a user needs to know before using the device.
       *
       * A ClinicalUseDefinition that points to the DeviceDefinition can be used if more structured
       * data is needed.
       */
      public var warning: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** A description of the general purpose or medical use of the device or its function. */
      public var intendedUse: String.Builder? = null

      public fun build(): Guideline =
        Guideline(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          useContext = useContext.map { it.build() },
          usageInstruction = usageInstruction?.build(),
          relatedArtifact = relatedArtifact.map { it.build() },
          indication = indication.map { it.build() },
          contraindication = contraindication.map { it.build() },
          warning = warning.map { it.build() },
          intendedUse = intendedUse?.build(),
        )
    }
  }

  /** Tracking of latest field safety corrective action. */
  @Serializable(with = DeviceDefinitionCorrectiveActionSerializer::class)
  public data class CorrectiveAction(
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
     * Whether the last corrective action known for this device was a recall.
     *
     * When a field safety action has been initiated but not yet resulted in a recall, this element
     * will be set to 'false'.
     */
    public val recall: Boolean,
    /**
     * The scope of the corrective action - whether the action targeted all units of a given device
     * model, or only a specific set of batches identified by lot numbers, or individually
     * identified devices identified by the serial name.
     */
    public val scope: Enumeration<DeviceCorrectiveActionScope>? = null,
    /** Start and end dates of the corrective action. */
    public val period: Period,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(recall.toBuilder(), period.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          scope = this@with.scope
        }
      }

    public class Builder(
      /**
       * Whether the last corrective action known for this device was a recall.
       *
       * When a field safety action has been initiated but not yet resulted in a recall, this
       * element will be set to 'false'.
       */
      public var recall: Boolean.Builder,
      /** Start and end dates of the corrective action. */
      public var period: Period.Builder,
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
       * The scope of the corrective action - whether the action targeted all units of a given
       * device model, or only a specific set of batches identified by lot numbers, or individually
       * identified devices identified by the serial name.
       */
      public var scope: Enumeration<DeviceCorrectiveActionScope>? = null

      public fun build(): CorrectiveAction =
        CorrectiveAction(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          recall = recall.build(),
          scope = scope,
          period = period.build(),
        )
    }
  }

  /** Billing code or reference associated with the device. */
  @Serializable(with = DeviceDefinitionChargeItemSerializer::class)
  public data class ChargeItem(
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
    /** The code or reference for the charge item. */
    public val chargeItemCode: CodeableReference,
    /** Coefficient applicable to the billing code. */
    public val count: Quantity,
    /** A specific time period in which this charge item applies. */
    public val effectivePeriod: Period? = null,
    /** The context to which this charge item applies. */
    public val useContext: List<UsageContext> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(chargeItemCode.toBuilder(), count.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          effectivePeriod = this@with.effectivePeriod?.toBuilder()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** The code or reference for the charge item. */
      public var chargeItemCode: CodeableReference.Builder,
      /** Coefficient applicable to the billing code. */
      public var count: Quantity.Builder,
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

      /** A specific time period in which this charge item applies. */
      public var effectivePeriod: Period.Builder? = null

      /** The context to which this charge item applies. */
      public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

      public fun build(): ChargeItem =
        ChargeItem(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          chargeItemCode = chargeItemCode.build(),
          count = count.build(),
          effectivePeriod = effectivePeriod?.build(),
          useContext = useContext.map { it.build() },
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

    /** Additional information to describe the device. */
    public var description: Markdown.Builder? = null

    /**
     * Unique instance identifiers assigned to a device by the software, manufacturers, other
     * organizations or owners. For example: handle ID. The identifier is typically valued if the
     * udiDeviceIdentifier, partNumber or modelNumber is not valued and represents a different type
     * of identifier. However, it is permissible to still include those identifiers in
     * DeviceDefinition.identifier with the appropriate identifier.type.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Unique device identifier (UDI) assigned to device label or package. Note that the Device may
     * include multiple udiCarriers as it either may include just the udiCarrier for the
     * jurisdiction it is sold, or for multiple jurisdictions it could have been sold.
     */
    public var udiDeviceIdentifier: MutableList<UdiDeviceIdentifier.Builder> = mutableListOf()

    /**
     * Identifier associated with the regulatory documentation (certificates, technical
     * documentation, post-market surveillance documentation and reports) of a set of device models
     * sharing the same intended purpose, risk class and essential design and manufacturing
     * characteristics. One example is the Basic UDI-DI in Europe.
     *
     * This should not be used for regulatory authorization numbers which are to be captured
     * elsewhere.
     */
    public var regulatoryIdentifier: MutableList<RegulatoryIdentifier.Builder> = mutableListOf()

    /**
     * The part number or catalog number of the device.
     *
     * Alphanumeric Maximum 20.
     */
    public var partNumber: String.Builder? = null

    /**
     * A name of the manufacturer or legal representative e.g. labeler. Whether this is the actual
     * manufacturer or the labeler or responsible depends on implementation and jurisdiction.
     */
    public var manufacturer: Reference.Builder? = null

    /** The name or names of the device as given by the manufacturer. */
    public var deviceName: MutableList<DeviceName.Builder> = mutableListOf()

    /**
     * The model number for the device for example as defined by the manufacturer or labeler, or
     * other agency.
     */
    public var modelNumber: String.Builder? = null

    /**
     * What kind of device or device system this is.
     *
     * In this element various classifications can be used, such as GMDN, EMDN, SNOMED CT, risk
     * classes, national product codes.
     */
    public var classification: MutableList<Classification.Builder> = mutableListOf()

    /**
     * Identifies the standards, specifications, or formal guidances for the capabilities supported
     * by the device. The device may be certified as conformant to these specifications e.g.,
     * communication, performance, process, measurement, or specialization standards.
     */
    public var conformsTo: MutableList<ConformsTo.Builder> = mutableListOf()

    /** A device that is part (for example a component) of the present device. */
    public var hasPart: MutableList<HasPart.Builder> = mutableListOf()

    /** Information about the packaging of the device, i.e. how the device is packaged. */
    public var packaging: MutableList<Packaging.Builder> = mutableListOf()

    /** The version of the device or software. */
    public var version: MutableList<Version.Builder> = mutableListOf()

    /** Safety characteristics of the device. */
    public var safety: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Shelf Life and storage information. */
    public var shelfLifeStorage: MutableList<ProductShelfLife.Builder> = mutableListOf()

    /** Language code for the human-readable text strings produced by the device (all supported). */
    public var languageCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Static or essentially fixed characteristics or features of this kind of device that are
     * otherwise not captured in more specific attributes, e.g., time or timing attributes,
     * resolution, accuracy, and physical attributes.
     *
     * Dynamic or current properties, such as settings, of an individual device are described using
     * a Device instance-specific DeviceMetric and recorded using Observation. Static
     * characteristics of an individual device could also be documented in a [Device] instance. The
     * Device instance's properties, and their values, could be, but need not be, the same as in the
     * associated DeviceDefinition.
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
     * An associated device, attached to, used with, communicating with or linking a previous or new
     * device model to the focal device.
     */
    public var link: MutableList<Link.Builder> = mutableListOf()

    /**
     * Descriptive information, usage information or implantation information that is not captured
     * in an existing element.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** A substance used to create the material(s) of which the device is made. */
    public var material: MutableList<Material.Builder> = mutableListOf()

    /**
     * Indicates the production identifier(s) that are expected to appear in the UDI carrier on the
     * device label.
     */
    public var productionIdentifierInUDI:
      MutableList<Enumeration<DeviceProductionIdentifierInUDI>> =
      mutableListOf()

    /**
     * Information aimed at providing directions for the usage of this model of device.
     *
     * For more structured data, a ClinicalUseDefinition that points to the DeviceDefinition can be
     * used.
     */
    public var guideline: Guideline.Builder? = null

    /** Tracking of latest field safety corrective action. */
    public var correctiveAction: CorrectiveAction.Builder? = null

    /** Billing code or reference associated with the device. */
    public var chargeItem: MutableList<ChargeItem.Builder> = mutableListOf()

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
        description = description?.build(),
        identifier = identifier.map { it.build() },
        udiDeviceIdentifier = udiDeviceIdentifier.map { it.build() },
        regulatoryIdentifier = regulatoryIdentifier.map { it.build() },
        partNumber = partNumber?.build(),
        manufacturer = manufacturer?.build(),
        deviceName = deviceName.map { it.build() },
        modelNumber = modelNumber?.build(),
        classification = classification.map { it.build() },
        conformsTo = conformsTo.map { it.build() },
        hasPart = hasPart.map { it.build() },
        packaging = packaging.map { it.build() },
        version = version.map { it.build() },
        safety = safety.map { it.build() },
        shelfLifeStorage = shelfLifeStorage.map { it.build() },
        languageCode = languageCode.map { it.build() },
        `property` = `property`.map { it.build() },
        owner = owner?.build(),
        contact = contact.map { it.build() },
        link = link.map { it.build() },
        note = note.map { it.build() },
        material = material.map { it.build() },
        productionIdentifierInUDI = productionIdentifierInUDI,
        guideline = guideline?.build(),
        correctiveAction = correctiveAction?.build(),
        chargeItem = chargeItem.map { it.build() },
      )
  }

  /** Regulatory Identifier type */
  public enum class DeviceDefinitionRegulatoryIdentifierType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Basic("basic", "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type", "Basic"),
    Master("master", "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type", "Master"),
    License(
      "license",
      "http://hl7.org/fhir/devicedefinition-regulatory-identifier-type",
      "License",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DeviceDefinitionRegulatoryIdentifierType =
        when (code) {
          "basic" -> Basic
          "master" -> Master
          "license" -> License
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum DeviceDefinitionRegulatoryIdentifierType"
            )
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

  /** Device - Corrective action scope */
  public enum class DeviceCorrectiveActionScope(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Model("model", "http://hl7.org/fhir/device-correctiveactionscope", "Model"),
    Lot_Numbers("lot-numbers", "http://hl7.org/fhir/device-correctiveactionscope", "Lot Numbers"),
    Serial_Numbers(
      "serial-numbers",
      "http://hl7.org/fhir/device-correctiveactionscope",
      "Serial Numbers",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DeviceCorrectiveActionScope =
        when (code) {
          "model" -> Model
          "lot-numbers" -> Lot_Numbers
          "serial-numbers" -> Serial_Numbers
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum DeviceCorrectiveActionScope"
            )
        }
    }
  }

  /** Device Production Identifier in UDI */
  public enum class DeviceProductionIdentifierInUDI(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Lot_Number("lot-number", "http://hl7.org/fhir/device-productidentifierinudi", "Lot Number"),
    Manufactured_Date(
      "manufactured-date",
      "http://hl7.org/fhir/device-productidentifierinudi",
      "Manufactured date",
    ),
    Serial_Number(
      "serial-number",
      "http://hl7.org/fhir/device-productidentifierinudi",
      "Serial Number",
    ),
    Expiration_Date(
      "expiration-date",
      "http://hl7.org/fhir/device-productidentifierinudi",
      "Expiration date",
    ),
    Biological_Source(
      "biological-source",
      "http://hl7.org/fhir/device-productidentifierinudi",
      "Biological source",
    ),
    Software_Version(
      "software-version",
      "http://hl7.org/fhir/device-productidentifierinudi",
      "Software Version",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DeviceProductionIdentifierInUDI =
        when (code) {
          "lot-number" -> Lot_Number
          "manufactured-date" -> Manufactured_Date
          "serial-number" -> Serial_Number
          "expiration-date" -> Expiration_Date
          "biological-source" -> Biological_Source
          "software-version" -> Software_Version
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum DeviceProductionIdentifierInUDI"
            )
        }
    }
  }
}

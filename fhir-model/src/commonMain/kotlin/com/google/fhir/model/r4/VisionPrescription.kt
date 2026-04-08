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

import com.google.fhir.model.r4.serializers.VisionPrescriptionLensSpecificationPrismSerializer
import com.google.fhir.model.r4.serializers.VisionPrescriptionLensSpecificationSerializer
import com.google.fhir.model.r4.serializers.VisionPrescriptionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** An authorization for the provision of glasses and/or contact lenses to a patient. */
@Serializable(with = VisionPrescriptionSerializer::class)
@SerialName("VisionPrescription")
public data class VisionPrescription(
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
  /** A unique identifier assigned to this vision prescription. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The status of the resource instance.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<FinancialResourceStatusCodes>,
  /** The date this resource was created. */
  public val created: DateTime,
  /** A resource reference to the person to whom the vision prescription applies. */
  public val patient: Reference,
  /**
   * A reference to a resource that identifies the particular occurrence of contact between patient
   * and health care provider during which the prescription was issued.
   */
  public val encounter: Reference? = null,
  /**
   * The date (and perhaps time) when the prescription was written.
   *
   * Jurisdictions determine the valid lifetime of a prescription. Typically vision prescriptions
   * are valid for two years from the date written.
   */
  public val dateWritten: DateTime,
  /** The healthcare professional responsible for authorizing the prescription. */
  public val prescriber: Reference,
  /**
   * Contain the details of the individual lens specifications and serves as the authorization for
   * the fullfillment by certified professionals.
   */
  public val lensSpecification: List<LensSpecification>,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          created.toBuilder(),
          patient.toBuilder(),
          dateWritten.toBuilder(),
          prescriber.toBuilder(),
          lensSpecification.map { it.toBuilder() }.toMutableList(),
        )
        .apply {
          id = this@with.id
          meta = this@with.meta?.toBuilder()
          implicitRules = this@with.implicitRules?.toBuilder()
          language = this@with.language?.toBuilder()
          text = this@with.text?.toBuilder()
          contained = this@with.contained.map { it.toBuilder() }.toMutableList()
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          encounter = this@with.encounter?.toBuilder()
        }
    }

  /**
   * Contain the details of the individual lens specifications and serves as the authorization for
   * the fullfillment by certified professionals.
   */
  @Serializable(with = VisionPrescriptionLensSpecificationSerializer::class)
  public data class LensSpecification(
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
    /** Identifies the type of vision correction product which is required for the patient. */
    public val product: CodeableConcept,
    /**
     * The eye for which the lens specification applies.
     *
     * May also appear as OD (oculus dexter) for the right eye and OS (oculus siniter) for the left
     * eye.
     */
    public val eye: Enumeration<VisionEyes>,
    /**
     * Lens power measured in dioptres (0.25 units).
     *
     * The value is negative for near-sighted and positive for far sighted. Often insurance will not
     * cover a lens with power between +75 and -75.
     */
    public val sphere: Decimal? = null,
    /** Power adjustment for astigmatism measured in dioptres (0.25 units). */
    public val cylinder: Decimal? = null,
    /**
     * Adjustment for astigmatism measured in integer degrees.
     *
     * The limits are +180 and -180 degrees.
     */
    public val axis: Integer? = null,
    /** Allows for adjustment on two axis. */
    public val prism: List<Prism> = listOf(),
    /** Power adjustment for multifocal lenses measured in dioptres (0.25 units). */
    public val add: Decimal? = null,
    /** Contact lens power measured in dioptres (0.25 units). */
    public val power: Decimal? = null,
    /** Back curvature measured in millimetres. */
    public val backCurve: Decimal? = null,
    /** Contact lens diameter measured in millimetres. */
    public val diameter: Decimal? = null,
    /** The recommended maximum wear period for the lens. */
    public val duration: Quantity? = null,
    /** Special color or pattern. */
    public val color: String? = null,
    /** Brand recommendations or restrictions. */
    public val brand: String? = null,
    /** Notes for special requirements such as coatings and lens materials. */
    public val note: List<Annotation> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(product.toBuilder(), eye).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          sphere = this@with.sphere?.toBuilder()
          cylinder = this@with.cylinder?.toBuilder()
          axis = this@with.axis?.toBuilder()
          prism = this@with.prism.map { it.toBuilder() }.toMutableList()
          add = this@with.add?.toBuilder()
          power = this@with.power?.toBuilder()
          backCurve = this@with.backCurve?.toBuilder()
          diameter = this@with.diameter?.toBuilder()
          duration = this@with.duration?.toBuilder()
          color = this@with.color?.toBuilder()
          brand = this@with.brand?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Allows for adjustment on two axis. */
    @Serializable(with = VisionPrescriptionLensSpecificationPrismSerializer::class)
    public data class Prism(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** Amount of prism to compensate for eye alignment in fractional units. */
      public val amount: Decimal,
      /** The relative base, or reference lens edge, for the prism. */
      public val base: Enumeration<VisionBase>,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(amount.toBuilder(), base).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** Amount of prism to compensate for eye alignment in fractional units. */
        public var amount: Decimal.Builder,
        /** The relative base, or reference lens edge, for the prism. */
        public var base: Enumeration<VisionBase>,
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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

        public fun build(): Prism =
          Prism(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            amount = amount.build(),
            base = base,
          )
      }
    }

    public class Builder(
      /** Identifies the type of vision correction product which is required for the patient. */
      public var product: CodeableConcept.Builder,
      /**
       * The eye for which the lens specification applies.
       *
       * May also appear as OD (oculus dexter) for the right eye and OS (oculus siniter) for the
       * left eye.
       */
      public var eye: Enumeration<VisionEyes>,
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

      /**
       * Lens power measured in dioptres (0.25 units).
       *
       * The value is negative for near-sighted and positive for far sighted. Often insurance will
       * not cover a lens with power between +75 and -75.
       */
      public var sphere: Decimal.Builder? = null

      /** Power adjustment for astigmatism measured in dioptres (0.25 units). */
      public var cylinder: Decimal.Builder? = null

      /**
       * Adjustment for astigmatism measured in integer degrees.
       *
       * The limits are +180 and -180 degrees.
       */
      public var axis: Integer.Builder? = null

      /** Allows for adjustment on two axis. */
      public var prism: MutableList<Prism.Builder> = mutableListOf()

      /** Power adjustment for multifocal lenses measured in dioptres (0.25 units). */
      public var add: Decimal.Builder? = null

      /** Contact lens power measured in dioptres (0.25 units). */
      public var power: Decimal.Builder? = null

      /** Back curvature measured in millimetres. */
      public var backCurve: Decimal.Builder? = null

      /** Contact lens diameter measured in millimetres. */
      public var diameter: Decimal.Builder? = null

      /** The recommended maximum wear period for the lens. */
      public var duration: Quantity.Builder? = null

      /** Special color or pattern. */
      public var color: String.Builder? = null

      /** Brand recommendations or restrictions. */
      public var brand: String.Builder? = null

      /** Notes for special requirements such as coatings and lens materials. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      public fun build(): LensSpecification =
        LensSpecification(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          product = product.build(),
          eye = eye,
          sphere = sphere?.build(),
          cylinder = cylinder?.build(),
          axis = axis?.build(),
          prism = prism.map { it.build() },
          add = add?.build(),
          power = power?.build(),
          backCurve = backCurve?.build(),
          diameter = diameter?.build(),
          duration = duration?.build(),
          color = color?.build(),
          brand = brand?.build(),
          note = note.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The status of the resource instance.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<FinancialResourceStatusCodes>,
    /** The date this resource was created. */
    public var created: DateTime.Builder,
    /** A resource reference to the person to whom the vision prescription applies. */
    public var patient: Reference.Builder,
    /**
     * The date (and perhaps time) when the prescription was written.
     *
     * Jurisdictions determine the valid lifetime of a prescription. Typically vision prescriptions
     * are valid for two years from the date written.
     */
    public var dateWritten: DateTime.Builder,
    /** The healthcare professional responsible for authorizing the prescription. */
    public var prescriber: Reference.Builder,
    /**
     * Contain the details of the individual lens specifications and serves as the authorization for
     * the fullfillment by certified professionals.
     */
    public var lensSpecification: MutableList<LensSpecification.Builder>,
  ) : DomainResource.Builder() {
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

    /** A unique identifier assigned to this vision prescription. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A reference to a resource that identifies the particular occurrence of contact between
     * patient and health care provider during which the prescription was issued.
     */
    public var encounter: Reference.Builder? = null

    override fun build(): VisionPrescription =
      VisionPrescription(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        status = status,
        created = created.build(),
        patient = patient.build(),
        encounter = encounter?.build(),
        dateWritten = dateWritten.build(),
        prescriber = prescriber.build(),
        lensSpecification = lensSpecification.map { it.build() },
      )
  }

  /** A coded concept listing the eye codes. */
  public enum class VisionEyes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Right("right", "http://hl7.org/fhir/vision-eye-codes", "Right Eye"),
    Left("left", "http://hl7.org/fhir/vision-eye-codes", "Left Eye");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): VisionEyes =
        when (code) {
          "right" -> Right
          "left" -> Left
          else -> throw IllegalArgumentException("Unknown code $code for enum VisionEyes")
        }
    }
  }

  /** A coded concept listing the base codes. */
  public enum class VisionBase(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Up("up", "http://hl7.org/fhir/vision-base-codes", "Up"),
    Down("down", "http://hl7.org/fhir/vision-base-codes", "Down"),
    In("in", "http://hl7.org/fhir/vision-base-codes", "In"),
    Out("out", "http://hl7.org/fhir/vision-base-codes", "Out");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): VisionBase =
        when (code) {
          "up" -> Up
          "down" -> Down
          "in" -> In
          "out" -> Out
          else -> throw IllegalArgumentException("Unknown code $code for enum VisionBase")
        }
    }
  }

  /** This value set includes Status codes. */
  public enum class FinancialResourceStatusCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Active("active", "http://hl7.org/fhir/fm-status", "Active"),
    Cancelled("cancelled", "http://hl7.org/fhir/fm-status", "Cancelled"),
    Draft("draft", "http://hl7.org/fhir/fm-status", "Draft"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/fm-status", "Entered in Error");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): FinancialResourceStatusCodes =
        when (code) {
          "active" -> Active
          "cancelled" -> Cancelled
          "draft" -> Draft
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum FinancialResourceStatusCodes"
            )
        }
    }
  }
}

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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.ImagingSelectionInstanceImageRegion2DSerializer
import dev.ohs.fhir.model.r5.serializers.ImagingSelectionInstanceImageRegion3DSerializer
import dev.ohs.fhir.model.r5.serializers.ImagingSelectionInstanceSerializer
import dev.ohs.fhir.model.r5.serializers.ImagingSelectionPerformerSerializer
import dev.ohs.fhir.model.r5.serializers.ImagingSelectionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A selection of DICOM SOP instances and/or frames within a single Study and Series. This might
 * include additional specifics such as an image region, an Observation UID or a Segmentation
 * Number, allowing linkage to an Observation Resource or transferring this information along with
 * the ImagingStudy Resource.
 */
@Serializable(with = ImagingSelectionSerializer::class)
@SerialName("ImagingSelection")
public data class ImagingSelection(
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
   * A unique identifier assigned to this imaging selection.
   *
   * This is a business identifier, not a resource identifier -- see discussion under
   * [Business Identifiers](resource.html#identifiers).
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The current state of the ImagingSelection resource. This is not the status of any ImagingStudy,
   * ServiceRequest, or Task resources associated with the ImagingSelection.
   *
   * Unknown does not represent "other" - one of the defined statuses must apply. Unknown is used
   * when the authoring system is not sure what the current status is.
   */
  public val status: Enumeration<ImagingSelectionStatus>,
  /**
   * The patient, or group of patients, location, device, organization, procedure or practitioner
   * this imaging selection is about and into whose or what record the imaging selection is placed.
   */
  public val subject: Reference? = null,
  /** The date and time this imaging selection was created. */
  public val issued: Instant? = null,
  /** Selector of the instances – human or machine. */
  public val performer: List<Performer> = listOf(),
  /** A list of the diagnostic requests that resulted in this imaging selection being performed. */
  public val basedOn: List<Reference> = listOf(),
  /** Classifies the imaging selection. */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * Reason for referencing the selected content.
   *
   * *All* code-value and, if present, component.code-component.value pairs need to be taken into
   * account to correctly understand the meaning of the observation.
   */
  public val code: CodeableConcept,
  /**
   * The Study Instance UID for the DICOM Study from which the images were selected.
   *
   * See
   * [DICOM PS3.3 C.7.2](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.2.html).
   */
  public val studyUid: Id? = null,
  /** The imaging study from which the imaging selection is made. */
  public val derivedFrom: List<Reference> = listOf(),
  /**
   * The network service providing retrieval access to the selected images, frames, etc. See
   * implementation notes for information about using DICOM endpoints.
   *
   * Typical endpoint types include DICOM WADO-RS, which is used to retrieve DICOM instances in
   * native or rendered (e.g., JPG, PNG) formats using a RESTful API; DICOM WADO-URI, which can
   * similarly retrieve native or rendered instances, except using an HTTP query-based approach.
   */
  public val endpoint: List<Reference> = listOf(),
  /**
   * The Series Instance UID for the DICOM Series from which the images were selected.
   *
   * See
   * [DICOM PS3.3 C.7.3](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.3.html).
   */
  public val seriesUid: Id? = null,
  /**
   * The Series Number for the DICOM Series from which the images were selected.
   *
   * See
   * [DICOM PS3.3 C.7.3](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.3.html).
   */
  public val seriesNumber: UnsignedInt? = null,
  /**
   * The Frame of Reference UID identifying the coordinate system that conveys spatial and/or
   * temporal information for the selected images or frames.
   *
   * See
   * [DICOM PS3.3 C.7.4.1](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.4.html).
   */
  public val frameOfReferenceUid: Id? = null,
  /**
   * The anatomic structures examined. See DICOM Part 16 Annex L
   * (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to
   * SNOMED-CT mappings.
   */
  public val bodySite: CodeableReference? = null,
  /**
   * The actual focus of an observation when it is not the patient of record representing something
   * or someone associated with the patient such as a spouse, parent, fetus, or donor. For example,
   * fetus observations in a mother's record. The focus of an observation could also be an existing
   * condition, an intervention, the subject's diet, another observation of the subject, or a body
   * structure such as tumor or implanted device. An example use case would be using the Observation
   * resource to capture whether the mother is trained to change her child's tracheostomy tube. In
   * this example, the child is the patient of record and the mother is the focus.
   *
   * An imaging selection may reference a DICOM resource that itself references other DICOM
   * resources. e.g. a presentation state references a set of source images or frames.
   */
  public val focus: List<Reference> = listOf(),
  /** Each imaging selection includes one or more selected DICOM SOP instances. */
  public val instance: List<Instance> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, code.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject?.toBuilder()
        issued = this@with.issued?.toBuilder()
        performer = this@with.performer.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        studyUid = this@with.studyUid?.toBuilder()
        derivedFrom = this@with.derivedFrom.map { it.toBuilder() }.toMutableList()
        endpoint = this@with.endpoint.map { it.toBuilder() }.toMutableList()
        seriesUid = this@with.seriesUid?.toBuilder()
        seriesNumber = this@with.seriesNumber?.toBuilder()
        frameOfReferenceUid = this@with.frameOfReferenceUid?.toBuilder()
        bodySite = this@with.bodySite?.toBuilder()
        focus = this@with.focus.map { it.toBuilder() }.toMutableList()
        instance = this@with.instance.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Selector of the instances – human or machine. */
  @Serializable(with = ImagingSelectionPerformerSerializer::class)
  public data class Performer(
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
    /** Distinguishes the type of involvement of the performer. */
    public val function: CodeableConcept? = null,
    /** Author – human or machine. */
    public val actor: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          function = this@with.function?.toBuilder()
          actor = this@with.actor?.toBuilder()
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

      /** Distinguishes the type of involvement of the performer. */
      public var function: CodeableConcept.Builder? = null

      /** Author – human or machine. */
      public var actor: Reference.Builder? = null

      public fun build(): Performer =
        Performer(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          function = function?.build(),
          actor = actor?.build(),
        )
    }
  }

  /** Each imaging selection includes one or more selected DICOM SOP instances. */
  @Serializable(with = ImagingSelectionInstanceSerializer::class)
  public data class Instance(
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
     * The SOP Instance UID for the selected DICOM instance.
     *
     * See
     * [DICOM PS3.3 C.12.1](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.12.html).
     */
    public val uid: Id,
    /**
     * The Instance Number for the selected DICOM instance.
     *
     * See
     * [DICOM PS3.3 C.7.6.1](https://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.6.html#sect_C.7.6.1).
     * Note: A multiframe instance has a single instance number with each frame identified by a
     * frame number.
     */
    public val number: UnsignedInt? = null,
    /**
     * The SOP Class UID for the selected DICOM instance.
     *
     * See
     * [DICOM PS3.3 C.12.1](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.12.html).
     */
    public val sopClass: Coding? = null,
    /**
     * Selected subset of the SOP Instance. The content and format of the subset item is determined
     * by the SOP Class of the selected instance. May be one of:
     * - A list of frame numbers selected from a multiframe SOP Instance.
     * - A list of Content Item Observation UID values selected from a DICOM SR or other structured
     *   document SOP Instance.
     * - A list of segment numbers selected from a segmentation SOP Instance.
     * - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP
     *   Instance.
     */
    public val subset: List<String> = listOf(),
    /**
     * Each imaging selection instance or frame list might includes an image region, specified by a
     * region type and a set of 2D coordinates. If the parent imagingSelection.instance contains a
     * subset element of type frame, the image region applies to all frames in the subset list.
     */
    public val imageRegion2D: List<ImageRegion2D> = listOf(),
    /**
     * Each imaging selection might includes a 3D image region, specified by a region type and a set
     * of 3D coordinates.
     */
    public val imageRegion3D: List<ImageRegion3D> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(uid.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          number = this@with.number?.toBuilder()
          sopClass = this@with.sopClass?.toBuilder()
          subset = this@with.subset.map { it.toBuilder() }.toMutableList()
          imageRegion2D = this@with.imageRegion2D.map { it.toBuilder() }.toMutableList()
          imageRegion3D = this@with.imageRegion3D.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * Each imaging selection instance or frame list might includes an image region, specified by a
     * region type and a set of 2D coordinates. If the parent imagingSelection.instance contains a
     * subset element of type frame, the image region applies to all frames in the subset list.
     */
    @Serializable(with = ImagingSelectionInstanceImageRegion2DSerializer::class)
    public data class ImageRegion2D(
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
      /**
       * Specifies the type of image region.
       *
       * See
       * [DICOM PS3.3 C.10.5.1.2](https://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.10.5.html#sect_C.10.5.1.2).
       */
      public val regionType: Enumeration<ImagingSelection2DGraphicType>,
      /**
       * The coordinates describing the image region. Encoded as a set of (column, row) pairs that
       * denote positions in the selected image / frames specified with sub-pixel resolution. The
       * origin at the TLHC of the TLHC pixel is 0.0\0.0, the BRHC of the TLHC pixel is 1.0\1.0, and
       * the BRHC of the BRHC pixel is the number of columns\rows in the image / frames. The values
       * must be within the range 0\0 to the number of columns\rows in the image / frames.
       *
       * For a description of how 2D coordinates are encoded, see
       * [DICOM PS3.3 C.18.6](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.18.6.html).
       */
      public val coordinate: List<Decimal>,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(regionType, coordinate.map { it.toBuilder() }.toMutableList()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * Specifies the type of image region.
         *
         * See
         * [DICOM PS3.3 C.10.5.1.2](https://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.10.5.html#sect_C.10.5.1.2).
         */
        public var regionType: Enumeration<ImagingSelection2DGraphicType>,
        /**
         * The coordinates describing the image region. Encoded as a set of (column, row) pairs that
         * denote positions in the selected image / frames specified with sub-pixel resolution. The
         * origin at the TLHC of the TLHC pixel is 0.0\0.0, the BRHC of the TLHC pixel is 1.0\1.0,
         * and the BRHC of the BRHC pixel is the number of columns\rows in the image / frames. The
         * values must be within the range 0\0 to the number of columns\rows in the image / frames.
         *
         * For a description of how 2D coordinates are encoded, see
         * [DICOM PS3.3 C.18.6](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.18.6.html).
         */
        public var coordinate: MutableList<Decimal.Builder>,
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

        public fun build(): ImageRegion2D =
          ImageRegion2D(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            regionType = regionType,
            coordinate = coordinate.map { it.build() },
          )
      }
    }

    /**
     * Each imaging selection might includes a 3D image region, specified by a region type and a set
     * of 3D coordinates.
     */
    @Serializable(with = ImagingSelectionInstanceImageRegion3DSerializer::class)
    public data class ImageRegion3D(
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
      /**
       * Specifies the type of image region.
       *
       * See
       * [DICOM PS3.3 C.18.9.1.2](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.18.9.html#sect_C.18.9.1.2).
       */
      public val regionType: Enumeration<ImagingSelection3DGraphicType>,
      /**
       * The coordinates describing the image region. Encoded as an ordered set of (x,y,z) triplets
       * (in mm and may be negative) that define a region of interest in the patient-relative
       * Reference Coordinate System defined by ImagingSelection.frameOfReferenceUid element.
       *
       * For a description of how 3D coordinates are encoded, see
       * [DICOM PS3.3 C.18.9](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.18.9.html).
       */
      public val coordinate: List<Decimal>,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(regionType, coordinate.map { it.toBuilder() }.toMutableList()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * Specifies the type of image region.
         *
         * See
         * [DICOM PS3.3 C.18.9.1.2](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.18.9.html#sect_C.18.9.1.2).
         */
        public var regionType: Enumeration<ImagingSelection3DGraphicType>,
        /**
         * The coordinates describing the image region. Encoded as an ordered set of (x,y,z)
         * triplets (in mm and may be negative) that define a region of interest in the
         * patient-relative Reference Coordinate System defined by
         * ImagingSelection.frameOfReferenceUid element.
         *
         * For a description of how 3D coordinates are encoded, see
         * [DICOM PS3.3 C.18.9](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.18.9.html).
         */
        public var coordinate: MutableList<Decimal.Builder>,
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

        public fun build(): ImageRegion3D =
          ImageRegion3D(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            regionType = regionType,
            coordinate = coordinate.map { it.build() },
          )
      }
    }

    public class Builder(
      /**
       * The SOP Instance UID for the selected DICOM instance.
       *
       * See
       * [DICOM PS3.3 C.12.1](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.12.html).
       */
      public var uid: Id.Builder
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
       * The Instance Number for the selected DICOM instance.
       *
       * See
       * [DICOM PS3.3 C.7.6.1](https://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.6.html#sect_C.7.6.1).
       * Note: A multiframe instance has a single instance number with each frame identified by a
       * frame number.
       */
      public var number: UnsignedInt.Builder? = null

      /**
       * The SOP Class UID for the selected DICOM instance.
       *
       * See
       * [DICOM PS3.3 C.12.1](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.12.html).
       */
      public var sopClass: Coding.Builder? = null

      /**
       * Selected subset of the SOP Instance. The content and format of the subset item is
       * determined by the SOP Class of the selected instance. May be one of:
       * - A list of frame numbers selected from a multiframe SOP Instance.
       * - A list of Content Item Observation UID values selected from a DICOM SR or other
       *   structured document SOP Instance.
       * - A list of segment numbers selected from a segmentation SOP Instance.
       * - A list of Region of Interest (ROI) numbers selected from a radiotherapy structure set SOP
       *   Instance.
       */
      public var subset: MutableList<String.Builder> = mutableListOf()

      /**
       * Each imaging selection instance or frame list might includes an image region, specified by
       * a region type and a set of 2D coordinates. If the parent imagingSelection.instance contains
       * a subset element of type frame, the image region applies to all frames in the subset list.
       */
      public var imageRegion2D: MutableList<ImageRegion2D.Builder> = mutableListOf()

      /**
       * Each imaging selection might includes a 3D image region, specified by a region type and a
       * set of 3D coordinates.
       */
      public var imageRegion3D: MutableList<ImageRegion3D.Builder> = mutableListOf()

      public fun build(): Instance =
        Instance(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          uid = uid.build(),
          number = number?.build(),
          sopClass = sopClass?.build(),
          subset = subset.map { it.build() },
          imageRegion2D = imageRegion2D.map { it.build() },
          imageRegion3D = imageRegion3D.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The current state of the ImagingSelection resource. This is not the status of any
     * ImagingStudy, ServiceRequest, or Task resources associated with the ImagingSelection.
     *
     * Unknown does not represent "other" - one of the defined statuses must apply. Unknown is used
     * when the authoring system is not sure what the current status is.
     */
    public var status: Enumeration<ImagingSelectionStatus>,
    /**
     * Reason for referencing the selected content.
     *
     * *All* code-value and, if present, component.code-component.value pairs need to be taken into
     * account to correctly understand the meaning of the observation.
     */
    public var code: CodeableConcept.Builder,
  ) : DomainResource.Builder() {
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
     * A unique identifier assigned to this imaging selection.
     *
     * This is a business identifier, not a resource identifier -- see discussion under
     * [Business Identifiers](resource.html#identifiers).
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The patient, or group of patients, location, device, organization, procedure or practitioner
     * this imaging selection is about and into whose or what record the imaging selection is
     * placed.
     */
    public var subject: Reference.Builder? = null

    /** The date and time this imaging selection was created. */
    public var issued: Instant.Builder? = null

    /** Selector of the instances – human or machine. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /**
     * A list of the diagnostic requests that resulted in this imaging selection being performed.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /** Classifies the imaging selection. */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The Study Instance UID for the DICOM Study from which the images were selected.
     *
     * See
     * [DICOM PS3.3 C.7.2](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.2.html).
     */
    public var studyUid: Id.Builder? = null

    /** The imaging study from which the imaging selection is made. */
    public var derivedFrom: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The network service providing retrieval access to the selected images, frames, etc. See
     * implementation notes for information about using DICOM endpoints.
     *
     * Typical endpoint types include DICOM WADO-RS, which is used to retrieve DICOM instances in
     * native or rendered (e.g., JPG, PNG) formats using a RESTful API; DICOM WADO-URI, which can
     * similarly retrieve native or rendered instances, except using an HTTP query-based approach.
     */
    public var endpoint: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The Series Instance UID for the DICOM Series from which the images were selected.
     *
     * See
     * [DICOM PS3.3 C.7.3](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.3.html).
     */
    public var seriesUid: Id.Builder? = null

    /**
     * The Series Number for the DICOM Series from which the images were selected.
     *
     * See
     * [DICOM PS3.3 C.7.3](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.3.html).
     */
    public var seriesNumber: UnsignedInt.Builder? = null

    /**
     * The Frame of Reference UID identifying the coordinate system that conveys spatial and/or
     * temporal information for the selected images or frames.
     *
     * See
     * [DICOM PS3.3 C.7.4.1](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.4.html).
     */
    public var frameOfReferenceUid: Id.Builder? = null

    /**
     * The anatomic structures examined. See DICOM Part 16 Annex L
     * (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to
     * SNOMED-CT mappings.
     */
    public var bodySite: CodeableReference.Builder? = null

    /**
     * The actual focus of an observation when it is not the patient of record representing
     * something or someone associated with the patient such as a spouse, parent, fetus, or donor.
     * For example, fetus observations in a mother's record. The focus of an observation could also
     * be an existing condition, an intervention, the subject's diet, another observation of the
     * subject, or a body structure such as tumor or implanted device. An example use case would be
     * using the Observation resource to capture whether the mother is trained to change her child's
     * tracheostomy tube. In this example, the child is the patient of record and the mother is the
     * focus.
     *
     * An imaging selection may reference a DICOM resource that itself references other DICOM
     * resources. e.g. a presentation state references a set of source images or frames.
     */
    public var focus: MutableList<Reference.Builder> = mutableListOf()

    /** Each imaging selection includes one or more selected DICOM SOP instances. */
    public var instance: MutableList<Instance.Builder> = mutableListOf()

    override fun build(): ImagingSelection =
      ImagingSelection(
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
        subject = subject?.build(),
        issued = issued?.build(),
        performer = performer.map { it.build() },
        basedOn = basedOn.map { it.build() },
        category = category.map { it.build() },
        code = code.build(),
        studyUid = studyUid?.build(),
        derivedFrom = derivedFrom.map { it.build() },
        endpoint = endpoint.map { it.build() },
        seriesUid = seriesUid?.build(),
        seriesNumber = seriesNumber?.build(),
        frameOfReferenceUid = frameOfReferenceUid?.build(),
        bodySite = bodySite?.build(),
        focus = focus.map { it.build() },
        instance = instance.map { it.build() },
      )
  }

  /** The type of 2D coordinates describing a 2D image region. */
  public enum class ImagingSelection2DGraphicType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Point("point", "http://hl7.org/fhir/imagingselection-2dgraphictype", "POINT"),
    Polyline("polyline", "http://hl7.org/fhir/imagingselection-2dgraphictype", "POLYLINE"),
    Interpolated(
      "interpolated",
      "http://hl7.org/fhir/imagingselection-2dgraphictype",
      "INTERPOLATED",
    ),
    Circle("circle", "http://hl7.org/fhir/imagingselection-2dgraphictype", "CIRCLE"),
    Ellipse("ellipse", "http://hl7.org/fhir/imagingselection-2dgraphictype", "ELLIPSE");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ImagingSelection2DGraphicType =
        when (code) {
          "point" -> Point
          "polyline" -> Polyline
          "interpolated" -> Interpolated
          "circle" -> Circle
          "ellipse" -> Ellipse
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum ImagingSelection2DGraphicType"
            )
        }
    }
  }

  /** The type of coordinates describing a 3D image region. */
  public enum class ImagingSelection3DGraphicType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Point("point", "http://hl7.org/fhir/imagingselection-3dgraphictype", "POINT"),
    Multipoint("multipoint", "http://hl7.org/fhir/imagingselection-3dgraphictype", "MULTIPOINT"),
    Polyline("polyline", "http://hl7.org/fhir/imagingselection-3dgraphictype", "POLYLINE"),
    Polygon("polygon", "http://hl7.org/fhir/imagingselection-3dgraphictype", "POLYGON"),
    Ellipse("ellipse", "http://hl7.org/fhir/imagingselection-3dgraphictype", "ELLIPSE"),
    Ellipsoid("ellipsoid", "http://hl7.org/fhir/imagingselection-3dgraphictype", "ELLIPSOID");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ImagingSelection3DGraphicType =
        when (code) {
          "point" -> Point
          "multipoint" -> Multipoint
          "polyline" -> Polyline
          "polygon" -> Polygon
          "ellipse" -> Ellipse
          "ellipsoid" -> Ellipsoid
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum ImagingSelection3DGraphicType"
            )
        }
    }
  }

  /** The status of the ImagingSelection. */
  public enum class ImagingSelectionStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Available("available", "http://hl7.org/fhir/imagingselection-status", "Available"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/imagingselection-status",
      "Entered in Error",
    ),
    Unknown("unknown", "http://hl7.org/fhir/imagingselection-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ImagingSelectionStatus =
        when (code) {
          "available" -> Available
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ImagingSelectionStatus")
        }
    }
  }
}

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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.ImagingStudySerializer
import dev.ohs.fhir.model.r4.serializers.ImagingStudySeriesInstanceSerializer
import dev.ohs.fhir.model.r4.serializers.ImagingStudySeriesPerformerSerializer
import dev.ohs.fhir.model.r4.serializers.ImagingStudySeriesSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Representation of the content produced in a DICOM imaging study. A study comprises a set of
 * series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or
 * other data) acquired or produced in a common context. A series is of only one modality (e.g.
 * X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.
 */
@Serializable(with = ImagingStudySerializer::class)
@SerialName("ImagingStudy")
public data class ImagingStudy(
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
   * Identifiers for the ImagingStudy such as DICOM Study Instance UID, and Accession Number.
   *
   * See discussion under [Imaging Study Implementation Notes](imagingstudy.html#notes) for encoding
   * of DICOM Study Instance UID. Accession Number should use ACSN Identifier type.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The current state of the ImagingStudy.
   *
   * Unknown does not represent "other" - one of the defined statuses must apply. Unknown is used
   * when the authoring system is not sure what the current status is.
   */
  public val status: Enumeration<ImagingStudyStatus>,
  /**
   * A list of all the series.modality values that are actual acquisition modalities, i.e. those in
   * the DICOM Context Group 29 (value set OID 1.2.840.10008.6.1.19).
   */
  public val modality: List<Coding> = listOf(),
  /**
   * The subject, typically a patient, of the imaging study.
   *
   * QA phantoms can be recorded with a Device; multiple subjects (such as mice) can be recorded
   * with a Group.
   */
  public val subject: Reference,
  /**
   * The healthcare event (e.g. a patient and healthcare provider interaction) during which this
   * ImagingStudy is made.
   *
   * This will typically be the encounter the event occurred within, but some events may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter (e.g. pre-admission test).
   */
  public val encounter: Reference? = null,
  /** Date and time the study started. */
  public val started: DateTime? = null,
  /** A list of the diagnostic requests that resulted in this imaging study being performed. */
  public val basedOn: List<Reference> = listOf(),
  /** The requesting/referring physician. */
  public val referrer: Reference? = null,
  /** Who read the study and interpreted the images or other content. */
  public val interpreter: List<Reference> = listOf(),
  /**
   * The network service providing access (e.g., query, view, or retrieval) for the study. See
   * implementation notes for information about using DICOM endpoints. A study-level endpoint
   * applies to each series in the study, unless overridden by a series-level endpoint with the same
   * Endpoint.connectionType.
   *
   * Typical endpoint types include DICOM WADO-RS, which is used to retrieve DICOM instances in
   * native or rendered (e.g., JPG, PNG), formats using a RESTful API; DICOM WADO-URI, which can
   * similarly retrieve native or rendered instances, except using an HTTP query-based approach;
   * DICOM QIDO-RS, which allows RESTful query for DICOM information without retrieving the actual
   * instances; or IHE Invoke Image Display (IID), which provides standard invocation of an imaging
   * web viewer.
   */
  public val endpoint: List<Reference> = listOf(),
  /**
   * Number of Series in the Study. This value given may be larger than the number of series
   * elements this Resource contains due to resource availability, security, or other factors. This
   * element should be present if any series elements are present.
   */
  public val numberOfSeries: UnsignedInt? = null,
  /**
   * Number of SOP Instances in Study. This value given may be larger than the number of instance
   * elements this resource contains due to resource availability, security, or other factors. This
   * element should be present if any instance elements are present.
   */
  public val numberOfInstances: UnsignedInt? = null,
  /** The procedure which this ImagingStudy was part of. */
  public val procedureReference: Reference? = null,
  /** The code for the performed procedure type. */
  public val procedureCode: List<CodeableConcept> = listOf(),
  /** The principal physical location where the ImagingStudy was performed. */
  public val location: Reference? = null,
  /** Description of clinical condition indicating why the ImagingStudy was requested. */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /** Indicates another resource whose existence justifies this Study. */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * Per the recommended DICOM mapping, this element is derived from the Study Description attribute
   * (0008,1030). Observations or findings about the imaging study should be recorded in another
   * resource, e.g. Observation, and not in this element.
   */
  public val note: List<Annotation> = listOf(),
  /**
   * The Imaging Manager description of the study. Institution-generated description or
   * classification of the Study (component) performed.
   */
  public val description: String? = null,
  /** Each study has one or more series of images or other content. */
  public val series: List<Series> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, subject.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        modality = this@with.modality.map { it.toBuilder() }.toMutableList()
        encounter = this@with.encounter?.toBuilder()
        started = this@with.started?.toBuilder()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        referrer = this@with.referrer?.toBuilder()
        interpreter = this@with.interpreter.map { it.toBuilder() }.toMutableList()
        endpoint = this@with.endpoint.map { it.toBuilder() }.toMutableList()
        numberOfSeries = this@with.numberOfSeries?.toBuilder()
        numberOfInstances = this@with.numberOfInstances?.toBuilder()
        procedureReference = this@with.procedureReference?.toBuilder()
        procedureCode = this@with.procedureCode.map { it.toBuilder() }.toMutableList()
        location = this@with.location?.toBuilder()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        series = this@with.series.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Each study has one or more series of images or other content. */
  @Serializable(with = ImagingStudySeriesSerializer::class)
  public data class Series(
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
     * The DICOM Series Instance UID for the series.
     *
     * See
     * [DICOM PS3.3 C.7.3](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.3.html).
     */
    public val uid: Id,
    /** The numeric identifier of this series in the study. */
    public val number: UnsignedInt? = null,
    /** The modality of this series sequence. */
    public val modality: Coding,
    /** A description of the series. */
    public val description: String? = null,
    /**
     * Number of SOP Instances in the Study. The value given may be larger than the number of
     * instance elements this resource contains due to resource availability, security, or other
     * factors. This element should be present if any instance elements are present.
     */
    public val numberOfInstances: UnsignedInt? = null,
    /**
     * The network service providing access (e.g., query, view, or retrieval) for this series. See
     * implementation notes for information about using DICOM endpoints. A series-level endpoint, if
     * present, has precedence over a study-level endpoint with the same Endpoint.connectionType.
     *
     * Typical endpoint types include DICOM WADO-RS, which is used to retrieve DICOM instances in
     * native or rendered (e.g., JPG, PNG) formats using a RESTful API; DICOM WADO-URI, which can
     * similarly retrieve native or rendered instances, except using an HTTP query-based approach;
     * and DICOM QIDO-RS, which allows RESTful query for DICOM information without retrieving the
     * actual instances.
     */
    public val endpoint: List<Reference> = listOf(),
    /**
     * The anatomic structures examined. See DICOM Part 16 Annex L
     * (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM to
     * SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so, it
     * shall be consistent with any content of ImagingStudy.series.laterality.
     */
    public val bodySite: Coding? = null,
    /**
     * The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee,
     * both lungs, or unpaired abdomen. If present, shall be consistent with any laterality
     * information indicated in ImagingStudy.series.bodySite.
     */
    public val laterality: Coding? = null,
    /** The specimen imaged, e.g., for whole slide imaging of a biopsy. */
    public val specimen: List<Reference> = listOf(),
    /** The date and time the series was started. */
    public val started: DateTime? = null,
    /**
     * Indicates who or what performed the series and how they were involved.
     *
     * If the person who performed the series is not known, their Organization may be recorded. A
     * patient, or related person, may be the performer, e.g. for patient-captured images.
     */
    public val performer: List<Performer> = listOf(),
    /** A single SOP instance within the series, e.g. an image, or presentation state. */
    public val instance: List<Instance> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(uid.toBuilder(), modality.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          number = this@with.number?.toBuilder()
          description = this@with.description?.toBuilder()
          numberOfInstances = this@with.numberOfInstances?.toBuilder()
          endpoint = this@with.endpoint.map { it.toBuilder() }.toMutableList()
          bodySite = this@with.bodySite?.toBuilder()
          laterality = this@with.laterality?.toBuilder()
          specimen = this@with.specimen.map { it.toBuilder() }.toMutableList()
          started = this@with.started?.toBuilder()
          performer = this@with.performer.map { it.toBuilder() }.toMutableList()
          instance = this@with.instance.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Indicates who or what performed the series and how they were involved. */
    @Serializable(with = ImagingStudySeriesPerformerSerializer::class)
    public data class Performer(
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
      /** Distinguishes the type of involvement of the performer in the series. */
      public val function: CodeableConcept? = null,
      /** Indicates who or what performed the series. */
      public val actor: Reference,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(actor.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            function = this@with.function?.toBuilder()
          }
        }

      public class Builder(
        /** Indicates who or what performed the series. */
        public var actor: Reference.Builder
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

        /** Distinguishes the type of involvement of the performer in the series. */
        public var function: CodeableConcept.Builder? = null

        public fun build(): Performer =
          Performer(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            function = function?.build(),
            actor = actor.build(),
          )
      }
    }

    /** A single SOP instance within the series, e.g. an image, or presentation state. */
    @Serializable(with = ImagingStudySeriesInstanceSerializer::class)
    public data class Instance(
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
      /**
       * The DICOM SOP Instance UID for this image or other DICOM content.
       *
       * See
       * [DICOM PS3.3 C.12.1](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.12.html#sect_C.12.1).
       */
      public val uid: Id,
      /** DICOM instance type. */
      public val sopClass: Coding,
      /** The number of instance in the series. */
      public val number: UnsignedInt? = null,
      /**
       * The description of the instance.
       *
       * Particularly for post-acquisition analytic objects, such as SR, presentation states, value
       * mapping, etc.
       */
      public val title: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(uid.toBuilder(), sopClass.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            number = this@with.number?.toBuilder()
            title = this@with.title?.toBuilder()
          }
        }

      public class Builder(
        /**
         * The DICOM SOP Instance UID for this image or other DICOM content.
         *
         * See
         * [DICOM PS3.3 C.12.1](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.12.html#sect_C.12.1).
         */
        public var uid: Id.Builder,
        /** DICOM instance type. */
        public var sopClass: Coding.Builder,
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

        /** The number of instance in the series. */
        public var number: UnsignedInt.Builder? = null

        /**
         * The description of the instance.
         *
         * Particularly for post-acquisition analytic objects, such as SR, presentation states,
         * value mapping, etc.
         */
        public var title: String.Builder? = null

        public fun build(): Instance =
          Instance(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            uid = uid.build(),
            sopClass = sopClass.build(),
            number = number?.build(),
            title = title?.build(),
          )
      }
    }

    public class Builder(
      /**
       * The DICOM Series Instance UID for the series.
       *
       * See
       * [DICOM PS3.3 C.7.3](http://dicom.nema.org/medical/dicom/current/output/chtml/part03/sect_C.7.3.html).
       */
      public var uid: Id.Builder,
      /** The modality of this series sequence. */
      public var modality: Coding.Builder,
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

      /** The numeric identifier of this series in the study. */
      public var number: UnsignedInt.Builder? = null

      /** A description of the series. */
      public var description: String.Builder? = null

      /**
       * Number of SOP Instances in the Study. The value given may be larger than the number of
       * instance elements this resource contains due to resource availability, security, or other
       * factors. This element should be present if any instance elements are present.
       */
      public var numberOfInstances: UnsignedInt.Builder? = null

      /**
       * The network service providing access (e.g., query, view, or retrieval) for this series. See
       * implementation notes for information about using DICOM endpoints. A series-level endpoint,
       * if present, has precedence over a study-level endpoint with the same
       * Endpoint.connectionType.
       *
       * Typical endpoint types include DICOM WADO-RS, which is used to retrieve DICOM instances in
       * native or rendered (e.g., JPG, PNG) formats using a RESTful API; DICOM WADO-URI, which can
       * similarly retrieve native or rendered instances, except using an HTTP query-based approach;
       * and DICOM QIDO-RS, which allows RESTful query for DICOM information without retrieving the
       * actual instances.
       */
      public var endpoint: MutableList<Reference.Builder> = mutableListOf()

      /**
       * The anatomic structures examined. See DICOM Part 16 Annex L
       * (http://dicom.nema.org/medical/dicom/current/output/chtml/part16/chapter_L.html) for DICOM
       * to SNOMED-CT mappings. The bodySite may indicate the laterality of body part imaged; if so,
       * it shall be consistent with any content of ImagingStudy.series.laterality.
       */
      public var bodySite: Coding.Builder? = null

      /**
       * The laterality of the (possibly paired) anatomic structures examined. E.g., the left knee,
       * both lungs, or unpaired abdomen. If present, shall be consistent with any laterality
       * information indicated in ImagingStudy.series.bodySite.
       */
      public var laterality: Coding.Builder? = null

      /** The specimen imaged, e.g., for whole slide imaging of a biopsy. */
      public var specimen: MutableList<Reference.Builder> = mutableListOf()

      /** The date and time the series was started. */
      public var started: DateTime.Builder? = null

      /**
       * Indicates who or what performed the series and how they were involved.
       *
       * If the person who performed the series is not known, their Organization may be recorded. A
       * patient, or related person, may be the performer, e.g. for patient-captured images.
       */
      public var performer: MutableList<Performer.Builder> = mutableListOf()

      /** A single SOP instance within the series, e.g. an image, or presentation state. */
      public var instance: MutableList<Instance.Builder> = mutableListOf()

      public fun build(): Series =
        Series(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          uid = uid.build(),
          number = number?.build(),
          modality = modality.build(),
          description = description?.build(),
          numberOfInstances = numberOfInstances?.build(),
          endpoint = endpoint.map { it.build() },
          bodySite = bodySite?.build(),
          laterality = laterality?.build(),
          specimen = specimen.map { it.build() },
          started = started?.build(),
          performer = performer.map { it.build() },
          instance = instance.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The current state of the ImagingStudy.
     *
     * Unknown does not represent "other" - one of the defined statuses must apply. Unknown is used
     * when the authoring system is not sure what the current status is.
     */
    public var status: Enumeration<ImagingStudyStatus>,
    /**
     * The subject, typically a patient, of the imaging study.
     *
     * QA phantoms can be recorded with a Device; multiple subjects (such as mice) can be recorded
     * with a Group.
     */
    public var subject: Reference.Builder,
  ) : DomainResource.Builder() {
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

    /**
     * Identifiers for the ImagingStudy such as DICOM Study Instance UID, and Accession Number.
     *
     * See discussion under [Imaging Study Implementation Notes](imagingstudy.html#notes) for
     * encoding of DICOM Study Instance UID. Accession Number should use ACSN Identifier type.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A list of all the series.modality values that are actual acquisition modalities, i.e. those
     * in the DICOM Context Group 29 (value set OID 1.2.840.10008.6.1.19).
     */
    public var modality: MutableList<Coding.Builder> = mutableListOf()

    /**
     * The healthcare event (e.g. a patient and healthcare provider interaction) during which this
     * ImagingStudy is made.
     *
     * This will typically be the encounter the event occurred within, but some events may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter (e.g. pre-admission test).
     */
    public var encounter: Reference.Builder? = null

    /** Date and time the study started. */
    public var started: DateTime.Builder? = null

    /** A list of the diagnostic requests that resulted in this imaging study being performed. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /** The requesting/referring physician. */
    public var referrer: Reference.Builder? = null

    /** Who read the study and interpreted the images or other content. */
    public var interpreter: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The network service providing access (e.g., query, view, or retrieval) for the study. See
     * implementation notes for information about using DICOM endpoints. A study-level endpoint
     * applies to each series in the study, unless overridden by a series-level endpoint with the
     * same Endpoint.connectionType.
     *
     * Typical endpoint types include DICOM WADO-RS, which is used to retrieve DICOM instances in
     * native or rendered (e.g., JPG, PNG), formats using a RESTful API; DICOM WADO-URI, which can
     * similarly retrieve native or rendered instances, except using an HTTP query-based approach;
     * DICOM QIDO-RS, which allows RESTful query for DICOM information without retrieving the actual
     * instances; or IHE Invoke Image Display (IID), which provides standard invocation of an
     * imaging web viewer.
     */
    public var endpoint: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Number of Series in the Study. This value given may be larger than the number of series
     * elements this Resource contains due to resource availability, security, or other factors.
     * This element should be present if any series elements are present.
     */
    public var numberOfSeries: UnsignedInt.Builder? = null

    /**
     * Number of SOP Instances in Study. This value given may be larger than the number of instance
     * elements this resource contains due to resource availability, security, or other factors.
     * This element should be present if any instance elements are present.
     */
    public var numberOfInstances: UnsignedInt.Builder? = null

    /** The procedure which this ImagingStudy was part of. */
    public var procedureReference: Reference.Builder? = null

    /** The code for the performed procedure type. */
    public var procedureCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The principal physical location where the ImagingStudy was performed. */
    public var location: Reference.Builder? = null

    /** Description of clinical condition indicating why the ImagingStudy was requested. */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicates another resource whose existence justifies this Study. */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Per the recommended DICOM mapping, this element is derived from the Study Description
     * attribute (0008,1030). Observations or findings about the imaging study should be recorded in
     * another resource, e.g. Observation, and not in this element.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * The Imaging Manager description of the study. Institution-generated description or
     * classification of the Study (component) performed.
     */
    public var description: String.Builder? = null

    /** Each study has one or more series of images or other content. */
    public var series: MutableList<Series.Builder> = mutableListOf()

    override fun build(): ImagingStudy =
      ImagingStudy(
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
        modality = modality.map { it.build() },
        subject = subject.build(),
        encounter = encounter?.build(),
        started = started?.build(),
        basedOn = basedOn.map { it.build() },
        referrer = referrer?.build(),
        interpreter = interpreter.map { it.build() },
        endpoint = endpoint.map { it.build() },
        numberOfSeries = numberOfSeries?.build(),
        numberOfInstances = numberOfInstances?.build(),
        procedureReference = procedureReference?.build(),
        procedureCode = procedureCode.map { it.build() },
        location = location?.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        note = note.map { it.build() },
        description = description?.build(),
        series = series.map { it.build() },
      )
  }

  /** The status of the ImagingStudy. */
  public enum class ImagingStudyStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Registered("registered", "http://hl7.org/fhir/imagingstudy-status", "Registered"),
    Available("available", "http://hl7.org/fhir/imagingstudy-status", "Available"),
    Cancelled("cancelled", "http://hl7.org/fhir/imagingstudy-status", "Cancelled"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/imagingstudy-status",
      "Entered in Error",
    ),
    Unknown("unknown", "http://hl7.org/fhir/imagingstudy-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ImagingStudyStatus =
        when (code) {
          "registered" -> Registered
          "available" -> Available
          "cancelled" -> Cancelled
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum ImagingStudyStatus")
        }
    }
  }
}

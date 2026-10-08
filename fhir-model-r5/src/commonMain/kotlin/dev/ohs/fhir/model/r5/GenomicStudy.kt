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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.GenomicStudyAnalysisDeviceSerializer
import dev.ohs.fhir.model.r5.serializers.GenomicStudyAnalysisInputSerializer
import dev.ohs.fhir.model.r5.serializers.GenomicStudyAnalysisOutputSerializer
import dev.ohs.fhir.model.r5.serializers.GenomicStudyAnalysisPerformerSerializer
import dev.ohs.fhir.model.r5.serializers.GenomicStudyAnalysisSerializer
import dev.ohs.fhir.model.r5.serializers.GenomicStudySerializer
import dev.ohs.fhir.model.r5.terminologies.GenomicStudyStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A set of analyses performed to analyze and generate genomic data. */
@Serializable(with = GenomicStudySerializer::class)
@SerialName("GenomicStudy")
public data class GenomicStudy(
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
  /** Identifiers for this genomic study. */
  public val identifier: List<Identifier> = listOf(),
  /** The status of the genomic study. */
  public val status: Enumeration<GenomicStudyStatus>,
  /**
   * The type of the study, e.g., Familial variant segregation, Functional variation detection, or
   * Gene expression profiling.
   */
  public val type: List<CodeableConcept> = listOf(),
  /** The primary subject of the genomic study. */
  public val subject: Reference,
  /** The healthcare event with which this genomics study is associated. */
  public val encounter: Reference? = null,
  /** When the genomic study was started. */
  public val startDate: DateTime? = null,
  /** Event resources that the genomic study is based on. */
  public val basedOn: List<Reference> = listOf(),
  /** Healthcare professional who requested or referred the genomic study. */
  public val referrer: Reference? = null,
  /** Healthcare professionals who interpreted the genomic study. */
  public val interpreter: List<Reference> = listOf(),
  /** Why the genomic study was performed. */
  public val reason: List<CodeableReference> = listOf(),
  /** The defined protocol that describes the study. */
  public val instantiatesCanonical: Canonical? = null,
  /** The URL pointing to an externally maintained protocol that describes the study. */
  public val instantiatesUri: Uri? = null,
  /** Comments related to the genomic study. */
  public val note: List<Annotation> = listOf(),
  /** Description of the genomic study. */
  public val description: Markdown? = null,
  /** The details about a specific analysis that was performed in this GenomicStudy. */
  public val analysis: List<Analysis> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        status,
        subject.toBuilder(),
      )
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.mapToMutableList { it.toBuilder() }
    builder.extension = extension.mapToMutableList { it.toBuilder() }
    builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
    builder.identifier = identifier.mapToMutableList { it.toBuilder() }
    builder.type = type.mapToMutableList { it.toBuilder() }
    builder.encounter = encounter?.toBuilder()
    builder.startDate = startDate?.toBuilder()
    builder.basedOn = basedOn.mapToMutableList { it.toBuilder() }
    builder.referrer = referrer?.toBuilder()
    builder.interpreter = interpreter.mapToMutableList { it.toBuilder() }
    builder.reason = reason.mapToMutableList { it.toBuilder() }
    builder.instantiatesCanonical = instantiatesCanonical?.toBuilder()
    builder.instantiatesUri = instantiatesUri?.toBuilder()
    builder.note = note.mapToMutableList { it.toBuilder() }
    builder.description = description?.toBuilder()
    builder.analysis = analysis.mapToMutableList { it.toBuilder() }
    return builder
  }

  /** The details about a specific analysis that was performed in this GenomicStudy. */
  @Serializable(with = GenomicStudyAnalysisSerializer::class)
  public data class Analysis(
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
    /** Identifiers for the analysis event. */
    public val identifier: List<Identifier> = listOf(),
    /**
     * Type of the methods used in the analysis, e.g., Fluorescence in situ hybridization (FISH),
     * Karyotyping, or Microsatellite instability testing (MSI).
     */
    public val methodType: List<CodeableConcept> = listOf(),
    /**
     * Type of the genomic changes studied in the analysis, e.g., DNA, RNA, or amino acid change.
     */
    public val changeType: List<CodeableConcept> = listOf(),
    /** The reference genome build that is used in this analysis. */
    public val genomeBuild: CodeableConcept? = null,
    /** The defined protocol that describes the analysis. */
    public val instantiatesCanonical: Canonical? = null,
    /** The URL pointing to an externally maintained protocol that describes the analysis. */
    public val instantiatesUri: Uri? = null,
    /** Name of the analysis event (human friendly). */
    public val title: String? = null,
    /**
     * The focus of a genomic analysis when it is not the patient of record representing something
     * or someone associated with the patient such as a spouse, parent, child, or sibling. For
     * example, in trio testing, the GenomicStudy.subject would be the child (proband) and the
     * GenomicStudy.analysis.focus of a specific analysis would be the parent.
     *
     * If the focus of the analysis is not known, the value of this field SHALL use the data absent
     * extension.
     */
    public val focus: List<Reference> = listOf(),
    /** The specimen used in the analysis event. */
    public val specimen: List<Reference> = listOf(),
    /** The date of the analysis event. */
    public val date: DateTime? = null,
    /** Any notes capture with the analysis event. */
    public val note: List<Annotation> = listOf(),
    /** The protocol that was performed for the analysis event. */
    public val protocolPerformed: Reference? = null,
    /** The genomic regions to be studied in the analysis (BED file). */
    public val regionsStudied: List<Reference> = listOf(),
    /** Genomic regions actually called in the analysis event (BED file). */
    public val regionsCalled: List<Reference> = listOf(),
    /** Inputs for the analysis event. */
    public val input: List<Input> = listOf(),
    /** Outputs for the analysis event. */
    public val output: List<Output> = listOf(),
    /** Performer for the analysis event. */
    public val performer: List<Performer> = listOf(),
    /**
     * Devices used for the analysis (e.g., instruments, software), with settings and parameters.
     */
    public val device: List<Device> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.identifier = identifier.mapToMutableList { it.toBuilder() }
      builder.methodType = methodType.mapToMutableList { it.toBuilder() }
      builder.changeType = changeType.mapToMutableList { it.toBuilder() }
      builder.genomeBuild = genomeBuild?.toBuilder()
      builder.instantiatesCanonical = instantiatesCanonical?.toBuilder()
      builder.instantiatesUri = instantiatesUri?.toBuilder()
      builder.title = title?.toBuilder()
      builder.focus = focus.mapToMutableList { it.toBuilder() }
      builder.specimen = specimen.mapToMutableList { it.toBuilder() }
      builder.date = date?.toBuilder()
      builder.note = note.mapToMutableList { it.toBuilder() }
      builder.protocolPerformed = protocolPerformed?.toBuilder()
      builder.regionsStudied = regionsStudied.mapToMutableList { it.toBuilder() }
      builder.regionsCalled = regionsCalled.mapToMutableList { it.toBuilder() }
      builder.input = input.mapToMutableList { it.toBuilder() }
      builder.output = output.mapToMutableList { it.toBuilder() }
      builder.performer = performer.mapToMutableList { it.toBuilder() }
      builder.device = device.mapToMutableList { it.toBuilder() }
      return builder
    }

    /** Inputs for the analysis event. */
    @Serializable(with = GenomicStudyAnalysisInputSerializer::class)
    public data class Input(
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
      /** File containing input data. */
      public val `file`: Reference? = null,
      /** Type of input data, e.g., BAM, CRAM, or FASTA. */
      public val type: CodeableConcept? = null,
      /** The analysis event or other GenomicStudy that generated this input file. */
      public val generatedBy: GeneratedBy? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.mapToMutableList { it.toBuilder() }
        builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
        builder.`file` = `file`?.toBuilder()
        builder.type = type?.toBuilder()
        builder.generatedBy = generatedBy
        return builder
      }

      public sealed interface GeneratedBy : FhirChoice {
        public fun asIdentifier(): Identifier? = this as? Identifier

        public fun asReference(): Reference? = this as? Reference

        public data class Identifier(override val `value`: dev.ohs.fhir.model.r5.Identifier) :
          GeneratedBy

        public data class Reference(override val `value`: dev.ohs.fhir.model.r5.Reference) :
          GeneratedBy

        public companion object {
          internal fun from(
            identifierValue: dev.ohs.fhir.model.r5.Identifier?,
            referenceValue: dev.ohs.fhir.model.r5.Reference?,
          ): GeneratedBy? {
            if (identifierValue != null) return Identifier(identifierValue)
            if (referenceValue != null) return Reference(referenceValue)
            return null
          }
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

        /** File containing input data. */
        public var `file`: Reference.Builder? = null

        /** Type of input data, e.g., BAM, CRAM, or FASTA. */
        public var type: CodeableConcept.Builder? = null

        /** The analysis event or other GenomicStudy that generated this input file. */
        public var generatedBy: GeneratedBy? = null

        public fun build(): Input =
          Input(
            id = id,
            extension = extension.mapToList { it.build() },
            modifierExtension = modifierExtension.mapToList { it.build() },
            `file` = `file`?.build(),
            type = type?.build(),
            generatedBy = generatedBy,
          )
      }
    }

    /** Outputs for the analysis event. */
    @Serializable(with = GenomicStudyAnalysisOutputSerializer::class)
    public data class Output(
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
      /** File containing output data. */
      public val `file`: Reference? = null,
      /** Type of output data, e.g., VCF, MAF, or BAM. */
      public val type: CodeableConcept? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.mapToMutableList { it.toBuilder() }
        builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
        builder.`file` = `file`?.toBuilder()
        builder.type = type?.toBuilder()
        return builder
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

        /** File containing output data. */
        public var `file`: Reference.Builder? = null

        /** Type of output data, e.g., VCF, MAF, or BAM. */
        public var type: CodeableConcept.Builder? = null

        public fun build(): Output =
          Output(
            id = id,
            extension = extension.mapToList { it.build() },
            modifierExtension = modifierExtension.mapToList { it.build() },
            `file` = `file`?.build(),
            type = type?.build(),
          )
      }
    }

    /** Performer for the analysis event. */
    @Serializable(with = GenomicStudyAnalysisPerformerSerializer::class)
    public data class Performer(
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
       * The organization, healthcare professional, or others who participated in performing this
       * analysis.
       */
      public val actor: Reference? = null,
      /** Role of the actor for this analysis. */
      public val role: CodeableConcept? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.mapToMutableList { it.toBuilder() }
        builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
        builder.actor = actor?.toBuilder()
        builder.role = role?.toBuilder()
        return builder
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

        /**
         * The organization, healthcare professional, or others who participated in performing this
         * analysis.
         */
        public var actor: Reference.Builder? = null

        /** Role of the actor for this analysis. */
        public var role: CodeableConcept.Builder? = null

        public fun build(): Performer =
          Performer(
            id = id,
            extension = extension.mapToList { it.build() },
            modifierExtension = modifierExtension.mapToList { it.build() },
            actor = actor?.build(),
            role = role?.build(),
          )
      }
    }

    /**
     * Devices used for the analysis (e.g., instruments, software), with settings and parameters.
     */
    @Serializable(with = GenomicStudyAnalysisDeviceSerializer::class)
    public data class Device(
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
      /** Device used for the analysis. */
      public val device: Reference? = null,
      /** Specific function for the device used for the analysis. */
      public val function: CodeableConcept? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.mapToMutableList { it.toBuilder() }
        builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
        builder.device = device?.toBuilder()
        builder.function = function?.toBuilder()
        return builder
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

        /** Device used for the analysis. */
        public var device: Reference.Builder? = null

        /** Specific function for the device used for the analysis. */
        public var function: CodeableConcept.Builder? = null

        public fun build(): Device =
          Device(
            id = id,
            extension = extension.mapToList { it.build() },
            modifierExtension = modifierExtension.mapToList { it.build() },
            device = device?.build(),
            function = function?.build(),
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

      /** Identifiers for the analysis event. */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /**
       * Type of the methods used in the analysis, e.g., Fluorescence in situ hybridization (FISH),
       * Karyotyping, or Microsatellite instability testing (MSI).
       */
      public var methodType: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Type of the genomic changes studied in the analysis, e.g., DNA, RNA, or amino acid change.
       */
      public var changeType: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The reference genome build that is used in this analysis. */
      public var genomeBuild: CodeableConcept.Builder? = null

      /** The defined protocol that describes the analysis. */
      public var instantiatesCanonical: Canonical.Builder? = null

      /** The URL pointing to an externally maintained protocol that describes the analysis. */
      public var instantiatesUri: Uri.Builder? = null

      /** Name of the analysis event (human friendly). */
      public var title: String.Builder? = null

      /**
       * The focus of a genomic analysis when it is not the patient of record representing something
       * or someone associated with the patient such as a spouse, parent, child, or sibling. For
       * example, in trio testing, the GenomicStudy.subject would be the child (proband) and the
       * GenomicStudy.analysis.focus of a specific analysis would be the parent.
       *
       * If the focus of the analysis is not known, the value of this field SHALL use the data
       * absent extension.
       */
      public var focus: MutableList<Reference.Builder> = mutableListOf()

      /** The specimen used in the analysis event. */
      public var specimen: MutableList<Reference.Builder> = mutableListOf()

      /** The date of the analysis event. */
      public var date: DateTime.Builder? = null

      /** Any notes capture with the analysis event. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      /** The protocol that was performed for the analysis event. */
      public var protocolPerformed: Reference.Builder? = null

      /** The genomic regions to be studied in the analysis (BED file). */
      public var regionsStudied: MutableList<Reference.Builder> = mutableListOf()

      /** Genomic regions actually called in the analysis event (BED file). */
      public var regionsCalled: MutableList<Reference.Builder> = mutableListOf()

      /** Inputs for the analysis event. */
      public var input: MutableList<Input.Builder> = mutableListOf()

      /** Outputs for the analysis event. */
      public var output: MutableList<Output.Builder> = mutableListOf()

      /** Performer for the analysis event. */
      public var performer: MutableList<Performer.Builder> = mutableListOf()

      /**
       * Devices used for the analysis (e.g., instruments, software), with settings and parameters.
       */
      public var device: MutableList<Device.Builder> = mutableListOf()

      public fun build(): Analysis =
        Analysis(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          identifier = identifier.mapToList { it.build() },
          methodType = methodType.mapToList { it.build() },
          changeType = changeType.mapToList { it.build() },
          genomeBuild = genomeBuild?.build(),
          instantiatesCanonical = instantiatesCanonical?.build(),
          instantiatesUri = instantiatesUri?.build(),
          title = title?.build(),
          focus = focus.mapToList { it.build() },
          specimen = specimen.mapToList { it.build() },
          date = date?.build(),
          note = note.mapToList { it.build() },
          protocolPerformed = protocolPerformed?.build(),
          regionsStudied = regionsStudied.mapToList { it.build() },
          regionsCalled = regionsCalled.mapToList { it.build() },
          input = input.mapToList { it.build() },
          output = output.mapToList { it.build() },
          performer = performer.mapToList { it.build() },
          device = device.mapToList { it.build() },
        )
    }
  }

  public class Builder(
    /** The status of the genomic study. */
    public var status: Enumeration<GenomicStudyStatus>,
    /** The primary subject of the genomic study. */
    public var subject: Reference.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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

    /** Identifiers for this genomic study. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The type of the study, e.g., Familial variant segregation, Functional variation detection, or
     * Gene expression profiling.
     */
    public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The healthcare event with which this genomics study is associated. */
    public var encounter: Reference.Builder? = null

    /** When the genomic study was started. */
    public var startDate: DateTime.Builder? = null

    /** Event resources that the genomic study is based on. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /** Healthcare professional who requested or referred the genomic study. */
    public var referrer: Reference.Builder? = null

    /** Healthcare professionals who interpreted the genomic study. */
    public var interpreter: MutableList<Reference.Builder> = mutableListOf()

    /** Why the genomic study was performed. */
    public var reason: MutableList<CodeableReference.Builder> = mutableListOf()

    /** The defined protocol that describes the study. */
    public var instantiatesCanonical: Canonical.Builder? = null

    /** The URL pointing to an externally maintained protocol that describes the study. */
    public var instantiatesUri: Uri.Builder? = null

    /** Comments related to the genomic study. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** Description of the genomic study. */
    public var description: Markdown.Builder? = null

    /** The details about a specific analysis that was performed in this GenomicStudy. */
    public var analysis: MutableList<Analysis.Builder> = mutableListOf()

    override fun build(): GenomicStudy =
      GenomicStudy(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.mapToList { it.build() },
        extension = extension.mapToList { it.build() },
        modifierExtension = modifierExtension.mapToList { it.build() },
        identifier = identifier.mapToList { it.build() },
        status = status,
        type = type.mapToList { it.build() },
        subject = subject.build(),
        encounter = encounter?.build(),
        startDate = startDate?.build(),
        basedOn = basedOn.mapToList { it.build() },
        referrer = referrer?.build(),
        interpreter = interpreter.mapToList { it.build() },
        reason = reason.mapToList { it.build() },
        instantiatesCanonical = instantiatesCanonical?.build(),
        instantiatesUri = instantiatesUri?.build(),
        note = note.mapToList { it.build() },
        description = description?.build(),
        analysis = analysis.mapToList { it.build() },
      )
  }
}

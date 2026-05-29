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

import dev.ohs.fhir.model.r5.serializers.MolecularSequenceRelativeEditSerializer
import dev.ohs.fhir.model.r5.serializers.MolecularSequenceRelativeSerializer
import dev.ohs.fhir.model.r5.serializers.MolecularSequenceRelativeStartingSequenceSerializer
import dev.ohs.fhir.model.r5.serializers.MolecularSequenceSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Representation of a molecular sequence. */
@Serializable(with = MolecularSequenceSerializer::class)
@SerialName("MolecularSequence")
public data class MolecularSequence(
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
  /** A unique identifier for this particular sequence instance. */
  public val identifier: List<Identifier> = listOf(),
  /** Amino Acid Sequence/ DNA Sequence / RNA Sequence. */
  public val type: Enumeration<SequenceType>? = null,
  /** Indicates the subject this sequence is associated too. */
  public val subject: Reference? = null,
  /**
   * The actual focus of a molecular sequence when it is not the patient of record representing
   * something or someone associated with the patient such as a spouse, parent, child, or sibling.
   * For example, in trio testing, the subject would be the child (proband) and the focus would be
   * the parent.
   */
  public val focus: List<Reference> = listOf(),
  /** Specimen used for sequencing. */
  public val specimen: Reference? = null,
  /** The method for sequencing, for example, chip information. */
  public val device: Reference? = null,
  /** The organization or lab that should be responsible for this result. */
  public val performer: Reference? = null,
  /** Sequence that was observed. */
  public val literal: String? = null,
  /**
   * Sequence that was observed as file content. Can be an actual file contents, or referenced by a
   * URL to an external system.
   */
  public val formatted: List<Attachment> = listOf(),
  /** A sequence defined relative to another sequence. */
  public val relative: List<Relative> = listOf(),
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
        type = this@with.type
        subject = this@with.subject?.toBuilder()
        focus = this@with.focus.map { it.toBuilder() }.toMutableList()
        specimen = this@with.specimen?.toBuilder()
        device = this@with.device?.toBuilder()
        performer = this@with.performer?.toBuilder()
        literal = this@with.literal?.toBuilder()
        formatted = this@with.formatted.map { it.toBuilder() }.toMutableList()
        relative = this@with.relative.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A sequence defined relative to another sequence. */
  @Serializable(with = MolecularSequenceRelativeSerializer::class)
  public data class Relative(
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
     * These are different ways of identifying nucleotides or amino acids within a sequence.
     * Different databases and file types may use different systems. For detail definitions, see
     * https://loinc.org/92822-6/ for more detail.
     */
    public val coordinateSystem: CodeableConcept,
    /**
     * Indicates the order in which the sequence should be considered when putting multiple
     * 'relative' elements together.
     */
    public val ordinalPosition: Integer? = null,
    /**
     * Indicates the nucleotide range in the composed sequence when multiple 'relative' elements are
     * used together.
     */
    public val sequenceRange: Range? = null,
    /**
     * A sequence that is used as a starting sequence to describe variants that are present in a
     * sequence analyzed.
     */
    public val startingSequence: StartingSequence? = null,
    /** Changes in sequence from the starting sequence. */
    public val edit: List<Edit> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(coordinateSystem.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          ordinalPosition = this@with.ordinalPosition?.toBuilder()
          sequenceRange = this@with.sequenceRange?.toBuilder()
          startingSequence = this@with.startingSequence?.toBuilder()
          edit = this@with.edit.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * A sequence that is used as a starting sequence to describe variants that are present in a
     * sequence analyzed.
     */
    @Serializable(with = MolecularSequenceRelativeStartingSequenceSerializer::class)
    public data class StartingSequence(
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
      /** The genome assembly used for starting sequence, e.g. GRCh38. */
      public val genomeAssembly: CodeableConcept? = null,
      /**
       * Structural unit composed of a nucleic acid molecule which controls its own replication
       * through the interaction of specific proteins at one or more origins of replication
       * ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).
       */
      public val chromosome: CodeableConcept? = null,
      /**
       * The reference sequence that represents the starting sequence.
       *
       * A starting sequence may be represented in one of three ways:
       * 1. CodeableConcept, using NCBI, LRG or other appropriate code systems
       * 1. a simple string of IUPAC codes
       * 1. a reference to another MolecularSequence resource.
       */
      public val sequence: Sequence? = null,
      /**
       * Start position of the window on the starting sequence. This value should honor the rules of
       * the coordinateSystem.
       */
      public val windowStart: Integer? = null,
      /**
       * End position of the window on the starting sequence. This value should honor the rules of
       * the coordinateSystem.
       */
      public val windowEnd: Integer? = null,
      /**
       * A relative reference to a DNA strand based on gene orientation. The strand that contains
       * the open reading frame of the gene is the "sense" strand, and the opposite complementary
       * strand is the "antisense" strand.
       */
      public val orientation: Enumeration<OrientationType>? = null,
      /**
       * An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the
       * short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long
       * arm.
       */
      public val strand: Enumeration<StrandType>? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            genomeAssembly = this@with.genomeAssembly?.toBuilder()
            chromosome = this@with.chromosome?.toBuilder()
            sequence = this@with.sequence
            windowStart = this@with.windowStart?.toBuilder()
            windowEnd = this@with.windowEnd?.toBuilder()
            orientation = this@with.orientation
            strand = this@with.strand
          }
        }

      public sealed interface Sequence {
        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public fun asString(): String? = this as? String

        public fun asReference(): Reference? = this as? Reference

        @JvmInline
        public value class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
        ) : Sequence

        @JvmInline
        public value class String(public val `value`: dev.ohs.fhir.model.r5.String) : Sequence

        @JvmInline
        public value class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) :
          Sequence

        public companion object {
          internal fun from(
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
            stringValue: dev.ohs.fhir.model.r5.String?,
            referenceValue: dev.ohs.fhir.model.r5.Reference?,
          ): Sequence? {
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (stringValue != null) return String(stringValue)
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

        /** The genome assembly used for starting sequence, e.g. GRCh38. */
        public var genomeAssembly: CodeableConcept.Builder? = null

        /**
         * Structural unit composed of a nucleic acid molecule which controls its own replication
         * through the interaction of specific proteins at one or more origins of replication
         * ([SO:0000340](http://www.sequenceontology.org/browser/current_svn/term/SO:0000340)).
         */
        public var chromosome: CodeableConcept.Builder? = null

        /**
         * The reference sequence that represents the starting sequence.
         *
         * A starting sequence may be represented in one of three ways:
         * 1. CodeableConcept, using NCBI, LRG or other appropriate code systems
         * 1. a simple string of IUPAC codes
         * 1. a reference to another MolecularSequence resource.
         */
        public var sequence: Sequence? = null

        /**
         * Start position of the window on the starting sequence. This value should honor the rules
         * of the coordinateSystem.
         */
        public var windowStart: Integer.Builder? = null

        /**
         * End position of the window on the starting sequence. This value should honor the rules of
         * the coordinateSystem.
         */
        public var windowEnd: Integer.Builder? = null

        /**
         * A relative reference to a DNA strand based on gene orientation. The strand that contains
         * the open reading frame of the gene is the "sense" strand, and the opposite complementary
         * strand is the "antisense" strand.
         */
        public var orientation: Enumeration<OrientationType>? = null

        /**
         * An absolute reference to a strand. The Watson strand is the strand whose 5'-end is on the
         * short arm of the chromosome, and the Crick strand as the one whose 5'-end is on the long
         * arm.
         */
        public var strand: Enumeration<StrandType>? = null

        public fun build(): StartingSequence =
          StartingSequence(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            genomeAssembly = genomeAssembly?.build(),
            chromosome = chromosome?.build(),
            sequence = sequence,
            windowStart = windowStart?.build(),
            windowEnd = windowEnd?.build(),
            orientation = orientation,
            strand = strand,
          )
      }
    }

    /** Changes in sequence from the starting sequence. */
    @Serializable(with = MolecularSequenceRelativeEditSerializer::class)
    public data class Edit(
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
       * Start position of the edit on the starting sequence. If the coordinate system is either
       * 0-based or 1-based, then start position is inclusive.
       */
      public val start: Integer? = null,
      /**
       * End position of the edit on the starting sequence. If the coordinate system is 0-based then
       * end is exclusive and does not include the last position. If the coordinate system is
       * 1-base, then end is inclusive and includes the last position.
       */
      public val end: Integer? = null,
      /**
       * Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to stop
       * position of sequence on the positive (+) strand of the observed sequence. When the sequence
       * type is DNA, it should be the sequence on the positive (+) strand. This will lay in the
       * range between variant.start and variant.end.
       */
      public val replacementSequence: String? = null,
      /**
       * Allele in the starting sequence. Nucleotide(s)/amino acids from start position of sequence
       * to stop position of sequence on the positive (+) strand of the starting sequence. When the
       * sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay
       * in the range between variant.start and variant.end.
       */
      public val replacedSequence: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            start = this@with.start?.toBuilder()
            end = this@with.end?.toBuilder()
            replacementSequence = this@with.replacementSequence?.toBuilder()
            replacedSequence = this@with.replacedSequence?.toBuilder()
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

        /**
         * Start position of the edit on the starting sequence. If the coordinate system is either
         * 0-based or 1-based, then start position is inclusive.
         */
        public var start: Integer.Builder? = null

        /**
         * End position of the edit on the starting sequence. If the coordinate system is 0-based
         * then end is exclusive and does not include the last position. If the coordinate system is
         * 1-base, then end is inclusive and includes the last position.
         */
        public var end: Integer.Builder? = null

        /**
         * Allele that was observed. Nucleotide(s)/amino acids from start position of sequence to
         * stop position of sequence on the positive (+) strand of the observed sequence. When the
         * sequence type is DNA, it should be the sequence on the positive (+) strand. This will lay
         * in the range between variant.start and variant.end.
         */
        public var replacementSequence: String.Builder? = null

        /**
         * Allele in the starting sequence. Nucleotide(s)/amino acids from start position of
         * sequence to stop position of sequence on the positive (+) strand of the starting
         * sequence. When the sequence type is DNA, it should be the sequence on the positive (+)
         * strand. This will lay in the range between variant.start and variant.end.
         */
        public var replacedSequence: String.Builder? = null

        public fun build(): Edit =
          Edit(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            start = start?.build(),
            end = end?.build(),
            replacementSequence = replacementSequence?.build(),
            replacedSequence = replacedSequence?.build(),
          )
      }
    }

    public class Builder(
      /**
       * These are different ways of identifying nucleotides or amino acids within a sequence.
       * Different databases and file types may use different systems. For detail definitions, see
       * https://loinc.org/92822-6/ for more detail.
       */
      public var coordinateSystem: CodeableConcept.Builder
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
       * Indicates the order in which the sequence should be considered when putting multiple
       * 'relative' elements together.
       */
      public var ordinalPosition: Integer.Builder? = null

      /**
       * Indicates the nucleotide range in the composed sequence when multiple 'relative' elements
       * are used together.
       */
      public var sequenceRange: Range.Builder? = null

      /**
       * A sequence that is used as a starting sequence to describe variants that are present in a
       * sequence analyzed.
       */
      public var startingSequence: StartingSequence.Builder? = null

      /** Changes in sequence from the starting sequence. */
      public var edit: MutableList<Edit.Builder> = mutableListOf()

      public fun build(): Relative =
        Relative(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          coordinateSystem = coordinateSystem.build(),
          ordinalPosition = ordinalPosition?.build(),
          sequenceRange = sequenceRange?.build(),
          startingSequence = startingSequence?.build(),
          edit = edit.map { it.build() },
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

    /** A unique identifier for this particular sequence instance. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Amino Acid Sequence/ DNA Sequence / RNA Sequence. */
    public var type: Enumeration<SequenceType>? = null

    /** Indicates the subject this sequence is associated too. */
    public var subject: Reference.Builder? = null

    /**
     * The actual focus of a molecular sequence when it is not the patient of record representing
     * something or someone associated with the patient such as a spouse, parent, child, or sibling.
     * For example, in trio testing, the subject would be the child (proband) and the focus would be
     * the parent.
     */
    public var focus: MutableList<Reference.Builder> = mutableListOf()

    /** Specimen used for sequencing. */
    public var specimen: Reference.Builder? = null

    /** The method for sequencing, for example, chip information. */
    public var device: Reference.Builder? = null

    /** The organization or lab that should be responsible for this result. */
    public var performer: Reference.Builder? = null

    /** Sequence that was observed. */
    public var literal: String.Builder? = null

    /**
     * Sequence that was observed as file content. Can be an actual file contents, or referenced by
     * a URL to an external system.
     */
    public var formatted: MutableList<Attachment.Builder> = mutableListOf()

    /** A sequence defined relative to another sequence. */
    public var relative: MutableList<Relative.Builder> = mutableListOf()

    override fun build(): MolecularSequence =
      MolecularSequence(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        type = type,
        subject = subject?.build(),
        focus = focus.map { it.build() },
        specimen = specimen?.build(),
        device = device?.build(),
        performer = performer?.build(),
        literal = literal?.build(),
        formatted = formatted.map { it.build() },
        relative = relative.map { it.build() },
      )
  }

  /** Type for orientation. */
  public enum class OrientationType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Sense("sense", "http://hl7.org/fhir/orientation-type", "Sense orientation of referenceSeq"),
    Antisense(
      "antisense",
      "http://hl7.org/fhir/orientation-type",
      "Antisense orientation of referenceSeq",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): OrientationType =
        when (code) {
          "sense" -> Sense
          "antisense" -> Antisense
          else -> throw IllegalArgumentException("Unknown code $code for enum OrientationType")
        }
    }
  }

  /** Type for strand. */
  public enum class StrandType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Watson("watson", "http://hl7.org/fhir/strand-type", "Watson strand of starting sequence"),
    Crick("crick", "http://hl7.org/fhir/strand-type", "Crick strand of starting sequence");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): StrandType =
        when (code) {
          "watson" -> Watson
          "crick" -> Crick
          else -> throw IllegalArgumentException("Unknown code $code for enum StrandType")
        }
    }
  }

  /** Type if a sequence -- DNA, RNA, or amino acid sequence. */
  public enum class SequenceType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Aa("aa", "http://hl7.org/fhir/sequence-type", "AA Sequence"),
    Dna("dna", "http://hl7.org/fhir/sequence-type", "DNA Sequence"),
    Rna("rna", "http://hl7.org/fhir/sequence-type", "RNA Sequence");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SequenceType =
        when (code) {
          "aa" -> Aa
          "dna" -> Dna
          "rna" -> Rna
          else -> throw IllegalArgumentException("Unknown code $code for enum SequenceType")
        }
    }
  }
}

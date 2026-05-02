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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.serializers.SubstanceProteinSerializer
import com.google.fhir.model.r5.serializers.SubstanceProteinSubunitSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination
 * of subunits that are either covalently linked or have a defined invariant stoichiometric
 * relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined
 * sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to
 * describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein
 * hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.
 */
@Serializable(with = SubstanceProteinSerializer::class)
@SerialName("SubstanceProtein")
public data class SubstanceProtein(
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
   * The SubstanceProtein descriptive elements will only be used when a complete or partial amino
   * acid sequence is available or derivable from a nucleic acid sequence.
   */
  public val sequenceType: CodeableConcept? = null,
  /**
   * Number of linear sequences of amino acids linked through peptide bonds. The number of subunits
   * constituting the SubstanceProtein shall be described. It is possible that the number of
   * subunits can be variable.
   */
  public val numberOfSubunits: Integer? = null,
  /**
   * The disulphide bond between two cysteine residues either on the same subunit or on two
   * different subunits shall be described. The position of the disulfide bonds in the
   * SubstanceProtein shall be listed in increasing order of subunit number and position within
   * subunit followed by the abbreviation of the amino acids involved. The disulfide linkage
   * positions shall actually contain the amino acid Cysteine at the respective positions.
   */
  public val disulfideLinkage: List<String> = listOf(),
  /**
   * This subclause refers to the description of each subunit constituting the SubstanceProtein. A
   * subunit is a linear sequence of amino acids linked through peptide bonds. The Subunit
   * information shall be provided when the finished SubstanceProtein is a complex of multiple
   * sequences; subunits are not used to delineate domains within a single sequence. Subunits are
   * listed in order of decreasing length; sequences of the same length will be ordered by
   * decreasing molecular weight; subunits that have identical sequences will be repeated multiple
   * times.
   */
  public val subunit: List<Subunit> = listOf(),
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
        sequenceType = this@with.sequenceType?.toBuilder()
        numberOfSubunits = this@with.numberOfSubunits?.toBuilder()
        disulfideLinkage = this@with.disulfideLinkage.map { it.toBuilder() }.toMutableList()
        subunit = this@with.subunit.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * This subclause refers to the description of each subunit constituting the SubstanceProtein. A
   * subunit is a linear sequence of amino acids linked through peptide bonds. The Subunit
   * information shall be provided when the finished SubstanceProtein is a complex of multiple
   * sequences; subunits are not used to delineate domains within a single sequence. Subunits are
   * listed in order of decreasing length; sequences of the same length will be ordered by
   * decreasing molecular weight; subunits that have identical sequences will be repeated multiple
   * times.
   */
  @Serializable(with = SubstanceProteinSubunitSerializer::class)
  public data class Subunit(
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
     * Index of primary sequences of amino acids linked through peptide bonds in order of decreasing
     * length. Sequences of the same length will be ordered by molecular weight. Subunits that have
     * identical sequences will be repeated and have sequential subscripts.
     */
    public val subunit: Integer? = null,
    /**
     * The sequence information shall be provided enumerating the amino acids from N- to C-terminal
     * end using standard single-letter amino acid codes. Uppercase shall be used for L-amino acids
     * and lowercase for D-amino acids. Transcribed SubstanceProteins will always be described using
     * the translated sequence; for synthetic peptide containing amino acids that are not
     * represented with a single letter code an X should be used within the sequence. The modified
     * amino acids will be distinguished by their position in the sequence.
     */
    public val sequence: String? = null,
    /** Length of linear sequences of amino acids contained in the subunit. */
    public val length: Integer? = null,
    /**
     * The sequence information shall be provided enumerating the amino acids from N- to C-terminal
     * end using standard single-letter amino acid codes. Uppercase shall be used for L-amino acids
     * and lowercase for D-amino acids. Transcribed SubstanceProteins will always be described using
     * the translated sequence; for synthetic peptide containing amino acids that are not
     * represented with a single letter code an X should be used within the sequence. The modified
     * amino acids will be distinguished by their position in the sequence.
     */
    public val sequenceAttachment: Attachment? = null,
    /**
     * Unique identifier for molecular fragment modification based on the ISO 11238 Substance ID.
     */
    public val nTerminalModificationId: Identifier? = null,
    /**
     * The name of the fragment modified at the N-terminal of the SubstanceProtein shall be
     * specified.
     */
    public val nTerminalModification: String? = null,
    /**
     * Unique identifier for molecular fragment modification based on the ISO 11238 Substance ID.
     */
    public val cTerminalModificationId: Identifier? = null,
    /** The modification at the C-terminal shall be specified. */
    public val cTerminalModification: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          subunit = this@with.subunit?.toBuilder()
          sequence = this@with.sequence?.toBuilder()
          length = this@with.length?.toBuilder()
          sequenceAttachment = this@with.sequenceAttachment?.toBuilder()
          nTerminalModificationId = this@with.nTerminalModificationId?.toBuilder()
          nTerminalModification = this@with.nTerminalModification?.toBuilder()
          cTerminalModificationId = this@with.cTerminalModificationId?.toBuilder()
          cTerminalModification = this@with.cTerminalModification?.toBuilder()
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

      /**
       * Index of primary sequences of amino acids linked through peptide bonds in order of
       * decreasing length. Sequences of the same length will be ordered by molecular weight.
       * Subunits that have identical sequences will be repeated and have sequential subscripts.
       */
      public var subunit: Integer.Builder? = null

      /**
       * The sequence information shall be provided enumerating the amino acids from N- to
       * C-terminal end using standard single-letter amino acid codes. Uppercase shall be used for
       * L-amino acids and lowercase for D-amino acids. Transcribed SubstanceProteins will always be
       * described using the translated sequence; for synthetic peptide containing amino acids that
       * are not represented with a single letter code an X should be used within the sequence. The
       * modified amino acids will be distinguished by their position in the sequence.
       */
      public var sequence: String.Builder? = null

      /** Length of linear sequences of amino acids contained in the subunit. */
      public var length: Integer.Builder? = null

      /**
       * The sequence information shall be provided enumerating the amino acids from N- to
       * C-terminal end using standard single-letter amino acid codes. Uppercase shall be used for
       * L-amino acids and lowercase for D-amino acids. Transcribed SubstanceProteins will always be
       * described using the translated sequence; for synthetic peptide containing amino acids that
       * are not represented with a single letter code an X should be used within the sequence. The
       * modified amino acids will be distinguished by their position in the sequence.
       */
      public var sequenceAttachment: Attachment.Builder? = null

      /**
       * Unique identifier for molecular fragment modification based on the ISO 11238 Substance ID.
       */
      public var nTerminalModificationId: Identifier.Builder? = null

      /**
       * The name of the fragment modified at the N-terminal of the SubstanceProtein shall be
       * specified.
       */
      public var nTerminalModification: String.Builder? = null

      /**
       * Unique identifier for molecular fragment modification based on the ISO 11238 Substance ID.
       */
      public var cTerminalModificationId: Identifier.Builder? = null

      /** The modification at the C-terminal shall be specified. */
      public var cTerminalModification: String.Builder? = null

      public fun build(): Subunit =
        Subunit(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          subunit = subunit?.build(),
          sequence = sequence?.build(),
          length = length?.build(),
          sequenceAttachment = sequenceAttachment?.build(),
          nTerminalModificationId = nTerminalModificationId?.build(),
          nTerminalModification = nTerminalModification?.build(),
          cTerminalModificationId = cTerminalModificationId?.build(),
          cTerminalModification = cTerminalModification?.build(),
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
     * The SubstanceProtein descriptive elements will only be used when a complete or partial amino
     * acid sequence is available or derivable from a nucleic acid sequence.
     */
    public var sequenceType: CodeableConcept.Builder? = null

    /**
     * Number of linear sequences of amino acids linked through peptide bonds. The number of
     * subunits constituting the SubstanceProtein shall be described. It is possible that the number
     * of subunits can be variable.
     */
    public var numberOfSubunits: Integer.Builder? = null

    /**
     * The disulphide bond between two cysteine residues either on the same subunit or on two
     * different subunits shall be described. The position of the disulfide bonds in the
     * SubstanceProtein shall be listed in increasing order of subunit number and position within
     * subunit followed by the abbreviation of the amino acids involved. The disulfide linkage
     * positions shall actually contain the amino acid Cysteine at the respective positions.
     */
    public var disulfideLinkage: MutableList<String.Builder> = mutableListOf()

    /**
     * This subclause refers to the description of each subunit constituting the SubstanceProtein. A
     * subunit is a linear sequence of amino acids linked through peptide bonds. The Subunit
     * information shall be provided when the finished SubstanceProtein is a complex of multiple
     * sequences; subunits are not used to delineate domains within a single sequence. Subunits are
     * listed in order of decreasing length; sequences of the same length will be ordered by
     * decreasing molecular weight; subunits that have identical sequences will be repeated multiple
     * times.
     */
    public var subunit: MutableList<Subunit.Builder> = mutableListOf()

    override fun build(): SubstanceProtein =
      SubstanceProtein(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        sequenceType = sequenceType?.build(),
        numberOfSubunits = numberOfSubunits?.build(),
        disulfideLinkage = disulfideLinkage.map { it.build() },
        subunit = subunit.map { it.build() },
      )
  }
}

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

import dev.ohs.fhir.model.r5.serializers.EvidenceReportRelatesToSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceReportRelatesToTargetSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceReportSectionSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceReportSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceReportSubjectCharacteristicSerializer
import dev.ohs.fhir.model.r5.serializers.EvidenceReportSubjectSerializer
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The EvidenceReport Resource is a specialized container for a collection of resources and codeable
 * concepts, adapted to support compositions of Evidence, EvidenceVariable, and Citation resources
 * and related concepts.
 */
@Serializable(with = EvidenceReportSerializer::class)
@SerialName("EvidenceReport")
public data class EvidenceReport(
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
   * An absolute URI that is used to identify this EvidenceReport when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which an authoritative instance of this
   * summary is (or will be) published. This URL can be the target of a canonical reference. It
   * SHALL remain the same when the summary is stored on different servers.
   *
   * Can be a urn:uuid: or a urn:oid: but real http: addresses are preferred. Multiple instances may
   * share the same URL if they have a distinct version.
   */
  public val url: Uri? = null,
  /**
   * The status of this summary. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of summaries that are appropriate for use versus not.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate evidence report instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A formal identifier that is used to identify this EvidenceReport when it is represented in
   * other formats, or referenced in a specification, model, design or an instance.
   *
   * This element will contain unique identifiers that support de-duplication of EvidenceReports.
   * This identifier can be valid for only one EvidenceReport resource.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * A formal identifier that is used to identify things closely related to this EvidenceReport.
   *
   * May include trial registry identifiers, e.g. NCT04372602 from clinicaltrials.gov. This
   * identifier can be valid for multiple EvidenceReport resources.
   */
  public val relatedIdentifier: List<Identifier> = listOf(),
  /**
   * Citation Resource or display of suggested citation for this report.
   *
   * used for reports for which external citation is expected, such as use in support of scholarly
   * publications.
   */
  public val citeAs: CiteAs? = null,
  /**
   * Specifies the kind of report, such as grouping of classifiers, search results, or
   * human-compiled expression.
   */
  public val type: CodeableConcept? = null,
  /** Used for footnotes and annotations. */
  public val note: List<Annotation> = listOf(),
  /** Link, description or reference to artifact associated with the report. */
  public val relatedArtifact: List<RelatedArtifact> = listOf(),
  /**
   * Specifies the subject or focus of the report. Answers "What is this report about?".
   *
   * May be used as an expression for search queries and search results
   */
  public val subject: Subject,
  /**
   * The name of the organization or individual responsible for the release and ongoing maintenance
   * of the evidence report.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the evidence
   * report is the organization or individual primarily responsible for the maintenance and upkeep
   * of the evidence report. This is not necessarily the same individual or organization that
   * developed and initially authored the content. The publisher is the primary point of contact for
   * questions or issues with the evidence report. This item SHOULD be populated unless the
   * information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * An individiual, organization, or device primarily involved in the creation and maintenance of
   * the content.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   */
  public val author: List<ContactDetail> = listOf(),
  /**
   * An individiual, organization, or device primarily responsible for internal coherence of the
   * content.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   */
  public val editor: List<ContactDetail> = listOf(),
  /**
   * An individiual, organization, or device primarily responsible for review of some aspect of the
   * content.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val reviewer: List<ContactDetail> = listOf(),
  /**
   * An individiual, organization, or device responsible for officially endorsing the content for
   * use in some setting.
   *
   * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
   * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val endorser: List<ContactDetail> = listOf(),
  /**
   * Relationships that this composition has with other compositions or documents that already
   * exist.
   *
   * A document is a version specific composition.
   */
  public val relatesTo: List<RelatesTo> = listOf(),
  /** The root of the sections that make up the composition. */
  public val section: List<Section> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          subject.toBuilder(),
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
          url = this@with.url?.toBuilder()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          relatedIdentifier = this@with.relatedIdentifier.map { it.toBuilder() }.toMutableList()
          citeAs = this@with.citeAs
          type = this@with.type?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          relatedArtifact = this@with.relatedArtifact.map { it.toBuilder() }.toMutableList()
          publisher = this@with.publisher?.toBuilder()
          contact = this@with.contact.map { it.toBuilder() }.toMutableList()
          author = this@with.author.map { it.toBuilder() }.toMutableList()
          editor = this@with.editor.map { it.toBuilder() }.toMutableList()
          reviewer = this@with.reviewer.map { it.toBuilder() }.toMutableList()
          endorser = this@with.endorser.map { it.toBuilder() }.toMutableList()
          relatesTo = this@with.relatesTo.map { it.toBuilder() }.toMutableList()
          section = this@with.section.map { it.toBuilder() }.toMutableList()
        }
    }

  /** Specifies the subject or focus of the report. Answers "What is this report about?". */
  @Serializable(with = EvidenceReportSubjectSerializer::class)
  public data class Subject(
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
    /** Characteristic. */
    public val characteristic: List<Characteristic> = listOf(),
    /** Used for general notes and annotations not coded elsewhere. */
    public val note: List<Annotation> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          characteristic = this@with.characteristic.map { it.toBuilder() }.toMutableList()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Characteristic. */
    @Serializable(with = EvidenceReportSubjectCharacteristicSerializer::class)
    public data class Characteristic(
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
       * Characteristic code.
       *
       * Example 1 is a Citation. Example 2 is a type of outcome. Example 3 is a specific outcome.
       */
      public val code: CodeableConcept,
      /**
       * Characteristic value.
       *
       * Example 1 is Citation #37. Example 2 is selecting clinical outcomes. Example 3 is 1-year
       * mortality.
       */
      public val `value`: Value,
      /** Is used to express not the characteristic. */
      public val exclude: Boolean? = null,
      /** Timeframe for the characteristic. */
      public val period: Period? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(
              code.toBuilder(),
              `value`,
            )
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              exclude = this@with.exclude?.toBuilder()
              period = this@with.period?.toBuilder()
            }
        }

      public sealed interface Value {
        public fun asReference(): Reference? = this as? Reference

        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public fun asBoolean(): Boolean? = this as? Boolean

        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asRange(): Range? = this as? Range

        public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
        ) : Value

        public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

        public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

        public companion object {
          internal fun from(
            referenceValue: dev.ohs.fhir.model.r5.Reference?,
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
            booleanValue: dev.ohs.fhir.model.r5.Boolean?,
            quantityValue: dev.ohs.fhir.model.r5.Quantity?,
            rangeValue: dev.ohs.fhir.model.r5.Range?,
          ): Value? {
            if (referenceValue != null) return Reference(referenceValue)
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (booleanValue != null) return Boolean(booleanValue)
            if (quantityValue != null) return Quantity(quantityValue)
            if (rangeValue != null) return Range(rangeValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * Characteristic code.
         *
         * Example 1 is a Citation. Example 2 is a type of outcome. Example 3 is a specific outcome.
         */
        public var code: CodeableConcept.Builder,
        /**
         * Characteristic value.
         *
         * Example 1 is Citation #37. Example 2 is selecting clinical outcomes. Example 3 is 1-year
         * mortality.
         */
        public var `value`: Value,
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

        /** Is used to express not the characteristic. */
        public var exclude: Boolean.Builder? = null

        /** Timeframe for the characteristic. */
        public var period: Period.Builder? = null

        public fun build(): Characteristic =
          Characteristic(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            code = code.build(),
            `value` = `value`,
            exclude = exclude?.build(),
            period = period?.build(),
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

      /** Characteristic. */
      public var characteristic: MutableList<Characteristic.Builder> = mutableListOf()

      /** Used for general notes and annotations not coded elsewhere. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      public fun build(): Subject =
        Subject(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          characteristic = characteristic.map { it.build() },
          note = note.map { it.build() },
        )
    }
  }

  /**
   * Relationships that this composition has with other compositions or documents that already
   * exist.
   */
  @Serializable(with = EvidenceReportRelatesToSerializer::class)
  public data class RelatesTo(
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
     * The type of relationship that this composition has with anther composition or document.
     *
     * If this document appends another document, then the document cannot be fully understood
     * without also accessing the referenced document.
     */
    public val code: Enumeration<ReportRelationshipType>,
    /** The target composition/document of this relationship. */
    public val target: Target,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            code,
            target.toBuilder(),
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
      }

    /** The target composition/document of this relationship. */
    @Serializable(with = EvidenceReportRelatesToTargetSerializer::class)
    public data class Target(
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
      /** Target of the relationship URL. */
      public val url: Uri? = null,
      /** Target of the relationship Identifier. */
      public val identifier: Identifier? = null,
      /** Target of the relationship Display. */
      public val display: Markdown? = null,
      /** Target of the relationship Resource reference. */
      public val resource: Reference? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            url = this@with.url?.toBuilder()
            identifier = this@with.identifier?.toBuilder()
            display = this@with.display?.toBuilder()
            resource = this@with.resource?.toBuilder()
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

        /** Target of the relationship URL. */
        public var url: Uri.Builder? = null

        /** Target of the relationship Identifier. */
        public var identifier: Identifier.Builder? = null

        /** Target of the relationship Display. */
        public var display: Markdown.Builder? = null

        /** Target of the relationship Resource reference. */
        public var resource: Reference.Builder? = null

        public fun build(): Target =
          Target(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            url = url?.build(),
            identifier = identifier?.build(),
            display = display?.build(),
            resource = resource?.build(),
          )
      }
    }

    public class Builder(
      /**
       * The type of relationship that this composition has with anther composition or document.
       *
       * If this document appends another document, then the document cannot be fully understood
       * without also accessing the referenced document.
       */
      public var code: Enumeration<ReportRelationshipType>,
      /** The target composition/document of this relationship. */
      public var target: Target.Builder,
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

      public fun build(): RelatesTo =
        RelatesTo(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code,
          target = target.build(),
        )
    }
  }

  /** The root of the sections that make up the composition. */
  @Serializable(with = EvidenceReportSectionSerializer::class)
  public data class Section(
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
     * The label for this particular section. This will be part of the rendered content for the
     * document, and is often used to build a table of contents.
     *
     * The title identifies the section for a human reader. The title must be consistent with the
     * narrative of the resource that is the target of the section.content reference. Generally,
     * sections SHOULD have titles, but in some documents, it is unnecessary or inappropriate.
     * Typically, this is where a section has subsections that have their own adequately
     * distinguishing title, or documents that only have a single section.
     */
    public val title: String? = null,
    /**
     * A code identifying the kind of content contained within the section. This should be
     * consistent with the section title.
     *
     * The code identifies the section for an automated processor of the document. This is
     * particularly relevant when using profiles to control the structure of the document.
     *
     * If the section has content (instead of sub-sections), the section.code does not change the
     * meaning or interpretation of the resource that is the content of the section in the comments
     * for the section.code.
     */
    public val focus: CodeableConcept? = null,
    /**
     * A definitional Resource identifying the kind of content contained within the section. This
     * should be consistent with the section title.
     */
    public val focusReference: Reference? = null,
    /**
     * Identifies who is responsible for the information in this section, not necessarily who typed
     * it in.
     */
    public val author: List<Reference> = listOf(),
    /**
     * A human-readable narrative that contains the attested content of the section, used to
     * represent the content of the resource to a human. The narrative need not encode all the
     * structured data, but is peferred to contain sufficient detail to make it acceptable for a
     * human to just read the narrative.
     *
     * Document profiles may define what content should be represented in the narrative.
     */
    public val text: Narrative? = null,
    /**
     * How the entry list was prepared - whether it is a working list that is suitable for being
     * maintained on an ongoing basis, or if it represents a snapshot of a list of items from
     * another source, or whether it is a prepared list where items may be marked as added, modified
     * or deleted.
     *
     * This element is labeled as a modifier because a change list must not be misunderstood as a
     * complete list.
     */
    public val mode: Enumeration<ListMode>? = null,
    /**
     * Specifies the order applied to the items in the section entries.
     *
     * Applications SHOULD render ordered lists in the order provided, but MAY allow users to
     * re-order based on their own preferences as well. If there is no order specified, the order is
     * unknown, though there may still be some order.
     */
    public val orderedBy: CodeableConcept? = null,
    /** Specifies any type of classification of the evidence report. */
    public val entryClassifier: List<CodeableConcept> = listOf(),
    /**
     * A reference to the actual resource from which the narrative in the section is derived.
     *
     * If there are no entries in the list, an emptyReason SHOULD be provided.
     */
    public val entryReference: List<Reference> = listOf(),
    /** Quantity as content. */
    public val entryQuantity: List<Quantity> = listOf(),
    /**
     * If the section is empty, why the list is empty. An empty section typically has some text
     * explaining the empty reason.
     *
     * The various reasons for an empty section make a significant interpretation to its
     * interpretation. Note that this code is for use when the entire section content has been
     * suppressed, and not for when individual items are omitted - implementers may consider using a
     * text note or a flag on an entry in these cases.
     */
    public val emptyReason: CodeableConcept? = null,
    /**
     * A nested sub-section within this section.
     *
     * Nested sections are primarily used to help human readers navigate to particular portions of
     * the document.
     */
    public val section: List<Section> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          title = this@with.title?.toBuilder()
          focus = this@with.focus?.toBuilder()
          focusReference = this@with.focusReference?.toBuilder()
          author = this@with.author.map { it.toBuilder() }.toMutableList()
          text = this@with.text?.toBuilder()
          mode = this@with.mode
          orderedBy = this@with.orderedBy?.toBuilder()
          entryClassifier = this@with.entryClassifier.map { it.toBuilder() }.toMutableList()
          entryReference = this@with.entryReference.map { it.toBuilder() }.toMutableList()
          entryQuantity = this@with.entryQuantity.map { it.toBuilder() }.toMutableList()
          emptyReason = this@with.emptyReason?.toBuilder()
          section = this@with.section.map { it.toBuilder() }.toMutableList()
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
       * The label for this particular section. This will be part of the rendered content for the
       * document, and is often used to build a table of contents.
       *
       * The title identifies the section for a human reader. The title must be consistent with the
       * narrative of the resource that is the target of the section.content reference. Generally,
       * sections SHOULD have titles, but in some documents, it is unnecessary or inappropriate.
       * Typically, this is where a section has subsections that have their own adequately
       * distinguishing title, or documents that only have a single section.
       */
      public var title: String.Builder? = null

      /**
       * A code identifying the kind of content contained within the section. This should be
       * consistent with the section title.
       *
       * The code identifies the section for an automated processor of the document. This is
       * particularly relevant when using profiles to control the structure of the document.
       *
       * If the section has content (instead of sub-sections), the section.code does not change the
       * meaning or interpretation of the resource that is the content of the section in the
       * comments for the section.code.
       */
      public var focus: CodeableConcept.Builder? = null

      /**
       * A definitional Resource identifying the kind of content contained within the section. This
       * should be consistent with the section title.
       */
      public var focusReference: Reference.Builder? = null

      /**
       * Identifies who is responsible for the information in this section, not necessarily who
       * typed it in.
       */
      public var author: MutableList<Reference.Builder> = mutableListOf()

      /**
       * A human-readable narrative that contains the attested content of the section, used to
       * represent the content of the resource to a human. The narrative need not encode all the
       * structured data, but is peferred to contain sufficient detail to make it acceptable for a
       * human to just read the narrative.
       *
       * Document profiles may define what content should be represented in the narrative.
       */
      public var text: Narrative.Builder? = null

      /**
       * How the entry list was prepared - whether it is a working list that is suitable for being
       * maintained on an ongoing basis, or if it represents a snapshot of a list of items from
       * another source, or whether it is a prepared list where items may be marked as added,
       * modified or deleted.
       *
       * This element is labeled as a modifier because a change list must not be misunderstood as a
       * complete list.
       */
      public var mode: Enumeration<ListMode>? = null

      /**
       * Specifies the order applied to the items in the section entries.
       *
       * Applications SHOULD render ordered lists in the order provided, but MAY allow users to
       * re-order based on their own preferences as well. If there is no order specified, the order
       * is unknown, though there may still be some order.
       */
      public var orderedBy: CodeableConcept.Builder? = null

      /** Specifies any type of classification of the evidence report. */
      public var entryClassifier: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * A reference to the actual resource from which the narrative in the section is derived.
       *
       * If there are no entries in the list, an emptyReason SHOULD be provided.
       */
      public var entryReference: MutableList<Reference.Builder> = mutableListOf()

      /** Quantity as content. */
      public var entryQuantity: MutableList<Quantity.Builder> = mutableListOf()

      /**
       * If the section is empty, why the list is empty. An empty section typically has some text
       * explaining the empty reason.
       *
       * The various reasons for an empty section make a significant interpretation to its
       * interpretation. Note that this code is for use when the entire section content has been
       * suppressed, and not for when individual items are omitted - implementers may consider using
       * a text note or a flag on an entry in these cases.
       */
      public var emptyReason: CodeableConcept.Builder? = null

      /**
       * A nested sub-section within this section.
       *
       * Nested sections are primarily used to help human readers navigate to particular portions of
       * the document.
       */
      public var section: MutableList<Builder> = mutableListOf()

      public fun build(): Section =
        Section(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          title = title?.build(),
          focus = focus?.build(),
          focusReference = focusReference?.build(),
          author = author.map { it.build() },
          text = text?.build(),
          mode = mode,
          orderedBy = orderedBy?.build(),
          entryClassifier = entryClassifier.map { it.build() },
          entryReference = entryReference.map { it.build() },
          entryQuantity = entryQuantity.map { it.build() },
          emptyReason = emptyReason?.build(),
          section = section.map { it.build() },
        )
    }
  }

  public sealed interface CiteAs {
    public fun asReference(): Reference? = this as? Reference

    public fun asMarkdown(): Markdown? = this as? Markdown

    public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : CiteAs

    public data class Markdown(public val `value`: dev.ohs.fhir.model.r5.Markdown) : CiteAs

    public companion object {
      internal fun from(
        referenceValue: dev.ohs.fhir.model.r5.Reference?,
        markdownValue: dev.ohs.fhir.model.r5.Markdown?,
      ): CiteAs? {
        if (referenceValue != null) return Reference(referenceValue)
        if (markdownValue != null) return Markdown(markdownValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The status of this summary. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of summaries that are appropriate for use versus not.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var status: Enumeration<PublicationStatus>,
    /**
     * Specifies the subject or focus of the report. Answers "What is this report about?".
     *
     * May be used as an expression for search queries and search results
     */
    public var subject: Subject.Builder,
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

    /**
     * An absolute URI that is used to identify this EvidenceReport when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance
     * of this summary is (or will be) published. This URL can be the target of a canonical
     * reference. It SHALL remain the same when the summary is stored on different servers.
     *
     * Can be a urn:uuid: or a urn:oid: but real http: addresses are preferred. Multiple instances
     * may share the same URL if they have a distinct version.
     */
    public var url: Uri.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate evidence report instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A formal identifier that is used to identify this EvidenceReport when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     *
     * This element will contain unique identifiers that support de-duplication of EvidenceReports.
     * This identifier can be valid for only one EvidenceReport resource.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A formal identifier that is used to identify things closely related to this EvidenceReport.
     *
     * May include trial registry identifiers, e.g. NCT04372602 from clinicaltrials.gov. This
     * identifier can be valid for multiple EvidenceReport resources.
     */
    public var relatedIdentifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Citation Resource or display of suggested citation for this report.
     *
     * used for reports for which external citation is expected, such as use in support of scholarly
     * publications.
     */
    public var citeAs: CiteAs? = null

    /**
     * Specifies the kind of report, such as grouping of classifiers, search results, or
     * human-compiled expression.
     */
    public var type: CodeableConcept.Builder? = null

    /** Used for footnotes and annotations. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** Link, description or reference to artifact associated with the report. */
    public var relatedArtifact: MutableList<RelatedArtifact.Builder> = mutableListOf()

    /**
     * The name of the organization or individual responsible for the release and ongoing
     * maintenance of the evidence report.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the evidence
     * report is the organization or individual primarily responsible for the maintenance and upkeep
     * of the evidence report. This is not necessarily the same individual or organization that
     * developed and initially authored the content. The publisher is the primary point of contact
     * for questions or issues with the evidence report. This item SHOULD be populated unless the
     * information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individiual, organization, or device primarily involved in the creation and maintenance of
     * the content.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     */
    public var author: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individiual, organization, or device primarily responsible for internal coherence of the
     * content.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     */
    public var editor: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individiual, organization, or device primarily responsible for review of some aspect of
     * the content.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var reviewer: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individiual, organization, or device responsible for officially endorsing the content for
     * use in some setting.
     *
     * Extensions to ContactDetail include: contactReference, contactAddress, and contributionTime
     * (see [Clinical Reasoning Module](clinicalreasoning-module.html)).
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var endorser: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * Relationships that this composition has with other compositions or documents that already
     * exist.
     *
     * A document is a version specific composition.
     */
    public var relatesTo: MutableList<RelatesTo.Builder> = mutableListOf()

    /** The root of the sections that make up the composition. */
    public var section: MutableList<Section.Builder> = mutableListOf()

    override fun build(): EvidenceReport =
      EvidenceReport(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url?.build(),
        status = status,
        useContext = useContext.map { it.build() },
        identifier = identifier.map { it.build() },
        relatedIdentifier = relatedIdentifier.map { it.build() },
        citeAs = citeAs,
        type = type?.build(),
        note = note.map { it.build() },
        relatedArtifact = relatedArtifact.map { it.build() },
        subject = subject.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        author = author.map { it.build() },
        editor = editor.map { it.build() },
        reviewer = reviewer.map { it.build() },
        endorser = endorser.map { it.build() },
        relatesTo = relatesTo.map { it.build() },
        section = section.map { it.build() },
      )
  }

  /** The type of relationship between reports. */
  public enum class ReportRelationshipType(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Replaces("replaces", "http://hl7.org/fhir/report-relation-type", "Replaces"),
    Amends("amends", "http://hl7.org/fhir/report-relation-type", "Amends"),
    Appends("appends", "http://hl7.org/fhir/report-relation-type", "Appends"),
    Transforms("transforms", "http://hl7.org/fhir/report-relation-type", "Transforms"),
    ReplacedWith("replacedWith", "http://hl7.org/fhir/report-relation-type", "Replaced With"),
    AmendedWith("amendedWith", "http://hl7.org/fhir/report-relation-type", "Amended With"),
    AppendedWith("appendedWith", "http://hl7.org/fhir/report-relation-type", "Appended With"),
    TransformedWith(
      "transformedWith",
      "http://hl7.org/fhir/report-relation-type",
      "Transformed With",
    );

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ReportRelationshipType =
        when (code) {
          "replaces" -> Replaces
          "amends" -> Amends
          "appends" -> Appends
          "transforms" -> Transforms
          "replacedWith" -> ReplacedWith
          "amendedWith" -> AmendedWith
          "appendedWith" -> AppendedWith
          "transformedWith" -> TransformedWith
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ReportRelationshipType")
        }
    }
  }

  /** The processing mode that applies to this list. */
  public enum class ListMode(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Working("working", "http://hl7.org/fhir/list-mode", "Working List"),
    Snapshot("snapshot", "http://hl7.org/fhir/list-mode", "Snapshot List"),
    Changes("changes", "http://hl7.org/fhir/list-mode", "Change List");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): ListMode =
        when (code) {
          "working" -> Working
          "snapshot" -> Snapshot
          "changes" -> Changes
          else -> throw IllegalArgumentException("Unknown code $code for enum ListMode")
        }
    }
  }
}

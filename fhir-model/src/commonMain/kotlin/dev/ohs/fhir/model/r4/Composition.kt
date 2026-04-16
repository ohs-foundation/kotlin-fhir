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

import dev.ohs.fhir.model.r4.serializers.CompositionAttesterSerializer
import dev.ohs.fhir.model.r4.serializers.CompositionEventSerializer
import dev.ohs.fhir.model.r4.serializers.CompositionRelatesToSerializer
import dev.ohs.fhir.model.r4.serializers.CompositionRelatesToTargetSerializer
import dev.ohs.fhir.model.r4.serializers.CompositionSectionSerializer
import dev.ohs.fhir.model.r4.serializers.CompositionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A set of healthcare-related information that is assembled together into a single logical package
 * that provides a single coherent statement of meaning, establishes its own context and that has
 * clinical attestation with regard to who is making the statement. A Composition defines the
 * structure and narrative content necessary for a document. However, a Composition alone does not
 * constitute a document. Rather, the Composition must be the first entry in a Bundle where
 * Bundle.type=document, and any other resources referenced from Composition must be included as
 * subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).
 */
@Serializable(with = CompositionSerializer::class)
@SerialName("Composition")
public data class Composition(
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
   * A version-independent identifier for the Composition. This identifier stays constant as the
   * composition is changed over time.
   *
   * Similar to ClinicalDocument/setId in CDA. See discussion in resource definition for how these
   * relate.
   */
  public val identifier: Identifier? = null,
  /**
   * The workflow/clinical status of this composition. The status is a marker for the clinical
   * standing of the document.
   *
   * If a composition is marked as withdrawn, the compositions/documents in the series, or data from
   * the composition or document series, should never be displayed to a user without being clearly
   * marked as untrustworthy. The flag "entered-in-error" is why this element is labeled as a
   * modifier of other elements.
   *
   * Some reporting work flows require that the original narrative of a final document never be
   * altered; instead, only new narrative can be added. The composition resource has no explicit
   * status for explicitly noting whether this business rule is in effect. This would be handled by
   * an extension if required.
   */
  public val status: Enumeration<CompositionStatus>,
  /**
   * Specifies the particular kind of composition (e.g. History and Physical, Discharge Summary,
   * Progress Note). This usually equates to the purpose of making the composition.
   *
   * For Composition type, LOINC is ubiquitous and strongly endorsed by HL7. Most implementation
   * guides will require a specific LOINC code, or use LOINC as an extensible binding.
   */
  public val type: CodeableConcept,
  /**
   * A categorization for the type of the composition - helps for indexing and searching. This may
   * be implied by or derived from the code specified in the Composition Type.
   *
   * This is a metadata field from
   * [XDS/MHD](http://wiki.ihe.net/index.php?title=Mobile_access_to_Health_Documents_(MHD)).
   */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * Who or what the composition is about. The composition can be about a person, (patient or
   * healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a
   * document about a herd of livestock, or a set of patients that share a common exposure).
   *
   * For clinical documents, this is usually the patient.
   */
  public val subject: Reference? = null,
  /** Describes the clinical encounter or type of care this documentation is associated with. */
  public val encounter: Reference? = null,
  /**
   * The composition editing time, when the composition was last logically changed by the author.
   *
   * The Last Modified Date on the composition may be after the date of the document was attested
   * without being changed.
   */
  public val date: DateTime,
  /**
   * Identifies who is responsible for the information in the composition, not necessarily who typed
   * it in.
   */
  public val author: List<Reference>,
  /**
   * Official human-readable label for the composition.
   *
   * For many compositions, the title is the same as the text or a display name of Composition.type
   * (e.g. a "consultation" or "progress note"). Note that CDA does not make title mandatory, but
   * there are no known cases where it is useful for title to be omitted, so it is mandatory here.
   * Feedback on this requirement is welcome during the trial use period.
   */
  public val title: String,
  /**
   * The code specifying the level of confidentiality of the Composition.
   *
   * The exact use of this element, and enforcement and issues related to highly sensitive documents
   * are out of scope for the base specification, and delegated to implementation profiles (see
   * security section). This element is labeled as a modifier because highly confidential documents
   * must not be treated as if they are not.
   */
  public val confidentiality: Enumeration<V3ConfidentialityClassification>? = null,
  /**
   * A participant who has attested to the accuracy of the composition/document.
   *
   * Only list each attester once.
   */
  public val attester: List<Attester> = listOf(),
  /**
   * Identifies the organization or group who is responsible for ongoing maintenance of and access
   * to the composition/document information.
   *
   * This is useful when documents are derived from a composition - provides guidance for how to get
   * the latest version of the document. This is optional because this is sometimes not known by the
   * authoring system, and can be inferred by context. However, it is important that this
   * information be known when working with a derived document, so providing a custodian is
   * encouraged.
   */
  public val custodian: Reference? = null,
  /**
   * Relationships that this composition has with other compositions or documents that already
   * exist.
   *
   * A document is a version specific composition.
   */
  public val relatesTo: List<RelatesTo> = listOf(),
  /**
   * The clinical service, such as a colonoscopy or an appendectomy, being documented.
   *
   * The event needs to be consistent with the type element, though can provide further information
   * if desired.
   */
  public val event: List<Event> = listOf(),
  /** The root of the sections that make up the composition. */
  public val section: List<Section> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          type.toBuilder(),
          date.toBuilder(),
          author.map { it.toBuilder() }.toMutableList(),
          title.toBuilder(),
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
          identifier = this@with.identifier?.toBuilder()
          category = this@with.category.map { it.toBuilder() }.toMutableList()
          subject = this@with.subject?.toBuilder()
          encounter = this@with.encounter?.toBuilder()
          confidentiality = this@with.confidentiality
          attester = this@with.attester.map { it.toBuilder() }.toMutableList()
          custodian = this@with.custodian?.toBuilder()
          relatesTo = this@with.relatesTo.map { it.toBuilder() }.toMutableList()
          event = this@with.event.map { it.toBuilder() }.toMutableList()
          section = this@with.section.map { it.toBuilder() }.toMutableList()
        }
    }

  /** A participant who has attested to the accuracy of the composition/document. */
  @Serializable(with = CompositionAttesterSerializer::class)
  public data class Attester(
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
    /** The type of attestation the authenticator offers. */
    public val mode: Enumeration<CompositionAttestationMode>,
    /** When the composition was attested by the party. */
    public val time: DateTime? = null,
    /** Who attested the composition in the specified way. */
    public val party: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(mode).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          time = this@with.time?.toBuilder()
          party = this@with.party?.toBuilder()
        }
      }

    public class Builder(
      /** The type of attestation the authenticator offers. */
      public var mode: Enumeration<CompositionAttestationMode>
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

      /** When the composition was attested by the party. */
      public var time: DateTime.Builder? = null

      /** Who attested the composition in the specified way. */
      public var party: Reference.Builder? = null

      public fun build(): Attester =
        Attester(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          mode = mode,
          time = time?.build(),
          party = party?.build(),
        )
    }
  }

  /**
   * Relationships that this composition has with other compositions or documents that already
   * exist.
   */
  @Serializable(with = CompositionRelatesToSerializer::class)
  public data class RelatesTo(
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
     * The type of relationship that this composition has with anther composition or document.
     *
     * If this document appends another document, then the document cannot be fully understood
     * without also accessing the referenced document.
     */
    public val code: Enumeration<DocumentRelationshipType>,
    /** The target composition/document of this relationship. */
    public val target: Target,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code, target).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    @Serializable(with = CompositionRelatesToTargetSerializer::class)
    public sealed interface Target {
      public fun asIdentifier(): Identifier? = this as? Identifier

      public fun asReference(): Reference? = this as? Reference

      public data class Identifier(public val `value`: dev.ohs.fhir.model.r4.Identifier) : Target

      public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Target

      public companion object {
        internal fun from(
          identifierValue: dev.ohs.fhir.model.r4.Identifier?,
          referenceValue: dev.ohs.fhir.model.r4.Reference?,
        ): Target? {
          if (identifierValue != null) return Identifier(identifierValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * The type of relationship that this composition has with anther composition or document.
       *
       * If this document appends another document, then the document cannot be fully understood
       * without also accessing the referenced document.
       */
      public var code: Enumeration<DocumentRelationshipType>,
      /** The target composition/document of this relationship. */
      public var target: Target,
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

      public fun build(): RelatesTo =
        RelatesTo(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code,
          target = target,
        )
    }
  }

  /** The clinical service, such as a colonoscopy or an appendectomy, being documented. */
  @Serializable(with = CompositionEventSerializer::class)
  public data class Event(
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
     * This list of codes represents the main clinical acts, such as a colonoscopy or an
     * appendectomy, being documented. In some cases, the event is inherent in the typeCode, such as
     * a "History and Physical Report" in which the procedure being documented is necessarily a
     * "History and Physical" act.
     *
     * An event can further specialize the act inherent in the typeCode, such as where it is simply
     * "Procedure Report" and the procedure was a "colonoscopy". If one or more eventCodes are
     * included, they SHALL NOT conflict with the values inherent in the classCode,
     * practiceSettingCode or typeCode, as such a conflict would create an ambiguous situation. This
     * short list of codes is provided to be used as key words for certain types of queries.
     */
    public val code: List<CodeableConcept> = listOf(),
    /**
     * The period of time covered by the documentation. There is no assertion that the documentation
     * is a complete representation for this period, only that it documents events during this time.
     */
    public val period: Period? = null,
    /**
     * The description and/or reference of the event(s) being documented. For example, this could be
     * used to document such a colonoscopy or an appendectomy.
     */
    public val detail: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          code = this@with.code.map { it.toBuilder() }.toMutableList()
          period = this@with.period?.toBuilder()
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
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
       * This list of codes represents the main clinical acts, such as a colonoscopy or an
       * appendectomy, being documented. In some cases, the event is inherent in the typeCode, such
       * as a "History and Physical Report" in which the procedure being documented is necessarily a
       * "History and Physical" act.
       *
       * An event can further specialize the act inherent in the typeCode, such as where it is
       * simply "Procedure Report" and the procedure was a "colonoscopy". If one or more eventCodes
       * are included, they SHALL NOT conflict with the values inherent in the classCode,
       * practiceSettingCode or typeCode, as such a conflict would create an ambiguous situation.
       * This short list of codes is provided to be used as key words for certain types of queries.
       */
      public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The period of time covered by the documentation. There is no assertion that the
       * documentation is a complete representation for this period, only that it documents events
       * during this time.
       */
      public var period: Period.Builder? = null

      /**
       * The description and/or reference of the event(s) being documented. For example, this could
       * be used to document such a colonoscopy or an appendectomy.
       */
      public var detail: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Event =
        Event(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code.map { it.build() },
          period = period?.build(),
          detail = detail.map { it.build() },
        )
    }
  }

  /** The root of the sections that make up the composition. */
  @Serializable(with = CompositionSectionSerializer::class)
  public data class Section(
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
     * The label for this particular section. This will be part of the rendered content for the
     * document, and is often used to build a table of contents.
     *
     * The title identifies the section for a human reader. The title must be consistent with the
     * narrative of the resource that is the target of the section.content reference. Generally,
     * sections SHOULD have titles, but in some documents, it is unnecessary or inappropriate.
     * Typically, this is where a section has subsections that have their own adequately
     * distinguishing title, or documents that only have a single section. Most Implementation
     * Guides will make section title to be a required element.
     */
    public val title: String? = null,
    /**
     * A code identifying the kind of content contained within the section. This must be consistent
     * with the section title.
     *
     * The code identifies the section for an automated processor of the document. This is
     * particularly relevant when using profiles to control the structure of the document.
     *
     * If the section has content (instead of sub-sections), the section.code does not change the
     * meaning or interpretation of the resource that is the content of the section in the comments
     * for the section.code.
     */
    public val code: CodeableConcept? = null,
    /**
     * Identifies who is responsible for the information in this section, not necessarily who typed
     * it in.
     */
    public val author: List<Reference> = listOf(),
    /**
     * The actual focus of the section when it is not the subject of the composition, but instead
     * represents something or someone associated with the subject such as (for a patient subject) a
     * spouse, parent, fetus, or donor. If not focus is specified, the focus is assumed to be focus
     * of the parent section, or, for a section in the Composition itself, the subject of the
     * composition. Sections with a focus SHALL only include resources where the logical subject
     * (patient, subject, focus, etc.) matches the section focus, or the resources have no logical
     * subject (few resources).
     *
     * Typically, sections in a doument are about the subject of the document, whether that is a
     * patient, or group of patients, location, or device, or whatever. For some kind of documents,
     * some sections actually contain data about related entities. Typical examples are a section in
     * a newborn discharge summary concerning the mother, or family history documents, with a
     * section about each family member, though there are many other examples.
     */
    public val focus: Reference? = null,
    /**
     * A human-readable narrative that contains the attested content of the section, used to
     * represent the content of the resource to a human. The narrative need not encode all the
     * structured data, but is required to contain sufficient detail to make it "clinically safe"
     * for a human to just read the narrative.
     *
     * Document profiles may define what content should be represented in the narrative to ensure
     * clinical safety.
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
    /**
     * A reference to the actual resource from which the narrative in the section is derived.
     *
     * If there are no entries in the list, an emptyReason SHOULD be provided.
     */
    public val entry: List<Reference> = listOf(),
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
          code = this@with.code?.toBuilder()
          author = this@with.author.map { it.toBuilder() }.toMutableList()
          focus = this@with.focus?.toBuilder()
          text = this@with.text?.toBuilder()
          mode = this@with.mode
          orderedBy = this@with.orderedBy?.toBuilder()
          entry = this@with.entry.map { it.toBuilder() }.toMutableList()
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
       * The label for this particular section. This will be part of the rendered content for the
       * document, and is often used to build a table of contents.
       *
       * The title identifies the section for a human reader. The title must be consistent with the
       * narrative of the resource that is the target of the section.content reference. Generally,
       * sections SHOULD have titles, but in some documents, it is unnecessary or inappropriate.
       * Typically, this is where a section has subsections that have their own adequately
       * distinguishing title, or documents that only have a single section. Most Implementation
       * Guides will make section title to be a required element.
       */
      public var title: String.Builder? = null

      /**
       * A code identifying the kind of content contained within the section. This must be
       * consistent with the section title.
       *
       * The code identifies the section for an automated processor of the document. This is
       * particularly relevant when using profiles to control the structure of the document.
       *
       * If the section has content (instead of sub-sections), the section.code does not change the
       * meaning or interpretation of the resource that is the content of the section in the
       * comments for the section.code.
       */
      public var code: CodeableConcept.Builder? = null

      /**
       * Identifies who is responsible for the information in this section, not necessarily who
       * typed it in.
       */
      public var author: MutableList<Reference.Builder> = mutableListOf()

      /**
       * The actual focus of the section when it is not the subject of the composition, but instead
       * represents something or someone associated with the subject such as (for a patient subject)
       * a spouse, parent, fetus, or donor. If not focus is specified, the focus is assumed to be
       * focus of the parent section, or, for a section in the Composition itself, the subject of
       * the composition. Sections with a focus SHALL only include resources where the logical
       * subject (patient, subject, focus, etc.) matches the section focus, or the resources have no
       * logical subject (few resources).
       *
       * Typically, sections in a doument are about the subject of the document, whether that is a
       * patient, or group of patients, location, or device, or whatever. For some kind of
       * documents, some sections actually contain data about related entities. Typical examples are
       * a section in a newborn discharge summary concerning the mother, or family history
       * documents, with a section about each family member, though there are many other examples.
       */
      public var focus: Reference.Builder? = null

      /**
       * A human-readable narrative that contains the attested content of the section, used to
       * represent the content of the resource to a human. The narrative need not encode all the
       * structured data, but is required to contain sufficient detail to make it "clinically safe"
       * for a human to just read the narrative.
       *
       * Document profiles may define what content should be represented in the narrative to ensure
       * clinical safety.
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

      /**
       * A reference to the actual resource from which the narrative in the section is derived.
       *
       * If there are no entries in the list, an emptyReason SHOULD be provided.
       */
      public var entry: MutableList<Reference.Builder> = mutableListOf()

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
          code = code?.build(),
          author = author.map { it.build() },
          focus = focus?.build(),
          text = text?.build(),
          mode = mode,
          orderedBy = orderedBy?.build(),
          entry = entry.map { it.build() },
          emptyReason = emptyReason?.build(),
          section = section.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The workflow/clinical status of this composition. The status is a marker for the clinical
     * standing of the document.
     *
     * If a composition is marked as withdrawn, the compositions/documents in the series, or data
     * from the composition or document series, should never be displayed to a user without being
     * clearly marked as untrustworthy. The flag "entered-in-error" is why this element is labeled
     * as a modifier of other elements.
     *
     * Some reporting work flows require that the original narrative of a final document never be
     * altered; instead, only new narrative can be added. The composition resource has no explicit
     * status for explicitly noting whether this business rule is in effect. This would be handled
     * by an extension if required.
     */
    public var status: Enumeration<CompositionStatus>,
    /**
     * Specifies the particular kind of composition (e.g. History and Physical, Discharge Summary,
     * Progress Note). This usually equates to the purpose of making the composition.
     *
     * For Composition type, LOINC is ubiquitous and strongly endorsed by HL7. Most implementation
     * guides will require a specific LOINC code, or use LOINC as an extensible binding.
     */
    public var type: CodeableConcept.Builder,
    /**
     * The composition editing time, when the composition was last logically changed by the author.
     *
     * The Last Modified Date on the composition may be after the date of the document was attested
     * without being changed.
     */
    public var date: DateTime.Builder,
    /**
     * Identifies who is responsible for the information in the composition, not necessarily who
     * typed it in.
     */
    public var author: MutableList<Reference.Builder>,
    /**
     * Official human-readable label for the composition.
     *
     * For many compositions, the title is the same as the text or a display name of
     * Composition.type (e.g. a "consultation" or "progress note"). Note that CDA does not make
     * title mandatory, but there are no known cases where it is useful for title to be omitted, so
     * it is mandatory here. Feedback on this requirement is welcome during the trial use period.
     */
    public var title: String.Builder,
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

    /**
     * A version-independent identifier for the Composition. This identifier stays constant as the
     * composition is changed over time.
     *
     * Similar to ClinicalDocument/setId in CDA. See discussion in resource definition for how these
     * relate.
     */
    public var identifier: Identifier.Builder? = null

    /**
     * A categorization for the type of the composition - helps for indexing and searching. This may
     * be implied by or derived from the code specified in the Composition Type.
     *
     * This is a metadata field from
     * [XDS/MHD](http://wiki.ihe.net/index.php?title=Mobile_access_to_Health_Documents_(MHD)).
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Who or what the composition is about. The composition can be about a person, (patient or
     * healthcare practitioner), a device (e.g. a machine) or even a group of subjects (such as a
     * document about a herd of livestock, or a set of patients that share a common exposure).
     *
     * For clinical documents, this is usually the patient.
     */
    public var subject: Reference.Builder? = null

    /** Describes the clinical encounter or type of care this documentation is associated with. */
    public var encounter: Reference.Builder? = null

    /**
     * The code specifying the level of confidentiality of the Composition.
     *
     * The exact use of this element, and enforcement and issues related to highly sensitive
     * documents are out of scope for the base specification, and delegated to implementation
     * profiles (see security section). This element is labeled as a modifier because highly
     * confidential documents must not be treated as if they are not.
     */
    public var confidentiality: Enumeration<V3ConfidentialityClassification>? = null

    /**
     * A participant who has attested to the accuracy of the composition/document.
     *
     * Only list each attester once.
     */
    public var attester: MutableList<Attester.Builder> = mutableListOf()

    /**
     * Identifies the organization or group who is responsible for ongoing maintenance of and access
     * to the composition/document information.
     *
     * This is useful when documents are derived from a composition - provides guidance for how to
     * get the latest version of the document. This is optional because this is sometimes not known
     * by the authoring system, and can be inferred by context. However, it is important that this
     * information be known when working with a derived document, so providing a custodian is
     * encouraged.
     */
    public var custodian: Reference.Builder? = null

    /**
     * Relationships that this composition has with other compositions or documents that already
     * exist.
     *
     * A document is a version specific composition.
     */
    public var relatesTo: MutableList<RelatesTo.Builder> = mutableListOf()

    /**
     * The clinical service, such as a colonoscopy or an appendectomy, being documented.
     *
     * The event needs to be consistent with the type element, though can provide further
     * information if desired.
     */
    public var event: MutableList<Event.Builder> = mutableListOf()

    /** The root of the sections that make up the composition. */
    public var section: MutableList<Section.Builder> = mutableListOf()

    override fun build(): Composition =
      Composition(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier?.build(),
        status = status,
        type = type.build(),
        category = category.map { it.build() },
        subject = subject?.build(),
        encounter = encounter?.build(),
        date = date.build(),
        author = author.map { it.build() },
        title = title.build(),
        confidentiality = confidentiality,
        attester = attester.map { it.build() },
        custodian = custodian?.build(),
        relatesTo = relatesTo.map { it.build() },
        event = event.map { it.build() },
        section = section.map { it.build() },
      )
  }

  /** The way in which a person authenticated a composition. */
  public enum class CompositionAttestationMode(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Personal("personal", "http://hl7.org/fhir/composition-attestation-mode", "Personal"),
    Professional(
      "professional",
      "http://hl7.org/fhir/composition-attestation-mode",
      "Professional",
    ),
    Legal("legal", "http://hl7.org/fhir/composition-attestation-mode", "Legal"),
    Official("official", "http://hl7.org/fhir/composition-attestation-mode", "Official");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): CompositionAttestationMode =
        when (code) {
          "personal" -> Personal
          "professional" -> Professional
          "legal" -> Legal
          "official" -> Official
          else ->
            throw IllegalArgumentException("Unknown code $code for enum CompositionAttestationMode")
        }
    }
  }

  /** The type of relationship between documents. */
  public enum class DocumentRelationshipType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Replaces("replaces", "http://hl7.org/fhir/document-relationship-type", "Replaces"),
    Transforms("transforms", "http://hl7.org/fhir/document-relationship-type", "Transforms"),
    Signs("signs", "http://hl7.org/fhir/document-relationship-type", "Signs"),
    Appends("appends", "http://hl7.org/fhir/document-relationship-type", "Appends");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DocumentRelationshipType =
        when (code) {
          "replaces" -> Replaces
          "transforms" -> Transforms
          "signs" -> Signs
          "appends" -> Appends
          else ->
            throw IllegalArgumentException("Unknown code $code for enum DocumentRelationshipType")
        }
    }
  }

  /** The processing mode that applies to this list. */
  public enum class ListMode(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Working("working", "http://hl7.org/fhir/list-mode", "Working List"),
    Snapshot("snapshot", "http://hl7.org/fhir/list-mode", "Snapshot List"),
    Changes("changes", "http://hl7.org/fhir/list-mode", "Change List");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

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

  /** The workflow/clinical status of the composition. */
  public enum class CompositionStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Preliminary("preliminary", "http://hl7.org/fhir/composition-status", "Preliminary"),
    Final("final", "http://hl7.org/fhir/composition-status", "Final"),
    Amended("amended", "http://hl7.org/fhir/composition-status", "Amended"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/composition-status",
      "Entered in Error",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): CompositionStatus =
        when (code) {
          "preliminary" -> Preliminary
          "final" -> Final
          "amended" -> Amended
          "entered-in-error" -> Entered_In_Error
          else -> throw IllegalArgumentException("Unknown code $code for enum CompositionStatus")
        }
    }
  }

  /**
   * Set of codes used to value Act.Confidentiality and Role.Confidentiality attribute in accordance
   * with the definition for concept domain "Confidentiality".
   */
  public enum class V3ConfidentialityClassification(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    U("U", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "unrestricted"),
    L("L", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "low"),
    M("M", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "moderate"),
    N("N", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "normal"),
    R("R", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "restricted"),
    V("V", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "very restricted");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): V3ConfidentialityClassification =
        when (code) {
          "U" -> U
          "L" -> L
          "M" -> M
          "N" -> N
          "R" -> R
          "V" -> V
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum V3ConfidentialityClassification"
            )
        }
    }
  }
}

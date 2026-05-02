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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.serializers.DocumentReferenceContentSerializer
import com.google.fhir.model.r4b.serializers.DocumentReferenceContextSerializer
import com.google.fhir.model.r4b.serializers.DocumentReferenceRelatesToSerializer
import com.google.fhir.model.r4b.serializers.DocumentReferenceSerializer
import com.google.fhir.model.r4b.terminologies.DocumentReferenceStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A reference to a document of any kind for any purpose. Provides metadata about the document so
 * that the document can be discovered and managed. The scope of a document is any seralized object
 * with a mime-type, so includes formal patient centric documents (CDA), cliical notes, scanned
 * paper, and non-patient specific documents like policy text.
 */
@Serializable(with = DocumentReferenceSerializer::class)
@SerialName("DocumentReference")
public data class DocumentReference(
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
   * Document identifier as assigned by the source of the document. This identifier is specific to
   * this version of the document. This unique identifier may be used elsewhere to identify this
   * version of the document.
   *
   * CDA Document Id extension and root.
   */
  public val masterIdentifier: Identifier? = null,
  /** Other identifiers associated with the document, including version independent identifiers. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The status of this document reference.
   *
   * This is the status of the DocumentReference object, which might be independent from the
   * docStatus element.
   *
   * This element is labeled as a modifier because the status contains the codes that mark the
   * document or reference as not currently valid.
   */
  public val status: Enumeration<DocumentReferenceStatus>,
  /**
   * The status of the underlying document.
   *
   * The document that is pointed to might be in various lifecycle states.
   */
  public val docStatus: Enumeration<CompositionStatus>? = null,
  /**
   * Specifies the particular kind of document referenced (e.g. History and Physical, Discharge
   * Summary, Progress Note). This usually equates to the purpose of making the document referenced.
   *
   * Key metadata element describing the document that describes he exact type of document. Helps
   * humans to assess whether the document is of interest when viewing a list of documents.
   */
  public val type: CodeableConcept? = null,
  /**
   * A categorization for the type of document referenced - helps for indexing and searching. This
   * may be implied by or derived from the code specified in the DocumentReference.type.
   *
   * Key metadata element describing the the category or classification of the document. This is a
   * broader perspective that groups similar documents based on how they would be used. This is a
   * primary key used in searching.
   */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * Who or what the document is about. The document can be about a person, (patient or healthcare
   * practitioner), a device (e.g. a machine) or even a group of subjects (such as a document about
   * a herd of farm animals, or a set of patients that share a common exposure).
   */
  public val subject: Reference? = null,
  /**
   * When the document reference was created.
   *
   * Referencing/indexing time is used for tracking, organizing versions and searching.
   */
  public val date: Instant? = null,
  /**
   * Identifies who is responsible for adding the information to the document.
   *
   * Not necessarily who did the actual data entry (i.e. typist) or who was the source (informant).
   */
  public val author: List<Reference> = listOf(),
  /**
   * Which person or organization authenticates that this document is valid.
   *
   * Represents a participant within the author institution who has legally authenticated or
   * attested the document. Legal authentication implies that a document has been signed manually or
   * electronically by the legal Authenticator.
   */
  public val authenticator: Reference? = null,
  /**
   * Identifies the organization or group who is responsible for ongoing maintenance of and access
   * to the document.
   *
   * Identifies the logical organization (software system, vendor, or department) to go to find the
   * current version, where to report issues, etc. This is different from the physical location
   * (URL, disk drive, or server) of the document, which is the technical location of the document,
   * which host may be delegated to the management of some other organization.
   */
  public val custodian: Reference? = null,
  /**
   * Relationships that this document has with other document references that already exist.
   *
   * This element is labeled as a modifier because documents that append to other documents are
   * incomplete on their own.
   */
  public val relatesTo: List<RelatesTo> = listOf(),
  /**
   * Human-readable description of the source document.
   *
   * What the document is about, a terse summary of the document.
   */
  public val description: String? = null,
  /**
   * A set of Security-Tag codes specifying the level of privacy/security of the Document. Note that
   * DocumentReference.meta.security contains the security labels of the "reference" to the
   * document, while DocumentReference.securityLabel contains a snapshot of the security labels on
   * the document the reference refers to.
   *
   * The confidentiality codes can carry multiple vocabulary items. HL7 has developed an
   * understanding of security and privacy tags that might be desirable in a Document Sharing
   * environment, called HL7 Healthcare Privacy and Security Classification System (HCS). The
   * following specification is recommended but not mandated, as the vocabulary bindings are an
   * administrative domain responsibility. The use of this method is up to the policy domain such as
   * the XDS Affinity Domain or other Trust Domain where all parties including sender and recipients
   * are trusted to appropriately tag and enforce.
   *
   * In the HL7 Healthcare Privacy and Security Classification (HCS) there are code systems specific
   * to Confidentiality, Sensitivity, Integrity, and Handling Caveats. Some values would come from a
   * local vocabulary as they are related to workflow roles and special projects.
   */
  public val securityLabel: List<CodeableConcept> = listOf(),
  /**
   * The document and format referenced. There may be multiple content element repetitions, each
   * with a different format.
   */
  public val content: List<Content>,
  /**
   * The clinical context in which the document was prepared.
   *
   * These values are primarily added to help with searching for interesting/relevant documents.
   */
  public val context: Context? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, content.map { it.toBuilder() }.toMutableList()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        masterIdentifier = this@with.masterIdentifier?.toBuilder()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        docStatus = this@with.docStatus
        type = this@with.type?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject?.toBuilder()
        date = this@with.date?.toBuilder()
        author = this@with.author.map { it.toBuilder() }.toMutableList()
        authenticator = this@with.authenticator?.toBuilder()
        custodian = this@with.custodian?.toBuilder()
        relatesTo = this@with.relatesTo.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        securityLabel = this@with.securityLabel.map { it.toBuilder() }.toMutableList()
        context = this@with.context?.toBuilder()
      }
    }

  /** Relationships that this document has with other document references that already exist. */
  @Serializable(with = DocumentReferenceRelatesToSerializer::class)
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
     * The type of relationship that this document has with anther document.
     *
     * If this document appends another document, then the document cannot be fully understood
     * without also accessing the referenced document.
     */
    public val code: Enumeration<DocumentRelationshipType>,
    /** The target document of this relationship. */
    public val target: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code, target.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * The type of relationship that this document has with anther document.
       *
       * If this document appends another document, then the document cannot be fully understood
       * without also accessing the referenced document.
       */
      public var code: Enumeration<DocumentRelationshipType>,
      /** The target document of this relationship. */
      public var target: Reference.Builder,
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
          target = target.build(),
        )
    }
  }

  /**
   * The document and format referenced. There may be multiple content element repetitions, each
   * with a different format.
   */
  @Serializable(with = DocumentReferenceContentSerializer::class)
  public data class Content(
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
     * The document or URL of the document along with critical metadata to prove content has
     * integrity.
     */
    public val attachment: Attachment,
    /**
     * An identifier of the document encoding, structure, and template that the document conforms to
     * beyond the base format indicated in the mimeType.
     *
     * Note that while IHE mostly issues URNs for format types, not all documents can be identified
     * by a URI.
     */
    public val format: Coding? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(attachment.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          format = this@with.format?.toBuilder()
        }
      }

    public class Builder(
      /**
       * The document or URL of the document along with critical metadata to prove content has
       * integrity.
       */
      public var attachment: Attachment.Builder
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
       * An identifier of the document encoding, structure, and template that the document conforms
       * to beyond the base format indicated in the mimeType.
       *
       * Note that while IHE mostly issues URNs for format types, not all documents can be
       * identified by a URI.
       */
      public var format: Coding.Builder? = null

      public fun build(): Content =
        Content(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          attachment = attachment.build(),
          format = format?.build(),
        )
    }
  }

  /** The clinical context in which the document was prepared. */
  @Serializable(with = DocumentReferenceContextSerializer::class)
  public data class Context(
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
     * Describes the clinical encounter or type of care that the document content is associated
     * with.
     */
    public val encounter: List<Reference> = listOf(),
    /**
     * This list of codes represents the main clinical acts, such as a colonoscopy or an
     * appendectomy, being documented. In some cases, the event is inherent in the type Code, such
     * as a "History and Physical Report" in which the procedure being documented is necessarily a
     * "History and Physical" act.
     *
     * An event can further specialize the act inherent in the type, such as where it is simply
     * "Procedure Report" and the procedure was a "colonoscopy". If one or more event codes are
     * included, they shall not conflict with the values inherent in the class or type elements as
     * such a conflict would create an ambiguous situation.
     */
    public val event: List<CodeableConcept> = listOf(),
    /** The time period over which the service that is described by the document was provided. */
    public val period: Period? = null,
    /** The kind of facility where the patient was seen. */
    public val facilityType: CodeableConcept? = null,
    /**
     * This property may convey specifics about the practice setting where the content was created,
     * often reflecting the clinical specialty.
     *
     * This element should be based on a coarse classification system for the class of specialty
     * practice. Recommend the use of the classification system for Practice Setting, such as that
     * described by the Subject Matter Domain in LOINC.
     */
    public val practiceSetting: CodeableConcept? = null,
    /**
     * The Patient Information as known when the document was published. May be a reference to a
     * version specific, or contained.
     */
    public val sourcePatientInfo: Reference? = null,
    /**
     * Related identifiers or resources associated with the DocumentReference.
     *
     * May be identifiers or resources that caused the DocumentReference or referenced Document to
     * be created.
     */
    public val related: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          encounter = this@with.encounter.map { it.toBuilder() }.toMutableList()
          event = this@with.event.map { it.toBuilder() }.toMutableList()
          period = this@with.period?.toBuilder()
          facilityType = this@with.facilityType?.toBuilder()
          practiceSetting = this@with.practiceSetting?.toBuilder()
          sourcePatientInfo = this@with.sourcePatientInfo?.toBuilder()
          related = this@with.related.map { it.toBuilder() }.toMutableList()
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
       * Describes the clinical encounter or type of care that the document content is associated
       * with.
       */
      public var encounter: MutableList<Reference.Builder> = mutableListOf()

      /**
       * This list of codes represents the main clinical acts, such as a colonoscopy or an
       * appendectomy, being documented. In some cases, the event is inherent in the type Code, such
       * as a "History and Physical Report" in which the procedure being documented is necessarily a
       * "History and Physical" act.
       *
       * An event can further specialize the act inherent in the type, such as where it is simply
       * "Procedure Report" and the procedure was a "colonoscopy". If one or more event codes are
       * included, they shall not conflict with the values inherent in the class or type elements as
       * such a conflict would create an ambiguous situation.
       */
      public var event: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The time period over which the service that is described by the document was provided. */
      public var period: Period.Builder? = null

      /** The kind of facility where the patient was seen. */
      public var facilityType: CodeableConcept.Builder? = null

      /**
       * This property may convey specifics about the practice setting where the content was
       * created, often reflecting the clinical specialty.
       *
       * This element should be based on a coarse classification system for the class of specialty
       * practice. Recommend the use of the classification system for Practice Setting, such as that
       * described by the Subject Matter Domain in LOINC.
       */
      public var practiceSetting: CodeableConcept.Builder? = null

      /**
       * The Patient Information as known when the document was published. May be a reference to a
       * version specific, or contained.
       */
      public var sourcePatientInfo: Reference.Builder? = null

      /**
       * Related identifiers or resources associated with the DocumentReference.
       *
       * May be identifiers or resources that caused the DocumentReference or referenced Document to
       * be created.
       */
      public var related: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Context =
        Context(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          encounter = encounter.map { it.build() },
          event = event.map { it.build() },
          period = period?.build(),
          facilityType = facilityType?.build(),
          practiceSetting = practiceSetting?.build(),
          sourcePatientInfo = sourcePatientInfo?.build(),
          related = related.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The status of this document reference.
     *
     * This is the status of the DocumentReference object, which might be independent from the
     * docStatus element.
     *
     * This element is labeled as a modifier because the status contains the codes that mark the
     * document or reference as not currently valid.
     */
    public var status: Enumeration<DocumentReferenceStatus>,
    /**
     * The document and format referenced. There may be multiple content element repetitions, each
     * with a different format.
     */
    public var content: MutableList<Content.Builder>,
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
     * Document identifier as assigned by the source of the document. This identifier is specific to
     * this version of the document. This unique identifier may be used elsewhere to identify this
     * version of the document.
     *
     * CDA Document Id extension and root.
     */
    public var masterIdentifier: Identifier.Builder? = null

    /**
     * Other identifiers associated with the document, including version independent identifiers.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The status of the underlying document.
     *
     * The document that is pointed to might be in various lifecycle states.
     */
    public var docStatus: Enumeration<CompositionStatus>? = null

    /**
     * Specifies the particular kind of document referenced (e.g. History and Physical, Discharge
     * Summary, Progress Note). This usually equates to the purpose of making the document
     * referenced.
     *
     * Key metadata element describing the document that describes he exact type of document. Helps
     * humans to assess whether the document is of interest when viewing a list of documents.
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * A categorization for the type of document referenced - helps for indexing and searching. This
     * may be implied by or derived from the code specified in the DocumentReference.type.
     *
     * Key metadata element describing the the category or classification of the document. This is a
     * broader perspective that groups similar documents based on how they would be used. This is a
     * primary key used in searching.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Who or what the document is about. The document can be about a person, (patient or healthcare
     * practitioner), a device (e.g. a machine) or even a group of subjects (such as a document
     * about a herd of farm animals, or a set of patients that share a common exposure).
     */
    public var subject: Reference.Builder? = null

    /**
     * When the document reference was created.
     *
     * Referencing/indexing time is used for tracking, organizing versions and searching.
     */
    public var date: Instant.Builder? = null

    /**
     * Identifies who is responsible for adding the information to the document.
     *
     * Not necessarily who did the actual data entry (i.e. typist) or who was the source
     * (informant).
     */
    public var author: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Which person or organization authenticates that this document is valid.
     *
     * Represents a participant within the author institution who has legally authenticated or
     * attested the document. Legal authentication implies that a document has been signed manually
     * or electronically by the legal Authenticator.
     */
    public var authenticator: Reference.Builder? = null

    /**
     * Identifies the organization or group who is responsible for ongoing maintenance of and access
     * to the document.
     *
     * Identifies the logical organization (software system, vendor, or department) to go to find
     * the current version, where to report issues, etc. This is different from the physical
     * location (URL, disk drive, or server) of the document, which is the technical location of the
     * document, which host may be delegated to the management of some other organization.
     */
    public var custodian: Reference.Builder? = null

    /**
     * Relationships that this document has with other document references that already exist.
     *
     * This element is labeled as a modifier because documents that append to other documents are
     * incomplete on their own.
     */
    public var relatesTo: MutableList<RelatesTo.Builder> = mutableListOf()

    /**
     * Human-readable description of the source document.
     *
     * What the document is about, a terse summary of the document.
     */
    public var description: String.Builder? = null

    /**
     * A set of Security-Tag codes specifying the level of privacy/security of the Document. Note
     * that DocumentReference.meta.security contains the security labels of the "reference" to the
     * document, while DocumentReference.securityLabel contains a snapshot of the security labels on
     * the document the reference refers to.
     *
     * The confidentiality codes can carry multiple vocabulary items. HL7 has developed an
     * understanding of security and privacy tags that might be desirable in a Document Sharing
     * environment, called HL7 Healthcare Privacy and Security Classification System (HCS). The
     * following specification is recommended but not mandated, as the vocabulary bindings are an
     * administrative domain responsibility. The use of this method is up to the policy domain such
     * as the XDS Affinity Domain or other Trust Domain where all parties including sender and
     * recipients are trusted to appropriately tag and enforce.
     *
     * In the HL7 Healthcare Privacy and Security Classification (HCS) there are code systems
     * specific to Confidentiality, Sensitivity, Integrity, and Handling Caveats. Some values would
     * come from a local vocabulary as they are related to workflow roles and special projects.
     */
    public var securityLabel: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The clinical context in which the document was prepared.
     *
     * These values are primarily added to help with searching for interesting/relevant documents.
     */
    public var context: Context.Builder? = null

    override fun build(): DocumentReference =
      DocumentReference(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        masterIdentifier = masterIdentifier?.build(),
        identifier = identifier.map { it.build() },
        status = status,
        docStatus = docStatus,
        type = type?.build(),
        category = category.map { it.build() },
        subject = subject?.build(),
        date = date?.build(),
        author = author.map { it.build() },
        authenticator = authenticator?.build(),
        custodian = custodian?.build(),
        relatesTo = relatesTo.map { it.build() },
        description = description?.build(),
        securityLabel = securityLabel.map { it.build() },
        content = content.map { it.build() },
        context = context?.build(),
      )
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
}

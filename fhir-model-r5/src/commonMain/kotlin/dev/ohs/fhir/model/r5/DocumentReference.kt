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

import dev.ohs.fhir.model.r5.serializers.DocumentReferenceAttesterSerializer
import dev.ohs.fhir.model.r5.serializers.DocumentReferenceContentProfileSerializer
import dev.ohs.fhir.model.r5.serializers.DocumentReferenceContentSerializer
import dev.ohs.fhir.model.r5.serializers.DocumentReferenceRelatesToSerializer
import dev.ohs.fhir.model.r5.serializers.DocumentReferenceSerializer
import dev.ohs.fhir.model.r5.terminologies.DocumentReferenceStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A reference to a document of any kind for any purpose. While the term “document” implies a more
 * narrow focus, for this resource this “document” encompasses *any* serialized object with a
 * mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper,
 * non-patient specific documents like policy text, as well as a photo, video, or audio recording
 * acquired or used in healthcare. The DocumentReference resource provides metadata about the
 * document so that the document can be discovered and managed. The actual content may be inline
 * base64 encoded data or provided by direct reference.
 */
@Serializable(with = DocumentReferenceSerializer::class)
@SerialName("DocumentReference")
public data class DocumentReference(
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
   * Other business identifiers associated with the document, including version independent
   * identifiers.
   *
   * The structure and format of this identifier would be consistent with the specification
   * corresponding to the format of the document. (e.g. for a DICOM standard document, a
   * 64-character numeric UID; for an HL7 CDA format, the CDA Document Id root and extension).
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * An explicitly assigned identifer of a variation of the content in the DocumentReference.
   *
   * While each resource, including the DocumentReference itself, has its own version identifier,
   * this is a formal identifier for the logical version of the DocumentReference as a whole. It
   * would remain constant if the resources were moved to a new server, and all got new individual
   * resource versions, for example.
   */
  public val version: String? = null,
  /** A procedure that is fulfilled in whole or in part by the creation of this media. */
  public val basedOn: List<Reference> = listOf(),
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
  /** Imaging modality used. This may include both acquisition and non-acquisition modalities. */
  public val modality: List<CodeableConcept> = listOf(),
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
   * Describes the clinical encounter or type of care that the document content is associated with.
   */
  public val context: List<Reference> = listOf(),
  /**
   * This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy,
   * being documented. In some cases, the event is inherent in the type Code, such as a "History and
   * Physical Report" in which the procedure being documented is necessarily a "History and
   * Physical" act.
   *
   * An event can further specialize the act inherent in the type, such as where it is simply
   * "Procedure Report" and the procedure was a "colonoscopy". If one or more event codes are
   * included, they shall not conflict with the values inherent in the class or type elements as
   * such a conflict would create an ambiguous situation.
   */
  public val event: List<CodeableReference> = listOf(),
  /** The anatomic structures included in the document. */
  public val bodySite: List<CodeableReference> = listOf(),
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
  /** The time period over which the service that is described by the document was provided. */
  public val period: Period? = null,
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
   * A participant who has authenticated the accuracy of the document.
   *
   * Only list each attester once.
   */
  public val attester: List<Attester> = listOf(),
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
  public val description: Markdown? = null,
  /**
   * A set of Security-Tag codes specifying the level of privacy/security of the Document found at
   * DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains
   * the security labels of the data elements in DocumentReference, while
   * DocumentReference.securityLabel contains the security labels for the document the reference
   * refers to. The distinction recognizes that the document may contain sensitive information,
   * while the DocumentReference is metadata about the document and thus might not be as sensitive
   * as the document. For example: a psychotherapy episode may contain highly sensitive information,
   * while the metadata may simply indicate that some episode happened.
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
   * The document and format referenced. If there are multiple content element repetitions, these
   * must all represent the same document in different format, or attachment metadata.
   *
   * content element shall not contain different versions of the same content. For version handling
   * use multiple DocumentReference with .relatesTo.
   */
  public val content: List<Content>,
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
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        version = this@with.version?.toBuilder()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        docStatus = this@with.docStatus
        modality = this@with.modality.map { it.toBuilder() }.toMutableList()
        type = this@with.type?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject?.toBuilder()
        context = this@with.context.map { it.toBuilder() }.toMutableList()
        event = this@with.event.map { it.toBuilder() }.toMutableList()
        bodySite = this@with.bodySite.map { it.toBuilder() }.toMutableList()
        facilityType = this@with.facilityType?.toBuilder()
        practiceSetting = this@with.practiceSetting?.toBuilder()
        period = this@with.period?.toBuilder()
        date = this@with.date?.toBuilder()
        author = this@with.author.map { it.toBuilder() }.toMutableList()
        attester = this@with.attester.map { it.toBuilder() }.toMutableList()
        custodian = this@with.custodian?.toBuilder()
        relatesTo = this@with.relatesTo.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        securityLabel = this@with.securityLabel.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A participant who has authenticated the accuracy of the document. */
  @Serializable(with = DocumentReferenceAttesterSerializer::class)
  public data class Attester(
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
    /** The type of attestation the authenticator offers. */
    public val mode: CodeableConcept,
    /** When the document was attested by the party. */
    public val time: DateTime? = null,
    /** Who attested the document in the specified way. */
    public val party: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(mode.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          time = this@with.time?.toBuilder()
          party = this@with.party?.toBuilder()
        }
      }

    public class Builder(
      /** The type of attestation the authenticator offers. */
      public var mode: CodeableConcept.Builder
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

      /** When the document was attested by the party. */
      public var time: DateTime.Builder? = null

      /** Who attested the document in the specified way. */
      public var party: Reference.Builder? = null

      public fun build(): Attester =
        Attester(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          mode = mode.build(),
          time = time?.build(),
          party = party?.build(),
        )
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
     * The type of relationship that this document has with anther document.
     *
     * If this document appends another document, then the document cannot be fully understood
     * without also accessing the referenced document.
     */
    public val code: CodeableConcept,
    /** The target document of this relationship. */
    public val target: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder(), target.toBuilder()).apply {
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
      public var code: CodeableConcept.Builder,
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
          code = code.build(),
          target = target.build(),
        )
    }
  }

  /**
   * The document and format referenced. If there are multiple content element repetitions, these
   * must all represent the same document in different format, or attachment metadata.
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
     * The document or URL of the document along with critical metadata to prove content has
     * integrity.
     */
    public val attachment: Attachment,
    /**
     * An identifier of the document constraints, encoding, structure, and template that the
     * document conforms to beyond the base format indicated in the mimeType.
     *
     * Note that IHE often issues URNs for formatCode codes, not all documents can be identified by
     * a URI.
     *
     * For FHIR content, .profile should indicate the structureDefinition profile canonical URI(s)
     * that the content complies with.
     */
    public val profile: List<Profile> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(attachment.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          profile = this@with.profile.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * An identifier of the document constraints, encoding, structure, and template that the
     * document conforms to beyond the base format indicated in the mimeType.
     */
    @Serializable(with = DocumentReferenceContentProfileSerializer::class)
    public data class Profile(
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
      /** Code|uri|canonical. */
      public val `value`: Value,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(`value`).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public sealed interface Value {
        public fun asCoding(): Coding? = this as? Coding

        public fun asUri(): Uri? = this as? Uri

        public fun asCanonical(): Canonical? = this as? Canonical

        public data class Coding(public val `value`: dev.ohs.fhir.model.r5.Coding) : Value

        public data class Uri(public val `value`: dev.ohs.fhir.model.r5.Uri) : Value

        public data class Canonical(public val `value`: dev.ohs.fhir.model.r5.Canonical) : Value

        public companion object {
          internal fun from(
            codingValue: dev.ohs.fhir.model.r5.Coding?,
            uriValue: dev.ohs.fhir.model.r5.Uri?,
            canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
          ): Value? {
            if (codingValue != null) return Coding(codingValue)
            if (uriValue != null) return Uri(uriValue)
            if (canonicalValue != null) return Canonical(canonicalValue)
            return null
          }
        }
      }

      public class Builder(
        /** Code|uri|canonical. */
        public var `value`: Value
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

        public fun build(): Profile =
          Profile(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            `value` = `value`,
          )
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
       * An identifier of the document constraints, encoding, structure, and template that the
       * document conforms to beyond the base format indicated in the mimeType.
       *
       * Note that IHE often issues URNs for formatCode codes, not all documents can be identified
       * by a URI.
       *
       * For FHIR content, .profile should indicate the structureDefinition profile canonical URI(s)
       * that the content complies with.
       */
      public var profile: MutableList<Profile.Builder> = mutableListOf()

      public fun build(): Content =
        Content(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          attachment = attachment.build(),
          profile = profile.map { it.build() },
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
     * The document and format referenced. If there are multiple content element repetitions, these
     * must all represent the same document in different format, or attachment metadata.
     *
     * content element shall not contain different versions of the same content. For version
     * handling use multiple DocumentReference with .relatesTo.
     */
    public var content: MutableList<Content.Builder>,
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
     * Other business identifiers associated with the document, including version independent
     * identifiers.
     *
     * The structure and format of this identifier would be consistent with the specification
     * corresponding to the format of the document. (e.g. for a DICOM standard document, a
     * 64-character numeric UID; for an HL7 CDA format, the CDA Document Id root and extension).
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * An explicitly assigned identifer of a variation of the content in the DocumentReference.
     *
     * While each resource, including the DocumentReference itself, has its own version identifier,
     * this is a formal identifier for the logical version of the DocumentReference as a whole. It
     * would remain constant if the resources were moved to a new server, and all got new individual
     * resource versions, for example.
     */
    public var version: String.Builder? = null

    /** A procedure that is fulfilled in whole or in part by the creation of this media. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The status of the underlying document.
     *
     * The document that is pointed to might be in various lifecycle states.
     */
    public var docStatus: Enumeration<CompositionStatus>? = null

    /** Imaging modality used. This may include both acquisition and non-acquisition modalities. */
    public var modality: MutableList<CodeableConcept.Builder> = mutableListOf()

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
     * Describes the clinical encounter or type of care that the document content is associated
     * with.
     */
    public var context: MutableList<Reference.Builder> = mutableListOf()

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
    public var event: MutableList<CodeableReference.Builder> = mutableListOf()

    /** The anatomic structures included in the document. */
    public var bodySite: MutableList<CodeableReference.Builder> = mutableListOf()

    /** The kind of facility where the patient was seen. */
    public var facilityType: CodeableConcept.Builder? = null

    /**
     * This property may convey specifics about the practice setting where the content was created,
     * often reflecting the clinical specialty.
     *
     * This element should be based on a coarse classification system for the class of specialty
     * practice. Recommend the use of the classification system for Practice Setting, such as that
     * described by the Subject Matter Domain in LOINC.
     */
    public var practiceSetting: CodeableConcept.Builder? = null

    /** The time period over which the service that is described by the document was provided. */
    public var period: Period.Builder? = null

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
     * A participant who has authenticated the accuracy of the document.
     *
     * Only list each attester once.
     */
    public var attester: MutableList<Attester.Builder> = mutableListOf()

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
    public var description: Markdown.Builder? = null

    /**
     * A set of Security-Tag codes specifying the level of privacy/security of the Document found at
     * DocumentReference.content.attachment.url. Note that DocumentReference.meta.security contains
     * the security labels of the data elements in DocumentReference, while
     * DocumentReference.securityLabel contains the security labels for the document the reference
     * refers to. The distinction recognizes that the document may contain sensitive information,
     * while the DocumentReference is metadata about the document and thus might not be as sensitive
     * as the document. For example: a psychotherapy episode may contain highly sensitive
     * information, while the metadata may simply indicate that some episode happened.
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
        identifier = identifier.map { it.build() },
        version = version?.build(),
        basedOn = basedOn.map { it.build() },
        status = status,
        docStatus = docStatus,
        modality = modality.map { it.build() },
        type = type?.build(),
        category = category.map { it.build() },
        subject = subject?.build(),
        context = context.map { it.build() },
        event = event.map { it.build() },
        bodySite = bodySite.map { it.build() },
        facilityType = facilityType?.build(),
        practiceSetting = practiceSetting?.build(),
        period = period?.build(),
        date = date?.build(),
        author = author.map { it.build() },
        attester = attester.map { it.build() },
        custodian = custodian?.build(),
        relatesTo = relatesTo.map { it.build() },
        description = description?.build(),
        securityLabel = securityLabel.map { it.build() },
        content = content.map { it.build() },
      )
  }

  /** The workflow/clinical status of the composition. */
  public enum class CompositionStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Registered("registered", "http://hl7.org/fhir/composition-status", "Registered"),
    Partial("partial", "http://hl7.org/fhir/composition-status", "Partial"),
    Preliminary("preliminary", "http://hl7.org/fhir/composition-status", "Preliminary"),
    Final("final", "http://hl7.org/fhir/composition-status", "Final"),
    Amended("amended", "http://hl7.org/fhir/composition-status", "Amended"),
    Corrected("corrected", "http://hl7.org/fhir/composition-status", "Corrected"),
    Appended("appended", "http://hl7.org/fhir/composition-status", "Appended"),
    Cancelled("cancelled", "http://hl7.org/fhir/composition-status", "Cancelled"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/composition-status",
      "Entered in Error",
    ),
    Deprecated("deprecated", "http://hl7.org/fhir/composition-status", "Deprecated"),
    Unknown("unknown", "http://hl7.org/fhir/composition-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): CompositionStatus =
        when (code) {
          "registered" -> Registered
          "partial" -> Partial
          "preliminary" -> Preliminary
          "final" -> Final
          "amended" -> Amended
          "corrected" -> Corrected
          "appended" -> Appended
          "cancelled" -> Cancelled
          "entered-in-error" -> Entered_In_Error
          "deprecated" -> Deprecated
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum CompositionStatus")
        }
    }
  }
}

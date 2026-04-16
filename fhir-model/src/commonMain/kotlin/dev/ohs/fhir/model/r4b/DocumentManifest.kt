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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.DocumentManifestRelatedSerializer
import dev.ohs.fhir.model.r4b.serializers.DocumentManifestSerializer
import dev.ohs.fhir.model.r4b.terminologies.DocumentReferenceStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A collection of documents compiled for a purpose together with metadata that applies to the
 * collection.
 */
@Serializable(with = DocumentManifestSerializer::class)
@SerialName("DocumentManifest")
public data class DocumentManifest(
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
   * A single identifier that uniquely identifies this manifest. Principally used to refer to the
   * manifest in non-FHIR contexts.
   */
  public val masterIdentifier: Identifier? = null,
  /**
   * Other identifiers associated with the document manifest, including version independent
   * identifiers.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The status of this document manifest.
   *
   * This element is labeled as a modifier because the status contains the codes that mark the
   * manifest as not currently valid.
   */
  public val status: Enumeration<DocumentReferenceStatus>,
  /**
   * The code specifying the type of clinical activity that resulted in placing the associated
   * content into the DocumentManifest.
   *
   * Specifies the kind of this set of documents (e.g. Patient Summary, Discharge Summary,
   * Prescription, etc.). The type of a set of documents may be the same as one of the documents in
   * it - especially if there is only one - but it may be wider.
   */
  public val type: CodeableConcept? = null,
  /**
   * Who or what the set of documents is about. The documents can be about a person, (patient or
   * healthcare practitioner), a device (i.e. machine) or even a group of subjects (such as a
   * document about a herd of farm animals, or a set of patients that share a common exposure). If
   * the documents cross more than one subject, then more than one subject is allowed here (unusual
   * use case).
   */
  public val subject: Reference? = null,
  /**
   * When the document manifest was created for submission to the server (not necessarily the same
   * thing as the actual resource last modified time, since it may be modified, replicated, etc.).
   *
   * Creation time is used for tracking, organizing versions and searching. This is the creation
   * time of the document set, not the documents on which it is based.
   */
  public val created: DateTime? = null,
  /**
   * Identifies who is the author of the manifest. Manifest author is not necessarly the author of
   * the references included.
   *
   * Not necessarily who did the actual data entry (i.e. typist) or who was the source (informant).
   */
  public val author: List<Reference> = listOf(),
  /**
   * A patient, practitioner, or organization for which this set of documents is intended.
   *
   * How the recipient receives the document set or is notified of it is up to the implementation.
   * This element is just a statement of intent. If the recipient is a person, and it is not known
   * whether the person is a patient or a practitioner, RelatedPerson would be the default choice.
   */
  public val recipient: List<Reference> = listOf(),
  /** Identifies the source system, application, or software that produced the document manifest. */
  public val source: Uri? = null,
  /**
   * Human-readable description of the source document. This is sometimes known as the "title".
   *
   * What the document is about, rather than a terse summary of the document. It is commonly the
   * case that records do not have a title and are collectively referred to by the display name of
   * Record code (e.g. a "consultation" or "progress note").
   */
  public val description: String? = null,
  /**
   * The list of Resources that consist of the parts of this manifest.
   *
   * When used for XDS the intended focus of the DocumentManifest is for the reference to target to
   * be a set of DocumentReference Resources. The reference is to "Any" to support EN 13606 usage,
   * where an extract is DocumentManifest that references List and Composition resources.
   */
  public val content: List<Reference>,
  /**
   * Related identifiers or resources associated with the DocumentManifest.
   *
   * May be identifiers or resources that caused the DocumentManifest to be created.
   */
  public val related: List<Related> = listOf(),
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
        type = this@with.type?.toBuilder()
        subject = this@with.subject?.toBuilder()
        created = this@with.created?.toBuilder()
        author = this@with.author.map { it.toBuilder() }.toMutableList()
        recipient = this@with.recipient.map { it.toBuilder() }.toMutableList()
        source = this@with.source?.toBuilder()
        description = this@with.description?.toBuilder()
        related = this@with.related.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Related identifiers or resources associated with the DocumentManifest. */
  @Serializable(with = DocumentManifestRelatedSerializer::class)
  public data class Related(
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
     * Related identifier to this DocumentManifest. For example, Order numbers, accession numbers,
     * XDW workflow numbers.
     *
     * If both identifier and ref elements are present they shall refer to the same thing.
     */
    public val identifier: Identifier? = null,
    /**
     * Related Resource to this DocumentManifest. For example, Order, ServiceRequest, Procedure,
     * EligibilityRequest, etc.
     *
     * If both identifier and ref elements are present they shall refer to the same thing.
     */
    public val ref: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier?.toBuilder()
          ref = this@with.ref?.toBuilder()
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
       * Related identifier to this DocumentManifest. For example, Order numbers, accession numbers,
       * XDW workflow numbers.
       *
       * If both identifier and ref elements are present they shall refer to the same thing.
       */
      public var identifier: Identifier.Builder? = null

      /**
       * Related Resource to this DocumentManifest. For example, Order, ServiceRequest, Procedure,
       * EligibilityRequest, etc.
       *
       * If both identifier and ref elements are present they shall refer to the same thing.
       */
      public var ref: Reference.Builder? = null

      public fun build(): Related =
        Related(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier?.build(),
          ref = ref?.build(),
        )
    }
  }

  public class Builder(
    /**
     * The status of this document manifest.
     *
     * This element is labeled as a modifier because the status contains the codes that mark the
     * manifest as not currently valid.
     */
    public var status: Enumeration<DocumentReferenceStatus>,
    /**
     * The list of Resources that consist of the parts of this manifest.
     *
     * When used for XDS the intended focus of the DocumentManifest is for the reference to target
     * to be a set of DocumentReference Resources. The reference is to "Any" to support EN 13606
     * usage, where an extract is DocumentManifest that references List and Composition resources.
     */
    public var content: MutableList<Reference.Builder>,
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
     * A single identifier that uniquely identifies this manifest. Principally used to refer to the
     * manifest in non-FHIR contexts.
     */
    public var masterIdentifier: Identifier.Builder? = null

    /**
     * Other identifiers associated with the document manifest, including version independent
     * identifiers.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The code specifying the type of clinical activity that resulted in placing the associated
     * content into the DocumentManifest.
     *
     * Specifies the kind of this set of documents (e.g. Patient Summary, Discharge Summary,
     * Prescription, etc.). The type of a set of documents may be the same as one of the documents
     * in it - especially if there is only one - but it may be wider.
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * Who or what the set of documents is about. The documents can be about a person, (patient or
     * healthcare practitioner), a device (i.e. machine) or even a group of subjects (such as a
     * document about a herd of farm animals, or a set of patients that share a common exposure). If
     * the documents cross more than one subject, then more than one subject is allowed here
     * (unusual use case).
     */
    public var subject: Reference.Builder? = null

    /**
     * When the document manifest was created for submission to the server (not necessarily the same
     * thing as the actual resource last modified time, since it may be modified, replicated, etc.).
     *
     * Creation time is used for tracking, organizing versions and searching. This is the creation
     * time of the document set, not the documents on which it is based.
     */
    public var created: DateTime.Builder? = null

    /**
     * Identifies who is the author of the manifest. Manifest author is not necessarly the author of
     * the references included.
     *
     * Not necessarily who did the actual data entry (i.e. typist) or who was the source
     * (informant).
     */
    public var author: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A patient, practitioner, or organization for which this set of documents is intended.
     *
     * How the recipient receives the document set or is notified of it is up to the implementation.
     * This element is just a statement of intent. If the recipient is a person, and it is not known
     * whether the person is a patient or a practitioner, RelatedPerson would be the default choice.
     */
    public var recipient: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Identifies the source system, application, or software that produced the document manifest.
     */
    public var source: Uri.Builder? = null

    /**
     * Human-readable description of the source document. This is sometimes known as the "title".
     *
     * What the document is about, rather than a terse summary of the document. It is commonly the
     * case that records do not have a title and are collectively referred to by the display name of
     * Record code (e.g. a "consultation" or "progress note").
     */
    public var description: String.Builder? = null

    /**
     * Related identifiers or resources associated with the DocumentManifest.
     *
     * May be identifiers or resources that caused the DocumentManifest to be created.
     */
    public var related: MutableList<Related.Builder> = mutableListOf()

    override fun build(): DocumentManifest =
      DocumentManifest(
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
        type = type?.build(),
        subject = subject?.build(),
        created = created?.build(),
        author = author.map { it.build() },
        recipient = recipient.map { it.build() },
        source = source?.build(),
        description = description?.build(),
        content = content.map { it.build() },
        related = related.map { it.build() },
      )
  }
}

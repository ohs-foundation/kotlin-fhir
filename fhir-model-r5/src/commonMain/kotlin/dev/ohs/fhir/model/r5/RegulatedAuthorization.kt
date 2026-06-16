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

import dev.ohs.fhir.model.r5.serializers.RegulatedAuthorizationCaseSerializer
import dev.ohs.fhir.model.r5.serializers.RegulatedAuthorizationSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Regulatory approval, clearance or licencing related to a regulated product, treatment, facility
 * or activity that is cited in a guidance, regulation, rule or legislative act. An example is
 * Market Authorization relating to a Medicinal Product.
 */
@Serializable(with = RegulatedAuthorizationSerializer::class)
@SerialName("RegulatedAuthorization")
public data class RegulatedAuthorization(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
   */
  override val id: String? = null,
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
  /** Business identifier for the authorization, typically assigned by the authorizing body. */
  public val identifier: List<Identifier> = listOf(),
  /** The product type, treatment, facility or activity that is being authorized. */
  public val subject: List<Reference> = listOf(),
  /**
   * Overall type of this authorization, for example drug marketing approval, orphan drug
   * designation.
   */
  public val type: CodeableConcept? = null,
  /** General textual supporting information. */
  public val description: Markdown? = null,
  /**
   * The territory (e.g., country, jurisdiction etc.) in which the authorization has been granted.
   */
  public val region: List<CodeableConcept> = listOf(),
  /**
   * The status that is authorised e.g. approved. Intermediate states and actions can be tracked
   * with cases and applications.
   */
  public val status: CodeableConcept? = null,
  /** The date at which the current status was assigned. */
  public val statusDate: DateTime? = null,
  /**
   * The time period in which the regulatory approval, clearance or licencing is in effect. As an
   * example, a Marketing Authorization includes the date of authorization and/or an expiration
   * date.
   */
  public val validityPeriod: Period? = null,
  /** Condition for which the use of the regulated product applies. */
  public val indication: List<CodeableReference> = listOf(),
  /** The intended use of the product, e.g. prevention, treatment, diagnosis. */
  public val intendedUse: CodeableConcept? = null,
  /**
   * The legal or regulatory framework against which this authorization is granted, or other reasons
   * for it.
   */
  public val basis: List<CodeableConcept> = listOf(),
  /**
   * The organization that has been granted this authorization, by some authoritative body (the
   * 'regulator').
   */
  public val holder: Reference? = null,
  /**
   * The regulatory authority or authorizing body granting the authorization. For example, European
   * Medicines Agency (EMA), Food and Drug Administration (FDA), Health Canada (HC), etc.
   */
  public val regulator: Reference? = null,
  /** Additional information or supporting documentation about the authorization. */
  public val attachedDocument: List<Reference> = listOf(),
  /**
   * The case or regulatory procedure for granting or amending a regulated authorization. An
   * authorization is granted in response to submissions/applications by those seeking
   * authorization. A case is the administrative process that deals with the application(s) that
   * relate to this and assesses them. Note: This area is subject to ongoing review and the
   * workgroup is seeking implementer feedback on its use (see link at bottom of page).
   */
  public val case: Case? = null,
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
        subject = this@with.subject.map { it.toBuilder() }.toMutableList()
        type = this@with.type?.toBuilder()
        description = this@with.description?.toBuilder()
        region = this@with.region.map { it.toBuilder() }.toMutableList()
        status = this@with.status?.toBuilder()
        statusDate = this@with.statusDate?.toBuilder()
        validityPeriod = this@with.validityPeriod?.toBuilder()
        indication = this@with.indication.map { it.toBuilder() }.toMutableList()
        intendedUse = this@with.intendedUse?.toBuilder()
        basis = this@with.basis.map { it.toBuilder() }.toMutableList()
        holder = this@with.holder?.toBuilder()
        regulator = this@with.regulator?.toBuilder()
        attachedDocument = this@with.attachedDocument.map { it.toBuilder() }.toMutableList()
        case = this@with.case?.toBuilder()
      }
    }

  /**
   * The case or regulatory procedure for granting or amending a regulated authorization. An
   * authorization is granted in response to submissions/applications by those seeking
   * authorization. A case is the administrative process that deals with the application(s) that
   * relate to this and assesses them. Note: This area is subject to ongoing review and the
   * workgroup is seeking implementer feedback on its use (see link at bottom of page).
   */
  @Serializable(with = RegulatedAuthorizationCaseSerializer::class)
  public data class Case(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** Identifier by which this case can be referenced. */
    public val identifier: Identifier? = null,
    /** The defining type of case. */
    public val type: CodeableConcept? = null,
    /** The status associated with the case. */
    public val status: CodeableConcept? = null,
    /** Relevant date for this case. */
    public val date: Date? = null,
    /**
     * A regulatory submission from an organization to a regulator, as part of an assessing case.
     * Multiple applications may occur over time, with more or different information to support or
     * modify the submission or the authorization. The applications can be considered as steps
     * within the longer running case or procedure for this authorization process.
     */
    public val application: List<Case> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier?.toBuilder()
          type = this@with.type?.toBuilder()
          status = this@with.status?.toBuilder()
          date = this@with.date
          application = this@with.application.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Date {
      public fun asPeriod(): Period? = this as? Period

      public fun asDateTime(): DateTime? = this as? DateTime

      public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Date

      public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Date

      public companion object {
        internal fun from(
          periodValue: dev.ohs.fhir.model.r5.Period?,
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
        ): Date? {
          if (periodValue != null) return Period(periodValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          return null
        }
      }
    }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /** Identifier by which this case can be referenced. */
      public var identifier: Identifier.Builder? = null

      /** The defining type of case. */
      public var type: CodeableConcept.Builder? = null

      /** The status associated with the case. */
      public var status: CodeableConcept.Builder? = null

      /** Relevant date for this case. */
      public var date: Date? = null

      /**
       * A regulatory submission from an organization to a regulator, as part of an assessing case.
       * Multiple applications may occur over time, with more or different information to support or
       * modify the submission or the authorization. The applications can be considered as steps
       * within the longer running case or procedure for this authorization process.
       */
      public var application: MutableList<Builder> = mutableListOf()

      public fun build(): Case =
        Case(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier?.build(),
          type = type?.build(),
          status = status?.build(),
          date = date,
          application = application.map { it.build() },
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
    override var id: String? = null

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

    /** Business identifier for the authorization, typically assigned by the authorizing body. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** The product type, treatment, facility or activity that is being authorized. */
    public var subject: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Overall type of this authorization, for example drug marketing approval, orphan drug
     * designation.
     */
    public var type: CodeableConcept.Builder? = null

    /** General textual supporting information. */
    public var description: Markdown.Builder? = null

    /**
     * The territory (e.g., country, jurisdiction etc.) in which the authorization has been granted.
     */
    public var region: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The status that is authorised e.g. approved. Intermediate states and actions can be tracked
     * with cases and applications.
     */
    public var status: CodeableConcept.Builder? = null

    /** The date at which the current status was assigned. */
    public var statusDate: DateTime.Builder? = null

    /**
     * The time period in which the regulatory approval, clearance or licencing is in effect. As an
     * example, a Marketing Authorization includes the date of authorization and/or an expiration
     * date.
     */
    public var validityPeriod: Period.Builder? = null

    /** Condition for which the use of the regulated product applies. */
    public var indication: MutableList<CodeableReference.Builder> = mutableListOf()

    /** The intended use of the product, e.g. prevention, treatment, diagnosis. */
    public var intendedUse: CodeableConcept.Builder? = null

    /**
     * The legal or regulatory framework against which this authorization is granted, or other
     * reasons for it.
     */
    public var basis: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The organization that has been granted this authorization, by some authoritative body (the
     * 'regulator').
     */
    public var holder: Reference.Builder? = null

    /**
     * The regulatory authority or authorizing body granting the authorization. For example,
     * European Medicines Agency (EMA), Food and Drug Administration (FDA), Health Canada (HC), etc.
     */
    public var regulator: Reference.Builder? = null

    /** Additional information or supporting documentation about the authorization. */
    public var attachedDocument: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The case or regulatory procedure for granting or amending a regulated authorization. An
     * authorization is granted in response to submissions/applications by those seeking
     * authorization. A case is the administrative process that deals with the application(s) that
     * relate to this and assesses them. Note: This area is subject to ongoing review and the
     * workgroup is seeking implementer feedback on its use (see link at bottom of page).
     */
    public var case: Case.Builder? = null

    override fun build(): RegulatedAuthorization =
      RegulatedAuthorization(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        subject = subject.map { it.build() },
        type = type?.build(),
        description = description?.build(),
        region = region.map { it.build() },
        status = status?.build(),
        statusDate = statusDate?.build(),
        validityPeriod = validityPeriod?.build(),
        indication = indication.map { it.build() },
        intendedUse = intendedUse?.build(),
        basis = basis.map { it.build() },
        holder = holder?.build(),
        regulator = regulator?.build(),
        attachedDocument = attachedDocument.map { it.build() },
        case = case?.build(),
      )
  }
}

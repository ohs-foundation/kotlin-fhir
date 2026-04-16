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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.EpisodeOfCareDiagnosisSerializer
import dev.ohs.fhir.model.r5.serializers.EpisodeOfCareReasonSerializer
import dev.ohs.fhir.model.r5.serializers.EpisodeOfCareSerializer
import dev.ohs.fhir.model.r5.serializers.EpisodeOfCareStatusHistorySerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An association between a patient and an organization / healthcare provider(s) during which time
 * encounters may occur. The managing organization assumes a level of responsibility for the patient
 * during this time.
 */
@Serializable(with = EpisodeOfCareSerializer::class)
@SerialName("EpisodeOfCare")
public data class EpisodeOfCare(
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
  /**
   * The EpisodeOfCare may be known by different identifiers for different contexts of use, such as
   * when an external agency is tracking the Episode for funding purposes.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * planned | waitlist | active | onhold | finished | cancelled.
   *
   * This element is labeled as a modifier because the status contains codes that mark the episode
   * as not currently valid.
   */
  public val status: Enumeration<EpisodeOfCareStatus>,
  /**
   * The history of statuses that the EpisodeOfCare has been through (without requiring processing
   * the history of the resource).
   */
  public val statusHistory: List<StatusHistory> = listOf(),
  /**
   * A classification of the type of episode of care; e.g. specialist referral, disease management,
   * type of funded care.
   *
   * The type can be very important in processing as this could be used in determining if the
   * EpisodeOfCare is relevant to specific government reporting, or other types of classifications.
   */
  public val type: List<CodeableConcept> = listOf(),
  /**
   * The list of medical reasons that are expected to be addressed during the episode of care.
   *
   * The reason communicates what medical problem the patient has that should be addressed during
   * the episode of care. This reason could be patient reported complaint, a clinical indication
   * that was determined in a previous encounter or episode of care, or some planned care such as an
   * immunization recommendation. In the case where you have a primary reason, but are expecting to
   * also address other problems, you can list the primary reason with a use code of 'Chief
   * Complaint', while the other problems being addressed would have a use code of 'Reason for
   * Visit'.
   *
   * Examples: pregnancy would use HealthcareService or a coding as the reason patient home
   * monitoring could use Condition as the reason
   */
  public val reason: List<Reason> = listOf(),
  /**
   * The list of medical conditions that were addressed during the episode of care.
   *
   * The diagnosis communicates what medical conditions were actually addressed during the episode
   * of care. If a diagnosis was provided as a reason, and was treated during the episode of care,
   * it may be listed in both EpisodeOfCare.reason and EpisodeOfCare.diagnosis.
   *
   * Diagnoses related to billing can be documented on the Account resources which supports ranking
   * for the purpose of reimbursement.
   */
  public val diagnosis: List<Diagnosis> = listOf(),
  /** The patient who is the focus of this episode of care. */
  public val patient: Reference,
  /**
   * The organization that has assumed the specific responsibilities for care coordination, care
   * delivery, or other services for the specified duration.
   *
   * If multiple organizations are involved in care delivery, the care teams from those
   * organizations would be represented in EpisodeOfCare.team, while the primary organization
   * managing the care would be listed in EpisodeOfCare.managingOrganization. Other organizations
   * may have their own EpisodeOfCare for tracking their activities.
   */
  public val managingOrganization: Reference? = null,
  /** The interval during which the managing organization assumes the defined responsibility. */
  public val period: Period? = null,
  /** Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals. */
  public val referralRequest: List<Reference> = listOf(),
  /** The practitioner that is the care manager/care coordinator for this patient. */
  public val careManager: Reference? = null,
  /**
   * The list of practitioners that may be facilitating this episode of care for specific purposes.
   */
  public val careTeam: List<Reference> = listOf(),
  /**
   * The set of accounts that may be used for billing for this EpisodeOfCare.
   *
   * The billing system may choose to allocate billable items associated with the EpisodeOfCare to
   * different referenced Accounts based on internal business rules.
   */
  public val account: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, patient.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        statusHistory = this@with.statusHistory.map { it.toBuilder() }.toMutableList()
        type = this@with.type.map { it.toBuilder() }.toMutableList()
        reason = this@with.reason.map { it.toBuilder() }.toMutableList()
        diagnosis = this@with.diagnosis.map { it.toBuilder() }.toMutableList()
        managingOrganization = this@with.managingOrganization?.toBuilder()
        period = this@with.period?.toBuilder()
        referralRequest = this@with.referralRequest.map { it.toBuilder() }.toMutableList()
        careManager = this@with.careManager?.toBuilder()
        careTeam = this@with.careTeam.map { it.toBuilder() }.toMutableList()
        account = this@with.account.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * The history of statuses that the EpisodeOfCare has been through (without requiring processing
   * the history of the resource).
   */
  @Serializable(with = EpisodeOfCareStatusHistorySerializer::class)
  public data class StatusHistory(
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
    /** planned | waitlist | active | onhold | finished | cancelled. */
    public val status: Enumeration<EpisodeOfCareStatus>,
    /** The period during this EpisodeOfCare that the specific status applied. */
    public val period: Period,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(status, period.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** planned | waitlist | active | onhold | finished | cancelled. */
      public var status: Enumeration<EpisodeOfCareStatus>,
      /** The period during this EpisodeOfCare that the specific status applied. */
      public var period: Period.Builder,
    ) {
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

      public fun build(): StatusHistory =
        StatusHistory(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          status = status,
          period = period.build(),
        )
    }
  }

  /** The list of medical reasons that are expected to be addressed during the episode of care. */
  @Serializable(with = EpisodeOfCareReasonSerializer::class)
  public data class Reason(
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
    /**
     * What the reason value should be used as e.g. Chief Complaint, Health Concern, Health
     * Maintenance (including screening).
     */
    public val use: CodeableConcept? = null,
    /**
     * The medical reason that is expected to be addressed during the episode of care, expressed as
     * a text, code or a reference to another resource.
     */
    public val `value`: List<CodeableReference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          use = this@with.use?.toBuilder()
          `value` = this@with.`value`.map { it.toBuilder() }.toMutableList()
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

      /**
       * What the reason value should be used as e.g. Chief Complaint, Health Concern, Health
       * Maintenance (including screening).
       */
      public var use: CodeableConcept.Builder? = null

      /**
       * The medical reason that is expected to be addressed during the episode of care, expressed
       * as a text, code or a reference to another resource.
       */
      public var `value`: MutableList<CodeableReference.Builder> = mutableListOf()

      public fun build(): Reason =
        Reason(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          use = use?.build(),
          `value` = `value`.map { it.build() },
        )
    }
  }

  /** The list of medical conditions that were addressed during the episode of care. */
  @Serializable(with = EpisodeOfCareDiagnosisSerializer::class)
  public data class Diagnosis(
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
    /**
     * The medical condition that was addressed during the episode of care, expressed as a text,
     * code or a reference to another resource.
     */
    public val condition: List<CodeableReference> = listOf(),
    /**
     * Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge
     * …).
     */
    public val use: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          condition = this@with.condition.map { it.toBuilder() }.toMutableList()
          use = this@with.use?.toBuilder()
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

      /**
       * The medical condition that was addressed during the episode of care, expressed as a text,
       * code or a reference to another resource.
       */
      public var condition: MutableList<CodeableReference.Builder> = mutableListOf()

      /**
       * Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge
       * …).
       */
      public var use: CodeableConcept.Builder? = null

      public fun build(): Diagnosis =
        Diagnosis(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          condition = condition.map { it.build() },
          use = use?.build(),
        )
    }
  }

  public class Builder(
    /**
     * planned | waitlist | active | onhold | finished | cancelled.
     *
     * This element is labeled as a modifier because the status contains codes that mark the episode
     * as not currently valid.
     */
    public var status: Enumeration<EpisodeOfCareStatus>,
    /** The patient who is the focus of this episode of care. */
    public var patient: Reference.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
     */
    public var id: String? = null

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
     * The EpisodeOfCare may be known by different identifiers for different contexts of use, such
     * as when an external agency is tracking the Episode for funding purposes.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The history of statuses that the EpisodeOfCare has been through (without requiring processing
     * the history of the resource).
     */
    public var statusHistory: MutableList<StatusHistory.Builder> = mutableListOf()

    /**
     * A classification of the type of episode of care; e.g. specialist referral, disease
     * management, type of funded care.
     *
     * The type can be very important in processing as this could be used in determining if the
     * EpisodeOfCare is relevant to specific government reporting, or other types of
     * classifications.
     */
    public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The list of medical reasons that are expected to be addressed during the episode of care.
     *
     * The reason communicates what medical problem the patient has that should be addressed during
     * the episode of care. This reason could be patient reported complaint, a clinical indication
     * that was determined in a previous encounter or episode of care, or some planned care such as
     * an immunization recommendation. In the case where you have a primary reason, but are
     * expecting to also address other problems, you can list the primary reason with a use code of
     * 'Chief Complaint', while the other problems being addressed would have a use code of 'Reason
     * for Visit'.
     *
     * Examples: pregnancy would use HealthcareService or a coding as the reason patient home
     * monitoring could use Condition as the reason
     */
    public var reason: MutableList<Reason.Builder> = mutableListOf()

    /**
     * The list of medical conditions that were addressed during the episode of care.
     *
     * The diagnosis communicates what medical conditions were actually addressed during the episode
     * of care. If a diagnosis was provided as a reason, and was treated during the episode of care,
     * it may be listed in both EpisodeOfCare.reason and EpisodeOfCare.diagnosis.
     *
     * Diagnoses related to billing can be documented on the Account resources which supports
     * ranking for the purpose of reimbursement.
     */
    public var diagnosis: MutableList<Diagnosis.Builder> = mutableListOf()

    /**
     * The organization that has assumed the specific responsibilities for care coordination, care
     * delivery, or other services for the specified duration.
     *
     * If multiple organizations are involved in care delivery, the care teams from those
     * organizations would be represented in EpisodeOfCare.team, while the primary organization
     * managing the care would be listed in EpisodeOfCare.managingOrganization. Other organizations
     * may have their own EpisodeOfCare for tracking their activities.
     */
    public var managingOrganization: Reference.Builder? = null

    /** The interval during which the managing organization assumes the defined responsibility. */
    public var period: Period.Builder? = null

    /** Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals. */
    public var referralRequest: MutableList<Reference.Builder> = mutableListOf()

    /** The practitioner that is the care manager/care coordinator for this patient. */
    public var careManager: Reference.Builder? = null

    /**
     * The list of practitioners that may be facilitating this episode of care for specific
     * purposes.
     */
    public var careTeam: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The set of accounts that may be used for billing for this EpisodeOfCare.
     *
     * The billing system may choose to allocate billable items associated with the EpisodeOfCare to
     * different referenced Accounts based on internal business rules.
     */
    public var account: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): EpisodeOfCare =
      EpisodeOfCare(
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
        statusHistory = statusHistory.map { it.build() },
        type = type.map { it.build() },
        reason = reason.map { it.build() },
        diagnosis = diagnosis.map { it.build() },
        patient = patient.build(),
        managingOrganization = managingOrganization?.build(),
        period = period?.build(),
        referralRequest = referralRequest.map { it.build() },
        careManager = careManager?.build(),
        careTeam = careTeam.map { it.build() },
        account = account.map { it.build() },
      )
  }

  /** The status of the episode of care. */
  public enum class EpisodeOfCareStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Planned("planned", "http://hl7.org/fhir/episode-of-care-status", "Planned"),
    Waitlist("waitlist", "http://hl7.org/fhir/episode-of-care-status", "Waitlist"),
    Active("active", "http://hl7.org/fhir/episode-of-care-status", "Active"),
    Onhold("onhold", "http://hl7.org/fhir/episode-of-care-status", "On Hold"),
    Finished("finished", "http://hl7.org/fhir/episode-of-care-status", "Finished"),
    Cancelled("cancelled", "http://hl7.org/fhir/episode-of-care-status", "Cancelled"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/episode-of-care-status",
      "Entered in Error",
    );

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): EpisodeOfCareStatus =
        when (code) {
          "planned" -> Planned
          "waitlist" -> Waitlist
          "active" -> Active
          "onhold" -> Onhold
          "finished" -> Finished
          "cancelled" -> Cancelled
          "entered-in-error" -> Entered_In_Error
          else -> throw IllegalArgumentException("Unknown code $code for enum EpisodeOfCareStatus")
        }
    }
  }
}

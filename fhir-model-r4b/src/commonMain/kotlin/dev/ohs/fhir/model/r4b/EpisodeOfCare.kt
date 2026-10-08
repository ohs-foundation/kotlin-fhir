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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.EpisodeOfCareDiagnosisSerializer
import dev.ohs.fhir.model.r4b.serializers.EpisodeOfCareSerializer
import dev.ohs.fhir.model.r4b.serializers.EpisodeOfCareStatusHistorySerializer
import dev.ohs.fhir.model.r4b.terminologies.EpisodeOfCareStatus
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
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
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
  /** The list of diagnosis relevant to this episode of care. */
  public val diagnosis: List<Diagnosis> = listOf(),
  /** The patient who is the focus of this episode of care. */
  public val patient: Reference,
  /** The organization that has assumed the specific responsibilities for the specified duration. */
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
  public val team: List<Reference> = listOf(),
  /**
   * The set of accounts that may be used for billing for this EpisodeOfCare.
   *
   * The billing system may choose to allocate billable items associated with the EpisodeOfCare to
   * different referenced Accounts based on internal business rules.
   */
  public val account: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        status,
        patient.toBuilder(),
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
    builder.statusHistory = statusHistory.mapToMutableList { it.toBuilder() }
    builder.type = type.mapToMutableList { it.toBuilder() }
    builder.diagnosis = diagnosis.mapToMutableList { it.toBuilder() }
    builder.managingOrganization = managingOrganization?.toBuilder()
    builder.period = period?.toBuilder()
    builder.referralRequest = referralRequest.mapToMutableList { it.toBuilder() }
    builder.careManager = careManager?.toBuilder()
    builder.team = team.mapToMutableList { it.toBuilder() }
    builder.account = account.mapToMutableList { it.toBuilder() }
    return builder
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
    /** planned | waitlist | active | onhold | finished | cancelled. */
    public val status: Enumeration<EpisodeOfCareStatus>,
    /** The period during this EpisodeOfCare that the specific status applied. */
    public val period: Period,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder =
        Builder(
          status,
          period.toBuilder(),
        )
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      return builder
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

      public fun build(): StatusHistory =
        StatusHistory(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          status = status,
          period = period.build(),
        )
    }
  }

  /** The list of diagnosis relevant to this episode of care. */
  @Serializable(with = EpisodeOfCareDiagnosisSerializer::class)
  public data class Diagnosis(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
     * A list of conditions/problems/diagnoses that this episode of care is intended to be providing
     * care for.
     */
    public val condition: Reference,
    /**
     * Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge
     * …).
     */
    public val role: CodeableConcept? = null,
    /** Ranking of the diagnosis (for each role type). */
    public val rank: PositiveInt? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder(condition.toBuilder())
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.role = role?.toBuilder()
      builder.rank = rank?.toBuilder()
      return builder
    }

    public class Builder(
      /**
       * A list of conditions/problems/diagnoses that this episode of care is intended to be
       * providing care for.
       */
      public var condition: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge
       * …).
       */
      public var role: CodeableConcept.Builder? = null

      /** Ranking of the diagnosis (for each role type). */
      public var rank: PositiveInt.Builder? = null

      public fun build(): Diagnosis =
        Diagnosis(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          condition = condition.build(),
          role = role?.build(),
          rank = rank?.build(),
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
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
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

    /** The list of diagnosis relevant to this episode of care. */
    public var diagnosis: MutableList<Diagnosis.Builder> = mutableListOf()

    /**
     * The organization that has assumed the specific responsibilities for the specified duration.
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
    public var team: MutableList<Reference.Builder> = mutableListOf()

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
        contained = contained.mapToList { it.build() },
        extension = extension.mapToList { it.build() },
        modifierExtension = modifierExtension.mapToList { it.build() },
        identifier = identifier.mapToList { it.build() },
        status = status,
        statusHistory = statusHistory.mapToList { it.build() },
        type = type.mapToList { it.build() },
        diagnosis = diagnosis.mapToList { it.build() },
        patient = patient.build(),
        managingOrganization = managingOrganization?.build(),
        period = period?.build(),
        referralRequest = referralRequest.mapToList { it.build() },
        careManager = careManager?.build(),
        team = team.mapToList { it.build() },
        account = account.mapToList { it.build() },
      )
  }
}

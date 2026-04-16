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

import dev.ohs.fhir.model.r4.serializers.VerificationResultAttestationSerializer
import dev.ohs.fhir.model.r4.serializers.VerificationResultPrimarySourceSerializer
import dev.ohs.fhir.model.r4.serializers.VerificationResultSerializer
import dev.ohs.fhir.model.r4.serializers.VerificationResultValidatorSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Describes validation requirements, source(s), status and dates for one or more elements. */
@Serializable(with = VerificationResultSerializer::class)
@SerialName("VerificationResult")
public data class VerificationResult(
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
  /** A resource that was validated. */
  public val target: List<Reference> = listOf(),
  /** The fhirpath location(s) within the resource that was validated. */
  public val targetLocation: List<String> = listOf(),
  /** The frequency with which the target must be validated (none; initial; periodic). */
  public val need: CodeableConcept? = null,
  /**
   * The validation status of the target (attested; validated; in process; requires revalidation;
   * validation failed; revalidation failed).
   */
  public val status: Enumeration<Status>,
  /** When the validation status was updated. */
  public val statusDate: DateTime? = null,
  /** What the target is validated against (nothing; primary source; multiple sources). */
  public val validationType: CodeableConcept? = null,
  /**
   * The primary process by which the target is validated (edit check; value set; primary source;
   * multiple sources; standalone; in context).
   */
  public val validationProcess: List<CodeableConcept> = listOf(),
  /** Frequency of revalidation. */
  public val frequency: Timing? = null,
  /** The date/time validation was last completed (including failed validations). */
  public val lastPerformed: DateTime? = null,
  /** The date when target is next validated, if appropriate. */
  public val nextScheduled: Date? = null,
  /** The result if validation fails (fatal; warning; record only; none). */
  public val failureAction: CodeableConcept? = null,
  /** Information about the primary source(s) involved in validation. */
  public val primarySource: List<PrimarySource> = listOf(),
  /** Information about the entity attesting to information. */
  public val attestation: Attestation? = null,
  /** Information about the entity validating information. */
  public val validator: List<Validator> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        target = this@with.target.map { it.toBuilder() }.toMutableList()
        targetLocation = this@with.targetLocation.map { it.toBuilder() }.toMutableList()
        need = this@with.need?.toBuilder()
        statusDate = this@with.statusDate?.toBuilder()
        validationType = this@with.validationType?.toBuilder()
        validationProcess = this@with.validationProcess.map { it.toBuilder() }.toMutableList()
        frequency = this@with.frequency?.toBuilder()
        lastPerformed = this@with.lastPerformed?.toBuilder()
        nextScheduled = this@with.nextScheduled?.toBuilder()
        failureAction = this@with.failureAction?.toBuilder()
        primarySource = this@with.primarySource.map { it.toBuilder() }.toMutableList()
        attestation = this@with.attestation?.toBuilder()
        validator = this@with.validator.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Information about the primary source(s) involved in validation. */
  @Serializable(with = VerificationResultPrimarySourceSerializer::class)
  public data class PrimarySource(
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
    /** Reference to the primary source. */
    public val who: Reference? = null,
    /**
     * Type of primary source (License Board; Primary Education; Continuing Education; Postal
     * Service; Relationship owner; Registration Authority; legal source; issuing source;
     * authoritative source).
     */
    public val type: List<CodeableConcept> = listOf(),
    /** Method for communicating with the primary source (manual; API; Push). */
    public val communicationMethod: List<CodeableConcept> = listOf(),
    /**
     * Status of the validation of the target against the primary source (successful; failed;
     * unknown).
     */
    public val validationStatus: CodeableConcept? = null,
    /** When the target was validated against the primary source. */
    public val validationDate: DateTime? = null,
    /** Ability of the primary source to push updates/alerts (yes; no; undetermined). */
    public val canPushUpdates: CodeableConcept? = null,
    /**
     * Type of alerts/updates the primary source can send (specific requested changes; any changes;
     * as defined by source).
     */
    public val pushTypeAvailable: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          who = this@with.who?.toBuilder()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          communicationMethod = this@with.communicationMethod.map { it.toBuilder() }.toMutableList()
          validationStatus = this@with.validationStatus?.toBuilder()
          validationDate = this@with.validationDate?.toBuilder()
          canPushUpdates = this@with.canPushUpdates?.toBuilder()
          pushTypeAvailable = this@with.pushTypeAvailable.map { it.toBuilder() }.toMutableList()
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

      /** Reference to the primary source. */
      public var who: Reference.Builder? = null

      /**
       * Type of primary source (License Board; Primary Education; Continuing Education; Postal
       * Service; Relationship owner; Registration Authority; legal source; issuing source;
       * authoritative source).
       */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Method for communicating with the primary source (manual; API; Push). */
      public var communicationMethod: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Status of the validation of the target against the primary source (successful; failed;
       * unknown).
       */
      public var validationStatus: CodeableConcept.Builder? = null

      /** When the target was validated against the primary source. */
      public var validationDate: DateTime.Builder? = null

      /** Ability of the primary source to push updates/alerts (yes; no; undetermined). */
      public var canPushUpdates: CodeableConcept.Builder? = null

      /**
       * Type of alerts/updates the primary source can send (specific requested changes; any
       * changes; as defined by source).
       */
      public var pushTypeAvailable: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): PrimarySource =
        PrimarySource(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          who = who?.build(),
          type = type.map { it.build() },
          communicationMethod = communicationMethod.map { it.build() },
          validationStatus = validationStatus?.build(),
          validationDate = validationDate?.build(),
          canPushUpdates = canPushUpdates?.build(),
          pushTypeAvailable = pushTypeAvailable.map { it.build() },
        )
    }
  }

  /** Information about the entity attesting to information. */
  @Serializable(with = VerificationResultAttestationSerializer::class)
  public data class Attestation(
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
    /** The individual or organization attesting to information. */
    public val who: Reference? = null,
    /** When the who is asserting on behalf of another (organization or individual). */
    public val onBehalfOf: Reference? = null,
    /** The method by which attested information was submitted/retrieved (manual; API; Push). */
    public val communicationMethod: CodeableConcept? = null,
    /** The date the information was attested to. */
    public val date: Date? = null,
    /** A digital identity certificate associated with the attestation source. */
    public val sourceIdentityCertificate: String? = null,
    /**
     * A digital identity certificate associated with the proxy entity submitting attested
     * information on behalf of the attestation source.
     */
    public val proxyIdentityCertificate: String? = null,
    /**
     * Signed assertion by the proxy entity indicating that they have the right to submit attested
     * information on behalf of the attestation source.
     */
    public val proxySignature: Signature? = null,
    /** Signed assertion by the attestation source that they have attested to the information. */
    public val sourceSignature: Signature? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          who = this@with.who?.toBuilder()
          onBehalfOf = this@with.onBehalfOf?.toBuilder()
          communicationMethod = this@with.communicationMethod?.toBuilder()
          date = this@with.date?.toBuilder()
          sourceIdentityCertificate = this@with.sourceIdentityCertificate?.toBuilder()
          proxyIdentityCertificate = this@with.proxyIdentityCertificate?.toBuilder()
          proxySignature = this@with.proxySignature?.toBuilder()
          sourceSignature = this@with.sourceSignature?.toBuilder()
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

      /** The individual or organization attesting to information. */
      public var who: Reference.Builder? = null

      /** When the who is asserting on behalf of another (organization or individual). */
      public var onBehalfOf: Reference.Builder? = null

      /** The method by which attested information was submitted/retrieved (manual; API; Push). */
      public var communicationMethod: CodeableConcept.Builder? = null

      /** The date the information was attested to. */
      public var date: Date.Builder? = null

      /** A digital identity certificate associated with the attestation source. */
      public var sourceIdentityCertificate: String.Builder? = null

      /**
       * A digital identity certificate associated with the proxy entity submitting attested
       * information on behalf of the attestation source.
       */
      public var proxyIdentityCertificate: String.Builder? = null

      /**
       * Signed assertion by the proxy entity indicating that they have the right to submit attested
       * information on behalf of the attestation source.
       */
      public var proxySignature: Signature.Builder? = null

      /** Signed assertion by the attestation source that they have attested to the information. */
      public var sourceSignature: Signature.Builder? = null

      public fun build(): Attestation =
        Attestation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          who = who?.build(),
          onBehalfOf = onBehalfOf?.build(),
          communicationMethod = communicationMethod?.build(),
          date = date?.build(),
          sourceIdentityCertificate = sourceIdentityCertificate?.build(),
          proxyIdentityCertificate = proxyIdentityCertificate?.build(),
          proxySignature = proxySignature?.build(),
          sourceSignature = sourceSignature?.build(),
        )
    }
  }

  /** Information about the entity validating information. */
  @Serializable(with = VerificationResultValidatorSerializer::class)
  public data class Validator(
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
    /** Reference to the organization validating information. */
    public val organization: Reference,
    /** A digital identity certificate associated with the validator. */
    public val identityCertificate: String? = null,
    /** Signed assertion by the validator that they have validated the information. */
    public val attestationSignature: Signature? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(organization.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identityCertificate = this@with.identityCertificate?.toBuilder()
          attestationSignature = this@with.attestationSignature?.toBuilder()
        }
      }

    public class Builder(
      /** Reference to the organization validating information. */
      public var organization: Reference.Builder
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

      /** A digital identity certificate associated with the validator. */
      public var identityCertificate: String.Builder? = null

      /** Signed assertion by the validator that they have validated the information. */
      public var attestationSignature: Signature.Builder? = null

      public fun build(): Validator =
        Validator(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          organization = organization.build(),
          identityCertificate = identityCertificate?.build(),
          attestationSignature = attestationSignature?.build(),
        )
    }
  }

  public class Builder(
    /**
     * The validation status of the target (attested; validated; in process; requires revalidation;
     * validation failed; revalidation failed).
     */
    public var status: Enumeration<Status>
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

    /** A resource that was validated. */
    public var target: MutableList<Reference.Builder> = mutableListOf()

    /** The fhirpath location(s) within the resource that was validated. */
    public var targetLocation: MutableList<String.Builder> = mutableListOf()

    /** The frequency with which the target must be validated (none; initial; periodic). */
    public var need: CodeableConcept.Builder? = null

    /** When the validation status was updated. */
    public var statusDate: DateTime.Builder? = null

    /** What the target is validated against (nothing; primary source; multiple sources). */
    public var validationType: CodeableConcept.Builder? = null

    /**
     * The primary process by which the target is validated (edit check; value set; primary source;
     * multiple sources; standalone; in context).
     */
    public var validationProcess: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Frequency of revalidation. */
    public var frequency: Timing.Builder? = null

    /** The date/time validation was last completed (including failed validations). */
    public var lastPerformed: DateTime.Builder? = null

    /** The date when target is next validated, if appropriate. */
    public var nextScheduled: Date.Builder? = null

    /** The result if validation fails (fatal; warning; record only; none). */
    public var failureAction: CodeableConcept.Builder? = null

    /** Information about the primary source(s) involved in validation. */
    public var primarySource: MutableList<PrimarySource.Builder> = mutableListOf()

    /** Information about the entity attesting to information. */
    public var attestation: Attestation.Builder? = null

    /** Information about the entity validating information. */
    public var validator: MutableList<Validator.Builder> = mutableListOf()

    override fun build(): VerificationResult =
      VerificationResult(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        target = target.map { it.build() },
        targetLocation = targetLocation.map { it.build() },
        need = need?.build(),
        status = status,
        statusDate = statusDate?.build(),
        validationType = validationType?.build(),
        validationProcess = validationProcess.map { it.build() },
        frequency = frequency?.build(),
        lastPerformed = lastPerformed?.build(),
        nextScheduled = nextScheduled?.build(),
        failureAction = failureAction?.build(),
        primarySource = primarySource.map { it.build() },
        attestation = attestation?.build(),
        validator = validator.map { it.build() },
      )
  }

  /** The validation status of the target */
  public enum class Status(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Attested("attested", "http://hl7.org/fhir/CodeSystem/status", "Attested"),
    Validated("validated", "http://hl7.org/fhir/CodeSystem/status", "Validated"),
    In_Process("in-process", "http://hl7.org/fhir/CodeSystem/status", "In process"),
    Req_Revalid("req-revalid", "http://hl7.org/fhir/CodeSystem/status", "Requires revalidation"),
    Val_Fail("val-fail", "http://hl7.org/fhir/CodeSystem/status", "Validation failed"),
    Reval_Fail("reval-fail", "http://hl7.org/fhir/CodeSystem/status", "Re-Validation failed");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): Status =
        when (code) {
          "attested" -> Attested
          "validated" -> Validated
          "in-process" -> In_Process
          "req-revalid" -> Req_Revalid
          "val-fail" -> Val_Fail
          "reval-fail" -> Reval_Fail
          else -> throw IllegalArgumentException("Unknown code $code for enum Status")
        }
    }
  }
}

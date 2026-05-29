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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.ProcedureFocalDeviceSerializer
import dev.ohs.fhir.model.r4b.serializers.ProcedurePerformerSerializer
import dev.ohs.fhir.model.r4b.serializers.ProcedureSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An action that is or was performed on or for a patient. This can be a physical intervention like
 * an operation, or less invasive like long term services, counseling, or hypnotherapy.
 */
@Serializable(with = ProcedureSerializer::class)
@SerialName("Procedure")
public data class Procedure(
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
   * Business identifiers assigned to this procedure by the performer or other systems which remain
   * constant as the resource is updated and is propagated from server to server.
   *
   * This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and Person resource instances might share the
   * same social insurance number.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is
   * adhered to in whole or in part by this Procedure.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally maintained protocol, guideline, order set or other definition
   * that is adhered to in whole or in part by this Procedure.
   *
   * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /** A reference to a resource that contains details of the request for this procedure. */
  public val basedOn: List<Reference> = listOf(),
  /**
   * A larger event of which this particular procedure is a component or step.
   *
   * The MedicationAdministration resource has a partOf reference to Procedure, but this is not a
   * circular reference. For example, the anesthesia MedicationAdministration is part of the
   * surgical Procedure (MedicationAdministration.partOf = Procedure). For example, the procedure to
   * insert the IV port for an IV medication administration is part of the medication administration
   * (Procedure.partOf = MedicationAdministration).
   */
  public val partOf: List<Reference> = listOf(),
  /**
   * A code specifying the state of the procedure. Generally, this will be the in-progress or
   * completed state.
   *
   * The "unknown" code is not to be used to convey other statuses. The "unknown" code should be
   * used when one of the statuses applies, but the authoring system doesn't know the current state
   * of the procedure.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<EventStatus>,
  /**
   * Captures the reason for the current state of the procedure.
   *
   * This is generally only used for "exception" statuses such as "not-done", "suspended" or
   * "aborted". The reason for performing the event at all is captured in reasonCode, not here.
   */
  public val statusReason: CodeableConcept? = null,
  /**
   * A code that classifies the procedure for searching, sorting and display purposes (e.g.
   * "Surgical Procedure").
   */
  public val category: CodeableConcept? = null,
  /**
   * The specific procedure that is performed. Use text if the exact nature of the procedure cannot
   * be coded (e.g. "Laparoscopic Appendectomy").
   */
  public val code: CodeableConcept? = null,
  /** The person, animal or group on which the procedure was performed. */
  public val subject: Reference,
  /**
   * The Encounter during which this Procedure was created or performed or to which the creation of
   * this record is tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter.
   */
  public val encounter: Reference? = null,
  /**
   * Estimated or actual date, date-time, period, or age when the procedure was performed. Allows a
   * period to support complex procedures that span more than one date, and also allows for the
   * length of the procedure to be captured.
   *
   * Age is generally used when the patient reports an age at which the procedure was performed.
   * Range is generally used when the patient reports an age range when the procedure was performed,
   * such as sometime between 20-25 years old. dateTime supports a range of precision due to some
   * procedures being reported as past procedures that might not have millisecond precision while
   * other procedures performed and documented during the encounter might have more precise UTC
   * timestamps with timezone.
   */
  public val performed: Performed? = null,
  /** Individual who recorded the record and takes responsibility for its content. */
  public val recorder: Reference? = null,
  /** Individual who is making the procedure statement. */
  public val asserter: Reference? = null,
  /** Limited to "real" people rather than equipment. */
  public val performer: List<Performer> = listOf(),
  /**
   * The location where the procedure actually happened. E.g. a newborn at home, a tracheostomy at a
   * restaurant.
   */
  public val location: Reference? = null,
  /**
   * The coded reason why the procedure was performed. This may be a coded entity of some type, or
   * may simply be present as text.
   *
   * Use Procedure.reasonCode when a code sufficiently describes the reason. Use
   * Procedure.reasonReference when referencing a resource, which allows more information to be
   * conveyed, such as onset date. Procedure.reasonCode and Procedure.reasonReference are not meant
   * to be duplicative. For a single reason, either Procedure.reasonCode or
   * Procedure.reasonReference can be used. Procedure.reasonCode may be a summary code, or
   * Procedure.reasonReference may be used to reference a very precise definition of the reason
   * using Condition | Observation | Procedure | DiagnosticReport | DocumentReference. Both
   * Procedure.reasonCode and Procedure.reasonReference can be used if they are describing different
   * reasons for the procedure.
   */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /**
   * The justification of why the procedure was performed.
   *
   * It is possible for a procedure to be a reason (such as C-Section) for another procedure (such
   * as an epidural). Other examples include endoscopy for dilatation and biopsy (a combination of
   * diagnostic and therapeutic use). Use Procedure.reasonCode when a code sufficiently describes
   * the reason. Use Procedure.reasonReference when referencing a resource, which allows more
   * information to be conveyed, such as onset date. Procedure.reasonCode and
   * Procedure.reasonReference are not meant to be duplicative. For a single reason, either
   * Procedure.reasonCode or Procedure.reasonReference can be used. Procedure.reasonCode may be a
   * summary code, or Procedure.reasonReference may be used to reference a very precise definition
   * of the reason using Condition | Observation | Procedure | DiagnosticReport | DocumentReference.
   * Both Procedure.reasonCode and Procedure.reasonReference can be used if they are describing
   * different reasons for the procedure.
   */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * Detailed and structured anatomical location information. Multiple locations are allowed - e.g.
   * multiple punch biopsies of a lesion.
   *
   * If the use case requires attributes from the BodySite resource (e.g. to identify and track
   * separately) then use the standard extension
   * [procedure-targetbodystructure](extension-procedure-targetbodystructure.html).
   */
  public val bodySite: List<CodeableConcept> = listOf(),
  /**
   * The outcome of the procedure - did it resolve the reasons for the procedure being performed?
   *
   * If outcome contains narrative text only, it can be captured using the CodeableConcept.text.
   */
  public val outcome: CodeableConcept? = null,
  /**
   * This could be a histology result, pathology report, surgical report, etc.
   *
   * There could potentially be multiple reports - e.g. if this was a procedure which took multiple
   * biopsies resulting in a number of anatomical pathology reports.
   */
  public val report: List<Reference> = listOf(),
  /**
   * Any complications that occurred during the procedure, or in the immediate post-performance
   * period. These are generally tracked separately from the notes, which will typically describe
   * the procedure itself rather than any 'post procedure' issues.
   *
   * If complications are only expressed by the narrative text, they can be captured using the
   * CodeableConcept.text.
   */
  public val complication: List<CodeableConcept> = listOf(),
  /**
   * Any complications that occurred during the procedure, or in the immediate post-performance
   * period.
   */
  public val complicationDetail: List<Reference> = listOf(),
  /**
   * If the procedure required specific follow up - e.g. removal of sutures. The follow up may be
   * represented as a simple note or could potentially be more complex, in which case the CarePlan
   * resource can be used.
   */
  public val followUp: List<CodeableConcept> = listOf(),
  /** Any other notes and comments about the procedure. */
  public val note: List<Annotation> = listOf(),
  /**
   * A device that is implanted, removed or otherwise manipulated (calibration, battery replacement,
   * fitting a prosthesis, attaching a wound-vac, etc.) as a focal portion of the Procedure.
   */
  public val focalDevice: List<FocalDevice> = listOf(),
  /**
   * Identifies medications, devices and any other substance used as part of the procedure.
   *
   * For devices actually implanted or removed, use Procedure.device.
   */
  public val usedReference: List<Reference> = listOf(),
  /**
   * Identifies coded items that were used as part of the procedure.
   *
   * For devices actually implanted or removed, use Procedure.device.
   */
  public val usedCode: List<CodeableConcept> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, subject.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        instantiatesCanonical =
          this@with.instantiatesCanonical.map { it.toBuilder() }.toMutableList()
        instantiatesUri = this@with.instantiatesUri.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
        statusReason = this@with.statusReason?.toBuilder()
        category = this@with.category?.toBuilder()
        code = this@with.code?.toBuilder()
        encounter = this@with.encounter?.toBuilder()
        performed = this@with.performed
        recorder = this@with.recorder?.toBuilder()
        asserter = this@with.asserter?.toBuilder()
        performer = this@with.performer.map { it.toBuilder() }.toMutableList()
        location = this@with.location?.toBuilder()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        bodySite = this@with.bodySite.map { it.toBuilder() }.toMutableList()
        outcome = this@with.outcome?.toBuilder()
        report = this@with.report.map { it.toBuilder() }.toMutableList()
        complication = this@with.complication.map { it.toBuilder() }.toMutableList()
        complicationDetail = this@with.complicationDetail.map { it.toBuilder() }.toMutableList()
        followUp = this@with.followUp.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        focalDevice = this@with.focalDevice.map { it.toBuilder() }.toMutableList()
        usedReference = this@with.usedReference.map { it.toBuilder() }.toMutableList()
        usedCode = this@with.usedCode.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Limited to "real" people rather than equipment. */
  @Serializable(with = ProcedurePerformerSerializer::class)
  public data class Performer(
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
     * Distinguishes the type of involvement of the performer in the procedure. For example,
     * surgeon, anaesthetist, endoscopist.
     */
    public val function: CodeableConcept? = null,
    /** The practitioner who was involved in the procedure. */
    public val actor: Reference,
    /** The organization the device or practitioner was acting on behalf of. */
    public val onBehalfOf: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(actor.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          function = this@with.function?.toBuilder()
          onBehalfOf = this@with.onBehalfOf?.toBuilder()
        }
      }

    public class Builder(
      /** The practitioner who was involved in the procedure. */
      public var actor: Reference.Builder
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
       * Distinguishes the type of involvement of the performer in the procedure. For example,
       * surgeon, anaesthetist, endoscopist.
       */
      public var function: CodeableConcept.Builder? = null

      /** The organization the device or practitioner was acting on behalf of. */
      public var onBehalfOf: Reference.Builder? = null

      public fun build(): Performer =
        Performer(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          function = function?.build(),
          actor = actor.build(),
          onBehalfOf = onBehalfOf?.build(),
        )
    }
  }

  /**
   * A device that is implanted, removed or otherwise manipulated (calibration, battery replacement,
   * fitting a prosthesis, attaching a wound-vac, etc.) as a focal portion of the Procedure.
   */
  @Serializable(with = ProcedureFocalDeviceSerializer::class)
  public data class FocalDevice(
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
    /** The kind of change that happened to the device during the procedure. */
    public val action: CodeableConcept? = null,
    /** The device that was manipulated (changed) during the procedure. */
    public val manipulated: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(manipulated.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          action = this@with.action?.toBuilder()
        }
      }

    public class Builder(
      /** The device that was manipulated (changed) during the procedure. */
      public var manipulated: Reference.Builder
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

      /** The kind of change that happened to the device during the procedure. */
      public var action: CodeableConcept.Builder? = null

      public fun build(): FocalDevice =
        FocalDevice(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          action = action?.build(),
          manipulated = manipulated.build(),
        )
    }
  }

  public sealed interface Performed {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public fun asString(): String? = this as? String

    public fun asAge(): Age? = this as? Age

    public fun asRange(): Range? = this as? Range

    @JvmInline
    public value class DateTime(public val `value`: dev.ohs.fhir.model.r4b.DateTime) : Performed

    @JvmInline
    public value class Period(public val `value`: dev.ohs.fhir.model.r4b.Period) : Performed

    @JvmInline
    public value class String(public val `value`: dev.ohs.fhir.model.r4b.String) : Performed

    @JvmInline public value class Age(public val `value`: dev.ohs.fhir.model.r4b.Age) : Performed

    @JvmInline
    public value class Range(public val `value`: dev.ohs.fhir.model.r4b.Range) : Performed

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r4b.DateTime?,
        periodValue: dev.ohs.fhir.model.r4b.Period?,
        stringValue: dev.ohs.fhir.model.r4b.String?,
        ageValue: dev.ohs.fhir.model.r4b.Age?,
        rangeValue: dev.ohs.fhir.model.r4b.Range?,
      ): Performed? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        if (stringValue != null) return String(stringValue)
        if (ageValue != null) return Age(ageValue)
        if (rangeValue != null) return Range(rangeValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * A code specifying the state of the procedure. Generally, this will be the in-progress or
     * completed state.
     *
     * The "unknown" code is not to be used to convey other statuses. The "unknown" code should be
     * used when one of the statuses applies, but the authoring system doesn't know the current
     * state of the procedure.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<EventStatus>,
    /** The person, animal or group on which the procedure was performed. */
    public var subject: Reference.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
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
     * Business identifiers assigned to this procedure by the performer or other systems which
     * remain constant as the resource is updated and is propagated from server to server.
     *
     * This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and Person resource instances might
     * share the same social insurance number.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is
     * adhered to in whole or in part by this Procedure.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally maintained protocol, guideline, order set or other
     * definition that is adhered to in whole or in part by this Procedure.
     *
     * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /** A reference to a resource that contains details of the request for this procedure. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A larger event of which this particular procedure is a component or step.
     *
     * The MedicationAdministration resource has a partOf reference to Procedure, but this is not a
     * circular reference. For example, the anesthesia MedicationAdministration is part of the
     * surgical Procedure (MedicationAdministration.partOf = Procedure). For example, the procedure
     * to insert the IV port for an IV medication administration is part of the medication
     * administration (Procedure.partOf = MedicationAdministration).
     */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Captures the reason for the current state of the procedure.
     *
     * This is generally only used for "exception" statuses such as "not-done", "suspended" or
     * "aborted". The reason for performing the event at all is captured in reasonCode, not here.
     */
    public var statusReason: CodeableConcept.Builder? = null

    /**
     * A code that classifies the procedure for searching, sorting and display purposes (e.g.
     * "Surgical Procedure").
     */
    public var category: CodeableConcept.Builder? = null

    /**
     * The specific procedure that is performed. Use text if the exact nature of the procedure
     * cannot be coded (e.g. "Laparoscopic Appendectomy").
     */
    public var code: CodeableConcept.Builder? = null

    /**
     * The Encounter during which this Procedure was created or performed or to which the creation
     * of this record is tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter.
     */
    public var encounter: Reference.Builder? = null

    /**
     * Estimated or actual date, date-time, period, or age when the procedure was performed. Allows
     * a period to support complex procedures that span more than one date, and also allows for the
     * length of the procedure to be captured.
     *
     * Age is generally used when the patient reports an age at which the procedure was performed.
     * Range is generally used when the patient reports an age range when the procedure was
     * performed, such as sometime between 20-25 years old. dateTime supports a range of precision
     * due to some procedures being reported as past procedures that might not have millisecond
     * precision while other procedures performed and documented during the encounter might have
     * more precise UTC timestamps with timezone.
     */
    public var performed: Performed? = null

    /** Individual who recorded the record and takes responsibility for its content. */
    public var recorder: Reference.Builder? = null

    /** Individual who is making the procedure statement. */
    public var asserter: Reference.Builder? = null

    /** Limited to "real" people rather than equipment. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /**
     * The location where the procedure actually happened. E.g. a newborn at home, a tracheostomy at
     * a restaurant.
     */
    public var location: Reference.Builder? = null

    /**
     * The coded reason why the procedure was performed. This may be a coded entity of some type, or
     * may simply be present as text.
     *
     * Use Procedure.reasonCode when a code sufficiently describes the reason. Use
     * Procedure.reasonReference when referencing a resource, which allows more information to be
     * conveyed, such as onset date. Procedure.reasonCode and Procedure.reasonReference are not
     * meant to be duplicative. For a single reason, either Procedure.reasonCode or
     * Procedure.reasonReference can be used. Procedure.reasonCode may be a summary code, or
     * Procedure.reasonReference may be used to reference a very precise definition of the reason
     * using Condition | Observation | Procedure | DiagnosticReport | DocumentReference. Both
     * Procedure.reasonCode and Procedure.reasonReference can be used if they are describing
     * different reasons for the procedure.
     */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The justification of why the procedure was performed.
     *
     * It is possible for a procedure to be a reason (such as C-Section) for another procedure (such
     * as an epidural). Other examples include endoscopy for dilatation and biopsy (a combination of
     * diagnostic and therapeutic use). Use Procedure.reasonCode when a code sufficiently describes
     * the reason. Use Procedure.reasonReference when referencing a resource, which allows more
     * information to be conveyed, such as onset date. Procedure.reasonCode and
     * Procedure.reasonReference are not meant to be duplicative. For a single reason, either
     * Procedure.reasonCode or Procedure.reasonReference can be used. Procedure.reasonCode may be a
     * summary code, or Procedure.reasonReference may be used to reference a very precise definition
     * of the reason using Condition | Observation | Procedure | DiagnosticReport |
     * DocumentReference. Both Procedure.reasonCode and Procedure.reasonReference can be used if
     * they are describing different reasons for the procedure.
     */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Detailed and structured anatomical location information. Multiple locations are allowed -
     * e.g. multiple punch biopsies of a lesion.
     *
     * If the use case requires attributes from the BodySite resource (e.g. to identify and track
     * separately) then use the standard extension
     * [procedure-targetbodystructure](extension-procedure-targetbodystructure.html).
     */
    public var bodySite: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The outcome of the procedure - did it resolve the reasons for the procedure being performed?
     *
     * If outcome contains narrative text only, it can be captured using the CodeableConcept.text.
     */
    public var outcome: CodeableConcept.Builder? = null

    /**
     * This could be a histology result, pathology report, surgical report, etc.
     *
     * There could potentially be multiple reports - e.g. if this was a procedure which took
     * multiple biopsies resulting in a number of anatomical pathology reports.
     */
    public var report: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Any complications that occurred during the procedure, or in the immediate post-performance
     * period. These are generally tracked separately from the notes, which will typically describe
     * the procedure itself rather than any 'post procedure' issues.
     *
     * If complications are only expressed by the narrative text, they can be captured using the
     * CodeableConcept.text.
     */
    public var complication: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Any complications that occurred during the procedure, or in the immediate post-performance
     * period.
     */
    public var complicationDetail: MutableList<Reference.Builder> = mutableListOf()

    /**
     * If the procedure required specific follow up - e.g. removal of sutures. The follow up may be
     * represented as a simple note or could potentially be more complex, in which case the CarePlan
     * resource can be used.
     */
    public var followUp: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Any other notes and comments about the procedure. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * A device that is implanted, removed or otherwise manipulated (calibration, battery
     * replacement, fitting a prosthesis, attaching a wound-vac, etc.) as a focal portion of the
     * Procedure.
     */
    public var focalDevice: MutableList<FocalDevice.Builder> = mutableListOf()

    /**
     * Identifies medications, devices and any other substance used as part of the procedure.
     *
     * For devices actually implanted or removed, use Procedure.device.
     */
    public var usedReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Identifies coded items that were used as part of the procedure.
     *
     * For devices actually implanted or removed, use Procedure.device.
     */
    public var usedCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    override fun build(): Procedure =
      Procedure(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        instantiatesCanonical = instantiatesCanonical.map { it.build() },
        instantiatesUri = instantiatesUri.map { it.build() },
        basedOn = basedOn.map { it.build() },
        partOf = partOf.map { it.build() },
        status = status,
        statusReason = statusReason?.build(),
        category = category?.build(),
        code = code?.build(),
        subject = subject.build(),
        encounter = encounter?.build(),
        performed = performed,
        recorder = recorder?.build(),
        asserter = asserter?.build(),
        performer = performer.map { it.build() },
        location = location?.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        bodySite = bodySite.map { it.build() },
        outcome = outcome?.build(),
        report = report.map { it.build() },
        complication = complication.map { it.build() },
        complicationDetail = complicationDetail.map { it.build() },
        followUp = followUp.map { it.build() },
        note = note.map { it.build() },
        focalDevice = focalDevice.map { it.build() },
        usedReference = usedReference.map { it.build() },
        usedCode = usedCode.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of an event. */
  public enum class EventStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Preparation("preparation", "http://hl7.org/fhir/event-status", "Preparation"),
    In_Progress("in-progress", "http://hl7.org/fhir/event-status", "In Progress"),
    Not_Done("not-done", "http://hl7.org/fhir/event-status", "Not Done"),
    On_Hold("on-hold", "http://hl7.org/fhir/event-status", "On Hold"),
    Stopped("stopped", "http://hl7.org/fhir/event-status", "Stopped"),
    Completed("completed", "http://hl7.org/fhir/event-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/event-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/event-status", "Unknown");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): EventStatus =
        when (code) {
          "preparation" -> Preparation
          "in-progress" -> In_Progress
          "not-done" -> Not_Done
          "on-hold" -> On_Hold
          "stopped" -> Stopped
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum EventStatus")
        }
    }
  }
}

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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.DeviceUseStatementSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A record of a device being used by a patient where the record is the result of a report from the
 * patient or another clinician.
 */
@Serializable(with = DeviceUseStatementSerializer::class)
@SerialName("DeviceUseStatement")
public data class DeviceUseStatement(
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
  /** An external identifier for this statement such as an IRI. */
  public val identifier: List<Identifier> = listOf(),
  /** A plan, proposal or order that is fulfilled in whole or in part by this DeviceUseStatement. */
  public val basedOn: List<Reference> = listOf(),
  /**
   * A code representing the patient or other source's judgment about the state of the device used
   * that this statement is about. Generally this will be active or completed.
   *
   * DeviceUseStatment is a statement at a point in time. The status is only representative at the
   * point when it was asserted. The value set for contains codes that assert the status of the use
   * by the patient (for example, stopped or on hold) as well as codes that assert the status of the
   * resource itself (for example, entered in error).
   *
   * This element is labeled as a modifier because the status contains the codes that mark the
   * statement as not currently valid.
   */
  public val status: Enumeration<DeviceUseStatementStatus>,
  /** The patient who used the device. */
  public val subject: Reference,
  /**
   * Allows linking the DeviceUseStatement to the underlying Request, or to other information that
   * supports or is used to derive the DeviceUseStatement.
   *
   * The most common use cases for deriving a DeviceUseStatement comes from creating it from a
   * request or from an observation or a claim. it should be noted that the amount of information
   * that is available varies from the type resource that you derive the DeviceUseStatement from.
   */
  public val derivedFrom: List<Reference> = listOf(),
  /** How often the device was used. */
  public val timing: Timing? = null,
  /** The time at which the statement was made/recorded. */
  public val recordedOn: DateTime? = null,
  /** Who reported the device was being used by the patient. */
  public val source: Reference? = null,
  /** The details of the device used. */
  public val device: Reference,
  /** Reason or justification for the use of the device. */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /** Indicates another resource whose existence justifies this DeviceUseStatement. */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * Indicates the anotomic location on the subject's body where the device was used ( i.e. the
   * target).
   */
  public val bodySite: CodeableConcept? = null,
  /**
   * Details about the device statement that were not represented at all or sufficiently in one of
   * the attributes provided in a class. These may include for example a comment, an instruction, or
   * a note associated with the statement.
   */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, subject.toBuilder(), device.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        derivedFrom = this@with.derivedFrom.map { it.toBuilder() }.toMutableList()
        timing = this@with.timing
        recordedOn = this@with.recordedOn?.toBuilder()
        source = this@with.source?.toBuilder()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        bodySite = this@with.bodySite?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  public sealed interface Timing {
    public fun asTiming(): Timing? = this as? Timing

    public fun asPeriod(): Period? = this as? Period

    public fun asDateTime(): DateTime? = this as? DateTime

    @JvmInline
    public value class Timing(public val `value`: dev.ohs.fhir.model.r4.Timing) :
      DeviceUseStatement.Timing

    @JvmInline
    public value class Period(public val `value`: dev.ohs.fhir.model.r4.Period) :
      DeviceUseStatement.Timing

    @JvmInline
    public value class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) :
      DeviceUseStatement.Timing

    public companion object {
      internal fun from(
        timingValue: dev.ohs.fhir.model.r4.Timing?,
        periodValue: dev.ohs.fhir.model.r4.Period?,
        dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
      ): DeviceUseStatement.Timing? {
        if (timingValue != null) return Timing(timingValue)
        if (periodValue != null) return Period(periodValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * A code representing the patient or other source's judgment about the state of the device used
     * that this statement is about. Generally this will be active or completed.
     *
     * DeviceUseStatment is a statement at a point in time. The status is only representative at the
     * point when it was asserted. The value set for contains codes that assert the status of the
     * use by the patient (for example, stopped or on hold) as well as codes that assert the status
     * of the resource itself (for example, entered in error).
     *
     * This element is labeled as a modifier because the status contains the codes that mark the
     * statement as not currently valid.
     */
    public var status: Enumeration<DeviceUseStatementStatus>,
    /** The patient who used the device. */
    public var subject: Reference.Builder,
    /** The details of the device used. */
    public var device: Reference.Builder,
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

    /** An external identifier for this statement such as an IRI. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this DeviceUseStatement.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Allows linking the DeviceUseStatement to the underlying Request, or to other information that
     * supports or is used to derive the DeviceUseStatement.
     *
     * The most common use cases for deriving a DeviceUseStatement comes from creating it from a
     * request or from an observation or a claim. it should be noted that the amount of information
     * that is available varies from the type resource that you derive the DeviceUseStatement from.
     */
    public var derivedFrom: MutableList<Reference.Builder> = mutableListOf()

    /** How often the device was used. */
    public var timing: Timing? = null

    /** The time at which the statement was made/recorded. */
    public var recordedOn: DateTime.Builder? = null

    /** Who reported the device was being used by the patient. */
    public var source: Reference.Builder? = null

    /** Reason or justification for the use of the device. */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicates another resource whose existence justifies this DeviceUseStatement. */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Indicates the anotomic location on the subject's body where the device was used ( i.e. the
     * target).
     */
    public var bodySite: CodeableConcept.Builder? = null

    /**
     * Details about the device statement that were not represented at all or sufficiently in one of
     * the attributes provided in a class. These may include for example a comment, an instruction,
     * or a note associated with the statement.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): DeviceUseStatement =
      DeviceUseStatement(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        basedOn = basedOn.map { it.build() },
        status = status,
        subject = subject.build(),
        derivedFrom = derivedFrom.map { it.build() },
        timing = timing,
        recordedOn = recordedOn?.build(),
        source = source?.build(),
        device = device.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        bodySite = bodySite?.build(),
        note = note.map { it.build() },
      )
  }

  /** A coded concept indicating the current status of the Device Usage. */
  public enum class DeviceUseStatementStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Active("active", "http://hl7.org/fhir/device-statement-status", "Active"),
    Completed("completed", "http://hl7.org/fhir/device-statement-status", "Completed"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/device-statement-status",
      "Entered in Error",
    ),
    Intended("intended", "http://hl7.org/fhir/device-statement-status", "Intended"),
    Stopped("stopped", "http://hl7.org/fhir/device-statement-status", "Stopped"),
    On_Hold("on-hold", "http://hl7.org/fhir/device-statement-status", "On Hold");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): DeviceUseStatementStatus =
        when (code) {
          "active" -> Active
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "intended" -> Intended
          "stopped" -> Stopped
          "on-hold" -> On_Hold
          else ->
            throw IllegalArgumentException("Unknown code $code for enum DeviceUseStatementStatus")
        }
    }
  }
}

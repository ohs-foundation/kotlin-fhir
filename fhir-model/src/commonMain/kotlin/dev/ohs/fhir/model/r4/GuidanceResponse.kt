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

import dev.ohs.fhir.model.r4.serializers.GuidanceResponseSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A guidance response is the formal response to a guidance request, including any output parameters
 * returned by the evaluation, as well as the description of any proposed actions to be taken.
 */
@Serializable(with = GuidanceResponseSerializer::class)
@SerialName("GuidanceResponse")
public data class GuidanceResponse(
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
   * The identifier of the request associated with this response. If an identifier was given as part
   * of the request, it will be reproduced here to enable the requester to more easily identify the
   * response in a multi-request scenario.
   */
  public val requestIdentifier: Identifier? = null,
  /** Allows a service to provide unique, business identifiers for the response. */
  public val identifier: List<Identifier> = listOf(),
  /** An identifier, CodeableConcept or canonical reference to the guidance that was requested. */
  public val module: Module,
  /**
   * The status of the response. If the evaluation is completed successfully, the status will
   * indicate success. However, in order to complete the evaluation, the engine may require more
   * information. In this case, the status will be data-required, and the response will contain a
   * description of the additional required information. If the evaluation completed successfully,
   * but the engine determines that a potentially more accurate response could be provided if more
   * data was available, the status will be data-requested, and the response will contain a
   * description of the additional requested information.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<GuidanceResponseStatus>,
  /** The patient for which the request was processed. */
  public val subject: Reference? = null,
  /**
   * The encounter during which this response was created or to which the creation of this record is
   * tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official copmletion of an encounter but still be tied to the
   * context of the encounter.
   */
  public val encounter: Reference? = null,
  /** Indicates when the guidance response was processed. */
  public val occurrenceDateTime: DateTime? = null,
  /** Provides a reference to the device that performed the guidance. */
  public val performer: Reference? = null,
  /** Describes the reason for the guidance response in coded or textual form. */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /**
   * Indicates the reason the request was initiated. This is typically provided as a parameter to
   * the evaluation and echoed by the service, although for some use cases, such as subscription- or
   * event-based scenarios, it may provide an indication of the cause for the response.
   */
  public val reasonReference: List<Reference> = listOf(),
  /** Provides a mechanism to communicate additional information about the response. */
  public val note: List<Annotation> = listOf(),
  /**
   * Messages resulting from the evaluation of the artifact or artifacts. As part of evaluating the
   * request, the engine may produce informational or warning messages. These messages will be
   * provided by this element.
   */
  public val evaluationMessage: List<Reference> = listOf(),
  /**
   * The output parameters of the evaluation, if any. Many modules will result in the return of
   * specific resources such as procedure or communication requests that are returned as part of the
   * operation result. However, modules may define specific outputs that would be returned as the
   * result of the evaluation, and these would be returned in this element.
   */
  public val outputParameters: Reference? = null,
  /** The actions, if any, produced by the evaluation of the artifact. */
  public val result: Reference? = null,
  /**
   * If the evaluation could not be completed due to lack of information, or additional information
   * would potentially result in a more accurate response, this element will a description of the
   * data required in order to proceed with the evaluation. A subsequent request to the service
   * should include this data.
   */
  public val dataRequirement: List<DataRequirement> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(module, status).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        requestIdentifier = this@with.requestIdentifier?.toBuilder()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject?.toBuilder()
        encounter = this@with.encounter?.toBuilder()
        occurrenceDateTime = this@with.occurrenceDateTime?.toBuilder()
        performer = this@with.performer?.toBuilder()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        evaluationMessage = this@with.evaluationMessage.map { it.toBuilder() }.toMutableList()
        outputParameters = this@with.outputParameters?.toBuilder()
        result = this@with.result?.toBuilder()
        dataRequirement = this@with.dataRequirement.map { it.toBuilder() }.toMutableList()
      }
    }

  public sealed interface Module {
    public fun asUri(): Uri? = this as? Uri

    public fun asCanonical(): Canonical? = this as? Canonical

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    @JvmInline public value class Uri(public val `value`: dev.ohs.fhir.model.r4.Uri) : Module

    @JvmInline
    public value class Canonical(public val `value`: dev.ohs.fhir.model.r4.Canonical) : Module

    @JvmInline
    public value class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
      Module

    public companion object {
      internal fun from(
        uriValue: dev.ohs.fhir.model.r4.Uri?,
        canonicalValue: dev.ohs.fhir.model.r4.Canonical?,
        codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
      ): Module? {
        if (uriValue != null) return Uri(uriValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        return null
      }
    }
  }

  public class Builder(
    /** An identifier, CodeableConcept or canonical reference to the guidance that was requested. */
    public var module: Module,
    /**
     * The status of the response. If the evaluation is completed successfully, the status will
     * indicate success. However, in order to complete the evaluation, the engine may require more
     * information. In this case, the status will be data-required, and the response will contain a
     * description of the additional required information. If the evaluation completed successfully,
     * but the engine determines that a potentially more accurate response could be provided if more
     * data was available, the status will be data-requested, and the response will contain a
     * description of the additional requested information.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<GuidanceResponseStatus>,
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
     * The identifier of the request associated with this response. If an identifier was given as
     * part of the request, it will be reproduced here to enable the requester to more easily
     * identify the response in a multi-request scenario.
     */
    public var requestIdentifier: Identifier.Builder? = null

    /** Allows a service to provide unique, business identifiers for the response. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** The patient for which the request was processed. */
    public var subject: Reference.Builder? = null

    /**
     * The encounter during which this response was created or to which the creation of this record
     * is tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official copmletion of an encounter but still be tied to the
     * context of the encounter.
     */
    public var encounter: Reference.Builder? = null

    /** Indicates when the guidance response was processed. */
    public var occurrenceDateTime: DateTime.Builder? = null

    /** Provides a reference to the device that performed the guidance. */
    public var performer: Reference.Builder? = null

    /** Describes the reason for the guidance response in coded or textual form. */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Indicates the reason the request was initiated. This is typically provided as a parameter to
     * the evaluation and echoed by the service, although for some use cases, such as subscription-
     * or event-based scenarios, it may provide an indication of the cause for the response.
     */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /** Provides a mechanism to communicate additional information about the response. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Messages resulting from the evaluation of the artifact or artifacts. As part of evaluating
     * the request, the engine may produce informational or warning messages. These messages will be
     * provided by this element.
     */
    public var evaluationMessage: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The output parameters of the evaluation, if any. Many modules will result in the return of
     * specific resources such as procedure or communication requests that are returned as part of
     * the operation result. However, modules may define specific outputs that would be returned as
     * the result of the evaluation, and these would be returned in this element.
     */
    public var outputParameters: Reference.Builder? = null

    /** The actions, if any, produced by the evaluation of the artifact. */
    public var result: Reference.Builder? = null

    /**
     * If the evaluation could not be completed due to lack of information, or additional
     * information would potentially result in a more accurate response, this element will a
     * description of the data required in order to proceed with the evaluation. A subsequent
     * request to the service should include this data.
     */
    public var dataRequirement: MutableList<DataRequirement.Builder> = mutableListOf()

    override fun build(): GuidanceResponse =
      GuidanceResponse(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        requestIdentifier = requestIdentifier?.build(),
        identifier = identifier.map { it.build() },
        module = module,
        status = status,
        subject = subject?.build(),
        encounter = encounter?.build(),
        occurrenceDateTime = occurrenceDateTime?.build(),
        performer = performer?.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        note = note.map { it.build() },
        evaluationMessage = evaluationMessage.map { it.build() },
        outputParameters = outputParameters?.build(),
        result = result?.build(),
        dataRequirement = dataRequirement.map { it.build() },
      )
  }

  /** The status of a guidance response. */
  public enum class GuidanceResponseStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Success("success", "http://hl7.org/fhir/guidance-response-status", "Success"),
    Data_Requested(
      "data-requested",
      "http://hl7.org/fhir/guidance-response-status",
      "Data Requested",
    ),
    Data_Required("data-required", "http://hl7.org/fhir/guidance-response-status", "Data Required"),
    In_Progress("in-progress", "http://hl7.org/fhir/guidance-response-status", "In Progress"),
    Failure("failure", "http://hl7.org/fhir/guidance-response-status", "Failure"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/guidance-response-status",
      "Entered In Error",
    );

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): GuidanceResponseStatus =
        when (code) {
          "success" -> Success
          "data-requested" -> Data_Requested
          "data-required" -> Data_Required
          "in-progress" -> In_Progress
          "failure" -> Failure
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException("Unknown code $code for enum GuidanceResponseStatus")
        }
    }
  }
}

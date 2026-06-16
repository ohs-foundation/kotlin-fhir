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

import dev.ohs.fhir.model.r4.serializers.DeviceRequestParameterSerializer
import dev.ohs.fhir.model.r4.serializers.DeviceRequestSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a request for a patient to employ a medical device. The device may be an implantable
 * device, or an external assistive device, such as a walker.
 */
@Serializable(with = DeviceRequestSerializer::class)
@SerialName("DeviceRequest")
public data class DeviceRequest(
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
  override val language: dev.ohs.fhir.model.r4.Code? = null,
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
  /** Identifiers assigned to this order by the orderer or by the receiver. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
   * adhered to in whole or in part by this DeviceRequest.
   *
   * Note: This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and a Person resource instance might share the
   * same social insurance number.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally maintained protocol, guideline, orderset or other definition
   * that is adhered to in whole or in part by this DeviceRequest.
   *
   * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /** Plan/proposal/order fulfilled by this request. */
  public val basedOn: List<Reference> = listOf(),
  /** The request takes the place of the referenced completed or terminated request(s). */
  public val priorRequest: List<Reference> = listOf(),
  /** Composite request this is part of. */
  public val groupIdentifier: Identifier? = null,
  /**
   * The status of the request.
   *
   * This element is labeled as a modifier because the status contains the codes cancelled and
   * entered-in-error that mark the request as not currently valid.
   */
  public val status: Enumeration<RequestStatus>? = null,
  /** Whether the request is a proposal, plan, an original order or a reflex order. */
  public val intent: Enumeration<RequestIntent>,
  /** Indicates how quickly the {{title}} should be addressed with respect to other requests. */
  public val priority: Enumeration<RequestPriority>? = null,
  /** The details of the device to be used. */
  public val code: Code,
  /** Specific parameters for the ordered item. For example, the prism value for lenses. */
  public val parameter: List<Parameter> = listOf(),
  /** The patient who will use the device. */
  public val subject: Reference,
  /** An encounter that provides additional context in which this request is made. */
  public val encounter: Reference? = null,
  /**
   * The timing schedule for the use of the device. The Schedule data type allows many different
   * expressions, for example. "Every 8 hours"; "Three times a day"; "1/2 an hour before breakfast
   * for 10 days from 23-Dec 2011:"; "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".
   */
  public val occurrence: Occurrence? = null,
  /** When the request transitioned to being actionable. */
  public val authoredOn: DateTime? = null,
  /** The individual who initiated the request and has responsibility for its activation. */
  public val requester: Reference? = null,
  /** Desired type of performer for doing the diagnostic testing. */
  public val performerType: CodeableConcept? = null,
  /** The desired performer for doing the diagnostic testing. */
  public val performer: Reference? = null,
  /** Reason or justification for the use of this device. */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /** Reason or justification for the use of this device. */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be
   * required for delivering the requested service.
   */
  public val insurance: List<Reference> = listOf(),
  /**
   * Additional clinical information about the patient that may influence the request fulfilment.
   * For example, this may include where on the subject's body the device will be used (i.e. the
   * target site).
   */
  public val supportingInfo: List<Reference> = listOf(),
  /**
   * Details about this request that were not represented at all or sufficiently in one of the
   * attributes provided in a class. These may include for example a comment, an instruction, or a
   * note associated with the statement.
   */
  public val note: List<Annotation> = listOf(),
  /**
   * Key events in the history of the request.
   *
   * This might not include provenances for all versions of the request - only those deemed
   * "relevant" or important. This SHALL NOT include the Provenance associated with this current
   * version of the resource. (If that provenance is deemed to be a "relevant" change, it will need
   * to be added as part of a later update. Until then, it can be queried directly as the Provenance
   * that points to this version using _revinclude All Provenances should have some historical
   * version of this Request as their subject.
   */
  public val relevantHistory: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(intent, code, subject.toBuilder()).apply {
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
        priorRequest = this@with.priorRequest.map { it.toBuilder() }.toMutableList()
        groupIdentifier = this@with.groupIdentifier?.toBuilder()
        status = this@with.status
        priority = this@with.priority
        parameter = this@with.parameter.map { it.toBuilder() }.toMutableList()
        encounter = this@with.encounter?.toBuilder()
        occurrence = this@with.occurrence
        authoredOn = this@with.authoredOn?.toBuilder()
        requester = this@with.requester?.toBuilder()
        performerType = this@with.performerType?.toBuilder()
        performer = this@with.performer?.toBuilder()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        insurance = this@with.insurance.map { it.toBuilder() }.toMutableList()
        supportingInfo = this@with.supportingInfo.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        relevantHistory = this@with.relevantHistory.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Specific parameters for the ordered item. For example, the prism value for lenses. */
  @Serializable(with = DeviceRequestParameterSerializer::class)
  public data class Parameter(
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
    /** A code or string that identifies the device detail being asserted. */
    public val code: CodeableConcept? = null,
    /**
     * The value of the device detail.
     *
     * Range means device should have a value that falls somewhere within the specified range.
     */
    public val `value`: Value? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          code = this@with.code?.toBuilder()
          `value` = this@with.`value`
        }
      }

    public sealed interface Value {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asBoolean(): Boolean? = this as? Boolean

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
        Value

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r4.Quantity) : Value

      public data class Range(public val `value`: dev.ohs.fhir.model.r4.Range) : Value

      public data class Boolean(public val `value`: dev.ohs.fhir.model.r4.Boolean) : Value

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
          quantityValue: dev.ohs.fhir.model.r4.Quantity?,
          rangeValue: dev.ohs.fhir.model.r4.Range?,
          booleanValue: dev.ohs.fhir.model.r4.Boolean?,
        ): Value? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (booleanValue != null) return Boolean(booleanValue)
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

      /** A code or string that identifies the device detail being asserted. */
      public var code: CodeableConcept.Builder? = null

      /**
       * The value of the device detail.
       *
       * Range means device should have a value that falls somewhere within the specified range.
       */
      public var `value`: Value? = null

      public fun build(): Parameter =
        Parameter(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code?.build(),
          `value` = `value`,
        )
    }
  }

  public sealed interface Code {
    public fun asReference(): Reference? = this as? Reference

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Code

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
      Code

    public companion object {
      internal fun from(
        referenceValue: dev.ohs.fhir.model.r4.Reference?,
        codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
      ): Code? {
        if (referenceValue != null) return Reference(referenceValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        return null
      }
    }
  }

  public sealed interface Occurrence {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public fun asTiming(): Timing? = this as? Timing

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) : Occurrence

    public data class Period(public val `value`: dev.ohs.fhir.model.r4.Period) : Occurrence

    public data class Timing(public val `value`: dev.ohs.fhir.model.r4.Timing) : Occurrence

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
        periodValue: dev.ohs.fhir.model.r4.Period?,
        timingValue: dev.ohs.fhir.model.r4.Timing?,
      ): Occurrence? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        if (timingValue != null) return Timing(timingValue)
        return null
      }
    }
  }

  public class Builder(
    /** Whether the request is a proposal, plan, an original order or a reflex order. */
    public var intent: Enumeration<RequestIntent>,
    /** The details of the device to be used. */
    public var code: Code,
    /** The patient who will use the device. */
    public var subject: Reference.Builder,
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
    public var language: dev.ohs.fhir.model.r4.Code.Builder? = null

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

    /** Identifiers assigned to this order by the orderer or by the receiver. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
     * adhered to in whole or in part by this DeviceRequest.
     *
     * Note: This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and a Person resource instance might
     * share the same social insurance number.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other
     * definition that is adhered to in whole or in part by this DeviceRequest.
     *
     * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /** Plan/proposal/order fulfilled by this request. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /** The request takes the place of the referenced completed or terminated request(s). */
    public var priorRequest: MutableList<Reference.Builder> = mutableListOf()

    /** Composite request this is part of. */
    public var groupIdentifier: Identifier.Builder? = null

    /**
     * The status of the request.
     *
     * This element is labeled as a modifier because the status contains the codes cancelled and
     * entered-in-error that mark the request as not currently valid.
     */
    public var status: Enumeration<RequestStatus>? = null

    /** Indicates how quickly the {{title}} should be addressed with respect to other requests. */
    public var priority: Enumeration<RequestPriority>? = null

    /** Specific parameters for the ordered item. For example, the prism value for lenses. */
    public var parameter: MutableList<Parameter.Builder> = mutableListOf()

    /** An encounter that provides additional context in which this request is made. */
    public var encounter: Reference.Builder? = null

    /**
     * The timing schedule for the use of the device. The Schedule data type allows many different
     * expressions, for example. "Every 8 hours"; "Three times a day"; "1/2 an hour before breakfast
     * for 10 days from 23-Dec 2011:"; "15 Oct 2013, 17 Oct 2013 and 1 Nov 2013".
     */
    public var occurrence: Occurrence? = null

    /** When the request transitioned to being actionable. */
    public var authoredOn: DateTime.Builder? = null

    /** The individual who initiated the request and has responsibility for its activation. */
    public var requester: Reference.Builder? = null

    /** Desired type of performer for doing the diagnostic testing. */
    public var performerType: CodeableConcept.Builder? = null

    /** The desired performer for doing the diagnostic testing. */
    public var performer: Reference.Builder? = null

    /** Reason or justification for the use of this device. */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Reason or justification for the use of this device. */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may
     * be required for delivering the requested service.
     */
    public var insurance: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Additional clinical information about the patient that may influence the request fulfilment.
     * For example, this may include where on the subject's body the device will be used (i.e. the
     * target site).
     */
    public var supportingInfo: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Details about this request that were not represented at all or sufficiently in one of the
     * attributes provided in a class. These may include for example a comment, an instruction, or a
     * note associated with the statement.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Key events in the history of the request.
     *
     * This might not include provenances for all versions of the request - only those deemed
     * "relevant" or important. This SHALL NOT include the Provenance associated with this current
     * version of the resource. (If that provenance is deemed to be a "relevant" change, it will
     * need to be added as part of a later update. Until then, it can be queried directly as the
     * Provenance that points to this version using _revinclude All Provenances should have some
     * historical version of this Request as their subject.
     */
    public var relevantHistory: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): DeviceRequest =
      DeviceRequest(
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
        priorRequest = priorRequest.map { it.build() },
        groupIdentifier = groupIdentifier?.build(),
        status = status,
        intent = intent,
        priority = priority,
        code = code,
        parameter = parameter.map { it.build() },
        subject = subject.build(),
        encounter = encounter?.build(),
        occurrence = occurrence,
        authoredOn = authoredOn?.build(),
        requester = requester?.build(),
        performerType = performerType?.build(),
        performer = performer?.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        insurance = insurance.map { it.build() },
        supportingInfo = supportingInfo.map { it.build() },
        note = note.map { it.build() },
        relevantHistory = relevantHistory.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of a request. */
  public enum class RequestStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Draft("draft", "http://hl7.org/fhir/request-status", "Draft"),
    Active("active", "http://hl7.org/fhir/request-status", "Active"),
    On_Hold("on-hold", "http://hl7.org/fhir/request-status", "On Hold"),
    Revoked("revoked", "http://hl7.org/fhir/request-status", "Revoked"),
    Completed("completed", "http://hl7.org/fhir/request-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/request-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/request-status", "Unknown");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): RequestStatus =
        when (code) {
          "draft" -> Draft
          "active" -> Active
          "on-hold" -> On_Hold
          "revoked" -> Revoked
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestStatus")
        }
    }
  }

  /** Codes indicating the degree of authority/intentionality associated with a request. */
  public enum class RequestIntent(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Proposal("proposal", "http://hl7.org/fhir/request-intent", "Proposal"),
    Plan("plan", "http://hl7.org/fhir/request-intent", "Plan"),
    Directive("directive", "http://hl7.org/fhir/request-intent", "Directive"),
    Order("order", "http://hl7.org/fhir/request-intent", "Order"),
    Original_Order("original-order", "http://hl7.org/fhir/request-intent", "Original Order"),
    Reflex_Order("reflex-order", "http://hl7.org/fhir/request-intent", "Reflex Order"),
    Filler_Order("filler-order", "http://hl7.org/fhir/request-intent", "Filler Order"),
    Instance_Order("instance-order", "http://hl7.org/fhir/request-intent", "Instance Order"),
    Option("option", "http://hl7.org/fhir/request-intent", "Option");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): RequestIntent =
        when (code) {
          "proposal" -> Proposal
          "plan" -> Plan
          "directive" -> Directive
          "order" -> Order
          "original-order" -> Original_Order
          "reflex-order" -> Reflex_Order
          "filler-order" -> Filler_Order
          "instance-order" -> Instance_Order
          "option" -> Option
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestIntent")
        }
    }
  }

  /** The clinical priority of a diagnostic order. */
  public enum class RequestPriority(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Routine("routine", "http://hl7.org/fhir/request-priority", "Routine"),
    Urgent("urgent", "http://hl7.org/fhir/request-priority", "Urgent"),
    Asap("asap", "http://hl7.org/fhir/request-priority", "ASAP"),
    Stat("stat", "http://hl7.org/fhir/request-priority", "STAT");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): RequestPriority =
        when (code) {
          "routine" -> Routine
          "urgent" -> Urgent
          "asap" -> Asap
          "stat" -> Stat
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestPriority")
        }
    }
  }
}

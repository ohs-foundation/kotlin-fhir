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

import dev.ohs.fhir.model.r4.serializers.QuestionnaireResponseItemAnswerSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireResponseItemSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireResponseSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A structured set of questions and their answers. The questions are ordered and grouped into
 * coherent subsets, corresponding to the structure of the grouping of the questionnaire being
 * responded to.
 */
@Serializable(with = QuestionnaireResponseSerializer::class)
@SerialName("QuestionnaireResponse")
public data class QuestionnaireResponse(
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
   * A business identifier assigned to a particular completed (or partially completed)
   * questionnaire.
   */
  public val identifier: Identifier? = null,
  /**
   * The order, proposal or plan that is fulfilled in whole or in part by this
   * QuestionnaireResponse. For example, a ServiceRequest seeking an intake assessment or a decision
   * support recommendation to assess for post-partum depression.
   */
  public val basedOn: List<Reference> = listOf(),
  /**
   * A procedure or observation that this questionnaire was performed as part of the execution of.
   * For example, the surgery a checklist was executed as part of.
   *
   * Composition of questionnaire responses will be handled by the parent questionnaire having
   * answers that reference the child questionnaire. For relationships to referrals, and other types
   * of requests, use basedOn.
   */
  public val partOf: List<Reference> = listOf(),
  /**
   * The Questionnaire that defines and organizes the questions for which answers are being
   * provided.
   *
   * If a QuestionnaireResponse references a Questionnaire, then the QuestionnaireResponse structure
   * must be consistent with the Questionnaire (i.e. questions must be organized into the same
   * groups, nested questions must still be nested, etc.).
   */
  public val questionnaire: Canonical? = null,
  /**
   * The position of the questionnaire response within its overall lifecycle.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<QuestionnaireResponseStatus>,
  /**
   * The subject of the questionnaire response. This could be a patient, organization, practitioner,
   * device, etc. This is who/what the answers apply to, but is not necessarily the source of
   * information.
   *
   * If the Questionnaire declared a subjectType, the resource pointed to by this element must be an
   * instance of one of the listed types.
   */
  public val subject: Reference? = null,
  /**
   * The Encounter during which this questionnaire response was created or to which the creation of
   * this record is tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter. A questionnaire that was initiated during an encounter but not fully
   * completed during the encounter would still generally be associated with the encounter.
   */
  public val encounter: Reference? = null,
  /**
   * The date and/or time that this set of answers were last changed.
   *
   * May be different from the lastUpdateTime of the resource itself, because that reflects when the
   * data was known to the server, not when the data was captured.
   *
   * This element is optional to allow for systems that might not know the value, however it SHOULD
   * be populated if possible.
   */
  public val authored: DateTime? = null,
  /**
   * Person who received the answers to the questions in the QuestionnaireResponse and recorded them
   * in the system.
   *
   * Mapping a subject's answers to multiple choice options and determining what to put in the
   * textual answer is a matter of interpretation. Authoring by device would indicate that some
   * portion of the questionnaire had been auto-populated.
   */
  public val author: Reference? = null,
  /**
   * The person who answered the questions about the subject.
   *
   * If not specified, no inference can be made about who provided the data.
   */
  public val source: Reference? = null,
  /**
   * A group or question item from the original questionnaire for which answers are provided.
   *
   * Groups cannot have answers and therefore must nest directly within item. When dealing with
   * questions, nesting must occur within each answer because some questions may have multiple
   * answers (and the nesting occurs for each answer).
   */
  public val item: List<Item> = listOf(),
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
        identifier = this@with.identifier?.toBuilder()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
        questionnaire = this@with.questionnaire?.toBuilder()
        subject = this@with.subject?.toBuilder()
        encounter = this@with.encounter?.toBuilder()
        authored = this@with.authored?.toBuilder()
        author = this@with.author?.toBuilder()
        source = this@with.source?.toBuilder()
        item = this@with.item.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A group or question item from the original questionnaire for which answers are provided. */
  @Serializable(with = QuestionnaireResponseItemSerializer::class)
  public data class Item(
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
     * The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse
     * resource.
     */
    public val linkId: String,
    /**
     * A reference to an [ElementDefinition](elementdefinition.html) that provides the details for
     * the item.
     *
     * The ElementDefinition must be in a [StructureDefinition](structuredefinition.html#), and must
     * have a fragment identifier that identifies the specific data element by its id (Element.id).
     * E.g. http://hl7.org/fhir/StructureDefinition/Observation#Observation.value[x].
     *
     * There is no need for this element if the item pointed to by the linkId has a definition
     * listed.
     */
    public val definition: Uri? = null,
    /**
     * Text that is displayed above the contents of the group or as the text of the question being
     * answered.
     */
    public val text: String? = null,
    /**
     * The respondent's answer(s) to the question.
     *
     * The value is nested because we cannot have a repeating structure that has variable type.
     */
    public val answer: List<Answer> = listOf(),
    /** Questions or sub-groups nested beneath a question or group. */
    public val item: List<Item> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(linkId.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          definition = this@with.definition?.toBuilder()
          text = this@with.text?.toBuilder()
          answer = this@with.answer.map { it.toBuilder() }.toMutableList()
          item = this@with.item.map { it.toBuilder() }.toMutableList()
        }
      }

    /** The respondent's answer(s) to the question. */
    @Serializable(with = QuestionnaireResponseItemAnswerSerializer::class)
    public data class Answer(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /**
       * The answer (or one of the answers) provided by the respondent to the question.
       *
       * More complex structures (Attachment, Resource and Quantity) will typically be limited to
       * electronic forms that can expose an appropriate user interface to capture the components
       * and enforce the constraints of a complex data type. Additional complex types can be
       * introduced through extensions. Must match the datatype specified by Questionnaire.item.type
       * in the corresponding Questionnaire.
       */
      public val `value`: Value? = null,
      /** Nested groups and/or questions found within this particular answer. */
      public val item: List<Item> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            `value` = this@with.`value`
            item = this@with.item.map { it.toBuilder() }.toMutableList()
          }
        }

      public sealed interface Value {
        public fun asBoolean(): Boolean? = this as? Boolean

        public fun asDecimal(): Decimal? = this as? Decimal

        public fun asInteger(): Integer? = this as? Integer

        public fun asDate(): Date? = this as? Date

        public fun asDateTime(): DateTime? = this as? DateTime

        public fun asTime(): Time? = this as? Time

        public fun asString(): String? = this as? String

        public fun asUri(): Uri? = this as? Uri

        public fun asAttachment(): Attachment? = this as? Attachment

        public fun asCoding(): Coding? = this as? Coding

        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asReference(): Reference? = this as? Reference

        public data class Boolean(public val `value`: dev.ohs.fhir.model.r4.Boolean) : Value

        public data class Decimal(public val `value`: dev.ohs.fhir.model.r4.Decimal) : Value

        public data class Integer(public val `value`: dev.ohs.fhir.model.r4.Integer) : Value

        public data class Date(public val `value`: dev.ohs.fhir.model.r4.Date) : Value

        public data class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) : Value

        public data class Time(public val `value`: dev.ohs.fhir.model.r4.Time) : Value

        public data class String(public val `value`: dev.ohs.fhir.model.r4.String) : Value

        public data class Uri(public val `value`: dev.ohs.fhir.model.r4.Uri) : Value

        public data class Attachment(public val `value`: dev.ohs.fhir.model.r4.Attachment) : Value

        public data class Coding(public val `value`: dev.ohs.fhir.model.r4.Coding) : Value

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r4.Quantity) : Value

        public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Value

        public companion object {
          internal fun from(
            booleanValue: dev.ohs.fhir.model.r4.Boolean?,
            decimalValue: dev.ohs.fhir.model.r4.Decimal?,
            integerValue: dev.ohs.fhir.model.r4.Integer?,
            dateValue: dev.ohs.fhir.model.r4.Date?,
            dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
            timeValue: dev.ohs.fhir.model.r4.Time?,
            stringValue: dev.ohs.fhir.model.r4.String?,
            uriValue: dev.ohs.fhir.model.r4.Uri?,
            attachmentValue: dev.ohs.fhir.model.r4.Attachment?,
            codingValue: dev.ohs.fhir.model.r4.Coding?,
            quantityValue: dev.ohs.fhir.model.r4.Quantity?,
            referenceValue: dev.ohs.fhir.model.r4.Reference?,
          ): Value? {
            if (booleanValue != null) return Boolean(booleanValue)
            if (decimalValue != null) return Decimal(decimalValue)
            if (integerValue != null) return Integer(integerValue)
            if (dateValue != null) return Date(dateValue)
            if (dateTimeValue != null) return DateTime(dateTimeValue)
            if (timeValue != null) return Time(timeValue)
            if (stringValue != null) return String(stringValue)
            if (uriValue != null) return Uri(uriValue)
            if (attachmentValue != null) return Attachment(attachmentValue)
            if (codingValue != null) return Coding(codingValue)
            if (quantityValue != null) return Quantity(quantityValue)
            if (referenceValue != null) return Reference(referenceValue)
            return null
          }
        }
      }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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

        /**
         * The answer (or one of the answers) provided by the respondent to the question.
         *
         * More complex structures (Attachment, Resource and Quantity) will typically be limited to
         * electronic forms that can expose an appropriate user interface to capture the components
         * and enforce the constraints of a complex data type. Additional complex types can be
         * introduced through extensions. Must match the datatype specified by
         * Questionnaire.item.type in the corresponding Questionnaire.
         */
        public var `value`: Value? = null

        /** Nested groups and/or questions found within this particular answer. */
        public var item: MutableList<Item.Builder> = mutableListOf()

        public fun build(): Answer =
          Answer(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            `value` = `value`,
            item = item.map { it.build() },
          )
      }
    }

    public class Builder(
      /**
       * The item from the Questionnaire that corresponds to this item in the QuestionnaireResponse
       * resource.
       */
      public var linkId: String.Builder
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

      /**
       * A reference to an [ElementDefinition](elementdefinition.html) that provides the details for
       * the item.
       *
       * The ElementDefinition must be in a [StructureDefinition](structuredefinition.html#), and
       * must have a fragment identifier that identifies the specific data element by its id
       * (Element.id). E.g.
       * http://hl7.org/fhir/StructureDefinition/Observation#Observation.value[x].
       *
       * There is no need for this element if the item pointed to by the linkId has a definition
       * listed.
       */
      public var definition: Uri.Builder? = null

      /**
       * Text that is displayed above the contents of the group or as the text of the question being
       * answered.
       */
      public var text: String.Builder? = null

      /**
       * The respondent's answer(s) to the question.
       *
       * The value is nested because we cannot have a repeating structure that has variable type.
       */
      public var answer: MutableList<Answer.Builder> = mutableListOf()

      /** Questions or sub-groups nested beneath a question or group. */
      public var item: MutableList<Builder> = mutableListOf()

      public fun build(): Item =
        Item(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          linkId = linkId.build(),
          definition = definition?.build(),
          text = text?.build(),
          answer = answer.map { it.build() },
          item = item.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The position of the questionnaire response within its overall lifecycle.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<QuestionnaireResponseStatus>
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
     * A business identifier assigned to a particular completed (or partially completed)
     * questionnaire.
     */
    public var identifier: Identifier.Builder? = null

    /**
     * The order, proposal or plan that is fulfilled in whole or in part by this
     * QuestionnaireResponse. For example, a ServiceRequest seeking an intake assessment or a
     * decision support recommendation to assess for post-partum depression.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A procedure or observation that this questionnaire was performed as part of the execution of.
     * For example, the surgery a checklist was executed as part of.
     *
     * Composition of questionnaire responses will be handled by the parent questionnaire having
     * answers that reference the child questionnaire. For relationships to referrals, and other
     * types of requests, use basedOn.
     */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The Questionnaire that defines and organizes the questions for which answers are being
     * provided.
     *
     * If a QuestionnaireResponse references a Questionnaire, then the QuestionnaireResponse
     * structure must be consistent with the Questionnaire (i.e. questions must be organized into
     * the same groups, nested questions must still be nested, etc.).
     */
    public var questionnaire: Canonical.Builder? = null

    /**
     * The subject of the questionnaire response. This could be a patient, organization,
     * practitioner, device, etc. This is who/what the answers apply to, but is not necessarily the
     * source of information.
     *
     * If the Questionnaire declared a subjectType, the resource pointed to by this element must be
     * an instance of one of the listed types.
     */
    public var subject: Reference.Builder? = null

    /**
     * The Encounter during which this questionnaire response was created or to which the creation
     * of this record is tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter. A questionnaire that was initiated during an encounter but not
     * fully completed during the encounter would still generally be associated with the encounter.
     */
    public var encounter: Reference.Builder? = null

    /**
     * The date and/or time that this set of answers were last changed.
     *
     * May be different from the lastUpdateTime of the resource itself, because that reflects when
     * the data was known to the server, not when the data was captured.
     *
     * This element is optional to allow for systems that might not know the value, however it
     * SHOULD be populated if possible.
     */
    public var authored: DateTime.Builder? = null

    /**
     * Person who received the answers to the questions in the QuestionnaireResponse and recorded
     * them in the system.
     *
     * Mapping a subject's answers to multiple choice options and determining what to put in the
     * textual answer is a matter of interpretation. Authoring by device would indicate that some
     * portion of the questionnaire had been auto-populated.
     */
    public var author: Reference.Builder? = null

    /**
     * The person who answered the questions about the subject.
     *
     * If not specified, no inference can be made about who provided the data.
     */
    public var source: Reference.Builder? = null

    /**
     * A group or question item from the original questionnaire for which answers are provided.
     *
     * Groups cannot have answers and therefore must nest directly within item. When dealing with
     * questions, nesting must occur within each answer because some questions may have multiple
     * answers (and the nesting occurs for each answer).
     */
    public var item: MutableList<Item.Builder> = mutableListOf()

    override fun build(): QuestionnaireResponse =
      QuestionnaireResponse(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier?.build(),
        basedOn = basedOn.map { it.build() },
        partOf = partOf.map { it.build() },
        questionnaire = questionnaire?.build(),
        status = status,
        subject = subject?.build(),
        encounter = encounter?.build(),
        authored = authored?.build(),
        author = author?.build(),
        source = source?.build(),
        item = item.map { it.build() },
      )
  }

  /** Lifecycle status of the questionnaire response. */
  public enum class QuestionnaireResponseStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    In_Progress("in-progress", "http://hl7.org/fhir/questionnaire-answers-status", "In Progress"),
    Completed("completed", "http://hl7.org/fhir/questionnaire-answers-status", "Completed"),
    Amended("amended", "http://hl7.org/fhir/questionnaire-answers-status", "Amended"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/questionnaire-answers-status",
      "Entered in Error",
    ),
    Stopped("stopped", "http://hl7.org/fhir/questionnaire-answers-status", "Stopped");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): QuestionnaireResponseStatus =
        when (code) {
          "in-progress" -> In_Progress
          "completed" -> Completed
          "amended" -> Amended
          "entered-in-error" -> Entered_In_Error
          "stopped" -> Stopped
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum QuestionnaireResponseStatus"
            )
        }
    }
  }
}

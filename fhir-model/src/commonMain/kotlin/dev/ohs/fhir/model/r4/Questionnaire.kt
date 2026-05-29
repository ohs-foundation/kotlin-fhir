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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.QuestionnaireItemAnswerOptionSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireItemEnableWhenSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireItemInitialSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireItemSerializer
import dev.ohs.fhir.model.r4.serializers.QuestionnaireSerializer
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A structured set of questions intended to guide the collection of answers from end-users.
 * Questionnaires provide detailed control over order, presentation, phraseology and grouping to
 * allow coherent, consistent data collection.
 */
@Serializable(with = QuestionnaireSerializer::class)
@SerialName("Questionnaire")
public data class Questionnaire(
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
   * An absolute URI that is used to identify this questionnaire when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this questionnaire is (or will be) published. This URL can be the target of a canonical
   * reference. It SHALL remain the same when the questionnaire is stored on different servers.
   *
   * The name of the referenced questionnaire can be conveyed using the
   * http://hl7.org/fhir/StructureDefinition/display extension.
   */
  public val url: Uri? = null,
  /**
   * A formal identifier that is used to identify this questionnaire when it is represented in other
   * formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this questionnaire outside of FHIR, where it is not possible to use
   * the logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the questionnaire when it is referenced
   * in a specification, model, design or instance. This is an arbitrary value managed by the
   * questionnaire author and is not expected to be globally unique. For example, it might be a
   * timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation
   * that versions can be placed in a lexicographical sequence.
   *
   * There may be different questionnaire instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the questionnaire with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the questionnaire. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the questionnaire.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /** The URL of a Questionnaire that this Questionnaire is based on. */
  public val derivedFrom: List<Canonical> = listOf(),
  /**
   * The status of this questionnaire. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of questionnaires that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this questionnaire is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of questionnaires that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The types of subjects that can be the subject of responses created for the questionnaire.
   *
   * If none are specified, then the subject is unlimited.
   */
  public val subjectType: List<Enumeration<ResourceType>> = listOf(),
  /**
   * The date (and optionally time) when the questionnaire was published. The date must change when
   * the business version changes and it must change if the status code changes. In addition, it
   * should change when the substantive content of the questionnaire changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the questionnaire. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the questionnaire.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the
   * questionnaire is the organization or individual primarily responsible for the maintenance and
   * upkeep of the questionnaire. This is not necessarily the same individual or organization that
   * developed and initially authored the content. The publisher is the primary point of contact for
   * questions or issues with the questionnaire. This item SHOULD be populated unless the
   * information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the questionnaire from a consumer's perspective.
   *
   * This description can be used to capture details such as why the questionnaire was built,
   * comments about misuse, instructions for clinical use and interpretation, literature references,
   * examples from the paper world, etc. It is not a rendering of the questionnaire as conveyed in
   * the 'text' field of the resource itself. This item SHOULD be populated unless the information
   * is available from context (e.g. the language of the questionnaire is presumed to be the
   * predominant language in the place the questionnaire was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate questionnaire instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the questionnaire is intended to be used.
   *
   * It may be possible for the questionnaire to be used in jurisdictions other than those for which
   * it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this questionnaire is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the questionnaire. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * questionnaire.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the questionnaire and/or its contents. Copyright statements
   * are generally legal restrictions on the use and publishing of the questionnaire.
   */
  public val copyright: Markdown? = null,
  /**
   * The date on which the resource content was approved by the publisher. Approval happens once
   * when the content is officially approved for usage.
   *
   * The 'date' element may be more recent than the approval date because of minor changes or
   * editorial corrections.
   */
  public val approvalDate: Date? = null,
  /**
   * The date on which the resource content was last reviewed. Review happens periodically after
   * approval but does not change the original approval date.
   *
   * If specified, this date follows the original approval date.
   */
  public val lastReviewDate: Date? = null,
  /**
   * The period during which the questionnaire content was or is planned to be in active use.
   *
   * The effective period for a questionnaire determines when the content is applicable for usage
   * and is independent of publication and review dates. For example, a measure intended to be used
   * for the year 2016 might be published in 2015.
   */
  public val effectivePeriod: Period? = null,
  /**
   * An identifier for this question or group of questions in a particular terminology such as
   * LOINC.
   */
  public val code: List<Coding> = listOf(),
  /**
   * A particular question, question grouping or display text that is part of the questionnaire.
   *
   * The content of the questionnaire is constructed from an ordered, hierarchical collection of
   * items.
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
        url = this@with.url?.toBuilder()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        version = this@with.version?.toBuilder()
        name = this@with.name?.toBuilder()
        title = this@with.title?.toBuilder()
        derivedFrom = this@with.derivedFrom.map { it.toBuilder() }.toMutableList()
        experimental = this@with.experimental?.toBuilder()
        subjectType = this@with.subjectType.toMutableList()
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        copyright = this@with.copyright?.toBuilder()
        approvalDate = this@with.approvalDate?.toBuilder()
        lastReviewDate = this@with.lastReviewDate?.toBuilder()
        effectivePeriod = this@with.effectivePeriod?.toBuilder()
        code = this@with.code.map { it.toBuilder() }.toMutableList()
        item = this@with.item.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A particular question, question grouping or display text that is part of the questionnaire. */
  @Serializable(with = QuestionnaireItemSerializer::class)
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
     * An identifier that is unique within the Questionnaire allowing linkage to the equivalent item
     * in a QuestionnaireResponse resource.
     *
     * This ''can'' be a meaningful identifier (e.g. a LOINC code) but is not intended to have any
     * meaning. GUIDs or sequential numbers are appropriate here.
     */
    public val linkId: String,
    /**
     * This element is a URI that refers to an [ElementDefinition](elementdefinition.html) that
     * provides information about this item, including information that might otherwise be included
     * in the instance of the Questionnaire resource. A detailed description of the construction of
     * the URI is shown in Comments, below. If this element is present then the following element
     * values MAY be derived from the Element Definition if the corresponding elements of this
     * Questionnaire resource instance have no value:
     * * code (ElementDefinition.code)
     * * type (ElementDefinition.type)
     * * required (ElementDefinition.min)
     * * repeats (ElementDefinition.max)
     * * maxLength (ElementDefinition.maxLength)
     * * answerValueSet (ElementDefinition.binding)
     * * options (ElementDefinition.binding).
     *
     * The uri refers to an ElementDefinition in a [StructureDefinition](structuredefinition.html#)
     * and always starts with the [canonical URL](references.html#canonical) for the target
     * resource. When referring to a StructureDefinition, a fragment identifier is used to specify
     * the element definition by its id [Element.id](element-definitions.html#Element.id). E.g.
     * http://hl7.org/fhir/StructureDefinition/Observation#Observation.value[x]. In the absence of a
     * fragment identifier, the first/root element definition in the target is the matching element
     * definition.
     */
    public val definition: Uri? = null,
    /**
     * A terminology code that corresponds to this group or question (e.g. a code from LOINC, which
     * defines many questions and answers).
     *
     * The value may come from the ElementDefinition referred to by .definition.
     */
    public val code: List<Coding> = listOf(),
    /**
     * A short label for a particular group, question or set of display text within the
     * questionnaire used for reference by the individual completing the questionnaire.
     *
     * These are generally unique within a questionnaire, though this is not guaranteed. Some
     * questionnaires may have multiple questions with the same label with logic to control which
     * gets exposed. Typically, these won't be used for "display" items, though such use is not
     * prohibited. Systems SHOULD NOT generate their own prefixes if prefixes are defined for any
     * items within a Questionnaire.
     */
    public val prefix: String? = null,
    /**
     * The name of a section, the text of a question or text content for a display item.
     *
     * When using this element to represent the name of a section, use group type item and also make
     * sure to limit the text element to a short string suitable for display as a section heading.
     * Group item instructions should be included as a display type item within the group.
     */
    public val text: String? = null,
    /**
     * The type of questionnaire item this is - whether text for display, a grouping of other items
     * or a particular type of data to be captured (string, integer, coded choice, etc.).
     *
     * Additional constraints on the type of answer can be conveyed by extensions. The value may
     * come from the ElementDefinition referred to by .definition.
     */
    public val type: Enumeration<QuestionnaireItemType>,
    /**
     * A constraint indicating that this item should only be enabled (displayed/allow answers to be
     * captured) when the specified condition is true.
     *
     * If multiple repetitions of this extension are present, the item should be enabled when the
     * condition for *any* of the repetitions is true. I.e. treat "enableWhen"s as being joined by
     * an "or" clause. This element is a modifier because if enableWhen is present for an item,
     * "required" is ignored unless one of the enableWhen conditions is met. When an item is
     * disabled, all of its descendants are disabled, regardless of what their own enableWhen logic
     * might evaluate to.
     */
    public val enableWhen: List<EnableWhen> = listOf(),
    /**
     * Controls how multiple enableWhen values are interpreted - whether all or any must be true.
     *
     * This element must be specified if more than one enableWhen value is provided.
     */
    public val enableBehavior: Enumeration<EnableWhenBehavior>? = null,
    /**
     * An indication, if true, that the item must be present in a "completed" QuestionnaireResponse.
     * If false, the item may be skipped when answering the questionnaire.
     *
     * Questionnaire.item.required only has meaning for elements that are conditionally enabled with
     * enableWhen if the condition evaluates to true. If an item that contains other items is marked
     * as required, that does not automatically make the contained elements required (though
     * required groups must contain at least one child element). The value may come from the
     * ElementDefinition referred to by .definition.
     */
    public val required: Boolean? = null,
    /**
     * An indication, if true, that the item may occur multiple times in the response, collecting
     * multiple answers for questions or multiple sets of answers for groups.
     *
     * If a question is marked as repeats=true, then multiple answers can be provided for the
     * question in the corresponding QuestionnaireResponse. When rendering the questionnaire, it is
     * up to the rendering software whether to render the question text for each answer repetition
     * (i.e. "repeat the question") or to simply allow entry/selection of multiple answers for the
     * question (repeat the answers). Which is most appropriate visually may depend on the type of
     * answer as well as whether there are nested items.
     *
     * The resulting QuestionnaireResponse will be populated the same way regardless of rendering -
     * one 'question' item with multiple answer values.
     *
     * The value may come from the ElementDefinition referred to by .definition.
     */
    public val repeats: Boolean? = null,
    /**
     * An indication, when true, that the value cannot be changed by a human respondent to the
     * Questionnaire.
     *
     * The value of readOnly elements can be established by asserting extensions for defaultValues,
     * linkages that support pre-population and/or extensions that support calculation based on
     * other answers.
     */
    public val readOnly: Boolean? = null,
    /**
     * The maximum number of characters that are permitted in the answer to be considered a "valid"
     * QuestionnaireResponse.
     *
     * For base64binary, reflects the number of characters representing the encoded data, not the
     * number of bytes of the binary data. The value may come from the ElementDefinition referred to
     * by .definition.
     */
    public val maxLength: Integer? = null,
    /**
     * A reference to a value set containing a list of codes representing permitted answers for a
     * "choice" or "open-choice" question.
     *
     * LOINC defines many useful value sets for questionnaire responses. See
     * [LOINC Answer Lists](loinc.html#alist). The value may come from the ElementDefinition
     * referred to by .definition.
     */
    public val answerValueSet: Canonical? = null,
    /**
     * One of the permitted answers for a "choice" or "open-choice" question.
     *
     * This element can be used when the value set machinery of answerValueSet is deemed too
     * cumbersome or when there's a need to capture possible answers that are not codes.
     */
    public val answerOption: List<AnswerOption> = listOf(),
    /**
     * One or more values that should be pre-populated in the answer when initially rendering the
     * questionnaire for user input.
     *
     * The user is allowed to change the value and override the default (unless marked as
     * read-only). If the user doesn't change the value, then this initial value will be persisted
     * when the QuestionnaireResponse is initially created. Note that initial values can influence
     * results. The data type of initial[x] must agree with the item.type, and only repeating items
     * can have more then one initial value.
     */
    public val initial: List<Initial> = listOf(),
    /**
     * Text, questions and other groups to be nested beneath a question or group.
     *
     * There is no specified limit to the depth of nesting. However, Questionnaire authors are
     * encouraged to consider the impact on the user and user interface of overly deep nesting.
     */
    public val item: List<Item> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(linkId.toBuilder(), type).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          definition = this@with.definition?.toBuilder()
          code = this@with.code.map { it.toBuilder() }.toMutableList()
          prefix = this@with.prefix?.toBuilder()
          text = this@with.text?.toBuilder()
          enableWhen = this@with.enableWhen.map { it.toBuilder() }.toMutableList()
          enableBehavior = this@with.enableBehavior
          required = this@with.required?.toBuilder()
          repeats = this@with.repeats?.toBuilder()
          readOnly = this@with.readOnly?.toBuilder()
          maxLength = this@with.maxLength?.toBuilder()
          answerValueSet = this@with.answerValueSet?.toBuilder()
          answerOption = this@with.answerOption.map { it.toBuilder() }.toMutableList()
          initial = this@with.initial.map { it.toBuilder() }.toMutableList()
          item = this@with.item.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * A constraint indicating that this item should only be enabled (displayed/allow answers to be
     * captured) when the specified condition is true.
     */
    @Serializable(with = QuestionnaireItemEnableWhenSerializer::class)
    public data class EnableWhen(
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
       * The linkId for the question whose answer (or lack of answer) governs whether this item is
       * enabled.
       *
       * If multiple question occurrences are present for the same question (same linkId), then this
       * refers to the nearest question occurrence reachable by tracing first the "ancestor" axis
       * and then the "preceding" axis and then the "following" axis.
       */
      public val question: String,
      /** Specifies the criteria by which the question is enabled. */
      public val `operator`: Enumeration<QuestionnaireItemOperator>,
      /**
       * A value that the referenced question is tested using the specified operator in order for
       * the item to be enabled.
       */
      public val answer: Answer,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(question.toBuilder(), `operator`, answer).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public sealed interface Answer {
        public fun asBoolean(): Boolean? = this as? Boolean

        public fun asDecimal(): Decimal? = this as? Decimal

        public fun asInteger(): Integer? = this as? Integer

        public fun asDate(): Date? = this as? Date

        public fun asDateTime(): DateTime? = this as? DateTime

        public fun asTime(): Time? = this as? Time

        public fun asString(): String? = this as? String

        public fun asCoding(): Coding? = this as? Coding

        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asReference(): Reference? = this as? Reference

        @JvmInline
        public value class Boolean(public val `value`: dev.ohs.fhir.model.r4.Boolean) : Answer

        @JvmInline
        public value class Decimal(public val `value`: dev.ohs.fhir.model.r4.Decimal) : Answer

        @JvmInline
        public value class Integer(public val `value`: dev.ohs.fhir.model.r4.Integer) : Answer

        @JvmInline public value class Date(public val `value`: dev.ohs.fhir.model.r4.Date) : Answer

        @JvmInline
        public value class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) : Answer

        @JvmInline public value class Time(public val `value`: dev.ohs.fhir.model.r4.Time) : Answer

        @JvmInline
        public value class String(public val `value`: dev.ohs.fhir.model.r4.String) : Answer

        @JvmInline
        public value class Coding(public val `value`: dev.ohs.fhir.model.r4.Coding) : Answer

        @JvmInline
        public value class Quantity(public val `value`: dev.ohs.fhir.model.r4.Quantity) : Answer

        @JvmInline
        public value class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Answer

        public companion object {
          internal fun from(
            booleanValue: dev.ohs.fhir.model.r4.Boolean?,
            decimalValue: dev.ohs.fhir.model.r4.Decimal?,
            integerValue: dev.ohs.fhir.model.r4.Integer?,
            dateValue: dev.ohs.fhir.model.r4.Date?,
            dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
            timeValue: dev.ohs.fhir.model.r4.Time?,
            stringValue: dev.ohs.fhir.model.r4.String?,
            codingValue: dev.ohs.fhir.model.r4.Coding?,
            quantityValue: dev.ohs.fhir.model.r4.Quantity?,
            referenceValue: dev.ohs.fhir.model.r4.Reference?,
          ): Answer? {
            if (booleanValue != null) return Boolean(booleanValue)
            if (decimalValue != null) return Decimal(decimalValue)
            if (integerValue != null) return Integer(integerValue)
            if (dateValue != null) return Date(dateValue)
            if (dateTimeValue != null) return DateTime(dateTimeValue)
            if (timeValue != null) return Time(timeValue)
            if (stringValue != null) return String(stringValue)
            if (codingValue != null) return Coding(codingValue)
            if (quantityValue != null) return Quantity(quantityValue)
            if (referenceValue != null) return Reference(referenceValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * The linkId for the question whose answer (or lack of answer) governs whether this item is
         * enabled.
         *
         * If multiple question occurrences are present for the same question (same linkId), then
         * this refers to the nearest question occurrence reachable by tracing first the "ancestor"
         * axis and then the "preceding" axis and then the "following" axis.
         */
        public var question: String.Builder,
        /** Specifies the criteria by which the question is enabled. */
        public var `operator`: Enumeration<QuestionnaireItemOperator>,
        /**
         * A value that the referenced question is tested using the specified operator in order for
         * the item to be enabled.
         */
        public var answer: Answer,
      ) {
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

        public fun build(): EnableWhen =
          EnableWhen(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            question = question.build(),
            `operator` = `operator`,
            answer = answer,
          )
      }
    }

    /** One of the permitted answers for a "choice" or "open-choice" question. */
    @Serializable(with = QuestionnaireItemAnswerOptionSerializer::class)
    public data class AnswerOption(
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
       * A potential answer that's allowed as the answer to this question.
       *
       * The data type of the value must agree with the item.type.
       */
      public val `value`: Value,
      /**
       * Indicates whether the answer value is selected when the list of possible answers is
       * initially shown.
       *
       * Use this instead of initial[v] if answerValueSet is present.
       */
      public val initialSelected: Boolean? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(`value`).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            initialSelected = this@with.initialSelected?.toBuilder()
          }
        }

      public sealed interface Value {
        public fun asInteger(): Integer? = this as? Integer

        public fun asDate(): Date? = this as? Date

        public fun asTime(): Time? = this as? Time

        public fun asString(): String? = this as? String

        public fun asCoding(): Coding? = this as? Coding

        public fun asReference(): Reference? = this as? Reference

        @JvmInline
        public value class Integer(public val `value`: dev.ohs.fhir.model.r4.Integer) : Value

        @JvmInline public value class Date(public val `value`: dev.ohs.fhir.model.r4.Date) : Value

        @JvmInline public value class Time(public val `value`: dev.ohs.fhir.model.r4.Time) : Value

        @JvmInline
        public value class String(public val `value`: dev.ohs.fhir.model.r4.String) : Value

        @JvmInline
        public value class Coding(public val `value`: dev.ohs.fhir.model.r4.Coding) : Value

        @JvmInline
        public value class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Value

        public companion object {
          internal fun from(
            integerValue: dev.ohs.fhir.model.r4.Integer?,
            dateValue: dev.ohs.fhir.model.r4.Date?,
            timeValue: dev.ohs.fhir.model.r4.Time?,
            stringValue: dev.ohs.fhir.model.r4.String?,
            codingValue: dev.ohs.fhir.model.r4.Coding?,
            referenceValue: dev.ohs.fhir.model.r4.Reference?,
          ): Value? {
            if (integerValue != null) return Integer(integerValue)
            if (dateValue != null) return Date(dateValue)
            if (timeValue != null) return Time(timeValue)
            if (stringValue != null) return String(stringValue)
            if (codingValue != null) return Coding(codingValue)
            if (referenceValue != null) return Reference(referenceValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * A potential answer that's allowed as the answer to this question.
         *
         * The data type of the value must agree with the item.type.
         */
        public var `value`: Value
      ) {
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
         * Indicates whether the answer value is selected when the list of possible answers is
         * initially shown.
         *
         * Use this instead of initial[v] if answerValueSet is present.
         */
        public var initialSelected: Boolean.Builder? = null

        public fun build(): AnswerOption =
          AnswerOption(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            `value` = `value`,
            initialSelected = initialSelected?.build(),
          )
      }
    }

    /**
     * One or more values that should be pre-populated in the answer when initially rendering the
     * questionnaire for user input.
     */
    @Serializable(with = QuestionnaireItemInitialSerializer::class)
    public data class Initial(
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
       * The actual value to for an initial answer.
       *
       * The type of the initial value must be consistent with the type of the item.
       */
      public val `value`: Value,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(`value`).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
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

        @JvmInline
        public value class Boolean(public val `value`: dev.ohs.fhir.model.r4.Boolean) : Value

        @JvmInline
        public value class Decimal(public val `value`: dev.ohs.fhir.model.r4.Decimal) : Value

        @JvmInline
        public value class Integer(public val `value`: dev.ohs.fhir.model.r4.Integer) : Value

        @JvmInline public value class Date(public val `value`: dev.ohs.fhir.model.r4.Date) : Value

        @JvmInline
        public value class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) : Value

        @JvmInline public value class Time(public val `value`: dev.ohs.fhir.model.r4.Time) : Value

        @JvmInline
        public value class String(public val `value`: dev.ohs.fhir.model.r4.String) : Value

        @JvmInline public value class Uri(public val `value`: dev.ohs.fhir.model.r4.Uri) : Value

        @JvmInline
        public value class Attachment(public val `value`: dev.ohs.fhir.model.r4.Attachment) : Value

        @JvmInline
        public value class Coding(public val `value`: dev.ohs.fhir.model.r4.Coding) : Value

        @JvmInline
        public value class Quantity(public val `value`: dev.ohs.fhir.model.r4.Quantity) : Value

        @JvmInline
        public value class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Value

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

      public class Builder(
        /**
         * The actual value to for an initial answer.
         *
         * The type of the initial value must be consistent with the type of the item.
         */
        public var `value`: Value
      ) {
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

        public fun build(): Initial =
          Initial(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            `value` = `value`,
          )
      }
    }

    public class Builder(
      /**
       * An identifier that is unique within the Questionnaire allowing linkage to the equivalent
       * item in a QuestionnaireResponse resource.
       *
       * This ''can'' be a meaningful identifier (e.g. a LOINC code) but is not intended to have any
       * meaning. GUIDs or sequential numbers are appropriate here.
       */
      public var linkId: String.Builder,
      /**
       * The type of questionnaire item this is - whether text for display, a grouping of other
       * items or a particular type of data to be captured (string, integer, coded choice, etc.).
       *
       * Additional constraints on the type of answer can be conveyed by extensions. The value may
       * come from the ElementDefinition referred to by .definition.
       */
      public var type: Enumeration<QuestionnaireItemType>,
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
       * This element is a URI that refers to an [ElementDefinition](elementdefinition.html) that
       * provides information about this item, including information that might otherwise be
       * included in the instance of the Questionnaire resource. A detailed description of the
       * construction of the URI is shown in Comments, below. If this element is present then the
       * following element values MAY be derived from the Element Definition if the corresponding
       * elements of this Questionnaire resource instance have no value:
       * * code (ElementDefinition.code)
       * * type (ElementDefinition.type)
       * * required (ElementDefinition.min)
       * * repeats (ElementDefinition.max)
       * * maxLength (ElementDefinition.maxLength)
       * * answerValueSet (ElementDefinition.binding)
       * * options (ElementDefinition.binding).
       *
       * The uri refers to an ElementDefinition in a
       * [StructureDefinition](structuredefinition.html#) and always starts with the
       * [canonical URL](references.html#canonical) for the target resource. When referring to a
       * StructureDefinition, a fragment identifier is used to specify the element definition by its
       * id [Element.id](element-definitions.html#Element.id). E.g.
       * http://hl7.org/fhir/StructureDefinition/Observation#Observation.value[x]. In the absence of
       * a fragment identifier, the first/root element definition in the target is the matching
       * element definition.
       */
      public var definition: Uri.Builder? = null

      /**
       * A terminology code that corresponds to this group or question (e.g. a code from LOINC,
       * which defines many questions and answers).
       *
       * The value may come from the ElementDefinition referred to by .definition.
       */
      public var code: MutableList<Coding.Builder> = mutableListOf()

      /**
       * A short label for a particular group, question or set of display text within the
       * questionnaire used for reference by the individual completing the questionnaire.
       *
       * These are generally unique within a questionnaire, though this is not guaranteed. Some
       * questionnaires may have multiple questions with the same label with logic to control which
       * gets exposed. Typically, these won't be used for "display" items, though such use is not
       * prohibited. Systems SHOULD NOT generate their own prefixes if prefixes are defined for any
       * items within a Questionnaire.
       */
      public var prefix: String.Builder? = null

      /**
       * The name of a section, the text of a question or text content for a display item.
       *
       * When using this element to represent the name of a section, use group type item and also
       * make sure to limit the text element to a short string suitable for display as a section
       * heading. Group item instructions should be included as a display type item within the
       * group.
       */
      public var text: String.Builder? = null

      /**
       * A constraint indicating that this item should only be enabled (displayed/allow answers to
       * be captured) when the specified condition is true.
       *
       * If multiple repetitions of this extension are present, the item should be enabled when the
       * condition for *any* of the repetitions is true. I.e. treat "enableWhen"s as being joined by
       * an "or" clause. This element is a modifier because if enableWhen is present for an item,
       * "required" is ignored unless one of the enableWhen conditions is met. When an item is
       * disabled, all of its descendants are disabled, regardless of what their own enableWhen
       * logic might evaluate to.
       */
      public var enableWhen: MutableList<EnableWhen.Builder> = mutableListOf()

      /**
       * Controls how multiple enableWhen values are interpreted - whether all or any must be true.
       *
       * This element must be specified if more than one enableWhen value is provided.
       */
      public var enableBehavior: Enumeration<EnableWhenBehavior>? = null

      /**
       * An indication, if true, that the item must be present in a "completed"
       * QuestionnaireResponse. If false, the item may be skipped when answering the questionnaire.
       *
       * Questionnaire.item.required only has meaning for elements that are conditionally enabled
       * with enableWhen if the condition evaluates to true. If an item that contains other items is
       * marked as required, that does not automatically make the contained elements required
       * (though required groups must contain at least one child element). The value may come from
       * the ElementDefinition referred to by .definition.
       */
      public var required: Boolean.Builder? = null

      /**
       * An indication, if true, that the item may occur multiple times in the response, collecting
       * multiple answers for questions or multiple sets of answers for groups.
       *
       * If a question is marked as repeats=true, then multiple answers can be provided for the
       * question in the corresponding QuestionnaireResponse. When rendering the questionnaire, it
       * is up to the rendering software whether to render the question text for each answer
       * repetition (i.e. "repeat the question") or to simply allow entry/selection of multiple
       * answers for the question (repeat the answers). Which is most appropriate visually may
       * depend on the type of answer as well as whether there are nested items.
       *
       * The resulting QuestionnaireResponse will be populated the same way regardless of
       * rendering - one 'question' item with multiple answer values.
       *
       * The value may come from the ElementDefinition referred to by .definition.
       */
      public var repeats: Boolean.Builder? = null

      /**
       * An indication, when true, that the value cannot be changed by a human respondent to the
       * Questionnaire.
       *
       * The value of readOnly elements can be established by asserting extensions for
       * defaultValues, linkages that support pre-population and/or extensions that support
       * calculation based on other answers.
       */
      public var readOnly: Boolean.Builder? = null

      /**
       * The maximum number of characters that are permitted in the answer to be considered a
       * "valid" QuestionnaireResponse.
       *
       * For base64binary, reflects the number of characters representing the encoded data, not the
       * number of bytes of the binary data. The value may come from the ElementDefinition referred
       * to by .definition.
       */
      public var maxLength: Integer.Builder? = null

      /**
       * A reference to a value set containing a list of codes representing permitted answers for a
       * "choice" or "open-choice" question.
       *
       * LOINC defines many useful value sets for questionnaire responses. See
       * [LOINC Answer Lists](loinc.html#alist). The value may come from the ElementDefinition
       * referred to by .definition.
       */
      public var answerValueSet: Canonical.Builder? = null

      /**
       * One of the permitted answers for a "choice" or "open-choice" question.
       *
       * This element can be used when the value set machinery of answerValueSet is deemed too
       * cumbersome or when there's a need to capture possible answers that are not codes.
       */
      public var answerOption: MutableList<AnswerOption.Builder> = mutableListOf()

      /**
       * One or more values that should be pre-populated in the answer when initially rendering the
       * questionnaire for user input.
       *
       * The user is allowed to change the value and override the default (unless marked as
       * read-only). If the user doesn't change the value, then this initial value will be persisted
       * when the QuestionnaireResponse is initially created. Note that initial values can influence
       * results. The data type of initial[x] must agree with the item.type, and only repeating
       * items can have more then one initial value.
       */
      public var initial: MutableList<Initial.Builder> = mutableListOf()

      /**
       * Text, questions and other groups to be nested beneath a question or group.
       *
       * There is no specified limit to the depth of nesting. However, Questionnaire authors are
       * encouraged to consider the impact on the user and user interface of overly deep nesting.
       */
      public var item: MutableList<Builder> = mutableListOf()

      public fun build(): Item =
        Item(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          linkId = linkId.build(),
          definition = definition?.build(),
          code = code.map { it.build() },
          prefix = prefix?.build(),
          text = text?.build(),
          type = type,
          enableWhen = enableWhen.map { it.build() },
          enableBehavior = enableBehavior,
          required = required?.build(),
          repeats = repeats?.build(),
          readOnly = readOnly?.build(),
          maxLength = maxLength?.build(),
          answerValueSet = answerValueSet?.build(),
          answerOption = answerOption.map { it.build() },
          initial = initial.map { it.build() },
          item = item.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The status of this questionnaire. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of questionnaires that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>
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
     * An absolute URI that is used to identify this questionnaire when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this questionnaire is (or will be) published. This URL can be the target of a
     * canonical reference. It SHALL remain the same when the questionnaire is stored on different
     * servers.
     *
     * The name of the referenced questionnaire can be conveyed using the
     * http://hl7.org/fhir/StructureDefinition/display extension.
     */
    public var url: Uri.Builder? = null

    /**
     * A formal identifier that is used to identify this questionnaire when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this questionnaire outside of FHIR, where it is not possible
     * to use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the questionnaire when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the questionnaire author and is not expected to be globally unique. For example, it might
     * be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different questionnaire instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the questionnaire with the format [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A natural language name identifying the questionnaire. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the questionnaire.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /** The URL of a Questionnaire that this Questionnaire is based on. */
    public var derivedFrom: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * A Boolean value to indicate that this questionnaire is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of questionnaires that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The types of subjects that can be the subject of responses created for the questionnaire.
     *
     * If none are specified, then the subject is unlimited.
     */
    public var subjectType: MutableList<Enumeration<ResourceType>> = mutableListOf()

    /**
     * The date (and optionally time) when the questionnaire was published. The date must change
     * when the business version changes and it must change if the status code changes. In addition,
     * it should change when the substantive content of the questionnaire changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the questionnaire. Additional specific dates may be added as
     * extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the questionnaire.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the
     * questionnaire is the organization or individual primarily responsible for the maintenance and
     * upkeep of the questionnaire. This is not necessarily the same individual or organization that
     * developed and initially authored the content. The publisher is the primary point of contact
     * for questions or issues with the questionnaire. This item SHOULD be populated unless the
     * information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the questionnaire from a consumer's perspective.
     *
     * This description can be used to capture details such as why the questionnaire was built,
     * comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the questionnaire as
     * conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless the
     * information is available from context (e.g. the language of the questionnaire is presumed to
     * be the predominant language in the place the questionnaire was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate questionnaire instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the questionnaire is intended to be used.
     *
     * It may be possible for the questionnaire to be used in jurisdictions other than those for
     * which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this questionnaire is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the questionnaire. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * questionnaire.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the questionnaire and/or its contents. Copyright statements
     * are generally legal restrictions on the use and publishing of the questionnaire.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once
     * when the content is officially approved for usage.
     *
     * The 'date' element may be more recent than the approval date because of minor changes or
     * editorial corrections.
     */
    public var approvalDate: Date.Builder? = null

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after
     * approval but does not change the original approval date.
     *
     * If specified, this date follows the original approval date.
     */
    public var lastReviewDate: Date.Builder? = null

    /**
     * The period during which the questionnaire content was or is planned to be in active use.
     *
     * The effective period for a questionnaire determines when the content is applicable for usage
     * and is independent of publication and review dates. For example, a measure intended to be
     * used for the year 2016 might be published in 2015.
     */
    public var effectivePeriod: Period.Builder? = null

    /**
     * An identifier for this question or group of questions in a particular terminology such as
     * LOINC.
     */
    public var code: MutableList<Coding.Builder> = mutableListOf()

    /**
     * A particular question, question grouping or display text that is part of the questionnaire.
     *
     * The content of the questionnaire is constructed from an ordered, hierarchical collection of
     * items.
     */
    public var item: MutableList<Item.Builder> = mutableListOf()

    override fun build(): Questionnaire =
      Questionnaire(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url?.build(),
        identifier = identifier.map { it.build() },
        version = version?.build(),
        name = name?.build(),
        title = title?.build(),
        derivedFrom = derivedFrom.map { it.build() },
        status = status,
        experimental = experimental?.build(),
        subjectType = subjectType,
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        effectivePeriod = effectivePeriod?.build(),
        code = code.map { it.build() },
        item = item.map { it.build() },
      )
  }

  /** Distinguishes groups from questions and display text and indicates data type for questions. */
  public enum class QuestionnaireItemType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Group("group", "http://hl7.org/fhir/item-type", "Group"),
    Display("display", "http://hl7.org/fhir/item-type", "Display"),
    Boolean("boolean", "http://hl7.org/fhir/item-type", "Boolean"),
    Decimal("decimal", "http://hl7.org/fhir/item-type", "Decimal"),
    Integer("integer", "http://hl7.org/fhir/item-type", "Integer"),
    Date("date", "http://hl7.org/fhir/item-type", "Date"),
    DateTime("dateTime", "http://hl7.org/fhir/item-type", "Date Time"),
    Time("time", "http://hl7.org/fhir/item-type", "Time"),
    String("string", "http://hl7.org/fhir/item-type", "String"),
    Text("text", "http://hl7.org/fhir/item-type", "Text"),
    Url("url", "http://hl7.org/fhir/item-type", "Url"),
    Choice("choice", "http://hl7.org/fhir/item-type", "Choice"),
    Open_Choice("open-choice", "http://hl7.org/fhir/item-type", "Open Choice"),
    Attachment("attachment", "http://hl7.org/fhir/item-type", "Attachment"),
    Reference("reference", "http://hl7.org/fhir/item-type", "Reference"),
    Quantity("quantity", "http://hl7.org/fhir/item-type", "Quantity");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): QuestionnaireItemType =
        when (code) {
          "group" -> Group
          "display" -> Display
          "boolean" -> Boolean
          "decimal" -> Decimal
          "integer" -> Integer
          "date" -> Date
          "dateTime" -> DateTime
          "time" -> Time
          "string" -> String
          "text" -> Text
          "url" -> Url
          "choice" -> Choice
          "open-choice" -> Open_Choice
          "attachment" -> Attachment
          "reference" -> Reference
          "quantity" -> Quantity
          else ->
            throw IllegalArgumentException("Unknown code $code for enum QuestionnaireItemType")
        }
    }
  }

  /** Controls how multiple enableWhen values are interpreted - whether all or any must be true. */
  public enum class EnableWhenBehavior(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    All("all", "http://hl7.org/fhir/questionnaire-enable-behavior", "All"),
    Any("any", "http://hl7.org/fhir/questionnaire-enable-behavior", "Any");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): EnableWhenBehavior =
        when (code) {
          "all" -> All
          "any" -> Any
          else -> throw IllegalArgumentException("Unknown code $code for enum EnableWhenBehavior")
        }
    }
  }

  /** The criteria by which a question is enabled. */
  public enum class QuestionnaireItemOperator(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Exists("exists", "http://hl7.org/fhir/questionnaire-enable-operator", "Exists"),
    EqualTo("=", "http://hl7.org/fhir/questionnaire-enable-operator", "Equals"),
    NotEqualTo("!=", "http://hl7.org/fhir/questionnaire-enable-operator", "Not Equals"),
    GreaterThan(">", "http://hl7.org/fhir/questionnaire-enable-operator", "Greater Than"),
    LessThan("<", "http://hl7.org/fhir/questionnaire-enable-operator", "Less Than"),
    GreaterThanOrEqualTo(
      ">=",
      "http://hl7.org/fhir/questionnaire-enable-operator",
      "Greater or Equals",
    ),
    LessThanOrEqualTo("<=", "http://hl7.org/fhir/questionnaire-enable-operator", "Less or Equals");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): QuestionnaireItemOperator =
        when (code) {
          "exists" -> Exists
          "=" -> EqualTo
          "!=" -> NotEqualTo
          ">" -> GreaterThan
          "<" -> LessThan
          ">=" -> GreaterThanOrEqualTo
          "<=" -> LessThanOrEqualTo
          else ->
            throw IllegalArgumentException("Unknown code $code for enum QuestionnaireItemOperator")
        }
    }
  }
}

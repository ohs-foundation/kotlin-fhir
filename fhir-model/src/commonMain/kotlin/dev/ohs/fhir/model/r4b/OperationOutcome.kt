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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.serializers.OperationOutcomeIssueSerializer
import com.google.fhir.model.r4.serializers.OperationOutcomeSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A collection of error, warning, or information messages that result from a system action. */
@Serializable(with = OperationOutcomeSerializer::class)
@SerialName("OperationOutcome")
public data class OperationOutcome(
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
  /** An error, warning, or information message that results from a system action. */
  public val issue: List<Issue>,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(issue.map { it.toBuilder() }.toMutableList()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
      }
    }

  /** An error, warning, or information message that results from a system action. */
  @Serializable(with = OperationOutcomeIssueSerializer::class)
  public data class Issue(
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
     * Indicates whether the issue indicates a variation from successful processing.
     *
     * This is labeled as "Is Modifier" because applications should not confuse hints and warnings
     * with errors.
     */
    public val severity: Enumeration<IssueSeverity>,
    /**
     * Describes the type of the issue. The system that creates an OperationOutcome SHALL choose the
     * most applicable code from the IssueType value set, and may additional provide its own code
     * for the error in the details element.
     */
    public val code: Enumeration<IssueType>,
    /**
     * Additional details about the error. This may be a text description of the error or a system
     * code that identifies the error.
     *
     * A human readable description of the error issue SHOULD be placed in details.text.
     */
    public val details: CodeableConcept? = null,
    /**
     * Additional diagnostic information about the issue.
     *
     * This may be a description of how a value is erroneous, a stack dump to help trace the issue
     * or other troubleshooting information.
     */
    public val diagnostics: String? = null,
    /**
     * This element is deprecated because it is XML specific. It is replaced by issue.expression,
     * which is format independent, and simpler to parse.
     *
     * For resource issues, this will be a simple XPath limited to element names, repetition
     * indicators and the default child accessor that identifies one of the elements in the resource
     * that caused this issue to be raised. For HTTP errors, will be "http." + the parameter name.
     *
     * The root of the XPath is the resource or bundle that generated OperationOutcome. Each XPath
     * SHALL resolve to a single node. This element is deprecated, and is being replaced by
     * expression.
     */
    public val location: List<String> = listOf(),
    /**
     * A [simple subset of FHIRPath](fhirpath.html#simple) limited to element names, repetition
     * indicators and the default child accessor that identifies one of the elements in the resource
     * that caused this issue to be raised.
     *
     * The root of the FHIRPath is the resource or bundle that generated OperationOutcome. Each
     * FHIRPath SHALL resolve to a single node.
     */
    public val expression: List<String> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(severity, code).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          details = this@with.details?.toBuilder()
          diagnostics = this@with.diagnostics?.toBuilder()
          location = this@with.location.map { it.toBuilder() }.toMutableList()
          expression = this@with.expression.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Indicates whether the issue indicates a variation from successful processing.
       *
       * This is labeled as "Is Modifier" because applications should not confuse hints and warnings
       * with errors.
       */
      public var severity: Enumeration<IssueSeverity>,
      /**
       * Describes the type of the issue. The system that creates an OperationOutcome SHALL choose
       * the most applicable code from the IssueType value set, and may additional provide its own
       * code for the error in the details element.
       */
      public var code: Enumeration<IssueType>,
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
       * Additional details about the error. This may be a text description of the error or a system
       * code that identifies the error.
       *
       * A human readable description of the error issue SHOULD be placed in details.text.
       */
      public var details: CodeableConcept.Builder? = null

      /**
       * Additional diagnostic information about the issue.
       *
       * This may be a description of how a value is erroneous, a stack dump to help trace the issue
       * or other troubleshooting information.
       */
      public var diagnostics: String.Builder? = null

      /**
       * This element is deprecated because it is XML specific. It is replaced by issue.expression,
       * which is format independent, and simpler to parse.
       *
       * For resource issues, this will be a simple XPath limited to element names, repetition
       * indicators and the default child accessor that identifies one of the elements in the
       * resource that caused this issue to be raised. For HTTP errors, will be "http." + the
       * parameter name.
       *
       * The root of the XPath is the resource or bundle that generated OperationOutcome. Each XPath
       * SHALL resolve to a single node. This element is deprecated, and is being replaced by
       * expression.
       */
      public var location: MutableList<String.Builder> = mutableListOf()

      /**
       * A [simple subset of FHIRPath](fhirpath.html#simple) limited to element names, repetition
       * indicators and the default child accessor that identifies one of the elements in the
       * resource that caused this issue to be raised.
       *
       * The root of the FHIRPath is the resource or bundle that generated OperationOutcome. Each
       * FHIRPath SHALL resolve to a single node.
       */
      public var expression: MutableList<String.Builder> = mutableListOf()

      public fun build(): Issue =
        Issue(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          severity = severity,
          code = code,
          details = details?.build(),
          diagnostics = diagnostics?.build(),
          location = location.map { it.build() },
          expression = expression.map { it.build() },
        )
    }
  }

  public class Builder(
    /** An error, warning, or information message that results from a system action. */
    public var issue: MutableList<Issue.Builder>
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

    override fun build(): OperationOutcome =
      OperationOutcome(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        issue = issue.map { it.build() },
      )
  }

  /** How the issue affects the success of the action. */
  public enum class IssueSeverity(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Fatal("fatal", "http://hl7.org/fhir/issue-severity", "Fatal"),
    Error("error", "http://hl7.org/fhir/issue-severity", "Error"),
    Warning("warning", "http://hl7.org/fhir/issue-severity", "Warning"),
    Information("information", "http://hl7.org/fhir/issue-severity", "Information");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): IssueSeverity =
        when (code) {
          "fatal" -> Fatal
          "error" -> Error
          "warning" -> Warning
          "information" -> Information
          else -> throw IllegalArgumentException("Unknown code $code for enum IssueSeverity")
        }
    }
  }

  /** A code that describes the type of issue. */
  public enum class IssueType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Invalid("invalid", "http://hl7.org/fhir/issue-type", "Invalid Content"),
    Structure("structure", "http://hl7.org/fhir/issue-type", "Structural Issue"),
    Required("required", "http://hl7.org/fhir/issue-type", "Required element missing"),
    Value("value", "http://hl7.org/fhir/issue-type", "Element value invalid"),
    Invariant("invariant", "http://hl7.org/fhir/issue-type", "Validation rule failed"),
    Security("security", "http://hl7.org/fhir/issue-type", "Security Problem"),
    Login("login", "http://hl7.org/fhir/issue-type", "Login Required"),
    Unknown("unknown", "http://hl7.org/fhir/issue-type", "Unknown User"),
    Expired("expired", "http://hl7.org/fhir/issue-type", "Session Expired"),
    Forbidden("forbidden", "http://hl7.org/fhir/issue-type", "Forbidden"),
    Suppressed("suppressed", "http://hl7.org/fhir/issue-type", "Information  Suppressed"),
    Processing("processing", "http://hl7.org/fhir/issue-type", "Processing Failure"),
    Not_Supported("not-supported", "http://hl7.org/fhir/issue-type", "Content not supported"),
    Duplicate("duplicate", "http://hl7.org/fhir/issue-type", "Duplicate"),
    Multiple_Matches("multiple-matches", "http://hl7.org/fhir/issue-type", "Multiple Matches"),
    Not_Found("not-found", "http://hl7.org/fhir/issue-type", "Not Found"),
    Deleted("deleted", "http://hl7.org/fhir/issue-type", "Deleted"),
    Too_Long("too-long", "http://hl7.org/fhir/issue-type", "Content Too Long"),
    Code_Invalid("code-invalid", "http://hl7.org/fhir/issue-type", "Invalid Code"),
    Extension("extension", "http://hl7.org/fhir/issue-type", "Unacceptable Extension"),
    Too_Costly("too-costly", "http://hl7.org/fhir/issue-type", "Operation Too Costly"),
    Business_Rule("business-rule", "http://hl7.org/fhir/issue-type", "Business Rule Violation"),
    Conflict("conflict", "http://hl7.org/fhir/issue-type", "Edit Version Conflict"),
    Transient("transient", "http://hl7.org/fhir/issue-type", "Transient Issue"),
    Lock_Error("lock-error", "http://hl7.org/fhir/issue-type", "Lock Error"),
    No_Store("no-store", "http://hl7.org/fhir/issue-type", "No Store Available"),
    Exception("exception", "http://hl7.org/fhir/issue-type", "Exception"),
    Timeout("timeout", "http://hl7.org/fhir/issue-type", "Timeout"),
    Incomplete("incomplete", "http://hl7.org/fhir/issue-type", "Incomplete Results"),
    Throttled("throttled", "http://hl7.org/fhir/issue-type", "Throttled"),
    Informational("informational", "http://hl7.org/fhir/issue-type", "Informational Note");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): IssueType =
        when (code) {
          "invalid" -> Invalid
          "structure" -> Structure
          "required" -> Required
          "value" -> Value
          "invariant" -> Invariant
          "security" -> Security
          "login" -> Login
          "unknown" -> Unknown
          "expired" -> Expired
          "forbidden" -> Forbidden
          "suppressed" -> Suppressed
          "processing" -> Processing
          "not-supported" -> Not_Supported
          "duplicate" -> Duplicate
          "multiple-matches" -> Multiple_Matches
          "not-found" -> Not_Found
          "deleted" -> Deleted
          "too-long" -> Too_Long
          "code-invalid" -> Code_Invalid
          "extension" -> Extension
          "too-costly" -> Too_Costly
          "business-rule" -> Business_Rule
          "conflict" -> Conflict
          "transient" -> Transient
          "lock-error" -> Lock_Error
          "no-store" -> No_Store
          "exception" -> Exception
          "timeout" -> Timeout
          "incomplete" -> Incomplete
          "throttled" -> Throttled
          "informational" -> Informational
          else -> throw IllegalArgumentException("Unknown code $code for enum IssueType")
        }
    }
  }
}

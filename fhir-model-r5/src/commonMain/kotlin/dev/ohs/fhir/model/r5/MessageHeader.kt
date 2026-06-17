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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.MessageHeaderDestinationSerializer
import dev.ohs.fhir.model.r5.serializers.MessageHeaderResponseSerializer
import dev.ohs.fhir.model.r5.serializers.MessageHeaderSerializer
import dev.ohs.fhir.model.r5.serializers.MessageHeaderSourceSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The header for a message exchange that is either requesting or responding to an action. The
 * reference(s) that are the subject of the action as well as other information related to the
 * action are typically transmitted in a bundle in which the MessageHeader resource instance is the
 * first resource in the bundle.
 */
@Serializable(with = MessageHeaderSerializer::class)
@SerialName("MessageHeader")
public data class MessageHeader(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
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
   * Code that identifies the event this message represents and connects it with its definition.
   * Events defined as part of the FHIR specification are defined by the implementation.
   * Alternatively a canonical uri to the EventDefinition.
   *
   * The time of the event will be found in the focus resource. The time of the message will be
   * found in [Bundle.timestamp](bundle-definitions.html#Bundle.timestamp).
   */
  public val event: Event,
  /**
   * The destination application which the message is intended for.
   *
   * There SHOULD be at least one destination, but in some circumstances, the source system is
   * unaware of any particular destination system.
   */
  public val destination: List<Destination> = listOf(),
  /**
   * Identifies the sending system to allow the use of a trust relationship.
   *
   * Use case is for where a (trusted) sending system is responsible for multiple organizations, and
   * therefore cannot differentiate based on source endpoint / authentication alone. Proposing to
   * remove and rely on Task to convey this information.
   */
  public val sender: Reference? = null,
  /**
   * The logical author of the message - the personor device that decided the described event should
   * happen. When there is more than one candidate, pick the most proximal to the MessageHeader. Can
   * provide other authors in extensions.
   *
   * Usually only for the request but can be used in a response.Proposing to remove and rely on Task
   * to convey this information.
   */
  public val author: Reference? = null,
  /** The source application from which this message originated. */
  public val source: Source,
  /**
   * The person or organization that accepts overall responsibility for the contents of the message.
   * The implication is that the message event happened under the policies of the responsible party.
   *
   * Usually only for the request but can be used in a response.Proposing to remove and rely on Task
   * to convey this information.
   */
  public val responsible: Reference? = null,
  /**
   * Coded indication of the cause for the event - indicates a reason for the occurrence of the
   * event that is a focus of this message.
   */
  public val reason: CodeableConcept? = null,
  /**
   * Information about the message that this message is a response to. Only present if this message
   * is a response.
   */
  public val response: Response? = null,
  /**
   * The actual data of the message - a reference to the root/focus class of the event. This is
   * allowed to be a Parameters resource.
   *
   * The data is defined where the transaction type is defined. The transaction data is always
   * included in the bundle that is the full message. Only the root resource is specified. The
   * resources it references should be contained in the bundle but are not also listed here.
   * Multiple repetitions are allowed to cater for merges and other situations with multiple focal
   * targets.
   */
  public val focus: List<Reference> = listOf(),
  /** Permanent link to the MessageDefinition for this message. */
  public val definition: Canonical? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          event,
          source.toBuilder(),
        )
        .apply {
          id = this@with.id
          meta = this@with.meta?.toBuilder()
          implicitRules = this@with.implicitRules?.toBuilder()
          language = this@with.language?.toBuilder()
          text = this@with.text?.toBuilder()
          contained = this@with.contained.map { it.toBuilder() }.toMutableList()
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          destination = this@with.destination.map { it.toBuilder() }.toMutableList()
          sender = this@with.sender?.toBuilder()
          author = this@with.author?.toBuilder()
          responsible = this@with.responsible?.toBuilder()
          reason = this@with.reason?.toBuilder()
          response = this@with.response?.toBuilder()
          focus = this@with.focus.map { it.toBuilder() }.toMutableList()
          definition = this@with.definition?.toBuilder()
        }
    }

  /** The destination application which the message is intended for. */
  @Serializable(with = MessageHeaderDestinationSerializer::class)
  public data class Destination(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
     * Indicates where the message should be routed.
     *
     * The url may be a non-resolvable URI for systems that do not use standard network-based
     * addresses.
     */
    public val endpoint: Endpoint? = null,
    /** Human-readable name for the target system. */
    public val name: String? = null,
    /**
     * Identifies the target end system in situations where the initial message transmission is to
     * an intermediary system.
     */
    public val target: Reference? = null,
    /**
     * Allows data conveyed by a message to be addressed to a particular person or department when
     * routing to a specific application isn't sufficient.
     */
    public val `receiver`: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          endpoint = this@with.endpoint
          name = this@with.name?.toBuilder()
          target = this@with.target?.toBuilder()
          `receiver` = this@with.`receiver`?.toBuilder()
        }
      }

    public sealed interface Endpoint {
      public fun asUrl(): Url? = this as? Url

      public fun asReference(): Reference? = this as? Reference

      public data class Url(public val `value`: dev.ohs.fhir.model.r5.Url) : Endpoint

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Endpoint

      public companion object {
        internal fun from(
          urlValue: dev.ohs.fhir.model.r5.Url?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
        ): Endpoint? {
          if (urlValue != null) return Url(urlValue)
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
       * Indicates where the message should be routed.
       *
       * The url may be a non-resolvable URI for systems that do not use standard network-based
       * addresses.
       */
      public var endpoint: Endpoint? = null

      /** Human-readable name for the target system. */
      public var name: String.Builder? = null

      /**
       * Identifies the target end system in situations where the initial message transmission is to
       * an intermediary system.
       */
      public var target: Reference.Builder? = null

      /**
       * Allows data conveyed by a message to be addressed to a particular person or department when
       * routing to a specific application isn't sufficient.
       */
      public var `receiver`: Reference.Builder? = null

      public fun build(): Destination =
        Destination(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          endpoint = endpoint,
          name = name?.build(),
          target = target?.build(),
          `receiver` = `receiver`?.build(),
        )
    }
  }

  /** The source application from which this message originated. */
  @Serializable(with = MessageHeaderSourceSerializer::class)
  public data class Source(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
     * Identifies the routing target to send acknowledgements to.
     *
     * The url may be a non-resolvable URI for systems that do not use standard network-based
     * addresses.
     */
    public val endpoint: Endpoint? = null,
    /** Human-readable name for the source system. */
    public val name: String? = null,
    /** May include configuration or other information useful in debugging. */
    public val software: String? = null,
    /**
     * Can convey versions of multiple systems in situations where a message passes through multiple
     * hands.
     */
    public val version: String? = null,
    /**
     * An e-mail, phone, website or other contact point to use to resolve issues with message
     * communications.
     */
    public val contact: ContactPoint? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          endpoint = this@with.endpoint
          name = this@with.name?.toBuilder()
          software = this@with.software?.toBuilder()
          version = this@with.version?.toBuilder()
          contact = this@with.contact?.toBuilder()
        }
      }

    public sealed interface Endpoint {
      public fun asUrl(): Url? = this as? Url

      public fun asReference(): Reference? = this as? Reference

      public data class Url(public val `value`: dev.ohs.fhir.model.r5.Url) : Endpoint

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Endpoint

      public companion object {
        internal fun from(
          urlValue: dev.ohs.fhir.model.r5.Url?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
        ): Endpoint? {
          if (urlValue != null) return Url(urlValue)
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
       * Identifies the routing target to send acknowledgements to.
       *
       * The url may be a non-resolvable URI for systems that do not use standard network-based
       * addresses.
       */
      public var endpoint: Endpoint? = null

      /** Human-readable name for the source system. */
      public var name: String.Builder? = null

      /** May include configuration or other information useful in debugging. */
      public var software: String.Builder? = null

      /**
       * Can convey versions of multiple systems in situations where a message passes through
       * multiple hands.
       */
      public var version: String.Builder? = null

      /**
       * An e-mail, phone, website or other contact point to use to resolve issues with message
       * communications.
       */
      public var contact: ContactPoint.Builder? = null

      public fun build(): Source =
        Source(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          endpoint = endpoint,
          name = name?.build(),
          software = software?.build(),
          version = version?.build(),
          contact = contact?.build(),
        )
    }
  }

  /**
   * Information about the message that this message is a response to. Only present if this message
   * is a response.
   */
  @Serializable(with = MessageHeaderResponseSerializer::class)
  public data class Response(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    /** The Bundle.identifier of the message to which this message is a response. */
    public val identifier: Identifier,
    /**
     * Code that identifies the type of response to the message - whether it was successful or not,
     * and whether it should be resent or not.
     *
     * This is a generic response to the request message. Specific data for the response will be
     * found in MessageHeader.focus.
     */
    public val code: Enumeration<ResponseType>,
    /**
     * Full details of any issues found in the message.
     *
     * This SHALL be contained in the bundle. If any of the issues are errors, the response code
     * SHALL be an error.
     */
    public val details: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            identifier.toBuilder(),
            code,
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            details = this@with.details?.toBuilder()
          }
      }

    public class Builder(
      /** The Bundle.identifier of the message to which this message is a response. */
      public var identifier: Identifier.Builder,
      /**
       * Code that identifies the type of response to the message - whether it was successful or
       * not, and whether it should be resent or not.
       *
       * This is a generic response to the request message. Specific data for the response will be
       * found in MessageHeader.focus.
       */
      public var code: Enumeration<ResponseType>,
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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
       * Full details of any issues found in the message.
       *
       * This SHALL be contained in the bundle. If any of the issues are errors, the response code
       * SHALL be an error.
       */
      public var details: Reference.Builder? = null

      public fun build(): Response =
        Response(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier.build(),
          code = code,
          details = details?.build(),
        )
    }
  }

  public sealed interface Event {
    public fun asCoding(): Coding? = this as? Coding

    public fun asCanonical(): Canonical? = this as? Canonical

    public data class Coding(public val `value`: dev.ohs.fhir.model.r5.Coding) : Event

    public data class Canonical(public val `value`: dev.ohs.fhir.model.r5.Canonical) : Event

    public companion object {
      internal fun from(
        codingValue: dev.ohs.fhir.model.r5.Coding?,
        canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
      ): Event? {
        if (codingValue != null) return Coding(codingValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * Code that identifies the event this message represents and connects it with its definition.
     * Events defined as part of the FHIR specification are defined by the implementation.
     * Alternatively a canonical uri to the EventDefinition.
     *
     * The time of the event will be found in the focus resource. The time of the message will be
     * found in [Bundle.timestamp](bundle-definitions.html#Bundle.timestamp).
     */
    public var event: Event,
    /** The source application from which this message originated. */
    public var source: Source.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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
     * The destination application which the message is intended for.
     *
     * There SHOULD be at least one destination, but in some circumstances, the source system is
     * unaware of any particular destination system.
     */
    public var destination: MutableList<Destination.Builder> = mutableListOf()

    /**
     * Identifies the sending system to allow the use of a trust relationship.
     *
     * Use case is for where a (trusted) sending system is responsible for multiple organizations,
     * and therefore cannot differentiate based on source endpoint / authentication alone. Proposing
     * to remove and rely on Task to convey this information.
     */
    public var sender: Reference.Builder? = null

    /**
     * The logical author of the message - the personor device that decided the described event
     * should happen. When there is more than one candidate, pick the most proximal to the
     * MessageHeader. Can provide other authors in extensions.
     *
     * Usually only for the request but can be used in a response.Proposing to remove and rely on
     * Task to convey this information.
     */
    public var author: Reference.Builder? = null

    /**
     * The person or organization that accepts overall responsibility for the contents of the
     * message. The implication is that the message event happened under the policies of the
     * responsible party.
     *
     * Usually only for the request but can be used in a response.Proposing to remove and rely on
     * Task to convey this information.
     */
    public var responsible: Reference.Builder? = null

    /**
     * Coded indication of the cause for the event - indicates a reason for the occurrence of the
     * event that is a focus of this message.
     */
    public var reason: CodeableConcept.Builder? = null

    /**
     * Information about the message that this message is a response to. Only present if this
     * message is a response.
     */
    public var response: Response.Builder? = null

    /**
     * The actual data of the message - a reference to the root/focus class of the event. This is
     * allowed to be a Parameters resource.
     *
     * The data is defined where the transaction type is defined. The transaction data is always
     * included in the bundle that is the full message. Only the root resource is specified. The
     * resources it references should be contained in the bundle but are not also listed here.
     * Multiple repetitions are allowed to cater for merges and other situations with multiple focal
     * targets.
     */
    public var focus: MutableList<Reference.Builder> = mutableListOf()

    /** Permanent link to the MessageDefinition for this message. */
    public var definition: Canonical.Builder? = null

    override fun build(): MessageHeader =
      MessageHeader(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        event = event,
        destination = destination.map { it.build() },
        sender = sender?.build(),
        author = author?.build(),
        source = source.build(),
        responsible = responsible?.build(),
        reason = reason?.build(),
        response = response?.build(),
        focus = focus.map { it.build() },
        definition = definition?.build(),
      )
  }

  /** The kind of response to a message. */
  public enum class ResponseType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Ok("ok", "http://hl7.org/fhir/response-code", "OK"),
    Transient_Error("transient-error", "http://hl7.org/fhir/response-code", "Transient Error"),
    Fatal_Error("fatal-error", "http://hl7.org/fhir/response-code", "Fatal Error");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ResponseType =
        when (code) {
          "ok" -> Ok
          "transient-error" -> Transient_Error
          "fatal-error" -> Fatal_Error
          else -> throw IllegalArgumentException("Unknown code $code for enum ResponseType")
        }
    }
  }
}

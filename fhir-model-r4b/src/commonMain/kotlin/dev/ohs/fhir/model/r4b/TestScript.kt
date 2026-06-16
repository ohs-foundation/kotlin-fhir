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

import dev.ohs.fhir.model.r4b.serializers.TestScriptDestinationSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptFixtureSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptMetadataCapabilitySerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptMetadataLinkSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptMetadataSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptOriginSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptSetupActionAssertSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptSetupActionOperationRequestHeaderSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptSetupActionOperationSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptSetupActionSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptSetupSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptTeardownActionSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptTeardownSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptTestActionSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptTestSerializer
import dev.ohs.fhir.model.r4b.serializers.TestScriptVariableSerializer
import dev.ohs.fhir.model.r4b.terminologies.FHIRDefinedType
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A structured set of tests against a FHIR server or client implementation to determine compliance
 * against the FHIR specification.
 */
@Serializable(with = TestScriptSerializer::class)
@SerialName("TestScript")
public data class TestScript(
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
   * An absolute URI that is used to identify this test script when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this test script is (or will be) published. This URL can be the target of a canonical
   * reference. It SHALL remain the same when the test script is stored on different servers.
   *
   * Can be a urn:uuid: or a urn:oid: but real http: addresses are preferred. Multiple instances may
   * share the same URL if they have a distinct version.
   *
   * The determination of when to create a new version of a resource (same url, new version) vs.
   * defining a new artifact is up to the author. Considerations for making this decision are found
   * in [Technical and Business Versions](resource.html#versions).
   *
   * In some cases, the resource can no longer be found at the stated url, but the url itself cannot
   * change. Implementations can use the [meta.source](resource.html#meta) element to indicate where
   * the current master source of the resource can be found.
   */
  public val url: Uri,
  /**
   * A formal identifier that is used to identify this test script when it is represented in other
   * formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this test script outside of FHIR, where it is not possible to use
   * the logical URI.
   */
  public val identifier: Identifier? = null,
  /**
   * The identifier that is used to identify this version of the test script when it is referenced
   * in a specification, model, design or instance. This is an arbitrary value managed by the test
   * script author and is not expected to be globally unique. For example, it might be a timestamp
   * (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that
   * versions can be placed in a lexicographical sequence.
   *
   * There may be different test script instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the test script with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the test script. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String,
  /**
   * A short, descriptive, user-friendly title for the test script.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * The status of this test script. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of test scripts that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this test script is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of test scripts that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the test script was published. The date must change when
   * the business version changes and it must change if the status code changes. In addition, it
   * should change when the substantive content of the test script changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the test script. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the test script.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the test script
   * is the organization or individual primarily responsible for the maintenance and upkeep of the
   * test script. This is not necessarily the same individual or organization that developed and
   * initially authored the content. The publisher is the primary point of contact for questions or
   * issues with the test script. This item SHOULD be populated unless the information is available
   * from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the test script from a consumer's perspective.
   *
   * This description can be used to capture details such as why the test script was built, comments
   * about misuse, instructions for clinical use and interpretation, literature references, examples
   * from the paper world, etc. It is not a rendering of the test script as conveyed in the 'text'
   * field of the resource itself. This item SHOULD be populated unless the information is available
   * from context (e.g. the language of the test script is presumed to be the predominant language
   * in the place the test script was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate test script instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the test script is intended to be used.
   *
   * It may be possible for the test script to be used in jurisdictions other than those for which
   * it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this test script is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the test script. Instead, it provides traceability
   * of ''why'' the resource is either needed or ''why'' it is defined as it is. This may be used to
   * point to source materials or specifications that drove the structure of this test script.
   */
  public val purpose: Markdown? = null,
  /**
   * A copyright statement relating to the test script and/or its contents. Copyright statements are
   * generally legal restrictions on the use and publishing of the test script.
   */
  public val copyright: Markdown? = null,
  /**
   * An abstract server used in operations within this test script in the origin element.
   *
   * The purpose of this element is to define the profile of an origin element used elsewhere in the
   * script. Test engines could then use the origin-profile mapping to offer a filtered list of test
   * systems that can serve as the sender for the interaction.
   */
  public val origin: List<Origin> = listOf(),
  /**
   * An abstract server used in operations within this test script in the destination element.
   *
   * The purpose of this element is to define the profile of a destination element used elsewhere in
   * the script. Test engines could then use the destination-profile mapping to offer a filtered
   * list of test systems that can serve as the receiver for the interaction.
   */
  public val destination: List<Destination> = listOf(),
  /**
   * The required capability must exist and are assumed to function correctly on the FHIR server
   * being tested.
   */
  public val metadata: Metadata? = null,
  /**
   * Fixture in the test script - by reference (uri). All fixtures are required for the test script
   * to execute.
   */
  public val fixture: List<Fixture> = listOf(),
  /**
   * Reference to the profile to be used for validation.
   *
   * See http://build.fhir.org/resourcelist.html for complete list of resource types.
   */
  public val profile: List<Reference> = listOf(),
  /**
   * Variable is set based either on element value in response body or on header field value in the
   * response headers.
   *
   * Variables would be set based either on XPath/JSONPath expressions against fixtures (static and
   * response), or headerField evaluations against response headers. If variable evaluates to
   * nodelist or anything other than a primitive value, then test engine would report an error.
   * Variables would be used to perform clean replacements in "operation.params",
   * "operation.requestHeader.value", and "operation.url" element values during operation calls and
   * in "assert.value" during assertion evaluations. This limits the places that test engines would
   * need to look for placeholders "${}". Variables are scoped to the whole script. They are NOT
   * evaluated at declaration. They are evaluated by test engine when used for substitutions in
   * "operation.params", "operation.requestHeader.value", and "operation.url" element values during
   * operation calls and in "assert.value" during assertion evaluations. See example
   * testscript-search.xml.
   */
  public val variable: List<Variable> = listOf(),
  /** A series of required setup operations before tests are executed. */
  public val setup: Setup? = null,
  /** A test in this script. */
  public val test: List<Test> = listOf(),
  /**
   * A series of operations required to clean up after all the tests are executed (successfully or
   * otherwise).
   */
  public val teardown: Teardown? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(url.toBuilder(), name.toBuilder(), status).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier?.toBuilder()
        version = this@with.version?.toBuilder()
        title = this@with.title?.toBuilder()
        experimental = this@with.experimental?.toBuilder()
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        copyright = this@with.copyright?.toBuilder()
        origin = this@with.origin.map { it.toBuilder() }.toMutableList()
        destination = this@with.destination.map { it.toBuilder() }.toMutableList()
        metadata = this@with.metadata?.toBuilder()
        fixture = this@with.fixture.map { it.toBuilder() }.toMutableList()
        profile = this@with.profile.map { it.toBuilder() }.toMutableList()
        variable = this@with.variable.map { it.toBuilder() }.toMutableList()
        setup = this@with.setup?.toBuilder()
        test = this@with.test.map { it.toBuilder() }.toMutableList()
        teardown = this@with.teardown?.toBuilder()
      }
    }

  /** An abstract server used in operations within this test script in the origin element. */
  @Serializable(with = TestScriptOriginSerializer::class)
  public data class Origin(
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
     * Abstract name given to an origin server in this test script. The name is provided as a number
     * starting at 1.
     *
     * A given origin index (e.g. 1) can appear only once in the list (e.g. Origin 1 cannot be
     * specified twice ... once as FormFiller and again as FormProcessor within the same script as
     * that could get confusing during test configuration).
     *
     * Different origin indices could play the same actor in the same test script (e.g. You could
     * have two different test systems acting as Form-Filler).
     *
     * The origin indices provided elsewhere in the test script must be one of these origin indices.
     */
    public val index: Integer,
    /**
     * The type of origin profile the test system supports.
     *
     * Must be a "sender"/"client" profile.
     */
    public val profile: Coding,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(index.toBuilder(), profile.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Abstract name given to an origin server in this test script. The name is provided as a
       * number starting at 1.
       *
       * A given origin index (e.g. 1) can appear only once in the list (e.g. Origin 1 cannot be
       * specified twice ... once as FormFiller and again as FormProcessor within the same script as
       * that could get confusing during test configuration).
       *
       * Different origin indices could play the same actor in the same test script (e.g. You could
       * have two different test systems acting as Form-Filler).
       *
       * The origin indices provided elsewhere in the test script must be one of these origin
       * indices.
       */
      public var index: Integer.Builder,
      /**
       * The type of origin profile the test system supports.
       *
       * Must be a "sender"/"client" profile.
       */
      public var profile: Coding.Builder,
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

      public fun build(): Origin =
        Origin(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          index = index.build(),
          profile = profile.build(),
        )
    }
  }

  /** An abstract server used in operations within this test script in the destination element. */
  @Serializable(with = TestScriptDestinationSerializer::class)
  public data class Destination(
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
     * Abstract name given to a destination server in this test script. The name is provided as a
     * number starting at 1.
     *
     * A given destination index (e.g. 1) can appear only once in the list (e.g. Destination 1
     * cannot be specified twice ... once as Form-Manager and again as Form-Processor within the
     * same script as that could get confusing during test configuration).
     *
     * Different destination indices could play the same actor in the same test script (e.g. You
     * could have two different test systems acting as Form-Manager).
     *
     * The destination indices provided elsewhere in the test script must be one of these
     * destination indices.
     */
    public val index: Integer,
    /**
     * The type of destination profile the test system supports.
     *
     * Must be a "receiver"/"server" profile.
     */
    public val profile: Coding,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(index.toBuilder(), profile.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Abstract name given to a destination server in this test script. The name is provided as a
       * number starting at 1.
       *
       * A given destination index (e.g. 1) can appear only once in the list (e.g. Destination 1
       * cannot be specified twice ... once as Form-Manager and again as Form-Processor within the
       * same script as that could get confusing during test configuration).
       *
       * Different destination indices could play the same actor in the same test script (e.g. You
       * could have two different test systems acting as Form-Manager).
       *
       * The destination indices provided elsewhere in the test script must be one of these
       * destination indices.
       */
      public var index: Integer.Builder,
      /**
       * The type of destination profile the test system supports.
       *
       * Must be a "receiver"/"server" profile.
       */
      public var profile: Coding.Builder,
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

      public fun build(): Destination =
        Destination(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          index = index.build(),
          profile = profile.build(),
        )
    }
  }

  /**
   * The required capability must exist and are assumed to function correctly on the FHIR server
   * being tested.
   */
  @Serializable(with = TestScriptMetadataSerializer::class)
  public data class Metadata(
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
    /** A link to the FHIR specification that this test is covering. */
    public val link: List<Link> = listOf(),
    /**
     * Capabilities that must exist and are assumed to function correctly on the FHIR server being
     * tested.
     *
     * When the metadata capabilities section is defined at TestScript.metadata or at
     * TestScript.setup.metadata, and the server's conformance statement does not contain the
     * elements defined in the minimal conformance statement, then all the tests in the TestScript
     * are skipped. When the metadata capabilities section is defined at TestScript.test.metadata
     * and the server's conformance statement does not contain the elements defined in the minimal
     * conformance statement, then only that test is skipped. The "metadata.capabilities.required"
     * and "metadata.capabilities.validated" elements only indicate whether the capabilities are the
     * primary focus of the test script or not. They do not impact the skipping logic. Capabilities
     * whose "metadata.capabilities.validated" flag is true are the primary focus of the test
     * script.
     */
    public val capability: List<Capability>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(capability.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          link = this@with.link.map { it.toBuilder() }.toMutableList()
        }
      }

    /** A link to the FHIR specification that this test is covering. */
    @Serializable(with = TestScriptMetadataLinkSerializer::class)
    public data class Link(
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
      /** URL to a particular requirement or feature within the FHIR specification. */
      public val url: Uri,
      /** Short description of the link. */
      public val description: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(url.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            description = this@with.description?.toBuilder()
          }
        }

      public class Builder(
        /** URL to a particular requirement or feature within the FHIR specification. */
        public var url: Uri.Builder
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

        /** Short description of the link. */
        public var description: String.Builder? = null

        public fun build(): Link =
          Link(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            url = url.build(),
            description = description?.build(),
          )
      }
    }

    /**
     * Capabilities that must exist and are assumed to function correctly on the FHIR server being
     * tested.
     */
    @Serializable(with = TestScriptMetadataCapabilitySerializer::class)
    public data class Capability(
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
       * Whether or not the test execution will require the given capabilities of the server in
       * order for this test script to execute.
       */
      public val required: Boolean,
      /**
       * Whether or not the test execution will validate the given capabilities of the server in
       * order for this test script to execute.
       */
      public val validated: Boolean,
      /**
       * Description of the capabilities that this test script is requiring the server to support.
       */
      public val description: String? = null,
      /** Which origin server these requirements apply to. */
      public val origin: List<Integer> = listOf(),
      /** Which server these requirements apply to. */
      public val destination: Integer? = null,
      /**
       * Links to the FHIR specification that describes this interaction and the resources involved
       * in more detail.
       */
      public val link: List<Uri> = listOf(),
      /**
       * Minimum capabilities required of server for test script to execute successfully. If server
       * does not meet at a minimum the referenced capability statement, then all tests in this
       * script are skipped.
       *
       * The conformance statement of the server has to contain at a minimum the contents of the
       * reference pointed to by this element.
       */
      public val capabilities: Canonical,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(required.toBuilder(), validated.toBuilder(), capabilities.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            description = this@with.description?.toBuilder()
            origin = this@with.origin.map { it.toBuilder() }.toMutableList()
            destination = this@with.destination?.toBuilder()
            link = this@with.link.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * Whether or not the test execution will require the given capabilities of the server in
         * order for this test script to execute.
         */
        public var required: Boolean.Builder,
        /**
         * Whether or not the test execution will validate the given capabilities of the server in
         * order for this test script to execute.
         */
        public var validated: Boolean.Builder,
        /**
         * Minimum capabilities required of server for test script to execute successfully. If
         * server does not meet at a minimum the referenced capability statement, then all tests in
         * this script are skipped.
         *
         * The conformance statement of the server has to contain at a minimum the contents of the
         * reference pointed to by this element.
         */
        public var capabilities: Canonical.Builder,
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
         * Description of the capabilities that this test script is requiring the server to support.
         */
        public var description: String.Builder? = null

        /** Which origin server these requirements apply to. */
        public var origin: MutableList<Integer.Builder> = mutableListOf()

        /** Which server these requirements apply to. */
        public var destination: Integer.Builder? = null

        /**
         * Links to the FHIR specification that describes this interaction and the resources
         * involved in more detail.
         */
        public var link: MutableList<Uri.Builder> = mutableListOf()

        public fun build(): Capability =
          Capability(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            required = required.build(),
            validated = validated.build(),
            description = description?.build(),
            origin = origin.map { it.build() },
            destination = destination?.build(),
            link = link.map { it.build() },
            capabilities = capabilities.build(),
          )
      }
    }

    public class Builder(
      /**
       * Capabilities that must exist and are assumed to function correctly on the FHIR server being
       * tested.
       *
       * When the metadata capabilities section is defined at TestScript.metadata or at
       * TestScript.setup.metadata, and the server's conformance statement does not contain the
       * elements defined in the minimal conformance statement, then all the tests in the TestScript
       * are skipped. When the metadata capabilities section is defined at TestScript.test.metadata
       * and the server's conformance statement does not contain the elements defined in the minimal
       * conformance statement, then only that test is skipped. The "metadata.capabilities.required"
       * and "metadata.capabilities.validated" elements only indicate whether the capabilities are
       * the primary focus of the test script or not. They do not impact the skipping logic.
       * Capabilities whose "metadata.capabilities.validated" flag is true are the primary focus of
       * the test script.
       */
      public var capability: MutableList<Capability.Builder>
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

      /** A link to the FHIR specification that this test is covering. */
      public var link: MutableList<Link.Builder> = mutableListOf()

      public fun build(): Metadata =
        Metadata(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          link = link.map { it.build() },
          capability = capability.map { it.build() },
        )
    }
  }

  /**
   * Fixture in the test script - by reference (uri). All fixtures are required for the test script
   * to execute.
   */
  @Serializable(with = TestScriptFixtureSerializer::class)
  public data class Fixture(
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
     * Whether or not to implicitly create the fixture during setup. If true, the fixture is
     * automatically created on each server being tested during setup, therefore no create operation
     * is required for this fixture in the TestScript.setup section.
     */
    public val autocreate: Boolean,
    /**
     * Whether or not to implicitly delete the fixture during teardown. If true, the fixture is
     * automatically deleted on each server being tested during teardown, therefore no delete
     * operation is required for this fixture in the TestScript.teardown section.
     */
    public val autodelete: Boolean,
    /**
     * Reference to the resource (containing the contents of the resource needed for operations).
     *
     * See http://build.fhir.org/resourcelist.html for complete list of resource types.
     */
    public val resource: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(autocreate.toBuilder(), autodelete.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          resource = this@with.resource?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Whether or not to implicitly create the fixture during setup. If true, the fixture is
       * automatically created on each server being tested during setup, therefore no create
       * operation is required for this fixture in the TestScript.setup section.
       */
      public var autocreate: Boolean.Builder,
      /**
       * Whether or not to implicitly delete the fixture during teardown. If true, the fixture is
       * automatically deleted on each server being tested during teardown, therefore no delete
       * operation is required for this fixture in the TestScript.teardown section.
       */
      public var autodelete: Boolean.Builder,
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
       * Reference to the resource (containing the contents of the resource needed for operations).
       *
       * See http://build.fhir.org/resourcelist.html for complete list of resource types.
       */
      public var resource: Reference.Builder? = null

      public fun build(): Fixture =
        Fixture(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          autocreate = autocreate.build(),
          autodelete = autodelete.build(),
          resource = resource?.build(),
        )
    }
  }

  /**
   * Variable is set based either on element value in response body or on header field value in the
   * response headers.
   */
  @Serializable(with = TestScriptVariableSerializer::class)
  public data class Variable(
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
     * Descriptive name for this variable.
     *
     * Placeholders would contain the variable name wrapped in ${} in "operation.params",
     * "operation.requestHeader.value", and "operation.url" elements. These placeholders would need
     * to be replaced by the variable value before the operation is executed.
     */
    public val name: String,
    /**
     * A default, hard-coded, or user-defined value for this variable.
     *
     * The purpose of this element is to allow for a pre-defined value that can be used as a default
     * or as an override value. Test engines can optionally use this as a placeholder for
     * user-defined execution time values.
     */
    public val defaultValue: String? = null,
    /** A free text natural language description of the variable and its purpose. */
    public val description: String? = null,
    /**
     * The FHIRPath expression to evaluate against the fixture body. When variables are defined,
     * only one of either expression, headerField or path must be specified.
     *
     * If headerField is defined, then the variable will be evaluated against the headers that
     * sourceId is pointing to. If expression or path is defined, then the variable will be
     * evaluated against the fixture body that sourceId is pointing to. It is an error to define any
     * combination of expression, headerField and path.
     */
    public val expression: String? = null,
    /**
     * Will be used to grab the HTTP header field value from the headers that sourceId is pointing
     * to.
     *
     * If headerField is defined, then the variable will be evaluated against the headers that
     * sourceId is pointing to. If path is defined, then the variable will be evaluated against the
     * fixture body that sourceId is pointing to. It is an error to define both headerField and
     * path.
     */
    public val headerField: String? = null,
    /**
     * Displayable text string with hint help information to the user when entering a default value.
     */
    public val hint: String? = null,
    /**
     * XPath or JSONPath to evaluate against the fixture body. When variables are defined, only one
     * of either expression, headerField or path must be specified.
     *
     * If headerField is defined, then the variable will be evaluated against the headers that
     * sourceId is pointing to. If expression or path is defined, then the variable will be
     * evaluated against the fixture body that sourceId is pointing to. It is an error to define any
     * combination of expression, headerField and path.
     */
    public val path: String? = null,
    /**
     * Fixture to evaluate the XPath/JSONPath expression or the headerField against within this
     * variable.
     *
     * This can be a statically defined fixture (at the top of the TestScript) or a dynamically set
     * fixture created by responseId of the `action.operation` element.
     */
    public val sourceId: Id? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(name.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          defaultValue = this@with.defaultValue?.toBuilder()
          description = this@with.description?.toBuilder()
          expression = this@with.expression?.toBuilder()
          headerField = this@with.headerField?.toBuilder()
          hint = this@with.hint?.toBuilder()
          path = this@with.path?.toBuilder()
          sourceId = this@with.sourceId?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Descriptive name for this variable.
       *
       * Placeholders would contain the variable name wrapped in ${} in "operation.params",
       * "operation.requestHeader.value", and "operation.url" elements. These placeholders would
       * need to be replaced by the variable value before the operation is executed.
       */
      public var name: String.Builder
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
       * A default, hard-coded, or user-defined value for this variable.
       *
       * The purpose of this element is to allow for a pre-defined value that can be used as a
       * default or as an override value. Test engines can optionally use this as a placeholder for
       * user-defined execution time values.
       */
      public var defaultValue: String.Builder? = null

      /** A free text natural language description of the variable and its purpose. */
      public var description: String.Builder? = null

      /**
       * The FHIRPath expression to evaluate against the fixture body. When variables are defined,
       * only one of either expression, headerField or path must be specified.
       *
       * If headerField is defined, then the variable will be evaluated against the headers that
       * sourceId is pointing to. If expression or path is defined, then the variable will be
       * evaluated against the fixture body that sourceId is pointing to. It is an error to define
       * any combination of expression, headerField and path.
       */
      public var expression: String.Builder? = null

      /**
       * Will be used to grab the HTTP header field value from the headers that sourceId is pointing
       * to.
       *
       * If headerField is defined, then the variable will be evaluated against the headers that
       * sourceId is pointing to. If path is defined, then the variable will be evaluated against
       * the fixture body that sourceId is pointing to. It is an error to define both headerField
       * and path.
       */
      public var headerField: String.Builder? = null

      /**
       * Displayable text string with hint help information to the user when entering a default
       * value.
       */
      public var hint: String.Builder? = null

      /**
       * XPath or JSONPath to evaluate against the fixture body. When variables are defined, only
       * one of either expression, headerField or path must be specified.
       *
       * If headerField is defined, then the variable will be evaluated against the headers that
       * sourceId is pointing to. If expression or path is defined, then the variable will be
       * evaluated against the fixture body that sourceId is pointing to. It is an error to define
       * any combination of expression, headerField and path.
       */
      public var path: String.Builder? = null

      /**
       * Fixture to evaluate the XPath/JSONPath expression or the headerField against within this
       * variable.
       *
       * This can be a statically defined fixture (at the top of the TestScript) or a dynamically
       * set fixture created by responseId of the `action.operation` element.
       */
      public var sourceId: Id.Builder? = null

      public fun build(): Variable =
        Variable(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name.build(),
          defaultValue = defaultValue?.build(),
          description = description?.build(),
          expression = expression?.build(),
          headerField = headerField?.build(),
          hint = hint?.build(),
          path = path?.build(),
          sourceId = sourceId?.build(),
        )
    }
  }

  /** A series of required setup operations before tests are executed. */
  @Serializable(with = TestScriptSetupSerializer::class)
  public data class Setup(
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
     * Action would contain either an operation or an assertion.
     *
     * An action should contain either an operation or an assertion but not both. It can contain any
     * number of variables.
     */
    public val action: List<Action>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(action.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Action would contain either an operation or an assertion. */
    @Serializable(with = TestScriptSetupActionSerializer::class)
    public data class Action(
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
      /** The operation to perform. */
      public val operation: Operation? = null,
      /**
       * Evaluates the results of previous operations to determine if the server under test behaves
       * appropriately.
       *
       * In order to evaluate an assertion, the request, response, and results of the most recently
       * executed operation must always be maintained by the test engine.
       */
      public val assert: Assert? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            operation = this@with.operation?.toBuilder()
            assert = this@with.assert?.toBuilder()
          }
        }

      /** The operation to perform. */
      @Serializable(with = TestScriptSetupActionOperationSerializer::class)
      public data class Operation(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * Server interaction or operation type.
         *
         * See http://build.fhir.org/http.html for list of server interactions.
         */
        public val type: Coding? = null,
        /**
         * The type of the resource. See http://build.fhir.org/resourcelist.html.
         *
         * If "url" element is specified, then "targetId", "params", and "resource" elements will be
         * ignored as "url" element will have everything needed for constructing the request url. If
         * "params" element is specified, then "targetId" element is ignored. For FHIR operations
         * that require a resource (e.g. "read" and "vread" operations), the "resource" element must
         * be specified when "params" element is specified. If "url" and "params" elements are
         * absent, then the request url will be constructed from "targetId" fixture if present. For
         * "read" operation, the resource and id values will be extracted from "targetId" fixture
         * and used to construct the url. For "vread" and "history" operations, the versionId value
         * will also be used.
         */
        public val resource: Enumeration<FHIRDefinedType>? = null,
        /**
         * The label would be used for tracking/logging purposes by test engines.
         *
         * This has no impact on the verification itself.
         */
        public val label: String? = null,
        /**
         * The description would be used by test engines for tracking and reporting purposes.
         *
         * This has no impact on the verification itself.
         */
        public val description: String? = null,
        /**
         * The mime-type to use for RESTful operation in the 'Accept' header.
         *
         * If this is specified, then test engine shall set the 'Accept' header to the corresponding
         * value. If you'd like to explicitly set the 'Accept' to some other value then use the
         * 'requestHeader' element.
         */
        public val accept: Code? = null,
        /**
         * The mime-type to use for RESTful operation in the 'Content-Type' header.
         *
         * If this is specified, then test engine shall set the 'Content-Type' header to the
         * corresponding value. If you'd like to explicitly set the 'Content-Type' to some other
         * value then use the 'requestHeader' element.
         */
        public val contentType: Code? = null,
        /**
         * The server where the request message is destined for. Must be one of the server numbers
         * listed in TestScript.destination section.
         *
         * If multiple TestScript.destination elements are defined and operation.destination is
         * undefined, test engine will report an error as it cannot determine what destination to
         * use for the exchange.
         */
        public val destination: Integer? = null,
        /**
         * Whether or not to implicitly send the request url in encoded format. The default is true
         * to match the standard RESTful client behavior. Set to false when communicating with a
         * server that does not support encoded url paths.
         */
        public val encodeRequestUrl: Boolean,
        /**
         * The HTTP method the test engine MUST use for this operation regardless of any other
         * operation details.
         *
         * The primary purpose of the explicit HTTP method is support of HTTP POST method invocation
         * of the FHIR search. Other uses will include support of negative testing.
         */
        public val method: Enumeration<TestScriptRequestMethodCode>? = null,
        /**
         * The server where the request message originates from. Must be one of the server numbers
         * listed in TestScript.origin section.
         *
         * If absent, test engine will send the message. When present, test engine will not send the
         * request message but will wait for the request message to be sent from this origin server.
         */
        public val origin: Integer? = null,
        /**
         * Path plus parameters after [type]. Used to set parts of the request URL explicitly.
         *
         * If "url" element is specified, then "targetId", "params", and "resource" elements will be
         * ignored as "url" element will have everything needed for constructing the request url. If
         * "params" element is specified, then "targetId" element is ignored. For FHIR operations
         * that require a resource (e.g. "read" and "vread" operations), the "resource" element must
         * be specified when "params" element is specified. If "url" and "params" elements are
         * absent, then the request url will be constructed from "targetId" fixture if present. For
         * "read" operation, the resource and id values will be extracted from "targetId" fixture
         * and used to construct the url. For "vread" and "history" operations, the versionId value
         * will also be used. Test engines would append whatever is specified for "params" to the
         * URL after the resource type without tampering with the string (beyond encoding the URL
         * for HTTP). The "params" element does not correspond exactly to "search parameters". Nor
         * is it the "path". It corresponds to the part of the URL that comes after the [type] (when
         * "resource" element is specified); e.g. It corresponds to "/[id]/_history/[vid]
         * {?_format=[mime-type]}" in the following operation: GET [base]/[type]/[id]/_history/[vid]
         * {?_format=[mime-type]} Test engines do have to look for placeholders (${}) and replace
         * the variable placeholders with the variable values at runtime before sending the request.
         */
        public val params: String? = null,
        /**
         * Header elements would be used to set HTTP headers.
         *
         * This gives control to test-script writers to set headers explicitly based on test
         * requirements. It will allow for testing using: - "If-Modified-Since" and "If-None-Match"
         * headers. See http://build.fhir.org/http.html#2.1.0.5.1 - "If-Match" header. See
         * http://build.fhir.org/http.html#2.1.0.11 - Conditional Create using "If-None-Exist". See
         * http://build.fhir.org/http.html#2.1.0.13.1 - Invalid "Content-Type" header for negative
         * testing. - etc.
         */
        public val requestHeader: List<RequestHeader> = listOf(),
        /**
         * The fixture id (maybe new) to map to the request.
         *
         * If a requestId is supplied, then the resulting request (both headers and body) is mapped
         * to the fixture ID (which may be entirely new and previously undeclared) designated by
         * "requestId". If requestId is not specified, it is the test engine's responsibility to
         * store the request and use it as the requestId in subsequent assertions when assertion
         * path and/or headerField is specified, direction is equal to request, and the requestId in
         * not specified.
         */
        public val requestId: Id? = null,
        /**
         * The fixture id (maybe new) to map to the response.
         *
         * If a responseId is supplied, and the server responds, then the resulting response (both
         * headers and body) is mapped to the fixture ID (which may be entirely new and previously
         * undeclared) designated by "responseId". If responseId is not specified, it is the test
         * engine's responsibility to store the response and use it as the responseId in subsequent
         * assertions when assertion path and/or headerField is specified and the responseId is not
         * specified.
         */
        public val responseId: Id? = null,
        /** The id of the fixture used as the body of a PUT or POST request. */
        public val sourceId: Id? = null,
        /**
         * Id of fixture used for extracting the [id], [type], and [vid] for GET requests.
         *
         * If "url" element is specified, then "targetId", "params", and "resource" elements will be
         * ignored as "url" element will have everything needed for constructing the request url. If
         * "params" element is specified, then "targetId" element is ignored. For FHIR operations
         * that require a resource (e.g. "read" and "vread" operations), the "resource" element must
         * be specified when "params" element is specified. If "url" and "params" elements are
         * absent, then the request url will be constructed from "targetId" fixture if present. For
         * "read" operation, the resource and id values will be extracted from "targetId" fixture
         * and used to construct the url. For "vread" and "history" operations, the versionId value
         * will also be used.
         */
        public val targetId: Id? = null,
        /**
         * Complete request URL.
         *
         * Used to set the request URL explicitly. If "url" element is defined, then "targetId",
         * "resource", and "params" elements will be ignored. Test engines would use whatever is
         * specified in "url" without tampering with the string (beyond encoding the URL for HTTP).
         * Test engines do have to look for placeholders (${}) and replace the variable placeholders
         * with the variable values at runtime before sending the request.
         */
        public val url: String? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(encodeRequestUrl.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              type = this@with.type?.toBuilder()
              resource = this@with.resource
              label = this@with.label?.toBuilder()
              description = this@with.description?.toBuilder()
              accept = this@with.accept?.toBuilder()
              contentType = this@with.contentType?.toBuilder()
              destination = this@with.destination?.toBuilder()
              method = this@with.method
              origin = this@with.origin?.toBuilder()
              params = this@with.params?.toBuilder()
              requestHeader = this@with.requestHeader.map { it.toBuilder() }.toMutableList()
              requestId = this@with.requestId?.toBuilder()
              responseId = this@with.responseId?.toBuilder()
              sourceId = this@with.sourceId?.toBuilder()
              targetId = this@with.targetId?.toBuilder()
              url = this@with.url?.toBuilder()
            }
          }

        /** Header elements would be used to set HTTP headers. */
        @Serializable(with = TestScriptSetupActionOperationRequestHeaderSerializer::class)
        public data class RequestHeader(
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          override val id: kotlin.String? = null,
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          override val extension: List<Extension> = listOf(),
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          override val modifierExtension: List<Extension> = listOf(),
          /**
           * The HTTP header field e.g. "Accept".
           *
           * If header element is specified, then field is required.
           */
          public val `field`: String,
          /**
           * The value of the header e.g. "application/fhir+xml".
           *
           * If header element is specified, then value is required. No conversions will be done by
           * the test engine e.g. "xml" to "application/fhir+xml". The values will be set in HTTP
           * headers "as-is". Test engines do have to look for placeholders (${}) and replace the
           * variable placeholders with the variable values at runtime before sending the request.
           */
          public val `value`: String,
        ) : BackboneElement() {
          public fun toBuilder(): Builder =
            with(this) {
              Builder(`field`.toBuilder(), `value`.toBuilder()).apply {
                id = this@with.id
                extension = this@with.extension.map { it.toBuilder() }.toMutableList()
                modifierExtension =
                  this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              }
            }

          public class Builder(
            /**
             * The HTTP header field e.g. "Accept".
             *
             * If header element is specified, then field is required.
             */
            public var `field`: String.Builder,
            /**
             * The value of the header e.g. "application/fhir+xml".
             *
             * If header element is specified, then value is required. No conversions will be done
             * by the test engine e.g. "xml" to "application/fhir+xml". The values will be set in
             * HTTP headers "as-is". Test engines do have to look for placeholders (${}) and replace
             * the variable placeholders with the variable values at runtime before sending the
             * request.
             */
            public var `value`: String.Builder,
          ) {
            /**
             * Unique id for the element within a resource (for internal references). This may be
             * any string value that does not contain spaces.
             */
            public var id: kotlin.String? = null

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element. To make the use of extensions safe and manageable, there
             * is a strict set of governance applied to the definition and use of extensions. Though
             * any implementer can define an extension, there is a set of requirements that SHALL be
             * met as part of the definition of the extension.
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var extension: MutableList<Extension.Builder> = mutableListOf()

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element and that modifies the understanding of the element in which
             * it is contained and/or the understanding of the containing element's descendants.
             * Usually modifier elements provide negation or qualification. To make the use of
             * extensions safe and manageable, there is a strict set of governance applied to the
             * definition and use of extensions. Though any implementer can define an extension,
             * there is a set of requirements that SHALL be met as part of the definition of the
             * extension. Applications processing a resource are required to check for modifier
             * extensions.
             *
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
             * DomainResource (including cannot change the meaning of modifierExtension itself).
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

            public fun build(): RequestHeader =
              RequestHeader(
                id = id,
                extension = extension.map { it.build() },
                modifierExtension = modifierExtension.map { it.build() },
                `field` = `field`.build(),
                `value` = `value`.build(),
              )
          }
        }

        public class Builder(
          /**
           * Whether or not to implicitly send the request url in encoded format. The default is
           * true to match the standard RESTful client behavior. Set to false when communicating
           * with a server that does not support encoded url paths.
           */
          public var encodeRequestUrl: Boolean.Builder
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * Server interaction or operation type.
           *
           * See http://build.fhir.org/http.html for list of server interactions.
           */
          public var type: Coding.Builder? = null

          /**
           * The type of the resource. See http://build.fhir.org/resourcelist.html.
           *
           * If "url" element is specified, then "targetId", "params", and "resource" elements will
           * be ignored as "url" element will have everything needed for constructing the request
           * url. If "params" element is specified, then "targetId" element is ignored. For FHIR
           * operations that require a resource (e.g. "read" and "vread" operations), the "resource"
           * element must be specified when "params" element is specified. If "url" and "params"
           * elements are absent, then the request url will be constructed from "targetId" fixture
           * if present. For "read" operation, the resource and id values will be extracted from
           * "targetId" fixture and used to construct the url. For "vread" and "history" operations,
           * the versionId value will also be used.
           */
          public var resource: Enumeration<FHIRDefinedType>? = null

          /**
           * The label would be used for tracking/logging purposes by test engines.
           *
           * This has no impact on the verification itself.
           */
          public var label: String.Builder? = null

          /**
           * The description would be used by test engines for tracking and reporting purposes.
           *
           * This has no impact on the verification itself.
           */
          public var description: String.Builder? = null

          /**
           * The mime-type to use for RESTful operation in the 'Accept' header.
           *
           * If this is specified, then test engine shall set the 'Accept' header to the
           * corresponding value. If you'd like to explicitly set the 'Accept' to some other value
           * then use the 'requestHeader' element.
           */
          public var accept: Code.Builder? = null

          /**
           * The mime-type to use for RESTful operation in the 'Content-Type' header.
           *
           * If this is specified, then test engine shall set the 'Content-Type' header to the
           * corresponding value. If you'd like to explicitly set the 'Content-Type' to some other
           * value then use the 'requestHeader' element.
           */
          public var contentType: Code.Builder? = null

          /**
           * The server where the request message is destined for. Must be one of the server numbers
           * listed in TestScript.destination section.
           *
           * If multiple TestScript.destination elements are defined and operation.destination is
           * undefined, test engine will report an error as it cannot determine what destination to
           * use for the exchange.
           */
          public var destination: Integer.Builder? = null

          /**
           * The HTTP method the test engine MUST use for this operation regardless of any other
           * operation details.
           *
           * The primary purpose of the explicit HTTP method is support of HTTP POST method
           * invocation of the FHIR search. Other uses will include support of negative testing.
           */
          public var method: Enumeration<TestScriptRequestMethodCode>? = null

          /**
           * The server where the request message originates from. Must be one of the server numbers
           * listed in TestScript.origin section.
           *
           * If absent, test engine will send the message. When present, test engine will not send
           * the request message but will wait for the request message to be sent from this origin
           * server.
           */
          public var origin: Integer.Builder? = null

          /**
           * Path plus parameters after [type]. Used to set parts of the request URL explicitly.
           *
           * If "url" element is specified, then "targetId", "params", and "resource" elements will
           * be ignored as "url" element will have everything needed for constructing the request
           * url. If "params" element is specified, then "targetId" element is ignored. For FHIR
           * operations that require a resource (e.g. "read" and "vread" operations), the "resource"
           * element must be specified when "params" element is specified. If "url" and "params"
           * elements are absent, then the request url will be constructed from "targetId" fixture
           * if present. For "read" operation, the resource and id values will be extracted from
           * "targetId" fixture and used to construct the url. For "vread" and "history" operations,
           * the versionId value will also be used. Test engines would append whatever is specified
           * for "params" to the URL after the resource type without tampering with the string
           * (beyond encoding the URL for HTTP). The "params" element does not correspond exactly to
           * "search parameters". Nor is it the "path". It corresponds to the part of the URL that
           * comes after the [type] (when "resource" element is specified); e.g. It corresponds to
           * "/[id]/_history/[vid] {?_format=[mime-type]}" in the following operation: GET
           * [base]/[type]/[id]/_history/[vid] {?_format=[mime-type]} Test engines do have to look
           * for placeholders (${}) and replace the variable placeholders with the variable values
           * at runtime before sending the request.
           */
          public var params: String.Builder? = null

          /**
           * Header elements would be used to set HTTP headers.
           *
           * This gives control to test-script writers to set headers explicitly based on test
           * requirements. It will allow for testing using: - "If-Modified-Since" and
           * "If-None-Match" headers. See http://build.fhir.org/http.html#2.1.0.5.1 - "If-Match"
           * header. See http://build.fhir.org/http.html#2.1.0.11 - Conditional Create using
           * "If-None-Exist". See http://build.fhir.org/http.html#2.1.0.13.1 - Invalid
           * "Content-Type" header for negative testing. - etc.
           */
          public var requestHeader: MutableList<RequestHeader.Builder> = mutableListOf()

          /**
           * The fixture id (maybe new) to map to the request.
           *
           * If a requestId is supplied, then the resulting request (both headers and body) is
           * mapped to the fixture ID (which may be entirely new and previously undeclared)
           * designated by "requestId". If requestId is not specified, it is the test engine's
           * responsibility to store the request and use it as the requestId in subsequent
           * assertions when assertion path and/or headerField is specified, direction is equal to
           * request, and the requestId in not specified.
           */
          public var requestId: Id.Builder? = null

          /**
           * The fixture id (maybe new) to map to the response.
           *
           * If a responseId is supplied, and the server responds, then the resulting response (both
           * headers and body) is mapped to the fixture ID (which may be entirely new and previously
           * undeclared) designated by "responseId". If responseId is not specified, it is the test
           * engine's responsibility to store the response and use it as the responseId in
           * subsequent assertions when assertion path and/or headerField is specified and the
           * responseId is not specified.
           */
          public var responseId: Id.Builder? = null

          /** The id of the fixture used as the body of a PUT or POST request. */
          public var sourceId: Id.Builder? = null

          /**
           * Id of fixture used for extracting the [id], [type], and [vid] for GET requests.
           *
           * If "url" element is specified, then "targetId", "params", and "resource" elements will
           * be ignored as "url" element will have everything needed for constructing the request
           * url. If "params" element is specified, then "targetId" element is ignored. For FHIR
           * operations that require a resource (e.g. "read" and "vread" operations), the "resource"
           * element must be specified when "params" element is specified. If "url" and "params"
           * elements are absent, then the request url will be constructed from "targetId" fixture
           * if present. For "read" operation, the resource and id values will be extracted from
           * "targetId" fixture and used to construct the url. For "vread" and "history" operations,
           * the versionId value will also be used.
           */
          public var targetId: Id.Builder? = null

          /**
           * Complete request URL.
           *
           * Used to set the request URL explicitly. If "url" element is defined, then "targetId",
           * "resource", and "params" elements will be ignored. Test engines would use whatever is
           * specified in "url" without tampering with the string (beyond encoding the URL for
           * HTTP). Test engines do have to look for placeholders (${}) and replace the variable
           * placeholders with the variable values at runtime before sending the request.
           */
          public var url: String.Builder? = null

          public fun build(): Operation =
            Operation(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              type = type?.build(),
              resource = resource,
              label = label?.build(),
              description = description?.build(),
              accept = accept?.build(),
              contentType = contentType?.build(),
              destination = destination?.build(),
              encodeRequestUrl = encodeRequestUrl.build(),
              method = method,
              origin = origin?.build(),
              params = params?.build(),
              requestHeader = requestHeader.map { it.build() },
              requestId = requestId?.build(),
              responseId = responseId?.build(),
              sourceId = sourceId?.build(),
              targetId = targetId?.build(),
              url = url?.build(),
            )
        }
      }

      /**
       * Evaluates the results of previous operations to determine if the server under test behaves
       * appropriately.
       */
      @Serializable(with = TestScriptSetupActionAssertSerializer::class)
      public data class Assert(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * The label would be used for tracking/logging purposes by test engines.
         *
         * This has no impact on the verification itself.
         */
        public val label: String? = null,
        /**
         * The description would be used by test engines for tracking and reporting purposes.
         *
         * This has no impact on the verification itself.
         */
        public val description: String? = null,
        /**
         * The direction to use for the assertion.
         *
         * If the direction is specified as "response" (the default), then the processing of this
         * assert is against the received response message. If the direction is specified as
         * "request", then the processing of this assert is against the sent request message.
         */
        public val direction: Enumeration<AssertionDirectionType>? = null,
        /**
         * Id of the source fixture used as the contents to be evaluated by either the
         * "source/expression" or "sourceId/path" definition.
         */
        public val compareToSourceId: String? = null,
        /**
         * The FHIRPath expression to evaluate against the source fixture. When compareToSourceId is
         * defined, either compareToSourceExpression or compareToSourcePath must be defined, but not
         * both.
         *
         * Thefhirpath expression to be evaluated against the expected fixture to compare to.
         * Ignored if "assert.value" is used. The evaluation will be done before the assertion is
         * evaluated.
         */
        public val compareToSourceExpression: String? = null,
        /**
         * XPath or JSONPath expression to evaluate against the source fixture. When
         * compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath
         * must be defined, but not both.
         *
         * The XPath or JSONPath expression to be evaluated against the expected fixture to compare
         * to. Ignored if "assert.value" is used. The evaluation will be done before the assertion
         * is evaluated.
         */
        public val compareToSourcePath: String? = null,
        /**
         * The mime-type contents to compare against the request or response message 'Content-Type'
         * header.
         *
         * If this is specified, then test engine shall confirm that the content-type of the last
         * operation's headers is set to this value. If "assert.sourceId" element is specified, then
         * the evaluation will be done against the headers mapped to that sourceId (and not the last
         * operation's headers). If you'd like to have more control over the string, then use
         * 'assert.headerField' instead.
         */
        public val contentType: Code? = null,
        /**
         * The FHIRPath expression to be evaluated against the request or response message
         * contents - HTTP headers and payload.
         *
         * If both "expression" and a "fixtureId" are specified, then the expression will be
         * evaluated against the request or response body mapped to the fixtureId. If "expression"
         * is specified and a "fixtureId" is not, then the expression will be evaluated against the
         * response body of the last operation. Test engines are to store the request and response
         * body and headers of the last operation at all times for subsequent assertions.
         */
        public val expression: String? = null,
        /**
         * The HTTP header field name e.g. 'Location'.
         *
         * If "headerField" is specified then "value" must be specified. If "sourceId" is not
         * specified, then "headerField" will be evaluated against the last operation's response
         * headers. Test engines are to keep track of the last operation's response body and
         * response headers.
         */
        public val headerField: String? = null,
        /**
         * The ID of a fixture. Asserts that the response contains at a minimum the fixture
         * specified by minimumId.
         *
         * Asserts that the response contains all the element/content in another fixture pointed to
         * by minimumId. This can be a statically defined fixture or one that is dynamically set via
         * responseId.
         */
        public val minimumId: String? = null,
        /**
         * Whether or not the test execution performs validation on the bundle navigation links.
         *
         * Asserts that the Bundle contains first, last, and next links.
         */
        public val navigationLinks: Boolean? = null,
        /**
         * The operator type defines the conditional behavior of the assert. If not defined, the
         * default is equals.
         *
         * Operators are useful especially for negative testing. If operator is not specified, then
         * the "equals" operator is assumed; e.g. ```<code> <assert> <operator value="in" />
         * <responseCode value="200,201,204" /> </assert> <assert> <operator value="notEquals" />
         * <response value="okay"/> </assert> <assert> <operator value="greaterThan" />
         * <responseHeader> <field value="Content-Length" /> <value value="0" /> </responseHeader/>
         * </assert> </code> ```.
         */
        public val `operator`: Enumeration<AssertionOperatorType>? = null,
        /**
         * The XPath or JSONPath expression to be evaluated against the fixture representing the
         * response received from server.
         *
         * If both "path" and a "fixtureId" are specified, then the path will be evaluated against
         * the request or response body mapped to the fixtureId. If "path" is specified and a
         * "fixtureId" is not, then the path will be evaluated against the response body of the last
         * operation. Test engines are to store the request and response body and headers of the
         * last operation at all times for subsequent assertions.
         */
        public val path: String? = null,
        /**
         * The request method or HTTP operation code to compare against that used by the client
         * system under test.
         *
         * If "requestMethod" is specified then it will be used in place of "value". The
         * "requestMethod" will evaluate against the last operation's request HTTP operation.
         */
        public val requestMethod: Enumeration<TestScriptRequestMethodCode>? = null,
        /**
         * The value to use in a comparison against the request URL path string.
         *
         * If "requestURL" is specified then it will be used in place of "value". The "requestURL"
         * will evaluate against the last operation's full request URL path string.
         */
        public val requestURL: String? = null,
        /**
         * The type of the resource. See http://build.fhir.org/resourcelist.html.
         *
         * This will be expected resource type in response body e.g. in read, vread, search, etc.
         * See http://build.fhir.org/resourcelist.html for complete list of resource types; e.g.
         * <assert > <resourceType value="Patient" </assert>.
         */
        public val resource: Enumeration<FHIRDefinedType>? = null,
        /**
         * okay | created | noContent | notModified | bad | forbidden | notFound | methodNotAllowed
         * | conflict | gone | preconditionFailed | unprocessable.
         *
         * This is a shorter way of achieving similar verifications via "assert.responseCode". If
         * you need more control, then use "assert.responseCode" e.g. <assert> <contentType
         * value="json" /> <response value="okay"/> </assert>.
         */
        public val response: Enumeration<AssertionResponseTypes>? = null,
        /**
         * The value of the HTTP response code to be tested.
         *
         * To be used with "operator" attribute value. Asserts that the response code equals this
         * value if "operator" is not specified. If the operator is "in" or "notIn" then the
         * responseCode would be a comma-separated list of values e.g. "200,201". Otherwise, it's
         * expected to be a numeric value. If "fixture" is not specified, then the "responseBodyId"
         * value of the last operation is assumed.
         */
        public val responseCode: String? = null,
        /**
         * Fixture to evaluate the XPath/JSONPath expression or the headerField against.
         *
         * This can be a statically defined fixture (at the top of the testscript) or a dynamically
         * set fixture created by responseId of the action.operation element.
         */
        public val sourceId: Id? = null,
        /**
         * The ID of the Profile to validate against.
         *
         * The ID of a Profile fixture. Asserts that the response is valid according to the Profile
         * specified by validateProfileId.
         */
        public val validateProfileId: Id? = null,
        /**
         * The value to compare to.
         *
         * The string-representation of a number, string, or boolean that is expected. Test engines
         * do have to look for placeholders (${}) and replace the variable placeholders with the
         * variable values at runtime before comparing this value to the actual value.
         */
        public val `value`: String? = null,
        /**
         * Whether or not the test execution will produce a warning only on error for this assert.
         *
         * If this element is specified and it is true, then assertion failures can be logged by
         * test engine but should not stop the test script execution from proceeding. There are
         * likely cases where the spec is not clear on what should happen. If the spec says
         * something is optional (maybe a response header for example), but a server doesn’t do it,
         * we could choose to issue a warning.
         */
        public val warningOnly: Boolean,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(warningOnly.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              label = this@with.label?.toBuilder()
              description = this@with.description?.toBuilder()
              direction = this@with.direction
              compareToSourceId = this@with.compareToSourceId?.toBuilder()
              compareToSourceExpression = this@with.compareToSourceExpression?.toBuilder()
              compareToSourcePath = this@with.compareToSourcePath?.toBuilder()
              contentType = this@with.contentType?.toBuilder()
              expression = this@with.expression?.toBuilder()
              headerField = this@with.headerField?.toBuilder()
              minimumId = this@with.minimumId?.toBuilder()
              navigationLinks = this@with.navigationLinks?.toBuilder()
              `operator` = this@with.`operator`
              path = this@with.path?.toBuilder()
              requestMethod = this@with.requestMethod
              requestURL = this@with.requestURL?.toBuilder()
              resource = this@with.resource
              response = this@with.response
              responseCode = this@with.responseCode?.toBuilder()
              sourceId = this@with.sourceId?.toBuilder()
              validateProfileId = this@with.validateProfileId?.toBuilder()
              `value` = this@with.`value`?.toBuilder()
            }
          }

        public class Builder(
          /**
           * Whether or not the test execution will produce a warning only on error for this assert.
           *
           * If this element is specified and it is true, then assertion failures can be logged by
           * test engine but should not stop the test script execution from proceeding. There are
           * likely cases where the spec is not clear on what should happen. If the spec says
           * something is optional (maybe a response header for example), but a server doesn’t do
           * it, we could choose to issue a warning.
           */
          public var warningOnly: Boolean.Builder
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and manageable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * The label would be used for tracking/logging purposes by test engines.
           *
           * This has no impact on the verification itself.
           */
          public var label: String.Builder? = null

          /**
           * The description would be used by test engines for tracking and reporting purposes.
           *
           * This has no impact on the verification itself.
           */
          public var description: String.Builder? = null

          /**
           * The direction to use for the assertion.
           *
           * If the direction is specified as "response" (the default), then the processing of this
           * assert is against the received response message. If the direction is specified as
           * "request", then the processing of this assert is against the sent request message.
           */
          public var direction: Enumeration<AssertionDirectionType>? = null

          /**
           * Id of the source fixture used as the contents to be evaluated by either the
           * "source/expression" or "sourceId/path" definition.
           */
          public var compareToSourceId: String.Builder? = null

          /**
           * The FHIRPath expression to evaluate against the source fixture. When compareToSourceId
           * is defined, either compareToSourceExpression or compareToSourcePath must be defined,
           * but not both.
           *
           * Thefhirpath expression to be evaluated against the expected fixture to compare to.
           * Ignored if "assert.value" is used. The evaluation will be done before the assertion is
           * evaluated.
           */
          public var compareToSourceExpression: String.Builder? = null

          /**
           * XPath or JSONPath expression to evaluate against the source fixture. When
           * compareToSourceId is defined, either compareToSourceExpression or compareToSourcePath
           * must be defined, but not both.
           *
           * The XPath or JSONPath expression to be evaluated against the expected fixture to
           * compare to. Ignored if "assert.value" is used. The evaluation will be done before the
           * assertion is evaluated.
           */
          public var compareToSourcePath: String.Builder? = null

          /**
           * The mime-type contents to compare against the request or response message
           * 'Content-Type' header.
           *
           * If this is specified, then test engine shall confirm that the content-type of the last
           * operation's headers is set to this value. If "assert.sourceId" element is specified,
           * then the evaluation will be done against the headers mapped to that sourceId (and not
           * the last operation's headers). If you'd like to have more control over the string, then
           * use 'assert.headerField' instead.
           */
          public var contentType: Code.Builder? = null

          /**
           * The FHIRPath expression to be evaluated against the request or response message
           * contents - HTTP headers and payload.
           *
           * If both "expression" and a "fixtureId" are specified, then the expression will be
           * evaluated against the request or response body mapped to the fixtureId. If "expression"
           * is specified and a "fixtureId" is not, then the expression will be evaluated against
           * the response body of the last operation. Test engines are to store the request and
           * response body and headers of the last operation at all times for subsequent assertions.
           */
          public var expression: String.Builder? = null

          /**
           * The HTTP header field name e.g. 'Location'.
           *
           * If "headerField" is specified then "value" must be specified. If "sourceId" is not
           * specified, then "headerField" will be evaluated against the last operation's response
           * headers. Test engines are to keep track of the last operation's response body and
           * response headers.
           */
          public var headerField: String.Builder? = null

          /**
           * The ID of a fixture. Asserts that the response contains at a minimum the fixture
           * specified by minimumId.
           *
           * Asserts that the response contains all the element/content in another fixture pointed
           * to by minimumId. This can be a statically defined fixture or one that is dynamically
           * set via responseId.
           */
          public var minimumId: String.Builder? = null

          /**
           * Whether or not the test execution performs validation on the bundle navigation links.
           *
           * Asserts that the Bundle contains first, last, and next links.
           */
          public var navigationLinks: Boolean.Builder? = null

          /**
           * The operator type defines the conditional behavior of the assert. If not defined, the
           * default is equals.
           *
           * Operators are useful especially for negative testing. If operator is not specified,
           * then the "equals" operator is assumed; e.g. ```<code> <assert> <operator value="in" />
           * <responseCode value="200,201,204" /> </assert> <assert> <operator value="notEquals" />
           * <response value="okay"/> </assert> <assert> <operator value="greaterThan" />
           * <responseHeader> <field value="Content-Length" /> <value value="0" />
           * </responseHeader/> </assert> </code> ```.
           */
          public var `operator`: Enumeration<AssertionOperatorType>? = null

          /**
           * The XPath or JSONPath expression to be evaluated against the fixture representing the
           * response received from server.
           *
           * If both "path" and a "fixtureId" are specified, then the path will be evaluated against
           * the request or response body mapped to the fixtureId. If "path" is specified and a
           * "fixtureId" is not, then the path will be evaluated against the response body of the
           * last operation. Test engines are to store the request and response body and headers of
           * the last operation at all times for subsequent assertions.
           */
          public var path: String.Builder? = null

          /**
           * The request method or HTTP operation code to compare against that used by the client
           * system under test.
           *
           * If "requestMethod" is specified then it will be used in place of "value". The
           * "requestMethod" will evaluate against the last operation's request HTTP operation.
           */
          public var requestMethod: Enumeration<TestScriptRequestMethodCode>? = null

          /**
           * The value to use in a comparison against the request URL path string.
           *
           * If "requestURL" is specified then it will be used in place of "value". The "requestURL"
           * will evaluate against the last operation's full request URL path string.
           */
          public var requestURL: String.Builder? = null

          /**
           * The type of the resource. See http://build.fhir.org/resourcelist.html.
           *
           * This will be expected resource type in response body e.g. in read, vread, search, etc.
           * See http://build.fhir.org/resourcelist.html for complete list of resource types; e.g.
           * <assert > <resourceType value="Patient" </assert>.
           */
          public var resource: Enumeration<FHIRDefinedType>? = null

          /**
           * okay | created | noContent | notModified | bad | forbidden | notFound |
           * methodNotAllowed | conflict | gone | preconditionFailed | unprocessable.
           *
           * This is a shorter way of achieving similar verifications via "assert.responseCode". If
           * you need more control, then use "assert.responseCode" e.g. <assert> <contentType
           * value="json" /> <response value="okay"/> </assert>.
           */
          public var response: Enumeration<AssertionResponseTypes>? = null

          /**
           * The value of the HTTP response code to be tested.
           *
           * To be used with "operator" attribute value. Asserts that the response code equals this
           * value if "operator" is not specified. If the operator is "in" or "notIn" then the
           * responseCode would be a comma-separated list of values e.g. "200,201". Otherwise, it's
           * expected to be a numeric value. If "fixture" is not specified, then the
           * "responseBodyId" value of the last operation is assumed.
           */
          public var responseCode: String.Builder? = null

          /**
           * Fixture to evaluate the XPath/JSONPath expression or the headerField against.
           *
           * This can be a statically defined fixture (at the top of the testscript) or a
           * dynamically set fixture created by responseId of the action.operation element.
           */
          public var sourceId: Id.Builder? = null

          /**
           * The ID of the Profile to validate against.
           *
           * The ID of a Profile fixture. Asserts that the response is valid according to the
           * Profile specified by validateProfileId.
           */
          public var validateProfileId: Id.Builder? = null

          /**
           * The value to compare to.
           *
           * The string-representation of a number, string, or boolean that is expected. Test
           * engines do have to look for placeholders (${}) and replace the variable placeholders
           * with the variable values at runtime before comparing this value to the actual value.
           */
          public var `value`: String.Builder? = null

          public fun build(): Assert =
            Assert(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              label = label?.build(),
              description = description?.build(),
              direction = direction,
              compareToSourceId = compareToSourceId?.build(),
              compareToSourceExpression = compareToSourceExpression?.build(),
              compareToSourcePath = compareToSourcePath?.build(),
              contentType = contentType?.build(),
              expression = expression?.build(),
              headerField = headerField?.build(),
              minimumId = minimumId?.build(),
              navigationLinks = navigationLinks?.build(),
              `operator` = `operator`,
              path = path?.build(),
              requestMethod = requestMethod,
              requestURL = requestURL?.build(),
              resource = resource,
              response = response,
              responseCode = responseCode?.build(),
              sourceId = sourceId?.build(),
              validateProfileId = validateProfileId?.build(),
              `value` = `value`?.build(),
              warningOnly = warningOnly.build(),
            )
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

        /** The operation to perform. */
        public var operation: Operation.Builder? = null

        /**
         * Evaluates the results of previous operations to determine if the server under test
         * behaves appropriately.
         *
         * In order to evaluate an assertion, the request, response, and results of the most
         * recently executed operation must always be maintained by the test engine.
         */
        public var assert: Assert.Builder? = null

        public fun build(): Action =
          Action(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            operation = operation?.build(),
            assert = assert?.build(),
          )
      }
    }

    public class Builder(
      /**
       * Action would contain either an operation or an assertion.
       *
       * An action should contain either an operation or an assertion but not both. It can contain
       * any number of variables.
       */
      public var action: MutableList<Action.Builder>
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

      public fun build(): Setup =
        Setup(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          action = action.map { it.build() },
        )
    }
  }

  /** A test in this script. */
  @Serializable(with = TestScriptTestSerializer::class)
  public data class Test(
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
    /** The name of this test used for tracking/logging purposes by test engines. */
    public val name: String? = null,
    /** A short description of the test used by test engines for tracking and reporting purposes. */
    public val description: String? = null,
    /**
     * Action would contain either an operation or an assertion.
     *
     * An action should contain either an operation or an assertion but not both. It can contain any
     * number of variables.
     */
    public val action: List<Action>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(action.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          name = this@with.name?.toBuilder()
          description = this@with.description?.toBuilder()
        }
      }

    /** Action would contain either an operation or an assertion. */
    @Serializable(with = TestScriptTestActionSerializer::class)
    public data class Action(
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
      /** An operation would involve a REST request to a server. */
      public val operation: Setup.Action.Operation? = null,
      /**
       * Evaluates the results of previous operations to determine if the server under test behaves
       * appropriately.
       *
       * In order to evaluate an assertion, the request, response, and results of the most recently
       * executed operation must always be maintained by the test engine.
       */
      public val assert: Setup.Action.Assert? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            operation = this@with.operation?.toBuilder()
            assert = this@with.assert?.toBuilder()
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

        /** An operation would involve a REST request to a server. */
        public var operation: Setup.Action.Operation.Builder? = null

        /**
         * Evaluates the results of previous operations to determine if the server under test
         * behaves appropriately.
         *
         * In order to evaluate an assertion, the request, response, and results of the most
         * recently executed operation must always be maintained by the test engine.
         */
        public var assert: Setup.Action.Assert.Builder? = null

        public fun build(): Action =
          Action(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            operation = operation?.build(),
            assert = assert?.build(),
          )
      }
    }

    public class Builder(
      /**
       * Action would contain either an operation or an assertion.
       *
       * An action should contain either an operation or an assertion but not both. It can contain
       * any number of variables.
       */
      public var action: MutableList<Action.Builder>
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

      /** The name of this test used for tracking/logging purposes by test engines. */
      public var name: String.Builder? = null

      /**
       * A short description of the test used by test engines for tracking and reporting purposes.
       */
      public var description: String.Builder? = null

      public fun build(): Test =
        Test(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name?.build(),
          description = description?.build(),
          action = action.map { it.build() },
        )
    }
  }

  /**
   * A series of operations required to clean up after all the tests are executed (successfully or
   * otherwise).
   */
  @Serializable(with = TestScriptTeardownSerializer::class)
  public data class Teardown(
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
     * The teardown action will only contain an operation.
     *
     * An action should contain either an operation or an assertion but not both. It can contain any
     * number of variables.
     */
    public val action: List<Action>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(action.map { it.toBuilder() }.toMutableList()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    /** The teardown action will only contain an operation. */
    @Serializable(with = TestScriptTeardownActionSerializer::class)
    public data class Action(
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
      /** An operation would involve a REST request to a server. */
      public val operation: Setup.Action.Operation,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(operation.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** An operation would involve a REST request to a server. */
        public var operation: Setup.Action.Operation.Builder
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

        public fun build(): Action =
          Action(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            operation = operation.build(),
          )
      }
    }

    public class Builder(
      /**
       * The teardown action will only contain an operation.
       *
       * An action should contain either an operation or an assertion but not both. It can contain
       * any number of variables.
       */
      public var action: MutableList<Action.Builder>
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

      public fun build(): Teardown =
        Teardown(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          action = action.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * An absolute URI that is used to identify this test script when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this test script is (or will be) published. This URL can be the target of a
     * canonical reference. It SHALL remain the same when the test script is stored on different
     * servers.
     *
     * Can be a urn:uuid: or a urn:oid: but real http: addresses are preferred. Multiple instances
     * may share the same URL if they have a distinct version.
     *
     * The determination of when to create a new version of a resource (same url, new version) vs.
     * defining a new artifact is up to the author. Considerations for making this decision are
     * found in [Technical and Business Versions](resource.html#versions).
     *
     * In some cases, the resource can no longer be found at the stated url, but the url itself
     * cannot change. Implementations can use the [meta.source](resource.html#meta) element to
     * indicate where the current master source of the resource can be found.
     */
    public var url: Uri.Builder,
    /**
     * A natural language name identifying the test script. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder,
    /**
     * The status of this test script. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of test scripts that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
     */
    override var id: kotlin.String? = null

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
     * A formal identifier that is used to identify this test script when it is represented in other
     * formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this test script outside of FHIR, where it is not possible
     * to use the logical URI.
     */
    public var identifier: Identifier.Builder? = null

    /**
     * The identifier that is used to identify this version of the test script when it is referenced
     * in a specification, model, design or instance. This is an arbitrary value managed by the test
     * script author and is not expected to be globally unique. For example, it might be a timestamp
     * (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that
     * versions can be placed in a lexicographical sequence.
     *
     * There may be different test script instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the test script with the format [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the test script.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * A Boolean value to indicate that this test script is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of test scripts that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the test script was published. The date must change when
     * the business version changes and it must change if the status code changes. In addition, it
     * should change when the substantive content of the test script changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the test script. Additional specific dates may be added as
     * extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the test script.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the test
     * script is the organization or individual primarily responsible for the maintenance and upkeep
     * of the test script. This is not necessarily the same individual or organization that
     * developed and initially authored the content. The publisher is the primary point of contact
     * for questions or issues with the test script. This item SHOULD be populated unless the
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
     * A free text natural language description of the test script from a consumer's perspective.
     *
     * This description can be used to capture details such as why the test script was built,
     * comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the test script as
     * conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless the
     * information is available from context (e.g. the language of the test script is presumed to be
     * the predominant language in the place the test script was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate test script instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the test script is intended to be used.
     *
     * It may be possible for the test script to be used in jurisdictions other than those for which
     * it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this test script is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the test script. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * test script.
     */
    public var purpose: Markdown.Builder? = null

    /**
     * A copyright statement relating to the test script and/or its contents. Copyright statements
     * are generally legal restrictions on the use and publishing of the test script.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * An abstract server used in operations within this test script in the origin element.
     *
     * The purpose of this element is to define the profile of an origin element used elsewhere in
     * the script. Test engines could then use the origin-profile mapping to offer a filtered list
     * of test systems that can serve as the sender for the interaction.
     */
    public var origin: MutableList<Origin.Builder> = mutableListOf()

    /**
     * An abstract server used in operations within this test script in the destination element.
     *
     * The purpose of this element is to define the profile of a destination element used elsewhere
     * in the script. Test engines could then use the destination-profile mapping to offer a
     * filtered list of test systems that can serve as the receiver for the interaction.
     */
    public var destination: MutableList<Destination.Builder> = mutableListOf()

    /**
     * The required capability must exist and are assumed to function correctly on the FHIR server
     * being tested.
     */
    public var metadata: Metadata.Builder? = null

    /**
     * Fixture in the test script - by reference (uri). All fixtures are required for the test
     * script to execute.
     */
    public var fixture: MutableList<Fixture.Builder> = mutableListOf()

    /**
     * Reference to the profile to be used for validation.
     *
     * See http://build.fhir.org/resourcelist.html for complete list of resource types.
     */
    public var profile: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Variable is set based either on element value in response body or on header field value in
     * the response headers.
     *
     * Variables would be set based either on XPath/JSONPath expressions against fixtures (static
     * and response), or headerField evaluations against response headers. If variable evaluates to
     * nodelist or anything other than a primitive value, then test engine would report an error.
     * Variables would be used to perform clean replacements in "operation.params",
     * "operation.requestHeader.value", and "operation.url" element values during operation calls
     * and in "assert.value" during assertion evaluations. This limits the places that test engines
     * would need to look for placeholders "${}". Variables are scoped to the whole script. They are
     * NOT evaluated at declaration. They are evaluated by test engine when used for substitutions
     * in "operation.params", "operation.requestHeader.value", and "operation.url" element values
     * during operation calls and in "assert.value" during assertion evaluations. See example
     * testscript-search.xml.
     */
    public var variable: MutableList<Variable.Builder> = mutableListOf()

    /** A series of required setup operations before tests are executed. */
    public var setup: Setup.Builder? = null

    /** A test in this script. */
    public var test: MutableList<Test.Builder> = mutableListOf()

    /**
     * A series of operations required to clean up after all the tests are executed (successfully or
     * otherwise).
     */
    public var teardown: Teardown.Builder? = null

    override fun build(): TestScript =
      TestScript(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url.build(),
        identifier = identifier?.build(),
        version = version?.build(),
        name = name.build(),
        title = title?.build(),
        status = status,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        origin = origin.map { it.build() },
        destination = destination.map { it.build() },
        metadata = metadata?.build(),
        fixture = fixture.map { it.build() },
        profile = profile.map { it.build() },
        variable = variable.map { it.build() },
        setup = setup?.build(),
        test = test.map { it.build() },
        teardown = teardown?.build(),
      )
  }

  /** The allowable request method or HTTP operation codes. */
  public enum class TestScriptRequestMethodCode(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Delete("delete", "http://hl7.org/fhir/http-operations", "DELETE"),
    Get("get", "http://hl7.org/fhir/http-operations", "GET"),
    Options("options", "http://hl7.org/fhir/http-operations", "OPTIONS"),
    Patch("patch", "http://hl7.org/fhir/http-operations", "PATCH"),
    Post("post", "http://hl7.org/fhir/http-operations", "POST"),
    Put("put", "http://hl7.org/fhir/http-operations", "PUT"),
    Head("head", "http://hl7.org/fhir/http-operations", "HEAD");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): TestScriptRequestMethodCode =
        when (code) {
          "delete" -> Delete
          "get" -> Get
          "options" -> Options
          "patch" -> Patch
          "post" -> Post
          "put" -> Put
          "head" -> Head
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum TestScriptRequestMethodCode"
            )
        }
    }
  }

  /** The type of direction to use for assertion. */
  public enum class AssertionDirectionType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Response("response", "http://hl7.org/fhir/assert-direction-codes", "response"),
    Request("request", "http://hl7.org/fhir/assert-direction-codes", "request");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AssertionDirectionType =
        when (code) {
          "response" -> Response
          "request" -> Request
          else ->
            throw IllegalArgumentException("Unknown code $code for enum AssertionDirectionType")
        }
    }
  }

  /** The type of operator to use for assertion. */
  public enum class AssertionOperatorType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Equals("equals", "http://hl7.org/fhir/assert-operator-codes", "equals"),
    NotEquals("notEquals", "http://hl7.org/fhir/assert-operator-codes", "notEquals"),
    In("in", "http://hl7.org/fhir/assert-operator-codes", "in"),
    NotIn("notIn", "http://hl7.org/fhir/assert-operator-codes", "notIn"),
    GreaterThan("greaterThan", "http://hl7.org/fhir/assert-operator-codes", "greaterThan"),
    LessThan("lessThan", "http://hl7.org/fhir/assert-operator-codes", "lessThan"),
    Empty("empty", "http://hl7.org/fhir/assert-operator-codes", "empty"),
    NotEmpty("notEmpty", "http://hl7.org/fhir/assert-operator-codes", "notEmpty"),
    Contains("contains", "http://hl7.org/fhir/assert-operator-codes", "contains"),
    NotContains("notContains", "http://hl7.org/fhir/assert-operator-codes", "notContains"),
    Eval("eval", "http://hl7.org/fhir/assert-operator-codes", "evaluate");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AssertionOperatorType =
        when (code) {
          "equals" -> Equals
          "notEquals" -> NotEquals
          "in" -> In
          "notIn" -> NotIn
          "greaterThan" -> GreaterThan
          "lessThan" -> LessThan
          "empty" -> Empty
          "notEmpty" -> NotEmpty
          "contains" -> Contains
          "notContains" -> NotContains
          "eval" -> Eval
          else ->
            throw IllegalArgumentException("Unknown code $code for enum AssertionOperatorType")
        }
    }
  }

  /** The type of response code to use for assertion. */
  public enum class AssertionResponseTypes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Okay("okay", "http://hl7.org/fhir/assert-response-code-types", "okay"),
    Created("created", "http://hl7.org/fhir/assert-response-code-types", "created"),
    NoContent("noContent", "http://hl7.org/fhir/assert-response-code-types", "noContent"),
    NotModified("notModified", "http://hl7.org/fhir/assert-response-code-types", "notModified"),
    Bad("bad", "http://hl7.org/fhir/assert-response-code-types", "bad"),
    Forbidden("forbidden", "http://hl7.org/fhir/assert-response-code-types", "forbidden"),
    NotFound("notFound", "http://hl7.org/fhir/assert-response-code-types", "notFound"),
    MethodNotAllowed(
      "methodNotAllowed",
      "http://hl7.org/fhir/assert-response-code-types",
      "methodNotAllowed",
    ),
    Conflict("conflict", "http://hl7.org/fhir/assert-response-code-types", "conflict"),
    Gone("gone", "http://hl7.org/fhir/assert-response-code-types", "gone"),
    PreconditionFailed(
      "preconditionFailed",
      "http://hl7.org/fhir/assert-response-code-types",
      "preconditionFailed",
    ),
    Unprocessable(
      "unprocessable",
      "http://hl7.org/fhir/assert-response-code-types",
      "unprocessable",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AssertionResponseTypes =
        when (code) {
          "okay" -> Okay
          "created" -> Created
          "noContent" -> NoContent
          "notModified" -> NotModified
          "bad" -> Bad
          "forbidden" -> Forbidden
          "notFound" -> NotFound
          "methodNotAllowed" -> MethodNotAllowed
          "conflict" -> Conflict
          "gone" -> Gone
          "preconditionFailed" -> PreconditionFailed
          "unprocessable" -> Unprocessable
          else ->
            throw IllegalArgumentException("Unknown code $code for enum AssertionResponseTypes")
        }
    }
  }
}

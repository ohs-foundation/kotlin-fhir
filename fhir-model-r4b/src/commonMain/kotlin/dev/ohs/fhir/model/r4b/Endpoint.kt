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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.EndpointSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The technical details of an endpoint that can be used for electronic services, such as for web
 * services providing XDS.b or a REST endpoint for another FHIR server. This may include any
 * security context information.
 */
@Serializable(with = EndpointSerializer::class)
@SerialName("Endpoint")
public data class Endpoint(
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
   * Identifier for the organization that is used to identify the endpoint across multiple disparate
   * systems.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * active | suspended | error | off | test.
   *
   * This element is labeled as a modifier because the status contains codes that mark the endpoint
   * as not currently valid.
   */
  public val status: Enumeration<EndpointStatus>,
  /**
   * A coded value that represents the technical details of the usage of this endpoint, such as what
   * WSDLs should be used in what way. (e.g. XDS.b/DICOM/cds-hook).
   *
   * For additional connectivity details for the protocol, extensions will be used at this point, as
   * in the XDS example.
   */
  public val connectionType: Coding,
  /** A friendly name that this endpoint can be referred to with. */
  public val name: String? = null,
  /**
   * The organization that manages this endpoint (even if technically another organization is
   * hosting this in the cloud, it is the organization associated with the data).
   *
   * This property is not typically used when searching for Endpoint resources for usage. The
   * typical usage is via the reference from an applicable Organization/Location/Practitioner
   * resource, which is where the context is provided. Multiple Locations may reference a single
   * endpoint, and don't have to be within the same organization resource, but most likely within
   * the same organizational hierarchy.
   */
  public val managingOrganization: Reference? = null,
  /**
   * Contact details for a human to contact about the subscription. The primary use of this for
   * system administrator troubleshooting.
   */
  public val contact: List<ContactPoint> = listOf(),
  /** The interval during which the endpoint is expected to be operational. */
  public val period: Period? = null,
  /**
   * The payload type describes the acceptable content that can be communicated on the endpoint.
   *
   * The payloadFormat describes the serialization format of the data, where the payloadType
   * indicates the specific document/schema that is being transferred; e.g. DischargeSummary or
   * CarePlan.
   */
  public val payloadType: List<CodeableConcept>,
  /**
   * The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If the
   * mime type is not specified, then the sender could send any content (including no content
   * depending on the connectionType).
   *
   * Sending the payload has obvious security consequences. The server is responsible for ensuring
   * that the content is appropriately secured.
   */
  public val payloadMimeType: List<Code> = listOf(),
  /**
   * The uri that describes the actual end-point to connect to.
   *
   * For rest-hook, and websocket, the end-point must be an http: or https: URL; for email, a
   * mailto: url, for sms, a tel: url, and for message the endpoint can be in any form of url the
   * server understands (usually, http: or mllp:). The URI is allowed to be relative; in which case,
   * it is relative to the server end-point (since there may be more than one, clients should avoid
   * using relative URIs)
   *
   * This address will be to the service base, without any parameters, or sub-services or resources
   * tacked on.
   *
   * E.g. for a WADO-RS endpoint, the url should be "https://pacs.hospital.org/wado-rs"
   *
   * and not
   * "https://pacs.hospital.org/wado-rs/studies/1.2.250.1.59.40211.12345678.678910/series/1.2.250.1.59.40211.789001276.14556172.67789/instances/...".
   */
  public val address: Url,
  /**
   * Additional headers / information to send as part of the notification.
   *
   * Exactly what these mean depends on the channel type. The can convey additional information to
   * the recipient and/or meet security requirements.
   */
  public val `header`: List<String> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          connectionType.toBuilder(),
          payloadType.map { it.toBuilder() }.toMutableList(),
          address.toBuilder(),
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
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          name = this@with.name?.toBuilder()
          managingOrganization = this@with.managingOrganization?.toBuilder()
          contact = this@with.contact.map { it.toBuilder() }.toMutableList()
          period = this@with.period?.toBuilder()
          payloadMimeType = this@with.payloadMimeType.map { it.toBuilder() }.toMutableList()
          `header` = this@with.`header`.map { it.toBuilder() }.toMutableList()
        }
    }

  public class Builder(
    /**
     * active | suspended | error | off | test.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * endpoint as not currently valid.
     */
    public var status: Enumeration<EndpointStatus>,
    /**
     * A coded value that represents the technical details of the usage of this endpoint, such as
     * what WSDLs should be used in what way. (e.g. XDS.b/DICOM/cds-hook).
     *
     * For additional connectivity details for the protocol, extensions will be used at this point,
     * as in the XDS example.
     */
    public var connectionType: Coding.Builder,
    /**
     * The payload type describes the acceptable content that can be communicated on the endpoint.
     *
     * The payloadFormat describes the serialization format of the data, where the payloadType
     * indicates the specific document/schema that is being transferred; e.g. DischargeSummary or
     * CarePlan.
     */
    public var payloadType: MutableList<CodeableConcept.Builder>,
    /**
     * The uri that describes the actual end-point to connect to.
     *
     * For rest-hook, and websocket, the end-point must be an http: or https: URL; for email, a
     * mailto: url, for sms, a tel: url, and for message the endpoint can be in any form of url the
     * server understands (usually, http: or mllp:). The URI is allowed to be relative; in which
     * case, it is relative to the server end-point (since there may be more than one, clients
     * should avoid using relative URIs)
     *
     * This address will be to the service base, without any parameters, or sub-services or
     * resources tacked on.
     *
     * E.g. for a WADO-RS endpoint, the url should be "https://pacs.hospital.org/wado-rs"
     *
     * and not
     * "https://pacs.hospital.org/wado-rs/studies/1.2.250.1.59.40211.12345678.678910/series/1.2.250.1.59.40211.789001276.14556172.67789/instances/...".
     */
    public var address: Url.Builder,
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
     * Identifier for the organization that is used to identify the endpoint across multiple
     * disparate systems.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** A friendly name that this endpoint can be referred to with. */
    public var name: String.Builder? = null

    /**
     * The organization that manages this endpoint (even if technically another organization is
     * hosting this in the cloud, it is the organization associated with the data).
     *
     * This property is not typically used when searching for Endpoint resources for usage. The
     * typical usage is via the reference from an applicable Organization/Location/Practitioner
     * resource, which is where the context is provided. Multiple Locations may reference a single
     * endpoint, and don't have to be within the same organization resource, but most likely within
     * the same organizational hierarchy.
     */
    public var managingOrganization: Reference.Builder? = null

    /**
     * Contact details for a human to contact about the subscription. The primary use of this for
     * system administrator troubleshooting.
     */
    public var contact: MutableList<ContactPoint.Builder> = mutableListOf()

    /** The interval during which the endpoint is expected to be operational. */
    public var period: Period.Builder? = null

    /**
     * The mime type to send the payload in - e.g. application/fhir+xml, application/fhir+json. If
     * the mime type is not specified, then the sender could send any content (including no content
     * depending on the connectionType).
     *
     * Sending the payload has obvious security consequences. The server is responsible for ensuring
     * that the content is appropriately secured.
     */
    public var payloadMimeType: MutableList<Code.Builder> = mutableListOf()

    /**
     * Additional headers / information to send as part of the notification.
     *
     * Exactly what these mean depends on the channel type. The can convey additional information to
     * the recipient and/or meet security requirements.
     */
    public var `header`: MutableList<String.Builder> = mutableListOf()

    override fun build(): Endpoint =
      Endpoint(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        status = status,
        connectionType = connectionType.build(),
        name = name?.build(),
        managingOrganization = managingOrganization?.build(),
        contact = contact.map { it.build() },
        period = period?.build(),
        payloadType = payloadType.map { it.build() },
        payloadMimeType = payloadMimeType.map { it.build() },
        address = address.build(),
        `header` = `header`.map { it.build() },
      )
  }

  /** The status of the endpoint. */
  public enum class EndpointStatus(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Active("active", "http://hl7.org/fhir/endpoint-status", "Active"),
    Suspended("suspended", "http://hl7.org/fhir/endpoint-status", "Suspended"),
    Error("error", "http://hl7.org/fhir/endpoint-status", "Error"),
    Off("off", "http://hl7.org/fhir/endpoint-status", "Off"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/endpoint-status", "Entered in error"),
    Test("test", "http://hl7.org/fhir/endpoint-status", "Test");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): EndpointStatus =
        when (code) {
          "active" -> Active
          "suspended" -> Suspended
          "error" -> Error
          "off" -> Off
          "entered-in-error" -> Entered_In_Error
          "test" -> Test
          else -> throw IllegalArgumentException("Unknown code $code for enum EndpointStatus")
        }
    }
  }
}

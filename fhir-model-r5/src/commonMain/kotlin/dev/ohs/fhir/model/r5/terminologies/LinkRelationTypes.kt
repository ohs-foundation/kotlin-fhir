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

package dev.ohs.fhir.model.r5.terminologies

import dev.ohs.fhir.model.r5.FhirEnum
import kotlin.String

/**
 * Link Relation Types defined at
 * https://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1
 */
public enum class LinkRelationTypes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  About(
    "about",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a resource that is the subject of the link's context.",
  ),
  Acl(
    "acl",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Asserts that the link target provides an access control description for the link context.",
  ),
  Alternate(
    "alternate",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a substitute for this context",
  ),
  Amphtml(
    "amphtml",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Used to reference alternative content that uses the AMP profile of the HTML format.",
  ),
  Appendix(
    "appendix",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to an appendix.",
  ),
  Apple_Touch_Icon(
    "apple-touch-icon",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to an icon for the context. Synonym for icon.",
  ),
  Apple_Touch_Startup_Image(
    "apple-touch-startup-image",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a launch screen for the context.",
  ),
  Archives(
    "archives",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a collection of records, documents, or other
    |      materials of historical interest.
    """
      .trimMargin(),
  ),
  Author(
    "author",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to the context's author.",
  ),
  Blocked_By(
    "blocked-by",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies the entity that blocks access to a resource
    |      following receipt of a legal demand.
    """
      .trimMargin(),
  ),
  Bookmark(
    "bookmark",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Gives a permanent link to use for bookmarking purposes.",
  ),
  Canonical(
    "canonical",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Designates the preferred version of a resource (the IRI and its contents).",
  ),
  Chapter(
    "chapter",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a chapter in a collection of resources.",
  ),
  Cite_As(
    "cite-as",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Indicates that the link target is preferred over the link context for the purpose of permanent citation.",
  ),
  Collection(
    "collection",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "The target IRI points to a resource which represents the collection resource for the context IRI.",
  ),
  Contents(
    "contents",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a table of contents.",
  ),
  ConvertedFrom(
    "convertedFrom",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |The document linked to was later converted to the
    |      document that contains this link relation.  For example, an RFC can
    |      have a link to the Internet-Draft that became the RFC; in that case,
    |      the link relation would be "convertedFrom".
    """
      .trimMargin(),
  ),
  Copyright(
    "copyright",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a copyright statement that applies to the
    |    link's context.
    """
      .trimMargin(),
  ),
  Create_Form(
    "create-form",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "The target IRI points to a resource where a submission form can be obtained.",
  ),
  Current(
    "current",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource containing the most recent
    |      item(s) in a collection of resources.
    """
      .trimMargin(),
  ),
  Describedby(
    "describedby",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource providing information about the
    |      link's context.
    """
      .trimMargin(),
  ),
  Describes(
    "describes",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |The relationship A 'describes' B asserts that
    |      resource A provides a description of resource B. There are no
    |      constraints on the format or representation of either A or B,
    |      neither are there any further constraints on either resource.
    """
      .trimMargin(),
  ),
  Disclosure(
    "disclosure",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a list of patent disclosures made with respect to 
    |      material for which 'disclosure' relation is specified.
    """
      .trimMargin(),
  ),
  Dns_Prefetch(
    "dns-prefetch",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Used to indicate an origin that will be used to fetch required 
    |      resources for the link context, and that the user agent ought to resolve 
    |      as early as possible.
    """
      .trimMargin(),
  ),
  Duplicate(
    "duplicate",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource whose available representations
    |      are byte-for-byte identical with the corresponding representations of
    |      the context IRI.
    """
      .trimMargin(),
  ),
  Edit(
    "edit",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource that can be used to edit the
    |      link's context.
    """
      .trimMargin(),
  ),
  Edit_Form(
    "edit-form",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |The target IRI points to a resource where a submission form for
    |      editing associated resource can be obtained.
    """
      .trimMargin(),
  ),
  Edit_Media(
    "edit-media",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource that can be used to edit media
    |      associated with the link's context.
    """
      .trimMargin(),
  ),
  Enclosure(
    "enclosure",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies a related resource that is potentially
    |      large and might require special handling.
    """
      .trimMargin(),
  ),
  External(
    "external",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a resource that is not part of the same site as the current context.",
  ),
  First(
    "first",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |An IRI that refers to the furthest preceding resource
    |    in a series of resources.
    """
      .trimMargin(),
  ),
  Glossary(
    "glossary",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a glossary of terms.",
  ),
  Help(
    "help",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to context-sensitive help.",
  ),
  Hosts(
    "hosts",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource hosted by the server indicated by
    |      the link context.
    """
      .trimMargin(),
  ),
  Hub(
    "hub",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a hub that enables registration for
    |    notification of updates to the context.
    """
      .trimMargin(),
  ),
  Icon(
    "icon",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to an icon representing the link's context.",
  ),
  Index("index", "http://hl7.org/fhir/CodeSystem/iana-link-relations", "Refers to an index."),
  IntervalAfter(
    "intervalAfter",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that ends before the beginning of the time interval associated with the context resource",
  ),
  IntervalBefore(
    "intervalBefore",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins after the end of the time interval associated with the context resource",
  ),
  IntervalContains(
    "intervalContains",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins after the beginning of the time interval associated with the context resource, and ends before the end of the time interval associated with the context resource",
  ),
  IntervalDisjoint(
    "intervalDisjoint",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins after the end of the time interval associated with the context resource, or ends before the beginning of the time interval associated with the context resource",
  ),
  IntervalDuring(
    "intervalDuring",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource",
  ),
  IntervalEquals(
    "intervalEquals",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource",
  ),
  IntervalFinishedBy(
    "intervalFinishedBy",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins after the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource",
  ),
  IntervalFinishes(
    "intervalFinishes",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource",
  ),
  IntervalIn(
    "intervalIn",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins before or is coincident with the beginning of the time interval associated with the context resource, and ends after or is coincident with the end of the time interval associated with the context resource",
  ),
  IntervalMeets(
    "intervalMeets",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval whose beginning coincides with the end of the time interval associated with the context resource",
  ),
  IntervalMetBy(
    "intervalMetBy",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval whose end coincides with the beginning of the time interval associated with the context resource",
  ),
  IntervalOverlappedBy(
    "intervalOverlappedBy",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and ends after the beginning of the time interval associated with the context resource",
  ),
  IntervalOverlaps(
    "intervalOverlaps",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval that begins before the end of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource",
  ),
  IntervalStartedBy(
    "intervalStartedBy",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and ends before the end of the time interval associated with the context resource",
  ),
  IntervalStarts(
    "intervalStarts",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource",
  ),
  Item(
    "item",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "The target IRI points to a resource that is a member of the collection represented by the context IRI.",
  ),
  Last(
    "last",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |An IRI that refers to the furthest following resource
    |      in a series of resources.
    """
      .trimMargin(),
  ),
  Latest_Version(
    "latest-version",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Points to a resource containing the latest (e.g.,
    |      current) version of the context.
    """
      .trimMargin(),
  ),
  License(
    "license",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a license associated with this context.",
  ),
  Linkset(
    "linkset",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |The link target of a link with the "linkset" relation
    |      type provides a set of links, including links in which the link
    |      context of the link participates.
    |    
    """
      .trimMargin(),
  ),
  Lrdd(
    "lrdd",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to further information about the link's context,
    |      expressed as a LRDD ("Link-based Resource Descriptor Document")
    |      resource.  See  for information about
    |      processing this relation type in host-meta documents. When used
    |      elsewhere, it refers to additional links and other metadata.
    |      Multiple instances indicate additional LRDD resources. LRDD
    |      resources MUST have an "application/xrd+xml" representation, and
    |      MAY have others.
    """
      .trimMargin(),
  ),
  Manifest(
    "manifest",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Links to a manifest file for the context.",
  ),
  Mask_Icon(
    "mask-icon",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a mask that can be applied to the icon for the context.",
  ),
  Media_Feed(
    "media-feed",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a feed of personalised media recommendations relevant to the link context.",
  ),
  Memento(
    "memento",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "The Target IRI points to a Memento, a fixed resource that will not change state anymore.",
  ),
  Micropub(
    "micropub",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Links to the context's Micropub endpoint.",
  ),
  Modulepreload(
    "modulepreload",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a module that the user agent is to preemptively fetch and store for use in the current context.",
  ),
  Monitor(
    "monitor",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource that can be used to monitor changes in an HTTP resource.
    |    
    """
      .trimMargin(),
  ),
  Monitor_Group(
    "monitor-group",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource that can be used to monitor changes in a specified group of HTTP resources.
    |    
    """
      .trimMargin(),
  ),
  Next(
    "next",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Indicates that the link's context is a part of a series, and
    |      that the next in the series is the link target.
    |    
    """
      .trimMargin(),
  ),
  Next_Archive(
    "next-archive",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to the immediately following archive resource.",
  ),
  Nofollow(
    "nofollow",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Indicates that the context’s original author or publisher does not endorse the link target.",
  ),
  Noopener(
    "noopener",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Indicates that any newly created top-level browsing context which results from following the link will not be an auxiliary browsing context.",
  ),
  Noreferrer(
    "noreferrer",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Indicates that no referrer information is to be leaked when following the link.",
  ),
  Opener(
    "opener",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Indicates that any newly created top-level browsing context which results from following the link will be an auxiliary browsing context.",
  ),
  Openid2_Local_Id(
    "openid2.local_id",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to an OpenID Authentication server on which the context relies for an assertion that the end user controls an Identifier.",
  ),
  Openid2_Provider(
    "openid2.provider",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a resource which accepts OpenID Authentication protocol messages for the context.",
  ),
  Original(
    "original",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "The Target IRI points to an Original Resource.",
  ),
  P3Pv1(
    "P3Pv1",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a P3P privacy policy for the context.",
  ),
  Payment(
    "payment",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Indicates a resource where payment is accepted.",
  ),
  Pingback(
    "pingback",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Gives the address of the pingback resource for the link context.",
  ),
  Preconnect(
    "preconnect",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Used to indicate an origin that will be used to fetch required 
    |      resources for the link context. Initiating an early connection, which 
    |      includes the DNS lookup, TCP handshake, and optional TLS negotiation, 
    |      allows the user agent to mask the high latency costs of establishing a 
    |      connection.
    """
      .trimMargin(),
  ),
  Predecessor_Version(
    "predecessor-version",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Points to a resource containing the predecessor
    |      version in the version history.
    |    
    """
      .trimMargin(),
  ),
  Prefetch(
    "prefetch",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |The prefetch link relation type is used to identify a resource 
    |      that might be required by the next navigation from the link context, and 
    |      that the user agent ought to fetch, such that the user agent can deliver a 
    |      faster response once the resource is requested in the future.
    """
      .trimMargin(),
  ),
  Preload(
    "preload",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource that should be loaded early in the 
    |      processing of the link's context, without blocking rendering.
    """
      .trimMargin(),
  ),
  Prerender(
    "prerender",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Used to identify a resource that might be required by the next 
    |      navigation from the link context, and that the user agent ought to fetch 
    |      and execute, such that the user agent can deliver a faster response once 
    |      the resource is requested in the future.
    """
      .trimMargin(),
  ),
  Prev(
    "prev",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Indicates that the link's context is a part of a series, and
    |      that the previous in the series is the link target.
    |    
    """
      .trimMargin(),
  ),
  Preview(
    "preview",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a resource that provides a preview of the link's context.",
  ),
  Previous(
    "previous",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to the previous resource in an ordered series
    |      of resources.  Synonym for "prev".
    """
      .trimMargin(),
  ),
  Prev_Archive(
    "prev-archive",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to the immediately preceding archive resource.",
  ),
  Privacy_Policy(
    "privacy-policy",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a privacy policy associated with the link's context.",
  ),
  Profile(
    "profile",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifying that a resource representation conforms
    |to a certain profile, without affecting the non-profile semantics
    |of the resource representation.
    """
      .trimMargin(),
  ),
  Publication(
    "publication",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Links to a publication manifest. A manifest represents 
    |      structured information about a publication, such as informative metadata, 
    |      a list of resources, and a default reading order.
    """
      .trimMargin(),
  ),
  Related(
    "related",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Identifies a related resource.",
  ),
  Restconf(
    "restconf",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies the root of RESTCONF API as configured on this HTTP server.
    |      The "restconf" relation defines the root of the API defined in RFC8040.
    |      Subsequent revisions of RESTCONF will use alternate relation values to support 
    |      protocol versioning.
    """
      .trimMargin(),
  ),
  Replies(
    "replies",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies a resource that is a reply to the context
    |      of the link.
    |    
    """
      .trimMargin(),
  ),
  Ruleinput(
    "ruleinput",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |The resource identified by the link target provides an input value to an 
    |    instance of a rule, where the resource which represents the rule instance is 
    |    identified by the link context.
    |    
    """
      .trimMargin(),
  ),
  Search(
    "search",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource that can be used to search through
    |      the link's context and related resources.
    """
      .trimMargin(),
  ),
  Section(
    "section",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a section in a collection of resources.",
  ),
  Self(
    "self",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Conveys an identifier for the link's context.
    |    
    """
      .trimMargin(),
  ),
  Service(
    "service",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Indicates a URI that can be used to retrieve a
    |      service document.
    """
      .trimMargin(),
  ),
  Service_Desc(
    "service-desc",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies service description for the context that
    |      is primarily intended for consumption by machines.
    """
      .trimMargin(),
  ),
  Service_Doc(
    "service-doc",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies service documentation for the context that
    |      is primarily intended for human consumption.
    """
      .trimMargin(),
  ),
  Service_Meta(
    "service-meta",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies general metadata for the context that is
    |      primarily intended for consumption by machines.
    """
      .trimMargin(),
  ),
  Sponsored(
    "sponsored",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource that is within a context that is 
    |		sponsored (such as advertising or another compensation agreement).
    """
      .trimMargin(),
  ),
  Start(
    "start",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to the first resource in a collection of
    |      resources.
    """
      .trimMargin(),
  ),
  Status(
    "status",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies a resource that represents the context's
    |      status.
    """
      .trimMargin(),
  ),
  Stylesheet(
    "stylesheet",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a stylesheet.",
  ),
  Subsection(
    "subsection",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource serving as a subsection in a
    |      collection of resources.
    """
      .trimMargin(),
  ),
  Successor_Version(
    "successor-version",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Points to a resource containing the successor version
    |      in the version history.
    |    
    """
      .trimMargin(),
  ),
  Sunset(
    "sunset",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies a resource that provides information about
    |      the context's retirement policy.
    |    
    """
      .trimMargin(),
  ),
  Tag(
    "tag",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Gives a tag (identified by the given address) that applies to
    |      the current document.
    |    
    """
      .trimMargin(),
  ),
  Terms_Of_Service(
    "terms-of-service",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to the terms of service associated with the link's context.",
  ),
  Timegate(
    "timegate",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "The Target IRI points to a TimeGate for an Original Resource.",
  ),
  Timemap(
    "timemap",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "The Target IRI points to a TimeMap for an Original Resource.",
  ),
  Type(
    "type",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Refers to a resource identifying the abstract semantic type of which the link's context is considered to be an instance.",
  ),
  Ugc(
    "ugc",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a resource that is within a context that is User Generated Content.
    |    
    """
      .trimMargin(),
  ),
  Up(
    "up",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Refers to a parent document in a hierarchy of
    |      documents.
    |    
    """
      .trimMargin(),
  ),
  Version_History(
    "version-history",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Points to a resource containing the version history
    |      for the context.
    |    
    """
      .trimMargin(),
  ),
  Via(
    "via",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies a resource that is the source of the
    |      information in the link's context.
    |    
    """
      .trimMargin(),
  ),
  Webmention(
    "webmention",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Identifies a target URI that supports the Webmention protocol.
    |    This allows clients that mention a resource in some form of publishing process
    |    to contact that endpoint and inform it that this resource has been mentioned.
    """
      .trimMargin(),
  ),
  Working_Copy(
    "working-copy",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    "Points to a working copy for this resource.",
  ),
  Working_Copy_Of(
    "working-copy-of",
    "http://hl7.org/fhir/CodeSystem/iana-link-relations",
    """
    |Points to the versioned resource from which this
    |      working copy was obtained.
    |    
    """
      .trimMargin(),
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): LinkRelationTypes =
      when (code) {
        "about" -> About
        "acl" -> Acl
        "alternate" -> Alternate
        "amphtml" -> Amphtml
        "appendix" -> Appendix
        "apple-touch-icon" -> Apple_Touch_Icon
        "apple-touch-startup-image" -> Apple_Touch_Startup_Image
        "archives" -> Archives
        "author" -> Author
        "blocked-by" -> Blocked_By
        "bookmark" -> Bookmark
        "canonical" -> Canonical
        "chapter" -> Chapter
        "cite-as" -> Cite_As
        "collection" -> Collection
        "contents" -> Contents
        "convertedFrom" -> ConvertedFrom
        "copyright" -> Copyright
        "create-form" -> Create_Form
        "current" -> Current
        "describedby" -> Describedby
        "describes" -> Describes
        "disclosure" -> Disclosure
        "dns-prefetch" -> Dns_Prefetch
        "duplicate" -> Duplicate
        "edit" -> Edit
        "edit-form" -> Edit_Form
        "edit-media" -> Edit_Media
        "enclosure" -> Enclosure
        "external" -> External
        "first" -> First
        "glossary" -> Glossary
        "help" -> Help
        "hosts" -> Hosts
        "hub" -> Hub
        "icon" -> Icon
        "index" -> Index
        "intervalAfter" -> IntervalAfter
        "intervalBefore" -> IntervalBefore
        "intervalContains" -> IntervalContains
        "intervalDisjoint" -> IntervalDisjoint
        "intervalDuring" -> IntervalDuring
        "intervalEquals" -> IntervalEquals
        "intervalFinishedBy" -> IntervalFinishedBy
        "intervalFinishes" -> IntervalFinishes
        "intervalIn" -> IntervalIn
        "intervalMeets" -> IntervalMeets
        "intervalMetBy" -> IntervalMetBy
        "intervalOverlappedBy" -> IntervalOverlappedBy
        "intervalOverlaps" -> IntervalOverlaps
        "intervalStartedBy" -> IntervalStartedBy
        "intervalStarts" -> IntervalStarts
        "item" -> Item
        "last" -> Last
        "latest-version" -> Latest_Version
        "license" -> License
        "linkset" -> Linkset
        "lrdd" -> Lrdd
        "manifest" -> Manifest
        "mask-icon" -> Mask_Icon
        "media-feed" -> Media_Feed
        "memento" -> Memento
        "micropub" -> Micropub
        "modulepreload" -> Modulepreload
        "monitor" -> Monitor
        "monitor-group" -> Monitor_Group
        "next" -> Next
        "next-archive" -> Next_Archive
        "nofollow" -> Nofollow
        "noopener" -> Noopener
        "noreferrer" -> Noreferrer
        "opener" -> Opener
        "openid2.local_id" -> Openid2_Local_Id
        "openid2.provider" -> Openid2_Provider
        "original" -> Original
        "P3Pv1" -> P3Pv1
        "payment" -> Payment
        "pingback" -> Pingback
        "preconnect" -> Preconnect
        "predecessor-version" -> Predecessor_Version
        "prefetch" -> Prefetch
        "preload" -> Preload
        "prerender" -> Prerender
        "prev" -> Prev
        "preview" -> Preview
        "previous" -> Previous
        "prev-archive" -> Prev_Archive
        "privacy-policy" -> Privacy_Policy
        "profile" -> Profile
        "publication" -> Publication
        "related" -> Related
        "restconf" -> Restconf
        "replies" -> Replies
        "ruleinput" -> Ruleinput
        "search" -> Search
        "section" -> Section
        "self" -> Self
        "service" -> Service
        "service-desc" -> Service_Desc
        "service-doc" -> Service_Doc
        "service-meta" -> Service_Meta
        "sponsored" -> Sponsored
        "start" -> Start
        "status" -> Status
        "stylesheet" -> Stylesheet
        "subsection" -> Subsection
        "successor-version" -> Successor_Version
        "sunset" -> Sunset
        "tag" -> Tag
        "terms-of-service" -> Terms_Of_Service
        "timegate" -> Timegate
        "timemap" -> Timemap
        "type" -> Type
        "ugc" -> Ugc
        "up" -> Up
        "version-history" -> Version_History
        "via" -> Via
        "webmention" -> Webmention
        "working-copy" -> Working_Copy
        "working-copy-of" -> Working_Copy_Of
        else -> throw IllegalArgumentException("Unknown code $code for enum LinkRelationTypes")
      }
  }
}

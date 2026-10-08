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

/** The type of response code to use for assertion. */
public enum class AssertionResponseTypes(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Continue("continue", "http://hl7.org/fhir/assert-response-code-types", "Continue"),
  SwitchingProtocols(
    "switchingProtocols",
    "http://hl7.org/fhir/assert-response-code-types",
    "Switching Protocols",
  ),
  Okay("okay", "http://hl7.org/fhir/assert-response-code-types", "OK"),
  Created("created", "http://hl7.org/fhir/assert-response-code-types", "Created"),
  Accepted("accepted", "http://hl7.org/fhir/assert-response-code-types", "Accepted"),
  NonAuthoritativeInformation(
    "nonAuthoritativeInformation",
    "http://hl7.org/fhir/assert-response-code-types",
    "Non-Authoritative Information",
  ),
  NoContent("noContent", "http://hl7.org/fhir/assert-response-code-types", "No Content"),
  ResetContent("resetContent", "http://hl7.org/fhir/assert-response-code-types", "Reset Content"),
  PartialContent(
    "partialContent",
    "http://hl7.org/fhir/assert-response-code-types",
    "Partial Content",
  ),
  MultipleChoices(
    "multipleChoices",
    "http://hl7.org/fhir/assert-response-code-types",
    "Multiple Choices",
  ),
  MovedPermanently(
    "movedPermanently",
    "http://hl7.org/fhir/assert-response-code-types",
    "Moved Permanently",
  ),
  Found("found", "http://hl7.org/fhir/assert-response-code-types", "Found"),
  SeeOther("seeOther", "http://hl7.org/fhir/assert-response-code-types", "See Other"),
  NotModified("notModified", "http://hl7.org/fhir/assert-response-code-types", "Not Modified"),
  UseProxy("useProxy", "http://hl7.org/fhir/assert-response-code-types", "Use Proxy"),
  TemporaryRedirect(
    "temporaryRedirect",
    "http://hl7.org/fhir/assert-response-code-types",
    "Temporary Redirect",
  ),
  PermanentRedirect(
    "permanentRedirect",
    "http://hl7.org/fhir/assert-response-code-types",
    "Permanent Redirect",
  ),
  BadRequest("badRequest", "http://hl7.org/fhir/assert-response-code-types", "Bad Request"),
  Unauthorized("unauthorized", "http://hl7.org/fhir/assert-response-code-types", "Unauthorized"),
  PaymentRequired(
    "paymentRequired",
    "http://hl7.org/fhir/assert-response-code-types",
    "Payment Required",
  ),
  Forbidden("forbidden", "http://hl7.org/fhir/assert-response-code-types", "Forbidden"),
  NotFound("notFound", "http://hl7.org/fhir/assert-response-code-types", "Not Found"),
  MethodNotAllowed(
    "methodNotAllowed",
    "http://hl7.org/fhir/assert-response-code-types",
    "Method Not Allowed",
  ),
  NotAcceptable(
    "notAcceptable",
    "http://hl7.org/fhir/assert-response-code-types",
    "Not Acceptable",
  ),
  ProxyAuthenticationRequired(
    "proxyAuthenticationRequired",
    "http://hl7.org/fhir/assert-response-code-types",
    "Proxy Authentication Required",
  ),
  RequestTimeout(
    "requestTimeout",
    "http://hl7.org/fhir/assert-response-code-types",
    "Request Timeout",
  ),
  Conflict("conflict", "http://hl7.org/fhir/assert-response-code-types", "Conflict"),
  Gone("gone", "http://hl7.org/fhir/assert-response-code-types", "Gone"),
  LengthRequired(
    "lengthRequired",
    "http://hl7.org/fhir/assert-response-code-types",
    "Length Required",
  ),
  PreconditionFailed(
    "preconditionFailed",
    "http://hl7.org/fhir/assert-response-code-types",
    "Precondition Failed",
  ),
  ContentTooLarge(
    "contentTooLarge",
    "http://hl7.org/fhir/assert-response-code-types",
    "Content Too Large",
  ),
  UriTooLong("uriTooLong", "http://hl7.org/fhir/assert-response-code-types", "URI Too Long"),
  UnsupportedMediaType(
    "unsupportedMediaType",
    "http://hl7.org/fhir/assert-response-code-types",
    "Unsupported Media Type",
  ),
  RangeNotSatisfiable(
    "rangeNotSatisfiable",
    "http://hl7.org/fhir/assert-response-code-types",
    "Range Not Satisfiable",
  ),
  ExpectationFailed(
    "expectationFailed",
    "http://hl7.org/fhir/assert-response-code-types",
    "Expectation Failed",
  ),
  MisdirectedRequest(
    "misdirectedRequest",
    "http://hl7.org/fhir/assert-response-code-types",
    "Misdirected Request",
  ),
  UnprocessableContent(
    "unprocessableContent",
    "http://hl7.org/fhir/assert-response-code-types",
    "Unprocessable Content",
  ),
  UpgradeRequired(
    "upgradeRequired",
    "http://hl7.org/fhir/assert-response-code-types",
    "Upgrade Required",
  ),
  InternalServerError(
    "internalServerError",
    "http://hl7.org/fhir/assert-response-code-types",
    "Internal Server Error",
  ),
  NotImplemented(
    "notImplemented",
    "http://hl7.org/fhir/assert-response-code-types",
    "Not Implemented",
  ),
  BadGateway("badGateway", "http://hl7.org/fhir/assert-response-code-types", "Bad Gateway"),
  ServiceUnavailable(
    "serviceUnavailable",
    "http://hl7.org/fhir/assert-response-code-types",
    "Service Unavailable",
  ),
  GatewayTimeout(
    "gatewayTimeout",
    "http://hl7.org/fhir/assert-response-code-types",
    "Gateway Timeout",
  ),
  httpVersionNotSupported(
    "httpVersionNotSupported",
    "http://hl7.org/fhir/assert-response-code-types",
    "HTTP Version Not Supported",
  );

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): AssertionResponseTypes =
      when (code) {
        "continue" -> Continue
        "switchingProtocols" -> SwitchingProtocols
        "okay" -> Okay
        "created" -> Created
        "accepted" -> Accepted
        "nonAuthoritativeInformation" -> NonAuthoritativeInformation
        "noContent" -> NoContent
        "resetContent" -> ResetContent
        "partialContent" -> PartialContent
        "multipleChoices" -> MultipleChoices
        "movedPermanently" -> MovedPermanently
        "found" -> Found
        "seeOther" -> SeeOther
        "notModified" -> NotModified
        "useProxy" -> UseProxy
        "temporaryRedirect" -> TemporaryRedirect
        "permanentRedirect" -> PermanentRedirect
        "badRequest" -> BadRequest
        "unauthorized" -> Unauthorized
        "paymentRequired" -> PaymentRequired
        "forbidden" -> Forbidden
        "notFound" -> NotFound
        "methodNotAllowed" -> MethodNotAllowed
        "notAcceptable" -> NotAcceptable
        "proxyAuthenticationRequired" -> ProxyAuthenticationRequired
        "requestTimeout" -> RequestTimeout
        "conflict" -> Conflict
        "gone" -> Gone
        "lengthRequired" -> LengthRequired
        "preconditionFailed" -> PreconditionFailed
        "contentTooLarge" -> ContentTooLarge
        "uriTooLong" -> UriTooLong
        "unsupportedMediaType" -> UnsupportedMediaType
        "rangeNotSatisfiable" -> RangeNotSatisfiable
        "expectationFailed" -> ExpectationFailed
        "misdirectedRequest" -> MisdirectedRequest
        "unprocessableContent" -> UnprocessableContent
        "upgradeRequired" -> UpgradeRequired
        "internalServerError" -> InternalServerError
        "notImplemented" -> NotImplemented
        "badGateway" -> BadGateway
        "serviceUnavailable" -> ServiceUnavailable
        "gatewayTimeout" -> GatewayTimeout
        "httpVersionNotSupported" -> httpVersionNotSupported
        else -> throw IllegalArgumentException("Unknown code $code for enum AssertionResponseTypes")
      }
  }
}

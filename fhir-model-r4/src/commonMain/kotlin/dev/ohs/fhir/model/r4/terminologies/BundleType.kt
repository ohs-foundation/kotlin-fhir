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

package dev.ohs.fhir.model.r4.terminologies

import dev.ohs.fhir.model.r4.FhirEnum
import kotlin.String

/** Indicates the purpose of a bundle - how it is intended to be used. */
public enum class BundleType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Document("document", "http://hl7.org/fhir/bundle-type", "Document"),
  Message("message", "http://hl7.org/fhir/bundle-type", "Message"),
  Transaction("transaction", "http://hl7.org/fhir/bundle-type", "Transaction"),
  Transaction_Response(
    "transaction-response",
    "http://hl7.org/fhir/bundle-type",
    "Transaction Response",
  ),
  Batch("batch", "http://hl7.org/fhir/bundle-type", "Batch"),
  Batch_Response("batch-response", "http://hl7.org/fhir/bundle-type", "Batch Response"),
  History("history", "http://hl7.org/fhir/bundle-type", "History List"),
  Searchset("searchset", "http://hl7.org/fhir/bundle-type", "Search Results"),
  Collection("collection", "http://hl7.org/fhir/bundle-type", "Collection");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): BundleType =
      when (code) {
        "document" -> Document
        "message" -> Message
        "transaction" -> Transaction
        "transaction-response" -> Transaction_Response
        "batch" -> Batch
        "batch-response" -> Batch_Response
        "history" -> History
        "searchset" -> Searchset
        "collection" -> Collection
        else -> throw IllegalArgumentException("Unknown code $code for enum BundleType")
      }
  }
}

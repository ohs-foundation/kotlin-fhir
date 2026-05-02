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

package com.google.fhir.model.r5.terminologies

import kotlin.String

/**
 * Operation Outcome codes for translatable phrases used by FHIR test servers (see Implementation
 * file translations.xml)
 */
public enum class OperationOutcomeCodes(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Delete_Multiple_Matches(
    "DELETE_MULTIPLE_MATCHES",
    "http://hl7.org/fhir/operation-outcome",
    "Error: Multiple matches exist for the conditional delete",
  ),
  Msg_Auth_Required(
    "MSG_AUTH_REQUIRED",
    "http://hl7.org/fhir/operation-outcome",
    "You must authenticate before you can use this service",
  ),
  Msg_Bad_Format(
    "MSG_BAD_FORMAT",
    "http://hl7.org/fhir/operation-outcome",
    "Bad Syntax: \"%s\" must be a %s'",
  ),
  Msg_Bad_Syntax("MSG_BAD_SYNTAX", "http://hl7.org/fhir/operation-outcome", "Bad Syntax in %s"),
  Msg_Cant_Parse_Content(
    "MSG_CANT_PARSE_CONTENT",
    "http://hl7.org/fhir/operation-outcome",
    "Unable to parse feed (entry content type = \"%s\")",
  ),
  Msg_Cant_Parse_Root(
    "MSG_CANT_PARSE_ROOT",
    "http://hl7.org/fhir/operation-outcome",
    "Unable to parse feed (root element name = \"%s\")",
  ),
  Msg_Created("MSG_CREATED", "http://hl7.org/fhir/operation-outcome", "New resource created"),
  Msg_Date_Format(
    "MSG_DATE_FORMAT",
    "http://hl7.org/fhir/operation-outcome",
    "The Date value %s is not in the correct format (Xml Date Format required)",
  ),
  Msg_Deleted(
    "MSG_DELETED",
    "http://hl7.org/fhir/operation-outcome",
    "This resource has been deleted",
  ),
  Msg_Deleted_Done("MSG_DELETED_DONE", "http://hl7.org/fhir/operation-outcome", "Resource deleted"),
  Msg_Deleted_Id(
    "MSG_DELETED_ID",
    "http://hl7.org/fhir/operation-outcome",
    "The resource \"%s\" has been deleted",
  ),
  Msg_Duplicate_Id(
    "MSG_DUPLICATE_ID",
    "http://hl7.org/fhir/operation-outcome",
    "Duplicate Id %s for resource type %s",
  ),
  Msg_Error_Parsing(
    "MSG_ERROR_PARSING",
    "http://hl7.org/fhir/operation-outcome",
    "Error parsing resource Xml (%s)",
  ),
  Msg_Id_Invalid(
    "MSG_ID_INVALID",
    "http://hl7.org/fhir/operation-outcome",
    "Id \"%s\" has an invalid character \"%s\"",
  ),
  Msg_Id_Too_Long(
    "MSG_ID_TOO_LONG",
    "http://hl7.org/fhir/operation-outcome",
    "Id \"%s\" too long (length limit 36)",
  ),
  Msg_Invalid_Id("MSG_INVALID_ID", "http://hl7.org/fhir/operation-outcome", "Id not accepted"),
  Msg_Json_Object(
    "MSG_JSON_OBJECT",
    "http://hl7.org/fhir/operation-outcome",
    "Json Source for a resource should start with an object",
  ),
  Msg_Local_Fail(
    "MSG_LOCAL_FAIL",
    "http://hl7.org/fhir/operation-outcome",
    "Unable to resolve local reference to resource %s",
  ),
  Msg_No_Exist(
    "MSG_NO_EXIST",
    "http://hl7.org/fhir/operation-outcome",
    "Resource Id \"%s\" does not exist",
  ),
  Msg_No_Match(
    "MSG_NO_MATCH",
    "http://hl7.org/fhir/operation-outcome",
    "No Resource found matching the query \"%s\"",
  ),
  Msg_No_Module(
    "MSG_NO_MODULE",
    "http://hl7.org/fhir/operation-outcome",
    "No module could be found to handle the request \"%s\"",
  ),
  Msg_No_Summary(
    "MSG_NO_SUMMARY",
    "http://hl7.org/fhir/operation-outcome",
    "No Summary for this resource",
  ),
  Msg_Op_Not_Allowed(
    "MSG_OP_NOT_ALLOWED",
    "http://hl7.org/fhir/operation-outcome",
    "Operation %s not allowed for resource %s (due to local configuration)",
  ),
  Msg_Param_Chained(
    "MSG_PARAM_CHAINED",
    "http://hl7.org/fhir/operation-outcome",
    "Unknown chained parameter name \"%s\"",
  ),
  Msg_Param_Invalid(
    "MSG_PARAM_INVALID",
    "http://hl7.org/fhir/operation-outcome",
    "Parameter \"%s\" content is invalid",
  ),
  Msg_Param_Modifier_Invalid(
    "MSG_PARAM_MODIFIER_INVALID",
    "http://hl7.org/fhir/operation-outcome",
    "Parameter \"%s\" modifier is invalid",
  ),
  Msg_Param_No_Repeat(
    "MSG_PARAM_NO_REPEAT",
    "http://hl7.org/fhir/operation-outcome",
    "Parameter \"%s\" is not allowed to repeat",
  ),
  Msg_Param_Unknown(
    "MSG_PARAM_UNKNOWN",
    "http://hl7.org/fhir/operation-outcome",
    "Parameter \"%s\" not understood",
  ),
  Msg_Remote_Fail(
    "MSG_REMOTE_FAIL",
    "http://hl7.org/fhir/operation-outcome",
    "Unable to resolve local reference to resource %s",
  ),
  Msg_Resource_Example_Protected(
    "MSG_RESOURCE_EXAMPLE_PROTECTED",
    "http://hl7.org/fhir/operation-outcome",
    "Resources with identity \"example\" cannot be deleted (for testing/training purposes)",
  ),
  Msg_Resource_Id_Fail(
    "MSG_RESOURCE_ID_FAIL",
    "http://hl7.org/fhir/operation-outcome",
    "unable to allocate resource id",
  ),
  Msg_Resource_Id_Mismatch(
    "MSG_RESOURCE_ID_MISMATCH",
    "http://hl7.org/fhir/operation-outcome",
    "Resource Id Mismatch",
  ),
  Msg_Resource_Id_Missing(
    "MSG_RESOURCE_ID_MISSING",
    "http://hl7.org/fhir/operation-outcome",
    "Resource Id Missing",
  ),
  Msg_Resource_Not_Allowed(
    "MSG_RESOURCE_NOT_ALLOWED",
    "http://hl7.org/fhir/operation-outcome",
    "Not allowed to submit a resource for this operation",
  ),
  Msg_Resource_Required(
    "MSG_RESOURCE_REQUIRED",
    "http://hl7.org/fhir/operation-outcome",
    "A resource is required",
  ),
  Msg_Resource_Type_Mismatch(
    "MSG_RESOURCE_TYPE_MISMATCH",
    "http://hl7.org/fhir/operation-outcome",
    "Resource Type Mismatch",
  ),
  Msg_Sort_Unknown(
    "MSG_SORT_UNKNOWN",
    "http://hl7.org/fhir/operation-outcome",
    "Unknown sort parameter name \"%s\"",
  ),
  Msg_Transaction_Duplicate_Id(
    "MSG_TRANSACTION_DUPLICATE_ID",
    "http://hl7.org/fhir/operation-outcome",
    "Duplicate Identifier in transaction: %s",
  ),
  Msg_Transaction_Missing_Id(
    "MSG_TRANSACTION_MISSING_ID",
    "http://hl7.org/fhir/operation-outcome",
    "Missing Identifier in transaction - an entry.id must be provided",
  ),
  Msg_Unhandled_Node_Type(
    "MSG_UNHANDLED_NODE_TYPE",
    "http://hl7.org/fhir/operation-outcome",
    "Unhandled xml node type \"%s\"",
  ),
  Msg_Unknown_Content(
    "MSG_UNKNOWN_CONTENT",
    "http://hl7.org/fhir/operation-outcome",
    "Unknown Content (%s) at %s",
  ),
  Msg_Unknown_Operation(
    "MSG_UNKNOWN_OPERATION",
    "http://hl7.org/fhir/operation-outcome",
    "unknown FHIR http operation",
  ),
  Msg_Unknown_Type(
    "MSG_UNKNOWN_TYPE",
    "http://hl7.org/fhir/operation-outcome",
    "Resource Type \"%s\" not recognised",
  ),
  Msg_Updated("MSG_UPDATED", "http://hl7.org/fhir/operation-outcome", "existing resource updated"),
  Msg_Version_Aware(
    "MSG_VERSION_AWARE",
    "http://hl7.org/fhir/operation-outcome",
    "Version aware updates are required for this resource",
  ),
  Msg_Version_Aware_Conflict(
    "MSG_VERSION_AWARE_CONFLICT",
    "http://hl7.org/fhir/operation-outcome",
    "Update Conflict (server current version = \"%s\", client version referenced = \"%s\")",
  ),
  Msg_Version_Aware_Url(
    "MSG_VERSION_AWARE_URL",
    "http://hl7.org/fhir/operation-outcome",
    "Version specific URL not recognised",
  ),
  Msg_Wrong_Ns(
    "MSG_WRONG_NS",
    "http://hl7.org/fhir/operation-outcome",
    "This does not appear to be a FHIR element or resource (wrong namespace \"%s\")",
  ),
  Search_Multiple(
    "SEARCH_MULTIPLE",
    "http://hl7.org/fhir/operation-outcome",
    "Error: Multiple matches exist for %s search parameters \"%s\"",
  ),
  Search_None(
    "SEARCH_NONE",
    "http://hl7.org/fhir/operation-outcome",
    "Error: no processable search found for %s search parameters \"%s\"",
  ),
  Update_Multiple_Matches(
    "UPDATE_MULTIPLE_MATCHES",
    "http://hl7.org/fhir/operation-outcome",
    "Error: Multiple matches exist for the conditional update",
  );

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): OperationOutcomeCodes =
      when (code) {
        "DELETE_MULTIPLE_MATCHES" -> Delete_Multiple_Matches
        "MSG_AUTH_REQUIRED" -> Msg_Auth_Required
        "MSG_BAD_FORMAT" -> Msg_Bad_Format
        "MSG_BAD_SYNTAX" -> Msg_Bad_Syntax
        "MSG_CANT_PARSE_CONTENT" -> Msg_Cant_Parse_Content
        "MSG_CANT_PARSE_ROOT" -> Msg_Cant_Parse_Root
        "MSG_CREATED" -> Msg_Created
        "MSG_DATE_FORMAT" -> Msg_Date_Format
        "MSG_DELETED" -> Msg_Deleted
        "MSG_DELETED_DONE" -> Msg_Deleted_Done
        "MSG_DELETED_ID" -> Msg_Deleted_Id
        "MSG_DUPLICATE_ID" -> Msg_Duplicate_Id
        "MSG_ERROR_PARSING" -> Msg_Error_Parsing
        "MSG_ID_INVALID" -> Msg_Id_Invalid
        "MSG_ID_TOO_LONG" -> Msg_Id_Too_Long
        "MSG_INVALID_ID" -> Msg_Invalid_Id
        "MSG_JSON_OBJECT" -> Msg_Json_Object
        "MSG_LOCAL_FAIL" -> Msg_Local_Fail
        "MSG_NO_EXIST" -> Msg_No_Exist
        "MSG_NO_MATCH" -> Msg_No_Match
        "MSG_NO_MODULE" -> Msg_No_Module
        "MSG_NO_SUMMARY" -> Msg_No_Summary
        "MSG_OP_NOT_ALLOWED" -> Msg_Op_Not_Allowed
        "MSG_PARAM_CHAINED" -> Msg_Param_Chained
        "MSG_PARAM_INVALID" -> Msg_Param_Invalid
        "MSG_PARAM_MODIFIER_INVALID" -> Msg_Param_Modifier_Invalid
        "MSG_PARAM_NO_REPEAT" -> Msg_Param_No_Repeat
        "MSG_PARAM_UNKNOWN" -> Msg_Param_Unknown
        "MSG_REMOTE_FAIL" -> Msg_Remote_Fail
        "MSG_RESOURCE_EXAMPLE_PROTECTED" -> Msg_Resource_Example_Protected
        "MSG_RESOURCE_ID_FAIL" -> Msg_Resource_Id_Fail
        "MSG_RESOURCE_ID_MISMATCH" -> Msg_Resource_Id_Mismatch
        "MSG_RESOURCE_ID_MISSING" -> Msg_Resource_Id_Missing
        "MSG_RESOURCE_NOT_ALLOWED" -> Msg_Resource_Not_Allowed
        "MSG_RESOURCE_REQUIRED" -> Msg_Resource_Required
        "MSG_RESOURCE_TYPE_MISMATCH" -> Msg_Resource_Type_Mismatch
        "MSG_SORT_UNKNOWN" -> Msg_Sort_Unknown
        "MSG_TRANSACTION_DUPLICATE_ID" -> Msg_Transaction_Duplicate_Id
        "MSG_TRANSACTION_MISSING_ID" -> Msg_Transaction_Missing_Id
        "MSG_UNHANDLED_NODE_TYPE" -> Msg_Unhandled_Node_Type
        "MSG_UNKNOWN_CONTENT" -> Msg_Unknown_Content
        "MSG_UNKNOWN_OPERATION" -> Msg_Unknown_Operation
        "MSG_UNKNOWN_TYPE" -> Msg_Unknown_Type
        "MSG_UPDATED" -> Msg_Updated
        "MSG_VERSION_AWARE" -> Msg_Version_Aware
        "MSG_VERSION_AWARE_CONFLICT" -> Msg_Version_Aware_Conflict
        "MSG_VERSION_AWARE_URL" -> Msg_Version_Aware_Url
        "MSG_WRONG_NS" -> Msg_Wrong_Ns
        "SEARCH_MULTIPLE" -> Search_Multiple
        "SEARCH_NONE" -> Search_None
        "UPDATE_MULTIPLE_MATCHES" -> Update_Multiple_Matches
        else -> throw IllegalArgumentException("Unknown code $code for enum OperationOutcomeCodes")
      }
  }
}

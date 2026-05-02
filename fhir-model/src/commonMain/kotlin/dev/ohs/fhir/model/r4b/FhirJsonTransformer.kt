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

package com.google.fhir.model.r5

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject

/**
 * Utility for transforming JSON structures by flattening or nesting multi-choice properties.
 *
 *           Example:
 *           This input JSON:
 *               {
 *                 "resourceType": "Patient",
 *                 "id": "1234",
 *                 "deceased": {
 *                   "deceasedBoolean": false,
 *                   "_deceasedBoolean": {
 *                     "id": "123",
 *                     "extension": [
 *                       {
 *                         "id": "129",
 *                         "value": {
 *                           "valuePositiveInt": 4
 *                         }
 *                       }
 *                     ]
 *                   }
 *                 }
 *               }
 *           Will be transformed into this FHIR-compatible format:
 *               {
 *                 "resourceType": "Patient",
 *                 "id": "1234",
 *                 "deceasedBoolean": false,
 *                 "_deceasedBoolean": {
 *                   "id": "123",
 *                   "extension": [
 *                     {
 *                       "id": "129",
 *                       "valuePositiveInt": 4
 *                     }
 *                   ]
 *                 }
 *               }
 */
internal object FhirJsonTransformer {
  /**
   * Flattens a JSON object by expanding specified multi-choice properties.
   *
   * @param inputJson The original JSON object to transform
   * @param multiChoiceProperties List of property names that should be flattened
   * @return New JsonObject with specified properties flattened
   */
  public fun flatten(inputJson: JsonObject, multiChoiceProperties: List<String>): JsonObject {
    val flattenedJsonMap = inputJson.toMutableMap()
    multiChoiceProperties.forEach { multiChoiceProperty ->
      flattenedJsonMap[multiChoiceProperty]
        ?.let { it as? JsonObject }
        ?.let { nestedObject ->
          nestedObject.forEach { (fieldName, fieldValue) ->
            flattenedJsonMap[fieldName] = fieldValue
          }
          flattenedJsonMap.remove(multiChoiceProperty)
        }
    }
    return JsonObject(flattenedJsonMap)
  }

  /**
   * Nests fields into specified multi-choice property objects.
   *
   * @param inputJson The original JSON object to transform
   * @param multiChoiceProperties List of property names that should contain nested fields
   * @return New JsonObject with specified properties nested
   */
  public fun unflatten(inputJson: JsonObject, multiChoiceProperties: List<String>): JsonObject {
    val nestedJsonMap = inputJson.toMutableMap()
    multiChoiceProperties.forEach { multiChoiceProperty ->
      val nestedFields = mutableMapOf<String, JsonElement>()
      inputJson.keys.forEach { key ->
        if (key.startsWith(multiChoiceProperty) || key.startsWith("_$multiChoiceProperty")) {
          nestedFields[key] = nestedJsonMap.remove(key)!!
        }
      }
      if (nestedFields.isNotEmpty()) {
        nestedJsonMap[multiChoiceProperty] = JsonObject(nestedFields)
      }
    }
    return JsonObject(nestedJsonMap)
  }
}

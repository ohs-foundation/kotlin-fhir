/*
 * Copyright 2025-2026 Open Health Stack Foundation
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

package dev.ohs.fhir.codegen

/*
 * Copyright 2025 Google LLC
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

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import kotlinx.serialization.json.JsonObject

/** Generator for creating a FileSpec containing the FhirJsonTransformer object definition. */
object FhirJsonTransformerFileSpecGenerator {

  /**
   * Generates a FileSpec for the FhirJsonTransformer object.
   *
   * @param packageName The package name for the generated file
   * @return A FileSpec containing the FhirJsonTransformer object definition
   */
  fun generate(packageName: String): FileSpec {
    val fhirJsonTransformerObject =
      TypeSpec.objectBuilder("FhirJsonTransformer")
        .addKdoc(
          """Utility for transforming JSON structures by flattening or nesting multi-choice properties.

          Example:
          This input JSON:
              {
                "resourceType": "Patient",
                "id": "1234",
                "deceased": {
                  "deceasedBoolean": false,
                  "_deceasedBoolean": {
                    "id": "123",
                    "extension": [
                      {
                        "id": "129",
                        "value": {
                          "valuePositiveInt": 4
                        }
                      }
                    ]
                  }
                }
              }
          
          Will be transformed into this FHIR-compatible format:
              {
                "resourceType": "Patient",
                "id": "1234",
                "deceasedBoolean": false,
                "_deceasedBoolean": {
                  "id": "123",
                  "extension": [
                    {
                      "id": "129",
                      "valuePositiveInt": 4
                    }
                  ]
                }
              }
          """
            .trimMargin()
        )
        .addModifiers(KModifier.INTERNAL)
        .addFunction(createFlattenFunction())
        .addFunction(createNestFunction())
        .build()

    return FileSpec.builder(packageName, "FhirJsonTransformer")
      .addImport("kotlinx.serialization.json", "JsonElement")
      .addType(fhirJsonTransformerObject)
      .build()
  }

  private fun createFlattenFunction(): FunSpec {
    return FunSpec.builder("flatten")
      .addKdoc("Flattens a JSON object by expanding specified multi-choice properties.\n")
      .addKdoc("@param inputJson The original JSON object to transform\n")
      .addKdoc("@param multiChoiceProperties List of property names that should be flattened\n")
      .addKdoc("@return New JsonObject with specified properties flattened\n")
      .addParameter("inputJson", JsonObject::class)
      .addParameter(
        ParameterSpec.builder("multiChoiceProperties", List::class.parameterizedBy(String::class))
          .build()
      )
      .returns(JsonObject::class)
      .addCode(
        """
                val flattenedJsonMap = inputJson.toMutableMap()
                multiChoiceProperties.forEach { multiChoiceProperty ->
                  flattenedJsonMap[multiChoiceProperty]?.let { it as? JsonObject }?.let { nestedObject ->
                    nestedObject.forEach { (fieldName, fieldValue) ->
                      flattenedJsonMap[fieldName] = fieldValue
                    }
                    flattenedJsonMap.remove(multiChoiceProperty)
                  }
                }
                return JsonObject(flattenedJsonMap)
            """
          .trimIndent()
      )
      .build()
  }

  private fun createNestFunction(): FunSpec {
    return FunSpec.builder("unflatten")
      .addKdoc("Nests fields into specified multi-choice property objects.\n")
      .addKdoc("@param inputJson The original JSON object to transform\n")
      .addKdoc(
        "@param multiChoiceProperties List of property names that should contain nested fields\n"
      )
      .addKdoc("@return New JsonObject with specified properties nested\n")
      .addParameter("inputJson", JsonObject::class)
      .addParameter(
        ParameterSpec.builder("multiChoiceProperties", List::class.parameterizedBy(String::class))
          .build()
      )
      .returns(JsonObject::class)
      .addCode(
        """
                val nestedJsonMap = inputJson.toMutableMap()
                multiChoiceProperties.forEach { multiChoiceProperty ->
                  val nestedFields = mutableMapOf<String, JsonElement>()
                  inputJson.keys.forEach { key ->
                    if (key.startsWith(multiChoiceProperty) || key.startsWith("_${'$'}multiChoiceProperty") ) {
                      nestedFields[key] = nestedJsonMap.remove(key)!!
                    }
                  }
                  if (nestedFields.isNotEmpty()) {
                    nestedJsonMap[multiChoiceProperty] = JsonObject(nestedFields)
                  }
                }
                return JsonObject(nestedJsonMap)
            """
          .trimIndent()
      )
      .build()
  }
}

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

package dev.ohs.fhir.model.test

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.io.File
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
private data class SearchParameterDef(
  val code: String,
  val base: List<String> = emptyList(),
  val type: String,
  val expression: String? = null,
  val target: List<String> = emptyList(),
)

private val json = Json { ignoreUnknownKeys = true }

private data class SearchParamTestSuite(
  val fhirVersion: String,
  val corePackageSubdirectory: String,
  val modelPackage: String,
)

private fun loadSearchParams(
  corePackageSubdirectory: String
): Map<String, List<SearchParameterDef>> {
  val rootDir = System.getProperty("projectRootDir")
  return File("$rootDir/third_party/$corePackageSubdirectory")
    .listFiles()!!
    .asSequence()
    .filter { it.isFile && it.name.matches("SearchParameter-.*\\.json".toRegex()) }
    .map { json.decodeFromString<SearchParameterDef>(it.readText()) }
    .filter { it.base.isNotEmpty() }
    .flatMap { searchParam -> searchParam.base.map { resource -> resource to searchParam } }
    .groupBy({ it.first }, { it.second })
}

private fun codeToDataObjectName(code: String): String =
  code.split("-").joinToString("") { it.replaceFirstChar(Char::uppercaseChar) }

/**
 * Extracts the expression portion relevant to a specific resource from a multi-resource expression.
 */
private fun extractExpressionForResource(expression: String?, resourceName: String): String {
  if (expression == null) return ""
  val parts = expression.split("|").map { it.trim() }
  val resourcePart =
    parts.firstOrNull { it.startsWith("$resourceName.") || it.startsWith("($resourceName.") }
  return resourcePart ?: expression
}

class SearchParamTest :
  FunSpec({
    listOf(
        SearchParamTestSuite("R4", "hl7.fhir.r4.core/package", "dev.ohs.fhir.model.r4"),
        SearchParamTestSuite("R4B", "hl7.fhir.r4b.core/package", "dev.ohs.fhir.model.r4b"),
        SearchParamTestSuite("R5", "hl7.fhir.r5.core/package", "dev.ohs.fhir.model.r5"),
      )
      .forEach { testSuite ->
        val searchParamsByResource = loadSearchParams(testSuite.corePackageSubdirectory)
        val searchParamInterface = Class.forName("${testSuite.modelPackage}.search.SearchParam")

        context("${testSuite.fhirVersion} search params should match definitions") {
          searchParamsByResource.forEach { (resourceName, expectedParams) ->
            // Check if the resource class exists and is concrete
            val resourceClass =
              try {
                Class.forName("${testSuite.modelPackage}.$resourceName").kotlin
              } catch (_: ClassNotFoundException) {
                null
              }
            if (resourceClass == null) return@forEach
            if (java.lang.reflect.Modifier.isAbstract(resourceClass.java.modifiers)) return@forEach

            // Load the per-resource search param container object
            val searchParamClass =
              try {
                Class.forName("${testSuite.modelPackage}.search.${resourceName}SearchParam").kotlin
              } catch (_: ClassNotFoundException) {
                null
              }
            if (searchParamClass == null) return@forEach

            val containerInstance = searchParamClass.objectInstance ?: return@forEach

            @Suppress("UNCHECKED_CAST")
            val containerProperties =
              containerInstance::class.memberProperties as Collection<KProperty1<Any, *>>

            val allProperty = containerProperties.firstOrNull { it.name == "ALL" }
            if (allProperty == null) return@forEach

            @Suppress("UNCHECKED_CAST")
            val allSearchParams = allProperty.get(containerInstance) as List<Any>

            // Build a map from data object name to search param instance
            val searchParamsByName = allSearchParams.associateBy { it::class.simpleName!! }

            val dedupedExpected = expectedParams.distinctBy { it.code }.sortedBy { it.code }

            test("$resourceName should have ${dedupedExpected.size} search params") {
              searchParamsByName.size.shouldBe(dedupedExpected.size)
            }

            dedupedExpected.forEach { expected ->
              val dataObjectName = codeToDataObjectName(expected.code)
              test(
                "$resourceName.$dataObjectName should have paramName '${expected.code}' and type '${expected.type}'"
              ) {
                val actual =
                  searchParamsByName[dataObjectName]
                    ?: error(
                      "Missing search param $dataObjectName on ${resourceName}SearchParam. Available: ${searchParamsByName.keys}"
                    )

                // Verify it implements SearchParam
                searchParamInterface.isInstance(actual).shouldBe(true)

                // Verify paramName
                val paramName =
                  actual::class.memberProperties.first { it.name == "paramName" }.call(actual)
                    as String
                paramName.shouldBe(expected.code)

                // Verify type
                val type = actual::class.memberProperties.first { it.name == "type" }.call(actual)
                type.shouldNotBe(null)
                type.toString().shouldBe(expected.type)

                // Verify expression
                val expression =
                  actual::class.memberProperties.first { it.name == "expression" }.call(actual)
                    as String
                val expectedExpression =
                  extractExpressionForResource(expected.expression, resourceName)
                expression.shouldBe(expectedExpression)

                // Verify target — generated as List<KClass<out Resource>>; compare by simple name
                @Suppress("UNCHECKED_CAST")
                val target =
                  actual::class.memberProperties.first { it.name == "target" }.call(actual)
                    as List<kotlin.reflect.KClass<*>>
                target.map { it.simpleName }.shouldBe(expected.target)
              }
            }
          }
        }
      }
  })

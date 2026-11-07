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

package dev.ohs.fhir.codegen.searchparam

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import dev.ohs.fhir.codegen.FhirPathExpressionResolver
import dev.ohs.fhir.codegen.schema.Base
import dev.ohs.fhir.codegen.schema.Binding
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.Type
import dev.ohs.fhir.codegen.schema.valueset.Expansion
import dev.ohs.fhir.codegen.schema.valueset.ValueSet
import kotlin.test.Test
import kotlin.test.assertEquals

class SearchParamTypeResolverTest {

  @Test
  fun resolve_simplePathPrimitiveType_returnsModelPrimitiveClass() {
    assertEquals(ClassName(PKG, "Date"), resolve("Patient", "Patient.birthDate"))
  }

  @Test
  fun resolve_simplePathFhirPathSystemUri_returnsKotlinDataModelType() {
    assertEquals(ClassName("kotlin", "String"), resolve("Resource", "Resource.id"))
  }

  @Test
  fun resolve_codeWithRequiredBinding_returnsEnumerationOfBoundEnum() {
    assertEquals(
      ClassName(PKG, "Enumeration")
        .parameterizedBy(ClassName("$PKG.terminologies", "AdministrativeGender")),
      resolve("Patient", "Patient.gender"),
    )
  }

  @Test
  fun resolve_codeWithExtensibleBinding_returnsExtensibleEnumerationOfBoundEnum() {
    assertEquals(
      ClassName(PKG, "ExtensibleEnumeration")
        .parameterizedBy(ClassName("$PKG.terminologies", "MaritalStatusCodes")),
      resolve("Patient", "Patient.maritalCode"),
    )
  }

  @Test
  fun resolve_codeWithExampleOrUnboundBinding_returnsCode() {
    assertEquals(ClassName(PKG, "Code"), resolve("Patient", "Patient.unboundCode"))
  }

  @Test
  fun resolve_codeInExternalComplexType_returnsEnumerationOfBoundEnum() {
    assertEquals(
      ClassName(PKG, "Enumeration").parameterizedBy(ClassName("$PKG.terminologies", "AddressUse")),
      resolve("Patient", "Patient.address.use"),
    )
  }

  @Test
  fun resolve_backboneElementLeaf_returnsNestedBackboneClass() {
    assertEquals(
      ClassName(PKG, "Observation", "Component"),
      resolve("Observation", "Observation.component"),
    )
  }

  @Test
  fun resolve_choiceElementWithoutCast_returnsSealedInterface() {
    assertEquals(
      ClassName(PKG, "Observation", "Effective"),
      resolve("Observation", "Observation.effective"),
    )
  }

  @Test
  fun resolve_inheritedChoiceElementWithoutCast_returnsBaseSealedInterface() {
    assertEquals(
      ClassName(PKG, "CanonicalResource", "VersionAlgorithm"),
      resolve("MetadataResource", "MetadataResource.versionAlgorithm"),
    )
  }

  @Test
  fun resolve_elementCast_returnsTargetModelType() {
    assertEquals(ClassName(PKG, "DateTime"), resolve("Patient", "(Patient.deceased as dateTime)"))
  }

  @Test
  fun resolve_whereFilterWithoutPostPath_returnsFilteredElementModelType() {
    assertEquals(
      ClassName(PKG, "ContactPoint"),
      resolve("Patient", "Patient.telecom.where(system='email')"),
    )
  }

  @Test
  fun resolve_whereFilterWithPostPath_returnsPostPathLeafType() {
    assertEquals(
      ClassName(PKG, "String"),
      resolve("Patient", "Patient.telecom.where(system='email').value"),
    )
  }

  @Test
  fun resolve_unionWithMatchingCodeTypes_returnsCommonType() {
    assertEquals(
      ClassName(PKG, "Code"),
      resolve(
        "ValueSet",
        "ValueSet.expansion.contains.code | ValueSet.compose.include.concept.code",
      ),
    )
  }

  @Test
  fun resolve_unionWithDifferentBranchTypes_widensToAny() {
    assertEquals(
      ClassName("kotlin", "Any"),
      resolve("Patient", "Patient.deceased.ofType(boolean) | Patient.deceased.ofType(dateTime)"),
    )
  }

  private fun resolve(resourceName: String, expression: String): TypeName {
    val pattern = parseSearchParamExpression(expression, resourceName, resolver)
    return SearchParamTypeResolver.resolve(pattern, PKG, valueSetMap)
  }

  private val valueSetMap =
    mapOf(
      "http://hl7.org/fhir/ValueSet/administrative-gender" to
        ValueSet(
          id = "administrative-gender",
          url = "http://hl7.org/fhir/ValueSet/administrative-gender",
          name = "AdministrativeGender",
          expansion = Expansion(),
        ),
      "http://hl7.org/fhir/ValueSet/marital-status" to
        ValueSet(
          id = "marital-status",
          url = "http://hl7.org/fhir/ValueSet/marital-status",
          name = "MaritalStatusCodes",
          expansion = Expansion(),
        ),
      "http://hl7.org/fhir/ValueSet/address-use" to
        ValueSet(
          id = "address-use",
          url = "http://hl7.org/fhir/ValueSet/address-use",
          name = "AddressUse",
          expansion = Expansion(),
        ),
    )

  private val resolver =
    FhirPathExpressionResolver(
      mapOf(
        "Resource" to listOf(element("Resource.id", "http://hl7.org/fhirpath/System.String")),
        "Patient" to
          listOf(
            element("Patient.birthDate", "date"),
            element(
              "Patient.gender",
              "code",
              binding =
                Binding(
                  strength = "required",
                  valueSet = "http://hl7.org/fhir/ValueSet/administrative-gender|4.0.1",
                ),
            ),
            element(
              "Patient.maritalCode",
              "code",
              binding =
                Binding(
                  strength = "extensible",
                  valueSet = "http://hl7.org/fhir/ValueSet/marital-status",
                ),
            ),
            element(
              "Patient.unboundCode",
              "code",
              binding =
                Binding(
                  strength = "example",
                  valueSet = "http://hl7.org/fhir/ValueSet/untracked",
                ),
            ),
            element("Patient.address", "Address", max = "*"),
            element("Patient.deceased[x]", "boolean", "dateTime"),
            element("Patient.telecom", "ContactPoint", max = "*"),
          ),
        "Address" to
          listOf(
            element(
              "Address.use",
              "code",
              binding =
                Binding(
                  strength = "required",
                  valueSet = "http://hl7.org/fhir/ValueSet/address-use",
                ),
            )
          ),
        "ContactPoint" to
          listOf(element("ContactPoint.system", "code"), element("ContactPoint.value", "string")),
        "Observation" to
          listOf(
            element("Observation.component", "BackboneElement", max = "*"),
            element("Observation.effective[x]", "dateTime", "Period"),
          ),
        "MetadataResource" to
          listOf(
            element(
              "MetadataResource.versionAlgorithm[x]",
              "string",
              "Coding",
              base = Base(path = "CanonicalResource.versionAlgorithm[x]", min = 0, max = "1"),
            )
          ),
        "ValueSet" to
          listOf(
            element("ValueSet.expansion", "BackboneElement"),
            element("ValueSet.expansion.contains", "BackboneElement", max = "*"),
            element("ValueSet.expansion.contains.code", "code"),
            element("ValueSet.compose", "BackboneElement"),
            element("ValueSet.compose.include", "BackboneElement", max = "*"),
            element("ValueSet.compose.include.concept", "BackboneElement", max = "*"),
            element("ValueSet.compose.include.concept.code", "code"),
          ),
      )
    )

  private fun element(
    path: String,
    vararg typeCodes: String,
    max: String = "1",
    binding: Binding? = null,
    base: Base? = null,
  ): Element =
    Element(
      id = path,
      path = path,
      definition = "",
      min = 0,
      max = max,
      base = base,
      isModifier = false,
      type = typeCodes.map { Type(it) },
      binding = binding,
    )

  companion object {
    private const val PKG = "dev.ohs.fhir.model.r4"
  }
}

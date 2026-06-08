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

package dev.ohs.fhir.codegen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName

/**
 * Generates `SearchParamExtensions.kt` in the version's `search` subpackage, holding fluent
 * extension functions for working with `SearchParam`s.
 *
 * Currently emits one helper:
 * ```
 * fun <R : Resource, T> R.extract(param: SearchParam<R, T>): List<T> = param.extractFrom(this)
 * ```
 *
 * which lets call sites read as `patient.extract(PatientSearchParams.birthdate)` instead of
 * `PatientSearchParams.birthdate.extractFrom(patient)`.
 */
object SearchParamExtensionsFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val resourceCN = ClassName(packageName, "Resource")
    val searchParamCN = ClassName("$packageName.search", "SearchParam")

    val r = TypeVariableName("R", resourceCN)
    val t = TypeVariableName("T")
    val listOfT = List::class.asClassName().parameterizedBy(t)

    val extractFn =
      FunSpec.builder("extract")
        .addModifiers(KModifier.PUBLIC, KModifier.INLINE)
        .addKdoc(
          "Extracts the values for [param] from this resource. Equivalent to " +
            "`param.extractFrom(this)`, but reads more fluently at the call site " +
            "(e.g. `patient.extract(PatientSearchParams.birthdate)`)."
        )
        .addTypeVariable(r)
        .addTypeVariable(t)
        .receiver(r)
        .addParameter("param", searchParamCN.parameterizedBy(r, t))
        .returns(listOfT)
        .addStatement("return param.extractFrom(this)")
        .build()

    return FileSpec.builder("$packageName.search", "SearchParamExtensions")
      .addFunction(extractFn)
      .build()
  }
}

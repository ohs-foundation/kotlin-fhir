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

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.WildcardTypeName
import com.squareup.kotlinpoet.asClassName
import kotlin.reflect.KClass

/**
 * Generates a `SearchParam.kt` file with the typed search-parameter class.
 *
 * `SearchParam<R, T>` carries the metadata about a FHIR search parameter (name, type, expression,
 * target) plus an `extractor` lambda. Its `extract(resource)` function delegates to the lambda to
 * pull values of type `T` out of a resource of type `R`. Per-resource container objects (e.g.,
 * `PatientSearchParams`) expose one `val` per search parameter, each holding a `SearchParam`
 * instance.
 */
object SearchParamFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val resourceClassName = ClassName(packageName, "Resource")
    val searchParamTypeClassName = ClassName("$packageName.terminologies", "SearchParamType")

    val listOfTargetClasses =
      List::class.asClassName()
        .parameterizedBy(
          KClass::class.asClassName()
            .parameterizedBy(WildcardTypeName.producerOf(resourceClassName))
        )

    val typeR = TypeVariableName("R", resourceClassName)
    val typeT = TypeVariableName("T")
    val listOfT = List::class.asClassName().parameterizedBy(typeT)
    val extractorType = LambdaTypeName.get(null, typeR, returnType = listOfT)

    val searchParamClass =
      TypeSpec.classBuilder("SearchParam")
        .addModifiers(KModifier.PUBLIC)
        .addTypeVariable(typeR)
        .addTypeVariable(typeT)
        .addKdoc(
          "A typed FHIR search parameter: its metadata plus an `extractor` that pulls typed " +
            "values out of a resource."
        )
        .primaryConstructor(
          FunSpec.constructorBuilder()
            .addParameter("name", String::class)
            .addParameter("type", searchParamTypeClassName)
            .addParameter("expression", String::class)
            .addParameter(
              ParameterSpec.builder("target", listOfTargetClasses)
                .defaultValue("emptyList()")
                .build()
            )
            .addParameter("extractor", extractorType)
            .build()
        )
        .addProperty(
          PropertySpec.builder("name", String::class)
            .addModifiers(KModifier.PUBLIC)
            .initializer("name")
            .addKdoc("The name of the search parameter as used in search URLs.")
            .build()
        )
        .addProperty(
          PropertySpec.builder("type", searchParamTypeClassName)
            .addModifiers(KModifier.PUBLIC)
            .initializer("type")
            .addKdoc("The search parameter type (e.g., date, token, reference).")
            .build()
        )
        .addProperty(
          PropertySpec.builder("expression", String::class)
            .addModifiers(KModifier.PUBLIC)
            .initializer("expression")
            .addKdoc("The FHIRPath expression that extracts values for this search parameter.")
            .build()
        )
        .addProperty(
          PropertySpec.builder("target", listOfTargetClasses)
            .addModifiers(KModifier.PUBLIC)
            .initializer("target")
            .addKdoc("The target resource types for reference search parameters.")
            .build()
        )
        .addProperty(
          PropertySpec.builder("extractor", extractorType)
            .addModifiers(KModifier.PRIVATE)
            .initializer("extractor")
            .build()
        )
        .addFunction(
          FunSpec.builder("extract")
            .addModifiers(KModifier.PUBLIC)
            .addParameter("resource", typeR)
            .returns(listOfT)
            .addStatement("return extractor(resource)")
            .addKdoc("Extracts the values for this search parameter from the given [resource].")
            .build()
        )
        .build()

    return FileSpec.builder("$packageName.search", "SearchParam").addType(searchParamClass).build()
  }
}

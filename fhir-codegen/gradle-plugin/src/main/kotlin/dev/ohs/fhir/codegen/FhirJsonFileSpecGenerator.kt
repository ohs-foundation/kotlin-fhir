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

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import dev.ohs.fhir.codegen.schema.capitalized
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder

/**
 * Generates a [FileSpec] for the JSON serialization API.
 *
 * The generated file includes a `Fhir<VERSION>Json` class. It configures kotlinx.serialization's
 * [Json] object.
 *
 * It exposes the following serialization API:
 * - `encodeToString`
 * - `decodeFromString`
 */
object FhirJsonFileSpecGenerator {
  fun generate(packageName: String): FileSpec {
    val baseClass = ClassName(packageName, "Resource")
    val fhirVersion = packageName.substringAfterLast('.').capitalized()
    val className = ClassName(packageName, "Fhir${fhirVersion}Json")
    return FileSpec.builder(className)
      .addType(
        TypeSpec.classBuilder(className)
          .addAnnotation(
            AnnotationSpec.builder(Deprecated::class)
              .addMember(
                "%S",
                "No longer required. Create a kotlinx.serialization Json instance directly and " +
                  "use it to serialize FHIR resources.",
              )
              .build()
          )
          .primaryConstructor(
            FunSpec.constructorBuilder()
              .addParameter(
                ParameterSpec.builder(
                    "init",
                    LambdaTypeName.get(
                      receiver = JsonBuilder::class.asTypeName(),
                      returnType = Unit::class.asTypeName(),
                    ),
                  )
                  .defaultValue("{}")
                  .build()
              )
              .build()
          )
          .addProperty(
            PropertySpec.builder("json", Json::class)
              .addModifiers(KModifier.PRIVATE)
              .initializer(
                CodeBlock.builder()
                  .addStatement("%T {", Json::class)
                  .indent()
                  .addStatement("prettyPrint = true")
                  .addStatement("init()")
                  .unindent()
                  .addStatement("}")
                  .build()
              )
              .build()
          )
          .addFunction(
            FunSpec.builder("encodeToString")
              .addParameter("resource", baseClass)
              .returns(String::class)
              .addStatement("return json.encodeToString(resource)")
              .build()
          )
          .addFunction(
            FunSpec.builder("decodeFromString")
              .addParameter("string", String::class)
              .returns(baseClass)
              .addStatement("return json.decodeFromString<${baseClass.simpleName}>(string)")
              .build()
          )
          .build()
      )
      .build()
  }
}

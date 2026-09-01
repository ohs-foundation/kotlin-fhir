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

package dev.ohs.fhir.codegen.primitives

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import dev.ohs.fhir.codegen.schema.sanitizeKDoc
import kotlin.text.substringAfterLast

/**
 * Generates [FileSpec] for a FHIR `Enumeration` type bound to a specific set of codes. It is an
 * extension to primitive type `code` and represents a constrained code value from an enumerated
 * list
 */
object EnumerationFileSpecGenerator {
  private const val R4 = "r4"
  private const val R4B = "r4b"
  private const val R5 = "r5"

  fun generate(packageName: String): FileSpec {
    val enumerationTypeSpec =
      TypeSpec.classBuilder("Enumeration")
        .addModifiers(KModifier.DATA)
        .apply {
          val version = packageName.substringAfterLast('.')
          val baseClassName =
            when (version) {
              R4,
              R4B -> "Element"
              R5 -> "PrimitiveType"
              else -> error("Enum generation is not supported for version: $version")
            }
          val typeVariable = TypeVariableName("T", ClassName(packageName, "FhirEnum"))
          val extensionClassName = ClassName(packageName, "Extension")
          val elementClassName = ClassName(packageName, "Element")
          addTypeVariable(typeVariable)
          primaryConstructor(
            FunSpec.constructorBuilder()
              .addParameter(
                ParameterSpec.builder("id", STRING.copy(nullable = true))
                  .defaultValue("null")
                  .addKdoc("unique id for the element within a resource (for internal references)")
                  .build()
              )
              .addParameter(
                ParameterSpec.builder(
                    name = "extension",
                    type =
                      ClassName("kotlin.collections", "List").parameterizedBy(extensionClassName),
                  )
                  .addKdoc(
                    """
                    May be used to represent additional information that is not part of the basic definition of the
                    resource. To make the use of extensions safe and manageable, there is a strict set of governance 
                    applied to the definition and use of extensions.
                    """
                      .trimIndent()
                      .sanitizeKDoc()
                  )
                  .defaultValue("listOf()")
                  .build()
              )
              .addParameter(
                ParameterSpec.builder("value", typeVariable.copy(nullable = true))
                  .defaultValue("null")
                  .addKdoc("The actual value")
                  .build()
              )
              .build()
          )
          addProperty(
            PropertySpec.builder("id", STRING.copy(nullable = true))
              .initializer("id")
              .addModifiers(KModifier.OVERRIDE)
              .build()
          )
          addProperty(
            PropertySpec.builder(
                name = "extension",
                type = ClassName("kotlin.collections", "List").parameterizedBy(extensionClassName),
              )
              .initializer("extension")
              .addModifiers(KModifier.OVERRIDE)
              .build()
          )
          addProperty(
            PropertySpec.builder("value", typeVariable.copy(nullable = true))
              .initializer("value")
              .build()
          )
          superclass(ClassName(packageName, baseClassName))
          if (version == R4 || version == R4B) {
            addSuperclassConstructorParameter("id")
            addSuperclassConstructorParameter("extension")
          }
          addFunction(
            FunSpec.builder("toElement")
              .returns(elementClassName.copy(nullable = true))
              .addStatement(
                "if (id != null || extension.isNotEmpty()) { return Element(id, extension) }"
              )
              .addStatement("return null")
              .build()
          )
          val codeClassName = ClassName(packageName, "Code")
          addFunction(
            FunSpec.builder("toCode")
              .returns(codeClassName)
              .addKdoc(
                """
                Returns this enumeration as an open [Code], preserving `id`, `extension`, and the
                code string of the value (generated enums stringify to their FHIR code).
                """
                  .trimIndent()
                  .sanitizeKDoc()
              )
              .addStatement("return Code(id, extension, value?.toString())")
              .build()
          )
          addType(
            TypeSpec.companionObjectBuilder()
              .addFunction(
                FunSpec.builder("of")
                  .addTypeVariable(typeVariable)
                  .addParameter(
                    ParameterSpec.builder("value", typeVariable.copy(nullable = true)).build()
                  )
                  .addParameter(
                    ParameterSpec.builder("element", elementClassName.copy(nullable = true)).build()
                  )
                  .returns(
                    ClassName("", "Enumeration").parameterizedBy(typeVariable).copy(nullable = true)
                  )
                  .addStatement(
                    "return if (value != null || element?.id != null || element?.extension?.isEmpty() == false) { Enumeration(element?.id, element?.extension ?: listOf(), value = value) } else { null }"
                  )
                  .build()
              )
              .addFunction(
                FunSpec.builder("fromCode")
                  .addTypeVariable(typeVariable)
                  .addParameter(ParameterSpec.builder("code", codeClassName).build())
                  .addParameter(
                    ParameterSpec.builder(
                        "parse",
                        LambdaTypeName.get(parameters = arrayOf(STRING), returnType = typeVariable),
                      )
                      .build()
                  )
                  .returns(ClassName("", "Enumeration").parameterizedBy(typeVariable))
                  .addKdoc(
                    """
                    Builds an [Enumeration] from an open [Code], preserving `id` and `extension` and
                    parsing the code string with the enum's parser, e.g.
                    `Enumeration.fromCode(expression.language, ExpressionLanguage::fromCode)`.
                    """
                      .trimIndent()
                      .sanitizeKDoc()
                  )
                  .addStatement(
                    "return Enumeration(code.id, code.extension, code.value?.let(parse))"
                  )
                  .build()
              )
              .build()
          )
        }
        .addKdoc(
          """
          A FHIR Enumeration type bound to a specific set of codes. It represents a constrained code 
          value from an enumerated list.
          """
            .trimIndent()
            .sanitizeKDoc()
        )
        .build()

    return FileSpec.builder(packageName, "Enumeration").addType(enumerationTypeSpec).build()
  }
}

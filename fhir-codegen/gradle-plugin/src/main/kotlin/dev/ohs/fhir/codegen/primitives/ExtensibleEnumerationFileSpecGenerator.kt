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

/**
 * Generates [FileSpec] for a FHIR `ExtensibleEnumeration` type bound to an extensible or preferred
 * set of codes.
 *
 * It provides a sealed hierarchy that represents either a standard, known enum value
 * ([ExtensibleEnumeration.Known]) or a legal custom code outside the ValueSet
 * ([ExtensibleEnumeration.Custom]).
 */
object ExtensibleEnumerationFileSpecGenerator {

  fun generate(packageName: String): FileSpec {
    val typeVariable = TypeVariableName("T", ClassName(packageName, "FhirEnum"))
    val typeVariableCovariant =
      TypeVariableName("T", listOf(ClassName(packageName, "FhirEnum")), variance = KModifier.OUT)
    val extensionClassName = ClassName(packageName, "Extension")
    val elementClassName = ClassName(packageName, "Element")
    val listExtensionType =
      ClassName("kotlin.collections", "List").parameterizedBy(extensionClassName)
    val extensibleEnumClassName = ClassName(packageName, "ExtensibleEnumeration")

    val extensibleEnumTypeSpec =
      TypeSpec.interfaceBuilder("ExtensibleEnumeration")
        .addModifiers(KModifier.SEALED)
        .addTypeVariable(typeVariableCovariant)
        .addProperty(PropertySpec.builder("id", STRING.copy(nullable = true)).build())
        .addProperty(PropertySpec.builder("extension", listExtensionType).build())
        .addProperty(PropertySpec.builder("rawCode", STRING.copy(nullable = true)).build())
        .addFunction(
          FunSpec.builder("toElement")
            .returns(elementClassName.copy(nullable = true))
            .addStatement(
              "if (id != null || extension.isNotEmpty()) { return Element(id, extension) }"
            )
            .addStatement("return null")
            .build()
        )
        .addType(
          TypeSpec.classBuilder("Known")
            .addModifiers(KModifier.DATA)
            .addTypeVariable(typeVariableCovariant)
            .addSuperinterface(extensibleEnumClassName.parameterizedBy(typeVariable))
            .primaryConstructor(
              FunSpec.constructorBuilder()
                .addParameter("value", typeVariable)
                .addParameter(
                  ParameterSpec.builder("id", STRING.copy(nullable = true))
                    .defaultValue("null")
                    .build()
                )
                .addParameter(
                  ParameterSpec.builder("extension", listExtensionType)
                    .defaultValue("listOf()")
                    .build()
                )
                .build()
            )
            .addProperty(PropertySpec.builder("value", typeVariable).initializer("value").build())
            .addProperty(
              PropertySpec.builder("id", STRING.copy(nullable = true))
                .initializer("id")
                .addModifiers(KModifier.OVERRIDE)
                .build()
            )
            .addProperty(
              PropertySpec.builder("extension", listExtensionType)
                .initializer("extension")
                .addModifiers(KModifier.OVERRIDE)
                .build()
            )
            .addProperty(
              PropertySpec.builder("rawCode", STRING.copy(nullable = true))
                .getter(FunSpec.getterBuilder().addStatement("return value.code").build())
                .addModifiers(KModifier.OVERRIDE)
                .build()
            )
            .addFunction(
              FunSpec.builder("toString")
                .addModifiers(KModifier.OVERRIDE)
                .returns(String::class)
                .addStatement("return value.code")
                .build()
            )
            .build()
        )
        .addType(
          TypeSpec.classBuilder("Custom")
            .addModifiers(KModifier.DATA)
            .addSuperinterface(
              extensibleEnumClassName.parameterizedBy(ClassName("kotlin", "Nothing"))
            )
            .primaryConstructor(
              FunSpec.constructorBuilder()
                .addParameter("rawCode", String::class)
                .addParameter(
                  ParameterSpec.builder("id", STRING.copy(nullable = true))
                    .defaultValue("null")
                    .build()
                )
                .addParameter(
                  ParameterSpec.builder("extension", listExtensionType)
                    .defaultValue("listOf()")
                    .build()
                )
                .build()
            )
            .addProperty(
              PropertySpec.builder("rawCode", String::class)
                .initializer("rawCode")
                .addModifiers(KModifier.OVERRIDE)
                .build()
            )
            .addProperty(
              PropertySpec.builder("id", STRING.copy(nullable = true))
                .initializer("id")
                .addModifiers(KModifier.OVERRIDE)
                .build()
            )
            .addProperty(
              PropertySpec.builder("extension", listExtensionType)
                .initializer("extension")
                .addModifiers(KModifier.OVERRIDE)
                .build()
            )
            .addFunction(
              FunSpec.builder("toString")
                .addModifiers(KModifier.OVERRIDE)
                .returns(String::class)
                .addStatement("return rawCode")
                .build()
            )
            .build()
        )
        .addType(
          TypeSpec.companionObjectBuilder()
            .addFunction(
              FunSpec.builder("of")
                .addTypeVariable(typeVariable)
                .addParameter(ParameterSpec.builder("code", STRING.copy(nullable = true)).build())
                .addParameter(
                  ParameterSpec.builder("element", elementClassName.copy(nullable = true)).build()
                )
                .addParameter(
                  ParameterSpec.builder(
                      "fromCode",
                      LambdaTypeName.get(
                        parameters = listOf(ParameterSpec.builder("code", STRING).build()),
                        returnType = typeVariable.copy(nullable = true),
                      ),
                    )
                    .build()
                )
                .returns(
                  extensibleEnumClassName.parameterizedBy(typeVariable).copy(nullable = true)
                )
                .addCode(
                  """
                  val parsed = code?.let(fromCode)
                  return when {
                    parsed != null -> Known(parsed, element?.id, element?.extension ?: listOf())
                    code != null -> Custom(code, element?.id, element?.extension ?: listOf())
                    element?.id != null || element?.extension?.isNotEmpty() == true ->
                      Custom("", element.id, element.extension)
                    else -> null
                  }
                  """
                    .trimIndent() + "\n"
                )
                .build()
            )
            .addFunction(
              FunSpec.builder("of")
                .addTypeVariable(typeVariable)
                .addParameter(ParameterSpec.builder("value", typeVariable).build())
                .returns(extensibleEnumClassName.parameterizedBy(typeVariable))
                .addStatement("return Known(value)")
                .build()
            )
            .addFunction(
              FunSpec.builder("of")
                .addParameter(ParameterSpec.builder("rawCode", String::class).build())
                .returns(extensibleEnumClassName.parameterizedBy(ClassName("kotlin", "Nothing")))
                .addStatement("return Custom(rawCode)")
                .build()
            )
            .build()
        )
        .addKdoc(
          """
          A FHIR ExtensibleEnumeration type bound to an extensible or preferred set of codes.

          It represents either a recognized standard enum constant ([Known]) or a legal custom code string ([Custom]).
          """
            .trimIndent()
            .sanitizeKDoc()
        )
        .build()

    return FileSpec.builder(packageName, "ExtensibleEnumeration")
      .addType(extensibleEnumTypeSpec)
      .build()
  }
}

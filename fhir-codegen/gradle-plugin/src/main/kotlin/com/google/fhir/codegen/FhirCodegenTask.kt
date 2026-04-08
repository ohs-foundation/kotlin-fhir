/*
 * Copyright 2025-2026 Google LLC
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

package com.google.fhir.codegen

import com.google.fhir.codegen.primitives.DoubleSerializerFileSpecGenerator
import com.google.fhir.codegen.primitives.EnumerationFileSpecGenerator
import com.google.fhir.codegen.primitives.FhirDateFileSpecGenerator
import com.google.fhir.codegen.primitives.FhirDateTimeFileSpecGenerator
import com.google.fhir.codegen.primitives.LocalTimeSerializerFileSpecGenerator
import com.google.fhir.codegen.schema.SearchParameterDefinition
import com.google.fhir.codegen.schema.StructureDefinition
import com.google.fhir.codegen.schema.capitalized
import com.google.fhir.codegen.schema.urlPart
import com.google.fhir.codegen.schema.valueset.ValueSet
import com.squareup.kotlinpoet.ClassName
import kotlinx.serialization.json.Json
import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

@CacheableTask
abstract class FhirCodegenTask : DefaultTask() {
  @get:InputFiles
  @get:PathSensitive(PathSensitivity.NONE)
  // These are files retrieved from third_party/hl7.fhir.<R4|R4B|R5>.core directory
  abstract val corePackageFiles: ConfigurableFileCollection

  @get:InputFiles
  @get:PathSensitive(PathSensitivity.NONE)
  // These are files retrieved from third_party/hl7.fhir.<R4|R4B|R5>.expansion directory
  abstract val expansionPackageFiles: ConfigurableFileCollection

  @get:Input abstract val packageName: Property<String>

  @get:OutputDirectory abstract val outputDirectory: DirectoryProperty

  private val json = Json {
    ignoreUnknownKeys = true
    prettyPrint = true
  }

  @TaskAction
  fun generateCode() {
    // Prepare the output folder
    val outputDir = outputDirectory.get().asFile
    outputDir.deleteRecursively()
    outputDir.mkdirs()

    // Prepare value set maps for each value set inside the expansion package
    val valueSetMap =
      expansionPackageFiles.files
        .asSequence()
        .flatMap { file ->
          file.walkTopDown().filter {
            it.isFile && it.name.matches("^ValueSet.*\\.json$".toRegex())
          }
        }
        .map { json.decodeFromString<ValueSet>(it.readText(Charsets.UTF_8)) }
        .filter {
          // Refer to the section "Excluded ValueSets from Enum Generation" on the README file for
          // the reasons for exclusion
          it.urlPart != "http://hl7.org/fhir/ValueSet/mimetypes" &&
            it.urlPart != "http://hl7.org/fhir/ValueSet/all-languages" &&
            it.urlPart != "http://hl7.org/fhir/ValueSet/use-context"
        }
        .groupBy { it.urlPart }
        .mapValues { it.value.first() }

    // Only use structure definition files for resource types.
    val structureDefinitions =
      corePackageFiles.files
        .asSequence()
        .flatMap { file ->
          // Use structure definitions files
          // NB filtering by file name is only an approximation.
          file.walkTopDown().filter {
            it.isFile && it.name.matches("StructureDefinition-[A-Za-z0-9]*\\.json".toRegex())
          }
        }
        .filter { it.name.startsWith("StructureDefinition") }
        .map { json.decodeFromString<StructureDefinition>(it.readText(Charsets.UTF_8)) }
        .filterNot {
          // Do not generate classes for logical types e.g. `Definition`, `Request`, `Event`, etc.
          it.kind == StructureDefinition.Kind.LOGICAL
        }
        .filterNot {
          // Do not generate metadata resource or canonical resource types as interface inheritance
          // has not been implemented.
          it.name == "MetadataResource" || it.name == "CanonicalResource"
        }
        .filterNot {
          // ???
          it.kind == StructureDefinition.Kind.RESOURCE && it.name != it.id
        }
        .filterNot { it.name == "MetadataResource" || it.name == "CanonicalResource" }
        .filterNot {
          // Filter out files like StructureDefinition-hdlcholesterol.json
          it.baseDefinition?.endsWith(it.type) == true
        }
        .toList()

    // Load search parameter definitions and group by resource type
    val searchParamsByResource =
      corePackageFiles.files
        .asSequence()
        .flatMap { file ->
          file.walkTopDown().filter {
            it.isFile && it.name.matches("SearchParameter-.*\\.json".toRegex())
          }
        }
        .map { json.decodeFromString<SearchParameterDefinition>(it.readText(Charsets.UTF_8)) }
        .flatMap { searchParam -> searchParam.base.map { resource -> resource to searchParam } }
        .groupBy({ it.first }, { it.second })

    val baseClasses =
      structureDefinitions.mapNotNullTo(hashSetOf()) {
        it.baseDefinition?.substringAfterLast('/')?.capitalized()
      }

    val packageName = this.packageName.get()

    val fhirCodegen = FhirCodegen(packageName, valueSetMap, baseClasses, searchParamsByResource)

    structureDefinitions
      .flatMap { fhirCodegen.generateFileSpecs(it) }
      .forEach { it.writeTo(outputDir) }

    val subclasses =
      structureDefinitions
        .mapNotNull {
          if (it.kind != StructureDefinition.Kind.RESOURCE) return@mapNotNull null
          if (it.abstract) return@mapNotNull null
          return@mapNotNull ClassName(packageName, it.name.capitalized())
        }
        .toList()

    FhirJsonFileSpecGenerator.generate(packageName, subclasses).writeTo(outputDir)

    FhirDateTimeFileSpecGenerator.generate(packageName).writeTo(outputDir)
    FhirDateFileSpecGenerator.generate(packageName).writeTo(outputDir)

    // Generates a wrapper for enum types
    EnumerationFileSpecGenerator.generate(packageName).writeTo(outputDir)

    // Generate custom serializers
    val serializersPackageName = "$packageName.serializers"
    DoubleSerializerFileSpecGenerator.generate(serializersPackageName).writeTo(outputDir)
    LocalTimeSerializerFileSpecGenerator.generate(serializersPackageName).writeTo(outputDir)

    FhirJsonTransformerFileSpecGenerator.generate(packageName).writeTo(outputDir)

    SearchParamFileSpecGenerator.generate(packageName).writeTo(outputDir)

    // Generate per-resource search parameter sealed classes
    searchParamsByResource.forEach { (resourceName, params) ->
      ResourceSearchParamFileSpecGenerator.generate(packageName, resourceName, params)
        .writeTo(outputDir)
    }
  }
}

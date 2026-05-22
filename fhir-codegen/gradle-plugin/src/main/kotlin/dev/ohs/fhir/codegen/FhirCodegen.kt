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

import com.squareup.kotlinpoet.FileSpec
import dev.ohs.fhir.codegen.primitives.PrimitiveClassSerializerFileSpecGenerator
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.rootElements
import dev.ohs.fhir.codegen.schema.serializableWithCustomSerializer
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/**
 * Generates [FileSpec]s for a given FHIR StructureDefinition.
 *
 * Produces two files per StructureDefinition:
 * 1. A model file (e.g. `Patient.kt`) with the data class and its BackboneElement nested classes.
 * 2. A serializer file (e.g. `PatientSerializers.kt`) under the `serializers` package with the
 *    streaming `KSerializer<X>` for the data class and each of its BackboneElements.
 */
class FhirCodegen(
  packageName: String,
  valueSetMap: Map<String, ValueSet>,
  baseClassesSet: HashSet<String>,
  typeGraph: TypeGraphAnalyzer,
  primitiveValueIsNonNull: Map<String, Boolean>,
) {

  private val codegenContext =
    CodegenContext(
      packageName = packageName,
      valueSetMap = valueSetMap,
      baseClassNameSet = baseClassesSet,
      typeGraph = typeGraph,
      primitiveValueIsNonNull = primitiveValueIsNonNull,
    )

  private val modelFileSpecGenerator = ModelFileSpecGenerator(codegenContext)
  private val serializerFileSpecGenerator = SerializerFileSpecGenerator(codegenContext)
  private val enumFileSpecGenerator = EnumFileSpecGenerator(codegenContext)

  fun generateFileSpecs(structureDefinition: StructureDefinition): List<FileSpec> {
    val fileSpecs = mutableListOf(modelFileSpecGenerator.generate(structureDefinition))
    if (
      structureDefinition.serializableWithCustomSerializer || structureDefinition.name == "Element"
    ) {
      fileSpecs += serializerFileSpecGenerator.generate(structureDefinition)
    }
    if (structureDefinition.kind == StructureDefinition.Kind.PRIMITIVE_TYPE) {
      generatePrimitiveClassSerializer(structureDefinition)?.let { fileSpecs += it }
    }
    fileSpecs += enumFileSpecGenerator.generate(structureDefinition)
    return fileSpecs
  }

  /**
   * Emits a hand-rolled `KSerializer` for a FHIR primitive wrapper (e.g. `BooleanSerializer`).
   * Needed because the compiler plugin can't synthesize one — `Element` is `@Serializable` and the
   * primitive redeclares `id`/`extension` via `override val`, which would trip the "duplicate
   * serial name" check. A hand-rolled serializer bypasses the plugin entirely.
   */
  private fun generatePrimitiveClassSerializer(
    structureDefinition: StructureDefinition
  ): FileSpec? {
    val primitiveClassName = codegenContext.getModelClassName(structureDefinition)
    val valueElement =
      structureDefinition.rootElements.firstOrNull { it.getElementName() == "value" } ?: return null
    val propertyMapper =
      PropertyMapper(PropertyMapper.MappingContext.MODEL, primitiveClassName, emptyMap())
    val valuePropertyInfo = propertyMapper.mapToProperty(valueElement)
    val valueTypeName = valuePropertyInfo.typeName
    val valueNullable = valueTypeName.isNullable
    val nonNullValueType =
      if (valueNullable) valueTypeName.copy(nullable = false) else valueTypeName
    return PrimitiveClassSerializerFileSpecGenerator.generate(
      primitiveClassName = primitiveClassName,
      valueType = nonNullValueType,
      valueNullable = valueNullable,
    )
  }
}

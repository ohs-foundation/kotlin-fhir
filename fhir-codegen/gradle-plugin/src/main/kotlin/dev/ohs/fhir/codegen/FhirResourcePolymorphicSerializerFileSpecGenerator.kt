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
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec

/**
 * Emits `ResourcePolymorphicSerializer.kt` — a hand-rolled `KSerializer<Resource>`.
 *
 * Decode has two paths:
 * 1. **Streaming peek (fast path, common case).** Calls kotlinx-json's internal
 *    `StreamingJsonDecoder.lexer.peekLeadingMatchingValue("resourceType", isLenient)` — the same
 *    API kotlinx uses for its own discriminator-first polymorphic optimization. On hit, open the
 *    JSON object via `beginStructure`, advance past `resourceType` to a mid-stream
 *    `CompositeDecoder`, then dispatch to the concrete subclass's `deserializeJson(composite)`
 *    streaming loop. No tree allocation.
 * 2. **Tree fallback.** FHIR spec permits `resourceType` anywhere in the object; for the ~1% of
 *    inputs that don't lead with it, or when the decoder isn't a `StreamingJsonDecoder`,
 *    materialize via `decodeJsonElement` and re-enter kotlinx's own `JsonTreeDecoder` via
 *    `json.decodeFromJsonElement(ConcreteSerializer, tree)` — same entry point
 *    (`deserialize(Decoder)`) as the streaming path, just with a tree-backed decoder underneath.
 *    Slower per-field than streaming, but gives path-aware kotlinx error messages for free.
 *
 * We reach the internal `StreamingJsonDecoder` / `AbstractJsonLexer` via a file-level
 * `@Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")`. kotlinx-json's `internal` members compile
 * to public JVM bytecode; the suppress tells kotlinc to stop enforcing the module-level visibility
 * check. Trade-off: kotlinx-json version drift becomes a build break rather than a graceful runtime
 * fallback.
 *
 * Encode: `when (value)` dispatching to each concrete subclass's `serialize`.
 */
object FhirResourcePolymorphicSerializerFileSpecGenerator {
  fun generate(packageName: String, subclasses: List<ClassName>): FileSpec {
    val sorted = subclasses.sorted()
    val serializersPackage = "$packageName.serializers"
    val resourceCN = ClassName(packageName, "Resource")

    val kSerializerCN = ClassName("kotlinx.serialization", "KSerializer")
    val experimentalSerializationApiCN =
      ClassName("kotlinx.serialization", "ExperimentalSerializationApi")
    val internalSerializationApiCN = ClassName("kotlinx.serialization", "InternalSerializationApi")
    val serializationExceptionCN = ClassName("kotlinx.serialization", "SerializationException")
    val polymorphicKindCN = ClassName("kotlinx.serialization.descriptors", "PolymorphicKind")
    val serialDescriptorCN = ClassName("kotlinx.serialization.descriptors", "SerialDescriptor")
    val buildClassSerialDescriptorMN =
      MemberName("kotlinx.serialization.descriptors", "buildClassSerialDescriptor")
    val buildSerialDescriptorMN =
      MemberName("kotlinx.serialization.descriptors", "buildSerialDescriptor")
    val stringSerializerMN = MemberName("kotlinx.serialization.builtins", "serializer")
    val decoderCN = ClassName("kotlinx.serialization.encoding", "Decoder")
    val encoderCN = ClassName("kotlinx.serialization.encoding", "Encoder")
    val jsonDecoderCN = ClassName("kotlinx.serialization.json", "JsonDecoder")
    val streamingJsonDecoderCN =
      ClassName("kotlinx.serialization.json.internal", "StreamingJsonDecoder")
    val jsonObjectMN = MemberName("kotlinx.serialization.json", "jsonObject")
    val jsonPrimitiveMN = MemberName("kotlinx.serialization.json", "jsonPrimitive")
    val contentOrNullMN = MemberName("kotlinx.serialization.json", "contentOrNull")

    // --- Properties ------------------------------------------------------------------------------

    val descriptorProp =
      PropertySpec.builder("descriptor", serialDescriptorCN)
        .addModifiers(KModifier.OVERRIDE)
        .addAnnotation(
          AnnotationSpec.builder(ClassName("kotlin", "OptIn"))
            .addMember("%T::class", experimentalSerializationApiCN)
            .addMember("%T::class", internalSerializationApiCN)
            .build()
        )
        .initializer("%M(%S, %T.SEALED)", buildSerialDescriptorMN, "Resource", polymorphicKindCN)
        .build()

    val discriminatorDescriptorProp =
      PropertySpec.builder("discriminatorDescriptor", serialDescriptorCN)
        .addModifiers(KModifier.PRIVATE)
        .addKdoc(
          "Discriminator-only descriptor: `{ resourceType: String }`. Used on the streaming " +
            "fast path to open the JSON object and advance past the leading discriminator; the " +
            "concrete subclass continues the loop against its own flat-shape descriptor."
        )
        .initializer(
          CodeBlock.builder()
            .add("%M(%S) {\n", buildClassSerialDescriptorMN, "Resource")
            .indent()
            .add(
              "element(%S, %T.%M().descriptor)\n",
              "resourceType",
              ClassName("kotlin", "String"),
              stringSerializerMN,
            )
            .unindent()
            .add("}\n")
            .build()
        )
        .build()

    // --- serialize -------------------------------------------------------------------------------

    val serializeFn =
      FunSpec.builder("serialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("encoder", encoderCN)
        .addParameter("value", resourceCN)
        .addCode(
          CodeBlock.builder()
            .apply {
              add("when (value) {\n")
              indent()
              for (sc in sorted) {
                val serializerCN = ClassName(serializersPackage, "${sc.simpleName}Serializer")
                add(
                  "is %T -> %T.serialize(encoder, value)\n",
                  ClassName(packageName, sc.simpleName),
                  serializerCN,
                )
              }
              add(
                "else -> throw %T(%P)\n",
                serializationExceptionCN,
                "Unknown Resource subtype \${value::class.simpleName}",
              )
              unindent()
              add("}\n")
            }
            .build()
        )
        .build()

    // --- deserialize -----------------------------------------------------------------------------

    val deserializeFn =
      FunSpec.builder("deserialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", decoderCN)
        .returns(resourceCN)
        .addCode(
          CodeBlock.builder()
            .apply {
              add("val jd = decoder as %T\n", jsonDecoderCN)
              add(
                "// Streaming fast path: when the decoder is kotlinx's StreamingJsonDecoder, " +
                  "use its\n"
              )
              add(
                "// internal lexer's `peekLeadingMatchingValue` to read the discriminator " +
                  "without\n"
              )
              add(
                "// consuming state. Returns null if `resourceType` isn't the first key — " +
                  "falls through\n"
              )
              add("// to the tree path.\n")
              add("val peeked: %T? =\n", ClassName("kotlin", "String"))
              indent()
              add("if (jd is %T) {\n", streamingJsonDecoderCN)
              indent()
              add("jd.lexer.peekLeadingMatchingValue(\n")
              indent()
              add("%S,\n", "resourceType")
              add("jd.json.configuration.isLenient,\n")
              unindent()
              add(")\n")
              unindent()
              add("} else null\n")
              unindent()
              add("if (peeked != null) {\n")
              indent()
              add("val composite = jd.beginStructure(discriminatorDescriptor)\n")
              add(
                "// Advance the lexer past `resourceType` before dispatching to the " +
                  "concrete's loop.\n"
              )
              add("composite.decodeElementIndex(discriminatorDescriptor)\n")
              add("composite.decodeStringElement(discriminatorDescriptor, 0)\n")
              add("val result: %T = when (peeked) {\n", resourceCN)
              indent()
              for (sc in sorted) {
                val serializerCN = ClassName(serializersPackage, "${sc.simpleName}Serializer")
                add("%S -> %T.deserializeJson(composite)\n", sc.simpleName, serializerCN)
              }
              add(
                "else -> throw %T(%P)\n",
                serializationExceptionCN,
                "Unknown Resource type \"\$peeked\"",
              )
              unindent()
              add("}\n")
              add("composite.endStructure(discriminatorDescriptor)\n")
              add("return result\n")
              unindent()
              add("}\n")
              add(
                "// Tree fallback — resourceType not first, or non-streaming decoder. Re-enter " +
                  "kotlinx's\n"
              )
              add(
                "// JsonTreeDecoder via `decodeFromJsonElement` so the concrete subclass's " +
                  "regular\n"
              )
              add(
                "// `deserialize(Decoder)` entry runs against a tree-backed CompositeDecoder. " +
                  "Slower\n"
              )
              add("// per-field than streaming but produces path-aware error messages.\n")
              add("val tree = jd.decodeJsonElement().%M\n", jsonObjectMN)
              add("val type = tree[%S]?.%M?.%M\n", "resourceType", jsonPrimitiveMN, contentOrNullMN)
              indent()
              add(
                "?: throw %T(%S)\n",
                serializationExceptionCN,
                "Missing required 'resourceType' discriminator in FHIR Resource JSON",
              )
              unindent()
              add("return when (type) {\n")
              indent()
              for (sc in sorted) {
                val serializerCN = ClassName(serializersPackage, "${sc.simpleName}Serializer")
                add("%S -> jd.json.decodeFromJsonElement(%T, tree)\n", sc.simpleName, serializerCN)
              }
              add(
                "else -> throw %T(%P)\n",
                serializationExceptionCN,
                "Unknown Resource type \"\$type\"",
              )
              unindent()
              add("}\n")
            }
            .build()
        )
        .build()

    // --- Object spec -----------------------------------------------------------------------------

    val objectSpec =
      TypeSpec.objectBuilder("ResourcePolymorphicSerializer")
        .addModifiers(KModifier.INTERNAL)
        .addSuperinterface(kSerializerCN.parameterizedBy(resourceCN))
        .addProperty(descriptorProp)
        .addProperty(discriminatorDescriptorProp)
        .addFunction(serializeFn)
        .addFunction(deserializeFn)
        .build()

    return FileSpec.builder(packageName, "ResourcePolymorphicSerializer")
      .addAnnotation(
        AnnotationSpec.builder(Suppress::class)
          .useSiteTarget(AnnotationSpec.UseSiteTarget.FILE)
          .addMember("%S, %S", "INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
          .build()
      )
      .addType(objectSpec)
      .build()
  }
}

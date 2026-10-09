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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.AnnotationSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Annotation Type: A text note which also contains information about
 * who made the statement and when.
 */
@Serializable(with = AnnotationSerializer::class)
public data class Annotation(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and manageable, there is a strict set of governance
   * applied to the definition and use of extensions. Though any implementer can define an
   * extension, there is a set of requirements that SHALL be met as part of the definition of the
   * extension.
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val extension: List<Extension> = listOf(),
  /**
   * The individual responsible for making the annotation.
   *
   * Organization is used when there's no need for specific attribution as to who made the comment.
   */
  public val author: Author? = null,
  /** Indicates when this particular annotation was made. */
  public val time: DateTime? = null,
  /** The text of the annotation in markdown format. */
  public val text: Markdown,
) : Element(), FhirBuildable {
  override fun toBuilder(): Builder {
    val builder = Builder(text.toBuilder())
    builder.id = id
    builder.extension = extension.toBuilderList()
    builder.author = author
    builder.time = time?.toBuilder()
    return builder
  }

  public sealed interface Author : FhirChoice {
    public fun asReference(): Reference? = this as? Reference

    public fun asString(): String? = this as? String

    public data class Reference(override val `value`: dev.ohs.fhir.model.r4b.Reference) : Author

    public data class String(override val `value`: dev.ohs.fhir.model.r4b.String) : Author

    public companion object {
      internal fun from(
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
        stringValue: dev.ohs.fhir.model.r4b.String?,
      ): Author? {
        if (referenceValue != null) return Reference(referenceValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
    }
  }

  public open class Builder(
    /** The text of the annotation in markdown format. */
    public open var text: Markdown.Builder
  ) : FhirBuilder {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: String? = null

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element. To make the use of extensions safe and manageable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * The individual responsible for making the annotation.
     *
     * Organization is used when there's no need for specific attribution as to who made the
     * comment.
     */
    public open var author: Author? = null

    /** Indicates when this particular annotation was made. */
    public open var time: DateTime.Builder? = null

    open override fun build(): Annotation =
      Annotation(
        id = id,
        extension = extension.buildList(),
        author = author,
        time = time?.build(),
        text = text.build(),
      )
  }
}

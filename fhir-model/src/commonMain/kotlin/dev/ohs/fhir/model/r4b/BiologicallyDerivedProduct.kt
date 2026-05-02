/*
 * Copyright 2026 Google LLC
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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.serializers.BiologicallyDerivedProductCollectionCollectedSerializer
import com.google.fhir.model.r4b.serializers.BiologicallyDerivedProductCollectionSerializer
import com.google.fhir.model.r4b.serializers.BiologicallyDerivedProductManipulationSerializer
import com.google.fhir.model.r4b.serializers.BiologicallyDerivedProductManipulationTimeSerializer
import com.google.fhir.model.r4b.serializers.BiologicallyDerivedProductProcessingSerializer
import com.google.fhir.model.r4b.serializers.BiologicallyDerivedProductProcessingTimeSerializer
import com.google.fhir.model.r4b.serializers.BiologicallyDerivedProductSerializer
import com.google.fhir.model.r4b.serializers.BiologicallyDerivedProductStorageSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A material substance originating from a biological entity intended to be transplanted or infused
 * into another (possibly the same) biological entity.
 */
@Serializable(with = BiologicallyDerivedProductSerializer::class)
@SerialName("BiologicallyDerivedProduct")
public data class BiologicallyDerivedProduct(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
   */
  override val id: kotlin.String? = null,
  /**
   * The metadata about the resource. This is content that is maintained by the infrastructure.
   * Changes to the content might not always be associated with version changes to the resource.
   */
  override val meta: Meta? = null,
  /**
   * A reference to a set of rules that were followed when the resource was constructed, and which
   * must be understood when processing the content. Often, this is a reference to an implementation
   * guide that defines the special rules along with other profiles etc.
   *
   * Asserting this rule set restricts the content to be only understood by a limited set of trading
   * partners. This inherently limits the usefulness of the data in the long term. However, the
   * existing health eco-system is highly fractured, and not yet ready to define, collect, and
   * exchange data in a generally computable sense. Wherever possible, implementers and/or
   * specification writers should avoid using this element. Often, when used, the URL is a reference
   * to an implementation guide that defines these special rules as part of it's narrative along
   * with other profiles, value sets, etc.
   */
  override val implicitRules: Uri? = null,
  /**
   * The base language in which the resource is written.
   *
   * Language is provided to support indexing and accessibility (typically, services such as text to
   * speech use the language tag). The html language tag in the narrative applies to the narrative.
   * The language tag on the resource may be used to specify the language of other presentations
   * generated from the data in the resource. Not all the content has to be in the base language.
   * The Resource.language should not be assumed to apply to the narrative automatically. If a
   * language is specified, it should it also be specified on the div element in the html (see rules
   * in HTML5 for information about the relationship between xml:lang and the html lang attribute).
   */
  override val language: Code? = null,
  /**
   * A human-readable narrative that contains a summary of the resource and can be used to represent
   * the content of the resource to a human. The narrative need not encode all the structured data,
   * but is required to contain sufficient detail to make it "clinically safe" for a human to just
   * read the narrative. Resource definitions may define what content should be represented in the
   * narrative to ensure clinical safety.
   *
   * Contained resources do not have narrative. Resources that are not contained SHOULD have a
   * narrative. In some cases, a resource may only have text with little or no additional discrete
   * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
   * legacy systems where information is captured as a "text blob" or where text is additionally
   * entered raw or narrated and encoded information is added later.
   */
  override val text: Narrative? = null,
  /**
   * These resources do not have an independent existence apart from the resource that contains
   * them - they cannot be identified independently, and nor can they have their own independent
   * transaction scope.
   *
   * This should never be done when the content can be identified properly, as once identification
   * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
   * resources may have profiles and tags In their meta elements, but SHALL NOT have security
   * labels.
   */
  override val contained: List<Resource> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and manageable, there is a strict set of
   * governance applied to the definition and use of extensions. Though any implementer can define
   * an extension, there is a set of requirements that SHALL be met as part of the definition of the
   * extension.
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val extension: List<Extension> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource and that modifies the understanding of the element that contains it and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and manageable, there is a strict
   * set of governance applied to the definition and use of extensions. Though any implementer is
   * allowed to define an extension, there is a set of requirements that SHALL be met as part of the
   * definition of the extension. Applications processing a resource are required to check for
   * modifier extensions.
   *
   * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource
   * (including cannot change the meaning of modifierExtension itself).
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val modifierExtension: List<Extension> = listOf(),
  /**
   * This records identifiers associated with this biologically derived product instance that are
   * defined by business processes and/or used to refer to it when a direct URL reference to the
   * resource itself is not appropriate (e.g. in CDA documents, or in written / printed
   * documentation).
   */
  public val identifier: List<Identifier> = listOf(),
  /** Broad category of this product. */
  public val productCategory: Enumeration<BiologicallyDerivedProductCategory>? = null,
  /** A code that identifies the kind of this biologically derived product (SNOMED Ctcode). */
  public val productCode: CodeableConcept? = null,
  /** Whether the product is currently available. */
  public val status: Enumeration<BiologicallyDerivedProductStatus>? = null,
  /** Procedure request to obtain this biologically derived product. */
  public val request: List<Reference> = listOf(),
  /** Number of discrete units within this product. */
  public val quantity: Integer? = null,
  /**
   * Parent product (if any).
   *
   * For products that have multiple collections. For example Peripheral Blood Stem Cells may be
   * collected over several days from a single donor and the donation split into in multiple
   * containers which must be linked to the parent donation.
   */
  public val parent: List<Reference> = listOf(),
  /** How this product was collected. */
  public val collection: Collection? = null,
  /**
   * Any processing of the product during collection that does not change the fundamental nature of
   * the product. For example adding anti-coagulants during the collection of Peripheral Blood Stem
   * Cells.
   */
  public val processing: List<Processing> = listOf(),
  /**
   * Any manipulation of product post-collection that is intended to alter the product. For example
   * a buffy-coat enrichment or CD8 reduction of Peripheral Blood Stem Cells to make it more
   * suitable for infusion.
   */
  public val manipulation: Manipulation? = null,
  /** Product storage. */
  public val storage: List<Storage> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        productCategory = this@with.productCategory
        productCode = this@with.productCode?.toBuilder()
        status = this@with.status
        request = this@with.request.map { it.toBuilder() }.toMutableList()
        quantity = this@with.quantity?.toBuilder()
        parent = this@with.parent.map { it.toBuilder() }.toMutableList()
        collection = this@with.collection?.toBuilder()
        processing = this@with.processing.map { it.toBuilder() }.toMutableList()
        manipulation = this@with.manipulation?.toBuilder()
        storage = this@with.storage.map { it.toBuilder() }.toMutableList()
      }
    }

  /** How this product was collected. */
  @Serializable(with = BiologicallyDerivedProductCollectionSerializer::class)
  public data class Collection(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val modifierExtension: List<Extension> = listOf(),
    /** Healthcare professional who is performing the collection. */
    public val collector: Reference? = null,
    /**
     * The patient or entity, such as a hospital or vendor in the case of a
     * processed/manipulated/manufactured product, providing the product.
     */
    public val source: Reference? = null,
    /** Time of product collection. */
    public val collected: Collected? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          collector = this@with.collector?.toBuilder()
          source = this@with.source?.toBuilder()
          collected = this@with.collected
        }
      }

    @Serializable(with = BiologicallyDerivedProductCollectionCollectedSerializer::class)
    public sealed interface Collected {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asPeriod(): Period? = this as? Period

      public data class DateTime(public val `value`: com.google.fhir.model.r4b.DateTime) :
        Collected

      public data class Period(public val `value`: com.google.fhir.model.r4b.Period) : Collected

      public companion object {
        internal fun from(
          dateTimeValue: com.google.fhir.model.r4b.DateTime?,
          periodValue: com.google.fhir.model.r4b.Period?,
        ): Collected? {
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
      }
    }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and manageable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /** Healthcare professional who is performing the collection. */
      public var collector: Reference.Builder? = null

      /**
       * The patient or entity, such as a hospital or vendor in the case of a
       * processed/manipulated/manufactured product, providing the product.
       */
      public var source: Reference.Builder? = null

      /** Time of product collection. */
      public var collected: Collected? = null

      public fun build(): Collection =
        Collection(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          collector = collector?.build(),
          source = source?.build(),
          collected = collected,
        )
    }
  }

  /**
   * Any processing of the product during collection that does not change the fundamental nature of
   * the product. For example adding anti-coagulants during the collection of Peripheral Blood Stem
   * Cells.
   */
  @Serializable(with = BiologicallyDerivedProductProcessingSerializer::class)
  public data class Processing(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val modifierExtension: List<Extension> = listOf(),
    /** Description of of processing. */
    public val description: String? = null,
    /** Procesing code. */
    public val procedure: CodeableConcept? = null,
    /** Substance added during processing. */
    public val additive: Reference? = null,
    /** Time of processing. */
    public val time: Time? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          procedure = this@with.procedure?.toBuilder()
          additive = this@with.additive?.toBuilder()
          time = this@with.time
        }
      }

    @Serializable(with = BiologicallyDerivedProductProcessingTimeSerializer::class)
    public sealed interface Time {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asPeriod(): Period? = this as? Period

      public data class DateTime(public val `value`: com.google.fhir.model.r4b.DateTime) : Time

      public data class Period(public val `value`: com.google.fhir.model.r4b.Period) : Time

      public companion object {
        internal fun from(
          dateTimeValue: com.google.fhir.model.r4b.DateTime?,
          periodValue: com.google.fhir.model.r4b.Period?,
        ): Time? {
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
      }
    }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and manageable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /** Description of of processing. */
      public var description: String.Builder? = null

      /** Procesing code. */
      public var procedure: CodeableConcept.Builder? = null

      /** Substance added during processing. */
      public var additive: Reference.Builder? = null

      /** Time of processing. */
      public var time: Time? = null

      public fun build(): Processing =
        Processing(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          description = description?.build(),
          procedure = procedure?.build(),
          additive = additive?.build(),
          time = time,
        )
    }
  }

  /**
   * Any manipulation of product post-collection that is intended to alter the product. For example
   * a buffy-coat enrichment or CD8 reduction of Peripheral Blood Stem Cells to make it more
   * suitable for infusion.
   */
  @Serializable(with = BiologicallyDerivedProductManipulationSerializer::class)
  public data class Manipulation(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val modifierExtension: List<Extension> = listOf(),
    /** Description of manipulation. */
    public val description: String? = null,
    /** Time of manipulation. */
    public val time: Time? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          time = this@with.time
        }
      }

    @Serializable(with = BiologicallyDerivedProductManipulationTimeSerializer::class)
    public sealed interface Time {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asPeriod(): Period? = this as? Period

      public data class DateTime(public val `value`: com.google.fhir.model.r4b.DateTime) : Time

      public data class Period(public val `value`: com.google.fhir.model.r4b.Period) : Time

      public companion object {
        internal fun from(
          dateTimeValue: com.google.fhir.model.r4b.DateTime?,
          periodValue: com.google.fhir.model.r4b.Period?,
        ): Time? {
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
      }
    }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and manageable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /** Description of manipulation. */
      public var description: String.Builder? = null

      /** Time of manipulation. */
      public var time: Time? = null

      public fun build(): Manipulation =
        Manipulation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          description = description?.build(),
          time = time,
        )
    }
  }

  /** Product storage. */
  @Serializable(with = BiologicallyDerivedProductStorageSerializer::class)
  public data class Storage(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val modifierExtension: List<Extension> = listOf(),
    /** Description of storage. */
    public val description: String? = null,
    /** Storage temperature. */
    public val temperature: Decimal? = null,
    /** Temperature scale used. */
    public val scale: Enumeration<BiologicallyDerivedProductStorageScale>? = null,
    /** Storage timeperiod. */
    public val duration: Period? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          temperature = this@with.temperature?.toBuilder()
          scale = this@with.scale
          duration = this@with.duration?.toBuilder()
        }
      }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and manageable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /** Description of storage. */
      public var description: String.Builder? = null

      /** Storage temperature. */
      public var temperature: Decimal.Builder? = null

      /** Temperature scale used. */
      public var scale: Enumeration<BiologicallyDerivedProductStorageScale>? = null

      /** Storage timeperiod. */
      public var duration: Period.Builder? = null

      public fun build(): Storage =
        Storage(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          description = description?.build(),
          temperature = temperature?.build(),
          scale = scale,
          duration = duration?.build(),
        )
    }
  }

  public class Builder() : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
     */
    public var id: kotlin.String? = null

    /**
     * The metadata about the resource. This is content that is maintained by the infrastructure.
     * Changes to the content might not always be associated with version changes to the resource.
     */
    public var meta: Meta.Builder? = null

    /**
     * A reference to a set of rules that were followed when the resource was constructed, and which
     * must be understood when processing the content. Often, this is a reference to an
     * implementation guide that defines the special rules along with other profiles etc.
     *
     * Asserting this rule set restricts the content to be only understood by a limited set of
     * trading partners. This inherently limits the usefulness of the data in the long term.
     * However, the existing health eco-system is highly fractured, and not yet ready to define,
     * collect, and exchange data in a generally computable sense. Wherever possible, implementers
     * and/or specification writers should avoid using this element. Often, when used, the URL is a
     * reference to an implementation guide that defines these special rules as part of it's
     * narrative along with other profiles, value sets, etc.
     */
    public var implicitRules: Uri.Builder? = null

    /**
     * The base language in which the resource is written.
     *
     * Language is provided to support indexing and accessibility (typically, services such as text
     * to speech use the language tag). The html language tag in the narrative applies to the
     * narrative. The language tag on the resource may be used to specify the language of other
     * presentations generated from the data in the resource. Not all the content has to be in the
     * base language. The Resource.language should not be assumed to apply to the narrative
     * automatically. If a language is specified, it should it also be specified on the div element
     * in the html (see rules in HTML5 for information about the relationship between xml:lang and
     * the html lang attribute).
     */
    public var language: Code.Builder? = null

    /**
     * A human-readable narrative that contains a summary of the resource and can be used to
     * represent the content of the resource to a human. The narrative need not encode all the
     * structured data, but is required to contain sufficient detail to make it "clinically safe"
     * for a human to just read the narrative. Resource definitions may define what content should
     * be represented in the narrative to ensure clinical safety.
     *
     * Contained resources do not have narrative. Resources that are not contained SHOULD have a
     * narrative. In some cases, a resource may only have text with little or no additional discrete
     * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
     * legacy systems where information is captured as a "text blob" or where text is additionally
     * entered raw or narrated and encoded information is added later.
     */
    public var text: Narrative.Builder? = null

    /**
     * These resources do not have an independent existence apart from the resource that contains
     * them - they cannot be identified independently, and nor can they have their own independent
     * transaction scope.
     *
     * This should never be done when the content can be identified properly, as once identification
     * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
     * resources may have profiles and tags In their meta elements, but SHALL NOT have security
     * labels.
     */
    public var contained: MutableList<Resource.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource. To make the use of extensions safe and manageable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public var extension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource and that modifies the understanding of the element that contains it and/or the
     * understanding of the containing element's descendants. Usually modifier elements provide
     * negation or qualification. To make the use of extensions safe and manageable, there is a
     * strict set of governance applied to the definition and use of extensions. Though any
     * implementer is allowed to define an extension, there is a set of requirements that SHALL be
     * met as part of the definition of the extension. Applications processing a resource are
     * required to check for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * This records identifiers associated with this biologically derived product instance that are
     * defined by business processes and/or used to refer to it when a direct URL reference to the
     * resource itself is not appropriate (e.g. in CDA documents, or in written / printed
     * documentation).
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Broad category of this product. */
    public var productCategory: Enumeration<BiologicallyDerivedProductCategory>? = null

    /** A code that identifies the kind of this biologically derived product (SNOMED Ctcode). */
    public var productCode: CodeableConcept.Builder? = null

    /** Whether the product is currently available. */
    public var status: Enumeration<BiologicallyDerivedProductStatus>? = null

    /** Procedure request to obtain this biologically derived product. */
    public var request: MutableList<Reference.Builder> = mutableListOf()

    /** Number of discrete units within this product. */
    public var quantity: Integer.Builder? = null

    /**
     * Parent product (if any).
     *
     * For products that have multiple collections. For example Peripheral Blood Stem Cells may be
     * collected over several days from a single donor and the donation split into in multiple
     * containers which must be linked to the parent donation.
     */
    public var parent: MutableList<Reference.Builder> = mutableListOf()

    /** How this product was collected. */
    public var collection: Collection.Builder? = null

    /**
     * Any processing of the product during collection that does not change the fundamental nature
     * of the product. For example adding anti-coagulants during the collection of Peripheral Blood
     * Stem Cells.
     */
    public var processing: MutableList<Processing.Builder> = mutableListOf()

    /**
     * Any manipulation of product post-collection that is intended to alter the product. For
     * example a buffy-coat enrichment or CD8 reduction of Peripheral Blood Stem Cells to make it
     * more suitable for infusion.
     */
    public var manipulation: Manipulation.Builder? = null

    /** Product storage. */
    public var storage: MutableList<Storage.Builder> = mutableListOf()

    override fun build(): BiologicallyDerivedProduct =
      BiologicallyDerivedProduct(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        productCategory = productCategory,
        productCode = productCode?.build(),
        status = status,
        request = request.map { it.build() },
        quantity = quantity?.build(),
        parent = parent.map { it.build() },
        collection = collection?.build(),
        processing = processing.map { it.build() },
        manipulation = manipulation?.build(),
        storage = storage.map { it.build() },
      )
  }

  /** BiologicallyDerived Product Storage Scale. */
  public enum class BiologicallyDerivedProductStorageScale(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Farenheit("farenheit", "http://hl7.org/fhir/product-storage-scale", "Fahrenheit"),
    Celsius("celsius", "http://hl7.org/fhir/product-storage-scale", "Celsius"),
    Kelvin("kelvin", "http://hl7.org/fhir/product-storage-scale", "Kelvin");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): BiologicallyDerivedProductStorageScale =
        when (code) {
          "farenheit" -> Farenheit
          "celsius" -> Celsius
          "kelvin" -> Kelvin
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum BiologicallyDerivedProductStorageScale"
            )
        }
    }
  }

  /** Biologically Derived Product Category. */
  public enum class BiologicallyDerivedProductCategory(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Organ("organ", "http://hl7.org/fhir/product-category", "Organ"),
    Tissue("tissue", "http://hl7.org/fhir/product-category", "Tissue"),
    Fluid("fluid", "http://hl7.org/fhir/product-category", "Fluid"),
    Cells("cells", "http://hl7.org/fhir/product-category", "Cells"),
    BiologicalAgent("biologicalAgent", "http://hl7.org/fhir/product-category", "BiologicalAgent");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): BiologicallyDerivedProductCategory =
        when (code) {
          "organ" -> Organ
          "tissue" -> Tissue
          "fluid" -> Fluid
          "cells" -> Cells
          "biologicalAgent" -> BiologicalAgent
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum BiologicallyDerivedProductCategory"
            )
        }
    }
  }

  /** Biologically Derived Product Status. */
  public enum class BiologicallyDerivedProductStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Available("available", "http://hl7.org/fhir/product-status", "Available"),
    Unavailable("unavailable", "http://hl7.org/fhir/product-status", "Unavailable");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): BiologicallyDerivedProductStatus =
        when (code) {
          "available" -> Available
          "unavailable" -> Unavailable
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum BiologicallyDerivedProductStatus"
            )
        }
    }
  }
}

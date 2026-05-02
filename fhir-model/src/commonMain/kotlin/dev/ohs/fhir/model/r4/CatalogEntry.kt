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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.serializers.CatalogEntryRelatedEntrySerializer
import com.google.fhir.model.r4.serializers.CatalogEntrySerializer
import com.google.fhir.model.r4.terminologies.PublicationStatus
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** Catalog entries are wrappers that contextualize items included in a catalog. */
@Serializable(with = CatalogEntrySerializer::class)
@SerialName("CatalogEntry")
public data class CatalogEntry(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
   */
  override val id: String? = null,
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
   * Used in supporting different identifiers for the same product, e.g. manufacturer code and
   * retailer code.
   */
  public val identifier: List<Identifier> = listOf(),
  /** The type of item - medication, device, service, protocol or other. */
  public val type: CodeableConcept? = null,
  /** Whether the entry represents an orderable item. */
  public val orderable: Boolean,
  /** The item in a catalog or definition. */
  public val referencedItem: Reference,
  /** Used in supporting related concepts, e.g. NDC to RxNorm. */
  public val additionalIdentifier: List<Identifier> = listOf(),
  /** Classes of devices, or ATC for medication. */
  public val classification: List<CodeableConcept> = listOf(),
  /**
   * Used to support catalog exchange even for unsupported products, e.g. getting list of
   * medications even if not prescribable.
   */
  public val status: Enumeration<PublicationStatus>? = null,
  /** The time period in which this catalog entry is expected to be active. */
  public val validityPeriod: Period? = null,
  /** The date until which this catalog entry is expected to be active. */
  public val validTo: DateTime? = null,
  /**
   * Typically date of issue is different from the beginning of the validity. This can be used to
   * see when an item was last updated.
   *
   * Perhaps not needed - if we use fhir resource metadata.
   */
  public val lastUpdated: DateTime? = null,
  /** Used for examplefor Out of Formulary, or any specifics. */
  public val additionalCharacteristic: List<CodeableConcept> = listOf(),
  /** User for example for ATC classification, or. */
  public val additionalClassification: List<CodeableConcept> = listOf(),
  /** Used for example, to point to a substance, or to a device used to administer a medication. */
  public val relatedEntry: List<RelatedEntry> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(orderable.toBuilder(), referencedItem.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        type = this@with.type?.toBuilder()
        additionalIdentifier = this@with.additionalIdentifier.map { it.toBuilder() }.toMutableList()
        classification = this@with.classification.map { it.toBuilder() }.toMutableList()
        status = this@with.status
        validityPeriod = this@with.validityPeriod?.toBuilder()
        validTo = this@with.validTo?.toBuilder()
        lastUpdated = this@with.lastUpdated?.toBuilder()
        additionalCharacteristic =
          this@with.additionalCharacteristic.map { it.toBuilder() }.toMutableList()
        additionalClassification =
          this@with.additionalClassification.map { it.toBuilder() }.toMutableList()
        relatedEntry = this@with.relatedEntry.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Used for example, to point to a substance, or to a device used to administer a medication. */
  @Serializable(with = CatalogEntryRelatedEntrySerializer::class)
  public data class RelatedEntry(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /**
     * The type of relation to the related item: child, parent, packageContent, containerPackage,
     * usedIn, uses, requires, etc.
     */
    public val relationtype: Enumeration<CatalogEntryRelationType>,
    /** The reference to the related item. */
    public val item: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(relationtype, item.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * The type of relation to the related item: child, parent, packageContent, containerPackage,
       * usedIn, uses, requires, etc.
       */
      public var relationtype: Enumeration<CatalogEntryRelationType>,
      /** The reference to the related item. */
      public var item: Reference.Builder,
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      public fun build(): RelatedEntry =
        RelatedEntry(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          relationtype = relationtype,
          item = item.build(),
        )
    }
  }

  public class Builder(
    /** Whether the entry represents an orderable item. */
    public var orderable: Boolean.Builder,
    /** The item in a catalog or definition. */
    public var referencedItem: Reference.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
     */
    public var id: String? = null

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
     * Used in supporting different identifiers for the same product, e.g. manufacturer code and
     * retailer code.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** The type of item - medication, device, service, protocol or other. */
    public var type: CodeableConcept.Builder? = null

    /** Used in supporting related concepts, e.g. NDC to RxNorm. */
    public var additionalIdentifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Classes of devices, or ATC for medication. */
    public var classification: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Used to support catalog exchange even for unsupported products, e.g. getting list of
     * medications even if not prescribable.
     */
    public var status: Enumeration<PublicationStatus>? = null

    /** The time period in which this catalog entry is expected to be active. */
    public var validityPeriod: Period.Builder? = null

    /** The date until which this catalog entry is expected to be active. */
    public var validTo: DateTime.Builder? = null

    /**
     * Typically date of issue is different from the beginning of the validity. This can be used to
     * see when an item was last updated.
     *
     * Perhaps not needed - if we use fhir resource metadata.
     */
    public var lastUpdated: DateTime.Builder? = null

    /** Used for examplefor Out of Formulary, or any specifics. */
    public var additionalCharacteristic: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** User for example for ATC classification, or. */
    public var additionalClassification: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Used for example, to point to a substance, or to a device used to administer a medication.
     */
    public var relatedEntry: MutableList<RelatedEntry.Builder> = mutableListOf()

    override fun build(): CatalogEntry =
      CatalogEntry(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        type = type?.build(),
        orderable = orderable.build(),
        referencedItem = referencedItem.build(),
        additionalIdentifier = additionalIdentifier.map { it.build() },
        classification = classification.map { it.build() },
        status = status,
        validityPeriod = validityPeriod?.build(),
        validTo = validTo?.build(),
        lastUpdated = lastUpdated?.build(),
        additionalCharacteristic = additionalCharacteristic.map { it.build() },
        additionalClassification = additionalClassification.map { it.build() },
        relatedEntry = relatedEntry.map { it.build() },
      )
  }

  /** The type of relations between entries. */
  public enum class CatalogEntryRelationType(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Triggers("triggers", "http://hl7.org/fhir/relation-type", "Triggers"),
    Is_Replaced_By("is-replaced-by", "http://hl7.org/fhir/relation-type", "Replaced By");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): CatalogEntryRelationType =
        when (code) {
          "triggers" -> Triggers
          "is-replaced-by" -> Is_Replaced_By
          else ->
            throw IllegalArgumentException("Unknown code $code for enum CatalogEntryRelationType")
        }
    }
  }
}

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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.BiologicallyDerivedProductDispensePerformerSerializer
import dev.ohs.fhir.model.r5.serializers.BiologicallyDerivedProductDispenseSerializer
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A record of dispensation of a biologically derived product. */
@Serializable(with = BiologicallyDerivedProductDispenseSerializer::class)
@SerialName("BiologicallyDerivedProductDispense")
public data class BiologicallyDerivedProductDispense(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
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
   * to an implementation guide that defines these special rules as part of its narrative along with
   * other profiles, value sets, etc.
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
   * Contained resources do not have a narrative. Resources that are not contained SHOULD have a
   * narrative. In some cases, a resource may only have text with little or no additional discrete
   * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
   * legacy systems where information is captured as a "text blob" or where text is additionally
   * entered raw or narrated and encoded information is added later.
   */
  override val text: Narrative? = null,
  /**
   * These resources do not have an independent existence apart from the resource that contains
   * them - they cannot be identified independently, nor can they have their own independent
   * transaction scope. This is allowed to be a Parameters resource if and only if it is referenced
   * by a resource that provides context/meaning.
   *
   * This should never be done when the content can be identified properly, as once identification
   * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
   * resources may have profiles and tags in their meta elements, but SHALL NOT have security
   * labels.
   */
  override val contained: List<Resource> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and managable, there is a strict set of governance
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
   * May be used to represent additional information that is not part of the basic definition of the
   * resource and that modifies the understanding of the element that contains it and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and managable, there is a strict
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
   * Unique instance identifiers assigned to a biologically derived product dispense. Note: This is
   * a business identifier, not a resource identifier.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The order or request that the dispense is fulfilling. This is a reference to a ServiceRequest
   * resource.
   */
  public val basedOn: List<Reference> = listOf(),
  /** A larger event of which this particular event is a component. */
  public val partOf: List<Reference> = listOf(),
  /** A code specifying the state of the dispense event. */
  public val status: Enumeration<BiologicallyDerivedProductDispenseCodes>,
  /**
   * Indicates the relationship between the donor of the biologically derived product and the
   * intended recipient.
   */
  public val originRelationshipType: CodeableConcept? = null,
  /** A link to a resource identifying the biologically derived product that is being dispensed. */
  public val product: Reference,
  /** A link to a resource representing the patient that the product is dispensed for. */
  public val patient: Reference,
  /** Indicates the type of matching associated with the dispense. */
  public val matchStatus: CodeableConcept? = null,
  /** Indicates who or what performed an action. */
  public val performer: List<Performer> = listOf(),
  /** The physical location where the dispense was performed. */
  public val location: Reference? = null,
  /**
   * The amount of product in the dispense. Quantity will depend on the product being dispensed.
   * Examples are: volume; cell count; concentration.
   */
  public val quantity: Quantity? = null,
  /** When the product was selected/ matched. */
  public val preparedDate: DateTime? = null,
  /** When the product was dispatched for clinical use. */
  public val whenHandedOver: DateTime? = null,
  /** Link to a resource identifying the physical location that the product was dispatched to. */
  public val destination: Reference? = null,
  /** Additional notes. */
  public val note: List<Annotation> = listOf(),
  /** Specific instructions for use. */
  public val usageInstruction: String? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, product.toBuilder(), patient.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
        originRelationshipType = this@with.originRelationshipType?.toBuilder()
        matchStatus = this@with.matchStatus?.toBuilder()
        performer = this@with.performer.map { it.toBuilder() }.toMutableList()
        location = this@with.location?.toBuilder()
        quantity = this@with.quantity?.toBuilder()
        preparedDate = this@with.preparedDate?.toBuilder()
        whenHandedOver = this@with.whenHandedOver?.toBuilder()
        destination = this@with.destination?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        usageInstruction = this@with.usageInstruction?.toBuilder()
      }
    }

  /** Indicates who or what performed an action. */
  @Serializable(with = BiologicallyDerivedProductDispensePerformerSerializer::class)
  public data class Performer(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element. To make the use of extensions safe and managable, there is a strict set of
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
     * provide negation or qualification. To make the use of extensions safe and managable, there is
     * a strict set of governance applied to the definition and use of extensions. Though any
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
    /** Identifies the function of the performer during the dispense. */
    public val function: CodeableConcept? = null,
    /** Identifies the person responsible for the action. */
    public val actor: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(actor.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          function = this@with.function?.toBuilder()
        }
      }

    public class Builder(
      /** Identifies the person responsible for the action. */
      public var actor: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and managable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and managable, there
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

      /** Identifies the function of the performer during the dispense. */
      public var function: CodeableConcept.Builder? = null

      public fun build(): Performer =
        Performer(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          function = function?.build(),
          actor = actor.build(),
        )
    }
  }

  public class Builder(
    /** A code specifying the state of the dispense event. */
    public var status: Enumeration<BiologicallyDerivedProductDispenseCodes>,
    /**
     * A link to a resource identifying the biologically derived product that is being dispensed.
     */
    public var product: Reference.Builder,
    /** A link to a resource representing the patient that the product is dispensed for. */
    public var patient: Reference.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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
     * reference to an implementation guide that defines these special rules as part of its
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
     * Contained resources do not have a narrative. Resources that are not contained SHOULD have a
     * narrative. In some cases, a resource may only have text with little or no additional discrete
     * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
     * legacy systems where information is captured as a "text blob" or where text is additionally
     * entered raw or narrated and encoded information is added later.
     */
    public var text: Narrative.Builder? = null

    /**
     * These resources do not have an independent existence apart from the resource that contains
     * them - they cannot be identified independently, nor can they have their own independent
     * transaction scope. This is allowed to be a Parameters resource if and only if it is
     * referenced by a resource that provides context/meaning.
     *
     * This should never be done when the content can be identified properly, as once identification
     * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
     * resources may have profiles and tags in their meta elements, but SHALL NOT have security
     * labels.
     */
    public var contained: MutableList<Resource.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource. To make the use of extensions safe and managable, there is a strict set of
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
     * negation or qualification. To make the use of extensions safe and managable, there is a
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
     * Unique instance identifiers assigned to a biologically derived product dispense. Note: This
     * is a business identifier, not a resource identifier.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The order or request that the dispense is fulfilling. This is a reference to a ServiceRequest
     * resource.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /** A larger event of which this particular event is a component. */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Indicates the relationship between the donor of the biologically derived product and the
     * intended recipient.
     */
    public var originRelationshipType: CodeableConcept.Builder? = null

    /** Indicates the type of matching associated with the dispense. */
    public var matchStatus: CodeableConcept.Builder? = null

    /** Indicates who or what performed an action. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /** The physical location where the dispense was performed. */
    public var location: Reference.Builder? = null

    /**
     * The amount of product in the dispense. Quantity will depend on the product being dispensed.
     * Examples are: volume; cell count; concentration.
     */
    public var quantity: Quantity.Builder? = null

    /** When the product was selected/ matched. */
    public var preparedDate: DateTime.Builder? = null

    /** When the product was dispatched for clinical use. */
    public var whenHandedOver: DateTime.Builder? = null

    /** Link to a resource identifying the physical location that the product was dispatched to. */
    public var destination: Reference.Builder? = null

    /** Additional notes. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** Specific instructions for use. */
    public var usageInstruction: String.Builder? = null

    override fun build(): BiologicallyDerivedProductDispense =
      BiologicallyDerivedProductDispense(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        basedOn = basedOn.map { it.build() },
        partOf = partOf.map { it.build() },
        status = status,
        originRelationshipType = originRelationshipType?.build(),
        product = product.build(),
        patient = patient.build(),
        matchStatus = matchStatus?.build(),
        performer = performer.map { it.build() },
        location = location?.build(),
        quantity = quantity?.build(),
        preparedDate = preparedDate?.build(),
        whenHandedOver = whenHandedOver?.build(),
        destination = destination?.build(),
        note = note.map { it.build() },
        usageInstruction = usageInstruction?.build(),
      )
  }

  /** BiologicallyDerivedProductDispense Status Codes */
  public enum class BiologicallyDerivedProductDispenseCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Preparation(
      "preparation",
      "http://hl7.org/fhir/biologicallyderivedproductdispense-status",
      "Preparation",
    ),
    In_Progress(
      "in-progress",
      "http://hl7.org/fhir/biologicallyderivedproductdispense-status",
      "In Progress",
    ),
    Allocated(
      "allocated",
      "http://hl7.org/fhir/biologicallyderivedproductdispense-status",
      "Allocated",
    ),
    Issued("issued", "http://hl7.org/fhir/biologicallyderivedproductdispense-status", "Issued"),
    Unfulfilled(
      "unfulfilled",
      "http://hl7.org/fhir/biologicallyderivedproductdispense-status",
      "Unfulfilled",
    ),
    Returned(
      "returned",
      "http://hl7.org/fhir/biologicallyderivedproductdispense-status",
      "Returned",
    ),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/biologicallyderivedproductdispense-status",
      "Entered in Error",
    ),
    Unknown("unknown", "http://hl7.org/fhir/biologicallyderivedproductdispense-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): BiologicallyDerivedProductDispenseCodes =
        when (code) {
          "preparation" -> Preparation
          "in-progress" -> In_Progress
          "allocated" -> Allocated
          "issued" -> Issued
          "unfulfilled" -> Unfulfilled
          "returned" -> Returned
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum BiologicallyDerivedProductDispenseCodes"
            )
        }
    }
  }
}

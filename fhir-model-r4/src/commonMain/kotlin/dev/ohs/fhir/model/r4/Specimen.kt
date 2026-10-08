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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.SpecimenCollectionSerializer
import dev.ohs.fhir.model.r4.serializers.SpecimenContainerSerializer
import dev.ohs.fhir.model.r4.serializers.SpecimenProcessingSerializer
import dev.ohs.fhir.model.r4.serializers.SpecimenSerializer
import dev.ohs.fhir.model.r4.terminologies.SpecimenStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A sample to be used for analysis. */
@Serializable(with = SpecimenSerializer::class)
@SerialName("Specimen")
public data class Specimen(
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
  /** Id for specimen. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier assigned by the lab when accessioning specimen(s). This is not necessarily the
   * same as the specimen identifier, depending on local lab procedures.
   */
  public val accessionIdentifier: Identifier? = null,
  /**
   * The availability of the specimen.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<SpecimenStatus>? = null,
  /**
   * The kind of material that forms the specimen.
   *
   * The type can change the way that a specimen is handled and drives what kind of analyses can
   * properly be performed on the specimen. It is frequently used in diagnostic work flow decision
   * making systems.
   */
  public val type: CodeableConcept? = null,
  /**
   * Where the specimen came from. This may be from patient(s), from a location (e.g., the source of
   * an environmental sample), or a sampling of a substance or a device.
   */
  public val subject: Reference? = null,
  /** Time when specimen was received for processing or testing. */
  public val receivedTime: DateTime? = null,
  /**
   * Reference to the parent (source) specimen which is used when the specimen was either derived
   * from or a component of another specimen.
   *
   * The parent specimen could be the source from which the current specimen is derived by some
   * processing step (e.g. an aliquot or isolate or extracted nucleic acids from clinical samples)
   * or one of many specimens that were combined to create a pooled sample.
   */
  public val parent: List<Reference> = listOf(),
  /**
   * Details concerning a service request that required a specimen to be collected.
   *
   * The request may be explicit or implied such with a ServiceRequest that requires a blood draw.
   */
  public val request: List<Reference> = listOf(),
  /** Details concerning the specimen collection. */
  public val collection: Collection? = null,
  /** Details concerning processing and processing steps for the specimen. */
  public val processing: List<Processing> = listOf(),
  /**
   * The container holding the specimen. The recursive nature of containers; i.e. blood in tube in
   * tray in rack is not addressed here.
   */
  public val container: List<Container> = listOf(),
  /**
   * A mode or state of being that describes the nature of the specimen.
   *
   * Specimen condition is an observation made about the specimen. It's a point-in-time assessment.
   * It can be used to assess its quality or appropriateness for a specific test.
   */
  public val condition: List<CodeableConcept> = listOf(),
  /**
   * To communicate any details or issues about the specimen or during the specimen collection. (for
   * example: broken vial, sent with patient, frozen).
   */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder = Builder()
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.mapToMutableList { it.toBuilder() }
    builder.extension = extension.mapToMutableList { it.toBuilder() }
    builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
    builder.identifier = identifier.mapToMutableList { it.toBuilder() }
    builder.accessionIdentifier = accessionIdentifier?.toBuilder()
    builder.status = status
    builder.type = type?.toBuilder()
    builder.subject = subject?.toBuilder()
    builder.receivedTime = receivedTime?.toBuilder()
    builder.parent = parent.mapToMutableList { it.toBuilder() }
    builder.request = request.mapToMutableList { it.toBuilder() }
    builder.collection = collection?.toBuilder()
    builder.processing = processing.mapToMutableList { it.toBuilder() }
    builder.container = container.mapToMutableList { it.toBuilder() }
    builder.condition = condition.mapToMutableList { it.toBuilder() }
    builder.note = note.mapToMutableList { it.toBuilder() }
    return builder
  }

  /** Details concerning the specimen collection. */
  @Serializable(with = SpecimenCollectionSerializer::class)
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
    /** Person who collected the specimen. */
    public val collector: Reference? = null,
    /** Time when specimen was collected from subject - the physiologically relevant time. */
    public val collected: Collected? = null,
    /** The span of time over which the collection of a specimen occurred. */
    public val duration: Duration? = null,
    /**
     * The quantity of specimen collected; for instance the volume of a blood sample, or the
     * physical measurement of an anatomic pathology sample.
     */
    public val quantity: Quantity? = null,
    /** A coded value specifying the technique that is used to perform the procedure. */
    public val method: CodeableConcept? = null,
    /**
     * Anatomical location from which the specimen was collected (if subject is a patient). This is
     * the target site. This element is not used for environmental specimens.
     *
     * If the use case requires BodySite to be handled as a separate resource instead of an inline
     * coded element (e.g. to identify and track separately) then use the standard extension
     * [bodySite](extension-bodysite.html).
     */
    public val bodySite: CodeableConcept? = null,
    /**
     * Abstinence or reduction from some or all food, drink, or both, for a period of time prior to
     * sample collection.
     *
     * Representing fasting status using this element is preferred to representing it with an
     * observation using a 'pre-coordinated code' such as LOINC 2005-7 (Calcium [Moles/​time] in 2
     * hour Urine --12 hours fasting), or using a component observation ` such as
     * `Observation.component code` = LOINC 49541-6 (Fasting status - Reported).
     */
    public val fastingStatus: FastingStatus? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.collector = collector?.toBuilder()
      builder.collected = collected
      builder.duration = duration?.toBuilder()
      builder.quantity = quantity?.toBuilder()
      builder.method = method?.toBuilder()
      builder.bodySite = bodySite?.toBuilder()
      builder.fastingStatus = fastingStatus
      return builder
    }

    public sealed interface Collected : FhirChoice {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asPeriod(): Period? = this as? Period

      public data class DateTime(override val `value`: dev.ohs.fhir.model.r4.DateTime) : Collected

      public data class Period(override val `value`: dev.ohs.fhir.model.r4.Period) : Collected

      public companion object {
        internal fun from(
          dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
          periodValue: dev.ohs.fhir.model.r4.Period?,
        ): Collected? {
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
      }
    }

    public sealed interface FastingStatus : FhirChoice {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asDuration(): Duration? = this as? Duration

      public data class CodeableConcept(
        override val `value`: dev.ohs.fhir.model.r4.CodeableConcept
      ) : FastingStatus

      public data class Duration(override val `value`: dev.ohs.fhir.model.r4.Duration) :
        FastingStatus

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
          durationValue: dev.ohs.fhir.model.r4.Duration?,
        ): FastingStatus? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (durationValue != null) return Duration(durationValue)
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

      /** Person who collected the specimen. */
      public var collector: Reference.Builder? = null

      /** Time when specimen was collected from subject - the physiologically relevant time. */
      public var collected: Collected? = null

      /** The span of time over which the collection of a specimen occurred. */
      public var duration: Duration.Builder? = null

      /**
       * The quantity of specimen collected; for instance the volume of a blood sample, or the
       * physical measurement of an anatomic pathology sample.
       */
      public var quantity: Quantity.Builder? = null

      /** A coded value specifying the technique that is used to perform the procedure. */
      public var method: CodeableConcept.Builder? = null

      /**
       * Anatomical location from which the specimen was collected (if subject is a patient). This
       * is the target site. This element is not used for environmental specimens.
       *
       * If the use case requires BodySite to be handled as a separate resource instead of an inline
       * coded element (e.g. to identify and track separately) then use the standard extension
       * [bodySite](extension-bodysite.html).
       */
      public var bodySite: CodeableConcept.Builder? = null

      /**
       * Abstinence or reduction from some or all food, drink, or both, for a period of time prior
       * to sample collection.
       *
       * Representing fasting status using this element is preferred to representing it with an
       * observation using a 'pre-coordinated code' such as LOINC 2005-7 (Calcium [Moles/​time] in 2
       * hour Urine --12 hours fasting), or using a component observation ` such as
       * `Observation.component code` = LOINC 49541-6 (Fasting status - Reported).
       */
      public var fastingStatus: FastingStatus? = null

      public fun build(): Collection =
        Collection(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          collector = collector?.build(),
          collected = collected,
          duration = duration?.build(),
          quantity = quantity?.build(),
          method = method?.build(),
          bodySite = bodySite?.build(),
          fastingStatus = fastingStatus,
        )
    }
  }

  /** Details concerning processing and processing steps for the specimen. */
  @Serializable(with = SpecimenProcessingSerializer::class)
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
    /** Textual description of procedure. */
    public val description: String? = null,
    /** A coded value specifying the procedure used to process the specimen. */
    public val procedure: CodeableConcept? = null,
    /** Material used in the processing step. */
    public val additive: List<Reference> = listOf(),
    /**
     * A record of the time or period when the specimen processing occurred. For example the time of
     * sample fixation or the period of time the sample was in formalin.
     */
    public val time: Time? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.description = description?.toBuilder()
      builder.procedure = procedure?.toBuilder()
      builder.additive = additive.mapToMutableList { it.toBuilder() }
      builder.time = time
      return builder
    }

    public sealed interface Time : FhirChoice {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asPeriod(): Period? = this as? Period

      public data class DateTime(override val `value`: dev.ohs.fhir.model.r4.DateTime) : Time

      public data class Period(override val `value`: dev.ohs.fhir.model.r4.Period) : Time

      public companion object {
        internal fun from(
          dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
          periodValue: dev.ohs.fhir.model.r4.Period?,
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

      /** Textual description of procedure. */
      public var description: String.Builder? = null

      /** A coded value specifying the procedure used to process the specimen. */
      public var procedure: CodeableConcept.Builder? = null

      /** Material used in the processing step. */
      public var additive: MutableList<Reference.Builder> = mutableListOf()

      /**
       * A record of the time or period when the specimen processing occurred. For example the time
       * of sample fixation or the period of time the sample was in formalin.
       */
      public var time: Time? = null

      public fun build(): Processing =
        Processing(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          description = description?.build(),
          procedure = procedure?.build(),
          additive = additive.mapToList { it.build() },
          time = time,
        )
    }
  }

  /**
   * The container holding the specimen. The recursive nature of containers; i.e. blood in tube in
   * tray in rack is not addressed here.
   */
  @Serializable(with = SpecimenContainerSerializer::class)
  public data class Container(
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
    /**
     * Id for container. There may be multiple; a manufacturer's bar code, lab assigned identifier,
     * etc. The container ID may differ from the specimen id in some circumstances.
     */
    public val identifier: List<Identifier> = listOf(),
    /** Textual description of the container. */
    public val description: String? = null,
    /** The type of container associated with the specimen (e.g. slide, aliquot, etc.). */
    public val type: CodeableConcept? = null,
    /** The capacity (volume or other measure) the container may contain. */
    public val capacity: Quantity? = null,
    /**
     * The quantity of specimen in the container; may be volume, dimensions, or other appropriate
     * measurements, depending on the specimen type.
     */
    public val specimenQuantity: Quantity? = null,
    /**
     * Introduced substance to preserve, maintain or enhance the specimen. Examples: Formalin,
     * Citrate, EDTA.
     */
    public val additive: Additive? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.mapToMutableList { it.toBuilder() }
      builder.modifierExtension = modifierExtension.mapToMutableList { it.toBuilder() }
      builder.identifier = identifier.mapToMutableList { it.toBuilder() }
      builder.description = description?.toBuilder()
      builder.type = type?.toBuilder()
      builder.capacity = capacity?.toBuilder()
      builder.specimenQuantity = specimenQuantity?.toBuilder()
      builder.additive = additive
      return builder
    }

    public sealed interface Additive : FhirChoice {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      public data class CodeableConcept(
        override val `value`: dev.ohs.fhir.model.r4.CodeableConcept
      ) : Additive

      public data class Reference(override val `value`: dev.ohs.fhir.model.r4.Reference) : Additive

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r4.Reference?,
        ): Additive? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
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

      /**
       * Id for container. There may be multiple; a manufacturer's bar code, lab assigned
       * identifier, etc. The container ID may differ from the specimen id in some circumstances.
       */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /** Textual description of the container. */
      public var description: String.Builder? = null

      /** The type of container associated with the specimen (e.g. slide, aliquot, etc.). */
      public var type: CodeableConcept.Builder? = null

      /** The capacity (volume or other measure) the container may contain. */
      public var capacity: Quantity.Builder? = null

      /**
       * The quantity of specimen in the container; may be volume, dimensions, or other appropriate
       * measurements, depending on the specimen type.
       */
      public var specimenQuantity: Quantity.Builder? = null

      /**
       * Introduced substance to preserve, maintain or enhance the specimen. Examples: Formalin,
       * Citrate, EDTA.
       */
      public var additive: Additive? = null

      public fun build(): Container =
        Container(
          id = id,
          extension = extension.mapToList { it.build() },
          modifierExtension = modifierExtension.mapToList { it.build() },
          identifier = identifier.mapToList { it.build() },
          description = description?.build(),
          type = type?.build(),
          capacity = capacity?.build(),
          specimenQuantity = specimenQuantity?.build(),
          additive = additive,
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
    override var id: kotlin.String? = null

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

    /** Id for specimen. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier assigned by the lab when accessioning specimen(s). This is not necessarily the
     * same as the specimen identifier, depending on local lab procedures.
     */
    public var accessionIdentifier: Identifier.Builder? = null

    /**
     * The availability of the specimen.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<SpecimenStatus>? = null

    /**
     * The kind of material that forms the specimen.
     *
     * The type can change the way that a specimen is handled and drives what kind of analyses can
     * properly be performed on the specimen. It is frequently used in diagnostic work flow decision
     * making systems.
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * Where the specimen came from. This may be from patient(s), from a location (e.g., the source
     * of an environmental sample), or a sampling of a substance or a device.
     */
    public var subject: Reference.Builder? = null

    /** Time when specimen was received for processing or testing. */
    public var receivedTime: DateTime.Builder? = null

    /**
     * Reference to the parent (source) specimen which is used when the specimen was either derived
     * from or a component of another specimen.
     *
     * The parent specimen could be the source from which the current specimen is derived by some
     * processing step (e.g. an aliquot or isolate or extracted nucleic acids from clinical samples)
     * or one of many specimens that were combined to create a pooled sample.
     */
    public var parent: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Details concerning a service request that required a specimen to be collected.
     *
     * The request may be explicit or implied such with a ServiceRequest that requires a blood draw.
     */
    public var request: MutableList<Reference.Builder> = mutableListOf()

    /** Details concerning the specimen collection. */
    public var collection: Collection.Builder? = null

    /** Details concerning processing and processing steps for the specimen. */
    public var processing: MutableList<Processing.Builder> = mutableListOf()

    /**
     * The container holding the specimen. The recursive nature of containers; i.e. blood in tube in
     * tray in rack is not addressed here.
     */
    public var container: MutableList<Container.Builder> = mutableListOf()

    /**
     * A mode or state of being that describes the nature of the specimen.
     *
     * Specimen condition is an observation made about the specimen. It's a point-in-time
     * assessment. It can be used to assess its quality or appropriateness for a specific test.
     */
    public var condition: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * To communicate any details or issues about the specimen or during the specimen collection.
     * (for example: broken vial, sent with patient, frozen).
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): Specimen =
      Specimen(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.mapToList { it.build() },
        extension = extension.mapToList { it.build() },
        modifierExtension = modifierExtension.mapToList { it.build() },
        identifier = identifier.mapToList { it.build() },
        accessionIdentifier = accessionIdentifier?.build(),
        status = status,
        type = type?.build(),
        subject = subject?.build(),
        receivedTime = receivedTime?.build(),
        parent = parent.mapToList { it.build() },
        request = request.mapToList { it.build() },
        collection = collection?.build(),
        processing = processing.mapToList { it.build() },
        container = container.mapToList { it.build() },
        condition = condition.mapToList { it.build() },
        note = note.mapToList { it.build() },
      )
  }
}

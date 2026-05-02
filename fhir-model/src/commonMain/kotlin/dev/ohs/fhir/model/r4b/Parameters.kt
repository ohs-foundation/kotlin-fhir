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

import com.google.fhir.model.r4.serializers.ParametersParameterSerializer
import com.google.fhir.model.r4.serializers.ParametersParameterValueSerializer
import com.google.fhir.model.r4.serializers.ParametersSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource is a non-persisted resource used to pass information into and back from an
 * [operation](operations.html). It has no other use, and there is no RESTful endpoint associated
 * with it.
 */
@Serializable(with = ParametersSerializer::class)
@SerialName("Parameters")
public data class Parameters(
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
  /** A parameter passed to or received from the operation. */
  public val parameter: List<Parameter> = listOf(),
) : Resource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        parameter = this@with.parameter.map { it.toBuilder() }.toMutableList()
      }
    }

  /** A parameter passed to or received from the operation. */
  @Serializable(with = ParametersParameterSerializer::class)
  public data class Parameter(
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
    /** The name of the parameter (reference to the operation definition). */
    public val name: String,
    /** If the parameter is a data type. */
    public val `value`: Value? = null,
    /**
     * If the parameter is a whole resource.
     *
     * When resolving references in resources, the operation definition may specify how references
     * may be resolved between parameters. If a reference cannot be resolved between the parameters,
     * the application should fall back to it's general resource resolution methods.
     */
    public val resource: Resource? = null,
    /**
     * A named part of a multi-part parameter.
     *
     * Only one level of nested parameters is allowed.
     */
    public val part: List<Parameter> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(name.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          `value` = this@with.`value`
          resource = this@with.resource?.toBuilder()
          part = this@with.part.map { it.toBuilder() }.toMutableList()
        }
      }

    @Serializable(with = ParametersParameterValueSerializer::class)
    public sealed interface Value {
      public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asCanonical(): Canonical? = this as? Canonical

      public fun asCode(): Code? = this as? Code

      public fun asDate(): Date? = this as? Date

      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asDecimal(): Decimal? = this as? Decimal

      public fun asId(): Id? = this as? Id

      public fun asInstant(): Instant? = this as? Instant

      public fun asInteger(): Integer? = this as? Integer

      public fun asMarkdown(): Markdown? = this as? Markdown

      public fun asOid(): Oid? = this as? Oid

      public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

      public fun asString(): String? = this as? String

      public fun asTime(): Time? = this as? Time

      public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

      public fun asUri(): Uri? = this as? Uri

      public fun asUrl(): Url? = this as? Url

      public fun asUuid(): Uuid? = this as? Uuid

      public fun asAddress(): Address? = this as? Address

      public fun asAge(): Age? = this as? Age

      public fun asAnnotation(): Annotation? = this as? Annotation

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asCoding(): Coding? = this as? Coding

      public fun asContactPoint(): ContactPoint? = this as? ContactPoint

      public fun asCount(): Count? = this as? Count

      public fun asDistance(): Distance? = this as? Distance

      public fun asDuration(): Duration? = this as? Duration

      public fun asHumanName(): HumanName? = this as? HumanName

      public fun asIdentifier(): Identifier? = this as? Identifier

      public fun asMoney(): Money? = this as? Money

      public fun asPeriod(): Period? = this as? Period

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asReference(): Reference? = this as? Reference

      public fun asSampledData(): SampledData? = this as? SampledData

      public fun asSignature(): Signature? = this as? Signature

      public fun asTiming(): Timing? = this as? Timing

      public fun asContactDetail(): ContactDetail? = this as? ContactDetail

      public fun asContributor(): Contributor? = this as? Contributor

      public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

      public fun asExpression(): Expression? = this as? Expression

      public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

      public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

      public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

      public fun asUsageContext(): UsageContext? = this as? UsageContext

      public fun asDosage(): Dosage? = this as? Dosage

      public fun asMeta(): Meta? = this as? Meta

      public data class Base64Binary(public val `value`: com.google.fhir.model.r4.Base64Binary) :
        Value

      public data class Boolean(public val `value`: com.google.fhir.model.r4.Boolean) : Value

      public data class Canonical(public val `value`: com.google.fhir.model.r4.Canonical) : Value

      public data class Code(public val `value`: com.google.fhir.model.r4.Code) : Value

      public data class Date(public val `value`: com.google.fhir.model.r4.Date) : Value

      public data class DateTime(public val `value`: com.google.fhir.model.r4.DateTime) : Value

      public data class Decimal(public val `value`: com.google.fhir.model.r4.Decimal) : Value

      public data class Id(public val `value`: com.google.fhir.model.r4.Id) : Value

      public data class Instant(public val `value`: com.google.fhir.model.r4.Instant) : Value

      public data class Integer(public val `value`: com.google.fhir.model.r4.Integer) : Value

      public data class Markdown(public val `value`: com.google.fhir.model.r4.Markdown) : Value

      public data class Oid(public val `value`: com.google.fhir.model.r4.Oid) : Value

      public data class PositiveInt(public val `value`: com.google.fhir.model.r4.PositiveInt) :
        Value

      public data class String(public val `value`: com.google.fhir.model.r4.String) : Value

      public data class Time(public val `value`: com.google.fhir.model.r4.Time) : Value

      public data class UnsignedInt(public val `value`: com.google.fhir.model.r4.UnsignedInt) :
        Value

      public data class Uri(public val `value`: com.google.fhir.model.r4.Uri) : Value

      public data class Url(public val `value`: com.google.fhir.model.r4.Url) : Value

      public data class Uuid(public val `value`: com.google.fhir.model.r4.Uuid) : Value

      public data class Address(public val `value`: com.google.fhir.model.r4.Address) : Value

      public data class Age(public val `value`: com.google.fhir.model.r4.Age) : Value

      public data class Annotation(public val `value`: com.google.fhir.model.r4.Annotation) : Value

      public data class Attachment(public val `value`: com.google.fhir.model.r4.Attachment) : Value

      public data class CodeableConcept(
        public val `value`: com.google.fhir.model.r4.CodeableConcept
      ) : Value

      public data class Coding(public val `value`: com.google.fhir.model.r4.Coding) : Value

      public data class ContactPoint(public val `value`: com.google.fhir.model.r4.ContactPoint) :
        Value

      public data class Count(public val `value`: com.google.fhir.model.r4.Count) : Value

      public data class Distance(public val `value`: com.google.fhir.model.r4.Distance) : Value

      public data class Duration(public val `value`: com.google.fhir.model.r4.Duration) : Value

      public data class HumanName(public val `value`: com.google.fhir.model.r4.HumanName) : Value

      public data class Identifier(public val `value`: com.google.fhir.model.r4.Identifier) : Value

      public data class Money(public val `value`: com.google.fhir.model.r4.Money) : Value

      public data class Period(public val `value`: com.google.fhir.model.r4.Period) : Value

      public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Value

      public data class Range(public val `value`: com.google.fhir.model.r4.Range) : Value

      public data class Ratio(public val `value`: com.google.fhir.model.r4.Ratio) : Value

      public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) : Value

      public data class SampledData(public val `value`: com.google.fhir.model.r4.SampledData) :
        Value

      public data class Signature(public val `value`: com.google.fhir.model.r4.Signature) : Value

      public data class Timing(public val `value`: com.google.fhir.model.r4.Timing) : Value

      public data class ContactDetail(public val `value`: com.google.fhir.model.r4.ContactDetail) :
        Value

      public data class Contributor(public val `value`: com.google.fhir.model.r4.Contributor) :
        Value

      public data class DataRequirement(
        public val `value`: com.google.fhir.model.r4.DataRequirement
      ) : Value

      public data class Expression(public val `value`: com.google.fhir.model.r4.Expression) : Value

      public data class ParameterDefinition(
        public val `value`: com.google.fhir.model.r4.ParameterDefinition
      ) : Value

      public data class RelatedArtifact(
        public val `value`: com.google.fhir.model.r4.RelatedArtifact
      ) : Value

      public data class TriggerDefinition(
        public val `value`: com.google.fhir.model.r4.TriggerDefinition
      ) : Value

      public data class UsageContext(public val `value`: com.google.fhir.model.r4.UsageContext) :
        Value

      public data class Dosage(public val `value`: com.google.fhir.model.r4.Dosage) : Value

      public data class Meta(public val `value`: com.google.fhir.model.r4.Meta) : Value

      public companion object {
        internal fun from(
          base64BinaryValue: com.google.fhir.model.r4.Base64Binary?,
          booleanValue: com.google.fhir.model.r4.Boolean?,
          canonicalValue: com.google.fhir.model.r4.Canonical?,
          codeValue: com.google.fhir.model.r4.Code?,
          dateValue: com.google.fhir.model.r4.Date?,
          dateTimeValue: com.google.fhir.model.r4.DateTime?,
          decimalValue: com.google.fhir.model.r4.Decimal?,
          idValue: com.google.fhir.model.r4.Id?,
          instantValue: com.google.fhir.model.r4.Instant?,
          integerValue: com.google.fhir.model.r4.Integer?,
          markdownValue: com.google.fhir.model.r4.Markdown?,
          oidValue: com.google.fhir.model.r4.Oid?,
          positiveIntValue: com.google.fhir.model.r4.PositiveInt?,
          stringValue: com.google.fhir.model.r4.String?,
          timeValue: com.google.fhir.model.r4.Time?,
          unsignedIntValue: com.google.fhir.model.r4.UnsignedInt?,
          uriValue: com.google.fhir.model.r4.Uri?,
          urlValue: com.google.fhir.model.r4.Url?,
          uuidValue: com.google.fhir.model.r4.Uuid?,
          addressValue: com.google.fhir.model.r4.Address?,
          ageValue: com.google.fhir.model.r4.Age?,
          annotationValue: com.google.fhir.model.r4.Annotation?,
          attachmentValue: com.google.fhir.model.r4.Attachment?,
          codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
          codingValue: com.google.fhir.model.r4.Coding?,
          contactPointValue: com.google.fhir.model.r4.ContactPoint?,
          countValue: com.google.fhir.model.r4.Count?,
          distanceValue: com.google.fhir.model.r4.Distance?,
          durationValue: com.google.fhir.model.r4.Duration?,
          humanNameValue: com.google.fhir.model.r4.HumanName?,
          identifierValue: com.google.fhir.model.r4.Identifier?,
          moneyValue: com.google.fhir.model.r4.Money?,
          periodValue: com.google.fhir.model.r4.Period?,
          quantityValue: com.google.fhir.model.r4.Quantity?,
          rangeValue: com.google.fhir.model.r4.Range?,
          ratioValue: com.google.fhir.model.r4.Ratio?,
          referenceValue: com.google.fhir.model.r4.Reference?,
          sampledDataValue: com.google.fhir.model.r4.SampledData?,
          signatureValue: com.google.fhir.model.r4.Signature?,
          timingValue: com.google.fhir.model.r4.Timing?,
          contactDetailValue: com.google.fhir.model.r4.ContactDetail?,
          contributorValue: com.google.fhir.model.r4.Contributor?,
          dataRequirementValue: com.google.fhir.model.r4.DataRequirement?,
          expressionValue: com.google.fhir.model.r4.Expression?,
          parameterDefinitionValue: com.google.fhir.model.r4.ParameterDefinition?,
          relatedArtifactValue: com.google.fhir.model.r4.RelatedArtifact?,
          triggerDefinitionValue: com.google.fhir.model.r4.TriggerDefinition?,
          usageContextValue: com.google.fhir.model.r4.UsageContext?,
          dosageValue: com.google.fhir.model.r4.Dosage?,
          metaValue: com.google.fhir.model.r4.Meta?,
        ): Value? {
          if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (canonicalValue != null) return Canonical(canonicalValue)
          if (codeValue != null) return Code(codeValue)
          if (dateValue != null) return Date(dateValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (decimalValue != null) return Decimal(decimalValue)
          if (idValue != null) return Id(idValue)
          if (instantValue != null) return Instant(instantValue)
          if (integerValue != null) return Integer(integerValue)
          if (markdownValue != null) return Markdown(markdownValue)
          if (oidValue != null) return Oid(oidValue)
          if (positiveIntValue != null) return PositiveInt(positiveIntValue)
          if (stringValue != null) return String(stringValue)
          if (timeValue != null) return Time(timeValue)
          if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
          if (uriValue != null) return Uri(uriValue)
          if (urlValue != null) return Url(urlValue)
          if (uuidValue != null) return Uuid(uuidValue)
          if (addressValue != null) return Address(addressValue)
          if (ageValue != null) return Age(ageValue)
          if (annotationValue != null) return Annotation(annotationValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (codingValue != null) return Coding(codingValue)
          if (contactPointValue != null) return ContactPoint(contactPointValue)
          if (countValue != null) return Count(countValue)
          if (distanceValue != null) return Distance(distanceValue)
          if (durationValue != null) return Duration(durationValue)
          if (humanNameValue != null) return HumanName(humanNameValue)
          if (identifierValue != null) return Identifier(identifierValue)
          if (moneyValue != null) return Money(moneyValue)
          if (periodValue != null) return Period(periodValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (ratioValue != null) return Ratio(ratioValue)
          if (referenceValue != null) return Reference(referenceValue)
          if (sampledDataValue != null) return SampledData(sampledDataValue)
          if (signatureValue != null) return Signature(signatureValue)
          if (timingValue != null) return Timing(timingValue)
          if (contactDetailValue != null) return ContactDetail(contactDetailValue)
          if (contributorValue != null) return Contributor(contributorValue)
          if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
          if (expressionValue != null) return Expression(expressionValue)
          if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
          if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
          if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
          if (usageContextValue != null) return UsageContext(usageContextValue)
          if (dosageValue != null) return Dosage(dosageValue)
          if (metaValue != null) return Meta(metaValue)
          return null
        }
      }
    }

    public class Builder(
      /** The name of the parameter (reference to the operation definition). */
      public var name: String.Builder
    ) {
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

      /** If the parameter is a data type. */
      public var `value`: Value? = null

      /**
       * If the parameter is a whole resource.
       *
       * When resolving references in resources, the operation definition may specify how references
       * may be resolved between parameters. If a reference cannot be resolved between the
       * parameters, the application should fall back to it's general resource resolution methods.
       */
      public var resource: Resource.Builder? = null

      /**
       * A named part of a multi-part parameter.
       *
       * Only one level of nested parameters is allowed.
       */
      public var part: MutableList<Builder> = mutableListOf()

      public fun build(): Parameter =
        Parameter(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name.build(),
          `value` = `value`,
          resource = resource?.build(),
          part = part.map { it.build() },
        )
    }
  }

  public class Builder() : Resource.Builder() {
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

    /** A parameter passed to or received from the operation. */
    public var parameter: MutableList<Parameter.Builder> = mutableListOf()

    override fun build(): Parameters =
      Parameters(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        parameter = parameter.map { it.build() },
      )
  }
}

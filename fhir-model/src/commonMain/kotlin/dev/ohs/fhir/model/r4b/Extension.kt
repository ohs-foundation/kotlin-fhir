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

import com.google.fhir.model.r4b.serializers.ExtensionSerializer
import com.google.fhir.model.r4b.serializers.ExtensionValueSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Extension Type: Optional Extension Element - found in all resources.
 */
@Serializable(with = ExtensionSerializer::class)
public data class Extension(
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
   * Source of the definition for the extension code - a logical name or a URL.
   *
   * The definition may point directly to a computable or human-readable definition of the
   * extensibility codes, or it may be a logical URI as declared in some other specification. The
   * definition SHALL be a URI for the Structure Definition defining the extension.
   */
  public val url: String,
  /**
   * Value of extension - must be one of a constrained set of the data types (see
   * [Extensibility](extensibility.html) for a list).
   */
  public val `value`: Value? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder(url).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        `value` = this@with.`value`
      }
    }

  @Serializable(with = ExtensionValueSerializer::class)
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

    public fun asCodeableReference(): CodeableReference? = this as? CodeableReference

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

    public fun asRatioRange(): RatioRange? = this as? RatioRange

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

    public data class Base64Binary(public val `value`: com.google.fhir.model.r4b.Base64Binary) :
      Value

    public data class Boolean(public val `value`: com.google.fhir.model.r4b.Boolean) : Value

    public data class Canonical(public val `value`: com.google.fhir.model.r4b.Canonical) : Value

    public data class Code(public val `value`: com.google.fhir.model.r4b.Code) : Value

    public data class Date(public val `value`: com.google.fhir.model.r4b.Date) : Value

    public data class DateTime(public val `value`: com.google.fhir.model.r4b.DateTime) : Value

    public data class Decimal(public val `value`: com.google.fhir.model.r4b.Decimal) : Value

    public data class Id(public val `value`: com.google.fhir.model.r4b.Id) : Value

    public data class Instant(public val `value`: com.google.fhir.model.r4b.Instant) : Value

    public data class Integer(public val `value`: com.google.fhir.model.r4b.Integer) : Value

    public data class Markdown(public val `value`: com.google.fhir.model.r4b.Markdown) : Value

    public data class Oid(public val `value`: com.google.fhir.model.r4b.Oid) : Value

    public data class PositiveInt(public val `value`: com.google.fhir.model.r4b.PositiveInt) :
      Value

    public data class String(public val `value`: com.google.fhir.model.r4b.String) : Value

    public data class Time(public val `value`: com.google.fhir.model.r4b.Time) : Value

    public data class UnsignedInt(public val `value`: com.google.fhir.model.r4b.UnsignedInt) :
      Value

    public data class Uri(public val `value`: com.google.fhir.model.r4b.Uri) : Value

    public data class Url(public val `value`: com.google.fhir.model.r4b.Url) : Value

    public data class Uuid(public val `value`: com.google.fhir.model.r4b.Uuid) : Value

    public data class Address(public val `value`: com.google.fhir.model.r4b.Address) : Value

    public data class Age(public val `value`: com.google.fhir.model.r4b.Age) : Value

    public data class Annotation(public val `value`: com.google.fhir.model.r4b.Annotation) : Value

    public data class Attachment(public val `value`: com.google.fhir.model.r4b.Attachment) : Value

    public data class CodeableConcept(
      public val `value`: com.google.fhir.model.r4b.CodeableConcept
    ) : Value

    public data class CodeableReference(
      public val `value`: com.google.fhir.model.r4b.CodeableReference
    ) : Value

    public data class Coding(public val `value`: com.google.fhir.model.r4b.Coding) : Value

    public data class ContactPoint(public val `value`: com.google.fhir.model.r4b.ContactPoint) :
      Value

    public data class Count(public val `value`: com.google.fhir.model.r4b.Count) : Value

    public data class Distance(public val `value`: com.google.fhir.model.r4b.Distance) : Value

    public data class Duration(public val `value`: com.google.fhir.model.r4b.Duration) : Value

    public data class HumanName(public val `value`: com.google.fhir.model.r4b.HumanName) : Value

    public data class Identifier(public val `value`: com.google.fhir.model.r4b.Identifier) : Value

    public data class Money(public val `value`: com.google.fhir.model.r4b.Money) : Value

    public data class Period(public val `value`: com.google.fhir.model.r4b.Period) : Value

    public data class Quantity(public val `value`: com.google.fhir.model.r4b.Quantity) : Value

    public data class Range(public val `value`: com.google.fhir.model.r4b.Range) : Value

    public data class Ratio(public val `value`: com.google.fhir.model.r4b.Ratio) : Value

    public data class RatioRange(public val `value`: com.google.fhir.model.r4b.RatioRange) : Value

    public data class Reference(public val `value`: com.google.fhir.model.r4b.Reference) : Value

    public data class SampledData(public val `value`: com.google.fhir.model.r4b.SampledData) :
      Value

    public data class Signature(public val `value`: com.google.fhir.model.r4b.Signature) : Value

    public data class Timing(public val `value`: com.google.fhir.model.r4b.Timing) : Value

    public data class ContactDetail(public val `value`: com.google.fhir.model.r4b.ContactDetail) :
      Value

    public data class Contributor(public val `value`: com.google.fhir.model.r4b.Contributor) :
      Value

    public data class DataRequirement(
      public val `value`: com.google.fhir.model.r4b.DataRequirement
    ) : Value

    public data class Expression(public val `value`: com.google.fhir.model.r4b.Expression) : Value

    public data class ParameterDefinition(
      public val `value`: com.google.fhir.model.r4b.ParameterDefinition
    ) : Value

    public data class RelatedArtifact(
      public val `value`: com.google.fhir.model.r4b.RelatedArtifact
    ) : Value

    public data class TriggerDefinition(
      public val `value`: com.google.fhir.model.r4b.TriggerDefinition
    ) : Value

    public data class UsageContext(public val `value`: com.google.fhir.model.r4b.UsageContext) :
      Value

    public data class Dosage(public val `value`: com.google.fhir.model.r4b.Dosage) : Value

    public companion object {
      internal fun from(
        base64BinaryValue: com.google.fhir.model.r4b.Base64Binary?,
        booleanValue: com.google.fhir.model.r4b.Boolean?,
        canonicalValue: com.google.fhir.model.r4b.Canonical?,
        codeValue: com.google.fhir.model.r4b.Code?,
        dateValue: com.google.fhir.model.r4b.Date?,
        dateTimeValue: com.google.fhir.model.r4b.DateTime?,
        decimalValue: com.google.fhir.model.r4b.Decimal?,
        idValue: com.google.fhir.model.r4b.Id?,
        instantValue: com.google.fhir.model.r4b.Instant?,
        integerValue: com.google.fhir.model.r4b.Integer?,
        markdownValue: com.google.fhir.model.r4b.Markdown?,
        oidValue: com.google.fhir.model.r4b.Oid?,
        positiveIntValue: com.google.fhir.model.r4b.PositiveInt?,
        stringValue: com.google.fhir.model.r4b.String?,
        timeValue: com.google.fhir.model.r4b.Time?,
        unsignedIntValue: com.google.fhir.model.r4b.UnsignedInt?,
        uriValue: com.google.fhir.model.r4b.Uri?,
        urlValue: com.google.fhir.model.r4b.Url?,
        uuidValue: com.google.fhir.model.r4b.Uuid?,
        addressValue: com.google.fhir.model.r4b.Address?,
        ageValue: com.google.fhir.model.r4b.Age?,
        annotationValue: com.google.fhir.model.r4b.Annotation?,
        attachmentValue: com.google.fhir.model.r4b.Attachment?,
        codeableConceptValue: com.google.fhir.model.r4b.CodeableConcept?,
        codeableReferenceValue: com.google.fhir.model.r4b.CodeableReference?,
        codingValue: com.google.fhir.model.r4b.Coding?,
        contactPointValue: com.google.fhir.model.r4b.ContactPoint?,
        countValue: com.google.fhir.model.r4b.Count?,
        distanceValue: com.google.fhir.model.r4b.Distance?,
        durationValue: com.google.fhir.model.r4b.Duration?,
        humanNameValue: com.google.fhir.model.r4b.HumanName?,
        identifierValue: com.google.fhir.model.r4b.Identifier?,
        moneyValue: com.google.fhir.model.r4b.Money?,
        periodValue: com.google.fhir.model.r4b.Period?,
        quantityValue: com.google.fhir.model.r4b.Quantity?,
        rangeValue: com.google.fhir.model.r4b.Range?,
        ratioValue: com.google.fhir.model.r4b.Ratio?,
        ratioRangeValue: com.google.fhir.model.r4b.RatioRange?,
        referenceValue: com.google.fhir.model.r4b.Reference?,
        sampledDataValue: com.google.fhir.model.r4b.SampledData?,
        signatureValue: com.google.fhir.model.r4b.Signature?,
        timingValue: com.google.fhir.model.r4b.Timing?,
        contactDetailValue: com.google.fhir.model.r4b.ContactDetail?,
        contributorValue: com.google.fhir.model.r4b.Contributor?,
        dataRequirementValue: com.google.fhir.model.r4b.DataRequirement?,
        expressionValue: com.google.fhir.model.r4b.Expression?,
        parameterDefinitionValue: com.google.fhir.model.r4b.ParameterDefinition?,
        relatedArtifactValue: com.google.fhir.model.r4b.RelatedArtifact?,
        triggerDefinitionValue: com.google.fhir.model.r4b.TriggerDefinition?,
        usageContextValue: com.google.fhir.model.r4b.UsageContext?,
        dosageValue: com.google.fhir.model.r4b.Dosage?,
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
        if (codeableReferenceValue != null) return CodeableReference(codeableReferenceValue)
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
        if (ratioRangeValue != null) return RatioRange(ratioRangeValue)
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
        return null
      }
    }
  }

  public open class Builder(
    /**
     * Source of the definition for the extension code - a logical name or a URL.
     *
     * The definition may point directly to a computable or human-readable definition of the
     * extensibility codes, or it may be a logical URI as declared in some other specification. The
     * definition SHALL be a URI for the Structure Definition defining the extension.
     */
    public open var url: String
  ) {
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
    public open var extension: MutableList<Builder> = mutableListOf()

    /**
     * Value of extension - must be one of a constrained set of the data types (see
     * [Extensibility](extensibility.html) for a list).
     */
    public open var `value`: Value? = null

    public open fun build(): Extension =
      Extension(id = id, extension = extension.map { it.build() }, url = url, `value` = `value`)
  }
}

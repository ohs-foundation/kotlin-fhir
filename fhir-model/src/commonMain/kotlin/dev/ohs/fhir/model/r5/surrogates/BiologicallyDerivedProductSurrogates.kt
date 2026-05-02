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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.BiologicallyDerivedProduct
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Ratio
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class BiologicallyDerivedProductCollectionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var collector: Reference? = null,
  public var source: Reference? = null,
  public var collected: BiologicallyDerivedProduct.Collection.Collected? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct.Collection =
    BiologicallyDerivedProduct.Collection(
      id = this@BiologicallyDerivedProductCollectionSurrogate.id,
      extension = this@BiologicallyDerivedProductCollectionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@BiologicallyDerivedProductCollectionSurrogate.modifierExtension ?: listOf(),
      collector = this@BiologicallyDerivedProductCollectionSurrogate.collector,
      source = this@BiologicallyDerivedProductCollectionSurrogate.source,
      collected = this@BiologicallyDerivedProductCollectionSurrogate.collected,
    )

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Collection
    ): BiologicallyDerivedProductCollectionSurrogate =
      with(model) {
        BiologicallyDerivedProductCollectionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          collector = this@with.collector,
          source = this@with.source,
          collected = this@with.collected,
        )
      }
  }
}

@Serializable
internal data class BiologicallyDerivedProductPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: BiologicallyDerivedProduct.Property.Value,
) {
  public fun toModel(): BiologicallyDerivedProduct.Property =
    BiologicallyDerivedProduct.Property(
      id = this@BiologicallyDerivedProductPropertySurrogate.id,
      extension = this@BiologicallyDerivedProductPropertySurrogate.extension ?: listOf(),
      modifierExtension =
        this@BiologicallyDerivedProductPropertySurrogate.modifierExtension ?: listOf(),
      type = this@BiologicallyDerivedProductPropertySurrogate.type,
      `value` = this@BiologicallyDerivedProductPropertySurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Property
    ): BiologicallyDerivedProductPropertySurrogate =
      with(model) {
        BiologicallyDerivedProductPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class BiologicallyDerivedProductCollectionCollectedSurrogate(
  public var collectedDateTime: KotlinString? = null,
  public var _collectedDateTime: Element? = null,
  public var collectedPeriod: Period? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct.Collection.Collected =
    BiologicallyDerivedProduct.Collection.Collected.from(
      DateTime.of(
        FhirDateTime.fromString(
          this@BiologicallyDerivedProductCollectionCollectedSurrogate.collectedDateTime
        ),
        this@BiologicallyDerivedProductCollectionCollectedSurrogate._collectedDateTime,
      ),
      this@BiologicallyDerivedProductCollectionCollectedSurrogate.collectedPeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Collection.Collected
    ): BiologicallyDerivedProductCollectionCollectedSurrogate =
      with(model) {
        BiologicallyDerivedProductCollectionCollectedSurrogate(
          collectedDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _collectedDateTime = this@with.asDateTime()?.value?.toElement(),
          collectedPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class BiologicallyDerivedProductPropertyValueSurrogate(
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valuePeriod: Period? = null,
  public var valueQuantity: Quantity? = null,
  public var valueRange: Range? = null,
  public var valueRatio: Ratio? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueAttachment: Attachment? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct.Property.Value =
    BiologicallyDerivedProduct.Property.Value.from(
      R5Boolean.of(
        this@BiologicallyDerivedProductPropertyValueSurrogate.valueBoolean,
        this@BiologicallyDerivedProductPropertyValueSurrogate._valueBoolean,
      ),
      Integer.of(
        this@BiologicallyDerivedProductPropertyValueSurrogate.valueInteger,
        this@BiologicallyDerivedProductPropertyValueSurrogate._valueInteger,
      ),
      this@BiologicallyDerivedProductPropertyValueSurrogate.valueCodeableConcept,
      this@BiologicallyDerivedProductPropertyValueSurrogate.valuePeriod,
      this@BiologicallyDerivedProductPropertyValueSurrogate.valueQuantity,
      this@BiologicallyDerivedProductPropertyValueSurrogate.valueRange,
      this@BiologicallyDerivedProductPropertyValueSurrogate.valueRatio,
      R5String.of(
        this@BiologicallyDerivedProductPropertyValueSurrogate.valueString,
        this@BiologicallyDerivedProductPropertyValueSurrogate._valueString,
      ),
      this@BiologicallyDerivedProductPropertyValueSurrogate.valueAttachment,
    )!!

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Property.Value
    ): BiologicallyDerivedProductPropertyValueSurrogate =
      with(model) {
        BiologicallyDerivedProductPropertyValueSurrogate(
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valuePeriod = this@with.asPeriod()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueRange = this@with.asRange()?.value,
          valueRatio = this@with.asRatio()?.value,
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
        )
      }
  }
}

@Serializable
internal data class BiologicallyDerivedProductSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var productCategory: Coding? = null,
  public var productCode: CodeableConcept? = null,
  public var parent: List<Reference>? = null,
  public var request: List<Reference>? = null,
  public var identifier: List<Identifier>? = null,
  public var biologicalSourceEvent: Identifier? = null,
  public var processingFacility: List<Reference>? = null,
  public var division: KotlinString? = null,
  public var _division: Element? = null,
  public var productStatus: Coding? = null,
  public var expirationDate: KotlinString? = null,
  public var _expirationDate: Element? = null,
  public var collection: BiologicallyDerivedProduct.Collection? = null,
  public var storageTempRequirements: Range? = null,
  public var `property`: List<BiologicallyDerivedProduct.Property>? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct =
    BiologicallyDerivedProduct(
      id = this@BiologicallyDerivedProductSurrogate.id,
      meta = this@BiologicallyDerivedProductSurrogate.meta,
      implicitRules =
        Uri.of(
          this@BiologicallyDerivedProductSurrogate.implicitRules,
          this@BiologicallyDerivedProductSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@BiologicallyDerivedProductSurrogate.language,
          this@BiologicallyDerivedProductSurrogate._language,
        ),
      text = this@BiologicallyDerivedProductSurrogate.text,
      contained = this@BiologicallyDerivedProductSurrogate.contained ?: listOf(),
      extension = this@BiologicallyDerivedProductSurrogate.extension ?: listOf(),
      modifierExtension = this@BiologicallyDerivedProductSurrogate.modifierExtension ?: listOf(),
      productCategory = this@BiologicallyDerivedProductSurrogate.productCategory,
      productCode = this@BiologicallyDerivedProductSurrogate.productCode,
      parent = this@BiologicallyDerivedProductSurrogate.parent ?: listOf(),
      request = this@BiologicallyDerivedProductSurrogate.request ?: listOf(),
      identifier = this@BiologicallyDerivedProductSurrogate.identifier ?: listOf(),
      biologicalSourceEvent = this@BiologicallyDerivedProductSurrogate.biologicalSourceEvent,
      processingFacility = this@BiologicallyDerivedProductSurrogate.processingFacility ?: listOf(),
      division =
        R5String.of(
          this@BiologicallyDerivedProductSurrogate.division,
          this@BiologicallyDerivedProductSurrogate._division,
        ),
      productStatus = this@BiologicallyDerivedProductSurrogate.productStatus,
      expirationDate =
        DateTime.of(
          FhirDateTime.fromString(this@BiologicallyDerivedProductSurrogate.expirationDate),
          this@BiologicallyDerivedProductSurrogate._expirationDate,
        ),
      collection = this@BiologicallyDerivedProductSurrogate.collection,
      storageTempRequirements = this@BiologicallyDerivedProductSurrogate.storageTempRequirements,
      `property` = this@BiologicallyDerivedProductSurrogate.`property` ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: BiologicallyDerivedProduct): BiologicallyDerivedProductSurrogate =
      with(model) {
        BiologicallyDerivedProductSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          productCategory = this@with.productCategory,
          productCode = this@with.productCode,
          parent = this@with.parent.takeIf { it.isNotEmpty() },
          request = this@with.request.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          biologicalSourceEvent = this@with.biologicalSourceEvent,
          processingFacility = this@with.processingFacility.takeIf { it.isNotEmpty() },
          division = this@with.division?.value,
          _division = this@with.division?.toElement(),
          productStatus = this@with.productStatus,
          expirationDate = this@with.expirationDate?.value?.toString(),
          _expirationDate = this@with.expirationDate?.toElement(),
          collection = this@with.collection,
          storageTempRequirements = this@with.storageTempRequirements,
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
        )
      }
  }
}

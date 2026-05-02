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

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.BiologicallyDerivedProduct
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Decimal
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Integer
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Double
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
internal data class BiologicallyDerivedProductProcessingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var procedure: CodeableConcept? = null,
  public var additive: Reference? = null,
  public var time: BiologicallyDerivedProduct.Processing.Time? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct.Processing =
    BiologicallyDerivedProduct.Processing(
      id = this@BiologicallyDerivedProductProcessingSurrogate.id,
      extension = this@BiologicallyDerivedProductProcessingSurrogate.extension ?: listOf(),
      modifierExtension =
        this@BiologicallyDerivedProductProcessingSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@BiologicallyDerivedProductProcessingSurrogate.description,
          this@BiologicallyDerivedProductProcessingSurrogate._description,
        ),
      procedure = this@BiologicallyDerivedProductProcessingSurrogate.procedure,
      additive = this@BiologicallyDerivedProductProcessingSurrogate.additive,
      time = this@BiologicallyDerivedProductProcessingSurrogate.time,
    )

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Processing
    ): BiologicallyDerivedProductProcessingSurrogate =
      with(model) {
        BiologicallyDerivedProductProcessingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          procedure = this@with.procedure,
          additive = this@with.additive,
          time = this@with.time,
        )
      }
  }
}

@Serializable
internal data class BiologicallyDerivedProductManipulationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var time: BiologicallyDerivedProduct.Manipulation.Time? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct.Manipulation =
    BiologicallyDerivedProduct.Manipulation(
      id = this@BiologicallyDerivedProductManipulationSurrogate.id,
      extension = this@BiologicallyDerivedProductManipulationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@BiologicallyDerivedProductManipulationSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@BiologicallyDerivedProductManipulationSurrogate.description,
          this@BiologicallyDerivedProductManipulationSurrogate._description,
        ),
      time = this@BiologicallyDerivedProductManipulationSurrogate.time,
    )

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Manipulation
    ): BiologicallyDerivedProductManipulationSurrogate =
      with(model) {
        BiologicallyDerivedProductManipulationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          time = this@with.time,
        )
      }
  }
}

@Serializable
internal data class BiologicallyDerivedProductStorageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var temperature: Double? = null,
  public var _temperature: Element? = null,
  public var scale: KotlinString? = null,
  public var _scale: Element? = null,
  public var duration: Period? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct.Storage =
    BiologicallyDerivedProduct.Storage(
      id = this@BiologicallyDerivedProductStorageSurrogate.id,
      extension = this@BiologicallyDerivedProductStorageSurrogate.extension ?: listOf(),
      modifierExtension =
        this@BiologicallyDerivedProductStorageSurrogate.modifierExtension ?: listOf(),
      description =
        R4bString.of(
          this@BiologicallyDerivedProductStorageSurrogate.description,
          this@BiologicallyDerivedProductStorageSurrogate._description,
        ),
      temperature =
        Decimal.of(
          this@BiologicallyDerivedProductStorageSurrogate.temperature,
          this@BiologicallyDerivedProductStorageSurrogate._temperature,
        ),
      scale =
        this@BiologicallyDerivedProductStorageSurrogate.scale?.let {
          Enumeration.of(
            BiologicallyDerivedProduct.BiologicallyDerivedProductStorageScale.fromCode(it),
            this@BiologicallyDerivedProductStorageSurrogate._scale,
          )
        },
      duration = this@BiologicallyDerivedProductStorageSurrogate.duration,
    )

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Storage
    ): BiologicallyDerivedProductStorageSurrogate =
      with(model) {
        BiologicallyDerivedProductStorageSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          temperature = this@with.temperature?.value?.toString()?.toDouble(),
          _temperature = this@with.temperature?.toElement(),
          scale = this@with.scale?.value?.getCode(),
          _scale = this@with.scale?.toElement(),
          duration = this@with.duration,
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
internal data class BiologicallyDerivedProductProcessingTimeSurrogate(
  public var timeDateTime: KotlinString? = null,
  public var _timeDateTime: Element? = null,
  public var timePeriod: Period? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct.Processing.Time =
    BiologicallyDerivedProduct.Processing.Time.from(
      DateTime.of(
        FhirDateTime.fromString(
          this@BiologicallyDerivedProductProcessingTimeSurrogate.timeDateTime
        ),
        this@BiologicallyDerivedProductProcessingTimeSurrogate._timeDateTime,
      ),
      this@BiologicallyDerivedProductProcessingTimeSurrogate.timePeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Processing.Time
    ): BiologicallyDerivedProductProcessingTimeSurrogate =
      with(model) {
        BiologicallyDerivedProductProcessingTimeSurrogate(
          timeDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _timeDateTime = this@with.asDateTime()?.value?.toElement(),
          timePeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class BiologicallyDerivedProductManipulationTimeSurrogate(
  public var timeDateTime: KotlinString? = null,
  public var _timeDateTime: Element? = null,
  public var timePeriod: Period? = null,
) {
  public fun toModel(): BiologicallyDerivedProduct.Manipulation.Time =
    BiologicallyDerivedProduct.Manipulation.Time.from(
      DateTime.of(
        FhirDateTime.fromString(
          this@BiologicallyDerivedProductManipulationTimeSurrogate.timeDateTime
        ),
        this@BiologicallyDerivedProductManipulationTimeSurrogate._timeDateTime,
      ),
      this@BiologicallyDerivedProductManipulationTimeSurrogate.timePeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: BiologicallyDerivedProduct.Manipulation.Time
    ): BiologicallyDerivedProductManipulationTimeSurrogate =
      with(model) {
        BiologicallyDerivedProductManipulationTimeSurrogate(
          timeDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _timeDateTime = this@with.asDateTime()?.value?.toElement(),
          timePeriod = this@with.asPeriod()?.value,
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
  public var identifier: List<Identifier>? = null,
  public var productCategory: KotlinString? = null,
  public var _productCategory: Element? = null,
  public var productCode: CodeableConcept? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var request: List<Reference>? = null,
  public var quantity: Int? = null,
  public var _quantity: Element? = null,
  public var parent: List<Reference>? = null,
  public var collection: BiologicallyDerivedProduct.Collection? = null,
  public var processing: List<BiologicallyDerivedProduct.Processing>? = null,
  public var manipulation: BiologicallyDerivedProduct.Manipulation? = null,
  public var storage: List<BiologicallyDerivedProduct.Storage>? = null,
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
      identifier = this@BiologicallyDerivedProductSurrogate.identifier ?: listOf(),
      productCategory =
        this@BiologicallyDerivedProductSurrogate.productCategory?.let {
          Enumeration.of(
            BiologicallyDerivedProduct.BiologicallyDerivedProductCategory.fromCode(it),
            this@BiologicallyDerivedProductSurrogate._productCategory,
          )
        },
      productCode = this@BiologicallyDerivedProductSurrogate.productCode,
      status =
        this@BiologicallyDerivedProductSurrogate.status?.let {
          Enumeration.of(
            BiologicallyDerivedProduct.BiologicallyDerivedProductStatus.fromCode(it),
            this@BiologicallyDerivedProductSurrogate._status,
          )
        },
      request = this@BiologicallyDerivedProductSurrogate.request ?: listOf(),
      quantity =
        Integer.of(
          this@BiologicallyDerivedProductSurrogate.quantity,
          this@BiologicallyDerivedProductSurrogate._quantity,
        ),
      parent = this@BiologicallyDerivedProductSurrogate.parent ?: listOf(),
      collection = this@BiologicallyDerivedProductSurrogate.collection,
      processing = this@BiologicallyDerivedProductSurrogate.processing ?: listOf(),
      manipulation = this@BiologicallyDerivedProductSurrogate.manipulation,
      storage = this@BiologicallyDerivedProductSurrogate.storage ?: listOf(),
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
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          productCategory = this@with.productCategory?.value?.getCode(),
          _productCategory = this@with.productCategory?.toElement(),
          productCode = this@with.productCode,
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          request = this@with.request.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity?.value,
          _quantity = this@with.quantity?.toElement(),
          parent = this@with.parent.takeIf { it.isNotEmpty() },
          collection = this@with.collection,
          processing = this@with.processing.takeIf { it.isNotEmpty() },
          manipulation = this@with.manipulation,
          storage = this@with.storage.takeIf { it.isNotEmpty() },
        )
      }
  }
}

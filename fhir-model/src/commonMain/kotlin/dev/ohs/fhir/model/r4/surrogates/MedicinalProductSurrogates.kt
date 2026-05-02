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

package com.google.fhir.model.r4.surrogates

import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Coding
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.MarketingStatus
import com.google.fhir.model.r4.MedicinalProduct
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MedicinalProductNameSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var productName: KotlinString? = null,
  public var _productName: Element? = null,
  public var namePart: List<MedicinalProduct.Name.NamePart>? = null,
  public var countryLanguage: List<MedicinalProduct.Name.CountryLanguage>? = null,
) {
  public fun toModel(): MedicinalProduct.Name =
    MedicinalProduct.Name(
      id = this@MedicinalProductNameSurrogate.id,
      extension = this@MedicinalProductNameSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicinalProductNameSurrogate.modifierExtension ?: listOf(),
      productName =
        R4String.of(
          this@MedicinalProductNameSurrogate.productName,
          this@MedicinalProductNameSurrogate._productName,
        )!!,
      namePart = this@MedicinalProductNameSurrogate.namePart ?: listOf(),
      countryLanguage = this@MedicinalProductNameSurrogate.countryLanguage ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MedicinalProduct.Name): MedicinalProductNameSurrogate =
      with(model) {
        MedicinalProductNameSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          productName = this@with.productName.value,
          _productName = this@with.productName.toElement(),
          namePart = this@with.namePart.takeIf { it.isNotEmpty() },
          countryLanguage = this@with.countryLanguage.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicinalProductNameNamePartSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var part: KotlinString? = null,
  public var _part: Element? = null,
  public var type: Coding,
) {
  public fun toModel(): MedicinalProduct.Name.NamePart =
    MedicinalProduct.Name.NamePart(
      id = this@MedicinalProductNameNamePartSurrogate.id,
      extension = this@MedicinalProductNameNamePartSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicinalProductNameNamePartSurrogate.modifierExtension ?: listOf(),
      part =
        R4String.of(
          this@MedicinalProductNameNamePartSurrogate.part,
          this@MedicinalProductNameNamePartSurrogate._part,
        )!!,
      type = this@MedicinalProductNameNamePartSurrogate.type,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProduct.Name.NamePart
    ): MedicinalProductNameNamePartSurrogate =
      with(model) {
        MedicinalProductNameNamePartSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          part = this@with.part.value,
          _part = this@with.part.toElement(),
          type = this@with.type,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductNameCountryLanguageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var country: CodeableConcept,
  public var jurisdiction: CodeableConcept? = null,
  public var language: CodeableConcept,
) {
  public fun toModel(): MedicinalProduct.Name.CountryLanguage =
    MedicinalProduct.Name.CountryLanguage(
      id = this@MedicinalProductNameCountryLanguageSurrogate.id,
      extension = this@MedicinalProductNameCountryLanguageSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductNameCountryLanguageSurrogate.modifierExtension ?: listOf(),
      country = this@MedicinalProductNameCountryLanguageSurrogate.country,
      jurisdiction = this@MedicinalProductNameCountryLanguageSurrogate.jurisdiction,
      language = this@MedicinalProductNameCountryLanguageSurrogate.language,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProduct.Name.CountryLanguage
    ): MedicinalProductNameCountryLanguageSurrogate =
      with(model) {
        MedicinalProductNameCountryLanguageSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          country = this@with.country,
          jurisdiction = this@with.jurisdiction,
          language = this@with.language,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductManufacturingBusinessOperationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var operationType: CodeableConcept? = null,
  public var authorisationReferenceNumber: Identifier? = null,
  public var effectiveDate: KotlinString? = null,
  public var _effectiveDate: Element? = null,
  public var confidentialityIndicator: CodeableConcept? = null,
  public var manufacturer: List<Reference>? = null,
  public var regulator: Reference? = null,
) {
  public fun toModel(): MedicinalProduct.ManufacturingBusinessOperation =
    MedicinalProduct.ManufacturingBusinessOperation(
      id = this@MedicinalProductManufacturingBusinessOperationSurrogate.id,
      extension =
        this@MedicinalProductManufacturingBusinessOperationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductManufacturingBusinessOperationSurrogate.modifierExtension ?: listOf(),
      operationType = this@MedicinalProductManufacturingBusinessOperationSurrogate.operationType,
      authorisationReferenceNumber =
        this@MedicinalProductManufacturingBusinessOperationSurrogate.authorisationReferenceNumber,
      effectiveDate =
        DateTime.of(
          FhirDateTime.fromString(
            this@MedicinalProductManufacturingBusinessOperationSurrogate.effectiveDate
          ),
          this@MedicinalProductManufacturingBusinessOperationSurrogate._effectiveDate,
        ),
      confidentialityIndicator =
        this@MedicinalProductManufacturingBusinessOperationSurrogate.confidentialityIndicator,
      manufacturer =
        this@MedicinalProductManufacturingBusinessOperationSurrogate.manufacturer ?: listOf(),
      regulator = this@MedicinalProductManufacturingBusinessOperationSurrogate.regulator,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProduct.ManufacturingBusinessOperation
    ): MedicinalProductManufacturingBusinessOperationSurrogate =
      with(model) {
        MedicinalProductManufacturingBusinessOperationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          operationType = this@with.operationType,
          authorisationReferenceNumber = this@with.authorisationReferenceNumber,
          effectiveDate = this@with.effectiveDate?.value?.toString(),
          _effectiveDate = this@with.effectiveDate?.toElement(),
          confidentialityIndicator = this@with.confidentialityIndicator,
          manufacturer = this@with.manufacturer.takeIf { it.isNotEmpty() },
          regulator = this@with.regulator,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductSpecialDesignationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var type: CodeableConcept? = null,
  public var intendedUse: CodeableConcept? = null,
  public var indication: MedicinalProduct.SpecialDesignation.Indication? = null,
  public var status: CodeableConcept? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var species: CodeableConcept? = null,
) {
  public fun toModel(): MedicinalProduct.SpecialDesignation =
    MedicinalProduct.SpecialDesignation(
      id = this@MedicinalProductSpecialDesignationSurrogate.id,
      extension = this@MedicinalProductSpecialDesignationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductSpecialDesignationSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicinalProductSpecialDesignationSurrogate.identifier ?: listOf(),
      type = this@MedicinalProductSpecialDesignationSurrogate.type,
      intendedUse = this@MedicinalProductSpecialDesignationSurrogate.intendedUse,
      indication = this@MedicinalProductSpecialDesignationSurrogate.indication,
      status = this@MedicinalProductSpecialDesignationSurrogate.status,
      date =
        DateTime.of(
          FhirDateTime.fromString(this@MedicinalProductSpecialDesignationSurrogate.date),
          this@MedicinalProductSpecialDesignationSurrogate._date,
        ),
      species = this@MedicinalProductSpecialDesignationSurrogate.species,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProduct.SpecialDesignation
    ): MedicinalProductSpecialDesignationSurrogate =
      with(model) {
        MedicinalProductSpecialDesignationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          type = this@with.type,
          intendedUse = this@with.intendedUse,
          indication = this@with.indication,
          status = this@with.status,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          species = this@with.species,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductSpecialDesignationIndicationSurrogate(
  public var indicationCodeableConcept: CodeableConcept? = null,
  public var indicationReference: Reference? = null,
) {
  public fun toModel(): MedicinalProduct.SpecialDesignation.Indication =
    MedicinalProduct.SpecialDesignation.Indication.from(
      this@MedicinalProductSpecialDesignationIndicationSurrogate.indicationCodeableConcept,
      this@MedicinalProductSpecialDesignationIndicationSurrogate.indicationReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicinalProduct.SpecialDesignation.Indication
    ): MedicinalProductSpecialDesignationIndicationSurrogate =
      with(model) {
        MedicinalProductSpecialDesignationIndicationSurrogate(
          indicationCodeableConcept = this@with.asCodeableConcept()?.value,
          indicationReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductSurrogate(
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
  public var type: CodeableConcept? = null,
  public var domain: Coding? = null,
  public var combinedPharmaceuticalDoseForm: CodeableConcept? = null,
  public var legalStatusOfSupply: CodeableConcept? = null,
  public var additionalMonitoringIndicator: CodeableConcept? = null,
  public var specialMeasures: List<KotlinString?>? = null,
  public var _specialMeasures: List<Element?>? = null,
  public var paediatricUseIndicator: CodeableConcept? = null,
  public var productClassification: List<CodeableConcept>? = null,
  public var marketingStatus: List<MarketingStatus>? = null,
  public var pharmaceuticalProduct: List<Reference>? = null,
  public var packagedMedicinalProduct: List<Reference>? = null,
  public var attachedDocument: List<Reference>? = null,
  public var masterFile: List<Reference>? = null,
  public var contact: List<Reference>? = null,
  public var clinicalTrial: List<Reference>? = null,
  public var name: List<MedicinalProduct.Name>? = null,
  public var crossReference: List<Identifier>? = null,
  public var manufacturingBusinessOperation:
    List<MedicinalProduct.ManufacturingBusinessOperation>? =
    null,
  public var specialDesignation: List<MedicinalProduct.SpecialDesignation>? = null,
) {
  public fun toModel(): MedicinalProduct =
    MedicinalProduct(
      id = this@MedicinalProductSurrogate.id,
      meta = this@MedicinalProductSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicinalProductSurrogate.implicitRules,
          this@MedicinalProductSurrogate._implicitRules,
        ),
      language =
        Code.of(this@MedicinalProductSurrogate.language, this@MedicinalProductSurrogate._language),
      text = this@MedicinalProductSurrogate.text,
      contained = this@MedicinalProductSurrogate.contained ?: listOf(),
      extension = this@MedicinalProductSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicinalProductSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicinalProductSurrogate.identifier ?: listOf(),
      type = this@MedicinalProductSurrogate.type,
      domain = this@MedicinalProductSurrogate.domain,
      combinedPharmaceuticalDoseForm =
        this@MedicinalProductSurrogate.combinedPharmaceuticalDoseForm,
      legalStatusOfSupply = this@MedicinalProductSurrogate.legalStatusOfSupply,
      additionalMonitoringIndicator = this@MedicinalProductSurrogate.additionalMonitoringIndicator,
      specialMeasures =
        if (
          this@MedicinalProductSurrogate.specialMeasures == null &&
            this@MedicinalProductSurrogate._specialMeasures == null
        ) {
          listOf()
        } else {
          (this@MedicinalProductSurrogate.specialMeasures
              ?: List(this@MedicinalProductSurrogate._specialMeasures!!.size) { null })
            .zip(
              this@MedicinalProductSurrogate._specialMeasures
                ?: List(this@MedicinalProductSurrogate.specialMeasures!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      paediatricUseIndicator = this@MedicinalProductSurrogate.paediatricUseIndicator,
      productClassification = this@MedicinalProductSurrogate.productClassification ?: listOf(),
      marketingStatus = this@MedicinalProductSurrogate.marketingStatus ?: listOf(),
      pharmaceuticalProduct = this@MedicinalProductSurrogate.pharmaceuticalProduct ?: listOf(),
      packagedMedicinalProduct =
        this@MedicinalProductSurrogate.packagedMedicinalProduct ?: listOf(),
      attachedDocument = this@MedicinalProductSurrogate.attachedDocument ?: listOf(),
      masterFile = this@MedicinalProductSurrogate.masterFile ?: listOf(),
      contact = this@MedicinalProductSurrogate.contact ?: listOf(),
      clinicalTrial = this@MedicinalProductSurrogate.clinicalTrial ?: listOf(),
      name = this@MedicinalProductSurrogate.name ?: listOf(),
      crossReference = this@MedicinalProductSurrogate.crossReference ?: listOf(),
      manufacturingBusinessOperation =
        this@MedicinalProductSurrogate.manufacturingBusinessOperation ?: listOf(),
      specialDesignation = this@MedicinalProductSurrogate.specialDesignation ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MedicinalProduct): MedicinalProductSurrogate =
      with(model) {
        MedicinalProductSurrogate(
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
          type = this@with.type,
          domain = this@with.domain,
          combinedPharmaceuticalDoseForm = this@with.combinedPharmaceuticalDoseForm,
          legalStatusOfSupply = this@with.legalStatusOfSupply,
          additionalMonitoringIndicator = this@with.additionalMonitoringIndicator,
          specialMeasures =
            this@with.specialMeasures
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _specialMeasures =
            this@with.specialMeasures
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          paediatricUseIndicator = this@with.paediatricUseIndicator,
          productClassification = this@with.productClassification.takeIf { it.isNotEmpty() },
          marketingStatus = this@with.marketingStatus.takeIf { it.isNotEmpty() },
          pharmaceuticalProduct = this@with.pharmaceuticalProduct.takeIf { it.isNotEmpty() },
          packagedMedicinalProduct = this@with.packagedMedicinalProduct.takeIf { it.isNotEmpty() },
          attachedDocument = this@with.attachedDocument.takeIf { it.isNotEmpty() },
          masterFile = this@with.masterFile.takeIf { it.isNotEmpty() },
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          clinicalTrial = this@with.clinicalTrial.takeIf { it.isNotEmpty() },
          name = this@with.name.takeIf { it.isNotEmpty() },
          crossReference = this@with.crossReference.takeIf { it.isNotEmpty() },
          manufacturingBusinessOperation =
            this@with.manufacturingBusinessOperation.takeIf { it.isNotEmpty() },
          specialDesignation = this@with.specialDesignation.takeIf { it.isNotEmpty() },
        )
      }
  }
}

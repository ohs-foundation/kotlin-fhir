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

import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.CodeableReference
import com.google.fhir.model.r4b.Coding
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.MarketingStatus
import com.google.fhir.model.r4b.MedicinalProductDefinition
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MedicinalProductDefinitionContactSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var contact: Reference,
) {
  public fun toModel(): MedicinalProductDefinition.Contact =
    MedicinalProductDefinition.Contact(
      id = this@MedicinalProductDefinitionContactSurrogate.id,
      extension = this@MedicinalProductDefinitionContactSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductDefinitionContactSurrogate.modifierExtension ?: listOf(),
      type = this@MedicinalProductDefinitionContactSurrogate.type,
      contact = this@MedicinalProductDefinitionContactSurrogate.contact,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductDefinition.Contact
    ): MedicinalProductDefinitionContactSurrogate =
      with(model) {
        MedicinalProductDefinitionContactSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          contact = this@with.contact,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductDefinitionNameSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var productName: KotlinString? = null,
  public var _productName: Element? = null,
  public var type: CodeableConcept? = null,
  public var namePart: List<MedicinalProductDefinition.Name.NamePart>? = null,
  public var countryLanguage: List<MedicinalProductDefinition.Name.CountryLanguage>? = null,
) {
  public fun toModel(): MedicinalProductDefinition.Name =
    MedicinalProductDefinition.Name(
      id = this@MedicinalProductDefinitionNameSurrogate.id,
      extension = this@MedicinalProductDefinitionNameSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductDefinitionNameSurrogate.modifierExtension ?: listOf(),
      productName =
        R4bString.of(
          this@MedicinalProductDefinitionNameSurrogate.productName,
          this@MedicinalProductDefinitionNameSurrogate._productName,
        )!!,
      type = this@MedicinalProductDefinitionNameSurrogate.type,
      namePart = this@MedicinalProductDefinitionNameSurrogate.namePart ?: listOf(),
      countryLanguage = this@MedicinalProductDefinitionNameSurrogate.countryLanguage ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductDefinition.Name
    ): MedicinalProductDefinitionNameSurrogate =
      with(model) {
        MedicinalProductDefinitionNameSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          productName = this@with.productName.value,
          _productName = this@with.productName.toElement(),
          type = this@with.type,
          namePart = this@with.namePart.takeIf { it.isNotEmpty() },
          countryLanguage = this@with.countryLanguage.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MedicinalProductDefinitionNameNamePartSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var part: KotlinString? = null,
  public var _part: Element? = null,
  public var type: CodeableConcept,
) {
  public fun toModel(): MedicinalProductDefinition.Name.NamePart =
    MedicinalProductDefinition.Name.NamePart(
      id = this@MedicinalProductDefinitionNameNamePartSurrogate.id,
      extension = this@MedicinalProductDefinitionNameNamePartSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductDefinitionNameNamePartSurrogate.modifierExtension ?: listOf(),
      part =
        R4bString.of(
          this@MedicinalProductDefinitionNameNamePartSurrogate.part,
          this@MedicinalProductDefinitionNameNamePartSurrogate._part,
        )!!,
      type = this@MedicinalProductDefinitionNameNamePartSurrogate.type,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductDefinition.Name.NamePart
    ): MedicinalProductDefinitionNameNamePartSurrogate =
      with(model) {
        MedicinalProductDefinitionNameNamePartSurrogate(
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
internal data class MedicinalProductDefinitionNameCountryLanguageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var country: CodeableConcept,
  public var jurisdiction: CodeableConcept? = null,
  public var language: CodeableConcept,
) {
  public fun toModel(): MedicinalProductDefinition.Name.CountryLanguage =
    MedicinalProductDefinition.Name.CountryLanguage(
      id = this@MedicinalProductDefinitionNameCountryLanguageSurrogate.id,
      extension = this@MedicinalProductDefinitionNameCountryLanguageSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductDefinitionNameCountryLanguageSurrogate.modifierExtension ?: listOf(),
      country = this@MedicinalProductDefinitionNameCountryLanguageSurrogate.country,
      jurisdiction = this@MedicinalProductDefinitionNameCountryLanguageSurrogate.jurisdiction,
      language = this@MedicinalProductDefinitionNameCountryLanguageSurrogate.language,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductDefinition.Name.CountryLanguage
    ): MedicinalProductDefinitionNameCountryLanguageSurrogate =
      with(model) {
        MedicinalProductDefinitionNameCountryLanguageSurrogate(
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
internal data class MedicinalProductDefinitionCrossReferenceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var product: CodeableReference,
  public var type: CodeableConcept? = null,
) {
  public fun toModel(): MedicinalProductDefinition.CrossReference =
    MedicinalProductDefinition.CrossReference(
      id = this@MedicinalProductDefinitionCrossReferenceSurrogate.id,
      extension = this@MedicinalProductDefinitionCrossReferenceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductDefinitionCrossReferenceSurrogate.modifierExtension ?: listOf(),
      product = this@MedicinalProductDefinitionCrossReferenceSurrogate.product,
      type = this@MedicinalProductDefinitionCrossReferenceSurrogate.type,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductDefinition.CrossReference
    ): MedicinalProductDefinitionCrossReferenceSurrogate =
      with(model) {
        MedicinalProductDefinitionCrossReferenceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          product = this@with.product,
          type = this@with.type,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductDefinitionOperationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableReference? = null,
  public var effectiveDate: Period? = null,
  public var organization: List<Reference>? = null,
  public var confidentialityIndicator: CodeableConcept? = null,
) {
  public fun toModel(): MedicinalProductDefinition.Operation =
    MedicinalProductDefinition.Operation(
      id = this@MedicinalProductDefinitionOperationSurrogate.id,
      extension = this@MedicinalProductDefinitionOperationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductDefinitionOperationSurrogate.modifierExtension ?: listOf(),
      type = this@MedicinalProductDefinitionOperationSurrogate.type,
      effectiveDate = this@MedicinalProductDefinitionOperationSurrogate.effectiveDate,
      organization = this@MedicinalProductDefinitionOperationSurrogate.organization ?: listOf(),
      confidentialityIndicator =
        this@MedicinalProductDefinitionOperationSurrogate.confidentialityIndicator,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductDefinition.Operation
    ): MedicinalProductDefinitionOperationSurrogate =
      with(model) {
        MedicinalProductDefinitionOperationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          effectiveDate = this@with.effectiveDate,
          organization = this@with.organization.takeIf { it.isNotEmpty() },
          confidentialityIndicator = this@with.confidentialityIndicator,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductDefinitionCharacteristicSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: MedicinalProductDefinition.Characteristic.Value? = null,
) {
  public fun toModel(): MedicinalProductDefinition.Characteristic =
    MedicinalProductDefinition.Characteristic(
      id = this@MedicinalProductDefinitionCharacteristicSurrogate.id,
      extension = this@MedicinalProductDefinitionCharacteristicSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MedicinalProductDefinitionCharacteristicSurrogate.modifierExtension ?: listOf(),
      type = this@MedicinalProductDefinitionCharacteristicSurrogate.type,
      `value` = this@MedicinalProductDefinitionCharacteristicSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: MedicinalProductDefinition.Characteristic
    ): MedicinalProductDefinitionCharacteristicSurrogate =
      with(model) {
        MedicinalProductDefinitionCharacteristicSurrogate(
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
internal data class MedicinalProductDefinitionCharacteristicValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueAttachment: Attachment? = null,
) {
  public fun toModel(): MedicinalProductDefinition.Characteristic.Value =
    MedicinalProductDefinition.Characteristic.Value.from(
      this@MedicinalProductDefinitionCharacteristicValueSurrogate.valueCodeableConcept,
      this@MedicinalProductDefinitionCharacteristicValueSurrogate.valueQuantity,
      Date.of(
        FhirDate.fromString(this@MedicinalProductDefinitionCharacteristicValueSurrogate.valueDate),
        this@MedicinalProductDefinitionCharacteristicValueSurrogate._valueDate,
      ),
      R4bBoolean.of(
        this@MedicinalProductDefinitionCharacteristicValueSurrogate.valueBoolean,
        this@MedicinalProductDefinitionCharacteristicValueSurrogate._valueBoolean,
      ),
      this@MedicinalProductDefinitionCharacteristicValueSurrogate.valueAttachment,
    )!!

  public companion object {
    public fun fromModel(
      model: MedicinalProductDefinition.Characteristic.Value
    ): MedicinalProductDefinitionCharacteristicValueSurrogate =
      with(model) {
        MedicinalProductDefinitionCharacteristicValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
        )
      }
  }
}

@Serializable
internal data class MedicinalProductDefinitionSurrogate(
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
  public var domain: CodeableConcept? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var status: CodeableConcept? = null,
  public var statusDate: KotlinString? = null,
  public var _statusDate: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var combinedPharmaceuticalDoseForm: CodeableConcept? = null,
  public var route: List<CodeableConcept>? = null,
  public var indication: KotlinString? = null,
  public var _indication: Element? = null,
  public var legalStatusOfSupply: CodeableConcept? = null,
  public var additionalMonitoringIndicator: CodeableConcept? = null,
  public var specialMeasures: List<CodeableConcept>? = null,
  public var pediatricUseIndicator: CodeableConcept? = null,
  public var classification: List<CodeableConcept>? = null,
  public var marketingStatus: List<MarketingStatus>? = null,
  public var packagedMedicinalProduct: List<CodeableConcept>? = null,
  public var ingredient: List<CodeableConcept>? = null,
  public var impurity: List<CodeableReference>? = null,
  public var attachedDocument: List<Reference>? = null,
  public var masterFile: List<Reference>? = null,
  public var contact: List<MedicinalProductDefinition.Contact>? = null,
  public var clinicalTrial: List<Reference>? = null,
  public var code: List<Coding>? = null,
  public var name: List<MedicinalProductDefinition.Name>? = null,
  public var crossReference: List<MedicinalProductDefinition.CrossReference>? = null,
  public var operation: List<MedicinalProductDefinition.Operation>? = null,
  public var characteristic: List<MedicinalProductDefinition.Characteristic>? = null,
) {
  public fun toModel(): MedicinalProductDefinition =
    MedicinalProductDefinition(
      id = this@MedicinalProductDefinitionSurrogate.id,
      meta = this@MedicinalProductDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MedicinalProductDefinitionSurrogate.implicitRules,
          this@MedicinalProductDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MedicinalProductDefinitionSurrogate.language,
          this@MedicinalProductDefinitionSurrogate._language,
        ),
      text = this@MedicinalProductDefinitionSurrogate.text,
      contained = this@MedicinalProductDefinitionSurrogate.contained ?: listOf(),
      extension = this@MedicinalProductDefinitionSurrogate.extension ?: listOf(),
      modifierExtension = this@MedicinalProductDefinitionSurrogate.modifierExtension ?: listOf(),
      identifier = this@MedicinalProductDefinitionSurrogate.identifier ?: listOf(),
      type = this@MedicinalProductDefinitionSurrogate.type,
      domain = this@MedicinalProductDefinitionSurrogate.domain,
      version =
        R4bString.of(
          this@MedicinalProductDefinitionSurrogate.version,
          this@MedicinalProductDefinitionSurrogate._version,
        ),
      status = this@MedicinalProductDefinitionSurrogate.status,
      statusDate =
        DateTime.of(
          FhirDateTime.fromString(this@MedicinalProductDefinitionSurrogate.statusDate),
          this@MedicinalProductDefinitionSurrogate._statusDate,
        ),
      description =
        Markdown.of(
          this@MedicinalProductDefinitionSurrogate.description,
          this@MedicinalProductDefinitionSurrogate._description,
        ),
      combinedPharmaceuticalDoseForm =
        this@MedicinalProductDefinitionSurrogate.combinedPharmaceuticalDoseForm,
      route = this@MedicinalProductDefinitionSurrogate.route ?: listOf(),
      indication =
        Markdown.of(
          this@MedicinalProductDefinitionSurrogate.indication,
          this@MedicinalProductDefinitionSurrogate._indication,
        ),
      legalStatusOfSupply = this@MedicinalProductDefinitionSurrogate.legalStatusOfSupply,
      additionalMonitoringIndicator =
        this@MedicinalProductDefinitionSurrogate.additionalMonitoringIndicator,
      specialMeasures = this@MedicinalProductDefinitionSurrogate.specialMeasures ?: listOf(),
      pediatricUseIndicator = this@MedicinalProductDefinitionSurrogate.pediatricUseIndicator,
      classification = this@MedicinalProductDefinitionSurrogate.classification ?: listOf(),
      marketingStatus = this@MedicinalProductDefinitionSurrogate.marketingStatus ?: listOf(),
      packagedMedicinalProduct =
        this@MedicinalProductDefinitionSurrogate.packagedMedicinalProduct ?: listOf(),
      ingredient = this@MedicinalProductDefinitionSurrogate.ingredient ?: listOf(),
      impurity = this@MedicinalProductDefinitionSurrogate.impurity ?: listOf(),
      attachedDocument = this@MedicinalProductDefinitionSurrogate.attachedDocument ?: listOf(),
      masterFile = this@MedicinalProductDefinitionSurrogate.masterFile ?: listOf(),
      contact = this@MedicinalProductDefinitionSurrogate.contact ?: listOf(),
      clinicalTrial = this@MedicinalProductDefinitionSurrogate.clinicalTrial ?: listOf(),
      code = this@MedicinalProductDefinitionSurrogate.code ?: listOf(),
      name = this@MedicinalProductDefinitionSurrogate.name ?: listOf(),
      crossReference = this@MedicinalProductDefinitionSurrogate.crossReference ?: listOf(),
      operation = this@MedicinalProductDefinitionSurrogate.operation ?: listOf(),
      characteristic = this@MedicinalProductDefinitionSurrogate.characteristic ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MedicinalProductDefinition): MedicinalProductDefinitionSurrogate =
      with(model) {
        MedicinalProductDefinitionSurrogate(
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
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          status = this@with.status,
          statusDate = this@with.statusDate?.value?.toString(),
          _statusDate = this@with.statusDate?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          combinedPharmaceuticalDoseForm = this@with.combinedPharmaceuticalDoseForm,
          route = this@with.route.takeIf { it.isNotEmpty() },
          indication = this@with.indication?.value,
          _indication = this@with.indication?.toElement(),
          legalStatusOfSupply = this@with.legalStatusOfSupply,
          additionalMonitoringIndicator = this@with.additionalMonitoringIndicator,
          specialMeasures = this@with.specialMeasures.takeIf { it.isNotEmpty() },
          pediatricUseIndicator = this@with.pediatricUseIndicator,
          classification = this@with.classification.takeIf { it.isNotEmpty() },
          marketingStatus = this@with.marketingStatus.takeIf { it.isNotEmpty() },
          packagedMedicinalProduct = this@with.packagedMedicinalProduct.takeIf { it.isNotEmpty() },
          ingredient = this@with.ingredient.takeIf { it.isNotEmpty() },
          impurity = this@with.impurity.takeIf { it.isNotEmpty() },
          attachedDocument = this@with.attachedDocument.takeIf { it.isNotEmpty() },
          masterFile = this@with.masterFile.takeIf { it.isNotEmpty() },
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          clinicalTrial = this@with.clinicalTrial.takeIf { it.isNotEmpty() },
          code = this@with.code.takeIf { it.isNotEmpty() },
          name = this@with.name.takeIf { it.isNotEmpty() },
          crossReference = this@with.crossReference.takeIf { it.isNotEmpty() },
          operation = this@with.operation.takeIf { it.isNotEmpty() },
          characteristic = this@with.characteristic.takeIf { it.isNotEmpty() },
        )
      }
  }
}

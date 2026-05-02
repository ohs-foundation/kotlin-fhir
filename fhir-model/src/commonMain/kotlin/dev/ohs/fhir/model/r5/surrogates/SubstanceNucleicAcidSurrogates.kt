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
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.SubstanceNucleicAcid
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class SubstanceNucleicAcidSubunitSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var subunit: Int? = null,
  public var _subunit: Element? = null,
  public var sequence: KotlinString? = null,
  public var _sequence: Element? = null,
  public var length: Int? = null,
  public var _length: Element? = null,
  public var sequenceAttachment: Attachment? = null,
  public var fivePrime: CodeableConcept? = null,
  public var threePrime: CodeableConcept? = null,
  public var linkage: List<SubstanceNucleicAcid.Subunit.Linkage>? = null,
  public var sugar: List<SubstanceNucleicAcid.Subunit.Sugar>? = null,
) {
  public fun toModel(): SubstanceNucleicAcid.Subunit =
    SubstanceNucleicAcid.Subunit(
      id = this@SubstanceNucleicAcidSubunitSurrogate.id,
      extension = this@SubstanceNucleicAcidSubunitSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceNucleicAcidSubunitSurrogate.modifierExtension ?: listOf(),
      subunit =
        Integer.of(
          this@SubstanceNucleicAcidSubunitSurrogate.subunit,
          this@SubstanceNucleicAcidSubunitSurrogate._subunit,
        ),
      sequence =
        R5String.of(
          this@SubstanceNucleicAcidSubunitSurrogate.sequence,
          this@SubstanceNucleicAcidSubunitSurrogate._sequence,
        ),
      length =
        Integer.of(
          this@SubstanceNucleicAcidSubunitSurrogate.length,
          this@SubstanceNucleicAcidSubunitSurrogate._length,
        ),
      sequenceAttachment = this@SubstanceNucleicAcidSubunitSurrogate.sequenceAttachment,
      fivePrime = this@SubstanceNucleicAcidSubunitSurrogate.fivePrime,
      threePrime = this@SubstanceNucleicAcidSubunitSurrogate.threePrime,
      linkage = this@SubstanceNucleicAcidSubunitSurrogate.linkage ?: listOf(),
      sugar = this@SubstanceNucleicAcidSubunitSurrogate.sugar ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceNucleicAcid.Subunit
    ): SubstanceNucleicAcidSubunitSurrogate =
      with(model) {
        SubstanceNucleicAcidSubunitSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          subunit = this@with.subunit?.value,
          _subunit = this@with.subunit?.toElement(),
          sequence = this@with.sequence?.value,
          _sequence = this@with.sequence?.toElement(),
          length = this@with.length?.value,
          _length = this@with.length?.toElement(),
          sequenceAttachment = this@with.sequenceAttachment,
          fivePrime = this@with.fivePrime,
          threePrime = this@with.threePrime,
          linkage = this@with.linkage.takeIf { it.isNotEmpty() },
          sugar = this@with.sugar.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class SubstanceNucleicAcidSubunitLinkageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var connectivity: KotlinString? = null,
  public var _connectivity: Element? = null,
  public var identifier: Identifier? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var residueSite: KotlinString? = null,
  public var _residueSite: Element? = null,
) {
  public fun toModel(): SubstanceNucleicAcid.Subunit.Linkage =
    SubstanceNucleicAcid.Subunit.Linkage(
      id = this@SubstanceNucleicAcidSubunitLinkageSurrogate.id,
      extension = this@SubstanceNucleicAcidSubunitLinkageSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceNucleicAcidSubunitLinkageSurrogate.modifierExtension ?: listOf(),
      connectivity =
        R5String.of(
          this@SubstanceNucleicAcidSubunitLinkageSurrogate.connectivity,
          this@SubstanceNucleicAcidSubunitLinkageSurrogate._connectivity,
        ),
      identifier = this@SubstanceNucleicAcidSubunitLinkageSurrogate.identifier,
      name =
        R5String.of(
          this@SubstanceNucleicAcidSubunitLinkageSurrogate.name,
          this@SubstanceNucleicAcidSubunitLinkageSurrogate._name,
        ),
      residueSite =
        R5String.of(
          this@SubstanceNucleicAcidSubunitLinkageSurrogate.residueSite,
          this@SubstanceNucleicAcidSubunitLinkageSurrogate._residueSite,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceNucleicAcid.Subunit.Linkage
    ): SubstanceNucleicAcidSubunitLinkageSurrogate =
      with(model) {
        SubstanceNucleicAcidSubunitLinkageSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          connectivity = this@with.connectivity?.value,
          _connectivity = this@with.connectivity?.toElement(),
          identifier = this@with.identifier,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          residueSite = this@with.residueSite?.value,
          _residueSite = this@with.residueSite?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceNucleicAcidSubunitSugarSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: Identifier? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var residueSite: KotlinString? = null,
  public var _residueSite: Element? = null,
) {
  public fun toModel(): SubstanceNucleicAcid.Subunit.Sugar =
    SubstanceNucleicAcid.Subunit.Sugar(
      id = this@SubstanceNucleicAcidSubunitSugarSurrogate.id,
      extension = this@SubstanceNucleicAcidSubunitSugarSurrogate.extension ?: listOf(),
      modifierExtension =
        this@SubstanceNucleicAcidSubunitSugarSurrogate.modifierExtension ?: listOf(),
      identifier = this@SubstanceNucleicAcidSubunitSugarSurrogate.identifier,
      name =
        R5String.of(
          this@SubstanceNucleicAcidSubunitSugarSurrogate.name,
          this@SubstanceNucleicAcidSubunitSugarSurrogate._name,
        ),
      residueSite =
        R5String.of(
          this@SubstanceNucleicAcidSubunitSugarSurrogate.residueSite,
          this@SubstanceNucleicAcidSubunitSugarSurrogate._residueSite,
        ),
    )

  public companion object {
    public fun fromModel(
      model: SubstanceNucleicAcid.Subunit.Sugar
    ): SubstanceNucleicAcidSubunitSugarSurrogate =
      with(model) {
        SubstanceNucleicAcidSubunitSugarSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          residueSite = this@with.residueSite?.value,
          _residueSite = this@with.residueSite?.toElement(),
        )
      }
  }
}

@Serializable
internal data class SubstanceNucleicAcidSurrogate(
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
  public var sequenceType: CodeableConcept? = null,
  public var numberOfSubunits: Int? = null,
  public var _numberOfSubunits: Element? = null,
  public var areaOfHybridisation: KotlinString? = null,
  public var _areaOfHybridisation: Element? = null,
  public var oligoNucleotideType: CodeableConcept? = null,
  public var subunit: List<SubstanceNucleicAcid.Subunit>? = null,
) {
  public fun toModel(): SubstanceNucleicAcid =
    SubstanceNucleicAcid(
      id = this@SubstanceNucleicAcidSurrogate.id,
      meta = this@SubstanceNucleicAcidSurrogate.meta,
      implicitRules =
        Uri.of(
          this@SubstanceNucleicAcidSurrogate.implicitRules,
          this@SubstanceNucleicAcidSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@SubstanceNucleicAcidSurrogate.language,
          this@SubstanceNucleicAcidSurrogate._language,
        ),
      text = this@SubstanceNucleicAcidSurrogate.text,
      contained = this@SubstanceNucleicAcidSurrogate.contained ?: listOf(),
      extension = this@SubstanceNucleicAcidSurrogate.extension ?: listOf(),
      modifierExtension = this@SubstanceNucleicAcidSurrogate.modifierExtension ?: listOf(),
      sequenceType = this@SubstanceNucleicAcidSurrogate.sequenceType,
      numberOfSubunits =
        Integer.of(
          this@SubstanceNucleicAcidSurrogate.numberOfSubunits,
          this@SubstanceNucleicAcidSurrogate._numberOfSubunits,
        ),
      areaOfHybridisation =
        R5String.of(
          this@SubstanceNucleicAcidSurrogate.areaOfHybridisation,
          this@SubstanceNucleicAcidSurrogate._areaOfHybridisation,
        ),
      oligoNucleotideType = this@SubstanceNucleicAcidSurrogate.oligoNucleotideType,
      subunit = this@SubstanceNucleicAcidSurrogate.subunit ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: SubstanceNucleicAcid): SubstanceNucleicAcidSurrogate =
      with(model) {
        SubstanceNucleicAcidSurrogate(
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
          sequenceType = this@with.sequenceType,
          numberOfSubunits = this@with.numberOfSubunits?.value,
          _numberOfSubunits = this@with.numberOfSubunits?.toElement(),
          areaOfHybridisation = this@with.areaOfHybridisation?.value,
          _areaOfHybridisation = this@with.areaOfHybridisation?.toElement(),
          oligoNucleotideType = this@with.oligoNucleotideType,
          subunit = this@with.subunit.takeIf { it.isNotEmpty() },
        )
      }
  }
}

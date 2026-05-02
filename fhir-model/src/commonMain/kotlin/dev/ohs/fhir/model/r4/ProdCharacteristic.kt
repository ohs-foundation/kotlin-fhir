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

import com.google.fhir.model.r4b.serializers.ProdCharacteristicSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for ProdCharacteristic Type: The marketing status describes the date
 * when a medicinal product is actually put on the market or the date as of which it is no longer
 * available.
 */
@Serializable(with = ProdCharacteristicSerializer::class)
public data class ProdCharacteristic(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
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
   * May be used to represent additional information that is not part of the basic definition of the
   * element and that modifies the understanding of the element in which it is contained and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and manageable, there is a strict
   * set of governance applied to the definition and use of extensions. Though any implementer can
   * define an extension, there is a set of requirements that SHALL be met as part of the definition
   * of the extension. Applications processing a resource are required to check for modifier
   * extensions.
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
   * Where applicable, the height can be specified using a numerical value and its unit of
   * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
   * resulting terminology The symbol and the symbol identifier shall be used.
   */
  public val height: Quantity? = null,
  /**
   * Where applicable, the width can be specified using a numerical value and its unit of
   * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
   * resulting terminology The symbol and the symbol identifier shall be used.
   */
  public val width: Quantity? = null,
  /**
   * Where applicable, the depth can be specified using a numerical value and its unit of
   * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
   * resulting terminology The symbol and the symbol identifier shall be used.
   */
  public val depth: Quantity? = null,
  /**
   * Where applicable, the weight can be specified using a numerical value and its unit of
   * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
   * resulting terminology The symbol and the symbol identifier shall be used.
   */
  public val weight: Quantity? = null,
  /**
   * Where applicable, the nominal volume can be specified using a numerical value and its unit of
   * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
   * resulting terminology The symbol and the symbol identifier shall be used.
   */
  public val nominalVolume: Quantity? = null,
  /**
   * Where applicable, the external diameter can be specified using a numerical value and its unit
   * of measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
   * resulting terminology The symbol and the symbol identifier shall be used.
   */
  public val externalDiameter: Quantity? = null,
  /**
   * Where applicable, the shape can be specified An appropriate controlled vocabulary shall be used
   * The term and the term identifier shall be used.
   */
  public val shape: String? = null,
  /**
   * Where applicable, the color can be specified An appropriate controlled vocabulary shall be used
   * The term and the term identifier shall be used.
   */
  public val color: List<String> = listOf(),
  /** Where applicable, the imprint can be specified as text. */
  public val imprint: List<String> = listOf(),
  /**
   * Where applicable, the image can be provided The format of the image attachment shall be
   * specified by regional implementations.
   */
  public val image: List<Attachment> = listOf(),
  /**
   * Where applicable, the scoring can be specified An appropriate controlled vocabulary shall be
   * used The term and the term identifier shall be used.
   */
  public val scoring: CodeableConcept? = null,
) : BackboneElement() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        height = this@with.height?.toBuilder()
        width = this@with.width?.toBuilder()
        depth = this@with.depth?.toBuilder()
        weight = this@with.weight?.toBuilder()
        nominalVolume = this@with.nominalVolume?.toBuilder()
        externalDiameter = this@with.externalDiameter?.toBuilder()
        shape = this@with.shape?.toBuilder()
        color = this@with.color.map { it.toBuilder() }.toMutableList()
        imprint = this@with.imprint.map { it.toBuilder() }.toMutableList()
        image = this@with.image.map { it.toBuilder() }.toMutableList()
        scoring = this@with.scoring?.toBuilder()
      }
    }

  public open class Builder() {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: kotlin.String? = null

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
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

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
    public open var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * Where applicable, the height can be specified using a numerical value and its unit of
     * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
     * resulting terminology The symbol and the symbol identifier shall be used.
     */
    public open var height: Quantity.Builder? = null

    /**
     * Where applicable, the width can be specified using a numerical value and its unit of
     * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
     * resulting terminology The symbol and the symbol identifier shall be used.
     */
    public open var width: Quantity.Builder? = null

    /**
     * Where applicable, the depth can be specified using a numerical value and its unit of
     * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
     * resulting terminology The symbol and the symbol identifier shall be used.
     */
    public open var depth: Quantity.Builder? = null

    /**
     * Where applicable, the weight can be specified using a numerical value and its unit of
     * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
     * resulting terminology The symbol and the symbol identifier shall be used.
     */
    public open var weight: Quantity.Builder? = null

    /**
     * Where applicable, the nominal volume can be specified using a numerical value and its unit of
     * measurement The unit of measurement shall be specified in accordance with ISO 11240 and the
     * resulting terminology The symbol and the symbol identifier shall be used.
     */
    public open var nominalVolume: Quantity.Builder? = null

    /**
     * Where applicable, the external diameter can be specified using a numerical value and its unit
     * of measurement The unit of measurement shall be specified in accordance with ISO 11240 and
     * the resulting terminology The symbol and the symbol identifier shall be used.
     */
    public open var externalDiameter: Quantity.Builder? = null

    /**
     * Where applicable, the shape can be specified An appropriate controlled vocabulary shall be
     * used The term and the term identifier shall be used.
     */
    public open var shape: String.Builder? = null

    /**
     * Where applicable, the color can be specified An appropriate controlled vocabulary shall be
     * used The term and the term identifier shall be used.
     */
    public open var color: MutableList<String.Builder> = mutableListOf()

    /** Where applicable, the imprint can be specified as text. */
    public open var imprint: MutableList<String.Builder> = mutableListOf()

    /**
     * Where applicable, the image can be provided The format of the image attachment shall be
     * specified by regional implementations.
     */
    public open var image: MutableList<Attachment.Builder> = mutableListOf()

    /**
     * Where applicable, the scoring can be specified An appropriate controlled vocabulary shall be
     * used The term and the term identifier shall be used.
     */
    public open var scoring: CodeableConcept.Builder? = null

    public open fun build(): ProdCharacteristic =
      ProdCharacteristic(
        id = id,
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        height = height?.build(),
        width = width?.build(),
        depth = depth?.build(),
        weight = weight?.build(),
        nominalVolume = nominalVolume?.build(),
        externalDiameter = externalDiameter?.build(),
        shape = shape?.build(),
        color = color.map { it.build() },
        imprint = imprint.map { it.build() },
        image = image.map { it.build() },
        scoring = scoring?.build(),
      )
  }
}

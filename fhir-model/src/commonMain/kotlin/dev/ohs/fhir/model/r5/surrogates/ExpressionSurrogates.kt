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

import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Expression
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ExpressionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var expression: KotlinString? = null,
  public var _expression: Element? = null,
  public var reference: KotlinString? = null,
  public var _reference: Element? = null,
) {
  public fun toModel(): Expression =
    Expression(
      id = this@ExpressionSurrogate.id,
      extension = this@ExpressionSurrogate.extension ?: listOf(),
      description =
        R5String.of(this@ExpressionSurrogate.description, this@ExpressionSurrogate._description),
      name = Code.of(this@ExpressionSurrogate.name, this@ExpressionSurrogate._name),
      language =
        this@ExpressionSurrogate.language?.let {
          Enumeration.of(
            Expression.ExpressionLanguage.fromCode(it),
            this@ExpressionSurrogate._language,
          )
        },
      expression =
        R5String.of(this@ExpressionSurrogate.expression, this@ExpressionSurrogate._expression),
      reference = Uri.of(this@ExpressionSurrogate.reference, this@ExpressionSurrogate._reference),
    )

  public companion object {
    public fun fromModel(model: Expression): ExpressionSurrogate =
      with(model) {
        ExpressionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          language = this@with.language?.value?.getCode(),
          _language = this@with.language?.toElement(),
          expression = this@with.expression?.value,
          _expression = this@with.expression?.toElement(),
          reference = this@with.reference?.value,
          _reference = this@with.reference?.toElement(),
        )
      }
  }
}

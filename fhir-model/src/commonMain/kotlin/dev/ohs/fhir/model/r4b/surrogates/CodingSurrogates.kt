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

import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.Coding
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Extension
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
internal data class CodingSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var system: KotlinString? = null,
  public var _system: Element? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var code: KotlinString? = null,
  public var _code: Element? = null,
  public var display: KotlinString? = null,
  public var _display: Element? = null,
  public var userSelected: KotlinBoolean? = null,
  public var _userSelected: Element? = null,
) {
  public fun toModel(): Coding =
    Coding(
      id = this@CodingSurrogate.id,
      extension = this@CodingSurrogate.extension ?: listOf(),
      system = Uri.of(this@CodingSurrogate.system, this@CodingSurrogate._system),
      version = R4bString.of(this@CodingSurrogate.version, this@CodingSurrogate._version),
      code = Code.of(this@CodingSurrogate.code, this@CodingSurrogate._code),
      display = R4bString.of(this@CodingSurrogate.display, this@CodingSurrogate._display),
      userSelected =
        R4bBoolean.of(this@CodingSurrogate.userSelected, this@CodingSurrogate._userSelected),
    )

  public companion object {
    public fun fromModel(model: Coding): CodingSurrogate =
      with(model) {
        CodingSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          system = this@with.system?.value,
          _system = this@with.system?.toElement(),
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          code = this@with.code?.value,
          _code = this@with.code?.toElement(),
          display = this@with.display?.value,
          _display = this@with.display?.toElement(),
          userSelected = this@with.userSelected?.value,
          _userSelected = this@with.userSelected?.toElement(),
        )
      }
  }
}

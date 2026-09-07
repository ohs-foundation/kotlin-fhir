/*
 * Copyright 2026 Open Health Stack Foundation
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

package dev.ohs.fhir.model.r4

import kotlin.Enum
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.enums.enumEntries

/**
 * A FHIR ExtensibleEnumeration type bound to an extensible or preferred set of codes.
 *
 * It represents either a predefined enum constant ([Predefined]) or a legal custom code string
 * ([Custom]).
 */
public sealed interface ExtensibleEnumeration<out T : FhirEnum> {
  public val id: String?

  public val extension: List<Extension>

  public val code: String

  public fun toElement(): Element? {
    if (id != null || extension.isNotEmpty()) {
      return Element(id, extension)
    }
    return null
  }

  public data class Predefined<out T : FhirEnum>(
    public val `value`: T,
    override val id: String? = null,
    override val extension: List<Extension> = listOf(),
  ) : ExtensibleEnumeration<T> {
    override val code: String
      get() = value.code

    override fun toString(): String = value.code
  }

  public data class Custom(
    override val code: String,
    override val id: String? = null,
    override val extension: List<Extension> = listOf(),
  ) : ExtensibleEnumeration<Nothing> {
    override fun toString(): String = code
  }

  public companion object {
    public inline fun <reified T> of(code: String?, element: Element?): ExtensibleEnumeration<T>?
      where T : Enum<T>, T : FhirEnum {
      val parsed = code?.let { c -> enumEntries<T>().firstOrNull { it.code == c } }
      return when {
        parsed != null -> Predefined(parsed, element?.id, element?.extension ?: listOf())
        code != null -> Custom(code, element?.id, element?.extension ?: listOf())
        element?.id != null || element?.extension?.isNotEmpty() == true ->
          Custom("", element.id, element.extension)
        else -> null
      }
    }

    public fun <T : FhirEnum> of(`value`: T): ExtensibleEnumeration<T> = Predefined(value)

    public fun of(code: String): ExtensibleEnumeration<Nothing> = Custom(code)
  }
}

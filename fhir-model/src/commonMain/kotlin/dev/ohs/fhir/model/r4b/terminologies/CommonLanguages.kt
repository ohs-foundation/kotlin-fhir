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

package com.google.fhir.model.r4b.terminologies

import kotlin.String

/** This value set includes common codes from BCP-47 (http://tools.ietf.org/html/bcp47) */
public enum class CommonLanguages(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Ar("ar", "urn:ietf:bcp:47", "Arabisk"),
  Bn("bn", "urn:ietf:bcp:47", "Bengali"),
  Cs("cs", "urn:ietf:bcp:47", "Czech"),
  Da("da", "urn:ietf:bcp:47", "Danish"),
  De("de", "urn:ietf:bcp:47", "German"),
  De_At("de-AT", "urn:ietf:bcp:47", "German (Austria)"),
  De_Ch("de-CH", "urn:ietf:bcp:47", "German (Switzerland)"),
  De_De("de-DE", "urn:ietf:bcp:47", "German (Germany)"),
  El("el", "urn:ietf:bcp:47", "Greek"),
  En("en", "urn:ietf:bcp:47", "English"),
  En_Au("en-AU", "urn:ietf:bcp:47", "English (Australia)"),
  En_Ca("en-CA", "urn:ietf:bcp:47", "English (Canada)"),
  En_Gb("en-GB", "urn:ietf:bcp:47", "English (Great Britain)"),
  En_In("en-IN", "urn:ietf:bcp:47", "English (India)"),
  En_Nz("en-NZ", "urn:ietf:bcp:47", "English (New Zeland)"),
  En_Sg("en-SG", "urn:ietf:bcp:47", "English (Singapore)"),
  En_Us("en-US", "urn:ietf:bcp:47", "English (United States)"),
  Es("es", "urn:ietf:bcp:47", "Spanish"),
  Es_Ar("es-AR", "urn:ietf:bcp:47", "Spanish (Argentina)"),
  Es_Es("es-ES", "urn:ietf:bcp:47", "Spanish (Spain)"),
  Es_Uy("es-UY", "urn:ietf:bcp:47", "Spanish (Uruguay)"),
  Fi("fi", "urn:ietf:bcp:47", "Finnish"),
  Fr("fr", "urn:ietf:bcp:47", "French"),
  Fr_Be("fr-BE", "urn:ietf:bcp:47", "French (Belgium)"),
  Fr_Ch("fr-CH", "urn:ietf:bcp:47", "French (Switzerland)"),
  Fr_Fr("fr-FR", "urn:ietf:bcp:47", "French (France)"),
  Fy("fy", "urn:ietf:bcp:47", "Frysian"),
  Fy_Nl("fy-NL", "urn:ietf:bcp:47", "Frysian (Netherlands)"),
  Hi("hi", "urn:ietf:bcp:47", "Hindi"),
  Hr("hr", "urn:ietf:bcp:47", "Croatian"),
  It("it", "urn:ietf:bcp:47", "Italian"),
  It_Ch("it-CH", "urn:ietf:bcp:47", "Italian (Switzerland)"),
  It_It("it-IT", "urn:ietf:bcp:47", "Italian (Italy)"),
  Ja("ja", "urn:ietf:bcp:47", "Japanese"),
  Ko("ko", "urn:ietf:bcp:47", "Korean"),
  Nl("nl", "urn:ietf:bcp:47", "Dutch"),
  Nl_Be("nl-BE", "urn:ietf:bcp:47", "Dutch (Belgium)"),
  Nl_Nl("nl-NL", "urn:ietf:bcp:47", "Dutch (Netherlands)"),
  No("no", "urn:ietf:bcp:47", "Norwegian"),
  No_No("no-NO", "urn:ietf:bcp:47", "Norwegian (Norway)"),
  Pa("pa", "urn:ietf:bcp:47", "Punjabi"),
  Pl("pl", "urn:ietf:bcp:47", "Polskie"),
  Pt("pt", "urn:ietf:bcp:47", "Portuguese"),
  Pt_Br("pt-BR", "urn:ietf:bcp:47", "Portuguese (Brazil)"),
  Ru("ru", "urn:ietf:bcp:47", "Russian"),
  Ru_Ru("ru-RU", "urn:ietf:bcp:47", "Russian (Russia)"),
  Sr("sr", "urn:ietf:bcp:47", "Serbian"),
  Sr_Rs("sr-RS", "urn:ietf:bcp:47", "Serbian (Serbia)"),
  Sv("sv", "urn:ietf:bcp:47", "Swedish"),
  Sv_Se("sv-SE", "urn:ietf:bcp:47", "Swedish (Sweden)"),
  Te("te", "urn:ietf:bcp:47", "Telegu"),
  Zh("zh", "urn:ietf:bcp:47", "Chinese"),
  Zh_Cn("zh-CN", "urn:ietf:bcp:47", "Chinese (China)"),
  Zh_Hk("zh-HK", "urn:ietf:bcp:47", "Chinese (Hong Kong)"),
  Zh_Sg("zh-SG", "urn:ietf:bcp:47", "Chinese (Singapore)"),
  Zh_Tw("zh-TW", "urn:ietf:bcp:47", "Chinese (Taiwan)");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): CommonLanguages =
      when (code) {
        "ar" -> Ar
        "bn" -> Bn
        "cs" -> Cs
        "da" -> Da
        "de" -> De
        "de-AT" -> De_At
        "de-CH" -> De_Ch
        "de-DE" -> De_De
        "el" -> El
        "en" -> En
        "en-AU" -> En_Au
        "en-CA" -> En_Ca
        "en-GB" -> En_Gb
        "en-IN" -> En_In
        "en-NZ" -> En_Nz
        "en-SG" -> En_Sg
        "en-US" -> En_Us
        "es" -> Es
        "es-AR" -> Es_Ar
        "es-ES" -> Es_Es
        "es-UY" -> Es_Uy
        "fi" -> Fi
        "fr" -> Fr
        "fr-BE" -> Fr_Be
        "fr-CH" -> Fr_Ch
        "fr-FR" -> Fr_Fr
        "fy" -> Fy
        "fy-NL" -> Fy_Nl
        "hi" -> Hi
        "hr" -> Hr
        "it" -> It
        "it-CH" -> It_Ch
        "it-IT" -> It_It
        "ja" -> Ja
        "ko" -> Ko
        "nl" -> Nl
        "nl-BE" -> Nl_Be
        "nl-NL" -> Nl_Nl
        "no" -> No
        "no-NO" -> No_No
        "pa" -> Pa
        "pl" -> Pl
        "pt" -> Pt
        "pt-BR" -> Pt_Br
        "ru" -> Ru
        "ru-RU" -> Ru_Ru
        "sr" -> Sr
        "sr-RS" -> Sr_Rs
        "sv" -> Sv
        "sv-SE" -> Sv_Se
        "te" -> Te
        "zh" -> Zh
        "zh-CN" -> Zh_Cn
        "zh-HK" -> Zh_Hk
        "zh-SG" -> Zh_Sg
        "zh-TW" -> Zh_Tw
        else -> throw IllegalArgumentException("Unknown code $code for enum CommonLanguages")
      }
  }
}

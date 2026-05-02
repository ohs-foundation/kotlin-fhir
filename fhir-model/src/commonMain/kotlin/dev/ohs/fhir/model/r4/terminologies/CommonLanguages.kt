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

package com.google.fhir.model.r4.terminologies

import kotlin.String

/** This value set includes common codes from BCP-47 (http://tools.ietf.org/html/bcp47) */
public enum class CommonLanguages(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Ar("ar", "urn:ietf:bcp:47", "Arabisch"),
  Bn("bn", "urn:ietf:bcp:47", "Bengalsk"),
  Cs("cs", "urn:ietf:bcp:47", "Tjekkisk"),
  Da("da", "urn:ietf:bcp:47", "Dansk"),
  De("de", "urn:ietf:bcp:47", "Tysk"),
  De_At("de-AT", "urn:ietf:bcp:47", "Tysk (Østrig"),
  De_Ch("de-CH", "urn:ietf:bcp:47", "Tysk (Schweiz)"),
  De_De("de-DE", "urn:ietf:bcp:47", "Tysk (Tyskland)"),
  El("el", "urn:ietf:bcp:47", "Græsk"),
  En("en", "urn:ietf:bcp:47", "Engelsk"),
  En_Au("en-AU", "urn:ietf:bcp:47", "Engelsk (Australien)"),
  En_Ca("en-CA", "urn:ietf:bcp:47", "Engelsk (Canada)"),
  En_Gb("en-GB", "urn:ietf:bcp:47", "Engelsk (Storbritannien)"),
  En_In("en-IN", "urn:ietf:bcp:47", "Engelsk (Indien)"),
  En_Nz("en-NZ", "urn:ietf:bcp:47", "Engelsk (New Zeeland)"),
  En_Sg("en-SG", "urn:ietf:bcp:47", "Engelsk (Singapore)"),
  En_Us("en-US", "urn:ietf:bcp:47", "Engelsk (Amerikansk)"),
  Es("es", "urn:ietf:bcp:47", "Spansk"),
  Es_Ar("es-AR", "urn:ietf:bcp:47", "Spansk (Argentina)"),
  Es_Es("es-ES", "urn:ietf:bcp:47", "Spansk (Spanien)"),
  Es_Uy("es-UY", "urn:ietf:bcp:47", "Spansk (Uruguay)"),
  Fi("fi", "urn:ietf:bcp:47", "Finsk"),
  Fr("fr", "urn:ietf:bcp:47", "Fransk"),
  Fr_Be("fr-BE", "urn:ietf:bcp:47", "Finsk (Belgien)"),
  Fr_Ch("fr-CH", "urn:ietf:bcp:47", "Fransk (Schweiz)"),
  Fr_Fr("fr-FR", "urn:ietf:bcp:47", "Fransk (Frankrig)"),
  Fy("fy", "urn:ietf:bcp:47", "Frisisk"),
  Fy_Nl("fy-NL", "urn:ietf:bcp:47", "Frisisk (Holland)"),
  Hi("hi", "urn:ietf:bcp:47", "Hindi"),
  Hr("hr", "urn:ietf:bcp:47", "Kroatisk"),
  It("it", "urn:ietf:bcp:47", "Italiensk"),
  It_Ch("it-CH", "urn:ietf:bcp:47", "Italiensk (Schweiz)"),
  It_It("it-IT", "urn:ietf:bcp:47", "Italiensk (Italien)"),
  Ja("ja", "urn:ietf:bcp:47", "Japansk"),
  Ko("ko", "urn:ietf:bcp:47", "Koreansk"),
  Nl("nl", "urn:ietf:bcp:47", "Hollandsk"),
  Nl_Be("nl-BE", "urn:ietf:bcp:47", "Hollandsk (Belgien)"),
  Nl_Nl("nl-NL", "urn:ietf:bcp:47", "Hollandsk (Holland)"),
  No("no", "urn:ietf:bcp:47", "Norsk"),
  No_No("no-NO", "urn:ietf:bcp:47", "Norsk (Norge)"),
  Pa("pa", "urn:ietf:bcp:47", "Punjabi"),
  Pl("pl", "urn:ietf:bcp:47", "Polskie"),
  Pt("pt", "urn:ietf:bcp:47", "Portugisisk"),
  Pt_Br("pt-BR", "urn:ietf:bcp:47", "Portugisisk (Brasilien)"),
  Ru("ru", "urn:ietf:bcp:47", "Russisk"),
  Ru_Ru("ru-RU", "urn:ietf:bcp:47", "Russisk (Rusland)"),
  Sr("sr", "urn:ietf:bcp:47", "Serbisk"),
  Sr_Rs("sr-RS", "urn:ietf:bcp:47", "Serbisk (Serbien)"),
  Sv("sv", "urn:ietf:bcp:47", "Svensk"),
  Sv_Se("sv-SE", "urn:ietf:bcp:47", "Svensk (Sverige)"),
  Te("te", "urn:ietf:bcp:47", "Telugu"),
  Zh("zh", "urn:ietf:bcp:47", "Kinesisk"),
  Zh_Cn("zh-CN", "urn:ietf:bcp:47", "Kinesisk (Kina)"),
  Zh_Hk("zh-HK", "urn:ietf:bcp:47", "Kinesisk (Hong Kong)"),
  Zh_Sg("zh-SG", "urn:ietf:bcp:47", "Kinesisk (Singapore)"),
  Zh_Tw("zh-TW", "urn:ietf:bcp:47", "Kinesisk (Taiwan)");

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

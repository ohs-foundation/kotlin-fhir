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

/** Currency codes from ISO 4217 (see https://www.iso.org/iso-4217-currency-codes.html) */
public enum class Currencies(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Aed("AED", "urn:iso:std:iso:4217", "United Arab Emirates dirham"),
  Afn("AFN", "urn:iso:std:iso:4217", "Afghan afghani"),
  All("ALL", "urn:iso:std:iso:4217", "Albanian lek"),
  Amd("AMD", "urn:iso:std:iso:4217", "Armenian dram"),
  Ang("ANG", "urn:iso:std:iso:4217", "Netherlands Antillean guilder"),
  Aoa("AOA", "urn:iso:std:iso:4217", "Angolan kwanza"),
  Ars("ARS", "urn:iso:std:iso:4217", "Argentine peso"),
  Aud("AUD", "urn:iso:std:iso:4217", "Australian dollar"),
  Awg("AWG", "urn:iso:std:iso:4217", "Aruban florin"),
  Azn("AZN", "urn:iso:std:iso:4217", "Azerbaijani manat"),
  Bam("BAM", "urn:iso:std:iso:4217", "Bosnia and Herzegovina convertible mark"),
  Bbd("BBD", "urn:iso:std:iso:4217", "Barbados dollar"),
  Bdt("BDT", "urn:iso:std:iso:4217", "Bangladeshi taka"),
  Bgn("BGN", "urn:iso:std:iso:4217", "Bulgarian lev"),
  Bhd("BHD", "urn:iso:std:iso:4217", "Bahraini dinar"),
  Bif("BIF", "urn:iso:std:iso:4217", "Burundian franc"),
  Bmd("BMD", "urn:iso:std:iso:4217", "Bermudian dollar"),
  Bnd("BND", "urn:iso:std:iso:4217", "Brunei dollar"),
  Bob("BOB", "urn:iso:std:iso:4217", "Boliviano"),
  Bov("BOV", "urn:iso:std:iso:4217", "Bolivian Mvdol (funds code)"),
  Brl("BRL", "urn:iso:std:iso:4217", "Brazilian real"),
  Bsd("BSD", "urn:iso:std:iso:4217", "Bahamian dollar"),
  Btn("BTN", "urn:iso:std:iso:4217", "Bhutanese ngultrum"),
  Bwp("BWP", "urn:iso:std:iso:4217", "Botswana pula"),
  Byn("BYN", "urn:iso:std:iso:4217", "Belarusian ruble"),
  Bzd("BZD", "urn:iso:std:iso:4217", "Belize dollar"),
  Cad("CAD", "urn:iso:std:iso:4217", "Canadian dollar"),
  Cdf("CDF", "urn:iso:std:iso:4217", "Congolese franc"),
  Che("CHE", "urn:iso:std:iso:4217", "WIR Euro (complementary currency)"),
  Chf("CHF", "urn:iso:std:iso:4217", "Swiss franc"),
  Chw("CHW", "urn:iso:std:iso:4217", "WIR Franc (complementary currency)"),
  Clf("CLF", "urn:iso:std:iso:4217", "Unidad de Fomento (funds code)"),
  Clp("CLP", "urn:iso:std:iso:4217", "Chilean peso"),
  Cny("CNY", "urn:iso:std:iso:4217", "Renminbi (Chinese) yuan[8]"),
  Cop("COP", "urn:iso:std:iso:4217", "Colombian peso"),
  Cou("COU", "urn:iso:std:iso:4217", "Unidad de Valor Real (UVR) (funds code)[9]"),
  Crc("CRC", "urn:iso:std:iso:4217", "Costa Rican colon"),
  Cuc("CUC", "urn:iso:std:iso:4217", "Cuban convertible peso"),
  Cup("CUP", "urn:iso:std:iso:4217", "Cuban peso"),
  Cve("CVE", "urn:iso:std:iso:4217", "Cape Verde escudo"),
  Czk("CZK", "urn:iso:std:iso:4217", "Czech koruna"),
  Djf("DJF", "urn:iso:std:iso:4217", "Djiboutian franc"),
  Dkk("DKK", "urn:iso:std:iso:4217", "Danish krone"),
  Dop("DOP", "urn:iso:std:iso:4217", "Dominican peso"),
  Dzd("DZD", "urn:iso:std:iso:4217", "Algerian dinar"),
  Egp("EGP", "urn:iso:std:iso:4217", "Egyptian pound"),
  Ern("ERN", "urn:iso:std:iso:4217", "Eritrean nakfa"),
  Etb("ETB", "urn:iso:std:iso:4217", "Ethiopian birr"),
  Eur("EUR", "urn:iso:std:iso:4217", "Euro"),
  Fjd("FJD", "urn:iso:std:iso:4217", "Fiji dollar"),
  Fkp("FKP", "urn:iso:std:iso:4217", "Falkland Islands pound"),
  Gbp("GBP", "urn:iso:std:iso:4217", "Pound sterling"),
  Gel("GEL", "urn:iso:std:iso:4217", "Georgian lari"),
  Ggp("GGP", "urn:iso:std:iso:4217", "Guernsey Pound"),
  Ghs("GHS", "urn:iso:std:iso:4217", "Ghanaian cedi"),
  Gip("GIP", "urn:iso:std:iso:4217", "Gibraltar pound"),
  Gmd("GMD", "urn:iso:std:iso:4217", "Gambian dalasi"),
  Gnf("GNF", "urn:iso:std:iso:4217", "Guinean franc"),
  Gtq("GTQ", "urn:iso:std:iso:4217", "Guatemalan quetzal"),
  Gyd("GYD", "urn:iso:std:iso:4217", "Guyanese dollar"),
  Hkd("HKD", "urn:iso:std:iso:4217", "Hong Kong dollar"),
  Hnl("HNL", "urn:iso:std:iso:4217", "Honduran lempira"),
  Hrk("HRK", "urn:iso:std:iso:4217", "Croatian kuna"),
  Htg("HTG", "urn:iso:std:iso:4217", "Haitian gourde"),
  Huf("HUF", "urn:iso:std:iso:4217", "Hungarian forint"),
  Idr("IDR", "urn:iso:std:iso:4217", "Indonesian rupiah"),
  Ils("ILS", "urn:iso:std:iso:4217", "Israeli new shekel"),
  Imp("IMP", "urn:iso:std:iso:4217", "Isle of Man Pound"),
  Inr("INR", "urn:iso:std:iso:4217", "Indian rupee"),
  Iqd("IQD", "urn:iso:std:iso:4217", "Iraqi dinar"),
  Irr("IRR", "urn:iso:std:iso:4217", "Iranian rial"),
  Isk("ISK", "urn:iso:std:iso:4217", "Icelandic króna"),
  Jep("JEP", "urn:iso:std:iso:4217", "Jersey Pound"),
  Jmd("JMD", "urn:iso:std:iso:4217", "Jamaican dollar"),
  Jod("JOD", "urn:iso:std:iso:4217", "Jordanian dinar"),
  Jpy("JPY", "urn:iso:std:iso:4217", "Japanese yen"),
  Kes("KES", "urn:iso:std:iso:4217", "Kenyan shilling"),
  Kgs("KGS", "urn:iso:std:iso:4217", "Kyrgyzstani som"),
  Khr("KHR", "urn:iso:std:iso:4217", "Cambodian riel"),
  Kmf("KMF", "urn:iso:std:iso:4217", "Comoro franc"),
  Kpw("KPW", "urn:iso:std:iso:4217", "North Korean won"),
  Krw("KRW", "urn:iso:std:iso:4217", "South Korean won"),
  Kwd("KWD", "urn:iso:std:iso:4217", "Kuwaiti dinar"),
  Kyd("KYD", "urn:iso:std:iso:4217", "Cayman Islands dollar"),
  Kzt("KZT", "urn:iso:std:iso:4217", "Kazakhstani tenge"),
  Lak("LAK", "urn:iso:std:iso:4217", "Lao kip"),
  Lbp("LBP", "urn:iso:std:iso:4217", "Lebanese pound"),
  Lkr("LKR", "urn:iso:std:iso:4217", "Sri Lankan rupee"),
  Lrd("LRD", "urn:iso:std:iso:4217", "Liberian dollar"),
  Lsl("LSL", "urn:iso:std:iso:4217", "Lesotho loti"),
  Lyd("LYD", "urn:iso:std:iso:4217", "Libyan dinar"),
  Mad("MAD", "urn:iso:std:iso:4217", "Moroccan dirham"),
  Mdl("MDL", "urn:iso:std:iso:4217", "Moldovan leu"),
  Mga("MGA", "urn:iso:std:iso:4217", "Malagasy ariary"),
  Mkd("MKD", "urn:iso:std:iso:4217", "Macedonian denar"),
  Mmk("MMK", "urn:iso:std:iso:4217", "Myanmar kyat"),
  Mnt("MNT", "urn:iso:std:iso:4217", "Mongolian tögrög"),
  Mop("MOP", "urn:iso:std:iso:4217", "Macanese pataca"),
  Mru("MRU", "urn:iso:std:iso:4217", "Mauritanian ouguiya"),
  Mur("MUR", "urn:iso:std:iso:4217", "Mauritian rupee"),
  Mvr("MVR", "urn:iso:std:iso:4217", "Maldivian rufiyaa"),
  Mwk("MWK", "urn:iso:std:iso:4217", "Malawian kwacha"),
  Mxn("MXN", "urn:iso:std:iso:4217", "Mexican peso"),
  Mxv("MXV", "urn:iso:std:iso:4217", "Mexican Unidad de Inversion (UDI) (funds code)"),
  Myr("MYR", "urn:iso:std:iso:4217", "Malaysian ringgit"),
  Mzn("MZN", "urn:iso:std:iso:4217", "Mozambican metical"),
  Nad("NAD", "urn:iso:std:iso:4217", "Namibian dollar"),
  Ngn("NGN", "urn:iso:std:iso:4217", "Nigerian naira"),
  Nio("NIO", "urn:iso:std:iso:4217", "Nicaraguan córdoba"),
  Nok("NOK", "urn:iso:std:iso:4217", "Norwegian krone"),
  Npr("NPR", "urn:iso:std:iso:4217", "Nepalese rupee"),
  Nzd("NZD", "urn:iso:std:iso:4217", "New Zealand dollar"),
  Omr("OMR", "urn:iso:std:iso:4217", "Omani rial"),
  Pab("PAB", "urn:iso:std:iso:4217", "Panamanian balboa"),
  Pen("PEN", "urn:iso:std:iso:4217", "Peruvian Sol"),
  Pgk("PGK", "urn:iso:std:iso:4217", "Papua New Guinean kina"),
  Php("PHP", "urn:iso:std:iso:4217", "Philippine piso[13]"),
  Pkr("PKR", "urn:iso:std:iso:4217", "Pakistani rupee"),
  Pln("PLN", "urn:iso:std:iso:4217", "Polish złoty"),
  Pyg("PYG", "urn:iso:std:iso:4217", "Paraguayan guaraní"),
  Qar("QAR", "urn:iso:std:iso:4217", "Qatari riyal"),
  Ron("RON", "urn:iso:std:iso:4217", "Romanian leu"),
  Rsd("RSD", "urn:iso:std:iso:4217", "Serbian dinar"),
  Rub("RUB", "urn:iso:std:iso:4217", "Russian ruble"),
  Rwf("RWF", "urn:iso:std:iso:4217", "Rwandan franc"),
  Sar("SAR", "urn:iso:std:iso:4217", "Saudi riyal"),
  Sbd("SBD", "urn:iso:std:iso:4217", "Solomon Islands dollar"),
  Scr("SCR", "urn:iso:std:iso:4217", "Seychelles rupee"),
  Sdg("SDG", "urn:iso:std:iso:4217", "Sudanese pound"),
  Sek("SEK", "urn:iso:std:iso:4217", "Swedish krona/kronor"),
  Sgd("SGD", "urn:iso:std:iso:4217", "Singapore dollar"),
  Shp("SHP", "urn:iso:std:iso:4217", "Saint Helena pound"),
  Sll("SLL", "urn:iso:std:iso:4217", "Sierra Leonean leone"),
  Sos("SOS", "urn:iso:std:iso:4217", "Somali shilling"),
  Srd("SRD", "urn:iso:std:iso:4217", "Surinamese dollar"),
  Ssp("SSP", "urn:iso:std:iso:4217", "South Sudanese pound"),
  Stn("STN", "urn:iso:std:iso:4217", "São Tomé and Príncipe dobra"),
  Svc("SVC", "urn:iso:std:iso:4217", "Salvadoran colón"),
  Syp("SYP", "urn:iso:std:iso:4217", "Syrian pound"),
  Szl("SZL", "urn:iso:std:iso:4217", "Swazi lilangeni"),
  Thb("THB", "urn:iso:std:iso:4217", "Thai baht"),
  Tjs("TJS", "urn:iso:std:iso:4217", "Tajikistani somoni"),
  Tmt("TMT", "urn:iso:std:iso:4217", "Turkmenistan manat"),
  Tnd("TND", "urn:iso:std:iso:4217", "Tunisian dinar"),
  Top("TOP", "urn:iso:std:iso:4217", "Tongan paʻanga"),
  Try("TRY", "urn:iso:std:iso:4217", "Turkish lira"),
  Ttd("TTD", "urn:iso:std:iso:4217", "Trinidad and Tobago dollar"),
  Tvd("TVD", "urn:iso:std:iso:4217", "Tuvalu Dollar"),
  Twd("TWD", "urn:iso:std:iso:4217", "New Taiwan dollar"),
  Tzs("TZS", "urn:iso:std:iso:4217", "Tanzanian shilling"),
  Uah("UAH", "urn:iso:std:iso:4217", "Ukrainian hryvnia"),
  Ugx("UGX", "urn:iso:std:iso:4217", "Ugandan shilling"),
  Usd("USD", "urn:iso:std:iso:4217", "United States dollar"),
  Usn("USN", "urn:iso:std:iso:4217", "United States dollar (next day) (funds code)"),
  Uyi("UYI", "urn:iso:std:iso:4217", "Uruguay Peso en Unidades Indexadas (URUIURUI) (funds code)"),
  Uyu("UYU", "urn:iso:std:iso:4217", "Uruguayan peso"),
  Uzs("UZS", "urn:iso:std:iso:4217", "Uzbekistan som"),
  Vef("VEF", "urn:iso:std:iso:4217", "Venezuelan bolívar"),
  Vnd("VND", "urn:iso:std:iso:4217", "Vietnamese đồng"),
  Vuv("VUV", "urn:iso:std:iso:4217", "Vanuatu vatu"),
  Wst("WST", "urn:iso:std:iso:4217", "Samoan tala"),
  Xaf("XAF", "urn:iso:std:iso:4217", "CFA franc BEAC"),
  Xag("XAG", "urn:iso:std:iso:4217", "Silver (one troy ounce)"),
  Xau("XAU", "urn:iso:std:iso:4217", "Gold (one troy ounce)"),
  Xba("XBA", "urn:iso:std:iso:4217", "European Composite Unit (EURCO) (bond market unit)"),
  Xbb("XBB", "urn:iso:std:iso:4217", "European Monetary Unit (E.M.U.-6) (bond market unit)"),
  Xbc("XBC", "urn:iso:std:iso:4217", "European Unit of Account 9 (E.U.A.-9) (bond market unit)"),
  Xbd("XBD", "urn:iso:std:iso:4217", "European Unit of Account 17 (E.U.A.-17) (bond market unit)"),
  Xcd("XCD", "urn:iso:std:iso:4217", "East Caribbean dollar"),
  Xdr("XDR", "urn:iso:std:iso:4217", "Special drawing rights"),
  Xof("XOF", "urn:iso:std:iso:4217", "CFA franc BCEAO"),
  Xpd("XPD", "urn:iso:std:iso:4217", "Palladium (one troy ounce)"),
  Xpf("XPF", "urn:iso:std:iso:4217", "CFP franc (franc Pacifique)"),
  Xpt("XPT", "urn:iso:std:iso:4217", "Platinum (one troy ounce)"),
  Xsu("XSU", "urn:iso:std:iso:4217", "SUCRE"),
  Xts("XTS", "urn:iso:std:iso:4217", "Code reserved for testing purposes"),
  Xua("XUA", "urn:iso:std:iso:4217", "ADB Unit of Account"),
  Xxx("XXX", "urn:iso:std:iso:4217", "No currency"),
  Yer("YER", "urn:iso:std:iso:4217", "Yemeni rial"),
  Zar("ZAR", "urn:iso:std:iso:4217", "South African rand"),
  Zmw("ZMW", "urn:iso:std:iso:4217", "Zambian kwacha"),
  Zwl("ZWL", "urn:iso:std:iso:4217", "Zimbabwean dollar A/10");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): Currencies =
      when (code) {
        "AED" -> Aed
        "AFN" -> Afn
        "ALL" -> All
        "AMD" -> Amd
        "ANG" -> Ang
        "AOA" -> Aoa
        "ARS" -> Ars
        "AUD" -> Aud
        "AWG" -> Awg
        "AZN" -> Azn
        "BAM" -> Bam
        "BBD" -> Bbd
        "BDT" -> Bdt
        "BGN" -> Bgn
        "BHD" -> Bhd
        "BIF" -> Bif
        "BMD" -> Bmd
        "BND" -> Bnd
        "BOB" -> Bob
        "BOV" -> Bov
        "BRL" -> Brl
        "BSD" -> Bsd
        "BTN" -> Btn
        "BWP" -> Bwp
        "BYN" -> Byn
        "BZD" -> Bzd
        "CAD" -> Cad
        "CDF" -> Cdf
        "CHE" -> Che
        "CHF" -> Chf
        "CHW" -> Chw
        "CLF" -> Clf
        "CLP" -> Clp
        "CNY" -> Cny
        "COP" -> Cop
        "COU" -> Cou
        "CRC" -> Crc
        "CUC" -> Cuc
        "CUP" -> Cup
        "CVE" -> Cve
        "CZK" -> Czk
        "DJF" -> Djf
        "DKK" -> Dkk
        "DOP" -> Dop
        "DZD" -> Dzd
        "EGP" -> Egp
        "ERN" -> Ern
        "ETB" -> Etb
        "EUR" -> Eur
        "FJD" -> Fjd
        "FKP" -> Fkp
        "GBP" -> Gbp
        "GEL" -> Gel
        "GGP" -> Ggp
        "GHS" -> Ghs
        "GIP" -> Gip
        "GMD" -> Gmd
        "GNF" -> Gnf
        "GTQ" -> Gtq
        "GYD" -> Gyd
        "HKD" -> Hkd
        "HNL" -> Hnl
        "HRK" -> Hrk
        "HTG" -> Htg
        "HUF" -> Huf
        "IDR" -> Idr
        "ILS" -> Ils
        "IMP" -> Imp
        "INR" -> Inr
        "IQD" -> Iqd
        "IRR" -> Irr
        "ISK" -> Isk
        "JEP" -> Jep
        "JMD" -> Jmd
        "JOD" -> Jod
        "JPY" -> Jpy
        "KES" -> Kes
        "KGS" -> Kgs
        "KHR" -> Khr
        "KMF" -> Kmf
        "KPW" -> Kpw
        "KRW" -> Krw
        "KWD" -> Kwd
        "KYD" -> Kyd
        "KZT" -> Kzt
        "LAK" -> Lak
        "LBP" -> Lbp
        "LKR" -> Lkr
        "LRD" -> Lrd
        "LSL" -> Lsl
        "LYD" -> Lyd
        "MAD" -> Mad
        "MDL" -> Mdl
        "MGA" -> Mga
        "MKD" -> Mkd
        "MMK" -> Mmk
        "MNT" -> Mnt
        "MOP" -> Mop
        "MRU" -> Mru
        "MUR" -> Mur
        "MVR" -> Mvr
        "MWK" -> Mwk
        "MXN" -> Mxn
        "MXV" -> Mxv
        "MYR" -> Myr
        "MZN" -> Mzn
        "NAD" -> Nad
        "NGN" -> Ngn
        "NIO" -> Nio
        "NOK" -> Nok
        "NPR" -> Npr
        "NZD" -> Nzd
        "OMR" -> Omr
        "PAB" -> Pab
        "PEN" -> Pen
        "PGK" -> Pgk
        "PHP" -> Php
        "PKR" -> Pkr
        "PLN" -> Pln
        "PYG" -> Pyg
        "QAR" -> Qar
        "RON" -> Ron
        "RSD" -> Rsd
        "RUB" -> Rub
        "RWF" -> Rwf
        "SAR" -> Sar
        "SBD" -> Sbd
        "SCR" -> Scr
        "SDG" -> Sdg
        "SEK" -> Sek
        "SGD" -> Sgd
        "SHP" -> Shp
        "SLL" -> Sll
        "SOS" -> Sos
        "SRD" -> Srd
        "SSP" -> Ssp
        "STN" -> Stn
        "SVC" -> Svc
        "SYP" -> Syp
        "SZL" -> Szl
        "THB" -> Thb
        "TJS" -> Tjs
        "TMT" -> Tmt
        "TND" -> Tnd
        "TOP" -> Top
        "TRY" -> Try
        "TTD" -> Ttd
        "TVD" -> Tvd
        "TWD" -> Twd
        "TZS" -> Tzs
        "UAH" -> Uah
        "UGX" -> Ugx
        "USD" -> Usd
        "USN" -> Usn
        "UYI" -> Uyi
        "UYU" -> Uyu
        "UZS" -> Uzs
        "VEF" -> Vef
        "VND" -> Vnd
        "VUV" -> Vuv
        "WST" -> Wst
        "XAF" -> Xaf
        "XAG" -> Xag
        "XAU" -> Xau
        "XBA" -> Xba
        "XBB" -> Xbb
        "XBC" -> Xbc
        "XBD" -> Xbd
        "XCD" -> Xcd
        "XDR" -> Xdr
        "XOF" -> Xof
        "XPD" -> Xpd
        "XPF" -> Xpf
        "XPT" -> Xpt
        "XSU" -> Xsu
        "XTS" -> Xts
        "XUA" -> Xua
        "XXX" -> Xxx
        "YER" -> Yer
        "ZAR" -> Zar
        "ZMW" -> Zmw
        "ZWL" -> Zwl
        else -> throw IllegalArgumentException("Unknown code $code for enum Currencies")
      }
  }
}

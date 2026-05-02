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

package com.google.fhir.model.r5.terminologies

import kotlin.String

/**
 * This value set defines a base set of codes for country, country subdivision and region for
 * indicating where a resource is intended to be used.
 *
 * Note: The codes for countries and country subdivisions are taken from
 * [ISO 3166](https://www.iso.org/iso-3166-country-codes.html) while the codes for "supra-national"
 * regions are from
 * [UN Standard country or area codes for statistical use (M49)](http://unstats.un.org/unsd/methods/m49/m49.htm).
 */
public enum class JurisdictionValueSet(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Ad("AD", "urn:iso:std:iso:3166", "Andorra"),
  Ae("AE", "urn:iso:std:iso:3166", "United Arab Emirates"),
  Af("AF", "urn:iso:std:iso:3166", "Afghanistan"),
  Ag("AG", "urn:iso:std:iso:3166", "Antigua and Barbuda"),
  Ai("AI", "urn:iso:std:iso:3166", "Anguilla"),
  Al("AL", "urn:iso:std:iso:3166", "Albania"),
  Am("AM", "urn:iso:std:iso:3166", "Armenia"),
  Ao("AO", "urn:iso:std:iso:3166", "Angola"),
  Aq("AQ", "urn:iso:std:iso:3166", "Antarctica"),
  Ar("AR", "urn:iso:std:iso:3166", "Argentina"),
  As("AS", "urn:iso:std:iso:3166", "American Samoa"),
  At("AT", "urn:iso:std:iso:3166", "Austria"),
  Au("AU", "urn:iso:std:iso:3166", "Australia"),
  Aw("AW", "urn:iso:std:iso:3166", "Aruba"),
  Ax("AX", "urn:iso:std:iso:3166", "Eland Islands"),
  Az("AZ", "urn:iso:std:iso:3166", "Azerbaijan"),
  Ba("BA", "urn:iso:std:iso:3166", "Bosnia and Herzegovina"),
  Bb("BB", "urn:iso:std:iso:3166", "Barbados"),
  Bd("BD", "urn:iso:std:iso:3166", "Bangladesh"),
  Be("BE", "urn:iso:std:iso:3166", "Belgium"),
  Bf("BF", "urn:iso:std:iso:3166", "Burkina Faso"),
  Bg("BG", "urn:iso:std:iso:3166", "Bulgaria"),
  Bh("BH", "urn:iso:std:iso:3166", "Bahrain"),
  Bi("BI", "urn:iso:std:iso:3166", "Burundi"),
  Bj("BJ", "urn:iso:std:iso:3166", "Benin"),
  Bl("BL", "urn:iso:std:iso:3166", "Saint Barthilemy"),
  Bm("BM", "urn:iso:std:iso:3166", "Bermuda"),
  Bn("BN", "urn:iso:std:iso:3166", "Brunei Darussalam"),
  Bo("BO", "urn:iso:std:iso:3166", "Bolivia, Plurinational State of"),
  Bq("BQ", "urn:iso:std:iso:3166", "Bonaire, Sint Eustatius and Saba"),
  Br("BR", "urn:iso:std:iso:3166", "Brazil"),
  Bs("BS", "urn:iso:std:iso:3166", "Bahamas"),
  Bt("BT", "urn:iso:std:iso:3166", "Bhutan"),
  Bv("BV", "urn:iso:std:iso:3166", "Bouvet Island"),
  Bw("BW", "urn:iso:std:iso:3166", "Botswana"),
  By("BY", "urn:iso:std:iso:3166", "Belarus"),
  Bz("BZ", "urn:iso:std:iso:3166", "Belize"),
  Ca("CA", "urn:iso:std:iso:3166", "Canada"),
  Cc("CC", "urn:iso:std:iso:3166", "Cocos (Keeling) Islands"),
  Cd("CD", "urn:iso:std:iso:3166", "Congo, the Democratic Republic of the"),
  Cf("CF", "urn:iso:std:iso:3166", "Central African Republic"),
  Cg("CG", "urn:iso:std:iso:3166", "Congo"),
  Ch("CH", "urn:iso:std:iso:3166", "Switzerland"),
  Ci("CI", "urn:iso:std:iso:3166", "Ctte d'Ivoire"),
  Ck("CK", "urn:iso:std:iso:3166", "Cook Islands"),
  Cl("CL", "urn:iso:std:iso:3166", "Chile"),
  Cm("CM", "urn:iso:std:iso:3166", "Cameroon"),
  Cn("CN", "urn:iso:std:iso:3166", "China"),
  Co("CO", "urn:iso:std:iso:3166", "Colombia"),
  Cr("CR", "urn:iso:std:iso:3166", "Costa Rica"),
  Cu("CU", "urn:iso:std:iso:3166", "Cuba"),
  Cv("CV", "urn:iso:std:iso:3166", "Cabo Verde"),
  Cw("CW", "urn:iso:std:iso:3166", "Curagao"),
  Cx("CX", "urn:iso:std:iso:3166", "Christmas Island"),
  Cy("CY", "urn:iso:std:iso:3166", "Cyprus"),
  Cz("CZ", "urn:iso:std:iso:3166", "Czechia"),
  De("DE", "urn:iso:std:iso:3166", "Germany"),
  Dj("DJ", "urn:iso:std:iso:3166", "Djibouti"),
  Dk("DK", "urn:iso:std:iso:3166", "Denmark"),
  Dm("DM", "urn:iso:std:iso:3166", "Dominica"),
  Do("DO", "urn:iso:std:iso:3166", "Dominican Republic"),
  Dz("DZ", "urn:iso:std:iso:3166", "Algeria"),
  Ec("EC", "urn:iso:std:iso:3166", "Ecuador"),
  Ee("EE", "urn:iso:std:iso:3166", "Estonia"),
  Eg("EG", "urn:iso:std:iso:3166", "Egypt"),
  Eh("EH", "urn:iso:std:iso:3166", "Western Sahara"),
  Er("ER", "urn:iso:std:iso:3166", "Eritrea"),
  Es("ES", "urn:iso:std:iso:3166", "Spain"),
  Et("ET", "urn:iso:std:iso:3166", "Ethiopia"),
  Fi("FI", "urn:iso:std:iso:3166", "Finland"),
  Fj("FJ", "urn:iso:std:iso:3166", "Fiji"),
  Fk("FK", "urn:iso:std:iso:3166", "Falkland Islands (Malvinas)"),
  Fm("FM", "urn:iso:std:iso:3166", "Micronesia, Federated States of"),
  Fo("FO", "urn:iso:std:iso:3166", "Faroe Islands"),
  Fr("FR", "urn:iso:std:iso:3166", "France"),
  Ga("GA", "urn:iso:std:iso:3166", "Gabon"),
  Gb("GB", "urn:iso:std:iso:3166", "United Kingdom of Great Britain and Northern Ireland"),
  Gd("GD", "urn:iso:std:iso:3166", "Grenada"),
  Ge("GE", "urn:iso:std:iso:3166", "Georgia"),
  Gf("GF", "urn:iso:std:iso:3166", "French Guiana"),
  Gg("GG", "urn:iso:std:iso:3166", "Guernsey"),
  Gh("GH", "urn:iso:std:iso:3166", "Ghana"),
  Gi("GI", "urn:iso:std:iso:3166", "Gibraltar"),
  Gl("GL", "urn:iso:std:iso:3166", "Greenland"),
  Gm("GM", "urn:iso:std:iso:3166", "Gambia"),
  Gn("GN", "urn:iso:std:iso:3166", "Guinea"),
  Gp("GP", "urn:iso:std:iso:3166", "Guadeloupe"),
  Gq("GQ", "urn:iso:std:iso:3166", "Equatorial Guinea"),
  Gr("GR", "urn:iso:std:iso:3166", "Greece"),
  Gs("GS", "urn:iso:std:iso:3166", "South Georgia and the South Sandwich Islands"),
  Gt("GT", "urn:iso:std:iso:3166", "Guatemala"),
  Gu("GU", "urn:iso:std:iso:3166", "Guam"),
  Gw("GW", "urn:iso:std:iso:3166", "Guinea-Bissau"),
  Gy("GY", "urn:iso:std:iso:3166", "Guyana"),
  Hk("HK", "urn:iso:std:iso:3166", "Hong Kong"),
  Hm("HM", "urn:iso:std:iso:3166", "Heard Island and McDonald Islands"),
  Hn("HN", "urn:iso:std:iso:3166", "Honduras"),
  Hr("HR", "urn:iso:std:iso:3166", "Croatia"),
  Ht("HT", "urn:iso:std:iso:3166", "Haiti"),
  Hu("HU", "urn:iso:std:iso:3166", "Hungary"),
  Id("ID", "urn:iso:std:iso:3166", "Indonesia"),
  Ie("IE", "urn:iso:std:iso:3166", "Ireland"),
  Il("IL", "urn:iso:std:iso:3166", "Israel"),
  Im("IM", "urn:iso:std:iso:3166", "Isle of Man"),
  In("IN", "urn:iso:std:iso:3166", "India"),
  Io("IO", "urn:iso:std:iso:3166", "British Indian Ocean Territory"),
  Iq("IQ", "urn:iso:std:iso:3166", "Iraq"),
  Ir("IR", "urn:iso:std:iso:3166", "Iran, Islamic Republic of"),
  Is("IS", "urn:iso:std:iso:3166", "Iceland"),
  It("IT", "urn:iso:std:iso:3166", "Italy"),
  Je("JE", "urn:iso:std:iso:3166", "Jersey"),
  Jm("JM", "urn:iso:std:iso:3166", "Jamaica"),
  Jo("JO", "urn:iso:std:iso:3166", "Jordan"),
  Jp("JP", "urn:iso:std:iso:3166", "Japan"),
  Ke("KE", "urn:iso:std:iso:3166", "Kenya"),
  Kg("KG", "urn:iso:std:iso:3166", "Kyrgyzstan"),
  Kh("KH", "urn:iso:std:iso:3166", "Cambodia"),
  Ki("KI", "urn:iso:std:iso:3166", "Kiribati"),
  Km("KM", "urn:iso:std:iso:3166", "Comoros"),
  Kn("KN", "urn:iso:std:iso:3166", "Saint Kitts and Nevis"),
  Kp("KP", "urn:iso:std:iso:3166", "Korea, Democratic People's Republic of"),
  Kr("KR", "urn:iso:std:iso:3166", "Korea, Republic of"),
  Kw("KW", "urn:iso:std:iso:3166", "Kuwait"),
  Ky("KY", "urn:iso:std:iso:3166", "Cayman Islands"),
  Kz("KZ", "urn:iso:std:iso:3166", "Kazakhstan"),
  La("LA", "urn:iso:std:iso:3166", "Lao People's Democratic Republic"),
  Lb("LB", "urn:iso:std:iso:3166", "Lebanon"),
  Lc("LC", "urn:iso:std:iso:3166", "Saint Lucia"),
  Li("LI", "urn:iso:std:iso:3166", "Liechtenstein"),
  Lk("LK", "urn:iso:std:iso:3166", "Sri Lanka"),
  Lr("LR", "urn:iso:std:iso:3166", "Liberia"),
  Ls("LS", "urn:iso:std:iso:3166", "Lesotho"),
  Lt("LT", "urn:iso:std:iso:3166", "Lithuania"),
  Lu("LU", "urn:iso:std:iso:3166", "Luxembourg"),
  Lv("LV", "urn:iso:std:iso:3166", "Latvia"),
  Ly("LY", "urn:iso:std:iso:3166", "Libya"),
  Ma("MA", "urn:iso:std:iso:3166", "Morocco"),
  Mc("MC", "urn:iso:std:iso:3166", "Monaco"),
  Md("MD", "urn:iso:std:iso:3166", "Moldova, Republic of"),
  Me("ME", "urn:iso:std:iso:3166", "Montenegro"),
  Mf("MF", "urn:iso:std:iso:3166", "Saint Martin (French part)"),
  Mg("MG", "urn:iso:std:iso:3166", "Madagascar"),
  Mh("MH", "urn:iso:std:iso:3166", "Marshall Islands"),
  Mk("MK", "urn:iso:std:iso:3166", "Macedonia, the former Yugoslav Republic of"),
  Ml("ML", "urn:iso:std:iso:3166", "Mali"),
  Mm("MM", "urn:iso:std:iso:3166", "Myanmar"),
  Mn("MN", "urn:iso:std:iso:3166", "Mongolia"),
  Mo("MO", "urn:iso:std:iso:3166", "Macao"),
  Mp("MP", "urn:iso:std:iso:3166", "Northern Mariana Islands"),
  Mq("MQ", "urn:iso:std:iso:3166", "Martinique"),
  Mr("MR", "urn:iso:std:iso:3166", "Mauritania"),
  Ms("MS", "urn:iso:std:iso:3166", "Montserrat"),
  Mt("MT", "urn:iso:std:iso:3166", "Malta"),
  Mu("MU", "urn:iso:std:iso:3166", "Mauritius"),
  Mv("MV", "urn:iso:std:iso:3166", "Maldives"),
  Mw("MW", "urn:iso:std:iso:3166", "Malawi"),
  Mx("MX", "urn:iso:std:iso:3166", "Mexico"),
  My("MY", "urn:iso:std:iso:3166", "Malaysia"),
  Mz("MZ", "urn:iso:std:iso:3166", "Mozambique"),
  Na("NA", "urn:iso:std:iso:3166", "Namibia"),
  Nc("NC", "urn:iso:std:iso:3166", "New Caledonia"),
  Ne("NE", "urn:iso:std:iso:3166", "Niger"),
  Nf("NF", "urn:iso:std:iso:3166", "Norfolk Island"),
  Ng("NG", "urn:iso:std:iso:3166", "Nigeria"),
  Ni("NI", "urn:iso:std:iso:3166", "Nicaragua"),
  Nl("NL", "urn:iso:std:iso:3166", "Netherlands"),
  No("NO", "urn:iso:std:iso:3166", "Norway"),
  Np("NP", "urn:iso:std:iso:3166", "Nepal"),
  Nr("NR", "urn:iso:std:iso:3166", "Nauru"),
  Nu("NU", "urn:iso:std:iso:3166", "Niue"),
  Nz("NZ", "urn:iso:std:iso:3166", "New Zealand"),
  Om("OM", "urn:iso:std:iso:3166", "Oman"),
  Pa("PA", "urn:iso:std:iso:3166", "Panama"),
  Pe("PE", "urn:iso:std:iso:3166", "Peru"),
  Pf("PF", "urn:iso:std:iso:3166", "French Polynesia"),
  Pg("PG", "urn:iso:std:iso:3166", "Papua New Guinea"),
  Ph("PH", "urn:iso:std:iso:3166", "Philippines"),
  Pk("PK", "urn:iso:std:iso:3166", "Pakistan"),
  Pl("PL", "urn:iso:std:iso:3166", "Poland"),
  Pm("PM", "urn:iso:std:iso:3166", "Saint Pierre and Miquelon"),
  Pn("PN", "urn:iso:std:iso:3166", "Pitcairn"),
  Pr("PR", "urn:iso:std:iso:3166", "Puerto Rico"),
  Ps("PS", "urn:iso:std:iso:3166", "Palestine, State of"),
  Pt("PT", "urn:iso:std:iso:3166", "Portugal"),
  Pw("PW", "urn:iso:std:iso:3166", "Palau"),
  Py("PY", "urn:iso:std:iso:3166", "Paraguay"),
  Qa("QA", "urn:iso:std:iso:3166", "Qatar"),
  Re("RE", "urn:iso:std:iso:3166", "Riunion"),
  Ro("RO", "urn:iso:std:iso:3166", "Romania"),
  Rs("RS", "urn:iso:std:iso:3166", "Serbia"),
  Ru("RU", "urn:iso:std:iso:3166", "Russian Federation"),
  Rw("RW", "urn:iso:std:iso:3166", "Rwanda"),
  Sa("SA", "urn:iso:std:iso:3166", "Saudi Arabia"),
  Sb("SB", "urn:iso:std:iso:3166", "Solomon Islands"),
  Sc("SC", "urn:iso:std:iso:3166", "Seychelles"),
  Sd("SD", "urn:iso:std:iso:3166", "Sudan"),
  Se("SE", "urn:iso:std:iso:3166", "Sweden"),
  Sg("SG", "urn:iso:std:iso:3166", "Singapore"),
  Sh("SH", "urn:iso:std:iso:3166", "Saint Helena, Ascension and Tristan da Cunha"),
  Si("SI", "urn:iso:std:iso:3166", "Slovenia"),
  Sj("SJ", "urn:iso:std:iso:3166", "Svalbard and Jan Mayen"),
  Sk("SK", "urn:iso:std:iso:3166", "Slovakia"),
  Sl("SL", "urn:iso:std:iso:3166", "Sierra Leone"),
  Sm("SM", "urn:iso:std:iso:3166", "San Marino"),
  Sn("SN", "urn:iso:std:iso:3166", "Senegal"),
  So("SO", "urn:iso:std:iso:3166", "Somalia"),
  Sr("SR", "urn:iso:std:iso:3166", "Suriname"),
  Ss("SS", "urn:iso:std:iso:3166", "South Sudan"),
  St("ST", "urn:iso:std:iso:3166", "Sao Tome and Principe"),
  Sv("SV", "urn:iso:std:iso:3166", "El Salvador"),
  Sx("SX", "urn:iso:std:iso:3166", "Sint Maarten (Dutch part)"),
  Sy("SY", "urn:iso:std:iso:3166", "Syrian Arab Republic"),
  Sz("SZ", "urn:iso:std:iso:3166", "Swaziland"),
  Tc("TC", "urn:iso:std:iso:3166", "Turks and Caicos Islands"),
  Td("TD", "urn:iso:std:iso:3166", "Chad"),
  Tf("TF", "urn:iso:std:iso:3166", "French Southern Territories"),
  Tg("TG", "urn:iso:std:iso:3166", "Togo"),
  Th("TH", "urn:iso:std:iso:3166", "Thailand"),
  Tj("TJ", "urn:iso:std:iso:3166", "Tajikistan"),
  Tk("TK", "urn:iso:std:iso:3166", "Tokelau"),
  Tl("TL", "urn:iso:std:iso:3166", "Timor-Leste"),
  Tm("TM", "urn:iso:std:iso:3166", "Turkmenistan"),
  Tn("TN", "urn:iso:std:iso:3166", "Tunisia"),
  To("TO", "urn:iso:std:iso:3166", "Tonga"),
  Tr("TR", "urn:iso:std:iso:3166", "Turkey"),
  Tt("TT", "urn:iso:std:iso:3166", "Trinidad and Tobago"),
  Tv("TV", "urn:iso:std:iso:3166", "Tuvalu"),
  Tw("TW", "urn:iso:std:iso:3166", "Taiwan, Province of China"),
  Tz("TZ", "urn:iso:std:iso:3166", "Tanzania, United Republic of"),
  Ua("UA", "urn:iso:std:iso:3166", "Ukraine"),
  Ug("UG", "urn:iso:std:iso:3166", "Uganda"),
  Um("UM", "urn:iso:std:iso:3166", "United States Minor Outlying Islands"),
  Us("US", "urn:iso:std:iso:3166", "United States of America"),
  Uy("UY", "urn:iso:std:iso:3166", "Uruguay"),
  Uz("UZ", "urn:iso:std:iso:3166", "Uzbekistan"),
  Va("VA", "urn:iso:std:iso:3166", "Holy See"),
  Vc("VC", "urn:iso:std:iso:3166", "Saint Vincent and the Grenadines"),
  Ve("VE", "urn:iso:std:iso:3166", "Venezuela, Bolivarian Republic of"),
  Vg("VG", "urn:iso:std:iso:3166", "Virgin Islands, British"),
  Vi("VI", "urn:iso:std:iso:3166", "Virgin Islands,"),
  Vn("VN", "urn:iso:std:iso:3166", "Viet Nam"),
  Vu("VU", "urn:iso:std:iso:3166", "Vanuatu"),
  Wf("WF", "urn:iso:std:iso:3166", "Wallis and Futuna"),
  Ws("WS", "urn:iso:std:iso:3166", "Samoa"),
  Ye("YE", "urn:iso:std:iso:3166", "Yemen"),
  Yt("YT", "urn:iso:std:iso:3166", "Mayotte"),
  Za("ZA", "urn:iso:std:iso:3166", "South Africa"),
  Zm("ZM", "urn:iso:std:iso:3166", "Zambia"),
  Zw("ZW", "urn:iso:std:iso:3166", "Zimbabwe"),
  Abw("ABW", "urn:iso:std:iso:3166", "Aruba"),
  Afg("AFG", "urn:iso:std:iso:3166", "Afghanistan"),
  Ago("AGO", "urn:iso:std:iso:3166", "Angola"),
  Aia("AIA", "urn:iso:std:iso:3166", "Anguilla"),
  Ala("ALA", "urn:iso:std:iso:3166", "Eland Islands"),
  Alb("ALB", "urn:iso:std:iso:3166", "Albania"),
  And("AND", "urn:iso:std:iso:3166", "Andorra"),
  Are("ARE", "urn:iso:std:iso:3166", "United Arab Emirates"),
  Arg("ARG", "urn:iso:std:iso:3166", "Argentina"),
  Arm("ARM", "urn:iso:std:iso:3166", "Armenia"),
  Asm("ASM", "urn:iso:std:iso:3166", "American Samoa"),
  Ata("ATA", "urn:iso:std:iso:3166", "Antarctica"),
  Atf("ATF", "urn:iso:std:iso:3166", "French Southern Territories"),
  Atg("ATG", "urn:iso:std:iso:3166", "Antigua and Barbuda"),
  Aus("AUS", "urn:iso:std:iso:3166", "Australia"),
  Aut("AUT", "urn:iso:std:iso:3166", "Austria"),
  Aze("AZE", "urn:iso:std:iso:3166", "Azerbaijan"),
  Bdi("BDI", "urn:iso:std:iso:3166", "Burundi"),
  Bel("BEL", "urn:iso:std:iso:3166", "Belgium"),
  Ben("BEN", "urn:iso:std:iso:3166", "Benin"),
  Bes("BES", "urn:iso:std:iso:3166", "Bonaire, Sint Eustatius and Saba"),
  Bfa("BFA", "urn:iso:std:iso:3166", "Burkina Faso"),
  Bgd("BGD", "urn:iso:std:iso:3166", "Bangladesh"),
  Bgr("BGR", "urn:iso:std:iso:3166", "Bulgaria"),
  Bhr("BHR", "urn:iso:std:iso:3166", "Bahrain"),
  Bhs("BHS", "urn:iso:std:iso:3166", "Bahamas"),
  Bih("BIH", "urn:iso:std:iso:3166", "Bosnia and Herzegovina"),
  Blm("BLM", "urn:iso:std:iso:3166", "Saint Barthilemy"),
  Blr("BLR", "urn:iso:std:iso:3166", "Belarus"),
  Blz("BLZ", "urn:iso:std:iso:3166", "Belize"),
  Bmu("BMU", "urn:iso:std:iso:3166", "Bermuda"),
  Bol("BOL", "urn:iso:std:iso:3166", "Bolivia, Plurinational State of"),
  Bra("BRA", "urn:iso:std:iso:3166", "Brazil"),
  Brb("BRB", "urn:iso:std:iso:3166", "Barbados"),
  Brn("BRN", "urn:iso:std:iso:3166", "Brunei Darussalam"),
  Btn("BTN", "urn:iso:std:iso:3166", "Bhutan"),
  Bvt("BVT", "urn:iso:std:iso:3166", "Bouvet Island"),
  Bwa("BWA", "urn:iso:std:iso:3166", "Botswana"),
  Caf("CAF", "urn:iso:std:iso:3166", "Central African Republic"),
  Can("CAN", "urn:iso:std:iso:3166", "Canada"),
  Cck("CCK", "urn:iso:std:iso:3166", "Cocos (Keeling) Islands"),
  Che("CHE", "urn:iso:std:iso:3166", "Switzerland"),
  Chl("CHL", "urn:iso:std:iso:3166", "Chile"),
  Chn("CHN", "urn:iso:std:iso:3166", "China"),
  Civ("CIV", "urn:iso:std:iso:3166", "Ctte d'Ivoire"),
  Cmr("CMR", "urn:iso:std:iso:3166", "Cameroon"),
  Cod("COD", "urn:iso:std:iso:3166", "Congo, the Democratic Republic of the"),
  Cog("COG", "urn:iso:std:iso:3166", "Congo"),
  Cok("COK", "urn:iso:std:iso:3166", "Cook Islands"),
  Col("COL", "urn:iso:std:iso:3166", "Colombia"),
  Com("COM", "urn:iso:std:iso:3166", "Comoros"),
  Cpv("CPV", "urn:iso:std:iso:3166", "Cabo Verde"),
  Cri("CRI", "urn:iso:std:iso:3166", "Costa Rica"),
  Cub("CUB", "urn:iso:std:iso:3166", "Cuba"),
  Cuw("CUW", "urn:iso:std:iso:3166", "Curagao"),
  Cxr("CXR", "urn:iso:std:iso:3166", "Christmas Island"),
  Cym("CYM", "urn:iso:std:iso:3166", "Cayman Islands"),
  Cyp("CYP", "urn:iso:std:iso:3166", "Cyprus"),
  Cze("CZE", "urn:iso:std:iso:3166", "Czechia"),
  Deu("DEU", "urn:iso:std:iso:3166", "Germany"),
  Dji("DJI", "urn:iso:std:iso:3166", "Djibouti"),
  Dma("DMA", "urn:iso:std:iso:3166", "Dominica"),
  Dnk("DNK", "urn:iso:std:iso:3166", "Denmark"),
  Dom("DOM", "urn:iso:std:iso:3166", "Dominican Republic"),
  Dza("DZA", "urn:iso:std:iso:3166", "Algeria"),
  Ecu("ECU", "urn:iso:std:iso:3166", "Ecuador"),
  Egy("EGY", "urn:iso:std:iso:3166", "Egypt"),
  Eri("ERI", "urn:iso:std:iso:3166", "Eritrea"),
  Esh("ESH", "urn:iso:std:iso:3166", "Western Sahara"),
  Esp("ESP", "urn:iso:std:iso:3166", "Spain"),
  Est("EST", "urn:iso:std:iso:3166", "Estonia"),
  Eth("ETH", "urn:iso:std:iso:3166", "Ethiopia"),
  Fin("FIN", "urn:iso:std:iso:3166", "Finland"),
  Fji("FJI", "urn:iso:std:iso:3166", "Fiji"),
  Flk("FLK", "urn:iso:std:iso:3166", "Falkland Islands (Malvinas)"),
  Fra("FRA", "urn:iso:std:iso:3166", "France"),
  Fro("FRO", "urn:iso:std:iso:3166", "Faroe Islands"),
  Fsm("FSM", "urn:iso:std:iso:3166", "Micronesia, Federated States of"),
  Gab("GAB", "urn:iso:std:iso:3166", "Gabon"),
  Gbr("GBR", "urn:iso:std:iso:3166", "United Kingdom"),
  Geo("GEO", "urn:iso:std:iso:3166", "Georgia"),
  Ggy("GGY", "urn:iso:std:iso:3166", "Guernsey"),
  Gha("GHA", "urn:iso:std:iso:3166", "Ghana"),
  Gib("GIB", "urn:iso:std:iso:3166", "Gibraltar"),
  Gin("GIN", "urn:iso:std:iso:3166", "Guinea"),
  Glp("GLP", "urn:iso:std:iso:3166", "Guadeloupe"),
  Gmb("GMB", "urn:iso:std:iso:3166", "Gambia"),
  Gnb("GNB", "urn:iso:std:iso:3166", "Guinea-Bissau"),
  Gnq("GNQ", "urn:iso:std:iso:3166", "Equatorial Guinea"),
  Grc("GRC", "urn:iso:std:iso:3166", "Greece"),
  Grd("GRD", "urn:iso:std:iso:3166", "Grenada"),
  Grl("GRL", "urn:iso:std:iso:3166", "Greenland"),
  Gtm("GTM", "urn:iso:std:iso:3166", "Guatemala"),
  Guf("GUF", "urn:iso:std:iso:3166", "French Guiana"),
  Gum("GUM", "urn:iso:std:iso:3166", "Guam"),
  Guy("GUY", "urn:iso:std:iso:3166", "Guyana"),
  Hkg("HKG", "urn:iso:std:iso:3166", "Hong Kong"),
  Hmd("HMD", "urn:iso:std:iso:3166", "Heard Island and McDonald Islands"),
  Hnd("HND", "urn:iso:std:iso:3166", "Honduras"),
  Hrv("HRV", "urn:iso:std:iso:3166", "Croatia"),
  Hti("HTI", "urn:iso:std:iso:3166", "Haiti"),
  Hun("HUN", "urn:iso:std:iso:3166", "Hungary"),
  Idn("IDN", "urn:iso:std:iso:3166", "Indonesia"),
  Imn("IMN", "urn:iso:std:iso:3166", "Isle of Man"),
  Ind("IND", "urn:iso:std:iso:3166", "India"),
  Iot("IOT", "urn:iso:std:iso:3166", "British Indian Ocean Territory"),
  Irl("IRL", "urn:iso:std:iso:3166", "Ireland"),
  Irn("IRN", "urn:iso:std:iso:3166", "Iran, Islamic Republic of"),
  Irq("IRQ", "urn:iso:std:iso:3166", "Iraq"),
  Isl("ISL", "urn:iso:std:iso:3166", "Iceland"),
  Isr("ISR", "urn:iso:std:iso:3166", "Israel"),
  Ita("ITA", "urn:iso:std:iso:3166", "Italy"),
  Jam("JAM", "urn:iso:std:iso:3166", "Jamaica"),
  Jey("JEY", "urn:iso:std:iso:3166", "Jersey"),
  Jor("JOR", "urn:iso:std:iso:3166", "Jordan"),
  Jpn("JPN", "urn:iso:std:iso:3166", "Japan"),
  Kaz("KAZ", "urn:iso:std:iso:3166", "Kazakhstan"),
  Ken("KEN", "urn:iso:std:iso:3166", "Kenya"),
  Kgz("KGZ", "urn:iso:std:iso:3166", "Kyrgyzstan"),
  Khm("KHM", "urn:iso:std:iso:3166", "Cambodia"),
  Kir("KIR", "urn:iso:std:iso:3166", "Kiribati"),
  Kna("KNA", "urn:iso:std:iso:3166", "Saint Kitts and Nevis"),
  Kor("KOR", "urn:iso:std:iso:3166", "Korea, Republic of"),
  Kwt("KWT", "urn:iso:std:iso:3166", "Kuwait"),
  Lao("LAO", "urn:iso:std:iso:3166", "Lao People's Democratic Republic"),
  Lbn("LBN", "urn:iso:std:iso:3166", "Lebanon"),
  Lbr("LBR", "urn:iso:std:iso:3166", "Liberia"),
  Lby("LBY", "urn:iso:std:iso:3166", "Libya"),
  Lca("LCA", "urn:iso:std:iso:3166", "Saint Lucia"),
  Lie("LIE", "urn:iso:std:iso:3166", "Liechtenstein"),
  Lka("LKA", "urn:iso:std:iso:3166", "Sri Lanka"),
  Lso("LSO", "urn:iso:std:iso:3166", "Lesotho"),
  Ltu("LTU", "urn:iso:std:iso:3166", "Lithuania"),
  Lux("LUX", "urn:iso:std:iso:3166", "Luxembourg"),
  Lva("LVA", "urn:iso:std:iso:3166", "Latvia"),
  Mac("MAC", "urn:iso:std:iso:3166", "Macao"),
  Maf("MAF", "urn:iso:std:iso:3166", "Saint Martin (French part)"),
  Mar("MAR", "urn:iso:std:iso:3166", "Morocco"),
  Mco("MCO", "urn:iso:std:iso:3166", "Monaco"),
  Mda("MDA", "urn:iso:std:iso:3166", "Moldova, Republic of"),
  Mdg("MDG", "urn:iso:std:iso:3166", "Madagascar"),
  Mdv("MDV", "urn:iso:std:iso:3166", "Maldives"),
  Mex("MEX", "urn:iso:std:iso:3166", "Mexico"),
  Mhl("MHL", "urn:iso:std:iso:3166", "Marshall Islands"),
  Mkd("MKD", "urn:iso:std:iso:3166", "Macedonia, the former Yugoslav Republic of"),
  Mli("MLI", "urn:iso:std:iso:3166", "Mali"),
  Mlt("MLT", "urn:iso:std:iso:3166", "Malta"),
  Mmr("MMR", "urn:iso:std:iso:3166", "Myanmar"),
  Mne("MNE", "urn:iso:std:iso:3166", "Montenegro"),
  Mng("MNG", "urn:iso:std:iso:3166", "Mongolia"),
  Mnp("MNP", "urn:iso:std:iso:3166", "Northern Mariana Islands"),
  Moz("MOZ", "urn:iso:std:iso:3166", "Mozambique"),
  Mrt("MRT", "urn:iso:std:iso:3166", "Mauritania"),
  Msr("MSR", "urn:iso:std:iso:3166", "Montserrat"),
  Mtq("MTQ", "urn:iso:std:iso:3166", "Martinique"),
  Mus("MUS", "urn:iso:std:iso:3166", "Mauritius"),
  Mwi("MWI", "urn:iso:std:iso:3166", "Malawi"),
  Mys("MYS", "urn:iso:std:iso:3166", "Malaysia"),
  Myt("MYT", "urn:iso:std:iso:3166", "Mayotte"),
  Nam("NAM", "urn:iso:std:iso:3166", "Namibia"),
  Ncl("NCL", "urn:iso:std:iso:3166", "New Caledonia"),
  Ner("NER", "urn:iso:std:iso:3166", "Niger"),
  Nfk("NFK", "urn:iso:std:iso:3166", "Norfolk Island"),
  Nga("NGA", "urn:iso:std:iso:3166", "Nigeria"),
  Nic("NIC", "urn:iso:std:iso:3166", "Nicaragua"),
  Niu("NIU", "urn:iso:std:iso:3166", "Niue"),
  Nld("NLD", "urn:iso:std:iso:3166", "Netherlands"),
  Nor("NOR", "urn:iso:std:iso:3166", "Norway"),
  Npl("NPL", "urn:iso:std:iso:3166", "Nepal"),
  Nru("NRU", "urn:iso:std:iso:3166", "Nauru"),
  Nzl("NZL", "urn:iso:std:iso:3166", "New Zealand"),
  Omn("OMN", "urn:iso:std:iso:3166", "Oman"),
  Pak("PAK", "urn:iso:std:iso:3166", "Pakistan"),
  Pan("PAN", "urn:iso:std:iso:3166", "Panama"),
  Pcn("PCN", "urn:iso:std:iso:3166", "Pitcairn"),
  Per("PER", "urn:iso:std:iso:3166", "Peru"),
  Phl("PHL", "urn:iso:std:iso:3166", "Philippines"),
  Plw("PLW", "urn:iso:std:iso:3166", "Palau"),
  Png("PNG", "urn:iso:std:iso:3166", "Papua New Guinea"),
  Pol("POL", "urn:iso:std:iso:3166", "Poland"),
  Pri("PRI", "urn:iso:std:iso:3166", "Puerto Rico"),
  Prk("PRK", "urn:iso:std:iso:3166", "Korea, Democratic People's Republic of"),
  Prt("PRT", "urn:iso:std:iso:3166", "Portugal"),
  Pry("PRY", "urn:iso:std:iso:3166", "Paraguay"),
  Pse("PSE", "urn:iso:std:iso:3166", "Palestine, State of"),
  Pyf("PYF", "urn:iso:std:iso:3166", "French Polynesia"),
  Qat("QAT", "urn:iso:std:iso:3166", "Qatar"),
  Reu("REU", "urn:iso:std:iso:3166", "Riunion"),
  Rou("ROU", "urn:iso:std:iso:3166", "Romania"),
  Rus("RUS", "urn:iso:std:iso:3166", "Russian Federation"),
  Rwa("RWA", "urn:iso:std:iso:3166", "Rwanda"),
  Sau("SAU", "urn:iso:std:iso:3166", "Saudi Arabia"),
  Sdn("SDN", "urn:iso:std:iso:3166", "Sudan"),
  Sen("SEN", "urn:iso:std:iso:3166", "Senegal"),
  Sgp("SGP", "urn:iso:std:iso:3166", "Singapore"),
  Sgs("SGS", "urn:iso:std:iso:3166", "South Georgia and the South Sandwich Islands"),
  Shn("SHN", "urn:iso:std:iso:3166", "Saint Helena, Ascension and Tristan da Cunha"),
  Sjm("SJM", "urn:iso:std:iso:3166", "Svalbard and Jan Mayen"),
  Slb("SLB", "urn:iso:std:iso:3166", "Solomon Islands"),
  Sle("SLE", "urn:iso:std:iso:3166", "Sierra Leone"),
  Slv("SLV", "urn:iso:std:iso:3166", "El Salvador"),
  Smr("SMR", "urn:iso:std:iso:3166", "San Marino"),
  Som("SOM", "urn:iso:std:iso:3166", "Somalia"),
  Spm("SPM", "urn:iso:std:iso:3166", "Saint Pierre and Miquelon"),
  Srb("SRB", "urn:iso:std:iso:3166", "Serbia"),
  Ssd("SSD", "urn:iso:std:iso:3166", "South Sudan"),
  Stp("STP", "urn:iso:std:iso:3166", "Sao Tome and Principe"),
  Sur("SUR", "urn:iso:std:iso:3166", "Suriname"),
  Svk("SVK", "urn:iso:std:iso:3166", "Slovakia"),
  Svn("SVN", "urn:iso:std:iso:3166", "Slovenia"),
  Swe("SWE", "urn:iso:std:iso:3166", "Sweden"),
  Swz("SWZ", "urn:iso:std:iso:3166", "Swaziland"),
  Sxm("SXM", "urn:iso:std:iso:3166", "Sint Maarten (Dutch part)"),
  Syc("SYC", "urn:iso:std:iso:3166", "Seychelles"),
  Syr("SYR", "urn:iso:std:iso:3166", "Syrian Arab Republic"),
  Tca("TCA", "urn:iso:std:iso:3166", "Turks and Caicos Islands"),
  Tcd("TCD", "urn:iso:std:iso:3166", "Chad"),
  Tgo("TGO", "urn:iso:std:iso:3166", "Togo"),
  Tha("THA", "urn:iso:std:iso:3166", "Thailand"),
  Tjk("TJK", "urn:iso:std:iso:3166", "Tajikistan"),
  Tkl("TKL", "urn:iso:std:iso:3166", "Tokelau"),
  Tkm("TKM", "urn:iso:std:iso:3166", "Turkmenistan"),
  Tls("TLS", "urn:iso:std:iso:3166", "Timor-Leste"),
  Ton("TON", "urn:iso:std:iso:3166", "Tonga"),
  Tto("TTO", "urn:iso:std:iso:3166", "Trinidad and Tobago"),
  Tun("TUN", "urn:iso:std:iso:3166", "Tunisia"),
  Tur("TUR", "urn:iso:std:iso:3166", "Turkey"),
  Tuv("TUV", "urn:iso:std:iso:3166", "Tuvalu"),
  Twn("TWN", "urn:iso:std:iso:3166", "Taiwan, Province of China"),
  Tza("TZA", "urn:iso:std:iso:3166", "Tanzania, United Republic of"),
  Uga("UGA", "urn:iso:std:iso:3166", "Uganda"),
  Ukr("UKR", "urn:iso:std:iso:3166", "Ukraine"),
  Umi("UMI", "urn:iso:std:iso:3166", "United States Minor Outlying Islands"),
  Ury("URY", "urn:iso:std:iso:3166", "Uruguay"),
  Usa("USA", "urn:iso:std:iso:3166", "United States of America"),
  Uzb("UZB", "urn:iso:std:iso:3166", "Uzbekistan"),
  Vat("VAT", "urn:iso:std:iso:3166", "Holy See"),
  Vct("VCT", "urn:iso:std:iso:3166", "Saint Vincent and the Grenadines"),
  Ven("VEN", "urn:iso:std:iso:3166", "Venezuela, Bolivarian Republic of"),
  Vgb("VGB", "urn:iso:std:iso:3166", "Virgin Islands, British"),
  Vir("VIR", "urn:iso:std:iso:3166", "Virgin Islands, U.S."),
  Vnm("VNM", "urn:iso:std:iso:3166", "Viet Nam"),
  Vut("VUT", "urn:iso:std:iso:3166", "Vanuatu"),
  Wlf("WLF", "urn:iso:std:iso:3166", "Wallis and Futuna"),
  Wsm("WSM", "urn:iso:std:iso:3166", "Samoa"),
  Yem("YEM", "urn:iso:std:iso:3166", "Yemen"),
  Zaf("ZAF", "urn:iso:std:iso:3166", "South Africa"),
  Zmb("ZMB", "urn:iso:std:iso:3166", "Zambia"),
  Zwe("ZWE", "urn:iso:std:iso:3166", "Zimbabwe"),
  _004("004", "urn:iso:std:iso:3166", "Afghanistan"),
  _008("008", "urn:iso:std:iso:3166", "Albania"),
  _010("010", "urn:iso:std:iso:3166", "Antarctica"),
  _012("012", "urn:iso:std:iso:3166", "Algeria"),
  _016("016", "urn:iso:std:iso:3166", "American Samoa"),
  _020("020", "urn:iso:std:iso:3166", "Andorra"),
  _024("024", "urn:iso:std:iso:3166", "Angola"),
  _028("028", "urn:iso:std:iso:3166", "Antigua and Barbuda"),
  _031("031", "urn:iso:std:iso:3166", "Azerbaijan"),
  _032("032", "urn:iso:std:iso:3166", "Argentina"),
  _036("036", "urn:iso:std:iso:3166", "Australia"),
  _040("040", "urn:iso:std:iso:3166", "Austria"),
  _044("044", "urn:iso:std:iso:3166", "Bahamas"),
  _048("048", "urn:iso:std:iso:3166", "Bahrain"),
  _050("050", "urn:iso:std:iso:3166", "Bangladesh"),
  _051("051", "urn:iso:std:iso:3166", "Armenia"),
  _052("052", "urn:iso:std:iso:3166", "Barbados"),
  _056("056", "urn:iso:std:iso:3166", "Belgium"),
  _060("060", "urn:iso:std:iso:3166", "Bermuda"),
  _064("064", "urn:iso:std:iso:3166", "Bhutan"),
  _068("068", "urn:iso:std:iso:3166", "Bolivia, Plurinational State of"),
  _070("070", "urn:iso:std:iso:3166", "Bosnia and Herzegovina"),
  _072("072", "urn:iso:std:iso:3166", "Botswana"),
  _074("074", "urn:iso:std:iso:3166", "Bouvet Island"),
  _076("076", "urn:iso:std:iso:3166", "Brazil"),
  _084("084", "urn:iso:std:iso:3166", "Belize"),
  _086("086", "urn:iso:std:iso:3166", "British Indian Ocean Territory"),
  _090("090", "urn:iso:std:iso:3166", "Solomon Islands"),
  _092("092", "urn:iso:std:iso:3166", "Virgin Islands, British"),
  _096("096", "urn:iso:std:iso:3166", "Brunei Darussalam"),
  _100("100", "urn:iso:std:iso:3166", "Bulgaria"),
  _104("104", "urn:iso:std:iso:3166", "Myanmar"),
  _108("108", "urn:iso:std:iso:3166", "Burundi"),
  _112("112", "urn:iso:std:iso:3166", "Belarus"),
  _116("116", "urn:iso:std:iso:3166", "Cambodia"),
  _120("120", "urn:iso:std:iso:3166", "Cameroon"),
  _124("124", "urn:iso:std:iso:3166", "Canada"),
  _132("132", "urn:iso:std:iso:3166", "Cabo Verde"),
  _136("136", "urn:iso:std:iso:3166", "Cayman Islands"),
  _140("140", "urn:iso:std:iso:3166", "Central African Republic"),
  _144("144", "urn:iso:std:iso:3166", "Sri Lanka"),
  _148("148", "urn:iso:std:iso:3166", "Chad"),
  _152("152", "urn:iso:std:iso:3166", "Chile"),
  _156("156", "urn:iso:std:iso:3166", "China"),
  _158("158", "urn:iso:std:iso:3166", "Taiwan, Province of China"),
  _162("162", "urn:iso:std:iso:3166", "Christmas Island"),
  _166("166", "urn:iso:std:iso:3166", "Cocos (Keeling) Islands"),
  _170("170", "urn:iso:std:iso:3166", "Colombia"),
  _174("174", "urn:iso:std:iso:3166", "Comoros"),
  _175("175", "urn:iso:std:iso:3166", "Mayotte"),
  _178("178", "urn:iso:std:iso:3166", "Congo"),
  _180("180", "urn:iso:std:iso:3166", "Congo, the Democratic Republic of the"),
  _184("184", "urn:iso:std:iso:3166", "Cook Islands"),
  _188("188", "urn:iso:std:iso:3166", "Costa Rica"),
  _191("191", "urn:iso:std:iso:3166", "Croatia"),
  _192("192", "urn:iso:std:iso:3166", "Cuba"),
  _196("196", "urn:iso:std:iso:3166", "Cyprus"),
  _203("203", "urn:iso:std:iso:3166", "Czechia"),
  _204("204", "urn:iso:std:iso:3166", "Benin"),
  _208("208", "urn:iso:std:iso:3166", "Denmark"),
  _212("212", "urn:iso:std:iso:3166", "Dominica"),
  _214("214", "urn:iso:std:iso:3166", "Dominican Republic"),
  _218("218", "urn:iso:std:iso:3166", "Ecuador"),
  _222("222", "urn:iso:std:iso:3166", "El Salvador"),
  _226("226", "urn:iso:std:iso:3166", "Equatorial Guinea"),
  _231("231", "urn:iso:std:iso:3166", "Ethiopia"),
  _232("232", "urn:iso:std:iso:3166", "Eritrea"),
  _233("233", "urn:iso:std:iso:3166", "Estonia"),
  _234("234", "urn:iso:std:iso:3166", "Faroe Islands"),
  _238("238", "urn:iso:std:iso:3166", "Falkland Islands (Malvinas)"),
  _239("239", "urn:iso:std:iso:3166", "South Georgia and the South Sandwich Islands"),
  _242("242", "urn:iso:std:iso:3166", "Fiji"),
  _246("246", "urn:iso:std:iso:3166", "Finland"),
  _248("248", "urn:iso:std:iso:3166", "Eland Islands"),
  _250("250", "urn:iso:std:iso:3166", "France"),
  _254("254", "urn:iso:std:iso:3166", "French Guiana"),
  _258("258", "urn:iso:std:iso:3166", "French Polynesia"),
  _260("260", "urn:iso:std:iso:3166", "French Southern Territories"),
  _262("262", "urn:iso:std:iso:3166", "Djibouti"),
  _266("266", "urn:iso:std:iso:3166", "Gabon"),
  _268("268", "urn:iso:std:iso:3166", "Georgia"),
  _270("270", "urn:iso:std:iso:3166", "Gambia"),
  _275("275", "urn:iso:std:iso:3166", "Palestine, State of"),
  _276("276", "urn:iso:std:iso:3166", "Germany"),
  _288("288", "urn:iso:std:iso:3166", "Ghana"),
  _292("292", "urn:iso:std:iso:3166", "Gibraltar"),
  _296("296", "urn:iso:std:iso:3166", "Kiribati"),
  _300("300", "urn:iso:std:iso:3166", "Greece"),
  _304("304", "urn:iso:std:iso:3166", "Greenland"),
  _308("308", "urn:iso:std:iso:3166", "Grenada"),
  _312("312", "urn:iso:std:iso:3166", "Guadeloupe"),
  _316("316", "urn:iso:std:iso:3166", "Guam"),
  _320("320", "urn:iso:std:iso:3166", "Guatemala"),
  _324("324", "urn:iso:std:iso:3166", "Guinea"),
  _328("328", "urn:iso:std:iso:3166", "Guyana"),
  _332("332", "urn:iso:std:iso:3166", "Haiti"),
  _334("334", "urn:iso:std:iso:3166", "Heard Island and McDonald Islands"),
  _336("336", "urn:iso:std:iso:3166", "Holy See"),
  _340("340", "urn:iso:std:iso:3166", "Honduras"),
  _344("344", "urn:iso:std:iso:3166", "Hong Kong"),
  _348("348", "urn:iso:std:iso:3166", "Hungary"),
  _352("352", "urn:iso:std:iso:3166", "Iceland"),
  _356("356", "urn:iso:std:iso:3166", "India"),
  _360("360", "urn:iso:std:iso:3166", "Indonesia"),
  _364("364", "urn:iso:std:iso:3166", "Iran, Islamic Republic of"),
  _368("368", "urn:iso:std:iso:3166", "Iraq"),
  _372("372", "urn:iso:std:iso:3166", "Ireland"),
  _376("376", "urn:iso:std:iso:3166", "Israel"),
  _380("380", "urn:iso:std:iso:3166", "Italy"),
  _384("384", "urn:iso:std:iso:3166", "Ctte d'Ivoire"),
  _388("388", "urn:iso:std:iso:3166", "Jamaica"),
  _392("392", "urn:iso:std:iso:3166", "Japan"),
  _398("398", "urn:iso:std:iso:3166", "Kazakhstan"),
  _400("400", "urn:iso:std:iso:3166", "Jordan"),
  _404("404", "urn:iso:std:iso:3166", "Kenya"),
  _408("408", "urn:iso:std:iso:3166", "Korea, Democratic People's Republic of"),
  _410("410", "urn:iso:std:iso:3166", "Korea, Republic of"),
  _414("414", "urn:iso:std:iso:3166", "Kuwait"),
  _417("417", "urn:iso:std:iso:3166", "Kyrgyzstan"),
  _418("418", "urn:iso:std:iso:3166", "Lao People's Democratic Republic"),
  _422("422", "urn:iso:std:iso:3166", "Lebanon"),
  _426("426", "urn:iso:std:iso:3166", "Lesotho"),
  _428("428", "urn:iso:std:iso:3166", "Latvia"),
  _430("430", "urn:iso:std:iso:3166", "Liberia"),
  _434("434", "urn:iso:std:iso:3166", "Libya"),
  _438("438", "urn:iso:std:iso:3166", "Liechtenstein"),
  _440("440", "urn:iso:std:iso:3166", "Lithuania"),
  _442("442", "urn:iso:std:iso:3166", "Luxembourg"),
  _446("446", "urn:iso:std:iso:3166", "Macao"),
  _450("450", "urn:iso:std:iso:3166", "Madagascar"),
  _454("454", "urn:iso:std:iso:3166", "Malawi"),
  _458("458", "urn:iso:std:iso:3166", "Malaysia"),
  _462("462", "urn:iso:std:iso:3166", "Maldives"),
  _466("466", "urn:iso:std:iso:3166", "Mali"),
  _470("470", "urn:iso:std:iso:3166", "Malta"),
  _474("474", "urn:iso:std:iso:3166", "Martinique"),
  _478("478", "urn:iso:std:iso:3166", "Mauritania"),
  _480("480", "urn:iso:std:iso:3166", "Mauritius"),
  _484("484", "urn:iso:std:iso:3166", "Mexico"),
  _492("492", "urn:iso:std:iso:3166", "Monaco"),
  _496("496", "urn:iso:std:iso:3166", "Mongolia"),
  _498("498", "urn:iso:std:iso:3166", "Moldova, Republic of"),
  _499("499", "urn:iso:std:iso:3166", "Montenegro"),
  _500("500", "urn:iso:std:iso:3166", "Montserrat"),
  _504("504", "urn:iso:std:iso:3166", "Morocco"),
  _508("508", "urn:iso:std:iso:3166", "Mozambique"),
  _512("512", "urn:iso:std:iso:3166", "Oman"),
  _516("516", "urn:iso:std:iso:3166", "Namibia"),
  _520("520", "urn:iso:std:iso:3166", "Nauru"),
  _524("524", "urn:iso:std:iso:3166", "Nepal"),
  _528("528", "urn:iso:std:iso:3166", "Netherlands"),
  _531("531", "urn:iso:std:iso:3166", "Curagao"),
  _533("533", "urn:iso:std:iso:3166", "Aruba"),
  _534("534", "urn:iso:std:iso:3166", "Sint Maarten (Dutch part)"),
  _535("535", "urn:iso:std:iso:3166", "Bonaire, Sint Eustatius and Saba"),
  _540("540", "urn:iso:std:iso:3166", "New Caledonia"),
  _548("548", "urn:iso:std:iso:3166", "Vanuatu"),
  _554("554", "urn:iso:std:iso:3166", "New Zealand"),
  _558("558", "urn:iso:std:iso:3166", "Nicaragua"),
  _562("562", "urn:iso:std:iso:3166", "Niger"),
  _566("566", "urn:iso:std:iso:3166", "Nigeria"),
  _570("570", "urn:iso:std:iso:3166", "Niue"),
  _574("574", "urn:iso:std:iso:3166", "Norfolk Island"),
  _578("578", "urn:iso:std:iso:3166", "Norway"),
  _580("580", "urn:iso:std:iso:3166", "Northern Mariana Islands"),
  _581("581", "urn:iso:std:iso:3166", "United States Minor Outlying Islands"),
  _583("583", "urn:iso:std:iso:3166", "Micronesia, Federated States of"),
  _584("584", "urn:iso:std:iso:3166", "Marshall Islands"),
  _585("585", "urn:iso:std:iso:3166", "Palau"),
  _586("586", "urn:iso:std:iso:3166", "Pakistan"),
  _591("591", "urn:iso:std:iso:3166", "Panama"),
  _598("598", "urn:iso:std:iso:3166", "Papua New Guinea"),
  _600("600", "urn:iso:std:iso:3166", "Paraguay"),
  _604("604", "urn:iso:std:iso:3166", "Peru"),
  _608("608", "urn:iso:std:iso:3166", "Philippines"),
  _612("612", "urn:iso:std:iso:3166", "Pitcairn"),
  _616("616", "urn:iso:std:iso:3166", "Poland"),
  _620("620", "urn:iso:std:iso:3166", "Portugal"),
  _624("624", "urn:iso:std:iso:3166", "Guinea-Bissau"),
  _626("626", "urn:iso:std:iso:3166", "Timor-Leste"),
  _630("630", "urn:iso:std:iso:3166", "Puerto Rico"),
  _634("634", "urn:iso:std:iso:3166", "Qatar"),
  _638("638", "urn:iso:std:iso:3166", "Riunion"),
  _642("642", "urn:iso:std:iso:3166", "Romania"),
  _643("643", "urn:iso:std:iso:3166", "Russian Federation"),
  _646("646", "urn:iso:std:iso:3166", "Rwanda"),
  _652("652", "urn:iso:std:iso:3166", "Saint Barthilemy"),
  _654("654", "urn:iso:std:iso:3166", "Saint Helena, Ascension and Tristan da Cunha"),
  _659("659", "urn:iso:std:iso:3166", "Saint Kitts and Nevis"),
  _660("660", "urn:iso:std:iso:3166", "Anguilla"),
  _662("662", "urn:iso:std:iso:3166", "Saint Lucia"),
  _663("663", "urn:iso:std:iso:3166", "Saint Martin (French part)"),
  _666("666", "urn:iso:std:iso:3166", "Saint Pierre and Miquelon"),
  _670("670", "urn:iso:std:iso:3166", "Saint Vincent and the Grenadines"),
  _674("674", "urn:iso:std:iso:3166", "San Marino"),
  _678("678", "urn:iso:std:iso:3166", "Sao Tome and Principe"),
  _682("682", "urn:iso:std:iso:3166", "Saudi Arabia"),
  _686("686", "urn:iso:std:iso:3166", "Senegal"),
  _688("688", "urn:iso:std:iso:3166", "Serbia"),
  _690("690", "urn:iso:std:iso:3166", "Seychelles"),
  _694("694", "urn:iso:std:iso:3166", "Sierra Leone"),
  _702("702", "urn:iso:std:iso:3166", "Singapore"),
  _703("703", "urn:iso:std:iso:3166", "Slovakia"),
  _704("704", "urn:iso:std:iso:3166", "Viet Nam"),
  _705("705", "urn:iso:std:iso:3166", "Slovenia"),
  _706("706", "urn:iso:std:iso:3166", "Somalia"),
  _710("710", "urn:iso:std:iso:3166", "South Africa"),
  _716("716", "urn:iso:std:iso:3166", "Zimbabwe"),
  _724("724", "urn:iso:std:iso:3166", "Spain"),
  _728("728", "urn:iso:std:iso:3166", "South Sudan"),
  _729("729", "urn:iso:std:iso:3166", "Sudan"),
  _732("732", "urn:iso:std:iso:3166", "Western Sahara"),
  _740("740", "urn:iso:std:iso:3166", "Suriname"),
  _744("744", "urn:iso:std:iso:3166", "Svalbard and Jan Mayen"),
  _748("748", "urn:iso:std:iso:3166", "Swaziland"),
  _752("752", "urn:iso:std:iso:3166", "Sweden"),
  _756("756", "urn:iso:std:iso:3166", "Switzerland"),
  _760("760", "urn:iso:std:iso:3166", "Syrian Arab Republic"),
  _762("762", "urn:iso:std:iso:3166", "Tajikistan"),
  _764("764", "urn:iso:std:iso:3166", "Thailand"),
  _768("768", "urn:iso:std:iso:3166", "Togo"),
  _772("772", "urn:iso:std:iso:3166", "Tokelau"),
  _776("776", "urn:iso:std:iso:3166", "Tonga"),
  _780("780", "urn:iso:std:iso:3166", "Trinidad and Tobago"),
  _784("784", "urn:iso:std:iso:3166", "United Arab Emirates"),
  _788("788", "urn:iso:std:iso:3166", "Tunisia"),
  _792("792", "urn:iso:std:iso:3166", "Turkey"),
  _795("795", "urn:iso:std:iso:3166", "Turkmenistan"),
  _796("796", "urn:iso:std:iso:3166", "Turks and Caicos Islands"),
  _798("798", "urn:iso:std:iso:3166", "Tuvalu"),
  _800("800", "urn:iso:std:iso:3166", "Uganda"),
  _804("804", "urn:iso:std:iso:3166", "Ukraine"),
  _807("807", "urn:iso:std:iso:3166", "Macedonia, the former Yugoslav Republic of"),
  _818("818", "urn:iso:std:iso:3166", "Egypt"),
  _826("826", "urn:iso:std:iso:3166", "United Kingdom"),
  _831("831", "urn:iso:std:iso:3166", "Guernsey"),
  _832("832", "urn:iso:std:iso:3166", "Jersey"),
  _833("833", "urn:iso:std:iso:3166", "Isle of Man"),
  _834("834", "urn:iso:std:iso:3166", "Tanzania, United Republic of"),
  _840("840", "urn:iso:std:iso:3166", "United States of America"),
  _850("850", "urn:iso:std:iso:3166", "Virgin Islands, U.S."),
  _854("854", "urn:iso:std:iso:3166", "Burkina Faso"),
  _858("858", "urn:iso:std:iso:3166", "Uruguay"),
  _860("860", "urn:iso:std:iso:3166", "Uzbekistan"),
  _862("862", "urn:iso:std:iso:3166", "Venezuela, Bolivarian Republic of"),
  _876("876", "urn:iso:std:iso:3166", "Wallis and Futuna"),
  _882("882", "urn:iso:std:iso:3166", "Samoa"),
  _887("887", "urn:iso:std:iso:3166", "Yemen"),
  _894("894", "urn:iso:std:iso:3166", "Zambia"),
  Af_Bal("AF-BAL", "urn:iso:std:iso:3166:-2", "Balkh"),
  Af_Bam("AF-BAM", "urn:iso:std:iso:3166:-2", "Bāmyān"),
  Af_Bdg("AF-BDG", "urn:iso:std:iso:3166:-2", "Bādghīs"),
  Af_Bds("AF-BDS", "urn:iso:std:iso:3166:-2", "Badakhshān"),
  Af_Bgl("AF-BGL", "urn:iso:std:iso:3166:-2", "Baghlān"),
  Af_Day("AF-DAY", "urn:iso:std:iso:3166:-2", "Dāykundī"),
  Af_Fra("AF-FRA", "urn:iso:std:iso:3166:-2", "Farāh"),
  Af_Fyb("AF-FYB", "urn:iso:std:iso:3166:-2", "Fāryāb"),
  Af_Gha("AF-GHA", "urn:iso:std:iso:3166:-2", "Ghaznī"),
  Af_Gho("AF-GHO", "urn:iso:std:iso:3166:-2", "Ghōr"),
  Af_Hel("AF-HEL", "urn:iso:std:iso:3166:-2", "Helmand"),
  Af_Her("AF-HER", "urn:iso:std:iso:3166:-2", "Herāt"),
  Af_Jow("AF-JOW", "urn:iso:std:iso:3166:-2", "Jowzjān"),
  Af_Kab("AF-KAB", "urn:iso:std:iso:3166:-2", "Kābul"),
  Af_Kan("AF-KAN", "urn:iso:std:iso:3166:-2", "Kandahār"),
  Af_Kap("AF-KAP", "urn:iso:std:iso:3166:-2", "Kāpīsā"),
  Af_Kdz("AF-KDZ", "urn:iso:std:iso:3166:-2", "Kunduz"),
  Af_Kho("AF-KHO", "urn:iso:std:iso:3166:-2", "Khōst"),
  Af_Knr("AF-KNR", "urn:iso:std:iso:3166:-2", "Kunar"),
  Af_Lag("AF-LAG", "urn:iso:std:iso:3166:-2", "Laghmān"),
  Af_Log("AF-LOG", "urn:iso:std:iso:3166:-2", "Lōgar"),
  Af_Nan("AF-NAN", "urn:iso:std:iso:3166:-2", "Nangarhār"),
  Af_Nim("AF-NIM", "urn:iso:std:iso:3166:-2", "Nīmrōz"),
  Af_Nur("AF-NUR", "urn:iso:std:iso:3166:-2", "Nūristān"),
  Af_Pan("AF-PAN", "urn:iso:std:iso:3166:-2", "Panjshayr"),
  Af_Par("AF-PAR", "urn:iso:std:iso:3166:-2", "Parwān"),
  Af_Pia("AF-PIA", "urn:iso:std:iso:3166:-2", "Paktiyā"),
  Af_Pka("AF-PKA", "urn:iso:std:iso:3166:-2", "Paktīkā"),
  Af_Sam("AF-SAM", "urn:iso:std:iso:3166:-2", "Samangān"),
  Af_Sar("AF-SAR", "urn:iso:std:iso:3166:-2", "Sar-e Pul"),
  Af_Tak("AF-TAK", "urn:iso:std:iso:3166:-2", "Takhār"),
  Af_Uru("AF-URU", "urn:iso:std:iso:3166:-2", "Uruzgān"),
  Af_War("AF-WAR", "urn:iso:std:iso:3166:-2", "Wardak"),
  Af_Zab("AF-ZAB", "urn:iso:std:iso:3166:-2", "Zābul"),
  Ax_Ax("AX-AX", "urn:iso:std:iso:3166:-2", "Åland Islands"),
  Al_01("AL-01", "urn:iso:std:iso:3166:-2", "Berat"),
  Al_02("AL-02", "urn:iso:std:iso:3166:-2", "Durrës"),
  Al_03("AL-03", "urn:iso:std:iso:3166:-2", "Elbasan"),
  Al_04("AL-04", "urn:iso:std:iso:3166:-2", "Fier"),
  Al_05("AL-05", "urn:iso:std:iso:3166:-2", "Gjirokastër"),
  Al_06("AL-06", "urn:iso:std:iso:3166:-2", "Korçë"),
  Al_07("AL-07", "urn:iso:std:iso:3166:-2", "Kukës"),
  Al_08("AL-08", "urn:iso:std:iso:3166:-2", "Lezhë"),
  Al_09("AL-09", "urn:iso:std:iso:3166:-2", "Dibër"),
  Al_10("AL-10", "urn:iso:std:iso:3166:-2", "Shkodër"),
  Al_11("AL-11", "urn:iso:std:iso:3166:-2", "Tiranë"),
  Al_12("AL-12", "urn:iso:std:iso:3166:-2", "Vlorë"),
  Al_Br("AL-BR", "urn:iso:std:iso:3166:-2", "Berat"),
  Al_Bu("AL-BU", "urn:iso:std:iso:3166:-2", "Bulqizë"),
  Al_Di("AL-DI", "urn:iso:std:iso:3166:-2", "Dibër"),
  Al_Dl("AL-DL", "urn:iso:std:iso:3166:-2", "Delvinë"),
  Al_Dr("AL-DR", "urn:iso:std:iso:3166:-2", "Durrës"),
  Al_Dv("AL-DV", "urn:iso:std:iso:3166:-2", "Devoll"),
  Al_El("AL-EL", "urn:iso:std:iso:3166:-2", "Elbasan"),
  Al_Er("AL-ER", "urn:iso:std:iso:3166:-2", "Kolonjë"),
  Al_Fr("AL-FR", "urn:iso:std:iso:3166:-2", "Fier"),
  Al_Gj("AL-GJ", "urn:iso:std:iso:3166:-2", "Gjirokastër"),
  Al_Gr("AL-GR", "urn:iso:std:iso:3166:-2", "Gramsh"),
  Al_Ha("AL-HA", "urn:iso:std:iso:3166:-2", "Has"),
  Al_Ka("AL-KA", "urn:iso:std:iso:3166:-2", "Kavajë"),
  Al_Kb("AL-KB", "urn:iso:std:iso:3166:-2", "Kurbin"),
  Al_Kc("AL-KC", "urn:iso:std:iso:3166:-2", "Kuçovë"),
  Al_Ko("AL-KO", "urn:iso:std:iso:3166:-2", "Korçë"),
  Al_Kr("AL-KR", "urn:iso:std:iso:3166:-2", "Krujë"),
  Al_Ku("AL-KU", "urn:iso:std:iso:3166:-2", "Kukës"),
  Al_Lb("AL-LB", "urn:iso:std:iso:3166:-2", "Librazhd"),
  Al_Le("AL-LE", "urn:iso:std:iso:3166:-2", "Lezhë"),
  Al_Lu("AL-LU", "urn:iso:std:iso:3166:-2", "Lushnjë"),
  Al_Mk("AL-MK", "urn:iso:std:iso:3166:-2", "Mallakastër"),
  Al_Mm("AL-MM", "urn:iso:std:iso:3166:-2", "Malësi e Madhe"),
  Al_Mr("AL-MR", "urn:iso:std:iso:3166:-2", "Mirditë"),
  Al_Mt("AL-MT", "urn:iso:std:iso:3166:-2", "Mat"),
  Al_Pg("AL-PG", "urn:iso:std:iso:3166:-2", "Pogradec"),
  Al_Pq("AL-PQ", "urn:iso:std:iso:3166:-2", "Peqin"),
  Al_Pr("AL-PR", "urn:iso:std:iso:3166:-2", "Përmet"),
  Al_Pu("AL-PU", "urn:iso:std:iso:3166:-2", "Pukë"),
  Al_Sh("AL-SH", "urn:iso:std:iso:3166:-2", "Shkodër"),
  Al_Sk("AL-SK", "urn:iso:std:iso:3166:-2", "Skrapar"),
  Al_Sr("AL-SR", "urn:iso:std:iso:3166:-2", "Sarandë"),
  Al_Te("AL-TE", "urn:iso:std:iso:3166:-2", "Tepelenë"),
  Al_Tp("AL-TP", "urn:iso:std:iso:3166:-2", "Tropojë"),
  Al_Tr("AL-TR", "urn:iso:std:iso:3166:-2", "Tiranë"),
  Al_Vl("AL-VL", "urn:iso:std:iso:3166:-2", "Vlorë"),
  Dz_01("DZ-01", "urn:iso:std:iso:3166:-2", "Adrar"),
  Dz_02("DZ-02", "urn:iso:std:iso:3166:-2", "Chlef"),
  Dz_03("DZ-03", "urn:iso:std:iso:3166:-2", "Laghouat"),
  Dz_04("DZ-04", "urn:iso:std:iso:3166:-2", "Oum el Bouaghi"),
  Dz_05("DZ-05", "urn:iso:std:iso:3166:-2", "Batna"),
  Dz_06("DZ-06", "urn:iso:std:iso:3166:-2", "Béjaïa"),
  Dz_07("DZ-07", "urn:iso:std:iso:3166:-2", "Biskra"),
  Dz_08("DZ-08", "urn:iso:std:iso:3166:-2", "Béchar"),
  Dz_09("DZ-09", "urn:iso:std:iso:3166:-2", "Blida"),
  Dz_10("DZ-10", "urn:iso:std:iso:3166:-2", "Bouira"),
  Dz_11("DZ-11", "urn:iso:std:iso:3166:-2", "Tamanrasset"),
  Dz_12("DZ-12", "urn:iso:std:iso:3166:-2", "Tébessa"),
  Dz_13("DZ-13", "urn:iso:std:iso:3166:-2", "Tlemcen"),
  Dz_14("DZ-14", "urn:iso:std:iso:3166:-2", "Tiaret"),
  Dz_15("DZ-15", "urn:iso:std:iso:3166:-2", "Tizi Ouzou"),
  Dz_16("DZ-16", "urn:iso:std:iso:3166:-2", "Alger"),
  Dz_17("DZ-17", "urn:iso:std:iso:3166:-2", "Djelfa"),
  Dz_18("DZ-18", "urn:iso:std:iso:3166:-2", "Jijel"),
  Dz_19("DZ-19", "urn:iso:std:iso:3166:-2", "Sétif"),
  Dz_20("DZ-20", "urn:iso:std:iso:3166:-2", "Saïda"),
  Dz_21("DZ-21", "urn:iso:std:iso:3166:-2", "Skikda"),
  Dz_22("DZ-22", "urn:iso:std:iso:3166:-2", "Sidi Bel Abbès"),
  Dz_23("DZ-23", "urn:iso:std:iso:3166:-2", "Annaba"),
  Dz_24("DZ-24", "urn:iso:std:iso:3166:-2", "Guelma"),
  Dz_25("DZ-25", "urn:iso:std:iso:3166:-2", "Constantine"),
  Dz_26("DZ-26", "urn:iso:std:iso:3166:-2", "Médéa"),
  Dz_27("DZ-27", "urn:iso:std:iso:3166:-2", "Mostaganem"),
  Dz_28("DZ-28", "urn:iso:std:iso:3166:-2", "Msila"),
  Dz_29("DZ-29", "urn:iso:std:iso:3166:-2", "Mascara"),
  Dz_30("DZ-30", "urn:iso:std:iso:3166:-2", "Ouargla"),
  Dz_31("DZ-31", "urn:iso:std:iso:3166:-2", "Oran"),
  Dz_32("DZ-32", "urn:iso:std:iso:3166:-2", "El Bayadh"),
  Dz_33("DZ-33", "urn:iso:std:iso:3166:-2", "Illizi"),
  Dz_34("DZ-34", "urn:iso:std:iso:3166:-2", "Bordj Bou Arréridj"),
  Dz_35("DZ-35", "urn:iso:std:iso:3166:-2", "Boumerdès"),
  Dz_36("DZ-36", "urn:iso:std:iso:3166:-2", "El Tarf"),
  Dz_37("DZ-37", "urn:iso:std:iso:3166:-2", "Tindouf"),
  Dz_38("DZ-38", "urn:iso:std:iso:3166:-2", "Tissemsilt"),
  Dz_39("DZ-39", "urn:iso:std:iso:3166:-2", "El Oued"),
  Dz_40("DZ-40", "urn:iso:std:iso:3166:-2", "Khenchela"),
  Dz_41("DZ-41", "urn:iso:std:iso:3166:-2", "Souk Ahras"),
  Dz_42("DZ-42", "urn:iso:std:iso:3166:-2", "Tipaza"),
  Dz_43("DZ-43", "urn:iso:std:iso:3166:-2", "Mila"),
  Dz_44("DZ-44", "urn:iso:std:iso:3166:-2", "Aïn Defla"),
  Dz_45("DZ-45", "urn:iso:std:iso:3166:-2", "Naama"),
  Dz_46("DZ-46", "urn:iso:std:iso:3166:-2", "Aïn Témouchent"),
  Dz_47("DZ-47", "urn:iso:std:iso:3166:-2", "Ghardaïa"),
  Dz_48("DZ-48", "urn:iso:std:iso:3166:-2", "Relizane"),
  As_As("AS-AS", "urn:iso:std:iso:3166:-2", "American Samoa"),
  Ad_02("AD-02", "urn:iso:std:iso:3166:-2", "Canillo"),
  Ad_03("AD-03", "urn:iso:std:iso:3166:-2", "Encamp"),
  Ad_04("AD-04", "urn:iso:std:iso:3166:-2", "La Massana"),
  Ad_05("AD-05", "urn:iso:std:iso:3166:-2", "Ordino"),
  Ad_06("AD-06", "urn:iso:std:iso:3166:-2", "Sant Julià de Lòria"),
  Ad_07("AD-07", "urn:iso:std:iso:3166:-2", "Andorra la Vella"),
  Ad_08("AD-08", "urn:iso:std:iso:3166:-2", "Escaldes-Engordany"),
  Ao_Bgo("AO-BGO", "urn:iso:std:iso:3166:-2", "Bengo"),
  Ao_Bgu("AO-BGU", "urn:iso:std:iso:3166:-2", "Benguela"),
  Ao_Bie("AO-BIE", "urn:iso:std:iso:3166:-2", "Bié"),
  Ao_Cab("AO-CAB", "urn:iso:std:iso:3166:-2", "Cabinda"),
  Ao_Ccu("AO-CCU", "urn:iso:std:iso:3166:-2", "Kuando Kubango"),
  Ao_Cnn("AO-CNN", "urn:iso:std:iso:3166:-2", "Cunene"),
  Ao_Cno("AO-CNO", "urn:iso:std:iso:3166:-2", "Kwanza Norte"),
  Ao_Cus("AO-CUS", "urn:iso:std:iso:3166:-2", "Kwanza Sul"),
  Ao_Hua("AO-HUA", "urn:iso:std:iso:3166:-2", "Huambo"),
  Ao_Hui("AO-HUI", "urn:iso:std:iso:3166:-2", "Huíla"),
  Ao_Lno("AO-LNO", "urn:iso:std:iso:3166:-2", "Lunda Norte"),
  Ao_Lsu("AO-LSU", "urn:iso:std:iso:3166:-2", "Lunda Sul"),
  Ao_Lua("AO-LUA", "urn:iso:std:iso:3166:-2", "Luanda"),
  Ao_Mal("AO-MAL", "urn:iso:std:iso:3166:-2", "Malange"),
  Ao_Mox("AO-MOX", "urn:iso:std:iso:3166:-2", "Moxico"),
  Ao_Nam("AO-NAM", "urn:iso:std:iso:3166:-2", "Namibe"),
  Ao_Uig("AO-UIG", "urn:iso:std:iso:3166:-2", "Uíge"),
  Ao_Zai("AO-ZAI", "urn:iso:std:iso:3166:-2", "Zaire"),
  Ai_Ai("AI-AI", "urn:iso:std:iso:3166:-2", "Anguilla"),
  Aq_Aq("AQ-AQ", "urn:iso:std:iso:3166:-2", "Antarctica"),
  Ag_03("AG-03", "urn:iso:std:iso:3166:-2", "Saint George"),
  Ag_04("AG-04", "urn:iso:std:iso:3166:-2", "Saint John"),
  Ag_05("AG-05", "urn:iso:std:iso:3166:-2", "Saint Mary"),
  Ag_06("AG-06", "urn:iso:std:iso:3166:-2", "Saint Paul"),
  Ag_07("AG-07", "urn:iso:std:iso:3166:-2", "Saint Peter"),
  Ag_08("AG-08", "urn:iso:std:iso:3166:-2", "Saint Philip"),
  Ag_10("AG-10", "urn:iso:std:iso:3166:-2", "Barbuda"),
  Ag_11("AG-11", "urn:iso:std:iso:3166:-2", "Redonda"),
  Ar_A("AR-A", "urn:iso:std:iso:3166:-2", "Salta"),
  Ar_B("AR-B", "urn:iso:std:iso:3166:-2", "Buenos Aires"),
  Ar_C("AR-C", "urn:iso:std:iso:3166:-2", "Ciudad Autónoma de Buenos Aires"),
  Ar_D("AR-D", "urn:iso:std:iso:3166:-2", "San Luis"),
  Ar_E("AR-E", "urn:iso:std:iso:3166:-2", "Entre Ríos"),
  Ar_F("AR-F", "urn:iso:std:iso:3166:-2", "La Rioja"),
  Ar_G("AR-G", "urn:iso:std:iso:3166:-2", "Santiago del Estero"),
  Ar_H("AR-H", "urn:iso:std:iso:3166:-2", "Chaco"),
  Ar_J("AR-J", "urn:iso:std:iso:3166:-2", "San Juan"),
  Ar_K("AR-K", "urn:iso:std:iso:3166:-2", "Catamarca"),
  Ar_L("AR-L", "urn:iso:std:iso:3166:-2", "La Pampa"),
  Ar_M("AR-M", "urn:iso:std:iso:3166:-2", "Mendoza"),
  Ar_N("AR-N", "urn:iso:std:iso:3166:-2", "Misiones"),
  Ar_P("AR-P", "urn:iso:std:iso:3166:-2", "Formosa"),
  Ar_Q("AR-Q", "urn:iso:std:iso:3166:-2", "Neuquén"),
  Ar_R("AR-R", "urn:iso:std:iso:3166:-2", "Río Negro"),
  Ar_S("AR-S", "urn:iso:std:iso:3166:-2", "Santa Fe"),
  Ar_T("AR-T", "urn:iso:std:iso:3166:-2", "Tucumán"),
  Ar_U("AR-U", "urn:iso:std:iso:3166:-2", "Chubut"),
  Ar_V("AR-V", "urn:iso:std:iso:3166:-2", "Tierra del Fuego"),
  Ar_W("AR-W", "urn:iso:std:iso:3166:-2", "Corrientes"),
  Ar_X("AR-X", "urn:iso:std:iso:3166:-2", "Córdoba"),
  Ar_Y("AR-Y", "urn:iso:std:iso:3166:-2", "Jujuy"),
  Ar_Z("AR-Z", "urn:iso:std:iso:3166:-2", "Santa Cruz"),
  Am_Ag("AM-AG", "urn:iso:std:iso:3166:-2", "Aragac̣otn"),
  Am_Ar("AM-AR", "urn:iso:std:iso:3166:-2", "Ararat"),
  Am_Av("AM-AV", "urn:iso:std:iso:3166:-2", "Armavir"),
  Am_Er("AM-ER", "urn:iso:std:iso:3166:-2", "Erevan"),
  Am_Gr("AM-GR", "urn:iso:std:iso:3166:-2", "Geġark'unik'"),
  Am_Kt("AM-KT", "urn:iso:std:iso:3166:-2", "Kotayk'"),
  Am_Lo("AM-LO", "urn:iso:std:iso:3166:-2", "Loṙi"),
  Am_Sh("AM-SH", "urn:iso:std:iso:3166:-2", "Širak"),
  Am_Su("AM-SU", "urn:iso:std:iso:3166:-2", "Syunik'"),
  Am_Tv("AM-TV", "urn:iso:std:iso:3166:-2", "Tavuš"),
  Am_Vd("AM-VD", "urn:iso:std:iso:3166:-2", "Vayoć Jor"),
  Aw_Aw("AW-AW", "urn:iso:std:iso:3166:-2", "Aruba"),
  Au_Act("AU-ACT", "urn:iso:std:iso:3166:-2", "Australian Capital Territory"),
  Au_Nsw("AU-NSW", "urn:iso:std:iso:3166:-2", "New South Wales"),
  Au_Nt("AU-NT", "urn:iso:std:iso:3166:-2", "Northern Territory"),
  Au_Qld("AU-QLD", "urn:iso:std:iso:3166:-2", "Queensland"),
  Au_Sa("AU-SA", "urn:iso:std:iso:3166:-2", "South Australia"),
  Au_Tas("AU-TAS", "urn:iso:std:iso:3166:-2", "Tasmania"),
  Au_Vic("AU-VIC", "urn:iso:std:iso:3166:-2", "Victoria"),
  Au_Wa("AU-WA", "urn:iso:std:iso:3166:-2", "Western Australia"),
  At_1("AT-1", "urn:iso:std:iso:3166:-2", "Burgenland"),
  At_2("AT-2", "urn:iso:std:iso:3166:-2", "Kärnten"),
  At_3("AT-3", "urn:iso:std:iso:3166:-2", "Niederösterreich"),
  At_4("AT-4", "urn:iso:std:iso:3166:-2", "Oberösterreich"),
  At_5("AT-5", "urn:iso:std:iso:3166:-2", "Salzburg"),
  At_6("AT-6", "urn:iso:std:iso:3166:-2", "Steiermark"),
  At_7("AT-7", "urn:iso:std:iso:3166:-2", "Tirol"),
  At_8("AT-8", "urn:iso:std:iso:3166:-2", "Vorarlberg"),
  At_9("AT-9", "urn:iso:std:iso:3166:-2", "Wien"),
  Az_Abs("AZ-ABS", "urn:iso:std:iso:3166:-2", "Abşeron"),
  Az_Aga("AZ-AGA", "urn:iso:std:iso:3166:-2", "Ağstafa"),
  Az_Agc("AZ-AGC", "urn:iso:std:iso:3166:-2", "Ağcabәdi"),
  Az_Agm("AZ-AGM", "urn:iso:std:iso:3166:-2", "Ağdam"),
  Az_Ags("AZ-AGS", "urn:iso:std:iso:3166:-2", "Ağdaş"),
  Az_Agu("AZ-AGU", "urn:iso:std:iso:3166:-2", "Ağsu"),
  Az_Ast("AZ-AST", "urn:iso:std:iso:3166:-2", "Astara"),
  Az_Ba("AZ-BA", "urn:iso:std:iso:3166:-2", "Bakı"),
  Az_Bab("AZ-BAB", "urn:iso:std:iso:3166:-2", "Babək"),
  Az_Bal("AZ-BAL", "urn:iso:std:iso:3166:-2", "Balakən"),
  Az_Bar("AZ-BAR", "urn:iso:std:iso:3166:-2", "Bərdə"),
  Az_Bey("AZ-BEY", "urn:iso:std:iso:3166:-2", "Beyləqan"),
  Az_Bil("AZ-BIL", "urn:iso:std:iso:3166:-2", "Biləsuvar"),
  Az_Cab("AZ-CAB", "urn:iso:std:iso:3166:-2", "Cəbrayıl"),
  Az_Cal("AZ-CAL", "urn:iso:std:iso:3166:-2", "Cəlilabad"),
  Az_Cul("AZ-CUL", "urn:iso:std:iso:3166:-2", "Culfa"),
  Az_Das("AZ-DAS", "urn:iso:std:iso:3166:-2", "Daşkəsən"),
  Az_Fuz("AZ-FUZ", "urn:iso:std:iso:3166:-2", "Füzuli"),
  Az_Gad("AZ-GAD", "urn:iso:std:iso:3166:-2", "Gədəbəy"),
  Az_Ga("AZ-GA", "urn:iso:std:iso:3166:-2", "Gәncә"),
  Az_Gor("AZ-GOR", "urn:iso:std:iso:3166:-2", "Goranboy"),
  Az_Goy("AZ-GOY", "urn:iso:std:iso:3166:-2", "Göyçay"),
  Az_Gyg("AZ-GYG", "urn:iso:std:iso:3166:-2", "Göygöl"),
  Az_Hac("AZ-HAC", "urn:iso:std:iso:3166:-2", "Hacıqabul"),
  Az_Imi("AZ-IMI", "urn:iso:std:iso:3166:-2", "İmişli"),
  Az_Ism("AZ-ISM", "urn:iso:std:iso:3166:-2", "İsmayıllı"),
  Az_Kal("AZ-KAL", "urn:iso:std:iso:3166:-2", "Kəlbəcər"),
  Az_Kan("AZ-KAN", "urn:iso:std:iso:3166:-2", "Kǝngǝrli"),
  Az_Kur("AZ-KUR", "urn:iso:std:iso:3166:-2", "Kürdəmir"),
  Az_Lac("AZ-LAC", "urn:iso:std:iso:3166:-2", "Laçın"),
  Az_La("AZ-LA", "urn:iso:std:iso:3166:-2", "Lәnkәran"),
  Az_Lan("AZ-LAN", "urn:iso:std:iso:3166:-2", "Lənkəran"),
  Az_Ler("AZ-LER", "urn:iso:std:iso:3166:-2", "Lerik"),
  Az_Mas("AZ-MAS", "urn:iso:std:iso:3166:-2", "Masallı"),
  Az_Mi("AZ-MI", "urn:iso:std:iso:3166:-2", "Mingәçevir"),
  Az_Na("AZ-NA", "urn:iso:std:iso:3166:-2", "Naftalan"),
  Az_Nef("AZ-NEF", "urn:iso:std:iso:3166:-2", "Neftçala"),
  Az_Nv("AZ-NV", "urn:iso:std:iso:3166:-2", "Naxçıvan"),
  Az_Nx("AZ-NX", "urn:iso:std:iso:3166:-2", "Naxçıvan"),
  Az_Ogu("AZ-OGU", "urn:iso:std:iso:3166:-2", "Oğuz"),
  Az_Ord("AZ-ORD", "urn:iso:std:iso:3166:-2", "Ordubad"),
  Az_Qab("AZ-QAB", "urn:iso:std:iso:3166:-2", "Qәbәlә"),
  Az_Qax("AZ-QAX", "urn:iso:std:iso:3166:-2", "Qax"),
  Az_Qaz("AZ-QAZ", "urn:iso:std:iso:3166:-2", "Qazax"),
  Az_Qba("AZ-QBA", "urn:iso:std:iso:3166:-2", "Quba"),
  Az_Qbi("AZ-QBI", "urn:iso:std:iso:3166:-2", "Qubadlı"),
  Az_Qob("AZ-QOB", "urn:iso:std:iso:3166:-2", "Qobustan"),
  Az_Qus("AZ-QUS", "urn:iso:std:iso:3166:-2", "Qusar"),
  Az_Sab("AZ-SAB", "urn:iso:std:iso:3166:-2", "Sabirabad"),
  Az_Sad("AZ-SAD", "urn:iso:std:iso:3166:-2", "Sәdәrәk"),
  Az_Sah("AZ-SAH", "urn:iso:std:iso:3166:-2", "Şahbuz"),
  Az_Sak("AZ-SAK", "urn:iso:std:iso:3166:-2", "Şәki"),
  Az_Sal("AZ-SAL", "urn:iso:std:iso:3166:-2", "Salyan"),
  Az_Sar("AZ-SAR", "urn:iso:std:iso:3166:-2", "Şәrur"),
  Az_Sa("AZ-SA", "urn:iso:std:iso:3166:-2", "Şәki"),
  Az_Sat("AZ-SAT", "urn:iso:std:iso:3166:-2", "Saatlı"),
  Az_Sbn("AZ-SBN", "urn:iso:std:iso:3166:-2", "Şabran"),
  Az_Siy("AZ-SIY", "urn:iso:std:iso:3166:-2", "Siyәzәn"),
  Az_Skr("AZ-SKR", "urn:iso:std:iso:3166:-2", "Şәmkir"),
  Az_Smi("AZ-SMI", "urn:iso:std:iso:3166:-2", "Şamaxı"),
  Az_Sm("AZ-SM", "urn:iso:std:iso:3166:-2", "Sumqayıt"),
  Az_Smx("AZ-SMX", "urn:iso:std:iso:3166:-2", "Samux"),
  Az_Sr("AZ-SR", "urn:iso:std:iso:3166:-2", "Şirvan"),
  Az_Sus("AZ-SUS", "urn:iso:std:iso:3166:-2", "Şuşa"),
  Az_Tar("AZ-TAR", "urn:iso:std:iso:3166:-2", "Tәrtәr"),
  Az_Tov("AZ-TOV", "urn:iso:std:iso:3166:-2", "Tovuz"),
  Az_Uca("AZ-UCA", "urn:iso:std:iso:3166:-2", "Ucar"),
  Az_Xac("AZ-XAC", "urn:iso:std:iso:3166:-2", "Xaçmaz"),
  Az_Xa("AZ-XA", "urn:iso:std:iso:3166:-2", "Xankәndi"),
  Az_Xci("AZ-XCI", "urn:iso:std:iso:3166:-2", "Xocalı"),
  Az_Xiz("AZ-XIZ", "urn:iso:std:iso:3166:-2", "Xızı"),
  Az_Xvd("AZ-XVD", "urn:iso:std:iso:3166:-2", "Xocavәnd"),
  Az_Yar("AZ-YAR", "urn:iso:std:iso:3166:-2", "Yardımlı"),
  Az_Yev("AZ-YEV", "urn:iso:std:iso:3166:-2", "Yevlax"),
  Az_Ye("AZ-YE", "urn:iso:std:iso:3166:-2", "Yevlax"),
  Az_Zan("AZ-ZAN", "urn:iso:std:iso:3166:-2", "Zәngilan"),
  Az_Zaq("AZ-ZAQ", "urn:iso:std:iso:3166:-2", "Zaqatala"),
  Az_Zar("AZ-ZAR", "urn:iso:std:iso:3166:-2", "Zәrdab"),
  Bs_Ak("BS-AK", "urn:iso:std:iso:3166:-2", "Acklins"),
  Bs_Bi("BS-BI", "urn:iso:std:iso:3166:-2", "Bimini"),
  Bs_Bp("BS-BP", "urn:iso:std:iso:3166:-2", "Black Point"),
  Bs_By("BS-BY", "urn:iso:std:iso:3166:-2", "Berry Islands"),
  Bs_Ce("BS-CE", "urn:iso:std:iso:3166:-2", "Central Eleuthera"),
  Bs_Ci("BS-CI", "urn:iso:std:iso:3166:-2", "Cat Island"),
  Bs_Ck("BS-CK", "urn:iso:std:iso:3166:-2", "Crooked Island and Long Cay"),
  Bs_Co("BS-CO", "urn:iso:std:iso:3166:-2", "Central Abaco"),
  Bs_Cs("BS-CS", "urn:iso:std:iso:3166:-2", "Central Andros"),
  Bs_Eg("BS-EG", "urn:iso:std:iso:3166:-2", "East Grand Bahama"),
  Bs_Ex("BS-EX", "urn:iso:std:iso:3166:-2", "Exuma"),
  Bs_Fp("BS-FP", "urn:iso:std:iso:3166:-2", "City of Freeport"),
  Bs_Gc("BS-GC", "urn:iso:std:iso:3166:-2", "Grand Cay"),
  Bs_Hi("BS-HI", "urn:iso:std:iso:3166:-2", "Harbour Island"),
  Bs_Ht("BS-HT", "urn:iso:std:iso:3166:-2", "Hope Town"),
  Bs_In("BS-IN", "urn:iso:std:iso:3166:-2", "Inagua"),
  Bs_Li("BS-LI", "urn:iso:std:iso:3166:-2", "Long Island"),
  Bs_Mc("BS-MC", "urn:iso:std:iso:3166:-2", "Mangrove Cay"),
  Bs_Mg("BS-MG", "urn:iso:std:iso:3166:-2", "Mayaguana"),
  Bs_Mi("BS-MI", "urn:iso:std:iso:3166:-2", "Moore's Island"),
  Bs_Ne("BS-NE", "urn:iso:std:iso:3166:-2", "North Eleuthera"),
  Bs_No("BS-NO", "urn:iso:std:iso:3166:-2", "North Abaco"),
  Bs_Ns("BS-NS", "urn:iso:std:iso:3166:-2", "North Andros"),
  Bs_Rc("BS-RC", "urn:iso:std:iso:3166:-2", "Rum Cay"),
  Bs_Ri("BS-RI", "urn:iso:std:iso:3166:-2", "Ragged Island"),
  Bs_Sa("BS-SA", "urn:iso:std:iso:3166:-2", "South Andros"),
  Bs_Se("BS-SE", "urn:iso:std:iso:3166:-2", "South Eleuthera"),
  Bs_So("BS-SO", "urn:iso:std:iso:3166:-2", "South Abaco"),
  Bs_Ss("BS-SS", "urn:iso:std:iso:3166:-2", "San Salvador"),
  Bs_Sw("BS-SW", "urn:iso:std:iso:3166:-2", "Spanish Wells"),
  Bs_Wg("BS-WG", "urn:iso:std:iso:3166:-2", "West Grand Bahama"),
  Bh_13("BH-13", "urn:iso:std:iso:3166:-2", "Al Manāmah"),
  Bh_14("BH-14", "urn:iso:std:iso:3166:-2", "Al Janūbīyah"),
  Bh_15("BH-15", "urn:iso:std:iso:3166:-2", "Al Muḩarraq"),
  Bh_16("BH-16", "urn:iso:std:iso:3166:-2", "Al Wusţá"),
  Bh_17("BH-17", "urn:iso:std:iso:3166:-2", "Ash Shamālīyah"),
  Bd_01("BD-01", "urn:iso:std:iso:3166:-2", "Bandarban"),
  Bd_02("BD-02", "urn:iso:std:iso:3166:-2", "Barguna"),
  Bd_03("BD-03", "urn:iso:std:iso:3166:-2", "Bogra"),
  Bd_04("BD-04", "urn:iso:std:iso:3166:-2", "Brahmanbaria"),
  Bd_05("BD-05", "urn:iso:std:iso:3166:-2", "Bagerhat"),
  Bd_06("BD-06", "urn:iso:std:iso:3166:-2", "Barisal"),
  Bd_07("BD-07", "urn:iso:std:iso:3166:-2", "Bhola"),
  Bd_08("BD-08", "urn:iso:std:iso:3166:-2", "Comilla"),
  Bd_09("BD-09", "urn:iso:std:iso:3166:-2", "Chandpur"),
  Bd_10("BD-10", "urn:iso:std:iso:3166:-2", "Chittagong"),
  Bd_11("BD-11", "urn:iso:std:iso:3166:-2", "Cox's Bazar"),
  Bd_12("BD-12", "urn:iso:std:iso:3166:-2", "Chuadanga"),
  Bd_13("BD-13", "urn:iso:std:iso:3166:-2", "Dhaka"),
  Bd_14("BD-14", "urn:iso:std:iso:3166:-2", "Dinajpur"),
  Bd_15("BD-15", "urn:iso:std:iso:3166:-2", "Faridpur"),
  Bd_16("BD-16", "urn:iso:std:iso:3166:-2", "Feni"),
  Bd_17("BD-17", "urn:iso:std:iso:3166:-2", "Gopalganj"),
  Bd_18("BD-18", "urn:iso:std:iso:3166:-2", "Gazipur"),
  Bd_19("BD-19", "urn:iso:std:iso:3166:-2", "Gaibandha"),
  Bd_20("BD-20", "urn:iso:std:iso:3166:-2", "Habiganj"),
  Bd_21("BD-21", "urn:iso:std:iso:3166:-2", "Jamalpur"),
  Bd_22("BD-22", "urn:iso:std:iso:3166:-2", "Jessore"),
  Bd_23("BD-23", "urn:iso:std:iso:3166:-2", "Jhenaidah"),
  Bd_24("BD-24", "urn:iso:std:iso:3166:-2", "Jaipurhat"),
  Bd_25("BD-25", "urn:iso:std:iso:3166:-2", "Jhalakati"),
  Bd_26("BD-26", "urn:iso:std:iso:3166:-2", "Kishoreganj"),
  Bd_27("BD-27", "urn:iso:std:iso:3166:-2", "Khulna"),
  Bd_28("BD-28", "urn:iso:std:iso:3166:-2", "Kurigram"),
  Bd_29("BD-29", "urn:iso:std:iso:3166:-2", "Khagrachari"),
  Bd_30("BD-30", "urn:iso:std:iso:3166:-2", "Kushtia"),
  Bd_31("BD-31", "urn:iso:std:iso:3166:-2", "Lakshmipur"),
  Bd_32("BD-32", "urn:iso:std:iso:3166:-2", "Lalmonirhat"),
  Bd_33("BD-33", "urn:iso:std:iso:3166:-2", "Manikganj"),
  Bd_34("BD-34", "urn:iso:std:iso:3166:-2", "Mymensingh"),
  Bd_35("BD-35", "urn:iso:std:iso:3166:-2", "Munshiganj"),
  Bd_36("BD-36", "urn:iso:std:iso:3166:-2", "Madaripur"),
  Bd_37("BD-37", "urn:iso:std:iso:3166:-2", "Magura"),
  Bd_38("BD-38", "urn:iso:std:iso:3166:-2", "Moulvibazar"),
  Bd_39("BD-39", "urn:iso:std:iso:3166:-2", "Meherpur"),
  Bd_40("BD-40", "urn:iso:std:iso:3166:-2", "Narayanganj"),
  Bd_41("BD-41", "urn:iso:std:iso:3166:-2", "Netrakona"),
  Bd_42("BD-42", "urn:iso:std:iso:3166:-2", "Narsingdi"),
  Bd_43("BD-43", "urn:iso:std:iso:3166:-2", "Narail"),
  Bd_44("BD-44", "urn:iso:std:iso:3166:-2", "Natore"),
  Bd_45("BD-45", "urn:iso:std:iso:3166:-2", "Nawabganj"),
  Bd_46("BD-46", "urn:iso:std:iso:3166:-2", "Nilphamari"),
  Bd_47("BD-47", "urn:iso:std:iso:3166:-2", "Noakhali"),
  Bd_48("BD-48", "urn:iso:std:iso:3166:-2", "Naogaon"),
  Bd_49("BD-49", "urn:iso:std:iso:3166:-2", "Pabna"),
  Bd_50("BD-50", "urn:iso:std:iso:3166:-2", "Pirojpur"),
  Bd_51("BD-51", "urn:iso:std:iso:3166:-2", "Patuakhali"),
  Bd_52("BD-52", "urn:iso:std:iso:3166:-2", "Panchagarh"),
  Bd_53("BD-53", "urn:iso:std:iso:3166:-2", "Rajbari"),
  Bd_54("BD-54", "urn:iso:std:iso:3166:-2", "Rajshahi"),
  Bd_55("BD-55", "urn:iso:std:iso:3166:-2", "Rangpur"),
  Bd_56("BD-56", "urn:iso:std:iso:3166:-2", "Rangamati"),
  Bd_57("BD-57", "urn:iso:std:iso:3166:-2", "Sherpur"),
  Bd_58("BD-58", "urn:iso:std:iso:3166:-2", "Satkhira"),
  Bd_59("BD-59", "urn:iso:std:iso:3166:-2", "Sirajganj"),
  Bd_60("BD-60", "urn:iso:std:iso:3166:-2", "Sylhet"),
  Bd_61("BD-61", "urn:iso:std:iso:3166:-2", "Sunamganj"),
  Bd_62("BD-62", "urn:iso:std:iso:3166:-2", "Shariatpur"),
  Bd_63("BD-63", "urn:iso:std:iso:3166:-2", "Tangail"),
  Bd_64("BD-64", "urn:iso:std:iso:3166:-2", "Thakurgaon"),
  Bd_A("BD-A", "urn:iso:std:iso:3166:-2", "Barisal"),
  Bd_B("BD-B", "urn:iso:std:iso:3166:-2", "Chittagong"),
  Bd_C("BD-C", "urn:iso:std:iso:3166:-2", "Dhaka"),
  Bd_D("BD-D", "urn:iso:std:iso:3166:-2", "Khulna"),
  Bd_E("BD-E", "urn:iso:std:iso:3166:-2", "Rajshahi"),
  Bd_F("BD-F", "urn:iso:std:iso:3166:-2", "Rangpur"),
  Bd_G("BD-G", "urn:iso:std:iso:3166:-2", "Sylhet"),
  Bb_01("BB-01", "urn:iso:std:iso:3166:-2", "Christ Church"),
  Bb_02("BB-02", "urn:iso:std:iso:3166:-2", "Saint Andrew"),
  Bb_03("BB-03", "urn:iso:std:iso:3166:-2", "Saint George"),
  Bb_04("BB-04", "urn:iso:std:iso:3166:-2", "Saint James"),
  Bb_05("BB-05", "urn:iso:std:iso:3166:-2", "Saint John"),
  Bb_06("BB-06", "urn:iso:std:iso:3166:-2", "Saint Joseph"),
  Bb_07("BB-07", "urn:iso:std:iso:3166:-2", "Saint Lucy"),
  Bb_08("BB-08", "urn:iso:std:iso:3166:-2", "Saint Michael"),
  Bb_09("BB-09", "urn:iso:std:iso:3166:-2", "Saint Peter"),
  Bb_10("BB-10", "urn:iso:std:iso:3166:-2", "Saint Philip"),
  Bb_11("BB-11", "urn:iso:std:iso:3166:-2", "Saint Thomas"),
  By_Br("BY-BR", "urn:iso:std:iso:3166:-2", "Bresckaja voblasć"),
  By_Hm("BY-HM", "urn:iso:std:iso:3166:-2", "Gorod Minsk"),
  By_Ho("BY-HO", "urn:iso:std:iso:3166:-2", "Gomel'skaja oblast'"),
  By_Hr("BY-HR", "urn:iso:std:iso:3166:-2", "Grodnenskaja oblast'"),
  By_Ma("BY-MA", "urn:iso:std:iso:3166:-2", "Mahilioŭskaja voblasć"),
  By_Mi("BY-MI", "urn:iso:std:iso:3166:-2", "Minskaja oblast'"),
  By_Vi("BY-VI", "urn:iso:std:iso:3166:-2", "Viciebskaja voblasć"),
  Be_Bru("BE-BRU", "urn:iso:std:iso:3166:-2", "Brussels Hoofdstedelijk Gewest"),
  Be_Van("BE-VAN", "urn:iso:std:iso:3166:-2", "Antwerpen"),
  Be_Vbr("BE-VBR", "urn:iso:std:iso:3166:-2", "Vlaams-Brabant"),
  Be_Vlg("BE-VLG", "urn:iso:std:iso:3166:-2", "Vlaams Gewest"),
  Be_Vli("BE-VLI", "urn:iso:std:iso:3166:-2", "Limburg"),
  Be_Vov("BE-VOV", "urn:iso:std:iso:3166:-2", "Oost-Vlaanderen"),
  Be_Vwv("BE-VWV", "urn:iso:std:iso:3166:-2", "West-Vlaanderen"),
  Be_Wal("BE-WAL", "urn:iso:std:iso:3166:-2", "wallonne, Région"),
  Be_Wbr("BE-WBR", "urn:iso:std:iso:3166:-2", "Brabant wallon"),
  Be_Wht("BE-WHT", "urn:iso:std:iso:3166:-2", "Hainaut"),
  Be_Wlg("BE-WLG", "urn:iso:std:iso:3166:-2", "Liège"),
  Be_Wlx("BE-WLX", "urn:iso:std:iso:3166:-2", "Luxembourg"),
  Be_Wna("BE-WNA", "urn:iso:std:iso:3166:-2", "Namur"),
  Bz_Bz("BZ-BZ", "urn:iso:std:iso:3166:-2", "Belize"),
  Bz_Cy("BZ-CY", "urn:iso:std:iso:3166:-2", "Cayo"),
  Bz_Czl("BZ-CZL", "urn:iso:std:iso:3166:-2", "Corozal"),
  Bz_Ow("BZ-OW", "urn:iso:std:iso:3166:-2", "Orange Walk"),
  Bz_Sc("BZ-SC", "urn:iso:std:iso:3166:-2", "Stann Creek"),
  Bz_Tol("BZ-TOL", "urn:iso:std:iso:3166:-2", "Toledo"),
  Bj_Ak("BJ-AK", "urn:iso:std:iso:3166:-2", "Atakora"),
  Bj_Al("BJ-AL", "urn:iso:std:iso:3166:-2", "Alibori"),
  Bj_Aq("BJ-AQ", "urn:iso:std:iso:3166:-2", "Atlantique"),
  Bj_Bo("BJ-BO", "urn:iso:std:iso:3166:-2", "Borgou"),
  Bj_Co("BJ-CO", "urn:iso:std:iso:3166:-2", "Collines"),
  Bj_Do("BJ-DO", "urn:iso:std:iso:3166:-2", "Donga"),
  Bj_Ko("BJ-KO", "urn:iso:std:iso:3166:-2", "Kouffo"),
  Bj_Li("BJ-LI", "urn:iso:std:iso:3166:-2", "Littoral"),
  Bj_Mo("BJ-MO", "urn:iso:std:iso:3166:-2", "Mono"),
  Bj_Ou("BJ-OU", "urn:iso:std:iso:3166:-2", "Ouémé"),
  Bj_Pl("BJ-PL", "urn:iso:std:iso:3166:-2", "Plateau"),
  Bj_Zo("BJ-ZO", "urn:iso:std:iso:3166:-2", "Zou"),
  Bm_Bm("BM-BM", "urn:iso:std:iso:3166:-2", "Bermuda"),
  Bt_11("BT-11", "urn:iso:std:iso:3166:-2", "Paro"),
  Bt_12("BT-12", "urn:iso:std:iso:3166:-2", "Chhukha"),
  Bt_13("BT-13", "urn:iso:std:iso:3166:-2", "Ha"),
  Bt_14("BT-14", "urn:iso:std:iso:3166:-2", "Samtse"),
  Bt_15("BT-15", "urn:iso:std:iso:3166:-2", "Thimphu"),
  Bt_21("BT-21", "urn:iso:std:iso:3166:-2", "Tsirang"),
  Bt_22("BT-22", "urn:iso:std:iso:3166:-2", "Dagana"),
  Bt_23("BT-23", "urn:iso:std:iso:3166:-2", "Punakha"),
  Bt_24("BT-24", "urn:iso:std:iso:3166:-2", "Wangdue Phodrang"),
  Bt_31("BT-31", "urn:iso:std:iso:3166:-2", "Sarpang"),
  Bt_32("BT-32", "urn:iso:std:iso:3166:-2", "Trongsa"),
  Bt_33("BT-33", "urn:iso:std:iso:3166:-2", "Bumthang"),
  Bt_34("BT-34", "urn:iso:std:iso:3166:-2", "Zhemgang"),
  Bt_41("BT-41", "urn:iso:std:iso:3166:-2", "Trashigang"),
  Bt_42("BT-42", "urn:iso:std:iso:3166:-2", "Monggar"),
  Bt_43("BT-43", "urn:iso:std:iso:3166:-2", "Pemagatshel"),
  Bt_44("BT-44", "urn:iso:std:iso:3166:-2", "Lhuentse"),
  Bt_45("BT-45", "urn:iso:std:iso:3166:-2", "Samdrup Jongkha"),
  Bt_Ga("BT-GA", "urn:iso:std:iso:3166:-2", "Gasa"),
  Bt_Ty("BT-TY", "urn:iso:std:iso:3166:-2", "Trashi Yangtse"),
  Bo_B("BO-B", "urn:iso:std:iso:3166:-2", "El Beni"),
  Bo_C("BO-C", "urn:iso:std:iso:3166:-2", "Cochabamba"),
  Bo_H("BO-H", "urn:iso:std:iso:3166:-2", "Chuquisaca"),
  Bo_L("BO-L", "urn:iso:std:iso:3166:-2", "La Paz"),
  Bo_N("BO-N", "urn:iso:std:iso:3166:-2", "Pando"),
  Bo_O("BO-O", "urn:iso:std:iso:3166:-2", "Oruro"),
  Bo_P("BO-P", "urn:iso:std:iso:3166:-2", "Potosí"),
  Bo_S("BO-S", "urn:iso:std:iso:3166:-2", "Santa Cruz"),
  Bo_T("BO-T", "urn:iso:std:iso:3166:-2", "Tarija"),
  Bq_Bo("BQ-BO", "urn:iso:std:iso:3166:-2", "Bonaire"),
  Bq_Sa("BQ-SA", "urn:iso:std:iso:3166:-2", "Saba"),
  Bq_Se("BQ-SE", "urn:iso:std:iso:3166:-2", "Sint Eustatius"),
  Ba_01("BA-01", "urn:iso:std:iso:3166:-2", "Unsko-sanska županija"),
  Ba_02("BA-02", "urn:iso:std:iso:3166:-2", "Posavska županija"),
  Ba_03("BA-03", "urn:iso:std:iso:3166:-2", "Tuzlanska županija"),
  Ba_04("BA-04", "urn:iso:std:iso:3166:-2", "Zeničko-dobojska županija"),
  Ba_05("BA-05", "urn:iso:std:iso:3166:-2", "Bosansko-podrinjska županija"),
  Ba_06("BA-06", "urn:iso:std:iso:3166:-2", "Srednjobosanska županija"),
  Ba_07("BA-07", "urn:iso:std:iso:3166:-2", "Hercegovačko-neretvanska županija"),
  Ba_08("BA-08", "urn:iso:std:iso:3166:-2", "Zapadnohercegovačka županija"),
  Ba_09("BA-09", "urn:iso:std:iso:3166:-2", "Kanton Sarajevo"),
  Ba_10("BA-10", "urn:iso:std:iso:3166:-2", "Kanton br. 10"),
  Ba_Bih("BA-BIH", "urn:iso:std:iso:3166:-2", "Federacija Bosne i Hercegovine"),
  Ba_Brc("BA-BRC", "urn:iso:std:iso:3166:-2", "Brčko distrikt"),
  Ba_Srp("BA-SRP", "urn:iso:std:iso:3166:-2", "Republika Srpska"),
  Bw_Ce("BW-CE", "urn:iso:std:iso:3166:-2", "Central"),
  Bw_Ch("BW-CH", "urn:iso:std:iso:3166:-2", "Chobe"),
  Bw_Fr("BW-FR", "urn:iso:std:iso:3166:-2", "Francistown"),
  Bw_Ga("BW-GA", "urn:iso:std:iso:3166:-2", "Gaborone"),
  Bw_Gh("BW-GH", "urn:iso:std:iso:3166:-2", "Ghanzi"),
  Bw_Jw("BW-JW", "urn:iso:std:iso:3166:-2", "Jwaneng"),
  Bw_Kg("BW-KG", "urn:iso:std:iso:3166:-2", "Kgalagadi"),
  Bw_Kl("BW-KL", "urn:iso:std:iso:3166:-2", "Kgatleng"),
  Bw_Kw("BW-KW", "urn:iso:std:iso:3166:-2", "Kweneng"),
  Bw_Lo("BW-LO", "urn:iso:std:iso:3166:-2", "Lobatse"),
  Bw_Ne("BW-NE", "urn:iso:std:iso:3166:-2", "North East"),
  Bw_Nw("BW-NW", "urn:iso:std:iso:3166:-2", "North West"),
  Bw_Se("BW-SE", "urn:iso:std:iso:3166:-2", "South East"),
  Bw_So("BW-SO", "urn:iso:std:iso:3166:-2", "Southern"),
  Bw_Sp("BW-SP", "urn:iso:std:iso:3166:-2", "Selibe Phikwe"),
  Bw_St("BW-ST", "urn:iso:std:iso:3166:-2", "Sowa Town"),
  Bv_Bv("BV-BV", "urn:iso:std:iso:3166:-2", "Bouvet Island"),
  Br_Ac("BR-AC", "urn:iso:std:iso:3166:-2", "Acre"),
  Br_Al("BR-AL", "urn:iso:std:iso:3166:-2", "Alagoas"),
  Br_Am("BR-AM", "urn:iso:std:iso:3166:-2", "Amazonas"),
  Br_Ap("BR-AP", "urn:iso:std:iso:3166:-2", "Amapá"),
  Br_Ba("BR-BA", "urn:iso:std:iso:3166:-2", "Bahia"),
  Br_Ce("BR-CE", "urn:iso:std:iso:3166:-2", "Ceará"),
  Br_Df("BR-DF", "urn:iso:std:iso:3166:-2", "Distrito Federal"),
  Br_Es("BR-ES", "urn:iso:std:iso:3166:-2", "Espírito Santo"),
  Br_Go("BR-GO", "urn:iso:std:iso:3166:-2", "Goiás"),
  Br_Ma("BR-MA", "urn:iso:std:iso:3166:-2", "Maranhão"),
  Br_Mg("BR-MG", "urn:iso:std:iso:3166:-2", "Minas Gerais"),
  Br_Ms("BR-MS", "urn:iso:std:iso:3166:-2", "Mato Grosso do Sul"),
  Br_Mt("BR-MT", "urn:iso:std:iso:3166:-2", "Mato Grosso"),
  Br_Pa("BR-PA", "urn:iso:std:iso:3166:-2", "Pará"),
  Br_Pb("BR-PB", "urn:iso:std:iso:3166:-2", "Paraíba"),
  Br_Pe("BR-PE", "urn:iso:std:iso:3166:-2", "Pernambuco"),
  Br_Pi("BR-PI", "urn:iso:std:iso:3166:-2", "Piauí"),
  Br_Pr("BR-PR", "urn:iso:std:iso:3166:-2", "Paraná"),
  Br_Rj("BR-RJ", "urn:iso:std:iso:3166:-2", "Rio de Janeiro"),
  Br_Rn("BR-RN", "urn:iso:std:iso:3166:-2", "Rio Grande do Norte"),
  Br_Ro("BR-RO", "urn:iso:std:iso:3166:-2", "Rondônia"),
  Br_Rr("BR-RR", "urn:iso:std:iso:3166:-2", "Roraima"),
  Br_Rs("BR-RS", "urn:iso:std:iso:3166:-2", "Rio Grande do Sul"),
  Br_Sc("BR-SC", "urn:iso:std:iso:3166:-2", "Santa Catarina"),
  Br_Se("BR-SE", "urn:iso:std:iso:3166:-2", "Sergipe"),
  Br_Sp("BR-SP", "urn:iso:std:iso:3166:-2", "São Paulo"),
  Br_To("BR-TO", "urn:iso:std:iso:3166:-2", "Tocantins"),
  Io_Io("IO-IO", "urn:iso:std:iso:3166:-2", "British Indian Ocean Territory"),
  Bn_Be("BN-BE", "urn:iso:std:iso:3166:-2", "Belait"),
  Bn_Bm("BN-BM", "urn:iso:std:iso:3166:-2", "Brunei-Muara"),
  Bn_Te("BN-TE", "urn:iso:std:iso:3166:-2", "Temburong"),
  Bn_Tu("BN-TU", "urn:iso:std:iso:3166:-2", "Tutong"),
  Bg_01("BG-01", "urn:iso:std:iso:3166:-2", "Blagoevgrad"),
  Bg_02("BG-02", "urn:iso:std:iso:3166:-2", "Burgas"),
  Bg_03("BG-03", "urn:iso:std:iso:3166:-2", "Varna"),
  Bg_04("BG-04", "urn:iso:std:iso:3166:-2", "Veliko Tarnovo"),
  Bg_05("BG-05", "urn:iso:std:iso:3166:-2", "Vidin"),
  Bg_06("BG-06", "urn:iso:std:iso:3166:-2", "Vratsa"),
  Bg_07("BG-07", "urn:iso:std:iso:3166:-2", "Gabrovo"),
  Bg_08("BG-08", "urn:iso:std:iso:3166:-2", "Dobrich"),
  Bg_09("BG-09", "urn:iso:std:iso:3166:-2", "Kardzhali"),
  Bg_10("BG-10", "urn:iso:std:iso:3166:-2", "Kyustendil"),
  Bg_11("BG-11", "urn:iso:std:iso:3166:-2", "Lovech"),
  Bg_12("BG-12", "urn:iso:std:iso:3166:-2", "Montana"),
  Bg_13("BG-13", "urn:iso:std:iso:3166:-2", "Pazardzhik"),
  Bg_14("BG-14", "urn:iso:std:iso:3166:-2", "Pernik"),
  Bg_15("BG-15", "urn:iso:std:iso:3166:-2", "Pleven"),
  Bg_16("BG-16", "urn:iso:std:iso:3166:-2", "Plovdiv"),
  Bg_17("BG-17", "urn:iso:std:iso:3166:-2", "Razgrad"),
  Bg_18("BG-18", "urn:iso:std:iso:3166:-2", "Ruse"),
  Bg_19("BG-19", "urn:iso:std:iso:3166:-2", "Silistra"),
  Bg_20("BG-20", "urn:iso:std:iso:3166:-2", "Sliven"),
  Bg_21("BG-21", "urn:iso:std:iso:3166:-2", "Smolyan"),
  Bg_22("BG-22", "urn:iso:std:iso:3166:-2", "Sofia"),
  Bg_23("BG-23", "urn:iso:std:iso:3166:-2", "Sofia"),
  Bg_24("BG-24", "urn:iso:std:iso:3166:-2", "Stara Zagora"),
  Bg_25("BG-25", "urn:iso:std:iso:3166:-2", "Targovishte"),
  Bg_26("BG-26", "urn:iso:std:iso:3166:-2", "Haskovo"),
  Bg_27("BG-27", "urn:iso:std:iso:3166:-2", "Shumen"),
  Bg_28("BG-28", "urn:iso:std:iso:3166:-2", "Yambol"),
  Bf_01("BF-01", "urn:iso:std:iso:3166:-2", "Boucle du Mouhoun"),
  Bf_02("BF-02", "urn:iso:std:iso:3166:-2", "Cascades"),
  Bf_03("BF-03", "urn:iso:std:iso:3166:-2", "Centre"),
  Bf_04("BF-04", "urn:iso:std:iso:3166:-2", "Centre-Est"),
  Bf_05("BF-05", "urn:iso:std:iso:3166:-2", "Centre-Nord"),
  Bf_06("BF-06", "urn:iso:std:iso:3166:-2", "Centre-Ouest"),
  Bf_07("BF-07", "urn:iso:std:iso:3166:-2", "Centre-Sud"),
  Bf_08("BF-08", "urn:iso:std:iso:3166:-2", "Est"),
  Bf_09("BF-09", "urn:iso:std:iso:3166:-2", "Hauts-Bassins"),
  Bf_10("BF-10", "urn:iso:std:iso:3166:-2", "Nord"),
  Bf_11("BF-11", "urn:iso:std:iso:3166:-2", "Plateau-Central"),
  Bf_12("BF-12", "urn:iso:std:iso:3166:-2", "Sahel"),
  Bf_13("BF-13", "urn:iso:std:iso:3166:-2", "Sud-Ouest"),
  Bf_Bal("BF-BAL", "urn:iso:std:iso:3166:-2", "Balé"),
  Bf_Bam("BF-BAM", "urn:iso:std:iso:3166:-2", "Bam"),
  Bf_Ban("BF-BAN", "urn:iso:std:iso:3166:-2", "Banwa"),
  Bf_Baz("BF-BAZ", "urn:iso:std:iso:3166:-2", "Bazèga"),
  Bf_Bgr("BF-BGR", "urn:iso:std:iso:3166:-2", "Bougouriba"),
  Bf_Blg("BF-BLG", "urn:iso:std:iso:3166:-2", "Boulgou"),
  Bf_Blk("BF-BLK", "urn:iso:std:iso:3166:-2", "Boulkiemdé"),
  Bf_Com("BF-COM", "urn:iso:std:iso:3166:-2", "Comoé"),
  Bf_Gan("BF-GAN", "urn:iso:std:iso:3166:-2", "Ganzourgou"),
  Bf_Gna("BF-GNA", "urn:iso:std:iso:3166:-2", "Gnagna"),
  Bf_Gou("BF-GOU", "urn:iso:std:iso:3166:-2", "Gourma"),
  Bf_Hou("BF-HOU", "urn:iso:std:iso:3166:-2", "Houet"),
  Bf_Iob("BF-IOB", "urn:iso:std:iso:3166:-2", "Ioba"),
  Bf_Kad("BF-KAD", "urn:iso:std:iso:3166:-2", "Kadiogo"),
  Bf_Ken("BF-KEN", "urn:iso:std:iso:3166:-2", "Kénédougou"),
  Bf_Kmd("BF-KMD", "urn:iso:std:iso:3166:-2", "Komondjari"),
  Bf_Kmp("BF-KMP", "urn:iso:std:iso:3166:-2", "Kompienga"),
  Bf_Kop("BF-KOP", "urn:iso:std:iso:3166:-2", "Koulpélogo"),
  Bf_Kos("BF-KOS", "urn:iso:std:iso:3166:-2", "Kossi"),
  Bf_Kot("BF-KOT", "urn:iso:std:iso:3166:-2", "Kouritenga"),
  Bf_Kow("BF-KOW", "urn:iso:std:iso:3166:-2", "Kourwéogo"),
  Bf_Ler("BF-LER", "urn:iso:std:iso:3166:-2", "Léraba"),
  Bf_Lor("BF-LOR", "urn:iso:std:iso:3166:-2", "Loroum"),
  Bf_Mou("BF-MOU", "urn:iso:std:iso:3166:-2", "Mouhoun"),
  Bf_Nam("BF-NAM", "urn:iso:std:iso:3166:-2", "Namentenga"),
  Bf_Nao("BF-NAO", "urn:iso:std:iso:3166:-2", "Nahouri"),
  Bf_Nay("BF-NAY", "urn:iso:std:iso:3166:-2", "Nayala"),
  Bf_Nou("BF-NOU", "urn:iso:std:iso:3166:-2", "Noumbiel"),
  Bf_Oub("BF-OUB", "urn:iso:std:iso:3166:-2", "Oubritenga"),
  Bf_Oud("BF-OUD", "urn:iso:std:iso:3166:-2", "Oudalan"),
  Bf_Pas("BF-PAS", "urn:iso:std:iso:3166:-2", "Passoré"),
  Bf_Pon("BF-PON", "urn:iso:std:iso:3166:-2", "Poni"),
  Bf_Sen("BF-SEN", "urn:iso:std:iso:3166:-2", "Séno"),
  Bf_Sis("BF-SIS", "urn:iso:std:iso:3166:-2", "Sissili"),
  Bf_Smt("BF-SMT", "urn:iso:std:iso:3166:-2", "Sanmatenga"),
  Bf_Sng("BF-SNG", "urn:iso:std:iso:3166:-2", "Sanguié"),
  Bf_Som("BF-SOM", "urn:iso:std:iso:3166:-2", "Soum"),
  Bf_Sor("BF-SOR", "urn:iso:std:iso:3166:-2", "Sourou"),
  Bf_Tap("BF-TAP", "urn:iso:std:iso:3166:-2", "Tapoa"),
  Bf_Tui("BF-TUI", "urn:iso:std:iso:3166:-2", "Tui"),
  Bf_Yag("BF-YAG", "urn:iso:std:iso:3166:-2", "Yagha"),
  Bf_Yat("BF-YAT", "urn:iso:std:iso:3166:-2", "Yatenga"),
  Bf_Zir("BF-ZIR", "urn:iso:std:iso:3166:-2", "Ziro"),
  Bf_Zon("BF-ZON", "urn:iso:std:iso:3166:-2", "Zondoma"),
  Bf_Zou("BF-ZOU", "urn:iso:std:iso:3166:-2", "Zoundwéogo"),
  Bi_Bb("BI-BB", "urn:iso:std:iso:3166:-2", "Bubanza"),
  Bi_Bl("BI-BL", "urn:iso:std:iso:3166:-2", "Bujumbura Rural"),
  Bi_Bm("BI-BM", "urn:iso:std:iso:3166:-2", "Bujumbura Mairie"),
  Bi_Br("BI-BR", "urn:iso:std:iso:3166:-2", "Bururi"),
  Bi_Ca("BI-CA", "urn:iso:std:iso:3166:-2", "Cankuzo"),
  Bi_Ci("BI-CI", "urn:iso:std:iso:3166:-2", "Cibitoke"),
  Bi_Gi("BI-GI", "urn:iso:std:iso:3166:-2", "Gitega"),
  Bi_Ki("BI-KI", "urn:iso:std:iso:3166:-2", "Kirundo"),
  Bi_Kr("BI-KR", "urn:iso:std:iso:3166:-2", "Karuzi"),
  Bi_Ky("BI-KY", "urn:iso:std:iso:3166:-2", "Kayanza"),
  Bi_Ma("BI-MA", "urn:iso:std:iso:3166:-2", "Makamba"),
  Bi_Mu("BI-MU", "urn:iso:std:iso:3166:-2", "Muramvya"),
  Bi_Mw("BI-MW", "urn:iso:std:iso:3166:-2", "Mwaro"),
  Bi_My("BI-MY", "urn:iso:std:iso:3166:-2", "Muyinga"),
  Bi_Ng("BI-NG", "urn:iso:std:iso:3166:-2", "Ngozi"),
  Bi_Rt("BI-RT", "urn:iso:std:iso:3166:-2", "Rutana"),
  Bi_Ry("BI-RY", "urn:iso:std:iso:3166:-2", "Ruyigi"),
  Kh_10("KH-10", "urn:iso:std:iso:3166:-2", "Krâchéh"),
  Kh_11("KH-11", "urn:iso:std:iso:3166:-2", "Môndól Kiri"),
  Kh_12("KH-12", "urn:iso:std:iso:3166:-2", "Phnom Penh"),
  Kh_13("KH-13", "urn:iso:std:iso:3166:-2", "Preăh Vihéar"),
  Kh_14("KH-14", "urn:iso:std:iso:3166:-2", "Prey Veaeng"),
  Kh_15("KH-15", "urn:iso:std:iso:3166:-2", "Pousaat"),
  Kh_16("KH-16", "urn:iso:std:iso:3166:-2", "Rotanak Kiri"),
  Kh_17("KH-17", "urn:iso:std:iso:3166:-2", "Siem Reab"),
  Kh_18("KH-18", "urn:iso:std:iso:3166:-2", "Krŏng Preăh Sihanouk"),
  Kh_19("KH-19", "urn:iso:std:iso:3166:-2", "Stoĕng Trêng"),
  Kh_1("KH-1", "urn:iso:std:iso:3166:-2", "Bântéay Méanchey"),
  Kh_20("KH-20", "urn:iso:std:iso:3166:-2", "Svaay Rieng"),
  Kh_21("KH-21", "urn:iso:std:iso:3166:-2", "Taakaev"),
  Kh_22("KH-22", "urn:iso:std:iso:3166:-2", "Ŏtdâr Méanchey"),
  Kh_23("KH-23", "urn:iso:std:iso:3166:-2", "Krong Kaeb"),
  Kh_24("KH-24", "urn:iso:std:iso:3166:-2", "Krŏng Pailĭn"),
  Kh_2("KH-2", "urn:iso:std:iso:3166:-2", "Baat Dambang"),
  Kh_3("KH-3", "urn:iso:std:iso:3166:-2", "Kampong Chaam"),
  Kh_4("KH-4", "urn:iso:std:iso:3166:-2", "Kampong Chhnang"),
  Kh_5("KH-5", "urn:iso:std:iso:3166:-2", "Kâmpóng Spœ"),
  Kh_6("KH-6", "urn:iso:std:iso:3166:-2", "Kâmpóng Thum"),
  Kh_7("KH-7", "urn:iso:std:iso:3166:-2", "Kampot"),
  Kh_8("KH-8", "urn:iso:std:iso:3166:-2", "Kandaal"),
  Kh_9("KH-9", "urn:iso:std:iso:3166:-2", "Kaoh Kong"),
  Cm_Ad("CM-AD", "urn:iso:std:iso:3166:-2", "Adamaoua"),
  Cm_Ce("CM-CE", "urn:iso:std:iso:3166:-2", "Centre"),
  Cm_En("CM-EN", "urn:iso:std:iso:3166:-2", "Extrême-Nord"),
  Cm_Es("CM-ES", "urn:iso:std:iso:3166:-2", "East"),
  Cm_Lt("CM-LT", "urn:iso:std:iso:3166:-2", "Littoral"),
  Cm_No("CM-NO", "urn:iso:std:iso:3166:-2", "Nord"),
  Cm_Nw("CM-NW", "urn:iso:std:iso:3166:-2", "Nord-Ouest"),
  Cm_Ou("CM-OU", "urn:iso:std:iso:3166:-2", "Ouest"),
  Cm_Su("CM-SU", "urn:iso:std:iso:3166:-2", "South"),
  Cm_Sw("CM-SW", "urn:iso:std:iso:3166:-2", "South-West"),
  Ca_Ab("CA-AB", "urn:iso:std:iso:3166:-2", "Alberta"),
  Ca_Bc("CA-BC", "urn:iso:std:iso:3166:-2", "British Columbia"),
  Ca_Mb("CA-MB", "urn:iso:std:iso:3166:-2", "Manitoba"),
  Ca_Nb("CA-NB", "urn:iso:std:iso:3166:-2", "New Brunswick"),
  Ca_Nl("CA-NL", "urn:iso:std:iso:3166:-2", "Newfoundland and Labrador"),
  Ca_Ns("CA-NS", "urn:iso:std:iso:3166:-2", "Nova Scotia"),
  Ca_Nt("CA-NT", "urn:iso:std:iso:3166:-2", "Northwest Territories"),
  Ca_Nu("CA-NU", "urn:iso:std:iso:3166:-2", "Nunavut"),
  Ca_On("CA-ON", "urn:iso:std:iso:3166:-2", "Ontario"),
  Ca_Pe("CA-PE", "urn:iso:std:iso:3166:-2", "Prince Edward Island"),
  Ca_Qc("CA-QC", "urn:iso:std:iso:3166:-2", "Quebec"),
  Ca_Sk("CA-SK", "urn:iso:std:iso:3166:-2", "Saskatchewan"),
  Ca_Yt("CA-YT", "urn:iso:std:iso:3166:-2", "Yukon"),
  Cv_B("CV-B", "urn:iso:std:iso:3166:-2", "Ilhas de Barlavento"),
  Cv_Br("CV-BR", "urn:iso:std:iso:3166:-2", "Brava"),
  Cv_Bv("CV-BV", "urn:iso:std:iso:3166:-2", "Boa Vista"),
  Cv_Ca("CV-CA", "urn:iso:std:iso:3166:-2", "Santa Catarina"),
  Cv_Cf("CV-CF", "urn:iso:std:iso:3166:-2", "Santa Catarina do Fogo"),
  Cv_Cr("CV-CR", "urn:iso:std:iso:3166:-2", "Santa Cruz"),
  Cv_Ma("CV-MA", "urn:iso:std:iso:3166:-2", "Maio"),
  Cv_Mo("CV-MO", "urn:iso:std:iso:3166:-2", "Mosteiros"),
  Cv_Pa("CV-PA", "urn:iso:std:iso:3166:-2", "Paul"),
  Cv_Pn("CV-PN", "urn:iso:std:iso:3166:-2", "Porto Novo"),
  Cv_Pr("CV-PR", "urn:iso:std:iso:3166:-2", "Praia"),
  Cv_Rb("CV-RB", "urn:iso:std:iso:3166:-2", "Ribeira Brava"),
  Cv_Rg("CV-RG", "urn:iso:std:iso:3166:-2", "Ribeira Grande"),
  Cv_Rs("CV-RS", "urn:iso:std:iso:3166:-2", "Ribeira Grande de Santiago"),
  Cv_Sd("CV-SD", "urn:iso:std:iso:3166:-2", "São Domingos"),
  Cv_Sf("CV-SF", "urn:iso:std:iso:3166:-2", "São Filipe"),
  Cv_S("CV-S", "urn:iso:std:iso:3166:-2", "Ilhas de Sotavento"),
  Cv_Sl("CV-SL", "urn:iso:std:iso:3166:-2", "Sal"),
  Cv_Sm("CV-SM", "urn:iso:std:iso:3166:-2", "São Miguel"),
  Cv_So("CV-SO", "urn:iso:std:iso:3166:-2", "São Lourenço dos Órgãos"),
  Cv_Ss("CV-SS", "urn:iso:std:iso:3166:-2", "São Salvador do Mundo"),
  Cv_Sv("CV-SV", "urn:iso:std:iso:3166:-2", "São Vicente"),
  Cv_Ta("CV-TA", "urn:iso:std:iso:3166:-2", "Tarrafal"),
  Cv_Ts("CV-TS", "urn:iso:std:iso:3166:-2", "Tarrafal de São Nicolau"),
  Ky_Ky("KY-KY", "urn:iso:std:iso:3166:-2", "Cayman Islands"),
  Cf_Ac("CF-AC", "urn:iso:std:iso:3166:-2", "Ouham"),
  Cf_Bb("CF-BB", "urn:iso:std:iso:3166:-2", "Bamïngï-Bangoran"),
  Cf_Bgf("CF-BGF", "urn:iso:std:iso:3166:-2", "Bangî"),
  Cf_Bk("CF-BK", "urn:iso:std:iso:3166:-2", "Basse-Kotto"),
  Cf_Hk("CF-HK", "urn:iso:std:iso:3166:-2", "Haute-Kotto"),
  Cf_Hm("CF-HM", "urn:iso:std:iso:3166:-2", "Haut-Mbomou"),
  Cf_Hs("CF-HS", "urn:iso:std:iso:3166:-2", "Haute-Sangha / Mambéré-Kadéï"),
  Cf_Kb("CF-KB", "urn:iso:std:iso:3166:-2", "Gïrïbïngï"),
  Cf_Kg("CF-KG", "urn:iso:std:iso:3166:-2", "Kemö-Gïrïbïngï"),
  Cf_Lb("CF-LB", "urn:iso:std:iso:3166:-2", "Lobaye"),
  Cf_Mb("CF-MB", "urn:iso:std:iso:3166:-2", "Mbomou"),
  Cf_Mp("CF-MP", "urn:iso:std:iso:3166:-2", "Ömbëlä-Pökö"),
  Cf_Nm("CF-NM", "urn:iso:std:iso:3166:-2", "Nana-Mambéré"),
  Cf_Op("CF-OP", "urn:iso:std:iso:3166:-2", "Ouham-Pendé"),
  Cf_Se("CF-SE", "urn:iso:std:iso:3166:-2", "Sangä"),
  Cf_Uk("CF-UK", "urn:iso:std:iso:3166:-2", "Ouaka"),
  Cf_Vk("CF-VK", "urn:iso:std:iso:3166:-2", "Vakaga"),
  Td_Ba("TD-BA", "urn:iso:std:iso:3166:-2", "Al Baţḩah"),
  Td_Bg("TD-BG", "urn:iso:std:iso:3166:-2", "Baḩr al Ghazāl"),
  Td_Bo("TD-BO", "urn:iso:std:iso:3166:-2", "Borkou"),
  Td_Cb("TD-CB", "urn:iso:std:iso:3166:-2", "Chari-Baguirmi"),
  Td_Ee("TD-EE", "urn:iso:std:iso:3166:-2", "Ennedi-Est"),
  Td_Eo("TD-EO", "urn:iso:std:iso:3166:-2", "Ennedi-Ouest"),
  Td_Gr("TD-GR", "urn:iso:std:iso:3166:-2", "Guéra"),
  Td_Hl("TD-HL", "urn:iso:std:iso:3166:-2", "Hadjer Lamis"),
  Td_Ka("TD-KA", "urn:iso:std:iso:3166:-2", "Kanem"),
  Td_Lc("TD-LC", "urn:iso:std:iso:3166:-2", "Al Buḩayrah"),
  Td_Lo("TD-LO", "urn:iso:std:iso:3166:-2", "Logone-Occidental"),
  Td_Lr("TD-LR", "urn:iso:std:iso:3166:-2", "Logone-Oriental"),
  Td_Ma("TD-MA", "urn:iso:std:iso:3166:-2", "Mandoul"),
  Td_Mc("TD-MC", "urn:iso:std:iso:3166:-2", "Moyen-Chari"),
  Td_Me("TD-ME", "urn:iso:std:iso:3166:-2", "Mayo-Kebbi-Est"),
  Td_Mo("TD-MO", "urn:iso:std:iso:3166:-2", "Mayo-Kebbi-Ouest"),
  Td_Nd("TD-ND", "urn:iso:std:iso:3166:-2", "Madīnat Injamīnā"),
  Td_Od("TD-OD", "urn:iso:std:iso:3166:-2", "Ouaddaï"),
  Td_Sa("TD-SA", "urn:iso:std:iso:3166:-2", "Salamat"),
  Td_Si("TD-SI", "urn:iso:std:iso:3166:-2", "Sila"),
  Td_Ta("TD-TA", "urn:iso:std:iso:3166:-2", "Tandjilé"),
  Td_Ti("TD-TI", "urn:iso:std:iso:3166:-2", "Tibastī"),
  Td_Wf("TD-WF", "urn:iso:std:iso:3166:-2", "Wadi Fira"),
  Cl_Ai("CL-AI", "urn:iso:std:iso:3166:-2", "Aysén"),
  Cl_An("CL-AN", "urn:iso:std:iso:3166:-2", "Antofagasta"),
  Cl_Ap("CL-AP", "urn:iso:std:iso:3166:-2", "Arica y Parinacota"),
  Cl_Ar("CL-AR", "urn:iso:std:iso:3166:-2", "Araucanía"),
  Cl_At("CL-AT", "urn:iso:std:iso:3166:-2", "Atacama"),
  Cl_Bi("CL-BI", "urn:iso:std:iso:3166:-2", "Biobío"),
  Cl_Co("CL-CO", "urn:iso:std:iso:3166:-2", "Coquimbo"),
  Cl_Li("CL-LI", "urn:iso:std:iso:3166:-2", "Libertador General Bernardo O'Higgins"),
  Cl_Ll("CL-LL", "urn:iso:std:iso:3166:-2", "Los Lagos"),
  Cl_Lr("CL-LR", "urn:iso:std:iso:3166:-2", "Los Ríos"),
  Cl_Ma("CL-MA", "urn:iso:std:iso:3166:-2", "Magallanes"),
  Cl_Ml("CL-ML", "urn:iso:std:iso:3166:-2", "Maule"),
  Cl_Rm("CL-RM", "urn:iso:std:iso:3166:-2", "Región Metropolitana de Santiago"),
  Cl_Ta("CL-TA", "urn:iso:std:iso:3166:-2", "Tarapacá"),
  Cl_Vs("CL-VS", "urn:iso:std:iso:3166:-2", "Valparaíso"),
  Cn_11("CN-11", "urn:iso:std:iso:3166:-2", "Beijing"),
  Cn_12("CN-12", "urn:iso:std:iso:3166:-2", "Tianjin"),
  Cn_13("CN-13", "urn:iso:std:iso:3166:-2", "Hebei"),
  Cn_14("CN-14", "urn:iso:std:iso:3166:-2", "Shanxi"),
  Cn_15("CN-15", "urn:iso:std:iso:3166:-2", "Nei Mongol"),
  Cn_21("CN-21", "urn:iso:std:iso:3166:-2", "Liaoning"),
  Cn_22("CN-22", "urn:iso:std:iso:3166:-2", "Jilin"),
  Cn_23("CN-23", "urn:iso:std:iso:3166:-2", "Heilongjiang"),
  Cn_31("CN-31", "urn:iso:std:iso:3166:-2", "Shanghai"),
  Cn_32("CN-32", "urn:iso:std:iso:3166:-2", "Jiangsu"),
  Cn_33("CN-33", "urn:iso:std:iso:3166:-2", "Zhejiang"),
  Cn_34("CN-34", "urn:iso:std:iso:3166:-2", "Anhui"),
  Cn_35("CN-35", "urn:iso:std:iso:3166:-2", "Fujian"),
  Cn_36("CN-36", "urn:iso:std:iso:3166:-2", "Jiangxi"),
  Cn_37("CN-37", "urn:iso:std:iso:3166:-2", "Shandong"),
  Cn_41("CN-41", "urn:iso:std:iso:3166:-2", "Henan"),
  Cn_42("CN-42", "urn:iso:std:iso:3166:-2", "Hubei"),
  Cn_43("CN-43", "urn:iso:std:iso:3166:-2", "Hunan"),
  Cn_44("CN-44", "urn:iso:std:iso:3166:-2", "Guangdong"),
  Cn_45("CN-45", "urn:iso:std:iso:3166:-2", "Guangxi"),
  Cn_46("CN-46", "urn:iso:std:iso:3166:-2", "Hainan"),
  Cn_50("CN-50", "urn:iso:std:iso:3166:-2", "Chongqing"),
  Cn_51("CN-51", "urn:iso:std:iso:3166:-2", "Sichuan"),
  Cn_52("CN-52", "urn:iso:std:iso:3166:-2", "Guizhou"),
  Cn_53("CN-53", "urn:iso:std:iso:3166:-2", "Yunnan"),
  Cn_54("CN-54", "urn:iso:std:iso:3166:-2", "Xizang"),
  Cn_61("CN-61", "urn:iso:std:iso:3166:-2", "Shaanxi"),
  Cn_62("CN-62", "urn:iso:std:iso:3166:-2", "Gansu"),
  Cn_63("CN-63", "urn:iso:std:iso:3166:-2", "Qinghai"),
  Cn_64("CN-64", "urn:iso:std:iso:3166:-2", "Ningxia"),
  Cn_65("CN-65", "urn:iso:std:iso:3166:-2", "Xinjiang"),
  Cn_71("CN-71", "urn:iso:std:iso:3166:-2", "Taiwan"),
  Cn_91("CN-91", "urn:iso:std:iso:3166:-2", "Hong Kong"),
  Cn_92("CN-92", "urn:iso:std:iso:3166:-2", "Aomen"),
  Cx_Cx("CX-CX", "urn:iso:std:iso:3166:-2", "Christmas Island"),
  Cc_Cc("CC-CC", "urn:iso:std:iso:3166:-2", "Cocos  Islands"),
  Co_Ama("CO-AMA", "urn:iso:std:iso:3166:-2", "Amazonas"),
  Co_Ant("CO-ANT", "urn:iso:std:iso:3166:-2", "Antioquia"),
  Co_Ara("CO-ARA", "urn:iso:std:iso:3166:-2", "Arauca"),
  Co_Atl("CO-ATL", "urn:iso:std:iso:3166:-2", "Atlántico"),
  Co_Bol("CO-BOL", "urn:iso:std:iso:3166:-2", "Bolívar"),
  Co_Boy("CO-BOY", "urn:iso:std:iso:3166:-2", "Boyacá"),
  Co_Cal("CO-CAL", "urn:iso:std:iso:3166:-2", "Caldas"),
  Co_Caq("CO-CAQ", "urn:iso:std:iso:3166:-2", "Caquetá"),
  Co_Cas("CO-CAS", "urn:iso:std:iso:3166:-2", "Casanare"),
  Co_Cau("CO-CAU", "urn:iso:std:iso:3166:-2", "Cauca"),
  Co_Ces("CO-CES", "urn:iso:std:iso:3166:-2", "Cesar"),
  Co_Cho("CO-CHO", "urn:iso:std:iso:3166:-2", "Chocó"),
  Co_Cor("CO-COR", "urn:iso:std:iso:3166:-2", "Córdoba"),
  Co_Cun("CO-CUN", "urn:iso:std:iso:3166:-2", "Cundinamarca"),
  Co_Dc("CO-DC", "urn:iso:std:iso:3166:-2", "Distrito Capital de Bogotá"),
  Co_Gua("CO-GUA", "urn:iso:std:iso:3166:-2", "Guainía"),
  Co_Guv("CO-GUV", "urn:iso:std:iso:3166:-2", "Guaviare"),
  Co_Hui("CO-HUI", "urn:iso:std:iso:3166:-2", "Huila"),
  Co_Lag("CO-LAG", "urn:iso:std:iso:3166:-2", "La Guajira"),
  Co_Mag("CO-MAG", "urn:iso:std:iso:3166:-2", "Magdalena"),
  Co_Met("CO-MET", "urn:iso:std:iso:3166:-2", "Meta"),
  Co_Nar("CO-NAR", "urn:iso:std:iso:3166:-2", "Nariño"),
  Co_Nsa("CO-NSA", "urn:iso:std:iso:3166:-2", "Norte de Santander"),
  Co_Put("CO-PUT", "urn:iso:std:iso:3166:-2", "Putumayo"),
  Co_Qui("CO-QUI", "urn:iso:std:iso:3166:-2", "Quindío"),
  Co_Ris("CO-RIS", "urn:iso:std:iso:3166:-2", "Risaralda"),
  Co_San("CO-SAN", "urn:iso:std:iso:3166:-2", "Santander"),
  Co_Sap("CO-SAP", "urn:iso:std:iso:3166:-2", "San Andrés, Providencia y Santa Catalina"),
  Co_Suc("CO-SUC", "urn:iso:std:iso:3166:-2", "Sucre"),
  Co_Tol("CO-TOL", "urn:iso:std:iso:3166:-2", "Tolima"),
  Co_Vac("CO-VAC", "urn:iso:std:iso:3166:-2", "Valle del Cauca"),
  Co_Vau("CO-VAU", "urn:iso:std:iso:3166:-2", "Vaupés"),
  Co_Vid("CO-VID", "urn:iso:std:iso:3166:-2", "Vichada"),
  Km_A("KM-A", "urn:iso:std:iso:3166:-2", "Andjouân"),
  Km_G("KM-G", "urn:iso:std:iso:3166:-2", "Andjazîdja"),
  Km_M("KM-M", "urn:iso:std:iso:3166:-2", "Mohéli"),
  Cg_11("CG-11", "urn:iso:std:iso:3166:-2", "Bouenza"),
  Cg_12("CG-12", "urn:iso:std:iso:3166:-2", "Pool"),
  Cg_13("CG-13", "urn:iso:std:iso:3166:-2", "Sangha"),
  Cg_14("CG-14", "urn:iso:std:iso:3166:-2", "Plateaux"),
  Cg_15("CG-15", "urn:iso:std:iso:3166:-2", "Cuvette-Ouest"),
  Cg_16("CG-16", "urn:iso:std:iso:3166:-2", "Pointe-Noire"),
  Cg_2("CG-2", "urn:iso:std:iso:3166:-2", "Lékoumou"),
  Cg_5("CG-5", "urn:iso:std:iso:3166:-2", "Kouilou"),
  Cg_7("CG-7", "urn:iso:std:iso:3166:-2", "Likouala"),
  Cg_8("CG-8", "urn:iso:std:iso:3166:-2", "Cuvette"),
  Cg_9("CG-9", "urn:iso:std:iso:3166:-2", "Niari"),
  Cg_Bzv("CG-BZV", "urn:iso:std:iso:3166:-2", "Brazzaville"),
  Cd_Bc("CD-BC", "urn:iso:std:iso:3166:-2", "Bas-Congo"),
  Cd_Bn("CD-BN", "urn:iso:std:iso:3166:-2", "Bandundu"),
  Cd_Eq("CD-EQ", "urn:iso:std:iso:3166:-2", "Équateur"),
  Cd_Ka("CD-KA", "urn:iso:std:iso:3166:-2", "Katanga"),
  Cd_Ke("CD-KE", "urn:iso:std:iso:3166:-2", "Kasai-Oriental"),
  Cd_Kn("CD-KN", "urn:iso:std:iso:3166:-2", "Kinshasa"),
  Cd_Kw("CD-KW", "urn:iso:std:iso:3166:-2", "Kasai-Occidental"),
  Cd_Ma("CD-MA", "urn:iso:std:iso:3166:-2", "Maniema"),
  Cd_Nk("CD-NK", "urn:iso:std:iso:3166:-2", "Nord-Kivu"),
  Cd_Or("CD-OR", "urn:iso:std:iso:3166:-2", "Orientale"),
  Cd_Sk("CD-SK", "urn:iso:std:iso:3166:-2", "Sud-Kivu"),
  Ck_Ck("CK-CK", "urn:iso:std:iso:3166:-2", "Cook Islands"),
  Cr_A("CR-A", "urn:iso:std:iso:3166:-2", "Alajuela"),
  Cr_C("CR-C", "urn:iso:std:iso:3166:-2", "Cartago"),
  Cr_G("CR-G", "urn:iso:std:iso:3166:-2", "Guanacaste"),
  Cr_H("CR-H", "urn:iso:std:iso:3166:-2", "Heredia"),
  Cr_L("CR-L", "urn:iso:std:iso:3166:-2", "Limón"),
  Cr_P("CR-P", "urn:iso:std:iso:3166:-2", "Puntarenas"),
  Cr_Sj("CR-SJ", "urn:iso:std:iso:3166:-2", "San José"),
  Ci_01("CI-01", "urn:iso:std:iso:3166:-2", "Lagunes"),
  Ci_02("CI-02", "urn:iso:std:iso:3166:-2", "Haut-Sassandra"),
  Ci_03("CI-03", "urn:iso:std:iso:3166:-2", "Savanes"),
  Ci_04("CI-04", "urn:iso:std:iso:3166:-2", "Vallée du Bandama"),
  Ci_05("CI-05", "urn:iso:std:iso:3166:-2", "Moyen-Comoé"),
  Ci_06("CI-06", "urn:iso:std:iso:3166:-2", "18 Montagnes"),
  Ci_07("CI-07", "urn:iso:std:iso:3166:-2", "Lacs"),
  Ci_08("CI-08", "urn:iso:std:iso:3166:-2", "Zanzan"),
  Ci_09("CI-09", "urn:iso:std:iso:3166:-2", "Bas-Sassandra"),
  Ci_10("CI-10", "urn:iso:std:iso:3166:-2", "Denguélé"),
  Ci_11("CI-11", "urn:iso:std:iso:3166:-2", "Nzi-Comoé"),
  Ci_12("CI-12", "urn:iso:std:iso:3166:-2", "Marahoué"),
  Ci_13("CI-13", "urn:iso:std:iso:3166:-2", "Sud-Comoé"),
  Ci_14("CI-14", "urn:iso:std:iso:3166:-2", "Worodougou"),
  Ci_15("CI-15", "urn:iso:std:iso:3166:-2", "Sud-Bandama"),
  Ci_16("CI-16", "urn:iso:std:iso:3166:-2", "Agnébi"),
  Ci_17("CI-17", "urn:iso:std:iso:3166:-2", "Bafing"),
  Ci_18("CI-18", "urn:iso:std:iso:3166:-2", "Fromager"),
  Ci_19("CI-19", "urn:iso:std:iso:3166:-2", "Moyen-Cavally"),
  Hr_01("HR-01", "urn:iso:std:iso:3166:-2", "Zagrebačka županija"),
  Hr_02("HR-02", "urn:iso:std:iso:3166:-2", "Krapinsko-zagorska županija"),
  Hr_03("HR-03", "urn:iso:std:iso:3166:-2", "Sisačko-moslavačka županija"),
  Hr_04("HR-04", "urn:iso:std:iso:3166:-2", "Karlovačka županija"),
  Hr_05("HR-05", "urn:iso:std:iso:3166:-2", "Varaždinska županija"),
  Hr_06("HR-06", "urn:iso:std:iso:3166:-2", "Koprivničko-križevačka županija"),
  Hr_07("HR-07", "urn:iso:std:iso:3166:-2", "Bjelovarsko-bilogorska županija"),
  Hr_08("HR-08", "urn:iso:std:iso:3166:-2", "Primorsko-goranska županija"),
  Hr_09("HR-09", "urn:iso:std:iso:3166:-2", "Ličko-senjska županija"),
  Hr_10("HR-10", "urn:iso:std:iso:3166:-2", "Virovitičko-podravska županija"),
  Hr_11("HR-11", "urn:iso:std:iso:3166:-2", "Požeško-slavonska županija"),
  Hr_12("HR-12", "urn:iso:std:iso:3166:-2", "Brodsko-posavska županija"),
  Hr_13("HR-13", "urn:iso:std:iso:3166:-2", "Zadarska županija"),
  Hr_14("HR-14", "urn:iso:std:iso:3166:-2", "Osječko-baranjska županija"),
  Hr_15("HR-15", "urn:iso:std:iso:3166:-2", "Šibensko-kninska županija"),
  Hr_16("HR-16", "urn:iso:std:iso:3166:-2", "Vukovarsko-srijemska županija"),
  Hr_17("HR-17", "urn:iso:std:iso:3166:-2", "Splitsko-dalmatinska županija"),
  Hr_18("HR-18", "urn:iso:std:iso:3166:-2", "Istarska županija"),
  Hr_19("HR-19", "urn:iso:std:iso:3166:-2", "Dubrovačko-neretvanska županija"),
  Hr_20("HR-20", "urn:iso:std:iso:3166:-2", "Međimurska županija"),
  Hr_21("HR-21", "urn:iso:std:iso:3166:-2", "Grad Zagreb"),
  Cu_01("CU-01", "urn:iso:std:iso:3166:-2", "Pinar del Río"),
  Cu_03("CU-03", "urn:iso:std:iso:3166:-2", "La Habana"),
  Cu_04("CU-04", "urn:iso:std:iso:3166:-2", "Matanzas"),
  Cu_05("CU-05", "urn:iso:std:iso:3166:-2", "Villa Clara"),
  Cu_06("CU-06", "urn:iso:std:iso:3166:-2", "Cienfuegos"),
  Cu_07("CU-07", "urn:iso:std:iso:3166:-2", "Sancti Spíritus"),
  Cu_08("CU-08", "urn:iso:std:iso:3166:-2", "Ciego de Ávila"),
  Cu_09("CU-09", "urn:iso:std:iso:3166:-2", "Camagüey"),
  Cu_10("CU-10", "urn:iso:std:iso:3166:-2", "Las Tunas"),
  Cu_11("CU-11", "urn:iso:std:iso:3166:-2", "Holguín"),
  Cu_12("CU-12", "urn:iso:std:iso:3166:-2", "Granma"),
  Cu_13("CU-13", "urn:iso:std:iso:3166:-2", "Santiago de Cuba"),
  Cu_14("CU-14", "urn:iso:std:iso:3166:-2", "Guantánamo"),
  Cu_15("CU-15", "urn:iso:std:iso:3166:-2", "Artemisa"),
  Cu_16("CU-16", "urn:iso:std:iso:3166:-2", "Mayabeque"),
  Cu_99("CU-99", "urn:iso:std:iso:3166:-2", "Isla de la Juventud"),
  Cw_Cw("CW-CW", "urn:iso:std:iso:3166:-2", "Curaçao"),
  Cy_01("CY-01", "urn:iso:std:iso:3166:-2", "Lefkoşa"),
  Cy_02("CY-02", "urn:iso:std:iso:3166:-2", "Lemesos"),
  Cy_03("CY-03", "urn:iso:std:iso:3166:-2", "Larnaka"),
  Cy_04("CY-04", "urn:iso:std:iso:3166:-2", "Ammochostos"),
  Cy_05("CY-05", "urn:iso:std:iso:3166:-2", "Baf"),
  Cy_06("CY-06", "urn:iso:std:iso:3166:-2", "Girne"),
  Cz_101("CZ-101", "urn:iso:std:iso:3166:-2", "Praha 1"),
  Cz_102("CZ-102", "urn:iso:std:iso:3166:-2", "Praha 2"),
  Cz_103("CZ-103", "urn:iso:std:iso:3166:-2", "Praha 3"),
  Cz_104("CZ-104", "urn:iso:std:iso:3166:-2", "Praha 4"),
  Cz_105("CZ-105", "urn:iso:std:iso:3166:-2", "Praha 5"),
  Cz_106("CZ-106", "urn:iso:std:iso:3166:-2", "Praha 6"),
  Cz_107("CZ-107", "urn:iso:std:iso:3166:-2", "Praha 7"),
  Cz_108("CZ-108", "urn:iso:std:iso:3166:-2", "Praha 8"),
  Cz_109("CZ-109", "urn:iso:std:iso:3166:-2", "Praha 9"),
  Cz_10A("CZ-10A", "urn:iso:std:iso:3166:-2", "Praha 10"),
  Cz_10B("CZ-10B", "urn:iso:std:iso:3166:-2", "Praha 11"),
  Cz_10C("CZ-10C", "urn:iso:std:iso:3166:-2", "Praha 12"),
  Cz_10D("CZ-10D", "urn:iso:std:iso:3166:-2", "Praha 13"),
  Cz_10E("CZ-10E", "urn:iso:std:iso:3166:-2", "Praha 14"),
  Cz_10F("CZ-10F", "urn:iso:std:iso:3166:-2", "Praha 15"),
  Cz_201("CZ-201", "urn:iso:std:iso:3166:-2", "Benešov"),
  Cz_202("CZ-202", "urn:iso:std:iso:3166:-2", "Beroun"),
  Cz_203("CZ-203", "urn:iso:std:iso:3166:-2", "Kladno"),
  Cz_204("CZ-204", "urn:iso:std:iso:3166:-2", "Kolín"),
  Cz_205("CZ-205", "urn:iso:std:iso:3166:-2", "Kutná Hora"),
  Cz_206("CZ-206", "urn:iso:std:iso:3166:-2", "Mělník"),
  Cz_207("CZ-207", "urn:iso:std:iso:3166:-2", "Mladá Boleslav"),
  Cz_208("CZ-208", "urn:iso:std:iso:3166:-2", "Nymburk"),
  Cz_209("CZ-209", "urn:iso:std:iso:3166:-2", "Praha-východ"),
  Cz_20A("CZ-20A", "urn:iso:std:iso:3166:-2", "Praha-západ"),
  Cz_20B("CZ-20B", "urn:iso:std:iso:3166:-2", "Příbram"),
  Cz_20C("CZ-20C", "urn:iso:std:iso:3166:-2", "Rakovník"),
  Cz_311("CZ-311", "urn:iso:std:iso:3166:-2", "České Budějovice"),
  Cz_312("CZ-312", "urn:iso:std:iso:3166:-2", "Český Krumlov"),
  Cz_313("CZ-313", "urn:iso:std:iso:3166:-2", "Jindřichův Hradec"),
  Cz_314("CZ-314", "urn:iso:std:iso:3166:-2", "Písek"),
  Cz_315("CZ-315", "urn:iso:std:iso:3166:-2", "Prachatice"),
  Cz_316("CZ-316", "urn:iso:std:iso:3166:-2", "Strakonice"),
  Cz_317("CZ-317", "urn:iso:std:iso:3166:-2", "Tábor"),
  Cz_321("CZ-321", "urn:iso:std:iso:3166:-2", "Domažlice"),
  Cz_322("CZ-322", "urn:iso:std:iso:3166:-2", "Klatovy"),
  Cz_323("CZ-323", "urn:iso:std:iso:3166:-2", "Plzeň-město"),
  Cz_324("CZ-324", "urn:iso:std:iso:3166:-2", "Plzeň-jih"),
  Cz_325("CZ-325", "urn:iso:std:iso:3166:-2", "Plzeň-sever"),
  Cz_326("CZ-326", "urn:iso:std:iso:3166:-2", "Rokycany"),
  Cz_327("CZ-327", "urn:iso:std:iso:3166:-2", "Tachov"),
  Cz_411("CZ-411", "urn:iso:std:iso:3166:-2", "Cheb"),
  Cz_412("CZ-412", "urn:iso:std:iso:3166:-2", "Karlovy Vary"),
  Cz_413("CZ-413", "urn:iso:std:iso:3166:-2", "Sokolov"),
  Cz_421("CZ-421", "urn:iso:std:iso:3166:-2", "Děčín"),
  Cz_422("CZ-422", "urn:iso:std:iso:3166:-2", "Chomutov"),
  Cz_423("CZ-423", "urn:iso:std:iso:3166:-2", "Litoměřice"),
  Cz_424("CZ-424", "urn:iso:std:iso:3166:-2", "Louny"),
  Cz_425("CZ-425", "urn:iso:std:iso:3166:-2", "Most"),
  Cz_426("CZ-426", "urn:iso:std:iso:3166:-2", "Teplice"),
  Cz_427("CZ-427", "urn:iso:std:iso:3166:-2", "Ústí nad Labem"),
  Cz_511("CZ-511", "urn:iso:std:iso:3166:-2", "Česká Lípa"),
  Cz_512("CZ-512", "urn:iso:std:iso:3166:-2", "Jablonec nad Nisou"),
  Cz_513("CZ-513", "urn:iso:std:iso:3166:-2", "Liberec"),
  Cz_514("CZ-514", "urn:iso:std:iso:3166:-2", "Semily"),
  _001("001", "http://unstats.un.org/unsd/methods/m49/m49.htm", "World"),
  _002("002", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Africa"),
  _014("014", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Eastern Africa"),
  _017("017", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Middle Africa"),
  _015("015", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Northern Africa"),
  _018("018", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Southern Africa"),
  _011("011", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Western Africa"),
  _019("019", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Americas"),
  _419("419", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Latin America and the Caribbean"),
  _029("029", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Caribbean"),
  _013("013", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Central America"),
  _005("005", "http://unstats.un.org/unsd/methods/m49/m49.htm", "South America"),
  _021("021", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Northern America a/"),
  _142("142", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Asia"),
  _143("143", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Central Asia"),
  _030("030", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Eastern Asia"),
  _034("034", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Southern Asia"),
  _035("035", "http://unstats.un.org/unsd/methods/m49/m49.htm", "South-Eastern Asia"),
  _145("145", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Western Asia"),
  _150("150", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Europe"),
  _151("151", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Eastern Europe"),
  _154("154", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Northern Europe"),
  _039("039", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Southern Europe"),
  _155("155", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Western Europe"),
  _009("009", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Oceania"),
  _053("053", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Australia and New Zealand"),
  _054("054", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Melanesia"),
  _057("057", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Micronesia"),
  _061("061", "http://unstats.un.org/unsd/methods/m49/m49.htm", "Polynesia");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): JurisdictionValueSet =
      when (code) {
        "AD" -> Ad
        "AE" -> Ae
        "AF" -> Af
        "AG" -> Ag
        "AI" -> Ai
        "AL" -> Al
        "AM" -> Am
        "AO" -> Ao
        "AQ" -> Aq
        "AR" -> Ar
        "AS" -> As
        "AT" -> At
        "AU" -> Au
        "AW" -> Aw
        "AX" -> Ax
        "AZ" -> Az
        "BA" -> Ba
        "BB" -> Bb
        "BD" -> Bd
        "BE" -> Be
        "BF" -> Bf
        "BG" -> Bg
        "BH" -> Bh
        "BI" -> Bi
        "BJ" -> Bj
        "BL" -> Bl
        "BM" -> Bm
        "BN" -> Bn
        "BO" -> Bo
        "BQ" -> Bq
        "BR" -> Br
        "BS" -> Bs
        "BT" -> Bt
        "BV" -> Bv
        "BW" -> Bw
        "BY" -> By
        "BZ" -> Bz
        "CA" -> Ca
        "CC" -> Cc
        "CD" -> Cd
        "CF" -> Cf
        "CG" -> Cg
        "CH" -> Ch
        "CI" -> Ci
        "CK" -> Ck
        "CL" -> Cl
        "CM" -> Cm
        "CN" -> Cn
        "CO" -> Co
        "CR" -> Cr
        "CU" -> Cu
        "CV" -> Cv
        "CW" -> Cw
        "CX" -> Cx
        "CY" -> Cy
        "CZ" -> Cz
        "DE" -> De
        "DJ" -> Dj
        "DK" -> Dk
        "DM" -> Dm
        "DO" -> Do
        "DZ" -> Dz
        "EC" -> Ec
        "EE" -> Ee
        "EG" -> Eg
        "EH" -> Eh
        "ER" -> Er
        "ES" -> Es
        "ET" -> Et
        "FI" -> Fi
        "FJ" -> Fj
        "FK" -> Fk
        "FM" -> Fm
        "FO" -> Fo
        "FR" -> Fr
        "GA" -> Ga
        "GB" -> Gb
        "GD" -> Gd
        "GE" -> Ge
        "GF" -> Gf
        "GG" -> Gg
        "GH" -> Gh
        "GI" -> Gi
        "GL" -> Gl
        "GM" -> Gm
        "GN" -> Gn
        "GP" -> Gp
        "GQ" -> Gq
        "GR" -> Gr
        "GS" -> Gs
        "GT" -> Gt
        "GU" -> Gu
        "GW" -> Gw
        "GY" -> Gy
        "HK" -> Hk
        "HM" -> Hm
        "HN" -> Hn
        "HR" -> Hr
        "HT" -> Ht
        "HU" -> Hu
        "ID" -> Id
        "IE" -> Ie
        "IL" -> Il
        "IM" -> Im
        "IN" -> In
        "IO" -> Io
        "IQ" -> Iq
        "IR" -> Ir
        "IS" -> Is
        "IT" -> It
        "JE" -> Je
        "JM" -> Jm
        "JO" -> Jo
        "JP" -> Jp
        "KE" -> Ke
        "KG" -> Kg
        "KH" -> Kh
        "KI" -> Ki
        "KM" -> Km
        "KN" -> Kn
        "KP" -> Kp
        "KR" -> Kr
        "KW" -> Kw
        "KY" -> Ky
        "KZ" -> Kz
        "LA" -> La
        "LB" -> Lb
        "LC" -> Lc
        "LI" -> Li
        "LK" -> Lk
        "LR" -> Lr
        "LS" -> Ls
        "LT" -> Lt
        "LU" -> Lu
        "LV" -> Lv
        "LY" -> Ly
        "MA" -> Ma
        "MC" -> Mc
        "MD" -> Md
        "ME" -> Me
        "MF" -> Mf
        "MG" -> Mg
        "MH" -> Mh
        "MK" -> Mk
        "ML" -> Ml
        "MM" -> Mm
        "MN" -> Mn
        "MO" -> Mo
        "MP" -> Mp
        "MQ" -> Mq
        "MR" -> Mr
        "MS" -> Ms
        "MT" -> Mt
        "MU" -> Mu
        "MV" -> Mv
        "MW" -> Mw
        "MX" -> Mx
        "MY" -> My
        "MZ" -> Mz
        "NA" -> Na
        "NC" -> Nc
        "NE" -> Ne
        "NF" -> Nf
        "NG" -> Ng
        "NI" -> Ni
        "NL" -> Nl
        "NO" -> No
        "NP" -> Np
        "NR" -> Nr
        "NU" -> Nu
        "NZ" -> Nz
        "OM" -> Om
        "PA" -> Pa
        "PE" -> Pe
        "PF" -> Pf
        "PG" -> Pg
        "PH" -> Ph
        "PK" -> Pk
        "PL" -> Pl
        "PM" -> Pm
        "PN" -> Pn
        "PR" -> Pr
        "PS" -> Ps
        "PT" -> Pt
        "PW" -> Pw
        "PY" -> Py
        "QA" -> Qa
        "RE" -> Re
        "RO" -> Ro
        "RS" -> Rs
        "RU" -> Ru
        "RW" -> Rw
        "SA" -> Sa
        "SB" -> Sb
        "SC" -> Sc
        "SD" -> Sd
        "SE" -> Se
        "SG" -> Sg
        "SH" -> Sh
        "SI" -> Si
        "SJ" -> Sj
        "SK" -> Sk
        "SL" -> Sl
        "SM" -> Sm
        "SN" -> Sn
        "SO" -> So
        "SR" -> Sr
        "SS" -> Ss
        "ST" -> St
        "SV" -> Sv
        "SX" -> Sx
        "SY" -> Sy
        "SZ" -> Sz
        "TC" -> Tc
        "TD" -> Td
        "TF" -> Tf
        "TG" -> Tg
        "TH" -> Th
        "TJ" -> Tj
        "TK" -> Tk
        "TL" -> Tl
        "TM" -> Tm
        "TN" -> Tn
        "TO" -> To
        "TR" -> Tr
        "TT" -> Tt
        "TV" -> Tv
        "TW" -> Tw
        "TZ" -> Tz
        "UA" -> Ua
        "UG" -> Ug
        "UM" -> Um
        "US" -> Us
        "UY" -> Uy
        "UZ" -> Uz
        "VA" -> Va
        "VC" -> Vc
        "VE" -> Ve
        "VG" -> Vg
        "VI" -> Vi
        "VN" -> Vn
        "VU" -> Vu
        "WF" -> Wf
        "WS" -> Ws
        "YE" -> Ye
        "YT" -> Yt
        "ZA" -> Za
        "ZM" -> Zm
        "ZW" -> Zw
        "ABW" -> Abw
        "AFG" -> Afg
        "AGO" -> Ago
        "AIA" -> Aia
        "ALA" -> Ala
        "ALB" -> Alb
        "AND" -> And
        "ARE" -> Are
        "ARG" -> Arg
        "ARM" -> Arm
        "ASM" -> Asm
        "ATA" -> Ata
        "ATF" -> Atf
        "ATG" -> Atg
        "AUS" -> Aus
        "AUT" -> Aut
        "AZE" -> Aze
        "BDI" -> Bdi
        "BEL" -> Bel
        "BEN" -> Ben
        "BES" -> Bes
        "BFA" -> Bfa
        "BGD" -> Bgd
        "BGR" -> Bgr
        "BHR" -> Bhr
        "BHS" -> Bhs
        "BIH" -> Bih
        "BLM" -> Blm
        "BLR" -> Blr
        "BLZ" -> Blz
        "BMU" -> Bmu
        "BOL" -> Bol
        "BRA" -> Bra
        "BRB" -> Brb
        "BRN" -> Brn
        "BTN" -> Btn
        "BVT" -> Bvt
        "BWA" -> Bwa
        "CAF" -> Caf
        "CAN" -> Can
        "CCK" -> Cck
        "CHE" -> Che
        "CHL" -> Chl
        "CHN" -> Chn
        "CIV" -> Civ
        "CMR" -> Cmr
        "COD" -> Cod
        "COG" -> Cog
        "COK" -> Cok
        "COL" -> Col
        "COM" -> Com
        "CPV" -> Cpv
        "CRI" -> Cri
        "CUB" -> Cub
        "CUW" -> Cuw
        "CXR" -> Cxr
        "CYM" -> Cym
        "CYP" -> Cyp
        "CZE" -> Cze
        "DEU" -> Deu
        "DJI" -> Dji
        "DMA" -> Dma
        "DNK" -> Dnk
        "DOM" -> Dom
        "DZA" -> Dza
        "ECU" -> Ecu
        "EGY" -> Egy
        "ERI" -> Eri
        "ESH" -> Esh
        "ESP" -> Esp
        "EST" -> Est
        "ETH" -> Eth
        "FIN" -> Fin
        "FJI" -> Fji
        "FLK" -> Flk
        "FRA" -> Fra
        "FRO" -> Fro
        "FSM" -> Fsm
        "GAB" -> Gab
        "GBR" -> Gbr
        "GEO" -> Geo
        "GGY" -> Ggy
        "GHA" -> Gha
        "GIB" -> Gib
        "GIN" -> Gin
        "GLP" -> Glp
        "GMB" -> Gmb
        "GNB" -> Gnb
        "GNQ" -> Gnq
        "GRC" -> Grc
        "GRD" -> Grd
        "GRL" -> Grl
        "GTM" -> Gtm
        "GUF" -> Guf
        "GUM" -> Gum
        "GUY" -> Guy
        "HKG" -> Hkg
        "HMD" -> Hmd
        "HND" -> Hnd
        "HRV" -> Hrv
        "HTI" -> Hti
        "HUN" -> Hun
        "IDN" -> Idn
        "IMN" -> Imn
        "IND" -> Ind
        "IOT" -> Iot
        "IRL" -> Irl
        "IRN" -> Irn
        "IRQ" -> Irq
        "ISL" -> Isl
        "ISR" -> Isr
        "ITA" -> Ita
        "JAM" -> Jam
        "JEY" -> Jey
        "JOR" -> Jor
        "JPN" -> Jpn
        "KAZ" -> Kaz
        "KEN" -> Ken
        "KGZ" -> Kgz
        "KHM" -> Khm
        "KIR" -> Kir
        "KNA" -> Kna
        "KOR" -> Kor
        "KWT" -> Kwt
        "LAO" -> Lao
        "LBN" -> Lbn
        "LBR" -> Lbr
        "LBY" -> Lby
        "LCA" -> Lca
        "LIE" -> Lie
        "LKA" -> Lka
        "LSO" -> Lso
        "LTU" -> Ltu
        "LUX" -> Lux
        "LVA" -> Lva
        "MAC" -> Mac
        "MAF" -> Maf
        "MAR" -> Mar
        "MCO" -> Mco
        "MDA" -> Mda
        "MDG" -> Mdg
        "MDV" -> Mdv
        "MEX" -> Mex
        "MHL" -> Mhl
        "MKD" -> Mkd
        "MLI" -> Mli
        "MLT" -> Mlt
        "MMR" -> Mmr
        "MNE" -> Mne
        "MNG" -> Mng
        "MNP" -> Mnp
        "MOZ" -> Moz
        "MRT" -> Mrt
        "MSR" -> Msr
        "MTQ" -> Mtq
        "MUS" -> Mus
        "MWI" -> Mwi
        "MYS" -> Mys
        "MYT" -> Myt
        "NAM" -> Nam
        "NCL" -> Ncl
        "NER" -> Ner
        "NFK" -> Nfk
        "NGA" -> Nga
        "NIC" -> Nic
        "NIU" -> Niu
        "NLD" -> Nld
        "NOR" -> Nor
        "NPL" -> Npl
        "NRU" -> Nru
        "NZL" -> Nzl
        "OMN" -> Omn
        "PAK" -> Pak
        "PAN" -> Pan
        "PCN" -> Pcn
        "PER" -> Per
        "PHL" -> Phl
        "PLW" -> Plw
        "PNG" -> Png
        "POL" -> Pol
        "PRI" -> Pri
        "PRK" -> Prk
        "PRT" -> Prt
        "PRY" -> Pry
        "PSE" -> Pse
        "PYF" -> Pyf
        "QAT" -> Qat
        "REU" -> Reu
        "ROU" -> Rou
        "RUS" -> Rus
        "RWA" -> Rwa
        "SAU" -> Sau
        "SDN" -> Sdn
        "SEN" -> Sen
        "SGP" -> Sgp
        "SGS" -> Sgs
        "SHN" -> Shn
        "SJM" -> Sjm
        "SLB" -> Slb
        "SLE" -> Sle
        "SLV" -> Slv
        "SMR" -> Smr
        "SOM" -> Som
        "SPM" -> Spm
        "SRB" -> Srb
        "SSD" -> Ssd
        "STP" -> Stp
        "SUR" -> Sur
        "SVK" -> Svk
        "SVN" -> Svn
        "SWE" -> Swe
        "SWZ" -> Swz
        "SXM" -> Sxm
        "SYC" -> Syc
        "SYR" -> Syr
        "TCA" -> Tca
        "TCD" -> Tcd
        "TGO" -> Tgo
        "THA" -> Tha
        "TJK" -> Tjk
        "TKL" -> Tkl
        "TKM" -> Tkm
        "TLS" -> Tls
        "TON" -> Ton
        "TTO" -> Tto
        "TUN" -> Tun
        "TUR" -> Tur
        "TUV" -> Tuv
        "TWN" -> Twn
        "TZA" -> Tza
        "UGA" -> Uga
        "UKR" -> Ukr
        "UMI" -> Umi
        "URY" -> Ury
        "USA" -> Usa
        "UZB" -> Uzb
        "VAT" -> Vat
        "VCT" -> Vct
        "VEN" -> Ven
        "VGB" -> Vgb
        "VIR" -> Vir
        "VNM" -> Vnm
        "VUT" -> Vut
        "WLF" -> Wlf
        "WSM" -> Wsm
        "YEM" -> Yem
        "ZAF" -> Zaf
        "ZMB" -> Zmb
        "ZWE" -> Zwe
        "004" -> _004
        "008" -> _008
        "010" -> _010
        "012" -> _012
        "016" -> _016
        "020" -> _020
        "024" -> _024
        "028" -> _028
        "031" -> _031
        "032" -> _032
        "036" -> _036
        "040" -> _040
        "044" -> _044
        "048" -> _048
        "050" -> _050
        "051" -> _051
        "052" -> _052
        "056" -> _056
        "060" -> _060
        "064" -> _064
        "068" -> _068
        "070" -> _070
        "072" -> _072
        "074" -> _074
        "076" -> _076
        "084" -> _084
        "086" -> _086
        "090" -> _090
        "092" -> _092
        "096" -> _096
        "100" -> _100
        "104" -> _104
        "108" -> _108
        "112" -> _112
        "116" -> _116
        "120" -> _120
        "124" -> _124
        "132" -> _132
        "136" -> _136
        "140" -> _140
        "144" -> _144
        "148" -> _148
        "152" -> _152
        "156" -> _156
        "158" -> _158
        "162" -> _162
        "166" -> _166
        "170" -> _170
        "174" -> _174
        "175" -> _175
        "178" -> _178
        "180" -> _180
        "184" -> _184
        "188" -> _188
        "191" -> _191
        "192" -> _192
        "196" -> _196
        "203" -> _203
        "204" -> _204
        "208" -> _208
        "212" -> _212
        "214" -> _214
        "218" -> _218
        "222" -> _222
        "226" -> _226
        "231" -> _231
        "232" -> _232
        "233" -> _233
        "234" -> _234
        "238" -> _238
        "239" -> _239
        "242" -> _242
        "246" -> _246
        "248" -> _248
        "250" -> _250
        "254" -> _254
        "258" -> _258
        "260" -> _260
        "262" -> _262
        "266" -> _266
        "268" -> _268
        "270" -> _270
        "275" -> _275
        "276" -> _276
        "288" -> _288
        "292" -> _292
        "296" -> _296
        "300" -> _300
        "304" -> _304
        "308" -> _308
        "312" -> _312
        "316" -> _316
        "320" -> _320
        "324" -> _324
        "328" -> _328
        "332" -> _332
        "334" -> _334
        "336" -> _336
        "340" -> _340
        "344" -> _344
        "348" -> _348
        "352" -> _352
        "356" -> _356
        "360" -> _360
        "364" -> _364
        "368" -> _368
        "372" -> _372
        "376" -> _376
        "380" -> _380
        "384" -> _384
        "388" -> _388
        "392" -> _392
        "398" -> _398
        "400" -> _400
        "404" -> _404
        "408" -> _408
        "410" -> _410
        "414" -> _414
        "417" -> _417
        "418" -> _418
        "422" -> _422
        "426" -> _426
        "428" -> _428
        "430" -> _430
        "434" -> _434
        "438" -> _438
        "440" -> _440
        "442" -> _442
        "446" -> _446
        "450" -> _450
        "454" -> _454
        "458" -> _458
        "462" -> _462
        "466" -> _466
        "470" -> _470
        "474" -> _474
        "478" -> _478
        "480" -> _480
        "484" -> _484
        "492" -> _492
        "496" -> _496
        "498" -> _498
        "499" -> _499
        "500" -> _500
        "504" -> _504
        "508" -> _508
        "512" -> _512
        "516" -> _516
        "520" -> _520
        "524" -> _524
        "528" -> _528
        "531" -> _531
        "533" -> _533
        "534" -> _534
        "535" -> _535
        "540" -> _540
        "548" -> _548
        "554" -> _554
        "558" -> _558
        "562" -> _562
        "566" -> _566
        "570" -> _570
        "574" -> _574
        "578" -> _578
        "580" -> _580
        "581" -> _581
        "583" -> _583
        "584" -> _584
        "585" -> _585
        "586" -> _586
        "591" -> _591
        "598" -> _598
        "600" -> _600
        "604" -> _604
        "608" -> _608
        "612" -> _612
        "616" -> _616
        "620" -> _620
        "624" -> _624
        "626" -> _626
        "630" -> _630
        "634" -> _634
        "638" -> _638
        "642" -> _642
        "643" -> _643
        "646" -> _646
        "652" -> _652
        "654" -> _654
        "659" -> _659
        "660" -> _660
        "662" -> _662
        "663" -> _663
        "666" -> _666
        "670" -> _670
        "674" -> _674
        "678" -> _678
        "682" -> _682
        "686" -> _686
        "688" -> _688
        "690" -> _690
        "694" -> _694
        "702" -> _702
        "703" -> _703
        "704" -> _704
        "705" -> _705
        "706" -> _706
        "710" -> _710
        "716" -> _716
        "724" -> _724
        "728" -> _728
        "729" -> _729
        "732" -> _732
        "740" -> _740
        "744" -> _744
        "748" -> _748
        "752" -> _752
        "756" -> _756
        "760" -> _760
        "762" -> _762
        "764" -> _764
        "768" -> _768
        "772" -> _772
        "776" -> _776
        "780" -> _780
        "784" -> _784
        "788" -> _788
        "792" -> _792
        "795" -> _795
        "796" -> _796
        "798" -> _798
        "800" -> _800
        "804" -> _804
        "807" -> _807
        "818" -> _818
        "826" -> _826
        "831" -> _831
        "832" -> _832
        "833" -> _833
        "834" -> _834
        "840" -> _840
        "850" -> _850
        "854" -> _854
        "858" -> _858
        "860" -> _860
        "862" -> _862
        "876" -> _876
        "882" -> _882
        "887" -> _887
        "894" -> _894
        "AF-BAL" -> Af_Bal
        "AF-BAM" -> Af_Bam
        "AF-BDG" -> Af_Bdg
        "AF-BDS" -> Af_Bds
        "AF-BGL" -> Af_Bgl
        "AF-DAY" -> Af_Day
        "AF-FRA" -> Af_Fra
        "AF-FYB" -> Af_Fyb
        "AF-GHA" -> Af_Gha
        "AF-GHO" -> Af_Gho
        "AF-HEL" -> Af_Hel
        "AF-HER" -> Af_Her
        "AF-JOW" -> Af_Jow
        "AF-KAB" -> Af_Kab
        "AF-KAN" -> Af_Kan
        "AF-KAP" -> Af_Kap
        "AF-KDZ" -> Af_Kdz
        "AF-KHO" -> Af_Kho
        "AF-KNR" -> Af_Knr
        "AF-LAG" -> Af_Lag
        "AF-LOG" -> Af_Log
        "AF-NAN" -> Af_Nan
        "AF-NIM" -> Af_Nim
        "AF-NUR" -> Af_Nur
        "AF-PAN" -> Af_Pan
        "AF-PAR" -> Af_Par
        "AF-PIA" -> Af_Pia
        "AF-PKA" -> Af_Pka
        "AF-SAM" -> Af_Sam
        "AF-SAR" -> Af_Sar
        "AF-TAK" -> Af_Tak
        "AF-URU" -> Af_Uru
        "AF-WAR" -> Af_War
        "AF-ZAB" -> Af_Zab
        "AX-AX" -> Ax_Ax
        "AL-01" -> Al_01
        "AL-02" -> Al_02
        "AL-03" -> Al_03
        "AL-04" -> Al_04
        "AL-05" -> Al_05
        "AL-06" -> Al_06
        "AL-07" -> Al_07
        "AL-08" -> Al_08
        "AL-09" -> Al_09
        "AL-10" -> Al_10
        "AL-11" -> Al_11
        "AL-12" -> Al_12
        "AL-BR" -> Al_Br
        "AL-BU" -> Al_Bu
        "AL-DI" -> Al_Di
        "AL-DL" -> Al_Dl
        "AL-DR" -> Al_Dr
        "AL-DV" -> Al_Dv
        "AL-EL" -> Al_El
        "AL-ER" -> Al_Er
        "AL-FR" -> Al_Fr
        "AL-GJ" -> Al_Gj
        "AL-GR" -> Al_Gr
        "AL-HA" -> Al_Ha
        "AL-KA" -> Al_Ka
        "AL-KB" -> Al_Kb
        "AL-KC" -> Al_Kc
        "AL-KO" -> Al_Ko
        "AL-KR" -> Al_Kr
        "AL-KU" -> Al_Ku
        "AL-LB" -> Al_Lb
        "AL-LE" -> Al_Le
        "AL-LU" -> Al_Lu
        "AL-MK" -> Al_Mk
        "AL-MM" -> Al_Mm
        "AL-MR" -> Al_Mr
        "AL-MT" -> Al_Mt
        "AL-PG" -> Al_Pg
        "AL-PQ" -> Al_Pq
        "AL-PR" -> Al_Pr
        "AL-PU" -> Al_Pu
        "AL-SH" -> Al_Sh
        "AL-SK" -> Al_Sk
        "AL-SR" -> Al_Sr
        "AL-TE" -> Al_Te
        "AL-TP" -> Al_Tp
        "AL-TR" -> Al_Tr
        "AL-VL" -> Al_Vl
        "DZ-01" -> Dz_01
        "DZ-02" -> Dz_02
        "DZ-03" -> Dz_03
        "DZ-04" -> Dz_04
        "DZ-05" -> Dz_05
        "DZ-06" -> Dz_06
        "DZ-07" -> Dz_07
        "DZ-08" -> Dz_08
        "DZ-09" -> Dz_09
        "DZ-10" -> Dz_10
        "DZ-11" -> Dz_11
        "DZ-12" -> Dz_12
        "DZ-13" -> Dz_13
        "DZ-14" -> Dz_14
        "DZ-15" -> Dz_15
        "DZ-16" -> Dz_16
        "DZ-17" -> Dz_17
        "DZ-18" -> Dz_18
        "DZ-19" -> Dz_19
        "DZ-20" -> Dz_20
        "DZ-21" -> Dz_21
        "DZ-22" -> Dz_22
        "DZ-23" -> Dz_23
        "DZ-24" -> Dz_24
        "DZ-25" -> Dz_25
        "DZ-26" -> Dz_26
        "DZ-27" -> Dz_27
        "DZ-28" -> Dz_28
        "DZ-29" -> Dz_29
        "DZ-30" -> Dz_30
        "DZ-31" -> Dz_31
        "DZ-32" -> Dz_32
        "DZ-33" -> Dz_33
        "DZ-34" -> Dz_34
        "DZ-35" -> Dz_35
        "DZ-36" -> Dz_36
        "DZ-37" -> Dz_37
        "DZ-38" -> Dz_38
        "DZ-39" -> Dz_39
        "DZ-40" -> Dz_40
        "DZ-41" -> Dz_41
        "DZ-42" -> Dz_42
        "DZ-43" -> Dz_43
        "DZ-44" -> Dz_44
        "DZ-45" -> Dz_45
        "DZ-46" -> Dz_46
        "DZ-47" -> Dz_47
        "DZ-48" -> Dz_48
        "AS-AS" -> As_As
        "AD-02" -> Ad_02
        "AD-03" -> Ad_03
        "AD-04" -> Ad_04
        "AD-05" -> Ad_05
        "AD-06" -> Ad_06
        "AD-07" -> Ad_07
        "AD-08" -> Ad_08
        "AO-BGO" -> Ao_Bgo
        "AO-BGU" -> Ao_Bgu
        "AO-BIE" -> Ao_Bie
        "AO-CAB" -> Ao_Cab
        "AO-CCU" -> Ao_Ccu
        "AO-CNN" -> Ao_Cnn
        "AO-CNO" -> Ao_Cno
        "AO-CUS" -> Ao_Cus
        "AO-HUA" -> Ao_Hua
        "AO-HUI" -> Ao_Hui
        "AO-LNO" -> Ao_Lno
        "AO-LSU" -> Ao_Lsu
        "AO-LUA" -> Ao_Lua
        "AO-MAL" -> Ao_Mal
        "AO-MOX" -> Ao_Mox
        "AO-NAM" -> Ao_Nam
        "AO-UIG" -> Ao_Uig
        "AO-ZAI" -> Ao_Zai
        "AI-AI" -> Ai_Ai
        "AQ-AQ" -> Aq_Aq
        "AG-03" -> Ag_03
        "AG-04" -> Ag_04
        "AG-05" -> Ag_05
        "AG-06" -> Ag_06
        "AG-07" -> Ag_07
        "AG-08" -> Ag_08
        "AG-10" -> Ag_10
        "AG-11" -> Ag_11
        "AR-A" -> Ar_A
        "AR-B" -> Ar_B
        "AR-C" -> Ar_C
        "AR-D" -> Ar_D
        "AR-E" -> Ar_E
        "AR-F" -> Ar_F
        "AR-G" -> Ar_G
        "AR-H" -> Ar_H
        "AR-J" -> Ar_J
        "AR-K" -> Ar_K
        "AR-L" -> Ar_L
        "AR-M" -> Ar_M
        "AR-N" -> Ar_N
        "AR-P" -> Ar_P
        "AR-Q" -> Ar_Q
        "AR-R" -> Ar_R
        "AR-S" -> Ar_S
        "AR-T" -> Ar_T
        "AR-U" -> Ar_U
        "AR-V" -> Ar_V
        "AR-W" -> Ar_W
        "AR-X" -> Ar_X
        "AR-Y" -> Ar_Y
        "AR-Z" -> Ar_Z
        "AM-AG" -> Am_Ag
        "AM-AR" -> Am_Ar
        "AM-AV" -> Am_Av
        "AM-ER" -> Am_Er
        "AM-GR" -> Am_Gr
        "AM-KT" -> Am_Kt
        "AM-LO" -> Am_Lo
        "AM-SH" -> Am_Sh
        "AM-SU" -> Am_Su
        "AM-TV" -> Am_Tv
        "AM-VD" -> Am_Vd
        "AW-AW" -> Aw_Aw
        "AU-ACT" -> Au_Act
        "AU-NSW" -> Au_Nsw
        "AU-NT" -> Au_Nt
        "AU-QLD" -> Au_Qld
        "AU-SA" -> Au_Sa
        "AU-TAS" -> Au_Tas
        "AU-VIC" -> Au_Vic
        "AU-WA" -> Au_Wa
        "AT-1" -> At_1
        "AT-2" -> At_2
        "AT-3" -> At_3
        "AT-4" -> At_4
        "AT-5" -> At_5
        "AT-6" -> At_6
        "AT-7" -> At_7
        "AT-8" -> At_8
        "AT-9" -> At_9
        "AZ-ABS" -> Az_Abs
        "AZ-AGA" -> Az_Aga
        "AZ-AGC" -> Az_Agc
        "AZ-AGM" -> Az_Agm
        "AZ-AGS" -> Az_Ags
        "AZ-AGU" -> Az_Agu
        "AZ-AST" -> Az_Ast
        "AZ-BA" -> Az_Ba
        "AZ-BAB" -> Az_Bab
        "AZ-BAL" -> Az_Bal
        "AZ-BAR" -> Az_Bar
        "AZ-BEY" -> Az_Bey
        "AZ-BIL" -> Az_Bil
        "AZ-CAB" -> Az_Cab
        "AZ-CAL" -> Az_Cal
        "AZ-CUL" -> Az_Cul
        "AZ-DAS" -> Az_Das
        "AZ-FUZ" -> Az_Fuz
        "AZ-GAD" -> Az_Gad
        "AZ-GA" -> Az_Ga
        "AZ-GOR" -> Az_Gor
        "AZ-GOY" -> Az_Goy
        "AZ-GYG" -> Az_Gyg
        "AZ-HAC" -> Az_Hac
        "AZ-IMI" -> Az_Imi
        "AZ-ISM" -> Az_Ism
        "AZ-KAL" -> Az_Kal
        "AZ-KAN" -> Az_Kan
        "AZ-KUR" -> Az_Kur
        "AZ-LAC" -> Az_Lac
        "AZ-LA" -> Az_La
        "AZ-LAN" -> Az_Lan
        "AZ-LER" -> Az_Ler
        "AZ-MAS" -> Az_Mas
        "AZ-MI" -> Az_Mi
        "AZ-NA" -> Az_Na
        "AZ-NEF" -> Az_Nef
        "AZ-NV" -> Az_Nv
        "AZ-NX" -> Az_Nx
        "AZ-OGU" -> Az_Ogu
        "AZ-ORD" -> Az_Ord
        "AZ-QAB" -> Az_Qab
        "AZ-QAX" -> Az_Qax
        "AZ-QAZ" -> Az_Qaz
        "AZ-QBA" -> Az_Qba
        "AZ-QBI" -> Az_Qbi
        "AZ-QOB" -> Az_Qob
        "AZ-QUS" -> Az_Qus
        "AZ-SAB" -> Az_Sab
        "AZ-SAD" -> Az_Sad
        "AZ-SAH" -> Az_Sah
        "AZ-SAK" -> Az_Sak
        "AZ-SAL" -> Az_Sal
        "AZ-SAR" -> Az_Sar
        "AZ-SA" -> Az_Sa
        "AZ-SAT" -> Az_Sat
        "AZ-SBN" -> Az_Sbn
        "AZ-SIY" -> Az_Siy
        "AZ-SKR" -> Az_Skr
        "AZ-SMI" -> Az_Smi
        "AZ-SM" -> Az_Sm
        "AZ-SMX" -> Az_Smx
        "AZ-SR" -> Az_Sr
        "AZ-SUS" -> Az_Sus
        "AZ-TAR" -> Az_Tar
        "AZ-TOV" -> Az_Tov
        "AZ-UCA" -> Az_Uca
        "AZ-XAC" -> Az_Xac
        "AZ-XA" -> Az_Xa
        "AZ-XCI" -> Az_Xci
        "AZ-XIZ" -> Az_Xiz
        "AZ-XVD" -> Az_Xvd
        "AZ-YAR" -> Az_Yar
        "AZ-YEV" -> Az_Yev
        "AZ-YE" -> Az_Ye
        "AZ-ZAN" -> Az_Zan
        "AZ-ZAQ" -> Az_Zaq
        "AZ-ZAR" -> Az_Zar
        "BS-AK" -> Bs_Ak
        "BS-BI" -> Bs_Bi
        "BS-BP" -> Bs_Bp
        "BS-BY" -> Bs_By
        "BS-CE" -> Bs_Ce
        "BS-CI" -> Bs_Ci
        "BS-CK" -> Bs_Ck
        "BS-CO" -> Bs_Co
        "BS-CS" -> Bs_Cs
        "BS-EG" -> Bs_Eg
        "BS-EX" -> Bs_Ex
        "BS-FP" -> Bs_Fp
        "BS-GC" -> Bs_Gc
        "BS-HI" -> Bs_Hi
        "BS-HT" -> Bs_Ht
        "BS-IN" -> Bs_In
        "BS-LI" -> Bs_Li
        "BS-MC" -> Bs_Mc
        "BS-MG" -> Bs_Mg
        "BS-MI" -> Bs_Mi
        "BS-NE" -> Bs_Ne
        "BS-NO" -> Bs_No
        "BS-NS" -> Bs_Ns
        "BS-RC" -> Bs_Rc
        "BS-RI" -> Bs_Ri
        "BS-SA" -> Bs_Sa
        "BS-SE" -> Bs_Se
        "BS-SO" -> Bs_So
        "BS-SS" -> Bs_Ss
        "BS-SW" -> Bs_Sw
        "BS-WG" -> Bs_Wg
        "BH-13" -> Bh_13
        "BH-14" -> Bh_14
        "BH-15" -> Bh_15
        "BH-16" -> Bh_16
        "BH-17" -> Bh_17
        "BD-01" -> Bd_01
        "BD-02" -> Bd_02
        "BD-03" -> Bd_03
        "BD-04" -> Bd_04
        "BD-05" -> Bd_05
        "BD-06" -> Bd_06
        "BD-07" -> Bd_07
        "BD-08" -> Bd_08
        "BD-09" -> Bd_09
        "BD-10" -> Bd_10
        "BD-11" -> Bd_11
        "BD-12" -> Bd_12
        "BD-13" -> Bd_13
        "BD-14" -> Bd_14
        "BD-15" -> Bd_15
        "BD-16" -> Bd_16
        "BD-17" -> Bd_17
        "BD-18" -> Bd_18
        "BD-19" -> Bd_19
        "BD-20" -> Bd_20
        "BD-21" -> Bd_21
        "BD-22" -> Bd_22
        "BD-23" -> Bd_23
        "BD-24" -> Bd_24
        "BD-25" -> Bd_25
        "BD-26" -> Bd_26
        "BD-27" -> Bd_27
        "BD-28" -> Bd_28
        "BD-29" -> Bd_29
        "BD-30" -> Bd_30
        "BD-31" -> Bd_31
        "BD-32" -> Bd_32
        "BD-33" -> Bd_33
        "BD-34" -> Bd_34
        "BD-35" -> Bd_35
        "BD-36" -> Bd_36
        "BD-37" -> Bd_37
        "BD-38" -> Bd_38
        "BD-39" -> Bd_39
        "BD-40" -> Bd_40
        "BD-41" -> Bd_41
        "BD-42" -> Bd_42
        "BD-43" -> Bd_43
        "BD-44" -> Bd_44
        "BD-45" -> Bd_45
        "BD-46" -> Bd_46
        "BD-47" -> Bd_47
        "BD-48" -> Bd_48
        "BD-49" -> Bd_49
        "BD-50" -> Bd_50
        "BD-51" -> Bd_51
        "BD-52" -> Bd_52
        "BD-53" -> Bd_53
        "BD-54" -> Bd_54
        "BD-55" -> Bd_55
        "BD-56" -> Bd_56
        "BD-57" -> Bd_57
        "BD-58" -> Bd_58
        "BD-59" -> Bd_59
        "BD-60" -> Bd_60
        "BD-61" -> Bd_61
        "BD-62" -> Bd_62
        "BD-63" -> Bd_63
        "BD-64" -> Bd_64
        "BD-A" -> Bd_A
        "BD-B" -> Bd_B
        "BD-C" -> Bd_C
        "BD-D" -> Bd_D
        "BD-E" -> Bd_E
        "BD-F" -> Bd_F
        "BD-G" -> Bd_G
        "BB-01" -> Bb_01
        "BB-02" -> Bb_02
        "BB-03" -> Bb_03
        "BB-04" -> Bb_04
        "BB-05" -> Bb_05
        "BB-06" -> Bb_06
        "BB-07" -> Bb_07
        "BB-08" -> Bb_08
        "BB-09" -> Bb_09
        "BB-10" -> Bb_10
        "BB-11" -> Bb_11
        "BY-BR" -> By_Br
        "BY-HM" -> By_Hm
        "BY-HO" -> By_Ho
        "BY-HR" -> By_Hr
        "BY-MA" -> By_Ma
        "BY-MI" -> By_Mi
        "BY-VI" -> By_Vi
        "BE-BRU" -> Be_Bru
        "BE-VAN" -> Be_Van
        "BE-VBR" -> Be_Vbr
        "BE-VLG" -> Be_Vlg
        "BE-VLI" -> Be_Vli
        "BE-VOV" -> Be_Vov
        "BE-VWV" -> Be_Vwv
        "BE-WAL" -> Be_Wal
        "BE-WBR" -> Be_Wbr
        "BE-WHT" -> Be_Wht
        "BE-WLG" -> Be_Wlg
        "BE-WLX" -> Be_Wlx
        "BE-WNA" -> Be_Wna
        "BZ-BZ" -> Bz_Bz
        "BZ-CY" -> Bz_Cy
        "BZ-CZL" -> Bz_Czl
        "BZ-OW" -> Bz_Ow
        "BZ-SC" -> Bz_Sc
        "BZ-TOL" -> Bz_Tol
        "BJ-AK" -> Bj_Ak
        "BJ-AL" -> Bj_Al
        "BJ-AQ" -> Bj_Aq
        "BJ-BO" -> Bj_Bo
        "BJ-CO" -> Bj_Co
        "BJ-DO" -> Bj_Do
        "BJ-KO" -> Bj_Ko
        "BJ-LI" -> Bj_Li
        "BJ-MO" -> Bj_Mo
        "BJ-OU" -> Bj_Ou
        "BJ-PL" -> Bj_Pl
        "BJ-ZO" -> Bj_Zo
        "BM-BM" -> Bm_Bm
        "BT-11" -> Bt_11
        "BT-12" -> Bt_12
        "BT-13" -> Bt_13
        "BT-14" -> Bt_14
        "BT-15" -> Bt_15
        "BT-21" -> Bt_21
        "BT-22" -> Bt_22
        "BT-23" -> Bt_23
        "BT-24" -> Bt_24
        "BT-31" -> Bt_31
        "BT-32" -> Bt_32
        "BT-33" -> Bt_33
        "BT-34" -> Bt_34
        "BT-41" -> Bt_41
        "BT-42" -> Bt_42
        "BT-43" -> Bt_43
        "BT-44" -> Bt_44
        "BT-45" -> Bt_45
        "BT-GA" -> Bt_Ga
        "BT-TY" -> Bt_Ty
        "BO-B" -> Bo_B
        "BO-C" -> Bo_C
        "BO-H" -> Bo_H
        "BO-L" -> Bo_L
        "BO-N" -> Bo_N
        "BO-O" -> Bo_O
        "BO-P" -> Bo_P
        "BO-S" -> Bo_S
        "BO-T" -> Bo_T
        "BQ-BO" -> Bq_Bo
        "BQ-SA" -> Bq_Sa
        "BQ-SE" -> Bq_Se
        "BA-01" -> Ba_01
        "BA-02" -> Ba_02
        "BA-03" -> Ba_03
        "BA-04" -> Ba_04
        "BA-05" -> Ba_05
        "BA-06" -> Ba_06
        "BA-07" -> Ba_07
        "BA-08" -> Ba_08
        "BA-09" -> Ba_09
        "BA-10" -> Ba_10
        "BA-BIH" -> Ba_Bih
        "BA-BRC" -> Ba_Brc
        "BA-SRP" -> Ba_Srp
        "BW-CE" -> Bw_Ce
        "BW-CH" -> Bw_Ch
        "BW-FR" -> Bw_Fr
        "BW-GA" -> Bw_Ga
        "BW-GH" -> Bw_Gh
        "BW-JW" -> Bw_Jw
        "BW-KG" -> Bw_Kg
        "BW-KL" -> Bw_Kl
        "BW-KW" -> Bw_Kw
        "BW-LO" -> Bw_Lo
        "BW-NE" -> Bw_Ne
        "BW-NW" -> Bw_Nw
        "BW-SE" -> Bw_Se
        "BW-SO" -> Bw_So
        "BW-SP" -> Bw_Sp
        "BW-ST" -> Bw_St
        "BV-BV" -> Bv_Bv
        "BR-AC" -> Br_Ac
        "BR-AL" -> Br_Al
        "BR-AM" -> Br_Am
        "BR-AP" -> Br_Ap
        "BR-BA" -> Br_Ba
        "BR-CE" -> Br_Ce
        "BR-DF" -> Br_Df
        "BR-ES" -> Br_Es
        "BR-GO" -> Br_Go
        "BR-MA" -> Br_Ma
        "BR-MG" -> Br_Mg
        "BR-MS" -> Br_Ms
        "BR-MT" -> Br_Mt
        "BR-PA" -> Br_Pa
        "BR-PB" -> Br_Pb
        "BR-PE" -> Br_Pe
        "BR-PI" -> Br_Pi
        "BR-PR" -> Br_Pr
        "BR-RJ" -> Br_Rj
        "BR-RN" -> Br_Rn
        "BR-RO" -> Br_Ro
        "BR-RR" -> Br_Rr
        "BR-RS" -> Br_Rs
        "BR-SC" -> Br_Sc
        "BR-SE" -> Br_Se
        "BR-SP" -> Br_Sp
        "BR-TO" -> Br_To
        "IO-IO" -> Io_Io
        "BN-BE" -> Bn_Be
        "BN-BM" -> Bn_Bm
        "BN-TE" -> Bn_Te
        "BN-TU" -> Bn_Tu
        "BG-01" -> Bg_01
        "BG-02" -> Bg_02
        "BG-03" -> Bg_03
        "BG-04" -> Bg_04
        "BG-05" -> Bg_05
        "BG-06" -> Bg_06
        "BG-07" -> Bg_07
        "BG-08" -> Bg_08
        "BG-09" -> Bg_09
        "BG-10" -> Bg_10
        "BG-11" -> Bg_11
        "BG-12" -> Bg_12
        "BG-13" -> Bg_13
        "BG-14" -> Bg_14
        "BG-15" -> Bg_15
        "BG-16" -> Bg_16
        "BG-17" -> Bg_17
        "BG-18" -> Bg_18
        "BG-19" -> Bg_19
        "BG-20" -> Bg_20
        "BG-21" -> Bg_21
        "BG-22" -> Bg_22
        "BG-23" -> Bg_23
        "BG-24" -> Bg_24
        "BG-25" -> Bg_25
        "BG-26" -> Bg_26
        "BG-27" -> Bg_27
        "BG-28" -> Bg_28
        "BF-01" -> Bf_01
        "BF-02" -> Bf_02
        "BF-03" -> Bf_03
        "BF-04" -> Bf_04
        "BF-05" -> Bf_05
        "BF-06" -> Bf_06
        "BF-07" -> Bf_07
        "BF-08" -> Bf_08
        "BF-09" -> Bf_09
        "BF-10" -> Bf_10
        "BF-11" -> Bf_11
        "BF-12" -> Bf_12
        "BF-13" -> Bf_13
        "BF-BAL" -> Bf_Bal
        "BF-BAM" -> Bf_Bam
        "BF-BAN" -> Bf_Ban
        "BF-BAZ" -> Bf_Baz
        "BF-BGR" -> Bf_Bgr
        "BF-BLG" -> Bf_Blg
        "BF-BLK" -> Bf_Blk
        "BF-COM" -> Bf_Com
        "BF-GAN" -> Bf_Gan
        "BF-GNA" -> Bf_Gna
        "BF-GOU" -> Bf_Gou
        "BF-HOU" -> Bf_Hou
        "BF-IOB" -> Bf_Iob
        "BF-KAD" -> Bf_Kad
        "BF-KEN" -> Bf_Ken
        "BF-KMD" -> Bf_Kmd
        "BF-KMP" -> Bf_Kmp
        "BF-KOP" -> Bf_Kop
        "BF-KOS" -> Bf_Kos
        "BF-KOT" -> Bf_Kot
        "BF-KOW" -> Bf_Kow
        "BF-LER" -> Bf_Ler
        "BF-LOR" -> Bf_Lor
        "BF-MOU" -> Bf_Mou
        "BF-NAM" -> Bf_Nam
        "BF-NAO" -> Bf_Nao
        "BF-NAY" -> Bf_Nay
        "BF-NOU" -> Bf_Nou
        "BF-OUB" -> Bf_Oub
        "BF-OUD" -> Bf_Oud
        "BF-PAS" -> Bf_Pas
        "BF-PON" -> Bf_Pon
        "BF-SEN" -> Bf_Sen
        "BF-SIS" -> Bf_Sis
        "BF-SMT" -> Bf_Smt
        "BF-SNG" -> Bf_Sng
        "BF-SOM" -> Bf_Som
        "BF-SOR" -> Bf_Sor
        "BF-TAP" -> Bf_Tap
        "BF-TUI" -> Bf_Tui
        "BF-YAG" -> Bf_Yag
        "BF-YAT" -> Bf_Yat
        "BF-ZIR" -> Bf_Zir
        "BF-ZON" -> Bf_Zon
        "BF-ZOU" -> Bf_Zou
        "BI-BB" -> Bi_Bb
        "BI-BL" -> Bi_Bl
        "BI-BM" -> Bi_Bm
        "BI-BR" -> Bi_Br
        "BI-CA" -> Bi_Ca
        "BI-CI" -> Bi_Ci
        "BI-GI" -> Bi_Gi
        "BI-KI" -> Bi_Ki
        "BI-KR" -> Bi_Kr
        "BI-KY" -> Bi_Ky
        "BI-MA" -> Bi_Ma
        "BI-MU" -> Bi_Mu
        "BI-MW" -> Bi_Mw
        "BI-MY" -> Bi_My
        "BI-NG" -> Bi_Ng
        "BI-RT" -> Bi_Rt
        "BI-RY" -> Bi_Ry
        "KH-10" -> Kh_10
        "KH-11" -> Kh_11
        "KH-12" -> Kh_12
        "KH-13" -> Kh_13
        "KH-14" -> Kh_14
        "KH-15" -> Kh_15
        "KH-16" -> Kh_16
        "KH-17" -> Kh_17
        "KH-18" -> Kh_18
        "KH-19" -> Kh_19
        "KH-1" -> Kh_1
        "KH-20" -> Kh_20
        "KH-21" -> Kh_21
        "KH-22" -> Kh_22
        "KH-23" -> Kh_23
        "KH-24" -> Kh_24
        "KH-2" -> Kh_2
        "KH-3" -> Kh_3
        "KH-4" -> Kh_4
        "KH-5" -> Kh_5
        "KH-6" -> Kh_6
        "KH-7" -> Kh_7
        "KH-8" -> Kh_8
        "KH-9" -> Kh_9
        "CM-AD" -> Cm_Ad
        "CM-CE" -> Cm_Ce
        "CM-EN" -> Cm_En
        "CM-ES" -> Cm_Es
        "CM-LT" -> Cm_Lt
        "CM-NO" -> Cm_No
        "CM-NW" -> Cm_Nw
        "CM-OU" -> Cm_Ou
        "CM-SU" -> Cm_Su
        "CM-SW" -> Cm_Sw
        "CA-AB" -> Ca_Ab
        "CA-BC" -> Ca_Bc
        "CA-MB" -> Ca_Mb
        "CA-NB" -> Ca_Nb
        "CA-NL" -> Ca_Nl
        "CA-NS" -> Ca_Ns
        "CA-NT" -> Ca_Nt
        "CA-NU" -> Ca_Nu
        "CA-ON" -> Ca_On
        "CA-PE" -> Ca_Pe
        "CA-QC" -> Ca_Qc
        "CA-SK" -> Ca_Sk
        "CA-YT" -> Ca_Yt
        "CV-B" -> Cv_B
        "CV-BR" -> Cv_Br
        "CV-BV" -> Cv_Bv
        "CV-CA" -> Cv_Ca
        "CV-CF" -> Cv_Cf
        "CV-CR" -> Cv_Cr
        "CV-MA" -> Cv_Ma
        "CV-MO" -> Cv_Mo
        "CV-PA" -> Cv_Pa
        "CV-PN" -> Cv_Pn
        "CV-PR" -> Cv_Pr
        "CV-RB" -> Cv_Rb
        "CV-RG" -> Cv_Rg
        "CV-RS" -> Cv_Rs
        "CV-SD" -> Cv_Sd
        "CV-SF" -> Cv_Sf
        "CV-S" -> Cv_S
        "CV-SL" -> Cv_Sl
        "CV-SM" -> Cv_Sm
        "CV-SO" -> Cv_So
        "CV-SS" -> Cv_Ss
        "CV-SV" -> Cv_Sv
        "CV-TA" -> Cv_Ta
        "CV-TS" -> Cv_Ts
        "KY-KY" -> Ky_Ky
        "CF-AC" -> Cf_Ac
        "CF-BB" -> Cf_Bb
        "CF-BGF" -> Cf_Bgf
        "CF-BK" -> Cf_Bk
        "CF-HK" -> Cf_Hk
        "CF-HM" -> Cf_Hm
        "CF-HS" -> Cf_Hs
        "CF-KB" -> Cf_Kb
        "CF-KG" -> Cf_Kg
        "CF-LB" -> Cf_Lb
        "CF-MB" -> Cf_Mb
        "CF-MP" -> Cf_Mp
        "CF-NM" -> Cf_Nm
        "CF-OP" -> Cf_Op
        "CF-SE" -> Cf_Se
        "CF-UK" -> Cf_Uk
        "CF-VK" -> Cf_Vk
        "TD-BA" -> Td_Ba
        "TD-BG" -> Td_Bg
        "TD-BO" -> Td_Bo
        "TD-CB" -> Td_Cb
        "TD-EE" -> Td_Ee
        "TD-EO" -> Td_Eo
        "TD-GR" -> Td_Gr
        "TD-HL" -> Td_Hl
        "TD-KA" -> Td_Ka
        "TD-LC" -> Td_Lc
        "TD-LO" -> Td_Lo
        "TD-LR" -> Td_Lr
        "TD-MA" -> Td_Ma
        "TD-MC" -> Td_Mc
        "TD-ME" -> Td_Me
        "TD-MO" -> Td_Mo
        "TD-ND" -> Td_Nd
        "TD-OD" -> Td_Od
        "TD-SA" -> Td_Sa
        "TD-SI" -> Td_Si
        "TD-TA" -> Td_Ta
        "TD-TI" -> Td_Ti
        "TD-WF" -> Td_Wf
        "CL-AI" -> Cl_Ai
        "CL-AN" -> Cl_An
        "CL-AP" -> Cl_Ap
        "CL-AR" -> Cl_Ar
        "CL-AT" -> Cl_At
        "CL-BI" -> Cl_Bi
        "CL-CO" -> Cl_Co
        "CL-LI" -> Cl_Li
        "CL-LL" -> Cl_Ll
        "CL-LR" -> Cl_Lr
        "CL-MA" -> Cl_Ma
        "CL-ML" -> Cl_Ml
        "CL-RM" -> Cl_Rm
        "CL-TA" -> Cl_Ta
        "CL-VS" -> Cl_Vs
        "CN-11" -> Cn_11
        "CN-12" -> Cn_12
        "CN-13" -> Cn_13
        "CN-14" -> Cn_14
        "CN-15" -> Cn_15
        "CN-21" -> Cn_21
        "CN-22" -> Cn_22
        "CN-23" -> Cn_23
        "CN-31" -> Cn_31
        "CN-32" -> Cn_32
        "CN-33" -> Cn_33
        "CN-34" -> Cn_34
        "CN-35" -> Cn_35
        "CN-36" -> Cn_36
        "CN-37" -> Cn_37
        "CN-41" -> Cn_41
        "CN-42" -> Cn_42
        "CN-43" -> Cn_43
        "CN-44" -> Cn_44
        "CN-45" -> Cn_45
        "CN-46" -> Cn_46
        "CN-50" -> Cn_50
        "CN-51" -> Cn_51
        "CN-52" -> Cn_52
        "CN-53" -> Cn_53
        "CN-54" -> Cn_54
        "CN-61" -> Cn_61
        "CN-62" -> Cn_62
        "CN-63" -> Cn_63
        "CN-64" -> Cn_64
        "CN-65" -> Cn_65
        "CN-71" -> Cn_71
        "CN-91" -> Cn_91
        "CN-92" -> Cn_92
        "CX-CX" -> Cx_Cx
        "CC-CC" -> Cc_Cc
        "CO-AMA" -> Co_Ama
        "CO-ANT" -> Co_Ant
        "CO-ARA" -> Co_Ara
        "CO-ATL" -> Co_Atl
        "CO-BOL" -> Co_Bol
        "CO-BOY" -> Co_Boy
        "CO-CAL" -> Co_Cal
        "CO-CAQ" -> Co_Caq
        "CO-CAS" -> Co_Cas
        "CO-CAU" -> Co_Cau
        "CO-CES" -> Co_Ces
        "CO-CHO" -> Co_Cho
        "CO-COR" -> Co_Cor
        "CO-CUN" -> Co_Cun
        "CO-DC" -> Co_Dc
        "CO-GUA" -> Co_Gua
        "CO-GUV" -> Co_Guv
        "CO-HUI" -> Co_Hui
        "CO-LAG" -> Co_Lag
        "CO-MAG" -> Co_Mag
        "CO-MET" -> Co_Met
        "CO-NAR" -> Co_Nar
        "CO-NSA" -> Co_Nsa
        "CO-PUT" -> Co_Put
        "CO-QUI" -> Co_Qui
        "CO-RIS" -> Co_Ris
        "CO-SAN" -> Co_San
        "CO-SAP" -> Co_Sap
        "CO-SUC" -> Co_Suc
        "CO-TOL" -> Co_Tol
        "CO-VAC" -> Co_Vac
        "CO-VAU" -> Co_Vau
        "CO-VID" -> Co_Vid
        "KM-A" -> Km_A
        "KM-G" -> Km_G
        "KM-M" -> Km_M
        "CG-11" -> Cg_11
        "CG-12" -> Cg_12
        "CG-13" -> Cg_13
        "CG-14" -> Cg_14
        "CG-15" -> Cg_15
        "CG-16" -> Cg_16
        "CG-2" -> Cg_2
        "CG-5" -> Cg_5
        "CG-7" -> Cg_7
        "CG-8" -> Cg_8
        "CG-9" -> Cg_9
        "CG-BZV" -> Cg_Bzv
        "CD-BC" -> Cd_Bc
        "CD-BN" -> Cd_Bn
        "CD-EQ" -> Cd_Eq
        "CD-KA" -> Cd_Ka
        "CD-KE" -> Cd_Ke
        "CD-KN" -> Cd_Kn
        "CD-KW" -> Cd_Kw
        "CD-MA" -> Cd_Ma
        "CD-NK" -> Cd_Nk
        "CD-OR" -> Cd_Or
        "CD-SK" -> Cd_Sk
        "CK-CK" -> Ck_Ck
        "CR-A" -> Cr_A
        "CR-C" -> Cr_C
        "CR-G" -> Cr_G
        "CR-H" -> Cr_H
        "CR-L" -> Cr_L
        "CR-P" -> Cr_P
        "CR-SJ" -> Cr_Sj
        "CI-01" -> Ci_01
        "CI-02" -> Ci_02
        "CI-03" -> Ci_03
        "CI-04" -> Ci_04
        "CI-05" -> Ci_05
        "CI-06" -> Ci_06
        "CI-07" -> Ci_07
        "CI-08" -> Ci_08
        "CI-09" -> Ci_09
        "CI-10" -> Ci_10
        "CI-11" -> Ci_11
        "CI-12" -> Ci_12
        "CI-13" -> Ci_13
        "CI-14" -> Ci_14
        "CI-15" -> Ci_15
        "CI-16" -> Ci_16
        "CI-17" -> Ci_17
        "CI-18" -> Ci_18
        "CI-19" -> Ci_19
        "HR-01" -> Hr_01
        "HR-02" -> Hr_02
        "HR-03" -> Hr_03
        "HR-04" -> Hr_04
        "HR-05" -> Hr_05
        "HR-06" -> Hr_06
        "HR-07" -> Hr_07
        "HR-08" -> Hr_08
        "HR-09" -> Hr_09
        "HR-10" -> Hr_10
        "HR-11" -> Hr_11
        "HR-12" -> Hr_12
        "HR-13" -> Hr_13
        "HR-14" -> Hr_14
        "HR-15" -> Hr_15
        "HR-16" -> Hr_16
        "HR-17" -> Hr_17
        "HR-18" -> Hr_18
        "HR-19" -> Hr_19
        "HR-20" -> Hr_20
        "HR-21" -> Hr_21
        "CU-01" -> Cu_01
        "CU-03" -> Cu_03
        "CU-04" -> Cu_04
        "CU-05" -> Cu_05
        "CU-06" -> Cu_06
        "CU-07" -> Cu_07
        "CU-08" -> Cu_08
        "CU-09" -> Cu_09
        "CU-10" -> Cu_10
        "CU-11" -> Cu_11
        "CU-12" -> Cu_12
        "CU-13" -> Cu_13
        "CU-14" -> Cu_14
        "CU-15" -> Cu_15
        "CU-16" -> Cu_16
        "CU-99" -> Cu_99
        "CW-CW" -> Cw_Cw
        "CY-01" -> Cy_01
        "CY-02" -> Cy_02
        "CY-03" -> Cy_03
        "CY-04" -> Cy_04
        "CY-05" -> Cy_05
        "CY-06" -> Cy_06
        "CZ-101" -> Cz_101
        "CZ-102" -> Cz_102
        "CZ-103" -> Cz_103
        "CZ-104" -> Cz_104
        "CZ-105" -> Cz_105
        "CZ-106" -> Cz_106
        "CZ-107" -> Cz_107
        "CZ-108" -> Cz_108
        "CZ-109" -> Cz_109
        "CZ-10A" -> Cz_10A
        "CZ-10B" -> Cz_10B
        "CZ-10C" -> Cz_10C
        "CZ-10D" -> Cz_10D
        "CZ-10E" -> Cz_10E
        "CZ-10F" -> Cz_10F
        "CZ-201" -> Cz_201
        "CZ-202" -> Cz_202
        "CZ-203" -> Cz_203
        "CZ-204" -> Cz_204
        "CZ-205" -> Cz_205
        "CZ-206" -> Cz_206
        "CZ-207" -> Cz_207
        "CZ-208" -> Cz_208
        "CZ-209" -> Cz_209
        "CZ-20A" -> Cz_20A
        "CZ-20B" -> Cz_20B
        "CZ-20C" -> Cz_20C
        "CZ-311" -> Cz_311
        "CZ-312" -> Cz_312
        "CZ-313" -> Cz_313
        "CZ-314" -> Cz_314
        "CZ-315" -> Cz_315
        "CZ-316" -> Cz_316
        "CZ-317" -> Cz_317
        "CZ-321" -> Cz_321
        "CZ-322" -> Cz_322
        "CZ-323" -> Cz_323
        "CZ-324" -> Cz_324
        "CZ-325" -> Cz_325
        "CZ-326" -> Cz_326
        "CZ-327" -> Cz_327
        "CZ-411" -> Cz_411
        "CZ-412" -> Cz_412
        "CZ-413" -> Cz_413
        "CZ-421" -> Cz_421
        "CZ-422" -> Cz_422
        "CZ-423" -> Cz_423
        "CZ-424" -> Cz_424
        "CZ-425" -> Cz_425
        "CZ-426" -> Cz_426
        "CZ-427" -> Cz_427
        "CZ-511" -> Cz_511
        "CZ-512" -> Cz_512
        "CZ-513" -> Cz_513
        "CZ-514" -> Cz_514
        "001" -> _001
        "002" -> _002
        "014" -> _014
        "017" -> _017
        "015" -> _015
        "018" -> _018
        "011" -> _011
        "019" -> _019
        "419" -> _419
        "029" -> _029
        "013" -> _013
        "005" -> _005
        "021" -> _021
        "142" -> _142
        "143" -> _143
        "030" -> _030
        "034" -> _034
        "035" -> _035
        "145" -> _145
        "150" -> _150
        "151" -> _151
        "154" -> _154
        "039" -> _039
        "155" -> _155
        "009" -> _009
        "053" -> _053
        "054" -> _054
        "057" -> _057
        "061" -> _061
        else -> throw IllegalArgumentException("Unknown code $code for enum JurisdictionValueSet")
      }
  }
}

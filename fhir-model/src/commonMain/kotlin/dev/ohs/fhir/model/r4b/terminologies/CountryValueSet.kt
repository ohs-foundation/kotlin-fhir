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

/**
 * This value set defines a base set of codes for countries.
 *
 * Note: The codes for countries are taken from
 * [ISO 3166](https://www.iso.org/iso-3166-country-codes.html).
 */
public enum class CountryValueSet(
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
  _894("894", "urn:iso:std:iso:3166", "Zambia");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): CountryValueSet =
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
        else -> throw IllegalArgumentException("Unknown code $code for enum CountryValueSet")
      }
  }
}

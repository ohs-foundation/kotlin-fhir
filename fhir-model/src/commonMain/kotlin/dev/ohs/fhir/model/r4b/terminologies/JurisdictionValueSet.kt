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
  Ad_03("AD-03", "urn:iso:std:iso:3166:-2", "Encamp"),
  Ad_07("AD-07", "urn:iso:std:iso:3166:-2", "Andorra la Vella"),
  Ad_04("AD-04", "urn:iso:std:iso:3166:-2", "La Massana"),
  Ad_05("AD-05", "urn:iso:std:iso:3166:-2", "Ordino"),
  Ad_02("AD-02", "urn:iso:std:iso:3166:-2", "Canillo"),
  Ad_06("AD-06", "urn:iso:std:iso:3166:-2", "Sant Julià de Lòria"),
  Ad_08("AD-08", "urn:iso:std:iso:3166:-2", "Escaldes-Engordany"),
  Ae_Rk("AE-RK", "urn:iso:std:iso:3166:-2", "Ra’s al Khaymah"),
  Ae_Sh("AE-SH", "urn:iso:std:iso:3166:-2", "Ash Shāriqah"),
  Ae_Fu("AE-FU", "urn:iso:std:iso:3166:-2", "Al Fujayrah"),
  Ae_Du("AE-DU", "urn:iso:std:iso:3166:-2", "Dubayy"),
  Ae_Az("AE-AZ", "urn:iso:std:iso:3166:-2", "Abū Z̧aby"),
  Ae_Uq("AE-UQ", "urn:iso:std:iso:3166:-2", "Umm al Qaywayn"),
  Ae_Aj("AE-AJ", "urn:iso:std:iso:3166:-2", "‘Ajmān"),
  Af_Bam("AF-BAM", "urn:iso:std:iso:3166:-2", "Bāmyān"),
  Af_Kab("AF-KAB", "urn:iso:std:iso:3166:-2", "Kābul"),
  Af_Kap("AF-KAP", "urn:iso:std:iso:3166:-2", "Kāpīsā"),
  Af_Kho("AF-KHO", "urn:iso:std:iso:3166:-2", "Khōst"),
  Af_Knr("AF-KNR", "urn:iso:std:iso:3166:-2", "Kunaṟ"),
  Af_Kan("AF-KAN", "urn:iso:std:iso:3166:-2", "Kandahār"),
  Af_Log("AF-LOG", "urn:iso:std:iso:3166:-2", "Lōgar"),
  Af_Pia("AF-PIA", "urn:iso:std:iso:3166:-2", "Paktiyā"),
  Af_Sam("AF-SAM", "urn:iso:std:iso:3166:-2", "Samangān"),
  Af_Uru("AF-URU", "urn:iso:std:iso:3166:-2", "Uruzgān"),
  Af_Bds("AF-BDS", "urn:iso:std:iso:3166:-2", "Badakhshān"),
  Af_Fyb("AF-FYB", "urn:iso:std:iso:3166:-2", "Fāryāb"),
  Af_Jow("AF-JOW", "urn:iso:std:iso:3166:-2", "Jowzjān"),
  Af_Kdz("AF-KDZ", "urn:iso:std:iso:3166:-2", "Kunduz"),
  Af_Lag("AF-LAG", "urn:iso:std:iso:3166:-2", "Laghmān"),
  Af_Nim("AF-NIM", "urn:iso:std:iso:3166:-2", "Nīmrōz"),
  Af_Bgl("AF-BGL", "urn:iso:std:iso:3166:-2", "Baghlān"),
  Af_Fra("AF-FRA", "urn:iso:std:iso:3166:-2", "Farāh"),
  Af_Hel("AF-HEL", "urn:iso:std:iso:3166:-2", "Helmand"),
  Af_Pka("AF-PKA", "urn:iso:std:iso:3166:-2", "Paktīkā"),
  Af_Sar("AF-SAR", "urn:iso:std:iso:3166:-2", "Sar-e Pul"),
  Af_Bdg("AF-BDG", "urn:iso:std:iso:3166:-2", "Bādghīs"),
  Af_Gha("AF-GHA", "urn:iso:std:iso:3166:-2", "Ghaznī"),
  Af_Pan("AF-PAN", "urn:iso:std:iso:3166:-2", "Panjshayr"),
  Af_Tak("AF-TAK", "urn:iso:std:iso:3166:-2", "Takhār"),
  Af_War("AF-WAR", "urn:iso:std:iso:3166:-2", "Wardak"),
  Af_Bal("AF-BAL", "urn:iso:std:iso:3166:-2", "Balkh"),
  Af_Gho("AF-GHO", "urn:iso:std:iso:3166:-2", "Ghōr"),
  Af_Day("AF-DAY", "urn:iso:std:iso:3166:-2", "Dāykundī"),
  Af_Her("AF-HER", "urn:iso:std:iso:3166:-2", "Herāt"),
  Af_Nan("AF-NAN", "urn:iso:std:iso:3166:-2", "Nangarhār"),
  Af_Nur("AF-NUR", "urn:iso:std:iso:3166:-2", "Nūristān"),
  Af_Par("AF-PAR", "urn:iso:std:iso:3166:-2", "Parwān"),
  Af_Zab("AF-ZAB", "urn:iso:std:iso:3166:-2", "Zābul"),
  Ag_03("AG-03", "urn:iso:std:iso:3166:-2", "Saint George"),
  Ag_06("AG-06", "urn:iso:std:iso:3166:-2", "Saint Paul"),
  Ag_10("AG-10", "urn:iso:std:iso:3166:-2", "Barbuda"),
  Ag_07("AG-07", "urn:iso:std:iso:3166:-2", "Saint Peter"),
  Ag_08("AG-08", "urn:iso:std:iso:3166:-2", "Saint Philip"),
  Ag_05("AG-05", "urn:iso:std:iso:3166:-2", "Saint Mary"),
  Ag_04("AG-04", "urn:iso:std:iso:3166:-2", "Saint John"),
  Ag_11("AG-11", "urn:iso:std:iso:3166:-2", "Redonda"),
  Al_11("AL-11", "urn:iso:std:iso:3166:-2", "Tiranë"),
  Al_12("AL-12", "urn:iso:std:iso:3166:-2", "Vlorë"),
  Al_03("AL-03", "urn:iso:std:iso:3166:-2", "Elbasan"),
  Al_09("AL-09", "urn:iso:std:iso:3166:-2", "Dibër"),
  Al_01("AL-01", "urn:iso:std:iso:3166:-2", "Berat"),
  Al_02("AL-02", "urn:iso:std:iso:3166:-2", "Durrës"),
  Al_08("AL-08", "urn:iso:std:iso:3166:-2", "Lezhë"),
  Al_10("AL-10", "urn:iso:std:iso:3166:-2", "Shkodër"),
  Al_05("AL-05", "urn:iso:std:iso:3166:-2", "Gjirokastër"),
  Al_06("AL-06", "urn:iso:std:iso:3166:-2", "Korçë"),
  Al_07("AL-07", "urn:iso:std:iso:3166:-2", "Kukës"),
  Al_04("AL-04", "urn:iso:std:iso:3166:-2", "Fier"),
  Am_Ag("AM-AG", "urn:iso:std:iso:3166:-2", "Aragac̣otn"),
  Am_Av("AM-AV", "urn:iso:std:iso:3166:-2", "Armavir"),
  Am_Kt("AM-KT", "urn:iso:std:iso:3166:-2", "Kotayk'"),
  Am_Gr("AM-GR", "urn:iso:std:iso:3166:-2", "Geġark'unik'"),
  Am_Sh("AM-SH", "urn:iso:std:iso:3166:-2", "Širak"),
  Am_Su("AM-SU", "urn:iso:std:iso:3166:-2", "Syunik'"),
  Am_Tv("AM-TV", "urn:iso:std:iso:3166:-2", "Tavuš"),
  Am_Lo("AM-LO", "urn:iso:std:iso:3166:-2", "Loṙi"),
  Am_Er("AM-ER", "urn:iso:std:iso:3166:-2", "Erevan"),
  Am_Vd("AM-VD", "urn:iso:std:iso:3166:-2", "Vayoć Jor"),
  Am_Ar("AM-AR", "urn:iso:std:iso:3166:-2", "Ararat"),
  Ao_Cab("AO-CAB", "urn:iso:std:iso:3166:-2", "Cabinda"),
  Ao_Ccu("AO-CCU", "urn:iso:std:iso:3166:-2", "Kuando Kubango"),
  Ao_Zai("AO-ZAI", "urn:iso:std:iso:3166:-2", "Zaire"),
  Ao_Lno("AO-LNO", "urn:iso:std:iso:3166:-2", "Lunda Norte"),
  Ao_Lsu("AO-LSU", "urn:iso:std:iso:3166:-2", "Lunda Sul"),
  Ao_Mox("AO-MOX", "urn:iso:std:iso:3166:-2", "Moxico"),
  Ao_Nam("AO-NAM", "urn:iso:std:iso:3166:-2", "Namibe"),
  Ao_Uig("AO-UIG", "urn:iso:std:iso:3166:-2", "Uíge"),
  Ao_Cno("AO-CNO", "urn:iso:std:iso:3166:-2", "Kwanza Norte"),
  Ao_Hui("AO-HUI", "urn:iso:std:iso:3166:-2", "Huíla"),
  Ao_Lua("AO-LUA", "urn:iso:std:iso:3166:-2", "Luanda"),
  Ao_Mal("AO-MAL", "urn:iso:std:iso:3166:-2", "Malange"),
  Ao_Bgo("AO-BGO", "urn:iso:std:iso:3166:-2", "Bengo"),
  Ao_Bgu("AO-BGU", "urn:iso:std:iso:3166:-2", "Benguela"),
  Ao_Cnn("AO-CNN", "urn:iso:std:iso:3166:-2", "Cunene"),
  Ao_Cus("AO-CUS", "urn:iso:std:iso:3166:-2", "Kwanza Sul"),
  Ao_Hua("AO-HUA", "urn:iso:std:iso:3166:-2", "Huambo"),
  Ao_Bie("AO-BIE", "urn:iso:std:iso:3166:-2", "Bié"),
  Ar_N("AR-N", "urn:iso:std:iso:3166:-2", "Misiones"),
  Ar_S("AR-S", "urn:iso:std:iso:3166:-2", "Santa Fe"),
  Ar_Z("AR-Z", "urn:iso:std:iso:3166:-2", "Santa Cruz"),
  Ar_A("AR-A", "urn:iso:std:iso:3166:-2", "Salta"),
  Ar_C("AR-C", "urn:iso:std:iso:3166:-2", "Ciudad Autónoma de Buenos Aires"),
  Ar_F("AR-F", "urn:iso:std:iso:3166:-2", "La Rioja"),
  Ar_B("AR-B", "urn:iso:std:iso:3166:-2", "Buenos Aires"),
  Ar_G("AR-G", "urn:iso:std:iso:3166:-2", "Santiago del Estero"),
  Ar_H("AR-H", "urn:iso:std:iso:3166:-2", "Chaco"),
  Ar_P("AR-P", "urn:iso:std:iso:3166:-2", "Formosa"),
  Ar_X("AR-X", "urn:iso:std:iso:3166:-2", "Córdoba"),
  Ar_J("AR-J", "urn:iso:std:iso:3166:-2", "San Juan"),
  Ar_T("AR-T", "urn:iso:std:iso:3166:-2", "Tucumán"),
  Ar_E("AR-E", "urn:iso:std:iso:3166:-2", "Entre Ríos"),
  Ar_K("AR-K", "urn:iso:std:iso:3166:-2", "Catamarca"),
  Ar_V("AR-V", "urn:iso:std:iso:3166:-2", "Tierra del Fuego"),
  Ar_W("AR-W", "urn:iso:std:iso:3166:-2", "Corrientes"),
  Ar_U("AR-U", "urn:iso:std:iso:3166:-2", "Chubut"),
  Ar_D("AR-D", "urn:iso:std:iso:3166:-2", "San Luis"),
  Ar_L("AR-L", "urn:iso:std:iso:3166:-2", "La Pampa"),
  Ar_M("AR-M", "urn:iso:std:iso:3166:-2", "Mendoza"),
  Ar_Q("AR-Q", "urn:iso:std:iso:3166:-2", "Neuquén"),
  Ar_R("AR-R", "urn:iso:std:iso:3166:-2", "Río Negro"),
  Ar_Y("AR-Y", "urn:iso:std:iso:3166:-2", "Jujuy"),
  At_3("AT-3", "urn:iso:std:iso:3166:-2", "Niederösterreich"),
  At_4("AT-4", "urn:iso:std:iso:3166:-2", "Oberösterreich"),
  At_5("AT-5", "urn:iso:std:iso:3166:-2", "Salzburg"),
  At_8("AT-8", "urn:iso:std:iso:3166:-2", "Vorarlberg"),
  At_1("AT-1", "urn:iso:std:iso:3166:-2", "Burgenland"),
  At_7("AT-7", "urn:iso:std:iso:3166:-2", "Tirol"),
  At_2("AT-2", "urn:iso:std:iso:3166:-2", "Kärnten"),
  At_6("AT-6", "urn:iso:std:iso:3166:-2", "Steiermark"),
  At_9("AT-9", "urn:iso:std:iso:3166:-2", "Wien"),
  Au_Nt("AU-NT", "urn:iso:std:iso:3166:-2", "Northern Territory"),
  Au_Qld("AU-QLD", "urn:iso:std:iso:3166:-2", "Queensland"),
  Au_Tas("AU-TAS", "urn:iso:std:iso:3166:-2", "Tasmania"),
  Au_Act("AU-ACT", "urn:iso:std:iso:3166:-2", "Australian Capital Territory"),
  Au_Nsw("AU-NSW", "urn:iso:std:iso:3166:-2", "New South Wales"),
  Au_Sa("AU-SA", "urn:iso:std:iso:3166:-2", "South Australia"),
  Au_Wa("AU-WA", "urn:iso:std:iso:3166:-2", "Western Australia"),
  Au_Vic("AU-VIC", "urn:iso:std:iso:3166:-2", "Victoria"),
  Az_Abs("AZ-ABS", "urn:iso:std:iso:3166:-2", "Abşeron"),
  Az_Ba("AZ-BA", "urn:iso:std:iso:3166:-2", "Bakı"),
  Az_Bal("AZ-BAL", "urn:iso:std:iso:3166:-2", "Balakən"),
  Az_Bar("AZ-BAR", "urn:iso:std:iso:3166:-2", "Bərdə"),
  Az_Goy("AZ-GOY", "urn:iso:std:iso:3166:-2", "Göyçay"),
  Az_Mas("AZ-MAS", "urn:iso:std:iso:3166:-2", "Masallı"),
  Az_Skr("AZ-SKR", "urn:iso:std:iso:3166:-2", "Şəmkir"),
  Az_Sr("AZ-SR", "urn:iso:std:iso:3166:-2", "Şirvan"),
  Az_Xa("AZ-XA", "urn:iso:std:iso:3166:-2", "Xankəndi"),
  Az_Xiz("AZ-XIZ", "urn:iso:std:iso:3166:-2", "Xızı"),
  Az_Agc("AZ-AGC", "urn:iso:std:iso:3166:-2", "Ağcabədi"),
  Az_Agu("AZ-AGU", "urn:iso:std:iso:3166:-2", "Ağsu"),
  Az_Bil("AZ-BIL", "urn:iso:std:iso:3166:-2", "Biləsuvar"),
  Az_Ga("AZ-GA", "urn:iso:std:iso:3166:-2", "Gəncə"),
  Az_Qab("AZ-QAB", "urn:iso:std:iso:3166:-2", "Qəbələ"),
  Az_Smx("AZ-SMX", "urn:iso:std:iso:3166:-2", "Samux"),
  Az_Xac("AZ-XAC", "urn:iso:std:iso:3166:-2", "Xaçmaz"),
  Az_Yar("AZ-YAR", "urn:iso:std:iso:3166:-2", "Yardımlı"),
  Az_Zan("AZ-ZAN", "urn:iso:std:iso:3166:-2", "Zəngilan"),
  Az_Aga("AZ-AGA", "urn:iso:std:iso:3166:-2", "Ağstafa"),
  Az_Fuz("AZ-FUZ", "urn:iso:std:iso:3166:-2", "Füzuli"),
  Az_Gad("AZ-GAD", "urn:iso:std:iso:3166:-2", "Gədəbəy"),
  Az_Lac("AZ-LAC", "urn:iso:std:iso:3166:-2", "Laçın"),
  Az_Qax("AZ-QAX", "urn:iso:std:iso:3166:-2", "Qax"),
  Az_Agm("AZ-AGM", "urn:iso:std:iso:3166:-2", "Ağdam"),
  Az_Das("AZ-DAS", "urn:iso:std:iso:3166:-2", "Daşkəsən"),
  Az_Gyg("AZ-GYG", "urn:iso:std:iso:3166:-2", "Göygöl"),
  Az_La("AZ-LA", "urn:iso:std:iso:3166:-2", "Lənkəran"),
  Az_Lan("AZ-LAN", "urn:iso:std:iso:3166:-2", "Lənkəran"),
  Az_Ogu("AZ-OGU", "urn:iso:std:iso:3166:-2", "Oğuz"),
  Az_Qba("AZ-QBA", "urn:iso:std:iso:3166:-2", "Quba"),
  Az_Qus("AZ-QUS", "urn:iso:std:iso:3166:-2", "Qusar"),
  Az_Sab("AZ-SAB", "urn:iso:std:iso:3166:-2", "Sabirabad"),
  Az_Cab("AZ-CAB", "urn:iso:std:iso:3166:-2", "Cəbrayıl"),
  Az_Kur("AZ-KUR", "urn:iso:std:iso:3166:-2", "Kürdəmir"),
  Az_Sal("AZ-SAL", "urn:iso:std:iso:3166:-2", "Salyan"),
  Az_Sbn("AZ-SBN", "urn:iso:std:iso:3166:-2", "Şabran"),
  Az_Sm("AZ-SM", "urn:iso:std:iso:3166:-2", "Sumqayıt"),
  Az_Uca("AZ-UCA", "urn:iso:std:iso:3166:-2", "Ucar"),
  Az_Xci("AZ-XCI", "urn:iso:std:iso:3166:-2", "Xocalı"),
  Az_Yev("AZ-YEV", "urn:iso:std:iso:3166:-2", "Yevlax"),
  Az_Ags("AZ-AGS", "urn:iso:std:iso:3166:-2", "Ağdaş"),
  Az_Ast("AZ-AST", "urn:iso:std:iso:3166:-2", "Astara"),
  Az_Bey("AZ-BEY", "urn:iso:std:iso:3166:-2", "Beyləqan"),
  Az_Hac("AZ-HAC", "urn:iso:std:iso:3166:-2", "Hacıqabul"),
  Az_Imi("AZ-IMI", "urn:iso:std:iso:3166:-2", "İmişli"),
  Az_Ism("AZ-ISM", "urn:iso:std:iso:3166:-2", "İsmayıllı"),
  Az_Ler("AZ-LER", "urn:iso:std:iso:3166:-2", "Lerik"),
  Az_Mi("AZ-MI", "urn:iso:std:iso:3166:-2", "Mingəçevir"),
  Az_Nef("AZ-NEF", "urn:iso:std:iso:3166:-2", "Neftçala"),
  Az_Nx("AZ-NX", "urn:iso:std:iso:3166:-2", "Naxçıvan"),
  Az_Qaz("AZ-QAZ", "urn:iso:std:iso:3166:-2", "Qazax"),
  Az_Sak("AZ-SAK", "urn:iso:std:iso:3166:-2", "Şəki"),
  Az_Sat("AZ-SAT", "urn:iso:std:iso:3166:-2", "Saatlı"),
  Az_Tar("AZ-TAR", "urn:iso:std:iso:3166:-2", "Tərtər"),
  Az_Xvd("AZ-XVD", "urn:iso:std:iso:3166:-2", "Xocavənd"),
  Az_Cal("AZ-CAL", "urn:iso:std:iso:3166:-2", "Cəlilabad"),
  Az_Kal("AZ-KAL", "urn:iso:std:iso:3166:-2", "Kəlbəcər"),
  Az_Qob("AZ-QOB", "urn:iso:std:iso:3166:-2", "Qobustan"),
  Az_Siy("AZ-SIY", "urn:iso:std:iso:3166:-2", "Siyəzən"),
  Az_Sus("AZ-SUS", "urn:iso:std:iso:3166:-2", "Şuşa"),
  Az_Zaq("AZ-ZAQ", "urn:iso:std:iso:3166:-2", "Zaqatala"),
  Az_Zar("AZ-ZAR", "urn:iso:std:iso:3166:-2", "Zərdab"),
  Az_Gor("AZ-GOR", "urn:iso:std:iso:3166:-2", "Goranboy"),
  Az_Na("AZ-NA", "urn:iso:std:iso:3166:-2", "Naftalan"),
  Az_Qbi("AZ-QBI", "urn:iso:std:iso:3166:-2", "Qubadlı"),
  Az_Sa("AZ-SA", "urn:iso:std:iso:3166:-2", "Şəki"),
  Az_Smi("AZ-SMI", "urn:iso:std:iso:3166:-2", "Şamaxı"),
  Az_Tov("AZ-TOV", "urn:iso:std:iso:3166:-2", "Tovuz"),
  Az_Ye("AZ-YE", "urn:iso:std:iso:3166:-2", "Yevlax"),
  Ba_Brc("BA-BRC", "urn:iso:std:iso:3166:-2", "Brčko distrikt"),
  Ba_Bih("BA-BIH", "urn:iso:std:iso:3166:-2", "Federacija Bosne i Hercegovine"),
  Ba_Srp("BA-SRP", "urn:iso:std:iso:3166:-2", "Republika Srpska"),
  Bb_03("BB-03", "urn:iso:std:iso:3166:-2", "Saint George"),
  Bb_05("BB-05", "urn:iso:std:iso:3166:-2", "Saint John"),
  Bb_02("BB-02", "urn:iso:std:iso:3166:-2", "Saint Andrew"),
  Bb_10("BB-10", "urn:iso:std:iso:3166:-2", "Saint Philip"),
  Bb_11("BB-11", "urn:iso:std:iso:3166:-2", "Saint Thomas"),
  Bb_08("BB-08", "urn:iso:std:iso:3166:-2", "Saint Michael"),
  Bb_04("BB-04", "urn:iso:std:iso:3166:-2", "Saint James"),
  Bb_09("BB-09", "urn:iso:std:iso:3166:-2", "Saint Peter"),
  Bb_01("BB-01", "urn:iso:std:iso:3166:-2", "Christ Church"),
  Bb_06("BB-06", "urn:iso:std:iso:3166:-2", "Saint Joseph"),
  Bb_07("BB-07", "urn:iso:std:iso:3166:-2", "Saint Lucy"),
  Bd_B("BD-B", "urn:iso:std:iso:3166:-2", "Chittagong"),
  Bd_H("BD-H", "urn:iso:std:iso:3166:-2", "Mymensingh"),
  Bd_A("BD-A", "urn:iso:std:iso:3166:-2", "Barisal"),
  Bd_C("BD-C", "urn:iso:std:iso:3166:-2", "Dhaka"),
  Bd_D("BD-D", "urn:iso:std:iso:3166:-2", "Khulna"),
  Bd_E("BD-E", "urn:iso:std:iso:3166:-2", "Rajshahi"),
  Bd_F("BD-F", "urn:iso:std:iso:3166:-2", "Rangpur"),
  Bd_G("BD-G", "urn:iso:std:iso:3166:-2", "Sylhet"),
  Be_Wal("BE-WAL", "urn:iso:std:iso:3166:-2", "wallonne, Région"),
  Be_Bru("BE-BRU", "urn:iso:std:iso:3166:-2", "Brussels Hoofdstedelijk Gewest"),
  Be_Vlg("BE-VLG", "urn:iso:std:iso:3166:-2", "Vlaams Gewest"),
  Bf_05("BF-05", "urn:iso:std:iso:3166:-2", "Centre-Nord"),
  Bf_01("BF-01", "urn:iso:std:iso:3166:-2", "Boucle du Mouhoun"),
  Bf_10("BF-10", "urn:iso:std:iso:3166:-2", "Nord"),
  Bf_02("BF-02", "urn:iso:std:iso:3166:-2", "Cascades"),
  Bf_03("BF-03", "urn:iso:std:iso:3166:-2", "Centre"),
  Bf_04("BF-04", "urn:iso:std:iso:3166:-2", "Centre-Est"),
  Bf_06("BF-06", "urn:iso:std:iso:3166:-2", "Centre-Ouest"),
  Bf_07("BF-07", "urn:iso:std:iso:3166:-2", "Centre-Sud"),
  Bf_08("BF-08", "urn:iso:std:iso:3166:-2", "Est"),
  Bf_09("BF-09", "urn:iso:std:iso:3166:-2", "Hauts-Bassins"),
  Bf_11("BF-11", "urn:iso:std:iso:3166:-2", "Plateau-Central"),
  Bf_12("BF-12", "urn:iso:std:iso:3166:-2", "Sahel"),
  Bf_13("BF-13", "urn:iso:std:iso:3166:-2", "Sud-Ouest"),
  Bg_04("BG-04", "urn:iso:std:iso:3166:-2", "Veliko Tarnovo"),
  Bg_09("BG-09", "urn:iso:std:iso:3166:-2", "Kardzhali"),
  Bg_15("BG-15", "urn:iso:std:iso:3166:-2", "Pleven"),
  Bg_16("BG-16", "urn:iso:std:iso:3166:-2", "Plovdiv"),
  Bg_28("BG-28", "urn:iso:std:iso:3166:-2", "Yambol"),
  Bg_13("BG-13", "urn:iso:std:iso:3166:-2", "Pazardzhik"),
  Bg_18("BG-18", "urn:iso:std:iso:3166:-2", "Ruse"),
  Bg_21("BG-21", "urn:iso:std:iso:3166:-2", "Smolyan"),
  Bg_22("BG-22", "urn:iso:std:iso:3166:-2", "Sofia (stolitsa)"),
  Bg_27("BG-27", "urn:iso:std:iso:3166:-2", "Shumen"),
  Bg_02("BG-02", "urn:iso:std:iso:3166:-2", "Burgas"),
  Bg_14("BG-14", "urn:iso:std:iso:3166:-2", "Pernik"),
  Bg_19("BG-19", "urn:iso:std:iso:3166:-2", "Silistra"),
  Bg_25("BG-25", "urn:iso:std:iso:3166:-2", "Targovishte"),
  Bg_03("BG-03", "urn:iso:std:iso:3166:-2", "Varna"),
  Bg_24("BG-24", "urn:iso:std:iso:3166:-2", "Stara Zagora"),
  Bg_01("BG-01", "urn:iso:std:iso:3166:-2", "Blagoevgrad"),
  Bg_10("BG-10", "urn:iso:std:iso:3166:-2", "Kyustendil"),
  Bg_12("BG-12", "urn:iso:std:iso:3166:-2", "Montana"),
  Bg_20("BG-20", "urn:iso:std:iso:3166:-2", "Sliven"),
  Bg_23("BG-23", "urn:iso:std:iso:3166:-2", "Sofia"),
  Bg_11("BG-11", "urn:iso:std:iso:3166:-2", "Lovech"),
  Bg_17("BG-17", "urn:iso:std:iso:3166:-2", "Razgrad"),
  Bg_05("BG-05", "urn:iso:std:iso:3166:-2", "Vidin"),
  Bg_06("BG-06", "urn:iso:std:iso:3166:-2", "Vratsa"),
  Bg_07("BG-07", "urn:iso:std:iso:3166:-2", "Gabrovo"),
  Bg_08("BG-08", "urn:iso:std:iso:3166:-2", "Dobrich"),
  Bg_26("BG-26", "urn:iso:std:iso:3166:-2", "Haskovo"),
  Bh_14("BH-14", "urn:iso:std:iso:3166:-2", "Al Janūbīyah"),
  Bh_13("BH-13", "urn:iso:std:iso:3166:-2", "Al ‘Āşimah"),
  Bh_15("BH-15", "urn:iso:std:iso:3166:-2", "Al Muḩarraq"),
  Bh_17("BH-17", "urn:iso:std:iso:3166:-2", "Ash Shamālīyah"),
  Bi_Bm("BI-BM", "urn:iso:std:iso:3166:-2", "Bujumbura Mairie"),
  Bi_Kr("BI-KR", "urn:iso:std:iso:3166:-2", "Karuzi"),
  Bi_My("BI-MY", "urn:iso:std:iso:3166:-2", "Muyinga"),
  Bi_Ki("BI-KI", "urn:iso:std:iso:3166:-2", "Kirundo"),
  Bi_Br("BI-BR", "urn:iso:std:iso:3166:-2", "Bururi"),
  Bi_Ci("BI-CI", "urn:iso:std:iso:3166:-2", "Cibitoke"),
  Bi_Gi("BI-GI", "urn:iso:std:iso:3166:-2", "Gitega"),
  Bi_Ma("BI-MA", "urn:iso:std:iso:3166:-2", "Makamba"),
  Bi_Mu("BI-MU", "urn:iso:std:iso:3166:-2", "Muramvya"),
  Bi_Ng("BI-NG", "urn:iso:std:iso:3166:-2", "Ngozi"),
  Bi_Ry("BI-RY", "urn:iso:std:iso:3166:-2", "Ruyigi"),
  Bi_Ky("BI-KY", "urn:iso:std:iso:3166:-2", "Kayanza"),
  Bi_Mw("BI-MW", "urn:iso:std:iso:3166:-2", "Mwaro"),
  Bi_Ca("BI-CA", "urn:iso:std:iso:3166:-2", "Cankuzo"),
  Bi_Bl("BI-BL", "urn:iso:std:iso:3166:-2", "Bujumbura Rural"),
  Bi_Rt("BI-RT", "urn:iso:std:iso:3166:-2", "Rutana"),
  Bi_Rm("BI-RM", "urn:iso:std:iso:3166:-2", "Rumonge"),
  Bi_Bb("BI-BB", "urn:iso:std:iso:3166:-2", "Bubanza"),
  Bj_Ak("BJ-AK", "urn:iso:std:iso:3166:-2", "Atacora"),
  Bj_Co("BJ-CO", "urn:iso:std:iso:3166:-2", "Collines"),
  Bj_Bo("BJ-BO", "urn:iso:std:iso:3166:-2", "Borgou"),
  Bj_Ou("BJ-OU", "urn:iso:std:iso:3166:-2", "Ouémé"),
  Bj_Li("BJ-LI", "urn:iso:std:iso:3166:-2", "Littoral"),
  Bj_Aq("BJ-AQ", "urn:iso:std:iso:3166:-2", "Atlantique"),
  Bj_Mo("BJ-MO", "urn:iso:std:iso:3166:-2", "Mono"),
  Bj_Al("BJ-AL", "urn:iso:std:iso:3166:-2", "Alibori"),
  Bj_Do("BJ-DO", "urn:iso:std:iso:3166:-2", "Donga"),
  Bj_Ko("BJ-KO", "urn:iso:std:iso:3166:-2", "Couffo"),
  Bj_Pl("BJ-PL", "urn:iso:std:iso:3166:-2", "Plateau"),
  Bj_Zo("BJ-ZO", "urn:iso:std:iso:3166:-2", "Zou"),
  Bn_Bm("BN-BM", "urn:iso:std:iso:3166:-2", "Brunei-Muara"),
  Bn_Be("BN-BE", "urn:iso:std:iso:3166:-2", "Belait"),
  Bn_Te("BN-TE", "urn:iso:std:iso:3166:-2", "Temburong"),
  Bn_Tu("BN-TU", "urn:iso:std:iso:3166:-2", "Tutong"),
  Bo_C("BO-C", "urn:iso:std:iso:3166:-2", "Cochabamba"),
  Bo_L("BO-L", "urn:iso:std:iso:3166:-2", "La Paz"),
  Bo_B("BO-B", "urn:iso:std:iso:3166:-2", "El Beni"),
  Bo_O("BO-O", "urn:iso:std:iso:3166:-2", "Oruro"),
  Bo_S("BO-S", "urn:iso:std:iso:3166:-2", "Santa Cruz"),
  Bo_P("BO-P", "urn:iso:std:iso:3166:-2", "Potosí"),
  Bo_T("BO-T", "urn:iso:std:iso:3166:-2", "Tarija"),
  Bo_H("BO-H", "urn:iso:std:iso:3166:-2", "Chuquisaca"),
  Bo_N("BO-N", "urn:iso:std:iso:3166:-2", "Pando"),
  Bq_Bo("BQ-BO", "urn:iso:std:iso:3166:-2", "Bonaire"),
  Bq_Sa("BQ-SA", "urn:iso:std:iso:3166:-2", "Saba"),
  Bq_Se("BQ-SE", "urn:iso:std:iso:3166:-2", "Sint Eustatius"),
  Br_Ac("BR-AC", "urn:iso:std:iso:3166:-2", "Acre"),
  Br_Am("BR-AM", "urn:iso:std:iso:3166:-2", "Amazonas"),
  Br_Ce("BR-CE", "urn:iso:std:iso:3166:-2", "Ceará"),
  Br_Rr("BR-RR", "urn:iso:std:iso:3166:-2", "Roraima"),
  Br_Go("BR-GO", "urn:iso:std:iso:3166:-2", "Goiás"),
  Br_Mg("BR-MG", "urn:iso:std:iso:3166:-2", "Minas Gerais"),
  Br_Es("BR-ES", "urn:iso:std:iso:3166:-2", "Espírito Santo"),
  Br_Ap("BR-AP", "urn:iso:std:iso:3166:-2", "Amapá"),
  Br_Ba("BR-BA", "urn:iso:std:iso:3166:-2", "Bahia"),
  Br_Ms("BR-MS", "urn:iso:std:iso:3166:-2", "Mato Grosso do Sul"),
  Br_Pr("BR-PR", "urn:iso:std:iso:3166:-2", "Paraná"),
  Br_Rn("BR-RN", "urn:iso:std:iso:3166:-2", "Rio Grande do Norte"),
  Br_Mt("BR-MT", "urn:iso:std:iso:3166:-2", "Mato Grosso"),
  Br_Pb("BR-PB", "urn:iso:std:iso:3166:-2", "Paraíba"),
  Br_Pe("BR-PE", "urn:iso:std:iso:3166:-2", "Pernambuco"),
  Br_Rj("BR-RJ", "urn:iso:std:iso:3166:-2", "Rio de Janeiro"),
  Br_Ro("BR-RO", "urn:iso:std:iso:3166:-2", "Rondônia"),
  Br_Sc("BR-SC", "urn:iso:std:iso:3166:-2", "Santa Catarina"),
  Br_Sp("BR-SP", "urn:iso:std:iso:3166:-2", "São Paulo"),
  Br_Al("BR-AL", "urn:iso:std:iso:3166:-2", "Alagoas"),
  Br_Df("BR-DF", "urn:iso:std:iso:3166:-2", "Distrito Federal"),
  Br_Ma("BR-MA", "urn:iso:std:iso:3166:-2", "Maranhão"),
  Br_Pa("BR-PA", "urn:iso:std:iso:3166:-2", "Pará"),
  Br_Pi("BR-PI", "urn:iso:std:iso:3166:-2", "Piauí"),
  Br_Rs("BR-RS", "urn:iso:std:iso:3166:-2", "Rio Grande do Sul"),
  Br_Se("BR-SE", "urn:iso:std:iso:3166:-2", "Sergipe"),
  Br_To("BR-TO", "urn:iso:std:iso:3166:-2", "Tocantins"),
  Bs_Co("BS-CO", "urn:iso:std:iso:3166:-2", "Central Abaco"),
  Bs_Eg("BS-EG", "urn:iso:std:iso:3166:-2", "East Grand Bahama"),
  Bs_Hi("BS-HI", "urn:iso:std:iso:3166:-2", "Harbour Island"),
  Bs_Mi("BS-MI", "urn:iso:std:iso:3166:-2", "Moore's Island"),
  Bs_Ss("BS-SS", "urn:iso:std:iso:3166:-2", "San Salvador"),
  Bs_Sw("BS-SW", "urn:iso:std:iso:3166:-2", "Spanish Wells"),
  Bs_Ak("BS-AK", "urn:iso:std:iso:3166:-2", "Acklins"),
  Bs_Li("BS-LI", "urn:iso:std:iso:3166:-2", "Long Island"),
  Bs_By("BS-BY", "urn:iso:std:iso:3166:-2", "Berry Islands"),
  Bs_Fp("BS-FP", "urn:iso:std:iso:3166:-2", "City of Freeport"),
  Bs_Ns("BS-NS", "urn:iso:std:iso:3166:-2", "North Andros"),
  Bs_Rc("BS-RC", "urn:iso:std:iso:3166:-2", "Rum Cay"),
  Bs_So("BS-SO", "urn:iso:std:iso:3166:-2", "South Abaco"),
  Bs_Ce("BS-CE", "urn:iso:std:iso:3166:-2", "Central Eleuthera"),
  Bs_Ci("BS-CI", "urn:iso:std:iso:3166:-2", "Cat Island"),
  Bs_Cs("BS-CS", "urn:iso:std:iso:3166:-2", "Central Andros"),
  Bs_Ex("BS-EX", "urn:iso:std:iso:3166:-2", "Exuma"),
  Bs_In("BS-IN", "urn:iso:std:iso:3166:-2", "Inagua"),
  Bs_Mc("BS-MC", "urn:iso:std:iso:3166:-2", "Mangrove Cay"),
  Bs_Sa("BS-SA", "urn:iso:std:iso:3166:-2", "South Andros"),
  Bs_Gc("BS-GC", "urn:iso:std:iso:3166:-2", "Grand Cay"),
  Bs_Mg("BS-MG", "urn:iso:std:iso:3166:-2", "Mayaguana"),
  Bs_Wg("BS-WG", "urn:iso:std:iso:3166:-2", "West Grand Bahama"),
  Bs_Bi("BS-BI", "urn:iso:std:iso:3166:-2", "Bimini"),
  Bs_Bp("BS-BP", "urn:iso:std:iso:3166:-2", "Black Point"),
  Bs_Ne("BS-NE", "urn:iso:std:iso:3166:-2", "North Eleuthera"),
  Bs_No("BS-NO", "urn:iso:std:iso:3166:-2", "North Abaco"),
  Bs_Se("BS-SE", "urn:iso:std:iso:3166:-2", "South Eleuthera"),
  Bs_Ck("BS-CK", "urn:iso:std:iso:3166:-2", "Crooked Island and Long Cay"),
  Bs_Ht("BS-HT", "urn:iso:std:iso:3166:-2", "Hope Town"),
  Bs_Ri("BS-RI", "urn:iso:std:iso:3166:-2", "Ragged Island"),
  Bt_42("BT-42", "urn:iso:std:iso:3166:-2", "Monggar"),
  Bt_45("BT-45", "urn:iso:std:iso:3166:-2", "Samdrup Jongkhar"),
  Bt_12("BT-12", "urn:iso:std:iso:3166:-2", "Chhukha"),
  Bt_23("BT-23", "urn:iso:std:iso:3166:-2", "Punakha"),
  Bt_24("BT-24", "urn:iso:std:iso:3166:-2", "Wangdue Phodrang"),
  Bt_21("BT-21", "urn:iso:std:iso:3166:-2", "Tsirang"),
  Bt_33("BT-33", "urn:iso:std:iso:3166:-2", "Bumthang"),
  Bt_34("BT-34", "urn:iso:std:iso:3166:-2", "Zhemgang"),
  Bt_31("BT-31", "urn:iso:std:iso:3166:-2", "Sarpang"),
  Bt_14("BT-14", "urn:iso:std:iso:3166:-2", "Samtse"),
  Bt_15("BT-15", "urn:iso:std:iso:3166:-2", "Thimphu"),
  Bt_44("BT-44", "urn:iso:std:iso:3166:-2", "Lhuentse"),
  Bt_Ty("BT-TY", "urn:iso:std:iso:3166:-2", "Trashi Yangtse"),
  Bt_13("BT-13", "urn:iso:std:iso:3166:-2", "Haa"),
  Bt_41("BT-41", "urn:iso:std:iso:3166:-2", "Trashigang"),
  Bt_Ga("BT-GA", "urn:iso:std:iso:3166:-2", "Gasa"),
  Bt_22("BT-22", "urn:iso:std:iso:3166:-2", "Dagana"),
  Bt_32("BT-32", "urn:iso:std:iso:3166:-2", "Trongsa"),
  Bt_43("BT-43", "urn:iso:std:iso:3166:-2", "Pemagatshel"),
  Bt_11("BT-11", "urn:iso:std:iso:3166:-2", "Paro"),
  Bw_Kl("BW-KL", "urn:iso:std:iso:3166:-2", "Kgatleng"),
  Bw_Gh("BW-GH", "urn:iso:std:iso:3166:-2", "Ghanzi"),
  Bw_Nw("BW-NW", "urn:iso:std:iso:3166:-2", "North West"),
  Bw_So("BW-SO", "urn:iso:std:iso:3166:-2", "Southern"),
  Bw_Kw("BW-KW", "urn:iso:std:iso:3166:-2", "Kweneng"),
  Bw_Ch("BW-CH", "urn:iso:std:iso:3166:-2", "Chobe"),
  Bw_Lo("BW-LO", "urn:iso:std:iso:3166:-2", "Lobatse"),
  Bw_Sp("BW-SP", "urn:iso:std:iso:3166:-2", "Selibe Phikwe"),
  Bw_Jw("BW-JW", "urn:iso:std:iso:3166:-2", "Jwaneng"),
  Bw_St("BW-ST", "urn:iso:std:iso:3166:-2", "Sowa Town"),
  Bw_Fr("BW-FR", "urn:iso:std:iso:3166:-2", "Francistown"),
  Bw_Ga("BW-GA", "urn:iso:std:iso:3166:-2", "Gaborone"),
  Bw_Kg("BW-KG", "urn:iso:std:iso:3166:-2", "Kgalagadi"),
  Bw_Ce("BW-CE", "urn:iso:std:iso:3166:-2", "Central"),
  Bw_Se("BW-SE", "urn:iso:std:iso:3166:-2", "South East"),
  Bw_Ne("BW-NE", "urn:iso:std:iso:3166:-2", "North East"),
  By_Vi("BY-VI", "urn:iso:std:iso:3166:-2", "Viciebskaja voblasć"),
  By_Br("BY-BR", "urn:iso:std:iso:3166:-2", "Brestskaya oblast'"),
  By_Hm("BY-HM", "urn:iso:std:iso:3166:-2", "Horad Minsk"),
  By_Ho("BY-HO", "urn:iso:std:iso:3166:-2", "Gomel'skaja oblast'"),
  By_Hr("BY-HR", "urn:iso:std:iso:3166:-2", "Grodnenskaja oblast'"),
  By_Mi("BY-MI", "urn:iso:std:iso:3166:-2", "Minskaja  voblasć"),
  By_Ma("BY-MA", "urn:iso:std:iso:3166:-2", "Mogilevskaja oblast'"),
  Bz_Ow("BZ-OW", "urn:iso:std:iso:3166:-2", "Orange Walk"),
  Bz_Czl("BZ-CZL", "urn:iso:std:iso:3166:-2", "Corozal"),
  Bz_Sc("BZ-SC", "urn:iso:std:iso:3166:-2", "Stann Creek"),
  Bz_Tol("BZ-TOL", "urn:iso:std:iso:3166:-2", "Toledo"),
  Bz_Bz("BZ-BZ", "urn:iso:std:iso:3166:-2", "Belize"),
  Bz_Cy("BZ-CY", "urn:iso:std:iso:3166:-2", "Cayo"),
  Ca_Bc("CA-BC", "urn:iso:std:iso:3166:-2", "Colombie-Britannique"),
  Ca_Mb("CA-MB", "urn:iso:std:iso:3166:-2", "Manitoba"),
  Ca_Nb("CA-NB", "urn:iso:std:iso:3166:-2", "Nouveau-Brunswick"),
  Ca_Sk("CA-SK", "urn:iso:std:iso:3166:-2", "Saskatchewan"),
  Ca_Ab("CA-AB", "urn:iso:std:iso:3166:-2", "Alberta"),
  Ca_On("CA-ON", "urn:iso:std:iso:3166:-2", "Ontario"),
  Ca_Yt("CA-YT", "urn:iso:std:iso:3166:-2", "Yukon"),
  Ca_Nt("CA-NT", "urn:iso:std:iso:3166:-2", "Territoires du Nord-Ouest"),
  Ca_Nu("CA-NU", "urn:iso:std:iso:3166:-2", "Nunavut"),
  Ca_Nl("CA-NL", "urn:iso:std:iso:3166:-2", "Newfoundland and Labrador"),
  Ca_Pe("CA-PE", "urn:iso:std:iso:3166:-2", "Île-du-Prince-Édouard"),
  Ca_Ns("CA-NS", "urn:iso:std:iso:3166:-2", "Nova Scotia"),
  Ca_Qc("CA-QC", "urn:iso:std:iso:3166:-2", "Quebec"),
  Cd_Eq("CD-EQ", "urn:iso:std:iso:3166:-2", "Équateur"),
  Cd_Bc("CD-BC", "urn:iso:std:iso:3166:-2", "Kongo Central"),
  Cd_Sk("CD-SK", "urn:iso:std:iso:3166:-2", "Sud-Kivu"),
  Cd_Nk("CD-NK", "urn:iso:std:iso:3166:-2", "Nord-Kivu"),
  Cd_Ke("CD-KE", "urn:iso:std:iso:3166:-2", "Kasaï Oriental"),
  Cd_Kn("CD-KN", "urn:iso:std:iso:3166:-2", "Kinshasa"),
  Cd_Bu("CD-BU", "urn:iso:std:iso:3166:-2", "Bas-Uélé"),
  Cd_Hk("CD-HK", "urn:iso:std:iso:3166:-2", "Haut-Katanga"),
  Cd_Hl("CD-HL", "urn:iso:std:iso:3166:-2", "Haut-Lomami"),
  Cd_Hu("CD-HU", "urn:iso:std:iso:3166:-2", "Haut-Uélé"),
  Cd_It("CD-IT", "urn:iso:std:iso:3166:-2", "Ituri"),
  Cd_Ks("CD-KS", "urn:iso:std:iso:3166:-2", "Kasaï"),
  Cd_Kc("CD-KC", "urn:iso:std:iso:3166:-2", "Kasaï Central"),
  Cd_Kg("CD-KG", "urn:iso:std:iso:3166:-2", "Kwango"),
  Cd_Kl("CD-KL", "urn:iso:std:iso:3166:-2", "Kwilu"),
  Cd_Lo("CD-LO", "urn:iso:std:iso:3166:-2", "Lomami"),
  Cd_Lu("CD-LU", "urn:iso:std:iso:3166:-2", "Lualaba"),
  Cd_Mn("CD-MN", "urn:iso:std:iso:3166:-2", "Mai-Ndombe"),
  Cd_Mo("CD-MO", "urn:iso:std:iso:3166:-2", "Mongala"),
  Cd_Nu("CD-NU", "urn:iso:std:iso:3166:-2", "Nord-Ubangi"),
  Cd_Sa("CD-SA", "urn:iso:std:iso:3166:-2", "Sankuru"),
  Cd_Su("CD-SU", "urn:iso:std:iso:3166:-2", "Sud-Ubangi"),
  Cd_Ta("CD-TA", "urn:iso:std:iso:3166:-2", "Tanganyika"),
  Cd_To("CD-TO", "urn:iso:std:iso:3166:-2", "Tshopo"),
  Cd_Tu("CD-TU", "urn:iso:std:iso:3166:-2", "Tshuapa"),
  Cd_Ma("CD-MA", "urn:iso:std:iso:3166:-2", "Maniema"),
  Cf_Hm("CF-HM", "urn:iso:std:iso:3166:-2", "Tö-Mbömü"),
  Cf_Hs("CF-HS", "urn:iso:std:iso:3166:-2", "Tö-Sangä / Mbaere-Kadeï"),
  Cf_Lb("CF-LB", "urn:iso:std:iso:3166:-2", "Lobaye"),
  Cf_Ac("CF-AC", "urn:iso:std:iso:3166:-2", "Ouham"),
  Cf_Kb("CF-KB", "urn:iso:std:iso:3166:-2", "Gribingui"),
  Cf_Bb("CF-BB", "urn:iso:std:iso:3166:-2", "Bamïngï-Bangoran"),
  Cf_Mp("CF-MP", "urn:iso:std:iso:3166:-2", "Ömbëlä-Pökö"),
  Cf_Hk("CF-HK", "urn:iso:std:iso:3166:-2", "Tö-Kötö"),
  Cf_Kg("CF-KG", "urn:iso:std:iso:3166:-2", "Kemö-Gïrïbïngï"),
  Cf_Mb("CF-MB", "urn:iso:std:iso:3166:-2", "Mbömü"),
  Cf_Nm("CF-NM", "urn:iso:std:iso:3166:-2", "Nana-Mambéré"),
  Cf_Se("CF-SE", "urn:iso:std:iso:3166:-2", "Sangha"),
  Cf_Vk("CF-VK", "urn:iso:std:iso:3166:-2", "Vakaga"),
  Cf_Bgf("CF-BGF", "urn:iso:std:iso:3166:-2", "Bangî"),
  Cf_Op("CF-OP", "urn:iso:std:iso:3166:-2", "Wâmo-Pendë"),
  Cf_Uk("CF-UK", "urn:iso:std:iso:3166:-2", "Wäkä"),
  Cf_Bk("CF-BK", "urn:iso:std:iso:3166:-2", "Basse-Kotto"),
  Cg_9("CG-9", "urn:iso:std:iso:3166:-2", "Niari"),
  Cg_15("CG-15", "urn:iso:std:iso:3166:-2", "Cuvette-Ouest"),
  Cg_5("CG-5", "urn:iso:std:iso:3166:-2", "Kouilou"),
  Cg_11("CG-11", "urn:iso:std:iso:3166:-2", "Bouenza"),
  Cg_Bzv("CG-BZV", "urn:iso:std:iso:3166:-2", "Brazzaville"),
  Cg_16("CG-16", "urn:iso:std:iso:3166:-2", "Pointe-Noire"),
  Cg_12("CG-12", "urn:iso:std:iso:3166:-2", "Pool"),
  Cg_13("CG-13", "urn:iso:std:iso:3166:-2", "Sangha"),
  Cg_7("CG-7", "urn:iso:std:iso:3166:-2", "Likouala"),
  Cg_14("CG-14", "urn:iso:std:iso:3166:-2", "Plateaux"),
  Cg_2("CG-2", "urn:iso:std:iso:3166:-2", "Lékoumou"),
  Cg_8("CG-8", "urn:iso:std:iso:3166:-2", "Cuvette"),
  Ch_Ju("CH-JU", "urn:iso:std:iso:3166:-2", "Jura"),
  Ch_Lu("CH-LU", "urn:iso:std:iso:3166:-2", "Luzern"),
  Ch_So("CH-SO", "urn:iso:std:iso:3166:-2", "Solothurn"),
  Ch_Tg("CH-TG", "urn:iso:std:iso:3166:-2", "Thurgau"),
  Ch_Bs("CH-BS", "urn:iso:std:iso:3166:-2", "Basel-Stadt"),
  Ch_Sz("CH-SZ", "urn:iso:std:iso:3166:-2", "Schwyz"),
  Ch_Zg("CH-ZG", "urn:iso:std:iso:3166:-2", "Zug"),
  Ch_Ag("CH-AG", "urn:iso:std:iso:3166:-2", "Aargau"),
  Ch_Be("CH-BE", "urn:iso:std:iso:3166:-2", "Bern"),
  Ch_Fr("CH-FR", "urn:iso:std:iso:3166:-2", "Freiburg"),
  Ch_Ne("CH-NE", "urn:iso:std:iso:3166:-2", "Neuchâtel"),
  Ch_Ow("CH-OW", "urn:iso:std:iso:3166:-2", "Obwalden"),
  Ch_Ti("CH-TI", "urn:iso:std:iso:3166:-2", "Ticino"),
  Ch_Vd("CH-VD", "urn:iso:std:iso:3166:-2", "Vaud"),
  Ch_Ar("CH-AR", "urn:iso:std:iso:3166:-2", "Appenzell Ausserrhoden"),
  Ch_Ge("CH-GE", "urn:iso:std:iso:3166:-2", "Genève"),
  Ch_Gl("CH-GL", "urn:iso:std:iso:3166:-2", "Glarus"),
  Ch_Sg("CH-SG", "urn:iso:std:iso:3166:-2", "Sankt Gallen"),
  Ch_Gr("CH-GR", "urn:iso:std:iso:3166:-2", "Grigioni"),
  Ch_Nw("CH-NW", "urn:iso:std:iso:3166:-2", "Nidwalden"),
  Ch_Sh("CH-SH", "urn:iso:std:iso:3166:-2", "Schaffhausen"),
  Ch_Zh("CH-ZH", "urn:iso:std:iso:3166:-2", "Zürich"),
  Ch_Ai("CH-AI", "urn:iso:std:iso:3166:-2", "Appenzell Innerrhoden"),
  Ch_Vs("CH-VS", "urn:iso:std:iso:3166:-2", "Valais"),
  Ch_Bl("CH-BL", "urn:iso:std:iso:3166:-2", "Basel-Landschaft"),
  Ch_Ur("CH-UR", "urn:iso:std:iso:3166:-2", "Uri"),
  Ci_Ab("CI-AB", "urn:iso:std:iso:3166:-2", "Abidjan"),
  Ci_Ym("CI-YM", "urn:iso:std:iso:3166:-2", "Yamoussoukro"),
  Ci_Bs("CI-BS", "urn:iso:std:iso:3166:-2", "Bas-Sassandra"),
  Ci_Cm("CI-CM", "urn:iso:std:iso:3166:-2", "Comoé"),
  Ci_Dn("CI-DN", "urn:iso:std:iso:3166:-2", "Denguélé"),
  Ci_Gd("CI-GD", "urn:iso:std:iso:3166:-2", "Gôh-Djiboua"),
  Ci_Lc("CI-LC", "urn:iso:std:iso:3166:-2", "Lacs"),
  Ci_Lg("CI-LG", "urn:iso:std:iso:3166:-2", "Lagunes"),
  Ci_Mg("CI-MG", "urn:iso:std:iso:3166:-2", "Montagnes"),
  Ci_Sm("CI-SM", "urn:iso:std:iso:3166:-2", "Sassandra-Marahoué"),
  Ci_Sv("CI-SV", "urn:iso:std:iso:3166:-2", "Savanes"),
  Ci_Vb("CI-VB", "urn:iso:std:iso:3166:-2", "Vallée du Bandama"),
  Ci_Wr("CI-WR", "urn:iso:std:iso:3166:-2", "Woroba"),
  Ci_Zz("CI-ZZ", "urn:iso:std:iso:3166:-2", "Zanzan"),
  Cl_An("CL-AN", "urn:iso:std:iso:3166:-2", "Antofagasta"),
  Cl_Rm("CL-RM", "urn:iso:std:iso:3166:-2", "Región Metropolitana de Santiago"),
  Cl_Ta("CL-TA", "urn:iso:std:iso:3166:-2", "Tarapacá"),
  Cl_Bi("CL-BI", "urn:iso:std:iso:3166:-2", "Biobío"),
  Cl_Ap("CL-AP", "urn:iso:std:iso:3166:-2", "Arica y Parinacota"),
  Cl_At("CL-AT", "urn:iso:std:iso:3166:-2", "Atacama"),
  Cl_Ll("CL-LL", "urn:iso:std:iso:3166:-2", "Los Lagos"),
  Cl_Lr("CL-LR", "urn:iso:std:iso:3166:-2", "Los Ríos"),
  Cl_Ml("CL-ML", "urn:iso:std:iso:3166:-2", "Maule"),
  Cl_Ar("CL-AR", "urn:iso:std:iso:3166:-2", "La Araucanía"),
  Cl_Li("CL-LI", "urn:iso:std:iso:3166:-2", "Libertador General Bernardo O'Higgins"),
  Cl_Ai("CL-AI", "urn:iso:std:iso:3166:-2", "Aisén del General Carlos Ibañez del Campo"),
  Cl_Vs("CL-VS", "urn:iso:std:iso:3166:-2", "Valparaíso"),
  Cl_Co("CL-CO", "urn:iso:std:iso:3166:-2", "Coquimbo"),
  Cl_Ma("CL-MA", "urn:iso:std:iso:3166:-2", "Magallanes"),
  Cm_Nw("CM-NW", "urn:iso:std:iso:3166:-2", "Nord-Ouest"),
  Cm_Ou("CM-OU", "urn:iso:std:iso:3166:-2", "West"),
  Cm_Ad("CM-AD", "urn:iso:std:iso:3166:-2", "Adamaoua"),
  Cm_Lt("CM-LT", "urn:iso:std:iso:3166:-2", "Littoral"),
  Cm_No("CM-NO", "urn:iso:std:iso:3166:-2", "Nord"),
  Cm_Ce("CM-CE", "urn:iso:std:iso:3166:-2", "Centre"),
  Cm_En("CM-EN", "urn:iso:std:iso:3166:-2", "Extrême-Nord"),
  Cm_Es("CM-ES", "urn:iso:std:iso:3166:-2", "East"),
  Cm_Su("CM-SU", "urn:iso:std:iso:3166:-2", "South"),
  Cm_Sw("CM-SW", "urn:iso:std:iso:3166:-2", "Sud-Ouest"),
  Cn_Nm("CN-NM", "urn:iso:std:iso:3166:-2", "Nei Mongol Zizhiqu"),
  Cn_Gx("CN-GX", "urn:iso:std:iso:3166:-2", "Guangxi Zhuangzu Zizhiqu"),
  Cn_Xz("CN-XZ", "urn:iso:std:iso:3166:-2", "Xizang Zizhiqu"),
  Cn_Nx("CN-NX", "urn:iso:std:iso:3166:-2", "Ningxia Huizi Zizhiqu"),
  Cn_Xj("CN-XJ", "urn:iso:std:iso:3166:-2", "Xinjiang Uygur Zizhiqu"),
  Cn_Bj("CN-BJ", "urn:iso:std:iso:3166:-2", "Beijing Shi"),
  Cn_Tj("CN-TJ", "urn:iso:std:iso:3166:-2", "Tianjin Shi"),
  Cn_Sh("CN-SH", "urn:iso:std:iso:3166:-2", "Shanghai Shi"),
  Cn_Cq("CN-CQ", "urn:iso:std:iso:3166:-2", "Chongqing Shi"),
  Cn_He("CN-HE", "urn:iso:std:iso:3166:-2", "Hebei Sheng"),
  Cn_Sx("CN-SX", "urn:iso:std:iso:3166:-2", "Shanxi Sheng"),
  Cn_Ln("CN-LN", "urn:iso:std:iso:3166:-2", "Liaoning Sheng"),
  Cn_Jl("CN-JL", "urn:iso:std:iso:3166:-2", "Jilin Sheng"),
  Cn_Hl("CN-HL", "urn:iso:std:iso:3166:-2", "Heilongjiang Sheng"),
  Cn_Zj("CN-ZJ", "urn:iso:std:iso:3166:-2", "Zhejiang Sheng"),
  Cn_Ah("CN-AH", "urn:iso:std:iso:3166:-2", "Anhui Sheng"),
  Cn_Fj("CN-FJ", "urn:iso:std:iso:3166:-2", "Fujian Sheng"),
  Cn_Jx("CN-JX", "urn:iso:std:iso:3166:-2", "Jiangxi Sheng"),
  Cn_Sd("CN-SD", "urn:iso:std:iso:3166:-2", "Shandong Sheng"),
  Cn_Ha("CN-HA", "urn:iso:std:iso:3166:-2", "Henan Sheng"),
  Cn_Hb("CN-HB", "urn:iso:std:iso:3166:-2", "Hubei Sheng"),
  Cn_Hn("CN-HN", "urn:iso:std:iso:3166:-2", "Hunan Sheng"),
  Cn_Gd("CN-GD", "urn:iso:std:iso:3166:-2", "Guangdong Sheng"),
  Cn_Hi("CN-HI", "urn:iso:std:iso:3166:-2", "Hainan Sheng"),
  Cn_Sc("CN-SC", "urn:iso:std:iso:3166:-2", "Sichuan Sheng"),
  Cn_Gz("CN-GZ", "urn:iso:std:iso:3166:-2", "Guizhou Sheng"),
  Cn_Yn("CN-YN", "urn:iso:std:iso:3166:-2", "Yunnan Sheng"),
  Cn_Sn("CN-SN", "urn:iso:std:iso:3166:-2", "Shaanxi Sheng"),
  Cn_Gs("CN-GS", "urn:iso:std:iso:3166:-2", "Gansu Sheng"),
  Cn_Qh("CN-QH", "urn:iso:std:iso:3166:-2", "Qinghai Sheng"),
  Cn_Tw(
    "CN-TW",
    "urn:iso:std:iso:3166:-2",
    "Taiwan Sheng (see also separate country code entry under TW)",
  ),
  Cn_Hk(
    "CN-HK",
    "urn:iso:std:iso:3166:-2",
    "Hong Kong SAR (see also separate country code entry under HK)",
  ),
  Cn_Mo(
    "CN-MO",
    "urn:iso:std:iso:3166:-2",
    "Macao SAR (see also separate country code entry under MO)",
  ),
  Cn_Js("CN-JS", "urn:iso:std:iso:3166:-2", "Jiangsu Sheng"),
  Co_Bol("CO-BOL", "urn:iso:std:iso:3166:-2", "Bolívar"),
  Co_Mag("CO-MAG", "urn:iso:std:iso:3166:-2", "Magdalena"),
  Co_Met("CO-MET", "urn:iso:std:iso:3166:-2", "Meta"),
  Co_Put("CO-PUT", "urn:iso:std:iso:3166:-2", "Putumayo"),
  Co_Vid("CO-VID", "urn:iso:std:iso:3166:-2", "Vichada"),
  Co_Ama("CO-AMA", "urn:iso:std:iso:3166:-2", "Amazonas"),
  Co_Cal("CO-CAL", "urn:iso:std:iso:3166:-2", "Caldas"),
  Co_Cau("CO-CAU", "urn:iso:std:iso:3166:-2", "Cauca"),
  Co_Ces("CO-CES", "urn:iso:std:iso:3166:-2", "Cesar"),
  Co_Dc("CO-DC", "urn:iso:std:iso:3166:-2", "Distrito Capital de Bogotá"),
  Co_Lag("CO-LAG", "urn:iso:std:iso:3166:-2", "La Guajira"),
  Co_Ara("CO-ARA", "urn:iso:std:iso:3166:-2", "Arauca"),
  Co_Nsa("CO-NSA", "urn:iso:std:iso:3166:-2", "Norte de Santander"),
  Co_Tol("CO-TOL", "urn:iso:std:iso:3166:-2", "Tolima"),
  Co_Vac("CO-VAC", "urn:iso:std:iso:3166:-2", "Valle del Cauca"),
  Co_Guv("CO-GUV", "urn:iso:std:iso:3166:-2", "Guaviare"),
  Co_Hui("CO-HUI", "urn:iso:std:iso:3166:-2", "Huila"),
  Co_Suc("CO-SUC", "urn:iso:std:iso:3166:-2", "Sucre"),
  Co_Cas("CO-CAS", "urn:iso:std:iso:3166:-2", "Casanare"),
  Co_Cho("CO-CHO", "urn:iso:std:iso:3166:-2", "Chocó"),
  Co_Gua("CO-GUA", "urn:iso:std:iso:3166:-2", "Guainía"),
  Co_Qui("CO-QUI", "urn:iso:std:iso:3166:-2", "Quindío"),
  Co_Ris("CO-RIS", "urn:iso:std:iso:3166:-2", "Risaralda"),
  Co_San("CO-SAN", "urn:iso:std:iso:3166:-2", "Santander"),
  Co_Vau("CO-VAU", "urn:iso:std:iso:3166:-2", "Vaupés"),
  Co_Ant("CO-ANT", "urn:iso:std:iso:3166:-2", "Antioquia"),
  Co_Atl("CO-ATL", "urn:iso:std:iso:3166:-2", "Atlántico"),
  Co_Cor("CO-COR", "urn:iso:std:iso:3166:-2", "Córdoba"),
  Co_Sap("CO-SAP", "urn:iso:std:iso:3166:-2", "San Andrés, Providencia y Santa Catalina"),
  Co_Boy("CO-BOY", "urn:iso:std:iso:3166:-2", "Boyacá"),
  Co_Caq("CO-CAQ", "urn:iso:std:iso:3166:-2", "Caquetá"),
  Co_Cun("CO-CUN", "urn:iso:std:iso:3166:-2", "Cundinamarca"),
  Co_Nar("CO-NAR", "urn:iso:std:iso:3166:-2", "Nariño"),
  Cr_H("CR-H", "urn:iso:std:iso:3166:-2", "Heredia"),
  Cr_L("CR-L", "urn:iso:std:iso:3166:-2", "Limón"),
  Cr_G("CR-G", "urn:iso:std:iso:3166:-2", "Guanacaste"),
  Cr_P("CR-P", "urn:iso:std:iso:3166:-2", "Puntarenas"),
  Cr_A("CR-A", "urn:iso:std:iso:3166:-2", "Alajuela"),
  Cr_C("CR-C", "urn:iso:std:iso:3166:-2", "Cartago"),
  Cr_Sj("CR-SJ", "urn:iso:std:iso:3166:-2", "San José"),
  Cu_03("CU-03", "urn:iso:std:iso:3166:-2", "La Habana"),
  Cu_07("CU-07", "urn:iso:std:iso:3166:-2", "Sancti Spíritus"),
  Cu_12("CU-12", "urn:iso:std:iso:3166:-2", "Granma"),
  Cu_05("CU-05", "urn:iso:std:iso:3166:-2", "Villa Clara"),
  Cu_11("CU-11", "urn:iso:std:iso:3166:-2", "Holguín"),
  Cu_08("CU-08", "urn:iso:std:iso:3166:-2", "Ciego de Ávila"),
  Cu_09("CU-09", "urn:iso:std:iso:3166:-2", "Camagüey"),
  Cu_10("CU-10", "urn:iso:std:iso:3166:-2", "Las Tunas"),
  Cu_13("CU-13", "urn:iso:std:iso:3166:-2", "Santiago de Cuba"),
  Cu_15("CU-15", "urn:iso:std:iso:3166:-2", "Artemisa"),
  Cu_16("CU-16", "urn:iso:std:iso:3166:-2", "Mayabeque"),
  Cu_01("CU-01", "urn:iso:std:iso:3166:-2", "Pinar del Río"),
  Cu_14("CU-14", "urn:iso:std:iso:3166:-2", "Guantánamo"),
  Cu_99("CU-99", "urn:iso:std:iso:3166:-2", "Isla de la Juventud"),
  Cu_04("CU-04", "urn:iso:std:iso:3166:-2", "Matanzas"),
  Cu_06("CU-06", "urn:iso:std:iso:3166:-2", "Cienfuegos"),
  Cv_B("CV-B", "urn:iso:std:iso:3166:-2", "Ilhas de Barlavento"),
  Cv_S("CV-S", "urn:iso:std:iso:3166:-2", "Ilhas de Sotavento"),
  Cy_03("CY-03", "urn:iso:std:iso:3166:-2", "Larnaka"),
  Cy_06("CY-06", "urn:iso:std:iso:3166:-2", "Keryneia"),
  Cy_01("CY-01", "urn:iso:std:iso:3166:-2", "Lefkosia"),
  Cy_04("CY-04", "urn:iso:std:iso:3166:-2", "Mağusa"),
  Cy_05("CY-05", "urn:iso:std:iso:3166:-2", "Pafos"),
  Cy_02("CY-02", "urn:iso:std:iso:3166:-2", "Leymasun"),
  Cz_42("CZ-42", "urn:iso:std:iso:3166:-2", "Ústecký kraj"),
  Cz_63("CZ-63", "urn:iso:std:iso:3166:-2", "Kraj Vysočina"),
  Cz_72("CZ-72", "urn:iso:std:iso:3166:-2", "Zlínský kraj"),
  Cz_31("CZ-31", "urn:iso:std:iso:3166:-2", "Jihočeský kraj"),
  Cz_64("CZ-64", "urn:iso:std:iso:3166:-2", "Jihomoravský kraj"),
  Cz_41("CZ-41", "urn:iso:std:iso:3166:-2", "Karlovarský kraj"),
  Cz_52("CZ-52", "urn:iso:std:iso:3166:-2", "Královéhradecký kraj"),
  Cz_51("CZ-51", "urn:iso:std:iso:3166:-2", "Liberecký kraj"),
  Cz_80("CZ-80", "urn:iso:std:iso:3166:-2", "Moravskoslezský kraj"),
  Cz_71("CZ-71", "urn:iso:std:iso:3166:-2", "Olomoucký kraj"),
  Cz_53("CZ-53", "urn:iso:std:iso:3166:-2", "Pardubický kraj"),
  Cz_32("CZ-32", "urn:iso:std:iso:3166:-2", "Plzeňský kraj"),
  Cz_20("CZ-20", "urn:iso:std:iso:3166:-2", "Středočeský kraj"),
  Cz_10("CZ-10", "urn:iso:std:iso:3166:-2", "Praha, Hlavní mešto"),
  De_Bw("DE-BW", "urn:iso:std:iso:3166:-2", "Baden-Württemberg"),
  De_Mv("DE-MV", "urn:iso:std:iso:3166:-2", "Mecklenburg-Vorpommern"),
  De_Nw("DE-NW", "urn:iso:std:iso:3166:-2", "Nordrhein-Westfalen"),
  De_Sl("DE-SL", "urn:iso:std:iso:3166:-2", "Saarland"),
  De_Th("DE-TH", "urn:iso:std:iso:3166:-2", "Thüringen"),
  De_St("DE-ST", "urn:iso:std:iso:3166:-2", "Sachsen-Anhalt"),
  De_Hh("DE-HH", "urn:iso:std:iso:3166:-2", "Hamburg"),
  De_Bb("DE-BB", "urn:iso:std:iso:3166:-2", "Brandenburg"),
  De_Be("DE-BE", "urn:iso:std:iso:3166:-2", "Berlin"),
  De_By("DE-BY", "urn:iso:std:iso:3166:-2", "Bayern"),
  De_Hb("DE-HB", "urn:iso:std:iso:3166:-2", "Bremen"),
  De_He("DE-HE", "urn:iso:std:iso:3166:-2", "Hessen"),
  De_Ni("DE-NI", "urn:iso:std:iso:3166:-2", "Niedersachsen"),
  De_Sh("DE-SH", "urn:iso:std:iso:3166:-2", "Schleswig-Holstein"),
  De_Rp("DE-RP", "urn:iso:std:iso:3166:-2", "Rheinland-Pfalz"),
  De_Sn("DE-SN", "urn:iso:std:iso:3166:-2", "Sachsen"),
  Dj_Ob("DJ-OB", "urn:iso:std:iso:3166:-2", "Awbūk"),
  Dj_Ar("DJ-AR", "urn:iso:std:iso:3166:-2", "Arta"),
  Dj_Di("DJ-DI", "urn:iso:std:iso:3166:-2", "Dikhīl"),
  Dj_Dj("DJ-DJ", "urn:iso:std:iso:3166:-2", "Jībūtī"),
  Dj_As("DJ-AS", "urn:iso:std:iso:3166:-2", "‘Alī Şabīḩ"),
  Dj_Ta("DJ-TA", "urn:iso:std:iso:3166:-2", "Tadjourah"),
  Dk_82("DK-82", "urn:iso:std:iso:3166:-2", "Midtjylland"),
  Dk_85("DK-85", "urn:iso:std:iso:3166:-2", "Sjælland"),
  Dk_81("DK-81", "urn:iso:std:iso:3166:-2", "Nordjylland"),
  Dk_84("DK-84", "urn:iso:std:iso:3166:-2", "Hovedstaden"),
  Dk_83("DK-83", "urn:iso:std:iso:3166:-2", "Syddanmark"),
  Dm_06("DM-06", "urn:iso:std:iso:3166:-2", "Saint Joseph"),
  Dm_08("DM-08", "urn:iso:std:iso:3166:-2", "Saint Mark"),
  Dm_09("DM-09", "urn:iso:std:iso:3166:-2", "Saint Patrick"),
  Dm_03("DM-03", "urn:iso:std:iso:3166:-2", "Saint David"),
  Dm_02("DM-02", "urn:iso:std:iso:3166:-2", "Saint Andrew"),
  Dm_11("DM-11", "urn:iso:std:iso:3166:-2", "Saint Peter"),
  Dm_04("DM-04", "urn:iso:std:iso:3166:-2", "Saint George"),
  Dm_10("DM-10", "urn:iso:std:iso:3166:-2", "Saint Paul"),
  Dm_05("DM-05", "urn:iso:std:iso:3166:-2", "Saint John"),
  Dm_07("DM-07", "urn:iso:std:iso:3166:-2", "Saint Luke"),
  Do_33("DO-33", "urn:iso:std:iso:3166:-2", "Cibao Nordeste"),
  Do_34("DO-34", "urn:iso:std:iso:3166:-2", "Cibao Noroeste"),
  Do_35("DO-35", "urn:iso:std:iso:3166:-2", "Cibao Norte"),
  Do_36("DO-36", "urn:iso:std:iso:3166:-2", "Cibao Sur"),
  Do_37("DO-37", "urn:iso:std:iso:3166:-2", "El Valle"),
  Do_38("DO-38", "urn:iso:std:iso:3166:-2", "Enriquillo"),
  Do_39("DO-39", "urn:iso:std:iso:3166:-2", "Higuamo"),
  Do_40("DO-40", "urn:iso:std:iso:3166:-2", "Ozama"),
  Do_41("DO-41", "urn:iso:std:iso:3166:-2", "Valdesia"),
  Do_42("DO-42", "urn:iso:std:iso:3166:-2", "Yuma"),
  Dz_06("DZ-06", "urn:iso:std:iso:3166:-2", "Béjaïa"),
  Dz_11("DZ-11", "urn:iso:std:iso:3166:-2", "Tamanrasset"),
  Dz_13("DZ-13", "urn:iso:std:iso:3166:-2", "Tlemcen"),
  Dz_27("DZ-27", "urn:iso:std:iso:3166:-2", "Mostaganem"),
  Dz_40("DZ-40", "urn:iso:std:iso:3166:-2", "Khenchela"),
  Dz_03("DZ-03", "urn:iso:std:iso:3166:-2", "Laghouat"),
  Dz_09("DZ-09", "urn:iso:std:iso:3166:-2", "Blida"),
  Dz_14("DZ-14", "urn:iso:std:iso:3166:-2", "Tiaret"),
  Dz_15("DZ-15", "urn:iso:std:iso:3166:-2", "Tizi Ouzou"),
  Dz_19("DZ-19", "urn:iso:std:iso:3166:-2", "Sétif"),
  Dz_20("DZ-20", "urn:iso:std:iso:3166:-2", "Saïda"),
  Dz_35("DZ-35", "urn:iso:std:iso:3166:-2", "Boumerdès"),
  Dz_41("DZ-41", "urn:iso:std:iso:3166:-2", "Souk Ahras"),
  Dz_42("DZ-42", "urn:iso:std:iso:3166:-2", "Tipaza"),
  Dz_44("DZ-44", "urn:iso:std:iso:3166:-2", "Aïn Defla"),
  Dz_02("DZ-02", "urn:iso:std:iso:3166:-2", "Chlef"),
  Dz_04("DZ-04", "urn:iso:std:iso:3166:-2", "Oum el Bouaghi"),
  Dz_05("DZ-05", "urn:iso:std:iso:3166:-2", "Batna"),
  Dz_23("DZ-23", "urn:iso:std:iso:3166:-2", "Annaba"),
  Dz_39("DZ-39", "urn:iso:std:iso:3166:-2", "El Oued"),
  Dz_01("DZ-01", "urn:iso:std:iso:3166:-2", "Adrar"),
  Dz_08("DZ-08", "urn:iso:std:iso:3166:-2", "Béchar"),
  Dz_16("DZ-16", "urn:iso:std:iso:3166:-2", "Alger"),
  Dz_28("DZ-28", "urn:iso:std:iso:3166:-2", "M'sila"),
  Dz_31("DZ-31", "urn:iso:std:iso:3166:-2", "Oran"),
  Dz_07("DZ-07", "urn:iso:std:iso:3166:-2", "Biskra"),
  Dz_24("DZ-24", "urn:iso:std:iso:3166:-2", "Guelma"),
  Dz_33("DZ-33", "urn:iso:std:iso:3166:-2", "Illizi"),
  Dz_36("DZ-36", "urn:iso:std:iso:3166:-2", "El Tarf"),
  Dz_38("DZ-38", "urn:iso:std:iso:3166:-2", "Tissemsilt"),
  Dz_45("DZ-45", "urn:iso:std:iso:3166:-2", "Naama"),
  Dz_10("DZ-10", "urn:iso:std:iso:3166:-2", "Bouira"),
  Dz_21("DZ-21", "urn:iso:std:iso:3166:-2", "Skikda"),
  Dz_25("DZ-25", "urn:iso:std:iso:3166:-2", "Constantine"),
  Dz_32("DZ-32", "urn:iso:std:iso:3166:-2", "El Bayadh"),
  Dz_43("DZ-43", "urn:iso:std:iso:3166:-2", "Mila"),
  Dz_46("DZ-46", "urn:iso:std:iso:3166:-2", "Aïn Témouchent"),
  Dz_48("DZ-48", "urn:iso:std:iso:3166:-2", "Relizane"),
  Dz_17("DZ-17", "urn:iso:std:iso:3166:-2", "Djelfa"),
  Dz_18("DZ-18", "urn:iso:std:iso:3166:-2", "Jijel"),
  Dz_22("DZ-22", "urn:iso:std:iso:3166:-2", "Sidi Bel Abbès"),
  Dz_30("DZ-30", "urn:iso:std:iso:3166:-2", "Ouargla"),
  Dz_47("DZ-47", "urn:iso:std:iso:3166:-2", "Ghardaïa"),
  Dz_12("DZ-12", "urn:iso:std:iso:3166:-2", "Tébessa"),
  Dz_26("DZ-26", "urn:iso:std:iso:3166:-2", "Médéa"),
  Dz_29("DZ-29", "urn:iso:std:iso:3166:-2", "Mascara"),
  Dz_34("DZ-34", "urn:iso:std:iso:3166:-2", "Bordj Bou Arréridj"),
  Dz_37("DZ-37", "urn:iso:std:iso:3166:-2", "Tindouf"),
  Ec_E("EC-E", "urn:iso:std:iso:3166:-2", "Esmeraldas"),
  Ec_G("EC-G", "urn:iso:std:iso:3166:-2", "Guayas"),
  Ec_X("EC-X", "urn:iso:std:iso:3166:-2", "Cotopaxi"),
  Ec_Y("EC-Y", "urn:iso:std:iso:3166:-2", "Pastaza"),
  Ec_A("EC-A", "urn:iso:std:iso:3166:-2", "Azuay"),
  Ec_D("EC-D", "urn:iso:std:iso:3166:-2", "Orellana"),
  Ec_L("EC-L", "urn:iso:std:iso:3166:-2", "Loja"),
  Ec_O("EC-O", "urn:iso:std:iso:3166:-2", "El Oro"),
  Ec_Se("EC-SE", "urn:iso:std:iso:3166:-2", "Santa Elena"),
  Ec_Z("EC-Z", "urn:iso:std:iso:3166:-2", "Zamora Chinchipe"),
  Ec_H("EC-H", "urn:iso:std:iso:3166:-2", "Chimborazo"),
  Ec_Sd("EC-SD", "urn:iso:std:iso:3166:-2", "Santo Domingo de los Tsáchilas"),
  Ec_I("EC-I", "urn:iso:std:iso:3166:-2", "Imbabura"),
  Ec_M("EC-M", "urn:iso:std:iso:3166:-2", "Manabí"),
  Ec_P("EC-P", "urn:iso:std:iso:3166:-2", "Pichincha"),
  Ec_W("EC-W", "urn:iso:std:iso:3166:-2", "Galápagos"),
  Ec_C("EC-C", "urn:iso:std:iso:3166:-2", "Carchi"),
  Ec_F("EC-F", "urn:iso:std:iso:3166:-2", "Cañar"),
  Ec_S("EC-S", "urn:iso:std:iso:3166:-2", "Morona Santiago"),
  Ec_U("EC-U", "urn:iso:std:iso:3166:-2", "Sucumbíos"),
  Ec_N("EC-N", "urn:iso:std:iso:3166:-2", "Napo"),
  Ec_T("EC-T", "urn:iso:std:iso:3166:-2", "Tungurahua"),
  Ec_B("EC-B", "urn:iso:std:iso:3166:-2", "Bolívar"),
  Ec_R("EC-R", "urn:iso:std:iso:3166:-2", "Los Ríos"),
  Ee_78("EE-78", "urn:iso:std:iso:3166:-2", "Tartumaa"),
  Ee_49("EE-49", "urn:iso:std:iso:3166:-2", "Jõgevamaa"),
  Ee_51("EE-51", "urn:iso:std:iso:3166:-2", "Järvamaa"),
  Ee_70("EE-70", "urn:iso:std:iso:3166:-2", "Raplamaa"),
  Ee_84("EE-84", "urn:iso:std:iso:3166:-2", "Viljandimaa"),
  Ee_37("EE-37", "urn:iso:std:iso:3166:-2", "Harjumaa"),
  Ee_44("EE-44", "urn:iso:std:iso:3166:-2", "Ida-Virumaa"),
  Ee_57("EE-57", "urn:iso:std:iso:3166:-2", "Läänemaa"),
  Ee_59("EE-59", "urn:iso:std:iso:3166:-2", "Lääne-Virumaa"),
  Ee_67("EE-67", "urn:iso:std:iso:3166:-2", "Pärnumaa"),
  Ee_74("EE-74", "urn:iso:std:iso:3166:-2", "Saaremaa"),
  Ee_82("EE-82", "urn:iso:std:iso:3166:-2", "Valgamaa"),
  Ee_86("EE-86", "urn:iso:std:iso:3166:-2", "Võrumaa"),
  Ee_65("EE-65", "urn:iso:std:iso:3166:-2", "Põlvamaa"),
  Ee_39("EE-39", "urn:iso:std:iso:3166:-2", "Hiiumaa"),
  Eg_Ast("EG-AST", "urn:iso:std:iso:3166:-2", "Asyūţ"),
  Eg_Bns("EG-BNS", "urn:iso:std:iso:3166:-2", "Banī Suwayf"),
  Eg_C("EG-C", "urn:iso:std:iso:3166:-2", "Al Qāhirah"),
  Eg_Fym("EG-FYM", "urn:iso:std:iso:3166:-2", "Al Fayyūm"),
  Eg_Pts("EG-PTS", "urn:iso:std:iso:3166:-2", "Būr Sa‘īd"),
  Eg_Dt("EG-DT", "urn:iso:std:iso:3166:-2", "Dumyāţ"),
  Eg_Gz("EG-GZ", "urn:iso:std:iso:3166:-2", "Al Jīzah"),
  Eg_Is("EG-IS", "urn:iso:std:iso:3166:-2", "Al Ismā'īlīyah"),
  Eg_Shg("EG-SHG", "urn:iso:std:iso:3166:-2", "Sūhāj"),
  Eg_Ba("EG-BA", "urn:iso:std:iso:3166:-2", "Al Baḩr al Aḩmar"),
  Eg_Kb("EG-KB", "urn:iso:std:iso:3166:-2", "Al Qalyūbīyah"),
  Eg_Shr("EG-SHR", "urn:iso:std:iso:3166:-2", "Ash Sharqīyah"),
  Eg_Dk("EG-DK", "urn:iso:std:iso:3166:-2", "Ad Daqahlīyah"),
  Eg_Lx("EG-LX", "urn:iso:std:iso:3166:-2", "Al Uqşur"),
  Eg_Sin("EG-SIN", "urn:iso:std:iso:3166:-2", "Shamāl Sīnā'"),
  Eg_Wad("EG-WAD", "urn:iso:std:iso:3166:-2", "Al Wādī al Jadīd"),
  Eg_Gh("EG-GH", "urn:iso:std:iso:3166:-2", "Al Gharbīyah"),
  Eg_Kn("EG-KN", "urn:iso:std:iso:3166:-2", "Qinā"),
  Eg_Mnf("EG-MNF", "urn:iso:std:iso:3166:-2", "Al Minūfīyah"),
  Eg_Suz("EG-SUZ", "urn:iso:std:iso:3166:-2", "As Suways"),
  Eg_Bh("EG-BH", "urn:iso:std:iso:3166:-2", "Al Buḩayrah"),
  Eg_Mt("EG-MT", "urn:iso:std:iso:3166:-2", "Maţrūḩ"),
  Eg_Alx("EG-ALX", "urn:iso:std:iso:3166:-2", "Al Iskandarīyah"),
  Eg_Asn("EG-ASN", "urn:iso:std:iso:3166:-2", "Aswān"),
  Eg_Js("EG-JS", "urn:iso:std:iso:3166:-2", "Janūb Sīnā'"),
  Eg_Kfs("EG-KFS", "urn:iso:std:iso:3166:-2", "Kafr ash Shaykh"),
  Eg_Mn("EG-MN", "urn:iso:std:iso:3166:-2", "Al Minyā"),
  Er_Gb("ER-GB", "urn:iso:std:iso:3166:-2", "Gash-Barka"),
  Er_Ma("ER-MA", "urn:iso:std:iso:3166:-2", "Al Awsaţ"),
  Er_Sk("ER-SK", "urn:iso:std:iso:3166:-2", "Semienawi K’eyyĭḥ Baḥri"),
  Er_Dk("ER-DK", "urn:iso:std:iso:3166:-2", "Janūbī al Baḩrī al Aḩmar"),
  Er_Du("ER-DU", "urn:iso:std:iso:3166:-2", "Debub"),
  Er_An("ER-AN", "urn:iso:std:iso:3166:-2", "‘Anseba"),
  Es_Cb("ES-CB", "urn:iso:std:iso:3166:-2", "Cantabria"),
  Es_Mc("ES-MC", "urn:iso:std:iso:3166:-2", "Murcia, Región de"),
  Es_Ar("ES-AR", "urn:iso:std:iso:3166:-2", "Aragón"),
  Es_As("ES-AS", "urn:iso:std:iso:3166:-2", "Asturias, Principado de"),
  Es_Ce("ES-CE", "urn:iso:std:iso:3166:-2", "Ceuta"),
  Es_Ga("ES-GA", "urn:iso:std:iso:3166:-2", "Galicia [Galicia]"),
  Es_Ri("ES-RI", "urn:iso:std:iso:3166:-2", "La Rioja"),
  Es_Vc("ES-VC", "urn:iso:std:iso:3166:-2", "Valenciana, Comunitat*"),
  Es_Ct("ES-CT", "urn:iso:std:iso:3166:-2", "Catalunya [Cataluña]"),
  Es_Ib("ES-IB", "urn:iso:std:iso:3166:-2", "Illes Balears [Islas Baleares]"),
  Es_Cm("ES-CM", "urn:iso:std:iso:3166:-2", "Castilla-La Mancha"),
  Es_Ex("ES-EX", "urn:iso:std:iso:3166:-2", "Extremadura"),
  Es_Md("ES-MD", "urn:iso:std:iso:3166:-2", "Madrid, Comunidad de"),
  Es_Ml("ES-ML", "urn:iso:std:iso:3166:-2", "Melilla"),
  Es_Cl("ES-CL", "urn:iso:std:iso:3166:-2", "Castilla y León"),
  Es_Cn("ES-CN", "urn:iso:std:iso:3166:-2", "Canarias"),
  Es_Nc("ES-NC", "urn:iso:std:iso:3166:-2", "Nafarroako Foru Komunitatea*"),
  Es_An("ES-AN", "urn:iso:std:iso:3166:-2", "Andalucía"),
  Es_Pv("ES-PV", "urn:iso:std:iso:3166:-2", "Euskal Herria"),
  Et_Be("ET-BE", "urn:iso:std:iso:3166:-2", "Bīnshangul Gumuz"),
  Et_Ha("ET-HA", "urn:iso:std:iso:3166:-2", "Harari People"),
  Et_So("ET-SO", "urn:iso:std:iso:3166:-2", "Sumalē"),
  Et_Dd("ET-DD", "urn:iso:std:iso:3166:-2", "Dire Dawa"),
  Et_Ga("ET-GA", "urn:iso:std:iso:3166:-2", "Gambēla Hizboch"),
  Et_Am("ET-AM", "urn:iso:std:iso:3166:-2", "Amara"),
  Et_Aa("ET-AA", "urn:iso:std:iso:3166:-2", "Ādīs Ābeba"),
  Et_Af("ET-AF", "urn:iso:std:iso:3166:-2", "Afar"),
  Et_Or("ET-OR", "urn:iso:std:iso:3166:-2", "Oromia"),
  Et_Ti("ET-TI", "urn:iso:std:iso:3166:-2", "Tigrai"),
  Et_Sn("ET-SN", "urn:iso:std:iso:3166:-2", "YeDebub Bihēroch Bihēreseboch na Hizboch"),
  Fi_06("FI-06", "urn:iso:std:iso:3166:-2", "Egentliga Tavastland"),
  Fi_08("FI-08", "urn:iso:std:iso:3166:-2", "Mellersta Finland"),
  Fi_13("FI-13", "urn:iso:std:iso:3166:-2", "Pohjois-Karjala"),
  Fi_18("FI-18", "urn:iso:std:iso:3166:-2", "Nyland"),
  Fi_01("FI-01", "urn:iso:std:iso:3166:-2", "Ahvenanmaan maakunta"),
  Fi_15("FI-15", "urn:iso:std:iso:3166:-2", "Norra Savolax"),
  Fi_14("FI-14", "urn:iso:std:iso:3166:-2", "Norra Österbotten"),
  Fi_04("FI-04", "urn:iso:std:iso:3166:-2", "Etelä-Savo"),
  Fi_07("FI-07", "urn:iso:std:iso:3166:-2", "Mellersta Österbotten"),
  Fi_09("FI-09", "urn:iso:std:iso:3166:-2", "Kymmenedalen"),
  Fi_11("FI-11", "urn:iso:std:iso:3166:-2", "Pirkanmaa"),
  Fi_12("FI-12", "urn:iso:std:iso:3166:-2", "Pohjanmaa"),
  Fi_19("FI-19", "urn:iso:std:iso:3166:-2", "Varsinais-Suomi"),
  Fi_17("FI-17", "urn:iso:std:iso:3166:-2", "Satakunda"),
  Fi_03("FI-03", "urn:iso:std:iso:3166:-2", "Södra Österbotten"),
  Fi_05("FI-05", "urn:iso:std:iso:3166:-2", "Kainuu"),
  Fi_10("FI-10", "urn:iso:std:iso:3166:-2", "Lappi"),
  Fi_02("FI-02", "urn:iso:std:iso:3166:-2", "Södra Karelen"),
  Fi_16("FI-16", "urn:iso:std:iso:3166:-2", "Päijänne-Tavastland"),
  Fj_R("FJ-R", "urn:iso:std:iso:3166:-2", "Rotuma"),
  Fj_W("FJ-W", "urn:iso:std:iso:3166:-2", "Western"),
  Fj_N("FJ-N", "urn:iso:std:iso:3166:-2", "Northern"),
  Fj_E("FJ-E", "urn:iso:std:iso:3166:-2", "Eastern"),
  Fj_C("FJ-C", "urn:iso:std:iso:3166:-2", "Central"),
  Fm_Trk("FM-TRK", "urn:iso:std:iso:3166:-2", "Chuuk"),
  Fm_Pni("FM-PNI", "urn:iso:std:iso:3166:-2", "Pohnpei"),
  Fm_Ksa("FM-KSA", "urn:iso:std:iso:3166:-2", "Kosrae"),
  Fm_Yap("FM-YAP", "urn:iso:std:iso:3166:-2", "Yap"),
  Fr_Cp("FR-CP", "urn:iso:std:iso:3166:-2", "Clipperton"),
  Fr_Mf(
    "FR-MF",
    "urn:iso:std:iso:3166:-2",
    "Saint-Martin (see also separate country code entry under MF)",
  ),
  Fr_Nc(
    "FR-NC",
    "urn:iso:std:iso:3166:-2",
    "Nouvelle-Calédonie (see also separate country code entry under NC)",
  ),
  Fr_Pm(
    "FR-PM",
    "urn:iso:std:iso:3166:-2",
    "Saint-Pierre-et-Miquelon (see also separate country code entry under PM)",
  ),
  Fr_Tf(
    "FR-TF",
    "urn:iso:std:iso:3166:-2",
    "Terres australes françaises (see also separate country code entry under TF)",
  ),
  Fr_Wf(
    "FR-WF",
    "urn:iso:std:iso:3166:-2",
    "Wallis-et-Futuna (see also separate country code entry under WF)",
  ),
  Fr_Ara("FR-ARA", "urn:iso:std:iso:3166:-2", "Auvergne-Rhône-Alpes"),
  Fr_Bfc("FR-BFC", "urn:iso:std:iso:3166:-2", "Bourgogne-Franche-Comté"),
  Fr_Bre("FR-BRE", "urn:iso:std:iso:3166:-2", "Bretagne"),
  Fr_Cvl("FR-CVL", "urn:iso:std:iso:3166:-2", "Centre-Val de Loire"),
  Fr_Cor("FR-COR", "urn:iso:std:iso:3166:-2", "Corse"),
  Fr_Ges("FR-GES", "urn:iso:std:iso:3166:-2", "Grand-Est"),
  Fr_Hdf("FR-HDF", "urn:iso:std:iso:3166:-2", "Hauts-de-France"),
  Fr_Idf("FR-IDF", "urn:iso:std:iso:3166:-2", "Île-de-France"),
  Fr_Nor("FR-NOR", "urn:iso:std:iso:3166:-2", "Normandie"),
  Fr_Naq("FR-NAQ", "urn:iso:std:iso:3166:-2", "Nouvelle-Aquitaine"),
  Fr_Occ("FR-OCC", "urn:iso:std:iso:3166:-2", "Occitanie"),
  Fr_Pdl("FR-PDL", "urn:iso:std:iso:3166:-2", "Pays-de-la-Loire"),
  Fr_Pac("FR-PAC", "urn:iso:std:iso:3166:-2", "Provence-Alpes-Côte-d’Azur"),
  Fr_Gua("FR-GUA", "urn:iso:std:iso:3166:-2", "Guadeloupe"),
  Fr_Lre("FR-LRE", "urn:iso:std:iso:3166:-2", "La Réunion"),
  Fr_May("FR-MAY", "urn:iso:std:iso:3166:-2", "Mayotte"),
  Fr_Gf(
    "FR-GF",
    "urn:iso:std:iso:3166:-2",
    "Guyane (française) (see also separate country code entry under GF)",
  ),
  Fr_Mq(
    "FR-MQ",
    "urn:iso:std:iso:3166:-2",
    "Martinique (see also separate country code entry under MQ)",
  ),
  Fr_Bl(
    "FR-BL",
    "urn:iso:std:iso:3166:-2",
    "Saint-Barthélemy (see also separate country code entry under BL)",
  ),
  Fr_Pf(
    "FR-PF",
    "urn:iso:std:iso:3166:-2",
    "Polynésie française (see also separate country code entry under PF)",
  ),
  Ga_1("GA-1", "urn:iso:std:iso:3166:-2", "Estuaire"),
  Ga_6("GA-6", "urn:iso:std:iso:3166:-2", "Ogooué-Ivindo"),
  Ga_7("GA-7", "urn:iso:std:iso:3166:-2", "Ogooué-Lolo"),
  Ga_8("GA-8", "urn:iso:std:iso:3166:-2", "Ogooué-Maritime"),
  Ga_2("GA-2", "urn:iso:std:iso:3166:-2", "Haut-Ogooué"),
  Ga_4("GA-4", "urn:iso:std:iso:3166:-2", "Ngounié"),
  Ga_9("GA-9", "urn:iso:std:iso:3166:-2", "Woleu-Ntem"),
  Ga_3("GA-3", "urn:iso:std:iso:3166:-2", "Moyen-Ogooué"),
  Ga_5("GA-5", "urn:iso:std:iso:3166:-2", "Nyanga"),
  Gb_Gbn("GB-GBN", "urn:iso:std:iso:3166:-2", "Great Britain"),
  Gb_Sct("GB-SCT", "urn:iso:std:iso:3166:-2", "Scotland"),
  Gb_Eaw("GB-EAW", "urn:iso:std:iso:3166:-2", "England and Wales"),
  Gb_Eng("GB-ENG", "urn:iso:std:iso:3166:-2", "England"),
  Gb_Wls("GB-WLS", "urn:iso:std:iso:3166:-2", "Wales [Cymru GB-CYM]"),
  Gb_Nir("GB-NIR", "urn:iso:std:iso:3166:-2", "Northern Ireland"),
  Gb_Ukm("GB-UKM", "urn:iso:std:iso:3166:-2", "United Kingdom"),
  Gd_10("GD-10", "urn:iso:std:iso:3166:-2", "Southern Grenadine Islands"),
  Gd_02("GD-02", "urn:iso:std:iso:3166:-2", "Saint David"),
  Gd_05("GD-05", "urn:iso:std:iso:3166:-2", "Saint Mark"),
  Gd_01("GD-01", "urn:iso:std:iso:3166:-2", "Saint Andrew"),
  Gd_03("GD-03", "urn:iso:std:iso:3166:-2", "Saint George"),
  Gd_06("GD-06", "urn:iso:std:iso:3166:-2", "Saint Patrick"),
  Gd_04("GD-04", "urn:iso:std:iso:3166:-2", "Saint John"),
  Ge_Sk("GE-SK", "urn:iso:std:iso:3166:-2", "Shida Kartli"),
  Ge_Im("GE-IM", "urn:iso:std:iso:3166:-2", "Imereti"),
  Ge_Sj("GE-SJ", "urn:iso:std:iso:3166:-2", "Samtskhe-Javakheti"),
  Ge_Gu("GE-GU", "urn:iso:std:iso:3166:-2", "Guria"),
  Ge_Rl("GE-RL", "urn:iso:std:iso:3166:-2", "Rach'a-Lechkhumi-Kvemo Svaneti"),
  Ge_Tb("GE-TB", "urn:iso:std:iso:3166:-2", "Tbilisi"),
  Ge_Ka("GE-KA", "urn:iso:std:iso:3166:-2", "K'akheti"),
  Ge_Kk("GE-KK", "urn:iso:std:iso:3166:-2", "Kvemo Kartli"),
  Ge_Ab("GE-AB", "urn:iso:std:iso:3166:-2", "Abkhazia"),
  Ge_Aj("GE-AJ", "urn:iso:std:iso:3166:-2", "Ajaria"),
  Ge_Mm("GE-MM", "urn:iso:std:iso:3166:-2", "Mtskheta-Mtianeti"),
  Ge_Sz("GE-SZ", "urn:iso:std:iso:3166:-2", "Samegrelo-Zemo Svaneti"),
  Gh_Ep("GH-EP", "urn:iso:std:iso:3166:-2", "Eastern"),
  Gh_Cp("GH-CP", "urn:iso:std:iso:3166:-2", "Central"),
  Gh_Np("GH-NP", "urn:iso:std:iso:3166:-2", "Northern"),
  Gh_Ba("GH-BA", "urn:iso:std:iso:3166:-2", "Brong-Ahafo"),
  Gh_Tv("GH-TV", "urn:iso:std:iso:3166:-2", "Volta"),
  Gh_Uw("GH-UW", "urn:iso:std:iso:3166:-2", "Upper West"),
  Gh_Ah("GH-AH", "urn:iso:std:iso:3166:-2", "Ashanti"),
  Gh_Aa("GH-AA", "urn:iso:std:iso:3166:-2", "Greater Accra"),
  Gh_Ue("GH-UE", "urn:iso:std:iso:3166:-2", "Upper East"),
  Gh_Wp("GH-WP", "urn:iso:std:iso:3166:-2", "Western"),
  Gl_Ku("GL-KU", "urn:iso:std:iso:3166:-2", "Kommune Kujalleq"),
  Gl_Sm("GL-SM", "urn:iso:std:iso:3166:-2", "Kommuneqarfik Sermersooq"),
  Gl_Qa("GL-QA", "urn:iso:std:iso:3166:-2", "Qaasuitsup Kommunia"),
  Gl_Qe("GL-QE", "urn:iso:std:iso:3166:-2", "Qeqqata Kommunia"),
  Gm_M("GM-M", "urn:iso:std:iso:3166:-2", "Central River"),
  Gm_U("GM-U", "urn:iso:std:iso:3166:-2", "Upper River"),
  Gm_W("GM-W", "urn:iso:std:iso:3166:-2", "Western"),
  Gm_L("GM-L", "urn:iso:std:iso:3166:-2", "Lower River"),
  Gm_B("GM-B", "urn:iso:std:iso:3166:-2", "Banjul"),
  Gm_N("GM-N", "urn:iso:std:iso:3166:-2", "North Bank"),
  Gn_M("GN-M", "urn:iso:std:iso:3166:-2", "Mamou"),
  Gn_C("GN-C", "urn:iso:std:iso:3166:-2", "Conakry"),
  Gn_K("GN-K", "urn:iso:std:iso:3166:-2", "Kankan"),
  Gn_L("GN-L", "urn:iso:std:iso:3166:-2", "Labé"),
  Gn_B("GN-B", "urn:iso:std:iso:3166:-2", "Boké"),
  Gn_F("GN-F", "urn:iso:std:iso:3166:-2", "Faranah"),
  Gn_D("GN-D", "urn:iso:std:iso:3166:-2", "Kindia"),
  Gn_N("GN-N", "urn:iso:std:iso:3166:-2", "Nzérékoré"),
  Gq_I("GQ-I", "urn:iso:std:iso:3166:-2", "Région Insulaire"),
  Gq_C("GQ-C", "urn:iso:std:iso:3166:-2", "Región Continental"),
  Gr_H("GR-H", "urn:iso:std:iso:3166:-2", "Stereá Elláda"),
  Gr_A("GR-A", "urn:iso:std:iso:3166:-2", "Anatolikí Makedonía kai Thráki"),
  Gr_B("GR-B", "urn:iso:std:iso:3166:-2", "Kentrikí Makedonía"),
  Gr_F("GR-F", "urn:iso:std:iso:3166:-2", "Ionía Nísia"),
  Gr_69("GR-69", "urn:iso:std:iso:3166:-2", "Ágion Óros"),
  Gr_E("GR-E", "urn:iso:std:iso:3166:-2", "Thessalía"),
  Gr_K("GR-K", "urn:iso:std:iso:3166:-2", "Voreío Aigaío"),
  Gr_I("GR-I", "urn:iso:std:iso:3166:-2", "Attikí"),
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
        "AD-03" -> Ad_03
        "AD-07" -> Ad_07
        "AD-04" -> Ad_04
        "AD-05" -> Ad_05
        "AD-02" -> Ad_02
        "AD-06" -> Ad_06
        "AD-08" -> Ad_08
        "AE-RK" -> Ae_Rk
        "AE-SH" -> Ae_Sh
        "AE-FU" -> Ae_Fu
        "AE-DU" -> Ae_Du
        "AE-AZ" -> Ae_Az
        "AE-UQ" -> Ae_Uq
        "AE-AJ" -> Ae_Aj
        "AF-BAM" -> Af_Bam
        "AF-KAB" -> Af_Kab
        "AF-KAP" -> Af_Kap
        "AF-KHO" -> Af_Kho
        "AF-KNR" -> Af_Knr
        "AF-KAN" -> Af_Kan
        "AF-LOG" -> Af_Log
        "AF-PIA" -> Af_Pia
        "AF-SAM" -> Af_Sam
        "AF-URU" -> Af_Uru
        "AF-BDS" -> Af_Bds
        "AF-FYB" -> Af_Fyb
        "AF-JOW" -> Af_Jow
        "AF-KDZ" -> Af_Kdz
        "AF-LAG" -> Af_Lag
        "AF-NIM" -> Af_Nim
        "AF-BGL" -> Af_Bgl
        "AF-FRA" -> Af_Fra
        "AF-HEL" -> Af_Hel
        "AF-PKA" -> Af_Pka
        "AF-SAR" -> Af_Sar
        "AF-BDG" -> Af_Bdg
        "AF-GHA" -> Af_Gha
        "AF-PAN" -> Af_Pan
        "AF-TAK" -> Af_Tak
        "AF-WAR" -> Af_War
        "AF-BAL" -> Af_Bal
        "AF-GHO" -> Af_Gho
        "AF-DAY" -> Af_Day
        "AF-HER" -> Af_Her
        "AF-NAN" -> Af_Nan
        "AF-NUR" -> Af_Nur
        "AF-PAR" -> Af_Par
        "AF-ZAB" -> Af_Zab
        "AG-03" -> Ag_03
        "AG-06" -> Ag_06
        "AG-10" -> Ag_10
        "AG-07" -> Ag_07
        "AG-08" -> Ag_08
        "AG-05" -> Ag_05
        "AG-04" -> Ag_04
        "AG-11" -> Ag_11
        "AL-11" -> Al_11
        "AL-12" -> Al_12
        "AL-03" -> Al_03
        "AL-09" -> Al_09
        "AL-01" -> Al_01
        "AL-02" -> Al_02
        "AL-08" -> Al_08
        "AL-10" -> Al_10
        "AL-05" -> Al_05
        "AL-06" -> Al_06
        "AL-07" -> Al_07
        "AL-04" -> Al_04
        "AM-AG" -> Am_Ag
        "AM-AV" -> Am_Av
        "AM-KT" -> Am_Kt
        "AM-GR" -> Am_Gr
        "AM-SH" -> Am_Sh
        "AM-SU" -> Am_Su
        "AM-TV" -> Am_Tv
        "AM-LO" -> Am_Lo
        "AM-ER" -> Am_Er
        "AM-VD" -> Am_Vd
        "AM-AR" -> Am_Ar
        "AO-CAB" -> Ao_Cab
        "AO-CCU" -> Ao_Ccu
        "AO-ZAI" -> Ao_Zai
        "AO-LNO" -> Ao_Lno
        "AO-LSU" -> Ao_Lsu
        "AO-MOX" -> Ao_Mox
        "AO-NAM" -> Ao_Nam
        "AO-UIG" -> Ao_Uig
        "AO-CNO" -> Ao_Cno
        "AO-HUI" -> Ao_Hui
        "AO-LUA" -> Ao_Lua
        "AO-MAL" -> Ao_Mal
        "AO-BGO" -> Ao_Bgo
        "AO-BGU" -> Ao_Bgu
        "AO-CNN" -> Ao_Cnn
        "AO-CUS" -> Ao_Cus
        "AO-HUA" -> Ao_Hua
        "AO-BIE" -> Ao_Bie
        "AR-N" -> Ar_N
        "AR-S" -> Ar_S
        "AR-Z" -> Ar_Z
        "AR-A" -> Ar_A
        "AR-C" -> Ar_C
        "AR-F" -> Ar_F
        "AR-B" -> Ar_B
        "AR-G" -> Ar_G
        "AR-H" -> Ar_H
        "AR-P" -> Ar_P
        "AR-X" -> Ar_X
        "AR-J" -> Ar_J
        "AR-T" -> Ar_T
        "AR-E" -> Ar_E
        "AR-K" -> Ar_K
        "AR-V" -> Ar_V
        "AR-W" -> Ar_W
        "AR-U" -> Ar_U
        "AR-D" -> Ar_D
        "AR-L" -> Ar_L
        "AR-M" -> Ar_M
        "AR-Q" -> Ar_Q
        "AR-R" -> Ar_R
        "AR-Y" -> Ar_Y
        "AT-3" -> At_3
        "AT-4" -> At_4
        "AT-5" -> At_5
        "AT-8" -> At_8
        "AT-1" -> At_1
        "AT-7" -> At_7
        "AT-2" -> At_2
        "AT-6" -> At_6
        "AT-9" -> At_9
        "AU-NT" -> Au_Nt
        "AU-QLD" -> Au_Qld
        "AU-TAS" -> Au_Tas
        "AU-ACT" -> Au_Act
        "AU-NSW" -> Au_Nsw
        "AU-SA" -> Au_Sa
        "AU-WA" -> Au_Wa
        "AU-VIC" -> Au_Vic
        "AZ-ABS" -> Az_Abs
        "AZ-BA" -> Az_Ba
        "AZ-BAL" -> Az_Bal
        "AZ-BAR" -> Az_Bar
        "AZ-GOY" -> Az_Goy
        "AZ-MAS" -> Az_Mas
        "AZ-SKR" -> Az_Skr
        "AZ-SR" -> Az_Sr
        "AZ-XA" -> Az_Xa
        "AZ-XIZ" -> Az_Xiz
        "AZ-AGC" -> Az_Agc
        "AZ-AGU" -> Az_Agu
        "AZ-BIL" -> Az_Bil
        "AZ-GA" -> Az_Ga
        "AZ-QAB" -> Az_Qab
        "AZ-SMX" -> Az_Smx
        "AZ-XAC" -> Az_Xac
        "AZ-YAR" -> Az_Yar
        "AZ-ZAN" -> Az_Zan
        "AZ-AGA" -> Az_Aga
        "AZ-FUZ" -> Az_Fuz
        "AZ-GAD" -> Az_Gad
        "AZ-LAC" -> Az_Lac
        "AZ-QAX" -> Az_Qax
        "AZ-AGM" -> Az_Agm
        "AZ-DAS" -> Az_Das
        "AZ-GYG" -> Az_Gyg
        "AZ-LA" -> Az_La
        "AZ-LAN" -> Az_Lan
        "AZ-OGU" -> Az_Ogu
        "AZ-QBA" -> Az_Qba
        "AZ-QUS" -> Az_Qus
        "AZ-SAB" -> Az_Sab
        "AZ-CAB" -> Az_Cab
        "AZ-KUR" -> Az_Kur
        "AZ-SAL" -> Az_Sal
        "AZ-SBN" -> Az_Sbn
        "AZ-SM" -> Az_Sm
        "AZ-UCA" -> Az_Uca
        "AZ-XCI" -> Az_Xci
        "AZ-YEV" -> Az_Yev
        "AZ-AGS" -> Az_Ags
        "AZ-AST" -> Az_Ast
        "AZ-BEY" -> Az_Bey
        "AZ-HAC" -> Az_Hac
        "AZ-IMI" -> Az_Imi
        "AZ-ISM" -> Az_Ism
        "AZ-LER" -> Az_Ler
        "AZ-MI" -> Az_Mi
        "AZ-NEF" -> Az_Nef
        "AZ-NX" -> Az_Nx
        "AZ-QAZ" -> Az_Qaz
        "AZ-SAK" -> Az_Sak
        "AZ-SAT" -> Az_Sat
        "AZ-TAR" -> Az_Tar
        "AZ-XVD" -> Az_Xvd
        "AZ-CAL" -> Az_Cal
        "AZ-KAL" -> Az_Kal
        "AZ-QOB" -> Az_Qob
        "AZ-SIY" -> Az_Siy
        "AZ-SUS" -> Az_Sus
        "AZ-ZAQ" -> Az_Zaq
        "AZ-ZAR" -> Az_Zar
        "AZ-GOR" -> Az_Gor
        "AZ-NA" -> Az_Na
        "AZ-QBI" -> Az_Qbi
        "AZ-SA" -> Az_Sa
        "AZ-SMI" -> Az_Smi
        "AZ-TOV" -> Az_Tov
        "AZ-YE" -> Az_Ye
        "BA-BRC" -> Ba_Brc
        "BA-BIH" -> Ba_Bih
        "BA-SRP" -> Ba_Srp
        "BB-03" -> Bb_03
        "BB-05" -> Bb_05
        "BB-02" -> Bb_02
        "BB-10" -> Bb_10
        "BB-11" -> Bb_11
        "BB-08" -> Bb_08
        "BB-04" -> Bb_04
        "BB-09" -> Bb_09
        "BB-01" -> Bb_01
        "BB-06" -> Bb_06
        "BB-07" -> Bb_07
        "BD-B" -> Bd_B
        "BD-H" -> Bd_H
        "BD-A" -> Bd_A
        "BD-C" -> Bd_C
        "BD-D" -> Bd_D
        "BD-E" -> Bd_E
        "BD-F" -> Bd_F
        "BD-G" -> Bd_G
        "BE-WAL" -> Be_Wal
        "BE-BRU" -> Be_Bru
        "BE-VLG" -> Be_Vlg
        "BF-05" -> Bf_05
        "BF-01" -> Bf_01
        "BF-10" -> Bf_10
        "BF-02" -> Bf_02
        "BF-03" -> Bf_03
        "BF-04" -> Bf_04
        "BF-06" -> Bf_06
        "BF-07" -> Bf_07
        "BF-08" -> Bf_08
        "BF-09" -> Bf_09
        "BF-11" -> Bf_11
        "BF-12" -> Bf_12
        "BF-13" -> Bf_13
        "BG-04" -> Bg_04
        "BG-09" -> Bg_09
        "BG-15" -> Bg_15
        "BG-16" -> Bg_16
        "BG-28" -> Bg_28
        "BG-13" -> Bg_13
        "BG-18" -> Bg_18
        "BG-21" -> Bg_21
        "BG-22" -> Bg_22
        "BG-27" -> Bg_27
        "BG-02" -> Bg_02
        "BG-14" -> Bg_14
        "BG-19" -> Bg_19
        "BG-25" -> Bg_25
        "BG-03" -> Bg_03
        "BG-24" -> Bg_24
        "BG-01" -> Bg_01
        "BG-10" -> Bg_10
        "BG-12" -> Bg_12
        "BG-20" -> Bg_20
        "BG-23" -> Bg_23
        "BG-11" -> Bg_11
        "BG-17" -> Bg_17
        "BG-05" -> Bg_05
        "BG-06" -> Bg_06
        "BG-07" -> Bg_07
        "BG-08" -> Bg_08
        "BG-26" -> Bg_26
        "BH-14" -> Bh_14
        "BH-13" -> Bh_13
        "BH-15" -> Bh_15
        "BH-17" -> Bh_17
        "BI-BM" -> Bi_Bm
        "BI-KR" -> Bi_Kr
        "BI-MY" -> Bi_My
        "BI-KI" -> Bi_Ki
        "BI-BR" -> Bi_Br
        "BI-CI" -> Bi_Ci
        "BI-GI" -> Bi_Gi
        "BI-MA" -> Bi_Ma
        "BI-MU" -> Bi_Mu
        "BI-NG" -> Bi_Ng
        "BI-RY" -> Bi_Ry
        "BI-KY" -> Bi_Ky
        "BI-MW" -> Bi_Mw
        "BI-CA" -> Bi_Ca
        "BI-BL" -> Bi_Bl
        "BI-RT" -> Bi_Rt
        "BI-RM" -> Bi_Rm
        "BI-BB" -> Bi_Bb
        "BJ-AK" -> Bj_Ak
        "BJ-CO" -> Bj_Co
        "BJ-BO" -> Bj_Bo
        "BJ-OU" -> Bj_Ou
        "BJ-LI" -> Bj_Li
        "BJ-AQ" -> Bj_Aq
        "BJ-MO" -> Bj_Mo
        "BJ-AL" -> Bj_Al
        "BJ-DO" -> Bj_Do
        "BJ-KO" -> Bj_Ko
        "BJ-PL" -> Bj_Pl
        "BJ-ZO" -> Bj_Zo
        "BN-BM" -> Bn_Bm
        "BN-BE" -> Bn_Be
        "BN-TE" -> Bn_Te
        "BN-TU" -> Bn_Tu
        "BO-C" -> Bo_C
        "BO-L" -> Bo_L
        "BO-B" -> Bo_B
        "BO-O" -> Bo_O
        "BO-S" -> Bo_S
        "BO-P" -> Bo_P
        "BO-T" -> Bo_T
        "BO-H" -> Bo_H
        "BO-N" -> Bo_N
        "BQ-BO" -> Bq_Bo
        "BQ-SA" -> Bq_Sa
        "BQ-SE" -> Bq_Se
        "BR-AC" -> Br_Ac
        "BR-AM" -> Br_Am
        "BR-CE" -> Br_Ce
        "BR-RR" -> Br_Rr
        "BR-GO" -> Br_Go
        "BR-MG" -> Br_Mg
        "BR-ES" -> Br_Es
        "BR-AP" -> Br_Ap
        "BR-BA" -> Br_Ba
        "BR-MS" -> Br_Ms
        "BR-PR" -> Br_Pr
        "BR-RN" -> Br_Rn
        "BR-MT" -> Br_Mt
        "BR-PB" -> Br_Pb
        "BR-PE" -> Br_Pe
        "BR-RJ" -> Br_Rj
        "BR-RO" -> Br_Ro
        "BR-SC" -> Br_Sc
        "BR-SP" -> Br_Sp
        "BR-AL" -> Br_Al
        "BR-DF" -> Br_Df
        "BR-MA" -> Br_Ma
        "BR-PA" -> Br_Pa
        "BR-PI" -> Br_Pi
        "BR-RS" -> Br_Rs
        "BR-SE" -> Br_Se
        "BR-TO" -> Br_To
        "BS-CO" -> Bs_Co
        "BS-EG" -> Bs_Eg
        "BS-HI" -> Bs_Hi
        "BS-MI" -> Bs_Mi
        "BS-SS" -> Bs_Ss
        "BS-SW" -> Bs_Sw
        "BS-AK" -> Bs_Ak
        "BS-LI" -> Bs_Li
        "BS-BY" -> Bs_By
        "BS-FP" -> Bs_Fp
        "BS-NS" -> Bs_Ns
        "BS-RC" -> Bs_Rc
        "BS-SO" -> Bs_So
        "BS-CE" -> Bs_Ce
        "BS-CI" -> Bs_Ci
        "BS-CS" -> Bs_Cs
        "BS-EX" -> Bs_Ex
        "BS-IN" -> Bs_In
        "BS-MC" -> Bs_Mc
        "BS-SA" -> Bs_Sa
        "BS-GC" -> Bs_Gc
        "BS-MG" -> Bs_Mg
        "BS-WG" -> Bs_Wg
        "BS-BI" -> Bs_Bi
        "BS-BP" -> Bs_Bp
        "BS-NE" -> Bs_Ne
        "BS-NO" -> Bs_No
        "BS-SE" -> Bs_Se
        "BS-CK" -> Bs_Ck
        "BS-HT" -> Bs_Ht
        "BS-RI" -> Bs_Ri
        "BT-42" -> Bt_42
        "BT-45" -> Bt_45
        "BT-12" -> Bt_12
        "BT-23" -> Bt_23
        "BT-24" -> Bt_24
        "BT-21" -> Bt_21
        "BT-33" -> Bt_33
        "BT-34" -> Bt_34
        "BT-31" -> Bt_31
        "BT-14" -> Bt_14
        "BT-15" -> Bt_15
        "BT-44" -> Bt_44
        "BT-TY" -> Bt_Ty
        "BT-13" -> Bt_13
        "BT-41" -> Bt_41
        "BT-GA" -> Bt_Ga
        "BT-22" -> Bt_22
        "BT-32" -> Bt_32
        "BT-43" -> Bt_43
        "BT-11" -> Bt_11
        "BW-KL" -> Bw_Kl
        "BW-GH" -> Bw_Gh
        "BW-NW" -> Bw_Nw
        "BW-SO" -> Bw_So
        "BW-KW" -> Bw_Kw
        "BW-CH" -> Bw_Ch
        "BW-LO" -> Bw_Lo
        "BW-SP" -> Bw_Sp
        "BW-JW" -> Bw_Jw
        "BW-ST" -> Bw_St
        "BW-FR" -> Bw_Fr
        "BW-GA" -> Bw_Ga
        "BW-KG" -> Bw_Kg
        "BW-CE" -> Bw_Ce
        "BW-SE" -> Bw_Se
        "BW-NE" -> Bw_Ne
        "BY-VI" -> By_Vi
        "BY-BR" -> By_Br
        "BY-HM" -> By_Hm
        "BY-HO" -> By_Ho
        "BY-HR" -> By_Hr
        "BY-MI" -> By_Mi
        "BY-MA" -> By_Ma
        "BZ-OW" -> Bz_Ow
        "BZ-CZL" -> Bz_Czl
        "BZ-SC" -> Bz_Sc
        "BZ-TOL" -> Bz_Tol
        "BZ-BZ" -> Bz_Bz
        "BZ-CY" -> Bz_Cy
        "CA-BC" -> Ca_Bc
        "CA-MB" -> Ca_Mb
        "CA-NB" -> Ca_Nb
        "CA-SK" -> Ca_Sk
        "CA-AB" -> Ca_Ab
        "CA-ON" -> Ca_On
        "CA-YT" -> Ca_Yt
        "CA-NT" -> Ca_Nt
        "CA-NU" -> Ca_Nu
        "CA-NL" -> Ca_Nl
        "CA-PE" -> Ca_Pe
        "CA-NS" -> Ca_Ns
        "CA-QC" -> Ca_Qc
        "CD-EQ" -> Cd_Eq
        "CD-BC" -> Cd_Bc
        "CD-SK" -> Cd_Sk
        "CD-NK" -> Cd_Nk
        "CD-KE" -> Cd_Ke
        "CD-KN" -> Cd_Kn
        "CD-BU" -> Cd_Bu
        "CD-HK" -> Cd_Hk
        "CD-HL" -> Cd_Hl
        "CD-HU" -> Cd_Hu
        "CD-IT" -> Cd_It
        "CD-KS" -> Cd_Ks
        "CD-KC" -> Cd_Kc
        "CD-KG" -> Cd_Kg
        "CD-KL" -> Cd_Kl
        "CD-LO" -> Cd_Lo
        "CD-LU" -> Cd_Lu
        "CD-MN" -> Cd_Mn
        "CD-MO" -> Cd_Mo
        "CD-NU" -> Cd_Nu
        "CD-SA" -> Cd_Sa
        "CD-SU" -> Cd_Su
        "CD-TA" -> Cd_Ta
        "CD-TO" -> Cd_To
        "CD-TU" -> Cd_Tu
        "CD-MA" -> Cd_Ma
        "CF-HM" -> Cf_Hm
        "CF-HS" -> Cf_Hs
        "CF-LB" -> Cf_Lb
        "CF-AC" -> Cf_Ac
        "CF-KB" -> Cf_Kb
        "CF-BB" -> Cf_Bb
        "CF-MP" -> Cf_Mp
        "CF-HK" -> Cf_Hk
        "CF-KG" -> Cf_Kg
        "CF-MB" -> Cf_Mb
        "CF-NM" -> Cf_Nm
        "CF-SE" -> Cf_Se
        "CF-VK" -> Cf_Vk
        "CF-BGF" -> Cf_Bgf
        "CF-OP" -> Cf_Op
        "CF-UK" -> Cf_Uk
        "CF-BK" -> Cf_Bk
        "CG-9" -> Cg_9
        "CG-15" -> Cg_15
        "CG-5" -> Cg_5
        "CG-11" -> Cg_11
        "CG-BZV" -> Cg_Bzv
        "CG-16" -> Cg_16
        "CG-12" -> Cg_12
        "CG-13" -> Cg_13
        "CG-7" -> Cg_7
        "CG-14" -> Cg_14
        "CG-2" -> Cg_2
        "CG-8" -> Cg_8
        "CH-JU" -> Ch_Ju
        "CH-LU" -> Ch_Lu
        "CH-SO" -> Ch_So
        "CH-TG" -> Ch_Tg
        "CH-BS" -> Ch_Bs
        "CH-SZ" -> Ch_Sz
        "CH-ZG" -> Ch_Zg
        "CH-AG" -> Ch_Ag
        "CH-BE" -> Ch_Be
        "CH-FR" -> Ch_Fr
        "CH-NE" -> Ch_Ne
        "CH-OW" -> Ch_Ow
        "CH-TI" -> Ch_Ti
        "CH-VD" -> Ch_Vd
        "CH-AR" -> Ch_Ar
        "CH-GE" -> Ch_Ge
        "CH-GL" -> Ch_Gl
        "CH-SG" -> Ch_Sg
        "CH-GR" -> Ch_Gr
        "CH-NW" -> Ch_Nw
        "CH-SH" -> Ch_Sh
        "CH-ZH" -> Ch_Zh
        "CH-AI" -> Ch_Ai
        "CH-VS" -> Ch_Vs
        "CH-BL" -> Ch_Bl
        "CH-UR" -> Ch_Ur
        "CI-AB" -> Ci_Ab
        "CI-YM" -> Ci_Ym
        "CI-BS" -> Ci_Bs
        "CI-CM" -> Ci_Cm
        "CI-DN" -> Ci_Dn
        "CI-GD" -> Ci_Gd
        "CI-LC" -> Ci_Lc
        "CI-LG" -> Ci_Lg
        "CI-MG" -> Ci_Mg
        "CI-SM" -> Ci_Sm
        "CI-SV" -> Ci_Sv
        "CI-VB" -> Ci_Vb
        "CI-WR" -> Ci_Wr
        "CI-ZZ" -> Ci_Zz
        "CL-AN" -> Cl_An
        "CL-RM" -> Cl_Rm
        "CL-TA" -> Cl_Ta
        "CL-BI" -> Cl_Bi
        "CL-AP" -> Cl_Ap
        "CL-AT" -> Cl_At
        "CL-LL" -> Cl_Ll
        "CL-LR" -> Cl_Lr
        "CL-ML" -> Cl_Ml
        "CL-AR" -> Cl_Ar
        "CL-LI" -> Cl_Li
        "CL-AI" -> Cl_Ai
        "CL-VS" -> Cl_Vs
        "CL-CO" -> Cl_Co
        "CL-MA" -> Cl_Ma
        "CM-NW" -> Cm_Nw
        "CM-OU" -> Cm_Ou
        "CM-AD" -> Cm_Ad
        "CM-LT" -> Cm_Lt
        "CM-NO" -> Cm_No
        "CM-CE" -> Cm_Ce
        "CM-EN" -> Cm_En
        "CM-ES" -> Cm_Es
        "CM-SU" -> Cm_Su
        "CM-SW" -> Cm_Sw
        "CN-NM" -> Cn_Nm
        "CN-GX" -> Cn_Gx
        "CN-XZ" -> Cn_Xz
        "CN-NX" -> Cn_Nx
        "CN-XJ" -> Cn_Xj
        "CN-BJ" -> Cn_Bj
        "CN-TJ" -> Cn_Tj
        "CN-SH" -> Cn_Sh
        "CN-CQ" -> Cn_Cq
        "CN-HE" -> Cn_He
        "CN-SX" -> Cn_Sx
        "CN-LN" -> Cn_Ln
        "CN-JL" -> Cn_Jl
        "CN-HL" -> Cn_Hl
        "CN-ZJ" -> Cn_Zj
        "CN-AH" -> Cn_Ah
        "CN-FJ" -> Cn_Fj
        "CN-JX" -> Cn_Jx
        "CN-SD" -> Cn_Sd
        "CN-HA" -> Cn_Ha
        "CN-HB" -> Cn_Hb
        "CN-HN" -> Cn_Hn
        "CN-GD" -> Cn_Gd
        "CN-HI" -> Cn_Hi
        "CN-SC" -> Cn_Sc
        "CN-GZ" -> Cn_Gz
        "CN-YN" -> Cn_Yn
        "CN-SN" -> Cn_Sn
        "CN-GS" -> Cn_Gs
        "CN-QH" -> Cn_Qh
        "CN-TW" -> Cn_Tw
        "CN-HK" -> Cn_Hk
        "CN-MO" -> Cn_Mo
        "CN-JS" -> Cn_Js
        "CO-BOL" -> Co_Bol
        "CO-MAG" -> Co_Mag
        "CO-MET" -> Co_Met
        "CO-PUT" -> Co_Put
        "CO-VID" -> Co_Vid
        "CO-AMA" -> Co_Ama
        "CO-CAL" -> Co_Cal
        "CO-CAU" -> Co_Cau
        "CO-CES" -> Co_Ces
        "CO-DC" -> Co_Dc
        "CO-LAG" -> Co_Lag
        "CO-ARA" -> Co_Ara
        "CO-NSA" -> Co_Nsa
        "CO-TOL" -> Co_Tol
        "CO-VAC" -> Co_Vac
        "CO-GUV" -> Co_Guv
        "CO-HUI" -> Co_Hui
        "CO-SUC" -> Co_Suc
        "CO-CAS" -> Co_Cas
        "CO-CHO" -> Co_Cho
        "CO-GUA" -> Co_Gua
        "CO-QUI" -> Co_Qui
        "CO-RIS" -> Co_Ris
        "CO-SAN" -> Co_San
        "CO-VAU" -> Co_Vau
        "CO-ANT" -> Co_Ant
        "CO-ATL" -> Co_Atl
        "CO-COR" -> Co_Cor
        "CO-SAP" -> Co_Sap
        "CO-BOY" -> Co_Boy
        "CO-CAQ" -> Co_Caq
        "CO-CUN" -> Co_Cun
        "CO-NAR" -> Co_Nar
        "CR-H" -> Cr_H
        "CR-L" -> Cr_L
        "CR-G" -> Cr_G
        "CR-P" -> Cr_P
        "CR-A" -> Cr_A
        "CR-C" -> Cr_C
        "CR-SJ" -> Cr_Sj
        "CU-03" -> Cu_03
        "CU-07" -> Cu_07
        "CU-12" -> Cu_12
        "CU-05" -> Cu_05
        "CU-11" -> Cu_11
        "CU-08" -> Cu_08
        "CU-09" -> Cu_09
        "CU-10" -> Cu_10
        "CU-13" -> Cu_13
        "CU-15" -> Cu_15
        "CU-16" -> Cu_16
        "CU-01" -> Cu_01
        "CU-14" -> Cu_14
        "CU-99" -> Cu_99
        "CU-04" -> Cu_04
        "CU-06" -> Cu_06
        "CV-B" -> Cv_B
        "CV-S" -> Cv_S
        "CY-03" -> Cy_03
        "CY-06" -> Cy_06
        "CY-01" -> Cy_01
        "CY-04" -> Cy_04
        "CY-05" -> Cy_05
        "CY-02" -> Cy_02
        "CZ-42" -> Cz_42
        "CZ-63" -> Cz_63
        "CZ-72" -> Cz_72
        "CZ-31" -> Cz_31
        "CZ-64" -> Cz_64
        "CZ-41" -> Cz_41
        "CZ-52" -> Cz_52
        "CZ-51" -> Cz_51
        "CZ-80" -> Cz_80
        "CZ-71" -> Cz_71
        "CZ-53" -> Cz_53
        "CZ-32" -> Cz_32
        "CZ-20" -> Cz_20
        "CZ-10" -> Cz_10
        "DE-BW" -> De_Bw
        "DE-MV" -> De_Mv
        "DE-NW" -> De_Nw
        "DE-SL" -> De_Sl
        "DE-TH" -> De_Th
        "DE-ST" -> De_St
        "DE-HH" -> De_Hh
        "DE-BB" -> De_Bb
        "DE-BE" -> De_Be
        "DE-BY" -> De_By
        "DE-HB" -> De_Hb
        "DE-HE" -> De_He
        "DE-NI" -> De_Ni
        "DE-SH" -> De_Sh
        "DE-RP" -> De_Rp
        "DE-SN" -> De_Sn
        "DJ-OB" -> Dj_Ob
        "DJ-AR" -> Dj_Ar
        "DJ-DI" -> Dj_Di
        "DJ-DJ" -> Dj_Dj
        "DJ-AS" -> Dj_As
        "DJ-TA" -> Dj_Ta
        "DK-82" -> Dk_82
        "DK-85" -> Dk_85
        "DK-81" -> Dk_81
        "DK-84" -> Dk_84
        "DK-83" -> Dk_83
        "DM-06" -> Dm_06
        "DM-08" -> Dm_08
        "DM-09" -> Dm_09
        "DM-03" -> Dm_03
        "DM-02" -> Dm_02
        "DM-11" -> Dm_11
        "DM-04" -> Dm_04
        "DM-10" -> Dm_10
        "DM-05" -> Dm_05
        "DM-07" -> Dm_07
        "DO-33" -> Do_33
        "DO-34" -> Do_34
        "DO-35" -> Do_35
        "DO-36" -> Do_36
        "DO-37" -> Do_37
        "DO-38" -> Do_38
        "DO-39" -> Do_39
        "DO-40" -> Do_40
        "DO-41" -> Do_41
        "DO-42" -> Do_42
        "DZ-06" -> Dz_06
        "DZ-11" -> Dz_11
        "DZ-13" -> Dz_13
        "DZ-27" -> Dz_27
        "DZ-40" -> Dz_40
        "DZ-03" -> Dz_03
        "DZ-09" -> Dz_09
        "DZ-14" -> Dz_14
        "DZ-15" -> Dz_15
        "DZ-19" -> Dz_19
        "DZ-20" -> Dz_20
        "DZ-35" -> Dz_35
        "DZ-41" -> Dz_41
        "DZ-42" -> Dz_42
        "DZ-44" -> Dz_44
        "DZ-02" -> Dz_02
        "DZ-04" -> Dz_04
        "DZ-05" -> Dz_05
        "DZ-23" -> Dz_23
        "DZ-39" -> Dz_39
        "DZ-01" -> Dz_01
        "DZ-08" -> Dz_08
        "DZ-16" -> Dz_16
        "DZ-28" -> Dz_28
        "DZ-31" -> Dz_31
        "DZ-07" -> Dz_07
        "DZ-24" -> Dz_24
        "DZ-33" -> Dz_33
        "DZ-36" -> Dz_36
        "DZ-38" -> Dz_38
        "DZ-45" -> Dz_45
        "DZ-10" -> Dz_10
        "DZ-21" -> Dz_21
        "DZ-25" -> Dz_25
        "DZ-32" -> Dz_32
        "DZ-43" -> Dz_43
        "DZ-46" -> Dz_46
        "DZ-48" -> Dz_48
        "DZ-17" -> Dz_17
        "DZ-18" -> Dz_18
        "DZ-22" -> Dz_22
        "DZ-30" -> Dz_30
        "DZ-47" -> Dz_47
        "DZ-12" -> Dz_12
        "DZ-26" -> Dz_26
        "DZ-29" -> Dz_29
        "DZ-34" -> Dz_34
        "DZ-37" -> Dz_37
        "EC-E" -> Ec_E
        "EC-G" -> Ec_G
        "EC-X" -> Ec_X
        "EC-Y" -> Ec_Y
        "EC-A" -> Ec_A
        "EC-D" -> Ec_D
        "EC-L" -> Ec_L
        "EC-O" -> Ec_O
        "EC-SE" -> Ec_Se
        "EC-Z" -> Ec_Z
        "EC-H" -> Ec_H
        "EC-SD" -> Ec_Sd
        "EC-I" -> Ec_I
        "EC-M" -> Ec_M
        "EC-P" -> Ec_P
        "EC-W" -> Ec_W
        "EC-C" -> Ec_C
        "EC-F" -> Ec_F
        "EC-S" -> Ec_S
        "EC-U" -> Ec_U
        "EC-N" -> Ec_N
        "EC-T" -> Ec_T
        "EC-B" -> Ec_B
        "EC-R" -> Ec_R
        "EE-78" -> Ee_78
        "EE-49" -> Ee_49
        "EE-51" -> Ee_51
        "EE-70" -> Ee_70
        "EE-84" -> Ee_84
        "EE-37" -> Ee_37
        "EE-44" -> Ee_44
        "EE-57" -> Ee_57
        "EE-59" -> Ee_59
        "EE-67" -> Ee_67
        "EE-74" -> Ee_74
        "EE-82" -> Ee_82
        "EE-86" -> Ee_86
        "EE-65" -> Ee_65
        "EE-39" -> Ee_39
        "EG-AST" -> Eg_Ast
        "EG-BNS" -> Eg_Bns
        "EG-C" -> Eg_C
        "EG-FYM" -> Eg_Fym
        "EG-PTS" -> Eg_Pts
        "EG-DT" -> Eg_Dt
        "EG-GZ" -> Eg_Gz
        "EG-IS" -> Eg_Is
        "EG-SHG" -> Eg_Shg
        "EG-BA" -> Eg_Ba
        "EG-KB" -> Eg_Kb
        "EG-SHR" -> Eg_Shr
        "EG-DK" -> Eg_Dk
        "EG-LX" -> Eg_Lx
        "EG-SIN" -> Eg_Sin
        "EG-WAD" -> Eg_Wad
        "EG-GH" -> Eg_Gh
        "EG-KN" -> Eg_Kn
        "EG-MNF" -> Eg_Mnf
        "EG-SUZ" -> Eg_Suz
        "EG-BH" -> Eg_Bh
        "EG-MT" -> Eg_Mt
        "EG-ALX" -> Eg_Alx
        "EG-ASN" -> Eg_Asn
        "EG-JS" -> Eg_Js
        "EG-KFS" -> Eg_Kfs
        "EG-MN" -> Eg_Mn
        "ER-GB" -> Er_Gb
        "ER-MA" -> Er_Ma
        "ER-SK" -> Er_Sk
        "ER-DK" -> Er_Dk
        "ER-DU" -> Er_Du
        "ER-AN" -> Er_An
        "ES-CB" -> Es_Cb
        "ES-MC" -> Es_Mc
        "ES-AR" -> Es_Ar
        "ES-AS" -> Es_As
        "ES-CE" -> Es_Ce
        "ES-GA" -> Es_Ga
        "ES-RI" -> Es_Ri
        "ES-VC" -> Es_Vc
        "ES-CT" -> Es_Ct
        "ES-IB" -> Es_Ib
        "ES-CM" -> Es_Cm
        "ES-EX" -> Es_Ex
        "ES-MD" -> Es_Md
        "ES-ML" -> Es_Ml
        "ES-CL" -> Es_Cl
        "ES-CN" -> Es_Cn
        "ES-NC" -> Es_Nc
        "ES-AN" -> Es_An
        "ES-PV" -> Es_Pv
        "ET-BE" -> Et_Be
        "ET-HA" -> Et_Ha
        "ET-SO" -> Et_So
        "ET-DD" -> Et_Dd
        "ET-GA" -> Et_Ga
        "ET-AM" -> Et_Am
        "ET-AA" -> Et_Aa
        "ET-AF" -> Et_Af
        "ET-OR" -> Et_Or
        "ET-TI" -> Et_Ti
        "ET-SN" -> Et_Sn
        "FI-06" -> Fi_06
        "FI-08" -> Fi_08
        "FI-13" -> Fi_13
        "FI-18" -> Fi_18
        "FI-01" -> Fi_01
        "FI-15" -> Fi_15
        "FI-14" -> Fi_14
        "FI-04" -> Fi_04
        "FI-07" -> Fi_07
        "FI-09" -> Fi_09
        "FI-11" -> Fi_11
        "FI-12" -> Fi_12
        "FI-19" -> Fi_19
        "FI-17" -> Fi_17
        "FI-03" -> Fi_03
        "FI-05" -> Fi_05
        "FI-10" -> Fi_10
        "FI-02" -> Fi_02
        "FI-16" -> Fi_16
        "FJ-R" -> Fj_R
        "FJ-W" -> Fj_W
        "FJ-N" -> Fj_N
        "FJ-E" -> Fj_E
        "FJ-C" -> Fj_C
        "FM-TRK" -> Fm_Trk
        "FM-PNI" -> Fm_Pni
        "FM-KSA" -> Fm_Ksa
        "FM-YAP" -> Fm_Yap
        "FR-CP" -> Fr_Cp
        "FR-MF" -> Fr_Mf
        "FR-NC" -> Fr_Nc
        "FR-PM" -> Fr_Pm
        "FR-TF" -> Fr_Tf
        "FR-WF" -> Fr_Wf
        "FR-ARA" -> Fr_Ara
        "FR-BFC" -> Fr_Bfc
        "FR-BRE" -> Fr_Bre
        "FR-CVL" -> Fr_Cvl
        "FR-COR" -> Fr_Cor
        "FR-GES" -> Fr_Ges
        "FR-HDF" -> Fr_Hdf
        "FR-IDF" -> Fr_Idf
        "FR-NOR" -> Fr_Nor
        "FR-NAQ" -> Fr_Naq
        "FR-OCC" -> Fr_Occ
        "FR-PDL" -> Fr_Pdl
        "FR-PAC" -> Fr_Pac
        "FR-GUA" -> Fr_Gua
        "FR-LRE" -> Fr_Lre
        "FR-MAY" -> Fr_May
        "FR-GF" -> Fr_Gf
        "FR-MQ" -> Fr_Mq
        "FR-BL" -> Fr_Bl
        "FR-PF" -> Fr_Pf
        "GA-1" -> Ga_1
        "GA-6" -> Ga_6
        "GA-7" -> Ga_7
        "GA-8" -> Ga_8
        "GA-2" -> Ga_2
        "GA-4" -> Ga_4
        "GA-9" -> Ga_9
        "GA-3" -> Ga_3
        "GA-5" -> Ga_5
        "GB-GBN" -> Gb_Gbn
        "GB-SCT" -> Gb_Sct
        "GB-EAW" -> Gb_Eaw
        "GB-ENG" -> Gb_Eng
        "GB-WLS" -> Gb_Wls
        "GB-NIR" -> Gb_Nir
        "GB-UKM" -> Gb_Ukm
        "GD-10" -> Gd_10
        "GD-02" -> Gd_02
        "GD-05" -> Gd_05
        "GD-01" -> Gd_01
        "GD-03" -> Gd_03
        "GD-06" -> Gd_06
        "GD-04" -> Gd_04
        "GE-SK" -> Ge_Sk
        "GE-IM" -> Ge_Im
        "GE-SJ" -> Ge_Sj
        "GE-GU" -> Ge_Gu
        "GE-RL" -> Ge_Rl
        "GE-TB" -> Ge_Tb
        "GE-KA" -> Ge_Ka
        "GE-KK" -> Ge_Kk
        "GE-AB" -> Ge_Ab
        "GE-AJ" -> Ge_Aj
        "GE-MM" -> Ge_Mm
        "GE-SZ" -> Ge_Sz
        "GH-EP" -> Gh_Ep
        "GH-CP" -> Gh_Cp
        "GH-NP" -> Gh_Np
        "GH-BA" -> Gh_Ba
        "GH-TV" -> Gh_Tv
        "GH-UW" -> Gh_Uw
        "GH-AH" -> Gh_Ah
        "GH-AA" -> Gh_Aa
        "GH-UE" -> Gh_Ue
        "GH-WP" -> Gh_Wp
        "GL-KU" -> Gl_Ku
        "GL-SM" -> Gl_Sm
        "GL-QA" -> Gl_Qa
        "GL-QE" -> Gl_Qe
        "GM-M" -> Gm_M
        "GM-U" -> Gm_U
        "GM-W" -> Gm_W
        "GM-L" -> Gm_L
        "GM-B" -> Gm_B
        "GM-N" -> Gm_N
        "GN-M" -> Gn_M
        "GN-C" -> Gn_C
        "GN-K" -> Gn_K
        "GN-L" -> Gn_L
        "GN-B" -> Gn_B
        "GN-F" -> Gn_F
        "GN-D" -> Gn_D
        "GN-N" -> Gn_N
        "GQ-I" -> Gq_I
        "GQ-C" -> Gq_C
        "GR-H" -> Gr_H
        "GR-A" -> Gr_A
        "GR-B" -> Gr_B
        "GR-F" -> Gr_F
        "GR-69" -> Gr_69
        "GR-E" -> Gr_E
        "GR-K" -> Gr_K
        "GR-I" -> Gr_I
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

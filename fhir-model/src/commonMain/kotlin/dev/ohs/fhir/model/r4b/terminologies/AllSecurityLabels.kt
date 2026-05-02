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

/** A single value set for all security labels defined by FHIR. */
public enum class AllSecurityLabels(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  U("U", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "unrestricted"),
  L("L", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Low"),
  M("M", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Moderate"),
  N("N", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "None"),
  R("R", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "restricted"),
  V("V", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "very restricted"),
  _InformationSensitivityPolicy(
    "_InformationSensitivityPolicy",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "InformationSensitivityPolicy",
  ),
  _ActInformationSensitivityPolicy(
    "_ActInformationSensitivityPolicy",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "ActInformationSensitivityPolicy",
  ),
  Eth(
    "ETH",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "substance abuse information sensitivity",
  ),
  Gdis(
    "GDIS",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "genetic disease information sensitivity",
  ),
  Hiv(
    "HIV",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "HIV/AIDS information sensitivity",
  ),
  Mst(
    "MST",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "military sexual trauma information sensitivity",
  ),
  Pregnant(
    "PREGNANT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "pregnancy information sensitivity",
  ),
  Sca(
    "SCA",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "sickle cell anemia information sensitivity",
  ),
  Sdv(
    "SDV",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "sexual assault, abuse, or domestic violence information sensitivity",
  ),
  Sex(
    "SEX",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "sexuality and reproductive health information sensitivity",
  ),
  Spi(
    "SPI",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "specially protected information sensitivity",
  ),
  Bh(
    "BH",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "behavioral health information sensitivity",
  ),
  Cogn(
    "COGN",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "cognitive disability information sensitivity",
  ),
  Dvd(
    "DVD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "developmental disability information sensitivity",
  ),
  Emotdis(
    "EMOTDIS",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "emotional disturbance information sensitivity",
  ),
  Mh(
    "MH",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "mental health information sensitivity",
  ),
  Psy(
    "PSY",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "psychiatry disorder information sensitivity",
  ),
  Psythpn(
    "PSYTHPN",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "psychotherapy note information sensitivity",
  ),
  Sud(
    "SUD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "substance use disorder information sensitivity",
  ),
  Ethud(
    "ETHUD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "alcohol use disorder information sensitivity",
  ),
  Opioidud(
    "OPIOIDUD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "opioid use disorder information sensitivity",
  ),
  Std(
    "STD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "sexually transmitted disease information sensitivity",
  ),
  Tboo("TBOO", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "taboo"),
  Vio(
    "VIO",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "violence information sensitivity",
  ),
  Ids("IDS", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "Identifier Sensitivity"),
  Sickle("SICKLE", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "sickle cell"),
  _EntitySensitivityPolicyType(
    "_EntitySensitivityPolicyType",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "EntityInformationSensitivityPolicy",
  ),
  Demo(
    "DEMO",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "all demographic information sensitivity",
  ),
  Dob(
    "DOB",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "date of birth information sensitivity",
  ),
  Gender(
    "GENDER",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "gender and sexual orientation information sensitivity",
  ),
  Livarg(
    "LIVARG",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "living arrangement information sensitivity",
  ),
  Marst(
    "MARST",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "marital status information sensitivity",
  ),
  Patloc("PATLOC", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "patient location"),
  Race("RACE", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "race information sensitivity"),
  Rel(
    "REL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "religion information sensitivity",
  ),
  _RoleInformationSensitivityPolicy(
    "_RoleInformationSensitivityPolicy",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "RoleInformationSensitivityPolicy",
  ),
  B("B", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "business information sensitivity"),
  Empl(
    "EMPL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "employer information sensitivity",
  ),
  Locis(
    "LOCIS",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "location information sensitivity",
  ),
  Ssp("SSP", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "same sex partner"),
  Adol(
    "ADOL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "adolescent information sensitivity",
  ),
  Cel(
    "CEL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "celebrity information sensitivity",
  ),
  Vip(
    "VIP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "celebrity information sensitivity",
  ),
  Dia(
    "DIA",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "diagnosis information sensitivity",
  ),
  Drgis(
    "DRGIS",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "drug information sensitivity",
  ),
  Emp(
    "EMP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "employee information sensitivity",
  ),
  Pds(
    "PDS",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "patient default information sensitivity",
  ),
  Phy(
    "PHY",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "physician requested information sensitivity",
  ),
  Prs(
    "PRS",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "patient requested information sensitivity",
  ),
  Compt("COMPT", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "compartment"),
  Acocompt(
    "ACOCOMPT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "accountable care organization compartment",
  ),
  Cdsscompt(
    "CDSSCOMPT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "CDS system compartment",
  ),
  Ctcompt("CTCOMPT", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "care team compartment"),
  Fmcompt(
    "FMCOMPT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "financial management compartment",
  ),
  Hrcompt(
    "HRCOMPT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "human resource compartment",
  ),
  Lrcompt(
    "LRCOMPT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "legitimate relationship compartment",
  ),
  Pacompt(
    "PACOMPT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "patient administration compartment",
  ),
  Rescompt(
    "RESCOMPT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "research project compartment",
  ),
  Rmgtcompt(
    "RMGTCOMPT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "records management compartment",
  ),
  _Secaltintobv(
    "_SECALTINTOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "alteration integrity",
  ),
  Abstred("ABSTRED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "abstracted"),
  Aggred("AGGRED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "aggregated"),
  Anonyed("ANONYED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "anonymized"),
  Mapped("MAPPED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "mapped"),
  Masked("MASKED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "masked"),
  Pseuded("PSEUDED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "pseudonymized"),
  Redacted("REDACTED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "redacted"),
  Subsetted("SUBSETTED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "subsetted"),
  Syntac(
    "SYNTAC",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "syntactic transform",
  ),
  Trslt("TRSLT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "translated"),
  Versioned("VERSIONED", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "versioned"),
  _Secdatintobv(
    "_SECDATINTOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "data integrity",
  ),
  Crytohash(
    "CRYTOHASH",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "cryptographic hash function",
  ),
  Digsig(
    "DIGSIG",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "digital signature",
  ),
  _Secintconobv(
    "_SECINTCONOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "integrity confidence",
  ),
  Hreliable(
    "HRELIABLE",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "highly reliable",
  ),
  Reliable("RELIABLE", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "reliable"),
  Uncertrel(
    "UNCERTREL",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "uncertain reliability",
  ),
  Unreliable(
    "UNRELIABLE",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "unreliable",
  ),
  _Secintprvobv(
    "_SECINTPRVOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "provenance",
  ),
  _Secintprvabobv(
    "_SECINTPRVABOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "provenance asserted by",
  ),
  Clinast(
    "CLINAST",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "clinician asserted",
  ),
  Devast("DEVAST", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "device asserted"),
  Hcpast(
    "HCPAST",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "healthcare professional asserted",
  ),
  Pacqast(
    "PACQAST",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "patient acquaintance asserted",
  ),
  Patast("PATAST", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "patient asserted"),
  Payast("PAYAST", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "payer asserted"),
  Proast(
    "PROAST",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "professional asserted",
  ),
  Sdmast(
    "SDMAST",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "substitute decision maker asserted",
  ),
  _Secintprvrbobv(
    "_SECINTPRVRBOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "provenance reported by",
  ),
  Clinrpt(
    "CLINRPT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "clinician reported",
  ),
  Devrpt("DEVRPT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "device reported"),
  Hcprpt(
    "HCPRPT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "healthcare professional reported",
  ),
  Pacqrpt(
    "PACQRPT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "patient acquaintance reported",
  ),
  Patrpt("PATRPT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "patient reported"),
  Payrpt("PAYRPT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "payer reported"),
  Prorpt(
    "PRORPT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "professional reported",
  ),
  Sdmrpt(
    "SDMRPT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "substitute decision maker reported",
  ),
  _Secintstobv(
    "_SECINTSTOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "integrity status",
  ),
  SecurityPolicy(
    "SecurityPolicy",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "security policy",
  ),
  Authpol("AUTHPOL", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "authorization policy"),
  Accessconscheme(
    "ACCESSCONSCHEME",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "access control scheme",
  ),
  Delepol("DELEPOL", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "delegation policy"),
  ObligationPolicy(
    "ObligationPolicy",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "obligation policy",
  ),
  Anony("ANONY", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "anonymize"),
  Aod("AOD", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "accounting of disclosure"),
  Audit("AUDIT", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "audit"),
  Audtr("AUDTR", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "audit trail"),
  Cplypol("CPLYPOL", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "comply with policy"),
  Cplycc(
    "CPLYCC",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "comply with confidentiality code",
  ),
  Cplycd(
    "CPLYCD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "comply with consent directive",
  ),
  Cplycui(
    "CPLYCUI",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "comply with controlled unclassified information policy",
  ),
  Cplyjpp(
    "CPLYJPP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "comply with jurisdictional privacy policy",
  ),
  Cplyjsp(
    "CPLYJSP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "comply with jurisdictional security policy",
  ),
  Cplyopp(
    "CPLYOPP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "comply with organizational privacy policy",
  ),
  Cplyosp(
    "CPLYOSP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "comply with organizational security policy",
  ),
  Declassifylabel(
    "DECLASSIFYLABEL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "declassify security label",
  ),
  Deid("DEID", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "deidentify"),
  Delau("DELAU", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "delete after use"),
  Downgrdlabel(
    "DOWNGRDLABEL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "downgrade security label",
  ),
  Drivlabel(
    "DRIVLABEL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "derive security label",
  ),
  Encrypt("ENCRYPT", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "encrypt"),
  Encryptr("ENCRYPTR", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "encrypt at rest"),
  Encryptt("ENCRYPTT", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "encrypt in transit"),
  Encryptu("ENCRYPTU", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "encrypt in use"),
  Huaprv("HUAPRV", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "human approval"),
  Label("LABEL", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "assign security label"),
  Mask("MASK", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "mask"),
  Minec("MINEC", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "minimum necessary"),
  Persistlabel(
    "PERSISTLABEL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "persist security label",
  ),
  Privmark("PRIVMARK", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "privacy mark"),
  CUIMark("CUIMark", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "CUI Mark"),
  Pseud("PSEUD", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "pseudonymize"),
  Redact("REDACT", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "redact"),
  Upgrdlabel(
    "UPGRDLABEL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "upgrade security label",
  ),
  PrivacyMark("PrivacyMark", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "privacy mark"),
  ControlledUnclassifiedInformation(
    "ControlledUnclassifiedInformation",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "ControlledUnclassifiedInformation",
  ),
  Controlled("CONTROLLED", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "CONTROLLED"),
  Cui("CUI", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "CUI"),
  Cuihlth("CUIHLTH", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "CUI//HLTH"),
  Cuihlthp("CUIHLTHP", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "(CUI//HLTH)"),
  Cuip("CUIP", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "(CUI)"),
  Cuiprvcy("CUIPRVCY", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "CUI//PRVCY"),
  Cuiprvcyp("CUIPRVCYP", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "(CUI//PRVCY)"),
  Cuisp_Hlth("CUISP-HLTH", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "CUI//SP-HLTH"),
  Cuisp_Hlthp("CUISP-HLTHP", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "(CUI//SP-HLTH)"),
  Cuisp_Prvcy("CUISP-PRVCY", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "CUI//SP-PRVCY"),
  Cuisp_Prvcyp(
    "CUISP-PRVCYP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "(CUI//SP-PRVCY)",
  ),
  Uui("UUI", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "(U)"),
  SecurityLabelMark(
    "SecurityLabelMark",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "Security Label Mark",
  ),
  ConfidentialMark(
    "ConfidentialMark",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "confidential mark",
  ),
  COPYMark("COPYMark", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "copy of original mark"),
  DeliverToAddresseeOnlyMark(
    "DeliverToAddresseeOnlyMark",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "deliver only to addressee mark",
  ),
  RedisclosureProhibitionMark(
    "RedisclosureProhibitionMark",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "prohibition against redisclosure mark",
  ),
  RestrictedConfidentialityMark(
    "RestrictedConfidentialityMark",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "restricted confidentiality mark",
  ),
  DRAFTMark("DRAFTMark", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "Draft Mark"),
  RefrainPolicy(
    "RefrainPolicy",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "refrain policy",
  ),
  Noauth(
    "NOAUTH",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no disclosure without subject authorization",
  ),
  Nocollect("NOCOLLECT", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "no collection"),
  Nodsclcd(
    "NODSCLCD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no disclosure without consent directive",
  ),
  Nodsclcds(
    "NODSCLCDS",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no disclosure without information subject's consent directive",
  ),
  Nointegrate("NOINTEGRATE", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "no integration"),
  Nolist(
    "NOLIST",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no unlisted entity disclosure",
  ),
  Nomou("NOMOU", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "no disclosure without MOU"),
  Noorgpol(
    "NOORGPOL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no disclosure without organizational authorization",
  ),
  Nopat(
    "NOPAT",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no disclosure to patient, family or caregivers without attending provider's authorization",
  ),
  Nopersistp(
    "NOPERSISTP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no collection beyond purpose of use",
  ),
  Nordsclcd(
    "NORDSCLCD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no redisclosure without consent directive",
  ),
  Nordslcd(
    "NORDSLCD",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no redisclosure without consent directive",
  ),
  Nordsclcds(
    "NORDSCLCDS",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no redisclosure without information subject's consent directive",
  ),
  Nordsclw(
    "NORDSCLW",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no disclosure without jurisdictional authorization",
  ),
  Norelink("NORELINK", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "no relinking"),
  Noreuse(
    "NOREUSE",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no reuse beyond purpose of use",
  ),
  Novip(
    "NOVIP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no unauthorized VIP disclosure",
  ),
  Orcon(
    "ORCON",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "no disclosure without originator authorization",
  ),
  Hmarkt("HMARKT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "healthcare marketing"),
  Hoperat("HOPERAT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "healthcare operations"),
  Caremgt("CAREMGT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "care management"),
  Donat("DONAT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "donation"),
  Fraud("FRAUD", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "fraud"),
  Gov("GOV", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "government"),
  Haccred("HACCRED", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "health accreditation"),
  Hcompl("HCOMPL", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "health compliance"),
  Hdecd("HDECD", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "decedent"),
  Hdirect("HDIRECT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "directory"),
  Hdm(
    "HDM",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "healthcare delivery management",
  ),
  Hlegal("HLEGAL", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "legal"),
  Houtcoms(
    "HOUTCOMS",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "health outcome measure",
  ),
  Hprgrp(
    "HPRGRP",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "health program reporting",
  ),
  Hqualimp(
    "HQUALIMP",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "health quality improvement",
  ),
  Hsysadmin(
    "HSYSADMIN",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "health system administration",
  ),
  Labeling("LABELING", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "labeling"),
  Metamgt("METAMGT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "metadata management"),
  Memadmin(
    "MEMADMIN",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "member administration",
  ),
  Milcdm("MILCDM", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "military command"),
  Patadmin(
    "PATADMIN",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "patient administration",
  ),
  Patsfty("PATSFTY", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "patient safety"),
  Perfmsr("PERFMSR", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "performance measure"),
  Recordmgt(
    "RECORDMGT",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "records management",
  ),
  Sysdev("SYSDEV", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "system development"),
  Htest("HTEST", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "test health data"),
  Train("TRAIN", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "training"),
  Hpaymt("HPAYMT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "healthcare payment"),
  Clmattch("CLMATTCH", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "claim attachment"),
  Covauth(
    "COVAUTH",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "coverage authorization",
  ),
  Coverage(
    "COVERAGE",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "coverage under policy or program",
  ),
  Eligdtrm(
    "ELIGDTRM",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "eligibility determination",
  ),
  Eligver(
    "ELIGVER",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "eligibility verification",
  ),
  Enrollm("ENROLLM", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "enrollment"),
  Mildcrg("MILDCRG", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "military discharge"),
  Remitadv("REMITADV", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "remittance advice"),
  Hresch("HRESCH", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "healthcare research"),
  Biorch("BIORCH", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "biomedical research"),
  Clintrch(
    "CLINTRCH",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "clinical trial research",
  ),
  Clintrchnpc(
    "CLINTRCHNPC",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "clinical trial research without patient care",
  ),
  Clintrchpc(
    "CLINTRCHPC",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "clinical trial research with patient care",
  ),
  Preclintrch(
    "PRECLINTRCH",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "preclinical trial research",
  ),
  Dsrch(
    "DSRCH",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "disease specific healthcare research",
  ),
  Poarch(
    "POARCH",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "population origins or ancestry healthcare research",
  ),
  Transrch(
    "TRANSRCH",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "translational healthcare research",
  ),
  Patrqt("PATRQT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "patient requested"),
  Famrqt("FAMRQT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "family requested"),
  Pwatrny("PWATRNY", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "power of attorney"),
  Supnwk("SUPNWK", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "support network"),
  Pubhlth("PUBHLTH", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "public health"),
  Disaster("DISASTER", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "disaster"),
  Threat("THREAT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "threat"),
  Treat("TREAT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "treatment"),
  Clintrl("CLINTRL", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "clinical trial"),
  Coc("COC", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "coordination of care"),
  Etreat("ETREAT", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "Emergency Treatment"),
  Btg("BTG", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "break the glass"),
  Ertreat(
    "ERTREAT",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "emergency room treatment",
  ),
  Pophlth("POPHLTH", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "population health"),
  _ActCoverageAssessmentObservationValue(
    "_ActCoverageAssessmentObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "ActCoverageAssessmentObservationValue",
  ),
  _ActFinancialStatusObservationValue(
    "_ActFinancialStatusObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "ActFinancialStatusObservationValue",
  ),
  Asset("ASSET", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "asset"),
  Annuity("ANNUITY", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "annuity"),
  Prop("PROP", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "real property"),
  Retacct(
    "RETACCT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "retirement investment account",
  ),
  Trust("TRUST", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "trust"),
  Income("INCOME", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "income"),
  Child("CHILD", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "child support"),
  Disabl("DISABL", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "disability pay"),
  Invest(
    "INVEST",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "investment income",
  ),
  Pay("PAY", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "paid employment"),
  Retire("RETIRE", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "retirement pay"),
  Spousal(
    "SPOUSAL",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "spousal or partner support",
  ),
  Supple(
    "SUPPLE",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "income supplement",
  ),
  Tax("TAX", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "tax obligation"),
  Livexp("LIVEXP", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "living expense"),
  Cloth("CLOTH", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "clothing expense"),
  Food("FOOD", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "food expense"),
  Health("HEALTH", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "health expense"),
  House("HOUSE", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "household expense"),
  Legal("LEGAL", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "legal expense"),
  Mortg("MORTG", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "mortgage"),
  Rent("RENT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "rent"),
  Sundry("SUNDRY", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "sundry expense"),
  Trans(
    "TRANS",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "transportation expense",
  ),
  Util("UTIL", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "utility expense"),
  Elstat(
    "ELSTAT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "eligibility indicator",
  ),
  Adopt("ADOPT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "adoption document"),
  Bthcert(
    "BTHCERT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "birth certificate",
  ),
  Ccoc(
    "CCOC",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "creditable coverage document",
  ),
  Drlic("DRLIC", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "driver license"),
  Foster(
    "FOSTER",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "foster child document",
  ),
  Member(
    "MEMBER",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "program or policy member",
  ),
  Mil(
    "MIL",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "military identification",
  ),
  Mrgcert(
    "MRGCERT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "marriage certificate",
  ),
  Passport("PASSPORT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "passport"),
  Studenrl(
    "STUDENRL",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "student enrollment",
  ),
  Hlstat("HLSTAT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "health status"),
  Disable("DISABLE", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "disabled"),
  Drug("DRUG", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "drug use"),
  Ivdrg("IVDRG", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "IV drug use"),
  Pgnt("PGNT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "pregnant"),
  Livdep(
    "LIVDEP",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "living dependency",
  ),
  Reldep(
    "RELDEP",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "relative dependent",
  ),
  Spsdep("SPSDEP", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "spouse dependent"),
  Ureldep(
    "URELDEP",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "unrelated person dependent",
  ),
  Livsit("LIVSIT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "living situation"),
  Alone("ALONE", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "alone"),
  Depchd(
    "DEPCHD",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "dependent children",
  ),
  Depsps("DEPSPS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "dependent spouse"),
  Depygchd(
    "DEPYGCHD",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "dependent young children",
  ),
  Fam("FAM", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "live with family"),
  Relat("RELAT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "relative"),
  Sps("SPS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "spouse only"),
  Unrel("UNREL", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "unrelated person"),
  Soecstat(
    "SOECSTAT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "socio economic status",
  ),
  Abuse("ABUSE", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "abuse victim"),
  Hmless("HMLESS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "homeless"),
  Ilgim("ILGIM", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "illegal immigrant"),
  Incar("INCAR", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "incarcerated"),
  Prob("PROB", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "probation"),
  Refug("REFUG", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "refugee"),
  Unempl("UNEMPL", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "unemployed"),
  _AllergyTestValue(
    "_AllergyTestValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "AllergyTestValue",
  ),
  A0("A0", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "no reaction"),
  A1("A1", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "minimal reaction"),
  A2("A2", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "mild reaction"),
  A3("A3", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "moderate reaction"),
  A4("A4", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "severe reaction"),
  _CompositeMeasureScoring(
    "_CompositeMeasureScoring",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CompositeMeasureScoring",
  ),
  Allornonescr(
    "ALLORNONESCR",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "All-or-nothing Scoring",
  ),
  Linearscr(
    "LINEARSCR",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Linear Scoring",
  ),
  Opporscr(
    "OPPORSCR",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Opportunity Scoring",
  ),
  Weightscr(
    "WEIGHTSCR",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Weighted Scoring",
  ),
  _CoverageLimitObservationValue(
    "_CoverageLimitObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CoverageLimitObservationValue",
  ),
  _CoverageLevelObservationValue(
    "_CoverageLevelObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CoverageLevelObservationValue",
  ),
  Adc("ADC", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "adult child"),
  Chd("CHD", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "child"),
  Dep("DEP", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "dependent"),
  Dp("DP", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "domestic partner"),
  Ech("ECH", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "employee"),
  Fly("FLY", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "family coverage"),
  Ind("IND", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "individual"),
  _CoverageItemLimitObservationValue(
    "_CoverageItemLimitObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CoverageItemLimitObservationValue",
  ),
  _CoverageLocationLimitObservationValue(
    "_CoverageLocationLimitObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CoverageLocationLimitObservationValue",
  ),
  _CriticalityObservationValue(
    "_CriticalityObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CriticalityObservationValue",
  ),
  Crith("CRITH", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "high criticality"),
  Critl("CRITL", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "low criticality"),
  Critu(
    "CRITU",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "unable to assess criticality",
  ),
  _EmploymentStatus(
    "_EmploymentStatus",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "_EmploymentStatus",
  ),
  Employed("Employed", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Employed"),
  NotInLaborForce(
    "NotInLaborForce",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Not In Labor Force",
  ),
  Unemployed(
    "Unemployed",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Unemployed",
  ),
  _GeneticObservationValue(
    "_GeneticObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "GeneticObservationValue",
  ),
  Homozygote("Homozygote", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "HOMO"),
  _MeasurementImprovementNotation(
    "_MeasurementImprovementNotation",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Measurement Improvement Notation",
  ),
  DecrIsImp(
    "DecrIsImp",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Decreased score indicates improvement",
  ),
  IncrIsImp(
    "IncrIsImp",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Increased score indicates improvement",
  ),
  _ObservationMeasureScoring(
    "_ObservationMeasureScoring",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "ObservationMeasureScoring",
  ),
  Cohort(
    "COHORT",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "cohort measure scoring",
  ),
  Contvar(
    "CONTVAR",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "continuous variable measure scoring",
  ),
  Propor(
    "PROPOR",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "proportion measure scoring",
  ),
  Ratio(
    "RATIO",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "ratio measure scoring",
  ),
  _ObservationMeasureType(
    "_ObservationMeasureType",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "ObservationMeasureType",
  ),
  Composite(
    "COMPOSITE",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "composite measure type",
  ),
  Efficiency(
    "EFFICIENCY",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "efficiency measure type",
  ),
  Experience(
    "EXPERIENCE",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "experience measure type",
  ),
  Outcome(
    "OUTCOME",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "outcome measure type",
  ),
  Interm_Om(
    "INTERM-OM",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "intermediate clinical outcome measure",
  ),
  Pro_Pm(
    "PRO-PM",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "patient reported outcome performance measure",
  ),
  Process(
    "PROCESS",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "process measure type",
  ),
  Appropriate(
    "APPROPRIATE",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "appropriate use process measure",
  ),
  Resource(
    "RESOURCE",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "resource use measure type",
  ),
  Structure(
    "STRUCTURE",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "structure measure type",
  ),
  _ObservationPopulationInclusion(
    "_ObservationPopulationInclusion",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "ObservationPopulationInclusion",
  ),
  Denex(
    "DENEX",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "denominator exclusions",
  ),
  Denexcep(
    "DENEXCEP",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "denominator exceptions",
  ),
  Denom("DENOM", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "denominator"),
  Ip("IP", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "initial population"),
  Ipp(
    "IPP",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "initial patient population",
  ),
  Msrpopl(
    "MSRPOPL",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "measure population",
  ),
  Numer("NUMER", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "numerator"),
  Numex(
    "NUMEX",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "numerator exclusions",
  ),
  _PartialCompletionScale(
    "_PartialCompletionScale",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "PartialCompletionScale",
  ),
  G("G", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Great extent"),
  Le("LE", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Large extent"),
  Me("ME", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Medium extent"),
  Mi("MI", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Minimal extent"),
  S("S", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Some extent"),
  _SecurityObservationValue(
    "_SecurityObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "SecurityObservationValue",
  ),
  _Seccatobv(
    "_SECCATOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "security category",
  ),
  _Secclassobv(
    "_SECCLASSOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "security classification",
  ),
  _Secconobv(
    "_SECCONOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "security control",
  ),
  _Secintobv(
    "_SECINTOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "security integrity",
  ),
  Sectrstobv(
    "SECTRSTOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "security trust observation",
  ),
  Trstaccrdobv(
    "TRSTACCRDOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "trust accreditation observation",
  ),
  Trstagreobv(
    "TRSTAGREOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "trust agreement observation",
  ),
  Trstcertobv(
    "TRSTCERTOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "trust certificate observation",
  ),
  Trstfwkobv(
    "TRSTFWKOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "none supplied 5",
  ),
  Trstloaobv(
    "TRSTLOAOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "trust assurance observation",
  ),
  Loaan(
    "LOAAN",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "authentication level of assurance value",
  ),
  LOAAN1(
    "LOAAN1",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "low authentication level of assurance",
  ),
  LOAAN2(
    "LOAAN2",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "basic authentication level of assurance",
  ),
  LOAAN3(
    "LOAAN3",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "medium authentication level of assurance",
  ),
  LOAAN4(
    "LOAAN4",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "high authentication level of assurance",
  ),
  Loaap(
    "LOAAP",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "authentication process level of assurance value",
  ),
  LOAAP1(
    "LOAAP1",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "low authentication process level of assurance",
  ),
  LOAAP2(
    "LOAAP2",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "basic authentication process level of assurance",
  ),
  LOAAP3(
    "LOAAP3",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "medium authentication process level of assurance",
  ),
  LOAAP4(
    "LOAAP4",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "high authentication process level of assurance",
  ),
  Loaas(
    "LOAAS",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "assertion level of assurance value",
  ),
  LOAAS1(
    "LOAAS1",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "low assertion level of assurance",
  ),
  LOAAS2(
    "LOAAS2",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "basic assertion level of assurance",
  ),
  LOAAS3(
    "LOAAS3",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "medium assertion level of assurance",
  ),
  LOAAS4(
    "LOAAS4",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "high assertion level of assurance",
  ),
  Loacm(
    "LOACM",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "token and credential management level of assurance value)",
  ),
  LOACM1(
    "LOACM1",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "low token and credential management level of assurance",
  ),
  LOACM2(
    "LOACM2",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "basic token and credential management level of assurance",
  ),
  LOACM3(
    "LOACM3",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "medium token and credential management level of assurance",
  ),
  LOACM4(
    "LOACM4",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "high token and credential management level of assurance",
  ),
  Loaid(
    "LOAID",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "identity proofing level of assurance",
  ),
  LOAID1(
    "LOAID1",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "low identity proofing level of assurance",
  ),
  LOAID2(
    "LOAID2",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "basic identity proofing level of assurance",
  ),
  LOAID3(
    "LOAID3",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "medium identity proofing level of assurance",
  ),
  LOAID4(
    "LOAID4",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "high identity proofing level of assurance",
  ),
  Loanr(
    "LOANR",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "non-repudiation level of assurance value",
  ),
  LOANR1(
    "LOANR1",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "low non-repudiation level of assurance",
  ),
  LOANR2(
    "LOANR2",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "basic non-repudiation level of assurance",
  ),
  LOANR3(
    "LOANR3",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "medium non-repudiation level of assurance",
  ),
  LOANR4(
    "LOANR4",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "high non-repudiation level of assurance",
  ),
  Loara(
    "LOARA",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "remote access level of assurance value",
  ),
  LOARA1(
    "LOARA1",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "low remote access level of assurance",
  ),
  LOARA2(
    "LOARA2",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "basic remote access level of assurance",
  ),
  LOARA3(
    "LOARA3",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "medium remote access level of assurance",
  ),
  LOARA4(
    "LOARA4",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "high remote access level of assurance",
  ),
  Loatk(
    "LOATK",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "token level of assurance value",
  ),
  LOATK1(
    "LOATK1",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "low token level of assurance",
  ),
  LOATK2(
    "LOATK2",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "basic token level of assurance",
  ),
  LOATK3(
    "LOATK3",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "medium token level of assurance",
  ),
  LOATK4(
    "LOATK4",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "high token level of assurance",
  ),
  Trstmecobv(
    "TRSTMECOBV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "none supplied 6",
  ),
  _SeverityObservation(
    "_SeverityObservation",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "SeverityObservation",
  ),
  H("H", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "High"),
  _SubjectBodyPosition(
    "_SubjectBodyPosition",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "_SubjectBodyPosition",
  ),
  Lld("LLD", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "left lateral decubitus"),
  Prn("PRN", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "prone"),
  Rld(
    "RLD",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "right lateral decubitus",
  ),
  Sfwl("SFWL", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "Semi-Fowler's"),
  Sit("SIT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "sitting"),
  Stn("STN", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "standing"),
  Sup("SUP", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "supine"),
  Rtrd(
    "RTRD",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "reverse trendelenburg",
  ),
  Trd("TRD", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "trendelenburg"),
  _VerificationOutcomeValue(
    "_VerificationOutcomeValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "verification outcome",
  ),
  Act("ACT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "active coverage"),
  Actpend(
    "ACTPEND",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "active - pending investigation",
  ),
  Elg("ELG", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "eligible"),
  Inact("INACT", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "inactive"),
  Inpndinv(
    "INPNDINV",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "inactive - pending investigation",
  ),
  Inpndupd(
    "INPNDUPD",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "inactive - pending eligibility update",
  ),
  Nelg("NELG", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "not eligible"),
  _WorkSchedule(
    "_WorkSchedule",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "_WorkSchedule",
  ),
  Ds("DS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "daytime shift"),
  Ems("EMS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "early morning shift"),
  Es("ES", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "evening shift"),
  Ns("NS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "night shift"),
  Rswn(
    "RSWN",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "rotating shift with nights",
  ),
  Rswon(
    "RSWON",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "rotating shift without nights",
  ),
  Ss("SS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "split shift"),
  Vls("VLS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "very long shift"),
  Vs("VS", "http://terminology.hl7.org/CodeSystem/v3-ObservationValue", "variable shift"),
  _AnnotationValue(
    "_AnnotationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "AnnotationValue",
  ),
  _ECGAnnotationValue(
    "_ECGAnnotationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "ECGAnnotationValue",
  ),
  _CommonClinicalObservationValue(
    "_CommonClinicalObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "common clinical observation",
  ),
  _CommonClinicalObservationAssertionValue(
    "_CommonClinicalObservationAssertionValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CommonClinicalObservationAssertionValue",
  ),
  _CommonClinicalObservationResultValue(
    "_CommonClinicalObservationResultValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CommonClinicalObservationResultValue",
  ),
  _CoverageChemicalDependencyValue(
    "_CoverageChemicalDependencyValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CoverageChemicalDependencyValue",
  ),
  _IndividualCaseSafetyReportValueDomains(
    "_IndividualCaseSafetyReportValueDomains",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Individual Case Safety Report Value Domains",
  ),
  _CaseSeriousnessCriteria(
    "_CaseSeriousnessCriteria",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "CaseSeriousnessCriteria",
  ),
  _DeviceManufacturerEvaluationInterpretation(
    "_DeviceManufacturerEvaluationInterpretation",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "DeviceManufacturerEvaluationInterpretation",
  ),
  _DeviceManufacturerEvaluationMethod(
    "_DeviceManufacturerEvaluationMethod",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "DeviceManufacturerEvaluationMethod",
  ),
  _DeviceManufacturerEvaluationResult(
    "_DeviceManufacturerEvaluationResult",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "DeviceManufacturerEvaluationResult",
  ),
  _PertinentReactionRelatedness(
    "_PertinentReactionRelatedness",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Pertinent Reaction Relatedness",
  ),
  _ProductCharacterization(
    "_ProductCharacterization",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Product Characterization",
  ),
  _ReactionActionTaken(
    "_ReactionActionTaken",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "ReactionActionTaken",
  ),
  _SubjectReaction(
    "_SubjectReaction",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "Subject Reaction",
  ),
  _SubjectReactionEmphasis(
    "_SubjectReactionEmphasis",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "SubjectReactionEmphasis",
  ),
  _SubjectReactionOutcome(
    "_SubjectReactionOutcome",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "SubjectReactionOutcome",
  ),
  _InjuryObservationValue(
    "_InjuryObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "InjuryObservationValue",
  ),
  _IntoleranceValue(
    "_IntoleranceValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "IntoleranceValue",
  ),
  _IssueTriggerObservationValue(
    "_IssueTriggerObservationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "IssueTriggerObservationValue",
  ),
  _OtherIndicationValue(
    "_OtherIndicationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "OtherIndicationValue",
  ),
  _IndicationValue(
    "_IndicationValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "IndicationValue",
  ),
  _DiagnosisValue(
    "_DiagnosisValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "DiagnosisValue",
  ),
  _SymptomValue(
    "_SymptomValue",
    "http://terminology.hl7.org/CodeSystem/v3-ObservationValue",
    "SymptomValue",
  ),
  _ActUSPrivacyLaw(
    "_ActUSPrivacyLaw",
    "http://terminology.hl7.org/CodeSystem/v3-ActUSPrivacyLaw",
    "ActUSPrivacyLaw",
  ),
  _42CFRPart2(
    "42CFRPart2",
    "http://terminology.hl7.org/CodeSystem/v3-ActUSPrivacyLaw",
    "42 CFR Part2",
  ),
  CommonRule(
    "CommonRule",
    "http://terminology.hl7.org/CodeSystem/v3-ActUSPrivacyLaw",
    "Common Rule",
  ),
  Hipaanopp(
    "HIPAANOPP",
    "http://terminology.hl7.org/CodeSystem/v3-ActUSPrivacyLaw",
    "HIPAA notice of privacy practices",
  ),
  HIPAAPsyNotes(
    "HIPAAPsyNotes",
    "http://terminology.hl7.org/CodeSystem/v3-ActUSPrivacyLaw",
    "HIPAA psychotherapy notes",
  ),
  HIPAASelfPay(
    "HIPAASelfPay",
    "http://terminology.hl7.org/CodeSystem/v3-ActUSPrivacyLaw",
    "HIPAA self-pay",
  ),
  Title38Section7332(
    "Title38Section7332",
    "http://terminology.hl7.org/CodeSystem/v3-ActUSPrivacyLaw",
    "Title 38 Section 7332",
  ),
  Title38Part1(
    "Title38Part1",
    "http://terminology.hl7.org/CodeSystem/v3-ActUSPrivacyLaw",
    "Title 38 Section 7332",
  );

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): AllSecurityLabels =
      when (code) {
        "U" -> U
        "L" -> L
        "M" -> M
        "N" -> N
        "R" -> R
        "V" -> V
        "_InformationSensitivityPolicy" -> _InformationSensitivityPolicy
        "_ActInformationSensitivityPolicy" -> _ActInformationSensitivityPolicy
        "ETH" -> Eth
        "GDIS" -> Gdis
        "HIV" -> Hiv
        "MST" -> Mst
        "PREGNANT" -> Pregnant
        "SCA" -> Sca
        "SDV" -> Sdv
        "SEX" -> Sex
        "SPI" -> Spi
        "BH" -> Bh
        "COGN" -> Cogn
        "DVD" -> Dvd
        "EMOTDIS" -> Emotdis
        "MH" -> Mh
        "PSY" -> Psy
        "PSYTHPN" -> Psythpn
        "SUD" -> Sud
        "ETHUD" -> Ethud
        "OPIOIDUD" -> Opioidud
        "STD" -> Std
        "TBOO" -> Tboo
        "VIO" -> Vio
        "IDS" -> Ids
        "SICKLE" -> Sickle
        "_EntitySensitivityPolicyType" -> _EntitySensitivityPolicyType
        "DEMO" -> Demo
        "DOB" -> Dob
        "GENDER" -> Gender
        "LIVARG" -> Livarg
        "MARST" -> Marst
        "PATLOC" -> Patloc
        "RACE" -> Race
        "REL" -> Rel
        "_RoleInformationSensitivityPolicy" -> _RoleInformationSensitivityPolicy
        "B" -> B
        "EMPL" -> Empl
        "LOCIS" -> Locis
        "SSP" -> Ssp
        "ADOL" -> Adol
        "CEL" -> Cel
        "VIP" -> Vip
        "DIA" -> Dia
        "DRGIS" -> Drgis
        "EMP" -> Emp
        "PDS" -> Pds
        "PHY" -> Phy
        "PRS" -> Prs
        "COMPT" -> Compt
        "ACOCOMPT" -> Acocompt
        "CDSSCOMPT" -> Cdsscompt
        "CTCOMPT" -> Ctcompt
        "FMCOMPT" -> Fmcompt
        "HRCOMPT" -> Hrcompt
        "LRCOMPT" -> Lrcompt
        "PACOMPT" -> Pacompt
        "RESCOMPT" -> Rescompt
        "RMGTCOMPT" -> Rmgtcompt
        "_SECALTINTOBV" -> _Secaltintobv
        "ABSTRED" -> Abstred
        "AGGRED" -> Aggred
        "ANONYED" -> Anonyed
        "MAPPED" -> Mapped
        "MASKED" -> Masked
        "PSEUDED" -> Pseuded
        "REDACTED" -> Redacted
        "SUBSETTED" -> Subsetted
        "SYNTAC" -> Syntac
        "TRSLT" -> Trslt
        "VERSIONED" -> Versioned
        "_SECDATINTOBV" -> _Secdatintobv
        "CRYTOHASH" -> Crytohash
        "DIGSIG" -> Digsig
        "_SECINTCONOBV" -> _Secintconobv
        "HRELIABLE" -> Hreliable
        "RELIABLE" -> Reliable
        "UNCERTREL" -> Uncertrel
        "UNRELIABLE" -> Unreliable
        "_SECINTPRVOBV" -> _Secintprvobv
        "_SECINTPRVABOBV" -> _Secintprvabobv
        "CLINAST" -> Clinast
        "DEVAST" -> Devast
        "HCPAST" -> Hcpast
        "PACQAST" -> Pacqast
        "PATAST" -> Patast
        "PAYAST" -> Payast
        "PROAST" -> Proast
        "SDMAST" -> Sdmast
        "_SECINTPRVRBOBV" -> _Secintprvrbobv
        "CLINRPT" -> Clinrpt
        "DEVRPT" -> Devrpt
        "HCPRPT" -> Hcprpt
        "PACQRPT" -> Pacqrpt
        "PATRPT" -> Patrpt
        "PAYRPT" -> Payrpt
        "PRORPT" -> Prorpt
        "SDMRPT" -> Sdmrpt
        "_SECINTSTOBV" -> _Secintstobv
        "SecurityPolicy" -> SecurityPolicy
        "AUTHPOL" -> Authpol
        "ACCESSCONSCHEME" -> Accessconscheme
        "DELEPOL" -> Delepol
        "ObligationPolicy" -> ObligationPolicy
        "ANONY" -> Anony
        "AOD" -> Aod
        "AUDIT" -> Audit
        "AUDTR" -> Audtr
        "CPLYPOL" -> Cplypol
        "CPLYCC" -> Cplycc
        "CPLYCD" -> Cplycd
        "CPLYCUI" -> Cplycui
        "CPLYJPP" -> Cplyjpp
        "CPLYJSP" -> Cplyjsp
        "CPLYOPP" -> Cplyopp
        "CPLYOSP" -> Cplyosp
        "DECLASSIFYLABEL" -> Declassifylabel
        "DEID" -> Deid
        "DELAU" -> Delau
        "DOWNGRDLABEL" -> Downgrdlabel
        "DRIVLABEL" -> Drivlabel
        "ENCRYPT" -> Encrypt
        "ENCRYPTR" -> Encryptr
        "ENCRYPTT" -> Encryptt
        "ENCRYPTU" -> Encryptu
        "HUAPRV" -> Huaprv
        "LABEL" -> Label
        "MASK" -> Mask
        "MINEC" -> Minec
        "PERSISTLABEL" -> Persistlabel
        "PRIVMARK" -> Privmark
        "CUIMark" -> CUIMark
        "PSEUD" -> Pseud
        "REDACT" -> Redact
        "UPGRDLABEL" -> Upgrdlabel
        "PrivacyMark" -> PrivacyMark
        "ControlledUnclassifiedInformation" -> ControlledUnclassifiedInformation
        "CONTROLLED" -> Controlled
        "CUI" -> Cui
        "CUIHLTH" -> Cuihlth
        "CUIHLTHP" -> Cuihlthp
        "CUIP" -> Cuip
        "CUIPRVCY" -> Cuiprvcy
        "CUIPRVCYP" -> Cuiprvcyp
        "CUISP-HLTH" -> Cuisp_Hlth
        "CUISP-HLTHP" -> Cuisp_Hlthp
        "CUISP-PRVCY" -> Cuisp_Prvcy
        "CUISP-PRVCYP" -> Cuisp_Prvcyp
        "UUI" -> Uui
        "SecurityLabelMark" -> SecurityLabelMark
        "ConfidentialMark" -> ConfidentialMark
        "COPYMark" -> COPYMark
        "DeliverToAddresseeOnlyMark" -> DeliverToAddresseeOnlyMark
        "RedisclosureProhibitionMark" -> RedisclosureProhibitionMark
        "RestrictedConfidentialityMark" -> RestrictedConfidentialityMark
        "DRAFTMark" -> DRAFTMark
        "RefrainPolicy" -> RefrainPolicy
        "NOAUTH" -> Noauth
        "NOCOLLECT" -> Nocollect
        "NODSCLCD" -> Nodsclcd
        "NODSCLCDS" -> Nodsclcds
        "NOINTEGRATE" -> Nointegrate
        "NOLIST" -> Nolist
        "NOMOU" -> Nomou
        "NOORGPOL" -> Noorgpol
        "NOPAT" -> Nopat
        "NOPERSISTP" -> Nopersistp
        "NORDSCLCD" -> Nordsclcd
        "NORDSLCD" -> Nordslcd
        "NORDSCLCDS" -> Nordsclcds
        "NORDSCLW" -> Nordsclw
        "NORELINK" -> Norelink
        "NOREUSE" -> Noreuse
        "NOVIP" -> Novip
        "ORCON" -> Orcon
        "HMARKT" -> Hmarkt
        "HOPERAT" -> Hoperat
        "CAREMGT" -> Caremgt
        "DONAT" -> Donat
        "FRAUD" -> Fraud
        "GOV" -> Gov
        "HACCRED" -> Haccred
        "HCOMPL" -> Hcompl
        "HDECD" -> Hdecd
        "HDIRECT" -> Hdirect
        "HDM" -> Hdm
        "HLEGAL" -> Hlegal
        "HOUTCOMS" -> Houtcoms
        "HPRGRP" -> Hprgrp
        "HQUALIMP" -> Hqualimp
        "HSYSADMIN" -> Hsysadmin
        "LABELING" -> Labeling
        "METAMGT" -> Metamgt
        "MEMADMIN" -> Memadmin
        "MILCDM" -> Milcdm
        "PATADMIN" -> Patadmin
        "PATSFTY" -> Patsfty
        "PERFMSR" -> Perfmsr
        "RECORDMGT" -> Recordmgt
        "SYSDEV" -> Sysdev
        "HTEST" -> Htest
        "TRAIN" -> Train
        "HPAYMT" -> Hpaymt
        "CLMATTCH" -> Clmattch
        "COVAUTH" -> Covauth
        "COVERAGE" -> Coverage
        "ELIGDTRM" -> Eligdtrm
        "ELIGVER" -> Eligver
        "ENROLLM" -> Enrollm
        "MILDCRG" -> Mildcrg
        "REMITADV" -> Remitadv
        "HRESCH" -> Hresch
        "BIORCH" -> Biorch
        "CLINTRCH" -> Clintrch
        "CLINTRCHNPC" -> Clintrchnpc
        "CLINTRCHPC" -> Clintrchpc
        "PRECLINTRCH" -> Preclintrch
        "DSRCH" -> Dsrch
        "POARCH" -> Poarch
        "TRANSRCH" -> Transrch
        "PATRQT" -> Patrqt
        "FAMRQT" -> Famrqt
        "PWATRNY" -> Pwatrny
        "SUPNWK" -> Supnwk
        "PUBHLTH" -> Pubhlth
        "DISASTER" -> Disaster
        "THREAT" -> Threat
        "TREAT" -> Treat
        "CLINTRL" -> Clintrl
        "COC" -> Coc
        "ETREAT" -> Etreat
        "BTG" -> Btg
        "ERTREAT" -> Ertreat
        "POPHLTH" -> Pophlth
        "_ActCoverageAssessmentObservationValue" -> _ActCoverageAssessmentObservationValue
        "_ActFinancialStatusObservationValue" -> _ActFinancialStatusObservationValue
        "ASSET" -> Asset
        "ANNUITY" -> Annuity
        "PROP" -> Prop
        "RETACCT" -> Retacct
        "TRUST" -> Trust
        "INCOME" -> Income
        "CHILD" -> Child
        "DISABL" -> Disabl
        "INVEST" -> Invest
        "PAY" -> Pay
        "RETIRE" -> Retire
        "SPOUSAL" -> Spousal
        "SUPPLE" -> Supple
        "TAX" -> Tax
        "LIVEXP" -> Livexp
        "CLOTH" -> Cloth
        "FOOD" -> Food
        "HEALTH" -> Health
        "HOUSE" -> House
        "LEGAL" -> Legal
        "MORTG" -> Mortg
        "RENT" -> Rent
        "SUNDRY" -> Sundry
        "TRANS" -> Trans
        "UTIL" -> Util
        "ELSTAT" -> Elstat
        "ADOPT" -> Adopt
        "BTHCERT" -> Bthcert
        "CCOC" -> Ccoc
        "DRLIC" -> Drlic
        "FOSTER" -> Foster
        "MEMBER" -> Member
        "MIL" -> Mil
        "MRGCERT" -> Mrgcert
        "PASSPORT" -> Passport
        "STUDENRL" -> Studenrl
        "HLSTAT" -> Hlstat
        "DISABLE" -> Disable
        "DRUG" -> Drug
        "IVDRG" -> Ivdrg
        "PGNT" -> Pgnt
        "LIVDEP" -> Livdep
        "RELDEP" -> Reldep
        "SPSDEP" -> Spsdep
        "URELDEP" -> Ureldep
        "LIVSIT" -> Livsit
        "ALONE" -> Alone
        "DEPCHD" -> Depchd
        "DEPSPS" -> Depsps
        "DEPYGCHD" -> Depygchd
        "FAM" -> Fam
        "RELAT" -> Relat
        "SPS" -> Sps
        "UNREL" -> Unrel
        "SOECSTAT" -> Soecstat
        "ABUSE" -> Abuse
        "HMLESS" -> Hmless
        "ILGIM" -> Ilgim
        "INCAR" -> Incar
        "PROB" -> Prob
        "REFUG" -> Refug
        "UNEMPL" -> Unempl
        "_AllergyTestValue" -> _AllergyTestValue
        "A0" -> A0
        "A1" -> A1
        "A2" -> A2
        "A3" -> A3
        "A4" -> A4
        "_CompositeMeasureScoring" -> _CompositeMeasureScoring
        "ALLORNONESCR" -> Allornonescr
        "LINEARSCR" -> Linearscr
        "OPPORSCR" -> Opporscr
        "WEIGHTSCR" -> Weightscr
        "_CoverageLimitObservationValue" -> _CoverageLimitObservationValue
        "_CoverageLevelObservationValue" -> _CoverageLevelObservationValue
        "ADC" -> Adc
        "CHD" -> Chd
        "DEP" -> Dep
        "DP" -> Dp
        "ECH" -> Ech
        "FLY" -> Fly
        "IND" -> Ind
        "SSP" -> Ssp
        "_CoverageItemLimitObservationValue" -> _CoverageItemLimitObservationValue
        "_CoverageLocationLimitObservationValue" -> _CoverageLocationLimitObservationValue
        "_CriticalityObservationValue" -> _CriticalityObservationValue
        "CRITH" -> Crith
        "CRITL" -> Critl
        "CRITU" -> Critu
        "_EmploymentStatus" -> _EmploymentStatus
        "Employed" -> Employed
        "NotInLaborForce" -> NotInLaborForce
        "Unemployed" -> Unemployed
        "_GeneticObservationValue" -> _GeneticObservationValue
        "Homozygote" -> Homozygote
        "_MeasurementImprovementNotation" -> _MeasurementImprovementNotation
        "DecrIsImp" -> DecrIsImp
        "IncrIsImp" -> IncrIsImp
        "_ObservationMeasureScoring" -> _ObservationMeasureScoring
        "COHORT" -> Cohort
        "CONTVAR" -> Contvar
        "PROPOR" -> Propor
        "RATIO" -> Ratio
        "_ObservationMeasureType" -> _ObservationMeasureType
        "COMPOSITE" -> Composite
        "EFFICIENCY" -> Efficiency
        "EXPERIENCE" -> Experience
        "OUTCOME" -> Outcome
        "INTERM-OM" -> Interm_Om
        "PRO-PM" -> Pro_Pm
        "PROCESS" -> Process
        "APPROPRIATE" -> Appropriate
        "RESOURCE" -> Resource
        "STRUCTURE" -> Structure
        "_ObservationPopulationInclusion" -> _ObservationPopulationInclusion
        "DENEX" -> Denex
        "DENEXCEP" -> Denexcep
        "DENOM" -> Denom
        "IP" -> Ip
        "IPP" -> Ipp
        "MSRPOPL" -> Msrpopl
        "NUMER" -> Numer
        "NUMEX" -> Numex
        "_PartialCompletionScale" -> _PartialCompletionScale
        "G" -> G
        "LE" -> Le
        "ME" -> Me
        "MI" -> Mi
        "N" -> N
        "S" -> S
        "_SecurityObservationValue" -> _SecurityObservationValue
        "_SECCATOBV" -> _Seccatobv
        "_SECCLASSOBV" -> _Secclassobv
        "_SECCONOBV" -> _Secconobv
        "_SECINTOBV" -> _Secintobv
        "SECTRSTOBV" -> Sectrstobv
        "TRSTACCRDOBV" -> Trstaccrdobv
        "TRSTAGREOBV" -> Trstagreobv
        "TRSTCERTOBV" -> Trstcertobv
        "TRSTFWKOBV" -> Trstfwkobv
        "TRSTLOAOBV" -> Trstloaobv
        "LOAAN" -> Loaan
        "LOAAN1" -> LOAAN1
        "LOAAN2" -> LOAAN2
        "LOAAN3" -> LOAAN3
        "LOAAN4" -> LOAAN4
        "LOAAP" -> Loaap
        "LOAAP1" -> LOAAP1
        "LOAAP2" -> LOAAP2
        "LOAAP3" -> LOAAP3
        "LOAAP4" -> LOAAP4
        "LOAAS" -> Loaas
        "LOAAS1" -> LOAAS1
        "LOAAS2" -> LOAAS2
        "LOAAS3" -> LOAAS3
        "LOAAS4" -> LOAAS4
        "LOACM" -> Loacm
        "LOACM1" -> LOACM1
        "LOACM2" -> LOACM2
        "LOACM3" -> LOACM3
        "LOACM4" -> LOACM4
        "LOAID" -> Loaid
        "LOAID1" -> LOAID1
        "LOAID2" -> LOAID2
        "LOAID3" -> LOAID3
        "LOAID4" -> LOAID4
        "LOANR" -> Loanr
        "LOANR1" -> LOANR1
        "LOANR2" -> LOANR2
        "LOANR3" -> LOANR3
        "LOANR4" -> LOANR4
        "LOARA" -> Loara
        "LOARA1" -> LOARA1
        "LOARA2" -> LOARA2
        "LOARA3" -> LOARA3
        "LOARA4" -> LOARA4
        "LOATK" -> Loatk
        "LOATK1" -> LOATK1
        "LOATK2" -> LOATK2
        "LOATK3" -> LOATK3
        "LOATK4" -> LOATK4
        "TRSTMECOBV" -> Trstmecobv
        "_SeverityObservation" -> _SeverityObservation
        "H" -> H
        "L" -> L
        "M" -> M
        "_SubjectBodyPosition" -> _SubjectBodyPosition
        "LLD" -> Lld
        "PRN" -> Prn
        "RLD" -> Rld
        "SFWL" -> Sfwl
        "SIT" -> Sit
        "STN" -> Stn
        "SUP" -> Sup
        "RTRD" -> Rtrd
        "TRD" -> Trd
        "_VerificationOutcomeValue" -> _VerificationOutcomeValue
        "ACT" -> Act
        "ACTPEND" -> Actpend
        "ELG" -> Elg
        "INACT" -> Inact
        "INPNDINV" -> Inpndinv
        "INPNDUPD" -> Inpndupd
        "NELG" -> Nelg
        "_WorkSchedule" -> _WorkSchedule
        "DS" -> Ds
        "EMS" -> Ems
        "ES" -> Es
        "NS" -> Ns
        "RSWN" -> Rswn
        "RSWON" -> Rswon
        "SS" -> Ss
        "VLS" -> Vls
        "VS" -> Vs
        "_AnnotationValue" -> _AnnotationValue
        "_ECGAnnotationValue" -> _ECGAnnotationValue
        "_CommonClinicalObservationValue" -> _CommonClinicalObservationValue
        "_CommonClinicalObservationAssertionValue" -> _CommonClinicalObservationAssertionValue
        "_CommonClinicalObservationResultValue" -> _CommonClinicalObservationResultValue
        "_CoverageChemicalDependencyValue" -> _CoverageChemicalDependencyValue
        "_IndividualCaseSafetyReportValueDomains" -> _IndividualCaseSafetyReportValueDomains
        "_CaseSeriousnessCriteria" -> _CaseSeriousnessCriteria
        "_DeviceManufacturerEvaluationInterpretation" -> _DeviceManufacturerEvaluationInterpretation
        "_DeviceManufacturerEvaluationMethod" -> _DeviceManufacturerEvaluationMethod
        "_DeviceManufacturerEvaluationResult" -> _DeviceManufacturerEvaluationResult
        "_PertinentReactionRelatedness" -> _PertinentReactionRelatedness
        "_ProductCharacterization" -> _ProductCharacterization
        "_ReactionActionTaken" -> _ReactionActionTaken
        "_SubjectReaction" -> _SubjectReaction
        "_SubjectReactionEmphasis" -> _SubjectReactionEmphasis
        "_SubjectReactionOutcome" -> _SubjectReactionOutcome
        "_InjuryObservationValue" -> _InjuryObservationValue
        "_IntoleranceValue" -> _IntoleranceValue
        "_IssueTriggerObservationValue" -> _IssueTriggerObservationValue
        "_OtherIndicationValue" -> _OtherIndicationValue
        "_IndicationValue" -> _IndicationValue
        "_DiagnosisValue" -> _DiagnosisValue
        "_SymptomValue" -> _SymptomValue
        "_ActUSPrivacyLaw" -> _ActUSPrivacyLaw
        "42CFRPart2" -> _42CFRPart2
        "CommonRule" -> CommonRule
        "HIPAANOPP" -> Hipaanopp
        "HIPAAPsyNotes" -> HIPAAPsyNotes
        "HIPAASelfPay" -> HIPAASelfPay
        "Title38Section7332" -> Title38Section7332
        "Title38Part1" -> Title38Part1
        else -> throw IllegalArgumentException("Unknown code $code for enum AllSecurityLabels")
      }
  }
}

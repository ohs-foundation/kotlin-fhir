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

/** A single value set for all security labels defined by FHIR. */
public enum class AllSecurityLabels(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  U("U", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "unrestricted"),
  L("L", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "low"),
  M("M", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "moderate"),
  N("N", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "normal"),
  R("R", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "restricted"),
  V("V", "http://terminology.hl7.org/CodeSystem/v3-Confidentiality", "very restricted"),
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
  Sickle("SICKLE", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "sickle cell"),
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
  Race("RACE", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "race information sensitivity"),
  Rel(
    "REL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "religion information sensitivity",
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
  Ssp(
    "SSP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "sensitive service provider information sensitivity",
  ),
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
  Cplyjpp(
    "CPLYJPP",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "comply with jurisdictional privacy policy",
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
  Cplypol("CPLYPOL", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "comply with policy"),
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
  Pseud("PSEUD", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "pseudonymize"),
  Redact("REDACT", "http://terminology.hl7.org/CodeSystem/v3-ActCode", "redact"),
  Upgrdlabel(
    "UPGRDLABEL",
    "http://terminology.hl7.org/CodeSystem/v3-ActCode",
    "upgrade security label",
  ),
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
  PurposeOfUse(
    "PurposeOfUse",
    "http://terminology.hl7.org/CodeSystem/v3-ActReason",
    "purpose of use",
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
  Pophlth("POPHLTH", "http://terminology.hl7.org/CodeSystem/v3-ActReason", "population health");

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
        "ETH" -> Eth
        "GDIS" -> Gdis
        "HIV" -> Hiv
        "MST" -> Mst
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
        "SICKLE" -> Sickle
        "DEMO" -> Demo
        "DOB" -> Dob
        "GENDER" -> Gender
        "LIVARG" -> Livarg
        "MARST" -> Marst
        "RACE" -> Race
        "REL" -> Rel
        "B" -> B
        "EMPL" -> Empl
        "LOCIS" -> Locis
        "SSP" -> Ssp
        "ADOL" -> Adol
        "CEL" -> Cel
        "DIA" -> Dia
        "DRGIS" -> Drgis
        "EMP" -> Emp
        "PDS" -> Pds
        "PHY" -> Phy
        "PRS" -> Prs
        "COMPT" -> Compt
        "ACOCOMPT" -> Acocompt
        "CTCOMPT" -> Ctcompt
        "FMCOMPT" -> Fmcompt
        "HRCOMPT" -> Hrcompt
        "LRCOMPT" -> Lrcompt
        "PACOMPT" -> Pacompt
        "RESCOMPT" -> Rescompt
        "RMGTCOMPT" -> Rmgtcompt
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
        "CRYTOHASH" -> Crytohash
        "DIGSIG" -> Digsig
        "HRELIABLE" -> Hreliable
        "RELIABLE" -> Reliable
        "UNCERTREL" -> Uncertrel
        "UNRELIABLE" -> Unreliable
        "CLINAST" -> Clinast
        "DEVAST" -> Devast
        "HCPAST" -> Hcpast
        "PACQAST" -> Pacqast
        "PATAST" -> Patast
        "PAYAST" -> Payast
        "PROAST" -> Proast
        "SDMAST" -> Sdmast
        "CLINRPT" -> Clinrpt
        "DEVRPT" -> Devrpt
        "HCPRPT" -> Hcprpt
        "PACQRPT" -> Pacqrpt
        "PATRPT" -> Patrpt
        "PAYRPT" -> Payrpt
        "PRORPT" -> Prorpt
        "SDMRPT" -> Sdmrpt
        "SecurityPolicy" -> SecurityPolicy
        "AUTHPOL" -> Authpol
        "ACCESSCONSCHEME" -> Accessconscheme
        "DELEPOL" -> Delepol
        "ObligationPolicy" -> ObligationPolicy
        "ANONY" -> Anony
        "AOD" -> Aod
        "AUDIT" -> Audit
        "AUDTR" -> Audtr
        "CPLYCC" -> Cplycc
        "CPLYCD" -> Cplycd
        "CPLYJPP" -> Cplyjpp
        "CPLYOPP" -> Cplyopp
        "CPLYOSP" -> Cplyosp
        "CPLYPOL" -> Cplypol
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
        "PSEUD" -> Pseud
        "REDACT" -> Redact
        "UPGRDLABEL" -> Upgrdlabel
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
        "NORDSCLCDS" -> Nordsclcds
        "NORDSCLW" -> Nordsclw
        "NORELINK" -> Norelink
        "NOREUSE" -> Noreuse
        "NOVIP" -> Novip
        "ORCON" -> Orcon
        "PurposeOfUse" -> PurposeOfUse
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
        else -> throw IllegalArgumentException("Unknown code $code for enum AllSecurityLabels")
      }
  }
}

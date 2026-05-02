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
 * This example FHIR value set is comprised of example Actor Type codes, which can be used to value
 * FHIR agents, actors, and other role elements such as those specified in financial transactions.
 * The FHIR Actor value set is based on DICOM Audit Message, C402; ASTM Standard, E1762-95 [2013];
 * selected codes and derived actor roles from HL7 RoleClass OID 2.16.840.1.113883.5.110; HL7 Role
 * Code 2.16.840.1.113883.5.111, including AgentRoleType; HL7 ParticipationType OID:
 * 2.16.840.1.113883.5.90; and HL7 ParticipationFunction codes OID: 2.16.840.1.113883.5.88. This
 * value set includes, by reference, role codes from external code systems: NUCC Health Care
 * Provider Taxonomy OID: 2.16.840.1.113883.6.101; North American Industry Classification System
 * [NAICS]OID: 2.16.840.1.113883.6.85; IndustryClassificationSystem 2.16.840.1.113883.1.11.16039;
 * and US Census Occupation Code OID: 2.16.840.1.113883.6.243 for relevant recipient or custodian
 * codes not included in this value set. If no source is indicated in the definition comments, then
 * these are example FHIR codes. It can be extended with appropriate roles described by SNOMED as
 * well as those described in the HL7 Role Based Access Control Catalog and the HL7 Healthcare
 * (Security and Privacy) Access Control Catalog. In Role-Based Access Control (RBAC), permissions
 * are operations on an object that a user wishes to access. Permissions are grouped into roles. A
 * role characterizes the functions a user is allowed to perform. Roles are assigned to users. If
 * the user's role has the appropriate permissions to access an object, then that user is granted
 * access to the object. FHIR readily enables RBAC, as FHIR Resources are object types and the CRUDE
 * events (the FHIR equivalent to permissions in the RBAC scheme) are operations on those objects.
 * In Attribute-Based Access Control (ABAC), a user requests to perform operations on objects. That
 * user's access request is granted or denied based on a set of access control policies that are
 * specified in terms of attributes and conditions. FHIR readily enables ABAC, as instances of a
 * Resource in FHIR (again, Resources are object types) can have attributes associated with them.
 * These attributes include security tags, environment conditions, and a host of user and object
 * characteristics, which are the same attributes as those used in ABAC. Attributes help define the
 * access control policies that determine the operations a user may perform on a Resource (in FHIR)
 * or object (in ABAC). For example, a tag (or attribute) may specify that the identified Resource
 * (object) is not to be further disclosed without explicit consent from the patient.
 */
public enum class SecurityRoleType(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Amender("AMENDER", "http://terminology.hl7.org/CodeSystem/contractsignertypecodes", "Amender"),
  Coauth("COAUTH", "http://terminology.hl7.org/CodeSystem/contractsignertypecodes", "Co-Author"),
  Cont("CONT", "http://terminology.hl7.org/CodeSystem/contractsignertypecodes", "Contact"),
  Evtwit(
    "EVTWIT",
    "http://terminology.hl7.org/CodeSystem/contractsignertypecodes",
    "Event Witness",
  ),
  Primauth(
    "PRIMAUTH",
    "http://terminology.hl7.org/CodeSystem/contractsignertypecodes",
    "Primary Author",
  ),
  Reviewer("REVIEWER", "http://terminology.hl7.org/CodeSystem/contractsignertypecodes", "Reviewer"),
  Source("SOURCE", "http://terminology.hl7.org/CodeSystem/contractsignertypecodes", "Source"),
  Trans("TRANS", "http://terminology.hl7.org/CodeSystem/contractsignertypecodes", "Transcriber"),
  Valid("VALID", "http://terminology.hl7.org/CodeSystem/contractsignertypecodes", "Validator"),
  Verf("VERF", "http://terminology.hl7.org/CodeSystem/contractsignertypecodes", "Verifier"),
  Affl("AFFL", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "affiliate"),
  Agnt("AGNT", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "agent"),
  Assigned("ASSIGNED", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "assigned entity"),
  Claim("CLAIM", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "claimant"),
  Covpty("COVPTY", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "covered party"),
  Depen("DEPEN", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "dependent"),
  Econ("ECON", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "emergency contact"),
  Emp("EMP", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "employee"),
  Guard("GUARD", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "guardian"),
  Invsbj("INVSBJ", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "Investigation Subject"),
  Named("NAMED", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "named insured"),
  Nok("NOK", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "next of kin"),
  Pat("PAT", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "patient"),
  Prov("PROV", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "healthcare provider"),
  Not("NOT", "http://terminology.hl7.org/CodeSystem/v3-RoleClass", "notary public"),
  Classifier("CLASSIFIER", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "classifier"),
  Consenter("CONSENTER", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "consenter"),
  Conswit("CONSWIT", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "consent witness"),
  Copart("COPART", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "co-participant"),
  Declassifier("DECLASSIFIER", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "declassifier"),
  Delegatee("DELEGATEE", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "delegatee"),
  Delegator("DELEGATOR", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "delegator"),
  Downgrder("DOWNGRDER", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "downgrader"),
  Dpowatt(
    "DPOWATT",
    "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
    "durable power of attorney",
  ),
  Excest("EXCEST", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "executor of estate"),
  Grantee("GRANTEE", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "grantee"),
  Grantor("GRANTOR", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "grantor"),
  Gt("GT", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "Guarantor"),
  Guadltm("GUADLTM", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "guardian ad lidem"),
  Hpowatt(
    "HPOWATT",
    "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
    "healthcare power of attorney",
  ),
  Intprter("INTPRTER", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "interpreter"),
  Powatt("POWATT", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "power of attorney"),
  Resprsn("RESPRSN", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "responsible party"),
  Spowatt(
    "SPOWATT",
    "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
    "special power of attorney",
  ),
  _CitizenRoleType(
    "_CitizenRoleType",
    "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
    "CitizenRoleType",
  ),
  Cas("CAS", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "asylum seeker"),
  Casm("CASM", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "single minor asylum seeker"),
  Cn("CN", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "national"),
  Cnrp(
    "CNRP",
    "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
    "non-country member without residence permit",
  ),
  Cnrpm(
    "CNRPM",
    "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
    "non-country member minor without residence permit",
  ),
  Cpca("CPCA", "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "permit card applicant"),
  Crp(
    "CRP",
    "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
    "non-country member with residence permit",
  ),
  Crpm(
    "CRPM",
    "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
    "non-country member minor with residence permit",
  ),
  Aucg(
    "AUCG",
    "http://terminology.hl7.org/CodeSystem/v3-ParticipationFunction",
    "caregiver information receiver",
  ),
  Aulr(
    "AULR",
    "http://terminology.hl7.org/CodeSystem/v3-ParticipationFunction",
    "legitimate relationship information receiver",
  ),
  Autm(
    "AUTM",
    "http://terminology.hl7.org/CodeSystem/v3-ParticipationFunction",
    "care team information receiver",
  ),
  Auwa(
    "AUWA",
    "http://terminology.hl7.org/CodeSystem/v3-ParticipationFunction",
    "work area information receiver",
  ),
  Promsk(
    "PROMSK",
    "http://terminology.hl7.org/CodeSystem/v3-ParticipationFunction",
    "authorized provider masking author",
  ),
  Aut("AUT", "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "author (originator)"),
  Cst("CST", "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "custodian"),
  Inf("INF", "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "informant"),
  Ircp(
    "IRCP",
    "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
    "information recipient",
  ),
  La("LA", "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "legal authenticator"),
  Trc("TRC", "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "tracker"),
  Wit("WIT", "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "witness"),
  Authserver(
    "authserver",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "authorization server",
  ),
  Datacollector(
    "datacollector",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "data collector",
  ),
  Dataprocessor(
    "dataprocessor",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "data processor",
  ),
  Datasubject(
    "datasubject",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "data subject",
  ),
  Humanuser(
    "humanuser",
    "http://terminology.hl7.org/CodeSystem/extra-security-role-type",
    "human user",
  ),
  _110150("110150", "http://dicom.nema.org/resources/ontology/DCM", "Application"),
  _110151("110151", "http://dicom.nema.org/resources/ontology/DCM", "Application Launcher"),
  _110152("110152", "http://dicom.nema.org/resources/ontology/DCM", "Destination Role ID"),
  _110153("110153", "http://dicom.nema.org/resources/ontology/DCM", "Source Role ID"),
  _110154("110154", "http://dicom.nema.org/resources/ontology/DCM", "Destination Media"),
  _110155("110155", "http://dicom.nema.org/resources/ontology/DCM", "Source Media");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): SecurityRoleType =
      when (code) {
        "AMENDER" -> Amender
        "COAUTH" -> Coauth
        "CONT" -> Cont
        "EVTWIT" -> Evtwit
        "PRIMAUTH" -> Primauth
        "REVIEWER" -> Reviewer
        "SOURCE" -> Source
        "TRANS" -> Trans
        "VALID" -> Valid
        "VERF" -> Verf
        "AFFL" -> Affl
        "AGNT" -> Agnt
        "ASSIGNED" -> Assigned
        "CLAIM" -> Claim
        "COVPTY" -> Covpty
        "DEPEN" -> Depen
        "ECON" -> Econ
        "EMP" -> Emp
        "GUARD" -> Guard
        "INVSBJ" -> Invsbj
        "NAMED" -> Named
        "NOK" -> Nok
        "PAT" -> Pat
        "PROV" -> Prov
        "NOT" -> Not
        "CLASSIFIER" -> Classifier
        "CONSENTER" -> Consenter
        "CONSWIT" -> Conswit
        "COPART" -> Copart
        "DECLASSIFIER" -> Declassifier
        "DELEGATEE" -> Delegatee
        "DELEGATOR" -> Delegator
        "DOWNGRDER" -> Downgrder
        "DPOWATT" -> Dpowatt
        "EXCEST" -> Excest
        "GRANTEE" -> Grantee
        "GRANTOR" -> Grantor
        "GT" -> Gt
        "GUADLTM" -> Guadltm
        "HPOWATT" -> Hpowatt
        "INTPRTER" -> Intprter
        "POWATT" -> Powatt
        "RESPRSN" -> Resprsn
        "SPOWATT" -> Spowatt
        "_CitizenRoleType" -> _CitizenRoleType
        "CAS" -> Cas
        "CASM" -> Casm
        "CN" -> Cn
        "CNRP" -> Cnrp
        "CNRPM" -> Cnrpm
        "CPCA" -> Cpca
        "CRP" -> Crp
        "CRPM" -> Crpm
        "AUCG" -> Aucg
        "AULR" -> Aulr
        "AUTM" -> Autm
        "AUWA" -> Auwa
        "PROMSK" -> Promsk
        "AUT" -> Aut
        "CST" -> Cst
        "INF" -> Inf
        "IRCP" -> Ircp
        "LA" -> La
        "TRC" -> Trc
        "WIT" -> Wit
        "authserver" -> Authserver
        "datacollector" -> Datacollector
        "dataprocessor" -> Dataprocessor
        "datasubject" -> Datasubject
        "humanuser" -> Humanuser
        "110150" -> _110150
        "110151" -> _110151
        "110152" -> _110152
        "110153" -> _110153
        "110154" -> _110154
        "110155" -> _110155
        else -> throw IllegalArgumentException("Unknown code $code for enum SecurityRoleType")
      }
  }
}

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

package dev.ohs.fhir.model.r4b.terminologies

import dev.ohs.fhir.model.r4b.FhirEnum
import kotlin.String

/**
 * The license that applies to an Implementation Guide (using an SPDX license Identifiers, or
 * 'not-open-source'). The binding is required but new SPDX license Identifiers are allowed to be
 * used (https://spdx.org/licenses/).
 */
public enum class SPDXLicense(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Not_Open_Source("not-open-source", "http://hl7.org/fhir/spdx-license", "Not open source"),
  _0BSD("0BSD", "http://hl7.org/fhir/spdx-license", "BSD Zero Clause License"),
  Aal("AAL", "http://hl7.org/fhir/spdx-license", "Attribution Assurance License"),
  Abstyles("Abstyles", "http://hl7.org/fhir/spdx-license", "Abstyles License"),
  Adobe_2006(
    "Adobe-2006",
    "http://hl7.org/fhir/spdx-license",
    "Adobe Systems Incorporated Source Code License Agreement",
  ),
  Adobe_Glyph("Adobe-Glyph", "http://hl7.org/fhir/spdx-license", "Adobe Glyph List License"),
  Adsl("ADSL", "http://hl7.org/fhir/spdx-license", "Amazon Digital Services License"),
  Afl_1_1("AFL-1.1", "http://hl7.org/fhir/spdx-license", "Academic Free License v1.1"),
  Afl_1_2("AFL-1.2", "http://hl7.org/fhir/spdx-license", "Academic Free License v1.2"),
  Afl_2_0("AFL-2.0", "http://hl7.org/fhir/spdx-license", "Academic Free License v2.0"),
  Afl_2_1("AFL-2.1", "http://hl7.org/fhir/spdx-license", "Academic Free License v2.1"),
  Afl_3_0("AFL-3.0", "http://hl7.org/fhir/spdx-license", "Academic Free License v3.0"),
  Afmparse("Afmparse", "http://hl7.org/fhir/spdx-license", "Afmparse License"),
  Agpl_1_0_Only(
    "AGPL-1.0-only",
    "http://hl7.org/fhir/spdx-license",
    "Affero General Public License v1.0 only",
  ),
  Agpl_1_0_Or_Later(
    "AGPL-1.0-or-later",
    "http://hl7.org/fhir/spdx-license",
    "Affero General Public License v1.0 or later",
  ),
  Agpl_3_0_Only(
    "AGPL-3.0-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU Affero General Public License v3.0 only",
  ),
  Agpl_3_0_Or_Later(
    "AGPL-3.0-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU Affero General Public License v3.0 or later",
  ),
  Aladdin("Aladdin", "http://hl7.org/fhir/spdx-license", "Aladdin Free Public License"),
  Amdplpa("AMDPLPA", "http://hl7.org/fhir/spdx-license", "AMD's plpa_map.c License"),
  Aml("AML", "http://hl7.org/fhir/spdx-license", "Apple MIT License"),
  Ampas(
    "AMPAS",
    "http://hl7.org/fhir/spdx-license",
    "Academy of Motion Picture Arts and Sciences BSD",
  ),
  Antlr_Pd("ANTLR-PD", "http://hl7.org/fhir/spdx-license", "ANTLR Software Rights Notice"),
  Apache_1_0("Apache-1.0", "http://hl7.org/fhir/spdx-license", "Apache License 1.0"),
  Apache_1_1("Apache-1.1", "http://hl7.org/fhir/spdx-license", "Apache License 1.1"),
  Apache_2_0("Apache-2.0", "http://hl7.org/fhir/spdx-license", "Apache License 2.0"),
  Apafml("APAFML", "http://hl7.org/fhir/spdx-license", "Adobe Postscript AFM License"),
  Apl_1_0("APL-1.0", "http://hl7.org/fhir/spdx-license", "Adaptive Public License 1.0"),
  Apsl_1_0("APSL-1.0", "http://hl7.org/fhir/spdx-license", "Apple Public Source License 1.0"),
  Apsl_1_1("APSL-1.1", "http://hl7.org/fhir/spdx-license", "Apple Public Source License 1.1"),
  Apsl_1_2("APSL-1.2", "http://hl7.org/fhir/spdx-license", "Apple Public Source License 1.2"),
  Apsl_2_0("APSL-2.0", "http://hl7.org/fhir/spdx-license", "Apple Public Source License 2.0"),
  Artistic_1_0_Cl8(
    "Artistic-1.0-cl8",
    "http://hl7.org/fhir/spdx-license",
    "Artistic License 1.0 w/clause 8",
  ),
  Artistic_1_0_Perl(
    "Artistic-1.0-Perl",
    "http://hl7.org/fhir/spdx-license",
    "Artistic License 1.0 (Perl)",
  ),
  Artistic_1_0("Artistic-1.0", "http://hl7.org/fhir/spdx-license", "Artistic License 1.0"),
  Artistic_2_0("Artistic-2.0", "http://hl7.org/fhir/spdx-license", "Artistic License 2.0"),
  Bahyph("Bahyph", "http://hl7.org/fhir/spdx-license", "Bahyph License"),
  Barr("Barr", "http://hl7.org/fhir/spdx-license", "Barr License"),
  Beerware("Beerware", "http://hl7.org/fhir/spdx-license", "Beerware License"),
  BitTorrent_1_0(
    "BitTorrent-1.0",
    "http://hl7.org/fhir/spdx-license",
    "BitTorrent Open Source License v1.0",
  ),
  BitTorrent_1_1(
    "BitTorrent-1.1",
    "http://hl7.org/fhir/spdx-license",
    "BitTorrent Open Source License v1.1",
  ),
  Borceux("Borceux", "http://hl7.org/fhir/spdx-license", "Borceux license"),
  Bsd_1_Clause("BSD-1-Clause", "http://hl7.org/fhir/spdx-license", "BSD 1-Clause License"),
  Bsd_2_Clause_FreeBSD(
    "BSD-2-Clause-FreeBSD",
    "http://hl7.org/fhir/spdx-license",
    "BSD 2-Clause FreeBSD License",
  ),
  Bsd_2_Clause_NetBSD(
    "BSD-2-Clause-NetBSD",
    "http://hl7.org/fhir/spdx-license",
    "BSD 2-Clause NetBSD License",
  ),
  Bsd_2_Clause_Patent(
    "BSD-2-Clause-Patent",
    "http://hl7.org/fhir/spdx-license",
    "BSD-2-Clause Plus Patent License",
  ),
  Bsd_2_Clause(
    "BSD-2-Clause",
    "http://hl7.org/fhir/spdx-license",
    "BSD 2-Clause \"Simplified\" License",
  ),
  Bsd_3_Clause_Attribution(
    "BSD-3-Clause-Attribution",
    "http://hl7.org/fhir/spdx-license",
    "BSD with attribution",
  ),
  Bsd_3_Clause_Clear(
    "BSD-3-Clause-Clear",
    "http://hl7.org/fhir/spdx-license",
    "BSD 3-Clause Clear License",
  ),
  Bsd_3_Clause_Lbnl(
    "BSD-3-Clause-LBNL",
    "http://hl7.org/fhir/spdx-license",
    "Lawrence Berkeley National Labs BSD variant license",
  ),
  Bsd_3_Clause_No_Nuclear_License_2014(
    "BSD-3-Clause-No-Nuclear-License-2014",
    "http://hl7.org/fhir/spdx-license",
    "BSD 3-Clause No Nuclear License 2014",
  ),
  Bsd_3_Clause_No_Nuclear_License(
    "BSD-3-Clause-No-Nuclear-License",
    "http://hl7.org/fhir/spdx-license",
    "BSD 3-Clause No Nuclear License",
  ),
  Bsd_3_Clause_No_Nuclear_Warranty(
    "BSD-3-Clause-No-Nuclear-Warranty",
    "http://hl7.org/fhir/spdx-license",
    "BSD 3-Clause No Nuclear Warranty",
  ),
  Bsd_3_Clause(
    "BSD-3-Clause",
    "http://hl7.org/fhir/spdx-license",
    "BSD 3-Clause \"New\" or \"Revised\" License",
  ),
  Bsd_4_Clause_Uc(
    "BSD-4-Clause-UC",
    "http://hl7.org/fhir/spdx-license",
    "BSD-4-Clause (University of California-Specific)",
  ),
  Bsd_4_Clause(
    "BSD-4-Clause",
    "http://hl7.org/fhir/spdx-license",
    "BSD 4-Clause \"Original\" or \"Old\" License",
  ),
  Bsd_Protection("BSD-Protection", "http://hl7.org/fhir/spdx-license", "BSD Protection License"),
  Bsd_Source_Code(
    "BSD-Source-Code",
    "http://hl7.org/fhir/spdx-license",
    "BSD Source Code Attribution",
  ),
  Bsl_1_0("BSL-1.0", "http://hl7.org/fhir/spdx-license", "Boost Software License 1.0"),
  Bzip2_1_0_5(
    "bzip2-1.0.5",
    "http://hl7.org/fhir/spdx-license",
    "bzip2 and libbzip2 License v1.0.5",
  ),
  Bzip2_1_0_6(
    "bzip2-1.0.6",
    "http://hl7.org/fhir/spdx-license",
    "bzip2 and libbzip2 License v1.0.6",
  ),
  Caldera("Caldera", "http://hl7.org/fhir/spdx-license", "Caldera License"),
  Catosl_1_1(
    "CATOSL-1.1",
    "http://hl7.org/fhir/spdx-license",
    "Computer Associates Trusted Open Source License 1.1",
  ),
  Cc_By_1_0(
    "CC-BY-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution 1.0 Generic",
  ),
  Cc_By_2_0(
    "CC-BY-2.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution 2.0 Generic",
  ),
  Cc_By_2_5(
    "CC-BY-2.5",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution 2.5 Generic",
  ),
  Cc_By_3_0(
    "CC-BY-3.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution 3.0 Unported",
  ),
  Cc_By_4_0(
    "CC-BY-4.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution 4.0 International",
  ),
  Cc_By_Nc_1_0(
    "CC-BY-NC-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial 1.0 Generic",
  ),
  Cc_By_Nc_2_0(
    "CC-BY-NC-2.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial 2.0 Generic",
  ),
  Cc_By_Nc_2_5(
    "CC-BY-NC-2.5",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial 2.5 Generic",
  ),
  Cc_By_Nc_3_0(
    "CC-BY-NC-3.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial 3.0 Unported",
  ),
  Cc_By_Nc_4_0(
    "CC-BY-NC-4.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial 4.0 International",
  ),
  Cc_By_Nc_Nd_1_0(
    "CC-BY-NC-ND-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial No Derivatives 1.0 Generic",
  ),
  Cc_By_Nc_Nd_2_0(
    "CC-BY-NC-ND-2.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial No Derivatives 2.0 Generic",
  ),
  Cc_By_Nc_Nd_2_5(
    "CC-BY-NC-ND-2.5",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial No Derivatives 2.5 Generic",
  ),
  Cc_By_Nc_Nd_3_0(
    "CC-BY-NC-ND-3.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial No Derivatives 3.0 Unported",
  ),
  Cc_By_Nc_Nd_4_0(
    "CC-BY-NC-ND-4.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial No Derivatives 4.0 International",
  ),
  Cc_By_Nc_Sa_1_0(
    "CC-BY-NC-SA-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial Share Alike 1.0 Generic",
  ),
  Cc_By_Nc_Sa_2_0(
    "CC-BY-NC-SA-2.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial Share Alike 2.0 Generic",
  ),
  Cc_By_Nc_Sa_2_5(
    "CC-BY-NC-SA-2.5",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial Share Alike 2.5 Generic",
  ),
  Cc_By_Nc_Sa_3_0(
    "CC-BY-NC-SA-3.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial Share Alike 3.0 Unported",
  ),
  Cc_By_Nc_Sa_4_0(
    "CC-BY-NC-SA-4.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Non Commercial Share Alike 4.0 International",
  ),
  Cc_By_Nd_1_0(
    "CC-BY-ND-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution No Derivatives 1.0 Generic",
  ),
  Cc_By_Nd_2_0(
    "CC-BY-ND-2.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution No Derivatives 2.0 Generic",
  ),
  Cc_By_Nd_2_5(
    "CC-BY-ND-2.5",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution No Derivatives 2.5 Generic",
  ),
  Cc_By_Nd_3_0(
    "CC-BY-ND-3.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution No Derivatives 3.0 Unported",
  ),
  Cc_By_Nd_4_0(
    "CC-BY-ND-4.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution No Derivatives 4.0 International",
  ),
  Cc_By_Sa_1_0(
    "CC-BY-SA-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Share Alike 1.0 Generic",
  ),
  Cc_By_Sa_2_0(
    "CC-BY-SA-2.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Share Alike 2.0 Generic",
  ),
  Cc_By_Sa_2_5(
    "CC-BY-SA-2.5",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Share Alike 2.5 Generic",
  ),
  Cc_By_Sa_3_0(
    "CC-BY-SA-3.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Share Alike 3.0 Unported",
  ),
  Cc_By_Sa_4_0(
    "CC-BY-SA-4.0",
    "http://hl7.org/fhir/spdx-license",
    "Creative Commons Attribution Share Alike 4.0 International",
  ),
  CC0_1_0("CC0-1.0", "http://hl7.org/fhir/spdx-license", "Creative Commons Zero v1.0 Universal"),
  Cddl_1_0(
    "CDDL-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Common Development and Distribution License 1.0",
  ),
  Cddl_1_1(
    "CDDL-1.1",
    "http://hl7.org/fhir/spdx-license",
    "Common Development and Distribution License 1.1",
  ),
  Cdla_Permissive_1_0(
    "CDLA-Permissive-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Community Data License Agreement Permissive 1.0",
  ),
  Cdla_Sharing_1_0(
    "CDLA-Sharing-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Community Data License Agreement Sharing 1.0",
  ),
  Cecill_1_0(
    "CECILL-1.0",
    "http://hl7.org/fhir/spdx-license",
    "CeCILL Free Software License Agreement v1.0",
  ),
  Cecill_1_1(
    "CECILL-1.1",
    "http://hl7.org/fhir/spdx-license",
    "CeCILL Free Software License Agreement v1.1",
  ),
  Cecill_2_0(
    "CECILL-2.0",
    "http://hl7.org/fhir/spdx-license",
    "CeCILL Free Software License Agreement v2.0",
  ),
  Cecill_2_1(
    "CECILL-2.1",
    "http://hl7.org/fhir/spdx-license",
    "CeCILL Free Software License Agreement v2.1",
  ),
  Cecill_B(
    "CECILL-B",
    "http://hl7.org/fhir/spdx-license",
    "CeCILL-B Free Software License Agreement",
  ),
  Cecill_C(
    "CECILL-C",
    "http://hl7.org/fhir/spdx-license",
    "CeCILL-C Free Software License Agreement",
  ),
  ClArtistic("ClArtistic", "http://hl7.org/fhir/spdx-license", "Clarified Artistic License"),
  Cnri_Jython("CNRI-Jython", "http://hl7.org/fhir/spdx-license", "CNRI Jython License"),
  Cnri_Python_Gpl_Compatible(
    "CNRI-Python-GPL-Compatible",
    "http://hl7.org/fhir/spdx-license",
    "CNRI Python Open Source GPL Compatible License Agreement",
  ),
  Cnri_Python("CNRI-Python", "http://hl7.org/fhir/spdx-license", "CNRI Python License"),
  Condor_1_1("Condor-1.1", "http://hl7.org/fhir/spdx-license", "Condor Public License v1.1"),
  Cpal_1_0("CPAL-1.0", "http://hl7.org/fhir/spdx-license", "Common Public Attribution License 1.0"),
  Cpl_1_0("CPL-1.0", "http://hl7.org/fhir/spdx-license", "Common Public License 1.0"),
  Cpol_1_02("CPOL-1.02", "http://hl7.org/fhir/spdx-license", "Code Project Open License 1.02"),
  Crossword("Crossword", "http://hl7.org/fhir/spdx-license", "Crossword License"),
  CrystalStacker("CrystalStacker", "http://hl7.org/fhir/spdx-license", "CrystalStacker License"),
  Cua_Opl_1_0("CUA-OPL-1.0", "http://hl7.org/fhir/spdx-license", "CUA Office Public License v1.0"),
  Cube("Cube", "http://hl7.org/fhir/spdx-license", "Cube License"),
  Curl("curl", "http://hl7.org/fhir/spdx-license", "curl License"),
  D_Fsl_1_0("D-FSL-1.0", "http://hl7.org/fhir/spdx-license", "Deutsche Freie Software Lizenz"),
  Diffmark("diffmark", "http://hl7.org/fhir/spdx-license", "diffmark license"),
  Doc("DOC", "http://hl7.org/fhir/spdx-license", "DOC License"),
  Dotseqn("Dotseqn", "http://hl7.org/fhir/spdx-license", "Dotseqn License"),
  Dsdp("DSDP", "http://hl7.org/fhir/spdx-license", "DSDP License"),
  Dvipdfm("dvipdfm", "http://hl7.org/fhir/spdx-license", "dvipdfm License"),
  Ecl_1_0("ECL-1.0", "http://hl7.org/fhir/spdx-license", "Educational Community License v1.0"),
  Ecl_2_0("ECL-2.0", "http://hl7.org/fhir/spdx-license", "Educational Community License v2.0"),
  Efl_1_0("EFL-1.0", "http://hl7.org/fhir/spdx-license", "Eiffel Forum License v1.0"),
  Efl_2_0("EFL-2.0", "http://hl7.org/fhir/spdx-license", "Eiffel Forum License v2.0"),
  EGenix("eGenix", "http://hl7.org/fhir/spdx-license", "eGenix.com Public License 1.1.0"),
  Entessa("Entessa", "http://hl7.org/fhir/spdx-license", "Entessa Public License v1.0"),
  Epl_1_0("EPL-1.0", "http://hl7.org/fhir/spdx-license", "Eclipse Public License 1.0"),
  Epl_2_0("EPL-2.0", "http://hl7.org/fhir/spdx-license", "Eclipse Public License 2.0"),
  ErlPL_1_1("ErlPL-1.1", "http://hl7.org/fhir/spdx-license", "Erlang Public License v1.1"),
  EUDatagrid("EUDatagrid", "http://hl7.org/fhir/spdx-license", "EU DataGrid Software License"),
  Eupl_1_0("EUPL-1.0", "http://hl7.org/fhir/spdx-license", "European Union Public License 1.0"),
  Eupl_1_1("EUPL-1.1", "http://hl7.org/fhir/spdx-license", "European Union Public License 1.1"),
  Eupl_1_2("EUPL-1.2", "http://hl7.org/fhir/spdx-license", "European Union Public License 1.2"),
  Eurosym("Eurosym", "http://hl7.org/fhir/spdx-license", "Eurosym License"),
  Fair("Fair", "http://hl7.org/fhir/spdx-license", "Fair License"),
  Frameworx_1_0("Frameworx-1.0", "http://hl7.org/fhir/spdx-license", "Frameworx Open License 1.0"),
  FreeImage("FreeImage", "http://hl7.org/fhir/spdx-license", "FreeImage Public License v1.0"),
  Fsfap("FSFAP", "http://hl7.org/fhir/spdx-license", "FSF All Permissive License"),
  Fsful("FSFUL", "http://hl7.org/fhir/spdx-license", "FSF Unlimited License"),
  Fsfullr(
    "FSFULLR",
    "http://hl7.org/fhir/spdx-license",
    "FSF Unlimited License (with License Retention)",
  ),
  Ftl("FTL", "http://hl7.org/fhir/spdx-license", "Freetype Project License"),
  Gfdl_1_1_Only(
    "GFDL-1.1-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU Free Documentation License v1.1 only",
  ),
  Gfdl_1_1_Or_Later(
    "GFDL-1.1-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU Free Documentation License v1.1 or later",
  ),
  Gfdl_1_2_Only(
    "GFDL-1.2-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU Free Documentation License v1.2 only",
  ),
  Gfdl_1_2_Or_Later(
    "GFDL-1.2-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU Free Documentation License v1.2 or later",
  ),
  Gfdl_1_3_Only(
    "GFDL-1.3-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU Free Documentation License v1.3 only",
  ),
  Gfdl_1_3_Or_Later(
    "GFDL-1.3-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU Free Documentation License v1.3 or later",
  ),
  Giftware("Giftware", "http://hl7.org/fhir/spdx-license", "Giftware License"),
  GL2PS("GL2PS", "http://hl7.org/fhir/spdx-license", "GL2PS License"),
  Glide("Glide", "http://hl7.org/fhir/spdx-license", "3dfx Glide License"),
  Glulxe("Glulxe", "http://hl7.org/fhir/spdx-license", "Glulxe License"),
  Gnuplot("gnuplot", "http://hl7.org/fhir/spdx-license", "gnuplot License"),
  Gpl_1_0_Only(
    "GPL-1.0-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU General Public License v1.0 only",
  ),
  Gpl_1_0_Or_Later(
    "GPL-1.0-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU General Public License v1.0 or later",
  ),
  Gpl_2_0_Only(
    "GPL-2.0-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU General Public License v2.0 only",
  ),
  Gpl_2_0_Or_Later(
    "GPL-2.0-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU General Public License v2.0 or later",
  ),
  Gpl_3_0_Only(
    "GPL-3.0-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU General Public License v3.0 only",
  ),
  Gpl_3_0_Or_Later(
    "GPL-3.0-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU General Public License v3.0 or later",
  ),
  GSOAP_1_3b("gSOAP-1.3b", "http://hl7.org/fhir/spdx-license", "gSOAP Public License v1.3b"),
  HaskellReport(
    "HaskellReport",
    "http://hl7.org/fhir/spdx-license",
    "Haskell Language Report License",
  ),
  Hpnd("HPND", "http://hl7.org/fhir/spdx-license", "Historical Permission Notice and Disclaimer"),
  Ibm_Pibs(
    "IBM-pibs",
    "http://hl7.org/fhir/spdx-license",
    "IBM PowerPC Initialization and Boot Software",
  ),
  Icu("ICU", "http://hl7.org/fhir/spdx-license", "ICU License"),
  Ijg("IJG", "http://hl7.org/fhir/spdx-license", "Independent JPEG Group License"),
  ImageMagick("ImageMagick", "http://hl7.org/fhir/spdx-license", "ImageMagick License"),
  IMatix(
    "iMatix",
    "http://hl7.org/fhir/spdx-license",
    "iMatix Standard Function Library Agreement",
  ),
  Imlib2("Imlib2", "http://hl7.org/fhir/spdx-license", "Imlib2 License"),
  Info_Zip("Info-ZIP", "http://hl7.org/fhir/spdx-license", "Info-ZIP License"),
  Intel_Acpi(
    "Intel-ACPI",
    "http://hl7.org/fhir/spdx-license",
    "Intel ACPI Software License Agreement",
  ),
  Intel("Intel", "http://hl7.org/fhir/spdx-license", "Intel Open Source License"),
  Interbase_1_0(
    "Interbase-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Interbase Public License v1.0",
  ),
  Ipa("IPA", "http://hl7.org/fhir/spdx-license", "IPA Font License"),
  Ipl_1_0("IPL-1.0", "http://hl7.org/fhir/spdx-license", "IBM Public License v1.0"),
  Isc("ISC", "http://hl7.org/fhir/spdx-license", "ISC License"),
  JasPer_2_0("JasPer-2.0", "http://hl7.org/fhir/spdx-license", "JasPer License"),
  Json("JSON", "http://hl7.org/fhir/spdx-license", "JSON License"),
  Lal_1_2("LAL-1.2", "http://hl7.org/fhir/spdx-license", "Licence Art Libre 1.2"),
  Lal_1_3("LAL-1.3", "http://hl7.org/fhir/spdx-license", "Licence Art Libre 1.3"),
  Latex2e("Latex2e", "http://hl7.org/fhir/spdx-license", "Latex2e License"),
  Leptonica("Leptonica", "http://hl7.org/fhir/spdx-license", "Leptonica License"),
  Lgpl_2_0_Only(
    "LGPL-2.0-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU Library General Public License v2 only",
  ),
  Lgpl_2_0_Or_Later(
    "LGPL-2.0-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU Library General Public License v2 or later",
  ),
  Lgpl_2_1_Only(
    "LGPL-2.1-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU Lesser General Public License v2.1 only",
  ),
  Lgpl_2_1_Or_Later(
    "LGPL-2.1-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU Lesser General Public License v2.1 or later",
  ),
  Lgpl_3_0_Only(
    "LGPL-3.0-only",
    "http://hl7.org/fhir/spdx-license",
    "GNU Lesser General Public License v3.0 only",
  ),
  Lgpl_3_0_Or_Later(
    "LGPL-3.0-or-later",
    "http://hl7.org/fhir/spdx-license",
    "GNU Lesser General Public License v3.0 or later",
  ),
  Lgpllr(
    "LGPLLR",
    "http://hl7.org/fhir/spdx-license",
    "Lesser General Public License For Linguistic Resources",
  ),
  Libpng("Libpng", "http://hl7.org/fhir/spdx-license", "libpng License"),
  Libtiff("libtiff", "http://hl7.org/fhir/spdx-license", "libtiff License"),
  LiLiQ_P_1_1(
    "LiLiQ-P-1.1",
    "http://hl7.org/fhir/spdx-license",
    "Licence Libre du Québec – Permissive version 1.1",
  ),
  LiLiQ_R_1_1(
    "LiLiQ-R-1.1",
    "http://hl7.org/fhir/spdx-license",
    "Licence Libre du Québec – Réciprocité version 1.1",
  ),
  LiLiQ_Rplus_1_1(
    "LiLiQ-Rplus-1.1",
    "http://hl7.org/fhir/spdx-license",
    "Licence Libre du Québec – Réciprocité forte version 1.1",
  ),
  Linux_OpenIB(
    "Linux-OpenIB",
    "http://hl7.org/fhir/spdx-license",
    "Linux Kernel Variant of OpenIB.org license",
  ),
  Lpl_1_0("LPL-1.0", "http://hl7.org/fhir/spdx-license", "Lucent Public License Version 1.0"),
  Lpl_1_02("LPL-1.02", "http://hl7.org/fhir/spdx-license", "Lucent Public License v1.02"),
  Lppl_1_0("LPPL-1.0", "http://hl7.org/fhir/spdx-license", "LaTeX Project Public License v1.0"),
  Lppl_1_1("LPPL-1.1", "http://hl7.org/fhir/spdx-license", "LaTeX Project Public License v1.1"),
  Lppl_1_2("LPPL-1.2", "http://hl7.org/fhir/spdx-license", "LaTeX Project Public License v1.2"),
  Lppl_1_3a("LPPL-1.3a", "http://hl7.org/fhir/spdx-license", "LaTeX Project Public License v1.3a"),
  Lppl_1_3c("LPPL-1.3c", "http://hl7.org/fhir/spdx-license", "LaTeX Project Public License v1.3c"),
  MakeIndex("MakeIndex", "http://hl7.org/fhir/spdx-license", "MakeIndex License"),
  MirOS("MirOS", "http://hl7.org/fhir/spdx-license", "MirOS License"),
  Mit_0("MIT-0", "http://hl7.org/fhir/spdx-license", "MIT No Attribution"),
  Mit_Advertising(
    "MIT-advertising",
    "http://hl7.org/fhir/spdx-license",
    "Enlightenment License (e16)",
  ),
  Mit_Cmu("MIT-CMU", "http://hl7.org/fhir/spdx-license", "CMU License"),
  Mit_Enna("MIT-enna", "http://hl7.org/fhir/spdx-license", "enna License"),
  Mit_Feh("MIT-feh", "http://hl7.org/fhir/spdx-license", "feh License"),
  Mit("MIT", "http://hl7.org/fhir/spdx-license", "MIT License"),
  Mitnfa("MITNFA", "http://hl7.org/fhir/spdx-license", "MIT +no-false-attribs license"),
  Motosoto("Motosoto", "http://hl7.org/fhir/spdx-license", "Motosoto License"),
  Mpich2("mpich2", "http://hl7.org/fhir/spdx-license", "mpich2 License"),
  Mpl_1_0("MPL-1.0", "http://hl7.org/fhir/spdx-license", "Mozilla Public License 1.0"),
  Mpl_1_1("MPL-1.1", "http://hl7.org/fhir/spdx-license", "Mozilla Public License 1.1"),
  Mpl_2_0_No_Copyleft_Exception(
    "MPL-2.0-no-copyleft-exception",
    "http://hl7.org/fhir/spdx-license",
    "Mozilla Public License 2.0 (no copyleft exception)",
  ),
  Mpl_2_0("MPL-2.0", "http://hl7.org/fhir/spdx-license", "Mozilla Public License 2.0"),
  Ms_Pl("MS-PL", "http://hl7.org/fhir/spdx-license", "Microsoft Public License"),
  Ms_Rl("MS-RL", "http://hl7.org/fhir/spdx-license", "Microsoft Reciprocal License"),
  Mtll("MTLL", "http://hl7.org/fhir/spdx-license", "Matrix Template Library License"),
  Multics("Multics", "http://hl7.org/fhir/spdx-license", "Multics License"),
  Mup("Mup", "http://hl7.org/fhir/spdx-license", "Mup License"),
  Nasa_1_3("NASA-1.3", "http://hl7.org/fhir/spdx-license", "NASA Open Source Agreement 1.3"),
  Naumen("Naumen", "http://hl7.org/fhir/spdx-license", "Naumen Public License"),
  Nbpl_1_0("NBPL-1.0", "http://hl7.org/fhir/spdx-license", "Net Boolean Public License v1"),
  Ncsa(
    "NCSA",
    "http://hl7.org/fhir/spdx-license",
    "University of Illinois/NCSA Open Source License",
  ),
  Net_Snmp("Net-SNMP", "http://hl7.org/fhir/spdx-license", "Net-SNMP License"),
  NetCDF("NetCDF", "http://hl7.org/fhir/spdx-license", "NetCDF license"),
  Newsletr("Newsletr", "http://hl7.org/fhir/spdx-license", "Newsletr License"),
  Ngpl("NGPL", "http://hl7.org/fhir/spdx-license", "Nethack General Public License"),
  Nlod_1_0(
    "NLOD-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Norwegian Licence for Open Government Data",
  ),
  Nlpl("NLPL", "http://hl7.org/fhir/spdx-license", "No Limit Public License"),
  Nokia("Nokia", "http://hl7.org/fhir/spdx-license", "Nokia Open Source License"),
  Nosl("NOSL", "http://hl7.org/fhir/spdx-license", "Netizen Open Source License"),
  Noweb("Noweb", "http://hl7.org/fhir/spdx-license", "Noweb License"),
  Npl_1_0("NPL-1.0", "http://hl7.org/fhir/spdx-license", "Netscape Public License v1.0"),
  Npl_1_1("NPL-1.1", "http://hl7.org/fhir/spdx-license", "Netscape Public License v1.1"),
  Nposl_3_0(
    "NPOSL-3.0",
    "http://hl7.org/fhir/spdx-license",
    "Non-Profit Open Software License 3.0",
  ),
  Nrl("NRL", "http://hl7.org/fhir/spdx-license", "NRL License"),
  Ntp("NTP", "http://hl7.org/fhir/spdx-license", "NTP License"),
  Occt_Pl("OCCT-PL", "http://hl7.org/fhir/spdx-license", "Open CASCADE Technology Public License"),
  Oclc_2_0("OCLC-2.0", "http://hl7.org/fhir/spdx-license", "OCLC Research Public License 2.0"),
  ODbL_1_0("ODbL-1.0", "http://hl7.org/fhir/spdx-license", "ODC Open Database License v1.0"),
  Ofl_1_0("OFL-1.0", "http://hl7.org/fhir/spdx-license", "SIL Open Font License 1.0"),
  Ofl_1_1("OFL-1.1", "http://hl7.org/fhir/spdx-license", "SIL Open Font License 1.1"),
  Ogtsl("OGTSL", "http://hl7.org/fhir/spdx-license", "Open Group Test Suite License"),
  Oldap_1_1("OLDAP-1.1", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v1.1"),
  Oldap_1_2("OLDAP-1.2", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v1.2"),
  Oldap_1_3("OLDAP-1.3", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v1.3"),
  Oldap_1_4("OLDAP-1.4", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v1.4"),
  Oldap_2_0_1("OLDAP-2.0.1", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.0.1"),
  Oldap_2_0(
    "OLDAP-2.0",
    "http://hl7.org/fhir/spdx-license",
    "Open LDAP Public License v2.0 (or possibly 2.0A and 2.0B)",
  ),
  Oldap_2_1("OLDAP-2.1", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.1"),
  Oldap_2_2_1("OLDAP-2.2.1", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.2.1"),
  Oldap_2_2_2("OLDAP-2.2.2", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License 2.2.2"),
  Oldap_2_2("OLDAP-2.2", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.2"),
  Oldap_2_3("OLDAP-2.3", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.3"),
  Oldap_2_4("OLDAP-2.4", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.4"),
  Oldap_2_5("OLDAP-2.5", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.5"),
  Oldap_2_6("OLDAP-2.6", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.6"),
  Oldap_2_7("OLDAP-2.7", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.7"),
  Oldap_2_8("OLDAP-2.8", "http://hl7.org/fhir/spdx-license", "Open LDAP Public License v2.8"),
  Oml("OML", "http://hl7.org/fhir/spdx-license", "Open Market License"),
  OpenSSL("OpenSSL", "http://hl7.org/fhir/spdx-license", "OpenSSL License"),
  Opl_1_0("OPL-1.0", "http://hl7.org/fhir/spdx-license", "Open Public License v1.0"),
  Oset_Pl_2_1("OSET-PL-2.1", "http://hl7.org/fhir/spdx-license", "OSET Public License version 2.1"),
  Osl_1_0("OSL-1.0", "http://hl7.org/fhir/spdx-license", "Open Software License 1.0"),
  Osl_1_1("OSL-1.1", "http://hl7.org/fhir/spdx-license", "Open Software License 1.1"),
  Osl_2_0("OSL-2.0", "http://hl7.org/fhir/spdx-license", "Open Software License 2.0"),
  Osl_2_1("OSL-2.1", "http://hl7.org/fhir/spdx-license", "Open Software License 2.1"),
  Osl_3_0("OSL-3.0", "http://hl7.org/fhir/spdx-license", "Open Software License 3.0"),
  Pddl_1_0(
    "PDDL-1.0",
    "http://hl7.org/fhir/spdx-license",
    "ODC Public Domain Dedication & License 1.0",
  ),
  Php_3_0("PHP-3.0", "http://hl7.org/fhir/spdx-license", "PHP License v3.0"),
  Php_3_01("PHP-3.01", "http://hl7.org/fhir/spdx-license", "PHP License v3.01"),
  Plexus("Plexus", "http://hl7.org/fhir/spdx-license", "Plexus Classworlds License"),
  PostgreSQL("PostgreSQL", "http://hl7.org/fhir/spdx-license", "PostgreSQL License"),
  Psfrag("psfrag", "http://hl7.org/fhir/spdx-license", "psfrag License"),
  Psutils("psutils", "http://hl7.org/fhir/spdx-license", "psutils License"),
  Python_2_0("Python-2.0", "http://hl7.org/fhir/spdx-license", "Python License 2.0"),
  Qhull("Qhull", "http://hl7.org/fhir/spdx-license", "Qhull License"),
  Qpl_1_0("QPL-1.0", "http://hl7.org/fhir/spdx-license", "Q Public License 1.0"),
  Rdisc("Rdisc", "http://hl7.org/fhir/spdx-license", "Rdisc License"),
  RHeCos_1_1("RHeCos-1.1", "http://hl7.org/fhir/spdx-license", "Red Hat eCos Public License v1.1"),
  Rpl_1_1("RPL-1.1", "http://hl7.org/fhir/spdx-license", "Reciprocal Public License 1.1"),
  Rpl_1_5("RPL-1.5", "http://hl7.org/fhir/spdx-license", "Reciprocal Public License 1.5"),
  Rpsl_1_0(
    "RPSL-1.0",
    "http://hl7.org/fhir/spdx-license",
    "RealNetworks Public Source License v1.0",
  ),
  Rsa_Md("RSA-MD", "http://hl7.org/fhir/spdx-license", "RSA Message-Digest License"),
  Rscpl("RSCPL", "http://hl7.org/fhir/spdx-license", "Ricoh Source Code Public License"),
  Ruby("Ruby", "http://hl7.org/fhir/spdx-license", "Ruby License"),
  Sax_Pd("SAX-PD", "http://hl7.org/fhir/spdx-license", "Sax Public Domain Notice"),
  Saxpath("Saxpath", "http://hl7.org/fhir/spdx-license", "Saxpath License"),
  Scea("SCEA", "http://hl7.org/fhir/spdx-license", "SCEA Shared Source License"),
  Sendmail("Sendmail", "http://hl7.org/fhir/spdx-license", "Sendmail License"),
  Sgi_B_1_0("SGI-B-1.0", "http://hl7.org/fhir/spdx-license", "SGI Free Software License B v1.0"),
  Sgi_B_1_1("SGI-B-1.1", "http://hl7.org/fhir/spdx-license", "SGI Free Software License B v1.1"),
  Sgi_B_2_0("SGI-B-2.0", "http://hl7.org/fhir/spdx-license", "SGI Free Software License B v2.0"),
  SimPL_2_0("SimPL-2.0", "http://hl7.org/fhir/spdx-license", "Simple Public License 2.0"),
  Sissl_1_2(
    "SISSL-1.2",
    "http://hl7.org/fhir/spdx-license",
    "Sun Industry Standards Source License v1.2",
  ),
  Sissl("SISSL", "http://hl7.org/fhir/spdx-license", "Sun Industry Standards Source License v1.1"),
  Sleepycat("Sleepycat", "http://hl7.org/fhir/spdx-license", "Sleepycat License"),
  Smlnj("SMLNJ", "http://hl7.org/fhir/spdx-license", "Standard ML of New Jersey License"),
  Smppl("SMPPL", "http://hl7.org/fhir/spdx-license", "Secure Messaging Protocol Public License"),
  Snia("SNIA", "http://hl7.org/fhir/spdx-license", "SNIA Public License 1.1"),
  Spencer_86("Spencer-86", "http://hl7.org/fhir/spdx-license", "Spencer License 86"),
  Spencer_94("Spencer-94", "http://hl7.org/fhir/spdx-license", "Spencer License 94"),
  Spencer_99("Spencer-99", "http://hl7.org/fhir/spdx-license", "Spencer License 99"),
  Spl_1_0("SPL-1.0", "http://hl7.org/fhir/spdx-license", "Sun Public License v1.0"),
  SugarCRM_1_1_3(
    "SugarCRM-1.1.3",
    "http://hl7.org/fhir/spdx-license",
    "SugarCRM Public License v1.1.3",
  ),
  Swl(
    "SWL",
    "http://hl7.org/fhir/spdx-license",
    "Scheme Widget Library (SWL) Software License Agreement",
  ),
  Tcl("TCL", "http://hl7.org/fhir/spdx-license", "TCL/TK License"),
  Tcp_Wrappers("TCP-wrappers", "http://hl7.org/fhir/spdx-license", "TCP Wrappers License"),
  TMate("TMate", "http://hl7.org/fhir/spdx-license", "TMate Open Source License"),
  Torque_1_1(
    "TORQUE-1.1",
    "http://hl7.org/fhir/spdx-license",
    "TORQUE v2.5+ Software License v1.1",
  ),
  Tosl("TOSL", "http://hl7.org/fhir/spdx-license", "Trusster Open Source License"),
  Unicode_Dfs_2015(
    "Unicode-DFS-2015",
    "http://hl7.org/fhir/spdx-license",
    "Unicode License Agreement - Data Files and Software (2015)",
  ),
  Unicode_Dfs_2016(
    "Unicode-DFS-2016",
    "http://hl7.org/fhir/spdx-license",
    "Unicode License Agreement - Data Files and Software (2016)",
  ),
  Unicode_Tou("Unicode-TOU", "http://hl7.org/fhir/spdx-license", "Unicode Terms of Use"),
  Unlicense("Unlicense", "http://hl7.org/fhir/spdx-license", "The Unlicense"),
  Upl_1_0("UPL-1.0", "http://hl7.org/fhir/spdx-license", "Universal Permissive License v1.0"),
  Vim("Vim", "http://hl7.org/fhir/spdx-license", "Vim License"),
  Vostrom("VOSTROM", "http://hl7.org/fhir/spdx-license", "VOSTROM Public License for Open Source"),
  Vsl_1_0("VSL-1.0", "http://hl7.org/fhir/spdx-license", "Vovida Software License v1.0"),
  W3C_19980720(
    "W3C-19980720",
    "http://hl7.org/fhir/spdx-license",
    "W3C Software Notice and License (1998-07-20)",
  ),
  W3C_20150513(
    "W3C-20150513",
    "http://hl7.org/fhir/spdx-license",
    "W3C Software Notice and Document License (2015-05-13)",
  ),
  W3C("W3C", "http://hl7.org/fhir/spdx-license", "W3C Software Notice and License (2002-12-31)"),
  Watcom_1_0(
    "Watcom-1.0",
    "http://hl7.org/fhir/spdx-license",
    "Sybase Open Watcom Public License 1.0",
  ),
  Wsuipa("Wsuipa", "http://hl7.org/fhir/spdx-license", "Wsuipa License"),
  Wtfpl("WTFPL", "http://hl7.org/fhir/spdx-license", "Do What The F*ck You Want To Public License"),
  X11("X11", "http://hl7.org/fhir/spdx-license", "X11 License"),
  Xerox("Xerox", "http://hl7.org/fhir/spdx-license", "Xerox License"),
  XFree86_1_1("XFree86-1.1", "http://hl7.org/fhir/spdx-license", "XFree86 License 1.1"),
  Xinetd("xinetd", "http://hl7.org/fhir/spdx-license", "xinetd License"),
  Xnet("Xnet", "http://hl7.org/fhir/spdx-license", "X.Net License"),
  Xpp("xpp", "http://hl7.org/fhir/spdx-license", "XPP License"),
  XSkat("XSkat", "http://hl7.org/fhir/spdx-license", "XSkat License"),
  Ypl_1_0("YPL-1.0", "http://hl7.org/fhir/spdx-license", "Yahoo! Public License v1.0"),
  Ypl_1_1("YPL-1.1", "http://hl7.org/fhir/spdx-license", "Yahoo! Public License v1.1"),
  Zed("Zed", "http://hl7.org/fhir/spdx-license", "Zed License"),
  Zend_2_0("Zend-2.0", "http://hl7.org/fhir/spdx-license", "Zend License v2.0"),
  Zimbra_1_3("Zimbra-1.3", "http://hl7.org/fhir/spdx-license", "Zimbra Public License v1.3"),
  Zimbra_1_4("Zimbra-1.4", "http://hl7.org/fhir/spdx-license", "Zimbra Public License v1.4"),
  Zlib_Acknowledgement(
    "zlib-acknowledgement",
    "http://hl7.org/fhir/spdx-license",
    "zlib/libpng License with Acknowledgement",
  ),
  Zlib("Zlib", "http://hl7.org/fhir/spdx-license", "zlib License"),
  Zpl_1_1("ZPL-1.1", "http://hl7.org/fhir/spdx-license", "Zope Public License 1.1"),
  Zpl_2_0("ZPL-2.0", "http://hl7.org/fhir/spdx-license", "Zope Public License 2.0"),
  Zpl_2_1("ZPL-2.1", "http://hl7.org/fhir/spdx-license", "Zope Public License 2.1");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SPDXLicense =
      when (code) {
        "not-open-source" -> Not_Open_Source
        "0BSD" -> _0BSD
        "AAL" -> Aal
        "Abstyles" -> Abstyles
        "Adobe-2006" -> Adobe_2006
        "Adobe-Glyph" -> Adobe_Glyph
        "ADSL" -> Adsl
        "AFL-1.1" -> Afl_1_1
        "AFL-1.2" -> Afl_1_2
        "AFL-2.0" -> Afl_2_0
        "AFL-2.1" -> Afl_2_1
        "AFL-3.0" -> Afl_3_0
        "Afmparse" -> Afmparse
        "AGPL-1.0-only" -> Agpl_1_0_Only
        "AGPL-1.0-or-later" -> Agpl_1_0_Or_Later
        "AGPL-3.0-only" -> Agpl_3_0_Only
        "AGPL-3.0-or-later" -> Agpl_3_0_Or_Later
        "Aladdin" -> Aladdin
        "AMDPLPA" -> Amdplpa
        "AML" -> Aml
        "AMPAS" -> Ampas
        "ANTLR-PD" -> Antlr_Pd
        "Apache-1.0" -> Apache_1_0
        "Apache-1.1" -> Apache_1_1
        "Apache-2.0" -> Apache_2_0
        "APAFML" -> Apafml
        "APL-1.0" -> Apl_1_0
        "APSL-1.0" -> Apsl_1_0
        "APSL-1.1" -> Apsl_1_1
        "APSL-1.2" -> Apsl_1_2
        "APSL-2.0" -> Apsl_2_0
        "Artistic-1.0-cl8" -> Artistic_1_0_Cl8
        "Artistic-1.0-Perl" -> Artistic_1_0_Perl
        "Artistic-1.0" -> Artistic_1_0
        "Artistic-2.0" -> Artistic_2_0
        "Bahyph" -> Bahyph
        "Barr" -> Barr
        "Beerware" -> Beerware
        "BitTorrent-1.0" -> BitTorrent_1_0
        "BitTorrent-1.1" -> BitTorrent_1_1
        "Borceux" -> Borceux
        "BSD-1-Clause" -> Bsd_1_Clause
        "BSD-2-Clause-FreeBSD" -> Bsd_2_Clause_FreeBSD
        "BSD-2-Clause-NetBSD" -> Bsd_2_Clause_NetBSD
        "BSD-2-Clause-Patent" -> Bsd_2_Clause_Patent
        "BSD-2-Clause" -> Bsd_2_Clause
        "BSD-3-Clause-Attribution" -> Bsd_3_Clause_Attribution
        "BSD-3-Clause-Clear" -> Bsd_3_Clause_Clear
        "BSD-3-Clause-LBNL" -> Bsd_3_Clause_Lbnl
        "BSD-3-Clause-No-Nuclear-License-2014" -> Bsd_3_Clause_No_Nuclear_License_2014
        "BSD-3-Clause-No-Nuclear-License" -> Bsd_3_Clause_No_Nuclear_License
        "BSD-3-Clause-No-Nuclear-Warranty" -> Bsd_3_Clause_No_Nuclear_Warranty
        "BSD-3-Clause" -> Bsd_3_Clause
        "BSD-4-Clause-UC" -> Bsd_4_Clause_Uc
        "BSD-4-Clause" -> Bsd_4_Clause
        "BSD-Protection" -> Bsd_Protection
        "BSD-Source-Code" -> Bsd_Source_Code
        "BSL-1.0" -> Bsl_1_0
        "bzip2-1.0.5" -> Bzip2_1_0_5
        "bzip2-1.0.6" -> Bzip2_1_0_6
        "Caldera" -> Caldera
        "CATOSL-1.1" -> Catosl_1_1
        "CC-BY-1.0" -> Cc_By_1_0
        "CC-BY-2.0" -> Cc_By_2_0
        "CC-BY-2.5" -> Cc_By_2_5
        "CC-BY-3.0" -> Cc_By_3_0
        "CC-BY-4.0" -> Cc_By_4_0
        "CC-BY-NC-1.0" -> Cc_By_Nc_1_0
        "CC-BY-NC-2.0" -> Cc_By_Nc_2_0
        "CC-BY-NC-2.5" -> Cc_By_Nc_2_5
        "CC-BY-NC-3.0" -> Cc_By_Nc_3_0
        "CC-BY-NC-4.0" -> Cc_By_Nc_4_0
        "CC-BY-NC-ND-1.0" -> Cc_By_Nc_Nd_1_0
        "CC-BY-NC-ND-2.0" -> Cc_By_Nc_Nd_2_0
        "CC-BY-NC-ND-2.5" -> Cc_By_Nc_Nd_2_5
        "CC-BY-NC-ND-3.0" -> Cc_By_Nc_Nd_3_0
        "CC-BY-NC-ND-4.0" -> Cc_By_Nc_Nd_4_0
        "CC-BY-NC-SA-1.0" -> Cc_By_Nc_Sa_1_0
        "CC-BY-NC-SA-2.0" -> Cc_By_Nc_Sa_2_0
        "CC-BY-NC-SA-2.5" -> Cc_By_Nc_Sa_2_5
        "CC-BY-NC-SA-3.0" -> Cc_By_Nc_Sa_3_0
        "CC-BY-NC-SA-4.0" -> Cc_By_Nc_Sa_4_0
        "CC-BY-ND-1.0" -> Cc_By_Nd_1_0
        "CC-BY-ND-2.0" -> Cc_By_Nd_2_0
        "CC-BY-ND-2.5" -> Cc_By_Nd_2_5
        "CC-BY-ND-3.0" -> Cc_By_Nd_3_0
        "CC-BY-ND-4.0" -> Cc_By_Nd_4_0
        "CC-BY-SA-1.0" -> Cc_By_Sa_1_0
        "CC-BY-SA-2.0" -> Cc_By_Sa_2_0
        "CC-BY-SA-2.5" -> Cc_By_Sa_2_5
        "CC-BY-SA-3.0" -> Cc_By_Sa_3_0
        "CC-BY-SA-4.0" -> Cc_By_Sa_4_0
        "CC0-1.0" -> CC0_1_0
        "CDDL-1.0" -> Cddl_1_0
        "CDDL-1.1" -> Cddl_1_1
        "CDLA-Permissive-1.0" -> Cdla_Permissive_1_0
        "CDLA-Sharing-1.0" -> Cdla_Sharing_1_0
        "CECILL-1.0" -> Cecill_1_0
        "CECILL-1.1" -> Cecill_1_1
        "CECILL-2.0" -> Cecill_2_0
        "CECILL-2.1" -> Cecill_2_1
        "CECILL-B" -> Cecill_B
        "CECILL-C" -> Cecill_C
        "ClArtistic" -> ClArtistic
        "CNRI-Jython" -> Cnri_Jython
        "CNRI-Python-GPL-Compatible" -> Cnri_Python_Gpl_Compatible
        "CNRI-Python" -> Cnri_Python
        "Condor-1.1" -> Condor_1_1
        "CPAL-1.0" -> Cpal_1_0
        "CPL-1.0" -> Cpl_1_0
        "CPOL-1.02" -> Cpol_1_02
        "Crossword" -> Crossword
        "CrystalStacker" -> CrystalStacker
        "CUA-OPL-1.0" -> Cua_Opl_1_0
        "Cube" -> Cube
        "curl" -> Curl
        "D-FSL-1.0" -> D_Fsl_1_0
        "diffmark" -> Diffmark
        "DOC" -> Doc
        "Dotseqn" -> Dotseqn
        "DSDP" -> Dsdp
        "dvipdfm" -> Dvipdfm
        "ECL-1.0" -> Ecl_1_0
        "ECL-2.0" -> Ecl_2_0
        "EFL-1.0" -> Efl_1_0
        "EFL-2.0" -> Efl_2_0
        "eGenix" -> EGenix
        "Entessa" -> Entessa
        "EPL-1.0" -> Epl_1_0
        "EPL-2.0" -> Epl_2_0
        "ErlPL-1.1" -> ErlPL_1_1
        "EUDatagrid" -> EUDatagrid
        "EUPL-1.0" -> Eupl_1_0
        "EUPL-1.1" -> Eupl_1_1
        "EUPL-1.2" -> Eupl_1_2
        "Eurosym" -> Eurosym
        "Fair" -> Fair
        "Frameworx-1.0" -> Frameworx_1_0
        "FreeImage" -> FreeImage
        "FSFAP" -> Fsfap
        "FSFUL" -> Fsful
        "FSFULLR" -> Fsfullr
        "FTL" -> Ftl
        "GFDL-1.1-only" -> Gfdl_1_1_Only
        "GFDL-1.1-or-later" -> Gfdl_1_1_Or_Later
        "GFDL-1.2-only" -> Gfdl_1_2_Only
        "GFDL-1.2-or-later" -> Gfdl_1_2_Or_Later
        "GFDL-1.3-only" -> Gfdl_1_3_Only
        "GFDL-1.3-or-later" -> Gfdl_1_3_Or_Later
        "Giftware" -> Giftware
        "GL2PS" -> GL2PS
        "Glide" -> Glide
        "Glulxe" -> Glulxe
        "gnuplot" -> Gnuplot
        "GPL-1.0-only" -> Gpl_1_0_Only
        "GPL-1.0-or-later" -> Gpl_1_0_Or_Later
        "GPL-2.0-only" -> Gpl_2_0_Only
        "GPL-2.0-or-later" -> Gpl_2_0_Or_Later
        "GPL-3.0-only" -> Gpl_3_0_Only
        "GPL-3.0-or-later" -> Gpl_3_0_Or_Later
        "gSOAP-1.3b" -> GSOAP_1_3b
        "HaskellReport" -> HaskellReport
        "HPND" -> Hpnd
        "IBM-pibs" -> Ibm_Pibs
        "ICU" -> Icu
        "IJG" -> Ijg
        "ImageMagick" -> ImageMagick
        "iMatix" -> IMatix
        "Imlib2" -> Imlib2
        "Info-ZIP" -> Info_Zip
        "Intel-ACPI" -> Intel_Acpi
        "Intel" -> Intel
        "Interbase-1.0" -> Interbase_1_0
        "IPA" -> Ipa
        "IPL-1.0" -> Ipl_1_0
        "ISC" -> Isc
        "JasPer-2.0" -> JasPer_2_0
        "JSON" -> Json
        "LAL-1.2" -> Lal_1_2
        "LAL-1.3" -> Lal_1_3
        "Latex2e" -> Latex2e
        "Leptonica" -> Leptonica
        "LGPL-2.0-only" -> Lgpl_2_0_Only
        "LGPL-2.0-or-later" -> Lgpl_2_0_Or_Later
        "LGPL-2.1-only" -> Lgpl_2_1_Only
        "LGPL-2.1-or-later" -> Lgpl_2_1_Or_Later
        "LGPL-3.0-only" -> Lgpl_3_0_Only
        "LGPL-3.0-or-later" -> Lgpl_3_0_Or_Later
        "LGPLLR" -> Lgpllr
        "Libpng" -> Libpng
        "libtiff" -> Libtiff
        "LiLiQ-P-1.1" -> LiLiQ_P_1_1
        "LiLiQ-R-1.1" -> LiLiQ_R_1_1
        "LiLiQ-Rplus-1.1" -> LiLiQ_Rplus_1_1
        "Linux-OpenIB" -> Linux_OpenIB
        "LPL-1.0" -> Lpl_1_0
        "LPL-1.02" -> Lpl_1_02
        "LPPL-1.0" -> Lppl_1_0
        "LPPL-1.1" -> Lppl_1_1
        "LPPL-1.2" -> Lppl_1_2
        "LPPL-1.3a" -> Lppl_1_3a
        "LPPL-1.3c" -> Lppl_1_3c
        "MakeIndex" -> MakeIndex
        "MirOS" -> MirOS
        "MIT-0" -> Mit_0
        "MIT-advertising" -> Mit_Advertising
        "MIT-CMU" -> Mit_Cmu
        "MIT-enna" -> Mit_Enna
        "MIT-feh" -> Mit_Feh
        "MIT" -> Mit
        "MITNFA" -> Mitnfa
        "Motosoto" -> Motosoto
        "mpich2" -> Mpich2
        "MPL-1.0" -> Mpl_1_0
        "MPL-1.1" -> Mpl_1_1
        "MPL-2.0-no-copyleft-exception" -> Mpl_2_0_No_Copyleft_Exception
        "MPL-2.0" -> Mpl_2_0
        "MS-PL" -> Ms_Pl
        "MS-RL" -> Ms_Rl
        "MTLL" -> Mtll
        "Multics" -> Multics
        "Mup" -> Mup
        "NASA-1.3" -> Nasa_1_3
        "Naumen" -> Naumen
        "NBPL-1.0" -> Nbpl_1_0
        "NCSA" -> Ncsa
        "Net-SNMP" -> Net_Snmp
        "NetCDF" -> NetCDF
        "Newsletr" -> Newsletr
        "NGPL" -> Ngpl
        "NLOD-1.0" -> Nlod_1_0
        "NLPL" -> Nlpl
        "Nokia" -> Nokia
        "NOSL" -> Nosl
        "Noweb" -> Noweb
        "NPL-1.0" -> Npl_1_0
        "NPL-1.1" -> Npl_1_1
        "NPOSL-3.0" -> Nposl_3_0
        "NRL" -> Nrl
        "NTP" -> Ntp
        "OCCT-PL" -> Occt_Pl
        "OCLC-2.0" -> Oclc_2_0
        "ODbL-1.0" -> ODbL_1_0
        "OFL-1.0" -> Ofl_1_0
        "OFL-1.1" -> Ofl_1_1
        "OGTSL" -> Ogtsl
        "OLDAP-1.1" -> Oldap_1_1
        "OLDAP-1.2" -> Oldap_1_2
        "OLDAP-1.3" -> Oldap_1_3
        "OLDAP-1.4" -> Oldap_1_4
        "OLDAP-2.0.1" -> Oldap_2_0_1
        "OLDAP-2.0" -> Oldap_2_0
        "OLDAP-2.1" -> Oldap_2_1
        "OLDAP-2.2.1" -> Oldap_2_2_1
        "OLDAP-2.2.2" -> Oldap_2_2_2
        "OLDAP-2.2" -> Oldap_2_2
        "OLDAP-2.3" -> Oldap_2_3
        "OLDAP-2.4" -> Oldap_2_4
        "OLDAP-2.5" -> Oldap_2_5
        "OLDAP-2.6" -> Oldap_2_6
        "OLDAP-2.7" -> Oldap_2_7
        "OLDAP-2.8" -> Oldap_2_8
        "OML" -> Oml
        "OpenSSL" -> OpenSSL
        "OPL-1.0" -> Opl_1_0
        "OSET-PL-2.1" -> Oset_Pl_2_1
        "OSL-1.0" -> Osl_1_0
        "OSL-1.1" -> Osl_1_1
        "OSL-2.0" -> Osl_2_0
        "OSL-2.1" -> Osl_2_1
        "OSL-3.0" -> Osl_3_0
        "PDDL-1.0" -> Pddl_1_0
        "PHP-3.0" -> Php_3_0
        "PHP-3.01" -> Php_3_01
        "Plexus" -> Plexus
        "PostgreSQL" -> PostgreSQL
        "psfrag" -> Psfrag
        "psutils" -> Psutils
        "Python-2.0" -> Python_2_0
        "Qhull" -> Qhull
        "QPL-1.0" -> Qpl_1_0
        "Rdisc" -> Rdisc
        "RHeCos-1.1" -> RHeCos_1_1
        "RPL-1.1" -> Rpl_1_1
        "RPL-1.5" -> Rpl_1_5
        "RPSL-1.0" -> Rpsl_1_0
        "RSA-MD" -> Rsa_Md
        "RSCPL" -> Rscpl
        "Ruby" -> Ruby
        "SAX-PD" -> Sax_Pd
        "Saxpath" -> Saxpath
        "SCEA" -> Scea
        "Sendmail" -> Sendmail
        "SGI-B-1.0" -> Sgi_B_1_0
        "SGI-B-1.1" -> Sgi_B_1_1
        "SGI-B-2.0" -> Sgi_B_2_0
        "SimPL-2.0" -> SimPL_2_0
        "SISSL-1.2" -> Sissl_1_2
        "SISSL" -> Sissl
        "Sleepycat" -> Sleepycat
        "SMLNJ" -> Smlnj
        "SMPPL" -> Smppl
        "SNIA" -> Snia
        "Spencer-86" -> Spencer_86
        "Spencer-94" -> Spencer_94
        "Spencer-99" -> Spencer_99
        "SPL-1.0" -> Spl_1_0
        "SugarCRM-1.1.3" -> SugarCRM_1_1_3
        "SWL" -> Swl
        "TCL" -> Tcl
        "TCP-wrappers" -> Tcp_Wrappers
        "TMate" -> TMate
        "TORQUE-1.1" -> Torque_1_1
        "TOSL" -> Tosl
        "Unicode-DFS-2015" -> Unicode_Dfs_2015
        "Unicode-DFS-2016" -> Unicode_Dfs_2016
        "Unicode-TOU" -> Unicode_Tou
        "Unlicense" -> Unlicense
        "UPL-1.0" -> Upl_1_0
        "Vim" -> Vim
        "VOSTROM" -> Vostrom
        "VSL-1.0" -> Vsl_1_0
        "W3C-19980720" -> W3C_19980720
        "W3C-20150513" -> W3C_20150513
        "W3C" -> W3C
        "Watcom-1.0" -> Watcom_1_0
        "Wsuipa" -> Wsuipa
        "WTFPL" -> Wtfpl
        "X11" -> X11
        "Xerox" -> Xerox
        "XFree86-1.1" -> XFree86_1_1
        "xinetd" -> Xinetd
        "Xnet" -> Xnet
        "xpp" -> Xpp
        "XSkat" -> XSkat
        "YPL-1.0" -> Ypl_1_0
        "YPL-1.1" -> Ypl_1_1
        "Zed" -> Zed
        "Zend-2.0" -> Zend_2_0
        "Zimbra-1.3" -> Zimbra_1_3
        "Zimbra-1.4" -> Zimbra_1_4
        "zlib-acknowledgement" -> Zlib_Acknowledgement
        "Zlib" -> Zlib
        "ZPL-1.1" -> Zpl_1_1
        "ZPL-2.0" -> Zpl_2_0
        "ZPL-2.1" -> Zpl_2_1
        else -> throw IllegalArgumentException("Unknown code $code for enum SPDXLicense")
      }
  }
}

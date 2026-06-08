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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Resource
import kotlin.collections.List

/**
 * Extracts the values for [param] from this resource. Equivalent to `param.extractFrom(this)`, but
 * reads more fluently at the call site (e.g. `patient.extract(PatientSearchParams.birthdate)`).
 */
public inline fun <R : Resource, T> R.extract(`param`: SearchParam<R, T>): List<T> =
  param.extractFrom(this)

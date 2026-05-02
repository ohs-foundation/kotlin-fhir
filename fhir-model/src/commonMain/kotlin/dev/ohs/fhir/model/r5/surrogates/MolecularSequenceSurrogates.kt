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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Attachment
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Integer
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.MolecularSequence
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Range
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class MolecularSequenceRelativeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var coordinateSystem: CodeableConcept,
  public var ordinalPosition: Int? = null,
  public var _ordinalPosition: Element? = null,
  public var sequenceRange: Range? = null,
  public var startingSequence: MolecularSequence.Relative.StartingSequence? = null,
  public var edit: List<MolecularSequence.Relative.Edit>? = null,
) {
  public fun toModel(): MolecularSequence.Relative =
    MolecularSequence.Relative(
      id = this@MolecularSequenceRelativeSurrogate.id,
      extension = this@MolecularSequenceRelativeSurrogate.extension ?: listOf(),
      modifierExtension = this@MolecularSequenceRelativeSurrogate.modifierExtension ?: listOf(),
      coordinateSystem = this@MolecularSequenceRelativeSurrogate.coordinateSystem,
      ordinalPosition =
        Integer.of(
          this@MolecularSequenceRelativeSurrogate.ordinalPosition,
          this@MolecularSequenceRelativeSurrogate._ordinalPosition,
        ),
      sequenceRange = this@MolecularSequenceRelativeSurrogate.sequenceRange,
      startingSequence = this@MolecularSequenceRelativeSurrogate.startingSequence,
      edit = this@MolecularSequenceRelativeSurrogate.edit ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MolecularSequence.Relative): MolecularSequenceRelativeSurrogate =
      with(model) {
        MolecularSequenceRelativeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          coordinateSystem = this@with.coordinateSystem,
          ordinalPosition = this@with.ordinalPosition?.value,
          _ordinalPosition = this@with.ordinalPosition?.toElement(),
          sequenceRange = this@with.sequenceRange,
          startingSequence = this@with.startingSequence,
          edit = this@with.edit.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class MolecularSequenceRelativeStartingSequenceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var genomeAssembly: CodeableConcept? = null,
  public var chromosome: CodeableConcept? = null,
  public var sequence: MolecularSequence.Relative.StartingSequence.Sequence? = null,
  public var windowStart: Int? = null,
  public var _windowStart: Element? = null,
  public var windowEnd: Int? = null,
  public var _windowEnd: Element? = null,
  public var orientation: KotlinString? = null,
  public var _orientation: Element? = null,
  public var strand: KotlinString? = null,
  public var _strand: Element? = null,
) {
  public fun toModel(): MolecularSequence.Relative.StartingSequence =
    MolecularSequence.Relative.StartingSequence(
      id = this@MolecularSequenceRelativeStartingSequenceSurrogate.id,
      extension = this@MolecularSequenceRelativeStartingSequenceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@MolecularSequenceRelativeStartingSequenceSurrogate.modifierExtension ?: listOf(),
      genomeAssembly = this@MolecularSequenceRelativeStartingSequenceSurrogate.genomeAssembly,
      chromosome = this@MolecularSequenceRelativeStartingSequenceSurrogate.chromosome,
      sequence = this@MolecularSequenceRelativeStartingSequenceSurrogate.sequence,
      windowStart =
        Integer.of(
          this@MolecularSequenceRelativeStartingSequenceSurrogate.windowStart,
          this@MolecularSequenceRelativeStartingSequenceSurrogate._windowStart,
        ),
      windowEnd =
        Integer.of(
          this@MolecularSequenceRelativeStartingSequenceSurrogate.windowEnd,
          this@MolecularSequenceRelativeStartingSequenceSurrogate._windowEnd,
        ),
      orientation =
        this@MolecularSequenceRelativeStartingSequenceSurrogate.orientation?.let {
          Enumeration.of(
            MolecularSequence.OrientationType.fromCode(it),
            this@MolecularSequenceRelativeStartingSequenceSurrogate._orientation,
          )
        },
      strand =
        this@MolecularSequenceRelativeStartingSequenceSurrogate.strand?.let {
          Enumeration.of(
            MolecularSequence.StrandType.fromCode(it),
            this@MolecularSequenceRelativeStartingSequenceSurrogate._strand,
          )
        },
    )

  public companion object {
    public fun fromModel(
      model: MolecularSequence.Relative.StartingSequence
    ): MolecularSequenceRelativeStartingSequenceSurrogate =
      with(model) {
        MolecularSequenceRelativeStartingSequenceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          genomeAssembly = this@with.genomeAssembly,
          chromosome = this@with.chromosome,
          sequence = this@with.sequence,
          windowStart = this@with.windowStart?.value,
          _windowStart = this@with.windowStart?.toElement(),
          windowEnd = this@with.windowEnd?.value,
          _windowEnd = this@with.windowEnd?.toElement(),
          orientation = this@with.orientation?.value?.getCode(),
          _orientation = this@with.orientation?.toElement(),
          strand = this@with.strand?.value?.getCode(),
          _strand = this@with.strand?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MolecularSequenceRelativeEditSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var start: Int? = null,
  public var _start: Element? = null,
  public var end: Int? = null,
  public var _end: Element? = null,
  public var replacementSequence: KotlinString? = null,
  public var _replacementSequence: Element? = null,
  public var replacedSequence: KotlinString? = null,
  public var _replacedSequence: Element? = null,
) {
  public fun toModel(): MolecularSequence.Relative.Edit =
    MolecularSequence.Relative.Edit(
      id = this@MolecularSequenceRelativeEditSurrogate.id,
      extension = this@MolecularSequenceRelativeEditSurrogate.extension ?: listOf(),
      modifierExtension = this@MolecularSequenceRelativeEditSurrogate.modifierExtension ?: listOf(),
      start =
        Integer.of(
          this@MolecularSequenceRelativeEditSurrogate.start,
          this@MolecularSequenceRelativeEditSurrogate._start,
        ),
      end =
        Integer.of(
          this@MolecularSequenceRelativeEditSurrogate.end,
          this@MolecularSequenceRelativeEditSurrogate._end,
        ),
      replacementSequence =
        R5String.of(
          this@MolecularSequenceRelativeEditSurrogate.replacementSequence,
          this@MolecularSequenceRelativeEditSurrogate._replacementSequence,
        ),
      replacedSequence =
        R5String.of(
          this@MolecularSequenceRelativeEditSurrogate.replacedSequence,
          this@MolecularSequenceRelativeEditSurrogate._replacedSequence,
        ),
    )

  public companion object {
    public fun fromModel(
      model: MolecularSequence.Relative.Edit
    ): MolecularSequenceRelativeEditSurrogate =
      with(model) {
        MolecularSequenceRelativeEditSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          start = this@with.start?.value,
          _start = this@with.start?.toElement(),
          end = this@with.end?.value,
          _end = this@with.end?.toElement(),
          replacementSequence = this@with.replacementSequence?.value,
          _replacementSequence = this@with.replacementSequence?.toElement(),
          replacedSequence = this@with.replacedSequence?.value,
          _replacedSequence = this@with.replacedSequence?.toElement(),
        )
      }
  }
}

@Serializable
internal data class MolecularSequenceRelativeStartingSequenceSequenceSurrogate(
  public var sequenceCodeableConcept: CodeableConcept? = null,
  public var sequenceString: KotlinString? = null,
  public var _sequenceString: Element? = null,
  public var sequenceReference: Reference? = null,
) {
  public fun toModel(): MolecularSequence.Relative.StartingSequence.Sequence =
    MolecularSequence.Relative.StartingSequence.Sequence.from(
      this@MolecularSequenceRelativeStartingSequenceSequenceSurrogate.sequenceCodeableConcept,
      R5String.of(
        this@MolecularSequenceRelativeStartingSequenceSequenceSurrogate.sequenceString,
        this@MolecularSequenceRelativeStartingSequenceSequenceSurrogate._sequenceString,
      ),
      this@MolecularSequenceRelativeStartingSequenceSequenceSurrogate.sequenceReference,
    )!!

  public companion object {
    public fun fromModel(
      model: MolecularSequence.Relative.StartingSequence.Sequence
    ): MolecularSequenceRelativeStartingSequenceSequenceSurrogate =
      with(model) {
        MolecularSequenceRelativeStartingSequenceSequenceSurrogate(
          sequenceCodeableConcept = this@with.asCodeableConcept()?.value,
          sequenceString = this@with.asString()?.value?.value,
          _sequenceString = this@with.asString()?.value?.toElement(),
          sequenceReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class MolecularSequenceSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var subject: Reference? = null,
  public var focus: List<Reference>? = null,
  public var specimen: Reference? = null,
  public var device: Reference? = null,
  public var performer: Reference? = null,
  public var literal: KotlinString? = null,
  public var _literal: Element? = null,
  public var formatted: List<Attachment>? = null,
  public var relative: List<MolecularSequence.Relative>? = null,
) {
  public fun toModel(): MolecularSequence =
    MolecularSequence(
      id = this@MolecularSequenceSurrogate.id,
      meta = this@MolecularSequenceSurrogate.meta,
      implicitRules =
        Uri.of(
          this@MolecularSequenceSurrogate.implicitRules,
          this@MolecularSequenceSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@MolecularSequenceSurrogate.language,
          this@MolecularSequenceSurrogate._language,
        ),
      text = this@MolecularSequenceSurrogate.text,
      contained = this@MolecularSequenceSurrogate.contained ?: listOf(),
      extension = this@MolecularSequenceSurrogate.extension ?: listOf(),
      modifierExtension = this@MolecularSequenceSurrogate.modifierExtension ?: listOf(),
      identifier = this@MolecularSequenceSurrogate.identifier ?: listOf(),
      type =
        this@MolecularSequenceSurrogate.type?.let {
          Enumeration.of(
            MolecularSequence.SequenceType.fromCode(it),
            this@MolecularSequenceSurrogate._type,
          )
        },
      subject = this@MolecularSequenceSurrogate.subject,
      focus = this@MolecularSequenceSurrogate.focus ?: listOf(),
      specimen = this@MolecularSequenceSurrogate.specimen,
      device = this@MolecularSequenceSurrogate.device,
      performer = this@MolecularSequenceSurrogate.performer,
      literal =
        R5String.of(
          this@MolecularSequenceSurrogate.literal,
          this@MolecularSequenceSurrogate._literal,
        ),
      formatted = this@MolecularSequenceSurrogate.formatted ?: listOf(),
      relative = this@MolecularSequenceSurrogate.relative ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: MolecularSequence): MolecularSequenceSurrogate =
      with(model) {
        MolecularSequenceSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          type = this@with.type?.value?.getCode(),
          _type = this@with.type?.toElement(),
          subject = this@with.subject,
          focus = this@with.focus.takeIf { it.isNotEmpty() },
          specimen = this@with.specimen,
          device = this@with.device,
          performer = this@with.performer,
          literal = this@with.literal?.value,
          _literal = this@with.literal?.toElement(),
          formatted = this@with.formatted.takeIf { it.isNotEmpty() },
          relative = this@with.relative.takeIf { it.isNotEmpty() },
        )
      }
  }
}

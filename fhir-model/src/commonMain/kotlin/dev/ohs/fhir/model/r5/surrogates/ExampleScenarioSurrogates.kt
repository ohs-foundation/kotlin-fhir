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

import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Canonical
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.ContactDetail
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.ExampleScenario
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Markdown
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.UsageContext
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ExampleScenarioActorSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var key: KotlinString? = null,
  public var _key: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
) {
  public fun toModel(): ExampleScenario.Actor =
    ExampleScenario.Actor(
      id = this@ExampleScenarioActorSurrogate.id,
      extension = this@ExampleScenarioActorSurrogate.extension ?: listOf(),
      modifierExtension = this@ExampleScenarioActorSurrogate.modifierExtension ?: listOf(),
      key =
        R5String.of(
          this@ExampleScenarioActorSurrogate.key,
          this@ExampleScenarioActorSurrogate._key,
        )!!,
      type =
        Enumeration.of(
          ExampleScenario.ExampleScenarioActorType.fromCode(
            this@ExampleScenarioActorSurrogate.type!!
          ),
          this@ExampleScenarioActorSurrogate._type,
        ),
      title =
        R5String.of(
          this@ExampleScenarioActorSurrogate.title,
          this@ExampleScenarioActorSurrogate._title,
        )!!,
      description =
        Markdown.of(
          this@ExampleScenarioActorSurrogate.description,
          this@ExampleScenarioActorSurrogate._description,
        ),
    )

  public companion object {
    public fun fromModel(model: ExampleScenario.Actor): ExampleScenarioActorSurrogate =
      with(model) {
        ExampleScenarioActorSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          key = this@with.key.value,
          _key = this@with.key.toElement(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          title = this@with.title.value,
          _title = this@with.title.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioInstanceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var key: KotlinString? = null,
  public var _key: Element? = null,
  public var structureType: Coding,
  public var structureVersion: KotlinString? = null,
  public var _structureVersion: Element? = null,
  public var structureProfile: ExampleScenario.Instance.StructureProfile? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var content: Reference? = null,
  public var version: List<ExampleScenario.Instance.Version>? = null,
  public var containedInstance: List<ExampleScenario.Instance.ContainedInstance>? = null,
) {
  public fun toModel(): ExampleScenario.Instance =
    ExampleScenario.Instance(
      id = this@ExampleScenarioInstanceSurrogate.id,
      extension = this@ExampleScenarioInstanceSurrogate.extension ?: listOf(),
      modifierExtension = this@ExampleScenarioInstanceSurrogate.modifierExtension ?: listOf(),
      key =
        R5String.of(
          this@ExampleScenarioInstanceSurrogate.key,
          this@ExampleScenarioInstanceSurrogate._key,
        )!!,
      structureType = this@ExampleScenarioInstanceSurrogate.structureType,
      structureVersion =
        R5String.of(
          this@ExampleScenarioInstanceSurrogate.structureVersion,
          this@ExampleScenarioInstanceSurrogate._structureVersion,
        ),
      structureProfile = this@ExampleScenarioInstanceSurrogate.structureProfile,
      title =
        R5String.of(
          this@ExampleScenarioInstanceSurrogate.title,
          this@ExampleScenarioInstanceSurrogate._title,
        )!!,
      description =
        Markdown.of(
          this@ExampleScenarioInstanceSurrogate.description,
          this@ExampleScenarioInstanceSurrogate._description,
        ),
      content = this@ExampleScenarioInstanceSurrogate.content,
      version = this@ExampleScenarioInstanceSurrogate.version ?: listOf(),
      containedInstance = this@ExampleScenarioInstanceSurrogate.containedInstance ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ExampleScenario.Instance): ExampleScenarioInstanceSurrogate =
      with(model) {
        ExampleScenarioInstanceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          key = this@with.key.value,
          _key = this@with.key.toElement(),
          structureType = this@with.structureType,
          structureVersion = this@with.structureVersion?.value,
          _structureVersion = this@with.structureVersion?.toElement(),
          structureProfile = this@with.structureProfile,
          title = this@with.title.value,
          _title = this@with.title.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          content = this@with.content,
          version = this@with.version.takeIf { it.isNotEmpty() },
          containedInstance = this@with.containedInstance.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioInstanceVersionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var key: KotlinString? = null,
  public var _key: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var content: Reference? = null,
) {
  public fun toModel(): ExampleScenario.Instance.Version =
    ExampleScenario.Instance.Version(
      id = this@ExampleScenarioInstanceVersionSurrogate.id,
      extension = this@ExampleScenarioInstanceVersionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExampleScenarioInstanceVersionSurrogate.modifierExtension ?: listOf(),
      key =
        R5String.of(
          this@ExampleScenarioInstanceVersionSurrogate.key,
          this@ExampleScenarioInstanceVersionSurrogate._key,
        )!!,
      title =
        R5String.of(
          this@ExampleScenarioInstanceVersionSurrogate.title,
          this@ExampleScenarioInstanceVersionSurrogate._title,
        )!!,
      description =
        Markdown.of(
          this@ExampleScenarioInstanceVersionSurrogate.description,
          this@ExampleScenarioInstanceVersionSurrogate._description,
        ),
      content = this@ExampleScenarioInstanceVersionSurrogate.content,
    )

  public companion object {
    public fun fromModel(
      model: ExampleScenario.Instance.Version
    ): ExampleScenarioInstanceVersionSurrogate =
      with(model) {
        ExampleScenarioInstanceVersionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          key = this@with.key.value,
          _key = this@with.key.toElement(),
          title = this@with.title.value,
          _title = this@with.title.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          content = this@with.content,
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioInstanceContainedInstanceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var instanceReference: KotlinString? = null,
  public var _instanceReference: Element? = null,
  public var versionReference: KotlinString? = null,
  public var _versionReference: Element? = null,
) {
  public fun toModel(): ExampleScenario.Instance.ContainedInstance =
    ExampleScenario.Instance.ContainedInstance(
      id = this@ExampleScenarioInstanceContainedInstanceSurrogate.id,
      extension = this@ExampleScenarioInstanceContainedInstanceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExampleScenarioInstanceContainedInstanceSurrogate.modifierExtension ?: listOf(),
      instanceReference =
        R5String.of(
          this@ExampleScenarioInstanceContainedInstanceSurrogate.instanceReference,
          this@ExampleScenarioInstanceContainedInstanceSurrogate._instanceReference,
        )!!,
      versionReference =
        R5String.of(
          this@ExampleScenarioInstanceContainedInstanceSurrogate.versionReference,
          this@ExampleScenarioInstanceContainedInstanceSurrogate._versionReference,
        ),
    )

  public companion object {
    public fun fromModel(
      model: ExampleScenario.Instance.ContainedInstance
    ): ExampleScenarioInstanceContainedInstanceSurrogate =
      with(model) {
        ExampleScenarioInstanceContainedInstanceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          instanceReference = this@with.instanceReference.value,
          _instanceReference = this@with.instanceReference.toElement(),
          versionReference = this@with.versionReference?.value,
          _versionReference = this@with.versionReference?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioProcessSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var preConditions: KotlinString? = null,
  public var _preConditions: Element? = null,
  public var postConditions: KotlinString? = null,
  public var _postConditions: Element? = null,
  public var step: List<ExampleScenario.Process.Step>? = null,
) {
  public fun toModel(): ExampleScenario.Process =
    ExampleScenario.Process(
      id = this@ExampleScenarioProcessSurrogate.id,
      extension = this@ExampleScenarioProcessSurrogate.extension ?: listOf(),
      modifierExtension = this@ExampleScenarioProcessSurrogate.modifierExtension ?: listOf(),
      title =
        R5String.of(
          this@ExampleScenarioProcessSurrogate.title,
          this@ExampleScenarioProcessSurrogate._title,
        )!!,
      description =
        Markdown.of(
          this@ExampleScenarioProcessSurrogate.description,
          this@ExampleScenarioProcessSurrogate._description,
        ),
      preConditions =
        Markdown.of(
          this@ExampleScenarioProcessSurrogate.preConditions,
          this@ExampleScenarioProcessSurrogate._preConditions,
        ),
      postConditions =
        Markdown.of(
          this@ExampleScenarioProcessSurrogate.postConditions,
          this@ExampleScenarioProcessSurrogate._postConditions,
        ),
      step = this@ExampleScenarioProcessSurrogate.step ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ExampleScenario.Process): ExampleScenarioProcessSurrogate =
      with(model) {
        ExampleScenarioProcessSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          title = this@with.title.value,
          _title = this@with.title.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          preConditions = this@with.preConditions?.value,
          _preConditions = this@with.preConditions?.toElement(),
          postConditions = this@with.postConditions?.value,
          _postConditions = this@with.postConditions?.toElement(),
          step = this@with.step.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioProcessStepSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var number: KotlinString? = null,
  public var _number: Element? = null,
  public var process: ExampleScenario.Process? = null,
  public var workflow: KotlinString? = null,
  public var _workflow: Element? = null,
  public var operation: ExampleScenario.Process.Step.Operation? = null,
  public var alternative: List<ExampleScenario.Process.Step.Alternative>? = null,
  public var pause: KotlinBoolean? = null,
  public var _pause: Element? = null,
) {
  public fun toModel(): ExampleScenario.Process.Step =
    ExampleScenario.Process.Step(
      id = this@ExampleScenarioProcessStepSurrogate.id,
      extension = this@ExampleScenarioProcessStepSurrogate.extension ?: listOf(),
      modifierExtension = this@ExampleScenarioProcessStepSurrogate.modifierExtension ?: listOf(),
      number =
        R5String.of(
          this@ExampleScenarioProcessStepSurrogate.number,
          this@ExampleScenarioProcessStepSurrogate._number,
        ),
      process = this@ExampleScenarioProcessStepSurrogate.process,
      workflow =
        Canonical.of(
          this@ExampleScenarioProcessStepSurrogate.workflow,
          this@ExampleScenarioProcessStepSurrogate._workflow,
        ),
      operation = this@ExampleScenarioProcessStepSurrogate.operation,
      alternative = this@ExampleScenarioProcessStepSurrogate.alternative ?: listOf(),
      pause =
        R5Boolean.of(
          this@ExampleScenarioProcessStepSurrogate.pause,
          this@ExampleScenarioProcessStepSurrogate._pause,
        ),
    )

  public companion object {
    public fun fromModel(model: ExampleScenario.Process.Step): ExampleScenarioProcessStepSurrogate =
      with(model) {
        ExampleScenarioProcessStepSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          number = this@with.number?.value,
          _number = this@with.number?.toElement(),
          process = this@with.process,
          workflow = this@with.workflow?.value,
          _workflow = this@with.workflow?.toElement(),
          operation = this@with.operation,
          alternative = this@with.alternative.takeIf { it.isNotEmpty() },
          pause = this@with.pause?.value,
          _pause = this@with.pause?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioProcessStepOperationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: Coding? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var initiator: KotlinString? = null,
  public var _initiator: Element? = null,
  public var `receiver`: KotlinString? = null,
  public var _receiver: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var initiatorActive: KotlinBoolean? = null,
  public var _initiatorActive: Element? = null,
  public var receiverActive: KotlinBoolean? = null,
  public var _receiverActive: Element? = null,
  public var request: ExampleScenario.Instance.ContainedInstance? = null,
  public var response: ExampleScenario.Instance.ContainedInstance? = null,
) {
  public fun toModel(): ExampleScenario.Process.Step.Operation =
    ExampleScenario.Process.Step.Operation(
      id = this@ExampleScenarioProcessStepOperationSurrogate.id,
      extension = this@ExampleScenarioProcessStepOperationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExampleScenarioProcessStepOperationSurrogate.modifierExtension ?: listOf(),
      type = this@ExampleScenarioProcessStepOperationSurrogate.type,
      title =
        R5String.of(
          this@ExampleScenarioProcessStepOperationSurrogate.title,
          this@ExampleScenarioProcessStepOperationSurrogate._title,
        )!!,
      initiator =
        R5String.of(
          this@ExampleScenarioProcessStepOperationSurrogate.initiator,
          this@ExampleScenarioProcessStepOperationSurrogate._initiator,
        ),
      `receiver` =
        R5String.of(
          this@ExampleScenarioProcessStepOperationSurrogate.`receiver`,
          this@ExampleScenarioProcessStepOperationSurrogate._receiver,
        ),
      description =
        Markdown.of(
          this@ExampleScenarioProcessStepOperationSurrogate.description,
          this@ExampleScenarioProcessStepOperationSurrogate._description,
        ),
      initiatorActive =
        R5Boolean.of(
          this@ExampleScenarioProcessStepOperationSurrogate.initiatorActive,
          this@ExampleScenarioProcessStepOperationSurrogate._initiatorActive,
        ),
      receiverActive =
        R5Boolean.of(
          this@ExampleScenarioProcessStepOperationSurrogate.receiverActive,
          this@ExampleScenarioProcessStepOperationSurrogate._receiverActive,
        ),
      request = this@ExampleScenarioProcessStepOperationSurrogate.request,
      response = this@ExampleScenarioProcessStepOperationSurrogate.response,
    )

  public companion object {
    public fun fromModel(
      model: ExampleScenario.Process.Step.Operation
    ): ExampleScenarioProcessStepOperationSurrogate =
      with(model) {
        ExampleScenarioProcessStepOperationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          title = this@with.title.value,
          _title = this@with.title.toElement(),
          initiator = this@with.initiator?.value,
          _initiator = this@with.initiator?.toElement(),
          `receiver` = this@with.`receiver`?.value,
          _receiver = this@with.`receiver`?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          initiatorActive = this@with.initiatorActive?.value,
          _initiatorActive = this@with.initiatorActive?.toElement(),
          receiverActive = this@with.receiverActive?.value,
          _receiverActive = this@with.receiverActive?.toElement(),
          request = this@with.request,
          response = this@with.response,
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioProcessStepAlternativeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var step: List<ExampleScenario.Process.Step>? = null,
) {
  public fun toModel(): ExampleScenario.Process.Step.Alternative =
    ExampleScenario.Process.Step.Alternative(
      id = this@ExampleScenarioProcessStepAlternativeSurrogate.id,
      extension = this@ExampleScenarioProcessStepAlternativeSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExampleScenarioProcessStepAlternativeSurrogate.modifierExtension ?: listOf(),
      title =
        R5String.of(
          this@ExampleScenarioProcessStepAlternativeSurrogate.title,
          this@ExampleScenarioProcessStepAlternativeSurrogate._title,
        )!!,
      description =
        Markdown.of(
          this@ExampleScenarioProcessStepAlternativeSurrogate.description,
          this@ExampleScenarioProcessStepAlternativeSurrogate._description,
        ),
      step = this@ExampleScenarioProcessStepAlternativeSurrogate.step ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ExampleScenario.Process.Step.Alternative
    ): ExampleScenarioProcessStepAlternativeSurrogate =
      with(model) {
        ExampleScenarioProcessStepAlternativeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          title = this@with.title.value,
          _title = this@with.title.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          step = this@with.step.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioVersionAlgorithmSurrogate(
  public var versionAlgorithmString: KotlinString? = null,
  public var _versionAlgorithmString: Element? = null,
  public var versionAlgorithmCoding: Coding? = null,
) {
  public fun toModel(): ExampleScenario.VersionAlgorithm =
    ExampleScenario.VersionAlgorithm.from(
      R5String.of(
        this@ExampleScenarioVersionAlgorithmSurrogate.versionAlgorithmString,
        this@ExampleScenarioVersionAlgorithmSurrogate._versionAlgorithmString,
      ),
      this@ExampleScenarioVersionAlgorithmSurrogate.versionAlgorithmCoding,
    )!!

  public companion object {
    public fun fromModel(
      model: ExampleScenario.VersionAlgorithm
    ): ExampleScenarioVersionAlgorithmSurrogate =
      with(model) {
        ExampleScenarioVersionAlgorithmSurrogate(
          versionAlgorithmString = this@with.asString()?.value?.value,
          _versionAlgorithmString = this@with.asString()?.value?.toElement(),
          versionAlgorithmCoding = this@with.asCoding()?.value,
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioInstanceStructureProfileSurrogate(
  public var structureProfileCanonical: KotlinString? = null,
  public var _structureProfileCanonical: Element? = null,
  public var structureProfileUri: KotlinString? = null,
  public var _structureProfileUri: Element? = null,
) {
  public fun toModel(): ExampleScenario.Instance.StructureProfile =
    ExampleScenario.Instance.StructureProfile.from(
      Canonical.of(
        this@ExampleScenarioInstanceStructureProfileSurrogate.structureProfileCanonical,
        this@ExampleScenarioInstanceStructureProfileSurrogate._structureProfileCanonical,
      ),
      Uri.of(
        this@ExampleScenarioInstanceStructureProfileSurrogate.structureProfileUri,
        this@ExampleScenarioInstanceStructureProfileSurrogate._structureProfileUri,
      ),
    )!!

  public companion object {
    public fun fromModel(
      model: ExampleScenario.Instance.StructureProfile
    ): ExampleScenarioInstanceStructureProfileSurrogate =
      with(model) {
        ExampleScenarioInstanceStructureProfileSurrogate(
          structureProfileCanonical = this@with.asCanonical()?.value?.value,
          _structureProfileCanonical = this@with.asCanonical()?.value?.toElement(),
          structureProfileUri = this@with.asUri()?.value?.value,
          _structureProfileUri = this@with.asUri()?.value?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ExampleScenarioSurrogate(
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
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var versionAlgorithm: ExampleScenario.VersionAlgorithm? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var experimental: KotlinBoolean? = null,
  public var _experimental: Element? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var copyrightLabel: KotlinString? = null,
  public var _copyrightLabel: Element? = null,
  public var actor: List<ExampleScenario.Actor>? = null,
  public var instance: List<ExampleScenario.Instance>? = null,
  public var process: List<ExampleScenario.Process>? = null,
) {
  public fun toModel(): ExampleScenario =
    ExampleScenario(
      id = this@ExampleScenarioSurrogate.id,
      meta = this@ExampleScenarioSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ExampleScenarioSurrogate.implicitRules,
          this@ExampleScenarioSurrogate._implicitRules,
        ),
      language =
        Code.of(this@ExampleScenarioSurrogate.language, this@ExampleScenarioSurrogate._language),
      text = this@ExampleScenarioSurrogate.text,
      contained = this@ExampleScenarioSurrogate.contained ?: listOf(),
      extension = this@ExampleScenarioSurrogate.extension ?: listOf(),
      modifierExtension = this@ExampleScenarioSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@ExampleScenarioSurrogate.url, this@ExampleScenarioSurrogate._url),
      identifier = this@ExampleScenarioSurrogate.identifier ?: listOf(),
      version =
        R5String.of(this@ExampleScenarioSurrogate.version, this@ExampleScenarioSurrogate._version),
      versionAlgorithm = this@ExampleScenarioSurrogate.versionAlgorithm,
      name = R5String.of(this@ExampleScenarioSurrogate.name, this@ExampleScenarioSurrogate._name),
      title =
        R5String.of(this@ExampleScenarioSurrogate.title, this@ExampleScenarioSurrogate._title),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@ExampleScenarioSurrogate.status!!),
          this@ExampleScenarioSurrogate._status,
        ),
      experimental =
        R5Boolean.of(
          this@ExampleScenarioSurrogate.experimental,
          this@ExampleScenarioSurrogate._experimental,
        ),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ExampleScenarioSurrogate.date),
          this@ExampleScenarioSurrogate._date,
        ),
      publisher =
        R5String.of(
          this@ExampleScenarioSurrogate.publisher,
          this@ExampleScenarioSurrogate._publisher,
        ),
      contact = this@ExampleScenarioSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@ExampleScenarioSurrogate.description,
          this@ExampleScenarioSurrogate._description,
        ),
      useContext = this@ExampleScenarioSurrogate.useContext ?: listOf(),
      jurisdiction = this@ExampleScenarioSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(this@ExampleScenarioSurrogate.purpose, this@ExampleScenarioSurrogate._purpose),
      copyright =
        Markdown.of(
          this@ExampleScenarioSurrogate.copyright,
          this@ExampleScenarioSurrogate._copyright,
        ),
      copyrightLabel =
        R5String.of(
          this@ExampleScenarioSurrogate.copyrightLabel,
          this@ExampleScenarioSurrogate._copyrightLabel,
        ),
      actor = this@ExampleScenarioSurrogate.actor ?: listOf(),
      instance = this@ExampleScenarioSurrogate.instance ?: listOf(),
      process = this@ExampleScenarioSurrogate.process ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ExampleScenario): ExampleScenarioSurrogate =
      with(model) {
        ExampleScenarioSurrogate(
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
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          versionAlgorithm = this@with.versionAlgorithm,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          copyrightLabel = this@with.copyrightLabel?.value,
          _copyrightLabel = this@with.copyrightLabel?.toElement(),
          actor = this@with.actor.takeIf { it.isNotEmpty() },
          instance = this@with.instance.takeIf { it.isNotEmpty() },
          process = this@with.process.takeIf { it.isNotEmpty() },
        )
      }
  }
}

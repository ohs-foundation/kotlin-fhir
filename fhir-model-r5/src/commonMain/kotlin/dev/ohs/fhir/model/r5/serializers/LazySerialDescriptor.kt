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

@file:Suppress("RedundantVisibilityModifier")

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SealedSerializationApi
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.SerialKind

@OptIn(ExperimentalSerializationApi::class, SealedSerializationApi::class)
internal class LazySerialDescriptor(id: Int) : SerialDescriptor {
  // Uses PUBLICATION for lock-free thread safety, avoiding race conditions (unlike NONE)
  // and mutex locks/deadlocks during cyclic resolution (unlike SYNCHRONIZED).
  private val delegate by lazy(LazyThreadSafetyMode.PUBLICATION) { resolveLazyDescriptor(id) }
  override val serialName: String
    get() = delegate.serialName

  override val kind: SerialKind
    get() = delegate.kind

  override val elementsCount: Int
    get() = delegate.elementsCount

  override val isInline: Boolean
    get() = delegate.isInline

  override val isNullable: Boolean
    get() = delegate.isNullable

  override val annotations: List<Annotation>
    get() = delegate.annotations

  override fun getElementName(index: Int): String = delegate.getElementName(index)

  override fun getElementIndex(name: String): Int = delegate.getElementIndex(name)

  override fun getElementAnnotations(index: Int): List<Annotation> =
    delegate.getElementAnnotations(index)

  override fun getElementDescriptor(index: Int): SerialDescriptor =
    delegate.getElementDescriptor(index)

  override fun isElementOptional(index: Int): Boolean = delegate.isElementOptional(index)

  override fun equals(other: Any?): Boolean = delegate == other

  override fun hashCode(): Int = delegate.hashCode()

  override fun toString(): String = delegate.toString()
}

/**
 * Descriptor for the serializer identified by [id] (a `LazyDescriptorId`), resolved on first use.
 */
internal fun lazyDescriptor(id: Int): SerialDescriptor = LazySerialDescriptor(id)

/** Ids of serializers whose descriptors are referenced lazily to break descriptor cycles. */
internal object LazyDescriptorId {
  const val ResourcePolymorphicSerializer: Int = 0
  const val AddressSerializer: Int = 1
  const val AgeSerializer: Int = 2
  const val AnnotationSerializer: Int = 3
  const val ArtifactAssessmentContentSerializer: Int = 4
  const val AttachmentSerializer: Int = 5
  const val AuditEventAgentSerializer: Int = 6
  const val AvailabilitySerializer: Int = 7
  const val BundleLinkSerializer: Int = 8
  const val ChargeItemDefinitionApplicabilitySerializer: Int = 9
  const val ClaimResponseItemAdjudicationSerializer: Int = 10
  const val ClaimResponseItemReviewOutcomeSerializer: Int = 11
  const val CodeSystemConceptSerializer: Int = 12
  const val CodeableConceptSerializer: Int = 13
  const val CodeableReferenceSerializer: Int = 14
  const val CodingSerializer: Int = 15
  const val CompositionSectionSerializer: Int = 16
  const val ConsentProvisionSerializer: Int = 17
  const val ContactDetailSerializer: Int = 18
  const val ContactPointSerializer: Int = 19
  const val ContractTermSerializer: Int = 20
  const val CountSerializer: Int = 21
  const val DataRequirementSerializer: Int = 22
  const val DeviceDefinitionPackagingSerializer: Int = 23
  const val DeviceDefinitionUdiDeviceIdentifierSerializer: Int = 24
  const val DistanceSerializer: Int = 25
  const val DosageSerializer: Int = 26
  const val DurationSerializer: Int = 27
  const val ElementSerializer: Int = 28
  const val EvidenceCertaintySerializer: Int = 29
  const val EvidenceReportSectionSerializer: Int = 30
  const val EvidenceStatisticAttributeEstimateSerializer: Int = 31
  const val EvidenceVariableCharacteristicSerializer: Int = 32
  const val ExampleScenarioInstanceContainedInstanceSerializer: Int = 33
  const val ExampleScenarioProcessSerializer: Int = 34
  const val ExampleScenarioProcessStepSerializer: Int = 35
  const val ExplanationOfBenefitItemAdjudicationSerializer: Int = 36
  const val ExplanationOfBenefitItemReviewOutcomeSerializer: Int = 37
  const val ExpressionSerializer: Int = 38
  const val ExtendedContactDetailSerializer: Int = 39
  const val ExtensionSerializer: Int = 40
  const val HumanNameSerializer: Int = 41
  const val IdentifierSerializer: Int = 42
  const val ImplementationGuideDefinitionPageSerializer: Int = 43
  const val ManufacturedItemDefinitionComponentSerializer: Int = 44
  const val ManufacturedItemDefinitionPropertySerializer: Int = 45
  const val MedicationKnowledgeCostSerializer: Int = 46
  const val MetaSerializer: Int = 47
  const val MoneySerializer: Int = 48
  const val ObservationDefinitionQualifiedValueSerializer: Int = 49
  const val ObservationReferenceRangeSerializer: Int = 50
  const val OperationDefinitionParameterSerializer: Int = 51
  const val PackagedProductDefinitionPackagingSerializer: Int = 52
  const val ParameterDefinitionSerializer: Int = 53
  const val ParametersParameterSerializer: Int = 54
  const val PeriodSerializer: Int = 55
  const val PlanDefinitionActionSerializer: Int = 56
  const val ProvenanceAgentSerializer: Int = 57
  const val QuantitySerializer: Int = 58
  const val QuestionnaireItemSerializer: Int = 59
  const val QuestionnaireResponseItemSerializer: Int = 60
  const val RangeSerializer: Int = 61
  const val RatioRangeSerializer: Int = 62
  const val RatioSerializer: Int = 63
  const val ReferenceSerializer: Int = 64
  const val RegulatedAuthorizationCaseSerializer: Int = 65
  const val RelatedArtifactSerializer: Int = 66
  const val RequestOrchestrationActionSerializer: Int = 67
  const val SampledDataSerializer: Int = 68
  const val SignatureSerializer: Int = 69
  const val StructureMapGroupRuleSerializer: Int = 70
  const val SubstanceDefinitionMolecularWeightSerializer: Int = 71
  const val SubstanceDefinitionNameSerializer: Int = 72
  const val TimingSerializer: Int = 73
  const val TriggerDefinitionSerializer: Int = 74
  const val UsageContextSerializer: Int = 75
  const val ValueSetExpansionContainsSerializer: Int = 76
}

internal fun resolveLazyDescriptor(id: Int): SerialDescriptor =
  when (id) {
    0 -> ResourcePolymorphicSerializer.descriptor
    1 -> AddressSerializer.descriptor
    2 -> AgeSerializer.descriptor
    3 -> AnnotationSerializer.descriptor
    4 -> ArtifactAssessmentContentSerializer.descriptor
    5 -> AttachmentSerializer.descriptor
    6 -> AuditEventAgentSerializer.descriptor
    7 -> AvailabilitySerializer.descriptor
    8 -> BundleLinkSerializer.descriptor
    9 -> ChargeItemDefinitionApplicabilitySerializer.descriptor
    10 -> ClaimResponseItemAdjudicationSerializer.descriptor
    11 -> ClaimResponseItemReviewOutcomeSerializer.descriptor
    12 -> CodeSystemConceptSerializer.descriptor
    13 -> CodeableConceptSerializer.descriptor
    14 -> CodeableReferenceSerializer.descriptor
    15 -> CodingSerializer.descriptor
    16 -> CompositionSectionSerializer.descriptor
    17 -> ConsentProvisionSerializer.descriptor
    18 -> ContactDetailSerializer.descriptor
    19 -> ContactPointSerializer.descriptor
    20 -> ContractTermSerializer.descriptor
    21 -> CountSerializer.descriptor
    22 -> DataRequirementSerializer.descriptor
    23 -> DeviceDefinitionPackagingSerializer.descriptor
    24 -> DeviceDefinitionUdiDeviceIdentifierSerializer.descriptor
    25 -> DistanceSerializer.descriptor
    26 -> DosageSerializer.descriptor
    27 -> DurationSerializer.descriptor
    28 -> ElementSerializer.descriptor
    29 -> EvidenceCertaintySerializer.descriptor
    30 -> EvidenceReportSectionSerializer.descriptor
    31 -> EvidenceStatisticAttributeEstimateSerializer.descriptor
    32 -> EvidenceVariableCharacteristicSerializer.descriptor
    33 -> ExampleScenarioInstanceContainedInstanceSerializer.descriptor
    34 -> ExampleScenarioProcessSerializer.descriptor
    35 -> ExampleScenarioProcessStepSerializer.descriptor
    36 -> ExplanationOfBenefitItemAdjudicationSerializer.descriptor
    37 -> ExplanationOfBenefitItemReviewOutcomeSerializer.descriptor
    38 -> ExpressionSerializer.descriptor
    39 -> ExtendedContactDetailSerializer.descriptor
    40 -> ExtensionSerializer.descriptor
    41 -> HumanNameSerializer.descriptor
    42 -> IdentifierSerializer.descriptor
    43 -> ImplementationGuideDefinitionPageSerializer.descriptor
    44 -> ManufacturedItemDefinitionComponentSerializer.descriptor
    45 -> ManufacturedItemDefinitionPropertySerializer.descriptor
    46 -> MedicationKnowledgeCostSerializer.descriptor
    47 -> MetaSerializer.descriptor
    48 -> MoneySerializer.descriptor
    49 -> ObservationDefinitionQualifiedValueSerializer.descriptor
    50 -> ObservationReferenceRangeSerializer.descriptor
    51 -> OperationDefinitionParameterSerializer.descriptor
    52 -> PackagedProductDefinitionPackagingSerializer.descriptor
    53 -> ParameterDefinitionSerializer.descriptor
    54 -> ParametersParameterSerializer.descriptor
    55 -> PeriodSerializer.descriptor
    56 -> PlanDefinitionActionSerializer.descriptor
    57 -> ProvenanceAgentSerializer.descriptor
    58 -> QuantitySerializer.descriptor
    59 -> QuestionnaireItemSerializer.descriptor
    60 -> QuestionnaireResponseItemSerializer.descriptor
    61 -> RangeSerializer.descriptor
    62 -> RatioRangeSerializer.descriptor
    63 -> RatioSerializer.descriptor
    64 -> ReferenceSerializer.descriptor
    65 -> RegulatedAuthorizationCaseSerializer.descriptor
    66 -> RelatedArtifactSerializer.descriptor
    67 -> RequestOrchestrationActionSerializer.descriptor
    68 -> SampledDataSerializer.descriptor
    69 -> SignatureSerializer.descriptor
    70 -> StructureMapGroupRuleSerializer.descriptor
    71 -> SubstanceDefinitionMolecularWeightSerializer.descriptor
    72 -> SubstanceDefinitionNameSerializer.descriptor
    73 -> TimingSerializer.descriptor
    74 -> TriggerDefinitionSerializer.descriptor
    75 -> UsageContextSerializer.descriptor
    76 -> ValueSetExpansionContainsSerializer.descriptor
    else -> throw IllegalArgumentException("Unknown lazy descriptor id " + id)
  }

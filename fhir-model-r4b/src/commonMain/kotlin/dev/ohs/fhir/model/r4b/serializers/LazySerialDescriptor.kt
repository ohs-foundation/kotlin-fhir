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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
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
  const val AttachmentSerializer: Int = 4
  const val BundleLinkSerializer: Int = 5
  const val ChargeItemDefinitionApplicabilitySerializer: Int = 6
  const val ClaimResponseItemAdjudicationSerializer: Int = 7
  const val CodeSystemConceptSerializer: Int = 8
  const val CodeableConceptSerializer: Int = 9
  const val CodeableReferenceSerializer: Int = 10
  const val CodingSerializer: Int = 11
  const val CompositionSectionSerializer: Int = 12
  const val ConsentProvisionSerializer: Int = 13
  const val ContactDetailSerializer: Int = 14
  const val ContactPointSerializer: Int = 15
  const val ContractTermSerializer: Int = 16
  const val ContributorSerializer: Int = 17
  const val CountSerializer: Int = 18
  const val DataRequirementSerializer: Int = 19
  const val DistanceSerializer: Int = 20
  const val DosageSerializer: Int = 21
  const val DurationSerializer: Int = 22
  const val ElementSerializer: Int = 23
  const val EvidenceCertaintySerializer: Int = 24
  const val EvidenceReportSectionSerializer: Int = 25
  const val EvidenceStatisticAttributeEstimateSerializer: Int = 26
  const val ExampleScenarioInstanceContainedInstanceSerializer: Int = 27
  const val ExampleScenarioProcessSerializer: Int = 28
  const val ExampleScenarioProcessStepSerializer: Int = 29
  const val ExplanationOfBenefitItemAdjudicationSerializer: Int = 30
  const val ExpressionSerializer: Int = 31
  const val ExtensionSerializer: Int = 32
  const val GraphDefinitionLinkSerializer: Int = 33
  const val HumanNameSerializer: Int = 34
  const val IdentifierSerializer: Int = 35
  const val ImplementationGuideDefinitionPageSerializer: Int = 36
  const val MoneySerializer: Int = 37
  const val ObservationReferenceRangeSerializer: Int = 38
  const val OperationDefinitionParameterSerializer: Int = 39
  const val PackagedProductDefinitionPackageSerializer: Int = 40
  const val ParameterDefinitionSerializer: Int = 41
  const val ParametersParameterSerializer: Int = 42
  const val PeriodSerializer: Int = 43
  const val PlanDefinitionActionSerializer: Int = 44
  const val ProvenanceAgentSerializer: Int = 45
  const val QuantitySerializer: Int = 46
  const val QuestionnaireItemSerializer: Int = 47
  const val QuestionnaireResponseItemSerializer: Int = 48
  const val RangeSerializer: Int = 49
  const val RatioRangeSerializer: Int = 50
  const val RatioSerializer: Int = 51
  const val ReferenceSerializer: Int = 52
  const val RegulatedAuthorizationCaseSerializer: Int = 53
  const val RelatedArtifactSerializer: Int = 54
  const val RequestGroupActionSerializer: Int = 55
  const val SampledDataSerializer: Int = 56
  const val SignatureSerializer: Int = 57
  const val StructureMapGroupRuleSerializer: Int = 58
  const val SubstanceDefinitionMolecularWeightSerializer: Int = 59
  const val SubstanceDefinitionNameSerializer: Int = 60
  const val TimingSerializer: Int = 61
  const val TriggerDefinitionSerializer: Int = 62
  const val UsageContextSerializer: Int = 63
  const val ValueSetExpansionContainsSerializer: Int = 64
}

internal fun resolveLazyDescriptor(id: Int): SerialDescriptor =
  when (id) {
    0 -> ResourcePolymorphicSerializer.descriptor
    1 -> AddressSerializer.descriptor
    2 -> AgeSerializer.descriptor
    3 -> AnnotationSerializer.descriptor
    4 -> AttachmentSerializer.descriptor
    5 -> BundleLinkSerializer.descriptor
    6 -> ChargeItemDefinitionApplicabilitySerializer.descriptor
    7 -> ClaimResponseItemAdjudicationSerializer.descriptor
    8 -> CodeSystemConceptSerializer.descriptor
    9 -> CodeableConceptSerializer.descriptor
    10 -> CodeableReferenceSerializer.descriptor
    11 -> CodingSerializer.descriptor
    12 -> CompositionSectionSerializer.descriptor
    13 -> ConsentProvisionSerializer.descriptor
    14 -> ContactDetailSerializer.descriptor
    15 -> ContactPointSerializer.descriptor
    16 -> ContractTermSerializer.descriptor
    17 -> ContributorSerializer.descriptor
    18 -> CountSerializer.descriptor
    19 -> DataRequirementSerializer.descriptor
    20 -> DistanceSerializer.descriptor
    21 -> DosageSerializer.descriptor
    22 -> DurationSerializer.descriptor
    23 -> ElementSerializer.descriptor
    24 -> EvidenceCertaintySerializer.descriptor
    25 -> EvidenceReportSectionSerializer.descriptor
    26 -> EvidenceStatisticAttributeEstimateSerializer.descriptor
    27 -> ExampleScenarioInstanceContainedInstanceSerializer.descriptor
    28 -> ExampleScenarioProcessSerializer.descriptor
    29 -> ExampleScenarioProcessStepSerializer.descriptor
    30 -> ExplanationOfBenefitItemAdjudicationSerializer.descriptor
    31 -> ExpressionSerializer.descriptor
    32 -> ExtensionSerializer.descriptor
    33 -> GraphDefinitionLinkSerializer.descriptor
    34 -> HumanNameSerializer.descriptor
    35 -> IdentifierSerializer.descriptor
    36 -> ImplementationGuideDefinitionPageSerializer.descriptor
    37 -> MoneySerializer.descriptor
    38 -> ObservationReferenceRangeSerializer.descriptor
    39 -> OperationDefinitionParameterSerializer.descriptor
    40 -> PackagedProductDefinitionPackageSerializer.descriptor
    41 -> ParameterDefinitionSerializer.descriptor
    42 -> ParametersParameterSerializer.descriptor
    43 -> PeriodSerializer.descriptor
    44 -> PlanDefinitionActionSerializer.descriptor
    45 -> ProvenanceAgentSerializer.descriptor
    46 -> QuantitySerializer.descriptor
    47 -> QuestionnaireItemSerializer.descriptor
    48 -> QuestionnaireResponseItemSerializer.descriptor
    49 -> RangeSerializer.descriptor
    50 -> RatioRangeSerializer.descriptor
    51 -> RatioSerializer.descriptor
    52 -> ReferenceSerializer.descriptor
    53 -> RegulatedAuthorizationCaseSerializer.descriptor
    54 -> RelatedArtifactSerializer.descriptor
    55 -> RequestGroupActionSerializer.descriptor
    56 -> SampledDataSerializer.descriptor
    57 -> SignatureSerializer.descriptor
    58 -> StructureMapGroupRuleSerializer.descriptor
    59 -> SubstanceDefinitionMolecularWeightSerializer.descriptor
    60 -> SubstanceDefinitionNameSerializer.descriptor
    61 -> TimingSerializer.descriptor
    62 -> TriggerDefinitionSerializer.descriptor
    63 -> UsageContextSerializer.descriptor
    64 -> ValueSetExpansionContainsSerializer.descriptor
    else -> throw IllegalArgumentException("Unknown lazy descriptor id " + id)
  }

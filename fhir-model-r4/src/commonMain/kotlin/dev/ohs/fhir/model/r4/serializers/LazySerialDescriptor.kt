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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
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
  const val CodingSerializer: Int = 10
  const val CompositionSectionSerializer: Int = 11
  const val ConsentProvisionSerializer: Int = 12
  const val ContactDetailSerializer: Int = 13
  const val ContactPointSerializer: Int = 14
  const val ContractTermSerializer: Int = 15
  const val ContributorSerializer: Int = 16
  const val CountSerializer: Int = 17
  const val DataRequirementSerializer: Int = 18
  const val DistanceSerializer: Int = 19
  const val DosageSerializer: Int = 20
  const val DurationSerializer: Int = 21
  const val ElementSerializer: Int = 22
  const val ExampleScenarioInstanceContainedInstanceSerializer: Int = 23
  const val ExampleScenarioProcessSerializer: Int = 24
  const val ExampleScenarioProcessStepSerializer: Int = 25
  const val ExplanationOfBenefitItemAdjudicationSerializer: Int = 26
  const val ExpressionSerializer: Int = 27
  const val ExtensionSerializer: Int = 28
  const val GraphDefinitionLinkSerializer: Int = 29
  const val HumanNameSerializer: Int = 30
  const val IdentifierSerializer: Int = 31
  const val ImplementationGuideDefinitionPageSerializer: Int = 32
  const val MedicinalProductAuthorizationProcedureSerializer: Int = 33
  const val MedicinalProductPackagedPackageItemSerializer: Int = 34
  const val MetaSerializer: Int = 35
  const val MoneySerializer: Int = 36
  const val ObservationReferenceRangeSerializer: Int = 37
  const val OperationDefinitionParameterSerializer: Int = 38
  const val ParameterDefinitionSerializer: Int = 39
  const val ParametersParameterSerializer: Int = 40
  const val PeriodSerializer: Int = 41
  const val PlanDefinitionActionSerializer: Int = 42
  const val ProvenanceAgentSerializer: Int = 43
  const val QuantitySerializer: Int = 44
  const val QuestionnaireItemSerializer: Int = 45
  const val QuestionnaireResponseItemSerializer: Int = 46
  const val RangeSerializer: Int = 47
  const val RatioSerializer: Int = 48
  const val ReferenceSerializer: Int = 49
  const val RelatedArtifactSerializer: Int = 50
  const val RequestGroupActionSerializer: Int = 51
  const val SampledDataSerializer: Int = 52
  const val SignatureSerializer: Int = 53
  const val StructureMapGroupRuleSerializer: Int = 54
  const val SubstanceSpecificationNameSerializer: Int = 55
  const val TimingSerializer: Int = 56
  const val TriggerDefinitionSerializer: Int = 57
  const val UsageContextSerializer: Int = 58
  const val ValueSetExpansionContainsSerializer: Int = 59
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
    10 -> CodingSerializer.descriptor
    11 -> CompositionSectionSerializer.descriptor
    12 -> ConsentProvisionSerializer.descriptor
    13 -> ContactDetailSerializer.descriptor
    14 -> ContactPointSerializer.descriptor
    15 -> ContractTermSerializer.descriptor
    16 -> ContributorSerializer.descriptor
    17 -> CountSerializer.descriptor
    18 -> DataRequirementSerializer.descriptor
    19 -> DistanceSerializer.descriptor
    20 -> DosageSerializer.descriptor
    21 -> DurationSerializer.descriptor
    22 -> ElementSerializer.descriptor
    23 -> ExampleScenarioInstanceContainedInstanceSerializer.descriptor
    24 -> ExampleScenarioProcessSerializer.descriptor
    25 -> ExampleScenarioProcessStepSerializer.descriptor
    26 -> ExplanationOfBenefitItemAdjudicationSerializer.descriptor
    27 -> ExpressionSerializer.descriptor
    28 -> ExtensionSerializer.descriptor
    29 -> GraphDefinitionLinkSerializer.descriptor
    30 -> HumanNameSerializer.descriptor
    31 -> IdentifierSerializer.descriptor
    32 -> ImplementationGuideDefinitionPageSerializer.descriptor
    33 -> MedicinalProductAuthorizationProcedureSerializer.descriptor
    34 -> MedicinalProductPackagedPackageItemSerializer.descriptor
    35 -> MetaSerializer.descriptor
    36 -> MoneySerializer.descriptor
    37 -> ObservationReferenceRangeSerializer.descriptor
    38 -> OperationDefinitionParameterSerializer.descriptor
    39 -> ParameterDefinitionSerializer.descriptor
    40 -> ParametersParameterSerializer.descriptor
    41 -> PeriodSerializer.descriptor
    42 -> PlanDefinitionActionSerializer.descriptor
    43 -> ProvenanceAgentSerializer.descriptor
    44 -> QuantitySerializer.descriptor
    45 -> QuestionnaireItemSerializer.descriptor
    46 -> QuestionnaireResponseItemSerializer.descriptor
    47 -> RangeSerializer.descriptor
    48 -> RatioSerializer.descriptor
    49 -> ReferenceSerializer.descriptor
    50 -> RelatedArtifactSerializer.descriptor
    51 -> RequestGroupActionSerializer.descriptor
    52 -> SampledDataSerializer.descriptor
    53 -> SignatureSerializer.descriptor
    54 -> StructureMapGroupRuleSerializer.descriptor
    55 -> SubstanceSpecificationNameSerializer.descriptor
    56 -> TimingSerializer.descriptor
    57 -> TriggerDefinitionSerializer.descriptor
    58 -> UsageContextSerializer.descriptor
    59 -> ValueSetExpansionContainsSerializer.descriptor
    else -> throw IllegalArgumentException("Unknown lazy descriptor id " + id)
  }

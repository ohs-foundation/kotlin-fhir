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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CarePlan
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object CarePlanActivitySerializer : KSerializer<CarePlan.Activity> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Activity") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "outcomeCodeableConcept",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "outcomeReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "progress",
        listSerialDescriptor(Annotation.serializer().descriptor),
        isOptional = true,
      )
      element("reference", Reference.serializer().descriptor, isOptional = true)
      element(
        "detail",
        lazyDescriptor { CarePlan.Activity.Detail.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): CarePlan.Activity =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CarePlan.Activity) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CarePlan.Activity {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var outcomeCodeableConcept: List<CodeableConcept>? = null
    var outcomeReference: List<Reference>? = null
    var progress: List<Annotation>? = null
    var reference: Reference? = null
    var detail: CarePlan.Activity.Detail? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          outcomeCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.outcomeCodeableConceptSer,
              null,
            )
        4 ->
          outcomeReference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.outcomeReferenceSer, null)
        5 ->
          progress = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.progressSer, null)
        6 ->
          reference =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.outcomeReferenceSerInner,
              null,
            )
        7 -> detail = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Activity: " + __i)
      }
    }
    return CarePlan.Activity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      outcomeCodeableConcept = outcomeCodeableConcept ?: listOf(),
      outcomeReference = outcomeReference ?: listOf(),
      progress = progress ?: listOf(),
      reference = reference,
      detail = detail,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CarePlan.Activity) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.outcomeCodeableConcept.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        3,
        Hoisted.outcomeCodeableConceptSer,
        value.outcomeCodeableConcept,
      )
    if (value.outcomeReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        4,
        Hoisted.outcomeReferenceSer,
        value.outcomeReference,
      )
    if (value.progress.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.progressSer, value.progress)
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.outcomeReferenceSerInner, it)
    }
    (value.detail)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.detailSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val outcomeCodeableConceptSerInner: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val outcomeCodeableConceptSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.outcomeCodeableConceptSerInner)

    public val outcomeReferenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val outcomeReferenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.outcomeReferenceSerInner)

    public val progressSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val progressSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.progressSerInner)

    public val detailSer: KSerializer<CarePlan.Activity.Detail> =
      CarePlan.Activity.Detail.serializer()
  }
}

internal object CarePlanActivityDetailSerializer : KSerializer<CarePlan.Activity.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("kind", KotlinString.serializer().descriptor, isOptional = true)
      element("_kind", Element.serializer().descriptor, isOptional = true)
      element(
        "instantiatesCanonical",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesCanonical",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "instantiatesUri",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_instantiatesUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("goal", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("statusReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
      element("scheduledTiming", Timing.serializer().descriptor, isOptional = true)
      element("scheduledPeriod", Period.serializer().descriptor, isOptional = true)
      element("scheduledString", KotlinString.serializer().descriptor, isOptional = true)
      element("_scheduledString", Element.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element(
        "performer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("productCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productReference", Reference.serializer().descriptor, isOptional = true)
      element("dailyAmount", Quantity.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CarePlan.Activity.Detail =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CarePlan.Activity.Detail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CarePlan.Activity.Detail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var kind: KotlinString? = null
    var _kind: Element? = null
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var code: CodeableConcept? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var goal: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var statusReason: CodeableConcept? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var scheduledTiming: Timing? = null
    var scheduledPeriod: Period? = null
    var scheduledString: KotlinString? = null
    var _scheduledString: Element? = null
    var location: Reference? = null
    var performer: List<Reference>? = null
    var productCodeableConcept: CodeableConcept? = null
    var productReference: Reference? = null
    var dailyAmount: Quantity? = null
    var quantity: Quantity? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> kind = decoder.decodeStringElement(__desc, 3)
        4 -> _kind = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.kindSer, null)
        5 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        6 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        7 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        8 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        9 -> code = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.codeSer, null)
        10 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.reasonCodeSer, null)
        11 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.reasonReferenceSer, null)
        12 ->
          goal =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.reasonReferenceSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 -> _status = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.kindSer, null)
        15 ->
          statusReason =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.codeSer, null)
        16 -> doNotPerform = decoder.decodeBooleanElement(__desc, 16)
        17 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.kindSer, null)
        18 ->
          scheduledTiming =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.scheduledTimingSer, null)
        19 ->
          scheduledPeriod =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.scheduledPeriodSer, null)
        20 -> scheduledString = decoder.decodeStringElement(__desc, 20)
        21 ->
          _scheduledString =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.kindSer, null)
        22 ->
          location =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.reasonReferenceSerInner,
              null,
            )
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.reasonReferenceSer, null)
        24 ->
          productCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.codeSer, null)
        25 ->
          productReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              25,
              Hoisted.reasonReferenceSerInner,
              null,
            )
        26 ->
          dailyAmount =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.dailyAmountSer, null)
        27 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.dailyAmountSer, null)
        28 -> description = decoder.decodeStringElement(__desc, 28)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.kindSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + __i)
      }
    }
    return CarePlan.Activity.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kind = kind?.let { Enumeration.of(CarePlan.CarePlanActivityKind.fromCode(it), _kind) },
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { __i ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(__i)?.let { it },
            _instantiatesCanonical?.getOrNull(__i),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          __i ->
          Uri.of(instantiatesUri?.getOrNull(__i)?.let { it }, _instantiatesUri?.getOrNull(__i))!!
        }),
      code = code,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      goal = goal ?: listOf(),
      status = Enumeration.of(CarePlan.CarePlanActivityStatus.fromCode(status!!), _status),
      statusReason = statusReason,
      doNotPerform = R4Boolean.of(doNotPerform, _doNotPerform),
      scheduled =
        CarePlan.Activity.Detail.Scheduled.from(
          scheduledTiming,
          scheduledPeriod,
          R4String.of(scheduledString, _scheduledString),
        ),
      location = location,
      performer = performer ?: listOf(),
      product = CarePlan.Activity.Detail.Product.from(productCodeableConcept, productReference),
      dailyAmount = dailyAmount,
      quantity = quantity,
      description = R4String.of(description, _description),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CarePlan.Activity.Detail) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.kind?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.kind?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.kindSer, it)
    }
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.codeSer, it) }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.reasonCodeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        11,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.reasonReferenceSer, value.goal)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.kindSer, it)
    }
    (value.statusReason)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.codeSer, it) }
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(__desc, 16, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.kindSer, it)
    }
    when (val __d = value.scheduled) {
      null -> {}
      is CarePlan.Activity.Detail.Scheduled.Timing -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.scheduledTimingSer, __d.value)
      }
      is CarePlan.Activity.Detail.Scheduled.Period -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.scheduledPeriodSer, __d.value)
      }
      is CarePlan.Activity.Detail.Scheduled.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.kindSer, it)
        }
      }
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.reasonReferenceSerInner, it)
    }
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.reasonReferenceSer, value.performer)
    when (val __d = value.product) {
      null -> {}
      is CarePlan.Activity.Detail.Product.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 24, Hoisted.codeSer, __d.value)
      }
      is CarePlan.Activity.Detail.Product.Reference -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.reasonReferenceSerInner, __d.value)
      }
    }
    (value.dailyAmount)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.dailyAmountSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.dailyAmountSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.kindSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val kindSer: KSerializer<Element> = Element.serializer()

    public val instantiatesCanonicalSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.kindSer).nullable)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val reasonCodeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSer)

    public val reasonReferenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val reasonReferenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.reasonReferenceSerInner)

    public val scheduledTimingSer: KSerializer<Timing> = Timing.serializer()

    public val scheduledPeriodSer: KSerializer<Period> = Period.serializer()

    public val dailyAmountSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object CarePlanSerializer : KSerializer<CarePlan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CarePlan") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesCanonical",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesUri",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "replaces",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("intent", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("author", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "contributor",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "careTeam",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "addresses",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("goal", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "activity",
      listSerialDescriptor(lazyDescriptor { CarePlan.Activity.serializer().descriptor }),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): CarePlan =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CarePlan) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CarePlan")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CarePlan {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var basedOn: List<Reference>? = null
    var replaces: List<Reference>? = null
    var partOf: List<Reference>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var category: List<CodeableConcept>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var period: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var author: Reference? = null
    var contributor: List<Reference>? = null
    var careTeam: List<Reference>? = null
    var addresses: List<Reference>? = null
    var supportingInfo: List<Reference>? = null
    var goal: List<Reference>? = null
    var activity: List<CarePlan.Activity>? = null
    var note: List<Annotation>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        13 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        14 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        15 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        16 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.basedOnSer, null)
        17 ->
          replaces = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.basedOnSer, null)
        18 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.basedOnSer, null)
        19 -> status = decoder.decodeStringElement(__desc, 19)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> intent = decoder.decodeStringElement(__desc, 21)
        22 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.categorySer, null)
        24 -> title = decoder.decodeStringElement(__desc, 24)
        25 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> description = decoder.decodeStringElement(__desc, 26)
        27 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.basedOnSerInner, null)
        29 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.basedOnSerInner, null)
        30 ->
          period = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.periodSer, null)
        31 -> created = decoder.decodeStringElement(__desc, 31)
        32 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 ->
          author =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.basedOnSerInner, null)
        34 ->
          contributor =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.basedOnSer, null)
        35 ->
          careTeam = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.basedOnSer, null)
        36 ->
          addresses =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.basedOnSer, null)
        37 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.basedOnSer, null)
        38 -> goal = decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.basedOnSer, null)
        39 ->
          activity =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.activitySer, null)
        40 -> note = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CarePlan: " + __i)
      }
    }
    return CarePlan(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { __i ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(__i)?.let { it },
            _instantiatesCanonical?.getOrNull(__i),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          __i ->
          Uri.of(instantiatesUri?.getOrNull(__i)?.let { it }, _instantiatesUri?.getOrNull(__i))!!
        }),
      basedOn = basedOn ?: listOf(),
      replaces = replaces ?: listOf(),
      partOf = partOf ?: listOf(),
      status = Enumeration.of(CarePlan.RequestStatus.fromCode(status!!), _status),
      intent = Enumeration.of(CarePlan.CarePlanIntent.fromCode(intent!!), _intent),
      category = category ?: listOf(),
      title = R4String.of(title, _title),
      description = R4String.of(description, _description),
      subject = subject!!,
      encounter = encounter,
      period = period,
      created = DateTime.of(FhirDateTime.fromString(created), _created),
      author = author,
      contributor = contributor ?: listOf(),
      careTeam = careTeam ?: listOf(),
      addresses = addresses ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      goal = goal ?: listOf(),
      activity = activity ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: CarePlan) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.basedOnSer, value.basedOn)
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.basedOnSer, value.replaces)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.categorySer, value.category)
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.basedOnSerInner, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 30, Hoisted.periodSer, it) }
    ((value.created?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.created?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.basedOnSerInner, it)
    }
    if (value.contributor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.basedOnSer, value.contributor)
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.basedOnSer, value.careTeam)
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.basedOnSer, value.addresses)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.basedOnSer, value.supportingInfo)
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.basedOnSer, value.goal)
    if (value.activity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.activitySer, value.activity)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val instantiatesCanonicalSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val activitySerInner: KSerializer<CarePlan.Activity> = CarePlan.Activity.serializer()

    public val activitySer: KSerializer<List<CarePlan.Activity>> =
      ListSerializer(Hoisted.activitySerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object CarePlanPolymorphicSerializer : KSerializer<CarePlan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CarePlan") { CarePlanSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: CarePlan) {
    encoder.encodeStructure(descriptor) { CarePlanSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): CarePlan =
    decoder.decodeStructure(descriptor) { CarePlanSerializer.deserializeJson(this) }
}

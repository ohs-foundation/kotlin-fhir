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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.CarePlan
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
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
        "performedActivity",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "progress",
        listSerialDescriptor(Annotation.serializer().descriptor),
        isOptional = true,
      )
      element("plannedActivityReference", Reference.serializer().descriptor, isOptional = true)
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
    var performedActivity: List<CodeableReference>? = null
    var progress: List<Annotation>? = null
    var plannedActivityReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          performedActivity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.performedActivitySer,
              null,
            )
        4 ->
          progress =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.progressSer, null)
        5 ->
          plannedActivityReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.plannedActivityReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Activity: " + __i)
      }
    }
    return CarePlan.Activity(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      performedActivity = performedActivity ?: listOf(),
      progress = progress ?: listOf(),
      plannedActivityReference = plannedActivityReference,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CarePlan.Activity) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.performedActivity.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        3,
        Hoisted.performedActivitySer,
        value.performedActivity,
      )
    if (value.progress.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.progressSer, value.progress)
    (value.plannedActivityReference)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.plannedActivityReferenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val performedActivitySerInner: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val performedActivitySer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.performedActivitySerInner)

    public val progressSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val progressSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.progressSerInner)

    public val plannedActivityReferenceSer: KSerializer<Reference> = Reference.serializer()
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
    b.element("custodian", Reference.serializer().descriptor, isOptional = true)
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
      listSerialDescriptor(CodeableReference.serializer().descriptor),
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: CarePlan) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CarePlan")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): CarePlan {
    val __desc = desc
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
    var custodian: Reference? = null
    var contributor: List<Reference>? = null
    var careTeam: List<Reference>? = null
    var addresses: List<CodeableReference>? = null
    var supportingInfo: List<Reference>? = null
    var goal: List<Reference>? = null
    var activity: List<CarePlan.Activity>? = null
    var note: List<Annotation>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        15 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        16 ->
          replaces =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        17 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        18 -> status = decoder.decodeStringElement(__desc, __i)
        19 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 -> intent = decoder.decodeStringElement(__desc, __i)
        21 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        23 -> title = decoder.decodeStringElement(__desc, __i)
        24 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 -> description = decoder.decodeStringElement(__desc, __i)
        26 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        27 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        28 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        29 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        30 -> created = decoder.decodeStringElement(__desc, __i)
        31 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 ->
          custodian =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        33 ->
          contributor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        34 ->
          careTeam =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        35 ->
          addresses =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.addressesSer, null)
        36 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        37 ->
          goal = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        38 ->
          activity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.activitySer, null)
        39 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
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
      title = R5String.of(title, _title),
      description = R5String.of(description, _description),
      subject = subject!!,
      encounter = encounter,
      period = period,
      created = DateTime.of(FhirDateTime.fromString(created), _created),
      custodian = custodian,
      contributor = contributor ?: listOf(),
      careTeam = careTeam ?: listOf(),
      addresses = addresses ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      goal = goal ?: listOf(),
      activity = activity ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: CarePlan,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.basedOnSer, value.basedOn)
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.basedOnSer, value.replaces)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.basedOnSer, value.partOf)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.categorySer, value.category)
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 23 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 25 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.periodSer, it)
    }
    ((value.created?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 30 + __off, it)
    }
    (value.created?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.custodian)?.let {
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.contributor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.basedOnSer, value.contributor)
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34 + __off, Hoisted.basedOnSer, value.careTeam)
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.addressesSer, value.addresses)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        36 + __off,
        Hoisted.basedOnSer,
        value.supportingInfo,
      )
    if (value.goal.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.basedOnSer, value.goal)
    if (value.activity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.activitySer, value.activity)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.noteSer, value.note)
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

    public val addressesSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val addressesSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.addressesSerInner)

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
    encoder.encodeStructure(descriptor) {
      CarePlanSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CarePlan =
    decoder.decodeStructure(descriptor) { CarePlanSerializer.deserializeJson(this, descriptor, 0) }
}

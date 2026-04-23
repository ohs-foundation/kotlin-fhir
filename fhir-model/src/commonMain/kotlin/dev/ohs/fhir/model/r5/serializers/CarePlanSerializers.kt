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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          performedActivity =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.performedActivitySer, null)
        4 ->
          progress = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.progressSer, null)
        5 ->
          plannedActivityReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
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
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "replaces",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("intent", KotlinString.serializer().descriptor, isOptional = true)
      element("_intent", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element("created", KotlinString.serializer().descriptor, isOptional = true)
      element("_created", Element.serializer().descriptor, isOptional = true)
      element("custodian", Reference.serializer().descriptor, isOptional = true)
      element(
        "contributor",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "careTeam",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "addresses",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "supportingInfo",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("goal", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "activity",
        listSerialDescriptor(lazyDescriptor { CarePlan.Activity.serializer().descriptor }),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CarePlan =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CarePlan) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
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
    var custodian: Reference? = null
    var contributor: List<Reference>? = null
    var careTeam: List<Reference>? = null
    var addresses: List<CodeableReference>? = null
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
          custodian =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.basedOnSerInner, null)
        34 ->
          contributor =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.basedOnSer, null)
        35 ->
          careTeam = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.basedOnSer, null)
        36 ->
          addresses =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.addressesSer, null)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: CarePlan) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "CarePlan")
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
    (value.custodian)?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.basedOnSerInner, it)
    }
    if (value.contributor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.basedOnSer, value.contributor)
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.basedOnSer, value.careTeam)
    if (value.addresses.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.addressesSer, value.addresses)
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

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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.DeviceMetricCalibrationSerializer
import dev.ohs.fhir.model.r5.serializers.DeviceMetricSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes a measurement, calculation or setting capability of a device. The DeviceMetric resource
 * is derived from the ISO/IEEE 11073-10201 Domain Information Model standard, but is more widely
 * applicable.
 */
@Serializable(with = DeviceMetricSerializer::class)
@SerialName("DeviceMetric")
public data class DeviceMetric(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
   */
  override val id: String? = null,
  /**
   * The metadata about the resource. This is content that is maintained by the infrastructure.
   * Changes to the content might not always be associated with version changes to the resource.
   */
  override val meta: Meta? = null,
  /**
   * A reference to a set of rules that were followed when the resource was constructed, and which
   * must be understood when processing the content. Often, this is a reference to an implementation
   * guide that defines the special rules along with other profiles etc.
   *
   * Asserting this rule set restricts the content to be only understood by a limited set of trading
   * partners. This inherently limits the usefulness of the data in the long term. However, the
   * existing health eco-system is highly fractured, and not yet ready to define, collect, and
   * exchange data in a generally computable sense. Wherever possible, implementers and/or
   * specification writers should avoid using this element. Often, when used, the URL is a reference
   * to an implementation guide that defines these special rules as part of its narrative along with
   * other profiles, value sets, etc.
   */
  override val implicitRules: Uri? = null,
  /**
   * The base language in which the resource is written.
   *
   * Language is provided to support indexing and accessibility (typically, services such as text to
   * speech use the language tag). The html language tag in the narrative applies to the narrative.
   * The language tag on the resource may be used to specify the language of other presentations
   * generated from the data in the resource. Not all the content has to be in the base language.
   * The Resource.language should not be assumed to apply to the narrative automatically. If a
   * language is specified, it should it also be specified on the div element in the html (see rules
   * in HTML5 for information about the relationship between xml:lang and the html lang attribute).
   */
  override val language: Code? = null,
  /**
   * A human-readable narrative that contains a summary of the resource and can be used to represent
   * the content of the resource to a human. The narrative need not encode all the structured data,
   * but is required to contain sufficient detail to make it "clinically safe" for a human to just
   * read the narrative. Resource definitions may define what content should be represented in the
   * narrative to ensure clinical safety.
   *
   * Contained resources do not have a narrative. Resources that are not contained SHOULD have a
   * narrative. In some cases, a resource may only have text with little or no additional discrete
   * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
   * legacy systems where information is captured as a "text blob" or where text is additionally
   * entered raw or narrated and encoded information is added later.
   */
  override val text: Narrative? = null,
  /**
   * These resources do not have an independent existence apart from the resource that contains
   * them - they cannot be identified independently, nor can they have their own independent
   * transaction scope. This is allowed to be a Parameters resource if and only if it is referenced
   * by a resource that provides context/meaning.
   *
   * This should never be done when the content can be identified properly, as once identification
   * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
   * resources may have profiles and tags in their meta elements, but SHALL NOT have security
   * labels.
   */
  override val contained: List<Resource> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and managable, there is a strict set of governance
   * applied to the definition and use of extensions. Though any implementer can define an
   * extension, there is a set of requirements that SHALL be met as part of the definition of the
   * extension.
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val extension: List<Extension> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource and that modifies the understanding of the element that contains it and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and managable, there is a strict
   * set of governance applied to the definition and use of extensions. Though any implementer is
   * allowed to define an extension, there is a set of requirements that SHALL be met as part of the
   * definition of the extension. Applications processing a resource are required to check for
   * modifier extensions.
   *
   * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource
   * (including cannot change the meaning of modifierExtension itself).
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val modifierExtension: List<Extension> = listOf(),
  /**
   * Instance identifiers assigned to a device, by the device or gateway software, manufacturers,
   * other organizations or owners. For example, handle ID.
   *
   * For identifiers assigned to a device by the device or gateway software, the `system` element of
   * the identifier should be set to any identifier of the device.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Describes the type of the metric. For example: Heart Rate, PEEP Setting, etc.
   *
   * DeviceMetric.type can be referred to either IEEE 11073-10101 or LOINC.
   */
  public val type: CodeableConcept,
  /**
   * Describes the unit that an observed value determined for this metric will have. For example:
   * Percent, Seconds, etc.
   *
   * DeviceMetric.unit can refer to either UCUM or preferable a RTMMS coding system.
   */
  public val unit: CodeableConcept? = null,
  /**
   * Describes the link to the Device. This is also known as a channel device.
   *
   * Note if this is not the top level device - also know as the source device, it may be referenced
   * in the device.parent element.
   */
  public val device: Reference,
  /** Indicates current operational state of the device. For example: On, Off, Standby, etc. */
  public val operationalStatus: Enumeration<DeviceMetricOperationalStatus>? = null,
  /**
   * The preferred color associated with the metric (e.g., display color). This is often used to aid
   * clinicians to track and identify parameter types by color. In practice, consider a Patient
   * Monitor that has ECG/HR and Pleth; the metrics are displayed in different characteristic
   * colors, such as HR in blue, BP in green, and PR and SpO2 in magenta.
   */
  public val color: Code? = null,
  /**
   * Indicates the category of the observation generation process. A DeviceMetric can be for example
   * a setting, measurement, or calculation.
   */
  public val category: Enumeration<DeviceMetricCategory>,
  /**
   * The frequency at which the metric is taken or recorded. Devices measure metrics at a wide range
   * of frequencies; for example, an ECG might sample measurements in the millisecond range, while
   * an NIBP might trigger only once an hour. Less often, the measurementFrequency may be based on a
   * unit other than time, such as distance (e.g. for a measuring wheel). The update period may be
   * different than the measurement frequency, if the device does not update the published observed
   * value with the same frequency as it was measured.
   */
  public val measurementFrequency: Quantity? = null,
  /** Describes the calibrations that have been performed or that are required to be performed. */
  public val calibration: List<Calibration> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          type.toBuilder(),
          device.toBuilder(),
          category,
        )
        .apply {
          id = this@with.id
          meta = this@with.meta?.toBuilder()
          implicitRules = this@with.implicitRules?.toBuilder()
          language = this@with.language?.toBuilder()
          text = this@with.text?.toBuilder()
          contained = this@with.contained.map { it.toBuilder() }.toMutableList()
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          unit = this@with.unit?.toBuilder()
          operationalStatus = this@with.operationalStatus
          color = this@with.color?.toBuilder()
          measurementFrequency = this@with.measurementFrequency?.toBuilder()
          calibration = this@with.calibration.map { it.toBuilder() }.toMutableList()
        }
    }

  /** Describes the calibrations that have been performed or that are required to be performed. */
  @Serializable(with = DeviceMetricCalibrationSerializer::class)
  public data class Calibration(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element. To make the use of extensions safe and managable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and managable, there is
     * a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    override val modifierExtension: List<Extension> = listOf(),
    /** Describes the type of the calibration method. */
    public val type: Enumeration<DeviceMetricCalibrationType>? = null,
    /** Describes the state of the calibration. */
    public val state: Enumeration<DeviceMetricCalibrationState>? = null,
    /** Describes the time last calibration has been performed. */
    public val time: Instant? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type
          state = this@with.state
          time = this@with.time?.toBuilder()
        }
      }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and managable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and managable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /** Describes the type of the calibration method. */
      public var type: Enumeration<DeviceMetricCalibrationType>? = null

      /** Describes the state of the calibration. */
      public var state: Enumeration<DeviceMetricCalibrationState>? = null

      /** Describes the time last calibration has been performed. */
      public var time: Instant.Builder? = null

      public fun build(): Calibration =
        Calibration(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type,
          state = state,
          time = time?.build(),
        )
    }
  }

  public class Builder(
    /**
     * Describes the type of the metric. For example: Heart Rate, PEEP Setting, etc.
     *
     * DeviceMetric.type can be referred to either IEEE 11073-10101 or LOINC.
     */
    public var type: CodeableConcept.Builder,
    /**
     * Describes the link to the Device. This is also known as a channel device.
     *
     * Note if this is not the top level device - also know as the source device, it may be
     * referenced in the device.parent element.
     */
    public var device: Reference.Builder,
    /**
     * Indicates the category of the observation generation process. A DeviceMetric can be for
     * example a setting, measurement, or calculation.
     */
    public var category: Enumeration<DeviceMetricCategory>,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
     */
    public var id: String? = null

    /**
     * The metadata about the resource. This is content that is maintained by the infrastructure.
     * Changes to the content might not always be associated with version changes to the resource.
     */
    public var meta: Meta.Builder? = null

    /**
     * A reference to a set of rules that were followed when the resource was constructed, and which
     * must be understood when processing the content. Often, this is a reference to an
     * implementation guide that defines the special rules along with other profiles etc.
     *
     * Asserting this rule set restricts the content to be only understood by a limited set of
     * trading partners. This inherently limits the usefulness of the data in the long term.
     * However, the existing health eco-system is highly fractured, and not yet ready to define,
     * collect, and exchange data in a generally computable sense. Wherever possible, implementers
     * and/or specification writers should avoid using this element. Often, when used, the URL is a
     * reference to an implementation guide that defines these special rules as part of its
     * narrative along with other profiles, value sets, etc.
     */
    public var implicitRules: Uri.Builder? = null

    /**
     * The base language in which the resource is written.
     *
     * Language is provided to support indexing and accessibility (typically, services such as text
     * to speech use the language tag). The html language tag in the narrative applies to the
     * narrative. The language tag on the resource may be used to specify the language of other
     * presentations generated from the data in the resource. Not all the content has to be in the
     * base language. The Resource.language should not be assumed to apply to the narrative
     * automatically. If a language is specified, it should it also be specified on the div element
     * in the html (see rules in HTML5 for information about the relationship between xml:lang and
     * the html lang attribute).
     */
    public var language: Code.Builder? = null

    /**
     * A human-readable narrative that contains a summary of the resource and can be used to
     * represent the content of the resource to a human. The narrative need not encode all the
     * structured data, but is required to contain sufficient detail to make it "clinically safe"
     * for a human to just read the narrative. Resource definitions may define what content should
     * be represented in the narrative to ensure clinical safety.
     *
     * Contained resources do not have a narrative. Resources that are not contained SHOULD have a
     * narrative. In some cases, a resource may only have text with little or no additional discrete
     * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
     * legacy systems where information is captured as a "text blob" or where text is additionally
     * entered raw or narrated and encoded information is added later.
     */
    public var text: Narrative.Builder? = null

    /**
     * These resources do not have an independent existence apart from the resource that contains
     * them - they cannot be identified independently, nor can they have their own independent
     * transaction scope. This is allowed to be a Parameters resource if and only if it is
     * referenced by a resource that provides context/meaning.
     *
     * This should never be done when the content can be identified properly, as once identification
     * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
     * resources may have profiles and tags in their meta elements, but SHALL NOT have security
     * labels.
     */
    public var contained: MutableList<Resource.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource. To make the use of extensions safe and managable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public var extension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource and that modifies the understanding of the element that contains it and/or the
     * understanding of the containing element's descendants. Usually modifier elements provide
     * negation or qualification. To make the use of extensions safe and managable, there is a
     * strict set of governance applied to the definition and use of extensions. Though any
     * implementer is allowed to define an extension, there is a set of requirements that SHALL be
     * met as part of the definition of the extension. Applications processing a resource are
     * required to check for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * Instance identifiers assigned to a device, by the device or gateway software, manufacturers,
     * other organizations or owners. For example, handle ID.
     *
     * For identifiers assigned to a device by the device or gateway software, the `system` element
     * of the identifier should be set to any identifier of the device.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Describes the unit that an observed value determined for this metric will have. For example:
     * Percent, Seconds, etc.
     *
     * DeviceMetric.unit can refer to either UCUM or preferable a RTMMS coding system.
     */
    public var unit: CodeableConcept.Builder? = null

    /** Indicates current operational state of the device. For example: On, Off, Standby, etc. */
    public var operationalStatus: Enumeration<DeviceMetricOperationalStatus>? = null

    /**
     * The preferred color associated with the metric (e.g., display color). This is often used to
     * aid clinicians to track and identify parameter types by color. In practice, consider a
     * Patient Monitor that has ECG/HR and Pleth; the metrics are displayed in different
     * characteristic colors, such as HR in blue, BP in green, and PR and SpO2 in magenta.
     */
    public var color: Code.Builder? = null

    /**
     * The frequency at which the metric is taken or recorded. Devices measure metrics at a wide
     * range of frequencies; for example, an ECG might sample measurements in the millisecond range,
     * while an NIBP might trigger only once an hour. Less often, the measurementFrequency may be
     * based on a unit other than time, such as distance (e.g. for a measuring wheel). The update
     * period may be different than the measurement frequency, if the device does not update the
     * published observed value with the same frequency as it was measured.
     */
    public var measurementFrequency: Quantity.Builder? = null

    /** Describes the calibrations that have been performed or that are required to be performed. */
    public var calibration: MutableList<Calibration.Builder> = mutableListOf()

    override fun build(): DeviceMetric =
      DeviceMetric(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        type = type.build(),
        unit = unit?.build(),
        device = device.build(),
        operationalStatus = operationalStatus,
        color = color?.build(),
        category = category,
        measurementFrequency = measurementFrequency?.build(),
        calibration = calibration.map { it.build() },
      )
  }

  /** Describes the type of a metric calibration. */
  public enum class DeviceMetricCalibrationType(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Unspecified("unspecified", "http://hl7.org/fhir/metric-calibration-type", "Unspecified"),
    Offset("offset", "http://hl7.org/fhir/metric-calibration-type", "Offset"),
    Gain("gain", "http://hl7.org/fhir/metric-calibration-type", "Gain"),
    Two_Point("two-point", "http://hl7.org/fhir/metric-calibration-type", "Two Point");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): DeviceMetricCalibrationType =
        when (code) {
          "unspecified" -> Unspecified
          "offset" -> Offset
          "gain" -> Gain
          "two-point" -> Two_Point
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum DeviceMetricCalibrationType"
            )
        }
    }
  }

  /** Describes the state of a metric calibration. */
  public enum class DeviceMetricCalibrationState(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Not_Calibrated(
      "not-calibrated",
      "http://hl7.org/fhir/metric-calibration-state",
      "Not Calibrated",
    ),
    Calibration_Required(
      "calibration-required",
      "http://hl7.org/fhir/metric-calibration-state",
      "Calibration Required",
    ),
    Calibrated("calibrated", "http://hl7.org/fhir/metric-calibration-state", "Calibrated"),
    Unspecified("unspecified", "http://hl7.org/fhir/metric-calibration-state", "Unspecified");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): DeviceMetricCalibrationState =
        when (code) {
          "not-calibrated" -> Not_Calibrated
          "calibration-required" -> Calibration_Required
          "calibrated" -> Calibrated
          "unspecified" -> Unspecified
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum DeviceMetricCalibrationState"
            )
        }
    }
  }

  /** Describes the operational status of the DeviceMetric. */
  public enum class DeviceMetricOperationalStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    On("on", "http://hl7.org/fhir/metric-operational-status", "On"),
    Off("off", "http://hl7.org/fhir/metric-operational-status", "Off"),
    Standby("standby", "http://hl7.org/fhir/metric-operational-status", "Standby"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/metric-operational-status",
      "Entered In Error",
    );

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): DeviceMetricOperationalStatus =
        when (code) {
          "on" -> On
          "off" -> Off
          "standby" -> Standby
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum DeviceMetricOperationalStatus"
            )
        }
    }
  }

  /** Describes the category of the metric. */
  public enum class DeviceMetricCategory(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Measurement("measurement", "http://hl7.org/fhir/metric-category", "Measurement"),
    Setting("setting", "http://hl7.org/fhir/metric-category", "Setting"),
    Calculation("calculation", "http://hl7.org/fhir/metric-category", "Calculation"),
    Unspecified("unspecified", "http://hl7.org/fhir/metric-category", "Unspecified");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): DeviceMetricCategory =
        when (code) {
          "measurement" -> Measurement
          "setting" -> Setting
          "calculation" -> Calculation
          "unspecified" -> Unspecified
          else -> throw IllegalArgumentException("Unknown code $code for enum DeviceMetricCategory")
        }
    }
  }
}

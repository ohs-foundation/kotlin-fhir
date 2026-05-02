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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.serializers.SignatureSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Signature Type: A signature along with supporting context. The
 * signature may be a digital signature that is cryptographic in nature, or some other signature
 * acceptable to the domain. This other signature may be as simple as a graphical image representing
 * a hand-written signature, or a signature ceremony Different signature approaches have different
 * utilities.
 */
@Serializable(with = SignatureSerializer::class)
public data class Signature(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and manageable, there is a strict set of governance
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
   * An indication of the reason that the entity signed this document. This may be explicitly
   * included as part of the signature information and can be used when determining accountability
   * for various actions concerning the document.
   *
   * Examples include attesting to: authorship, correct transcription, and witness of specific
   * event. Also known as a &quot;Commitment Type Indication&quot;.
   */
  public val type: List<Coding>,
  /**
   * When the digital signature was signed.
   *
   * This should agree with the information in the signature.
   */
  public val `when`: Instant,
  /**
   * A reference to an application-usable description of the identity that signed (e.g. the
   * signature used their private key).
   *
   * This should agree with the information in the signature.
   */
  public val who: Reference,
  /**
   * A reference to an application-usable description of the identity that is represented by the
   * signature.
   *
   * The party that can't sign. For example a child.
   */
  public val onBehalfOf: Reference? = null,
  /**
   * A mime type that indicates the technical format of the target resources signed by the
   * signature.
   *
   * "xml", "json" and "ttl" are allowed, which describe the simple encodings described in the
   * specification (and imply appropriate bundle support). Otherwise, mime types are legal here.
   */
  public val targetFormat: Code? = null,
  /**
   * A mime type that indicates the technical format of the signature. Important mime types are
   * application/signature+xml for X ML DigSig, application/jose for JWS, and image&#47;* for a
   * graphical image of a signature, etc.
   */
  public val sigFormat: Code? = null,
  /**
   * The base64 encoding of the Signature content. When signature is not recorded electronically
   * this element would be empty.
   *
   * Where the signature type is an XML DigSig, the signed content is a FHIR Resource(s), the
   * signature is of the XML form of the Resource(s) using XML-Signature (XMLDIG) "Detached
   * Signature" form.
   */
  public val `data`: Base64Binary? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder(type.map { it.toBuilder() }.toMutableList(), `when`.toBuilder(), who.toBuilder())
        .apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          onBehalfOf = this@with.onBehalfOf?.toBuilder()
          targetFormat = this@with.targetFormat?.toBuilder()
          sigFormat = this@with.sigFormat?.toBuilder()
          `data` = this@with.`data`?.toBuilder()
        }
    }

  public open class Builder(
    /**
     * An indication of the reason that the entity signed this document. This may be explicitly
     * included as part of the signature information and can be used when determining accountability
     * for various actions concerning the document.
     *
     * Examples include attesting to: authorship, correct transcription, and witness of specific
     * event. Also known as a &quot;Commitment Type Indication&quot;.
     */
    public open var type: MutableList<Coding.Builder>,
    /**
     * When the digital signature was signed.
     *
     * This should agree with the information in the signature.
     */
    public open var `when`: Instant.Builder,
    /**
     * A reference to an application-usable description of the identity that signed (e.g. the
     * signature used their private key).
     *
     * This should agree with the information in the signature.
     */
    public open var who: Reference.Builder,
  ) {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: String? = null

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element. To make the use of extensions safe and manageable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * A reference to an application-usable description of the identity that is represented by the
     * signature.
     *
     * The party that can't sign. For example a child.
     */
    public open var onBehalfOf: Reference.Builder? = null

    /**
     * A mime type that indicates the technical format of the target resources signed by the
     * signature.
     *
     * "xml", "json" and "ttl" are allowed, which describe the simple encodings described in the
     * specification (and imply appropriate bundle support). Otherwise, mime types are legal here.
     */
    public open var targetFormat: Code.Builder? = null

    /**
     * A mime type that indicates the technical format of the signature. Important mime types are
     * application/signature+xml for X ML DigSig, application/jose for JWS, and image&#47;* for a
     * graphical image of a signature, etc.
     */
    public open var sigFormat: Code.Builder? = null

    /**
     * The base64 encoding of the Signature content. When signature is not recorded electronically
     * this element would be empty.
     *
     * Where the signature type is an XML DigSig, the signed content is a FHIR Resource(s), the
     * signature is of the XML form of the Resource(s) using XML-Signature (XMLDIG) "Detached
     * Signature" form.
     */
    public open var `data`: Base64Binary.Builder? = null

    public open fun build(): Signature =
      Signature(
        id = id,
        extension = extension.map { it.build() },
        type = type.map { it.build() },
        `when` = `when`.build(),
        who = who.build(),
        onBehalfOf = onBehalfOf?.build(),
        targetFormat = targetFormat?.build(),
        sigFormat = sigFormat?.build(),
        `data` = `data`?.build(),
      )
  }
}

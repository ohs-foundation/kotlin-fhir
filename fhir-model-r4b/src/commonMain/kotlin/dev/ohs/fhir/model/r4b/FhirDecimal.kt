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

package dev.ohs.fhir.model.r4b

import com.ionspin.kotlin.bignum.BigNumber
import com.ionspin.kotlin.bignum.decimal.BigDecimal
import com.ionspin.kotlin.bignum.integer.BigInteger
import kotlin.Any
import kotlin.Boolean
import kotlin.Byte
import kotlin.Comparable
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Pair
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort

/**
 * FHIR `decimal` value: a precision-preserving rational number backed by an ionspin `BigDecimal`.
 * The wrapped value is kept `internal`; consumers operate on this type through its `BigNumber`
 * arithmetic surface and call [toString] for the exact lexical form.
 */
public class FhirDecimal
private constructor(
  internal val bigDecimal: BigDecimal,
  /** The exact lexical form to emit on the wire. */
  internal val wire: String,
) : BigNumber<FhirDecimal>, Comparable<Any> {
  override val isNegative: Boolean
    get() = bigDecimal.isNegative

  override val isPositive: Boolean
    get() = bigDecimal.isPositive

  override fun getCreator(): BigNumber.Creator<FhirDecimal> = FhirDecimal

  override fun add(other: FhirDecimal): FhirDecimal =
    fromBigDecimal(bigDecimal.add(other.bigDecimal))

  override fun subtract(other: FhirDecimal): FhirDecimal =
    fromBigDecimal(bigDecimal.subtract(other.bigDecimal))

  override fun multiply(other: FhirDecimal): FhirDecimal =
    fromBigDecimal(bigDecimal.multiply(other.bigDecimal))

  override fun divide(other: FhirDecimal): FhirDecimal =
    fromBigDecimal(bigDecimal.divide(other.bigDecimal))

  override fun remainder(other: FhirDecimal): FhirDecimal =
    fromBigDecimal(bigDecimal.remainder(other.bigDecimal))

  override fun divideAndRemainder(other: FhirDecimal): Pair<FhirDecimal, FhirDecimal> {
    val (quotient, rem) = bigDecimal.divideAndRemainder(other.bigDecimal)
    return fromBigDecimal(quotient) to fromBigDecimal(rem)
  }

  override fun isZero(): Boolean = bigDecimal.isZero()

  override fun negate(): FhirDecimal = fromBigDecimal(bigDecimal.negate())

  override fun abs(): FhirDecimal = fromBigDecimal(bigDecimal.abs())

  override fun pow(exponent: Long): FhirDecimal = fromBigDecimal(bigDecimal.pow(exponent))

  override fun pow(exponent: Int): FhirDecimal = fromBigDecimal(bigDecimal.pow(exponent))

  override fun signum(): Int = bigDecimal.signum()

  override fun numberOfDecimalDigits(): Long = bigDecimal.numberOfDecimalDigits()

  override operator fun compareTo(other: Any): Int =
    if (other is FhirDecimal) bigDecimal.compareTo(other.bigDecimal)
    else bigDecimal.compareTo(other)

  override operator fun unaryMinus(): FhirDecimal = fromBigDecimal(bigDecimal.unaryMinus())

  override fun secureOverwrite() {
    bigDecimal.secureOverwrite()
  }

  override fun equals(other: Any?): Boolean = other is FhirDecimal && bigDecimal == other.bigDecimal

  override fun hashCode(): Int = bigDecimal.hashCode()

  override fun toString(): String = wire

  override fun toString(base: Int): String = bigDecimal.toString(base)

  /**
   * Returns the underlying value as an ionspin `BigDecimal` (loses the preserved [wire] lexical
   * form; for the exact serialized text call [toString]).
   */
  public fun asBigDecimal(): BigDecimal = bigDecimal

  public operator fun plus(other: FhirDecimal): FhirDecimal = add(other)

  public operator fun minus(other: FhirDecimal): FhirDecimal = subtract(other)

  public operator fun times(other: FhirDecimal): FhirDecimal = multiply(other)

  public operator fun div(other: FhirDecimal): FhirDecimal = divide(other)

  public operator fun rem(other: FhirDecimal): FhirDecimal = remainder(other)

  public companion object : BigNumber.Creator<FhirDecimal> {
    override val ZERO: FhirDecimal = fromBigDecimal(BigDecimal.ZERO)

    override val ONE: FhirDecimal = fromBigDecimal(BigDecimal.ONE)

    override val TWO: FhirDecimal = fromBigDecimal(BigDecimal.TWO)

    override val TEN: FhirDecimal = fromBigDecimal(BigDecimal.TEN)

    /**
     * Parses a wire/lexical decimal, preserving its exact lexical form for round-tripping. Throws
     * if [string] is not a parseable decimal number.
     */
    public fun fromString(string: String): FhirDecimal =
      FhirDecimal(BigDecimal.parseString(string), string)

    /** Wraps a [BigDecimal], using its plain-string form as the wire representation. */
    public fun fromBigDecimal(bigDecimal: BigDecimal): FhirDecimal =
      FhirDecimal(bigDecimal, bigDecimal.toPlainString())

    override fun parseString(string: String, base: Int): FhirDecimal =
      if (base == 10) fromString(string) else fromBigDecimal(BigDecimal.parseString(string, base))

    override fun fromULong(uLong: ULong): FhirDecimal = fromBigDecimal(BigDecimal.fromULong(uLong))

    override fun fromUInt(uInt: UInt): FhirDecimal = fromBigDecimal(BigDecimal.fromUInt(uInt))

    override fun fromUShort(uShort: UShort): FhirDecimal =
      fromBigDecimal(BigDecimal.fromUShort(uShort))

    override fun fromUByte(uByte: UByte): FhirDecimal = fromBigDecimal(BigDecimal.fromUByte(uByte))

    override fun fromLong(long: Long): FhirDecimal = fromBigDecimal(BigDecimal.fromLong(long))

    override fun fromInt(int: Int): FhirDecimal = fromBigDecimal(BigDecimal.fromInt(int))

    override fun fromShort(short: Short): FhirDecimal = fromBigDecimal(BigDecimal.fromShort(short))

    override fun fromByte(byte: Byte): FhirDecimal = fromBigDecimal(BigDecimal.fromByte(byte))

    override fun fromBigInteger(bigInteger: BigInteger): FhirDecimal =
      fromBigDecimal(BigDecimal.fromBigInteger(bigInteger))

    override fun tryFromFloat(float: Float, exactRequired: Boolean): FhirDecimal =
      fromBigDecimal(BigDecimal.tryFromFloat(float, exactRequired))

    override fun tryFromDouble(double: Double, exactRequired: Boolean): FhirDecimal =
      fromBigDecimal(BigDecimal.tryFromDouble(double, exactRequired))
  }
}

package ca.elliot.fractions.dto

import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.lang3.builder.HashCodeBuilder

class FractionDto(val numerator: Int, val denominator: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (javaClass != other?.javaClass) {
            return false
        }

        other as FractionDto

        return EqualsBuilder().append(numerator, other.numerator).append(denominator, other.denominator).isEquals
    }

    override fun hashCode(): Int {
        return HashCodeBuilder(17*numerator, 37*denominator).append(numerator).append(denominator).toHashCode()
    }

    override fun toString(): String {
        return "($numerator/$denominator)"
    }


}
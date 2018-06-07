package ca.elliot.fractions.extensions

import ca.elliot.fractions.constants.FractionConstants
import ca.elliot.fractions.dto.FractionDto

fun FractionDto.add(rightFraction: FractionDto): FractionDto {

//    validate valid parameters
    if (((this.numerator > 0 || this.numerator < 0) && this.denominator == 0) ||
            ((rightFraction.numerator > 0 || rightFraction.numerator < 0) && rightFraction.denominator == 0)) {
        throw IllegalArgumentException(FractionConstants.EXCEPTION_MESSAGE_DIVISION_BY_ZERO)
    }

//    when one of the fraction has a 0 numerator, we don't need to do the addition, we can return the other fraction
    if (this.numerator == 0) {
        return rightFraction
    } else if (rightFraction.numerator == 0) {
        return this
    }

    val commonDenominator = this.denominator * rightFraction.denominator

    val leftNumeratorWithCommonDenominator = this.numerator * rightFraction.denominator
    val rightNumeratorWithCommonDenominator = rightFraction.numerator * this.denominator

    return FractionDto(numerator = leftNumeratorWithCommonDenominator + rightNumeratorWithCommonDenominator, denominator = commonDenominator)
}

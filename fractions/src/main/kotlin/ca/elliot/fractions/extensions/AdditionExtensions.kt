package ca.elliot.fractions.extensions

import ca.elliot.fractions.constants.FractionConstants
import ca.elliot.fractions.dto.FractionDto

/**
 * Addition of two [FractionDto]
 * ex: 1/2 + 1/3 = 3/6 + 2/6 = 5/6
 * @receiver [FractionDto] the left fraction
 * @param rightFraction [FractionDto] the right fraction
 * @return [FractionDto] final fraction
 * @throws IllegalArgumentException on denominator = 0 when the numerator is different than 0
 */
fun FractionDto.add(rightFraction: FractionDto): FractionDto {

//    validate valid parameters
    this.validate()
    rightFraction.validate()

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

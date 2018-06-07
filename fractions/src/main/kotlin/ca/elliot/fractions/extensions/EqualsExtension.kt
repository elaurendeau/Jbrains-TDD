package ca.elliot.fractions.extensions

import ca.elliot.fractions.dto.FractionDto

/**
 * Addition of two [FractionDto]
 * ex: 1/2 + 1/3 = 3/6 + 2/6 = 5/6
 * @receiver [FractionDto] the left fraction
 * @param rightFraction [FractionDto] the right fraction
 * @return [FractionDto] final fraction
 * @throws IllegalArgumentException on denominator = 0 when the numerator is different than 0
 */
fun FractionDto.same(rightFraction: FractionDto): Boolean {
    //    validate valid parameters
    this.validate()
    rightFraction.validate()

    val reducedLeftFraction = this.reduce()
    val reducedRightFraction = rightFraction.reduce()

    return reducedLeftFraction.numerator == reducedRightFraction.numerator && reducedLeftFraction.denominator == reducedRightFraction.denominator
}

package ca.elliot.fractions.extensions

import ca.elliot.fractions.constants.FractionConstants
import ca.elliot.fractions.dto.FractionDto

/**
 * Validate a [FractionDto]
 * ex: 15/0 is invalid, 0/1 is valid
 * @receiver [FractionDto] the fraction to validate
 * @throws IllegalArgumentException on denominator = 0 when the numerator is different than 0
 */
fun FractionDto.validate() {
    if (((this.numerator > 0 || this.numerator < 0) && this.denominator == 0)) {
        throw IllegalArgumentException(FractionConstants.EXCEPTION_MESSAGE_DIVISION_BY_ZERO)
    }

    if(this.denominator < 0) {
        throw IllegalArgumentException(FractionConstants.EXCEPTION_MESSAGE_NEGATIVE_DENOMINATOR)
    }
}
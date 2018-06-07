package ca.elliot.fractions.extensions

import ca.elliot.fractions.dto.FractionDto

/**
 * Reduction of a [FractionDto]
 * ex: 2/12 = 1/6 ou 0/1 = 0/0
 * @receiver [FractionDto] the fraction to reduce
 * @return [FractionDto] reduced
 * @throws IllegalArgumentException on denominator = 0 when the numerator is different than 0
 */
fun FractionDto.reduce(): FractionDto {

//    validate the faction
    this.validate()

//    when the numerator is 0, the denominator should always be 0
    if(this.numerator == 0 && this.denominator != 0) {
        return FractionDto(numerator = 0, denominator = 0)
    }

    for(i in 2..this.denominator) {
        if(this.numerator.rem(i) == 0 && this.denominator.rem(i) == 0) {
            return FractionDto(numerator= this.numerator/i, denominator = this.denominator/i)
        }
    }

    return this
}
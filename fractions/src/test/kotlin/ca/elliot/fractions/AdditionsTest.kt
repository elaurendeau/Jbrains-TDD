package ca.elliot.fractions

import ca.elliot.fractions.constants.FractionConstants
import ca.elliot.fractions.dto.FractionDto
import ca.elliot.fractions.extensions.add
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdditionsTest {

    //    4/5 + 7/3 = 47/15
    @Test
    internal fun `valid addition of two positive numbers with different denominators`() {
        val resultingFraction = FractionDto(numerator = 4, denominator = 5).add(FractionDto(numerator = 7, denominator = 3))

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(47)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(15)
    }

    //    0/0 + 0/0 = 0/0
    @Test
    internal fun `valid addition of two zero numbers`() {
        val resultingFraction = FractionDto(numerator = 0, denominator = 0).add(FractionDto(numerator = 0, denominator = 0))

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(0)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(0)
    }

    //    1/2 + 0/0 = 1/2
    @Test
    internal fun `valid addition of a zero and a left positive number`() {
        val resultingFraction = FractionDto(numerator = 0, denominator = 0).add(FractionDto(numerator = 1, denominator = 2))

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(1)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(2)
    }

    //    0/0 + 1/2 = 1/2
    @Test
    internal fun `valid addition of a zero and a right positive number`() {
        val resultingFraction = FractionDto(numerator = 1, denominator = 2).add(FractionDto(numerator = 0, denominator = 0))

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(1)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(2)
    }

    //    1/0 + 1/2 = illegal argument
    @Test
    internal fun `invalid addition with a 0 denominator on the left fraction`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            FractionDto(numerator = 1, denominator = 0).add(FractionDto(numerator = 1, denominator = 2))
        }.withMessage(FractionConstants.EXCEPTION_MESSAGE_DIVISION_BY_ZERO)

    }

    //    1/2 + 1/0 = illegal argument
    @Test
    internal fun `invalid addition with a 0 denominator on the right fraction`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            FractionDto(numerator = 1, denominator = 2).add(FractionDto(numerator = 1, denominator = 0))
        }.withMessage(FractionConstants.EXCEPTION_MESSAGE_DIVISION_BY_ZERO)

    }
}
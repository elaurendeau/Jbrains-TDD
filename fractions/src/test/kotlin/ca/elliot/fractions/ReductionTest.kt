package ca.elliot.fractions

import ca.elliot.fractions.dto.FractionDto
import ca.elliot.fractions.extensions.reduce
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReductionTest {

    //    4/3 = 4/3
    @Test
    internal fun `valid reduction that can't be reduced`() {
        val resultingFraction = FractionDto(numerator = 4, denominator = 3).reduce()

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(4)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(3)
    }

    //    2/12 = 1/6
    @Test
    internal fun `valid reduction with smaller numerator`() {
        val resultingFraction = FractionDto(numerator = 2, denominator = 12).reduce()

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(1)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(6)
    }

    //    15/3 = 5/1
    @Test
    internal fun `valid reduction with bigger numerator`() {
        val resultingFraction = FractionDto(numerator = 15, denominator = 3).reduce()

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(5)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(1)
    }

    //    -12/3 = -4/1
    @Test
    internal fun `valid reduction with a negative numerator`() {
        val resultingFraction = FractionDto(numerator = -12, denominator = 3).reduce()

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(-4)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(1)
    }
    //    0/0 = 0/0
    @Test
    internal fun `valid reduction of zero`() {
        val resultingFraction = FractionDto(numerator = 0, denominator = 0).reduce()

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(0)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(0)
    }

    //    0/1 = 0/0
    @Test
    internal fun `valid reduction of zero numerator and a non zero denominator`() {
        val resultingFraction = FractionDto(numerator = 0, denominator = 1).reduce()

        Assertions.assertThat(resultingFraction.numerator).isEqualTo(0)
        Assertions.assertThat(resultingFraction.denominator).isEqualTo(0)
    }
}
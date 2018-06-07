package ca.elliot.fractions

import ca.elliot.fractions.dto.FractionDto
import ca.elliot.fractions.extensions.add
import ca.elliot.fractions.extensions.reduce
import ca.elliot.fractions.extensions.same
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReductionTest {

    //    4/3 = 4/3
    @Test
    internal fun `valid reduction that can't be reduced`() {
        val expectedFraction = FractionDto(numerator = 4, denominator = 3)
        val actualFraction = FractionDto(numerator = 4, denominator = 3)

        Assertions.assertThat(actualFraction.same(expectedFraction)).isTrue()
    }

    //    2/12 = 1/6
    @Test
    internal fun `valid reduction with smaller numerator`() {
        val expectedFraction = FractionDto(numerator = 1, denominator = 6)
        val actualFraction = FractionDto(numerator = 2, denominator = 12)

        Assertions.assertThat(actualFraction.same(expectedFraction)).isTrue()
    }

    //    15/3 = 5/1
    @Test
    internal fun `valid reduction with bigger numerator`() {
        val expectedFraction = FractionDto(numerator = 5, denominator = 1)
        val actualFraction = FractionDto(numerator = 15, denominator = 3)

        Assertions.assertThat(actualFraction.same(expectedFraction)).isTrue()
    }

    //    -12/3 = -4/1
    @Test
    internal fun `valid reduction with a negative numerator`() {
        val expectedFraction = FractionDto(numerator = -4, denominator = 1)
        val actualFraction = FractionDto(numerator = -12, denominator = 3)

        Assertions.assertThat(actualFraction.same(expectedFraction)).isTrue()
    }
    //    0/0 = 0/0
    @Test
    internal fun `valid reduction of zero`() {
        val expectedFraction = FractionDto(numerator = 0, denominator = 0)
        val actualFraction = FractionDto(numerator = 0, denominator = 0)

        Assertions.assertThat(actualFraction.same(expectedFraction)).isTrue()
    }

    //    0/1 = 0/0
    @Test
    internal fun `valid reduction of zero numerator and a non zero denominator`() {
        val expectedFraction = FractionDto(numerator = 0, denominator = 0)
        val actualFraction = FractionDto(numerator = 0, denominator = 1)

        Assertions.assertThat(actualFraction.same(expectedFraction)).isTrue()
    }
}
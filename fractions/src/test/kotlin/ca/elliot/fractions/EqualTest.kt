package ca.elliot.fractions

import ca.elliot.fractions.dto.FractionDto
import ca.elliot.fractions.extensions.same
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EqualTest {

    //    5/3 == 5/4
    @Test
    internal fun `invalid equal fractions different denominator`() {
        assertThat(FractionDto(numerator = 5, denominator = 3).same(FractionDto(numerator = 5, denominator = 4))).isFalse()
    }

    //    5/3 == 7/3
    @Test
    internal fun `invalid equal fractions different numerator`() {
        assertThat(FractionDto(numerator = 5, denominator = 3).same(FractionDto(numerator = 7, denominator = 3))).isFalse()
    }
    //    5/3 == 5/3
    @Test
    internal fun `valid equal fractions`() {
        assertThat(FractionDto(numerator = 5, denominator = 3).same(FractionDto(numerator = 5, denominator = 3))).isTrue()
    }
}
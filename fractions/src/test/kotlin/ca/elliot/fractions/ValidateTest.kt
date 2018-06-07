package ca.elliot.fractions

import ca.elliot.fractions.constants.FractionConstants
import ca.elliot.fractions.dto.FractionDto
import ca.elliot.fractions.extensions.validate
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidateTest {

    //    15/0 = illegal argument
    @Test
    internal fun `invalid fraction with zero denominator and positive numerator`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            FractionDto(numerator = 15, denominator = 0).validate()
        }.withMessage(FractionConstants.EXCEPTION_MESSAGE_DIVISION_BY_ZERO)
    }
    //    5/-1
    @Test
    internal fun `invalid fraction with negative denominator`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            FractionDto(numerator = 5, denominator = -1).validate()
        }.withMessage(FractionConstants.EXCEPTION_MESSAGE_NEGATIVE_DENOMINATOR)
    }

    //    -15/0 = illegal argument
    @Test
    internal fun `invalid fraction with zero denominator and negative numerator`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            FractionDto(numerator = -15, denominator = 0).validate()
        }.withMessage(FractionConstants.EXCEPTION_MESSAGE_DIVISION_BY_ZERO)
    }

    //    0/0 = nothing
    @Test
    internal fun `valid fraction with zero denominator`() {
        FractionDto(numerator = 0, denominator = 0).validate()
    }

    //    0/1 = nothing
    @Test
    internal fun `valid fraction`() {
        FractionDto(numerator = 0, denominator = 1).validate()
    }
}
package ca.elliot.oneitemsale

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OneItemSaleTest {
    @Test
    internal fun `valid barcode received`() {

        val display = Display()
        val productScanner = ProductScanner(display)

        val barcode = "1234"
        productScanner.scan(barcode)

        Assertions.assertThat(display.text).isEqualTo("7.25$")
    }

    @Test
    internal fun `second valid barcode received`() {

        val display = Display()
        val productScanner = ProductScanner(display)

        val barcode = "3241234"
        productScanner.scan(barcode)

        Assertions.assertThat(display.text).isEqualTo("8.25$")
    }




    class ProductScanner(val display: Display) {

        fun scan(barcode: String) {

            display.text = if(barcode == "1234") {
                "7.25$"
            } else {
                "8.25$"
            }

        }

    }

    class Display {
        var text: String = "7.25$"

    }
}



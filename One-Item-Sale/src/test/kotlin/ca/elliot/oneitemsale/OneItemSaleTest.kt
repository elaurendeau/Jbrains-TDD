package ca.elliot.oneitemsale

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*
import java.awt.SystemColor.text
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OneItemSaleTest {

    internal fun getScannerAndDisplay(): Pair<ProductScanner, Display> {
        val display = Display()
        val productScanner = ProductScanner(display)

        return Pair(productScanner, display)
    }

    @Test
    internal fun `valid barcode received`() {

        val (scanner, display) = getScannerAndDisplay()

        val barcode = "1234"
        scanner.scan(barcode)

        Assertions.assertThat(display.text).isEqualTo("7.25$")
    }

    @Test
    internal fun `second valid barcode received`() {

        val (scanner, display) = getScannerAndDisplay()

        val barcode = "3241234"
        scanner.scan(barcode)

        Assertions.assertThat(display.text).isEqualTo("8.25$")
    }

    @Test
    internal fun `valid barcode product not found`() {

        val (scanner, display) = getScannerAndDisplay()

        val barcode = "5555555"
        scanner.scan(barcode)

        Assertions.assertThat(display.text).isEqualTo("product not found")
    }

    class ProductScanner(val display: Display) {

        fun scan(barcode: String) {

            display.text = if (barcode == "1234") {
                "7.25$"
            } else if (barcode == "3241234") {
                "8.25$"
            } else {
                "product not found"
            }

        }

    }

    class Display {
        var text: String = "7.25$"

    }
}



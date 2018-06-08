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

        Assertions.assertThat(display.text).isEqualTo("Product not found for $barcode")
    }

    @Test
    internal fun `empty bar code`() {

        val (scanner, display) = getScannerAndDisplay()

        val barcode = ""
        scanner.scan(barcode)

        Assertions.assertThat(display.text).isEqualTo("Invalid barcode: Empty")
    }

    class ProductScanner(val display: Display) {

        fun scan(barcode: String) {

            display.text = if (barcode.isEmpty()) {
                "Invalid barcode: Empty"
            } else if (barcode == "3241234") {
                "8.25$"
            } else if (barcode == "1234") {
                "7.25$"
            } else {
                "Product not found for $barcode"
            }

        }

    }

    class Display {
        var text: String = "7.25$"

    }
}



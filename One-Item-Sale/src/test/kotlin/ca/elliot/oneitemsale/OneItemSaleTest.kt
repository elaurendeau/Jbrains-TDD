package ca.elliot.oneitemsale

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*
import java.awt.SystemColor.text
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OneItemSaleTest {

    private fun getScannerAndDisplay(): Pair<ProductScanner, Display> {
        val display = Display()
        val productScanner = ProductScanner(display, hashMapOf("3241234" to "8.25$", "1234" to "7.25$"))

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

    class ProductScanner(private val display: Display, private val barcodeToPriceMap: Map<String, String>) {

        fun scan(barcode: String) {
            display.text = if (barcode.isEmpty()) {
                "Invalid barcode: Empty"
            } else {
                barcodeToPriceMap.getOrDefault(barcode, "Product not found for $barcode")
            }
        }

    }

    class Display {
        var text: String = "7.25$"

    }
}



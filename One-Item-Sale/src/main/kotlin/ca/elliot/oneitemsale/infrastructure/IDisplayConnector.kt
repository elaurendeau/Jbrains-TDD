package ca.elliot.oneitemsale.infrastructure

import ca.elliot.oneitemsale.dto.BarcodeErrorDto
import ca.elliot.oneitemsale.dto.ProductErrorDto
import java.math.BigDecimal

interface IDisplayConnector {
    fun display(price: BigDecimal): Unit
    fun display(error: ProductErrorDto): Unit
    fun display(error: BarcodeErrorDto): Unit
}
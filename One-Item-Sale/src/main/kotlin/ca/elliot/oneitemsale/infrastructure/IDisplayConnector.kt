package ca.elliot.oneitemsale.infrastructure

import ca.elliot.oneitemsale.dto.ProductErrorDto
import ca.elliot.oneitemsale.enumeration.SaleErrorEnum
import java.math.BigDecimal

interface IDisplayConnector {
    fun display(price: BigDecimal): Unit
    fun display(error: SaleErrorEnum): Unit
    fun display(error: ProductErrorDto): Unit
}
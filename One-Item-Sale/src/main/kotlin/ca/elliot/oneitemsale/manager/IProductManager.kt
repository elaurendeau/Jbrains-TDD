package ca.elliot.oneitemsale.manager

import java.math.BigDecimal
import java.util.*

interface IProductManager {
    fun getPrice(barcode: String): BigDecimal?
}
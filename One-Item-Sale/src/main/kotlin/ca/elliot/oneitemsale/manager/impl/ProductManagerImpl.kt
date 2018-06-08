package ca.elliot.oneitemsale.manager.impl

import ca.elliot.oneitemsale.manager.IProductManager
import java.math.BigDecimal
import java.util.*

class ProductManagerImpl(private val barcodeToPriceMap: Map<String, BigDecimal>): IProductManager {

    override fun getPrice(barcode: String): BigDecimal? {
            return barcodeToPriceMap.get(barcode)
    }
}
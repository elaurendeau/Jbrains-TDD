package ca.elliot.oneitemsale.service.impl

import ca.elliot.oneitemsale.enumeration.SaleErrorEnum
import ca.elliot.oneitemsale.infrastructure.IDisplayConnector
import ca.elliot.oneitemsale.manager.IProductManager
import ca.elliot.oneitemsale.service.ISaleService

class SaleServiceImpl(private val productManager: IProductManager, private val displayConnector: IDisplayConnector): ISaleService {
    override fun scan(barcode: String) {

        if(barcode.isEmpty()) {
            displayConnector.display(SaleErrorEnum.BARCODE_EMPTY)
        } else {

            val price = productManager.getPrice(barcode)
            price?.let { displayConnector.display(it) }
        }
    }
}
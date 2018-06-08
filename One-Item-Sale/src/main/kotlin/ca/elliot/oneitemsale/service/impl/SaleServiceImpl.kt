package ca.elliot.oneitemsale.service.impl

import ca.elliot.oneitemsale.dto.ProductErrorDto
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
            if(price == null) {
                 displayConnector.display(ProductErrorDto(ProductErrorDto.ErrorEnum.PRODUCT_NOT_FOUND, barcode))
            } else {
                price?.let { displayConnector.display(it) }
            }
        }
    }
}
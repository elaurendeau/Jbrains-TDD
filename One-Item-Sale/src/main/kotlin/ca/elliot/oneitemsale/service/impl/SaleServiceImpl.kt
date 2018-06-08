package ca.elliot.oneitemsale.service.impl

import ca.elliot.oneitemsale.dto.BarcodeErrorDto
import ca.elliot.oneitemsale.dto.ProductErrorDto
import ca.elliot.oneitemsale.infrastructure.IDisplayConnector
import ca.elliot.oneitemsale.manager.IBarcodeManager
import ca.elliot.oneitemsale.manager.IProductManager
import ca.elliot.oneitemsale.service.ISaleService

class SaleServiceImpl(private val productManager: IProductManager, private val barcodeManager: IBarcodeManager, private val displayConnector: IDisplayConnector): ISaleService {
    override fun scan(barcode: String) {

        val barcodeError = barcodeManager.validate(barcode)
        if(barcodeError != null) {
            barcodeError.let { displayConnector.display(it) }
        } else {
            val price = productManager.getPrice(barcode)
            if(price == null) {
                 displayConnector.display(ProductErrorDto(ProductErrorDto.ErrorEnum.PRODUCT_NOT_FOUND, barcode))
            } else {
                price.let { displayConnector.display(it) }
            }
        }
    }
}
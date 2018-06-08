package ca.elliot.oneitemsale.infrastructure.impl

import ca.elliot.oneitemsale.dto.ProductErrorDto
import ca.elliot.oneitemsale.enumeration.SaleErrorEnum
import ca.elliot.oneitemsale.handler.IDisplayHandler
import ca.elliot.oneitemsale.infrastructure.IDisplayConnector
import java.math.BigDecimal

class DisplayConnectorImpl(private val displayHandler: IDisplayHandler): IDisplayConnector {
    override fun display(error: ProductErrorDto) {
        if(error.error == ProductErrorDto.ErrorEnum.PRODUCT_NOT_FOUND){
            displayHandler.display("Product number: ${error.productNumber} not found")
        }
    }

    private val errorMessages = hashMapOf(SaleErrorEnum.BARCODE_EMPTY to "Invalid barcode: Empty", SaleErrorEnum.PRODUCT_NOT_FOUND to "Product not found")
    override fun display(error: SaleErrorEnum) {
        val message = errorMessages.getOrDefault(error, "Unknown error")
        displayHandler.display(message)
    }

    override fun display(price: BigDecimal) {
        displayHandler.display(price.toString()+"$")
    }
}
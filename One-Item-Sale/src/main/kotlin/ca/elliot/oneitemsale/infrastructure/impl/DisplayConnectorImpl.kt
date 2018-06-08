package ca.elliot.oneitemsale.infrastructure.impl

import ca.elliot.oneitemsale.dto.BarcodeErrorDto
import ca.elliot.oneitemsale.dto.ProductErrorDto
import ca.elliot.oneitemsale.handler.IDisplayHandler
import ca.elliot.oneitemsale.infrastructure.IDisplayConnector
import java.math.BigDecimal

class DisplayConnectorImpl(private val displayHandler: IDisplayHandler): IDisplayConnector {
    override fun display(error: BarcodeErrorDto) {
        if(error.error == BarcodeErrorDto.ErrorEnum.BARCODE_EMPTY) {
            displayHandler.display("Invalid barcode: Empty")
        }
    }

    override fun display(error: ProductErrorDto) {
        if(error.error == ProductErrorDto.ErrorEnum.PRODUCT_NOT_FOUND){
            displayHandler.display("Product number: ${error.productNumber} not found")
        }
    }

    override fun display(price: BigDecimal) {
        displayHandler.display(price.toString()+"$")
    }
}
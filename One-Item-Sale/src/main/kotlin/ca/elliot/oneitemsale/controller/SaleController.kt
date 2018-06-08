package ca.elliot.oneitemsale.controller

import ca.elliot.oneitemsale.service.ISaleService

class SaleController(private val saleService: ISaleService) {

    fun scan(barcode: String) {
        saleService.scan(barcode)
    }
}
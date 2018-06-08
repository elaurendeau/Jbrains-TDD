package ca.elliot.oneitemsale.manager

import ca.elliot.oneitemsale.dto.BarcodeErrorDto


interface IBarcodeManager {
    fun validate(barcode: String): BarcodeErrorDto?
}
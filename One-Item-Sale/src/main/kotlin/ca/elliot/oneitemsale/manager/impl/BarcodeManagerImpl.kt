package ca.elliot.oneitemsale.manager.impl

import ca.elliot.oneitemsale.dto.BarcodeErrorDto
import ca.elliot.oneitemsale.manager.IBarcodeManager

class BarcodeManagerImpl: IBarcodeManager {
    override fun validate(barcode: String): BarcodeErrorDto? {
        if(barcode.isEmpty()) {
           return BarcodeErrorDto(BarcodeErrorDto.ErrorEnum.BARCODE_EMPTY, barcode)
        } else if (!barcode.matches(Regex("^\\d{8}\$"))){
            return BarcodeErrorDto(BarcodeErrorDto.ErrorEnum.BARCODE_INVALID, barcode)
        }
        return null
    }
}
package ca.elliot.oneitemsale.dto

class BarcodeErrorDto(val error: ErrorEnum, val barcode: String) {
    enum class ErrorEnum {
        BARCODE_EMPTY, BARCODE_INVALID
    }
}
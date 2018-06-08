package ca.elliot.oneitemsale.dto

class ProductErrorDto(val error: ErrorEnum, val productNumber: String) {
    enum class ErrorEnum {
        PRODUCT_NOT_FOUND
    }
}
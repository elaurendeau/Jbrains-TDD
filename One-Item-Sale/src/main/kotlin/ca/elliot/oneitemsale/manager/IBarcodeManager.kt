package ca.elliot.oneitemsale.manager


interface IBarcodeManager {
    fun validate(barcode: String): Boolean
}
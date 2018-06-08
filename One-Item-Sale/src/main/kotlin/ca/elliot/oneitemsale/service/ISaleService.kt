package ca.elliot.oneitemsale.service

interface ISaleService {
    fun scan(barcode: String): Unit
}
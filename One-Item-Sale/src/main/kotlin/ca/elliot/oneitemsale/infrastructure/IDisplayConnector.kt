package ca.elliot.oneitemsale.infrastructure

import java.math.BigDecimal

interface IDisplayConnector {
    fun display(price: BigDecimal): Unit
}
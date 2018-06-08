package ca.elliot.oneitemsale.infrastructure.impl

import ca.elliot.oneitemsale.handler.IDisplayHandler
import ca.elliot.oneitemsale.infrastructure.IDisplayConnector
import java.math.BigDecimal

class DisplayConnectorImpl(private val displayHandler: IDisplayHandler): IDisplayConnector {
    override fun display(price: BigDecimal) {
        displayHandler.display(price.toString()+"$")
    }
}
package ca.elliot.oneitemsale.manager.impl

import ca.elliot.oneitemsale.manager.IBarcodeManager

class BarcodeManagerImpl: IBarcodeManager {
    override fun validate(barcode: String): Boolean {
        return false;
    }
}
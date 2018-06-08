package ca.elliot.oneitemsale.handler.impl

import ca.elliot.oneitemsale.handler.IDisplayHandler

class DisplayHandlerImpl(private var text: String = ""): IDisplayHandler {
    override fun getDisplayedText(): String {
        return text
    }

    override fun display(text: String) {
        this.text = text
    }
}
package ca.elliot.oneitemsale.handler

interface IDisplayHandler {
    fun display(text: String): Unit
    fun getDisplayedText(): String
}
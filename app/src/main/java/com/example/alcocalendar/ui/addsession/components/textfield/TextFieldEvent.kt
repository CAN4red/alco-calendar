package com.example.alcocalendar.ui.addsession.components.textfield

sealed interface TextFieldEvent {
    data class AddDigit(val char: Char) : TextFieldEvent
    data object AddDot : TextFieldEvent
    data object EraseCharacter : TextFieldEvent
    data class UpdateField(val newTextValue: String) : TextFieldEvent
}
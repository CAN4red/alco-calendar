package com.example.alcocalendar.ui.addsession.components.textfield

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class TextFieldViewModel : ViewModel() {
    private val _textFieldState: MutableStateFlow<String> = MutableStateFlow("")

    val textFieldState: StateFlow<String> get() = _textFieldState

    val textFieldStateAsDouble: StateFlow<Double> = _textFieldState
        .map { it.toDoubleOrNull() ?: 0.0 }
        .stateIn(viewModelScope, SharingStarted.Lazily, 0.0)

    fun onTextFieldEvent(event: TextFieldEvent) {
        when (event) {
            is TextFieldEvent.AddNumber -> handleAddNumber(event.char)
            is TextFieldEvent.AddDot -> handleAddDot()
            is TextFieldEvent.EraseCharacter -> handleEraseCharacter()
            is TextFieldEvent.UpdateField -> handleUpdateField(event.newTextValue)
        }
    }

    private fun handleAddNumber(char: Char) {
        _textFieldState.update { currentState ->
            when {
                currentState.isEmpty() || currentState.isSingleDigitZero() -> char.toString()
                else -> currentState + char
            }
        }
    }

    private fun handleAddDot() {
        _textFieldState.update { currentState ->
            when {
                currentState.isEmpty() -> "0."
                currentState.hasDot() -> currentState // No change if dot already exists
                else -> "$currentState."
            }
        }
    }

    private fun handleEraseCharacter() {
        _textFieldState.update { currentState ->
            if (currentState.isNotEmpty()) {
                currentState.dropLast(1) // Remove the last character
            } else {
                currentState // No change if already empty
            }
        }
    }

    private fun handleUpdateField(newTextValue: String) {
        _textFieldState.update {
            if (newTextValue.toDoubleOrNull() == 0.0) "" else newTextValue
        }
    }

    private fun String.isSingleDigitZero(): Boolean = this.length == 1 && this[0] == '0'
    private fun String.hasDot(): Boolean = this.contains('.')
}

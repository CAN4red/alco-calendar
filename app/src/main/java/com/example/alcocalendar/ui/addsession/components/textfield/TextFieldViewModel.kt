package com.example.alcocalendar.ui.addsession.components.textfield

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class TextFieldViewModel() : ViewModel() {
    private val _textFieldState: MutableStateFlow<String> =
        MutableStateFlow(value = "")

    val textFieldState: StateFlow<String>
        get() = _textFieldState

    val textFieldStateDouble: StateFlow<Double>
        get() = _textFieldState
            .map { it.toDoubleOrNull() ?: 0.0 }
            .stateIn(viewModelScope, SharingStarted.Lazily, 0.0)

    fun onTextFieldEvent(event: TextFieldEvent) {
        when (event) {
            is TextFieldEvent.AddNumber -> {
                if (_textFieldState.value.isEmpty()) {
                    _textFieldState.update {
                        event.char.toString()
                    }
                } else {
                    _textFieldState.update { currentState ->
                        currentState + event.char
                    }
                }
            }

            is TextFieldEvent.AddDot -> {
                if (_textFieldState.value.isEmpty()) {
                    _textFieldState.update { "0." }
                } else {
                    _textFieldState.update { currentState ->
                        "$currentState."
                    }
                }
            }

            is TextFieldEvent.EraseCharacter -> {
                if (_textFieldState.value.isNotEmpty()) {
                    _textFieldState.update { currentState ->
                        currentState.substring(0, currentState.length - 1)
                    }
                }
            }

            is TextFieldEvent.UpdateField -> {
                _textFieldState.update { event.newTextValue }
            }
        }
    }
}

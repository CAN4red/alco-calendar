package com.example.alcocalendar.ui.addsession.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomTextFieldKeyboard(
    onClickEvent: (TextFieldEvent) -> Unit,
    onConfirmEvent: () -> Unit,
    hideBottomSheet: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Row(modifier = Modifier) {
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('1')) },
                buttonContent = { Text(text = "1") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('2')) },
                buttonContent = { Text(text = "2") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('3')) },
                buttonContent = { Text(text = "3") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.EraseCharacter) },
                buttonContent = { Text(text = "back") })
        }

        Row(modifier = Modifier) {
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('4')) },
                buttonContent = { Text(text = "4") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('5')) },
                buttonContent = { Text(text = "5") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('6')) },
                buttonContent = { Text(text = "6") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDot) },
                buttonContent = { Text(text = "._") })
        }

        Row(modifier = Modifier) {
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('7')) },
                buttonContent = { Text(text = "7") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('8')) },
                buttonContent = { Text(text = "8") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('9')) },
                buttonContent = { Text(text = "9") }
            )
            CustomTextFieldButton(
                onClick = {
                    onConfirmEvent()
                    hideBottomSheet()
                },
                buttonContent = { Text(text = "enter") })
        }

        Row(modifier = Modifier) {
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDigit('0')) },
                buttonContent = { Text(text = "0") }
            )
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
        }
    }
}
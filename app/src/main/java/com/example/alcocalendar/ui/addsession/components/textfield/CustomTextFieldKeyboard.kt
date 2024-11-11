package com.example.alcocalendar.ui.addsession.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent

@Composable
fun CustomTextFieldKeyboard(
    onClickEvent: (TextFieldEvent) -> Unit,
    onConfirmEvent: () -> Unit,
    hideBottomSheet: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('1')) },
                buttonContent = { Text(text = "1") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('2')) },
                buttonContent = { Text(text = "2") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('3')) },
                buttonContent = { Text(text = "3") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.EraseCharacter) },
                buttonContent = { Text(text = "back") })
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('4')) },
                buttonContent = { Text(text = "4") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('5')) },
                buttonContent = { Text(text = "5") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('6')) },
                buttonContent = { Text(text = "6") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddDot) },
                buttonContent = { Text(text = "._") })
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('7')) },
                buttonContent = { Text(text = "7") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('8')) },
                buttonContent = { Text(text = "8") }
            )
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('9')) },
                buttonContent = { Text(text = "9") }
            )
            CustomTextFieldButton(
                onClick = {
                    onConfirmEvent()
                    hideBottomSheet()
                },
                buttonContent = { Text(text = "enter") })
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
            CustomTextFieldButton(
                onClick = { onClickEvent(TextFieldEvent.AddNumber('0')) },
                buttonContent = { Text(text = "0") }
            )
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
        }
    }
}
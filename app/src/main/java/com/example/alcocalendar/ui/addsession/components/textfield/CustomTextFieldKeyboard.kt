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
    val buttonRows = listOf(
        listOf('1', '2', '3', TextFieldEvent.EraseCharacter),
        listOf('4', '5', '6', TextFieldEvent.AddDot),
        listOf('7', '8', '9', TextFieldEvent.AddDigit('0')),
        listOf(TextFieldEvent.Empty, '0', TextFieldEvent.Empty, TextFieldEvent.Empty)
    )

    Column(modifier) {
        buttonRows.forEach { row ->
            Row(modifier = Modifier) {
                row.forEach { item ->
                    when (item) {
                        is Char -> CustomTextFieldButton(
                            onClick = { onClickEvent(TextFieldEvent.AddDigit(item)) },
                            buttonContent = { Text(text = item.toString()) }
                        )
                        TextFieldEvent.EraseCharacter -> CustomTextFieldButton(
                            onClick = { onClickEvent(TextFieldEvent.EraseCharacter) },
                            buttonContent = { Text(text = "back") }
                        )
                        TextFieldEvent.AddDot -> CustomTextFieldButton(
                            onClick = { onClickEvent(TextFieldEvent.AddDot) },
                            buttonContent = { Text(text = "._") }
                        )
                        TextFieldEvent.Empty -> CustomTextFieldButton(
                            onClick = {},
                            buttonContent = { Text(text = "") }
                        )
                    }
                }
            }
        }

        Row(modifier = Modifier) {
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
            CustomTextFieldButton(
                onClick = {
                    onConfirmEvent()
                    hideBottomSheet()
                },
                buttonContent = { Text(text = "enter") }
            )
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
            CustomTextFieldButton(onClick = {}, buttonContent = { Text(text = "") })
        }
    }
}

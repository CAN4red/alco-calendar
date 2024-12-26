package com.example.alcocalendar.ui.addsession.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
        listOf('7', '8', '9', TextFieldEvent.Confirm(onConfirmEvent)),
        listOf(TextFieldEvent.Empty, '0', TextFieldEvent.Empty, TextFieldEvent.Empty)
    )

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        buttonRows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                row.forEach { item ->
                    CustomTextFieldButton(
                        onClick = {
                            when (item) {
                                is Char -> onClickEvent(TextFieldEvent.AddDigit(item))
                                is TextFieldEvent.EraseCharacter -> onClickEvent(TextFieldEvent.EraseCharacter)
                                is TextFieldEvent.AddDot -> onClickEvent(TextFieldEvent.AddDot)
                                is TextFieldEvent.Confirm -> {
                                    onClickEvent(TextFieldEvent.Confirm(onConfirmEvent))
                                    hideBottomSheet()
                                }

                                else -> {}
                            }
                        },
                        color = MaterialTheme.colorScheme.surface,
                        buttonContent = {
                            Text(
                                text = when (item) {
                                    is Char -> item.toString()
                                    is TextFieldEvent.EraseCharacter -> "back"
                                    is TextFieldEvent.AddDot -> "._"
                                    is TextFieldEvent.Confirm -> "enter"
                                    else -> ""
                                }
                            )
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}


package com.example.alcocalendar.ui.addsession.screens.bottomsheets


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.ui.addsession.components.textfield.CustomField
import com.example.alcocalendar.ui.addsession.components.textfield.CustomTextFieldKeyboard
import com.example.alcocalendar.ui.addsession.components.textfield.TextFieldEvent

@Composable
fun AddDrinkSheetContent(
    textFieldState: String,
    onTextFieldEvent: (TextFieldEvent) -> Unit,
    onConfirmEvent: () -> Unit,
    hideBottomSheet: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        CustomField(textValue = textFieldState)

        CustomTextFieldKeyboard(
            onClickEvent = onTextFieldEvent,
            onConfirmEvent = onConfirmEvent,
            hideBottomSheet = hideBottomSheet,
        )
    }
}


@Composable
@Preview
private fun AddBeerBottomSheetPreview() {
    AddDrinkSheetContent(
        textFieldState = "7.0",
        onTextFieldEvent = {},
        onConfirmEvent = {},
        hideBottomSheet = {},
        modifier = Modifier.fillMaxWidth()
    )
}
package com.example.alcocalendar.ui.addsession.screens.bottomsheets


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        Spacer(modifier = Modifier.height(24.dp))

        CustomTextFieldKeyboard(
            onClickEvent = onTextFieldEvent,
            onConfirmEvent = onConfirmEvent,
            hideBottomSheet = hideBottomSheet,
            modifier = Modifier.padding(horizontal = 40.dp)
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
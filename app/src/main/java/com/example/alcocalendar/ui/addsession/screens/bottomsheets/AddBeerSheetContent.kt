package com.example.alcocalendar.ui.addsession.screens.bottomsheets


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.ui.addsession.components.textfield.CustomField
import com.example.alcocalendar.ui.addsession.components.textfield.CustomTextFieldKeyboard
import com.example.alcocalendar.ui.addsession.components.textfield.TextFieldEvent
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent

@Composable
fun AddBeerSheetContent(
    textFieldState: String,
    onTextFieldEvent: (TextFieldEvent) -> Unit,
    onConfirmEvent: () -> Unit,
    hideBottomSheet: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        CustomField(textValue = textFieldState)

        CustomTextFieldKeyboard(
            onClickEvent = onTextFieldEvent,
            onConfirmEvent = onConfirmEvent,
            hideBottomSheet = hideBottomSheet
        )
    }
}

@Composable
@Preview
private fun AddBeerBottomSheetPreview() {
    AddBeerSheetContent(
        textFieldState = "",
        onTextFieldEvent = {},
        onConfirmEvent = {},
        hideBottomSheet = {},
        modifier = Modifier.fillMaxWidth()
    )
}
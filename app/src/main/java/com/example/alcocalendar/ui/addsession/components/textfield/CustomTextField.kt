package com.example.alcocalendar.ui.addsession.components.textfield


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CustomTextField(
    initialValue: String,
    modifier: Modifier = Modifier
) {
    val textFieldViewModel: TextFieldViewModel = viewModel()
    val textFieldValueState = textFieldViewModel.textFieldState.collectAsState()

    Column(
        modifier = modifier
    ) {
        CustomField(
            textValue = formatTextFieldValue(textFieldValueState.value),
            modifier = Modifier.fillMaxWidth()
        )


    }
}

private fun formatTextFieldValue(value: String): String{
    return value.ifEmpty { "0" }
}

@Composable
@Preview
private fun CustomTextFieldPreview() {
    val textValue by remember { mutableStateOf("") }
    CustomTextField(initialValue = textValue)
}

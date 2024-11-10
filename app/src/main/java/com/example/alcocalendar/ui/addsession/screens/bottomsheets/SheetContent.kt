package com.example.alcocalendar.ui.addsession.screens.bottomsheets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SheetContent(
    intakeValue: Double,
    onIntakeChange: (String) -> Unit,
    onConfirmClick: () -> Unit,
    increaseIntakeButtons: List<@Composable () -> Unit>,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = modifier) {
        TextField(
            value = intakeValue.toString(),
            onValueChange = onIntakeChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth().focusRequester(focusRequester)
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            increaseIntakeButtons.forEach { increaseIntakeButton ->
                increaseIntakeButton()
            }
        }

        Button(
            onClick = onConfirmClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Confirm")
        }
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
        keyboardController?.show()
    }
}

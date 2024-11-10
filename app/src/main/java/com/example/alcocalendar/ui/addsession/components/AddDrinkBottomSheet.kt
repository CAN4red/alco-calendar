package com.example.alcocalendar.ui.addsession.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ModalBottomSheetLayout
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.ui.addsession.screens.columns.AddBeerScreen

@Composable
fun AddDrinkBottomSheet(
    sheetContent: @Composable ColumnScope.() -> Unit,
    screenContent: @Composable (Modifier) -> Unit,
    modifier: Modifier = Modifier
) {
    ModalBottomSheetLayout(sheetContent = sheetContent) {
        screenContent(modifier)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SheetContent(
    intakeValue: String,
    onIntakeChange: (String) -> Unit,
    onConfirmClick: () -> Unit,
    vararg increaseIntakeButtons: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        TextField(
            value = intakeValue,
            onValueChange = onIntakeChange,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
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
        ) {
            Text("Confirm")
        }
    }
}

@Composable
@Preview
private fun AddDrinkBottomSheetPreview() {
    AddDrinkBottomSheet(
        sheetContent = {
            SheetContent(intakeValue = "", onIntakeChange = {}, onConfirmClick = {}, { Button(onClick = { /*TODO*/ }) {Text("Lol")} })
        },
        screenContent = { AddBeerScreen(onFillingSessionEvent = {}, navigateBack = { /*TODO*/ }) }
    )
}
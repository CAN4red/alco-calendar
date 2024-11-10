package com.example.alcocalendar.ui.addsession.screens.bottomsheets


import androidx.compose.foundation.layout.fillMaxWidth
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddBeerBottomSheet(
    initialIntakeValue: Double,
    onConfirmClick: (Double) -> Unit,
    modifier: Modifier = Modifier
) {
    var intakeFillingState by remember {
        mutableDoubleStateOf(initialIntakeValue)
    }

    val increaseIntakeButtons = listOf<@Composable () -> Unit>(
        {
            Button(onClick = { intakeFillingState += 0.25 }) {
                Text(text = "+0.25")
            }
        },
        {
            Button(onClick = { intakeFillingState += 0.5 }) {
                Text(text = "+0.5")
            }
        },
        {
            Button(onClick = { intakeFillingState += 1 }) {
                Text(text = "+1")
            }
        },
    )

    SheetContent(
        intakeValue = intakeFillingState,
        onIntakeChange = { newIntake -> intakeFillingState = newIntake.toDouble() },
        onConfirmClick = { onConfirmClick(intakeFillingState) },
        increaseIntakeButtons = increaseIntakeButtons,
        modifier = modifier,
    )
}

@Composable
@Preview
private fun AddBeerBottomSheetPreview() {
    AddBeerBottomSheet(
        initialIntakeValue = 0.0,
        onConfirmClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}
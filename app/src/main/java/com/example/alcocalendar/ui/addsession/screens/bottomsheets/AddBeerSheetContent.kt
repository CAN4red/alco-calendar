package com.example.alcocalendar.ui.addsession.screens.bottomsheets


import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.Light

@Composable
fun AddBeerSheetContent(
    initialIntake: Beer,
    onConfirmClick: (Beer) -> Unit,
    modifier: Modifier = Modifier
) {
    var intakeFillingState by remember {
        mutableDoubleStateOf(initialIntake.liters)
    }

    LaunchedEffect(initialIntake) {
        intakeFillingState = initialIntake.liters
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
        onIntakeChange = { newIntake ->
            intakeFillingState = newIntake.toDouble()
            Log.d("BEER_ADDED", "intakeState after change: $intakeFillingState")
        },
        onConfirmClick = { onConfirmClick(initialIntake.genericCopy(intakeFillingState)) },
        increaseIntakeButtons = increaseIntakeButtons,
        modifier = modifier,
    )
}

@Composable
@Preview
private fun AddBeerBottomSheetPreview() {
    AddBeerSheetContent(
        initialIntake = Light(),
        onConfirmClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}
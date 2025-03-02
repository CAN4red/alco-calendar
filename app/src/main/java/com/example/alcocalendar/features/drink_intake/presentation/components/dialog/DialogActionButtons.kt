package com.example.alcocalendar.features.drink_intake.presentation.components.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeEvent

@Composable
fun DialogActionButtons(
    onEvent: (DrinkIntakeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { onEvent(DrinkIntakeEvent.DeleteDrinkIntake) },
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = "Delete",
                style = MaterialTheme.typography.labelLarge
            )
        }

        Button(
            onClick = { submitIntake(onEvent) },
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = "Add Intake",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

private fun submitIntake(onEvent: (DrinkIntakeEvent) -> Unit) {
    onEvent(DrinkIntakeEvent.InsertUpdateDrinkIntake)
    onEvent(DrinkIntakeEvent.DropFillingDrinkIntake)
}
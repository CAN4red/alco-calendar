package com.example.alcocalendar.features.drink_intake.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeState
import com.example.alcocalendar.features.drink_intake.presentation.components.dialog.AddIntakeDialog
import com.example.alcocalendar.features.drink_intake.presentation.components.intake_tag.IntakesFlowRow

@Composable
fun DrinkIntakeScreenContent(
    state: DrinkIntakeState,
    onEvent: (DrinkIntakeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = state.date.toString(),
            style = MaterialTheme.typography.displayMedium
        )

        LazyColumn {
            item {
                DrinkListsColumn(
                    state = state,
                    onEvent = onEvent,
                )
            }
        }

        IntakesFlowRow(
            intakes = state.intakes,
            onEvent = onEvent,
            modifier = Modifier.fillMaxWidth()
        )

        if (state.fillingIntake != null) {
            AddIntakeDialog(
                state = state,
                onEvent = onEvent,
            )
        }
    }
}

@Preview
@Composable
private fun DrinkIntakeScreenContentPreview() {
    DrinkIntakeScreenContent(
        state = DrinkIntakeState(),
        onEvent = {},
        modifier = Modifier.fillMaxSize()
    )
}
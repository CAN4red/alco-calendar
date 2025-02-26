package com.example.alcocalendar.features.drink_intake.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.core.data.local.entities.drink_types.OtherType
import com.example.alcocalendar.core.data.local.entities.drink_types.SpiritsType
import com.example.alcocalendar.core.data.local.entities.drink_types.WineType
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeState

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
            items(count = 1) {
                TitledDrinkList<BeerType>(
                    onEvent = onEvent
                )

                TitledDrinkList<WineType>(
                    onEvent = onEvent
                )

                TitledDrinkList<SpiritsType>(
                    onEvent = onEvent
                )

                TitledDrinkList<OtherType>(
                    onEvent = onEvent
                )
            }
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
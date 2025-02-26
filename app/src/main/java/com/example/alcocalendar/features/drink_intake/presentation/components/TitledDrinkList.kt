package com.example.alcocalendar.features.drink_intake.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.drink_intake.presentation.utils.DrinkTypeToStringMapper.headlineName

@Composable
inline fun <reified T> TitledDrinkList(
    crossinline onEvent: (DrinkIntakeEvent) -> Unit,
    modifier: Modifier = Modifier
) where T : Enum<T>, T : DrinkType {
    Column(modifier = modifier) {
        Text(
            text = headlineName<T>(),
            style = MaterialTheme.typography.headlineMedium
        )

        DrinkList<T>(
            onEvent = onEvent,
        )
    }
}

@Preview
@Composable
private fun TitledDrinkListPreview() {
    TitledDrinkList<BeerType>(
        onEvent = {}
    )
}
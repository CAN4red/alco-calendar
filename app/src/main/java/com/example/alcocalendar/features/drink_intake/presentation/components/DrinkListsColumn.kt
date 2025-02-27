package com.example.alcocalendar.features.drink_intake.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.core.data.local.entities.drink_types.OtherType
import com.example.alcocalendar.core.data.local.entities.drink_types.SpiritsType
import com.example.alcocalendar.core.data.local.entities.drink_types.WineType
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.drink_intake.presentation.DrinkIntakeState

@Composable
fun DrinkListsColumn(
    state: DrinkIntakeState,
    onEvent: (DrinkIntakeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        DrinkListWithTitle<BeerType>(
            onEvent = onEvent,
            isListExpanded = isListExpanded<BeerType>(state.expandedDrinkType),
        )

        DrinkListWithTitle<WineType>(
            onEvent = onEvent,
            isListExpanded = isListExpanded<WineType>(state.expandedDrinkType),
        )

        DrinkListWithTitle<SpiritsType>(
            onEvent = onEvent,
            isListExpanded = isListExpanded<SpiritsType>(state.expandedDrinkType),
        )

        DrinkListWithTitle<OtherType>(
            onEvent = onEvent,
            isListExpanded = isListExpanded<OtherType>(state.expandedDrinkType),
        )
    }
}

private inline fun <reified T> isListExpanded(expandedDrinkType: Class<out DrinkType>?): Boolean {
    if (expandedDrinkType == null) {
        return false
    }
    return T::class.java == expandedDrinkType
}

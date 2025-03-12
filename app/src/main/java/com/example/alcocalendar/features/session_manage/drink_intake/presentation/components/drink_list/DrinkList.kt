package com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.drink_list

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.core.data.local.entity.drink_types.BeerType
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeEvent
import kotlin.enums.enumEntries

@Composable
inline fun <reified T> DrinkList(
    crossinline onEvent: (DrinkIntakeEvent) -> Unit,
    modifier: Modifier = Modifier
) where T : Enum<T>, T : DrinkType {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        enumEntries<T>().forEach { drinkType ->
            DrinkCard(
                drinkType = drinkType,
                onClick = {
                    onEvent(
                        DrinkIntakeEvent.SetFillingDrinkIntake(
                            drinkType = drinkType,
                            alcoStrength = drinkType.defaultAlcoStrength
                        )
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun DrinkListPreview() {
    DrinkList<BeerType>(
        onEvent = {}
    )
}
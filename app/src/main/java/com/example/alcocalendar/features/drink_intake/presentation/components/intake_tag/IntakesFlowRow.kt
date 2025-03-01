package com.example.alcocalendar.features.drink_intake.presentation.components.intake_tag

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.core.data.local.entities.drink_types.WineType
import com.example.alcocalendar.core.domain.model.DrinkIntake
import java.time.LocalDate

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun IntakesFlowRow(
    intakes: List<DrinkIntake>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        intakes.forEach { intake ->
            DrinkIntakeTag(drinkIntake = intake)
        }
    }
}

@Preview
@Composable
private fun IntakesFlowRowPreview() {
    IntakesFlowRow(
        intakes = listOf(
            DrinkIntake(
                date = LocalDate.now(),
                drinkType = BeerType.LIGHT,
                liters = 26.4,
                alcoStrength = 5.5
            ),
            DrinkIntake(
                date = LocalDate.now(),
                drinkType = BeerType.UNFILTERED,
                liters = 2.4,
                alcoStrength = 6.5
            ),
            DrinkIntake(
                date = LocalDate.now(),
                drinkType = WineType.CHAMPAGNE,
                liters = 2.0,
                alcoStrength = 5.5
            )
        )
    )
}
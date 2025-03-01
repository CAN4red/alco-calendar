package com.example.alcocalendar.features.drink_intake.presentation.components.intake_tag

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.features.drink_intake.presentation.utils.DrinkTypeToStringMapper.typeName
import java.time.LocalDate

@Composable
fun DrinkIntakeTag(
    drinkIntake: DrinkIntake,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(6.dp)
    ) {
        Column {
            Row {
                Text(
                    text = stringResource(drinkIntake.drinkType.typeName()),
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(Modifier.size(16.dp))

                Text(
                    text = drinkIntake.alcoStrength.toString() + "%",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Text(
                text = drinkIntake.liters.toString() + " liters",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview
@Composable
private fun DrinkIntakeTagPreview() {
    DrinkIntakeTag(
        drinkIntake = DrinkIntake(
            drinkIntakeId = 0,
            date = LocalDate.now(),
            drinkType = BeerType.LIGHT,
            liters = 2.6,
            alcoStrength = 5.5
        )
    )
}
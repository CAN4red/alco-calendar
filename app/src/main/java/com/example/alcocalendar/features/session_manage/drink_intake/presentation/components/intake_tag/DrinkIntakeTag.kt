package com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.intake_tag

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R
import com.example.alcocalendar.core.data.local.entity.drink_types.BeerType
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.state.FillingType
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.DrinkTypeToStringMapper.typeName
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.Formatter.formatAsString
import java.time.LocalDate

@Composable
fun DrinkIntakeTag(
    drinkIntake: DrinkIntake,
    onEvent: (DrinkIntakeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.32f),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onEvent(
                    DrinkIntakeEvent.SetFillingDrinkIntake(
                        drinkType = drinkIntake.drinkType,
                        alcoStrength = drinkIntake.alcoStrength,
                        liters = drinkIntake.liters,
                        fillingType = FillingType.UPDATING
                    )
                )
            }
            .padding(10.dp)
    ) {
        Column {
            Row {
                Text(
                    text = stringResource(drinkIntake.drinkType.typeName()),
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(Modifier.size(16.dp))

                Text(
                    text = getAlcoStrengthTitle(drinkIntake.alcoStrength),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = getLabel(drinkIntake.liters),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.44f)
            )
        }
    }
}

@Composable
private fun getAlcoStrengthTitle(alcoStrength: Double) = "${alcoStrength.formatAsString()}%"

@Composable
private fun getLabel(liters: Double): String {
    val postfix = pluralStringResource(R.plurals.liters, liters.toInt())
    return "${liters.formatAsString()} $postfix"
}

@Preview
@Composable
private fun DrinkIntakeTagPreview() {
    DrinkIntakeTag(
        drinkIntake = DrinkIntake(
            date = LocalDate.now(),
            drinkType = BeerType.LIGHT,
            liters = 2.6,
            alcoStrength = 5.5
        ),
        onEvent = {}
    )
}
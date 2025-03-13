package com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.alcocalendar.R
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.state.DrinkIntakeState


@Composable
fun AddIntakeDialog(
    state: DrinkIntakeState,
    onEvent: (DrinkIntakeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    var alcoStrengthString by remember { mutableStateOf(state.fillingAlcoStrengthString) }
    var litersString by remember { mutableStateOf(state.fillingLitersString) }

    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Dialog(onDismissRequest = { onEvent(DrinkIntakeEvent.DropFillingDrinkIntake) }) {
        Column(
            modifier = modifier
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Text(
                text = stringResource(state.fillingIntakeTitle),
                style = MaterialTheme.typography.titleMedium
            )

            EditNumberField(
                value = alcoStrengthString,
                onValueChange = { newValue ->
                    alcoStrengthString = newValue
                    val alcoStrengthDouble = newValue.toDoubleSafe()
                    onEvent(DrinkIntakeEvent.SetFillingDrinkIntakeAlcoStrength(alcoStrengthDouble))
                },
                label = R.string.alco_strength_label,
                clearField = { alcoStrengthString = "" },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next,
                ),
                modifier = Modifier.focusRequester(focusRequester)
            )

            EditNumberField(
                value = litersString,
                onValueChange = { newValue ->
                    litersString = newValue
                    val litersDouble = if (newValue.isBlank()) 0.0 else newValue.toDouble()
                    onEvent(DrinkIntakeEvent.SetFillingDrinkIntakeLiters(litersDouble))
                },
                label = R.string.liters_label,
                clearField = { litersString = "" },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onEvent(DrinkIntakeEvent.InsertUpdateDrinkIntake)
                        onEvent(DrinkIntakeEvent.DropFillingDrinkIntake)
                    }
                )
            )

            DialogActionButtons(onEvent = onEvent)
        }
    }
}

private fun String.toDoubleSafe(): Double = if (this.isBlank()) 0.0 else this.toDouble()

@Preview
@Composable
private fun AddIntakeDialogPreview() {
    AddIntakeDialog(
        state = DrinkIntakeState(),
        onEvent = {}
    )
}
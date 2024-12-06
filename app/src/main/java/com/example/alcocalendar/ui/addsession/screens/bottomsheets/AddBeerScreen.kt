package com.example.alcocalendar.ui.addsession.screens.bottomsheets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.Drink
import com.example.alcocalendar.db.entities.intakes.OtherDrink
import com.example.alcocalendar.db.entities.intakes.Spirits
import com.example.alcocalendar.db.entities.intakes.Wine
import com.example.alcocalendar.ui.addsession.components.textfield.TextFieldEvent
import com.example.alcocalendar.ui.addsession.components.textfield.TextFieldViewModel
import com.example.alcocalendar.ui.addsession.screens.columns.AddBeerColumn
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkScreenWithBottomSheet(
    fillingSessionState: DrinkingSession,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    content: @Composable (onDrinkButtonClick: (Drink) -> Unit) -> Unit,
) {
    var currentIntakeState by rememberSaveable { mutableStateOf<Drink?>(null) }
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    val textFieldViewModel: TextFieldViewModel = viewModel()
    val textFieldState = textFieldViewModel.textFieldState.collectAsState()
    val textFieldStateDouble = textFieldViewModel.textFieldStateAsDouble.collectAsState()

    content { newIntake ->
        currentIntakeState = newIntake
        textFieldViewModel.onTextFieldEvent(
            TextFieldEvent.UpdateField(newIntake.liters.toString().tryToDisplayAsInt())
        )
        isBottomSheetVisible = true
    }

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isBottomSheetVisible = false }
        ) {
            AddDrinkSheetContent(
                textFieldState = textFieldState.value,
                onTextFieldEvent = textFieldViewModel::onTextFieldEvent,
                hideBottomSheet = { isBottomSheetVisible = false },
                onConfirmEvent = {
                    handleConfirmEvent(
                        currentIntakeState,
                        textFieldStateDouble.value,
                        fillingSessionState,
                        onFillingSessionEvent
                    )
                    isBottomSheetVisible = false
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun AddBeerScreen(
    fillingSessionState: DrinkingSession,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit
) {
    DrinkScreenWithBottomSheet(
        fillingSessionState = fillingSessionState,
        onFillingSessionEvent = onFillingSessionEvent,
    ) { onDrinkButtonClick ->
        AddBeerColumn(
            fillingSessionState = fillingSessionState,
            navigateBack = navigateBack,
            onDrinkButtonClick = onDrinkButtonClick
        )
    }
}


private fun handleConfirmEvent(
    currentIntakeState: Drink?,
    textFieldStateDouble: Double,
    fillingSessionState: DrinkingSession,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit
) {
    val newIntake = currentIntakeState?.copyDrink(textFieldStateDouble)
        ?: fillingSessionState.beerIntake.light

    when (newIntake) {
        is Beer -> onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(newIntake))
        is Wine -> onFillingSessionEvent(FillingSessionEvent.AddWineDrink(newIntake))
        is Spirits -> onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(newIntake))
        is OtherDrink -> onFillingSessionEvent(FillingSessionEvent.AddOtherDrink(newIntake))
    }
}


private fun String.tryToDisplayAsInt(): String {
    val valueDouble = this.toDouble()
    return when (valueDouble == valueDouble.toInt().toDouble()) {
        true -> valueDouble.toInt().toString()
        false -> this
    }
}


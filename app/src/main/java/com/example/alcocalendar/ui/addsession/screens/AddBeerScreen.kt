package com.example.alcocalendar.ui.addsession.screens

import android.util.Log
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.Light
import com.example.alcocalendar.ui.addsession.components.AddDrinkScreen
import com.example.alcocalendar.ui.addsession.screens.bottomsheets.AddBeerSheetContent
import com.example.alcocalendar.ui.addsession.screens.columns.AddBeerColumn
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import kotlinx.coroutines.launch

@Composable
fun AddBeerScreen(
    fillingSessionState: DrinkingSession,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
) {
    var currentIntakeState by remember { mutableStateOf<Beer>(Light()) }
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    AddDrinkScreen(
        sheetState = sheetState,
        sheetContent = {
            AddBeerSheetContent(
                initialIntake = currentIntakeState,
                onConfirmClick = { newIntakeState ->
                    currentIntakeState = newIntakeState
                    onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(currentIntakeState))
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                }
            )
        },
        screenContent = {
            AddBeerColumn(
                fillingSessionState = fillingSessionState,
                onDrinkButtonClick = { newIntake ->
                    currentIntakeState = newIntake
                    coroutineScope.launch {
                        sheetState.show()
                    }
                    Log.d("BEER_ADDED", "currentIntake: $currentIntakeState")
                },
                onFillingSessionEvent = onFillingSessionEvent,
                navigateBack = navigateBack,
            )
        }
    )
}

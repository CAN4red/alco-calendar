package com.example.alcocalendar.ui.addsession.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.Light
import com.example.alcocalendar.ui.addsession.screens.bottomsheets.AddBeerSheetContent
import com.example.alcocalendar.ui.addsession.screens.columns.AddBeerColumn
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBeerScreen(
    fillingSessionState: DrinkingSession,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
) {
    var currentIntakeState by remember { mutableStateOf<Beer>(Light()) }
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    AddBeerColumn(
        fillingSessionState = fillingSessionState,
        onDrinkButtonClick = { newIntake ->
            currentIntakeState = newIntake
            isBottomSheetVisible = true
        },
        onFillingSessionEvent = onFillingSessionEvent,
        navigateBack = navigateBack,
    )

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isBottomSheetVisible = false }
        ) {
            AddBeerSheetContent(
                initialIntake = currentIntakeState,
                onConfirmClick = { newIntakeState ->
                    onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(newIntakeState))
                    isBottomSheetVisible = false
                }
            )
        }
    }
}

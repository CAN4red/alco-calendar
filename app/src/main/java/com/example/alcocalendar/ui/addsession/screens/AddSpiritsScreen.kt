package com.example.alcocalendar.ui.addsession.screens

import androidx.compose.runtime.Composable
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.ui.addsession.screens.bottomsheets.DrinkScreenWithBottomSheet
import com.example.alcocalendar.ui.addsession.screens.columns.AddSpiritsColumn
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent

@Composable
fun AddSpiritsScreen(
    fillingSessionState: DrinkingSession,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit
) {
    DrinkScreenWithBottomSheet(
        fillingSessionState = fillingSessionState,
        onFillingSessionEvent = onFillingSessionEvent,
    ) { onDrinkButtonClick ->
        AddSpiritsColumn(
            fillingSessionState = fillingSessionState,
            navigateBack = navigateBack,
            onDrinkButtonClick = onDrinkButtonClick
        )
    }
}
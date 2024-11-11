package com.example.alcocalendar.ui.addsession.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.Light
import com.example.alcocalendar.ui.addsession.components.textfield.TextFieldEvent
import com.example.alcocalendar.ui.addsession.components.textfield.TextFieldViewModel
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
    var currentIntakeState by remember { mutableStateOf<Beer?>(null) }
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    val textFieldViewModel: TextFieldViewModel = viewModel()
    val textFieldState = textFieldViewModel.textFieldState.collectAsState()
    val textFieldStateDouble = textFieldViewModel.textFieldStateDouble.collectAsState()

    AddBeerColumn(
        fillingSessionState = fillingSessionState,
        onFillingSessionEvent = onFillingSessionEvent,
        navigateBack = navigateBack,
        onDrinkButtonClick = { newIntake ->
            currentIntakeState = newIntake
            textFieldViewModel.onTextFieldEvent(TextFieldEvent.UpdateField(newIntake.liters.toString()))
            isBottomSheetVisible = true
        },
    )

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = { isBottomSheetVisible = false }
        ) {
            AddBeerSheetContent(
                textFieldState = textFieldState.value,
                onTextFieldEvent = textFieldViewModel::onTextFieldEvent,
                hideBottomSheet = { isBottomSheetVisible = false },
                onConfirmEvent = {
                    val newIntake = currentIntakeState?.genericCopy(textFieldStateDouble.value) ?: Light()
                    onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(newIntake))
                }
            )
        }
    }
}

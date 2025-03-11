package com.example.alcocalendar.features.session_manage.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeState
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.date_title.DateTitle
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.dialog.AddIntakeDialog
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState
import com.example.alcocalendar.features.session_manage.notes.presentation.components.NotesTextFieldScreen

@Composable
fun SessionManageScreenContent(
    drinkIntakeState: DrinkIntakeState,
    notesState: NotesState,
    onDrinkIntakeEvent: (DrinkIntakeEvent) -> Unit,
    onNotesEvent: (NotesEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 8.dp)
    ) {
        DateTitle(state = drinkIntakeState)

        if (notesState.isExpanded) {
            NotesTextFieldScreen(
                state = notesState,
                onEvent = onNotesEvent,
            )
        } else {
            SessionManageColumnContent(
                drinkIntakeState = drinkIntakeState,
                notesState = notesState,
                onDrinkIntakeEvent = onDrinkIntakeEvent,
                onNotesEvent = onNotesEvent
            )
        }
    }

    if (drinkIntakeState.fillingIntake != null) {
        AddIntakeDialog(
            state = drinkIntakeState,
            onEvent = onDrinkIntakeEvent,
        )
    }
}


@Preview
@Composable
private fun DrinkIntakeScreenContentPreview() {
    SessionManageScreenContent(
        drinkIntakeState = DrinkIntakeState(),
        onDrinkIntakeEvent = {},
        notesState = NotesState(),
        onNotesEvent = {},
        modifier = Modifier.fillMaxSize()
    )
}
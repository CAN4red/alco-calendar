package com.example.alcocalendar.features.session_manage.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeState
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.drink_list.DrinkListsColumn
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.intake_tag.IntakesFlowRow
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState
import com.example.alcocalendar.features.session_manage.notes.presentation.components.NotesField

@Composable
fun SessionManageColumnContent(
    drinkIntakeState: DrinkIntakeState,
    notesState: NotesState,
    onDrinkIntakeEvent: (DrinkIntakeEvent) -> Unit,
    onNotesEvent: (NotesEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        DrinkListsColumn(
            state = drinkIntakeState,
            onEvent = onDrinkIntakeEvent,
        )

        Spacer(Modifier.padding(8.dp))

        IntakesFlowRow(
            intakes = drinkIntakeState.intakes,
            onEvent = onDrinkIntakeEvent,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.weight(1f))

        NotesField(
            onClick = { onNotesEvent(NotesEvent.ExpandNote) },
            content = notesState.note.content,
            modifier = Modifier.fillMaxSize()
        )
    }
}
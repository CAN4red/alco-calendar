package com.example.alcocalendar.features.session_manage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeEvent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeState
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.date_title.DateTitle
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.dialog.AddIntakeDialog
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.drink_list.DrinkListsColumn
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.components.intake_tag.IntakesFlowRow
import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import com.example.alcocalendar.features.session_manage.notes.presentation.components.NotesField

@Composable
fun SessionManageScreenContent(
    drinkIntakeState: DrinkIntakeState,
    notesState: Note,
    onDrinkIntakeEvent: (DrinkIntakeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 8.dp)
    ) {
        DateTitle(state = drinkIntakeState)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                DrinkListsColumn(
                    state = drinkIntakeState,
                    onEvent = onDrinkIntakeEvent,
                )
            }
            item {
                Spacer(Modifier.padding(8.dp))
            }
            item {
                IntakesFlowRow(
                    intakes = drinkIntakeState.intakes,
                    onEvent = onDrinkIntakeEvent,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                NotesField(
                    onClick = {},
                    content = notesState.content,
                    modifier = Modifier.fillMaxSize()
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
}

@Preview
@Composable
private fun DrinkIntakeScreenContentPreview() {
    SessionManageScreenContent(
        drinkIntakeState = DrinkIntakeState(),
        onDrinkIntakeEvent = {},
        notesState = Note(content = "lol"),
        modifier = Modifier.fillMaxSize()
    )
}
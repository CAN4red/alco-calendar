package com.example.alcocalendar.features.session_manage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.alcocalendar.features.session_manage.components.SessionManageScreenContent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeViewModel
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesViewModel

@Composable
fun SessionManageScreen(
    modifier: Modifier = Modifier,
    drinkIntakeViewModel: DrinkIntakeViewModel = hiltViewModel(),
    notesViewModel: NotesViewModel = hiltViewModel(),
) {
    val drinkIntakeState by drinkIntakeViewModel.state.collectAsState()
    val notesState by notesViewModel.state.collectAsState()

    SessionManageScreenContent(
        drinkIntakeState = drinkIntakeState,
        notesState = notesState,
        onDrinkIntakeEvent = drinkIntakeViewModel::onEvent,
        onNotesEvent = notesViewModel::onEvent,
        modifier = modifier
    )
}

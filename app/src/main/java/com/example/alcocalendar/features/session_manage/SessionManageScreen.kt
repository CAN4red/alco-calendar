package com.example.alcocalendar.features.session_manage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.alcocalendar.features.session_manage.components.SessionManageScreenContent
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.DrinkIntakeViewModel
import com.example.alcocalendar.features.session_manage.media.presentation.MediaViewModel
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesViewModel

@Composable
fun SessionManageScreen(
    modifier: Modifier = Modifier,
    drinkIntakeViewModel: DrinkIntakeViewModel = hiltViewModel(),
    notesViewModel: NotesViewModel = hiltViewModel(),
    mediaViewModel: MediaViewModel = hiltViewModel(),
) {
    val drinkIntakeState by drinkIntakeViewModel.state.collectAsState()
    val notesState by notesViewModel.state.collectAsState()
    val mediaState by mediaViewModel.state.collectAsState()

    SessionManageScreenContent(
        drinkIntakeState = drinkIntakeState,
        notesState = notesState,
        mediaState = mediaState,
        onDrinkIntakeEvent = drinkIntakeViewModel::onEvent,
        onNotesEvent = notesViewModel::onEvent,
        onMediaEvent = mediaViewModel::onEvent,
        modifier = modifier
    )
}

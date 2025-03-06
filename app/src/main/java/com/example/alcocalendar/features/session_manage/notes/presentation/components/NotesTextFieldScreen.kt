package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent

@Composable
fun NotesTextFieldScreen(
    state: Note,
    onEvent: (NotesEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onEvent(NotesEvent.SubmitNote(state)) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        NotesTextField(
            state = state,
            onEvent = onEvent,
        )
    }
}

@Preview
@Composable
private fun NotesTextFieldScreen() {

}
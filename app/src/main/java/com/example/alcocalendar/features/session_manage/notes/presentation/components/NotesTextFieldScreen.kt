package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState

@Composable
fun NotesTextFieldScreen(
    state: NotesState,
    onEvent: (NotesEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onEvent(NotesEvent.SubmitNote(state.note))
        onEvent(NotesEvent.CollapseNote)
    }

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
private fun NotesTextFieldScreenPreview() {
    NotesTextFieldScreen(
        state = NotesState(),
        onEvent = {},
    )
}
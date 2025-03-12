package com.example.alcocalendar.features.session_manage.notes.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesEvent
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NotesTextFieldScreen(
    state: NotesState,
    onEvent: (NotesEvent) -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onEvent(NotesEvent.SaveNote(state.note))
        onEvent(NotesEvent.CollapseNote)
    }

    with(sharedTransitionScope) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .sharedElement(
                    rememberSharedContentState(key = "text_field"),
                    animatedVisibilityScope = animatedVisibilityScope
                )
        ) {
            NotesTextField(
                state = state,
                onEvent = onEvent,
            )
        }
    }
}

package com.example.alcocalendar.features.session_manage.common.mappers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import com.example.alcocalendar.features.session_manage.media.presentation.MediaState
import com.example.alcocalendar.features.session_manage.notes.presentation.NotesState

sealed class SessionManageTargetState {
    data object Default : SessionManageTargetState()
    data class NotesExpanded(val state: NotesState) : SessionManageTargetState()
    data class MediaExpanded(val state: MediaState) : SessionManageTargetState()
}

@Composable
fun rememberSessionManageTargetState(
    notesState: NotesState,
    mediaState: MediaState
): SessionManageTargetState {
    return remember(notesState.isExpanded, mediaState.isExpanded) {
        derivedStateOf {
            when {
                notesState.isExpanded -> SessionManageTargetState.NotesExpanded(notesState)
                mediaState.isExpanded -> SessionManageTargetState.MediaExpanded(mediaState)
                else -> SessionManageTargetState.Default
            }
        }.value
    }
}

package com.example.alcocalendar.features.session_manage.notes.presentation

import com.example.alcocalendar.features.session_manage.notes.domain.model.Note

sealed interface NotesEvent {
    data class SetNoteContent(val content: String) : NotesEvent
    data class SubmitNote(val note: Note) : NotesEvent
    data object ExpandNote : NotesEvent
    data object CollapseNote : NotesEvent
}
package com.example.alcocalendar.features.session_manage.notes.presentation

sealed interface NotesEvent {
    data class SetNoteContent(val content: String) : NotesEvent
    data object SaveNote : NotesEvent
    data object ExpandNote : NotesEvent
    data object CollapseNote : NotesEvent
}
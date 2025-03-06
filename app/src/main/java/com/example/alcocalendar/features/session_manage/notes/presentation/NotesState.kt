package com.example.alcocalendar.features.session_manage.notes.presentation

import com.example.alcocalendar.features.session_manage.notes.domain.model.Note

data class NotesState(
    val note: Note = Note(),
    val isExpanded: Boolean = false,
)

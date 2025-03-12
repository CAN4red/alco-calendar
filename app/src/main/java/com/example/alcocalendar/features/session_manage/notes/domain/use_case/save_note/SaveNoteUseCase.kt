package com.example.alcocalendar.features.session_manage.notes.domain.use_case.save_note

import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import com.example.alcocalendar.features.session_manage.notes.domain.repository.NotesRepository
import javax.inject.Inject

class SaveNoteUseCase @Inject constructor(
    private val repository: NotesRepository
) {
    suspend operator fun invoke(note: Note) {
        val existingNote = repository.getNote(note.date)
        when {
            note.content.isBlank() -> repository.deleteNotesByDate(note.date)
            existingNote != null -> repository.updateNote(note)
            else -> repository.insertNote(note)
        }
    }
}
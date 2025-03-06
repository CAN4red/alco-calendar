package com.example.alcocalendar.features.session_manage.notes.domain.use_case.submit_note

import android.util.Log
import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import com.example.alcocalendar.features.session_manage.notes.domain.repository.NotesRepository
import javax.inject.Inject

class SubmitNoteUseCase @Inject constructor(
    private val repository: NotesRepository
) {
    suspend operator fun invoke(note: Note) {
        val existingNote = repository.getNote(note.date)
        Log.i("Submit note", note.content)
        when {
            note.content.isBlank() -> {
                repository.deleteNotesByDate(note.date)
                Log.i("Submit note", "Note Deleted, ${note.content}")
            }
            existingNote != null -> {
                repository.updateNote(note)
                Log.i("Submit note", "Note Updated, ${existingNote.content}")
            }
            else -> {
                repository.insertNote(note)
                Log.i("Submit note", "Note Inserted")
            }
        }
    }
}
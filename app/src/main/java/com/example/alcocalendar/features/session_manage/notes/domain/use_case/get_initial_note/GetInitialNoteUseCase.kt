package com.example.alcocalendar.features.session_manage.notes.domain.use_case.get_initial_note

import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import com.example.alcocalendar.features.session_manage.notes.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import javax.inject.Inject

class GetInitialNoteUseCase @Inject constructor(
    private val repository: NotesRepository
) {
    operator fun invoke(date: LocalDate): Flow<Note> = flow {
        val emptyNote = Note(date)
        emit(emptyNote)

        val existingNote = repository.getNote(date)
        if (existingNote != null) {
            emit(existingNote)
        }
    }
}
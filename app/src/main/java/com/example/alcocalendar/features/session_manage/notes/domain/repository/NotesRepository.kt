package com.example.alcocalendar.features.session_manage.notes.domain.repository

import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import java.time.LocalDate

interface NotesRepository {

    suspend fun insertNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNotesByDate(date: LocalDate)

    suspend fun getNote(date: LocalDate): Note?
}
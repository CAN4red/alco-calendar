package com.example.alcocalendar.features.session_manage.notes.data.repository

import com.example.alcocalendar.features.session_manage.notes.data.local.dao.NotesDao
import com.example.alcocalendar.features.session_manage.notes.data.mappers.NoteMapper
import com.example.alcocalendar.features.session_manage.notes.domain.model.Note
import com.example.alcocalendar.features.session_manage.notes.domain.repository.NotesRepository
import java.time.LocalDate
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val notesDao: NotesDao
) : NotesRepository {

    override suspend fun insertNote(note: Note) {
        notesDao.insertNote(NoteMapper.toData(note))
    }

    override suspend fun updateNote(note: Note) {
        notesDao.updateNote(NoteMapper.toData(note))
    }

    override suspend fun deleteNotesByDate(date: LocalDate) {
        notesDao.deleteNotesByDate(date)
    }

    override suspend fun getNote(date: LocalDate): Note? {
        val noteEntity = notesDao.getDrinkingSessionAndNote(date)?.note
        return NoteMapper.toDomain(noteEntity)
    }
}

package com.example.alcocalendar.features.session_manage.notes.data.mappers

import com.example.alcocalendar.features.session_manage.notes.data.local.entity.NoteEntity
import com.example.alcocalendar.features.session_manage.notes.domain.model.Note

object NoteMapper {

    fun toDomain(noteEntity: NoteEntity?): Note? {
        if (noteEntity == null) return null
        return Note(
            date = noteEntity.date,
            content = noteEntity.content
        )
    }

    fun toData(note: Note) = NoteEntity(
        date = note.date,
        content = note.content
    )
}
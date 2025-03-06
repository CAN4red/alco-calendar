package com.example.alcocalendar.features.session_manage.notes.data.local.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.alcocalendar.core.data.local.entity.DrinkingSessionEntity
import com.example.alcocalendar.features.session_manage.notes.data.local.entity.NoteEntity

data class DrinkingSessionAndNote(
    @Embedded
    val drinkingSession: DrinkingSessionEntity,
    @Relation(
        parentColumn = "date",
        entityColumn = "date",
    )
    val note: NoteEntity?,
)

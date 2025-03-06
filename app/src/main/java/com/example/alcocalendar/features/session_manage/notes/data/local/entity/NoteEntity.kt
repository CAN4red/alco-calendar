package com.example.alcocalendar.features.session_manage.notes.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.alcocalendar.core.data.local.entity.DrinkingSessionEntity
import java.time.LocalDate

@Entity(
    tableName = "note",
    foreignKeys = [
        ForeignKey(
            entity = DrinkingSessionEntity::class,
            parentColumns = ["date"],
            childColumns = ["date"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
)
data class NoteEntity(
    @PrimaryKey(autoGenerate = false)
    val date: LocalDate,
    val content: String = "",
)

package com.example.alcocalendar.features.session_manage.media.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.alcocalendar.core.data.local.entity.DrinkingSessionEntity
import java.time.LocalDate

@Entity(
    tableName = "media_item",
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
data class MediaItemEntity(
    @PrimaryKey
    val name: String,
    val date: LocalDate,
    val path: String,
)

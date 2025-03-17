package com.example.alcocalendar.features.session_manage.media.data.local.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.alcocalendar.core.data.local.entity.DrinkingSessionEntity
import com.example.alcocalendar.features.session_manage.media.data.local.entity.MediaItemEntity

data class DrinkingSessionWithMediaItems(
    @Embedded
    val drinkingSession: DrinkingSessionEntity,
    @Relation(
        parentColumn = "date",
        entityColumn = "date",
    )
    val mediaItems: List<MediaItemEntity>,
)

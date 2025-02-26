package com.example.alcocalendar.core.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.alcocalendar.core.data.local.entities.DrinkingSessionEntity
import com.example.alcocalendar.core.data.local.entities.DrinkIntakeEntity

data class DrinkingSessionWithDrinkIntakes(
    @Embedded
    val drinkingSession: DrinkingSessionEntity,
    @Relation(
        parentColumn = "date",
        entityColumn = "date",
    )
    val drinkIntakes: List<DrinkIntakeEntity>,
)
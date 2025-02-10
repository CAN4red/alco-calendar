package com.example.alcocalendar.features.drink_intake.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.alcocalendar.core.database.entities.DrinkingSessionEntity
import com.example.alcocalendar.core.database.entities.DrinkIntakeEntity

data class DrinkingSessionWithDrinkIntakes(
    @Embedded
    val drinkingSessionEntity: DrinkingSessionEntity,
    @Relation(
        parentColumn = "date",
        entityColumn = "date",
    )
    val drinkIntakes: List<DrinkIntakeEntity>,
)
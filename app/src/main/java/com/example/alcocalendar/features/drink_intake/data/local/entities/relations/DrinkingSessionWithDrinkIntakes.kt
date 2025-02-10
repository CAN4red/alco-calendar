package com.example.alcocalendar.features.drink_intake.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.alcocalendar.core.data.local.entities.DrinkingSession
import com.example.alcocalendar.core.data.local.entities.DrinkIntake

data class DrinkingSessionWithDrinkIntakes(
    @Embedded
    val drinkingSession: DrinkingSession,
    @Relation(
        parentColumn = "date",
        entityColumn = "date",
    )
    val drinkIntakes: List<DrinkIntake>,
)
package com.example.alcocalendar.data.local.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity
import com.example.alcocalendar.data.local.entities.drinks.DrinkIntakeEntity

data class DrinkingSessionWithDrinkIntakes(
    @Embedded
    val drinkingSessionEntity: DrinkingSessionEntity,
    @Relation(
        parentColumn = "date",
        entityColumn = "date",
    )
    val drinkIntakes: List<DrinkIntakeEntity>,
)
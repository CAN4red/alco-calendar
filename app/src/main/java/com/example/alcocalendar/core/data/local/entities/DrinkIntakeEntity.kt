package com.example.alcocalendar.core.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.alcocalendar.core.domain.model.DrinkType
import java.time.LocalDate

@Entity(
    tableName = "drink_intake",
    foreignKeys = [
        ForeignKey(
            entity = DrinkingSessionEntity::class,
            parentColumns = ["date"],
            childColumns = ["date"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
    primaryKeys = ["date", "drinkType", "alcoStrength"]
)
data class DrinkIntakeEntity(
    val date: LocalDate,
    val drinkType: DrinkType,
    val liters: Double = 0.0,
    val alcoStrength: Double = drinkType.defaultAlcoStrength,
)

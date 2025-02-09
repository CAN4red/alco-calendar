package com.example.alcocalendar.data.local.entities.drinks

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.alcocalendar.data.local.entities.DrinkingSessionEntity
import com.example.alcocalendar.data.local.entities.drinks.types.DrinkType
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
    ]
)
data class DrinkIntakeEntity(
    @PrimaryKey(autoGenerate = true)
    val drinkIntakeId: Int = 0,
    val date: LocalDate,
    val drinkType: DrinkType,
    val liters: Double = 0.0,
    val alcoStrength: Double = drinkType.defaultAlcoStrength,
)
package com.example.alcocalendar.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.alcocalendar.data.local.entities.drink_types.DrinkType
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
    val date: LocalDate,
    val drinkType: DrinkType,
    val liters: Double = 0.0,
    val alcoStrength: Double = drinkType.defaultAlcoStrength,
    @PrimaryKey(autoGenerate = true)
    val drinkIntakeId: Int = 0,
)

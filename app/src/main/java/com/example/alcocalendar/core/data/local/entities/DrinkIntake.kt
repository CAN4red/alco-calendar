package com.example.alcocalendar.core.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.alcocalendar.core.data.local.entities.drink_types.DrinkType
import java.time.LocalDate

@Entity(
    tableName = "drink_intake",
    foreignKeys = [
        ForeignKey(
            entity = DrinkingSession::class,
            parentColumns = ["date"],
            childColumns = ["date"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ]
)
data class DrinkIntake(
    @PrimaryKey(autoGenerate = true)
    val drinkIntakeId: Int = 0,
    val date: LocalDate,
    val drinkType: DrinkType,
    val liters: Double = 0.0,
    val alcoStrength: Double = drinkType.defaultAlcoStrength,
) {
    val isEmpty: Boolean
        get() = (liters == 0.0)

    val alcoUnits: Double
        get() = liters * alcoStrength * ETHANOL_MASS

    companion object {
        private const val ETHANOL_MASS = 0.789
    }
}

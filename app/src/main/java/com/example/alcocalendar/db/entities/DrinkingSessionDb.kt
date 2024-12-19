package com.example.alcocalendar.db.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.alcocalendar.db.entities.intakes.BeerIntake
import com.example.alcocalendar.db.entities.intakes.OtherIntake
import com.example.alcocalendar.db.entities.intakes.SpiritsIntake
import com.example.alcocalendar.db.entities.intakes.WineIntake
import java.time.LocalDate

@Entity(tableName = "drinking_sessions")
data class DrinkingSessionDb(
    @PrimaryKey override val date: LocalDate,
    @Embedded override val beerIntake: BeerIntake = BeerIntake(),
    @Embedded override val wineIntake: WineIntake = WineIntake(),
    @Embedded override val spiritsIntake: SpiritsIntake = SpiritsIntake(),
    @Embedded override val otherIntake: OtherIntake = OtherIntake(),
) : DrinkingSession {
    override val isEmpty: Boolean
        get() = beerIntake.isEmpty &&
                wineIntake.isEmpty &&
                spiritsIntake.isEmpty &&
                otherIntake.isEmpty

    override val alcoUnits: Double
        get() = beerIntake.alcoUnits +
                wineIntake.alcoUnits +
                spiritsIntake.alcoUnits +
                otherIntake.alcoUnits
}
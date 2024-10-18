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
data class DrinkingSession(
    @PrimaryKey val date: LocalDate,
    @Embedded val beerIntake: BeerIntake = BeerIntake(),
    @Embedded val wineIntake: WineIntake = WineIntake(),
    @Embedded val spiritsIntake: SpiritsIntake = SpiritsIntake(),
    @Embedded val otherIntake: OtherIntake = OtherIntake(),
)
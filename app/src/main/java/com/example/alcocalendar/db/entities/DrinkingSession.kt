package com.example.alcocalendar.db.entities

import com.example.alcocalendar.db.entities.intakes.BeerIntake
import com.example.alcocalendar.db.entities.intakes.OtherIntake
import com.example.alcocalendar.db.entities.intakes.SpiritsIntake
import com.example.alcocalendar.db.entities.intakes.WineIntake
import java.time.LocalDate

interface DrinkingSession {
    val date: LocalDate
    val beerIntake: BeerIntake
    val wineIntake: WineIntake
    val spiritsIntake: SpiritsIntake
    val otherIntake: OtherIntake
    val isEmpty: Boolean
}
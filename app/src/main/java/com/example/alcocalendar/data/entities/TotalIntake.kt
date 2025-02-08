package com.example.alcocalendar.data.entities

import androidx.room.Embedded
import com.example.alcocalendar.data.entities.intakes.beer.TotalBeerIntake
import com.example.alcocalendar.data.entities.intakes.other.TotalOtherIntake
import com.example.alcocalendar.data.entities.intakes.spirits.TotalSpiritsIntake
import com.example.alcocalendar.data.entities.intakes.wine.TotalWineIntake

data class TotalIntake(
    @Embedded
    val totalBeerIntake: TotalBeerIntake = TotalBeerIntake(),
    @Embedded
    val totalSpiritsIntake: TotalSpiritsIntake = TotalSpiritsIntake(),
    @Embedded
    val totalWineIntake: TotalWineIntake = TotalWineIntake(),
    @Embedded
    val totalOtherIntake: TotalOtherIntake = TotalOtherIntake(),
)

package com.example.alcocalendar.data.local.entities.intakes.other

import androidx.room.Embedded

data class TotalOtherIntake(
    @Embedded
    val cocktailsIntake: CocktailsIntake = CocktailsIntake(),
    @Embedded
    val shotsIntake: ShotsIntake = ShotsIntake(),
    @Embedded
    val moonshineIntake: MoonshineIntake = MoonshineIntake(),
)

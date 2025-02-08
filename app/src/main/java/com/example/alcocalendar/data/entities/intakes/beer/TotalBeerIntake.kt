package com.example.alcocalendar.data.entities.intakes.beer

import androidx.room.Embedded

data class TotalBeerIntake(
    @Embedded
    val lightIntake: LightIntake = LightIntake(),
    @Embedded
    val darkIntake: DarkIntake = DarkIntake(),
    @Embedded
    val ciderIntake: CiderIntake = CiderIntake(),
    @Embedded
    val unfilteredIntake: UnfilteredIntake = UnfilteredIntake(),
    @Embedded
    val elIntake: ElIntake = ElIntake(),
)
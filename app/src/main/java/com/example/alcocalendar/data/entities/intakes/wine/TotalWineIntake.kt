package com.example.alcocalendar.data.entities.intakes.wine

import androidx.room.Embedded

data class TotalWineIntake(
    @Embedded
    val redIntake: RedIntake = RedIntake(),
    @Embedded
    val whiteIntake: WhiteIntake = WhiteIntake(),
    @Embedded
    val roseIntake: RoseIntake = RoseIntake(),
    @Embedded
    val champagneIntake: ChampagneIntake = ChampagneIntake(),
    @Embedded
    val portIntake: PortIntake = PortIntake(),
    @Embedded
    val vermouthIntake: VermouthIntake = VermouthIntake(),
)
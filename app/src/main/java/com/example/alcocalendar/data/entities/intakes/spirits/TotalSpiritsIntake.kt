package com.example.alcocalendar.data.entities.intakes.spirits

import androidx.room.Embedded

data class TotalSpiritsIntake(
    @Embedded
    val vodkaIntake: VodkaIntake = VodkaIntake(),
    @Embedded
    val whiskeyIntake: WhiskeyIntake = WhiskeyIntake(),
    @Embedded
    val cognacIntake: CognacIntake = CognacIntake(),
    @Embedded
    val rumIntake: RumIntake = RumIntake(),
    @Embedded
    val tequilaIntake: TequilaIntake = TequilaIntake(),
    @Embedded
    val ginIntake: GinIntake = GinIntake(),
    @Embedded
    val absintheIntake: AbsintheIntake = AbsintheIntake(),
    @Embedded
    val liquorIntake: LiquorIntake = LiquorIntake(),
    @Embedded
    val brandyIntake: BrandyIntake = BrandyIntake(),
)


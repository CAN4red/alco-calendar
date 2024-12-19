package com.example.alcocalendar.db.entities.intakes

import androidx.room.Embedded

data class OtherIntake(
    @Embedded val cocktails: OtherDrink.Cocktails = OtherDrink.Cocktails(),
    @Embedded val shots: OtherDrink.Shots = OtherDrink.Shots(),
    @Embedded val moonshine: OtherDrink.Moonshine = OtherDrink.Moonshine(),
): Intake {
    override val isEmpty: Boolean
        get() = cocktails.isEmpty &&
                shots.isEmpty &&
                moonshine.isEmpty

    override val alcoUnits: Double
        get() = cocktails.alcoUnits +
                shots.alcoUnits +
                moonshine.alcoUnits

    fun update(otherDrink: OtherDrink): OtherIntake {
        return when (otherDrink) {
            is OtherDrink.Cocktails -> this.copy(cocktails = otherDrink)
            is OtherDrink.Shots -> this.copy(shots = otherDrink)
            is OtherDrink.Moonshine -> this.copy(moonshine = otherDrink)
        }
    }
}

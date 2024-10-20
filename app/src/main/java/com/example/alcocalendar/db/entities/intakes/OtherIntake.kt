package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class OtherIntake(
    @Embedded val cocktails: Cocktails = Cocktails(),
    @Embedded val shots: Shots = Shots(),
    @Embedded val moonshine: Moonshine = Moonshine(),
) {
    val isEmpty: Boolean
        get() = cocktails.isEmpty &&
                shots.isEmpty &&
                moonshine.isEmpty

    fun update(otherDrink: OtherDrink): OtherIntake {
        return when (otherDrink) {
            is Cocktails -> this.copy(cocktails = otherDrink)
            is Shots -> this.copy(shots = otherDrink)
            is Moonshine -> this.copy(moonshine = otherDrink)
        }
    }
}

sealed interface OtherDrink {
    val liters: Double
    val isEmpty: Boolean
        get() = liters == 0.0
}

data class Cocktails(
    @ColumnInfo(name = "cocktails_liters")
    override val liters: Double = 0.0
) : OtherDrink

data class Shots(
    @ColumnInfo(name = "shots_liters")
    override val liters: Double = 0.0
) : OtherDrink

data class Moonshine(
    @ColumnInfo(name = "moonshine_liters")
    override val liters: Double = 0.0
) : OtherDrink

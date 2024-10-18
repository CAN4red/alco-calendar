package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.example.alcocalendar.db.entities.Drink

data class OtherIntake(
    @Embedded val cocktails: Cocktails = Cocktails(),
    @Embedded val shots: Shots = Shots(),
    @Embedded val moonshine: Moonshine = Moonshine(),
)

data class Cocktails(
    @ColumnInfo(name = "cocktails_liters")
    override val liters: Double = 0.0
) : Drink

data class Shots(
    @ColumnInfo(name = "shots_liters")
    override val liters: Double = 0.0
) : Drink

data class Moonshine(
    @ColumnInfo(name = "moonshine_liters")
    override val liters: Double = 0.0
) : Drink

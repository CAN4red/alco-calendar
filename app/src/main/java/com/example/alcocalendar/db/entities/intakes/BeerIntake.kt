package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.example.alcocalendar.db.entities.Drink

data class BeerIntake(
    @Embedded val light: Light = Light(),
    @Embedded val dark: Dark = Dark(),
    @Embedded val cider: Cider = Cider(),
    @Embedded val unfiltered: Unfiltered = Unfiltered(),
    @Embedded val el: El = El(),
)

data class Light(
    @ColumnInfo(name = "light_beer_liters")
    override val liters: Double = 0.0
) : Drink

data class Dark(
    @ColumnInfo(name = "dark_beer_liters")
    override val liters: Double = 0.0
) : Drink

data class Cider(
    @ColumnInfo(name = "cider_liters")
    override val liters: Double = 0.0
) : Drink

data class Unfiltered(
    @ColumnInfo(name = "unfiltered_beer_liters")
    override val liters: Double = 0.0
) : Drink

data class El(
    @ColumnInfo(name = "el_liters")
    override val liters: Double = 0.0
) : Drink
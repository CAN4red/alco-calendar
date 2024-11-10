package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class BeerIntake(
    @Embedded val light: Light = Light(),
    @Embedded val dark: Dark = Dark(),
    @Embedded val cider: Cider = Cider(),
    @Embedded val unfiltered: Unfiltered = Unfiltered(),
    @Embedded val el: El = El(),
) {
    val isEmpty: Boolean
        get() = light.isEmpty &&
                dark.isEmpty &&
                cider.isEmpty &&
                unfiltered.isEmpty &&
                el.isEmpty

    fun update(beer: Beer): BeerIntake {
        return when (beer) {
            is Light -> this.copy(light = beer)
            is Dark -> this.copy(dark = beer)
            is Cider -> this.copy(cider = beer)
            is Unfiltered -> this.copy(unfiltered = beer)
            is El -> this.copy(el = beer)
        }
    }
}

sealed interface Beer {
    val liters: Double
    val isEmpty: Boolean
        get() = liters == 0.0

    fun genericCopy(liters: Double): Beer {
        return when (this) {
            is Light -> this.copy(liters = liters)
            is Dark -> this.copy(liters = liters)
            is Cider -> this.copy(liters = liters)
            is Unfiltered -> this.copy(liters = liters)
            is El -> this.copy(liters = liters)
        }
    }
}

data class Light(
    @ColumnInfo(name = "light_beer_liters")
    override val liters: Double = 0.0
) : Beer

data class Dark(
    @ColumnInfo(name = "dark_beer_liters")
    override val liters: Double = 0.0
) : Beer

data class Cider(
    @ColumnInfo(name = "cider_liters")
    override val liters: Double = 0.0
) : Beer

data class Unfiltered(
    @ColumnInfo(name = "unfiltered_beer_liters")
    override val liters: Double = 0.0
) : Beer

data class El(
    @ColumnInfo(name = "el_liters")
    override val liters: Double = 0.0
) : Beer

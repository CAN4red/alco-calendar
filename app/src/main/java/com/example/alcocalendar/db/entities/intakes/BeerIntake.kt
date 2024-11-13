package com.example.alcocalendar.db.entities.intakes

import androidx.room.Embedded

data class BeerIntake(
    @Embedded val light: Beer.Light = Beer.Light(),
    @Embedded val dark: Beer.Dark = Beer.Dark(),
    @Embedded val cider: Beer.Cider = Beer.Cider(),
    @Embedded val unfiltered: Beer.Unfiltered = Beer.Unfiltered(),
    @Embedded val el: Beer.El = Beer.El(),
) {
    val isEmpty: Boolean
        get() = light.isEmpty &&
                dark.isEmpty &&
                cider.isEmpty &&
                unfiltered.isEmpty &&
                el.isEmpty

    fun update(beer: Beer): BeerIntake {
        return when (beer) {
            is Beer.Light -> this.copy(light = beer)
            is Beer.Dark -> this.copy(dark = beer)
            is Beer.Cider -> this.copy(cider = beer)
            is Beer.Unfiltered -> this.copy(unfiltered = beer)
            is Beer.El -> this.copy(el = beer)
        }
    }
}

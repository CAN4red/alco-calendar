package com.example.alcocalendar.data.local.entities.drinks

import com.example.alcocalendar.data.local.entities.DrinkIntake
import com.example.alcocalendar.data.local.entities.drinks.types.WineType

data class WineIntake(
    override val drinkType: WineType,
    override val liters: Double = 0.0,
    override val alcoStrength: Double = drinkType.defaultAlcoStrength,
) : DrinkIntake

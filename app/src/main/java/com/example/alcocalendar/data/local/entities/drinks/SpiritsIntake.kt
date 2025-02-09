package com.example.alcocalendar.data.local.entities.drinks

import com.example.alcocalendar.data.local.entities.DrinkIntake
import com.example.alcocalendar.data.local.entities.drinks.types.SpiritsType

data class SpiritsIntake(
    override val drinkType: SpiritsType,
    override val liters: Double = 0.0,
    override val alcoStrength: Double = drinkType.defaultAlcoStrength,
) : DrinkIntake

package com.example.alcocalendar.data.local.entities.drinks

import com.example.alcocalendar.data.local.entities.DrinkIntake
import com.example.alcocalendar.data.local.entities.drinks.types.BeerType

data class BeerIntake(
    override val drinkType: BeerType,
    override val liters: Double = 0.0,
    override val alcoStrength: Double = drinkType.defaultAlcoStrength,
) : DrinkIntake
package com.example.alcocalendar.data.local.entities.drinks

import com.example.alcocalendar.data.local.entities.DrinkIntake
import com.example.alcocalendar.data.local.entities.drinks.types.OtherType

data class OtherIntake(
    override val drinkType: OtherType,
    override val liters: Double = 0.0,
    override val alcoStrength: Double = drinkType.defaultAlcoStrength,
) : DrinkIntake

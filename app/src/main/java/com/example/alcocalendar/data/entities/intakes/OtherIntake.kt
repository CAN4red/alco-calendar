package com.example.alcocalendar.data.entities.intakes

import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.DrinkIntake

sealed class OtherIntake() : DrinkIntake

data class OtherCocktailsIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_COCKTAILS_STRENGTH
) : OtherIntake()

data class OtherShotsIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_SHOTS_STRENGTH
) : OtherIntake()

data class OtherMoonshineIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_MOONSHINE_STRENGTH
) : OtherIntake()
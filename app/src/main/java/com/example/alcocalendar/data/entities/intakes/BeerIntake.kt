package com.example.alcocalendar.data.entities.intakes

import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.DrinkIntake

sealed class BeerIntake : DrinkIntake

data class LightIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_LIGHT_STRENGTH,
) : BeerIntake()

data class DarkIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_DARK_STRENGTH
) : BeerIntake()

data class CiderIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_CIDER_STRENGTH
) : BeerIntake()

data class UnfilteredIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_UNFILTERED_STRENGTH
) : BeerIntake()

data class ElIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_EL_STRENGTH
) : BeerIntake()
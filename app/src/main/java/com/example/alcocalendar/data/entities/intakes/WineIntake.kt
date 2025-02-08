package com.example.alcocalendar.data.entities.intakes

import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.DrinkIntake

sealed class WineIntake : DrinkIntake

data class RedIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_RED_STRENGTH
) : WineIntake()

data class WhiteIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_WHITE_STRENGTH
) : WineIntake()

data class RoseIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_ROSE_STRENGTH
) : WineIntake()

data class ChampagneIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_CHAMPAGNE_STRENGTH
) : WineIntake()

data class PortIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_PORT_STRENGTH
) : WineIntake()

data class VermouthIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_VERMOUTH_STRENGTH
) : WineIntake()

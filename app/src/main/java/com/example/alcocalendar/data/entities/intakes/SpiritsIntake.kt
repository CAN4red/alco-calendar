package com.example.alcocalendar.data.entities.intakes

import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.DrinkIntake

sealed class SpiritsIntake() : DrinkIntake

class VodkaIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_VODKA_STRENGTH
) : SpiritsIntake()

class WhiskeyIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_WHISKEY_STRENGTH
) : SpiritsIntake()

data class CognacIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_COGNAC_STRENGTH
) : SpiritsIntake()

data class RumIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_RUM_STRENGTH
) : SpiritsIntake()

data class TequilaIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_TEQUILA_STRENGTH
) : SpiritsIntake()

data class GinIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_GIN_STRENGTH
) : SpiritsIntake()

data class AbsintheIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_ABSINTHE_STRENGTH
) : SpiritsIntake()

data class LiquorIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_LIQUOR_STRENGTH
) : SpiritsIntake()

data class BrandyIntake(
    override val liters: Double = 0.0,
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_BRANDY_STRENGTH
) : SpiritsIntake()

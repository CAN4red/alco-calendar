package com.example.alcocalendar.data.local.entities.intakes.spirits

import androidx.room.ColumnInfo
import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.local.entities.DrinkIntake

sealed class SpiritsIntake() : DrinkIntake

class VodkaIntake(
    @ColumnInfo(name = "vodka_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "vodka_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_VODKA_STRENGTH
) : SpiritsIntake()

class WhiskeyIntake(
    @ColumnInfo(name = "whiskey_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "whiskey_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_WHISKEY_STRENGTH
) : SpiritsIntake()

data class CognacIntake(
    @ColumnInfo(name = "cognac_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "cognac_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_COGNAC_STRENGTH
) : SpiritsIntake()

data class RumIntake(
    @ColumnInfo(name = "rum_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "rum_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_RUM_STRENGTH
) : SpiritsIntake()

data class TequilaIntake(
    @ColumnInfo(name = "tequila_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "tequila_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_TEQUILA_STRENGTH
) : SpiritsIntake()

data class GinIntake(
    @ColumnInfo(name = "gin_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "gin_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_GIN_STRENGTH
) : SpiritsIntake()

data class AbsintheIntake(
    @ColumnInfo(name = "absinthe_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "absinthe_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_ABSINTHE_STRENGTH
) : SpiritsIntake()

data class LiquorIntake(
    @ColumnInfo(name = "liquor_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "liquor_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_LIQUOR_STRENGTH
) : SpiritsIntake()

data class BrandyIntake(
    @ColumnInfo(name = "brandy_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "brandy_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.SPIRITS_BRANDY_STRENGTH
) : SpiritsIntake()

package com.example.alcocalendar.data.local.entities.intakes.other

import androidx.room.ColumnInfo
import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.local.entities.DrinkIntake

sealed class OtherIntake() : DrinkIntake

data class CocktailsIntake(
    @ColumnInfo(name = "other_cocktails_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "other_cocktails_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_COCKTAILS_STRENGTH
) : OtherIntake()

data class ShotsIntake(
    @ColumnInfo(name = "other_shots_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "other_shots_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_SHOTS_STRENGTH
) : OtherIntake()

data class MoonshineIntake(
    @ColumnInfo(name = "other_moonshine_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "other_moonshine_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_MOONSHINE_STRENGTH
) : OtherIntake()

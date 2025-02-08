package com.example.alcocalendar.data.entities.intakes

import androidx.room.ColumnInfo
import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.DrinkIntake

sealed class OtherIntake() : DrinkIntake

data class OtherCocktailsIntake(
    @ColumnInfo(name = "other_cocktails_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "other_cocktails_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_COCKTAILS_STRENGTH
) : OtherIntake()

data class OtherShotsIntake(
    @ColumnInfo(name = "other_shots_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "other_shots_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_SHOTS_STRENGTH
) : OtherIntake()

data class OtherMoonshineIntake(
    @ColumnInfo(name = "other_moonshine_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "other_moonshine_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.OTHER_MOONSHINE_STRENGTH
) : OtherIntake()

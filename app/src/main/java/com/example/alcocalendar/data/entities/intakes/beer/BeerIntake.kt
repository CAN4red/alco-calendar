package com.example.alcocalendar.data.entities.intakes.beer

import androidx.room.ColumnInfo
import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.DrinkIntake

sealed class BeerIntake : DrinkIntake

data class LightIntake(
    @ColumnInfo(name = "light_beer_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "light_beer_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_LIGHT_STRENGTH,
) : BeerIntake()

data class DarkIntake(
    @ColumnInfo(name = "dark_beer_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "dark_beer_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_DARK_STRENGTH
) : BeerIntake()

data class CiderIntake(
    @ColumnInfo(name = "cider_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "cider_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_CIDER_STRENGTH
) : BeerIntake()

data class UnfilteredIntake(
    @ColumnInfo(name = "unfiltered_beer_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "unfiltered_beer_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_UNFILTERED_STRENGTH
) : BeerIntake()

data class ElIntake(
    @ColumnInfo(name = "el_beer_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "el_beer_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.BEER_EL_STRENGTH
) : BeerIntake()

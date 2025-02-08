package com.example.alcocalendar.data.local.entities.intakes.wine

import androidx.room.ColumnInfo
import com.example.alcocalendar.common.AlcoStrengthConstants
import com.example.alcocalendar.data.local.entities.DrinkIntake

sealed class WineIntake : DrinkIntake

data class RedIntake(
    @ColumnInfo(name = "red_wine_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "red_wine_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_RED_STRENGTH
) : WineIntake()

data class WhiteIntake(
    @ColumnInfo(name = "white_wine_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "white_wine_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_WHITE_STRENGTH
) : WineIntake()

data class RoseIntake(
    @ColumnInfo(name = "rose_wine_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "rose_wine_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_ROSE_STRENGTH
) : WineIntake()

data class ChampagneIntake(
    @ColumnInfo(name = "champagne_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "champagne_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_CHAMPAGNE_STRENGTH
) : WineIntake()

data class PortIntake(
    @ColumnInfo(name = "port_wine_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "port_wine_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_PORT_STRENGTH
) : WineIntake()

data class VermouthIntake(
    @ColumnInfo(name = "vermouth_liters")
    override val liters: Double = 0.0,
    @ColumnInfo(name = "vermouth_strength")
    override val alcoStrength: Double = AlcoStrengthConstants.WINE_VERMOUTH_STRENGTH
) : WineIntake()


package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.example.alcocalendar.db.entities.Drink

data class WineIntake(
    @Embedded val red: Red = Red(),
    @Embedded val white: White = White(),
    @Embedded val rose: Rose = Rose(),
    @Embedded val champagne: Champagne = Champagne(),
    @Embedded val port: Port = Port(),
    @Embedded val vermouth: Vermouth = Vermouth(),
)

data class Red(
    @ColumnInfo(name = "red_wine_liters")
    override val liters: Double = 0.0
) : Drink

data class White(
    @ColumnInfo(name = "white_wine_liters")
    override val liters: Double = 0.0
) : Drink

data class Rose(
    @ColumnInfo(name = "rose_wine_liters")
    override val liters: Double = 0.0
) : Drink

data class Champagne(
    @ColumnInfo(name = "champagne_liters")
    override val liters: Double = 0.0
) : Drink

data class Port(
    @ColumnInfo(name = "port_wine_liters")
    override val liters: Double = 0.0
) : Drink

data class Vermouth(
    @ColumnInfo(name = "vermouth_liters")
    override val liters: Double = 0.0
) : Drink

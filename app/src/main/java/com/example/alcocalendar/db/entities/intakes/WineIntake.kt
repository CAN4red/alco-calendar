package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class WineIntake(
    @Embedded val red: Red = Red(),
    @Embedded val white: White = White(),
    @Embedded val rose: Rose = Rose(),
    @Embedded val champagne: Champagne = Champagne(),
    @Embedded val port: Port = Port(),
    @Embedded val vermouth: Vermouth = Vermouth(),
) {
    fun update(wine: Wine): WineIntake {
        return when (wine) {
            is Red -> this.copy(red = wine)
            is White -> this.copy(white = wine)
            is Rose -> this.copy(rose = wine)
            is Champagne -> this.copy(champagne = wine)
            is Port -> this.copy(port = wine)
            is Vermouth -> this.copy(vermouth = wine)
        }
    }
}

sealed interface Wine {
    val liters: Double
}

data class Red(
    @ColumnInfo(name = "red_wine_liters")
    override val liters: Double = 0.0
) : Wine

data class White(
    @ColumnInfo(name = "white_wine_liters")
    override val liters: Double = 0.0
) : Wine

data class Rose(
    @ColumnInfo(name = "rose_wine_liters")
    override val liters: Double = 0.0
) : Wine

data class Champagne(
    @ColumnInfo(name = "champagne_liters")
    override val liters: Double = 0.0
) : Wine

data class Port(
    @ColumnInfo(name = "port_wine_liters")
    override val liters: Double = 0.0
) : Wine

data class Vermouth(
    @ColumnInfo(name = "vermouth_liters")
    override val liters: Double = 0.0
) : Wine

package com.example.alcocalendar.db.entities.intakes

import androidx.room.Embedded

data class WineIntake(
    @Embedded val red: Wine.Red = Wine.Red(),
    @Embedded val white: Wine.White = Wine.White(),
    @Embedded val rose: Wine.Rose = Wine.Rose(),
    @Embedded val champagne: Wine.Champagne = Wine.Champagne(),
    @Embedded val port: Wine.Port = Wine.Port(),
    @Embedded val vermouth: Wine.Vermouth = Wine.Vermouth(),
): Intake {
    override val isEmpty: Boolean
        get() = red.isEmpty &&
                white.isEmpty &&
                rose.isEmpty &&
                champagne.isEmpty &&
                port.isEmpty &&
                vermouth.isEmpty

    override val alcoUnits: Double
        get() = red.alcoUnits +
                white.alcoUnits +
                rose.alcoUnits +
                champagne.alcoUnits +
                port.alcoUnits +
                vermouth.alcoUnits

    fun update(wine: Wine): WineIntake {
        return when (wine) {
            is Wine.Red -> this.copy(red = wine)
            is Wine.White -> this.copy(white = wine)
            is Wine.Rose -> this.copy(rose = wine)
            is Wine.Champagne -> this.copy(champagne = wine)
            is Wine.Port -> this.copy(port = wine)
            is Wine.Vermouth -> this.copy(vermouth = wine)
        }
    }
}

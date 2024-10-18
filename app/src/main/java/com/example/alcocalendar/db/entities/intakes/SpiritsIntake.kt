package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo
import androidx.room.Embedded
import com.example.alcocalendar.db.entities.Drink

data class SpiritsIntake(
    @Embedded val vodka: Vodka = Vodka(),
    @Embedded val whiskey: Whiskey = Whiskey(),
    @Embedded val cognac: Cognac = Cognac(),
    @Embedded val rum: Rum = Rum(),
    @Embedded val tequila: Tequila = Tequila(),
    @Embedded val gin: Gin = Gin(),
    @Embedded val absinthe: Absinthe = Absinthe(),
    @Embedded val brandy: Brandy = Brandy()
)

data class Vodka(
    @ColumnInfo(name = "vodka_liters")
    override val liters: Double = 0.0
) : Drink

data class Whiskey(
    @ColumnInfo(name = "whiskey_liters")
    override val liters: Double = 0.0
) : Drink

data class Cognac(
    @ColumnInfo(name = "cognac_liters")
    override val liters: Double = 0.0
) : Drink

data class Rum(
    @ColumnInfo(name = "rum_liters")
    override val liters: Double = 0.0
) : Drink

data class Tequila(
    @ColumnInfo(name = "tequila_liters")
    override val liters: Double = 0.0
) : Drink

data class Gin(
    @ColumnInfo(name = "gin_liters")
    override val liters: Double = 0.0
) : Drink

data class Absinthe(
    @ColumnInfo(name = "absinthe_liters")
    override val liters: Double = 0.0
) : Drink

data class Brandy(
    @ColumnInfo(name = "brandy_liters")
    override val liters: Double = 0.0
) : Drink

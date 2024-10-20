package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class SpiritsIntake(
    @Embedded val vodka: Vodka = Vodka(),
    @Embedded val whiskey: Whiskey = Whiskey(),
    @Embedded val cognac: Cognac = Cognac(),
    @Embedded val rum: Rum = Rum(),
    @Embedded val tequila: Tequila = Tequila(),
    @Embedded val gin: Gin = Gin(),
    @Embedded val absinthe: Absinthe = Absinthe(),
    @Embedded val brandy: Brandy = Brandy()
) {
    val isEmpty: Boolean
        get() = vodka.isEmpty &&
                whiskey.isEmpty &&
                cognac.isEmpty &&
                rum.isEmpty &&
                tequila.isEmpty &&
                gin.isEmpty &&
                absinthe.isEmpty &&
                brandy.isEmpty

    fun update(spirits: Spirits): SpiritsIntake {
        return when (spirits) {
            is Vodka -> this.copy(vodka = spirits)
            is Whiskey -> this.copy(whiskey = spirits)
            is Cognac -> this.copy(cognac = spirits)
            is Rum -> this.copy(rum = spirits)
            is Tequila -> this.copy(tequila = spirits)
            is Gin -> this.copy(gin = spirits)
            is Absinthe -> this.copy(absinthe = spirits)
            is Brandy -> this.copy(brandy = spirits)
        }
    }
}

sealed interface Spirits {
    val liters: Double
    val isEmpty: Boolean
        get() = liters == 0.0
}

data class Vodka(
    @ColumnInfo(name = "vodka_liters")
    override val liters: Double = 0.0
) : Spirits

data class Whiskey(
    @ColumnInfo(name = "whiskey_liters")
    override val liters: Double = 0.0
) : Spirits

data class Cognac(
    @ColumnInfo(name = "cognac_liters")
    override val liters: Double = 0.0
) : Spirits

data class Rum(
    @ColumnInfo(name = "rum_liters")
    override val liters: Double = 0.0
) : Spirits

data class Tequila(
    @ColumnInfo(name = "tequila_liters")
    override val liters: Double = 0.0
) : Spirits

data class Gin(
    @ColumnInfo(name = "gin_liters")
    override val liters: Double = 0.0
) : Spirits

data class Absinthe(
    @ColumnInfo(name = "absinthe_liters")
    override val liters: Double = 0.0
) : Spirits

data class Brandy(
    @ColumnInfo(name = "brandy_liters")
    override val liters: Double = 0.0
) : Spirits

package com.example.alcocalendar.db.entities.intakes

import androidx.room.Embedded

data class SpiritsIntake(
    @Embedded val vodka: Spirits.Vodka = Spirits.Vodka(),
    @Embedded val whiskey: Spirits.Whiskey = Spirits.Whiskey(),
    @Embedded val cognac: Spirits.Cognac = Spirits.Cognac(),
    @Embedded val rum: Spirits.Rum = Spirits.Rum(),
    @Embedded val tequila: Spirits.Tequila = Spirits.Tequila(),
    @Embedded val gin: Spirits.Gin = Spirits.Gin(),
    @Embedded val absinthe: Spirits.Absinthe = Spirits.Absinthe(),
    @Embedded val liquor: Spirits.Liquor = Spirits.Liquor(),
    @Embedded val brandy: Spirits.Brandy = Spirits.Brandy()
): Intake {
    override val isEmpty: Boolean
        get() = vodka.isEmpty &&
                whiskey.isEmpty &&
                cognac.isEmpty &&
                rum.isEmpty &&
                tequila.isEmpty &&
                gin.isEmpty &&
                absinthe.isEmpty &&
                liquor.isEmpty &&
                brandy.isEmpty

    override val alcoUnits: Double
        get() = vodka.alcoUnits +
                whiskey.alcoUnits +
                cognac.alcoUnits +
                rum.alcoUnits +
                tequila.alcoUnits +
                gin.alcoUnits +
                absinthe.alcoUnits +
                liquor.alcoUnits +
                brandy.alcoUnits

    fun update(spirits: Spirits): SpiritsIntake {
        return when (spirits) {
            is Spirits.Vodka -> this.copy(vodka = spirits)
            is Spirits.Whiskey -> this.copy(whiskey = spirits)
            is Spirits.Cognac -> this.copy(cognac = spirits)
            is Spirits.Rum -> this.copy(rum = spirits)
            is Spirits.Tequila -> this.copy(tequila = spirits)
            is Spirits.Gin -> this.copy(gin = spirits)
            is Spirits.Absinthe -> this.copy(absinthe = spirits)
            is Spirits.Liquor -> this.copy(liquor = spirits)
            is Spirits.Brandy -> this.copy(brandy = spirits)
        }
    }
}

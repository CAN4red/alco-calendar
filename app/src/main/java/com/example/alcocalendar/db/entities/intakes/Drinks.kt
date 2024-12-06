package com.example.alcocalendar.db.entities.intakes

import androidx.room.ColumnInfo

sealed interface Drink {
    val liters: Double

    val isEmpty: Boolean
        get() = liters == 0.0

    fun copyDrink(liters: Double): Drink
}

sealed class Beer : Drink {

    override fun copyDrink(liters: Double): Beer {
        return when (this) {
            is Light -> Light(liters)
            is Dark -> Dark(liters)
            is Cider -> Cider(liters)
            is Unfiltered -> Unfiltered(liters)
            is El -> El(liters)
        }
    }

    data class Light(
        @ColumnInfo(name = "light_beer_liters")
        override val liters: Double = 0.0
    ) : Beer()

    data class Dark(
        @ColumnInfo(name = "dark_beer_liters")
        override val liters: Double = 0.0
    ) : Beer()

    data class Cider(
        @ColumnInfo(name = "cider_liters")
        override val liters: Double = 0.0
    ) : Beer()

    data class Unfiltered(
        @ColumnInfo(name = "unfiltered_liters")
        override val liters: Double = 0.0
    ) : Beer()

    data class El(
        @ColumnInfo(name = "el_liters")
        override val liters: Double = 0.0
    ) : Beer()
}

sealed class Wine : Drink {

    override fun copyDrink(liters: Double): Wine {
        return when (this) {
            is Red -> Red(liters)
            is White -> White(liters)
            is Rose -> Rose(liters)
            is Champagne -> Champagne(liters)
            is Port -> Port(liters)
            is Vermouth -> Vermouth(liters)
        }
    }

    data class Red(
        @ColumnInfo(name = "red_wine_liters")
        override val liters: Double = 0.0
    ) : Wine()

    data class White(
        @ColumnInfo(name = "white_wine_liters")
        override val liters: Double = 0.0
    ) : Wine()

    data class Rose(
        @ColumnInfo(name = "rose_wine_liters")
        override val liters: Double = 0.0
    ) : Wine()

    data class Champagne(
        @ColumnInfo(name = "champagne_liters")
        override val liters: Double = 0.0
    ) : Wine()

    data class Port(
        @ColumnInfo(name = "port_wine_liters")
        override val liters: Double = 0.0
    ) : Wine()

    data class Vermouth(
        @ColumnInfo(name = "vermouth_liters")
        override val liters: Double = 0.0
    ) : Wine()
}

sealed class Spirits : Drink {
    override fun copyDrink(liters: Double): Spirits {
        return when (this) {
            is Vodka -> Vodka(liters)
            is Whiskey -> Whiskey(liters)
            is Cognac -> Cognac(liters)
            is Rum -> Rum(liters)
            is Tequila -> Tequila(liters)
            is Gin -> Gin(liters)
            is Absinthe -> Absinthe(liters)
            is Liquor -> Liquor(liters)
            is Brandy -> Brandy(liters)
        }
    }

    data class Vodka(
        @ColumnInfo(name = "vodka_liters")
        override val liters: Double = 0.0
    ) : Spirits()

    data class Whiskey(
        @ColumnInfo(name = "whiskey_liters")
        override val liters: Double = 0.0
    ) : Spirits()

    data class Cognac(
        @ColumnInfo(name = "cognac_liters")
        override val liters: Double = 0.0
    ) : Spirits()

    data class Rum(
        @ColumnInfo(name = "rum_liters")
        override val liters: Double = 0.0
    ) : Spirits()

    data class Tequila(
        @ColumnInfo(name = "tequila_liters")
        override val liters: Double = 0.0
    ) : Spirits()

    data class Gin(
        @ColumnInfo(name = "gin_liters")
        override val liters: Double = 0.0
    ) : Spirits()

    data class Absinthe(
        @ColumnInfo(name = "absinthe_liters")
        override val liters: Double = 0.0
    ) : Spirits()

    data class Liquor(
        @ColumnInfo(name = "liquor_liters")
        override val liters: Double = 0.0
    ) : Spirits()

    data class Brandy(
        @ColumnInfo(name = "brandy_liters")
        override val liters: Double = 0.0
    ) : Spirits()
}

sealed class OtherDrink : Drink {

    override fun copyDrink(liters: Double): OtherDrink {
        return when (this) {
            is Cocktails -> Cocktails(liters)
            is Shots -> Shots(liters)
            is Moonshine -> Moonshine(liters)
        }
    }

    data class Cocktails(
        @ColumnInfo(name = "cocktails_liters")
        override val liters: Double = 0.0
    ) : OtherDrink()

    data class Shots(
        @ColumnInfo(name = "shots_liters")
        override val liters: Double = 0.0
    ) : OtherDrink()

    data class Moonshine(
        @ColumnInfo(name = "moonshine_liters")
        override val liters: Double = 0.0
    ) : OtherDrink()
}

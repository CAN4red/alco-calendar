package com.example.alcocalendar.data.local.converters

import androidx.room.TypeConverter
import com.example.alcocalendar.data.local.entities.drinks.types.BeerType
import com.example.alcocalendar.data.local.entities.drinks.types.DrinkType
import com.example.alcocalendar.data.local.entities.drinks.types.OtherType
import com.example.alcocalendar.data.local.entities.drinks.types.SpiritsType
import com.example.alcocalendar.data.local.entities.drinks.types.WineType


class DrinkTypeConverter {

    private val stringToDrinkTypeMap: Map<String, DrinkType> by lazy {
        val beerMap = BeerType.entries.associateBy { it.name.lowercase() }
        val wineMap = WineType.entries.associateBy { it.name.lowercase() }
        val spiritsMap = SpiritsType.entries.associateBy { it.name.lowercase() }
        val otherMap = OtherType.entries.associateBy { it.name.lowercase() }

        beerMap + wineMap + spiritsMap + otherMap
    }

    @TypeConverter
    fun fromDrinkType(drinkType: DrinkType): String {
        return drinkType.toString().lowercase()
    }

    @TypeConverter
    fun toDrinkType(string: String): DrinkType {
        return stringToDrinkTypeMap[string.lowercase()] ?: throw IllegalArgumentException()
    }
}

fun main() {
    val tp = DrinkTypeConverter()
    println(tp.fromDrinkType(BeerType.LIGHT))
    println(tp.toDrinkType("light"))
}
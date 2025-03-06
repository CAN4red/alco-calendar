package com.example.alcocalendar.core.data.local.converters

import androidx.room.TypeConverter
import com.example.alcocalendar.core.data.local.entity.drink_types.BeerType
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.core.data.local.entity.drink_types.OtherType
import com.example.alcocalendar.core.data.local.entity.drink_types.SpiritsType
import com.example.alcocalendar.core.data.local.entity.drink_types.WineType


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

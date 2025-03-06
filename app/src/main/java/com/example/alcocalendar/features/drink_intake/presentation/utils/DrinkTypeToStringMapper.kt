package com.example.alcocalendar.features.drink_intake.presentation.utils

import androidx.annotation.StringRes
import com.example.alcocalendar.R
import com.example.alcocalendar.core.data.local.entity.drink_types.BeerType
import com.example.alcocalendar.core.data.local.entity.drink_types.OtherType
import com.example.alcocalendar.core.data.local.entity.drink_types.SpiritsType
import com.example.alcocalendar.core.data.local.entity.drink_types.WineType
import com.example.alcocalendar.core.domain.model.DrinkType

object DrinkTypeToStringMapper {

    @StringRes
    inline fun <reified T> generalTypeName(): Int where T : Enum<T>, T : DrinkType {
        return when (T::class) {
            BeerType::class -> R.string.beer_title
            WineType::class -> R.string.wine_title
            SpiritsType::class -> R.string.spirits_title
            OtherType::class -> R.string.other_title

            else -> R.string.unknown_drink
        }
    }

    @StringRes
    fun DrinkType.typeName(): Int = when (this) {
        is BeerType -> this.typeName()
        is WineType -> this.typeName()
        is SpiritsType -> this.typeName()
        is OtherType -> this.typeName()

        else -> R.string.unknown_drink
    }

    @StringRes
    private fun BeerType.typeName(): Int = when (this) {
        BeerType.LIGHT -> R.string.light
        BeerType.DARK -> R.string.dark
        BeerType.CIDER -> R.string.cider
        BeerType.UNFILTERED -> R.string.unfiltered
        BeerType.EL -> R.string.el
    }

    @StringRes
    private fun WineType.typeName(): Int = when (this) {
        WineType.RED -> R.string.red
        WineType.WHITE -> R.string.white
        WineType.ROSE -> R.string.rose
        WineType.CHAMPAGNE -> R.string.champagne
        WineType.PORT -> R.string.port
        WineType.VERMOUTH -> R.string.vermouth
    }

    @StringRes
    private fun SpiritsType.typeName(): Int = when (this) {
        SpiritsType.VODKA -> R.string.vodka
        SpiritsType.WHISKEY -> R.string.whiskey
        SpiritsType.COGNAC -> R.string.cognac
        SpiritsType.RUM -> R.string.rum
        SpiritsType.TEQUILA -> R.string.tequila
        SpiritsType.GIN -> R.string.gin
        SpiritsType.SOJU -> R.string.soju
        SpiritsType.ABSINTHE -> R.string.absinthe
        SpiritsType.LIQUOR -> R.string.liquor
        SpiritsType.BRANDY -> R.string.brandy
    }

    @StringRes
    private fun OtherType.typeName(): Int = when (this) {
        OtherType.COCKTAILS -> R.string.cocktails
        OtherType.SHOTS -> R.string.shots
        OtherType.MOONSHINE -> R.string.moonshine
    }
}

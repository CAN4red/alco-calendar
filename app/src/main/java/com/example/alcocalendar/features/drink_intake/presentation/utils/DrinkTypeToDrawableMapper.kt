package com.example.alcocalendar.features.drink_intake.presentation.utils

import com.example.alcocalendar.R
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.core.data.local.entities.drink_types.OtherType
import com.example.alcocalendar.core.data.local.entities.drink_types.SpiritsType
import com.example.alcocalendar.core.data.local.entities.drink_types.WineType
import com.example.alcocalendar.core.domain.model.DrinkType

object DrinkTypeToDrawableMapper {

    fun DrinkType.toDrawable(): Int {
        return when (this) {
            is BeerType -> this.toDrawable()
            is WineType -> this.toDrawable()
            is SpiritsType -> this.toDrawable()
            is OtherType -> this.toDrawable()
            else -> R.drawable.resource_default
        }
    }

    private fun BeerType.toDrawable(): Int {
        return when (this) {
            BeerType.LIGHT -> R.drawable.beer_light
            BeerType.DARK -> R.drawable.beer_dark
            BeerType.CIDER -> R.drawable.beer_cider
            BeerType.UNFILTERED -> R.drawable.beer_unfiltered
            BeerType.EL -> R.drawable.beer_el
        }
    }

    private fun WineType.toDrawable(): Int {
        return when (this) {
            WineType.RED -> R.drawable.wine_red
            WineType.WHITE -> R.drawable.wine_white
            WineType.ROSE -> R.drawable.wine_rose
            WineType.CHAMPAGNE -> R.drawable.wine_champagne
            WineType.PORT -> R.drawable.wine_port
            WineType.VERMOUTH -> R.drawable.wine_vermouth
        }
    }

    private fun SpiritsType.toDrawable(): Int {
        return when (this) {
            SpiritsType.VODKA -> R.drawable.spirits_vodka
            SpiritsType.WHISKEY -> R.drawable.spirits_whiskey
            SpiritsType.COGNAC -> R.drawable.spirits_cognac
            SpiritsType.RUM -> R.drawable.spirits_rum
            SpiritsType.TEQUILA -> R.drawable.spirits_tequila
            SpiritsType.GIN -> R.drawable.spirits_gin
            SpiritsType.SOJU -> R.drawable.spirits_soju
            SpiritsType.ABSINTHE -> R.drawable.spirits_absinthe
            SpiritsType.LIQUOR -> R.drawable.spirits_liquor
            SpiritsType.BRANDY -> R.drawable.spirits_brandy
        }
    }

    private fun OtherType.toDrawable(): Int {
        return when (this) {
            OtherType.COCKTAILS -> R.drawable.other_cocktails
            OtherType.SHOTS -> R.drawable.other_shots
            OtherType.MOONSHINE -> R.drawable.other_moonshine
        }
    }
}
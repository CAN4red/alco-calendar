package com.example.alcocalendar.features.drink_intake.presentation.utils

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.alcocalendar.R
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.core.data.local.entities.drink_types.OtherType
import com.example.alcocalendar.core.data.local.entities.drink_types.SpiritsType
import com.example.alcocalendar.core.data.local.entities.drink_types.WineType
import com.example.alcocalendar.core.domain.model.DrinkType

object DrinkTypeToStringMapper {

    @Composable
    inline fun <reified T> headlineName(): String where T : Enum<T>, T : DrinkType {
        return when (T::class) {
            BeerType::class -> stringResource(R.string.beer_headline)
            WineType::class -> stringResource(R.string.wine_headline)
            SpiritsType::class -> stringResource(R.string.spirits_headline)
            OtherType::class -> stringResource(R.string.other_headline)

            else -> stringResource(R.string.unknown_drink_type_headline)
        }
    }

    @StringRes
    fun DrinkType.titleName(): Int = when (this) {
        is BeerType -> R.string.beer_title
        is WineType -> R.string.wine_title
        is SpiritsType -> R.string.spirits_title
        is OtherType -> R.string.other_title

        else -> R.string.unknown_drink
    }
}

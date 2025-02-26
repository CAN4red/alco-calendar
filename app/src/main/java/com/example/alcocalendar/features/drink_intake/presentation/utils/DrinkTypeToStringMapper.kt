package com.example.alcocalendar.features.drink_intake.presentation.utils

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

    @Composable
    fun DrinkType.titleName(): String = when (this) {
        is BeerType -> this.displayName()
        is WineType -> this.displayName()
        is SpiritsType -> this.displayName()
        is OtherType -> this.displayName()

        else -> stringResource(R.string.unknown_drink)
    }

    private fun <T: Enum<T>> T.displayName() = this.name
        .lowercase()
        .replaceFirstChar { it.titlecaseChar() }
}

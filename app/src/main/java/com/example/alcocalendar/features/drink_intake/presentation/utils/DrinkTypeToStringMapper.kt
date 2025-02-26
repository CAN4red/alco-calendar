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

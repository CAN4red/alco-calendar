package com.example.alcocalendar.core.data.local.entities.drink_types

import com.example.alcocalendar.core.common.AlcoStrengthConstants
import com.example.alcocalendar.core.domain.model.DrinkType

enum class BeerType(override val defaultAlcoStrength: Double) : DrinkType {
    LIGHT(AlcoStrengthConstants.BEER_LIGHT_STRENGTH),
    DARK(AlcoStrengthConstants.BEER_DARK_STRENGTH),
    CIDER(AlcoStrengthConstants.BEER_CIDER_STRENGTH),
    UNFILTERED(AlcoStrengthConstants.BEER_UNFILTERED_STRENGTH),
    EL(AlcoStrengthConstants.BEER_EL_STRENGTH),
}
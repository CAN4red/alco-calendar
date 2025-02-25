package com.example.alcocalendar.core.data.local.entities.drink_types

import com.example.alcocalendar.core.common.AlcoStrengthConstants
import com.example.alcocalendar.core.domain.model.DrinkType

enum class SpiritsType(override val defaultAlcoStrength: Double) : DrinkType {
    VODKA(AlcoStrengthConstants.SPIRITS_VODKA_STRENGTH),
    WHISKEY(AlcoStrengthConstants.SPIRITS_WHISKEY_STRENGTH),
    COGNAC(AlcoStrengthConstants.SPIRITS_COGNAC_STRENGTH),
    RUM(AlcoStrengthConstants.SPIRITS_RUM_STRENGTH),
    TEQUILA(AlcoStrengthConstants.SPIRITS_TEQUILA_STRENGTH),
    GIN(AlcoStrengthConstants.SPIRITS_GIN_STRENGTH),
    ABSINTHE(AlcoStrengthConstants.SPIRITS_ABSINTHE_STRENGTH),
    LIQUOR(AlcoStrengthConstants.SPIRITS_LIQUOR_STRENGTH),
    BRANDY(AlcoStrengthConstants.SPIRITS_BRANDY_STRENGTH),
}
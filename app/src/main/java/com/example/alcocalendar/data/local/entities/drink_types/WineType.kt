package com.example.alcocalendar.data.local.entities.drink_types

import com.example.alcocalendar.common.AlcoStrengthConstants

enum class WineType(override val defaultAlcoStrength: Double) : DrinkType {
    RED(AlcoStrengthConstants.WINE_RED_STRENGTH),
    WHITE(AlcoStrengthConstants.WINE_WHITE_STRENGTH),
    ROSE(AlcoStrengthConstants.WINE_ROSE_STRENGTH),
    CHAMPAGNE(AlcoStrengthConstants.WINE_CHAMPAGNE_STRENGTH),
    PORT(AlcoStrengthConstants.WINE_PORT_STRENGTH),
    VERMOUTH(AlcoStrengthConstants.WINE_VERMOUTH_STRENGTH),
}
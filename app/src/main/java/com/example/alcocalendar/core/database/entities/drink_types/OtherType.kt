package com.example.alcocalendar.core.database.entities.drink_types

import com.example.alcocalendar.core.common.AlcoStrengthConstants

enum class OtherType(override val defaultAlcoStrength: Double) : DrinkType {
    COCKTAILS(AlcoStrengthConstants.OTHER_COCKTAILS_STRENGTH),
    SHOTS(AlcoStrengthConstants.OTHER_SHOTS_STRENGTH),
    MOONSHINE(AlcoStrengthConstants.OTHER_MOONSHINE_STRENGTH),
}
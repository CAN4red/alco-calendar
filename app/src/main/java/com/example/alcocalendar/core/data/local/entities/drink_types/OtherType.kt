package com.example.alcocalendar.core.data.local.entities.drink_types

import com.example.alcocalendar.core.common.AlcoStrengthConstants
import com.example.alcocalendar.core.domain.model.DrinkType

enum class OtherType(override val defaultAlcoStrength: Double) : DrinkType {
    COCKTAILS(AlcoStrengthConstants.OTHER_COCKTAILS_STRENGTH),
    SHOTS(AlcoStrengthConstants.OTHER_SHOTS_STRENGTH),
    MOONSHINE(AlcoStrengthConstants.OTHER_MOONSHINE_STRENGTH),
}
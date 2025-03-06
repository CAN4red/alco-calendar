package com.example.alcocalendar.features.session_manage.drink_intake.presentation

import com.example.alcocalendar.R
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.DrinkTypeToStringMapper.typeName
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.Formatter.formatAsString
import java.time.LocalDate

data class DrinkIntakeState(
    val date: LocalDate = LocalDate.now(),
    val intakes: List<DrinkIntake> = emptyList(),
    val fillingIntake: DrinkIntake? = null,
    val expandedDrinkType: Class<out DrinkType>? = null,
) {
    val fillingIntakeTitle
        get() = fillingIntake?.drinkType?.typeName() ?: R.string.unknown_drink

    val fillingAlcoStrengthString
        get() = fillingIntake?.alcoStrength?.formatAsStringExcludingZero() ?: ""

    val fillingLitersString
        get() = fillingIntake?.liters?.formatAsStringExcludingZero() ?: ""

    private fun Double.formatAsStringExcludingZero(): String {
        if (this == 0.0) return ""
        return this.formatAsString()
    }
}

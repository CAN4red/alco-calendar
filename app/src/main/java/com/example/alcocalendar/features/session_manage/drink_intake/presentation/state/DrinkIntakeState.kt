package com.example.alcocalendar.features.session_manage.drink_intake.presentation.state

import com.example.alcocalendar.R
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.DrinkTypeToStringMapper.typeName
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.utils.Formatter.formatAsString
import java.time.LocalDate

data class DrinkIntakeState(
    val date: LocalDate = LocalDate.now(),
    val intakes: List<DrinkIntake> = emptyList(),
    val fillingIntake: FillingIntakeState? = null,
    val expandedDrinkType: Class<out DrinkType>? = null,
) {
    val fillingIntakeTitle
        get() = fillingIntake?.intake?.drinkType?.typeName() ?: R.string.unknown_drink

    val fillingAlcoStrengthString
        get() = fillingIntake?.intake?.alcoStrength?.formatAsStringExcludingZero() ?: ""

    val fillingLitersString
        get() = fillingIntake?.intake?.liters?.formatAsStringExcludingZero() ?: ""

    private fun Double.formatAsStringExcludingZero(): String {
        if (this == 0.0) return ""
        return this.formatAsString()
    }
}

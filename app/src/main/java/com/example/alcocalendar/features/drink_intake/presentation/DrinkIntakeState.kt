package com.example.alcocalendar.features.drink_intake.presentation

import com.example.alcocalendar.R
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.drink_intake.presentation.utils.DrinkTypeToStringMapper.titleName
import java.text.NumberFormat
import java.time.LocalDate
import java.util.Locale

data class DrinkIntakeState(
    val date: LocalDate = LocalDate.now(),
    val intakes: List<DrinkIntake> = emptyList(),
    val fillingIntake: DrinkIntake? = null,
    val expandedDrinkType: Class<out DrinkType>? = null,
) {
    val fillingIntakeTitle
        get() = fillingIntake?.drinkType?.titleName() ?: R.string.unknown_drink

    val fillingAlcoStrengthString
        get() = fillingIntake?.alcoStrength?.formatAsString() ?: ""

    val fillingLitersString
        get() = fillingIntake?.liters?.formatAsString() ?: ""

    private fun Double.formatAsString(): String {
        return if (this == 0.0) ""
        else {
            NumberFormat.getInstance(Locale.getDefault()).apply {
                maximumFractionDigits = 3
                isGroupingUsed = false
            }.format(this)
        }
    }
}

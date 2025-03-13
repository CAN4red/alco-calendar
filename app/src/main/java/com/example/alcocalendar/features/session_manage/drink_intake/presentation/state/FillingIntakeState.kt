package com.example.alcocalendar.features.session_manage.drink_intake.presentation.state

import com.example.alcocalendar.core.domain.model.DrinkIntake

data class FillingIntakeState(
    val intake: DrinkIntake,
    val initialIntake: DrinkIntake?,
    val fillingType: FillingType,
) {
    val isFittingWithInitial: Boolean
        get() = intake.drinkType == initialIntake?.drinkType &&
                intake.alcoStrength == initialIntake.alcoStrength
}

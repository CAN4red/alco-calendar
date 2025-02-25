package com.example.alcocalendar.features.drink_intake.presentation

import java.time.LocalDate
import java.time.Month

object DrinkIntakeUtils {

    fun String?.toYear(): Int = this?.toInt() ?: LocalDate.now().year
    fun String?.toMonth(): Month = this?.toMonth() ?: LocalDate.now().month
    fun String?.toDay(): Int = this?.toInt() ?: LocalDate.now().dayOfMonth

    private fun String.toMonth() = Month.valueOf(this.uppercase())
}
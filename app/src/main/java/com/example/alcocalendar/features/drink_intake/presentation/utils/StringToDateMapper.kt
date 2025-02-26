package com.example.alcocalendar.features.drink_intake.presentation.utils

import java.time.LocalDate
import java.time.Month

object StringToDateMapper {

    fun String?.toYear(): Int = this?.toInt() ?: LocalDate.now().year
    fun String?.toMonth(): Month = this?.toMonthUnsafe() ?: LocalDate.now().month
    fun String?.toDay(): Int = this?.toInt() ?: LocalDate.now().dayOfMonth

    private fun String.toMonthUnsafe() = Month.valueOf(this.uppercase())
}
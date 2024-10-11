package com.example.alcocalendar.model

import android.annotation.SuppressLint
import java.time.Month

class YearModel(
    val year: Int,
    val months: Map<Month, MonthModel>,
) {
    constructor(year: Int) : this(
        year = year,
        months = getAllMonths().associateWith { month ->
            MonthModel(year, month)
        }
    )

    fun getMonthModel(month: Month): MonthModel {
        return months[month] ?: throw IllegalArgumentException("Invalid month: $month")
    }
}

@SuppressLint("NewApi")
fun getAllMonths(): List<Month> {
    return listOf(
        Month.JANUARY,
        Month.FEBRUARY,
        Month.MARCH,
        Month.APRIL,
        Month.MAY,
        Month.JUNE,
        Month.JULY,
        Month.AUGUST,
        Month.SEPTEMBER,
        Month.OCTOBER,
        Month.NOVEMBER,
        Month.DECEMBER
    )
}

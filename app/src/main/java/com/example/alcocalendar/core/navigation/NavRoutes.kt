package com.example.alcocalendar.core.navigation

import java.time.Month

object NavRoutes {
    const val CALENDAR = "calendar"

    const val MONTH_CALENDAR = "month_calendar"
    const val YEAR_CALENDAR = "year_calendar"
    const val DRINK_INTAKE = "drink_intake/{${NavArgs.YEAR}}/{${NavArgs.MONTH}}/{${NavArgs.DAY}}"

    fun drinkIntakeCalendarRoute(year: Int, month: Month, day: Int) =
        "drink_intake/${year.toString().lowercase()}" +
                "/${month.toString().lowercase()}" +
                "/${day.toString().lowercase()}"
}
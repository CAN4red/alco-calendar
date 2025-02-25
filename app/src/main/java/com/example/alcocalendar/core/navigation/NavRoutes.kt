package com.example.alcocalendar.core.navigation

object NavRoutes {
    const val CALENDAR = "calendar"

    const val MONTH_CALENDAR = "month_calendar"
    const val YEAR_CALENDAR = "year_calendar"
    const val DRINK_INTAKE = "drink_intake/{${NavArgs.YEAR}}/{${NavArgs.MONTH}}/{${NavArgs.DAY}}"

    fun drinkIntakeCalendarRoute(year: String, month: String, day: String) =
        "drink_intake/{${year.lowercase()}}/{${month.lowercase()}}/{${day.lowercase()}}"
}
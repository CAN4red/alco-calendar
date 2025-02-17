package com.example.alcocalendar.core.navigation

object NavRoutes {
    private const val MONTH_CALENDAR_BASE = "month_calendar"
    private const val YEAR_CALENDAR_BASE = "year_calendar"

    const val CALENDAR = "calendar"
//    const val MONTH_CALENDAR = "$MONTH_CALENDAR_BASE/{${NavArgs.YEAR}}/{${NavArgs.MONTH}}"
//    const val YEAR_CALENDAR = "$YEAR_CALENDAR_BASE/{${NavArgs.YEAR}}"

    const val MONTH_CALENDAR = "month_calendar"
    const val YEAR_CALENDAR = "year_calendar"

    fun monthCalendarRoute(year: String, month: String) =
        "$MONTH_CALENDAR_BASE/${year.lowercase()}/${month.lowercase()}"

    fun yearCalendarRoute(year: String) =
        "$YEAR_CALENDAR_BASE/${year.lowercase()}"
}
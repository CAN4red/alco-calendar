package com.example.alcocalendar.core.navigation

import java.time.Month

object NavRoutes {
    const val CALENDAR = "calendar"

    const val MONTH_CALENDAR = "month_calendar"
    const val YEAR_CALENDAR = "year_calendar"
    const val SESSION_MANAGE = "session_manage/{${NavArgs.YEAR}}/{${NavArgs.MONTH}}/{${NavArgs.DAY}}"

    fun sessionManageRoute(year: Int, month: Month, day: Int) =
        "session_manage/${year.toString().lowercase()}" +
                "/${month.toString().lowercase()}" +
                "/${day.toString().lowercase()}"
}
package com.example.alcocalendar.app

sealed class Screen(val route: String) {
    data object YearCalendarScreen : Screen("year_calendar_screen")
    data object MonthCalendarScreen : Screen("month_calendar_screen")
}
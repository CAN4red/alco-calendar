package com.example.alcocalendar.app.navigation

import androidx.navigation.NavBackStackEntry
import com.example.alcocalendar.core.navigation.NavArgs
import java.time.Month
import java.time.Year
import java.time.YearMonth


fun NavBackStackEntry.parseMonthFromArguments(): YearMonth {
    val year = this.arguments?.getInt(NavArgs.YEAR)
    val monthString = this.arguments?.getString(NavArgs.MONTH)

    return if (year != null && monthString != null) {
        val month = Month.valueOf(monthString.uppercase())
        YearMonth.of(year, month)
    } else {
        YearMonth.now()
    }
}

fun NavBackStackEntry.parseYearFromArguments(): Year {
    val year = this.arguments?.getInt(NavArgs.YEAR)
    return year?.let { Year.of(it) } ?: Year.now()
}

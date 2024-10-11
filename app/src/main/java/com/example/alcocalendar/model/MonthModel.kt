package com.example.alcocalendar.model

import android.annotation.SuppressLint
import com.example.alcocalendar.ui.calendar.Weekdays
import com.example.alcocalendar.ui.calendar.month.getWeekday
import kotlinx.collections.immutable.toImmutableList
import java.time.LocalDate
import java.time.Month

data class MonthModel(
    val name: String,
    val year: Int,
    val month: Month,
    val dates: List<DrinkingSessionModel>,
) {
    @SuppressLint("NewApi")
    constructor(year: Int, month: Month) : this(
        name = month.getMonthName(),
        year = year,
        month = month,
        dates = generateEmptySessions(year, month),
    )

    var monthMatrix: List<List<DrinkingSessionModel>> = generateMonthMatrix()
        private set

    fun getDay(date: Int): DrinkingSessionModel {
        return dates[date - 1]
    }

    // Gets a matrix like [Column number = Weekday number] with Empty Drinking Sessions
    @SuppressLint("NewApi")
    private fun generateMonthMatrix(): List<List<DrinkingSessionModel>> {
        val weekdaysSpread: MutableList<MutableList<DrinkingSessionModel>> =
            MutableList(7) { mutableListOf() }

        for (session in this.dates) {
            val weekdayString = session.date.getWeekday()
            val weekday = Weekdays.fromString(weekdayString)
            weekdaysSpread[weekday.ordinal].add(session)
        }

        return weekdaysSpread.toImmutableList().map { it.toImmutableList() }
    }

    fun changeLayoutForSundays(startFromSunday: Boolean) {
        monthMatrix = if (startFromSunday) {
            monthMatrix.toMutableList().apply { add(0, removeAt(6)) }.toImmutableList()
        } else {
            generateMonthMatrix()
        }
    }
}

@SuppressLint("NewApi")
fun getLastDay(year: Int, month: Month): LocalDate {
    val isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
    return LocalDate.of(year, month, month.length(isLeap))
}

@SuppressLint("NewApi")
fun getFirstDay(year: Int, month: Month): LocalDate =
    LocalDate.of(year, month, 1)

@SuppressLint("NewApi")
fun generateEmptySessions(year: Int, month: Month): List<DrinkingSessionModel> {
    val sessions = mutableListOf<DrinkingSessionModel>()
    val lastDay = getLastDay(year, month).dayOfMonth
    for (day in 1..lastDay) {
        sessions.add(DrinkingSessionModel(LocalDate.of(year, month, day)))
    }
    return sessions.toImmutableList()
}

@SuppressLint("NewApi")
fun Month.getMonthName(): String {
    return when (this) {
        Month.JANUARY -> "January"
        Month.FEBRUARY -> "February"
        Month.MARCH -> "March"
        Month.APRIL -> "April"
        Month.MAY -> "May"
        Month.JUNE -> "June"
        Month.JULY -> "July"
        Month.AUGUST -> "August"
        Month.SEPTEMBER -> "September"
        Month.OCTOBER -> "October"
        Month.NOVEMBER -> "November"
        Month.DECEMBER -> "December"
    }
}

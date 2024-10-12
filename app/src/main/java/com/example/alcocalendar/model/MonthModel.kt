package com.example.alcocalendar.model

import android.annotation.SuppressLint
import com.example.alcocalendar.ui.calendar.Weekdays
import com.example.alcocalendar.ui.calendar.month.getWeekday
import kotlinx.collections.immutable.toImmutableList
import java.time.LocalDate
import java.time.Month

data class MonthModel(
    val year: Int,
    val month: Month,
    val sessions: List<DrinkingSessionModel>,
) {
    @SuppressLint("NewApi")
    constructor(year: Int, month: Month) : this(
        year = year,
        month = month,
        sessions = generateEmptySessions(year, month),
    )

    var monthMatrix: List<List<DrinkingSessionModel>> = generateMonthMatrix()
        private set

    fun getDay(date: Int): DrinkingSessionModel {
        return sessions[date - 1]
    }

    // Gets a matrix like [Column number = Weekday number] with Empty Drinking Sessions
    @SuppressLint("NewApi")
    private fun generateMonthMatrix(): List<List<DrinkingSessionModel>> {
        val weekdaysSpread: MutableList<MutableList<DrinkingSessionModel>> =
            MutableList(7) { mutableListOf() }

        for (session in this.sessions) {
            val weekdayString = session.date.getWeekday()
            val weekday = Weekdays.fromString(weekdayString)
            weekdaysSpread[weekday.ordinal].add(session)
        }

        return weekdaysSpread.toImmutableList().map { it.toImmutableList() }
    }


}

@SuppressLint("NewApi")
private fun getLastDayOfMonth(year: Int, month: Month): LocalDate {
    val isLeapYear = year.isLeapYear()
    return LocalDate.of(year, month, month.length(isLeapYear))
}

private fun Int.isLeapYear(): Boolean {
    return (this % 4 == 0 && this % 100 != 0) || (this % 400 == 0)
}

@SuppressLint("NewApi")
private fun generateEmptySessions(year: Int, month: Month): List<DrinkingSessionModel> {
    val lastDayOfMonth = getLastDayOfMonth(year, month).dayOfMonth
    return (1..lastDayOfMonth).map { day ->
        DrinkingSessionModel(LocalDate.of(year, month, day))
    }.toImmutableList()
}

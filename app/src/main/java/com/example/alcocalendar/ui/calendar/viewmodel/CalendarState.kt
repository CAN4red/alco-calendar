package com.example.alcocalendar.ui.calendar.viewmodel

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import com.example.alcocalendar.model.DrinkingSessionWrapper
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.model.YearModel
import com.example.alcocalendar.ui.navigation.CalendarView
import kotlinx.collections.immutable.ImmutableMap
import java.time.LocalDate
import java.time.Month


@SuppressLint("NewApi")
data class CalendarState(
    val calendarMap: ImmutableMap<Int, YearModel>,
    val currentView: CalendarView,
    val startFromSunday: Boolean,
    val currentMonthIndex: Int = getInitialMonthIndex(),
    val currentYearIndex: Int = getInitialYearIndex(),
    val updateToggle: Boolean = true,
    private val statistics: DrinkStatistics = DrinkStatistics()
) {
    val yearsCount get() = calendarMap.size
    val monthsCount get() = yearsCount * MONTHS_NUMBER

    fun getMonthByIndex(index: Int): MonthModel {
        val year = index / MONTHS_NUMBER + FIRST_YEAR
        val month = Month.of(index % MONTHS_NUMBER + 1)
        return calendarMap[year]?.getMonthModel(month) ?: MonthModel(year, month)
    }

    fun getYearByIndex(index: Int): YearModel {
        val year = index + FIRST_YEAR
        return calendarMap[year] ?: YearModel(year)
    }

    fun updateSession(session: DrinkingSessionWrapper) {
        val date = session.date
        calendarMap[date.year]
            ?.getMonthModel(date.month)
            ?.updateDrinkingSession(session)
        statistics.updatePopulation(session.alcoUnits)
    }

    fun deleteSession(session: DrinkingSessionWrapper) {
        val emptySession = DrinkingSessionWrapper(DrinkingSessionDb(session.date))
        this.updateSession(emptySession)
        statistics.deleteFromPopulation(session.alcoUnits)
    }

    fun getSessionColor(alcoUnits: Double, isSystemInDarkTheme: Boolean): Color {
        return statistics.getSessionColor(alcoUnits, isSystemInDarkTheme)
    }

    val hasNextMonth: Boolean
        get() = hasNextYear || getMonthByIndex(currentMonthIndex).month != Month.DECEMBER

    val hasPrevMonth: Boolean
        get() = hasPrevYear || getMonthByIndex(currentMonthIndex).month != Month.JANUARY

    val hasNextYear: Boolean
        get() = getYearByIndex(currentYearIndex).year != LAST_YEAR

    val hasPrevYear: Boolean
        get() = getYearByIndex(currentYearIndex).year != FIRST_YEAR


    companion object {
        const val FIRST_YEAR: Int = 2000
        const val LAST_YEAR: Int = 2200
        const val MONTHS_NUMBER: Int = 12

        private fun getInitialMonthIndex(): Int =
            IndexConverter.getMonthIndex(
                LocalDate.now().year,
                LocalDate.now().month
            )

        private fun getInitialYearIndex(): Int =
            IndexConverter.getYearIndex(
                LocalDate.now().year
            )
    }
}


object IndexConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthIndex(year: Int, month: Month): Int =
        (year - CalendarState.FIRST_YEAR) * CalendarState.MONTHS_NUMBER + month.value - 1

    fun getYearIndex(year: Int): Int = year - CalendarState.FIRST_YEAR
}
package com.example.alcocalendar.viewmodel

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.model.YearModel
import kotlinx.collections.immutable.ImmutableMap
import java.time.LocalDate
import java.time.Month

@SuppressLint("NewApi")
data class CalendarState(
    val calendarMap: ImmutableMap<Int, YearModel>,
    val currentMonthIndex: Int = IndexConverter.getMonthIndex(
        LocalDate.now().year,
        LocalDate.now().month
    ),
    val currentYearIndex: Int = IndexConverter.getYearIndex(
        LocalDate.now().year
    ),
) {
    val yearsCount = calendarMap.size
    val monthsCount = yearsCount * MONTHS_NUMBER

    fun getMonthByIndex(index: Int): MonthModel {
        val year = index / MONTHS_NUMBER + FIRST_YEAR
        val month = Month.of(index % MONTHS_NUMBER + 1)
        return calendarMap[year]?.getMonthModel(month) ?: MonthModel(year, month)
    }

    fun getYearByIndex(index: Int): YearModel {
        val year = index + FIRST_YEAR
        return calendarMap[year] ?: YearModel(year)
    }

    fun hasNextMonth(): Boolean {
        return hasNextYear() || getMonthByIndex(currentMonthIndex).month != Month.DECEMBER
    }

    fun hasPrevMonth(): Boolean {
        return hasPrevYear() || getMonthByIndex(currentMonthIndex).month != Month.JANUARY
    }

    fun hasNextYear(): Boolean {
        return getYearByIndex(currentYearIndex).year != LAST_YEAR
    }

    fun hasPrevYear(): Boolean {
        return getYearByIndex(currentYearIndex).year != FIRST_YEAR
    }

    companion object {
        const val FIRST_YEAR: Int = 2000
        const val LAST_YEAR: Int = 2200
        const val MONTHS_NUMBER: Int = 12
    }
}

object IndexConverter {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthIndex(year: Int, month: Month): Int {
        return (year - CalendarState.FIRST_YEAR) * CalendarState.MONTHS_NUMBER + month.value - 1
    }

    fun getYearIndex(year: Int): Int {
        return year - CalendarState.FIRST_YEAR
    }
}
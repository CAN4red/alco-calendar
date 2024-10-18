package com.example.alcocalendar.model

import android.annotation.SuppressLint
import com.example.alcocalendar.db.entities.DrinkingSessionModel
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

    fun getDay(date: Int): DrinkingSessionModel {
        return sessions[date - 1]
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

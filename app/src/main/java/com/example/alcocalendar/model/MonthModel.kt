package com.example.alcocalendar.model

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import java.time.LocalDate
import java.time.Month


data class MonthModel(
    val year: Int,
    val month: Month,
    private val _sessions: MutableList<DrinkingSessionWrapper>,
) {
    @SuppressLint("NewApi")
    constructor(year: Int, month: Month) : this(
        year = year,
        month = month,
        _sessions = generateEmptySessions(year, month).toMutableList(),
    )

    val sessions: List<DrinkingSession>
        get() = _sessions.toList()

    fun getDrinkingSession(date: Int): DrinkingSession {
        return _sessions[date - 1]
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateDrinkingSession(session: DrinkingSessionWrapper) {
        _sessions[session.date.dayOfMonth - 1] = session
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
private fun generateEmptySessions(year: Int, month: Month): List<DrinkingSessionWrapper> {
    val lastDayOfMonth = getLastDayOfMonth(year, month).dayOfMonth
    return (1..lastDayOfMonth).map { day ->
        DrinkingSessionWrapper(
            drinkingSession = DrinkingSessionDb(LocalDate.of(year, month, day))
        )
    }
}

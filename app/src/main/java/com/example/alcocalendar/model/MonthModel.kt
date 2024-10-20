package com.example.alcocalendar.model

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.alcocalendar.db.entities.DrinkingSession
import kotlinx.collections.immutable.toImmutableList
import java.time.LocalDate
import java.time.Month


data class MonthModel(
    val year: Int,
    val month: Month,
    val sessions: MutableList<DrinkingSession>,
) {
    @SuppressLint("NewApi")
    constructor(year: Int, month: Month) : this(
        year = year,
        month = month,
        sessions = generateEmptySessions(year, month),
    )

    fun getDrinkingSession(date: Int): DrinkingSession {
        return sessions[date - 1]
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateDrinkingSession(session: DrinkingSession) {
        Log.d("SessionUpdate", "Days count before update: ${sessions.size}")
        sessions[session.date.dayOfMonth - 1] = session
        Log.d("SessionUpdate", "Days count after update: ${sessions.size}")
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
private fun generateEmptySessions(year: Int, month: Month): MutableList<DrinkingSession> {
    val lastDayOfMonth = getLastDayOfMonth(year, month).dayOfMonth
    return (1..lastDayOfMonth).map { day ->
        DrinkingSession(LocalDate.of(year, month, day))
    }.toMutableList()
}

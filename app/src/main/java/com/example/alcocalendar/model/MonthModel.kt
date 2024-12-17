package com.example.alcocalendar.model

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import java.time.DayOfWeek
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

    val sessions: List<DrinkingSessionWrapper>
        get() = _sessions.toList()

    private fun getDrinkingSession(date: Int): DrinkingSessionWrapper {
        return _sessions[date - 1]
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateDrinkingSession(session: DrinkingSessionWrapper) {
        _sessions[session.date.dayOfMonth - 1] = session
        updateSessionOrders(session)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun updateSessionOrders(session: DrinkingSessionWrapper) {
        updateSessionOrder(session)

        if (session.date.dayOfMonth > 1) {
            updateSessionOrder(getDrinkingSession(session.date.dayOfMonth - 1))
        }
        if (session.date.dayOfMonth < getLastDayOfMonth(this.year, this.month)) {
            updateSessionOrder(getDrinkingSession(session.date.dayOfMonth + 1))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun updateSessionOrder(session: DrinkingSessionWrapper?) {
        session?.let {
            _sessions[it.date.dayOfMonth - 1] = it.copy(
                sessionOrder = getSessionOrder(it)
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getSessionOrder(session: DrinkingSessionWrapper): SessionOrder {
        if (session.isEmpty) {
            return SessionOrder.EMPTY_SESSION
        }

        val dayOfMonth = session.date.dayOfMonth

        return when (dayOfMonth) {
            1 -> handleFirstDaySessionOrder(session)
            getLastDayOfMonth(this.year, this.month) -> handleLastDaySessionOrder(session)
            else -> handleRegularSession(session)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleFirstDaySessionOrder(session: DrinkingSessionWrapper): SessionOrder {
        val dayOfWeek = session.date.dayOfWeek
        val dayOfMonth = session.date.dayOfMonth
        val nextSession = getDrinkingSession(dayOfMonth + 1)

        return when (dayOfWeek == DayOfWeek.SUNDAY || nextSession.isEmpty) {
            true -> SessionOrder.SINGLE_SESSION
            false -> SessionOrder.FIRST_IN_ROW
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleLastDaySessionOrder(session: DrinkingSessionWrapper): SessionOrder {
        val dayOfWeek = session.date.dayOfWeek
        val dayOfMonth = session.date.dayOfMonth
        val previousSession = getDrinkingSession(dayOfMonth - 1)

        return when (dayOfWeek == DayOfWeek.MONDAY || previousSession.isEmpty) {
            true -> SessionOrder.SINGLE_SESSION
            false -> SessionOrder.LAST_IN_ROW
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleRegularSession(session: DrinkingSessionWrapper): SessionOrder {
        val dayOfWeek = session.date.dayOfWeek
        return when (dayOfWeek) {
            DayOfWeek.MONDAY -> handleMondaySessionOrder(session)
            DayOfWeek.SUNDAY -> handleSundaySessionOrder(session)
            else -> handleOtherSessionOrder(session)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleMondaySessionOrder(session: DrinkingSessionWrapper): SessionOrder {
        val dayOfMonth = session.date.dayOfMonth
        val nextSession = getDrinkingSession(dayOfMonth + 1)

        return when (nextSession.isEmpty) {
            true -> SessionOrder.SINGLE_SESSION
            false -> SessionOrder.FIRST_IN_ROW
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleSundaySessionOrder(session: DrinkingSessionWrapper): SessionOrder {
        val dayOfMonth = session.date.dayOfMonth
        val previousSession = getDrinkingSession(dayOfMonth - 1)

        return when (previousSession.isEmpty) {
            true -> SessionOrder.SINGLE_SESSION
            false -> SessionOrder.LAST_IN_ROW
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun handleOtherSessionOrder(session: DrinkingSessionWrapper): SessionOrder {
        val dayOfMonth = session.date.dayOfMonth
        val nextSession = getDrinkingSession(dayOfMonth + 1)
        val previousSession = getDrinkingSession(dayOfMonth - 1)

        return when {
            !previousSession.isEmpty && !nextSession.isEmpty -> SessionOrder.MIDDLE_IN_ROW
            !previousSession.isEmpty && nextSession.isEmpty -> SessionOrder.LAST_IN_ROW
            previousSession.isEmpty && !nextSession.isEmpty -> SessionOrder.FIRST_IN_ROW
            else -> SessionOrder.SINGLE_SESSION
        }
    }
}


@SuppressLint("NewApi")
private fun getLastDayOfMonth(year: Int, month: Month): Int {
    val isLeapYear = year.isLeapYear()
    return LocalDate.of(year, month, month.length(isLeapYear)).dayOfMonth
}


private fun Int.isLeapYear(): Boolean {
    return (this % 4 == 0 && this % 100 != 0) || (this % 400 == 0)
}


@SuppressLint("NewApi")
private fun generateEmptySessions(year: Int, month: Month): List<DrinkingSessionWrapper> {
    val lastDayOfMonth = getLastDayOfMonth(year, month)
    return (1..lastDayOfMonth).map { day ->
        DrinkingSessionWrapper(
            drinkingSession = DrinkingSessionDb(LocalDate.of(year, month, day))
        )
    }
}

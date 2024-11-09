package com.example.alcocalendar.ui.calendar.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.db.DrinkingSessionsDao
import com.example.alcocalendar.model.YearModel
import com.example.alcocalendar.ui.calendar.viewmodel.events.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.states.CalendarState
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.O)
class CalendarViewModel(
    private val dao: DrinkingSessionsDao
) : ViewModel() {
    private val calendarMap =
        (CalendarState.FIRST_YEAR..CalendarState.LAST_YEAR)
            .toList()
            .associateWith { year -> YearModel(year) }
            .toImmutableMap()

    private val _calendarState: MutableStateFlow<CalendarState> = MutableStateFlow(
        CalendarState(
            calendarMap = calendarMap,
            startFromSunday = false,
        )
    )
    val calendarState: StateFlow<CalendarState> get() = _calendarState

    init {
        viewModelScope.launch { loadInitialData() }
    }

    fun onCalendarEvent(event: CalendarEvent) {
        when (event) {
            is CalendarEvent.ChangeMonth -> {
                _calendarState.update { currentState ->
                    currentState.copy(
                        currentMonthIndex = event.monthIndex,
                    )
                }
            }

            is CalendarEvent.ChangeYear -> {
                _calendarState.update { currentState ->
                    currentState.copy(
                        currentYearIndex = event.yearIndex,
                    )
                }
            }

            is CalendarEvent.OnDateClick -> {

            }
        }
    }

    private suspend fun loadInitialData() {
        val initialSessions = dao.getDrinkingSessions()
        _calendarState.update { currentState ->
            initialSessions.forEach { session -> currentState.updateSession(session) }
            currentState.copy(updateToggle = !currentState.updateToggle)
        }
    }
}
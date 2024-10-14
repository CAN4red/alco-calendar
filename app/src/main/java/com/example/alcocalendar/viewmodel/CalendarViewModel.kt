package com.example.alcocalendar.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.alcocalendar.model.YearModel
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


@RequiresApi(Build.VERSION_CODES.O)
class CalendarViewModel() : ViewModel() {
    private val calendarMap =
        (CalendarState.FIRST_YEAR..CalendarState.LAST_YEAR)
            .toList()
            .associateWith { year -> YearModel(year) }
            .toImmutableMap()

    private val _state: MutableStateFlow<CalendarState> = MutableStateFlow(
        CalendarState(
            calendarMap = calendarMap,
            startFromSunday = false,
        )
    )
    val state: StateFlow<CalendarState> get() = _state

    fun onEvent(event: CalendarEvent) {
        when (event) {
            is CalendarEvent.ChangeMonth -> {
                _state.update { currentState ->
                    currentState.copy(
                        currentMonthIndex = event.monthIndex,
                    )
                }
            }

            is CalendarEvent.ChangeYear -> {
                _state.update { currentState ->
                    currentState.copy(
                        currentYearIndex = event.yearIndex,
                    )
                }
            }

            is CalendarEvent.OnDateClick -> {
                TODO("implement a logic of adding a new session or checking the current one")
            }
        }
    }
}
package com.example.alcocalendar.features.calendar.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.features.calendar.domain.use_case.load_sessions_with_intakes.GetSessionsWithIntakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.Month
import java.time.Year
import java.time.YearMonth
import javax.inject.Inject

@HiltViewModel
class SharedCalendarViewModel @Inject constructor(
    private val getSessionsWithIntakesUseCase: GetSessionsWithIntakesUseCase,
) : ViewModel() {

    private val _calendarState = MutableStateFlow(SharedCalendarState())
    val calendarState: StateFlow<SharedCalendarState> get() = _calendarState

    init {
        viewModelScope.launch {
            _calendarState.update { currentState ->
                currentState.copy(intakesData = getSessionsWithIntakesUseCase())
            }
        }
    }

    fun onEvent(event: CalendarEvent) {
        when (event) {
            is CalendarEvent.UpdateCurrentYearMonth -> {
                handleUpdateCurrentYearMonth(year = event.year, month = event.month)
            }
        }
    }

    private fun handleUpdateCurrentYearMonth(year: Int?, month: Month?) {
        val newYear = year ?: calendarState.value.currentYearMonth.year
        val newMonth = month ?: calendarState.value.currentYearMonth.month

        val newYearMonth = YearMonth.of(newYear, newMonth)
        _calendarState.update { currentState ->
            currentState.copy(currentYearMonth = newYearMonth)
        }
    }
}

fun YearMonth.asYear(): Year {
    return Year.of(this.year)
}
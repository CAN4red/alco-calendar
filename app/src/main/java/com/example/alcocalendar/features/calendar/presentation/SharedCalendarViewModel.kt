package com.example.alcocalendar.features.calendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.core.domain.model.DrinkingSession
import com.example.alcocalendar.features.calendar.domain.use_case.init_session.InitializeSessionUseCase
import com.example.alcocalendar.features.calendar.domain.use_case.load_sessions_with_intakes.GetSessionsWithIntakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Month
import java.time.YearMonth
import javax.inject.Inject

@HiltViewModel
class SharedCalendarViewModel @Inject constructor(
    private val getSessionsWithIntakesUseCase: GetSessionsWithIntakesUseCase,
    private val initializeSessionUseCase: InitializeSessionUseCase,
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

            is CalendarEvent.InitializeSession -> {
                handleInitializeSession(sessionDate = event.sessionDate)
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

    private fun handleInitializeSession(sessionDate: LocalDate) {
        if (_calendarState.value.intakesData[sessionDate] == null) {
            viewModelScope.launch {
                initializeSessionUseCase.invoke(DrinkingSession(sessionDate))
            }
        }
    }
}

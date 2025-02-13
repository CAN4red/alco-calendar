package com.example.alcocalendar.features.calendar.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.features.calendar.domain.use_case.load_sessions_with_intakes.GetSessionsWithIntakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val getSessionsWithIntakesUseCase: GetSessionsWithIntakesUseCase,
) : ViewModel() {

    private val _calendarDataState = MutableStateFlow(CalendarDataState())
    val calendarDataState: StateFlow<CalendarDataState> get() = _calendarDataState

    init {
        viewModelScope.launch {
            _calendarDataState.update { currentState ->
                currentState.copy(value = getSessionsWithIntakesUseCase())
            }
        }
    }
}
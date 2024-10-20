package com.example.alcocalendar.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.db.DrinkingSessionsDao
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.model.YearModel
import com.example.alcocalendar.viewmodel.events.CalendarEvent
import com.example.alcocalendar.viewmodel.events.SessionFillingEvent
import com.example.alcocalendar.viewmodel.states.CalendarState
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep
import java.time.LocalDate


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

    private val _fillingSessionState: MutableStateFlow<DrinkingSession> = MutableStateFlow(
        DrinkingSession(date = LocalDate.now())
    )
    val fillingSessionState: StateFlow<DrinkingSession> get() = _fillingSessionState

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
                TODO("implement a logic of adding a new session or checking the current one")
            }
        }
    }

    fun onSessionFillingEvent(event: SessionFillingEvent) {
        when (event) {
            is SessionFillingEvent.AddBeerDrink -> {
                _fillingSessionState.update { currentState ->
                    val updatedBeerIntake = currentState.beerIntake.update(event.beer)
                    currentState.copy(beerIntake = updatedBeerIntake)
                }
            }

            is SessionFillingEvent.AddWineDrink -> {
                _fillingSessionState.update { currentState ->
                    val updatedWineIntake = currentState.wineIntake.update(event.wine)
                    currentState.copy(wineIntake = updatedWineIntake)
                }
            }

            is SessionFillingEvent.AddSpiritsDrink -> {
                _fillingSessionState.update { currentState ->
                    val updatedSpiritsIntake = currentState.spiritsIntake.update(event.spirits)
                    currentState.copy(spiritsIntake = updatedSpiritsIntake)
                }
            }

            is SessionFillingEvent.AddOtherDrink -> {
                _fillingSessionState.update { currentState ->
                    val updatedOtherIntake = currentState.otherIntake.update(event.otherDrink)
                    currentState.copy(otherIntake = updatedOtherIntake)
                }
            }

            is SessionFillingEvent.ConfirmSession -> {
                TODO()
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
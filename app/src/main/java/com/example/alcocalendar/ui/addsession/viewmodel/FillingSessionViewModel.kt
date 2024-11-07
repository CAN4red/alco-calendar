package com.example.alcocalendar.ui.addsession.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.db.DrinkingSessionsDao
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.ui.calendar.viewmodel.events.SessionFillingEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class FillingSessionViewModel(
    private val dao: DrinkingSessionsDao,
): ViewModel() {
    private val _fillingSessionState: MutableStateFlow<DrinkingSession> = MutableStateFlow(
        DrinkingSession(date = LocalDate.now())
    )
    val fillingSessionState: StateFlow<DrinkingSession>
        get() = _fillingSessionState

    fun onSessionFillingEvent(event: SessionFillingEvent) {
        when (event) {
            is SessionFillingEvent.InitNewSession -> {
                _fillingSessionState.update {
                    DrinkingSession(date = event.date)
                }
                viewModelScope.launch {
                    loadNewSession(date = event.date)
                }
            }

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

            }

            is SessionFillingEvent.DismissSession -> {

            }
        }
    }

    private suspend fun loadNewSession(date: LocalDate) {
        val potentialState = dao.getDrinkingSession(date = date)
        potentialState?.let { newState ->
            _fillingSessionState.update { newState }
        }
    }
}
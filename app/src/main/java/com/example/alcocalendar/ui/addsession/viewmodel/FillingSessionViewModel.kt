package com.example.alcocalendar.ui.addsession.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.db.DrinkingSessionsDao
import com.example.alcocalendar.db.entities.DrinkingSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class FillingSessionViewModel(
    private val dao: DrinkingSessionsDao,
) : ViewModel() {
    private val _fillingSessionState: MutableStateFlow<DrinkingSession> = MutableStateFlow(
        DrinkingSession(date = LocalDate.now())
    )
    val fillingSessionState: StateFlow<DrinkingSession>
        get() = _fillingSessionState

    fun onSessionFillingEvent(event: FillingSessionEvent) {
        when (event) {
            is FillingSessionEvent.InitNewSession -> {
                _fillingSessionState.update {
                    DrinkingSession(date = event.date)
                }
                viewModelScope.launch {
                    loadNewSession(date = event.date)
                }
            }

            is FillingSessionEvent.AddBeerDrink -> {
                _fillingSessionState.update { currentState ->
                    val updatedBeerIntake = currentState.beerIntake.update(event.beer)
                    currentState.copy(beerIntake = updatedBeerIntake)
                }
            }

            is FillingSessionEvent.AddWineDrink -> {
                _fillingSessionState.update { currentState ->
                    val updatedWineIntake = currentState.wineIntake.update(event.wine)
                    currentState.copy(wineIntake = updatedWineIntake)
                }
            }

            is FillingSessionEvent.AddSpiritsDrink -> {
                _fillingSessionState.update { currentState ->
                    val updatedSpiritsIntake = currentState.spiritsIntake.update(event.spirits)
                    currentState.copy(spiritsIntake = updatedSpiritsIntake)
                }
            }

            is FillingSessionEvent.AddOtherDrink -> {
                _fillingSessionState.update { currentState ->
                    val updatedOtherIntake = currentState.otherIntake.update(event.otherDrink)
                    currentState.copy(otherIntake = updatedOtherIntake)
                }
            }

            is FillingSessionEvent.ConfirmSession -> {
                viewModelScope.launch {
                    dao.insertDrinkingSession(_fillingSessionState.value)
                }
            }

            is FillingSessionEvent.CancelSession -> {

            }

            is FillingSessionEvent.DeleteSession -> {
                viewModelScope.launch {
                    dao.deleteDrinkingSession(_fillingSessionState.value)
                }
                _fillingSessionState.update { currentState ->
                    DrinkingSession(date = currentState.date)
                }
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
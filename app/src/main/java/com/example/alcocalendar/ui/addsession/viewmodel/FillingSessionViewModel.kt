package com.example.alcocalendar.ui.addsession.viewmodel

import android.os.Build
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
            is FillingSessionEvent.InitNewSession -> handleInitNewSession(event)
            is FillingSessionEvent.AddBeerDrink -> handleAddBeerDrink(event)
            is FillingSessionEvent.AddWineDrink -> handleAddWineDrink(event)
            is FillingSessionEvent.AddSpiritsDrink -> handleAddSpiritsDrink(event)
            is FillingSessionEvent.AddOtherDrink -> handleAddOtherDrink(event)
            is FillingSessionEvent.ConfirmSession -> handleConfirmSession()
            is FillingSessionEvent.CancelSession -> handleCancelSession()
            is FillingSessionEvent.DeleteSession -> handleDeleteSession()
        }
    }

    private fun handleInitNewSession(event: FillingSessionEvent.InitNewSession) {
        _fillingSessionState.update {
            DrinkingSession(date = event.date)
        }
        viewModelScope.launch {
            loadNewSession(date = event.date)
        }
    }

    private fun handleAddBeerDrink(event: FillingSessionEvent.AddBeerDrink) {
        _fillingSessionState.update { currentState ->
            val updatedBeerIntake = currentState.beerIntake.update(event.beer)
            currentState.copy(beerIntake = updatedBeerIntake)
        }
    }

    private fun handleAddWineDrink(event: FillingSessionEvent.AddWineDrink) {
        _fillingSessionState.update { currentState ->
            val updatedWineIntake = currentState.wineIntake.update(event.wine)
            currentState.copy(wineIntake = updatedWineIntake)
        }
    }

    private fun handleAddSpiritsDrink(event: FillingSessionEvent.AddSpiritsDrink) {
        _fillingSessionState.update { currentState ->
            val updatedSpiritsIntake = currentState.spiritsIntake.update(event.spirits)
            currentState.copy(spiritsIntake = updatedSpiritsIntake)
        }
    }

    private fun handleAddOtherDrink(event: FillingSessionEvent.AddOtherDrink) {
        _fillingSessionState.update { currentState ->
            val updatedOtherIntake = currentState.otherIntake.update(event.otherDrink)
            currentState.copy(otherIntake = updatedOtherIntake)
        }
    }

    private fun handleConfirmSession() {
        viewModelScope.launch {
            dao.insertDrinkingSession(_fillingSessionState.value)
        }
    }

    private fun handleCancelSession() {
        // Логика для отмены сессии, если требуется
    }

    private fun handleDeleteSession() {
        viewModelScope.launch {
            dao.deleteDrinkingSession(_fillingSessionState.value)
        }
        _fillingSessionState.update { currentState ->
            DrinkingSession(date = currentState.date)
        }
    }

    private suspend fun loadNewSession(date: LocalDate) {
        val potentialState = dao.getDrinkingSession(date = date)
        potentialState?.let { newState ->
            _fillingSessionState.update { newState }
        }
    }
}

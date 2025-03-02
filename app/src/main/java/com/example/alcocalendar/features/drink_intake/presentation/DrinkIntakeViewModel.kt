package com.example.alcocalendar.features.drink_intake.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.core.navigation.NavArgs
import com.example.alcocalendar.features.drink_intake.domain.use_case.DrinkIntakeUseCases
import com.example.alcocalendar.features.drink_intake.presentation.utils.StringToDateMapper.toDay
import com.example.alcocalendar.features.drink_intake.presentation.utils.StringToDateMapper.toMonth
import com.example.alcocalendar.features.drink_intake.presentation.utils.StringToDateMapper.toYear
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DrinkIntakeViewModel @Inject constructor(
    private val drinkIntakeUseCases: DrinkIntakeUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(DrinkIntakeState())
    val state: StateFlow<DrinkIntakeState> get() = _state

    private val prevFillingIntake = MutableStateFlow<DrinkIntake?>(null)

    init {
        val year = savedStateHandle.get<String>(NavArgs.YEAR).toYear()
        val month = savedStateHandle.get<String>(NavArgs.MONTH).toMonth()
        val day = savedStateHandle.get<String>(NavArgs.DAY).toDay()

        val date = LocalDate.of(year, month, day)

        loadData(date)
    }

    private fun loadData(date: LocalDate) {
        val intakesFlow = drinkIntakeUseCases.getDrinkIntakesUseCase(date)
        viewModelScope.launch {
            intakesFlow.collect { intakes ->
                _state.update { currentState ->
                    currentState.copy(date = date, intakes = intakes)
                }
            }
        }
    }

    fun onEvent(event: DrinkIntakeEvent) {
        when (event) {
            is DrinkIntakeEvent.SetFillingDrinkIntake -> {
                handleSetFillingDrinkIntake(event.drinkType, event.alcoStrength, event.liters)
            }

            is DrinkIntakeEvent.SetFillingDrinkIntakeAlcoStrength -> {
                handleSetFillingDrinkIntakeAlcoStrength(event.alcoStrength)
            }

            is DrinkIntakeEvent.SetFillingDrinkIntakeLiters -> {
                handleSetFillingDrinkIntakeLiters(event.liters)
            }

            is DrinkIntakeEvent.DropFillingDrinkIntake -> {
                handleDropFillingDrinkIntake()
            }

            is DrinkIntakeEvent.InsertUpdateDrinkIntake -> {
                handleInsertUpdateDrinkIntake()
            }

            is DrinkIntakeEvent.DeleteDrinkIntake -> {
                handleDeleteDrinkIntake()
            }

            is DrinkIntakeEvent.SetExpandedIntake -> {
                handleSetExpandedIntake(event.drinkType)
            }
        }
    }

    private fun handleSetFillingDrinkIntake(
        drinkType: DrinkType,
        alcoStrength: Double,
        liters: Double
    ) {
        val fillingIntake = DrinkIntake(
            date = _state.value.date,
            drinkType = drinkType,
            alcoStrength = alcoStrength,
            liters = liters
        )
        _state.update { currentState ->
            currentState.copy(
                fillingIntake = fillingIntake
            )
        }
        setPrevFillingIntake(drinkType, alcoStrength)
    }

    private fun handleSetFillingDrinkIntakeAlcoStrength(alcoStrength: Double) {
        _state.value.fillingIntake?.let { fillingIntake ->
            val updatedFillingIntake = fillingIntake.copy(alcoStrength = alcoStrength)

            _state.update { currentState ->
                currentState.copy(fillingIntake = updatedFillingIntake)
            }
        }
    }

    private fun handleSetFillingDrinkIntakeLiters(liters: Double) {
        _state.value.fillingIntake?.let { fillingIntake ->
            val updatedFillingIntake = fillingIntake.copy(liters = liters)

            _state.update { currentState ->
                currentState.copy(fillingIntake = updatedFillingIntake)
            }
        }
    }

    private fun handleDropFillingDrinkIntake() {
        _state.update { currentState ->
            currentState.copy(fillingIntake = null)
        }
        prevFillingIntake.update { null }
    }

    private fun handleInsertUpdateDrinkIntake() {
        val intake = _state.value.fillingIntake
        intake?.let {
            viewModelScope.launch {
                when {
                    (prevFillingIntake.value == null) -> {
                        drinkIntakeUseCases.insertDrinkIntakeUseCase(intake)
                    }

                    (prevFillingIntake.value!!
                        .isFittingWith(intake.drinkType, intake.alcoStrength)) -> {
                        drinkIntakeUseCases.updateDrinkIntakeUseCase(intake)
                    }

                    else -> {
                        drinkIntakeUseCases.deleteDrinkIntakeUseCase(prevFillingIntake.value!!)
                        drinkIntakeUseCases.insertDrinkIntakeUseCase(intake)
                    }
                }
                loadData(date = _state.value.date)
            }
        }
    }

    private fun handleDeleteDrinkIntake() {
        val drinkIntake = _state.value.fillingIntake
        drinkIntake?.let {
            viewModelScope.launch {
                drinkIntakeUseCases.deleteDrinkIntakeUseCase(drinkIntake)
            }
        }
        loadData(date = _state.value.date)
    }

    private fun handleSetExpandedIntake(drinkType: Class<out DrinkType>?) {
        _state.update { currentState ->
            currentState.copy(expandedDrinkType = drinkType)
        }
    }

    private fun setPrevFillingIntake(drinkType: DrinkType, alcoStrength: Double) {
        val fittingIntakes = _state.value.intakes
            .filter { it.isFittingWith(drinkType, alcoStrength) }

        prevFillingIntake.update {
            if (fittingIntakes.isEmpty()) null else fittingIntakes.first()
        }
    }

    private fun DrinkIntake.isFittingWith(
        otherDrinkType: DrinkType,
        otherAlcoStrength: Double
    ): Boolean {
        return this.drinkType == otherDrinkType && this.alcoStrength == otherAlcoStrength
    }
}

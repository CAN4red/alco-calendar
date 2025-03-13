package com.example.alcocalendar.features.session_manage.drink_intake.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcocalendar.core.domain.model.DrinkIntake
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.session_manage.SessionManageUtils.getDate
import com.example.alcocalendar.features.session_manage.drink_intake.domain.use_case.DrinkIntakeUseCases
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.state.DrinkIntakeState
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.state.FillingIntakeState
import com.example.alcocalendar.features.session_manage.drink_intake.presentation.state.FillingType
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
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(DrinkIntakeState())
    val state: StateFlow<DrinkIntakeState> get() = _state

    init {
        loadData(savedStateHandle.getDate())
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
                handleSetFillingDrinkIntake(
                    event.drinkType,
                    event.alcoStrength,
                    event.liters,
                    event.fillingType
                )
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

            is DrinkIntakeEvent.SetExpandedIntakeType -> {
                handleSetExpandedIntakeType(event.drinkType)
            }
        }
    }

    private fun handleSetFillingDrinkIntake(
        drinkType: DrinkType,
        alcoStrength: Double,
        liters: Double,
        fillingType: FillingType,
    ) {
        val fillingIntake = DrinkIntake(
            date = _state.value.date,
            drinkType = drinkType,
            alcoStrength = alcoStrength,
            liters = liters
        )
        _state.update { currentState ->
            currentState.copy(
                fillingIntake = FillingIntakeState(
                    intake = fillingIntake,
                    initialIntake = getInitFillingIntake(drinkType, alcoStrength),
                    fillingType = fillingType
                )
            )
        }

    }

    private fun handleSetFillingDrinkIntakeAlcoStrength(alcoStrength: Double) {
        _state.value.fillingIntake?.intake?.let { fillingIntake ->
            val updatedIntake = fillingIntake.copy(alcoStrength = alcoStrength)
            val updatedFillingIntake = _state.value.fillingIntake!!.copy(intake = updatedIntake)

            _state.update { currentState ->
                currentState.copy(fillingIntake = updatedFillingIntake)
            }
        }
    }

    private fun handleSetFillingDrinkIntakeLiters(liters: Double) {
        _state.value.fillingIntake?.intake?.let { fillingIntake ->
            val updatedIntake = fillingIntake.copy(liters = liters)
            val updatedFillingIntake = _state.value.fillingIntake!!.copy(intake = updatedIntake)

            _state.update { currentState ->
                currentState.copy(fillingIntake = updatedFillingIntake)
            }
        }
    }

    private fun handleDropFillingDrinkIntake() {
        _state.update { currentState ->
            currentState.copy(fillingIntake = null)
        }
    }

    private fun handleInsertUpdateDrinkIntake() {
        val intake = _state.value.fillingIntake
        intake?.let { fillingIntake ->
            viewModelScope.launch {
                when {
                    (fillingIntake.initialIntake != null && fillingIntake.isFittingWithInitial) -> {
                        drinkIntakeUseCases.updateDrinkIntakeUseCase(fillingIntake.intake)
                    }

                    else -> {
                        if (fillingIntake.fillingType == FillingType.UPDATING) {
                            drinkIntakeUseCases.deleteDrinkIntakeUseCase(fillingIntake.initialIntake!!)
                        }
                        drinkIntakeUseCases.insertDrinkIntakeUseCase(fillingIntake.intake)
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
                drinkIntakeUseCases.deleteDrinkIntakeUseCase(drinkIntake.intake)
            }
        }
        loadData(date = _state.value.date)
    }

    private fun handleSetExpandedIntakeType(drinkType: Class<out DrinkType>?) {
        _state.update { currentState ->
            currentState.copy(expandedDrinkType = drinkType)
        }
    }

    private fun getInitFillingIntake(drinkType: DrinkType, alcoStrength: Double): DrinkIntake? {
        val fittingIntakes = _state.value.intakes
            .filter { it.isFittingWith(drinkType, alcoStrength) }

        return if (fittingIntakes.isEmpty()) null else fittingIntakes.first()
    }

    private fun DrinkIntake.isFittingWith(
        otherDrinkType: DrinkType,
        otherAlcoStrength: Double
    ): Boolean {
        return this.drinkType == otherDrinkType && this.alcoStrength == otherAlcoStrength
    }
}

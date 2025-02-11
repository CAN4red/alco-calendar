package com.example.alcocalendar.core.domain.use_case.get_sessions_with_intakes

import com.example.alcocalendar.core.domain.repository.SharedDrinkIntakeRepository
import com.example.alcocalendar.features.drink_intake.data.local.entities.relations.DrinkingSessionWithDrinkIntakes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDrinkingSessionsWithDrinkIntakesUseCase @Inject constructor(
    private val sharedRepository: SharedDrinkIntakeRepository
) {
    operator fun invoke(): Flow<List<DrinkingSessionWithDrinkIntakes>> = flow {
        emit(sharedRepository.getDrinkingSessionsWithDrinkIntakes())
    }
}
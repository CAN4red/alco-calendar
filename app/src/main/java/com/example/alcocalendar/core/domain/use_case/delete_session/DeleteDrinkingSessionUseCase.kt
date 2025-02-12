package com.example.alcocalendar.core.domain.use_case.delete_session

import com.example.alcocalendar.core.domain.model.DrinkingSession
import com.example.alcocalendar.core.domain.repository.DrinkingSessionRepository
import javax.inject.Inject

class DeleteDrinkingSessionUseCase @Inject constructor(
    private val drinkingSessionRepository: DrinkingSessionRepository
) {
    suspend operator fun invoke(session: DrinkingSession) {
        drinkingSessionRepository.insertDrinkingSession(session)
    }
}
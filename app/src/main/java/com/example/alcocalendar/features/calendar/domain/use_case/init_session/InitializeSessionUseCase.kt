package com.example.alcocalendar.features.calendar.domain.use_case.init_session

import com.example.alcocalendar.core.domain.model.DrinkingSession
import com.example.alcocalendar.features.calendar.domain.repository.CalendarRepository
import javax.inject.Inject

class InitializeSessionUseCase @Inject constructor(
    private val repository: CalendarRepository
) {
    suspend operator fun invoke(drinkingSession: DrinkingSession) {
        val existingSession = repository.getDrinkingSession(drinkingSession.date)
        if (existingSession == null) {
            repository.insertDrinkingSession(drinkingSession)
        }
    }
}
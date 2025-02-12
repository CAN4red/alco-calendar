package com.example.alcocalendar.core.domain.repository

import com.example.alcocalendar.core.domain.model.DrinkingSession
import java.time.LocalDate

interface DrinkingSessionRepository {

    suspend fun insertDrinkingSession(drinkingSession: DrinkingSession)

    suspend fun deleteDrinkingSession(date: LocalDate)
}
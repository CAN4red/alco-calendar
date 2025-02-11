package com.example.alcocalendar.core.domain.repository

import com.example.alcocalendar.core.data.local.entities.DrinkingSession
import java.time.LocalDate

interface DrinkingSessionRepository {

    suspend fun insertDrinkingSession(drinkingSession: DrinkingSession)

    suspend fun deleteDrinkingSession(date: LocalDate)
}
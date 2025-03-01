package com.example.alcocalendar.features.calendar.domain.repository

import com.example.alcocalendar.core.domain.model.DrinkingSession
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import java.time.LocalDate

interface CalendarRepository {

    suspend fun getSessionsWithIntakes(): Map<LocalDate, CalendarSessionWithIntakes>

    suspend fun insertDrinkingSession(drinkingSession: DrinkingSession)
}
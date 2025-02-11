package com.example.alcocalendar.core.data.local.repository

import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.core.data.local.entities.DrinkingSession
import com.example.alcocalendar.core.domain.repository.DrinkingSessionRepository
import java.time.LocalDate
import javax.inject.Inject

class DrinkingSessionRepositoryImpl @Inject constructor(
    private val drinkingSessionDao: DrinkingSessionDao
) : DrinkingSessionRepository {
    override suspend fun insertDrinkingSession(drinkingSession: DrinkingSession) {
        drinkingSessionDao.insertDrinkingSession(drinkingSession)
    }

    override suspend fun deleteDrinkingSession(date: LocalDate) {
        drinkingSessionDao.deleteDrinkingSessionByDate(date)
    }
}

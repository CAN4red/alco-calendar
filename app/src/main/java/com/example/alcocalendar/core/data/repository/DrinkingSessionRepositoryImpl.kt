package com.example.alcocalendar.core.data.repository

import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.core.data.mappers.DrinkingSessionMapper
import com.example.alcocalendar.core.domain.model.DrinkingSession
import com.example.alcocalendar.core.domain.repository.DrinkingSessionRepository
import java.time.LocalDate
import javax.inject.Inject

class DrinkingSessionRepositoryImpl @Inject constructor(
    private val drinkingSessionDao: DrinkingSessionDao
) : DrinkingSessionRepository {
    override suspend fun insertDrinkingSession(drinkingSession: DrinkingSession) {
        drinkingSessionDao.insertDrinkingSession(DrinkingSessionMapper.toData(drinkingSession))
    }

    override suspend fun deleteDrinkingSession(date: LocalDate) {
        drinkingSessionDao.deleteDrinkingSessionByDate(date)
    }
}

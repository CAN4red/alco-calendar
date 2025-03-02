package com.example.alcocalendar.features.calendar.data.repository

import com.example.alcocalendar.core.data.local.dao.DrinkingSessionDao
import com.example.alcocalendar.core.data.mappers.DrinkingSessionMapper
import com.example.alcocalendar.core.domain.model.DrinkingSession
import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import com.example.alcocalendar.features.calendar.data.mappers.CalendarSessionWithIntakesMapper
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.example.alcocalendar.features.calendar.domain.repository.CalendarRepository
import java.time.LocalDate
import javax.inject.Inject

class CalendarRepositoryImpl @Inject constructor(
    private val calendarDao: CalendarDao,
    private val sessionDao: DrinkingSessionDao,
) : CalendarRepository {

    override suspend fun getSessionsWithIntakes(): Map<LocalDate, CalendarSessionWithIntakes> {
        return calendarDao.getDrinkingSessionsWithDrinkIntakes().associate { session ->
            session.drinkingSession.date to CalendarSessionWithIntakesMapper.toDomain(session)
        }
    }

    override suspend fun insertDrinkingSession(drinkingSession: DrinkingSession) {
        sessionDao.insertDrinkingSession(DrinkingSessionMapper.toData(drinkingSession))
    }

    override suspend fun getDrinkingSession(date: LocalDate): DrinkingSession? {
        return DrinkingSessionMapper.toDomain(sessionDao.getDrinkingSession(date))
    }
}
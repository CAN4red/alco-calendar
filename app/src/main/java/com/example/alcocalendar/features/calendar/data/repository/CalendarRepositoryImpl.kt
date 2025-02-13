package com.example.alcocalendar.features.calendar.data.repository

import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import com.example.alcocalendar.features.calendar.data.mappers.CalendarSessionWithIntakesMapper
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.example.alcocalendar.features.calendar.domain.repository.CalendarRepository
import java.time.LocalDate
import javax.inject.Inject

class CalendarRepositoryImpl @Inject constructor(
    private val dao: CalendarDao,
) : CalendarRepository {

    override suspend fun getSessionsWithIntakes(): Map<LocalDate, CalendarSessionWithIntakes> {
        return dao.getDrinkingSessionsWithDrinkIntakes().associate { session ->
            session.drinkingSession.date to CalendarSessionWithIntakesMapper.toDomain(session)
        }
    }
}
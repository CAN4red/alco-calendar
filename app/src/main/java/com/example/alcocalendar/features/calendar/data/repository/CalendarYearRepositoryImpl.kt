package com.example.alcocalendar.features.calendar.data.repository

import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import com.example.alcocalendar.features.calendar.data.mappers.CalendarYearMapper
import com.example.alcocalendar.features.calendar.domain.model.CalendarYear
import com.example.alcocalendar.features.calendar.domain.repository.CalendarYearRepository
import java.time.Year
import javax.inject.Inject

class CalendarYearRepositoryImpl @Inject constructor(
    private val calendarDao: CalendarDao
) : CalendarYearRepository {

    override suspend fun getCalendarYear(year: Year): CalendarYear {
        val sessionsWithIntakes = calendarDao.getDrinkingSessionsWithDrinkIntakesByYear(year)
        return CalendarYearMapper.toDomain(sessionsWithIntakes)
    }
}
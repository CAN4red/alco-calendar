package com.example.alcocalendar.features.calendar.data.repository

import com.example.alcocalendar.features.calendar.data.local.dao.CalendarDao
import com.example.alcocalendar.features.calendar.data.mappers.CalendarMonthMapper
import com.example.alcocalendar.features.calendar.domain.model.CalendarMonth
import com.example.alcocalendar.features.calendar.domain.repository.CalendarMonthRepository
import java.time.YearMonth
import javax.inject.Inject

class CalendarMonthRepositoryImpl @Inject constructor(
    private val calendarDao: CalendarDao
) : CalendarMonthRepository {

    override suspend fun getCalendarMonth(yearMonth: YearMonth): CalendarMonth {
        val sessionsWithIntakes = calendarDao.getDrinkingSessionsWithDrinkIntakesByMonth(yearMonth)
        return CalendarMonthMapper.toDomain(sessionsWithIntakes)
    }
}
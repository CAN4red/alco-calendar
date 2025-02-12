package com.example.alcocalendar.features.calendar.domain.repository

import com.example.alcocalendar.features.calendar.domain.model.CalendarYear
import java.time.Year

interface CalendarYearRepository {

    suspend fun getCalendarYear(year: Year): CalendarYear
}
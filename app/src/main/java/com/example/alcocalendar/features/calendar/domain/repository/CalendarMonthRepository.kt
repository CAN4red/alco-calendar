package com.example.alcocalendar.features.calendar.domain.repository

import com.example.alcocalendar.features.calendar.domain.model.CalendarMonth
import java.time.YearMonth

interface CalendarMonthRepository {

    suspend fun getCalendarMonth(yearMonth: YearMonth): CalendarMonth
}
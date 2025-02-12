package com.example.alcocalendar.features.calendar.domain.use_case.get_calendar_year

import com.example.alcocalendar.features.calendar.domain.model.CalendarYear
import com.example.alcocalendar.features.calendar.domain.repository.CalendarYearRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.Year
import javax.inject.Inject

class GetCalendarYearUseCase @Inject constructor(
    private val calendarYearRepository: CalendarYearRepository
) {
    operator fun invoke(year: Year): Flow<CalendarYear> = flow {
        emit(calendarYearRepository.getCalendarYear(year))
    }
}
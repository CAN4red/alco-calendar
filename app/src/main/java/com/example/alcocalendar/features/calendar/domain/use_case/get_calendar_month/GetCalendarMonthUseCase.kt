package com.example.alcocalendar.features.calendar.domain.use_case.get_calendar_month

import com.example.alcocalendar.features.calendar.domain.model.CalendarMonth
import com.example.alcocalendar.features.calendar.domain.repository.CalendarMonthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.YearMonth
import javax.inject.Inject

class GetCalendarMonthUseCase @Inject constructor(
    private val calendarMonthRepository: CalendarMonthRepository
) {
    operator fun invoke(yearMonth: YearMonth): Flow<CalendarMonth> = flow {
        emit(calendarMonthRepository.getCalendarMonth(yearMonth))
    }
}
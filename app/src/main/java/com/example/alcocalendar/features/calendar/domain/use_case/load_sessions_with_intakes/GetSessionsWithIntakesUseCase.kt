package com.example.alcocalendar.features.calendar.domain.use_case.load_sessions_with_intakes

import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.example.alcocalendar.features.calendar.domain.repository.CalendarRepository
import java.time.LocalDate
import javax.inject.Inject

class GetSessionsWithIntakesUseCase @Inject constructor(
    private val repository: CalendarRepository
) {
    suspend operator fun invoke(): Map<LocalDate, CalendarSessionWithIntakes> {
        return repository.getSessionsWithIntakes()
    }
}
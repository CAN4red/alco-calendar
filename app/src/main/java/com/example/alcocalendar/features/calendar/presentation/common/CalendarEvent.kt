package com.example.alcocalendar.features.calendar.presentation.common

import java.time.Month

sealed interface CalendarEvent {
    data class UpdateCurrentYearMonth(
        val year: Int? = null, val month: Month? = null
    ) : CalendarEvent
}
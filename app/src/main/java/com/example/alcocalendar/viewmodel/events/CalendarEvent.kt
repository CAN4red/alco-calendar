package com.example.alcocalendar.viewmodel.events

import java.time.LocalDate

sealed interface CalendarEvent {
    data class OnDateClick(val date: LocalDate) : CalendarEvent
    data class ChangeMonth(val monthIndex: Int) : CalendarEvent
    data class ChangeYear(val yearIndex: Int) : CalendarEvent
}

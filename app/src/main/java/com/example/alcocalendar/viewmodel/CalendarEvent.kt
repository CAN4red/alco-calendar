package com.example.alcocalendar.viewmodel

sealed interface CalendarEvent {
    data object OnDateClick : CalendarEvent
    data class ChangeMonth(val monthIndex: Int) : CalendarEvent
    data class ChangeYear(val yearIndex: Int) : CalendarEvent
}

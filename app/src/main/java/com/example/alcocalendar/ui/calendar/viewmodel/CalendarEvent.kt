package com.example.alcocalendar.ui.calendar.viewmodel

import com.example.alcocalendar.model.DrinkingSessionWrapper
import com.example.alcocalendar.ui.navigation.CalendarView

sealed interface CalendarEvent {
    data class ChangeMonth(val monthIndex: Int) : CalendarEvent
    data class ChangeYear(val yearIndex: Int) : CalendarEvent
    data class UpdateDrinkingSession(val session: DrinkingSessionWrapper) : CalendarEvent
    data class DeleteDrinkingSession(val session: DrinkingSessionWrapper) : CalendarEvent
    data class ChangeView(val calendarView: CalendarView) : CalendarEvent
}

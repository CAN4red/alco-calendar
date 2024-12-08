package com.example.alcocalendar.ui.calendar

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.monthscreen.MonthLayout
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.calendar.yearscreen.YearLayout
import com.example.alcocalendar.ui.navigation.CalendarView

@Composable
fun CalendarScreen(
    calendarState: CalendarState,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateToCategoryScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BackHandler(calendarState.currentView == CalendarView.YearView) {
        onCalendarEvent(CalendarEvent.ChangeView(CalendarView.MonthView))
    }

    Column(
        modifier = modifier
    ) {
        when (calendarState.currentView) {
            CalendarView.MonthView -> MonthLayout(
                calendarState = calendarState,
                onCalendarEvent = onCalendarEvent,
                onFillingSessionEvent = onFillingSessionEvent,
                navigateToCategoryScreen = navigateToCategoryScreen,
                modifier = modifier
            )

            CalendarView.YearView -> YearLayout(
                calendarState = calendarState,
                onCalendarEvent = onCalendarEvent,
                modifier = modifier
            )
        }
    }
}
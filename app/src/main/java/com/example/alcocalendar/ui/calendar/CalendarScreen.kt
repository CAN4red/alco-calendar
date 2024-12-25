package com.example.alcocalendar.ui.calendar

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.db.entities.DrinkingSession
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
    getSessionColor: (DrinkingSession, Boolean) -> Color,
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
                getSessionColor = getSessionColor,
                defaultCellColor = Color.Transparent,
                navigateToCategoryScreen = navigateToCategoryScreen,
                modifier = modifier
            )

            CalendarView.YearView -> YearLayout(
                calendarState = calendarState,
                onCalendarEvent = onCalendarEvent,
                getSessionColor = getSessionColor,
                defaultCellColor = MaterialTheme.colorScheme.surface,
                modifier = modifier
            )
        }

    }
}
package com.example.alcocalendar.ui.calendar.monthscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.calendar.viewmodel.IndexConverter


@Composable
fun MonthPager(
    calendarState: CalendarState,
    pagerState: PagerState,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    getSessionColor: (DrinkingSession) -> Color,
    navigateToCategoryScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { monthIndex ->

        MonthGrid(
            monthModel = calendarState.getMonthByIndex(monthIndex),
            onFillingSessionEvent = onFillingSessionEvent,
            navigateToCategoryScreen = navigateToCategoryScreen,
            startFromSunday = calendarState.startFromSunday,
            getSessionColor = getSessionColor,
            modifier = Modifier.fillMaxSize()
        )

        LaunchedEffect(pagerState.currentPage) {
            val currentYear = calendarState.getMonthByIndex(pagerState.currentPage).year
            val currentYearIndex = IndexConverter.getYearIndex(currentYear)

            onCalendarEvent(CalendarEvent.ChangeMonth(pagerState.currentPage))
            onCalendarEvent(CalendarEvent.ChangeYear(currentYearIndex))
        }
    }
}

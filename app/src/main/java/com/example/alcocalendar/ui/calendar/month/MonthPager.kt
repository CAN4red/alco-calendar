package com.example.alcocalendar.ui.calendar.month

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.calendar.viewmodel.IndexConverter
import java.time.LocalDate


@Composable
fun MonthPager(
    calendarState: CalendarState,
    pagerState: PagerState,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
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
            modifier = Modifier.fillMaxHeight()
        )

        LaunchedEffect(pagerState.currentPage) {
            val currentYear = calendarState.getMonthByIndex(pagerState.currentPage).year
            val currentYearIndex = IndexConverter.getYearIndex(currentYear)

            onCalendarEvent(CalendarEvent.ChangeMonth(pagerState.currentPage))
            onCalendarEvent(CalendarEvent.ChangeYear(currentYearIndex))
        }
    }
}

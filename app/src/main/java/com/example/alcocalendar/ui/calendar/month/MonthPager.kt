package com.example.alcocalendar.ui.calendar.month

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.alcocalendar.viewmodel.CalendarEvent
import com.example.alcocalendar.viewmodel.CalendarState
import com.example.alcocalendar.viewmodel.IndexConverter

@Composable
fun MonthPager(
    calendarState: CalendarState,
    pagerState: PagerState,
    onEvent: (CalendarEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { monthIndex ->

        MonthGrid(
            monthModel = calendarState.getMonthByIndex(monthIndex),
            onEvent = onEvent,
            startFromSunday = calendarState.startFromSunday,
            modifier = Modifier.fillMaxHeight()
        )

        LaunchedEffect(pagerState.currentPage) {
            val currentYear = calendarState.getMonthByIndex(pagerState.currentPage).year
            val currentYearIndex = IndexConverter.getYearIndex(currentYear)

            onEvent(CalendarEvent.ChangeMonth(pagerState.currentPage))
            onEvent(CalendarEvent.ChangeYear(currentYearIndex))
        }
    }
}

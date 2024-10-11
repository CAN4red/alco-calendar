package com.example.alcocalendar.ui.calendar.month

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.alcocalendar.ui.model.structure.CalendarEvent
import com.example.alcocalendar.ui.model.structure.CalendarState
import com.example.alcocalendar.ui.model.structure.IndexConverter

@Composable
fun MonthPager(
    calendarState: CalendarState,
    pagerState: PagerState,
    startFromSunday: Boolean,
    onEvent: (CalendarEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    var currentMonthIndex by remember { mutableIntStateOf(pagerState.currentPage) }

    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { monthIndex ->

        MonthGrid(
            monthModel = calendarState.getMonthByIndex(monthIndex),
            onEvent = onEvent,
            startFromSunday = startFromSunday,
            modifier = Modifier.fillMaxHeight()
        )

        LaunchedEffect(monthIndex) {
            when {
                (monthIndex > currentMonthIndex) -> currentMonthIndex = monthIndex - 1
                (monthIndex < currentMonthIndex) -> currentMonthIndex = monthIndex + 1
            }

            val currentYear = calendarState.getMonthByIndex(currentMonthIndex).year
            val currentYearIndex = IndexConverter.getYearIndex(currentYear)

            onEvent(CalendarEvent.ChangeMonth(currentMonthIndex))
            onEvent(CalendarEvent.ChangeYear(currentYearIndex))
        }
    }
}

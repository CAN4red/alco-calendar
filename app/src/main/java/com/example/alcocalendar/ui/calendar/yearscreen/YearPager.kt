package com.example.alcocalendar.ui.calendar.yearscreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.calendar.viewmodel.IndexConverter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun YearPager(
    calendarState: CalendarState,
    pagerState: PagerState,
    onCalendarEvent: (CalendarEvent) -> Unit,
    getSessionColor: (DrinkingSession, Boolean) -> Color,
    navigateToMonth: () -> Unit,
    defaultCellColor: Color,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { yearIndex ->
        YearGrid(
            yearModel = calendarState.getYearByIndex(yearIndex),
            defaultCellColor = defaultCellColor,
            onCalendarEvent = onCalendarEvent,
            getSessionColor = getSessionColor,
            navigateToMonth = navigateToMonth,
            startFromSunday = calendarState.startFromSunday,
            modifier = Modifier.fillMaxSize()
        )

        LaunchedEffect(pagerState.currentPage) {
            val monthIndex = calendarState.currentMonthIndex

            val currentYear = calendarState.getYearByIndex(pagerState.currentPage).year
            val currentMonth = calendarState.getMonthByIndex(monthIndex).month

            val currentMonthIndex = IndexConverter.getMonthIndex(currentYear, currentMonth)

            onCalendarEvent(CalendarEvent.ChangeYear(pagerState.currentPage))
            onCalendarEvent(CalendarEvent.ChangeMonth(currentMonthIndex))
        }
    }
}

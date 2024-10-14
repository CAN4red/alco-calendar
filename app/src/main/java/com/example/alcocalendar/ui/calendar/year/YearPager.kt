package com.example.alcocalendar.ui.calendar.year

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.alcocalendar.viewmodel.CalendarEvent
import com.example.alcocalendar.viewmodel.CalendarState
import com.example.alcocalendar.viewmodel.IndexConverter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun YearPager(
    calendarState: CalendarState,
    pagerState: PagerState,
    navigateToMonth: () -> Unit,
    onEvent: (CalendarEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier
    ) { yearIndex ->
        YearGrid(
            yearModel = calendarState.getYearByIndex(yearIndex),
            onEvent = onEvent,
            navigateToMonth = navigateToMonth,
            startFromSunday = calendarState.startFromSunday,
            modifier = Modifier.fillMaxSize()
        )

        LaunchedEffect(pagerState.currentPage) {
            val monthIndex = calendarState.currentMonthIndex

            val currentYear = calendarState.getYearByIndex(pagerState.currentPage).year
            val currentMonth = calendarState.getMonthByIndex(monthIndex).month

            val currentMonthIndex = IndexConverter.getMonthIndex(currentYear, currentMonth)

            onEvent(CalendarEvent.ChangeYear(pagerState.currentPage))
            onEvent(CalendarEvent.ChangeMonth(currentMonthIndex))
        }
    }
}

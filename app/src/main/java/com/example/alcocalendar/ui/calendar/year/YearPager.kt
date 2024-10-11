package com.example.alcocalendar.ui.calendar.year

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun YearPager(
    calendarState: CalendarState,
    pagerState: PagerState,
    navigateToMonth: () -> Unit,
    onEvent: (CalendarEvent) -> Unit,
    startFromSunday: Boolean,
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
            startFromSunday = startFromSunday,
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

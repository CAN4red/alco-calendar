package com.example.alcocalendar.features.calendar.presentation.month_appearance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.alcocalendar.core.navigation.NavRoutes
import com.example.alcocalendar.features.calendar.presentation.common.CalendarEvent
import com.example.alcocalendar.features.calendar.presentation.common.SharedCalendarViewModel
import com.example.alcocalendar.features.calendar.presentation.common.getSessionWithIntakes
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.MonthCalendarPager
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.MonthTitleWithNavigation
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.rememberFirstMostVisibleMonth
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarMonth
import com.kizitonwose.calendar.core.nextMonth
import com.kizitonwose.calendar.core.previousMonth
import java.time.Month
import java.time.YearMonth

@Composable
fun MonthCalendarScreen(
    navController: NavController,
    modifier: Modifier = Modifier, // temporary!
    viewModel: SharedCalendarViewModel = hiltViewModel(),
) {
    val sharedCalendarState by viewModel.calendarState.collectAsState()
    val calendarState = rememberCalendarState(
        startMonth = YearMonth.of(2020, Month.JANUARY),
        endMonth = YearMonth.of(2025, Month.DECEMBER),
        firstVisibleMonth = sharedCalendarState.currentYearMonth,
    )

    val visibleMonth = rememberFirstMostVisibleMonth(calendarState, 90f)

    Column(modifier = modifier) {
        MonthTitleWithNavigation(
            month = visibleMonth.yearMonth,
            scrollToPrevMonth = { calendarState.scrollToPrevMonth(visibleMonth) },
            scrollToNextMonth = { calendarState.scrollToNextMonth(visibleMonth) },
            navigateToYearCalendar = { navController.navigate(NavRoutes.YEAR_CALENDAR) },
        )

        MonthCalendarPager(
            calendarState = calendarState,
            getCalendarSessionWithIntakes = sharedCalendarState::getSessionWithIntakes,
            modifier = Modifier.fillMaxSize()
        )
    }

    LaunchedEffect(visibleMonth) {
        viewModel.onEvent(
            CalendarEvent.UpdateCurrentYearMonth(
                year = visibleMonth.yearMonth.year,
                month = visibleMonth.yearMonth.month,
            )
        )
    }
}

private suspend fun CalendarState.scrollToPrevMonth(currentMonth: CalendarMonth) {
    this.animateScrollToMonth(currentMonth.yearMonth.previousMonth)
}

private suspend fun CalendarState.scrollToNextMonth(currentMonth: CalendarMonth) {
    this.animateScrollToMonth(currentMonth.yearMonth.nextMonth)
}
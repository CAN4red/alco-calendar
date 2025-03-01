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
import com.example.alcocalendar.features.calendar.presentation.CalendarEvent
import com.example.alcocalendar.features.calendar.presentation.SharedCalendarViewModel
import com.example.alcocalendar.features.calendar.presentation.getSessionWithIntakes
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.MonthCalendarPager
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.MonthCalendarUtils.rememberFirstMostVisibleMonth
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.MonthTitleWithNavigation
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

    val currentMonth = rememberFirstMostVisibleMonth(calendarState, 90f)

    Column(modifier = modifier) {
        MonthTitleWithNavigation(
            month = currentMonth.yearMonth,
            scrollToPrevMonth = { calendarState.scrollToPrevMonth(currentMonth) },
            scrollToNextMonth = { calendarState.scrollToNextMonth(currentMonth) },
            navigateToYearCalendar = { navController.navigate(NavRoutes.YEAR_CALENDAR) },
        )

        MonthCalendarPager(
            state = calendarState,
            onEvent = viewModel::onEvent,
            getCalendarSessionWithIntakes = sharedCalendarState::getSessionWithIntakes,
            modifier = Modifier.fillMaxSize(),
            navigateToDrinkIntake = { date ->
                navController.navigate(
                    NavRoutes.drinkIntakeCalendarRoute(
                        date.year,
                        date.month,
                        date.dayOfMonth
                    )
                )
            }
        )
    }

    LaunchedEffect(currentMonth) {
        viewModel.onEvent(
            CalendarEvent.UpdateCurrentYearMonth(
                year = currentMonth.yearMonth.year,
                month = currentMonth.yearMonth.month,
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
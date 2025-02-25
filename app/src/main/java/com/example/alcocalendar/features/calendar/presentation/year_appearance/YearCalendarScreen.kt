package com.example.alcocalendar.features.calendar.presentation.year_appearance

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
import com.example.alcocalendar.features.calendar.presentation.common.asYear
import com.example.alcocalendar.features.calendar.presentation.common.getSessionWithIntakes
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.YearCalendarPager
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.YearTitleWithNavigation
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.rememberFirstMostVisibleYear
import com.kizitonwose.calendar.compose.yearcalendar.YearCalendarState
import com.kizitonwose.calendar.compose.yearcalendar.rememberYearCalendarState
import com.kizitonwose.calendar.core.CalendarYear
import com.kizitonwose.calendar.core.ExperimentalCalendarApi
import java.time.Year

@OptIn(ExperimentalCalendarApi::class)
@Composable
fun YearCalendarScreen(
    navController: NavController,
    modifier: Modifier = Modifier, // temporary!
    viewModel: SharedCalendarViewModel = hiltViewModel(),
) {
    val sharedCalendarState by viewModel.calendarState.collectAsState()
    val yearCalendarState = rememberYearCalendarState(
        startYear = Year.of(2020),
        endYear = Year.of(2025),
        firstVisibleYear = sharedCalendarState.currentYearMonth.asYear(),
    )

    val currentYear = rememberFirstMostVisibleYear(yearCalendarState, 90f)

    Column(modifier = modifier) {
        YearTitleWithNavigation(
            year = currentYear.year,
            scrollToPrevYear = { yearCalendarState.scrollToPrevYear(currentYear) },
            scrollToNextYear = { yearCalendarState.scrollToNextYear(currentYear) },
            navigateToMonthCalendar = navController::navigateToMonthCalendar
        )

        YearCalendarPager(
            yearCalendarState = yearCalendarState,
            getCalendarSessionWithIntakes = sharedCalendarState::getSessionWithIntakes,
            onCalendarEvent = viewModel::onEvent,
            navigateToTheMonth = navController::navigateToMonthCalendar,
            modifier = Modifier.fillMaxSize()
        )
    }

    LaunchedEffect(currentYear) {
        viewModel.onEvent(CalendarEvent.UpdateCurrentYearMonth(year = currentYear.year.value))
    }
}

private suspend fun YearCalendarState.scrollToPrevYear(currentYear: CalendarYear) {
    this.animateScrollToYear(currentYear.year.minusYears(1))
}

private suspend fun YearCalendarState.scrollToNextYear(currentYear: CalendarYear) {
    this.animateScrollToYear(currentYear.year.plusYears(1))
}

private fun NavController.navigateToMonthCalendar() {
    this.navigate(NavRoutes.MONTH_CALENDAR) {
        popUpTo(NavRoutes.MONTH_CALENDAR) { inclusive = true }
    }
}

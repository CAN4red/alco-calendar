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
import com.example.alcocalendar.features.calendar.presentation.common.SharedCalendarViewModel
import com.example.alcocalendar.features.calendar.presentation.common.asYear
import com.example.alcocalendar.features.calendar.presentation.common.getSessionWithIntakes
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.YearCalendarPager
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.YearTitleWithNavigation
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.rememberFirstMostVisibleYear
import com.kizitonwose.calendar.compose.yearcalendar.rememberYearCalendarState
import com.kizitonwose.calendar.core.ExperimentalCalendarApi
import java.time.Year

@OptIn(ExperimentalCalendarApi::class)
@Composable
fun YearCalendarScreen(
    navController: NavController,
    modifier: Modifier = Modifier, // temporary!
    viewModel: SharedCalendarViewModel = hiltViewModel(),
) {
    val calendarDataState by viewModel.calendarState.collectAsState()
    val yearCalendarState = rememberYearCalendarState(
        startYear = Year.of(2020),
        endYear = Year.of(2025),
        firstVisibleYear = calendarDataState.currentYearMonth.asYear(),
    )

    val visibleYear = rememberFirstMostVisibleYear(yearCalendarState, 90f)

    Column(modifier = modifier) {
        YearTitleWithNavigation(
            year = visibleYear.year,
            scrollToPrevYear = { yearCalendarState.animateScrollToYear(visibleYear.year.minusYears(1)) },
            scrollToNextYear = { yearCalendarState.animateScrollToYear(visibleYear.year.plusYears(1)) },
            navigateToMonthCalendar = {
                navController.popBackStack(
                    route = NavRoutes.MONTH_CALENDAR,
                    inclusive = false
                )
            }
        )

        YearCalendarPager(
            yearCalendarState = yearCalendarState,
            getCalendarSessionWithIntakes = calendarDataState::getSessionWithIntakes,
            modifier = Modifier.fillMaxSize()
        )
    }

    LaunchedEffect(visibleYear) {
        viewModel.updateCurrentYearMonth(year = visibleYear.year.value)
    }
}
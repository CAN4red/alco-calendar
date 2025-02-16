package com.example.alcocalendar.features.calendar.presentation.year_appearance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.alcocalendar.features.calendar.presentation.common.CalendarViewModel
import com.example.alcocalendar.features.calendar.presentation.common.getSessionWithIntakes
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.YearCalendarPager
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.YearTitleWithNavigation
import com.example.alcocalendar.features.calendar.presentation.year_appearance.components.rememberFirstMostVisibleYear
import com.kizitonwose.calendar.compose.yearcalendar.rememberYearCalendarState
import com.kizitonwose.calendar.core.ExperimentalCalendarApi
import java.time.Year

@OptIn(ExperimentalCalendarApi::class)
@Composable
fun YearAppearanceScreen(
    modifier: Modifier = Modifier, // temporary!
    firstVisibleYear: Year = Year.now(),
    viewModel: CalendarViewModel = hiltViewModel(),
) {
    val calendarDataState by viewModel.calendarDataState.collectAsState()
    val yearCalendarState = rememberYearCalendarState(
        startYear = Year.of(2020),
        endYear = Year.of(2025),
        firstVisibleYear = firstVisibleYear,
    )

    val visibleYear = rememberFirstMostVisibleYear(yearCalendarState, 90f)

    Column(modifier = modifier) {
        YearTitleWithNavigation(
            year = visibleYear.year,
            scrollToPrevYear = { yearCalendarState.animateScrollToYear(visibleYear.year.minusYears(1)) },
            scrollToNextYear = { yearCalendarState.animateScrollToYear(visibleYear.year.plusYears(1)) }
        )

        YearCalendarPager(
            yearCalendarState = yearCalendarState,
            getCalendarSessionWithIntakes = calendarDataState::getSessionWithIntakes,
            modifier = Modifier.fillMaxSize()
        )
    }
}
package com.example.alcocalendar.features.calendar.presentation.month_appearance.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.alcocalendar.features.calendar.presentation.common.CalendarViewModel
import com.example.alcocalendar.features.calendar.presentation.common.getSessionWithIntakes
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import java.time.Month
import java.time.YearMonth

@Composable
fun MonthAppearanceScreen(
    modifier: Modifier = Modifier, // temporary!
    viewModel: CalendarViewModel = hiltViewModel(),
) {
    val calendarDataState by viewModel.calendarDataState.collectAsState()
    val calendarState = rememberCalendarState(
        startMonth = YearMonth.of(2020, Month.JANUARY),
        endMonth = YearMonth.of(2025, Month.DECEMBER),
        firstVisibleMonth = YearMonth.now(),
        firstDayOfWeek = firstDayOfWeekFromLocale()
    )

    CalendarPager(
        calendarState = calendarState,
        getCalendarSessionWithIntakes = calendarDataState::getSessionWithIntakes,
        modifier = modifier.fillMaxSize()
    )
}
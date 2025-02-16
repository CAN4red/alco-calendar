package com.example.alcocalendar.features.calendar.presentation.month_appearance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.alcocalendar.features.calendar.presentation.common.CalendarViewModel
import com.example.alcocalendar.features.calendar.presentation.common.getSessionWithIntakes
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.MonthCalendarPager
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.MonthTitleWithNavigation
import com.example.alcocalendar.features.calendar.presentation.month_appearance.components.rememberFirstMostVisibleMonth
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.nextMonth
import com.kizitonwose.calendar.core.previousMonth
import java.time.Month
import java.time.YearMonth

@Composable
fun MonthAppearanceScreen(
    modifier: Modifier = Modifier, // temporary!
    firstVisibleMonth: YearMonth = YearMonth.now(),
    viewModel: CalendarViewModel = hiltViewModel(),
) {
    val calendarDataState by viewModel.calendarDataState.collectAsState()
    val calendarState = rememberCalendarState(
        startMonth = YearMonth.of(2020, Month.JANUARY),
        endMonth = YearMonth.of(2025, Month.DECEMBER),
        firstVisibleMonth = firstVisibleMonth,
    )

    val visibleMonth = rememberFirstMostVisibleMonth(calendarState, 90f)

    Column(modifier = modifier) {
        MonthTitleWithNavigation(
            month = visibleMonth.yearMonth,
            scrollToPrevMonth = { calendarState.animateScrollToMonth(visibleMonth.yearMonth.previousMonth) },
            scrollToNextMonth = { calendarState.animateScrollToMonth(visibleMonth.yearMonth.nextMonth) }
        )

        MonthCalendarPager(
            calendarState = calendarState,
            getCalendarSessionWithIntakes = calendarDataState::getSessionWithIntakes,
            modifier = Modifier.fillMaxSize()
        )
    }
}
package com.example.alcocalendar.ui.calendar.yearscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.ui.calendar.components.CalendarNavigationBar
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.navigation.CalendarView


@SuppressLint("NewApi")
@Composable
fun YearLayout(
    calendarState: CalendarState,
    onCalendarEvent: (CalendarEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = calendarState.currentYearIndex,
        pageCount = { calendarState.yearsCount }
    )

    val titleString = calendarState.getYearByIndex(pagerState.currentPage).year.toString()

    Column(
        modifier = modifier,
    ) {
        CalendarNavigationBar(
            onTitleClick = { onCalendarEvent(CalendarEvent.ChangeView(CalendarView.MonthView)) },
            titleString = titleString,
            enabledPrev = calendarState.hasPrevYear,
            enabledNext = calendarState.hasNextYear,
            onBackNavigationClick = {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            },
            onForwardNavigationClick = {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            },
        )

        YearPager(
            calendarState = calendarState,
            onCalendarEvent = onCalendarEvent,
            navigateToMonth = { onCalendarEvent(CalendarEvent.ChangeView(CalendarView.MonthView)) },
            pagerState = pagerState,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

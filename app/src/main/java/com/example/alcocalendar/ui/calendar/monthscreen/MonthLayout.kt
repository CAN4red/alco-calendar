package com.example.alcocalendar.ui.calendar.monthscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.components.CalendarNavigationBar
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState


@SuppressLint("NewApi")
@Composable
fun MonthLayout(
    calendarState: CalendarState,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateToCategoryScreen: () -> Unit,
    navigateToYear: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(
        initialPage = calendarState.currentMonthIndex,
        pageCount = { calendarState.monthsCount }
    )

    val month = calendarState.getMonthByIndex(pagerState.currentPage).month
    val year = calendarState.getMonthByIndex(pagerState.currentPage).year
    val titleString = "$month $year"

    Column(
        modifier = modifier,
    ) {
        CalendarNavigationBar(
            titleString = titleString,
            onTitleClick = navigateToYear,
            enabledPrev = calendarState.hasPrevMonth,
            enabledNext = calendarState.hasNextMonth,
            onBackNavigationClick = {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            },
            onForwardNavigationClick = {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            },
        )

        MonthPager(
            calendarState = calendarState,
            pagerState = pagerState,
            onCalendarEvent = onCalendarEvent,
            onFillingSessionEvent = onFillingSessionEvent,
            navigateToCategoryScreen = navigateToCategoryScreen,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
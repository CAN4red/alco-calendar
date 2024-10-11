package com.example.alcocalendar.ui.calendar.year

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.ui.calendar.month.CalendarNavigationBar
import com.example.alcocalendar.ui.model.structure.CalendarEvent
import com.example.alcocalendar.ui.model.structure.CalendarState

@SuppressLint("NewApi")
@Composable
fun YearLayout(
    calendarState: CalendarState,
    onEvent: (CalendarEvent) -> Unit,
    navigateToYear: () -> Unit,
    startFromSunday: Boolean,
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
            onTitleClick = navigateToYear,
            titleString = titleString,
            enabledPrev = calendarState.hasPrevYear(),
            enabledNext = calendarState.hasNextYear(),
            onBackNavigationClick = {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            },
            onForwardNavigationClick = {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            },
        )

        YearPager(
            calendarState = calendarState,
            onEvent = onEvent,
            navigateToMonth = navigateToYear,
            pagerState = pagerState,
            startFromSunday = startFromSunday,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

package com.example.alcocalendar.ui.calendar.monthscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.components.CalendarNavigationBar
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarState
import com.example.alcocalendar.ui.navigation.CalendarView


@SuppressLint("NewApi")
@Composable
fun MonthLayout(
    calendarState: CalendarState,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    getSessionColor: (DrinkingSession) -> Color,
    defaultCellColor: Color,
    navigateToCategoryScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(
        initialPage = calendarState.currentMonthIndex,
        pageCount = { calendarState.monthsCount }
    )

    val month = calendarState
        .getMonthByIndex(pagerState.currentPage).month.toString()
        .lowercase()
        .replaceFirstChar { it.titlecase() }
    val year = calendarState
        .getMonthByIndex(pagerState.currentPage)
        .year
    val titleString = "$month $year"

    Column(
        modifier = modifier,
    ) {
        CalendarNavigationBar(
            titleString = titleString,
            onTitleClick = { onCalendarEvent(CalendarEvent.ChangeView(CalendarView.YearView)) },
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
            getSessionColor = getSessionColor,
            defaultCellColor = defaultCellColor,
            navigateToCategoryScreen = navigateToCategoryScreen,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

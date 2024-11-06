package com.example.alcocalendar.ui.calendar.month

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.ui.calendar.CalendarNavigationBar
import com.example.alcocalendar.viewmodel.events.CalendarEvent
import com.example.alcocalendar.viewmodel.events.SessionFillingEvent
import com.example.alcocalendar.viewmodel.states.CalendarState


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("NewApi")
@Composable
fun MonthLayout(
    calendarState: CalendarState,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onSessionFillingEvent: (SessionFillingEvent) -> Unit,
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
            modifier = Modifier.fillMaxWidth()
        )

        if (calendarState.isShowingSessionEditMenu) {
            ModalBottomSheet(onDismissRequest = { onSessionFillingEvent(SessionFillingEvent.ConfirmSession) }) {
                Column {
                    Text("lol")
                    Text("lol")
                    Text("lol")
                    Text("lol")
                }
            }
        }
    }
}

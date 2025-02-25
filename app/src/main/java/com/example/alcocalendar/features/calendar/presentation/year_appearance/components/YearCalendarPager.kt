package com.example.alcocalendar.features.calendar.presentation.year_appearance.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.example.alcocalendar.features.calendar.presentation.CalendarEvent
import com.kizitonwose.calendar.compose.HorizontalYearCalendar
import com.kizitonwose.calendar.compose.yearcalendar.YearCalendarState
import com.kizitonwose.calendar.compose.yearcalendar.rememberYearCalendarState
import com.kizitonwose.calendar.core.CalendarMonth
import com.kizitonwose.calendar.core.ExperimentalCalendarApi
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalCalendarApi::class)
@Composable
fun YearCalendarPager(
    yearCalendarState: YearCalendarState,
    getCalendarSessionWithIntakes: (LocalDate) -> CalendarSessionWithIntakes,
    onCalendarEvent: (CalendarEvent) -> Unit,
    navigateToTheMonth: () -> Unit,
    modifier: Modifier = Modifier,
) {
    HorizontalYearCalendar(
        state = yearCalendarState,
        dayContent = { calendarDay ->
            DayOfYearCell(
                calendarSessionWithIntakes = getCalendarSessionWithIntakes(calendarDay.date),
                calendarDay = calendarDay
            )
        },
        monthHeader = { month -> MonthTitle(month.yearMonth) },
        monthBody = { month, content ->
            ClickableMonthBody(
                content = content,
                onMonthClick = {
                    onMonthClick(
                        month = month,
                        onCalendarEvent = onCalendarEvent,
                        navigateToTheMonth = navigateToTheMonth
                    )
                }
            )
        },
        monthHorizontalSpacing = 16.dp,
        monthVerticalSpacing = 14.dp,
        modifier = modifier,
    )
}

@Composable
private fun MonthTitle(month: YearMonth) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = month.month.getDisplayName(TextStyle.FULL, Locale.getDefault()))
    }
}

@Composable
private fun ClickableMonthBody(
    content: @Composable () -> Unit,
    onMonthClick: () -> Unit,
) {
    Box(
        modifier = Modifier.clickable { onMonthClick() }
    ) {
        content()
    }
}


private fun onMonthClick(
    month: CalendarMonth,
    onCalendarEvent: (CalendarEvent) -> Unit,
    navigateToTheMonth: () -> Unit
) {
    onCalendarEvent(
        CalendarEvent.UpdateCurrentYearMonth(
            year = month.yearMonth.year,
            month = month.yearMonth.month
        )
    )
    navigateToTheMonth()
}


@OptIn(ExperimentalCalendarApi::class)
@Preview
@Composable
private fun CalendarPagerPreview() {
    YearCalendarPager(
        yearCalendarState = rememberYearCalendarState(),
        getCalendarSessionWithIntakes = { date -> CalendarSessionWithIntakes(date) },
        onCalendarEvent = {},
        navigateToTheMonth = {},
        modifier = Modifier.fillMaxSize()
    )
}
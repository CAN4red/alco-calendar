package com.example.alcocalendar.features.calendar.presentation.month_appearance.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun MonthCalendarPager(
    calendarState: CalendarState,
    getCalendarSessionWithIntakes: (LocalDate) -> CalendarSessionWithIntakes,
    modifier: Modifier = Modifier,
) {
    HorizontalCalendar(
        state = calendarState,
        dayContent = { calendarDay ->
            DayOfMonthCell(
                calendarSessionWithIntakes = getCalendarSessionWithIntakes(calendarDay.date),
                calendarDay = calendarDay
            )
        },
        monthHeader = { month ->
            val dayOfWeek = remember { month.weekDays.first().map { it.date.dayOfWeek } }
            DaysOfWeekTitle(dayOfWeek)
        },
        modifier = modifier,
    )
}


@Composable
private fun DaysOfWeekTitle(daysOfWeek: List<DayOfWeek>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (dayOfWeek in daysOfWeek) {
            Text(
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
            )
        }
    }
}


@Preview
@Composable
private fun CalendarPagerPreview() {
    MonthCalendarPager(
        calendarState = rememberCalendarState(),
        getCalendarSessionWithIntakes = { date -> CalendarSessionWithIntakes(date) },
        modifier = Modifier.fillMaxSize()
    )
}
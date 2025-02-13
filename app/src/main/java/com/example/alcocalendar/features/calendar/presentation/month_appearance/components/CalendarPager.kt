package com.example.alcocalendar.features.calendar.presentation.month_appearance.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.kizitonwose.calendar.compose.CalendarState
import com.kizitonwose.calendar.compose.HorizontalCalendar
import java.time.LocalDate

@Composable
fun CalendarPager(
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
        }
    )
}
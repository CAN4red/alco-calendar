package com.example.alcocalendar.features.calendar.presentation.month_appearance.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.example.alcocalendar.features.calendar.presentation.CalendarEvent
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import java.time.LocalDate

@Composable
fun DayOfMonthCell(
    onEvent: (CalendarEvent) -> Unit,
    calendarSessionWithIntakes: CalendarSessionWithIntakes,
    calendarDay: CalendarDay,
    navigateToDrinkIntake: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .aspectRatio(1f)
            .padding(6.dp)
    ) {
        if (calendarDay.position == DayPosition.MonthDate) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .matchParentSize()
                    .clip(CircleShape)
                    .background(color = getCellColor(calendarSessionWithIntakes))
                    .clickable {
                        navigateToDrinkIntake()
                        onEvent(CalendarEvent.InitializeSession(calendarSessionWithIntakes.date))
                    }
            ) {
                Text(text = calendarSessionWithIntakes.date.dayOfMonth.toString())
            }
        }
    }
}

@Composable
private fun getCellColor(calendarSessionWithIntakes: CalendarSessionWithIntakes): Color {
    if (calendarSessionWithIntakes.isNotEmpty) {
        return MaterialTheme.colorScheme.primary
    }
    return Color.Transparent
}

@Preview
@Composable
private fun DayOfMonthCellPreview() {
    DayOfMonthCell(
        onEvent = {},
        calendarSessionWithIntakes = CalendarSessionWithIntakes(LocalDate.now()),
        calendarDay = CalendarDay(LocalDate.now(), DayPosition.MonthDate),
        navigateToDrinkIntake = {}
    )
}

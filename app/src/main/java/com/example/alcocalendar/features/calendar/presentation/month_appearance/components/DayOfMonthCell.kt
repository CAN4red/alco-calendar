package com.example.alcocalendar.features.calendar.presentation.month_appearance.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition

@Composable
fun DayOfMonthCell(
    calendarSessionWithIntakes: CalendarSessionWithIntakes,
    calendarDay: CalendarDay,
) {
    Box(
        modifier = Modifier.aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        if (calendarDay.position == DayPosition.MonthDate) {
            Text(text = calendarSessionWithIntakes.date.dayOfMonth.toString())
        }
    }
}
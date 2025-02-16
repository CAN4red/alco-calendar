package com.example.alcocalendar.features.calendar.presentation.year_appearance.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.features.calendar.domain.model.CalendarSessionWithIntakes
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import java.time.LocalDate

@Composable
fun DayOfYearCell(
    calendarSessionWithIntakes: CalendarSessionWithIntakes,
    calendarDay: CalendarDay,
) {
    val isMonthDate = (calendarDay.position == DayPosition.MonthDate)

    val cellModifier = Modifier.getCellModifier(isMonthDate)

    Box(modifier = cellModifier)
}

private fun Modifier.getCellModifier(isMonthDate: Boolean): Modifier {
    return if (isMonthDate) {
        this
            .getCommonCellModifier()
            .background(shape = CircleShape, color = Color.Gray)
            .clip(CircleShape)
    } else {
        this.getCommonCellModifier()
    }
}

private fun Modifier.getCommonCellModifier(): Modifier {
    return this
        .aspectRatio(1f)
        .padding(2.dp)
}

@Preview
@Composable
private fun DayOfYearCellPreview() {
    DayOfYearCell(
        calendarSessionWithIntakes = CalendarSessionWithIntakes(LocalDate.now()),
        calendarDay = CalendarDay(LocalDate.now(), DayPosition.MonthDate)
    )
}
package com.example.alcocalendar.ui.calendar.month

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.ui.calendar.DateCell
import com.example.alcocalendar.ui.calendar.DatesGrid
import com.example.alcocalendar.ui.calendar.viewmodel.events.CalendarEvent
import java.time.Month


@SuppressLint("NewApi")
@Composable
fun MonthGrid(
    monthModel: MonthModel,
    onCalendarEvent: (CalendarEvent) -> Unit,
    startFromSunday: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        DatesGrid(
            monthModel = monthModel,
            startFromSunday = startFromSunday,
            showDaysOfWeek = true,
            dateCell = { session -> DateCell(session = session, onCalendarEvent = onCalendarEvent) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@SuppressLint("NewApi")
@Preview
@Composable
fun MonthGridPreview() {
    MonthGrid(
        monthModel = MonthModel(2024, Month.AUGUST),
        onCalendarEvent = {},
        startFromSunday = false,
        modifier = Modifier.background(color = Color.White)
    )
}
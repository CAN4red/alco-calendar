package com.example.alcocalendar.ui.calendar.month

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.ui.calendar.WeekdayCell
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.ui.calendar.DateCell
import com.example.alcocalendar.ui.calendar.EmptyCell
import com.example.alcocalendar.viewmodel.CalendarEvent
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.util.Locale

@SuppressLint("NewApi")
@Composable
fun MonthGrid(
    monthModel: MonthModel,
    onEvent: (CalendarEvent) -> Unit,
    startFromSunday: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        DatesGrid(
            monthModel = monthModel,
            startFromSunday = startFromSunday,
            onEvent = onEvent,
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatesGrid(
    monthModel: MonthModel,
    startFromSunday: Boolean,
    onEvent: (CalendarEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val daysOfWeek = monthModel.sessions.groupBy { it.date.dayOfWeek }
    val orderedDaysOfWeek = orderDaysOfWeek(daysOfWeek.keys.toList(), startFromSunday)
    val firstDayIndex = getFirstDayIndex(monthModel.sessions.first().date, startFromSunday)

    Row(
        modifier = modifier
    ) {
        orderedDaysOfWeek.forEach { dayOfWeek ->
            Column(modifier = Modifier.weight(1f)) {
                WeekdayCell(dayOfWeek = dayOfWeek)

                Spacer(modifier = Modifier.height(8.dp))

                val dayOfWeekIndex = orderedDaysOfWeek.indexOf(
                    daysOfWeek[dayOfWeek]?.first()?.date?.dayOfWeek
                )
                if (dayOfWeekIndex < firstDayIndex) {
                    EmptyCell()
                }

                daysOfWeek[dayOfWeek]?.forEach { session ->
                    DateCell(session = session, onEvent = onEvent)
                }
            }
        }
    }
}
@SuppressLint("NewApi")
fun LocalDate.getWeekday(): String {
    val formatter = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH)
    return this.format(formatter).trim()
}

fun orderDaysOfWeek(
    daysOfWeek: List<DayOfWeek>,
    startFromSunday: Boolean
): List<DayOfWeek> {
    val orderedDays = daysOfWeek.sorted()
    return if (startFromSunday) {
        listOf(orderedDays.last()) + orderedDays.dropLast(1)
    } else {
        orderedDays
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getFirstDayIndex(firstDay: LocalDate, startFromSunday: Boolean): Int {
    var index = firstDay.dayOfWeek.value - 1
    if (startFromSunday) {
        index = (index + 1) % 7
    }
    return index
}


@SuppressLint("NewApi")
@Preview
@Composable
fun MonthGridPreview() {
    MonthGrid(
        monthModel = MonthModel(2024, Month.AUGUST),
        onEvent = {},
        startFromSunday = false,
        modifier = Modifier.background(color = Color.White)
    )
}
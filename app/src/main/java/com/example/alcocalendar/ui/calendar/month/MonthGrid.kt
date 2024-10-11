package com.example.alcocalendar.ui.calendar.month

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.ui.calendar.DateCell
import com.example.alcocalendar.ui.calendar.EmptyCell
import com.example.alcocalendar.ui.calendar.WeekdayCell
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.viewmodel.CalendarEvent
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
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
        Row(modifier = Modifier.fillMaxWidth()) {
            getWeekDays(startFromSunday = startFromSunday).forEach { weekday ->
                WeekdayCell(
                    weekday = weekday,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.size(8.dp))

        DatesGrid(
            monthModel = monthModel,
            startFromSunday = startFromSunday,
            onEvent = onEvent
        )

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatesGrid(
    monthModel: MonthModel,
    startFromSunday: Boolean,
    onEvent: (CalendarEvent) -> Unit,
) {
    monthModel.changeLayoutForSundays(startFromSunday)
    val monthMatrix = monthModel.monthMatrix

    Row(modifier = Modifier.fillMaxWidth()) {
        monthMatrix.forEach { sessions ->
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.weight(1f)
            ) {
                // Adding empty cells at the start of the month
                if (monthMatrix.indexOf(sessions) + 1 < sessions[0].date.dayOfMonth &&
                    sessions[0].date.dayOfMonth != 1
                ) {
                    EmptyCell(modifier = Modifier.fillMaxWidth())
                }

                // Generating the dates
                sessions.forEach { session ->
                    DateCell(
                        session = session,
                        signal = false,
                        onEvent = onEvent,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // Adding empty cells at the end of the month
                if (monthMatrix[0].last().date.dayOfMonth - sessions.last().date.dayOfMonth >= 1) {
                    EmptyCell(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}

fun getWeekDays(startFromSunday: Boolean): ImmutableList<Int> {
    val days = (1..7).toList()
    return (if (startFromSunday)
        days.drop(1) + days.take(1)
    else
        days).toImmutableList()
}

@SuppressLint("NewApi")
fun LocalDate.getWeekday(): String {
    val formatter = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH)
    return this.format(formatter).trim()
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
package com.example.alcocalendar.ui.calendar.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.alcocalendar.model.DrinkingSessionWrapper
import com.example.alcocalendar.model.MonthModel
import java.time.DayOfWeek
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatesGrid(
    monthModel: MonthModel,
    startFromSunday: Boolean,
    showDaysOfWeek: Boolean,
    dateCell: @Composable (session: DrinkingSessionWrapper) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        val orderedDaysOfWeek = orderDaysOfWeek(DayOfWeek.entries, startFromSunday)
        val weeks = getWeeks(monthModel.sessions, startFromSunday)

        val firstEmptyCellsCount = 7 - weeks.first().size
        val lastEmptyCellsCount = 7 - weeks.last().size

        if (showDaysOfWeek) {
            Row(modifier = Modifier.fillMaxWidth()) {
                orderedDaysOfWeek.forEach { dayOfWeek ->
                    WeekdayCell(
                        dayOfWeek = dayOfWeek,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                }
            }
        }

        weeks.forEachIndexed { index, week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                if (index == 0) {
                    repeat(firstEmptyCellsCount) {
                        EmptyCell(modifier = Modifier.weight(1f))
                    }
                }
                week.forEach { session ->
                    dateCell(session)
                }
                if (index == weeks.indices.last) {
                    repeat(lastEmptyCellsCount) {
                        EmptyCell(modifier = Modifier.weight(1f))
                    }
                }

            }
        }
    }
}

private fun orderDaysOfWeek(
    daysOfWeek: List<DayOfWeek>, startFromSunday: Boolean
): List<DayOfWeek> {
    val orderedDays = daysOfWeek.sorted()
    return if (startFromSunday) {
        listOf(orderedDays.last()) + orderedDays.dropLast(1)
    } else {
        orderedDays
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getWeeks(
    days: List<DrinkingSessionWrapper>,
    startFromSunday: Boolean
): List<List<DrinkingSessionWrapper>> {
    val firstDayIndex = getFirstDayIndex(days.first().date, startFromSunday)
    val firstWeekLength = 7 - firstDayIndex

    val firstWeek = days.take(firstWeekLength)
    val remainingWeeks = days.drop(firstWeekLength).chunked(7)

    return listOf(firstWeek) + remainingWeeks
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getFirstDayIndex(
    firstDay: LocalDate, startFromSunday: Boolean
): Int {
    return if (startFromSunday) {
        (firstDay.dayOfWeek.value % 7) // Sunday as the first day
    } else {
        firstDay.dayOfWeek.value - 1 // Monday as the first day
    }
}

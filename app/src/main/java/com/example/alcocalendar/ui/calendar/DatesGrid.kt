package com.example.alcocalendar.ui.calendar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.model.DrinkingSessionModel
import com.example.alcocalendar.model.MonthModel
import java.time.DayOfWeek
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DatesGrid(
    monthModel: MonthModel,
    startFromSunday: Boolean,
    showDaysOfWeek: Boolean,
    dateCell: @Composable (session: DrinkingSessionModel) -> Unit,
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
                if (showDaysOfWeek) {
                    WeekdayCell(dayOfWeek = dayOfWeek)

                    Spacer(modifier = Modifier.height(8.dp))
                }

                val dayOfWeekIndex = orderedDaysOfWeek.indexOf(
                    daysOfWeek[dayOfWeek]?.first()?.date?.dayOfWeek
                )
                if (dayOfWeekIndex < firstDayIndex) {
                    EmptyCell()
                }

                daysOfWeek[dayOfWeek]?.forEach { session ->
                    dateCell(session)
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
private fun getFirstDayIndex(
    firstDay: LocalDate, startFromSunday: Boolean
): Int {
    var index = firstDay.dayOfWeek.value - 1
    if (startFromSunday) {
        index = (index + 1) % 7
    }
    return index
}
package com.example.alcocalendar.ui.calendar.year

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.ui.calendar.EmptyCell
import com.example.alcocalendar.ui.calendar.SmallDateCell
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.model.YearModel
import com.example.alcocalendar.ui.calendar.month.DatesGrid
import com.example.alcocalendar.viewmodel.CalendarEvent
import com.example.alcocalendar.viewmodel.IndexConverter
import java.time.Month

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun YearGrid(
    yearModel: YearModel,
    onEvent: (CalendarEvent) -> Unit,
    navigateToMonth: () -> Unit,
    startFromSunday: Boolean,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        items(items = yearModel.months.values.toList()) { monthModel ->
            NonDetailedMonthLayout(
                monthModel = monthModel,
                startFromSunday = startFromSunday,
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 16.dp,
                        start = 8.dp,
                        end = 8.dp
                    )
                    .clickable(onClick = {
                        val monthIndex = IndexConverter.getMonthIndex(
                            monthModel.year,
                            monthModel.month
                        )
                        onEvent(CalendarEvent.ChangeMonth(monthIndex))
                        navigateToMonth()
                    })
            )
        }
    }
}


@SuppressLint("NewApi")
@Composable
fun NonDetailedMonthLayout(
    monthModel: MonthModel,
    startFromSunday: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = monthModel.month.name)

        DatesGrid(
            monthModel = monthModel,
            startFromSunday = startFromSunday,
            dateCell = { session ->
                SmallDateCell(session = session,)
            },
            modifier = modifier
        )
    }
}

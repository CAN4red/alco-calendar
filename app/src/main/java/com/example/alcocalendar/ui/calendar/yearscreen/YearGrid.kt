package com.example.alcocalendar.ui.calendar.yearscreen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.BeerIntake
import com.example.alcocalendar.model.DrinkingSessionWrapper
import com.example.alcocalendar.ui.calendar.components.SmallDateCell
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.model.YearModel
import com.example.alcocalendar.ui.calendar.components.DatesGrid
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.calendar.viewmodel.IndexConverter
import java.time.LocalDate
import java.time.Month


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun YearGrid(
    yearModel: YearModel,
    onCalendarEvent: (CalendarEvent) -> Unit,
    getSessionColor: (DrinkingSession) -> Color,
    navigateToMonth: () -> Unit,
    defaultCellColor: Color,
    startFromSunday: Boolean,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        items(items = Month.entries) { month ->
            val monthModel = yearModel.getMonthModel(month)
            NonDetailedMonthLayout(
                monthModel = monthModel,
                defaultCellColor = defaultCellColor,
                getSessionColor = getSessionColor,
                startFromSunday = startFromSunday,
                modifier = Modifier
                    .padding(8.dp)
                    .padding(bottom = 16.dp)
                    .clickable(onClick = {
                        val monthIndex = IndexConverter.getMonthIndex(
                            monthModel.year,
                            monthModel.month
                        )
                        onCalendarEvent(CalendarEvent.ChangeMonth(monthIndex))
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
    getSessionColor: (DrinkingSession) -> Color,
    defaultCellColor: Color,
    startFromSunday: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = monthModel.month.name)

        DatesGrid(
            monthModel = monthModel,
            startFromSunday = startFromSunday,
            showDaysOfWeek = false,
            dateCell = { session ->
                SmallDateCell(
                    session = session,
                    color = if (session.isEmpty) defaultCellColor else getSessionColor(session),
                    modifier = Modifier.weight(1f)
                )
            },
            modifier = modifier
        )
    }
}

@Preview
@Composable
@RequiresApi(Build.VERSION_CODES.O)
private fun NonDetailedMonthLayoutPreview() {
    val month = Month.MAY
    val monthModel = MonthModel(2024, month)
    monthModel.updateDrinkingSession(
        DrinkingSessionWrapper(
            DrinkingSessionDb(
                date = LocalDate.of(2024, month, 5),
                beerIntake = BeerIntake(light = Beer.Light(1.0))
            )
        )
    )

    monthModel.updateDrinkingSession(
        DrinkingSessionWrapper(
            DrinkingSessionDb(
                date = LocalDate.of(2024, month, 6),
                beerIntake = BeerIntake(light = Beer.Light(1.0))
            )
        )
    )

    monthModel.updateDrinkingSession(
        DrinkingSessionWrapper(
            DrinkingSessionDb(
                date = LocalDate.of(2024, month, 7),
                beerIntake = BeerIntake(light = Beer.Light(1.0))
            )
        )
    )

    monthModel.updateDrinkingSession(
        DrinkingSessionWrapper(
            DrinkingSessionDb(
                date = LocalDate.of(2024, month, 8),
                beerIntake = BeerIntake(light = Beer.Light(1.0))
            )
        )
    )

    monthModel.updateDrinkingSession(
        DrinkingSessionWrapper(
            DrinkingSessionDb(
                date = LocalDate.of(2024, month, 9),
                beerIntake = BeerIntake(light = Beer.Light(1.0))
            )
        )
    )

    monthModel.updateDrinkingSession(
        DrinkingSessionWrapper(
            DrinkingSessionDb(
                date = LocalDate.of(2024, month, 10),
                beerIntake = BeerIntake(light = Beer.Light(1.0))
            )
        )
    )

    monthModel.updateDrinkingSession(
        DrinkingSessionWrapper(
            DrinkingSessionDb(
                date = LocalDate.of(2024, month, 11),
                beerIntake = BeerIntake(light = Beer.Light(1.0))
            )
        )
    )

    NonDetailedMonthLayout(
        monthModel = monthModel,
        defaultCellColor =  MaterialTheme.colorScheme.surface,
        getSessionColor = { Color.Red },
        startFromSunday = false,
    )
}

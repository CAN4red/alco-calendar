package com.example.alcocalendar.ui.calendar.monthscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.db.entities.intakes.BeerIntake
import com.example.alcocalendar.model.DrinkingSessionWrapper
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.components.DateCell
import com.example.alcocalendar.ui.calendar.components.DatesGrid
import java.time.LocalDate
import java.time.Month


@SuppressLint("NewApi")
@Composable
fun MonthGrid(
    monthModel: MonthModel,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    getSessionColor: (DrinkingSession) -> Color,
    navigateToCategoryScreen: () -> Unit,
    defaultCellColor: Color,
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
            dateCell = { session ->
                DateCell(
                    session = session,
                    onClick = {
                        onFillingSessionEvent(FillingSessionEvent.InitNewSession(session.date))
                        navigateToCategoryScreen()
                    },
                    color = if (session.isEmpty) defaultCellColor else getSessionColor(session),
                    modifier = Modifier.weight(1f)
                )
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}


@SuppressLint("NewApi")
@Preview
@Composable
fun MonthGridPreview() {
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


    MonthGrid(
        monthModel = monthModel,
        onFillingSessionEvent = {},
        navigateToCategoryScreen = {},
        getSessionColor = { Color.Red },
        defaultCellColor = Color.Transparent,
        startFromSunday = false,
        modifier = Modifier.background(color = Color.White)
    )
}
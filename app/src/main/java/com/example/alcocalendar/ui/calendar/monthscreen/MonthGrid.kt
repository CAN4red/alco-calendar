package com.example.alcocalendar.ui.calendar.monthscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.model.MonthModel
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.components.DateCell
import com.example.alcocalendar.ui.calendar.components.DatesGrid
import java.time.Month


@SuppressLint("NewApi")
@Composable
fun MonthGrid(
    monthModel: MonthModel,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateToCategoryScreen: () -> Unit,
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
                    }
                )
            },
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
        onFillingSessionEvent = {},
        navigateToCategoryScreen = {},
        startFromSunday = false,
        modifier = Modifier.background(color = Color.White)
    )
}
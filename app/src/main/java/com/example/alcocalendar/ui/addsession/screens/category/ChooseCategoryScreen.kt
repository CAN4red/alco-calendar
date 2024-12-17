package com.example.alcocalendar.ui.addsession.screens.category

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R
import com.example.alcocalendar.db.entities.DrinkingSessionDb
import com.example.alcocalendar.model.DrinkingSessionWrapper
import com.example.alcocalendar.ui.addsession.components.CategoryCard
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.calendar.viewmodel.CalendarEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChooseCategoryScreen(
    fillingSessionState: DrinkingSessionDb,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    onCalendarEvent: (CalendarEvent) -> Unit,
    onBeerClick: () -> Unit,
    onWineClick: () -> Unit,
    onSpiritsClick: () -> Unit,
    onOtherClick: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {

    val title =
        "${fillingSessionState.date.dayOfMonth} " +
                "${fillingSessionState.date.month} " +
                "${fillingSessionState.date.year}"

    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight(700),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
        ) {
            item {
                CategoryCard(
                    title = "Beer",
                    iconId = R.drawable.beer_category,
                    iconColor = Color.Black,
                    backgroundIconColor = DrinkColor.BeerLight,
                    onClick = { onBeerClick() },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            item {
                CategoryCard(
                    title = "Wine",
                    iconId = R.drawable.wine_category,
                    iconColor = Color.White,
                    backgroundIconColor = DrinkColor.WineRed,
                    onClick = { onWineClick() },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            item {
                CategoryCard(
                    title = "Spirits",
                    iconId = R.drawable.spirits_category,
                    iconColor = Color.Black,
                    backgroundIconColor = DrinkColor.SpiritsVodka,
                    onClick = { onSpiritsClick() },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            item {
                CategoryCard(
                    title = "Other",
                    iconId = R.drawable.other_category,
                    iconColor = Color.White,
                    backgroundIconColor = DrinkColor.OtherCocktails,
                    onClick = { onOtherClick() },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }

        Button(
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.ConfirmSession)
                onCalendarEvent(
                    CalendarEvent.UpdateDrinkingSession(
                        DrinkingSessionWrapper(fillingSessionState)
                    )
                )
                navigateBack()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Confirm Session")
        }

        Button(
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.DeleteSession)
                onCalendarEvent(
                    CalendarEvent.DeleteDrinkingSession(
                        DrinkingSessionWrapper(fillingSessionState)
                    )
                )
                navigateBack()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Delete Session")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
private fun ChooseCategoryScreenPreview() {
    ChooseCategoryScreen(
        fillingSessionState = DrinkingSessionDb(LocalDate.now()),
        onFillingSessionEvent = {},
        onCalendarEvent = {},
        onBeerClick = {},
        onWineClick = {},
        onSpiritsClick = {},
        onOtherClick = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
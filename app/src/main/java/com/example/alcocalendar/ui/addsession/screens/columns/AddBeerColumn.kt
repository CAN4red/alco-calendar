package com.example.alcocalendar.ui.addsession.screens.columns


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.DrinkingSession
import com.example.alcocalendar.db.entities.intakes.Beer
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.getAddDrinkButtonComposable
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor
import java.time.LocalDate

@Composable
fun AddBeerColumn(
    fillingSessionState: DrinkingSession,
    onDrinkButtonClick: (Beer) -> Unit,
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val addDrinkButtons = listOf(
        getAddDrinkButtonComposable(
            title = "Light",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.BeerLight,
            onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.light) },
        ),
        getAddDrinkButtonComposable(
            title = "Dark",
            titleColor = Color.White,
            backgroundColor = DrinkColor.BeerDark,
            onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.dark) },
        ),
        getAddDrinkButtonComposable(
            title = "Cider",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.BeerCider,
            onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.cider) },
        ),
        getAddDrinkButtonComposable(
            title = "Unfiltered",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.BeerUnfiltered,
            onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.unfiltered) },
        ),
        getAddDrinkButtonComposable(
            title = "El",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.BeerEl,
            onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.el) },
        ),
    )

    AddDrinkColumn(
        addDrinkButtons = addDrinkButtons,
        navigateBack = navigateBack,
        modifier = modifier
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
private fun AddBeerScreenPreview() {
    AddBeerColumn(
        fillingSessionState = DrinkingSession(LocalDate.now()),
        onDrinkButtonClick = {},
        onFillingSessionEvent = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}

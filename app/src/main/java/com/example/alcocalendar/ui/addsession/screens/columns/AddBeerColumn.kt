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
import com.example.alcocalendar.db.entities.intakes.Cider
import com.example.alcocalendar.db.entities.intakes.Dark
import com.example.alcocalendar.db.entities.intakes.El
import com.example.alcocalendar.db.entities.intakes.Light
import com.example.alcocalendar.db.entities.intakes.Unfiltered
import com.example.alcocalendar.ui.addsession.components.AddDrinkButton
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
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
    AddDrinkColumn(

        { buttonModifier ->
            AddDrinkButton(
                title = "Light",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerLight,
                onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.light) },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Dark",
                titleColor = Color.White,
                backgroundColor = DrinkColor.BeerDark,
                onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.dark) },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Cider",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerCider,
                onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.cider) },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Unfiltered",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerUnfiltered,
                onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.unfiltered) },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "El",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerEl,
                onClick = { onDrinkButtonClick(fillingSessionState.beerIntake.el) },
                modifier = buttonModifier
            )
        },

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

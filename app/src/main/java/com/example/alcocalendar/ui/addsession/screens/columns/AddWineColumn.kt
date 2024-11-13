package com.example.alcocalendar.ui.addsession.screens.columns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Wine
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.getAddDrinkButtonComposable
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddWineScreen(
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val addDrinkButtons = listOf(
        getAddDrinkButtonComposable(
            title = "Red",
            titleColor = Color.White,
            backgroundColor = DrinkColor.WineRed,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Wine.Red(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "White",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.WineWhite,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Wine.White(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Champagne",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.WineChampagne,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Wine.Champagne(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Rose",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.WineRose,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Wine.Rose(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Port",
            titleColor = Color.White,
            backgroundColor = DrinkColor.WinePort,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Wine.Port(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Vermouth",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.WineVermouth,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Wine.Vermouth(1.0)))
                navigateBack()
            },
        ),
    )

    AddDrinkColumn(
        addDrinkButtons = addDrinkButtons,
        navigateBack = navigateBack,
        modifier = modifier
    )
}

@Composable
@Preview
private fun AddWineScreenPreview() {
    AddWineScreen(
        onFillingSessionEvent = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}

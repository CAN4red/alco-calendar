package com.example.alcocalendar.ui.addsession.screens.columns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Champagne
import com.example.alcocalendar.db.entities.intakes.Port
import com.example.alcocalendar.db.entities.intakes.Red
import com.example.alcocalendar.db.entities.intakes.White
import com.example.alcocalendar.db.entities.intakes.Rose
import com.example.alcocalendar.db.entities.intakes.Vermouth
import com.example.alcocalendar.ui.addsession.components.AddDrinkButton
import com.example.alcocalendar.ui.addsession.components.AddDrinkScreen
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddWineScreen(
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    AddDrinkScreen(

        { buttonModifier ->
            AddDrinkButton(
                title = "Red",
                titleColor = Color.White,
                backgroundColor = DrinkColor.WineRed,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Red(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "White",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.WineWhite,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddWineDrink(White(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Champagne",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.WineChampagne,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Champagne(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Rose",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.WineRose,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Rose(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Port",
                titleColor = Color.White,
                backgroundColor = DrinkColor.WinePort,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Port(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Vermouth",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.WineVermouth,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddWineDrink(Vermouth(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },


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
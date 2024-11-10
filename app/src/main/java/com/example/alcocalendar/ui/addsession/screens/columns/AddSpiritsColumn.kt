package com.example.alcocalendar.ui.addsession.screens.columns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Absinthe
import com.example.alcocalendar.db.entities.intakes.Brandy
import com.example.alcocalendar.db.entities.intakes.Cognac
import com.example.alcocalendar.db.entities.intakes.Gin
import com.example.alcocalendar.db.entities.intakes.Liquor
import com.example.alcocalendar.db.entities.intakes.Rum
import com.example.alcocalendar.db.entities.intakes.Tequila
import com.example.alcocalendar.db.entities.intakes.Vodka
import com.example.alcocalendar.db.entities.intakes.Whiskey
import com.example.alcocalendar.ui.addsession.components.AddDrinkButton
import com.example.alcocalendar.ui.addsession.components.AddDrinkScreen
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddSpiritsScreen(
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    AddDrinkScreen(

        { buttonModifier ->
            AddDrinkButton(
                title = "Vodka",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsVodka,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Vodka(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Whiskey",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsWhiskey,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Whiskey(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Cognac",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsCognac,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Cognac(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Rum",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsRum,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Rum(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Tequila",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsTequila,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Tequila(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Gin",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsGin,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Gin(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Absinthe",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsAbsinthe,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Absinthe(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Liquor",
                titleColor = Color(0xFFFC510E),
                backgroundColor = DrinkColor.SpiritsLiquor,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Liquor(1.0)))
                    navigateBack()
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Brandy",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsBrandy,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Brandy(1.0)))
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
private fun AddSpiritsScreenPreview() {
    AddSpiritsScreen(
        onFillingSessionEvent = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}

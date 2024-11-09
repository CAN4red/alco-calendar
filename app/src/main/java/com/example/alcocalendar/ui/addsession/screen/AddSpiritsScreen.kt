package com.example.alcocalendar.ui.addsession.screen

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
import com.example.alcocalendar.ui.calendar.viewmodel.events.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddSpiritsScreen(
    onEvent: (FillingSessionEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AddDrinkScreen(

        { buttonModifier ->
            AddDrinkButton(
                title = "Vodka",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.SpiritsVodka,
                onClick = {
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Vodka(1.0)))
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
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Whiskey(1.0)))
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
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Cognac(1.0)))
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
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Rum(1.0)))
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
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Tequila(1.0)))
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
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Gin(1.0)))
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
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Absinthe(1.0)))
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
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Liquor(1.0)))
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
                    onEvent(FillingSessionEvent.AddSpiritsDrink(Brandy(1.0)))
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
        onEvent = {},
        modifier = Modifier.fillMaxSize()
    )
}

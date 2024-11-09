package com.example.alcocalendar.ui.addsession.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Cocktails
import com.example.alcocalendar.db.entities.intakes.Moonshine
import com.example.alcocalendar.db.entities.intakes.Shots
import com.example.alcocalendar.ui.addsession.components.AddDrinkButton
import com.example.alcocalendar.ui.calendar.viewmodel.events.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddOtherScreen(
    onEvent: (FillingSessionEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AddDrinkScreen(

        { buttonModifier ->
            AddDrinkButton(
                title = "Cocktails",
                titleColor = Color.White,
                backgroundColor = DrinkColor.OtherCocktails,
                onClick = {
                    onEvent(FillingSessionEvent.AddOtherDrink(Cocktails(1.0)))
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Shots",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.OtherShots,
                onClick = {
                    onEvent(FillingSessionEvent.AddOtherDrink(Shots(1.0)))
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Moonshine",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.OtherMoonshine,
                onClick = {
                    onEvent(FillingSessionEvent.AddOtherDrink(Moonshine(1.0)))
                },
                modifier = buttonModifier
            )
        },

        modifier = modifier
    )
}

@Composable
@Preview
private fun AddOtherScreenPreview() {
    AddOtherScreen(
        onEvent = {},
        modifier = Modifier.fillMaxSize()
    )
}
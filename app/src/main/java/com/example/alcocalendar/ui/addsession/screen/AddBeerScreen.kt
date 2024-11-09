package com.example.alcocalendar.ui.addsession.screen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Cider
import com.example.alcocalendar.db.entities.intakes.Dark
import com.example.alcocalendar.db.entities.intakes.El
import com.example.alcocalendar.db.entities.intakes.Light
import com.example.alcocalendar.db.entities.intakes.Unfiltered
import com.example.alcocalendar.ui.addsession.components.AddDrinkButton
import com.example.alcocalendar.ui.calendar.viewmodel.events.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddBeerScreen(
    onEvent: (FillingSessionEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AddDrinkScreen(

        { buttonModifier ->
            AddDrinkButton(
                title = "Light",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerLight,
                onClick = {
                    onEvent(FillingSessionEvent.AddBeerDrink(Light(1.0)))
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Dark",
                titleColor = Color.White,
                backgroundColor = DrinkColor.BeerDark,
                onClick = {
                    onEvent(FillingSessionEvent.AddBeerDrink(Dark(1.0)))
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Cider",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerCider,
                onClick = {
                    onEvent(FillingSessionEvent.AddBeerDrink(Cider(1.0)))
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "Unfiltered",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerUnfiltered,
                onClick = {
                    onEvent(FillingSessionEvent.AddBeerDrink(Unfiltered(1.0)))
                },
                modifier = buttonModifier
            )
        },

        { buttonModifier ->
            AddDrinkButton(
                title = "El",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerEl,
                onClick = {
                    onEvent(FillingSessionEvent.AddBeerDrink(El(1.0)))
                },
                modifier = buttonModifier
            )
        },

        modifier = modifier
    )
}

@Composable
@Preview
private fun AddBeerScreenPreview() {
    AddBeerScreen(
        onEvent = {},
        modifier = Modifier.fillMaxSize()
    )
}

package com.example.alcocalendar.ui.addsession.screens.drink


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
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddBeerScreen(
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    AddDrinkScreen(

        { buttonModifier ->
            AddDrinkButton(
                title = "Light",
                titleColor = Color.Black,
                backgroundColor = DrinkColor.BeerLight,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(Light(1.0)))
                    navigateBack()
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
                    onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(Dark(1.0)))
                    navigateBack()
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
                    onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(Cider(1.0)))
                    navigateBack()
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
                    onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(Unfiltered(1.0)))
                    navigateBack()
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
                    onFillingSessionEvent(FillingSessionEvent.AddBeerDrink(El(1.0)))
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
private fun AddBeerScreenPreview() {
    AddBeerScreen(
        onFillingSessionEvent = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}

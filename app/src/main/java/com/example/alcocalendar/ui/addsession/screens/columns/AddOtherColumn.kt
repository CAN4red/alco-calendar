package com.example.alcocalendar.ui.addsession.screens.columns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Cocktails
import com.example.alcocalendar.db.entities.intakes.Moonshine
import com.example.alcocalendar.db.entities.intakes.Shots
import com.example.alcocalendar.ui.addsession.components.AddDrinkButton
import com.example.alcocalendar.ui.addsession.components.AddDrinkScreen
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddOtherScreen(
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    AddDrinkScreen(

        { buttonModifier ->
            AddDrinkButton(
                title = "Cocktails",
                titleColor = Color.White,
                backgroundColor = DrinkColor.OtherCocktails,
                onClick = {
                    onFillingSessionEvent(FillingSessionEvent.AddOtherDrink(Cocktails(1.0)))
                    navigateBack()
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
                    onFillingSessionEvent(FillingSessionEvent.AddOtherDrink(Shots(1.0)))
                    navigateBack()
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
                    onFillingSessionEvent(FillingSessionEvent.AddOtherDrink(Moonshine(1.0)))
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
private fun AddOtherScreenPreview() {
    AddOtherScreen(
        onFillingSessionEvent = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
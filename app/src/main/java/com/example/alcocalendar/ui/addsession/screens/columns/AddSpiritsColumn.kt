package com.example.alcocalendar.ui.addsession.screens.columns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.alcocalendar.db.entities.intakes.Spirits
import com.example.alcocalendar.ui.addsession.components.AddDrinkColumn
import com.example.alcocalendar.ui.addsession.components.getAddDrinkButtonComposable
import com.example.alcocalendar.ui.addsession.viewmodel.FillingSessionEvent
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddSpiritsScreen(
    onFillingSessionEvent: (FillingSessionEvent) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val addDrinkButtons = listOf(
        getAddDrinkButtonComposable(
            title = "Vodka",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsVodka,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Vodka(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Whiskey",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsWhiskey,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Whiskey(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Cognac",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsCognac,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Cognac(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Rum",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsRum,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Rum(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Tequila",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsTequila,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Tequila(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Gin",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsGin,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Gin(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Absinthe",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsAbsinthe,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Absinthe(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Liquor",
            titleColor = Color(0xFFFC510E),
            backgroundColor = DrinkColor.SpiritsLiquor,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Liquor(1.0)))
                navigateBack()
            },
        ),
        getAddDrinkButtonComposable(
            title = "Brandy",
            titleColor = Color.Black,
            backgroundColor = DrinkColor.SpiritsBrandy,
            onClick = {
                onFillingSessionEvent(FillingSessionEvent.AddSpiritsDrink(Spirits.Brandy(1.0)))
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
private fun AddSpiritsScreenPreview() {
    AddSpiritsScreen(
        onFillingSessionEvent = {},
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}

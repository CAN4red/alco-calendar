package com.example.alcocalendar.ui.addsession.screens.drink


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.ui.addsession.components.AddDrinkButton
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddDrinkScreen(
    vararg addDrinkButtons: @Composable (Modifier) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        addDrinkButtons.forEach { button ->
            item { button(Modifier.padding(bottom = 16.dp)) }
        }
    }
}

@Composable
@Preview
private fun AddDrinkScreenPreview() {
    AddDrinkScreen(
        { modifier ->
            AddDrinkButton(
                title = "Light",
                titleColor = DrinkColor.BeerDark,
                backgroundColor = DrinkColor.BeerLight,
                onClick = {},
                modifier = modifier.fillMaxWidth()
            )
        },

        { modifier ->
            AddDrinkButton(
                title = "Light",
                titleColor = DrinkColor.BeerDark,
                backgroundColor = DrinkColor.BeerLight,
                onClick = {},
                modifier = modifier.fillMaxWidth()
            )
        },
        modifier = Modifier.fillMaxSize()
    )
}
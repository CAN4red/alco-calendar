package com.example.alcocalendar.ui.addsession.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddDrinkColumn(
    addDrinkButtons: List<@Composable (Modifier) -> Unit>,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            addDrinkButtons.forEach { button ->
                item { button(Modifier.padding(bottom = 16.dp)) }
            }
        }

        Button(onClick = { navigateBack() }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Confirm")
        }
    }
}

@Composable
@Preview
private fun AddDrinkScreenPreview() {
    AddDrinkColumn(
        listOf(
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
            }
        ),
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
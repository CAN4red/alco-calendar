package com.example.alcocalendar.ui.addsession.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddDrinkColumn(
    addDrinkButtons: List<DrinkButtonData>,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(addDrinkButtons) { buttonData ->
                AddDrinkButton(
                    title = buttonData.title,
                    titleColor = buttonData.titleColor,
                    backgroundColor = buttonData.backgroundColor,
                    onClick = buttonData.onClick,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }

        Button(
            onClick = { navigateBack() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Confirm")
        }
    }
}

@Composable
@Preview
private fun AddDrinkScreenPreview() {
    AddDrinkColumn(
        listOf(
            DrinkButtonData("Light", Color.Black, DrinkColor.BeerLight) { },
            DrinkButtonData("Dark", Color.White, DrinkColor.BeerDark) { },
            DrinkButtonData("Cider", Color.Black, DrinkColor.BeerCider) { },
        ),
        navigateBack = {},
        modifier = Modifier.fillMaxSize()
    )
}
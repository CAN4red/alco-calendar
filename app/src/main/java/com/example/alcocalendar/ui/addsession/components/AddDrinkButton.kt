package com.example.alcocalendar.ui.addsession.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun AddDrinkButton(
    title: String,
    titleColor: Color,
    backgroundColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(3f)
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = backgroundColor)
            .clickable { onClick() }
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight(700),
            color = titleColor,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}

data class DrinkButtonData(
    val title: String,
    val titleColor: Color,
    val backgroundColor: Color,
    val onClick: () -> Unit
)

@Composable
@Preview
private fun AddDrinkButtonPreview() {
    AddDrinkButton(
        title = "Light",
        titleColor = DrinkColor.BeerDark,
        backgroundColor = DrinkColor.BeerLight,
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}

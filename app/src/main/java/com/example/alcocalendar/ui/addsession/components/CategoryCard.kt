package com.example.alcocalendar.ui.addsession.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R
import com.example.alcocalendar.ui.theme.color.DrinkColor

@Composable
fun CategoryCard(
    title: String,
    @DrawableRes iconId: Int,
    iconColor: Color,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(3f)
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
        ) {
            CategoryIcon(
                title = title,
                iconId = iconId,
                iconColor = iconColor,
                color = color
            )
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight(700),
            )
        }
    }
}

@Composable
private fun CategoryIcon(
    title: String,
    @DrawableRes iconId: Int,
    iconColor: Color,
    color: Color,
) {
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .size(100.dp)
            .padding(end = 10.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = color)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = iconId),
            contentDescription = "${title}_category",
            tint = iconColor,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
@Preview
private fun CategoryButtonPreview() {
    CategoryCard(
        title = "Beer",
        iconId = R.drawable.beer_category,
        iconColor = DrinkColor.BeerDark,
        color = DrinkColor.BeerLight,
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}
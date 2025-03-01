package com.example.alcocalendar.features.drink_intake.presentation.components.drink_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.core.data.local.entities.drink_types.WineType
import com.example.alcocalendar.core.domain.model.DrinkType
import com.example.alcocalendar.features.drink_intake.presentation.utils.DrinkTypeToDrawableMapper.toDrawable
import com.example.alcocalendar.features.drink_intake.presentation.utils.DrinkTypeToStringMapper.typeName

@Composable
fun DrinkCard(
    drinkType: DrinkType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Image(
                painter = painterResource(drinkType.toDrawable()),
                contentDescription = stringResource(R.string.drink_type_image),
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(6.dp))
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(
                text = stringResource(drinkType.typeName()),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}

@Preview
@Composable
private fun DrinkCardPreview() {
    DrinkCard(
        drinkType = BeerType.LIGHT,
        onClick = {},
    )
}

@Preview
@Composable
private fun DrinkCardPreview2() {
    DrinkCard(
        drinkType = WineType.RED,
        onClick = {},
    )
}

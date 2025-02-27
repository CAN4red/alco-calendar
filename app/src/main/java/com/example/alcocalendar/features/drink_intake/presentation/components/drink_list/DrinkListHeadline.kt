package com.example.alcocalendar.features.drink_intake.presentation.components.drink_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alcocalendar.R
import com.example.alcocalendar.core.data.local.entities.drink_types.BeerType
import com.example.alcocalendar.features.drink_intake.presentation.utils.DrinkTypeToStringMapper.headlineName

@Composable
fun DrinkListHeadline(
    headline: String,
    onClick: () -> Unit,
    isListExpanded: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Text(
            text = headline,
            style = MaterialTheme.typography.headlineMedium
        )
        Icon(
            imageVector = getIcon(isListExpanded),
            contentDescription = stringResource(R.string.expand_icon),
            modifier = Modifier.size(28.dp)
        )
    }
}

private fun getIcon(isListExpanded: Boolean): ImageVector {
    return if (isListExpanded) {
        Icons.Default.KeyboardArrowUp
    } else {
        Icons.Default.KeyboardArrowDown
    }
}


@Preview
@Composable
private fun DrinkListHeadlinePreview() {
    DrinkListHeadline(
        headline = headlineName<BeerType>(),
        onClick = { },
        isListExpanded = false
    )
}